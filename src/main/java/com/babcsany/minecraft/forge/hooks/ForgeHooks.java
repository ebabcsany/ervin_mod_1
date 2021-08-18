package com.babcsany.minecraft.forge.hooks;


import com.babcsany.minecraft.ervin_mod_1.block.ModBlock;
import com.babcsany.minecraft.ervin_mod_1.entity.living.Living;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.interfaces.consumer.consumers.Consumer_1;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.interfaces.consumer.consumers.Consumer_10;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.interfaces.consumer.consumers.Consumer_3;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.interfaces.consumer.consumers.Consumers;
import com.babcsany.minecraft.ervin_mod_1.item.entity.icsvre.IcsvreEntity;
import com.babcsany.minecraft.ervin_mod_1.item.item.icsvre.Icsvre;
import com.babcsany.minecraft.ervin_mod_1.item.item.icsvre.IcsvreUseContext;
import com.babcsany.minecraft.ervin_mod_1.item.item.stack.IcsvreStack;
import com.babcsany.minecraft.forge.event.entity.icsvre.IcsvreTossEvent;
import com.babcsany.minecraft.item.icsvre.EnchantedBookIcsvre;
import com.babcsany.minecraft.item.icsvre.PotionIcsvre;
import com.babcsany.minecraft.item.icsvre.SpawnEggIcsvre;
import com.babcsany.minecraft.item.icsvre.TippedArrowIcsvre;
import com.google.common.collect.Lists;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.CachedBlockInfo;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.util.BlockSnapshot;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class ForgeHooks {

    public static net.minecraftforge.common.ForgeHooks forgeHooks = null;
    static net.minecraftforge.fluids.FluidAttributes forgeFluidAttributes = null;
    private static Consumer_10<?, ?, ?, ?, ?, ?, ?, ?, ?, ?> consumer_10;
    private static Consumers consumers;
    private static ItemStack itemStack;
    private static Item item;
    private static Living living;
    private static Consumer_1<?> consumer_1;
    private static void setConsumers() {
        consumers.consumer(consumer_1);
    }

    private static Consumer_3<ModBlock, ToolType, Integer> blockToolSetter;
    private static ThreadLocal<PlayerEntity> craftingPlayer = new ThreadLocal<>();
    //Internal use only Modders, this is specifically hidden from you, as you shouldn't be editing other people's blocks.
    public static void setBlockToolSetter(Consumer_3<ModBlock, ToolType, Integer> setter)
    {
        blockToolSetter = setter;
    }

    @Nonnull
    public static IcsvreStack getContainerItem(@Nonnull IcsvreStack stack)
    {
        if (stack.getIcsvre().hasContainerItem(stack))
        {
            stack = stack.getIcsvre().getContainerItem_().getContainerItem(stack);
            if (!stack.isEmpty() && stack.isDamageable() && stack.getDamage() > stack.getMaxDamage())
            {
                com.babcsany.minecraft.forge.event.ForgeEventFactory.onPlayerDestroyIcsvre(craftingPlayer.get(), stack, null);
                return IcsvreStack.EMPTY;
            }
            return stack;
        }
        return IcsvreStack.EMPTY;
    }

    public static ActionResultType onPlaceItemIntoWorld(@Nonnull IcsvreUseContext context)
    {
        IcsvreStack itemstack = context.getIcsvre();
        World world = context.getWorld();

        PlayerEntity player = context.getPlayer();
        if (player != null && !player.abilities.allowEdit && !itemstack.canPlaceOn(world.getTags(), new CachedBlockInfo(world, context.getPos(), false)))
            return ActionResultType.PASS;

        // handle all placement events here
        Icsvre icsvre = itemstack.getIcsvre();
        int size = itemstack.getCount();
        CompoundNBT nbt = null;
        if (itemstack.getTag() != null)
            nbt = itemstack.getTag().copy();

        if (!(itemstack.getItem() instanceof BucketItem)) // if not bucket
            world.captureBlockSnapshots = true;

        IcsvreStack copy = itemstack.copy();
        ActionResultType ret = itemstack.getIcsvre().onItemUse(context);
        if (itemstack.isEmpty())
            ForgeEventFactory.onPlayerDestroyItem(player, copy.getContainerItem(), context.getHand());

        world.captureBlockSnapshots = false;

        if (ret.isSuccessOrConsume())
        {
            // save new item data
            int newSize = itemstack.getCount();
            CompoundNBT newNBT = null;
            if (itemstack.getTag() != null)
            {
                newNBT = itemstack.getTag().copy();
            }
            @SuppressWarnings("unchecked")
            List<BlockSnapshot> blockSnapshots = (List<BlockSnapshot>)world.capturedBlockSnapshots.clone();
            world.capturedBlockSnapshots.clear();

            // make sure to set pre-placement item data for event
            itemstack.setCount(size);
            itemstack.setTag(nbt);

            Direction side = context.getFace();

            boolean eventResult = false;
            if (blockSnapshots.size() > 1)
            {
                eventResult = ForgeEventFactory.onMultiBlockPlace(player, blockSnapshots, side);
            }
            else if (blockSnapshots.size() == 1)
            {
                eventResult = ForgeEventFactory.onBlockPlace(player, blockSnapshots.get(0), side);
            }

            if (eventResult)
            {
                ret = ActionResultType.FAIL; // cancel placement
                // revert back all captured blocks
                for (BlockSnapshot blocksnapshot : Lists.reverse(blockSnapshots))
                {
                    world.restoringBlockSnapshots = true;
                    blocksnapshot.restore(true, false);
                    world.restoringBlockSnapshots = false;
                }
            }
            else
            {
                // Change the stack to its new content
                itemstack.setCount(newSize);
                itemstack.setTag(newNBT);

                for (BlockSnapshot snap : blockSnapshots)
                {
                    int updateFlag = snap.getFlag();
                    BlockState oldBlock = snap.getReplacedBlock();
                    BlockState newBlock = world.getBlockState(snap.getPos());
                    if (!newBlock.hasTileEntity()) // Containers get placed automatically
                    {
                        newBlock.onBlockAdded(world, snap.getPos(), oldBlock, false);
                    }

                    world.markAndNotifyBlock(snap.getPos(), world.getChunkAt(snap.getPos()), oldBlock, newBlock, updateFlag, 512);
                }
                player.addStat(Stats.ITEM_USED.get(item));
            }
        }
        world.capturedBlockSnapshots.clear();

        return ret;
    }

    @Nullable
    public static IcsvreEntity onPlayerTossEvent(@Nonnull PlayerEntity player, @Nonnull IcsvreStack item, boolean includeName)
    {
        player.captureDrops(Lists.newArrayList());
        IcsvreEntity ret = living.dropItem(item, false, includeName);
        player.captureDrops(null);

        if (ret == null)
            return null;

        IcsvreTossEvent event = new IcsvreTossEvent(ret, player);
        if (MinecraftForge.EVENT_BUS.post(event))
            return null;

        if (!player.world.isRemote)
            player.getEntityWorld().addEntity(event.getEntityItem());
        return event.getEntityItem();
    }

    /**
     * Used as the default implementation of {@link Icsvre#getCreatorModId}. Call that method instead.
     */
    @Nullable
    public static String getDefaultCreatorModId(@Nonnull IcsvreStack icsvreStack)
    {
        Icsvre item = icsvreStack.getIcsvre();
        ResourceLocation registryName = item.getRegistryName();
        String modId = registryName == null ? null : registryName.getNamespace();
        if ("minecraft".equals(modId))
        {
            if (item instanceof EnchantedBookIcsvre)
            {
                ListNBT enchantmentsNbt = EnchantedBookIcsvre.getEnchantments(icsvreStack);
                if (enchantmentsNbt.size() == 1)
                {
                    CompoundNBT nbttagcompound = enchantmentsNbt.getCompound(0);
                    ResourceLocation resourceLocation = ResourceLocation.tryCreate(nbttagcompound.getString("id"));
                    if (resourceLocation != null && ForgeRegistries.ENCHANTMENTS.containsKey(resourceLocation))
                    {
                        return resourceLocation.getNamespace();
                    }
                }
            }
            else if (item instanceof PotionIcsvre || item instanceof TippedArrowIcsvre)
            {
                Potion potionType = getPotionFromItem(icsvreStack);
                ResourceLocation resourceLocation = ForgeRegistries.POTION_TYPES.getKey(potionType);
                if (resourceLocation != null)
                {
                    return resourceLocation.getNamespace();
                }
            }
            else if (item instanceof SpawnEggIcsvre)
            {
                ResourceLocation resourceLocation = ((SpawnEggIcsvre)item).getType(null).getRegistryName();
                if (resourceLocation != null)
                {
                    return resourceLocation.getNamespace();
                }
            }
        }
        return modId;
    }

    public static Potion getPotionFromItem(IcsvreStack itemIn) {
        return getPotionTypeFromNBT(itemIn.getTag());
    }

    public static Potion getPotionTypeFromNBT(@Nullable CompoundNBT tag) {
        return tag == null ? Potions.EMPTY : Potion.getPotionTypeForName(tag.getString("Potion"));
    }
}
