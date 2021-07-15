package com.babcsany.minecraft.client.particle;

import com.babcsany.minecraft.init.FluidInit;
import com.babcsany.minecraft.init.ParticleInit;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DripParticle extends SpriteTexturedParticle {
   private final Fluid fluid;
   protected boolean field_239177_a_;

   private DripParticle(ClientWorld p_i232361_1_, double p_i232361_2_, double p_i232361_4_, double p_i232361_6_, Fluid p_i232361_8_) {
      super(p_i232361_1_, p_i232361_2_, p_i232361_4_, p_i232361_6_);
      this.setSize(0.01F, 0.01F);
      this.particleGravity = 0.06F;
      this.fluid = p_i232361_8_;
   }

   public IParticleRenderType getRenderType() {
      return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
   }

   public int getBrightnessForRender(float partialTick) {
      return this.field_239177_a_ ? 240 : super.getBrightnessForRender(partialTick);
   }

   public void tick() {
      this.prevPosX = this.posX;
      this.prevPosY = this.posY;
      this.prevPosZ = this.posZ;
      this.func_217576_g();
      if (!this.isExpired) {
         this.motionY -= (double)this.particleGravity;
         this.move(this.motionX, this.motionY, this.motionZ);
         this.func_217577_h();
         if (!this.isExpired) {
            this.motionX *= (double)0.98F;
            this.motionY *= (double)0.98F;
            this.motionZ *= (double)0.98F;
            BlockPos blockpos = new BlockPos(this.posX, this.posY, this.posZ);
            FluidState fluidstate = this.world.getFluidState(blockpos);
            if (fluidstate.getFluid() == this.fluid && this.posY < (double)((float)blockpos.getY() + fluidstate.getActualHeight(this.world, blockpos))) {
               this.setExpired();
            }

         }
      }
   }

   protected void func_217576_g() {
      if (this.maxAge-- <= 0) {
         this.setExpired();
      }

   }

   protected void func_217577_h() {
   }

   @OnlyIn(Dist.CLIENT)
   static class Dripping extends DripParticle {
      private final IParticleData field_217579_C;

      private Dripping(ClientWorld p_i232365_1_, double p_i232365_2_, double p_i232365_4_, double p_i232365_6_, Fluid p_i232365_8_, IParticleData p_i232365_9_) {
         super(p_i232365_1_, p_i232365_2_, p_i232365_4_, p_i232365_6_, p_i232365_8_);
         this.field_217579_C = p_i232365_9_;
         this.particleGravity *= 0.02F;
         this.maxAge = 40;
      }

      protected void func_217576_g() {
         if (this.maxAge-- <= 0) {
            this.setExpired();
            this.world.addParticle(this.field_217579_C, this.posX, this.posY, this.posZ, this.motionX, this.motionY, this.motionZ);
         }

      }

      protected void func_217577_h() {
         this.motionX *= 0.02D;
         this.motionY *= 0.02D;
         this.motionZ *= 0.02D;
      }
   }

   @OnlyIn(Dist.CLIENT)
   static class DrippingJurk extends Dripping {
      private DrippingJurk(ClientWorld p_i232363_1_, double p_i232363_2_, double p_i232363_4_, double p_i232363_6_, Fluid p_i232363_8_, IParticleData p_i232363_9_) {
         super(p_i232363_1_, p_i232363_2_, p_i232363_4_, p_i232363_6_, p_i232363_8_, p_i232363_9_);
      }

      protected void func_217576_g() {
         this.particleRed = 4.0F;
         this.particleGreen = 16.0F / (float)(40 - this.maxAge + 16);
         this.particleBlue = 1.0F / (float)(40 - this.maxAge + 8);
         super.func_217576_g();
      }
   }

   @OnlyIn(Dist.CLIENT)
   public static class DrippingJurkFactory implements IParticleFactory<BasicParticleType> {
      protected final IAnimatedSprite spriteSet;

      public DrippingJurkFactory(IAnimatedSprite animatedSprite) {
         this.spriteSet = animatedSprite;
      }

      public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         DrippingJurk dripParticle$drippingJurk = new DrippingJurk(worldIn, x, y, z, FluidInit.JURK, ParticleTypes.FALLING_WATER);
         dripParticle$drippingJurk.selectSpriteRandomly(this.spriteSet);
         return dripParticle$drippingJurk;
      }
   }

   @OnlyIn(Dist.CLIENT)
   public static class FallingJurkFactory implements IParticleFactory<BasicParticleType> {
      protected final IAnimatedSprite spriteSet;

      public FallingJurkFactory(IAnimatedSprite p_i50506_1_) {
         this.spriteSet = p_i50506_1_;
      }

      public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         DripParticle dripparticle = new FallingLiquidParticle(worldIn, x, y, z, FluidInit.JURK, ParticleTypes.LANDING_OBSIDIAN_TEAR);
         dripparticle.setColor(4.0F, 0.2857143F, 0.083333336F);
         dripparticle.selectSpriteRandomly(this.spriteSet);
         return dripparticle;
      }
   }

   @OnlyIn(Dist.CLIENT)
   public static class LandingJurkFactory implements IParticleFactory<BasicParticleType> {
      protected final IAnimatedSprite spriteSet;

      public LandingJurkFactory(IAnimatedSprite p_i50504_1_) {
         this.spriteSet = p_i50504_1_;
      }

      public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
         DripParticle dripparticle = new Landing(worldIn, x, y, z, FluidInit.JURK);
         dripparticle.setColor(4.0F, 0.2857143F, 0.083333336F);
         dripparticle.selectSpriteRandomly(this.spriteSet);
         return dripparticle;
      }
   }

   @OnlyIn(Dist.CLIENT)
   static class Landing extends DripParticle {
      private Landing(ClientWorld p_i232367_1_, double p_i232367_2_, double p_i232367_4_, double p_i232367_6_, Fluid p_i232367_8_) {
         super(p_i232367_1_, p_i232367_2_, p_i232367_4_, p_i232367_6_, p_i232367_8_);
         this.maxAge = (int)(16.0D / (Math.random() * 0.8D + 0.2D));
      }
   }

   @OnlyIn(Dist.CLIENT)
   static class FallingLiquidParticle extends FallingNectarParticle {
      protected final IParticleData field_228335_a_;

      private FallingLiquidParticle(ClientWorld p_i232369_1_, double p_i232369_2_, double p_i232369_4_, double p_i232369_6_, Fluid p_i232369_8_, IParticleData p_i232369_9_) {
         super(p_i232369_1_, p_i232369_2_, p_i232369_4_, p_i232369_6_, p_i232369_8_);
         this.field_228335_a_ = p_i232369_9_;
      }

      protected void func_217577_h() {
         if (this.onGround) {
            this.setExpired();
            this.world.addParticle(this.field_228335_a_, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
         }

      }
   }

   @OnlyIn(Dist.CLIENT)
   static class FallingNectarParticle extends DripParticle {
      private FallingNectarParticle(ClientWorld p_i232371_1_, double p_i232371_2_, double p_i232371_4_, double p_i232371_6_, Fluid p_i232371_8_) {
         super(p_i232371_1_, p_i232371_2_, p_i232371_4_, p_i232371_6_, p_i232371_8_);
         this.maxAge = (int)(64.0D / (Math.random() * 0.8D + 0.2D));
      }

      protected void func_217577_h() {
         if (this.onGround) {
            this.setExpired();
         }

      }
   }
}
