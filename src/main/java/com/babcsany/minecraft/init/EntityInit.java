package com.babcsany.minecraft.init;

import com.babcsany.minecraft.entity.ModBoatEntity;
import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityInit {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Ervin_mod_1.MOD_ID);

    public static final EntityType<ModBoatEntity> MOD_BOAT = Ervin_mod_1.entityRegister("ervin_mod_1:mod_boat",EntityType.Builder.<ModBoatEntity>create(ModBoatEntity::new, EntityClassification.MISC).size(1.375F, 0.5625F).func_233606_a_(10));

}
