package com.babcsany.minecraft;

import com.babcsany.minecraft.client.renderer.WorldRenderer;
import com.babcsany.minecraft.client.renderer.texture.painting.modPaintingSpriteUploader;
import net.minecraft.client.GameConfiguration;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.RenderTypeBuffers;
import net.minecraft.resources.IReloadableResourceManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Minecraft extends net.minecraft.client.Minecraft {
    private static Minecraft instance;
    private static GameConfiguration gameConfiguration;
    public WorldRenderer worldRenderer;
    private RenderTypeBuffers renderTypeBuffers;
    public final GameRenderer gameRenderer;
    private IReloadableResourceManager resourceManager;
    private static IReloadableResourceManager iReloadableResourceManager;
    private modPaintingSpriteUploader paintingSprites;

    public Minecraft(GameConfiguration gameConfig) {
        super(gameConfig);
        //this.paintingSprites = new modPaintingSpriteUploader(this.textureManager);
        //this.resourceManager.addReloadListener(this.paintingSprites);
        this.gameRenderer = new GameRenderer(this, this.resourceManager, this.renderTypeBuffers);
        this.worldRenderer = new WorldRenderer(this, this.renderTypeBuffers);
        this.resourceManager.addReloadListener(this.worldRenderer);
        //this.paintingSprites.close();
        setResourceManager(resourceManager);
    }

    public RenderTypeBuffers getRenderTypeBuffers() {
        return this.renderTypeBuffers;
    }

    /**
     * Return the singleton Minecraft instance for the game
     */
    public static Minecraft getModInstance() {
        return instance;
    }

    /**
     * Gets the sprite uploader used for paintings.
     */
    public modPaintingSpriteUploader getModPaintingSpriteUploader() {
        return this.paintingSprites;
    }

    public void setResourceManager(IReloadableResourceManager resourceManager) {
        this.resourceManager = resourceManager;
    }
}
