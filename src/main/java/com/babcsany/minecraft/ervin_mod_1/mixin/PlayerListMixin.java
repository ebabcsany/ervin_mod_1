package com.babcsany.minecraft.ervin_mod_1.mixin;

import com.babcsany.minecraft.server.management.ModPlayerList;
import net.minecraft.server.management.PlayerList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin({PlayerList.class})
public class PlayerListMixin {

    @ModifyVariable(
            method = {"func_232644_a_"},
            at = @At("HEAD"),
            ordinal = 0,
            argsOnly = true
    )
    public PlayerList func_232644_a_(PlayerList value) {
        value.tick();
        value.getServer().setPlayerList(ModPlayerList.list);
        return value;
    }
}
