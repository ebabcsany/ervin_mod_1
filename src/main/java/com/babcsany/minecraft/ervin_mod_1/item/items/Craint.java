package com.babcsany.minecraft.ervin_mod_1.item.items;

import com.babcsany.minecraft.ervin_mod_1.item.tool.IItemTier2;
import com.babcsany.minecraft.ervin_mod_1.item.tool.TieredItem;
import com.babcsany.minecraft.ervin_mod_1.item.tool.TieredItem_1;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import com.mojang.datafixers.types.templates.List;
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

import java.util.Arrays;
import java.util.Collections;

public class Craint extends ToolItem_1 implements IVanishable {
   private final float attackDamage;
   /** Modifiers applied when the item is in the mainhand of a user. */
   private final Multimap<Attribute, AttributeModifier> attributeModifiers;

   public Craint(IItemTier tier, int attackDamageIn, Properties builderIn) {
      super(tier, attackDamageIn, Collections.emptyList(), builderIn);
      this.attackDamage = (float)attackDamageIn + tier.getAttackDamage();
      Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
      builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", this.attackDamage, AttributeModifier.Operation.ADDITION));
      this.attributeModifiers = builder.build();
   }

   public float getAttackDamage() {
      return this.attackDamage;
   }

   /**
    * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
    * @return
    */
   public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
      return equipmentSlot == EquipmentSlotType.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(equipmentSlot);
   }
}