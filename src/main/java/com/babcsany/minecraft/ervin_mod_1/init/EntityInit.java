package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
//import com.babcsany.minecraft.ervin_mod_1.entity.animal.FreinEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.*;
import com.babcsany.minecraft.ervin_mod_1.entity.item.FirgBoatEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.projectile.ScrakthsPearlEntity;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityInit {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES,
            Ervin_mod_1.MOD_ID);

    public static final RegistryObject<EntityType<ZurEntity1>> ZUR_ENTITY1 = ENTITY_TYPES
            .register("zur_entity_1",
                    () -> EntityType.Builder.<ZurEntity1>create(ZurEntity1::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "zur_entity_1").toString()
                            ));
    public static final RegistryObject<EntityType<ZurEntity>> ZUR_ENTITY = ENTITY_TYPES
            .register("zur_entity",
                    () -> EntityType.Builder.<ZurEntity>create(ZurEntity::new, EntityClassification.MONSTER)
                            .size(0.6f, 1.95f)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "zur_entity").toString()
                            ));
    public static final RegistryObject<EntityType<FreinEntity>> FREIN_ENTITY = ENTITY_TYPES
            .register("frein_entity",
                    () -> EntityType.Builder.<FreinEntity>create(FreinEntity::new, EntityClassification.CREATURE)
                            .size(1.0f, 3.0f)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "frein_entity").toString()
                            ));
    public static final RegistryObject<EntityType<ViltEntity>> VILT_ENTITY = ENTITY_TYPES
            .register("vilt_entity",
                    () -> EntityType.Builder.<ViltEntity>create(ViltEntity::new, EntityClassification.CREATURE)
                            .size(1.0f, 2.0f)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "crask").toString()
                            ));
    public static final RegistryObject<EntityType<SrachEntity>> SRACH_ENTITY = ENTITY_TYPES
            .register("srach/srach",
                    () -> EntityType.Builder.<SrachEntity>create(SrachEntity::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.4f)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "srach/srach").toString()
                            ));
    public static final RegistryObject<EntityType<ShertEntity>> SHERT_ENTITY = ENTITY_TYPES
            .register("srach/shert",
                    () -> EntityType.Builder.<ShertEntity>create(ShertEntity::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.4f)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "srach/shert").toString()
                            ));
    public static final RegistryObject<EntityType<WolfEntity1>> HHIJ_ENTITY = ENTITY_TYPES
            .register("wolf1",
                    () -> EntityType.Builder.<WolfEntity1>create(WolfEntity1::new, EntityClassification.CREATURE)
                            .size(0.6f, 0.85f)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "srach/shert").toString()
                            ));
}
