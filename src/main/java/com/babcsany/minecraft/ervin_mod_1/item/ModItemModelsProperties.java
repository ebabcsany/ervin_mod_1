package com.babcsany.minecraft.ervin_mod_1.item;

import com.babcsany.minecraft.ervin_mod_1.entity.ModPlayer;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.BlockItemInit_;
import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModItemModelsProperties extends ItemModelsProperties {
    public static void init() {
        registerProperty(BlockItemInit_.FIGHIV, new ResourceLocation("time"), (stack, world, living) -> {
            Entity entity = living != null ? living : stack.getAttachedEntity();
            if (entity == null) {
                return 0.0F;
            } else {
                if (world == null && entity.world instanceof ClientWorld) {
                    world = (ClientWorld)entity.world;
                }

                if (world == null) {
                    return 0.0F;
                } else {
                    double d0;
                    d0 = world.func_242415_f(1.0F);
                    return (float)d0;
                }
            }
        });
        registerProperty(isBurnableItemInit.HUIHK_ROD, new ResourceLocation("cast"), (stack, world, living) -> {
            if (living == null) {
                return 0.0F;
            } else {
                boolean flag = living.getHeldItemMainhand() == stack;
                boolean flag1 = living.getHeldItemOffhand() == stack;
                if (living.getHeldItemMainhand().getItem() instanceof HuihkRodItem) {
                    flag1 = false;
                }

                return (flag || flag1) && living instanceof PlayerEntity && ModPlayer.huihk != null ? 1.0F : 0.0F;
            }
        });
        registerProperty(ItemInit.TURG_SHIELD, new ResourceLocation("blocking"), (stack, world, living) -> {
            return living != null && living.isHandActive() && living.getActiveItemStack() == stack ? 1.0F : 0.0F;
        });
    }
}
