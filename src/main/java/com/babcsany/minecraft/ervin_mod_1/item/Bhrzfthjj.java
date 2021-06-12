package com.babcsany.minecraft.ervin_mod_1.item;

import com.babcsany.minecraft.ervin_mod_1.util.SeismicWave;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import com.google.common.collect.ImmutableMultimap.Builder;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.*;

public class Bhrzfthjj extends Item implements IVanishable {
    public static final Map<UUID, List<SeismicWave>> WAVES = new HashMap();
    private final Multimap<Attribute, AttributeModifier> attributeModifiers;

    public Bhrzfthjj(Properties properties) {
        super(properties.maxStackSize(64));
        Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", 8.0D, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -3.0D, AttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    public boolean canDisableShield(ItemStack stack, ItemStack shield, LivingEntity entity, LivingEntity attacker) {
        return true;
    }

    public EquipmentSlotType getEquipmentSlot(ItemStack stack) {
        return EquipmentSlotType.MAINHAND;
    }

    public boolean func_77644_a(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damageItem(1, attacker, (e) -> e.getItemStackFromSlot(EquipmentSlotType.MAINHAND));
        return true;
    }

    public boolean func_179218_a(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if (state.getComparatorInputOverride(worldIn, pos) != 0.0F) {
            stack.damageItem(2, entityLiving, (e) -> {
                e.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
            });
        }

        return true;
    }

    /*public ActionResult<ItemStack> func_77659_a(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if (rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.SOURCE_ONLY).getType() == RayTraceResult.Type.MISS) {
            return ActionResult.func_226250_c_(stack);
        } else {
            if (!worldIn.field_72995_K) {
                List<SeismicWave> list = new ArrayList();
                Vector3d vec = playerIn.func_70040_Z();
                int x = MathHelper.func_76128_c(playerIn.func_226277_ct_() + vec.field_72450_a * 1.0D);
                int y = MathHelper.func_76128_c(playerIn.func_174813_aQ().field_72338_b);
                int z = MathHelper.func_76128_c(playerIn.func_226281_cx_() + vec.field_72449_c * 1.0D);
                int x1 = MathHelper.func_76128_c(playerIn.func_226277_ct_() + vec.field_72450_a * 8.0D);
                int z1 = MathHelper.func_76128_c(playerIn.func_226281_cx_() + vec.field_72449_c * 8.0D);
                SeismicWave.createWaves(worldIn, list, x, z, x1, z1, y);
                addWave(playerIn.func_110124_au(), list);
            }

            worldIn.playSound(playerIn, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS, SoundCategory.BLOCKS, 0.8F, 0.8F + playerIn.func_70681_au().nextFloat() * 0.4F);
            playerIn.func_184811_cZ().func_185145_a(this, 25);
            playerIn.func_71029_a(Stats.field_75929_E.func_199076_b(this));
            stack.func_222118_a(1, playerIn, (e) -> {
                e.func_213334_d(handIn);
            });
            return ActionResult.func_233538_a_(stack, worldIn.field_72995_K);
        }
    }*/

    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot, ItemStack stack) {
        return slot == EquipmentSlotType.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(slot, stack);
    }

    public static void addWave(UUID name, List<SeismicWave> list) {
        List<SeismicWave> waves = null;

        List waves1;
        for(Iterator var3 = WAVES.values().iterator(); var3.hasNext(); waves = waves1) {
            waves1 = (List)var3.next();
        }

        if (waves == null) {
            WAVES.put(name, list);
        } else {
            waves.addAll(list);
            WAVES.put(name, waves);
        }

    }
}
