package com.babcsany.minecraft.ervin_mod_1.client.renderer.entity;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.client.entity.render.HuihkRenderer;
import com.babcsany.minecraft.init.EntityInit;
import net.minecraft.client.GameSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.resources.IReloadableResourceManager;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ModEntityRendererManager extends EntityRendererManager {
    private void registerRenderers(ItemRenderer itemRendererIn, IReloadableResourceManager resourceManagerIn) {
        EntityRendererManager managerIn = this;
        this.register(EntityInit.TAWROL, new SpriteRenderer<>(managerIn, itemRendererIn));
        this.register(EntityInit.HUIHK, new HuihkRenderer(managerIn));
    }

    public ModEntityRendererManager(TextureManager textureManagerIn, ItemRenderer itemRendererIn, IReloadableResourceManager resourceManagerIn, FontRenderer fontRendererIn, GameSettings gameSettingsIn) {
        super(textureManagerIn, itemRendererIn, resourceManagerIn, fontRendererIn, gameSettingsIn);
        registerRenderers(itemRendererIn, resourceManagerIn);
    }

    public static void register() {
        Ervin_mod_1.register(ModEntityRendererManager.class);
    }
}
