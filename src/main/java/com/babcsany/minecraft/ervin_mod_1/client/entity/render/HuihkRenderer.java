package com.babcsany.minecraft.ervin_mod_1.client.entity.render;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.client.renderer.entity.ModEntityRendererManager;
import com.babcsany.minecraft.ervin_mod_1.entity.projectile.Huihk;
import com.babcsany.minecraft.ervin_mod_1.item.HuihkRodItem;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.player.PlayerEntity;
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
public class HuihkRenderer extends EntityRenderer<Huihk> {
   private static final ResourceLocation HUIHK = new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/hook/huihk.png");
   private static final RenderType CUTOUT = RenderType.getEntityCutout(HUIHK);
   protected final ModEntityRendererManager modEntityRendererManager;

   public HuihkRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn);
      this.modEntityRendererManager = (ModEntityRendererManager) renderManagerIn;
   }

   @Override
   public void render(Huihk entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
      PlayerEntity playerentity = entityIn.getPlayer();
      if (playerentity != null) {
         EntityRendererManager manager = this.renderManager;
         matrixStackIn.push();
         matrixStackIn.push();
         matrixStackIn.scale(0.5F, 0.5F, 0.5F);
         matrixStackIn.rotate(manager.getCameraOrientation());
         matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180.0F));
         MatrixStack.Entry matrixstack$entry = matrixStackIn.getLast();
         Matrix4f matrix4f = matrixstack$entry.getMatrix();
         Matrix3f matrix3f = matrixstack$entry.getNormal();
         IVertexBuilder ivertexbuilder = bufferIn.getBuffer(CUTOUT);
         func_229106_a_(ivertexbuilder, matrix4f, matrix3f, packedLightIn, 0.0F, 0, 0, 1);
         func_229106_a_(ivertexbuilder, matrix4f, matrix3f, packedLightIn, 1.0F, 0, 1, 1);
         func_229106_a_(ivertexbuilder, matrix4f, matrix3f, packedLightIn, 1.0F, 1, 1, 0);
         func_229106_a_(ivertexbuilder, matrix4f, matrix3f, packedLightIn, 0.0F, 1, 0, 0);
         matrixStackIn.pop();
         int i = playerentity.getPrimaryHand() == HandSide.RIGHT ? 1 : -1;
         ItemStack itemstack = playerentity.getHeldItemMainhand();
         if (!(itemstack.getItem() instanceof HuihkRodItem)) {
            i = -i;
         }

         float f = playerentity.getSwingProgress(partialTicks);
         float f1 = MathHelper.sin(MathHelper.sqrt(f) * (float)Math.PI);
         float f2 = MathHelper.lerp(partialTicks, playerentity.prevRenderYawOffset, playerentity.renderYawOffset) * ((float)Math.PI / 180F);
         double d0 = (double)MathHelper.sin(f2);
         double d1 = (double)MathHelper.cos(f2);
         double d2 = (double)i * 0.35D;
         double d3 = 0.8D;
         double d4;
         double d5;
         double d6;
         float f3;
         if ((manager.options == null || manager.options.getPointOfView().func_243192_a()) && playerentity == Minecraft.getInstance().player) {
            double d7 = manager.options.fov;
            d7 = d7 / 100.0D;
            Vector3d vector3d = new Vector3d((double)i * -0.36D * d7, -0.045D * d7, 0.4D);
            vector3d = vector3d.rotatePitch(-MathHelper.lerp(partialTicks, playerentity.prevRotationPitch, playerentity.rotationPitch) * ((float)Math.PI / 180F));
            vector3d = vector3d.rotateYaw(-MathHelper.lerp(partialTicks, playerentity.prevRotationYaw, playerentity.rotationYaw) * ((float)Math.PI / 180F));
            vector3d = vector3d.rotateYaw(f1 * 0.5F);
            vector3d = vector3d.rotatePitch(-f1 * 0.7F);
            d4 = MathHelper.lerp((double)partialTicks, playerentity.prevPosX, playerentity.getPosX()) + vector3d.x;
            d5 = MathHelper.lerp((double)partialTicks, playerentity.prevPosY, playerentity.getPosY()) + vector3d.y;
            d6 = MathHelper.lerp((double)partialTicks, playerentity.prevPosZ, playerentity.getPosZ()) + vector3d.z;
            f3 = playerentity.getEyeHeight();
         } else {
            d4 = MathHelper.lerp((double)partialTicks, playerentity.prevPosX, playerentity.getPosX()) - d1 * d2 - d0 * 0.8D;
            d5 = playerentity.prevPosY + (double)playerentity.getEyeHeight() + (playerentity.getPosY() - playerentity.prevPosY) * (double)partialTicks - 0.45D;
            d6 = MathHelper.lerp((double)partialTicks, playerentity.prevPosZ, playerentity.getPosZ()) - d0 * d2 + d1 * 0.8D;
            f3 = playerentity.isCrouching() ? -0.1875F : 0.0F;
         }

         double d9 = MathHelper.lerp((double)partialTicks, entityIn.prevPosX, entityIn.getPosX());
         double d10 = MathHelper.lerp((double)partialTicks, entityIn.prevPosY, entityIn.getPosY()) + 0.25D;
         double d8 = MathHelper.lerp((double)partialTicks, entityIn.prevPosZ, entityIn.getPosZ());
         float f4 = (float)(d4 - d9);
         float f5 = (float)(d5 - d10) + f3;
         float f6 = (float)(d6 - d8);
         IVertexBuilder ivertexbuilder1 = bufferIn.getBuffer(RenderType.getLines());
         Matrix4f matrix4f1 = matrixStackIn.getLast().getMatrix();
         int j = 16;

         for(int k = 0; k < 16; ++k) {
            setVertexPosAndColor(f4, f5, f6, ivertexbuilder1, matrix4f1, func_229105_a_(k, 16));
            setVertexPosAndColor(f4, f5, f6, ivertexbuilder1, matrix4f1, func_229105_a_(k + 1, 16));
         }

         matrixStackIn.pop();
         super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
      }
   }

   public static float func_229105_a_(int p_229105_0_, int p_229105_1_) {
      return (float)p_229105_0_ / (float)p_229105_1_;
   }

   private static void func_229106_a_(IVertexBuilder builder, Matrix4f matrix4f, Matrix3f matrix3f, int lightmapUV, float x, int y, int u, int v) {
      builder.pos(matrix4f, x - 0.5F, (float)y - 0.5F, 0.0F).color(255, 255, 255, 255).tex((float)u, (float)v).overlay(OverlayTexture.NO_OVERLAY).lightmap(lightmapUV).normal(matrix3f, 0.0F, 1.0F, 0.0F).endVertex();
   }

   private static void setVertexPosAndColor(float moveX, float y, float z, IVertexBuilder builder, Matrix4f matrix4f, float scale) {
      builder.pos(matrix4f, moveX * scale, y * (scale * scale + scale) * 0.5F + 0.25F, z * scale).color(96, 40, 40, 255).endVertex();
   }

   /**
    * Returns the location of an entity's texture.
    */
   @Override
   public ResourceLocation getEntityTexture(Huihk entity) {
      return HUIHK;
   }
}
