package com.babcsany.minecraft.ervin_mod_1.client.gui.widget;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ToggleWidget1 extends Widget {
   protected ResourceLocation resourceLocation;
   protected boolean stateTriggered;
   protected int xTexStart;
   protected int yTexStart;
   protected int xDiffTex;
   protected int yDiffTex;

   public ToggleWidget1(int xIn, int yIn, int widthIn, int heightIn, boolean triggered) {
      super(xIn, yIn, widthIn, heightIn, StringTextComponent.EMPTY);
      this.stateTriggered = triggered;
   }

   public void initTextureValues(int xTexStartIn, int yTexStartIn, int xDiffTexIn, int yDiffTexIn, ResourceLocation resourceLocationIn) {
      this.xTexStart = xTexStartIn;
      this.yTexStart = yTexStartIn;
      this.xDiffTex = xDiffTexIn;
      this.yDiffTex = yDiffTexIn;
      this.resourceLocation = resourceLocationIn;
   }

   public void setStateTriggered(boolean triggered) {
      this.stateTriggered = triggered;
   }

   public boolean isStateTriggered() {
      return this.stateTriggered;
   }

   public void setPosition(int xIn, int yIn) {
      this.x = xIn;
      this.y = yIn;
   }

   public void renderButton(MatrixStack p_230431_1_, int p_230431_2_, int p_230431_3_, float p_230431_4_) {
      Minecraft minecraft = Minecraft.getInstance();
      minecraft.getTextureManager().bindTexture(this.resourceLocation);
      RenderSystem.disableDepthTest();
      int i = this.xTexStart;
      int j = this.yTexStart;
      if (this.stateTriggered) {
         i += this.xDiffTex;
      }

      if (this.isHovered()) {
         j += this.yDiffTex;
      }

      this.blit(p_230431_1_, this.x, this.y, i, j, this.width, this.height);
      RenderSystem.enableDepthTest();
   }
}