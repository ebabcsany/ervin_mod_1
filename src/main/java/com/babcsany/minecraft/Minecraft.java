package com.babcsany.minecraft;

import com.babcsany.minecraft.client.renderer.texture.painting.modPaintingSpriteUploader;
import net.minecraft.client.GameConfiguration;
import net.minecraft.resources.IReloadableResourceManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Minecraft extends net.minecraft.client.Minecraft {
    private static Minecraft instance;
    private GameConfiguration gameConfiguration;
    private IReloadableResourceManager resourceManager;
    private final modPaintingSpriteUploader paintingSprites;

    public Minecraft() {
        this(getModInstance().gameConfiguration, getModInstance().resourceManager);
    }

    public Minecraft(GameConfiguration gameConfig, IReloadableResourceManager resourceManager) {
        super(gameConfig);
        this.paintingSprites = new modPaintingSpriteUploader(this.textureManager);
        this.resourceManager.addReloadListener(this.paintingSprites);
        this.paintingSprites.close();
        setResourceManager(resourceManager);
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
