package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.tile_entity.ReutrienTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityInit {

	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(
			ForgeRegistries.TILE_ENTITIES, Ervin_mod_1.MOD_ID);

	public static final RegistryObject<TileEntityType<ReutrienTileEntity>> REUTRIEN = TILE_ENTITY_TYPES
			.register("reutrien", () -> TileEntityType.Builder
					.create(ReutrienTileEntity::new, BlockItemInit.REUTRIEN.get()).build(null));


}
