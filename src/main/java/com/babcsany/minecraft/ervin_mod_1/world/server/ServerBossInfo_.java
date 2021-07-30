package com.babcsany.minecraft.ervin_mod_1.world.server;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.BossInfo;
import net.minecraft.world.server.ServerBossInfo;

public class ServerBossInfo_ extends ServerBossInfo {
    public ServerBossInfo_(ITextComponent nameIn, BossInfo.Color colorIn, Color color, Overlay overlayIn) {
        super(nameIn, colorIn, overlayIn);
    }

    public enum Color {
        BLACK("black", TextFormatting.BLACK),
        DARK_GRAY("dark_gray", TextFormatting.DARK_GRAY),
        GRAY("gray", TextFormatting.GRAY),
        PINK("pink", TextFormatting.RED),
        BLUE("blue", TextFormatting.BLUE),
        RED("red", TextFormatting.DARK_RED),
        GREEN("green", TextFormatting.GREEN),
        YELLOW("yellow", TextFormatting.YELLOW),
        PURPLE("purple", TextFormatting.DARK_BLUE),
        WHITE("white", TextFormatting.WHITE);

        private final String name;
        private final TextFormatting formatting;

        private Color(String p_i48622_3_, TextFormatting p_i48622_4_) {
            this.name = p_i48622_3_;
            this.formatting = p_i48622_4_;
        }

        public TextFormatting getFormatting() {
            return this.formatting;
        }

        public String getName() {
            return this.name;
        }

        public static Color byName(String p_201481_0_) {
            for(Color bossinfo$color : values()) {
                if (bossinfo$color.name.equals(p_201481_0_)) {
                    return bossinfo$color;
                }
            }

            return WHITE;
        }
    }
}
