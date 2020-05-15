package com.codeisnotevil.minerslove.tileentities;

import com.codeisnotevil.minerslove.container.MinersBackpackContainer;
import com.codeisnotevil.minerslove.init.ModTileEntityTypes;
import com.codeisnotevil.minerslove.objects.items.MinersBackpack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemHandlerHelper;

import javax.annotation.Nonnull;

public class MinersBackpackTileEntity extends LockableLootTileEntity {

    private NonNullList<ItemStack> backpackContents = NonNullList.withSize(MinersBackpackContainer.size, ItemStack.EMPTY);
    protected int numPlayerUsing;
    private IItemHandlerModifiable items = null;//createHandler(); //TODO
    private LazyOptional<IItemHandlerModifiable> itemHandler = LazyOptional.of(() -> items);
/*
    public MinersBackpackTileEntity() {
        this(ModTileEntityTypes.MINERS_BACKPACK_CONTAINER.get());
    }
*/
    public MinersBackpackTileEntity(TileEntityType<?> typeIn) {
        super(typeIn);
    }
/*
    public MinersBackpackTileEntity() {
        super();

    }
*/
    @Override
    public int getSizeInventory() {
        return backpackContents.size();
    }

    @Nonnull
    @Override
    public NonNullList<ItemStack> getItems() {
        return this.backpackContents;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> itemsIn) {
        this.backpackContents = itemsIn;
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.miners_backpack");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new MinersBackpackContainer(id, player, this);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        if(!this.checkLootAndWrite(compound)){
            ItemStackHelper.saveAllItems(compound, this.backpackContents);
        }
        return compound;
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        this.backpackContents = NonNullList.withSize(this.getSizeInventory(),ItemStack.EMPTY);
        if(!this.checkLootAndRead(compound)){
            ItemStackHelper.loadAllItems(compound, this.backpackContents);
        }
    }

    private void playSound(SoundEvent sound){
        double dx = (double)this.pos.getX() + 0.5d;
        double dy = (double)this.pos.getY() + 0.5d;
        double dz = (double)this.pos.getZ() + 0.5d;
        this.world.playSound((PlayerEntity)null, dx, dy, dz, sound, SoundCategory.BLOCKS, 0.5f,
                this.world.rand.nextFloat() * 0.1f + 0.9f);
    }

    @Override
    public boolean receiveClientEvent(int id, int type) {
        if(id == 1){
            this.numPlayerUsing = type;
            return true;
        }
        return super.receiveClientEvent(id, type);
    }

}
