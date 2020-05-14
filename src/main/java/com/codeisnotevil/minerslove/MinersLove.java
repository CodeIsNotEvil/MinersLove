package com.codeisnotevil.minerslove;

import com.codeisnotevil.minerslove.init.BlockInit;
import com.codeisnotevil.minerslove.init.ItemInit;
import com.codeisnotevil.minerslove.objects.blocks.FireWheatCrop;
import com.codeisnotevil.minerslove.world.gen.OreGen;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("minerslove")
@Mod.EventBusSubscriber(modid = MinersLove.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MinersLove
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "minerslove";
    public static MinersLove instance;


    public MinersLove() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);

        //init RegistryHandlers
        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        //ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);

        instance = this;

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
/*
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event){
        final IForgeRegistry<Item> registry = event.getRegistry();

        BlockInit.BLOCKS.getEntries().stream()
                .filter(block -> !(block.get() instanceof
                        FireWheatCrop))
                .map(RegistryObject::get).forEach(block -> {
                    final Item.Properties properties = new Item.Properties().group(MinersLoveItemGroup.instance);
                    final BlockItem blockItem = new BlockItem(block, properties);
                    blockItem.setRegistryName(block.getRegistryName());
                    registry.register(blockItem);
        });
        //Block block = BlockInit.DEF_BLOCK.get();
        //Item item = ItemInit.DEF_ITEM.get();
        //TileEntityType tileEntityType = ModTileEntityTypes.QUARRY.get();

        LOGGER.debug("Registered BlockItems!");
    }
*/
    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event){
        OreGen.generateOre();
    }

}

