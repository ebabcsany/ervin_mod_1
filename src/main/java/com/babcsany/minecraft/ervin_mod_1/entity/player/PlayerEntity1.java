package com.babcsany.minecraft.ervin_mod_1.entity.player;

import com.babcsany.minecraft.ervin_mod_1.init.item.special.isBurnableSpecialItemInit;
import com.babcsany.minecraft.ervin_mod_1.item.entity.icsvre.IcsvreEntity;
import com.babcsany.minecraft.ervin_mod_1.item.item.stack.IcsvreStack;
import com.babcsany.minecraft.forge.hooks.ForgeHooks;
import com.mojang.authlib.GameProfile;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.CachedBlockInfo;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.IForgeRegistryEntry;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public abstract class PlayerEntity1 extends PlayerEntity {
   PlayerEntity player;
   public PlayerEntity1(World p_i231577_1_, BlockPos p_i231577_2_, GameProfile p_i231577_3_) {
      super(p_i231577_1_, p_i231577_2_, p_i231577_3_);
   }

   public boolean canPlayerEdit(BlockPos pos, Direction facing, IcsvreStack stack) {
      if (this.abilities.allowEdit) {
         return true;
      } else {
         BlockPos blockpos = pos.offset(facing.getOpposite());
         CachedBlockInfo cachedblockinfo = new CachedBlockInfo(this.world, blockpos, false);
         return stack.canPlaceOn(this.world.getTags(), cachedblockinfo);
      }
   }

   @Nullable
   public IcsvreEntity dropItem(IcsvreStack itemStackIn, boolean unused) {
      return ForgeHooks.onPlayerTossEvent(player, itemStackIn, false);
   }

   @Override
   public void tick() {
      super.tick();
      this.updateTurtleHelmet();
   }

   public Supplier<? extends Item> registryObject(Supplier<? extends Item> itemIn) {
      return itemIn;
   }

   public void updateTurtleHelmet() {
      ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
      if (itemstack.getItem() == isBurnableSpecialItemInit.DEBUG_SRIUNK_STICK.get() && !this.areEyesInFluid(FluidTags.WATER)) {
         this.addPotionEffect(new EffectInstance(Effects.HEALTH_BOOST, 40, 1000, true, true, true));
      }

   }
}
