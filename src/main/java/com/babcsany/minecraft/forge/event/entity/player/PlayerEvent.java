package com.babcsany.minecraft.forge.event.entity.player;

import com.babcsany.minecraft.ervin_mod_1.item.entity.icsvre.IcsvreEntity;
import com.babcsany.minecraft.ervin_mod_1.item.item.stack.IcsvreStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent;

public class PlayerEvent extends LivingEvent {

    private final PlayerEntity entityPlayer;
    public PlayerEvent(PlayerEntity player)
    {
        super(player);
        entityPlayer = player;
    }

    public static class IcsvrePickupEvent extends net.minecraftforge.event.entity.player.PlayerEvent {
        /**
         * Original EntityItem with current remaining stack size
         */
        private final IcsvreEntity originalEntity;
        /**
         * Clone item stack, containing the item and amount picked up
         */
        private final IcsvreStack stack;
        public IcsvrePickupEvent(PlayerEntity player, IcsvreEntity entPickedUp, IcsvreStack stack)
        {
            super(player);
            this.originalEntity = entPickedUp;
            this.stack = stack;
        }

        public IcsvreStack getStack() {
            return stack;
        }

        public IcsvreEntity getOriginalEntity() {
            return originalEntity;
        }
    }
}
