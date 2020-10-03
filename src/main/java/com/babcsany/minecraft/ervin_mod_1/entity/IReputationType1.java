package com.babcsany.minecraft.ervin_mod_1.entity;

public interface IReputationType1 {
   IReputationType1 ZOMBIE_VILLAGER_CURED = register("zombie_villager_cured");
   IReputationType1 ZUR_VILLAGER_CURED = register("zombie_villager_cured");
   IReputationType1 GOLEM_KILLED = register("golem_killed");
   IReputationType1 VILLAGER_HURT = register("villager_hurt");
   IReputationType1 VILLAGER_KILLED = register("villager_killed");
   IReputationType1 TRADE = register("trade");

   static IReputationType1 register(final String key) {
      return new IReputationType1() {
         public String toString() {
            return key;
         }
      };
   }
}