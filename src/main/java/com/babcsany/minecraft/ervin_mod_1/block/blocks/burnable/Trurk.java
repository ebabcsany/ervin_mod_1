package com.babcsany.minecraft.ervin_mod_1.block.blocks.burnable;

import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class Trurk extends Block {
   public Trurk(Properties properties) {
      super(properties);
   }

   public void onEntityWalk(World worldIn, BlockPos blockPos, Entity entityIn) {
      if (!entityIn.isImmuneToFire() && entityIn instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)entityIn)) {
         entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 0.2F);
      }

      super.onEntityWalk(worldIn, blockPos, entityIn);
   }

   /* *
    * Called periodically clientside on blocks near the player to show effects (like furnace fire particles). Note that
    * this method is unrelated to {@link randomTick} and {@link #needsRandomTick}, and will always be called regardless
    * of whether the block can receive random update ticks
    */
   @OnlyIn(Dist.CLIENT)
   public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
      Direction direction = Direction.func_239631_a_(rand);
      if (direction != Direction.UP) {
         BlockPos blockpos = pos.offset(direction);
         BlockState blockstate = worldIn.getBlockState(blockpos);
         if (!stateIn.isSolid() || !blockstate.isSolidSide(worldIn, blockpos, direction.getOpposite())) {
            double d0 = (double)pos.getX();
            double d1 = (double)pos.getY();
            double d2 = (double)pos.getZ();
            if (direction == Direction.DOWN) {
               d1 = d1 - 0.05D;
               d0 += rand.nextDouble();
               d2 += rand.nextDouble();
            } else {
               d1 = d1 + rand.nextDouble() * 0.8D;
               if (direction.getAxis() == Direction.Axis.X) {
                  d2 += rand.nextDouble();
                  if (direction == Direction.EAST) {
                     ++d0;
                  } else {
                     d0 += 0.05D;
                  }
               } else {
                  d0 += rand.nextDouble();
                  if (direction == Direction.SOUTH) {
                     ++d2;
                  } else {
                     d2 += 0.05D;
                  }
               }
            }

            worldIn.addParticle(ParticleTypes.DRIPPING_LAVA, d0, d1, d2, 0.0D, 0.0D, 0.0D);
         }
      }
   }
}