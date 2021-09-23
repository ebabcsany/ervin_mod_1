package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes;

import com.babcsany.minecraft.ervin_mod_1.init.WorldInit;
import com.babcsany.minecraft.ervin_mod_1.world.teleporter.Teleporter;
import com.babcsany.minecraft.world.server.ModServerWorld;
import com.babcsany.minecraft.world.world;
import com.mojang.authlib.GameProfile;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.play.server.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerInteractionManager;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.IWorldInfo;

import javax.annotation.Nullable;

public class ModServerPlayerEntity extends ServerPlayerEntity {
    private int lastExperience = -99999999;
    private float lastHealth = -1.0E8F;
    private int lastFoodLevel = -99999999;
    private boolean invulnerableDimensionChange;
    @Nullable
    private Vector3d enteredNetherPosition;
    private boolean seenCredits;
    private static ServerWorld server;
    private static net.minecraftforge.common.util.ITeleporter teleporter;

    public ModServerPlayerEntity(MinecraftServer server, ServerWorld worldIn, GameProfile profile, PlayerInteractionManager interactionManagerIn) {
        super(server, worldIn, profile, interactionManagerIn);
    }

    public void player() {
        changeDimension(server, teleporter);
    }

    @Nullable
    public Entity changeDimension(ServerWorld server, net.minecraftforge.common.util.ITeleporter teleporter) {
        if (!net.minecraftforge.common.ForgeHooks.onTravelToDimension(this, server.func_234923_W_())) return null;
        this.invulnerableDimensionChange = true;
        ServerWorld serverWorld = this.getServerWorld();
        ModServerWorld modServerWorld = this.getModServerWorld();
        RegistryKey<World> registryKey = serverWorld.func_234923_W_();
        RegistryKey<world> modRegistryKey = modServerWorld.worldRegistryKey();
        if (modRegistryKey == WorldInit.EXAMPLE && server.func_234923_W_() == World.field_234918_g_ && teleporter instanceof Teleporter) { //Forge: Fix non-vanilla teleporters triggering end credits
            this.detach();
            this.getServerWorld().removePlayer(this, true); //Forge: The player entity is cloned so keep the data until after cloning calls copyFrom
            if (!this.queuedEndExit) {
                this.queuedEndExit = true;
                this.connection.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, this.seenCredits ? 0.0F : 1.0F));
                this.seenCredits = true;
            }

            return this;
        } else {
            IWorldInfo iworldinfo = server.getWorldInfo();
            this.connection.sendPacket(new SRespawnPacket(server.func_234922_V_(), server.func_234923_W_(), BiomeManager.func_235200_a_(server.getSeed()), this.interactionManager.getGameType(), this.interactionManager.func_241815_c_(), server.func_234925_Z_(), server.func_241109_A_(), true));
            this.connection.sendPacket(new SServerDifficultyPacket(iworldinfo.getDifficulty(), iworldinfo.isDifficultyLocked()));
            PlayerList playerlist = this.getServer().getPlayerList();
            playerlist.updatePermissionLevel(this);
            serverWorld.removeEntity(this, true); //Forge: the player entity is moved to the new world, NOT cloned. So keep the data alive with no matching invalidate call.
            this.revive();
            Entity e = teleporter.placeEntity(this, serverWorld, server, this.rotationYaw, spawnPortal -> {//Forge: Start vanilla logic
                double d0 = this.getPosX();
                double d1 = this.getPosY();
                double d2 = this.getPosZ();
                float f = this.rotationPitch;
                float f1 = this.rotationYaw;
                float f2 = f1;
                serverWorld.getProfiler().startSection("moving");
                if (server.func_234923_W_() == World.field_234920_i_) {
                    BlockPos blockpos = ServerWorld.field_241108_a_;
                    d0 = blockpos.getX();
                    d1 = blockpos.getY();
                    d2 = blockpos.getZ();
                    f1 = 90.0F;
                    f = 0.0F;
                } else {
                    if (registryKey == World.field_234918_g_ && server.func_234923_W_() == World.field_234919_h_) {
                        this.enteredNetherPosition = this.getPositionVec();
                    }

                    DimensionType dimensiontype1 = serverWorld.func_230315_m_();
                    DimensionType dimensiontype = server.func_230315_m_();
                    double d3 = 8.0D;
                    if (!dimensiontype1.func_236045_g_() && dimensiontype.func_236045_g_()) {
                        d0 /= 8.0D;
                        d2 /= 8.0D;
                    } else if (dimensiontype1.func_236045_g_() && !dimensiontype.func_236045_g_()) {
                        d0 *= 8.0D;
                        d2 *= 8.0D;
                    }
                }

                this.setLocationAndAngles(d0, d1, d2, f1, f);
                serverWorld.getProfiler().endSection();
                serverWorld.getProfiler().startSection("placing");
                double d6 = Math.min(-2.9999872E7D, server.getWorldBorder().minX() + 16.0D);
                double d7 = Math.min(-2.9999872E7D, server.getWorldBorder().minZ() + 16.0D);
                double d4 = Math.min(2.9999872E7D, server.getWorldBorder().maxX() - 16.0D);
                double d5 = Math.min(2.9999872E7D, server.getWorldBorder().maxZ() - 16.0D);
                d0 = MathHelper.clamp(d0, d6, d4);
                d2 = MathHelper.clamp(d2, d7, d5);
                this.setLocationAndAngles(d0, d1, d2, f1, f);
                if (server.func_234923_W_() == World.field_234920_i_) {
                    int i = MathHelper.floor(this.getPosX());
                    int j = MathHelper.floor(this.getPosY()) - 1;
                    int k = MathHelper.floor(this.getPosZ());
                    ServerWorld.func_241121_a_(server);
                    this.setLocationAndAngles(i, j, k, f1, 0.0F);
                    this.setMotion(Vector3d.ZERO);
                } else if (spawnPortal && !server.getDefaultTeleporter().placeInPortal(this, f2)) {
                    server.getDefaultTeleporter().makePortal(this);
                    server.getDefaultTeleporter().placeInPortal(this, f2);
                }

                serverWorld.getProfiler().endSection();
                this.setWorld(server);
                server.addDuringPortalTeleport(this);
                this.func_213846_b(serverWorld);
                this.connection.setPlayerLocation(this.getPosX(), this.getPosY(), this.getPosZ(), f1, f);
                return this;//forge: this is part of the ITeleporter patch
            });//Forge: End vanilla logic
            if (e != this) throw new IllegalArgumentException(String.format("Teleporter %s returned not the player entity but instead %s, expected PlayerEntity %s", teleporter, e, this));
            this.interactionManager.setWorld(server);
            this.connection.sendPacket(new SPlayerAbilitiesPacket(this.abilities));
            playerlist.sendWorldInfo(this, server);
            playerlist.sendInventory(this);

            for(EffectInstance effectinstance : this.getActivePotionEffects()) {
                this.connection.sendPacket(new SPlayEntityEffectPacket(this.getEntityId(), effectinstance));
            }

            this.connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
            this.lastExperience = -1;
            this.lastHealth = -1.0F;
            this.lastFoodLevel = -1;
            net.minecraftforge.fml.hooks.BasicEventHooks.firePlayerChangedDimensionEvent(this, registryKey, server.func_234923_W_());
            return this;
        }
    }

    private void func_213846_b(ServerWorld p_213846_1_) {
        RegistryKey<World> registrykey = p_213846_1_.func_234923_W_();
        RegistryKey<World> registrykey1 = this.world.func_234923_W_();
        CriteriaTriggers.CHANGED_DIMENSION.testForAll(this, registrykey, registrykey1);
        if (registrykey == World.field_234919_h_ && registrykey1 == World.field_234918_g_ && this.enteredNetherPosition != null) {
            CriteriaTriggers.NETHER_TRAVEL.trigger(this, this.enteredNetherPosition);
        }

        if (registrykey1 != World.field_234919_h_) {
            this.enteredNetherPosition = null;
        }

    }
}
