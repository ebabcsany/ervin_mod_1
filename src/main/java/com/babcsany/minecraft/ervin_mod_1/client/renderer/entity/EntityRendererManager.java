package com.babcsany.minecraft.ervin_mod_1.client.renderer.entity;

import com.babcsany.minecraft.client.renderer.entity.painting.modPaintingRenderer;
import com.babcsany.minecraft.ervin_mod_1.client.entity.render.GubrovRenderer;
import com.babcsany.minecraft.ervin_mod_1.client.entity.render.ZurEntityRender;
import com.babcsany.minecraft.ervin_mod_1.client.entity.render.skull.DgrurbkSkullRenderer;
import com.babcsany.minecraft.init.EntityInit;
import com.babcsany.minecraft.init.special.PaintingEntityInit;
import com.google.common.collect.Maps;
import net.minecraft.client.GameSettings;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.EntityType;
import net.minecraft.resources.IReloadableResourceManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class EntityRendererManager extends net.minecraft.client.renderer.entity.EntityRendererManager {
   public final Map<EntityType<?>, EntityRenderer<?>> renderers = Maps.newHashMap();
   public final TextureManager textureManager;
   public ActiveRenderInfo info;
   public final GameSettings options;
   public static EntityRendererManager ENTITY_ENDERER_MANAGER;

   private void registerRenderers(net.minecraft.client.renderer.ItemRenderer itemRendererIn, IReloadableResourceManager resourceManagerIn) {
      //this.register(EntityInit.MOD_BOAT, new ModBoatRenderer(this));
      this.register(EntityInit.ZUR_ENTITY, new ZurEntityRender(this));
      this.register(EntityInit.GUBROV, new GubrovRenderer(this));
      this.register(EntityInit.DGRURB_SKULL, new DgrurbkSkullRenderer(this));
      this.register(EntityInit.TAWROL, new SpriteRenderer<>(this, itemRendererIn));
      this.register(PaintingEntityInit.modPainting, new modPaintingRenderer(this));
      this.register(EntityInit.ICSVRE, new ItemRenderer(this, itemRendererIn));
   }

   public EntityRendererManager(TextureManager textureManagerIn, net.minecraft.client.renderer.ItemRenderer itemRendererIn, IReloadableResourceManager resourceManagerIn, FontRenderer fontRendererIn, GameSettings gameSettingsIn) {
      super(textureManagerIn, itemRendererIn, resourceManagerIn, fontRendererIn, gameSettingsIn);
      this.textureManager = textureManagerIn;
      this.options = gameSettingsIn;
      this.registerRenderers(itemRendererIn, resourceManagerIn);
      PlayerRenderer playerRenderer = new PlayerRenderer(this);
      Map<String, PlayerRenderer> skinMap = Maps.newHashMap();
      skinMap.put("default", playerRenderer);
      skinMap.put("slim", new PlayerRenderer(this, true));
   }
}
