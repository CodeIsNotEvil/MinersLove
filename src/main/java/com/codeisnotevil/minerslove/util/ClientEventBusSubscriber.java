package com.codeisnotevil.minerslove.util;

import com.codeisnotevil.minerslove.MinersLove;
import com.codeisnotevil.minerslove.client.gui.UpgradedChestScreen;
import com.codeisnotevil.minerslove.init.BlockInit;
import com.codeisnotevil.minerslove.init.ModContainerTypes;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = MinersLove.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event){
        ScreenManager.registerFactory(ModContainerTypes.UPGRADED_CHEST_CONTAINER.get(), UpgradedChestScreen::new);
        RenderTypeLookup.setRenderLayer(BlockInit.FIRE_GRASS_BLOCK.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInit.FIRE_WHEAT_BLOCK.get(), RenderType.getCutout());
    }
}
