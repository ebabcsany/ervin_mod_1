package com.babcsany.minecraft.ervin_mod_1.item;

public class Hk {
    /*public static final Map<UUID, List<SeismicWave>> WAVES = new HashMap();
    private final Multimap<Attribute, AttributeModifier> attributeModifiers;

    public Hk(Item.Properties properties) {
        super(properties.maxStackSize(64));
        Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(field_111210_e, "Weapon modifier", 8.0D, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(field_185050_h, "Weapon modifier", -3.0D, AttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    public boolean canDisableShield(ItemStack stack, ItemStack shield, LivingEntity entity, LivingEntity attacker) {
        return true;
    }

    public EquipmentSlotType getEquipmentSlot(ItemStack stack) {
        return EquipmentSlotType.MAINHAND;
    }

    public boolean func_77644_a(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.write(1, attacker, (e) -> e.func_213361_c(EquipmentSlotType.MAINHAND));
        return true;
    }

    public boolean func_179218_a(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if (state.func_185887_b(worldIn, pos) != 0.0F) {
            stack.func_222118_a(2, entityLiving, (e) -> {
                e.func_213361_c(EquipmentSlotType.MAINHAND);
            });
        }

        return true;
    }

    public ActionResult<ItemStack> func_77659_a(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if (func_77644_a(worldIn, playerIn, RayTraceContext.FluidMode.SOURCE_ONLY).getType() == RayTraceResult.Type.MISS) {
            return ActionResult.resultSuccess(stack);
        } else {
            if (!worldIn.field_72995_K) {
                List<SeismicWave> list = new ArrayList();
                Vector3d vec = playerIn.getLookVec();
                int x = MathHelper.func_76128_c(playerIn.func_226277_ct_() + vec.field_72450_a * 1.0D);
                int y = MathHelper.func_76128_c(playerIn.func_174813_aQ().field_72338_b);
                int z = MathHelper.func_76128_c(playerIn.func_226281_cx_() + vec.field_72449_c * 1.0D);
                int x1 = MathHelper.func_76128_c(playerIn.func_226277_ct_() + vec.field_72450_a * 8.0D);
                int z1 = MathHelper.func_76128_c(playerIn.func_226281_cx_() + vec.field_72449_c * 8.0D);
                SeismicWave.createWaves(worldIn, list, x, z, x1, z1, y);
                addWave(playerIn.func_110124_au(), list);
            }

            worldIn.func_184148_a(playerIn, playerIn.func_226277_ct_(), playerIn.func_226278_cu_(), playerIn.func_226281_cx_(), SoundEvents.field_187539_bB, SoundCategory.BLOCKS, 0.8F, 0.8F + playerIn.func_70681_au().nextFloat() * 0.4F);
            playerIn.func_184811_cZ().func_185145_a(this, 25);
            playerIn.func_71029_a(Stats.field_75929_E.func_199076_b(this));
            stack.func_222118_a(1, playerIn, (e) -> {
                e.func_213334_d(handIn);
            });
            return ActionResult.func_233538_a_(stack, worldIn.field_72995_K);
        }
    }

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

    }*/
}
