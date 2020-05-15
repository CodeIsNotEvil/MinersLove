package com.codeisnotevil.minerslove.events;

import com.codeisnotevil.minerslove.MinersLove;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = MinersLove.MOD_ID, bus = Bus.FORGE)
public class TestJumpEvent {
/*
    @SubscribeEvent
    public static void testJumpEvent(LivingEvent.LivingJumpEvent event){
        MinersLove.LOGGER.info("testJumpEventFired");
        //LivingEntity livingEntity = event.getEntityLiving();
        //World world = livingEntity.getEntityWorld();
        //livingEntity.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 20,3));
        //livingEntity.addPotionEffect(new EffectInstance(Effects.RESISTANCE,200,3));
        //livingEntity.setGlowing(true);
    }

 */
}
