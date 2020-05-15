package com.codeisnotevil.minerslove.init;

import com.codeisnotevil.minerslove.MinersLove;
import com.codeisnotevil.minerslove.objects.blocks.BlockItemBase;
import com.codeisnotevil.minerslove.objects.items.ItemBase;
import com.codeisnotevil.minerslove.objects.items.MinersBackpack;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MinersLove.MOD_ID);

    //Test Items -------------------------------------------------------------------------------------------------------
    //public static final RegistryObject<Item> DEF_ITEM = ITEMS.register("def_item", ItemBase::new);
    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item", ItemBase::new);

    //Normal Items -----------------------------------------------------------------------------------------------------
    public static final RegistryObject<Item> MINERS_BACKPACK = ITEMS.register("miners_backpack",
            MinersBackpack::new);

    //Crop Items/Seeds -------------------------------------------------------------------------------------------------
    public static final  RegistryObject<Item> FIRE_WHEAT_SEED = ITEMS.register( "fire_wheat_seed",
            () -> new BlockItemBase(BlockInit.FIRE_WHEAT_BLOCK.get()));

    //Block Items ------------------------------------------------------------------------------------------------------
    public static final RegistryObject<Item> FIRE_GRASS_BLOCK_ITEM = ITEMS.register("fire_grass_block",
            () -> new BlockItemBase(BlockInit.FIRE_GRASS_BLOCK.get()));

    public static final RegistryObject<Item> ENDER_ORE_BLOCK_ITEM = ITEMS.register("ender_ore_block",
            () -> new BlockItemBase(BlockInit.ENDER_ORE_BLOCK.get()));

    public static final RegistryObject<Item> UPGRADED_CHEST_BLOCK_ITEM = ITEMS.register("upgraded_chest_block",
            () -> new BlockItemBase(BlockInit.UPGRADED_CHEST_BLOCK.get()));

}
