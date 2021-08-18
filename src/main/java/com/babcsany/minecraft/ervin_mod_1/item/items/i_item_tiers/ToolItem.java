package com.babcsany.minecraft.ervin_mod_1.item.items.i_item_tiers;

import com.babcsany.minecraft.ervin_mod_1.item.Rarity;
import com.babcsany.minecraft.ervin_mod_1.item.tool.IItemTier2;
import com.babcsany.minecraft.ervin_mod_1.item.tool.IItemTier4;
import com.babcsany.minecraft.ervin_mod_1.item.tool.TieredItem;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Set;

public class ToolItem extends TieredItem implements IVanishable {
   /** Hardcoded set of blocks this tool can properly dig at full speed. Modders see instead. */
   private final Set<Block> effectiveBlocks;
   protected final float efficiency;
   private final float attackDamage;

   public ToolItem(IItemTier2 tier, float attackDamageIn, Set<Block> effectiveBlocksIn, Item.Properties builderIn) {
      super(tier, builderIn);
      this.effectiveBlocks = effectiveBlocksIn;
      this.efficiency = tier.getEfficiency();
      this.attackDamage = attackDamageIn + tier.getAttackDamage();
   }

   public float getDestroySpeed(ItemStack stack, BlockState state) {
      if (getToolTypes(stack).stream().anyMatch(e -> state.isToolEffective(e))) return efficiency;
      return this.effectiveBlocks.contains(state.getBlock()) ? this.efficiency : 1.0F;
   }

   /**
    * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
    * the damage on the stack.
    */
   public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
      stack.damageItem(0, attacker, (p_220039_0_) -> {
         p_220039_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
      });
      return true;
   }

   /**
    * Called when a Block is destroyed using this Item. Return true to trigger the "Use Item" statistic.
    */
   public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
      if (!worldIn.isRemote && state.getBlockHardness(worldIn, pos) != 0.0F) {
         stack.damageItem(0, entityLiving, (LivingEntity) -> {
            LivingEntity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
         });
      }

      return true;
   }

   public float func_234675_d_() {
      return this.attackDamage;
   }
}