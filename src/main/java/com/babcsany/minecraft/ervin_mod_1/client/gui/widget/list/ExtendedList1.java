package com.babcsany.minecraft.ervin_mod_1.client.gui.widget.list;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.list.AbstractList;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public abstract class ExtendedList1<E extends AbstractList1.AbstractListEntry1<E>> extends AbstractList1<E> {
   private boolean field_230698_a_;

   public ExtendedList1(Minecraft mcIn, int widthIn, int heightIn, int topIn, int bottomIn, int slotHeightIn) {
      super(mcIn, widthIn, heightIn, topIn, bottomIn, slotHeightIn);
   }

   public boolean changeFocus(boolean p_231049_1_) {
      if (!this.field_230698_a_ && this.getItemCount() == 0) {
         return false;
      } else {
         this.field_230698_a_ = !this.field_230698_a_;
         if (this.field_230698_a_ && this.getSelected() == null && this.getItemCount() > 0) {
            this.moveSelection(Ordering.DOWN);
         } else if (this.field_230698_a_ && this.getSelected() != null) {
            this.func_241574_n_();
         }

         return this.field_230698_a_;
      }
   }

   @OnlyIn(Dist.CLIENT)
   public abstract static class AbstractListEntry1<E extends ExtendedList1.AbstractListEntry1<E>> extends AbstractList1.AbstractListEntry1<E> {
      public boolean changeFocus(boolean p_231049_1_) {
         return false;
      }
   }
}