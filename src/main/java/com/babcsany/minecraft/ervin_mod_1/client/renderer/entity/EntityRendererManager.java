package com.babcsany.minecraft.ervin_mod_1.client.renderer.entity;

import com.babcsany.minecraft.ervin_mod_1.client.entity.render.GubrovRenderer;
import com.babcsany.minecraft.ervin_mod_1.client.entity.render.ZurEntityRender;
import com.babcsany.minecraft.ervin_mod_1.client.entity.render.skull.DgrurbkSkullRenderer;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.DgrurbMobEntity;
import com.babcsany.minecraft.init.EntityInit;
import com.babcsany.minecraft.init.item.ItemInit;
import com.babcsany.minecraft.renderer.entity.ModBoatRenderer;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import java.util.Map;
import javax.annotation.Nullable;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.client.GameSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.culling.ClippingHelper;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.model.ModelBakery;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.crash.ReportedException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.boss.dragon.EnderDragonPartEntity;
import net.minecraft.resources.IReloadableResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EntityRendererManager extends net.minecraft.client.renderer.entity.EntityRendererManager {
   public final Map<EntityType<?>, EntityRenderer<?>> renderers = Maps.newHashMap();
   public final TextureManager textureManager;
   public ActiveRenderInfo info;
   public final GameSettings options;

   public static EntityRendererManager ENTITY_RENDERER_MANAGER;

   private void registerRenderers(net.minecraft.client.renderer.ItemRenderer itemRendererIn, IReloadableResourceManager resourceManagerIn) {
      this.register(EntityInit.MOD_BOAT, new ModBoatRenderer(this));
      this.register(EntityInit.ZUR_ENTITY, new ZurEntityRender(this));
      this.register(EntityInit.GUBROV, new GubrovRenderer(this));
      this.register(EntityInit.DGRURB_SKULL, new DgrurbkSkullRenderer(this));
      this.register(EntityInit.TAWROL, new SpriteRenderer<>(this, itemRendererIn));
   }

   public EntityRendererManager(TextureManager textureManagerIn, net.minecraft.client.renderer.ItemRenderer itemRendererIn, IReloadableResourceManager resourceManagerIn, FontRenderer fontRendererIn, GameSettings gameSettingsIn) {
      super(textureManagerIn, itemRendererIn, resourceManagerIn, fontRendererIn, gameSettingsIn);
      this.textureManager = textureManagerIn;
      this.options = gameSettingsIn;
      this.registerRenderers(itemRendererIn, resourceManagerIn);
      PlayerRenderer playerRenderer = new PlayerRenderer(this);
      /** lists the various player skin types with their associated Renderer class instances. */
      Map<String, PlayerRenderer> skinMap = Maps.newHashMap();
      skinMap.put("default", playerRenderer);
      skinMap.put("slim", new PlayerRenderer(this, true));
   }
}
