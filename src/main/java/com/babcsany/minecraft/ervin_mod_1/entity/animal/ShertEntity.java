package com.babcsany.minecraft.ervin_mod_1.entity.animal;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effect;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;

public class ShertEntity extends SrachEntity implements IShearable, net.minecraftforge.common.IForgeShearable {
   private static final DataParameter<String> MOOSHROOM_TYPE = EntityDataManager.createKey(ShertEntity.class, DataSerializers.STRING);
   private Effect hasStewEffect;
   private int effectDuration;
   /** Stores the UUID of the most recent lightning bolt to strike */
   private UUID lightningUUID;

   public ShertEntity(EntityType<? extends ShertEntity> type, World worldIn) {
      super(type, worldIn);
   }

   public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
      return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 10.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.2F);
   }

   public float getBlockPathWeight(BlockPos pos, IWorldReader worldIn) {
      return worldIn.getBlockState(pos.down()).isIn(Blocks.MYCELIUM) ? 10.0F : worldIn.getBrightness(pos) - 0.5F;
   }

   public static boolean func_223318_c(EntityType<ShertEntity> p_223318_0_, IWorld p_223318_1_, SpawnReason p_223318_2_, BlockPos p_223318_3_, Random p_223318_4_) {
      return p_223318_1_.getBlockState(p_223318_3_.down()).isIn(BlockItemInit.RED_GRASS_BLOCK.get()) && p_223318_1_.getLightSubtracted(p_223318_3_, 0) > 8;
   }

   /**
    * Called when a lightning bolt hits the entity.
    */
   public void onStruckByLightning(LightningBoltEntity lightningBolt) {
      UUID uuid = lightningBolt.getUniqueID();
      if (!uuid.equals(this.lightningUUID)) {
         this.setMooshroomType(this.getMooshroomType() == ShertEntity.Type.RED ? ShertEntity.Type.BROWN : ShertEntity.Type.RED);
         this.lightningUUID = uuid;
         this.playSound(SoundEvents.ENTITY_MOOSHROOM_CONVERT, 2.0F, 1.0F);
      }

   }

   protected void registerData() {
      super.registerData();
      this.dataManager.register(MOOSHROOM_TYPE, ShertEntity.Type.RED.name);
   }

   public ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand hand) {
      ItemStack itemstack = p_230254_1_.getHeldItem(hand);
      if (itemstack.getItem() == Items.BOWL && !this.isChild()) {
         boolean flag = false;
         ItemStack itemstack1;
         if (this.hasStewEffect != null) {
            flag = true;
            itemstack1 = new ItemStack(Items.SUSPICIOUS_STEW);
            SuspiciousStewItem.addEffect(itemstack1, this.hasStewEffect, this.effectDuration);
            this.hasStewEffect = null;
            this.effectDuration = 0;
         } else {
            itemstack1 = new ItemStack(Items.MUSHROOM_STEW);
         }

         ItemStack itemstack2 = DrinkHelper.func_241445_a_(itemstack, p_230254_1_, itemstack1);
         p_230254_1_.setHeldItem(hand, itemstack2);
         SoundEvent soundevent;
         if (flag) {
            soundevent = SoundEvents.ENTITY_MOOSHROOM_SUSPICIOUS_MILK;
         } else {
            soundevent = SoundEvents.ENTITY_MOOSHROOM_MILK;
         }

         this.playSound(soundevent, 1.0F, 1.0F);
         return ActionResultType.func_233537_a_(this.world.isRemote);
      } else if (false && itemstack.getItem() == Items.SHEARS && this.isShearable()) { //Forge: Moved to onSheared
         this.shear(SoundCategory.PLAYERS);
         if (!this.world.isRemote) {
            itemstack.damageItem(1, p_230254_1_, (p_213442_1_) -> {
               p_213442_1_.sendBreakAnimation(hand);
            });
         }

         return ActionResultType.func_233537_a_(this.world.isRemote);
      } else if (this.getMooshroomType() == ShertEntity.Type.BROWN && itemstack.getItem().isIn(ItemTags.SMALL_FLOWERS)) {
         if (this.hasStewEffect != null) {
            for(int i = 0; i < 2; ++i) {
               this.world.addParticle(ParticleTypes.SMOKE, this.getPosX() + this.rand.nextDouble() / 2.0D, this.getPosYHeight(0.5D), this.getPosZ() + this.rand.nextDouble() / 2.0D, 0.0D, this.rand.nextDouble() / 5.0D, 0.0D);
            }
         } else {
            Optional<Pair<Effect, Integer>> optional = this.getStewEffect(itemstack);
            if (!optional.isPresent()) {
               return ActionResultType.PASS;
            }

            Pair<Effect, Integer> pair = optional.get();
            if (!p_230254_1_.abilities.isCreativeMode) {
               itemstack.shrink(1);
            }

            for(int j = 0; j < 4; ++j) {
               this.world.addParticle(ParticleTypes.EFFECT, this.getPosX() + this.rand.nextDouble() / 2.0D, this.getPosYHeight(0.5D), this.getPosZ() + this.rand.nextDouble() / 2.0D, 0.0D, this.rand.nextDouble() / 5.0D, 0.0D);
            }

            this.hasStewEffect = pair.getLeft();
            this.effectDuration = pair.getRight();
            this.playSound(SoundEvents.ENTITY_MOOSHROOM_EAT, 2.0F, 1.0F);
         }

         return ActionResultType.func_233537_a_(this.world.isRemote);
      } else {
         return super.func_230254_b_(p_230254_1_, hand);
      }
   }

   public void shear(SoundCategory category) {
      this.world.playMovingSound(null, this, SoundEvents.ENTITY_MOOSHROOM_SHEAR, category, 1.0F, 1.0F);
      if (!this.world.isRemote()) {
         ((ServerWorld)this.world).spawnParticle(ParticleTypes.EXPLOSION, this.getPosX(), this.getPosYHeight(0.5D), this.getPosZ(), 1, 0.0D, 0.0D, 0.0D, 0.0D);
         this.remove();
         SrachEntity srachentity = EntityInit.SRACH_ENTITY.get().create(this.world);
         srachentity.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, this.rotationPitch);
         srachentity.setHealth(this.getHealth());
         srachentity.renderYawOffset = this.renderYawOffset;
         if (this.hasCustomName()) {
            srachentity.setCustomName(this.getCustomName());
            srachentity.setCustomNameVisible(this.isCustomNameVisible());
         }

         if (this.isNoDespawnRequired()) {
            srachentity.enablePersistence();
         }

         srachentity.setInvulnerable(this.isInvulnerable());
         this.world.addEntity(srachentity);

         for(int i = 0; i < 5; ++i) {
            this.world.addEntity(new ItemEntity(this.world, this.getPosX(), this.getPosYHeight(1.0D), this.getPosZ(), new ItemStack(this.getMooshroomType().renderState.getBlock())));
         }
      }

   }

   public boolean isShearable() {
      return this.isAlive() && !this.isChild();
   }

   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
      compound.putString("Type", this.getMooshroomType().name);
      if (this.hasStewEffect != null) {
         compound.putByte("EffectId", (byte)Effect.getId(this.hasStewEffect));
         compound.putInt("EffectDuration", this.effectDuration);
      }

   }

   /**
    * (abstract) Protected helper method to read subclass entity data from NBT.
    */
   public void readAdditional(CompoundNBT compound) {
      super.readAdditional(compound);
      this.setMooshroomType(ShertEntity.Type.getTypeByName(compound.getString("Type")));
      if (compound.contains("EffectId", 1)) {
         this.hasStewEffect = Effect.get(compound.getByte("EffectId"));
      }

      if (compound.contains("EffectDuration", 3)) {
         this.effectDuration = compound.getInt("EffectDuration");
      }

   }

   private Optional<Pair<Effect, Integer>> getStewEffect(ItemStack p_213443_1_) {
      Item item = p_213443_1_.getItem();
      if (item instanceof BlockItem) {
         Block block = ((BlockItem)item).getBlock();
         if (block instanceof FlowerBlock) {
            FlowerBlock flowerblock = (FlowerBlock)block;
            return Optional.of(Pair.of(flowerblock.getStewEffect(), flowerblock.getStewEffectDuration()));
         }
      }

      return Optional.empty();
   }

   private void setMooshroomType(ShertEntity.Type typeIn) {
      this.dataManager.set(MOOSHROOM_TYPE, typeIn.name);
   }

   public ShertEntity.Type getMooshroomType() {
      return ShertEntity.Type.getTypeByName(this.dataManager.get(MOOSHROOM_TYPE));
   }

   public ShertEntity createChild(AgeableEntity ageable) {
      ShertEntity shertentity = EntityInit.SHERT_ENTITY.get().create(this.world);
      shertentity.setMooshroomType(this.func_213445_a((ShertEntity)ageable));
      return shertentity;
   }

   private ShertEntity.Type func_213445_a(ShertEntity p_213445_1_) {
      ShertEntity.Type shertentity$type = this.getMooshroomType();
      ShertEntity.Type shertentity$type1 = p_213445_1_.getMooshroomType();
      ShertEntity.Type shertentity$type2;
      if (shertentity$type == shertentity$type1 && this.rand.nextInt(1024) == 0) {
         shertentity$type2 = shertentity$type == ShertEntity.Type.BROWN ? ShertEntity.Type.RED : ShertEntity.Type.BROWN;
         shertentity$type2 = shertentity$type == Type.RED ? Type.GRINTH : Type.BROWN;
         shertentity$type2 = shertentity$type == Type.BROWN ? Type.GRINTH : Type.RED;
         shertentity$type2 = shertentity$type == Type.RED ? Type.BROWN : Type.GRINTH;
      } else {
         shertentity$type2 = this.rand.nextBoolean() ? shertentity$type : shertentity$type1;
      }

      return shertentity$type2;
   }

   @Override
   public boolean isShearable(@javax.annotation.Nonnull ItemStack item, World world, BlockPos pos) {
      return isShearable();
   }

   @javax.annotation.Nonnull
   @Override
   public java.util.List<ItemStack> onSheared(@javax.annotation.Nullable PlayerEntity player, @javax.annotation.Nonnull ItemStack item, World world, BlockPos pos, int fortune) {
      world.playMovingSound(null, this, SoundEvents.ENTITY_MOOSHROOM_SHEAR, player == null ? SoundCategory.BLOCKS : SoundCategory.PLAYERS, 1.0F, 1.0F);
      if (!world.isRemote()) {
         ((ServerWorld)this.world).spawnParticle(ParticleTypes.EXPLOSION, this.getPosX(), this.getPosYHeight(0.5D), this.getPosZ(), 1, 0.0D, 0.0D, 0.0D, 0.0D);
         this.remove();
         SrachEntity srachentity = EntityInit.SRACH_ENTITY.get().create(this.world);
         srachentity.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, this.rotationPitch);
         srachentity.setHealth(this.getHealth());
         srachentity.renderYawOffset = this.renderYawOffset;
         if (this.hasCustomName()) {
            srachentity.setCustomName(this.getCustomName());
            srachentity.setCustomNameVisible(this.isCustomNameVisible());
         }

         if (this.isNoDespawnRequired()) {
            srachentity.enablePersistence();
         }

         srachentity.setInvulnerable(this.isInvulnerable());
         this.world.addEntity(srachentity);

         java.util.List<ItemStack> items = new java.util.ArrayList<>();
         for (int i = 0; i < 5; ++i) {
            items.add(new ItemStack(this.getMooshroomType().renderState.getBlock()));
         }

         return items;
      }
      return java.util.Collections.emptyList();
   }


   public static enum Type {
      RED("red", Blocks.RED_MUSHROOM.getDefaultState()),
      BROWN("brown", Blocks.BROWN_MUSHROOM.getDefaultState()),
      GRINTH("grinth", BlockItemInit.GRINTH_MUSHROOM_BLOCK.get().getDefaultState());

      private final String name;
      private final BlockState renderState;

      private Type(String nameIn, BlockState renderStateIn) {
         this.name = nameIn;
         this.renderState = renderStateIn;
      }

      /**
       * A block state that is rendered on the back of the mooshroom.
       */
      @OnlyIn(Dist.CLIENT)
      public BlockState getRenderState() {
         return this.renderState;
      }

      private static ShertEntity.Type getTypeByName(String nameIn) {
         for(ShertEntity.Type mooshroomentity$type : values()) {
            if (mooshroomentity$type.name.equals(nameIn)) {
               return mooshroomentity$type;
            }
         }

         return RED;
      }
   }
}