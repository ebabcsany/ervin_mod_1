package com.babcsany.minecraft.ervin_mod_1.init.container;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.container.CraintBlockCraftingTableContainer;
import com.babcsany.minecraft.ervin_mod_1.container.IrtrewContainer;
import com.babcsany.minecraft.ervin_mod_1.container.LeatBlockCraftingTableContainer;
import com.babcsany.minecraft.ervin_mod_1.container.furnace.BlackFurnaceContainer;
import com.babcsany.minecraft.ervin_mod_1.container.merchant.ZurContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FurnaceContainerInit {

    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<ContainerType<BlackFurnaceContainer>> BLACK_FURNACE = CONTAINER_TYPES.register("black_furnace", () -> IForgeContainerType.create(BlackFurnaceContainer::new));
    //public static final RegistryObject<ContainerType<BlackFurnaceContainer>> BLUE_FURNACE = CONTAINER_TYPES.register("blue_furnace", () -> IForgeContainerType.create(BlackFurnaceContainer::new));
}
