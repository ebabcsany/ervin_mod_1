package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes.world.spawn;

import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.fml.RegistryObject;

import javax.annotation.Nullable;
import java.util.Random;

public class EntitySpawnPlacementRegistry extends net.minecraft.entity.EntitySpawnPlacementRegistry {

   public EntitySpawnPlacementRegistry ENTITY_SPAWN_PLACEMENT_REGISTRY;

   public EntitySpawnPlacementRegistry() {
      ENTITY_SPAWN_PLACEMENT_REGISTRY = new EntitySpawnPlacementRegistry();
      entitySpawnPlacementRegistry(ENTITY_SPAWN_PLACEMENT_REGISTRY);
      System.out.println(getHeightmapType(EntityInit.SRECH_ENTITY));
   }

   @SuppressWarnings("UnusedDeclaration")
   public static void entitySpawnPlacementRegistry(EntitySpawnPlacementRegistry Class) {

   }

   public static <T extends MobEntity> void register(EntityType<T> entityTypeIn, net.minecraft.entity.EntitySpawnPlacementRegistry.PlacementType placementType, net.minecraft.world.gen.Heightmap.Type heightMapType, net.minecraft.entity.EntitySpawnPlacementRegistry.IPlacementPredicate<T> placementPredicate) {
      net.minecraft.entity.EntitySpawnPlacementRegistry.register(entityTypeIn, placementType, heightMapType, placementPredicate);
   }

   public static <T extends MobEntity> void registerOnGround(EntityType<T> entityTypeIn, net.minecraft.world.gen.Heightmap.Type heightMapType, net.minecraft.entity.EntitySpawnPlacementRegistry.IPlacementPredicate<T> placementPredicate) {
      register(entityTypeIn, PlacementType.ON_GROUND, heightMapType, placementPredicate);
   }

   public static <T extends MobEntity> void registerNoRestrictions(EntityType<T> entityTypeIn, net.minecraft.world.gen.Heightmap.Type heightMapType, net.minecraft.entity.EntitySpawnPlacementRegistry.IPlacementPredicate<T> placementPredicate) {
      register(entityTypeIn, PlacementType.NO_RESTRICTIONS, heightMapType, placementPredicate);
   }

   public static <T extends MobEntity> void registerOnGroundNoLeaves(EntityType<T> entityTypeIn, net.minecraft.entity.EntitySpawnPlacementRegistry.IPlacementPredicate<T> placementPredicate) {
      registerOnGround(entityTypeIn, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, placementPredicate);
   }

   public static <T extends MobEntity> void registerNoRestrictionsNoLeaves(EntityType<T> entityTypeIn, net.minecraft.entity.EntitySpawnPlacementRegistry.IPlacementPredicate<T> placementPredicate) {
      registerNoRestrictions(entityTypeIn, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, placementPredicate);
   }

   public static Heightmap.Type getHeightmapType(@Nullable EntityType<?> entityTypeIn) {
      return func_209342_b(entityTypeIn);
   }

   public static <T extends MobEntity> void register(RegistryObject<EntityType<T>> entityTypeIn, net.minecraft.entity.EntitySpawnPlacementRegistry.PlacementType placementType, net.minecraft.world.gen.Heightmap.Type heightMapType, IPlacementPredicate<T> placementPredicate) {
      register(entityTypeIn.get(), placementType, heightMapType, placementPredicate);
   }

   @FunctionalInterface
   public interface IPlacementPredicate<T extends Entity> extends net.minecraft.entity.EntitySpawnPlacementRegistry.IPlacementPredicate<T> {
      boolean test(EntityType<T> p_test_1_, IServerWorld p_test_2_, SpawnReason p_test_3_, BlockPos p_test_4_, Random p_test_5_);
   }
}
