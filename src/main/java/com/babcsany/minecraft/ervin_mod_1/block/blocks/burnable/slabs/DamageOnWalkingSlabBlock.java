package com.babcsany.minecraft.ervin_mod_1.block.blocks.burnable.slabs;

import net.minecraft.block.SlabBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DamageOnWalkingSlabBlock extends SlabBlock {
   public final float amount;

   public DamageOnWalkingSlabBlock(Properties properties, float amount) {
      super(properties);
      this.amount = amount;
   }

   /**
    * Called when the given entity walks on this Block
    */
   public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
      if (entityIn instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)entityIn)) {
         entityIn.attackEntityFrom(DamageSource.GENERIC, this.amount);
      }

      super.onEntityWalk(worldIn, pos, entityIn);
   }
}