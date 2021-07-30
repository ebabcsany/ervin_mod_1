package com.babcsany.minecraft.forge.hooks;


import com.babcsany.minecraft.ervin_mod_1.block.ModBlock;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.interfaces.consumer.consumers.Consumer_1;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.interfaces.consumer.consumers.Consumer_10;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.interfaces.consumer.consumers.Consumer_3;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.interfaces.consumer.consumers.Consumers;
import net.minecraftforge.common.ToolType;

public class ForgeHooks {

    public static net.minecraftforge.common.ForgeHooks forgeHooks = null;
    static net.minecraftforge.fluids.FluidAttributes forgeFluidAttributes = null;
    private static Consumer_10<?, ?, ?, ?, ?, ?, ?, ?, ?, ?> consumer_10;
    private static Consumers consumers;
    private static Consumer_1<?> consumer_1;
    private static void setConsumers() {
        consumers.consumer(consumer_1);
    }

    private static Consumer_3<ModBlock, ToolType, Integer> blockToolSetter;
    //Internal use only Modders, this is specifically hidden from you, as you shouldn't be editing other people's blocks.
    public static void setBlockToolSetter(Consumer_3<ModBlock, ToolType, Integer> setter)
    {
        blockToolSetter = setter;
    }
}
