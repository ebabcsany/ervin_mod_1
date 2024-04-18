package com.babcsany.minecraft.ervin_mod_1.block.blocks.special;

import com.babcsany.minecraft.ervin_mod_1.init.special.SpecialBlockInit;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.material.PushReaction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.item.minecart.AbstractMinecartEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Gtrziuzhizjkj extends HorizontalBlock {
   protected static final VoxelShape SHAPES = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

   public Gtrziuzhizjkj(Properties properties) {
      super(properties);
   }

   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
      builder.add(HORIZONTAL_FACING);
   }

   public BlockState getStateForPlacement(BlockItemUseContext context) {
      return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
   }

   public PushReaction getPushReaction(BlockState state) {
      return PushReaction.PUSH_ONLY;
   }

   private static boolean func_226937_c_(Entity entity) {
      return entity instanceof LivingEntity || entity instanceof AbstractMinecartEntity || entity instanceof TNTEntity || entity instanceof BoatEntity || entity instanceof ItemEntity;
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
      return adjacentBlockState.matchesBlock(this) || super.isSideInvisible(state, adjacentBlockState, side);
   }

   public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
      return SHAPES;
   }

   /**
    * Block's chance to react to a living entity falling on it.
    */
   public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
      entityIn.playSound(SoundEvents.BLOCK_HONEY_BLOCK_SLIDE, 1.0F, 1.0F);
      if (!worldIn.isRemote) {
         worldIn.setEntityState(entityIn, (byte)54);
      }

      if (entityIn.onLivingFall(fallDistance, 0.00001F)) {
         entityIn.playSound(this.soundType.getFallSound(), this.soundType.getVolume() * 0.5F, this.soundType.getPitch() * 0.75F);
      }

      if (entityIn.isSuppressingBounce()) {
         super.onFallenUpon(worldIn, pos, entityIn, fallDistance);
      }
   }

   /**
    * Called when an Entity lands on this Block. This method *must* update motionY because the entity will not do that
    * on its own
    */
   public void onLanded(IBlockReader worldIn, Entity entityIn) {
      if (entityIn.isSuppressingBounce()) {
         super.onLanded(worldIn, entityIn);
      } else {
         this.bounceEntity(entityIn);
      }

   }

   private void bounceEntity(Entity entity) {
      Vector3d vector3d = entity.getMotion();
      if (vector3d.y < 0.0D) {
         double d0 = entity instanceof LivingEntity ? 4.0D : 3.996D;
         entity.setMotion(vector3d.x, -vector3d.y * d0, vector3d.z);
      }

   }

   public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
      if (this.isSliding(pos, entityIn)) {
         this.triggerSlideDownBlock(entityIn, pos);
         this.func_226938_d_(entityIn);
         this.func_226934_a_(worldIn, entityIn);
      }

      super.onEntityCollision(state, worldIn, pos, entityIn);
   }

   private boolean isSliding(BlockPos pos, Entity entity) {
      if (entity.isOnGround()) {
         return false;
      } else if (entity.getPosY() > (double)pos.getY() + 9.375D - 1.0E-7D) {
         return false;
      } else if (entity.getMotion().y >= -0.8D) {
         return false;
      } else {
         double d0 = Math.abs((double)pos.getX() + 1.0D - entity.getPosX());
         double d1 = Math.abs((double)pos.getZ() + 1.0D - entity.getPosZ());
         double d2 = 4.375D + (double)(entity.getWidth() / 4.0F);
         return d0 + 1.0E-7D > d2 || d1 + 1.0E-7D > d2;
      }
   }

   private void triggerSlideDownBlock(Entity entity, BlockPos pos) {
      if (entity instanceof ServerPlayerEntity && entity.world.getGameTime() % 20L == 0L) {
         CriteriaTriggers.SLIDE_DOWN_BLOCK.test((ServerPlayerEntity)entity, entity.world.getBlockState(pos));
      }

   }

   private void func_226938_d_(Entity entity) {
      Vector3d vector3d = entity.getMotion();
      if (vector3d.y < -1.3D) {
         double d0 = -5.0D / vector3d.y;
         entity.setMotion(new Vector3d(vector3d.x * d0, -0.5D, vector3d.z * d0));
      } else {
         entity.setMotion(new Vector3d(vector3d.x, -0.05D, vector3d.z));
      }

      entity.fallDistance = 0.0F;
   }

   private void func_226934_a_(World world, Entity entity) {
      if (func_226937_c_(entity)) {
         if (world.rand.nextInt(20) == 0) {
            entity.playSound(SoundEvents.BLOCK_HONEY_BLOCK_SLIDE, 1.0F, 1.0F);
         }

         if (!world.isRemote && world.rand.nextInt(20) == 0) {
            world.setEntityState(entity, (byte)212);
         }
      }

   }

   @OnlyIn(Dist.CLIENT)
   public static void func_226931_a_(Entity entity) {
      func_226932_a_(entity, 5);
   }

   @OnlyIn(Dist.CLIENT)
   public static void func_226936_b_(Entity entity) {
      func_226932_a_(entity, 10);
   }

   @OnlyIn(Dist.CLIENT)
   private static void func_226932_a_(Entity entity, int particleCount) {
      if (entity.world.isRemote) {
         BlockState blockstate = SpecialBlockInit.GTRZIUZHIZJKJ.get().getDefaultState();

         for(int i = 0; i < particleCount; ++i) {
            entity.world.addParticle(new BlockParticleData(ParticleTypes.BLOCK, blockstate), entity.getPosX(), entity.getPosY(), entity.getPosZ(), 0.0D, 0.0D, 0.0D);
         }

      }
   }

   /**
    * Called when the given entity walks on this Block
    */
   public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
      double d0 = Math.abs(entityIn.getMotion().y);
      if (d0 < 0.1D && !entityIn.isSteppingCarefully()) {
         double d1 = 1.0D + d0 * 0.2D;
         entityIn.setMotion(entityIn.getMotion().mul(d1, 20.0D, d1));
      }

      super.onEntityWalk(worldIn, pos, entityIn);
   }
}
