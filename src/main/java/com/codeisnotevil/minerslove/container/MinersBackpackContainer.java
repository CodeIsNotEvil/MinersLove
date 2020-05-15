package com.codeisnotevil.minerslove.container;

import com.codeisnotevil.minerslove.init.ModContainerTypes;
import com.codeisnotevil.minerslove.tileentities.MinersBackpackTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

import java.util.Objects;

public class MinersBackpackContainer extends Container {

    private static final int NUMBER_OF_ROWS = 5, NUMBER_OF_COLUMNS = 9, SLOT_SIZE_PLUS_2 = 18;
    public static int size = NUMBER_OF_ROWS * NUMBER_OF_COLUMNS;
    public final MinersBackpackTileEntity tileEntity;
    private final IWorldPosCallable canInteractWithCallable;

    public MinersBackpackContainer(final int windowId, final PlayerInventory playerInventory,
                                   final MinersBackpackTileEntity tileEntity) {
        super(ModContainerTypes.MINERS_BACKPACK_CONTAINER.get(), windowId);
        this.tileEntity = tileEntity;
        this.canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(),tileEntity.getPos());

        //Main Inventory
        int startX = 9, startY = 18;

        for (int row = 0; row < NUMBER_OF_ROWS; row++) {
            for (int column = 0; column < NUMBER_OF_COLUMNS; column++) {
                this.addSlot(new Slot(tileEntity,
                        (row * NUMBER_OF_COLUMNS) + column,
                        startX + (column * SLOT_SIZE_PLUS_2),
                        startY + (row * SLOT_SIZE_PLUS_2)));
            }
        }

        //Main Player Inventory
        int spaceBetweenInv = 4;
        int startPlayerInY = startY + (NUMBER_OF_ROWS * SLOT_SIZE_PLUS_2) + spaceBetweenInv; //112

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                this.addSlot(new Slot(playerInventory,
                        9 + (row * 9) + column,
                        startX + (column * SLOT_SIZE_PLUS_2),
                        startPlayerInY + (row * SLOT_SIZE_PLUS_2)));
            }
        }

        //Hotbar Inventory
        int hotbarY = startPlayerInY + (3 * SLOT_SIZE_PLUS_2) + spaceBetweenInv; //170

        for (int column = 0; column < 9; column++) {
            this.addSlot(new Slot(playerInventory, column, startX, hotbarY));
        }

    }

    public static MinersBackpackTileEntity getTileEntity(final PlayerInventory playerInventory,
                                                         final PacketBuffer data) {
        Objects.requireNonNull(playerInventory, "playerInventory cannot be null");
        Objects.requireNonNull(data, "data cannot be null");

        final TileEntity tileAtPos = playerInventory.player.world.getTileEntity(data.readBlockPos());
        if (tileAtPos instanceof MinersBackpackTileEntity){
            return (MinersBackpackTileEntity)tileAtPos;
        }

        throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
    }

    public MinersBackpackContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {
        this(windowId, playerInventory, getTileEntity(playerInventory, data));
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return true;
        //return isWithinUsableDistance(canInteractWithCallable, playerIn, BlockInit.EXAMPLE_BLOCK.get());
    }

    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if(slot != null && slot.getHasStack()){
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();
            if (index < size){
                if(!this.mergeItemStack(itemStack1, size, this.inventorySlots.size(),true)){
                    return ItemStack.EMPTY;
                }
            }else if (!this.mergeItemStack(itemStack1, 0, size, false)){
                return ItemStack.EMPTY;
            }
            if (itemStack1.isEmpty()){
                slot.putStack(ItemStack.EMPTY);
            }else {
                slot.onSlotChange(itemStack, itemStack1);
            }
        }
        return itemStack;
    }
}
