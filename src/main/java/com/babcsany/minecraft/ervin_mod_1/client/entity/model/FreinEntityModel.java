package com.babcsany.minecraft.ervin_mod_1.client.entity.model;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FreinEntityModel <T extends Entity> extends SegmentedModel<T> {

        private final ModelRenderer freinBodies;
        private final ModelRenderer freinRightEye;
        private final ModelRenderer freinLeftEye;
        private final ModelRenderer freinMouth;

        public FreinEntityModel(int freinBodyTexOffY) {
            this.freinBodies = new ModelRenderer(this, 0, freinBodyTexOffY);
            this.freinRightEye = new ModelRenderer(this, 32, 0);
            this.freinLeftEye = new ModelRenderer(this, 32, 4);
            this.freinMouth = new ModelRenderer(this, 32, 8);
            if (freinBodyTexOffY > 0) {
                this.freinBodies.addBox(-3.0F, 17.0F, -3.0F, 6.0F, 6.0F, 6.0F);
                this.freinRightEye.addBox(-3.25F, 18.0F, -3.5F, 2.0F, 2.0F, 2.0F);
                this.freinLeftEye.addBox(1.25F, 18.0F, -3.5F, 2.0F, 2.0F, 2.0F);
                this.freinMouth.addBox(0.0F, 21.0F, -3.5F, 1.0F, 1.0F, 1.0F);
            } else {
                this.freinBodies.addBox(-4.0F, 16.0F, -4.0F, 8.0F, 8.0F, 8.0F);
            }

        }

        /**
         * Sets this entity's model rotation angles
         */
        public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        }

        public Iterable<ModelRenderer> getParts() {
            return ImmutableList.of(this.freinBodies, this.freinRightEye, this.freinLeftEye, this.freinMouth);
        }
    }

