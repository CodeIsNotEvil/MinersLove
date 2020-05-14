package com.codeisnotevil.minerslove;

import com.codeisnotevil.minerslove.init.BlockInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class MinersLoveItemGroup extends ItemGroup {

    public static final MinersLoveItemGroup instance = new MinersLoveItemGroup(ItemGroup.GROUPS.length, "Miners Love");

    private MinersLoveItemGroup(int index, String label){
        super(index, label);
    }

    @Override
    public ItemStack createIcon(){
        return new ItemStack(BlockInit.ENDER_ORE_BLOCK.get());
    }

}
