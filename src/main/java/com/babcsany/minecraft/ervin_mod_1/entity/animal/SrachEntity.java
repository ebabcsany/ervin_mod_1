package com.babcsany.minecraft.ervin_mod_1.entity.animal;

import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.BlockFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.SpecialBlockFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.isBurnableFoodItemInit;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

public class SrachEntity extends CowEntity {
   private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(new IItemProvider[]{com.babcsany.minecraft.ervin_mod_1.init.item.item.ItemInit.TARG.get(), SpecialBlockFoodItemInit.FIRG.get(), SpecialBlockFoodItemInit.FIRG_SLAB.get(), SpecialBlockFoodItemInit.FIRG_STAIRS.get(), isBurnableFoodItemInit.GRINT.get(), SpecialBlockFoodItemInit.GRINT_BLOCK.get(), SpecialBlockFoodItemInit.GRINT_SLAB.get(), SpecialBlockFoodItemInit.GRINT_STAIRS.get(), isBurnableFoodItemInit.DURG.get(), BlockFoodItemInit.SCRAFTH.get()});

   public SrachEntity(EntityType<? extends SrachEntity> type, World worldIn) {
      super(type, worldIn);
   }

   protected void registerGoals() {
      this.goalSelector.addGoal(0, new SwimGoal(this));
      this.goalSelector.addGoal(1, new PanicGoal(this, 2.0D));
      this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
      this.goalSelector.addGoal(3, new TemptGoal(this, 1.25D, Ingredient.fromItems(new IItemProvider[]{com.babcsany.minecraft.ervin_mod_1.init.item.item.ItemInit.TARG.get(), SpecialBlockFoodItemInit.FIRG.get(), SpecialBlockFoodItemInit.FIRG_SLAB.get(), SpecialBlockFoodItemInit.FIRG_STAIRS.get(), isBurnableFoodItemInit.GRINT.get(), SpecialBlockFoodItemInit.GRINT_BLOCK.get(), SpecialBlockFoodItemInit.GRINT_SLAB.get(), SpecialBlockFoodItemInit.GRINT_STAIRS.get(), isBurnableFoodItemInit.DURG.get(), BlockFoodItemInit.SCRAFTH.get()}), false));
      this.goalSelector.addGoal(4, new TemptGoal(this, 1.25D, false, TEMPTATION_ITEMS));
      this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
      this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
      this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
      this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
   }

   public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
      return CowEntity.registerAttributes();
   }

   public ActionResultType onJurking(PlayerEntity player, Hand hand) {
      ItemStack heldItem = player.getHeldItem(hand);
      if (heldItem.getItem() == Items.BUCKET && !this.isChild()) {
         player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
         ItemStack drinkHelper = DrinkHelper.fill(heldItem, player, ItemInit.JURK_BUCKET.get().getDefaultInstance());
         player.setHeldItem(hand, drinkHelper);
         return ActionResultType.func_233537_a_(this.world.isRemote);
      } else {
         return super.getEntityInteractionResult(player, hand);
      }
   }

   public ActionResultType getEntityInteractionResult(PlayerEntity player, Hand hand) {
      return this.onJurking(player, hand);
   }

   public SrachEntity createChild(ServerWorld serverWorld, AgeableEntity ageable) {
      return EntityInit.SRACH_ENTITY.get().create(this.world);
   }

   public boolean isBreedingItem(ItemStack stack) {
      return TEMPTATION_ITEMS.test(stack);
   }

   protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
      return this.isChild() ? sizeIn.height * 0.95F : 1.3F;
   }
}