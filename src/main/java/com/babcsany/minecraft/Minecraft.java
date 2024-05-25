package com.babcsany.minecraft;

import com.mojang.datafixers.DataFixer;
import net.minecraft.client.GameConfiguration;
import net.minecraft.util.MinecraftVersion;
import net.minecraft.util.datafix.DataFixesManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Minecraft extends net.minecraft.client.Minecraft {
    private final DataFixer dataFixer;
    public Minecraft(GameConfiguration gameConfig) {
        super(gameConfig);
        this.dataFixer = null;
        MinecraftVersion.load();
    }

    @Override
    public DataFixer getDataFixer() {
        return this.dataFixer;
    }
}
