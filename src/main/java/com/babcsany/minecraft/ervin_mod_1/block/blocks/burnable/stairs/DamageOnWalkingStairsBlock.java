package com.babcsany.minecraft.ervin_mod_1.block.blocks.burnable.stairs;

import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class DamageOnWalkingStairsBlock extends StairsBlock {
   public final float amount;

   @Deprecated // Forge: Use the other constructor that takes a Supplier
   public DamageOnWalkingStairsBlock(BlockState state, Properties properties, float amount) {
      super(state, properties);
      this.amount = amount;
   }

   public DamageOnWalkingStairsBlock(Supplier<BlockState> state, Properties properties, float amount) {
      super(state, properties);
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