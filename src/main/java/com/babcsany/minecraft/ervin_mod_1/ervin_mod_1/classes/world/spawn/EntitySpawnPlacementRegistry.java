package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes.world.spawn;

import net.minecraft.world.gen.Heightmap;
import com.google.common.collect.Maps;
import net.minecraft.entity.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IWorld;
import net.minecraftforge.fml.RegistryObject;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Random;

public class EntitySpawnPlacementRegistry extends net.minecraft.entity.EntitySpawnPlacementRegistry {

   public EntitySpawnPlacementRegistry ENTITY_SPAWN_PLACEMENT_REGISTRY;

   public EntitySpawnPlacementRegistry() {
      entitySpawnPlacementRegistry(ENTITY_SPAWN_PLACEMENT_REGISTRY);
   }

   public static void entitySpawnPlacementRegistry(EntitySpawnPlacementRegistry Class) {

   }

   public static final Map<EntityType<?>, Entry> REGISTRY = Maps.newHashMap();

   public static <T extends MobEntity> void registerl_(EntityType<T> entityTypeIn, PlacementType placementType, Heightmap.Type heightMapType, IPlacementPredicate<T> placementPredicate) {
      //net.minecraft.entity.EntitySpawnPlacementRegistry.register(entityTypeIn, placementType, heightMapType, placementPredicate);
   }

   public static <T extends MobEntity> void register(EntityType<T> entityTypeIn, net.minecraft.entity.EntitySpawnPlacementRegistry.PlacementType placementType, net.minecraft.world.gen.Heightmap.Type heightMapType, net.minecraft.entity.EntitySpawnPlacementRegistry.IPlacementPredicate<T> placementPredicate) {
      net.minecraft.entity.EntitySpawnPlacementRegistry.register(entityTypeIn, placementType, heightMapType, placementPredicate);
   }

   public static <T extends Entity> void register1(EntityType<T> entityTypeIn, PlacementType placementType, Heightmap.Type heightMapType, IPlacementPredicate<T> placementPredicate) {
      Entry entityspawnplacementregistry$entry = REGISTRY.put(entityTypeIn, new Entry(heightMapType, placementType, placementPredicate));
      if (entityspawnplacementregistry$entry != null) {
         throw new IllegalStateException("Duplicate registration for type " + Registry.ENTITY_TYPE.getKey(entityTypeIn));
      }
   }

   public static PlacementType getPlacementType(EntityType<?> entityTypeIn) {
      Entry entityspawnplacementregistry$entry = REGISTRY.get(entityTypeIn);
      return entityspawnplacementregistry$entry == null ? PlacementType.NO_RESTRICTIONS : entityspawnplacementregistry$entry.placementType;
   }

   public static Heightmap.Type getHeightmapType(@Nullable EntityType<?> entityTypeIn) {
      Entry entityspawnplacementregistry$entry = REGISTRY.get(entityTypeIn);
      return entityspawnplacementregistry$entry == null ? Heightmap.Type.MOTION_BLOCKING_NO_LEAVES : entityspawnplacementregistry$entry.type;
   }

   public static <T extends Entity> boolean canSpawnEntity(EntityType<T> entityType, IWorld world, SpawnReason reason, BlockPos pos, Random rand) {
      Entry entityspawnplacementregistry$entry = REGISTRY.get(entityType);
      return entityspawnplacementregistry$entry == null || entityspawnplacementregistry$entry.placementPredicate.test((EntityType) entityType, world, reason, pos, rand);
   }

   public static <T extends MobEntity> void register(RegistryObject<EntityType<T>> entityTypeIn, net.minecraft.entity.EntitySpawnPlacementRegistry.PlacementType placementType, net.minecraft.world.gen.Heightmap.Type heightMapType, IPlacementPredicate<T> placementPredicate) {
      register(entityTypeIn.get(), placementType, heightMapType, placementPredicate);
   }

   public static class Entry {
      private final Heightmap.Type type;
      private final PlacementType placementType;
      private final IPlacementPredicate<?> placementPredicate;

      public Entry(Heightmap.Type typeIn, PlacementType placementTypeIn, IPlacementPredicate<?> placementPredicateIn) {
         this.type = typeIn;
         this.placementType = placementTypeIn;
         this.placementPredicate = placementPredicateIn;
      }
   }

   @FunctionalInterface
   public interface IPlacementPredicate<T extends Entity> extends net.minecraft.entity.EntitySpawnPlacementRegistry.IPlacementPredicate<T> {
      boolean test(EntityType<T> p_test_1_, IWorld p_test_2_, SpawnReason p_test_3_, BlockPos p_test_4_, Random p_test_5_);
   }
}
