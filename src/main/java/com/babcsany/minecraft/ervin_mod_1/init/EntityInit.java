package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.ZurEntity1;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityInit {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES,
            Ervin_mod_1.MOD_ID);

    public static final RegistryObject<EntityType<ZurEntity1>> ZUR_ENTITY = ENTITY_TYPES
            .register("zur_entity",
                    () -> EntityType.Builder.<ZurEntity1>create(ZurEntity1::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(Ervin_mod_1.MOD_ID, "zur_entity").toString()));
}
