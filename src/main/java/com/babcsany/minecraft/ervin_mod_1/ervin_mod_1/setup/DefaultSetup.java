package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.setup;

import com.babcsany.minecraft.ervin_mod_1.entity.animal.SrachEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.fish.DrurgbkEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.fish.GubrovEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.RoventEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import com.babcsany.minecraft.init.EntityInit;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;

public class DefaultSetup {

    public DefaultSetup() {
        register();
    }

    public void register() {
        GlobalEntityTypeAttributes.put(com.babcsany.minecraft.init.EntityInit.ZUR_ENTITY, ZurEntity.setCustomAttributes().create());
        GlobalEntityTypeAttributes.put(com.babcsany.minecraft.init.EntityInit.ROVENT_ENTITY, RoventEntity.setCustomAttributes().create());
        GlobalEntityTypeAttributes.put(EntityInit.DRURGBK, DrurgbkEntity.setCustomAttributes().create());
        GlobalEntityTypeAttributes.put(com.babcsany.minecraft.init.EntityInit.SRACH_ENTITY, SrachEntity.setCustomAttributes().create());
        GlobalEntityTypeAttributes.put(com.babcsany.minecraft.init.EntityInit.GUBROV, GubrovEntity.setCustomAttributes().create());
    }
}
