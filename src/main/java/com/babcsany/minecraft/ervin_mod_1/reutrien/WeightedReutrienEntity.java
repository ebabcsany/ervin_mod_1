package com.babcsany.minecraft.ervin_mod_1.reutrien;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedRandom;

public class WeightedReutrienEntity extends WeightedRandom.Item {
   private final CompoundNBT nbt;

   public WeightedReutrienEntity() {
      super(1);
      this.nbt = new CompoundNBT();
      this.nbt.putString("id", "minecraft:lightning_bolt");
   }

   public WeightedReutrienEntity(CompoundNBT nbtIn) {
      this(nbtIn.contains("Weight", 99) ? nbtIn.getInt("Weight") : 1, nbtIn.getCompound("Entity"));
   }

   public WeightedReutrienEntity(int itemWeightIn, CompoundNBT nbtIn) {
      super(itemWeightIn);
      this.nbt = nbtIn;
      ResourceLocation resourcelocation = ResourceLocation.tryCreate(nbtIn.getString("id"));
      if (resourcelocation != null) {
         nbtIn.putString("id", resourcelocation.toString());
      } else {
         nbtIn.putString("id", "minecraft:lightning_bolt");
      }

   }

   public CompoundNBT toCompoundTag() {
      CompoundNBT compoundnbt = new CompoundNBT();
      compoundnbt.put("Entity", this.nbt);
      compoundnbt.putInt("Weight", this.itemWeight);
      return compoundnbt;
   }

   public CompoundNBT getNbt() {
      return this.nbt;
   }
}
