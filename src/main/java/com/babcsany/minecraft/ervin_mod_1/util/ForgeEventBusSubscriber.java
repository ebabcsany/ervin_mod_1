package com.babcsany.minecraft.ervin_mod_1.util;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.DimensionInit;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

/*@Mod.EventBusSubscriber(modid = Ervin_mod_1.MOD_ID, bus = Bus.FORGE)
public class ForgeEventBusSubscriber {

	@SubscribeEvent
	public static void registerDimensions(final RegisterDimensionsEvent event) {
		if (DimensionType.byName(Ervin_mod_1.EXAMPLE_DIM_TYPE) == null) {
			DimensionManager.registerDimension(Ervin_mod_1.EXAMPLE_DIM_TYPE, DimensionInit.EXAMPLE_DIM.get(), null,
					true);
		}
		Ervin_mod_1.LOGGER.info("Dimensions Registered!");
	}
}*/
