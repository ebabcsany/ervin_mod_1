package com.babcsany.minecraft.ervin_mod_1.entity.merchant;

public interface IReputationType {
   IReputationType ZUR_NIRTRE_CURED = register("zur_nirtre_cured");
   IReputationType TRADE = register("trade");

   static IReputationType register(final String key) {
      return new IReputationType() {
         public String toString() {
            return key;
         }
      };
   }
}