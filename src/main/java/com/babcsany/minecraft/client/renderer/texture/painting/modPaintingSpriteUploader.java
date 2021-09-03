package com.babcsany.minecraft.client.renderer.texture.painting;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.registry.ModRegistry;
import com.babcsany.minecraft.ervin_mod_1.util.registries.modPainting_Type;
import net.minecraft.client.renderer.texture.SpriteUploader;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.stream.Stream;

@OnlyIn(Dist.CLIENT)
public class modPaintingSpriteUploader extends SpriteUploader {
   private static final ResourceLocation LOCATION_BACK_SPRITE = new ResourceLocation("back");

   public modPaintingSpriteUploader(TextureManager textureManagerIn) {
      super(textureManagerIn, new ResourceLocation(Ervin_mod_1.MOD_ID,"textures/atlas/painting/modPaintings.png"), "modPainting");
   }

   protected Stream<ResourceLocation> getResourceLocations() {
      return Stream.concat(ModRegistry.modPainting_MOTIVE.keySet().stream(), Stream.of(LOCATION_BACK_SPRITE));
   }

   /**
    * Gets the sprite used for a specific painting type.
    */
   public TextureAtlasSprite getSpriteForPainting(modPainting_Type paintingTypeIn) {
      return this.getSprite(ModRegistry.modPainting_MOTIVE.getKey(paintingTypeIn));
   }

   public TextureAtlasSprite getBackSprite() {
      return this.getSprite(LOCATION_BACK_SPRITE);
   }
}
