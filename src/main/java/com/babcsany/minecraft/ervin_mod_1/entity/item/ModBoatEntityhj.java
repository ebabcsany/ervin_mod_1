package com.babcsany.minecraft.ervin_mod_1.entity.item;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SSpawnObjectPacket;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class ModBoatEntityhj extends BoatEntity {
   private static final DataParameter<Integer> MOD_BOAT_TYPE = EntityDataManager.createKey(BoatEntity.class, DataSerializers.VARINT);
   @Deprecated //Forge: Use isAlive, remove(boolean) and revive() instead of directly accessing this field. To allow the entity to react to and better control this information.
   public boolean removed;
   private float[] paddlePositions;
   private BoatEntity.Status status;
   private double lastYd;

   public ModBoatEntityhj(World world, double x, double y, double z) {
      this(EntityInit.MOD_BOAT_ENTITY.get(), world);
      this.setPosition(x, y, z);
      this.setMotion(Vector3d.ZERO);
      this.prevPosX = x;
      this.prevPosY = y;
      this.prevPosZ = z;
   }

   public ModBoatEntityhj(EntityType<? extends ModBoatEntityhj> boatEntityType, World world) {
      super(boatEntityType, world);
      this.paddlePositions = new float[2];
      this.preventEntitySpawning = true;
   }

   public Item getItemBoat() {
      switch(this.getModBoatType()) {
         default:
            return com.babcsany.minecraft.init.item.ItemInit.FIRG_BOAT;
         case FRIM:
            return ItemInit.FRIM_BOAT.get();
      }
   }

   public Block getPlanks() {
      switch(this.getModBoatType()) {
         default:
            return BlockInit.FIRG_PLANKS;
         case FRIM:
            return BlockItemInit.FRIM_PLANKS.get();
      }
   }

   public ModBoatEntityhj.ModBoatType getModBoatType() {
      return ModBoatEntityhj.ModBoatType.byId(this.dataManager.get(MOD_BOAT_TYPE));
   }

   public void setModBoatType(ModBoatEntityhj.ModBoatType modBoatType) {
      this.dataManager.set(MOD_BOAT_TYPE, modBoatType.ordinal());
   }

   protected void registerData() {
      super.registerData();
      this.dataManager.register(MOD_BOAT_TYPE, ModBoatType.FIRG.ordinal());
   }

   protected void writeAdditional(CompoundNBT compound) {
      compound.putString("Type", this.getModBoatType().getName());
   }

   protected void readAdditional(CompoundNBT compound) {
      if (compound.contains("Type", 8)) {
         this.setModBoatType(ModBoatEntityhj.ModBoatType.getTypeFromString(compound.getString("ModBoatType")));
      }

   }

   public void performHurtAnimation() {
      this.setForwardDirection(-this.getForwardDirection());
      this.setTimeSinceHit(10);
      this.setDamageTaken(this.getDamageTaken() * 11.0F);
   }

   protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
      this.lastYd = this.getMotion().y;
      if (!this.isPassenger()) {
         if (onGroundIn) {
            if (this.fallDistance > 3.0F) {
               if (this.status != BoatEntity.Status.ON_LAND) {
                  this.fallDistance = 0.0F;
                  return;
               }

               this.onLivingFall(this.fallDistance, 1.0F);
               if (!this.world.isRemote && !this.removed) {
                  this.remove();
                  if (this.world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
                     int j;
                     for(j = 0; j < 3; ++j) {
                        this.entityDropItem(this.getPlanks());
                     }

                     for(j = 0; j < 2; ++j) {
                        this.entityDropItem(Items.STICK);
                     }

                     //this.entityDropItem(Items.STICK);
                  }
               }
            }

            this.fallDistance = 0.0F;
         } else if (!this.world.getFluidState(this.getPosition().down()).isTagged(FluidTags.WATER) && y < 0.0D) {
            this.fallDistance = (float)((double)this.fallDistance - y);
         }
      }

   }

   public boolean attackEntityFrom(DamageSource source, float amount) {
      if (this.isInvulnerableTo(source)) {
         return false;
      } else if (!this.world.isRemote && !this.removed) {
         this.setForwardDirection(-this.getForwardDirection());
         this.setTimeSinceHit(10);
         this.setDamageTaken(this.getDamageTaken() + amount * 10.0F);
         this.markVelocityChanged();
         boolean bl = source.getTrueSource() instanceof PlayerEntity && ((PlayerEntity)source.getTrueSource()).abilities.isCreativeMode;
         if (bl || this.getDamageTaken() > 40.0F) {
            if (!bl && this.world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
               this.entityDropItem(this.getItemBoat());
            }

            this.remove();
         }

         return true;
      } else {
         return true;
      }
   }

   public IPacket<?> createSpawnPacket() {
      return new SSpawnObjectPacket(this);
   }

   public static enum ModBoatType {
      FIRG("firg"),
      FRIM("frim");

      private final String name;

      ModBoatType(String string) {
         this.name = string;
      }

      public static ModBoatEntityhj.ModBoatType byId(int id) {
         ModBoatEntityhj.ModBoatType[] aBYGBoatEntity$BYGType = values();
         if (id < 0 || id >= aBYGBoatEntity$BYGType.length) {
            id = 0;
         }

         return aBYGBoatEntity$BYGType[id];
      }

      public static ModBoatEntityhj.ModBoatType getTypeFromString(String nameIn) {
         ModBoatEntityhj.ModBoatType[] aModBoatEntity$BoatType = values();
         ModBoatEntityhj.ModBoatType[] var2 = aModBoatEntity$BoatType;
         int var3 = aModBoatEntity$BoatType.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            ModBoatEntityhj.ModBoatType BoatType = var2[var4];
            if (BoatType.getName().equals(nameIn)) {
               return BoatType;
            }
         }

         return aModBoatEntity$BoatType[0];
      }

      public String getName() {
         return this.name;
      }

      public String toString() {
         return this.name;
      }
   }
}