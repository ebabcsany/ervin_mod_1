package com.babcsany.minecraft.ervin_mod_1.item;

import com.babcsany.minecraft.ervin_mod_1.entity.item.FirgBoatEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Predicate;

public class FirgBoatItem extends Item {
   private static final Predicate<Entity> field_219989_a = EntityPredicates.NOT_SPECTATING.and(Entity::canBeCollidedWith);
   private final FirgBoatEntity.Type1 type;

   public FirgBoatItem(FirgBoatEntity.Type1 typeIn, Properties properties) {
      super(properties);
      this.type = typeIn;
   }

   /**
    * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
    * {@link #onItemUse}.
    */
   public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
      ItemStack itemstack = playerIn.getHeldItem(handIn);
      RayTraceResult raytraceresult = rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.ANY);
      if (raytraceresult.getType() == RayTraceResult.Type.MISS) {
         return ActionResult.resultPass(itemstack);
      } else {
         Vec3d vec3d = playerIn.getLook(1.0F);
         double d0 = 5.0D;
         List<Entity> list = worldIn.getEntitiesInAABBexcluding(playerIn, playerIn.getBoundingBox().expand(vec3d.scale(5.0D)).grow(1.0D), field_219989_a);
         if (!list.isEmpty()) {
            Vec3d vec3d1 = playerIn.getEyePosition(1.0F);

            for(Entity entity : list) {
               AxisAlignedBB axisalignedbb = entity.getBoundingBox().grow((double)entity.getCollisionBorderSize());
               if (axisalignedbb.contains(vec3d1)) {
                  return ActionResult.resultPass(itemstack);
               }
            }
         }

         if (raytraceresult.getType() == RayTraceResult.Type.BLOCK) {
            FirgBoatEntity firgboatentity = new FirgBoatEntity(worldIn, raytraceresult.getHitVec().x, raytraceresult.getHitVec().y, raytraceresult.getHitVec().z);
            firgboatentity.setModBoatType(this.type);
            firgboatentity.rotationYaw = playerIn.rotationYaw;
            if (!worldIn.hasNoCollisions(firgboatentity, firgboatentity.getBoundingBox().grow(-0.1D))) {
               return ActionResult.resultFail(itemstack);
            } else {
               if (!worldIn.isRemote) {
                  worldIn.addEntity(firgboatentity);
                  if (!playerIn.abilities.isCreativeMode) {
                     itemstack.shrink(1);
                  }
               }

               playerIn.addStat(Stats.ITEM_USED.get(this));
               return ActionResult.resultSuccess(itemstack);
            }
         } else {
            return ActionResult.resultPass(itemstack);
         }
      }
   }
}