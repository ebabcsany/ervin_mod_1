package com.babcsany.minecraft.ervin_mod_1.item.item.icsvre;

import com.babcsany.minecraft.ervin_mod_1.entity.living.Living;
import com.babcsany.minecraft.ervin_mod_1.forge.common.extensions.IForgeIcsvre;
import com.babcsany.minecraft.ervin_mod_1.item.entity.icsvre.IIcsvreProvider;
import com.babcsany.minecraft.ervin_mod_1.item.entity.icsvre.IcsvreEntity;
import com.babcsany.minecraft.ervin_mod_1.item.item.stack.IcsvreStack;
import com.babcsany.minecraft.ervin_mod_1.tags.ItemTag;
import com.babcsany.minecraft.forge.hooks.ForgeHooks;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tags.ITag;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.extensions.IForgeItem;
import net.minecraftforge.registries.RegistryManager;

import javax.annotation.Nullable;
import java.util.*;

public class Icsvre extends Item implements IIcsvreProvider, IForgeIcsvre {
   public static final Map<Block, Item> BLOCK_TO_ITEM = net.minecraftforge.registries.GameData.getBlockItemMap();
   public static final Map<Block, Icsvre> BLOCK_TO_ICSVRE = getBlockIcsvreMap();
   private static final ResourceLocation BLOCK_TO_ICSVRE_MAP = new ResourceLocation("ervin_mod_1:blocktoicsvremap");
   public static final UUID ATTACK_DAMAGE_MODIFIER = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");
   public static final UUID ATTACK_SPEED_MODIFIER = UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA3");
   public static final Random random = new Random();
   public final ItemGroup group;
   private final Rarity rarity;
   private PlayerEntity player;
   private final int maxStackSize;
   private final int maxDamage;
   private final boolean burnable;
   private final Icsvre containerItem;
   private static Icsvre icsvre;
   private static Item.Properties properties1;
   @Nullable
   private String translationKey;
   @Nullable
   private final Food food;
   private Living living;

   public static int getIdFromItem(Item itemIn) {
      return itemIn == null ? 0 : Registry.ITEM.getId(itemIn);
   }

   public static Icsvre getItemById(int id) {
      return item(Registry.ITEM.getByValue(id));
   }

   public static Icsvre icsvre(Map<Block, Icsvre> item) {
      return icsvre;
   }

   @SuppressWarnings("unchecked")
   public static Map<Block, Icsvre> getBlockIcsvreMap()
   {
      return (Map<Block, Icsvre>) icsvre(RegistryManager.ACTIVE.getRegistry(Item.class).getSlaveMap(BLOCK_TO_ICSVRE_MAP, Map.class));
   }

   public static Icsvre item(Item item) {
      return icsvre;
   }

   @Deprecated
   public static Icsvre getItemFromBlock(Block blockIn) {
      return item(BLOCK_TO_ITEM.getOrDefault(blockIn, Items.AIR));
   }

   public Icsvre(Properties properties, Item.Properties properties1) {
      super(properties1);
      this.group = properties.group;
      this.rarity = properties.rarity;
      this.containerItem = properties.containerItem;
      this.maxDamage = properties.maxDamage;
      this.maxStackSize = properties.maxStackSize;
      this.food = properties.food;
      this.burnable = properties.burnable;
      this.canRepair = properties.canRepair;
      this.toolClasses.putAll(properties.toolClasses);
      Object tmp = properties.ister == null ? null : net.minecraftforge.fml.DistExecutor.callWhenOn(Dist.CLIENT, properties.ister);
      this.ister = tmp == null ? null : () -> (net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer) tmp;
   }

   /**
    * Called as the item is being used by an entity.
    */
   public void onUse(World worldIn, LivingEntity livingEntityIn, IcsvreStack stack, int count) {
   }

   /**
    * Called when an IcsvreStack with NBT data is read to potentially that IcsvreStack's NBT data
    */
   public boolean updateItemStackNBT(CompoundNBT nbt) {
      return false;
   }

   public boolean canPlayerBreakBlockWhileHolding(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
      return true;
   }

   public Icsvre asItem() {
      return icsvre;
   }

   /**
    * Called when this item is used when targetting a Block
    */
   public ActionResultType onItemUse(IcsvreUseContext context) {
      return ActionResultType.PASS;
   }

   public float getDestroySpeed(IcsvreStack stack, BlockState state) {
      return 1.0F;
   }

   /**
    * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
    * {@link #onItemUse}.
    */
   public ActionResult<IcsvreStack> onIcsvreRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
      if (this.isFood()) {
         IcsvreStack icsvreStack = living.getHeldIcsvre(handIn);
         if (playerIn.canEat(this.getFood().canEatWhenFull())) {
            playerIn.setActiveHand(handIn);
            return ActionResult.resultConsume(icsvreStack);
         } else {
            return ActionResult.resultFail(icsvreStack);
         }
      } else {
         return ActionResult.resultPass(living.getHeldIcsvre(handIn));
      }
   }

   /**
    * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
    * the Item before the action is complete.
    */
   public IcsvreStack onItemUseFinish(IcsvreStack stack, World worldIn, LivingEntity entityLiving) {
      return this.isFood() ? living.onFoodEaten(worldIn, stack) : stack;
   }

   /**
    * Returns the maximum size of the stack for a specific item.
    */
   public final int getIcsvreMaxStackSize() {
      return this.maxStackSize;
   }

   @Nullable
   public IcsvreEntity dropItem(IcsvreStack itemStackIn, boolean unused) {
      return ForgeHooks.onPlayerTossEvent(player, itemStackIn, false);
   }

   /**
    * Returns the maximum damage an item can take.
    */
   public final int getIcsvreMaxDamage() {
      return this.maxDamage;
   }

   public boolean isDamageable() {
      return this.maxDamage > 0;
   }

   /**
    * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
    * the damage on the stack.
    */
   public boolean hitEntity(IcsvreStack stack, LivingEntity target, LivingEntity attacker) {
      return false;
   }

   /**
    * Called when a Block is destroyed using this Item. Return true to trigger the "Use Item" statistic.
    */
   public boolean onBlockDestroyed(IcsvreStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
      return false;
   }

   /**
    * Check whether this Item can harvest the given Block
    */
   public boolean canHarvestBlock(BlockState blockIn) {
      return false;
   }

   /**
    * Returns true if the item can be used on the given entity, e.g. shears on sheep.
    */
   public ActionResultType itemInteractionForEntity(IcsvreStack stack, PlayerEntity playerIn, LivingEntity target, Hand hand) {
      return ActionResultType.PASS;
   }

   @OnlyIn(Dist.CLIENT)
   public ITextComponent getName() {
      return new TranslationTextComponent(this.getTranslationKey());
   }

   public Item item;

   public String toString() {
      return Registry.ITEM.getKey(item).getPath();
   }

   protected String getDefaultTranslationKey() {
      if (this.translationKey == null) {
         this.translationKey = Util.makeTranslationKey("item", Registry.ITEM.getKey(item));
      }

      return this.translationKey;
   }

   /**
    * Returns the unlocalized name of this item.
    */
   public String getTranslationKey() {
      return this.getDefaultTranslationKey();
   }

   /**
    * Returns the unlocalized name of this item. This version accepts an IcsvreStack so different stacks can have
    * different names based on their damage or NBT.
    */
   public String getTranslationKey(IcsvreStack stack) {
      return this.getTranslationKey();
   }

   /**
    * If this function returns true (or the item is damageable), the IcsvreStack's NBT tag will be sent to the client.
    */
   public boolean shouldSyncTag() {
      return true;
   }

   @Nullable
   @Deprecated // Use IcsvreStack sensitive version.
   public final Icsvre getContainerItem_() {
      return this.containerItem;
   }

   /**
    * True if this Item has a container item (a.k.a. crafting result)
    */
   @Deprecated // Use IcsvreStack sensitive version.
   public boolean hasContainerItem() {
      return this.containerItem != null;
   }

   /**
    * Called each tick as long the item is on a player inventory. Uses by maps to check if is on a player hand and
    * update it's contents.
    */
   public void inventoryTick(IcsvreStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
   }

   /**
    * Called when item is crafted/smelted. Used only by maps so far.
    */
   public void onCreated(IcsvreStack stack, World worldIn, PlayerEntity playerIn) {
   }

   /**
    * Returns {@code true} if this is a complex item.
    */
   public boolean isComplex() {
      return false;
   }

   /**
    * returns the action that specifies what animation to play when the items is being used
    */
   public UseAction getUseAction(IcsvreStack stack) {
      return stack.getIcsvre().isFood() ? UseAction.EAT : UseAction.NONE;
   }

   /**
    * How long it takes to use or consume an item
    */
   public int getUseDuration(ItemStack stack) {
      if (stack.getItem().isFood()) {
         return this.getFood().isFastEating() ? 16 : 32;
      } else {
         return 0;
      }
   }

   /**
    * Called when the player stops using an Item (stops holding the right mouse button).
    */
   public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
   }

   /**
    * allows items to add custom lines of information to the mouseover description
    */
   @OnlyIn(Dist.CLIENT)
   public void addInformation(IcsvreStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
   }

   public ITextComponent getDisplayName(IcsvreStack stack) {
      return new TranslationTextComponent(this.getTranslationKey(stack));
   }

   /**
    * Returns true if this item has an enchantment glint. By default, this returns <code>stack.isItemEnchanted()</code>,
    * but other items can override it (for instance, written books always return true).
    *
    * Note that if you override this method, you generally want to also call the super version (on {@link Item}) to get
    * the glint for enchanted items. Of course, that is unnecessary if the overwritten version always returns true.
    */
   public boolean hasEffect(IcsvreStack stack) {
      return stack.isEnchanted();
   }

   /**
    * Return an item rarity from EnumRarity
    */
   public Rarity getRarity(IcsvreStack stack) {
      if (!stack.isEnchanted()) {
         return this.rarity;
      } else {
         switch(this.rarity) {
            case COMMON:
            case UNCOMMON:
               return Rarity.RARE;
            case RARE:
               return Rarity.EPIC;
            case EPIC:
            default:
               return this.rarity;
         }
      }
   }

   /**
    * Checks isDamagable and if it cannot be stacked
    */
   public boolean isEnchantable(IcsvreStack stack) {
      return this.getIcsvreStackLimit(stack) == 1 && this.isDamageable();
   }

   protected static BlockRayTraceResult rayTrace(World worldIn, PlayerEntity player, RayTraceContext.FluidMode fluidMode) {
      float f = player.rotationPitch;
      float f1 = player.rotationYaw;
      Vector3d vector3d = player.getEyePosition(1.0F);
      float f2 = MathHelper.cos(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
      float f3 = MathHelper.sin(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
      float f4 = -MathHelper.cos(-f * ((float)Math.PI / 180F));
      float f5 = MathHelper.sin(-f * ((float)Math.PI / 180F));
      float f6 = f3 * f4;
      float f7 = f2 * f4;
      double d0 = player.getAttribute(net.minecraftforge.common.ForgeMod.REACH_DISTANCE.get()).getValue();;
      Vector3d vector3d1 = vector3d.add((double)f6 * d0, (double)f5 * d0, (double)f7 * d0);
      return worldIn.rayTraceBlocks(new RayTraceContext(vector3d, vector3d1, RayTraceContext.BlockMode.OUTLINE, fluidMode, player));
   }

   /**
    * Return the enchantability factor of the item, most of the time is based on material.
    */
   public int getItemEnchantability() {
      return 0;
   }

   /**
    * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
    */
   public void fillIcsvreGroup(ItemGroup group, NonNullList<IcsvreStack> items) {
      if (this.isInGroup(group)) {
         items.add(new IcsvreStack(this));
      }

   }

   protected boolean isInGroup(ItemGroup group) {
      if (getCreativeTabs().stream().anyMatch(tab -> tab == group)) return true;
      ItemGroup itemgroup = this.getGroup_();
      return itemgroup != null && (group == ItemGroup.SEARCH || group == itemgroup);
   }

   /**
    * gets the CreativeTab this item is displayed on
    */
   @Nullable
   public final ItemGroup getGroup_() {
      return this.group;
   }

   /**
    * Return whether this item is repairable in an anvil.
    */
   public boolean getIsRepairable(IcsvreStack toRepair, IcsvreStack repair) {
      return false;
   }

   /**
    * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
    */
   @Deprecated // Use IcsvreStack sensitive version.
   public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
      return ImmutableMultimap.of();
   }

   @Nullable
   private final java.util.function.Supplier<net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer> ister;
   private final Map<net.minecraftforge.common.ToolType, Integer> toolClasses = Maps.newHashMap();
   private final net.minecraftforge.common.util.ReverseTagWrapper<Icsvre> reverseTags = new net.minecraftforge.common.util.ReverseTagWrapper<>(this, ItemTag::getCollectionIcsvre);
   protected final boolean canRepair;

   public boolean isRepairable(IcsvreStack stack) {
      return canRepair && isDamageable();
   }

   public java.util.Set<net.minecraftforge.common.ToolType> getToolTypes(IcsvreStack stack) {
      return toolClasses.keySet();
   }

   public int getHarvestLevel(IcsvreStack stack, net.minecraftforge.common.ToolType tool, @Nullable PlayerEntity player, @Nullable BlockState blockState) {
      return toolClasses.getOrDefault(tool, -1);
   }

   @Override
   public Icsvre getIcsvre() {
      return IForgeIcsvre.super.getIcsvre();
   }

   @Override
   public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot, IcsvreStack stack) {
      return IForgeIcsvre.super.getAttributeModifiers(slot, stack);
   }

   @Override
   public boolean onDroppedByPlayer(IcsvreStack icsvre, PlayerEntity player) {
      return IForgeIcsvre.super.onDroppedByPlayer(icsvre, player);
   }

   @Override
   public ITextComponent getHighlightTip(IcsvreStack icsvre, ITextComponent displayName) {
      return IForgeIcsvre.super.getHighlightTip(icsvre, displayName);
   }

   @Override
   public ActionResultType onIcsvreUseFirst(IcsvreStack stack, IcsvreUseContext context) {
      return IForgeIcsvre.super.onIcsvreUseFirst(stack, context);
   }

   @Override
   public boolean isZurCurrency(ItemStack stack) {
      return IForgeIcsvre.super.isZurCurrency(stack);
   }

   @Override
   public boolean isZurCurrency(IcsvreStack stack) {
      return IForgeIcsvre.super.isZurCurrency(stack);
   }

   @Override
   public boolean isRepairable(ItemStack stack) {
      return false;
   }

   @Override
   public IcsvreStack getContainerItem(IcsvreStack itemStack) {
      return IForgeIcsvre.super.getContainerItem(itemStack);
   }

   @Override
   public boolean hasContainerItem(IcsvreStack stack) {
      return IForgeIcsvre.super.hasContainerItem(stack);
   }

   @Override
   public int getEntityLifespan(IcsvreStack itemStack, World world) {
      return IForgeIcsvre.super.getEntityLifespan(itemStack, world);
   }

   @Override
   public boolean onEntityItemUpdate(IcsvreStack stack, IcsvreEntity entity) {
      return IForgeIcsvre.super.onEntityItemUpdate(stack, entity);
   }

   @Override
   public int getIcsvreStackLimit(IcsvreStack stack) {
      return IForgeIcsvre.super.getIcsvreStackLimit(stack);
   }

   @Override
   public int getDamage(IcsvreStack stack) {
      return IForgeIcsvre.super.getDamage(stack);
   }

   @Override
   public Set<ToolType> getToolTypes(ItemStack stack) {
      return null;
   }

   @Override
   public int getHarvestLevel(ItemStack stack, ToolType tool, @Nullable PlayerEntity player, @Nullable BlockState blockState) {
      return 0;
   }

   @OnlyIn(Dist.CLIENT)
   public final net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer getIcsvreStackTileEntityRenderer() {
      net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer renderer = ister != null ? ister.get() : null;
      return renderer != null ? renderer : net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer.instance;
   }

   @Override
   public java.util.Set<ResourceLocation> getTags() {
      return reverseTags.getTagNames();
   }

   /**
    * If this icsvreStack's item is a crossbow
    */
   public boolean isCrossbow(ItemStack stack) {
      return stack.getItem() == Items.CROSSBOW;
   }

   public IcsvreStack getDefaultInstance_() {
      return new IcsvreStack(this);
   }

   public boolean isInIcsvre(ITag<Icsvre> tagIn) {
      return tagIn.contains(this);
   }

   public boolean isFood() {
      return this.food != null;
   }

   @Nullable
   public Food getFood() {
      return this.food;
   }

   public SoundEvent getDrinkSound() {
      return SoundEvents.ENTITY_GENERIC_DRINK;
   }

   public SoundEvent getEatSound() {
      return SoundEvents.ENTITY_GENERIC_EAT;
   }

   public boolean isBurnable() {
      return this.burnable;
   }

   public boolean isDamageable(DamageSource damageSource) {
      return !this.burnable || !damageSource.isFireDamage();
   }

   public static class Properties {
      private int maxStackSize = 2048;
      private int maxDamage;
      private Icsvre containerItem;
      private ItemGroup group;
      private Rarity rarity = Rarity.COMMON;
      /** Sets food information to this item */
      private Food food;
      private com.babcsany.minecraft.ervin_mod_1.init.item.food.Food modFood;
      private boolean burnable;
      private boolean canRepair = true;
      private Map<net.minecraftforge.common.ToolType, Integer> toolClasses = Maps.newHashMap();
      private java.util.function.Supplier<java.util.concurrent.Callable<net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer>> ister;
      private Item.Properties properties;

      public Properties food(Food foodIn) {
         this.food = foodIn;
         return this;
      }

      public Properties modFood(com.babcsany.minecraft.ervin_mod_1.init.item.food.Food foodIn) {
         this.modFood = foodIn;
         return this;
      }

      public Properties maxStackSize(int maxStackSizeIn) {
         if (this.maxDamage > 0) {
            throw new RuntimeException("Unable to have damage AND stack.");
         } else {
            this.maxStackSize = maxStackSizeIn;
            return this;
         }
      }

      public Properties defaultMaxDamage(int maxDamageIn) {
         return this.maxDamage == 0 ? this.maxDamage(maxDamageIn) : this;
      }

      public Properties maxDamage(int maxDamageIn) {
         this.maxDamage = maxDamageIn;
         this.maxStackSize = 1;
         return this;
      }

      public Properties containerItem(Icsvre containerItemIn) {
         this.containerItem = containerItemIn;
         return this;
      }

      public Properties group(ItemGroup groupIn) {
         this.group = groupIn;
         return this;
      }

      public Properties rarity(Rarity rarityIn) {
         this.rarity = rarityIn;
         return this;
      }

      public Properties isBurnable() {
         this.burnable = true;
         return this;
      }

      public Properties setNoRepair() {
         canRepair = false;
         return this;
      }

      public Properties addToolType(net.minecraftforge.common.ToolType type, int level) {
         toolClasses.put(type, level);
         return this;
      }

      public Properties setISTER(java.util.function.Supplier<java.util.concurrent.Callable<net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer>> ister) {
         this.ister = ister;
         return this;
      }

      public Item.Properties properties(Item.Properties properties) {
         this.properties = properties;
         return properties;
      }
   }
}
