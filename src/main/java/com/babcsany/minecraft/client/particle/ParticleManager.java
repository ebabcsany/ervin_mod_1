package com.babcsany.minecraft.client.particle;

import com.babcsany.minecraft.init.ParticleInit;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.IParticleData;
import net.minecraft.resources.IFutureReloadListener;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;
import java.util.Random;

@OnlyIn(Dist.CLIENT)
public class ParticleManager extends net.minecraft.client.particle.ParticleManager implements IFutureReloadListener {
   protected ClientWorld world;

   public ParticleManager(ClientWorld clientWorld, TextureManager textureManager) {
      super(clientWorld, textureManager);
      AtlasTexture atlas = new AtlasTexture(AtlasTexture.LOCATION_PARTICLES_TEXTURE);
      textureManager.loadTexture(atlas.getTextureLocation(), atlas);
      this.world = clientWorld;
      this.registerFactories();
   }

   private void registerFactories() {
      this.registerFactory(ParticleInit.EPKIN, new EpkinParticle.Factory());
      this.registerFactory(ParticleInit.ITEM_FREIN, new BreakingParticle.FreinFactory());
      //this.registerFactory(ParticleInit.DRIPPING_JURK, DripParticle.DrippingJurkFactory::new);
      //this.registerFactory(ParticleInit.FALLING_JURK, DripParticle.FallingJurkFactory::new);
      //this.registerFactory(ParticleInit.LANDING_JURK, DripParticle.LandingJurkFactory::new);
      //this.registerFactory(ParticleInit.UNDERJURK, UnderjurkParticle.UnderjurkFactory::new);

   }

   @OnlyIn(Dist.CLIENT)
   static class AnimatedSpriteImpl implements IAnimatedSprite {
      private List<TextureAtlasSprite> sprites;

      private AnimatedSpriteImpl() {
      }

      public TextureAtlasSprite get(int particleAge, int particleMaxAge) {
         return this.sprites.get(particleAge * (this.sprites.size() - 1) / particleMaxAge);
      }

      public TextureAtlasSprite get(Random p_217590_1_) {
         return this.sprites.get(p_217590_1_.nextInt(this.sprites.size()));
      }

      public void setSprites(List<TextureAtlasSprite> p_217592_1_) {
         this.sprites = ImmutableList.copyOf(p_217592_1_);
      }
   }

   @FunctionalInterface
   @OnlyIn(Dist.CLIENT)
   public interface IParticleMetaFactory<T extends IParticleData> {
      IParticleFactory<T> create(IAnimatedSprite p_create_1_);
   }
}
