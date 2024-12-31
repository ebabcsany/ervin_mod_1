package com.babcsany.minecraft.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.entity.ModBoatEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.projectile.Huihk;
import com.babcsany.minecraft.ervin_mod_1.entity.projectile.TawrolEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityInit {

    public static EntityInit ENTITIES;
    private static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Ervin_mod_1.MOD_ID);

//    public static final RegistryObject<EntityType<TawrolEntity>> TAWROL = ENTITY_TYPES.register("tawrol", () -> EntityType.Builder.create(new EntityType.IFactory<TawrolEntity>(EntityClassification.MISC), EntityClassification.MISC).size(0.25F, 0.25F).trackingRange(4).updateInterval(10));
//    public static final RegistryObject<EntityType<Huihk>> HUIHK = ENTITY_TYPES.register("huihk", () -> EntityType.Builder.create(EntityClassification.MISC).disableSerialization().disableSummoning().size(0.25F, 0.25F).immuneToFire().trackingRange(4).updateInterval(5));
//    public static final RegistryObject<EntityType<ModBoatEntity>> MOD_BOAT = ENTITY_TYPES.register("mod_boat", () -> EntityType.Builder.create(ModBoatEntity::new, EntityClassification.MISC).size(1.375F, 0.5625F).trackingRange(10));

    @Deprecated
    public static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
        return Registry.register(Registry.ENTITY_TYPE, Ervin_mod_1.identifier(name), builder.build(Ervin_mod_1.identifier(name)));
    }
}
