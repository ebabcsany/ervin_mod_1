package com.babcsany.minecraft.ervin_mod_1.item;

import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class TeratBucket extends BucketItem {
    public TeratBucket(Properties builder) {
        super(() -> {
            return Fluids.EMPTY;
        }, builder);
    }

    public TeratBucket(Supplier<? extends Fluid> supplier, Properties builder) {
        super(supplier, builder);
    }

    public TeratBucket(Fluid containedFluidIn, Properties builder) {
        super(() -> {
            return containedFluidIn;
        }, builder);
    }

    @OnlyIn(Dist.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add((new TranslationTextComponent("tips.copper_bucket")).mergeStyle(TextFormatting.GREEN));
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ActionResult<ItemStack> itemStackActionResult = super.onItemRightClick(worldIn, playerIn, handIn);
        if (itemStackActionResult.getType() == ActionResultType.CONSUME) {
            ItemStack newItemStack;
            Item itemBucket = itemStackActionResult.getResult().getItem();
            Item newBucket = this.fixBucketItem(itemBucket);
            if (newBucket != itemBucket) {
                if (newBucket == null) {
                    newItemStack = ItemStack.EMPTY;
                } else {
                    newItemStack = new ItemStack(newBucket);
                }

                itemStackActionResult = new ActionResult(ActionResultType.CONSUME, newItemStack);
            }
        }

        return itemStackActionResult;
    }

    private Item fixBucketItem(Item bucketIn) {
        if (bucketIn == isBurnableItemInit.TERAT_BUCKET.get()) {
            return isBurnableItemInit.WATER_TERAT_BUCKET.get();
        } else if (bucketIn == Items.WATER_BUCKET) {
            return isBurnableItemInit.TERAT_BUCKET.get();
        } else if (bucketIn == Items.LAVA_BUCKET) {
            return bucketIn == isBurnableItemInit.LAVA_TERAT_BUCKET.get() ? null : bucketIn;
        } else {
            return bucketIn == isBurnableItemInit.LAVA_TERAT_BUCKET.get() ? null : bucketIn;
        }
    }

    protected ItemStack emptyBucket(ItemStack p_203790_1_, PlayerEntity p_203790_2_) {
        return !p_203790_2_.abilities.isCreativeMode ? new ItemStack(isBurnableItemInit.TERAT_BUCKET.get()) : p_203790_1_;
    }
}
