package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.tile_entity.ReutrienTileEntity;
import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.types.Type;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.CommandBlockFriszernTileEntity;
import net.minecraft.tileentity.CommandBlockTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Util;
import net.minecraft.util.datafix.TypeReferences;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;
import java.util.function.Supplier;

public class TileEntityInit<T extends TileEntity> {

	private static final Logger LOGGER = LogManager.getLogger();
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Ervin_mod_1.MOD_ID);

	public static final RegistryObject<TileEntityType<ReutrienTileEntity>> REUTRIEN = TILE_ENTITY_TYPES.register("reutrien", () -> TileEntityType.Builder.create(ReutrienTileEntity::new, BlockItemInit.REUTRIEN.get()).build(null));
	public static final TileEntityType<CommandBlockFriszernTileEntity> FRISZERN = register("ervin_mod_1:friszern", Builder.create(CommandBlockFriszernTileEntity::new, BlockInit.FRISZERN, BlockInit.CHAIN_FRISZERN, BlockInit.REPEATING_FRISZERN));
	public static final TileEntityType<CommandBlockTileEntity> COMMAND_BLOCK = register("ervin_mod_1:command_block", Builder.create(CommandBlockTileEntity::new, Blocks.COMMAND_BLOCK, Blocks.CHAIN_COMMAND_BLOCK, Blocks.REPEATING_COMMAND_BLOCK, BlockInit.FRISZERN, BlockInit.CHAIN_FRISZERN, BlockInit.REPEATING_FRISZERN));

	//public static final TileEntityType<?> BLACK_FURNACE = TILE_ENTITY_TYPES.register("black_furnace", () -> TileEntityType.Builder.create(BlackFurnaceTileEntity::new, BlockItemInit.BLACK_FURNACE.get()).build(null));
	//public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES;

	@OnlyIn(Dist.CLIENT)
	public static void registerTileRenders() {
		//ClientRegistry.bindTileEntityRenderer((TileEntityType)FRISZERN.get(), EndTrollBoxTileEntityRenderer::new);
	}

	private static <T extends TileEntity> TileEntityType<T> register(String key, Builder<T> builder) {
		if (builder.blocks.isEmpty()) {
			LOGGER.warn("Block entity type {} requires at least one valid block to be defined!", key);
		}

		Type<?> type = Util.attemptDataFix(TypeReferences.BLOCK_ENTITY, key);
		return Registry.register(Registry.BLOCK_ENTITY_TYPE, key, builder.build(type));
	}

	public static final class Builder<T extends TileEntity> {
		private final Supplier<? extends T> factory;
		private final Set<Block> blocks;

		private Builder(Supplier<? extends T> factoryIn, Set<Block> validBlocks) {
			this.factory = factoryIn;
			this.blocks = validBlocks;
		}

		public static <T extends TileEntity> Builder<T> create(Supplier<? extends T> factoryIn, Block... validBlocks) {
			return new Builder<>(factoryIn, ImmutableSet.copyOf(validBlocks));
		}

		public TileEntityType<T> build(Type<?> datafixerType) {
			return new TileEntityType<>(this.factory, this.blocks, datafixerType);
		}
	}

	/*static {
		TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, "ervin_mod_1");
		FRISZERN = TILE_ENTITY_TYPES.register("friszern", () -> new TileEntityType(FriszernTileEntity::new, Sets.newHashSet(new Block[]{BlockInit.FRISZERN.get(), BlockInit.CHAIN_FRISZERN.get(), BlockInit.REPEATER_FRISZERN.get()}), null));
	}*/

}
