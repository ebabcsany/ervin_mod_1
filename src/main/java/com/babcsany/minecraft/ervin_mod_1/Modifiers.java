package com.babcsany.minecraft.ervin_mod_1;

import com.babcsany.minecraft.ervin_mod_1.world.teleporter.Teleporter;

public class Modifiers {

    public static final WorldBorder worldBorder = WorldBorder.getWorldBorder();

    public int getWorldSize = getWorldSize(getWorldSize());
    public double getDamageBuffer = getDamageBuffer(getDamageBuffer());
    public double getDamagePerBlock = getDamagePerBlock(getDamagePerBlock());

    public Modifiers() {
        modifiers();
        classes();
    }

    public int getWorldSize() {
        return worldSize;
    }

    public double getDamageBuffer() {
        return damageBuffer;
    }

    public double getDamagePerBlock() {
        return damagePerBlock;
    }

    public final int getWorldSize(int worldSize) {
        return getWorldSize = worldSize;
    }

    public final double getDamageBuffer(double damageBuffer) {
        return getDamageBuffer = damageBuffer;
    }

    public final double getDamagePerBlock(double damagePerBlock) {
        return getDamagePerBlock = damagePerBlock;
    }

    public static double damagePerBlock = worldBorder.damagePerBlock;
    public static double damageBuffer = worldBorder.damageBuffer;
    public static double warningTime = worldBorder.warningTime;
    public static double warningDistance = worldBorder.warningDistance;
    public static int worldSize = worldBorder.worldSize;


    public void classes() {
        new Teleporter();
    }

    public void modifiers() {
        damagePerBlock = getDamagePerBlock(0.02D);
        damageBuffer = getDamageBuffer(0.5D);
        damageBuffer = getDamageBuffer(0.5D);
        damageBuffer = getDamageBuffer(0.5D);
        worldSize = getWorldSize(299_999_984);
    }

    public static class WorldBorder extends net.minecraft.world.border.WorldBorder {
        private static final WorldBorder worldBorder = new WorldBorder();
        public Modifiers modifiers;
        public double damagePerBlock = this.getDamagePerBlock();
        public double damageBuffer = this.getDamageBuffer();
        public double warningTime = this.getWarningTime();
        public double warningDistance = this.getWarningDistance();
        public int worldSize = this.getSize();

        public static WorldBorder getWorldBorder() {
            return worldBorder;
        }
    }
}
