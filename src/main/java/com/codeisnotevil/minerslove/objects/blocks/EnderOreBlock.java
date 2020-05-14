package com.codeisnotevil.minerslove.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;


public class EnderOreBlock extends Block{

    public EnderOreBlock() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(15.0f,20.0f)
                .sound(SoundType.METAL)
                .harvestLevel(3) //Diamond
                .harvestTool(ToolType.PICKAXE)
        );
    }

}
