package com.babcsany.minecraft.ervin_mod_1.item.items;

import com.babcsany.minecraft.ervin_mod_1.item.tool.IItemTier2;
import com.babcsany.minecraft.ervin_mod_1.item.tool.TieredBlockItem_1;
import com.babcsany.minecraft.ervin_mod_1.item.tool.TieredItem_1;
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
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Set;

public class ToolBlockItem_1 extends TieredBlockItem_1 implements IVanishable {
   /** Hardcoded set of blocks this tool can properly dig at full speed. Modders see instead. */
   protected final float efficiency;
   private final float attackDamage;
   private final Multimap<Attribute, AttributeModifier> field_234674_d_;

   public ToolBlockItem_1(Block blockIn, float attackDamageIn, IItemTier2 tier, Properties builderIn) {
      super(blockIn, tier, builderIn);
      this.efficiency = tier.getEfficiency();
      this.attackDamage = attackDamageIn + tier.getAttackDamage();
      ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
      builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Tool modifier", this.attackDamage, AttributeModifier.Operation.ADDITION));
      this.field_234674_d_ = builder.build();
   }

   public float getDestroySpeed(ItemStack stack, BlockState state) {
      getToolTypes(stack).stream().anyMatch(state::isToolEffective);
      return this.efficiency;
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
         stack.damageItem(0, entityLiving, (p_220038_0_) -> {
            p_220038_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
         });
      }

      return true;
   }

   /**
    * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
    */
   public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
      return equipmentSlot == EquipmentSlotType.MAINHAND ? this.field_234674_d_ : super.getAttributeModifiers(equipmentSlot);
   }

   public float func_234675_d_() {
      return this.attackDamage;
   }
}