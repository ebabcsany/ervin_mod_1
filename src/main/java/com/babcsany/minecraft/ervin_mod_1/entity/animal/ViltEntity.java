package com.babcsany.minecraft.ervin_mod_1.entity.animal;

import com.babcsany.minecraft.ervin_mod_1.entity.ai.FollowParentGoal1;
import com.babcsany.minecraft.ervin_mod_1.init.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.item.DyeColor1;
import com.babcsany.minecraft.ervin_mod_1.item.DyeItem1;
import com.babcsany.minecraft.ervin_mod_1.world.storage.loot.LootTables1;
import com.google.common.collect.Maps;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
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
import net.minecraft.world.storage.loot.LootTables;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class ViltEntity extends AnimalEntity implements net.minecraftforge.common.IShearable {
   private static final DataParameter<Byte> DYE_COLOR = EntityDataManager.createKey(ViltEntity.class, DataSerializers.BYTE);
   private static final Map<DyeColor1, IItemProvider> WOOL_BY_COLOR = Util.make(Maps.newEnumMap(DyeColor1.class), (p_203402_0_) -> {
      p_203402_0_.put(DyeColor1.WHITE, Blocks.WHITE_WOOL);
      p_203402_0_.put(DyeColor1.ORANGE, Blocks.ORANGE_WOOL);
      p_203402_0_.put(DyeColor1.MAGENTA, Blocks.MAGENTA_WOOL);
      p_203402_0_.put(DyeColor1.LIGHT_BLUE, Blocks.LIGHT_BLUE_WOOL);
      p_203402_0_.put(DyeColor1.YELLOW, Blocks.YELLOW_WOOL);
      p_203402_0_.put(DyeColor1.LIME, Blocks.LIME_WOOL);
      p_203402_0_.put(DyeColor1.PINK, Blocks.PINK_WOOL);
      p_203402_0_.put(DyeColor1.GRAY, Blocks.GRAY_WOOL);
      p_203402_0_.put(DyeColor1.LIGHT_GRAY, Blocks.LIGHT_GRAY_WOOL);
      p_203402_0_.put(DyeColor1.CYAN, Blocks.CYAN_WOOL);
      p_203402_0_.put(DyeColor1.PURPLE, Blocks.PURPLE_WOOL);
      p_203402_0_.put(DyeColor1.BLUE, Blocks.BLUE_WOOL);
      p_203402_0_.put(DyeColor1.BROWN, Blocks.BROWN_WOOL);
      p_203402_0_.put(DyeColor1.GREEN, Blocks.GREEN_WOOL);
      p_203402_0_.put(DyeColor1.RED, Blocks.RED_WOOL);
      p_203402_0_.put(DyeColor1.BLACK, Blocks.BLACK_WOOL);
      p_203402_0_.put(DyeColor1.CRASK, BlockInit.CRASK.get());
   });
   /** Map from EnumDyeColor to RGB values for passage to GlStateManager.color() */
   private static final Map<DyeColor1, float[]> DYE_TO_RGB = Maps.newEnumMap(Arrays.stream(DyeColor1.values()).collect(Collectors.toMap((DyeColor1 p_200204_0_) -> {
      return p_200204_0_;
   }, ViltEntity::createViltColor)));
   private int viltTimer;
   private EatGrassGoal eatGrassGoal;

   private static float[] createViltColor(DyeColor1 dyeColor1In) {
      if (dyeColor1In == DyeColor1.CRASK) {
         return new float[]{0.9019608F, 0.9019608F, 0.9019608F};
      } else {
         float[] afloat = dyeColor1In.getColorComponentValues();
         float f = 0.75F;
         return new float[]{afloat[0] * 0.75F, afloat[1] * 0.75F, afloat[2] * 0.75F};
      }
   }

   @OnlyIn(Dist.CLIENT)
   public static float[] getDyeRgb1(DyeColor1 dyeColor1) {
      return DYE_TO_RGB.get(dyeColor1);
   }

   public ViltEntity(EntityType<? extends ViltEntity> type, World worldIn) {
      super(type, worldIn);
   }

   protected void registerGoals() {
      this.eatGrassGoal = new EatGrassGoal(this);
      this.goalSelector.addGoal(0, new SwimGoal(this));
      this.goalSelector.addGoal(1, new PanicGoal(this, 55.0D));
      this.goalSelector.addGoal(2, new BreedGoal(this, 52.0D));
      this.goalSelector.addGoal(3, new TemptGoal(this, 50.0D, Ingredient.fromItems(ItemInit.VILTDROP.get()), false));
      this.goalSelector.addGoal(4, new FollowParentGoal(this, 21.0D));
      this.goalSelector.addGoal(5, this.eatGrassGoal);
      this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 42.0D));
      this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 28.0F));
      this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
   }

   protected void updateAITasks() {
      this.viltTimer = this.eatGrassGoal.getEatingGrassTimer();
      super.updateAITasks();
   }

   /**
    * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
    * use this to react to sunlight and start to burn.
    */
   public void livingTick() {
      if (this.world.isRemote) {
         this.viltTimer = Math.max(0, this.viltTimer - 1);
      }

      super.livingTick();
   }

   protected void registerAttributes() {
      super.registerAttributes();
      this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100000.0D);
      this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)35.0F);
   }

   protected void registerData() {
      super.registerData();
      this.dataManager.register(DYE_COLOR, (byte)0);
   }

   public ResourceLocation getLootTable() {
      if (this.getSheared1()) {
         return this.getType().getLootTable();
      } else {
         switch(this.getFleeceColor1()) {
         case CRASK:
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
         case RED:
            return LootTables.ENTITIES_SHEEP_RED;
         case BLACK:
            return LootTables.ENTITIES_SHEEP_BLACK;
         case WHITE:
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
         this.viltTimer = 40;
      } else {
         super.handleStatusUpdate(id);
      }

   }

   @OnlyIn(Dist.CLIENT)
   public float getHeadRotationPointY(float p_70894_1_) {
      if (this.viltTimer <= 0) {
         return 0.0F;
      } else if (this.viltTimer >= 4 && this.viltTimer <= 36) {
         return 1.0F;
      } else {
         return this.viltTimer < 4 ? ((float)this.viltTimer - p_70894_1_) / 4.0F : -((float)(this.viltTimer - 40) - p_70894_1_) / 4.0F;
      }
   }

   @OnlyIn(Dist.CLIENT)
   public float getHeadRotationAngleX(float p_70890_1_) {
      if (this.viltTimer > 4 && this.viltTimer <= 36) {
         float f = ((float)(this.viltTimer - 4) - p_70890_1_) / 32.0F;
         return ((float)Math.PI / 5F) + 0.21991149F * MathHelper.sin(f * 28.7F);
      } else {
         return this.viltTimer > 0 ? ((float)Math.PI / 5F) : this.rotationPitch * ((float)Math.PI / 180F);
      }
   }

   public boolean processInteract(PlayerEntity player, Hand hand) {
      ItemStack itemstack = player.getHeldItem(hand);
      if (false && itemstack.getItem() == Items.SHEARS && !this.getSheared1() && !this.isChild()) { //Forge: Moved to onSheared
         this.func_213612_dV();
         if (!this.world.isRemote) {
            itemstack.damageItem(1, player, (p_213613_1_) -> {
               p_213613_1_.sendBreakAnimation(hand);
            });
         }

         return true;
      } else {
         return super.processInteract(player, hand);
      }
   }

   @Deprecated //Forge: Use Shearable interface
   public void func_213612_dV() {
      if (!this.world.isRemote) {
         this.setSheared(true);
         int i = 1 + this.rand.nextInt(3);

         for(int j = 0; j < i; ++j) {
            ItemEntity itementity = this.entityDropItem(WOOL_BY_COLOR.get(this.getFleeceColor1()), 1);
            if (itementity != null) {
               itementity.setMotion(itementity.getMotion().add((double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F), (double)(this.rand.nextFloat() * 0.05F), (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F)));
            }
         }
      }

      this.playSound(SoundEvents.ENTITY_SHEEP_SHEAR, 1.0F, 1.0F);
   }

   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
      compound.putBoolean("Sheared", this.getSheared1());
      compound.putByte("Color", (byte)this.getFleeceColor1().getId());
   }

   /**
    * (abstract) Protected helper method to read subclass entity data from NBT.
    */
   public void readAdditional(CompoundNBT compound) {
      super.readAdditional(compound);
      this.setSheared(compound.getBoolean("Sheared"));
      this.setFleeceColor1(DyeColor1.byId(compound.getByte("Color")));
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
   public DyeColor1 getFleeceColor1() {
      return DyeColor1.byId(this.dataManager.get(DYE_COLOR) & 15);
   }

   /**
    * Sets the wool color of this sheep
    */
   public void setFleeceColor1(DyeColor1 color) {
      byte b0 = this.dataManager.get(DYE_COLOR);
      this.dataManager.set(DYE_COLOR, (byte)(b0 & 240 | color.getId() & 15));
   }

   /**
    * returns true if a sheeps wool has been sheared
    */
   public boolean getSheared1() {
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
   public static DyeColor1 getRandomViltColor(Random random) {
      int i = random.nextInt(100);
      if (i < 5) {
         return DyeColor1.BLACK;
      } else if (i < 10) {
         return DyeColor1.GRAY;
      } else if (i < 15) {
         return DyeColor1.LIGHT_GRAY;
      } else if (i < 18) {
         return DyeColor1.BROWN;
      } else if (i < 21) {
         return DyeColor1.CRASK;
      } else {
         return random.nextInt(500) == 0 ? DyeColor1.PINK : DyeColor1.WHITE;
      }
   }

   public ViltEntity createChild(AgeableEntity ageable) {
      ViltEntity viltentity = (ViltEntity)ageable;
      ViltEntity viltentity1 = EntityInit.VILT_ENTITY.get().create(this.world);
      viltentity1.setFleeceColor1(this.getDyeColor1MixFromParents(this, viltentity));
      return viltentity1;
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
      this.setFleeceColor1(getRandomViltColor(worldIn.getRandom()));
      return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
   }

   /**
    * Attempts to mix both parent sheep to come up with a mixed dye color.
    */
   private DyeColor1 getDyeColor1MixFromParents(AnimalEntity father, AnimalEntity mother) {
      DyeColor1 dyecolor = ((ViltEntity)father).getFleeceColor1();
      DyeColor1 dyecolor1 = ((ViltEntity)mother).getFleeceColor1();
      CraftingInventory craftinginventory = createDyeColorCraftingInventory(dyecolor, dyecolor1);
      return this.world.getRecipeManager().getRecipe(IRecipeType.CRAFTING, craftinginventory, this.world).map((p_213614_1_) -> {
         return p_213614_1_.getCraftingResult(craftinginventory);
      }).map(ItemStack::getItem).filter(DyeItem1.class::isInstance).map(DyeItem1.class::cast).map(DyeItem1::getDyeColor1).orElseGet(() -> {
         return this.world.rand.nextBoolean() ? dyecolor : dyecolor1;
      });
   }

   private static CraftingInventory createDyeColorCraftingInventory(DyeColor1 color, DyeColor1 color1) {
      CraftingInventory craftinginventory = new CraftingInventory(new Container((ContainerType)null, -1) {
         /**
          * Determines whether supplied player can use this container
          */
         public boolean canInteractWith(PlayerEntity playerIn) {
            return false;
         }
      }, 2, 1);
      craftinginventory.setInventorySlotContents(0, new ItemStack(DyeItem1.getItem(color)));
      craftinginventory.setInventorySlotContents(1, new ItemStack(DyeItem1.getItem(color1)));
      return craftinginventory;
   }

   protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
      return 0.95F * sizeIn.height;
   }

   @Override
   public boolean isShearable(ItemStack item, net.minecraft.world.IWorldReader world, BlockPos pos) {
      return !this.getSheared1() && !this.isChild();
   }

   @Override
   public java.util.List<ItemStack> onSheared(ItemStack item, IWorld world, BlockPos pos, int fortune) {
      java.util.List<ItemStack> ret = new java.util.ArrayList<>();
      if (!this.world.isRemote) {
         this.setSheared(true);
         int i = 1 + this.rand.nextInt(3);

         for(int j = 0; j < i; ++j) {
            ret.add(new ItemStack(WOOL_BY_COLOR.get(this.getFleeceColor1())));
         }
      }
      this.playSound(SoundEvents.ENTITY_SHEEP_SHEAR, 1.0F, 1.0F);
      return ret;
   }
}