package com.babcsany.minecraft.ervin_mod_1.entity.villager;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.villager.IVillagerType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class NirtreData {
   /*private static final int[] LEVEL_EXPERIENCE_AMOUNTS = new int[]{0, 10, 70, 150, 250};
   public static final Codec<NirtreData> NIRTRE_DATA_CODEC = RecordCodecBuilder.create((dataInstance) -> {
      return dataInstance.group(Registry.NIRTRE_TYPE.fieldOf("type").withDefault(() -> {
         return INirtreType.DESERT;
      }).forGetter((data) -> {
         return data.type;
      }), Registry.NIRTRE_PROFESSION.fieldOf("nirtre_profession").withDefault(() -> {
         return NirtreProfession.NONE;
      }).forGetter((data) -> {
         return data.nirtreProfession;
      }), Codec.INT.fieldOf("level").withDefault(1).forGetter((data) -> {
         return data.level;
      })).apply(dataInstance, NirtreData::new);
   });
   private final INirtreType type;
   private final NirtreProfession nirtreProfession;
   private final int level;

   public NirtreData(INirtreType type, NirtreProfession profession, int level) {
      this.type = type;
      this.nirtreProfession = profession;
      this.level = Math.max(1, level);
   }

   public INirtreType getType() {
      return this.type;
   }

   public NirtreProfession getProfession() {
      return this.nirtreProfession;
   }

   public int getLevel() {
      return this.level;
   }

   public NirtreData withType(INirtreType typeIn) {
      return new NirtreData(typeIn, this.nirtreProfession, this.level);
   }

   public NirtreData withProfession(NirtreProfession professionIn) {
      return new NirtreData(this.type, professionIn, this.level);
   }

   public NirtreData withLevel(int levelIn) {
      return new NirtreData(this.type, this.nirtreProfession, levelIn);
   }

   @OnlyIn(Dist.CLIENT)
   public static int func_221133_b(int p_221133_0_) {
      return canLevelUp(p_221133_0_) ? LEVEL_EXPERIENCE_AMOUNTS[p_221133_0_ - 1] : 0;
   }

   public static int func_221127_c(int p_221127_0_) {
      return canLevelUp(p_221127_0_) ? LEVEL_EXPERIENCE_AMOUNTS[p_221127_0_] : 0;
   }

   public static boolean canLevelUp(int level) {
      return level >= 1 && level < 5;
   }*/
}