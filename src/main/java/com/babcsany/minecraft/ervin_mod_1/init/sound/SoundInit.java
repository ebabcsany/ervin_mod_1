package com.babcsany.minecraft.ervin_mod_1.init.sound;

import net.minecraft.block.SoundType;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class SoundInit {
   public static final SoundInit AMBIENT_BASALT_NETHER_ADDITIONS = new SoundInit(1.0F, 1.0F, SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS, SoundEvents.AMBIENT_NETHER_WASTES_ADDITIONS, SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, SoundEvents.AMBIENT_WARPED_FOREST_ADDITIONS);
   public static final SoundInit WOOD = new SoundInit(1.0F, 1.0F, SoundEvents.BLOCK_WOOD_BREAK, SoundEvents.BLOCK_WOOD_STEP, SoundEvents.BLOCK_WOOD_PLACE, SoundEvents.BLOCK_WOOD_HIT, SoundEvents.BLOCK_WOOD_FALL);
   public final float volume;
   public final float pitch;
   private final SoundEvent breakSound;
   private final SoundEvent stepSound;
   private final SoundEvent placeSound;
   private final SoundEvent hitSound;
   private final SoundEvent fallSound;

   public SoundInit(float volumeIn, float pitchIn, SoundEvent breakSoundIn, SoundEvent stepSoundIn, SoundEvent placeSoundIn, SoundEvent hitSoundIn, SoundEvent fallSoundIn) {
      this.volume = volumeIn;
      this.pitch = pitchIn;
      this.breakSound = breakSoundIn;
      this.stepSound = stepSoundIn;
      this.placeSound = placeSoundIn;
      this.hitSound = hitSoundIn;
      this.fallSound = fallSoundIn;
   }

   public float getVolume() {
      return this.volume;
   }

   public float getPitch() {
      return this.pitch;
   }

   public SoundEvent getBreakSound() {
      return this.breakSound;
   }

   public SoundEvent getStepSound() {
      return this.stepSound;
   }

   public SoundEvent getPlaceSound() {
      return this.placeSound;
   }

   public SoundEvent getHitSound() {
      return this.hitSound;
   }

   public SoundEvent getFallSound() {
      return this.fallSound;
   }
}