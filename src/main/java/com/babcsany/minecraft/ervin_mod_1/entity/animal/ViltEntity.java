package com.babcsany.minecraft.ervin_mod_1.entity.animal;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.FoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.SpecialBlockFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.isBurnableFoodItemInit;
import com.google.common.collect.Maps;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.container.Container;
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
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.IForgeShearable;

import javax.annotation.Nullable;
import java.util.*;
import java.util.stream.Collectors;

public class ViltEntity extends AnimalEntity implements IShearable, IForgeShearable {
    private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(FoodItemInit.FRIM);
    private static final DataParameter<Byte> DYE_COLOR = EntityDataManager.createKey(ViltEntity.class, DataSerializers.BYTE);;
    private static final Map<DyeColor, IItemProvider> WOOL_BY_COLOR = Util.make(Maps.newEnumMap(DyeColor.class), (dyeColorIItemProviderEnumMap) -> {
        dyeColorIItemProviderEnumMap.put(DyeColor.RED, isBurnableBlockItemInit.CRASK);
        dyeColorIItemProviderEnumMap.put(DyeColor.WHITE, Blocks.WHITE_WOOL);
        dyeColorIItemProviderEnumMap.put(DyeColor.ORANGE, Blocks.ORANGE_WOOL);
        dyeColorIItemProviderEnumMap.put(DyeColor.MAGENTA, Blocks.MAGENTA_WOOL);
        dyeColorIItemProviderEnumMap.put(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_WOOL);
        dyeColorIItemProviderEnumMap.put(DyeColor.YELLOW, Blocks.YELLOW_WOOL);
        dyeColorIItemProviderEnumMap.put(DyeColor.LIME, Blocks.LIME_WOOL);
        dyeColorIItemProviderEnumMap.put(DyeColor.PINK, Blocks.PINK_WOOL);
        dyeColorIItemProviderEnumMap.put(DyeColor.GRAY, Blocks.GRAY_WOOL);
        dyeColorIItemProviderEnumMap.put(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_WOOL);
        dyeColorIItemProviderEnumMap.put(DyeColor.CYAN, Blocks.CYAN_WOOL);
        dyeColorIItemProviderEnumMap.put(DyeColor.PURPLE, Blocks.PURPLE_WOOL);
        dyeColorIItemProviderEnumMap.put(DyeColor.BLUE, Blocks.BLUE_WOOL);
        dyeColorIItemProviderEnumMap.put(DyeColor.BROWN, Blocks.BROWN_WOOL);
        dyeColorIItemProviderEnumMap.put(DyeColor.GREEN, Blocks.GREEN_WOOL);
        dyeColorIItemProviderEnumMap.put(DyeColor.BLACK, Blocks.BLACK_WOOL);
    });
    private static final Map<DyeColor, float[]> DYE_TO_RGB = Maps.newEnumMap((Map)Arrays.stream(DyeColor.values()).collect(Collectors.toMap((dyeColor) -> dyeColor, ViltEntity::createViltColor)));;
    private int sheepTimer;
    private EatGrassGoal eatGrassGoal;
    private boolean isAttack = false;

    public ViltEntity(EntityType<? extends ViltEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected void registerGoals() {
        this.eatGrassGoal = new EatGrassGoal(this);
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1));
        this.goalSelector.addGoal(5, this.eatGrassGoal);
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        registerTemptAndAttackGoals();
    }

    protected void registerTemptAndAttackGoals() {
        TemptGoal firstTemptGoal = new TemptGoal(this, 10.0D, Ingredient.fromItems(FoodItemInit.REAT), false);
        TemptGoal secondTemptGoal = new TemptGoal(this, 1.25D, false, TEMPTATION_ITEMS);
        MeleeAttackGoal meleeAttackGoal = new MeleeAttackGoal(this, 1.0D, true);
        NearestAttackableTargetGoal<PlayerEntity> attackPlayerGoal = new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true);
        addTemptGoal(4, firstTemptGoal);
        addTemptGoal(3, secondTemptGoal);
        addTemptGoal(2, 0.3D, false, Ingredient.fromItems(SpecialBlockFoodItemInit.VIRK_BLOCK));
        addTemptGoal(2, 0.3D/9, true, Ingredient.fromItems(isBurnableFoodItemInit.VIRK.get()));
        addTemptGoal(1, 0.36D, true, Ingredient.fromItems(isBurnableFoodItemInit.DURG));
        addTemptGoal(1, 0.04D, true, Ingredient.fromItems(SpecialBlockFoodItemInit.GRINT_BLOCK));
        addTemptGoal(1, 0.02D, true, Ingredient.fromItems(SpecialBlockFoodItemInit.GRINT_SLAB));
        addTemptGoal(1, 0.03D, true, Ingredient.fromItems(SpecialBlockFoodItemInit.GRINT_STAIRS));
        addTemptGoal(0, 0.005D, true, Ingredient.fromItems(SpecialBlockFoodItemInit.FIRG));
        addTemptGoal(0, 0.0025D, true, Ingredient.fromItems(SpecialBlockFoodItemInit.FIRG_SLAB));
        addTemptGoal(0, 0.00375D, true, Ingredient.fromItems(SpecialBlockFoodItemInit.FIRG_STAIRS));
        if (!firstTemptGoal.isRunning() && !secondTemptGoal.isRunning()) {
            this.isAttack = true;
            this.goalSelector.addGoal(5, meleeAttackGoal);
            this.targetSelector.addGoal(6, attackPlayerGoal);
        } else {
            this.isAttack = false;
            this.goalSelector.removeGoal(meleeAttackGoal);
            this.targetSelector.removeGoal(attackPlayerGoal);
        }
    }

    private void addTemptGoal(int priority, TemptGoal temptGoal) {
        this.goalSelector.addGoal(priority, temptGoal);
    }

    private void addTemptGoal(int priority, double speed, boolean scaredByPlayerMovement, Ingredient temptItem) {
        this.goalSelector.addGoal(priority, new TemptGoal(this, speed, scaredByPlayerMovement, temptItem));
    }

    private void addTemptGoal(int priority, double speed, Ingredient temptItem, boolean scaredByPlayerMovement) {
        this.goalSelector.addGoal(priority, new TemptGoal(this, speed, temptItem, scaredByPlayerMovement));
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
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 80.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.36F).createMutableAttribute(Attributes.ATTACK_DAMAGE, 2.0D);
    }

    private static float[] createViltColor(DyeColor dyeColor) {
        if (dyeColor == DyeColor.WHITE) {
            float f = 0.9019608F;
            return new float[]{f, f, f};
        } else {
            float[] afloat = dyeColor.getColorComponentValues();
            float f = 0.75F;
            return new float[]{afloat[0] * f, afloat[1] * f, afloat[2] * f};
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static float[] getDyeRgb(DyeColor dyeColor) {
        return DYE_TO_RGB.get(dyeColor);
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 8.0).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.23000000417232513);
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(DYE_COLOR, (byte)0);
    }

    public void writeAdditional(CompoundNBT nbt) {
        super.writeAdditional(nbt);
        nbt.putBoolean("Sheared", this.getSheared());
        nbt.putByte("Color", (byte)this.getFleeceColor().getId());
    }

    public void readAdditional(CompoundNBT p_70037_1_) {
        super.readAdditional(p_70037_1_);
        this.setSheared(p_70037_1_.getBoolean("Sheared"));
        this.setFleeceColor(DyeColor.byId(p_70037_1_.getByte("Color")));
    }

    public DyeColor getFleeceColor() {
        return DyeColor.byId((Byte)this.dataManager.get(DYE_COLOR) & 15);
    }

    public void setFleeceColor(DyeColor p_175512_1_) {
        byte b0 = (Byte)this.dataManager.get(DYE_COLOR);
        this.dataManager.set(DYE_COLOR, (byte)(b0 & 240 | p_175512_1_.getId() & 15));
    }

    public boolean getSheared() {
        return ((Byte)this.dataManager.get(DYE_COLOR) & 16) != 0;
    }

    public void setSheared(boolean p_70893_1_) {
        byte b0 = (Byte)this.dataManager.get(DYE_COLOR);
        if (p_70893_1_) {
            this.dataManager.set(DYE_COLOR, (byte)(b0 | 16));
        } else {
            this.dataManager.set(DYE_COLOR, (byte)(b0 & -17));
        }
    }

    public ResourceLocation getLootTable() {
        if (this.getSheared()) {
            return this.getType().getLootTable();
        } else {
            switch (this.getFleeceColor()) {
                case RED:
                default:
                    return new ResourceLocation(Ervin_mod_1.MOD_ID, "entities/vilt");
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
            this.sheepTimer = 80;
        } else {
            super.handleStatusUpdate(id);
        }

    }

    @OnlyIn(Dist.CLIENT)
    public float getHeadRotationPointY(float p_70894_1_) {
        if (this.sheepTimer <= 0) {
            return 0.0F;
        } else if (this.sheepTimer >= 4 && this.sheepTimer <= 56) {
            return 1.0F;
        } else {
            return this.sheepTimer < 4 ? ((float) this.sheepTimer - p_70894_1_) / 4.0F : -((float) (this.sheepTimer - 80) - p_70894_1_) / 4.0F;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public float getHeadRotationAngleX(float p_70890_1_) {
        if (this.sheepTimer > 4 && this.sheepTimer <= 56) {
            float f = ((float) (this.sheepTimer - 4) - p_70890_1_) / 32.0F;
            return ((float) Math.PI / 5F) + 0.21991149F * MathHelper.sin(f * 28.7F);
        } else {
            return this.sheepTimer > 0 ? ((float) Math.PI / 5F) : this.rotationPitch * ((float) Math.PI / 180F);
        }
    }

    public ActionResultType getEntityInteractionResult(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        if (itemstack.getItem() == Items.SHEARS) { //Forge: Moved to onSheared
            if (!this.world.isRemote && this.isShearable()) {
                this.shear(SoundCategory.PLAYERS);
                itemstack.damageItem(1, player, (playerEntity) -> playerEntity.sendBreakAnimation(hand));
                return ActionResultType.SUCCESS;
            } else {
                return ActionResultType.CONSUME;
            }
        } else {
            return super.getEntityInteractionResult(player, hand);
        }
    }

    @Override
    public void shear(SoundCategory category) {
        this.world.playMovingSound(null, this, SoundEvents.EVENT_RAID_HORN, category, 1.0F, 1.0F);
        this.setSheared(true);
        int i = 1 + this.rand.nextInt(3);

        for (int j = 0; j < i; ++j) {
            ItemEntity itementity = this.entityDropItem(WOOL_BY_COLOR.get(this.getFleeceColor()), 1);
            if (itementity != null) {
                itementity.setMotion(itementity.getMotion().add((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F, this.rand.nextFloat() * 0.05F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F));
            }
        }
    }

    public boolean isShearable() {
        return this.isAlive() && !this.getSheared() && !this.isChild() && !this.isAttack;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.MUSIC_GAME;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.BLOCK_LAVA_AMBIENT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.AMBIENT_CAVE;
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_SHEEP_STEP, 0.15F, 1.1F);
    }

    /**
     * Chooses a "vanilla" vilt color based on the provided random.
     */
    public static DyeColor getRandomSheepColor(Random random) {
        int i = random.nextInt(100);
        if (i < 5) {
            return DyeColor.BLACK;
        } else if (i < 10) {
            return DyeColor.GRAY;
        } else if (i < 15) {
            return DyeColor.LIGHT_GRAY;
        } else if (i < 18) {
            return DyeColor.BROWN;
        } else if (i < 21) {
            return DyeColor.BLUE;
        } else if (i < 43) {
            return DyeColor.WHITE;
        } else if (i < 54) {
            return DyeColor.GREEN;
        } else if (i < 77) {
            return DyeColor.PURPLE;
        } else if (i < 86) {
            return DyeColor.LIGHT_BLUE;
        } else if (i < 99) {
            return DyeColor.LIME;
        } else {
            return random.nextInt(500) == 0 ? random.nextInt(200) == 0 ? DyeColor.CYAN : DyeColor.PINK : random.nextInt(800) == 0 ? random.nextInt(300) == 0 ? random.nextInt(400) == 0 ? DyeColor.YELLOW : DyeColor.MAGENTA : DyeColor.ORANGE : DyeColor.RED;
        }
    }

    public ViltEntity createChild(ServerWorld serverWorld, AgeableEntity ageable) {
        ViltEntity viltEntity = (ViltEntity) ageable;
        ViltEntity newViltEntity = EntityInit.VILT.create(serverWorld);
        if (newViltEntity == null) throw new AssertionError();
        newViltEntity.setFleeceColor(this.getDyeColorMixFromParents(this, viltEntity));
        return newViltEntity;
    }

    public boolean isBreedingItem(ItemStack stack) {
        return TEMPTATION_ITEMS.test(stack);
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
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        this.setFleeceColor(getRandomSheepColor(worldIn.getRandom()));
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    /**
     * Attempts to mix both parent vilt to come up with a mixed dye color.
     */
    private DyeColor getDyeColorMixFromParents(AnimalEntity father, AnimalEntity mother) {
        DyeColor fatherColor = ((ViltEntity) father).getFleeceColor();
        DyeColor motherColor = ((ViltEntity) mother).getFleeceColor();
        CraftingInventory craftinginventory = createDyeColorCraftingInventory(fatherColor, motherColor);
        return this.world.getRecipeManager().getRecipe(IRecipeType.CRAFTING, craftinginventory, this.world).map((mix) -> mix.getCraftingResult(craftinginventory)).map(ItemStack::getItem).filter(DyeItem.class::isInstance).map(DyeItem.class::cast).map(DyeItem::getDyeColor).orElseGet(() -> this.world.rand.nextBoolean() ? fatherColor : motherColor);
    }

    private static CraftingInventory createDyeColorCraftingInventory(DyeColor color, DyeColor color1) {
        CraftingInventory craftinginventory = new CraftingInventory(new Container(null, -1) {
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
        return 0.96F * sizeIn.height;
    }

    @Override
    public boolean isShearable(@javax.annotation.Nonnull ItemStack item, World world, BlockPos pos) {
        return isShearable();
    }

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
