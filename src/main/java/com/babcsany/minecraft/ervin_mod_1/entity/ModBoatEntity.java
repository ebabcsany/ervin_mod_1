package com.babcsany.minecraft.ervin_mod_1.entity;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.init.BlockInit;
import com.babcsany.minecraft.init.EntityInit;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class ModBoatEntity extends BoatEntity {
    private static final DataParameter<Integer> BOAT_TYPE = EntityDataManager.createKey(ModBoatEntity.class, DataSerializers.VARINT);

    public ModBoatEntity(EntityType<? extends ModBoatEntity> p_i50129_1_, World p_i50129_2_) {
        super(p_i50129_1_, p_i50129_2_);
    }

    public ModBoatEntity(World p_i1705_1_, double p_i1705_2_, double p_i1705_4_, double p_i1705_6_) {
        this(EntityInit.MOD_BOAT, p_i1705_1_);
        this.setPosition(p_i1705_2_, p_i1705_4_, p_i1705_6_);
        this.setMotion(Vector3d.ZERO);
        this.prevPosX = p_i1705_2_;
        this.prevPosY = p_i1705_4_;
        this.prevPosZ = p_i1705_6_;
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(BOAT_TYPE, Type.FIRG.ordinal());
    }

    protected void writeAdditional(CompoundNBT p_213281_1_) {
        p_213281_1_.putString("ModType", this.getModBoatType().getName());
    }

    protected void readAdditional(CompoundNBT p_70037_1_) {
        if (p_70037_1_.contains("ModType", 8)) {
            this.setModBoatType(Type.getTypeFromString(p_70037_1_.getString("ModType")));
        }

    }

    public void setModBoatType(Type p_184458_1_) {
        this.dataManager.set(BOAT_TYPE, p_184458_1_.ordinal());
    }

    public Type getModBoatType() {
        return Type.byId((Integer)this.dataManager.get(BOAT_TYPE));
    }

    public static enum Type {
        FIRG(BlockInit.FIRG_PLANKS.get(), "firg"),
        FRIM(BlockItemInit.FRIM_PLANKS.get(), "frim");

        private final String name;
        private final Block block;

        private Type(Block p_i48146_3_, String p_i48146_4_) {
            this.name = p_i48146_4_;
            this.block = p_i48146_3_;
        }

        public String getName() {
            return this.name;
        }

        public Block asPlank() {
            return this.block;
        }

        public String toString() {
            return this.name;
        }

        public static Type byId(int p_184979_0_) {
            Type[] aboatentity$type = values();
            if (p_184979_0_ < 0 || p_184979_0_ >= aboatentity$type.length) {
                p_184979_0_ = 0;
            }

            return aboatentity$type[p_184979_0_];
        }

        public static Type getTypeFromString(String p_184981_0_) {
            Type[] aboatentity$type = values();

            for (int i = 0; i < aboatentity$type.length; ++i) {
                if (aboatentity$type[i].getName().equals(p_184981_0_)) {
                    return aboatentity$type[i];
                }
            }

            return aboatentity$type[0];
        }
    }
}
