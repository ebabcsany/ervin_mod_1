package com.babcsany.minecraft.ervin_mod_1.command;

import com.babcsany.minecraft.ervin_mod_1.init.item.block.BlockItemInit_;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.command.arguments.ItemArgument;
import net.minecraft.command.arguments.ItemInput;
import net.minecraft.command.impl.GiveCommand;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.Collection;

public class ModGiveCommand extends GiveCommand {
    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("give").requires((source) -> {
            return source.hasPermissionLevel(2);
        }).then(Commands.argument("targets", EntityArgument.players()).then(Commands.argument("item", ItemArgument.item()).executes((context) -> {
            return giveItem(context.getSource(), ItemArgument.getItem(context, "item"), EntityArgument.getPlayers(context, "targets"), 1);
        }).then(Commands.argument("count", IntegerArgumentType.integer(1)).executes((context) -> {
            return giveItem(context.getSource(), ItemArgument.getItem(context, "item"), EntityArgument.getPlayers(context, "targets"), IntegerArgumentType.getInteger(context, "count"));
        })))));
    }

    private static int giveItemWithCondition(CommandSource source, ItemInput itemIn, Collection<ServerPlayerEntity> targets, int count) throws CommandSyntaxException {
        if (itemIn.getItem() != BlockItemInit_.EPKIN.asItem()) return giveItem(source, itemIn, targets, count); else return targets.size();
    }

    private static int giveItem(CommandSource source, ItemInput itemIn, Collection<ServerPlayerEntity> targets, int count) throws CommandSyntaxException {
        for (ServerPlayerEntity serverplayerentity : targets) {
            int i = count;

            while(i > 0) {
                int j = Math.min(itemIn.getItem().getMaxStackSize(), i);
                i -= j;
                ItemStack itemstack = itemIn.createStack(j, false);
                boolean flag = serverplayerentity.inventory.addItemStackToInventory(itemstack);
                if (flag && itemstack.isEmpty()) {
                    itemstack.setCount(1);
                    ItemEntity itementity1 = serverplayerentity.dropItem(itemstack, false);
                    if (itementity1 != null) {
                        itementity1.makeFakeItem();
                    }

                    serverplayerentity.world.playSound((PlayerEntity)null, serverplayerentity.getPosX(), serverplayerentity.getPosY(), serverplayerentity.getPosZ(), SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 0.2F, ((serverplayerentity.getRNG().nextFloat() - serverplayerentity.getRNG().nextFloat()) * 0.7F + 1.0F) * 2.0F);
                    serverplayerentity.container.detectAndSendChanges();
                } else {
                    ItemEntity itementity = serverplayerentity.dropItem(itemstack, false);
                    if (itementity != null) {
                        itementity.setNoPickupDelay();
                        itementity.setOwnerId(serverplayerentity.getUniqueID());
                    }
                }
            }
        }

        if (targets.size() == 1) {
            source.sendFeedback(new TranslationTextComponent("commands.give.success.single", count, itemIn.createStack(count, false).getTextComponent(), targets.iterator().next().getDisplayName()), true);
        } else {
            source.sendFeedback(new TranslationTextComponent("commands.give.success.single", count, itemIn.createStack(count, false).getTextComponent(), targets.size()), true);
        }

        return targets.size();
    }
}
