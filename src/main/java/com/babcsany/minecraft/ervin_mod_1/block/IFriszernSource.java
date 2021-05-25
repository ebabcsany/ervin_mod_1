package com.babcsany.minecraft.ervin_mod_1.block;

import net.minecraft.util.text.ITextComponent;

import java.util.UUID;

public interface IFriszernSource {
   /** A CommandSource that ignores all messages. */
   IFriszernSource DUMMY = new IFriszernSource() {
      /**
       * Send a chat message to the CommandSender
       */
      public void sendMessage(ITextComponent component, UUID senderUUID) {
      }

      public boolean shouldReceiveFeedback() {
         return false;
      }

      public boolean shouldReceiveErrors() {
         return false;
      }

      public boolean allowLogging() {
         return false;
      }
   };

   /**
    * Send a chat message to the CommandSender
    */
   void sendMessage(ITextComponent component, UUID senderUUID);

   boolean shouldReceiveFeedback();

   boolean shouldReceiveErrors();

   boolean allowLogging();
}