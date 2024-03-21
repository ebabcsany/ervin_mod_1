package com.babcsany.minecraft.ervin_mod_1.client.gui.screen.furnace.gui;

import java.util.Set;

import com.babcsany.minecraft.ervin_mod_1.tile_entity.furnace.abstract_furnace.AbstractBlackFurnaceTileEntity;
import net.minecraft.client.gui.recipebook.AbstractRecipeBookGui;
import net.minecraft.item.Item;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BlackFurnaceRecipeGui extends AbstractRecipeBookGui {
   private static final ITextComponent field_243414_i = new TranslationTextComponent("gui.recipebook.toggleRecipes.smeltable");

   protected ITextComponent func_230479_g_() {
      return field_243414_i;
   }

   protected Set<Item> func_212958_h() {
      return AbstractBlackFurnaceTileEntity.getBurnTimes().keySet();
   }
}