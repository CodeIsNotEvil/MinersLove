package com.codeisnotevil.minerslove.world.gen;

import com.codeisnotevil.minerslove.init.BlockInit;
import com.codeisnotevil.minerslove.objects.blocks.EnderOreBlock;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGen {

    public static void generateOre(){
        for (Biome biome : ForgeRegistries.BIOMES){

            ConfiguredPlacement customConfig = Placement.COUNT_RANGE.configure(
                    new CountRangeConfig(5, 3, 5, 14));

            //EnderOre
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(
                    new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                            BlockInit.ENDER_ORE_BLOCK.get().getDefaultState(), 3)));
            //nextOre

        }
    }
}
