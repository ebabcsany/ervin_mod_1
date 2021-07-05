package com.babcsany.minecraft;

import net.minecraft.client.GameConfiguration;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Minecraft extends net.minecraft.client.Minecraft {
    public Minecraft(GameConfiguration gameConfig) {
        super(gameConfig);
    }
}
