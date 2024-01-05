package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.setup.client.screen;

import com.babcsany.minecraft.ervin_mod_1.client.gui.screen.CraintBlockCraftingTableScreen;
import com.babcsany.minecraft.ervin_mod_1.client.gui.screen.IrtrewScreen;
import com.babcsany.minecraft.ervin_mod_1.client.gui.screen.LeatBlockCraftingTableScreen;
import com.babcsany.minecraft.ervin_mod_1.client.gui.screen.TraderBlockScreen;
import com.babcsany.minecraft.ervin_mod_1.client.gui.screen.merchant.ZurScreen;
import com.babcsany.minecraft.ervin_mod_1.init.container.ContainerInit;
import net.minecraft.client.gui.ScreenManager;

public class ScreenSetup {

    public ScreenSetup() {
        register();
    }

    public void register() {
        ScreenManager.registerFactory(ContainerInit.LEAT_BLOCK_CRAFTING_TABLE.get(), LeatBlockCraftingTableScreen::new);
        ScreenManager.registerFactory(ContainerInit.CRAINT_BLOCK_CRAFTING_TABLE.get(), CraintBlockCraftingTableScreen::new);
        ScreenManager.registerFactory(ContainerInit.IRTREW.get(), IrtrewScreen::new);
        ScreenManager.registerFactory(ContainerInit.TRADER_BLOCK.get(), TraderBlockScreen::new);
        ScreenManager.registerFactory(ContainerInit.ZUR.get(), ZurScreen::new);
    }
}
