package com.babcsany.minecraft.init;

import com.babcsany.minecraft.ervin_mod_1.entity.animal.SrachEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.fish.DrurgbkEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.fish.GubrovEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.RoventEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.projectile.DgrurbkSkullEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.projectile.TawrolEntity;
import com.babcsany.minecraft.ervin_mod_1.item.entity.icsvre.IcsvreEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.Registry;

public class EntityInit {

    public static EntityType<?> ENTITIES;

    public static final EntityType<RoventEntity> ROVENT_ENTITY = register("rovent", EntityType.Builder.create((RoventEntity::new), EntityClassification.CREATURE).size(0.6f, 1.95f).func_233606_a_(10).immuneToFire());
    public static final EntityType<IcsvreEntity> ICSVRE = register("icsvre", EntityType.Builder.<IcsvreEntity>create(IcsvreEntity::new, EntityClassification.MISC).size(0.25F, 0.25F).func_233606_a_(6).func_233608_b_(20));
    public static final EntityType<TawrolEntity> TAWROL = register("tawrol", EntityType.Builder.<TawrolEntity>create(TawrolEntity::new, EntityClassification.MISC).size(0.25F, 0.25F).func_233606_a_(4).func_233608_b_(10));
    //public static final EntityType<ModBoatEntity> MOD_BOAT = register("mod_boat", EntityType.Builder.<ModBoatEntity>create(ModBoatEntity::new, EntityClassification.MISC).size(1.375F, 0.5625F).func_233606_a_(10));
    public static final EntityType<GubrovEntity> GUBROV = register("gubrov", EntityType.Builder.create(GubrovEntity::new, EntityClassification.WATER_CREATURE).size(0.7f, 0.4f).func_233606_a_(10).immuneToFire());
    public static final EntityType<DrurgbkEntity> DRURGBK = register("drurgbk", EntityType.Builder.create(DrurgbkEntity::new, EntityClassification.WATER_CREATURE).size(0.5f, 0.3f).func_233606_a_(10).immuneToFire());
    public static final EntityType<ZurEntity> ZUR_ENTITY = register("zur", EntityType.Builder.<ZurEntity>create(ZurEntity::new, EntityClassification.CREATURE).size(0.6F, 1.90F).func_233606_a_(8).immuneToFire());
    public static final EntityType<DgrurbkSkullEntity> DGRURB_SKULL = register("dgrurb_skull", EntityType.Builder.<DgrurbkSkullEntity>create(DgrurbkSkullEntity::new, EntityClassification.MISC).size(0.3125F, 0.3125F).func_233606_a_(4).func_233608_b_(10));
    public static final EntityType<SrachEntity> SRACH_ENTITY = register("srach", EntityType.Builder.create(SrachEntity::new, EntityClassification.CREATURE).size(0.9f, 1.4f).func_233606_a_(12));

    private static String string(String name) {
        String string = "ervin_mod_1:";
        return string + name;
    }

    private static <T extends Entity> EntityType<T> register(String key, EntityType.Builder<T> builder) {
        return Registry.register(Registry.ENTITY_TYPE, string(key), builder.build(string(key)));
    }
}
