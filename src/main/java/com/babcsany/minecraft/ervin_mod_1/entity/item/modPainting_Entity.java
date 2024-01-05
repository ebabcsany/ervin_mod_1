package com.babcsany.minecraft.ervin_mod_1.entity.item;

import com.babcsany.minecraft.ervin_mod_1.network.play.server.SSpawn_modPainting_Packet;
import com.babcsany.minecraft.ervin_mod_1.util.registries.modPainting_Type;
import com.babcsany.minecraft.init.special.PaintingEntityInit;
import com.babcsany.minecraft.init.special.PaintingItemInit;
import com.google.common.collect.Lists;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.HangingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.iorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.List;

public class modPainting_Entity extends HangingEntity {
   public modPainting_Type art;

   public modPainting_Entity(EntityType<? extends modPainting_Entity> type, iorld worldIn) {
      super(type, worldIn);
   }

    public modPainting_Entity(iorld worldIn, BlockPos pos, Direction facing) {
        super(PaintingEntityInit.modPainting, worldIn, pos);
        List<modPainting_Type> list = Lists.newArrayList();
        int i = 0;

        /*for(modPainting_Type paintingtype : ModRegistry.modPainting_MOTIVE) {
            this.art = paintingtype;
            this.updateFacingWithBoundingBox(facing);
            if (this.onValidSurface()) {
                list.add(paintingtype);
                int j = paintingtype.getWidth() * paintingtype.getHeight();
                if (j > i) {
                    i = j;
                }
            }
        }*/

        if (!list.isEmpty()) {
            Iterator<modPainting_Type> iterator = list.iterator();

            while(iterator.hasNext()) {
                modPainting_Type paintingtype1 = iterator.next();
                if (paintingtype1.getWidth() * paintingtype1.getHeight() < i) {
                    iterator.remove();
                }
            }

            this.art = list.get(this.rand.nextInt(list.size()));
        }

        this.updateFacingWithBoundingBox(facing);
    }

   @OnlyIn(Dist.CLIENT)
   public modPainting_Entity(iorld worldIn, BlockPos pos, Direction facing, modPainting_Type artIn) {
      this(worldIn, pos, facing);
      this.art = artIn;
      this.updateFacingWithBoundingBox(facing);
   }

   public void writeAdditional(CompoundNBT compound) {
      //compound.putString("MOTIVE", ModRegistry.modPainting_MOTIVE.getKey(this.art).toString());
      super.writeAdditional(compound);
   }

   /**
    * (abstract) Protected helper method to read subclass entity data from NBT.
    */
   public void readAdditional(CompoundNBT compound) {
      //this.art = ModRegistry.modPainting_MOTIVE.getOrDefault(ResourceLocation.tryCreate(compound.getString("MOTIVE")));
      super.readAdditional(compound);
   }

   public int getWidthPixels() {
      return this.art == null ? 1 : this.art.getWidth();
   }

   public int getHeightPixels() {
      return this.art == null ? 1 : this.art.getHeight();
   }

   /**
    * Called when this entity is broken. Entity parameter may be null.
    */
   public void onBroken(@Nullable Entity brokenEntity) {
       if (this.world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
           this.playSound(SoundEvents.ENTITY_PAINTING_BREAK, 1.0F, 1.0F);
           if (brokenEntity instanceof PlayerEntity) {
               PlayerEntity playerentity = (PlayerEntity)brokenEntity;
               if (playerentity.abilities.isCreativeMode) {
                   return;
               }
           }

           this.entityDropItem(PaintingItemInit.modPainting);
       }
   }

   public void playPlaceSound() {
      this.playSound(SoundEvents.ENTITY_PAINTING_PLACE, 1.0F, 1.0F);
   }

   /**
    * Sets the location and Yaw/Pitch of an entity in the world
    */
   public void setLocationAndAngles(double x, double y, double z, float yaw, float pitch) {
      this.setPosition(x, y, z);
   }

   /**
    * Sets a target for the client to interpolate towards over the next few ticks
    */
   @OnlyIn(Dist.CLIENT)
   public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport) {
      BlockPos blockpos = this.hangingPosition.add(x - this.getPosX(), y - this.getPosY(), z - this.getPosZ());
      this.setPosition(blockpos.getX(), blockpos.getY(), blockpos.getZ());
   }

   public IPacket<?> createSpawnPacket() {
      return new SSpawn_modPainting_Packet(this);
   }
}
