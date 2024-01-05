package com.babcsany.minecraft.world.border;

import com.google.common.collect.Lists;
import com.mojang.serialization.DynamicLike;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Util;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class ModWorldBorder {
   private final List<IModBorderListener> listeners = Lists.newArrayList();
   private double damagePerBlock = 0.2D;
   private double damageBuffer = 5.0D;
   private int warningTime = 15;
   private int warningDistance = 5;
   private double centerX;
   private double centerZ;
   private int worldSize = 29999984;
   private IBorderInfo state = new StationaryBorderInfo(60000000);
   public static final Serializer field_235925_b_ = new Serializer(0.0D, 0.0D, 0.2D, 5.0D, 5, 15, 6.0E7D, 0L, 0.0D);

   public boolean contains(BlockPos pos) {
      return (double)(pos.getX() + 1) > this.minX() && (double)pos.getX() < this.maxX() && (double)(pos.getZ() + 1) > this.minZ() && (double)pos.getZ() < this.maxZ();
   }

   public boolean contains(ChunkPos range) {
      return (double)range.getXEnd() > this.minX() && (double)range.getXStart() < this.maxX() && (double)range.getZEnd() > this.minZ() && (double)range.getZStart() < this.maxZ();
   }

   public boolean contains(AxisAlignedBB bb) {
      return bb.maxX > this.minX() && bb.minX < this.maxX() && bb.maxZ > this.minZ() && bb.minZ < this.maxZ();
   }

   public double getClosestDistance(Entity entityIn) {
      return this.getClosestDistance(entityIn.getPosX(), entityIn.getPosZ());
   }

   public VoxelShape getShape() {
      return this.state.getShape();
   }

   public double getClosestDistance(double x, double z) {
      double d0 = z - this.minZ();
      double d1 = this.maxZ() - z;
      double d2 = x - this.minX();
      double d3 = this.maxX() - x;
      double d4 = Math.min(d2, d3);
      d4 = Math.min(d4, d0);
      return Math.min(d4, d1);
   }

   @OnlyIn(Dist.CLIENT)
   public ModBorderStatus getStatus() {
      return this.state.getStatus();
   }

   public double minX() {
      return this.state.getMinX();
   }

   public double minZ() {
      return this.state.getMinZ();
   }

   public double maxX() {
      return this.state.getMaxX();
   }

   public double maxZ() {
      return this.state.getMaxZ();
   }

   public double getCenterX() {
      return this.centerX;
   }

   public double getCenterZ() {
      return this.centerZ;
   }

   public void setCenter(double x, double z) {
      this.centerX = x;
      this.centerZ = z;
      this.state.onCenterChanged();

      for(IModBorderListener iModBorderListener : this.getListeners()) {
         iModBorderListener.onCenterChanged(this, x, z);
      }

   }

   public double getDiameter() {
      return this.state.getSize();
   }

   public long getTimeUntilTarget() {
      return this.state.getTimeUntilTarget();
   }

   public double getTargetSize() {
      return this.state.getTargetSize();
   }

   public void setTransition(double newSize) {
      this.state = new StationaryBorderInfo(newSize);

      for(IModBorderListener iModBorderListener : this.getListeners()) {
         iModBorderListener.onSizeChanged(this, newSize);
      }

   }

   public void setTransition(double oldSize, double newSize, long time) {
      this.state = oldSize == newSize ? new StationaryBorderInfo(newSize) : new MovingBorderInfo(oldSize, newSize, time);

      for(IModBorderListener iborderlistener : this.getListeners()) {
         iborderlistener.onTransitionStarted(this, oldSize, newSize, time);
      }

   }

   protected List<IModBorderListener> getListeners() {
      return Lists.newArrayList(this.listeners);
   }

   public void addListener(IModBorderListener listener) {
      this.listeners.add(listener);
   }

   public void removeListener(IModBorderListener listener) {
      this.listeners.remove(listener);
   }

   public void setSize(int size) {
      this.worldSize = size;
      this.state.onSizeChanged();
   }

   public int getSize() {
      return this.worldSize;
   }

   public double getDamageBuffer() {
      return this.damageBuffer;
   }

   public void setDamageBuffer(double bufferSize) {
      this.damageBuffer = bufferSize;

      for(IModBorderListener iborderlistener : this.getListeners()) {
         iborderlistener.onDamageBufferChanged(this, bufferSize);
      }

   }

   public double getDamagePerBlock() {
      return this.damagePerBlock;
   }

   public void setDamagePerBlock(double newAmount) {
      this.damagePerBlock = newAmount;

      for(IModBorderListener iborderlistener : this.getListeners()) {
         iborderlistener.onDamageAmountChanged(this, newAmount);
      }

   }

   @OnlyIn(Dist.CLIENT)
   public double getResizeSpeed() {
      return this.state.getResizeSpeed();
   }

   public int getWarningTime() {
      return this.warningTime;
   }

   public void setWarningTime(int warningTime) {
      this.warningTime = warningTime;

      for(IModBorderListener iborderlistener : this.getListeners()) {
         iborderlistener.onWarningTimeChanged(this, warningTime);
      }

   }

   public int getWarningDistance() {
      return this.warningDistance;
   }

   public void setWarningDistance(int warningDistance) {
      this.warningDistance = warningDistance;

      for(IModBorderListener iborderlistener : this.getListeners()) {
         iborderlistener.onWarningDistanceChanged(this, warningDistance);
      }

   }

   public void tick() {
      this.state = this.state.tick();
   }

   public Serializer getSerializer() {
      return new Serializer(this);
   }

   public void deserialize(Serializer serializer) {
      this.setCenter(serializer.getCenterX(), serializer.getCenterZ());
      this.setDamagePerBlock(serializer.getDamagePerBlock());
      this.setDamageBuffer(serializer.getDamageBuffer());
      this.setWarningDistance(serializer.getWarningDistance());
      this.setWarningTime(serializer.getWarningTime());
      if (serializer.getSizeLerpTime() > 0L) {
         this.setTransition(serializer.getSize(), serializer.getSizeLerpTarget(), serializer.getSizeLerpTime());
      } else {
         this.setTransition(serializer.getSize());
      }

   }

   interface IBorderInfo {
      double getMinX();

      double getMaxX();

      double getMinZ();

      double getMaxZ();

      double getSize();

      @OnlyIn(Dist.CLIENT)
      double getResizeSpeed();

      long getTimeUntilTarget();

      double getTargetSize();

      @OnlyIn(Dist.CLIENT)
      ModBorderStatus getStatus();

      void onSizeChanged();

      void onCenterChanged();

      IBorderInfo tick();

      VoxelShape getShape();
   }

   class MovingBorderInfo implements IBorderInfo {
      private final double oldSize;
      private final double newSize;
      private final long endTime;
      private final long startTime;
      private final double transitionTime;

      private MovingBorderInfo(double oldSize, double newSize, long transitionTime) {
         this.oldSize = oldSize;
         this.newSize = newSize;
         this.transitionTime = (double)transitionTime;
         this.startTime = Util.milliTime();
         this.endTime = this.startTime + transitionTime;
      }

      public double getMinX() {
         return Math.max(ModWorldBorder.this.getCenterX() - this.getSize() / 2.0D, -ModWorldBorder.this.worldSize);
      }

      public double getMinZ() {
         return Math.max(ModWorldBorder.this.getCenterZ() - this.getSize() / 2.0D, -ModWorldBorder.this.worldSize);
      }

      public double getMaxX() {
         return Math.min(ModWorldBorder.this.getCenterX() + this.getSize() / 2.0D, ModWorldBorder.this.worldSize);
      }

      public double getMaxZ() {
         return Math.min(ModWorldBorder.this.getCenterZ() + this.getSize() / 2.0D, ModWorldBorder.this.worldSize);
      }

      public double getSize() {
         double d0 = (double)(Util.milliTime() - this.startTime) / this.transitionTime;
         return d0 < 1.0D ? MathHelper.lerp(d0, this.oldSize, this.newSize) : this.newSize;
      }

      @OnlyIn(Dist.CLIENT)
      public double getResizeSpeed() {
         return Math.abs(this.oldSize - this.newSize) / (double)(this.endTime - this.startTime);
      }

      public long getTimeUntilTarget() {
         return this.endTime - Util.milliTime();
      }

      public double getTargetSize() {
         return this.newSize;
      }

      @OnlyIn(Dist.CLIENT)
      public ModBorderStatus getStatus() {
         return this.newSize < this.oldSize ? ModBorderStatus.SHRINKING : ModBorderStatus.GROWING;
      }

      public void onCenterChanged() {
      }

      public void onSizeChanged() {
      }

      public IBorderInfo tick() {
         return this.getTimeUntilTarget() <= 0L ? ModWorldBorder.this.new StationaryBorderInfo(this.newSize) : this;
      }

      public VoxelShape getShape() {
         return VoxelShapes.combineAndSimplify(VoxelShapes.INFINITY, VoxelShapes.create(Math.floor(this.getMinX()), Double.NEGATIVE_INFINITY, Math.floor(this.getMinZ()), Math.ceil(this.getMaxX()), Double.POSITIVE_INFINITY, Math.ceil(this.getMaxZ())), IBooleanFunction.ONLY_FIRST);
      }
   }

   public static class Serializer {
      private final double centerX;
      private final double centerZ;
      private final double damagePerBlock;
      private final double damageBuffer;
      private final int warningDistance;
      private final int warningTime;
      private final double size;
      private final long sizeLerpTime;
      private final double sizeLerpTarget;

      private Serializer(double centerX, double centerZ, double damagePerBlock, double damageBuffer, int warningDistance, int warningTime, double size, long sizeLerpTime, double sizeLerpTarget) {
         this.centerX = centerX;
         this.centerZ = centerZ;
         this.damagePerBlock = damagePerBlock;
         this.damageBuffer = damageBuffer;
         this.warningDistance = warningDistance;
         this.warningTime = warningTime;
         this.size = size;
         this.sizeLerpTime = sizeLerpTime;
         this.sizeLerpTarget = sizeLerpTarget;
      }

      private Serializer(ModWorldBorder border) {
         this.centerX = border.getCenterX();
         this.centerZ = border.getCenterZ();
         this.damagePerBlock = border.getDamagePerBlock();
         this.damageBuffer = border.getDamageBuffer();
         this.warningDistance = border.getWarningDistance();
         this.warningTime = border.getWarningTime();
         this.size = border.getDiameter();
         this.sizeLerpTime = border.getTimeUntilTarget();
         this.sizeLerpTarget = border.getTargetSize();
      }

      public double getCenterX() {
         return this.centerX;
      }

      public double getCenterZ() {
         return this.centerZ;
      }

      public double getDamagePerBlock() {
         return this.damagePerBlock;
      }

      public double getDamageBuffer() {
         return this.damageBuffer;
      }

      public int getWarningDistance() {
         return this.warningDistance;
      }

      public int getWarningTime() {
         return this.warningTime;
      }

      public double getSize() {
         return this.size;
      }

      public long getSizeLerpTime() {
         return this.sizeLerpTime;
      }

      public double getSizeLerpTarget() {
         return this.sizeLerpTarget;
      }

      public static Serializer func_235938_a_(DynamicLike<?> p_235938_0_, Serializer p_235938_1_) {
         double d0 = p_235938_0_.get("BorderCenterX").asDouble(p_235938_1_.centerX);
         double d1 = p_235938_0_.get("BorderCenterZ").asDouble(p_235938_1_.centerZ);
         double d2 = p_235938_0_.get("BorderSize").asDouble(p_235938_1_.size);
         long i = p_235938_0_.get("BorderSizeLerpTime").asLong(p_235938_1_.sizeLerpTime);
         double d3 = p_235938_0_.get("BorderSizeLerpTarget").asDouble(p_235938_1_.sizeLerpTarget);
         double d4 = p_235938_0_.get("BorderSafeZone").asDouble(p_235938_1_.damageBuffer);
         double d5 = p_235938_0_.get("BorderDamagePerBlock").asDouble(p_235938_1_.damagePerBlock);
         int j = p_235938_0_.get("BorderWarningBlocks").asInt(p_235938_1_.warningDistance);
         int k = p_235938_0_.get("BorderWarningTime").asInt(p_235938_1_.warningTime);
         return new Serializer(d0, d1, d5, d4, j, k, d2, i, d3);
      }

      public void func_235939_a_(CompoundNBT nbt) {
         nbt.putDouble("BorderCenterX", this.centerX);
         nbt.putDouble("BorderCenterZ", this.centerZ);
         nbt.putDouble("BorderSize", this.size);
         nbt.putLong("BorderSizeLerpTime", this.sizeLerpTime);
         nbt.putDouble("BorderSafeZone", this.damageBuffer);
         nbt.putDouble("BorderDamagePerBlock", this.damagePerBlock);
         nbt.putDouble("BorderSizeLerpTarget", this.sizeLerpTarget);
         nbt.putDouble("BorderWarningBlocks", (double)this.warningDistance);
         nbt.putDouble("BorderWarningTime", (double)this.warningTime);
      }
   }

   class StationaryBorderInfo implements IBorderInfo {
      private final double size;
      private double minX;
      private double minZ;
      private double maxX;
      private double maxZ;
      private VoxelShape shape;

      public StationaryBorderInfo(double p_i49837_2_) {
         this.size = p_i49837_2_;
         this.updateBox();
      }

      public double getMinX() {
         return this.minX;
      }

      public double getMaxX() {
         return this.maxX;
      }

      public double getMinZ() {
         return this.minZ;
      }

      public double getMaxZ() {
         return this.maxZ;
      }

      public double getSize() {
         return this.size;
      }

      @OnlyIn(Dist.CLIENT)
      public ModBorderStatus getStatus() {
         return ModBorderStatus.STATIONARY;
      }

      @OnlyIn(Dist.CLIENT)
      public double getResizeSpeed() {
         return 0.0D;
      }

      public long getTimeUntilTarget() {
         return 0L;
      }

      public double getTargetSize() {
         return this.size;
      }

      private void updateBox() {
         this.minX = Math.max(ModWorldBorder.this.getCenterX() - this.size / 2.0D, -ModWorldBorder.this.worldSize);
         this.minZ = Math.max(ModWorldBorder.this.getCenterZ() - this.size / 2.0D, -ModWorldBorder.this.worldSize);
         this.maxX = Math.min(ModWorldBorder.this.getCenterX() + this.size / 2.0D, ModWorldBorder.this.worldSize);
         this.maxZ = Math.min(ModWorldBorder.this.getCenterZ() + this.size / 2.0D, ModWorldBorder.this.worldSize);
         this.shape = VoxelShapes.combineAndSimplify(VoxelShapes.INFINITY, VoxelShapes.create(Math.floor(this.getMinX()), Double.NEGATIVE_INFINITY, Math.floor(this.getMinZ()), Math.ceil(this.getMaxX()), Double.POSITIVE_INFINITY, Math.ceil(this.getMaxZ())), IBooleanFunction.ONLY_FIRST);
      }

      public void onSizeChanged() {
         this.updateBox();
      }

      public void onCenterChanged() {
         this.updateBox();
      }

      public IBorderInfo tick() {
         return this;
      }

      public VoxelShape getShape() {
         return this.shape;
      }
   }
}
