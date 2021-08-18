package com.babcsany.minecraft.item.icsvre;

import com.babcsany.minecraft.ervin_mod_1.entity.living.Living;
import com.babcsany.minecraft.ervin_mod_1.item.entity.icsvre.IIcsvreProvider;
import com.babcsany.minecraft.ervin_mod_1.item.entity.icsvre.IcsvreEntity;
import com.babcsany.minecraft.ervin_mod_1.item.item.icsvre.Icsvre;
import com.babcsany.minecraft.ervin_mod_1.item.item.stack.IcsvreStack;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Multimap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IDispenseItemBehavior;
import net.minecraft.dispenser.IPosition;
import net.minecraft.enchantment.IArmorVanishable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ArmorIcsvre extends Icsvre implements IArmorVanishable {
   private static final UUID[] ARMOR_MODIFIERS = new UUID[]{UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"), UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"), UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"), UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150")};
   /*public static final ArmorIcsvre DISPENSER_BEHAVIOR = new ArmorIcsvre() {
      /**
       * Dispense the specified stack, play the dispense sound and spawn particles.
       * /
      protected IcsvreStack dispenseStack(IBlockSource source, IcsvreStack stack) {
         return ArmorIcsvre.func_226626_a_(source, stack) ? stack : super.dispenseStack(source, stack);
      }
   };*/

   IDispenseItemBehavior iDispenseItemBehavior;

   public static void doDispense(World worldIn, IcsvreStack stack, int speed, Direction facing, IPosition position) {
      double d0 = position.getX();
      double d1 = position.getY();
      double d2 = position.getZ();
      if (facing.getAxis() == Direction.Axis.Y) {
         d1 = d1 - 0.125D;
      } else {
         d1 = d1 - 0.15625D;
      }

      IcsvreEntity itementity = new IcsvreEntity(worldIn, d0, d1, d2, stack);
      double d3 = worldIn.rand.nextDouble() * 0.1D + 0.2D;
      itementity.setMotion(worldIn.rand.nextGaussian() * (double)0.0075F * (double)speed + (double)facing.getXOffset() * d3, worldIn.rand.nextGaussian() * (double)0.0075F * (double)speed + (double)0.2F, worldIn.rand.nextGaussian() * (double)0.0075F * (double)speed + (double)facing.getZOffset() * d3);
      worldIn.addEntity(itementity);
   }

   protected IcsvreStack dispenseStack(IBlockSource source, IcsvreStack stack) {
      Direction direction = source.getBlockState().get(DispenserBlock.FACING);
      IPosition iposition = DispenserBlock.getDispensePosition(source);
      IcsvreStack itemstack = stack.split(1);
      doDispense(source.getWorld(), itemstack, 6, direction, iposition);
      return stack;
   }

   protected final EquipmentSlotType slot;
   private final int damageReduceAmount;
   private final float toughness;
   protected final float field_234655_c_;
   protected final IArmorMaterial material;
   private final Multimap<Attribute, AttributeModifier> field_234656_m_;

   public static boolean func_226626_a_(IBlockSource blockSource, IcsvreStack stack) {
      BlockPos blockpos = blockSource.getBlockPos().offset(blockSource.getBlockState().get(DispenserBlock.FACING));
      List<Living> list = blockSource.getWorld().getEntitiesWithinAABB(Living.class, new AxisAlignedBB(blockpos), EntityPredicates.NOT_SPECTATING.and(new com.babcsany.minecraft.util.EntityPredicates.ArmoredMob(stack)));
      if (list.isEmpty()) {
         return false;
      } else {
         Living living = list.get(0);
         EquipmentSlotType equipmentslottype = Living.getSlotForIcsvreStack(stack);
         IcsvreStack itemstack = stack.split(1);
         living.setItemStackToSlot(equipmentslottype, itemstack);
         //if (living instanceof Living) {
            living.setDropChance(equipmentslottype, 2.0F);
            living.enablePersistence();
         //}

         return true;
      }
   }

   public ArmorIcsvre(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn, Item.Properties builder1In) {
      super(builderIn, builder1In.defaultMaxDamage(materialIn.getDurability(slot)));
      this.material = materialIn;
      this.slot = slot;
      this.damageReduceAmount = materialIn.getDamageReductionAmount(slot);
      this.toughness = materialIn.getToughness();
      this.field_234655_c_ = materialIn.getKnockbackResistance();
      //DispenserBlock.registerDispenseBehavior(this, DISPENSER_BEHAVIOR.iDispenseItemBehavior);
      Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
      UUID uuid = ARMOR_MODIFIERS[slot.getIndex()];
      builder.put(Attributes.ARMOR, new AttributeModifier(uuid, "Armor modifier", this.damageReduceAmount, AttributeModifier.Operation.ADDITION));
      builder.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(uuid, "Armor toughness", this.toughness, AttributeModifier.Operation.ADDITION));
      if (this.field_234655_c_ > 0) {
         builder.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(uuid, "Armor knockback resistance", this.field_234655_c_, AttributeModifier.Operation.ADDITION));
      }

      this.field_234656_m_ = builder.build();
   }

   private static final Map<Icsvre, IDispenseItemBehavior> DISPENSE_BEHAVIOR_REGISTRY = Util.make(new Object2ObjectOpenHashMap<>(), (behaviour) -> {
      behaviour.defaultReturnValue(new DefaultDispenseItemBehavior());
   });

   public static void registerDispenseBehavior(IIcsvreProvider itemIn, IDispenseItemBehavior behavior) {
      DISPENSE_BEHAVIOR_REGISTRY.put(itemIn.asItem(), behavior);
   }

   /**
    * Gets the equipment slot of this armor piece (formerly known as armor type)
    */
   public EquipmentSlotType getEquipmentSlot() {
      return this.slot;
   }

   /**
    * Return the enchantability factor of the item, most of the time is based on material.
    */
   public int getItemEnchantability() {
      return this.material.getEnchantability();
   }

   public IArmorMaterial getArmorMaterial() {
      return this.material;
   }

   /**
    * Return whether this item is repairable in an anvil.
    */
   public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
      return this.material.getRepairMaterial().test(repair) || super.getIsRepairable(toRepair, repair);
   }

   /**
    * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
    * {@link #onItemUse}.
    */
   public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
      ItemStack itemstack = playerIn.getHeldItem(handIn);
      EquipmentSlotType equipmentslottype = MobEntity.getSlotForItemStack(itemstack);
      ItemStack itemstack1 = playerIn.getItemStackFromSlot(equipmentslottype);
      if (itemstack1.isEmpty()) {
         playerIn.setItemStackToSlot(equipmentslottype, itemstack.copy());
         itemstack.setCount(0);
         return ActionResult.func_233538_a_(itemstack, worldIn.isRemote());
      } else {
         return ActionResult.resultFail(itemstack);
      }
   }

   /**
    * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
    */
   public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
      return equipmentSlot == this.slot ? this.field_234656_m_ : super.getAttributeModifiers(equipmentSlot);
   }

   public int getDamageReduceAmount() {
      return this.damageReduceAmount;
   }

   public float func_234657_f_() {
      return this.toughness;
   }
}
