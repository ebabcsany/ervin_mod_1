package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.setup;

import com.babcsany.minecraft.ervin_mod_1.entity.animal.*;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij.HhijEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.RoventEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurNirtreEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.*;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;

import java.util.function.Supplier;

import static com.babcsany.minecraft.ervin_mod_1.init.EntityInit.*;

public class ModSetup {

    public ModSetup() {
        register();
    }

    public void register() {
        put(LIWRAY, Liwray.setCustomAttributes());
        put(GWURST, GwurstEntity.setCustomAttributes());
        put(ROVENT_ENTITY, RoventEntity.func_234342_eQ_());
        put(ZUR_NIRTRE_ENTITY, ZurNirtreEntity.setCustomAttributes());
        put(FREIN_ENTITY, FreinEntity.setCustomAttributes());
        put(VILT_ENTITY, ViltEntity.setCustomAttributes());
        put(SRACH_ENTITY, SrachEntity.setCustomAttributes());
        put(SHERT_ENTITY, ShertEntity.setCustomAttributes());
        put(HHIJ_ENTITY, HhijEntity.setCustomAttributes());
        put(WANDERING_TRADER_NIRTRE_ENTITY, WanderingTraderNirtreEntity.setCustomAttributes());
        put(TRADER_NIRTRE_ENTITY, TraderNirtreEntity.setCustomAttributes());
        put(TRADER_NIRTRE1_ENTITY, TraderNirtre1Entity.setCustomAttributes());
        put($_TRADER_ENTITY, $TraderEntity.setCustomAttributes());
        put(ZOMBIE_TRADER_ENTITY, ZombieTraderEntity.setCustomAttributes());
        put(ZUR_ENTITY, ZurEntity.setCustomAttributes());
        put(GUBROV, GwurstEntity.setCustomAttributes());
    }

    public static <T extends LivingEntity> AttributeModifierMap put(Supplier<EntityType<T>> type, AttributeModifierMap.MutableAttribute mutableAttribute) {
        return GlobalEntityTypeAttributes.put(type.get(), mutableAttribute.create());
    }
}
