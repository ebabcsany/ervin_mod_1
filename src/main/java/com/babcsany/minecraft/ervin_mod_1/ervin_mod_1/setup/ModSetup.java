package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.setup;

import com.babcsany.minecraft.ervin_mod_1.entity.animal.*;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij.HhijEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurNirtreEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.Dgrurb;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.dgrurbk.Dgrurbk;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.*;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;

public class ModSetup {

    public ModSetup() {
        register();
    }

    public void register() {
        GlobalEntityTypeAttributes.put(EntityInit.LIWRAY.get(), Liwray.setCustomAttributes().create());
        GlobalEntityTypeAttributes.put(EntityInit.GWURST.get(), GwurstEntity.setCustomAttributes().create());
        GlobalEntityTypeAttributes.put(EntityInit.DGRURB_ENTITY.get(), Dgrurb.registerAttributes().create());
        GlobalEntityTypeAttributes.put(EntityInit.DGRURBK_ENTITY.get(), Dgrurbk.registerAttributes().create());
        GlobalEntityTypeAttributes.put(EntityInit.ZUR_NIRTRE_ENTITY.get(), ZurNirtreEntity.setCustomAttributes().create());
        GlobalEntityTypeAttributes.put(EntityInit.FREIN_ENTITY.get(), FreinEntity.setCustomAttributes().create());
        GlobalEntityTypeAttributes.put(EntityInit.VILT_ENTITY.get(), ViltEntity.setCustomAttributes().create());
        GlobalEntityTypeAttributes.put(EntityInit.SHERT_ENTITY.get(), ShertEntity.setCustomAttributes().create());
        GlobalEntityTypeAttributes.put(EntityInit.HHIJ_ENTITY.get(), HhijEntity.setCustomAttributes().create());
        GlobalEntityTypeAttributes.put(EntityInit.WANDERING_TRADER_NIRTRE_ENTITY.get(), WanderingTraderNirtreEntity.setCustomAttributes().create());
        GlobalEntityTypeAttributes.put(EntityInit.TRADER_NIRTRE_ENTITY.get(), TraderNirtreEntity.setCustomAttributes().create());
        GlobalEntityTypeAttributes.put(EntityInit.TRADER_NIRTRE1_ENTITY.get(), TraderNirtre1Entity.setCustomAttributes().create());
        GlobalEntityTypeAttributes.put(EntityInit.$_TRADER_ENTITY.get(), $TraderEntity.setCustomAttributes().create());
        GlobalEntityTypeAttributes.put(EntityInit.ZOMBIE_TRADER_ENTITY.get(), ZombieTraderEntity.setCustomAttributes().create());
    }
}
