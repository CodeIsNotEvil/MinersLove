package com.codeisnotevil.minerslove.init;

import com.codeisnotevil.minerslove.MinersLove;
import com.codeisnotevil.minerslove.tileentities.UpgradedChestTileEntity;
import com.mojang.datafixers.DataFixer;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES =
            new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, MinersLove.MOD_ID);

    //Example
    /*
    public static final RegistryObject<TileEntityType<ExampleTileEntity>> EXAMPLE = TILE_ENTITY_TYPES
            .register("example_tile_entity", () -> TileEntityType.Builder.create(ExampleTileEntity::new,
                    BlockInit.EXAMPLE_BLOCK.get()).build(null));
    */
    //TileEntities


    //Container --------------------------------------------------------------------------------------------------------
/*    public static final RegistryObject<TileEntityType<MinersBackpackTileEntity>> MINERS_BACKPACK_CONTAINER =
            TILE_ENTITY_TYPES.register("miners_backpack_container", () -> TileEntityType.Builder.create(
                    MinersBackpackTileEntity::new, ItemInit.MINERS_BACKPACK.get()).build(null));*/

    public static final RegistryObject<TileEntityType<UpgradedChestTileEntity>> UPGRADED_CHEST_TILE_ENTITY =
            TILE_ENTITY_TYPES.register("upgraded_chest_tile_entity", () -> TileEntityType.Builder.create(
                    UpgradedChestTileEntity::new, BlockInit.UPGRADED_CHEST_BLOCK.get()).build(null));
}
