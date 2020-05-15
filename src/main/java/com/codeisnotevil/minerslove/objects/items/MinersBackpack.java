package com.codeisnotevil.minerslove.objects.items;

import com.codeisnotevil.minerslove.MinersLoveItemGroup;
import com.codeisnotevil.minerslove.init.ModContainerTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class MinersBackpack extends Item {

    public MinersBackpack() {
        super(new Properties().group(MinersLoveItemGroup.instance));
    }

    public MinersBackpack(Properties properties) {
        super(properties.group(MinersLoveItemGroup.instance));
    }

    public boolean hasTileEntity(BlockState state){
        return true;
    }

    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if(!worldIn.isRemote){
            //NetworkHooks.openGui((ServerPlayerEntity)playerIn, (INamedContainerProvider) ModContainerTypes.MINERS_BACKPACK_CONTAINER.get());
       /*     NetworkHooks.openGui((ServerPlayerEntity) playerIn, new INamedContainerProvider() {
                @Override
                public ITextComponent getDisplayName() {
                    return null;
                }

                @Nullable
                @Override
                public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
                    return ModContainerTypes.MINERS_BACKPACK_CONTAINER.get().create(p_createMenu_1_, p_createMenu_2_);
                    //TODO return value can be wrong
                }
            });*/
        }

        return ActionResult.resultFail(new ItemStack(this));
    }

}
