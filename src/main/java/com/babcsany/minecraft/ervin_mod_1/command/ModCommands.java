package com.babcsany.minecraft.ervin_mod_1.command;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

public class ModCommands extends Commands {
    protected static CommandDispatcher<CommandSource> DISPATCHER = null;

    public ModCommands(EnvironmentType envType) {
        super(envType);
        DISPATCHER = this.getDispatcher();
        ModGiveCommand.register(DISPATCHER);
        DISPATCHER = null;
    }

    public static void register() {
        Ervin_mod_1.register(ModCommands.class);
    }
}
