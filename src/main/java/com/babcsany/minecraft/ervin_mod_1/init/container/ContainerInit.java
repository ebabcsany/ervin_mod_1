package com.babcsany.minecraft.ervin_mod_1.init.container;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.container.CraintBlockCraftingTableContainer;
import com.babcsany.minecraft.ervin_mod_1.container.IrtrewContainer;
import com.babcsany.minecraft.ervin_mod_1.container.LeatBlockCraftingTableContainer;
import com.babcsany.minecraft.ervin_mod_1.container.furnace.BlackFurnaceContainer;
import com.babcsany.minecraft.ervin_mod_1.container.merchant.ZurContainer;
import com.babcsany.minecraft.ervin_mod_1.container.trader.TraderBlockContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerInit {

    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<ContainerType<CraintBlockCraftingTableContainer>> CRAINT_BLOCK_CRAFTING_TABLE = CONTAINER_TYPES.register("craint_block_crafting_table", () -> IForgeContainerType.create(CraintBlockCraftingTableContainer::new));
    public static final RegistryObject<ContainerType<LeatBlockCraftingTableContainer>> LEAT_BLOCK_CRAFTING_TABLE = CONTAINER_TYPES.register("leat_block_crafting_table", () -> IForgeContainerType.create(LeatBlockCraftingTableContainer::new));
    public static final RegistryObject<ContainerType<IrtrewContainer>> IRTREW = CONTAINER_TYPES.register("irtrew", () -> IForgeContainerType.create(IrtrewContainer::new));
    public static final RegistryObject<ContainerType<ZurContainer>> ZUR = CONTAINER_TYPES.register("zur", () -> IForgeContainerType.create(ZurContainer::new));
    public static final RegistryObject<ContainerType<TraderBlockContainer>> TRADER_BLOCK = CONTAINER_TYPES.register("trader_block", () -> IForgeContainerType.create(TraderBlockContainer::new));
}
