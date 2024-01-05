package com.babcsany.minecraft.world.border;

public interface IModBorderListener {
   void onSizeChanged(ModWorldBorder border, double newSize);

   void onTransitionStarted(ModWorldBorder border, double oldSize, double newSize, long time);

   void onCenterChanged(ModWorldBorder border, double x, double z);

   void onWarningTimeChanged(ModWorldBorder border, int newTime);

   void onWarningDistanceChanged(ModWorldBorder border, int newDistance);

   void onDamageAmountChanged(ModWorldBorder border, double newAmount);

   void onDamageBufferChanged(ModWorldBorder border, double newSize);

   class Impl implements IModBorderListener {
      private final ModWorldBorder worldBorder;

      public Impl(ModWorldBorder border) {
         this.worldBorder = border;
      }

      public void onSizeChanged(ModWorldBorder border, double newSize) {
         this.worldBorder.setTransition(newSize);
      }

      public void onTransitionStarted(ModWorldBorder border, double oldSize, double newSize, long time) {
         this.worldBorder.setTransition(oldSize, newSize, time);
      }

      public void onCenterChanged(ModWorldBorder border, double x, double z) {
         this.worldBorder.setCenter(x, z);
      }

      public void onWarningTimeChanged(ModWorldBorder border, int newTime) {
         this.worldBorder.setWarningTime(newTime);
      }

      public void onWarningDistanceChanged(ModWorldBorder border, int newDistance) {
         this.worldBorder.setWarningDistance(newDistance);
      }

      public void onDamageAmountChanged(ModWorldBorder border, double newAmount) {
         this.worldBorder.setDamagePerBlock(newAmount);
      }

      public void onDamageBufferChanged(ModWorldBorder border, double newSize) {
         this.worldBorder.setDamageBuffer(newSize);
      }
   }
}
