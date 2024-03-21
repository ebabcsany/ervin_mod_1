package com.babcsany.minecraft.ervin_mod_1.client.entity.render;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.HuihkEntity;
import net.minecraft.item.FishingRodItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.HandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Matrix3f;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HuihkRender extends EntityRenderer<HuihkEntity> {
   private static final ResourceLocation HUIHK = new ResourceLocation(Ervin_mod_1.MOD_ID,"textures/entity/hook/huihk.png");
   private static final RenderType field_229103_e_;

   public HuihkRender(EntityRendererManager p_i46175_1_) {
      super(p_i46175_1_);
   }

   public void render(HuihkEntity p_225623_1_, float p_225623_2_, float p_225623_3_, MatrixStack p_225623_4_, IRenderTypeBuffer p_225623_5_, int p_225623_6_) {
      PlayerEntity playerentity = p_225623_1_.func_234606_i_();
      if (playerentity != null) {
         p_225623_4_.push();
         p_225623_4_.push();
         p_225623_4_.scale(0.5F, 0.5F, 0.5F);
         p_225623_4_.rotate(this.renderManager.getCameraOrientation());
         p_225623_4_.rotate(Vector3f.YP.rotationDegrees(180.0F));
         MatrixStack.Entry matrixstack$entry = p_225623_4_.getLast();
         Matrix4f matrix4f = matrixstack$entry.getMatrix();
         Matrix3f matrix3f = matrixstack$entry.getNormal();
         IVertexBuilder ivertexbuilder = p_225623_5_.getBuffer(field_229103_e_);
         func_229106_a_(ivertexbuilder, matrix4f, matrix3f, p_225623_6_, 0.0F, 0, 0, 1);
         func_229106_a_(ivertexbuilder, matrix4f, matrix3f, p_225623_6_, 1.0F, 0, 1, 1);
         func_229106_a_(ivertexbuilder, matrix4f, matrix3f, p_225623_6_, 1.0F, 1, 1, 0);
         func_229106_a_(ivertexbuilder, matrix4f, matrix3f, p_225623_6_, 0.0F, 1, 0, 0);
         p_225623_4_.pop();
         int i = playerentity.getPrimaryHand() == HandSide.RIGHT ? 1 : -1;
         ItemStack itemstack = playerentity.getHeldItemMainhand();
         if (!(itemstack.getItem() instanceof FishingRodItem)) {
            i = -i;
         }

         float f = playerentity.getSwingProgress(p_225623_3_);
         float f1 = MathHelper.sin(MathHelper.sqrt(f) * 3.1415927F);
         float f2 = MathHelper.lerp(p_225623_3_, playerentity.prevRenderYawOffset, playerentity.renderYawOffset) * 0.017453292F;
         double d0 = (double)MathHelper.sin(f2);
         double d1 = (double)MathHelper.cos(f2);
         double d2 = (double)i * 0.35;
         double d3 = 0.8;
         double d4;
         double d5;
         double d6;
         float f3;
         double d9;
         if ((this.renderManager.options == null || this.renderManager.options.getPointOfView().func_243192_a()) && playerentity == Minecraft.getInstance().player) {
            d9 = this.renderManager.options.fov;
            d9 /= 100.0;
            Vector3d vector3d = new Vector3d((double)i * -0.36 * d9, -0.045 * d9, 0.4);
            vector3d = vector3d.rotatePitch(-MathHelper.lerp(p_225623_3_, playerentity.prevRotationPitch, playerentity.rotationPitch) * 0.017453292F);
            vector3d = vector3d.rotateYaw(-MathHelper.lerp(p_225623_3_, playerentity.prevRotationYaw, playerentity.rotationYaw) * 0.017453292F);
            vector3d = vector3d.rotateYaw(f1 * 0.5F);
            vector3d = vector3d.rotatePitch(-f1 * 0.7F);
            d4 = MathHelper.lerp((double)p_225623_3_, playerentity.prevPosX, playerentity.getPosX()) + vector3d.x;
            d5 = MathHelper.lerp((double)p_225623_3_, playerentity.prevPosY, playerentity.getPosY()) + vector3d.y;
            d6 = MathHelper.lerp((double)p_225623_3_, playerentity.prevPosZ, playerentity.getPosZ()) + vector3d.z;
            f3 = playerentity.getEyeHeight();
         } else {
            d4 = MathHelper.lerp((double)p_225623_3_, playerentity.prevPosX, playerentity.getPosX()) - d1 * d2 - d0 * 0.8;
            d5 = playerentity.prevPosY + (double)playerentity.getEyeHeight() + (playerentity.getPosY() - playerentity.prevPosY) * (double)p_225623_3_ - 0.45;
            d6 = MathHelper.lerp((double)p_225623_3_, playerentity.prevPosZ, playerentity.getPosZ()) - d0 * d2 + d1 * 0.8;
            f3 = playerentity.isCrouching() ? -0.1875F : 0.0F;
         }

         d9 = MathHelper.lerp((double)p_225623_3_, p_225623_1_.prevPosX, p_225623_1_.getPosX());
         double d10 = MathHelper.lerp((double)p_225623_3_, p_225623_1_.prevPosY, p_225623_1_.getPosY()) + 0.25;
         double d8 = MathHelper.lerp((double)p_225623_3_, p_225623_1_.prevPosZ, p_225623_1_.getPosZ());
         float f4 = (float)(d4 - d9);
         float f5 = (float)(d5 - d10) + f3;
         float f6 = (float)(d6 - d8);
         IVertexBuilder ivertexbuilder1 = p_225623_5_.getBuffer(RenderType.getLines());
         Matrix4f matrix4f1 = p_225623_4_.getLast().getMatrix();
         int j = 1;

         for(int k = 0; k < 16; ++k) {
            func_229104_a_(f4, f5, f6, ivertexbuilder1, matrix4f1, func_229105_a_(k, 16));
            func_229104_a_(f4, f5, f6, ivertexbuilder1, matrix4f1, func_229105_a_(k + 1, 16));
         }

         p_225623_4_.pop();
         super.render(p_225623_1_, p_225623_2_, p_225623_3_, p_225623_4_, p_225623_5_, p_225623_6_);
      }

   }

   private static float func_229105_a_(int p_229105_0_, int p_229105_1_) {
      return (float)p_229105_0_ / (float)p_229105_1_;
   }

   private static void func_229106_a_(IVertexBuilder p_229106_0_, Matrix4f p_229106_1_, Matrix3f p_229106_2_, int p_229106_3_, float p_229106_4_, int p_229106_5_, int p_229106_6_, int p_229106_7_) {
      p_229106_0_.pos(p_229106_1_, p_229106_4_ - 0.5F, (float)p_229106_5_ - 0.5F, 0.0F).color(255, 255, 255, 255).tex((float)p_229106_6_, (float)p_229106_7_).overlay(OverlayTexture.NO_OVERLAY).lightmap(p_229106_3_).normal(p_229106_2_, 0.0F, 1.0F, 0.0F).endVertex();
   }

   private static void func_229104_a_(float p_229104_0_, float p_229104_1_, float p_229104_2_, IVertexBuilder p_229104_3_, Matrix4f p_229104_4_, float p_229104_5_) {
      p_229104_3_.pos(p_229104_4_, p_229104_0_ * p_229104_5_, p_229104_1_ * (p_229104_5_ * p_229104_5_ + p_229104_5_) * 0.5F + 0.25F, p_229104_2_ * p_229104_5_).color(0, 0, 0, 255).endVertex();
   }

   public ResourceLocation getEntityTexture(HuihkEntity p_110775_1_) {
      return HUIHK;
   }

   static {
      field_229103_e_ = RenderType.getEntityCutout(HUIHK);
   }
}