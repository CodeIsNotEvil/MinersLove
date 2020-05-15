package com.codeisnotevil.minerslove.init;

import com.codeisnotevil.minerslove.MinersLove;
import com.codeisnotevil.minerslove.container.MinersBackpackContainer;
import com.codeisnotevil.minerslove.container.UpgradedChestContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerTypes {

    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES =
            new DeferredRegister<>(ForgeRegistries.CONTAINERS, MinersLove.MOD_ID);

    public static final RegistryObject<ContainerType<MinersBackpackContainer>> MINERS_BACKPACK_CONTAINER =
            CONTAINER_TYPES.register("miners_backpack_container",
                    () -> IForgeContainerType.create(MinersBackpackContainer::new));

    public static final RegistryObject<ContainerType<UpgradedChestContainer>> UPGRADED_CHEST_CONTAINER =
            CONTAINER_TYPES.register("upgraded_chest_container",
                    () -> IForgeContainerType.create(UpgradedChestContainer::new));

}
