package com.babcsany.minecraft.client.particle;

import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ItemParticleData;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BreakingParticle extends SpriteTexturedParticle {
   private final float field_217571_C;
   private final float field_217572_F;

   private BreakingParticle(ClientWorld p_i232346_1_, double p_i232346_2_, double p_i232346_4_, double p_i232346_6_, double p_i232346_8_, double p_i232346_10_, double p_i232346_12_, ItemStack p_i232346_14_) {
      this(p_i232346_1_, p_i232346_2_, p_i232346_4_, p_i232346_6_, p_i232346_14_);
      this.motionX *= 0.1F;
      this.motionY *= 0.1F;
      this.motionZ *= 0.1F;
      this.motionX += p_i232346_8_;
      this.motionY += p_i232346_10_;
      this.motionZ += p_i232346_12_;
   }

   public IParticleRenderType getRenderType() {
      return IParticleRenderType.TERRAIN_SHEET;
   }

   protected BreakingParticle(ClientWorld p_i232348_1_, double p_i232348_2_, double p_i232348_4_, double p_i232348_6_, ItemStack p_i232348_8_) {
      super(p_i232348_1_, p_i232348_2_, p_i232348_4_, p_i232348_6_, 0.0D, 0.0D, 0.0D);
      this.setSprite(Minecraft.getInstance().getItemRenderer().getItemModelWithOverrides(p_i232348_8_, p_i232348_1_, null).getParticleTexture());
      this.particleGravity = 1.0F;
      this.particleScale /= 2.0F;
      this.field_217571_C = this.rand.nextFloat() * 3.0F;
      this.field_217572_F = this.rand.nextFloat() * 3.0F;
   }

   protected float getMinU() {
      return this.sprite.getInterpolatedU((this.field_217571_C + 1.0F) / 4.0F * 16.0F);
   }

   protected float getMaxU() {
      return this.sprite.getInterpolatedU(this.field_217571_C / 4.0F * 16.0F);
   }

   protected float getMinV() {
      return this.sprite.getInterpolatedV(this.field_217572_F / 4.0F * 16.0F);
   }

   protected float getMaxV() {
      return this.sprite.getInterpolatedV((this.field_217572_F + 1.0F) / 4.0F * 16.0F);
   }

   @OnlyIn(Dist.CLIENT)
   public static class FreinFactory implements IParticleFactory<BasicParticleType> {
      public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         return new BreakingParticle(worldIn, x, y, z, new ItemStack(ItemInit.FREIN_BALL.get()));
      }
   }

   @OnlyIn(Dist.CLIENT)
   public static class FreinFactory1 implements IParticleFactory<BasicParticleType> {
      public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         return new BreakingParticle(worldIn, x, y, z, new ItemStack(ItemInit.FREIN_BALL.get()));
      }
   }
}
