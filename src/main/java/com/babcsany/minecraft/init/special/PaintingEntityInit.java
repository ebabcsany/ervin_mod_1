package com.babcsany.minecraft.init.special;

import com.babcsany.minecraft.ervin_mod_1.entity.item.modPainting_Entity;
import com.babcsany.minecraft.ervin_mod_1.util.registries.modPainting_Type;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.Registry;

public class PaintingEntityInit {

    public static EntityType<?> PAINTING_ENTITIES;

    public static final EntityType<modPainting_Entity> modPainting = register("modPainting", EntityType.Builder.<modPainting_Entity>create(modPainting_Entity::new, EntityClassification.MISC).size(0.5F, 0.5F).immuneToFire().func_233606_a_(10).func_233608_b_(Integer.MAX_VALUE));

    public static String string(String key) {
        String string = "ervin_mod_1:painting_entities/";
        return string + key;
    }

    private static <T extends Entity> EntityType<T> register(String key, EntityType.Builder<T> builder) {
        return Registry.register(Registry.ENTITY_TYPE, string(key), builder.build(string(key)));
    }

    modPainting_Type modPainting_TYPE;
}
