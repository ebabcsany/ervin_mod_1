package com.babcsany.minecraft.ervin_mod_1.client.renderer.entity;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.entity.item.ModBoatEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.BoatModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;

public class ModBoatRender extends EntityRenderer<ModBoatEntity> {
    private static final ResourceLocation[] MOD_BOAT_TEXTURES = new ResourceLocation[]{
            new ResourceLocation(Ervin_mod_1.MOD_ID,"textures/entity/boat/firg.png"),
            new ResourceLocation(Ervin_mod_1.MOD_ID,"textures/entity/boat/frim.png"),
    };
    protected final BoatModel model = new BoatModel();

    public ModBoatRender(EntityRendererManager entityRenderDispatcher) {
        super(entityRenderDispatcher);
        this.shadowSize = 0.8F;
        Ervin_mod_1.LOGGER.info("ACCESSING");
    }

    public void render(ModBoatEntity boat, float f, float g, MatrixStack matrixStack, IRenderTypeBuffer buffer, int i) {
        Ervin_mod_1.LOGGER.info("RENDERED");
        matrixStack.push();
        matrixStack.translate(0.0D, 0.375D, 0.0D);
        matrixStack.rotate(Vector3f.YP.rotationDegrees(180.0F - f));
        float h = (float)boat.getTimeSinceHit() - g;
        float j = boat.getDamageTaken() - g;
        if (j < 0.0F) {
            j = 0.0F;
        }

        if (h > 0.0F) {
            matrixStack.rotate(Vector3f.XP.rotationDegrees(MathHelper.sin(h) * h * j / 10.0F * (float)boat.getForwardDirection()));
        }

        float k = boat.getRockingAngle(g);
        if (!MathHelper.epsilonEquals(k, 0.0F)) {
            matrixStack.rotate(new Quaternion(new Vector3f(1.0F, 0.0F, 1.0F), boat.getRockingAngle(g), true));
        }

        matrixStack.scale(-1.0F, -1.0F, 1.0F);
        matrixStack.rotate(Vector3f.YP.rotationDegrees(90.0F));
        this.model.setRotationAngles(boat, g, 0.0F, -0.1F, 0.0F, 0.0F);
        IVertexBuilder vertexConsumer = buffer.getBuffer(this.model.getRenderType(this.getEntityTexture(boat)));
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        if (!boat.canSwim()) {
            IVertexBuilder vertexConsumer2 = buffer.getBuffer(RenderType.getWaterMask());
            this.model.func_228245_c_().render(matrixStack, vertexConsumer2, i, OverlayTexture.NO_OVERLAY);
        }

        matrixStack.pop();
        Ervin_mod_1.LOGGER.info("RENDERED");
        super.render(boat, f, g, matrixStack, buffer, i);
    }

    public ResourceLocation getEntityTexture(ModBoatEntity boatEntity) {
        return MOD_BOAT_TEXTURES[boatEntity.getModBoatType().ordinal()];
    }
}
