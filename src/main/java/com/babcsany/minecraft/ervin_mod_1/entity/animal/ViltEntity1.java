package com.babcsany.minecraft.ervin_mod_1.entity.animal;

import com.babcsany.minecraft.ervin_mod_1.init.init.DyeColorInit;
import com.babcsany.minecraft.ervin_mod_1.init.init.DyeItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
import com.babcsany.minecraft.ervin_mod_1.world.storage.loot.LootTables1;
import com.google.common.collect.Maps;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.DyeColor;
import net.minecraft.item.DyeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.loot.LootTables;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class ViltEntity1 extends AnimalEntity implements IShearable, net.minecraftforge.common.IForgeShearable {
   private static final DataParameter<Byte> DYE_COLOR = EntityDataManager.createKey(ViltEntity1.class, DataSerializers.BYTE);
   private static final Map<DyeColorInit, IItemProvider> WOOL_BY_COLOR = Util.make(Maps.newEnumMap(DyeColorInit.class), (p_203402_0_) -> {
      p_203402_0_.put(DyeColorInit.RED, isBurnableBlockItemInit.CRASK.get());
      p_203402_0_.put(DyeColorInit.WHITE, Blocks.WHITE_WOOL);
      p_203402_0_.put(DyeColorInit.ORANGE, Blocks.ORANGE_WOOL);
      p_203402_0_.put(DyeColorInit.MAGENTA, Blocks.MAGENTA_WOOL);
      p_203402_0_.put(DyeColorInit.LIGHT_BLUE, Blocks.LIGHT_BLUE_WOOL);
      p_203402_0_.put(DyeColorInit.YELLOW, Blocks.YELLOW_WOOL);
      p_203402_0_.put(DyeColorInit.LIME, Blocks.LIME_WOOL);
      p_203402_0_.put(DyeColorInit.PINK, Blocks.PINK_WOOL);
      p_203402_0_.put(DyeColorInit.GRAY, Blocks.GRAY_WOOL);
      p_203402_0_.put(DyeColorInit.LIGHT_GRAY, Blocks.LIGHT_GRAY_WOOL);
      p_203402_0_.put(DyeColorInit.CYAN, Blocks.CYAN_WOOL);
      p_203402_0_.put(DyeColorInit.PURPLE, Blocks.PURPLE_WOOL);
      p_203402_0_.put(DyeColorInit.BLUE, Blocks.BLUE_WOOL);
      p_203402_0_.put(DyeColorInit.BROWN, Blocks.BROWN_WOOL);
      p_203402_0_.put(DyeColorInit.GREEN, Blocks.GREEN_WOOL);
      p_203402_0_.put(DyeColorInit.BLACK, Blocks.BLACK_WOOL);
   });
   /** Map from EnumDyeColor to RGB values for passage to GlStateManager.color() */
   private static final Map<DyeColorInit, float[]> DYE_TO_RGB = Maps.newEnumMap(Arrays.stream(DyeColorInit.values()).collect(Collectors.toMap((DyeColorInit p_200204_0_) -> {
      return p_200204_0_;
   }, ViltEntity1::createSheepColor)));
   private int sheepTimer;
   private EatGrassGoal eatGrassGoal;

   private static float[] createSheepColor(DyeColorInit dyeColorIn) {
      if (dyeColorIn == DyeColorInit.RED) {
         return new float[]{0.9019608F, 0.9019608F, 0.9019608F};
      } else {
         float[] afloat = dyeColorIn.getColorComponentValues();
         float f = 0.75F;
         return new float[]{afloat[0] * 0.75F, afloat[1] * 0.75F, afloat[2] * 0.75F};
      }
   }

   @OnlyIn(Dist.CLIENT)
   public static float[] getDyeRgb(DyeColorInit dyeColor) {
      return DYE_TO_RGB.get(dyeColor);
   }

   public ViltEntity1(EntityType<? extends ViltEntity1> type, World worldIn) {
      super(type, worldIn);
   }

   protected void registerGoals() {
      this.eatGrassGoal = new EatGrassGoal(this);
      this.goalSelector.addGoal(0, new SwimGoal(this));
      this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
      this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
      this.goalSelector.addGoal(3, new TemptGoal(this, 10.0D, Ingredient.fromItems(isBurnableItemInit.VILTDROP.get()), false));
      this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
      this.goalSelector.addGoal(5, this.eatGrassGoal);
      this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
      this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
      this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
   }

   protected void updateAITasks() {
      this.sheepTimer = this.eatGrassGoal.getEatingGrassTimer();
      super.updateAITasks();
   }

   /**
    * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
    * use this to react to sunlight and start to burn.
    */
   public void livingTick() {
      if (this.world.isRemote) {
         this.sheepTimer = Math.max(0, this.sheepTimer - 1);
      }

      super.livingTick();
   }

   public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
      return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 80.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.92F).createMutableAttribute(Attributes.ATTACK_DAMAGE, 2.0D);
   }

   protected void registerData() {
      super.registerData();
      this.dataManager.register(DYE_COLOR, (byte)0);
   }

   public ResourceLocation getLootTable() {
      if (this.getSheared()) {
         return this.getType().getLootTable();
      } else {
         switch(this.getFleeceColor()) {
            case RED:
         default:
            return LootTables1.ENTITIES_VILT1;
         case ORANGE:
            return LootTables.ENTITIES_SHEEP_ORANGE;
         case MAGENTA:
            return LootTables.ENTITIES_SHEEP_MAGENTA;
         case LIGHT_BLUE:
            return LootTables.ENTITIES_SHEEP_LIGHT_BLUE;
         case YELLOW:
            return LootTables.ENTITIES_SHEEP_YELLOW;
         case LIME:
            return LootTables.ENTITIES_SHEEP_LIME;
         case PINK:
            return LootTables.ENTITIES_SHEEP_PINK;
         case GRAY:
            return LootTables.ENTITIES_SHEEP_GRAY;
         case LIGHT_GRAY:
            return LootTables.ENTITIES_SHEEP_LIGHT_GRAY;
         case CYAN:
            return LootTables.ENTITIES_SHEEP_CYAN;
         case PURPLE:
            return LootTables.ENTITIES_SHEEP_PURPLE;
         case BLUE:
            return LootTables.ENTITIES_SHEEP_BLUE;
         case BROWN:
            return LootTables.ENTITIES_SHEEP_BROWN;
         case GREEN:
            return LootTables.ENTITIES_SHEEP_GREEN;
         case WHITE:
            return LootTables.ENTITIES_SHEEP_WHITE;
         case BLACK:
            return LootTables.ENTITIES_SHEEP_BLACK;
         }
      }
   }

   /**
    * Handler for {@link World#setEntityState}
    */
   @OnlyIn(Dist.CLIENT)
   public void handleStatusUpdate(byte id) {
      if (id == 10) {
         this.sheepTimer = 40;
      } else {
         super.handleStatusUpdate(id);
      }

   }

   @OnlyIn(Dist.CLIENT)
   public float getHeadRotationPointY(float p_70894_1_) {
      if (this.sheepTimer <= 0) {
         return 0.0F;
      } else if (this.sheepTimer >= 4 && this.sheepTimer <= 36) {
         return 1.0F;
      } else {
         return this.sheepTimer < 4 ? ((float)this.sheepTimer - p_70894_1_) / 4.0F : -((float)(this.sheepTimer - 40) - p_70894_1_) / 4.0F;
      }
   }

   @OnlyIn(Dist.CLIENT)
   public float getHeadRotationAngleX(float p_70890_1_) {
      if (this.sheepTimer > 4 && this.sheepTimer <= 36) {
         float f = ((float)(this.sheepTimer - 4) - p_70890_1_) / 32.0F;
         return ((float)Math.PI / 5F) + 0.21991149F * MathHelper.sin(f * 28.7F);
      } else {
         return this.sheepTimer > 0 ? ((float)Math.PI / 5F) : this.rotationPitch * ((float)Math.PI / 180F);
      }
   }

   public ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
      ItemStack itemstack = p_230254_1_.getHeldItem(p_230254_2_);
      if (false && itemstack.getItem() == Items.SHEARS) { //Forge: Moved to onSheared
         if (!this.world.isRemote && this.isShearable()) {
            this.shear(SoundCategory.PLAYERS);
            itemstack.damageItem(1, p_230254_1_, (p_213613_1_) -> {
               p_213613_1_.sendBreakAnimation(p_230254_2_);
            });
            return ActionResultType.SUCCESS;
         } else {
            return ActionResultType.CONSUME;
         }
      } else {
         return super.func_230254_b_(p_230254_1_, p_230254_2_);
      }
   }

   public void shear(SoundCategory category) {
      this.world.playMovingSound(null, this, SoundEvents.ENTITY_SHEEP_SHEAR, category, 1.0F, 1.0F);
      this.setSheared(true);
      int i = 1 + this.rand.nextInt(3);

      for(int j = 0; j < i; ++j) {
         ItemEntity itementity = this.entityDropItem(WOOL_BY_COLOR.get(this.getFleeceColor()), 1);
         if (itementity != null) {
            itementity.setMotion(itementity.getMotion().add((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F, (double)(this.rand.nextFloat() * 0.05F), (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F)));
         }
      }

   }

   public boolean isShearable() {
      return this.isAlive() && !this.getSheared() && !this.isChild();
   }

   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
      compound.putBoolean("Sheared", this.getSheared());
      compound.putByte("Color", (byte)this.getFleeceColor().getId());
   }

   /**
    * (abstract) Protected helper method to read subclass entity data from NBT.
    */
   public void readAdditional(CompoundNBT compound) {
      super.readAdditional(compound);
      this.setSheared(compound.getBoolean("Sheared"));
      this.setFleeceColor(DyeColorInit.byId(compound.getByte("Color")));
   }

   protected SoundEvent getAmbientSound() {
      return SoundEvents.ENTITY_SHEEP_AMBIENT;
   }

   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return SoundEvents.ENTITY_SHEEP_HURT;
   }

   protected SoundEvent getDeathSound() {
      return SoundEvents.ENTITY_SHEEP_DEATH;
   }

   protected void playStepSound(BlockPos pos, BlockState blockIn) {
      this.playSound(SoundEvents.ENTITY_SHEEP_STEP, 0.15F, 1.0F);
   }

   /**
    * Gets the wool color of this sheep.
    */
   public DyeColorInit getFleeceColor() {
      return DyeColorInit.byId(this.dataManager.get(DYE_COLOR) & 15);
   }

   public DyeColor getFleece1Color() {
      return DyeColor.byId(this.dataManager.get(DYE_COLOR) & 15);
   }

   /**
    * Sets the wool color of this sheep
    */
   public void setFleeceColor(DyeColorInit color) {
      byte b0 = this.dataManager.get(DYE_COLOR);
      this.dataManager.set(DYE_COLOR, (byte)(b0 & 240 | color.getId() & 15));
   }

   /**
    * returns true if a sheeps wool has been sheared
    */
   public boolean getSheared() {
      return (this.dataManager.get(DYE_COLOR) & 16) != 0;
   }

   /**
    * make a sheep sheared if set to true
    */
   public void setSheared(boolean sheared) {
      byte b0 = this.dataManager.get(DYE_COLOR);
      if (sheared) {
         this.dataManager.set(DYE_COLOR, (byte)(b0 | 16));
      } else {
         this.dataManager.set(DYE_COLOR, (byte)(b0 & -17));
      }

   }

   /**
    * Chooses a "vanilla" sheep color based on the provided random.
    */
   public static DyeColorInit getRandomSheepColor(Random random) {
      int i = random.nextInt(100);
      if (i < 5) {
         return DyeColorInit.BLACK;
      } else if (i < 10) {
         return DyeColorInit.GRAY;
      } else if (i < 15) {
         return DyeColorInit.LIGHT_GRAY;
      } else if (i < 18) {
         return DyeColorInit.BROWN;
      } else {
         return random.nextInt(500) == 0 ? DyeColorInit.PINK : DyeColorInit.RED;
      }
   }

   public ViltEntity createChild(AgeableEntity ageable) {
      ViltEntity viltEntity = (ViltEntity)ageable;
      ViltEntity viltEntity1 = EntityInit.VILT_ENTITY.get().create(this.world);
      viltEntity1.setFleeceColor(this.getDyeColorMixFromParents(this, viltEntity));
      return viltEntity1;
   }

   /**
    * This function applies the benefits of growing back wool and faster growing up to the acting entity. (This function
    * is used in the AIEatGrass)
    */
   public void eatGrassBonus() {
      this.setSheared(false);
      if (this.isChild()) {
         this.addGrowth(60);
      }

   }

   @Nullable
   public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
      this.setFleeceColor(getRandomSheepColor(worldIn.getRandom()));
      return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
   }

   /**
    * Attempts to mix both parent sheep to come up with a mixed dye color.
    */
   private DyeColorInit getDyeColorInitMixFromParents(AnimalEntity father, AnimalEntity mother) {
      DyeColorInit dyecolor = ((ViltEntity1)father).getFleeceColor();
      DyeColorInit dyecolor1 = ((ViltEntity1)mother).getFleeceColor();
      CraftingInventory craftinginventory = createDyeColorInitCraftingInventory(dyecolor, dyecolor1);
      return this.world.getRecipeManager().getRecipe(IRecipeType.CRAFTING, craftinginventory, this.world).map((p_213614_1_) -> {
         return p_213614_1_.getCraftingResult(craftinginventory);
      }).map(ItemStack::getItem).filter(DyeItem.class::isInstance).map(DyeItemInit.class::cast).map(DyeItemInit::getDyeColor).orElseGet(() -> {
         return this.world.rand.nextBoolean() ? dyecolor : dyecolor1;
      });
   }

   private DyeColor getDyeColorMixFromParents(AnimalEntity father, AnimalEntity mother) {
      DyeColor dyecolor = ((ViltEntity1)father).getFleece1Color();
      DyeColor dyecolor1 = ((ViltEntity1)mother).getFleece1Color();
      CraftingInventory craftinginventory = createDyeColorCraftingInventory(dyecolor, dyecolor1);
      return this.world.getRecipeManager().getRecipe(IRecipeType.CRAFTING, craftinginventory, this.world).map((p_213614_1_) -> {
         return p_213614_1_.getCraftingResult(craftinginventory);
      }).map(ItemStack::getItem).filter(DyeItem.class::isInstance).map(DyeItem.class::cast).map(DyeItem::getDyeColor).orElseGet(() -> {
         return this.world.rand.nextBoolean() ? dyecolor : dyecolor1;
      });
   }

   private static CraftingInventory createDyeColorInitCraftingInventory(DyeColorInit color, DyeColorInit color1) {
      CraftingInventory craftinginventory = new CraftingInventory(new Container((ContainerType)null, -1) {
         /**
          * Determines whether supplied player can use this container
          */
         public boolean canInteractWith(PlayerEntity playerIn) {
            return false;
         }
      }, 2, 1);
      craftinginventory.setInventorySlotContents(0, new ItemStack(DyeItemInit.getItem(color)));
      craftinginventory.setInventorySlotContents(1, new ItemStack(DyeItemInit.getItem(color1)));
      return craftinginventory;
   }

   private static CraftingInventory createDyeColorCraftingInventory(DyeColor color, DyeColor color1) {
      CraftingInventory craftinginventory = new CraftingInventory(new Container((ContainerType)null, -1) {
         /**
          * Determines whether supplied player can use this container
          */
         public boolean canInteractWith(PlayerEntity playerIn) {
            return false;
         }
      }, 2, 1);
      craftinginventory.setInventorySlotContents(0, new ItemStack(DyeItem.getItem(color)));
      craftinginventory.setInventorySlotContents(1, new ItemStack(DyeItem.getItem(color1)));
      return craftinginventory;
   }

   protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
      return 0.95F * sizeIn.height;
   }

   @Override
   public boolean isShearable(@javax.annotation.Nonnull ItemStack item, World world, BlockPos pos) {
      return isShearable();
   }

   @javax.annotation.Nonnull
   @Override
   public java.util.List<ItemStack> onSheared(@Nullable PlayerEntity player, @javax.annotation.Nonnull ItemStack item, World world, BlockPos pos, int fortune) {
      world.playMovingSound(null, this, SoundEvents.ENTITY_SHEEP_SHEAR, player == null ? SoundCategory.BLOCKS : SoundCategory.PLAYERS, 1.0F, 1.0F);
      if (!world.isRemote) {
         this.setSheared(true);
         int i = 1 + this.rand.nextInt(3);

         java.util.List<ItemStack> items = new java.util.ArrayList<>();
         for (int j = 0; j < i; ++j) {
            items.add(new ItemStack(WOOL_BY_COLOR.get(this.getFleeceColor())));
         }
         return items;
      }
      return java.util.Collections.emptyList();
   }
}