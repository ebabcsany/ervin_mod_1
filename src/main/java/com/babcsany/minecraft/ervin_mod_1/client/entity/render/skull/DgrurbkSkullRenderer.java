package com.babcsany.minecraft.ervin_mod_1.client.entity.render.skull;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.entity.projectile.DgrurbkSkullEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.GenericHeadModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DgrurbkSkullRenderer extends EntityRenderer<DgrurbkSkullEntity> {
   private static final ResourceLocation INVULNERABLE_DGRURBK_TEXTURES = new ResourceLocation(Ervin_mod_1.MOD_ID,"textures/entity/wither/wither_invulnerable.png");
   private static final ResourceLocation DGRURBK_TEXTURES = new ResourceLocation(Ervin_mod_1.MOD_ID,"textures/entity/wither/wither.png");
   private final GenericHeadModel skeletonHeadModel = new GenericHeadModel();

   public DgrurbkSkullRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn);
   }

   protected int getBlockLight(DgrurbkSkullEntity entityIn, BlockPos partialTicks) {
      return 15;
   }

   public void render(DgrurbkSkullEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
      matrixStackIn.push();
      matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
      float f = MathHelper.rotLerp(entityIn.prevRotationYaw, entityIn.rotationYaw, partialTicks);
      float f1 = MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch);
      IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.skeletonHeadModel.getRenderType(this.getEntityTexture(entityIn)));
      this.skeletonHeadModel.func_225603_a_(0.0F, f, f1);
      this.skeletonHeadModel.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
      matrixStackIn.pop();
      super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
   }

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getEntityTexture(DgrurbkSkullEntity entity) {
      return entity.isSkullInvulnerable() ? INVULNERABLE_DGRURBK_TEXTURES : DGRURBK_TEXTURES;
   }
}
