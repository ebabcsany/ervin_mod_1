package com.babcsany.minecraft.ervin_mod_1.command;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.command.Commands;

public class ModCommands extends Commands {

    public ModCommands(EnvironmentType envType) {
        super(envType);
        ModGiveCommand.register(super.getDispatcher());
    }

    public static void register() {
        Ervin_mod_1.register(ModCommands.class);
    }
}
