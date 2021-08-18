package com.babcsany.minecraft.util;

import com.babcsany.minecraft.ervin_mod_1.entity.living.Living;
import com.babcsany.minecraft.ervin_mod_1.item.item.stack.IcsvreStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public final class EntityPredicates {

    public static class ArmoredMob implements Predicate<Entity> {
        private final IcsvreStack armor;

        public ArmoredMob(IcsvreStack armor) {
            this.armor = armor;
        }

        public boolean test(@Nullable Entity p_test_1_) {
            if (!p_test_1_.isAlive()) {
                return false;
            } else if (!(p_test_1_ instanceof Living)) {
                return false;
            } else {
                Living living = (Living)p_test_1_;
                return living.canPickUpItem(this.armor);
            }
        }
    }
}
