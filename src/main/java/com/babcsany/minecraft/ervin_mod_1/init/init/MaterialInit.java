package com.babcsany.minecraft.ervin_mod_1.init.init;

import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.PushReaction;

public class MaterialInit {
    public static final MaterialInit AIR = (new MaterialInit.Builder(MaterialColorInit.AIR)).doesNotBlockMovement().notOpaque().notSolid().replaceable().build();
    public static final MaterialInit CRASK = (new MaterialInit.Builder(MaterialColorInit.CRASK)).doesNotBlockMovement().notOpaque().notSolid().replaceable().build();
    public static final MaterialInit ROCK = (new MaterialInit.Builder(MaterialColorInit.STONE)).build();
    public static final MaterialInit WOOD = (new MaterialInit.Builder(MaterialColorInit.WOOD)).flammable().build();
    public static final MaterialInit WOOL = (new MaterialInit.Builder(MaterialColorInit.WOOL)).flammable().build();
    public static final MaterialInit SAND = (new MaterialInit.Builder(MaterialColorInit.SAND)).build();



    private final MaterialColorInit color;
    /**
     * Mobility information flag. 0 indicates that this block is normal, 1 indicates that it can't push other blocks, 2
     * indicates that it can't be pushed.
     */
    private final PushReaction pushReaction;
    private final boolean blocksMovement;
    private final boolean flammable;
    private final boolean isLiquid;
    private final boolean isOpaque;
    private final boolean replaceable;
    private final boolean isSolid;

    public MaterialInit(MaterialColorInit color, boolean isLiquid, boolean isSolid, boolean blocksMovement, boolean isOpaque, boolean flammable, boolean replaceable, PushReaction pushReaction) {
        this.color = color;
        this.isLiquid = isLiquid;
        this.isSolid = isSolid;
        this.blocksMovement = blocksMovement;
        this.isOpaque = isOpaque;
        this.flammable = flammable;
        this.replaceable = replaceable;
        this.pushReaction = pushReaction;
    }

    /**
     * Returns if blocks of these materials are liquids.
     */
    public boolean isLiquid() {
        return this.isLiquid;
    }

    /**
     * Returns true if the block is a considered solid. This is true by default.
     */
    public boolean isSolid() {
        return this.isSolid;
    }

    /**
     * Returns if this material is considered solid or not
     */
    public boolean blocksMovement() {
        return this.blocksMovement;
    }

    /**
     * Returns if the block can burn or not.
     */
    public boolean isFlammable() {
        return this.flammable;
    }

    /**
     * Returns whether the material can be replaced by other blocks when placed - eg snow, vines and tall grass.
     */
    public boolean isReplaceable() {
        return this.replaceable;
    }

    /**
     * Indicate if the material is opaque
     */
    public boolean isOpaque() {
        return this.isOpaque;
    }

    public PushReaction getPushReaction() {
        return this.pushReaction;
    }

    /**
     * Retrieves the color index of the block. This is is the same color used by vanilla maps to represent this block.
     */
    public MaterialColorInit getColor() {
        return this.color;
    }

    public static class Builder {
        private PushReaction pushReaction = PushReaction.NORMAL;
        private boolean blocksMovement = true;
        private boolean canBurn;
        private boolean isLiquid;
        private boolean isReplaceable;
        private boolean isSolid = true;
        private final MaterialColorInit color;
        private boolean isOpaque = true;

        public Builder(MaterialColorInit color) {
            this.color = color;
        }

        public MaterialInit.Builder liquid() {
            this.isLiquid = true;
            return this;
        }

        public MaterialInit.Builder notSolid() {
            this.isSolid = false;
            return this;
        }

        public MaterialInit.Builder doesNotBlockMovement() {
            this.blocksMovement = false;
            return this;
        }

        private MaterialInit.Builder notOpaque() {
            this.isOpaque = false;
            return this;
        }

        protected MaterialInit.Builder flammable() {
            this.canBurn = true;
            return this;
        }

        public MaterialInit.Builder replaceable() {
            this.isReplaceable = true;
            return this;
        }

        protected MaterialInit.Builder pushDestroys() {
            this.pushReaction = PushReaction.DESTROY;
            return this;
        }

        protected MaterialInit.Builder pushBlocks() {
            this.pushReaction = PushReaction.BLOCK;
            return this;
        }

        public MaterialInit build() {
            return new MaterialInit(this.color, this.isLiquid, this.isSolid, this.blocksMovement, this.isOpaque, this.canBurn, this.isReplaceable, this.pushReaction);
        }
    }
}
