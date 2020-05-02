package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.container.LeatBlockCraftingTableContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerInit {

    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(ForgeRegistries.CONTAINERS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<ContainerType<LeatBlockCraftingTableContainer>> LEAT_BLOCK_CRAFTING_TABLE = CONTAINER_TYPES
            .register("leat_block_crafting_table", () -> IForgeContainerType.create(LeatBlockCraftingTableContainer::new));
}
