package com.codeisnotevil.minerslove.init;

import com.codeisnotevil.minerslove.MinersLove;

import com.codeisnotevil.minerslove.objects.blocks.EnderOreBlock;
import com.codeisnotevil.minerslove.objects.blocks.FireWheatCrop;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS,
            MinersLove.MOD_ID);

    //Normal Blocks ----------------------------------------------------------------------------------------------------
    public static final RegistryObject<Block> FIRE_GRASS_BLOCK = BLOCKS.register("fire_grass_block",
            () -> new Block(Block.Properties.create(Material.ORGANIC)
                    .hardnessAndResistance(0.5f, 15.0f).sound(SoundType.WET_GRASS)));

    public static final RegistryObject<Block> ENDER_ORE_BLOCK = BLOCKS.register("ender_ore_block", EnderOreBlock::new);

    //Crops Blocks -----------------------------------------------------------------------------------------------------
    public static final RegistryObject<Block> FIRE_WHEAT_BLOCK = BLOCKS.register("fire_wheat_block",
            () -> new FireWheatCrop(Block.Properties.from(Blocks.WHEAT)));

}