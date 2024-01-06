package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.setup;

import com.babcsany.minecraft.ervin_mod_1.entity.animal.*;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij.HhijEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurNirtreEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.*;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;

import java.util.function.Supplier;

public class ModSetup {

    public ModSetup() {
        register();
    }

    public void register() {
        put(EntityInit.LIWRAY, Liwray.setCustomAttributes());
        put(EntityInit.GWURST, GwurstEntity.setCustomAttributes());
        put(EntityInit.ZUR_NIRTRE_ENTITY, ZurNirtreEntity.setCustomAttributes());
        put(EntityInit.FREIN_ENTITY, FreinEntity.setCustomAttributes());
        put(EntityInit.VILT_ENTITY, ViltEntity.setCustomAttributes());
        put(EntityInit.SHERT_ENTITY, ShertEntity.setCustomAttributes());
        put(EntityInit.HHIJ_ENTITY, HhijEntity.setCustomAttributes());
        put(EntityInit.WANDERING_TRADER_NIRTRE_ENTITY, WanderingTraderNirtreEntity.setCustomAttributes());
        put(EntityInit.TRADER_NIRTRE_ENTITY, TraderNirtreEntity.setCustomAttributes());
        put(EntityInit.TRADER_NIRTRE1_ENTITY, TraderNirtre1Entity.setCustomAttributes());
        put(EntityInit.$_TRADER_ENTITY, $TraderEntity.setCustomAttributes());
        put(EntityInit.ZOMBIE_TRADER_ENTITY, ZombieTraderEntity.setCustomAttributes());
    }

    public static <T extends LivingEntity> AttributeModifierMap put(Supplier<EntityType<T>> type, AttributeModifierMap.MutableAttribute mutableAttribute) {
        return GlobalEntityTypeAttributes.put(type.get(), mutableAttribute.create());
    }
}
