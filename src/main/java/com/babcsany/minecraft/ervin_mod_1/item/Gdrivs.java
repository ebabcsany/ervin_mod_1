package com.babcsany.minecraft.ervin_mod_1.item;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Gdrivs {
    /*public static final String KEY = "entity_holder";

    public Gdrivs(Item.Properties properties) {
        super(properties);
    }

    @Nonnull
    public ActionResultType func_195939_a(ItemUseContext context) {
        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();
        if (player == null) {
            return ActionResultType.FAIL;
        } else {
            ItemStack stack = context.getItem();
            if (!world.isRemote && containsEntity(stack)) {
                Entity entity = getEntityFromStack(stack, world, true);
                BlockPos blockPos = context.getPos();
                entity.getPosition((double)blockPos.getX() + 0.5D, (double)(blockPos.getY() + 1), (double)blockPos.getZ() + 0.5D, 0.0F, 0.0F);
                stack.write(null);
                world.addEntity(entity);
                if (this.createNet()) {
                    stack.func_222118_a(1, player, (playerEntity) -> {
                        playerEntity.func_213334_d(context.func_221531_n());
                    });
                }

                return ActionResultType.SUCCESS;
            } else {
                return ActionResultType.FAIL;
            }
        }
    }

    public ActionResultType func_111207_a(ItemStack stack, PlayerEntity player, LivingEntity target, Hand hand) {
        if (!target.func_130014_f_().field_72995_K && !(target instanceof PlayerEntity) && target.func_70089_S() && !containsEntity(stack)) {
            EntityType<?> entityID = target.func_200600_R();
            if (this.isBlacklisted(entityID)) {
                return ActionResultType.FAIL;
            } else {
                ItemStack newStack = stack.func_77946_l();
                CompoundNBT nbt = getNBTfromEntity(target);
                ItemStack newerStack = newStack.func_77979_a(1);
                newerStack.func_196082_o().func_218657_a("entity_holder", nbt);
                player.func_184609_a(hand);
                player.func_184611_a(hand, newStack);
                if (!player.func_191521_c(newerStack)) {
                    ItemEntity itemEntity = new ItemEntity(player.field_70170_p, player.func_226277_ct_(), player.func_226278_cu_(), player.func_226281_cx_(), newerStack);
                    player.field_70170_p.func_217376_c(itemEntity);
                }

                target.func_70106_y();
                player.func_184811_cZ().func_185145_a(this, 5);
                return ActionResultType.SUCCESS;
            }
        } else {
            return ActionResultType.FAIL;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.func_77624_a(stack, worldIn, tooltip, flagIn);
        if (containsEntity(stack) && !getID(stack).isEmpty()) {
            String s0 = "entity." + getID(stack);
            String s1 = s0.replace(':', '.');
            tooltip.add(new StringTextComponent(I18n.func_135052_a(s1, new Object[0])));
            tooltip.add(new StringTextComponent("Health: " + stack.func_77978_p().func_74775_l("entity_holder").func_74769_h("Health")));
        }

    }

    @Nonnull
    public ITextComponent func_200295_i(@Nonnull ItemStack stack) {
        if (!containsEntity(stack)) {
            return new TranslationTextComponent(super.func_77667_c(stack) + ".name");
        } else {
            String s0 = "entity." + getID(stack);
            String s1 = s0.replace(':', '.');
            return new TranslationTextComponent(I18n.func_135052_a(super.func_77667_c(stack) + ".name", new Object[0]) + ": " + I18n.func_135052_a(s1, new Object[0]));
        }
    }

    public NetEntity createNet(World worldIn, LivingEntity shooter, ItemStack stack) {
        ItemStack newStack = stack.func_77946_l();
        newStack.func_190920_e(1);
        return new NetEntity(shooter.func_226277_ct_(), shooter.func_226278_cu_() + 1.25D, shooter.func_226281_cx_(), worldIn, newStack);
    }

    public static boolean containsEntity(@Nonnull ItemStack stack) {
        return stack.func_77942_o() && stack.func_77978_p().func_74764_b("entity_holder");
    }

    public static String getID(ItemStack stack) {
        return getID(stack.func_77978_p().func_74775_l("entity_holder"));
    }

    public static String getID(CompoundNBT nbt) {
        return nbt.func_74779_i("entity");
    }

    public boolean isBlacklisted(EntityType<?> entity) {
        return Ervin_mod_1.blacklisted.equals(entity);
    }

    public static Entity getEntityFromNBT(CompoundNBT nbt, World world, boolean withInfo) {
        Entity entity = ((EntityType) Registry.ENTITY_TYPE.register(new ResourceLocation(nbt.get(String)))).func_200721_a(world);
        if (withInfo) {
            entity.serializeNBT(nbt);
        }

        return entity;
    }

    public static Entity getEntityFromStack(ItemStack stack, World world, boolean withInfo) {
        return getEntityFromNBT(stack.serializeNBT().getCompound("entity_holder"), world, withInfo);
    }

    public static CompoundNBT getNBTfromEntity(Entity entity) {
        CompoundNBT nbt = new CompoundNBT();
        nbt.contains("entity", Integer.parseInt(Objects.requireNonNull(entity).toString()));
        nbt.contains("id", Integer.parseInt(EntityType.byKey(entity.toString()).toString()));
        entity.serializeNBT(nbt);
        return nbt;
    }*/
}
