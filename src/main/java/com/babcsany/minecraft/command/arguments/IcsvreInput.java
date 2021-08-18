package com.babcsany.minecraft.command.arguments;

import com.babcsany.minecraft.ervin_mod_1.item.item.icsvre.Icsvre;
import com.babcsany.minecraft.ervin_mod_1.item.item.stack.IcsvreStack;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.Dynamic2CommandExceptionType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class IcsvreInput implements Predicate<IcsvreStack> {
   private static final Dynamic2CommandExceptionType STACK_TOO_LARGE = new Dynamic2CommandExceptionType((p_208695_0_, p_208695_1_) -> {
      return new TranslationTextComponent("arguments.item.overstacked", p_208695_0_, p_208695_1_);
   });
   private final Icsvre icsvre;
   @Nullable
   private final CompoundNBT tag;

   public IcsvreInput(Icsvre itemIn, @Nullable CompoundNBT tagIn) {
      this.icsvre = itemIn;
      this.tag = tagIn;
   }

   public Icsvre getItem() {
      return this.icsvre;
   }

   public boolean test(IcsvreStack stack) {
      return stack.getIcsvre() == this.icsvre && NBTUtil.areNBTEquals(this.tag, stack.getTag(), true);
   }

   public IcsvreStack createStack(int count, boolean allowOversizedStacks) throws CommandSyntaxException {
      IcsvreStack icsvreStack = new IcsvreStack(this.icsvre, count);
      if (this.tag != null) {
         icsvreStack.setTag(this.tag);
      }

      if (allowOversizedStacks && count > icsvreStack.getMaxStackSize()) {
         throw STACK_TOO_LARGE.create(Registry.ITEM.getKey(this.icsvre.item), icsvreStack.getMaxStackSize());
      } else {
         return icsvreStack;
      }
   }

   public String serialize() {
      StringBuilder stringbuilder = new StringBuilder(Registry.ITEM.getId(this.icsvre.item));
      if (this.tag != null) {
         stringbuilder.append(this.tag);
      }

      return stringbuilder.toString();
   }
}
