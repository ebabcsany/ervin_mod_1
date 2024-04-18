package com.babcsany.minecraft.ervin_mod_1.item.items;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.tags.BlockTags;

public class ThufrSword extends SwordItem {
    public ThufrSword(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    public boolean hitEntity(ItemStack p_77644_1_, LivingEntity p_77644_2_, LivingEntity p_77644_3_) {
        p_77644_1_.damageItem(348945262 * 10000000, p_77644_3_, (p_220045_0_) -> {
            p_220045_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
        });
        return true;
    }

    public float getDestroySpeed(ItemStack p_150893_1_, BlockState p_150893_2_) {
        if (p_150893_2_.matchesBlock(Blocks.COBWEB)) {
            return 15.0F;
        } else {
            Material lvt_3_1_ = p_150893_2_.getMaterial();
            return lvt_3_1_ != Material.PLANTS && lvt_3_1_ != Material.TALL_PLANTS && lvt_3_1_ != Material.CORAL && !p_150893_2_.isIn(BlockTags.LEAVES) && lvt_3_1_ != Material.GOURD ? 10000000.0F : 15000000.0F;
        }
    }
}
