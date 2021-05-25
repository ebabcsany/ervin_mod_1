package com.babcsany.minecraft.ervin_mod_1.item;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.entity.item.ModBoatEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BoatItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class ModBoatItem extends Item {
    private static final Predicate<Entity> RIDERS = EntityPredicates.NOT_SPECTATING.and(Entity::canBeCollidedWith);
    private final ModBoatEntity.ModBoatType type;

    public ModBoatItem(ModBoatEntity.ModBoatType type, Item.Properties properties) {
        super(properties);
        this.type = type;
    }

    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getHeldItem(hand);
        RayTraceResult rayTraceResult = rayTrace(world, player, RayTraceContext.FluidMode.ANY);
        if (rayTraceResult.getType() == RayTraceResult.Type.MISS) {
            return ActionResult.resultPass(itemStack);
        } else {
            Vector3d vec3d = player.getLook(1.0F);
            double d = 5.0D;
            List<Entity> list = world.getEntitiesInAABBexcluding(player, player.getBoundingBox().expand(vec3d.scale(5.0D)).grow(1.0D), RIDERS);
            if (!list.isEmpty()) {
                Vector3d vec3d2 = player.getEyePosition(1.0F);
                Iterator var11 = list.iterator();

                while(var11.hasNext()) {
                    Entity entity = (Entity) var11.next();
                    AxisAlignedBB box = entity.getBoundingBox().grow(entity.getCollisionBorderSize());
                    if (box.contains(vec3d2)) {
                        return ActionResult.resultPass(itemStack);
                    }
                }
            }

            if (rayTraceResult.getType() == RayTraceResult.Type.BLOCK) {
                ModBoatEntity boat = new ModBoatEntity(world, rayTraceResult.getHitVec().x, rayTraceResult.getHitVec().y, rayTraceResult.getHitVec().z);
                Ervin_mod_1.LOGGER.info("BOAT ENTITY: " + boat);
                boat.setModBoatType(this.type);
                boat.rotationYaw = player.rotationYaw;
                if (!world.hasNoCollisions(boat, boat.getBoundingBox().grow(-0.1D))) {
                    return ActionResult.resultFail(itemStack);
                } else {
                    if (!world.isRemote) {
                        world.addEntity(boat);
                        if (!player.abilities.isCreativeMode) {
                            itemStack.shrink(1);
                        }
                    }

                    player.addStat(Stats.ITEM_USED.get(this));
                    return ActionResult.func_233538_a_(itemStack, world.isRemote());
                }
            } else {
                return ActionResult.resultPass(itemStack);
            }
        }
    }
}
