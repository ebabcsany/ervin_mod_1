package com.babcsany.minecraft.ervin_mod_1.block.blocks;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class NetherPortal extends Block {

   public NetherPortal(AbstractBlock.Properties properties) {
      super(properties);
   }

   /**
    * Performs a random tick on a block.
    */
   public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
      if (worldIn.func_230315_m_().func_236043_f_() && worldIn.getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING) && random.nextInt(2000) < worldIn.getDifficulty().getId()) {
         while(worldIn.getBlockState(pos).isIn(this)) {
            pos = pos.down();
         }

         if (worldIn.getBlockState(pos).canEntitySpawn(worldIn, pos, EntityType.ZOMBIFIED_PIGLIN)) {
            Entity entity = EntityType.ZOMBIFIED_PIGLIN.spawn(worldIn, (CompoundNBT)null, (ITextComponent)null, (PlayerEntity)null, pos.up(), SpawnReason.STRUCTURE, false, false);
            if (entity != null) {
               entity.timeUntilPortal = entity.getPortalCooldown();
            }
         }
      }
   }
   @OnlyIn(Dist.CLIENT)
   public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
      if (rand.nextInt(100) == 0) {
         worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_PORTAL_AMBIENT, SoundCategory.BLOCKS, 0.5F, rand.nextFloat() * 0.4F + 0.8F, false);
      }

      for(int i = 0; i < 4; ++i) {
         double d0 = (double)pos.getX() + rand.nextDouble();
         double d1 = (double)pos.getY() + rand.nextDouble();
         double d2 = (double)pos.getZ() + rand.nextDouble();
         double d3 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
         double d4 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
         double d5 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
         int j = rand.nextInt(2) * 2 - 1;

         worldIn.addParticle(ParticleTypes.PORTAL, d0, d1, d2, d3, d4, d5);
      }

   }
}