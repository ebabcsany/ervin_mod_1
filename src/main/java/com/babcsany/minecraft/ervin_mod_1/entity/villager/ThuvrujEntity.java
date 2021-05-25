package com.babcsany.minecraft.ervin_mod_1.entity.villager;

public class ThuvrujEntity /*extends AbstractNirtreEntity*/ {
   /** Mapping between valid food items and their respective efficiency values. */
   /*public static final Map<Item, Integer> FOOD_VALUES = ImmutableMap.of(Items.BREAD, 4, Items.POTATO, 1, Items.CARROT, 1, Items.BEETROOT, 1);
   /** Defaults items a villager regardless of its profession can pick up. */
   /*private static final Set<Item> ALLOWED_INVENTORY_ITEMS = ImmutableSet.of(Items.BREAD, Items.POTATO, Items.CARROT, Items.WHEAT, Items.WHEAT_SEEDS, Items.BEETROOT, Items.BEETROOT_SEEDS);
   private int timeUntilReset;
   private boolean leveledUp;
   @Nullable
   private PlayerEntity previousCustomer;
   private byte foodLevel;
   private final GossipManager gossip = new GossipManager();
   private long field_213783_bN;
   private long lastGossipDecay;
   private int xp;
   private long lastRestock;
   private int field_223725_bO;
   private long field_223726_bP;
   private boolean field_234542_bL_;
   private static final ImmutableList<MemoryModuleType<?>> MEMORY_TYPES = ImmutableList.of(MemoryModuleType.HOME, MemoryModuleType.JOB_SITE, MemoryModuleType.POTENTIAL_JOB_SITE, MemoryModuleType.MEETING_POINT, MemoryModuleType.MOBS, MemoryModuleType.VISIBLE_MOBS, MemoryModuleType.VISIBLE_VILLAGER_BABIES, MemoryModuleType.NEAREST_PLAYERS, MemoryModuleType.NEAREST_VISIBLE_PLAYER, MemoryModuleType.NEAREST_VISIBLE_TARGETABLE_PLAYER, MemoryModuleType.NEAREST_VISIBLE_WANTED_ITEM, MemoryModuleType.WALK_TARGET, MemoryModuleType.LOOK_TARGET, MemoryModuleType.INTERACTION_TARGET, MemoryModuleType.BREED_TARGET, MemoryModuleType.PATH, MemoryModuleType.INTERACTABLE_DOORS, MemoryModuleType.OPENED_DOORS, MemoryModuleType.NEAREST_BED, MemoryModuleType.HURT_BY, MemoryModuleType.HURT_BY_ENTITY, MemoryModuleType.NEAREST_HOSTILE, MemoryModuleType.SECONDARY_JOB_SITE, MemoryModuleType.HIDING_PLACE, MemoryModuleType.HEARD_BELL_TIME, MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE, MemoryModuleType.LAST_SLEPT, MemoryModuleType.LAST_WOKEN, MemoryModuleType.LAST_WORKED_AT_POI, MemoryModuleType.GOLEM_LAST_SEEN_TIME);
   private static final ImmutableList<SensorType<? extends Sensor<? super ThuvrujEntity>>> SENSOR_TYPES = ImmutableList.of(net.minecraft.entity.ai.brain.sensor.SensorType.NEAREST_LIVING_ENTITIES, net.minecraft.entity.ai.brain.sensor.SensorType.NEAREST_PLAYERS, net.minecraft.entity.ai.brain.sensor.SensorType.field_234129_b_, net.minecraft.entity.ai.brain.sensor.SensorType.INTERACTABLE_DOORS, net.minecraft.entity.ai.brain.sensor.SensorType.NEAREST_BED, net.minecraft.entity.ai.brain.sensor.SensorType.HURT_BY, net.minecraft.entity.ai.brain.sensor.SensorType.VILLAGER_HOSTILES, net.minecraft.entity.ai.brain.sensor.SensorType.VILLAGER_BABIES, net.minecraft.entity.ai.brain.sensor.SensorType.SECONDARY_POIS, net.minecraft.entity.ai.brain.sensor.SensorType.GOLEM_LAST_SEEN);
   public static final Map<MemoryModuleType<GlobalPos>, BiPredicate<ThuvrujEntity, PointOfInterestType>> field_213774_bB = ImmutableMap.of(MemoryModuleType.HOME, (p_213769_0_, p_213769_1_) -> {
      return p_213769_1_ == PointOfInterestType.HOME;
   }, MemoryModuleType.JOB_SITE, (p_213771_0_, p_213771_1_) -> {
      return p_213771_0_.getVillagerData().getProfession().getPointOfInterest() == p_213771_1_;
   }, MemoryModuleType.POTENTIAL_JOB_SITE, (p_213772_0_, p_213772_1_) -> {
      return PointOfInterestType.ANY_VILLAGER_WORKSTATION.test(p_213772_1_);
   }, MemoryModuleType.MEETING_POINT, (p_234546_0_, p_234546_1_) -> {
      return p_234546_1_ == PointOfInterestType.MEETING;
   });

   public ThuvrujEntity(EntityType<? extends ThuvrujEntity> type, World worldIn) {
      this(type, worldIn, IVillagerType.PLAINS);
   }

   public ThuvrujEntity(EntityType<? extends ThuvrujEntity> type, World worldIn, IVillagerType villagerType) {
      super(type, worldIn);
      ((GroundPathNavigator)this.getNavigator()).setBreakDoors(true);
      this.getNavigator().setCanSwim(true);
      this.setCanPickUpLoot(true);
      this.setVillagerData(this.getVillagerData().withType(villagerType).withProfession(VillagerProfession.NONE));
   }

   public Brain<ThuvrujEntity> getBrain() {
      return (Brain<ThuvrujEntity>)super.getBrain();
   }

   protected Brain.BrainCodec<ThuvrujEntity> getBrainCodec() {
      return Brain.func_233705_a_(MEMORY_TYPES, SENSOR_TYPES);
   }

   protected Brain<?> createBrain(Dynamic<?> dynamicIn) {
      Brain<ThuvrujEntity> brain = this.getBrainCodec().func_233748_a_(dynamicIn);
      this.initBrain(brain);
      return brain;
   }

   public void resetBrain(ServerWorld serverWorldIn) {
      Brain<ThuvrujEntity> brain = this.getBrain();
      brain.stopAllTasks(serverWorldIn, this);
      this.brain = brain.copy();
      this.initBrain(this.getBrain());
   }

   private void initBrain(Brain<ThuvrujEntity> villagerBrain) {
      VillagerProfession villagerprofession = this.getVillagerData().getProfession();
      if (this.isChild()) {
         villagerBrain.setSchedule(Schedule.VILLAGER_BABY);
         villagerBrain.registerActivity(Activity.PLAY, ThuvrujTasks.play(0.5F));
      } else {
         villagerBrain.setSchedule(Schedule.VILLAGER_DEFAULT);
         villagerBrain.func_233700_a_(Activity.WORK, ThuvrujTasks.work(villagerprofession, 0.5F), ImmutableSet.of(Pair.of(MemoryModuleType.JOB_SITE, MemoryModuleStatus.VALUE_PRESENT)));
      }

      villagerBrain.registerActivity(Activity.CORE, ThuvrujTasks.core(villagerprofession, 0.5F));
      villagerBrain.func_233700_a_(Activity.MEET, ThuvrujTasks.meet(villagerprofession, 0.5F), ImmutableSet.of(Pair.of(MemoryModuleType.MEETING_POINT, MemoryModuleStatus.VALUE_PRESENT)));
      villagerBrain.registerActivity(Activity.REST, ThuvrujTasks.rest(villagerprofession, 0.5F));
      villagerBrain.registerActivity(Activity.IDLE, ThuvrujTasks.idle(villagerprofession, 0.5F));
      villagerBrain.registerActivity(Activity.PANIC, ThuvrujTasks.panic(villagerprofession, 0.5F));
      villagerBrain.registerActivity(Activity.PRE_RAID, ThuvrujTasks.preRaid(villagerprofession, 0.5F));
      villagerBrain.registerActivity(Activity.RAID, ThuvrujTasks.raid(villagerprofession, 0.5F));
      villagerBrain.registerActivity(Activity.HIDE, ThuvrujTasks.hide(villagerprofession, 0.5F));
      villagerBrain.setDefaultActivities(ImmutableSet.of(Activity.CORE));
      villagerBrain.setFallbackActivity(Activity.IDLE);
      villagerBrain.switchTo(Activity.IDLE);
      villagerBrain.updateActivity(this.world.getDayTime(), this.world.getGameTime());
   }

   /**
    * This is called when Entity's growing age timer reaches 0 (negative values are considered as a child, positive as
    * an adult)
    */
   /*protected void onGrowingAdult() {
      super.onGrowingAdult();
      if (this.world instanceof ServerWorld) {
         this.resetBrain((ServerWorld)this.world);
      }

   }

   public static AttributeModifierMap.MutableAttribute registerAttributes() {
      return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.5D).createMutableAttribute(Attributes.FOLLOW_RANGE, 48.0D);
   }

   public boolean func_234552_eW_() {
      return this.field_234542_bL_;
   }

   protected void updateAITasks() {
      this.world.getProfiler().startSection("villagerBrain");
      this.getBrain().tick((ServerWorld)this.world, this);
      this.world.getProfiler().endSection();
      if (this.field_234542_bL_) {
         this.field_234542_bL_ = false;
      }

      if (!this.hasCustomer() && this.timeUntilReset > 0) {
         --this.timeUntilReset;
         if (this.timeUntilReset <= 0) {
            if (this.leveledUp) {
               this.levelUp();
               this.leveledUp = false;
            }

            this.addPotionEffect(new EffectInstance(Effects.REGENERATION, 200, 0));
         }
      }

      if (this.previousCustomer != null && this.world instanceof ServerWorld) {
         ((ServerWorld)this.world).updateReputation(IReputationType.TRADE, this.previousCustomer, this);
         this.world.setEntityState(this, (byte)14);
         this.previousCustomer = null;
      }

      if (!this.isAIDisabled() && this.rand.nextInt(100) == 0) {
         Raid raid = ((ServerWorld)this.world).findRaid(this.getPosition());
         if (raid != null && raid.isActive() && !raid.isOver()) {
            this.world.setEntityState(this, (byte)42);
         }
      }

      if (this.getVillagerData().getProfession() == VillagerProfession.NONE && this.hasCustomer()) {
         this.resetCustomer();
      }

      super.updateAITasks();
   }

   /**
    * Called to update the entity's position/logic.
    */
   /*public void tick() {
      super.tick();
      if (this.getShakeHeadTicks() > 0) {
         this.setShakeHeadTicks(this.getShakeHeadTicks() - 1);
      }

      this.tickGossip();
   }

   public ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
      ItemStack itemstack = p_230254_1_.getHeldItem(p_230254_2_);
      if (itemstack.getItem() != Items.VILLAGER_SPAWN_EGG && this.isAlive() && !this.hasCustomer() && !this.isSleeping() && !p_230254_1_.isSecondaryUseActive()) {
         if (this.isChild()) {
            this.shakeHead();
            return ActionResultType.func_233537_a_(this.world.isRemote);
         } else {
            boolean flag = this.getOffers().isEmpty();
            if (p_230254_2_ == Hand.MAIN_HAND) {
               if (flag && !this.world.isRemote) {
                  this.shakeHead();
               }

               p_230254_1_.addStat(Stats.TALKED_TO_VILLAGER);
            }

            if (flag) {
               return ActionResultType.func_233537_a_(this.world.isRemote);
            } else {
               if (!this.world.isRemote && !this.offers.isEmpty()) {
                  this.displayMerchantGui(p_230254_1_);
               }

               return ActionResultType.func_233537_a_(this.world.isRemote);
            }
         }
      } else {
         return super.func_230254_b_(p_230254_1_, p_230254_2_);
      }
   }

   private void shakeHead() {
      this.setShakeHeadTicks(40);
      if (!this.world.isRemote()) {
         this.playSound(SoundEvents.ENTITY_VILLAGER_NO, this.getSoundVolume(), this.getSoundPitch());
      }

   }

   private void displayMerchantGui(PlayerEntity player) {
      this.recalculateSpecialPricesFor(player);
      this.setCustomer(player);
      this.openMerchantContainer(player, this.getDisplayName(), this.getVillagerData().getLevel());
   }

   public void setCustomer(@Nullable PlayerEntity player) {
      boolean flag = this.getCustomer() != null && player == null;
      super.setCustomer(player);
      if (flag) {
         this.resetCustomer();
      }

   }

   protected void resetCustomer() {
      super.resetCustomer();
      this.resetAllSpecialPrices();
   }

   private void resetAllSpecialPrices() {
      for(MerchantOffer merchantoffer : this.getOffers()) {
         merchantoffer.resetSpecialPrice();
      }

   }

   public boolean func_223340_ej() {
      return true;
   }

   public void func_213766_ei() {
      this.calculateDemandOfOffers();

      for(MerchantOffer merchantoffer : this.getOffers()) {
         merchantoffer.resetUses();
      }

      this.lastRestock = this.world.getGameTime();
      ++this.field_223725_bO;
   }

   private boolean hasUsedOffer() {
      for(MerchantOffer merchantoffer : this.getOffers()) {
         if (merchantoffer.hasBeenUsed()) {
            return true;
         }
      }

      return false;
   }

   private boolean func_223720_ew() {
      return this.field_223725_bO == 0 || this.field_223725_bO < 2 && this.world.getGameTime() > this.lastRestock + 2400L;
   }

   public boolean func_223721_ek() {
      long i = this.lastRestock + 12000L;
      long j = this.world.getGameTime();
      boolean flag = j > i;
      long k = this.world.getDayTime();
      if (this.field_223726_bP > 0L) {
         long l = this.field_223726_bP / 24000L;
         long i1 = k / 24000L;
         flag |= i1 > l;
      }

      this.field_223726_bP = k;
      if (flag) {
         this.lastRestock = j;
         this.func_223718_eH();
      }

      return this.func_223720_ew() && this.hasUsedOffer();
   }

   private void func_223719_ex() {
      int i = 2 - this.field_223725_bO;
      if (i > 0) {
         for(MerchantOffer merchantoffer : this.getOffers()) {
            merchantoffer.resetUses();
         }
      }

      for(int j = 0; j < i; ++j) {
         this.calculateDemandOfOffers();
      }

   }

   private void calculateDemandOfOffers() {
      for(MerchantOffer merchantoffer : this.getOffers()) {
         merchantoffer.calculateDemand();
      }

   }

   private void recalculateSpecialPricesFor(PlayerEntity playerIn) {
      int i = this.getPlayerReputation(playerIn);
      if (i != 0) {
         for(MerchantOffer merchantoffer : this.getOffers()) {
            merchantoffer.increaseSpecialPrice(-MathHelper.floor((float)i * merchantoffer.getPriceMultiplier()));
         }
      }

      if (playerIn.isPotionActive(Effects.HERO_OF_THE_VILLAGE)) {
         EffectInstance effectinstance = playerIn.getActivePotionEffect(Effects.HERO_OF_THE_VILLAGE);
         int k = effectinstance.getAmplifier();

         for(MerchantOffer merchantoffer1 : this.getOffers()) {
            double d0 = 0.3D + 0.0625D * (double)k;
            int j = (int)Math.floor(d0 * (double)merchantoffer1.getBuyingStackFirst().getCount());
            merchantoffer1.increaseSpecialPrice(-Math.max(j, 1));
         }
      }

   }

   protected void registerData() {
      super.registerData();
      this.dataManager.register(VILLAGER_DATA, new VillagerData(IVillagerType.PLAINS, VillagerProfession.NONE, 1));
   }

   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
      VillagerData.VILLAGER_DATA_CODEC.encodeStart(NBTDynamicOps.INSTANCE, this.getVillagerData()).resultOrPartial(LOGGER::error).ifPresent((p_234547_1_) -> {
         compound.put("VillagerData", p_234547_1_);
      });
      compound.putByte("FoodLevel", this.foodLevel);
      compound.put("Gossips", this.gossip.func_234058_a_(NBTDynamicOps.INSTANCE).getValue());
      compound.putInt("Xp", this.xp);
      compound.putLong("LastRestock", this.lastRestock);
      compound.putLong("LastGossipDecay", this.lastGossipDecay);
      compound.putInt("RestocksToday", this.field_223725_bO);
      if (this.field_234542_bL_) {
         compound.putBoolean("AssignProfessionWhenSpawned", true);
      }

   }

   /**
    * (abstract) Protected helper method to read subclass entity data from NBT.
    */
   /*public void readAdditional(CompoundNBT compound) {
      super.readAdditional(compound);
      if (compound.contains("VillagerData", 10)) {
         DataResult<VillagerData> dataresult = VillagerData.VILLAGER_DATA_CODEC.parse(new Dynamic<>(NBTDynamicOps.INSTANCE, compound.get("VillagerData")));
         dataresult.resultOrPartial(LOGGER::error).ifPresent(this::setVillagerData);
      }

      if (compound.contains("Offers", 10)) {
         this.offers = new MerchantOffers(compound.getCompound("Offers"));
      }

      if (compound.contains("FoodLevel", 1)) {
         this.foodLevel = compound.getByte("FoodLevel");
      }

      ListNBT listnbt = compound.getList("Gossips", 10);
      this.gossip.func_234057_a_(new Dynamic<>(NBTDynamicOps.INSTANCE, listnbt));
      if (compound.contains("Xp", 3)) {
         this.xp = compound.getInt("Xp");
      }

      this.lastRestock = compound.getLong("LastRestock");
      this.lastGossipDecay = compound.getLong("LastGossipDecay");
      this.setCanPickUpLoot(true);
      if (this.world instanceof ServerWorld) {
         this.resetBrain((ServerWorld)this.world);
      }

      this.field_223725_bO = compound.getInt("RestocksToday");
      if (compound.contains("AssignProfessionWhenSpawned")) {
         this.field_234542_bL_ = compound.getBoolean("AssignProfessionWhenSpawned");
      }

   }

   public boolean canDespawn(double distanceToClosestPlayer) {
      return false;
   }

   @Nullable
   protected SoundEvent getAmbientSound() {
      if (this.isSleeping()) {
         return null;
      } else {
         return this.hasCustomer() ? SoundEvents.ENTITY_VILLAGER_TRADE : SoundEvents.ENTITY_VILLAGER_AMBIENT;
      }
   }

   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return SoundEvents.ENTITY_VILLAGER_HURT;
   }

   protected SoundEvent getDeathSound() {
      return SoundEvents.ENTITY_VILLAGER_DEATH;
   }

   public void playWorkstationSound() {
      SoundEvent soundevent = this.getVillagerData().getProfession().getSound();
      if (soundevent != null) {
         this.playSound(soundevent, this.getSoundVolume(), this.getSoundPitch());
      }

   }

   public void setVillagerData(VillagerData p_213753_1_) {
      VillagerData villagerdata = this.getVillagerData();
      if (villagerdata.getProfession() != p_213753_1_.getProfession()) {
         this.offers = null;
      }

      this.dataManager.set(VILLAGER_DATA, p_213753_1_);
   }

   public VillagerData getVillagerData() {
      return this.dataManager.get(VILLAGER_DATA);
   }

   protected void onVillagerTrade(MerchantOffer offer) {
      int i = 3 + this.rand.nextInt(4);
      this.xp += offer.getGivenExp();
      this.previousCustomer = this.getCustomer();
      if (this.canLevelUp()) {
         this.timeUntilReset = 40;
         this.leveledUp = true;
         i += 5;
      }

      if (offer.getDoesRewardExp()) {
         this.world.addEntity(new ExperienceOrbEntity(this.world, this.getPosX(), this.getPosY() + 0.5D, this.getPosZ(), i));
      }

   }

   /**
    * Hint to AI tasks that we were attacked by the passed EntityLivingBase and should retaliate. Is not guaranteed to
    * change our actual active target (for example if we are currently busy attacking someone else)
    */
   /*public void setRevengeTarget(@Nullable LivingEntity livingBase) {
      if (livingBase != null && this.world instanceof ServerWorld) {
         ((ServerWorld)this.world).updateReputation(IReputationType.VILLAGER_HURT, livingBase, this);
         if (this.isAlive() && livingBase instanceof PlayerEntity) {
            this.world.setEntityState(this, (byte)13);
         }
      }

      super.setRevengeTarget(livingBase);
   }

   /**
    * Called when the mob's health reaches 0.
    */
   /*public void onDeath(DamageSource cause) {
      LOGGER.info("Villager {} died, message: '{}'", this, cause.getDeathMessage(this).getString());
      Entity entity = cause.getTrueSource();
      if (entity != null) {
         this.func_223361_a(entity);
      }

      this.func_213742_a(MemoryModuleType.HOME);
      this.func_213742_a(MemoryModuleType.JOB_SITE);
      this.func_213742_a(MemoryModuleType.MEETING_POINT);
      super.onDeath(cause);
   }

   private void func_223361_a(Entity p_223361_1_) {
      if (this.world instanceof ServerWorld) {
         Optional<List<LivingEntity>> optional = this.brain.getMemory(MemoryModuleType.VISIBLE_MOBS);
         if (optional.isPresent()) {
            ServerWorld serverworld = (ServerWorld)this.world;
            optional.get().stream().filter((p_223349_0_) -> {
               return p_223349_0_ instanceof IReputationTracking;
            }).forEach((p_223342_2_) -> {
               serverworld.updateReputation(IReputationType.VILLAGER_KILLED, p_223361_1_, (IReputationTracking)p_223342_2_);
            });
         }
      }
   }

   public void func_213742_a(MemoryModuleType<GlobalPos> p_213742_1_) {
      if (this.world instanceof ServerWorld) {
         MinecraftServer minecraftserver = ((ServerWorld)this.world).getServer();
         this.brain.getMemory(p_213742_1_).ifPresent((p_213752_3_) -> {
            ServerWorld serverworld = minecraftserver.getWorld(p_213752_3_.func_239646_a_());
            if (serverworld != null) {
               PointOfInterestManager pointofinterestmanager = serverworld.getPointOfInterestManager();
               Optional<PointOfInterestType> optional = pointofinterestmanager.getType(p_213752_3_.getPos());
               BiPredicate<ThuvrujEntity, PointOfInterestType> bipredicate = field_213774_bB.get(p_213742_1_);
               if (optional.isPresent() && bipredicate.test(this, optional.get())) {
                  pointofinterestmanager.release(p_213752_3_.getPos());
                  DebugPacketSender.func_218801_c(serverworld, p_213752_3_.getPos());
               }

            }
         });
      }
   }

   public boolean canBreed() {
      return this.foodLevel + this.getFoodValueFromInventory() >= 12 && this.getGrowingAge() == 0;
   }

   private boolean func_223344_ex() {
      return this.foodLevel < 12;
   }

   private void func_213765_en() {
      if (this.func_223344_ex() && this.getFoodValueFromInventory() != 0) {
         for(int i = 0; i < this.getVillagerInventory().getSizeInventory(); ++i) {
            ItemStack itemstack = this.getVillagerInventory().getStackInSlot(i);
            if (!itemstack.isEmpty()) {
               Integer integer = FOOD_VALUES.get(itemstack.getItem());
               if (integer != null) {
                  int j = itemstack.getCount();

                  for(int k = j; k > 0; --k) {
                     this.foodLevel = (byte)(this.foodLevel + integer);
                     this.getVillagerInventory().decrStackSize(i, 1);
                     if (!this.func_223344_ex()) {
                        return;
                     }
                  }
               }
            }
         }

      }
   }

   public int getPlayerReputation(PlayerEntity player) {
      return this.gossip.getReputation(player.getUniqueID(), (p_223103_0_) -> {
         return true;
      });
   }

   private void decrFoodLevel(int qty) {
      this.foodLevel = (byte)(this.foodLevel - qty);
   }

   public void func_223346_ep() {
      this.func_213765_en();
      this.decrFoodLevel(12);
   }

   public void setOffers(MerchantOffers offersIn) {
      this.offers = offersIn;
   }

   private boolean canLevelUp() {
      int i = this.getVillagerData().getLevel();
      return VillagerData.canLevelUp(i) && this.xp >= VillagerData.func_221127_c(i);
   }

   private void levelUp() {
      this.setVillagerData(this.getVillagerData().withLevel(this.getVillagerData().getLevel() + 1));
      this.populateTradeData();
   }

   protected ITextComponent getProfessionName() {
      net.minecraft.util.ResourceLocation profName = this.getVillagerData().getProfession().getRegistryName();
      return new TranslationTextComponent(this.getType().getTranslationKey() + '.' + (!"minecraft".equals(profName.getNamespace()) ? profName.getNamespace() + '.' : "") + profName.getPath());
   }

   /**
    * Handler for {@link World#setEntityState}
    */
   /*@OnlyIn(Dist.CLIENT)
   public void handleStatusUpdate(byte id) {
      if (id == 12) {
         this.spawnParticles(ParticleTypes.HEART);
      } else if (id == 13) {
         this.spawnParticles(ParticleTypes.ANGRY_VILLAGER);
      } else if (id == 14) {
         this.spawnParticles(ParticleTypes.HAPPY_VILLAGER);
      } else if (id == 42) {
         this.spawnParticles(ParticleTypes.SPLASH);
      } else {
         super.handleStatusUpdate(id);
      }

   }

   @Nullable
   public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
      if (reason == SpawnReason.BREEDING) {
         this.setVillagerData(this.getVillagerData().withProfession(VillagerProfession.NONE));
      }

      if (reason == SpawnReason.COMMAND || reason == SpawnReason.SPAWN_EGG || reason == SpawnReason.SPAWNER || reason == SpawnReason.DISPENSER) {
         this.setVillagerData(this.getVillagerData().withType(IVillagerType.byBiome(worldIn.getBiome(this.getPosition()))));
      }

      if (reason == SpawnReason.STRUCTURE) {
         this.field_234542_bL_ = true;
      }

      return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
   }

   public ThuvrujEntity createChild(AgeableEntity ageable) {
      double d0 = this.rand.nextDouble();
      IVillagerType ivillagertype;
      if (d0 < 0.5D) {
         ivillagertype = IVillagerType.byBiome(this.world.getBiome(this.getPosition()));
      } else if (d0 < 0.75D) {
         ivillagertype = this.getVillagerData().getType();
      } else {
         ivillagertype = ((ThuvrujEntity)ageable).getVillagerData().getType();
      }

      ThuvrujEntity villagerentity = new ThuvrujEntity(EntityType.VILLAGER, this.world, ivillagertype);
      villagerentity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(villagerentity.getPosition()), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
      return villagerentity;
   }

   /**
    * Called when a lightning bolt hits the entity.
    */
   /*public void onStruckByLightning(LightningBoltEntity lightningBolt) {
      if (this.world.getDifficulty() != Difficulty.PEACEFUL) {
         LOGGER.info("Villager {} was struck by lightning {}.", this, lightningBolt);
         WitchEntity witchentity = EntityType.WITCH.create(this.world);
         witchentity.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, this.rotationPitch);
         witchentity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(witchentity.getPosition()), SpawnReason.CONVERSION, (ILivingEntityData)null, (CompoundNBT)null);
         witchentity.setNoAI(this.isAIDisabled());
         if (this.hasCustomName()) {
            witchentity.setCustomName(this.getCustomName());
            witchentity.setCustomNameVisible(this.isCustomNameVisible());
         }

         witchentity.enablePersistence();
         this.world.addEntity(witchentity);
         this.remove();
      } else {
         super.onStruckByLightning(lightningBolt);
      }

   }

   /**
    * Tests if this entity should pickup a weapon or an armor. Entity drops current weapon or armor if the new one is
    * better.
    */
   /*protected void updateEquipmentIfNeeded(ItemEntity itemEntity) {
      ItemStack itemstack = itemEntity.getItem();
      if (this.func_230293_i_(itemstack)) {
         Inventory inventory = this.getVillagerInventory();
         boolean flag = inventory.func_233541_b_(itemstack);
         if (!flag) {
            return;
         }

         this.triggerItemPickupTrigger(itemEntity);
         this.onItemPickup(itemEntity, itemstack.getCount());
         ItemStack itemstack1 = inventory.addItem(itemstack);
         if (itemstack1.isEmpty()) {
            itemEntity.remove();
         } else {
            itemstack.setCount(itemstack1.getCount());
         }
      }

   }

   public boolean func_230293_i_(ItemStack p_230293_1_) {
      Item item = p_230293_1_.getItem();
      return (ALLOWED_INVENTORY_ITEMS.contains(item) || this.getVillagerData().getProfession().getSpecificItems().contains(item)) && this.getVillagerInventory().func_233541_b_(p_230293_1_);
   }

   /**
    * Used by {@link net.minecraft.entity.ai.EntityAIVillagerInteract EntityAIVillagerInteract} to check if the villager
    * can give some items from an inventory to another villager.
    */
   /*public boolean canAbondonItems() {
      return this.getFoodValueFromInventory() >= 24;
   }

   public boolean wantsMoreFood() {
      return this.getFoodValueFromInventory() < 12;
   }

   /**
    * @return calculated food value from item stacks in this villager's inventory
    */
   /*private int getFoodValueFromInventory() {
      Inventory inventory = this.getVillagerInventory();
      return FOOD_VALUES.entrySet().stream().mapToInt((p_226553_1_) -> {
         return inventory.count(p_226553_1_.getKey()) * p_226553_1_.getValue();
      }).sum();
   }

   /**
    * Returns true if villager has seeds, potatoes or carrots in inventory
    */
   /*public boolean isFarmItemInInventory() {
      return this.getVillagerInventory().hasAny(ImmutableSet.of(Items.WHEAT_SEEDS, Items.POTATO, Items.CARROT, Items.BEETROOT_SEEDS));
   }

   protected void populateTradeData() {
      VillagerData villagerdata = this.getVillagerData();
      Int2ObjectMap<VillagerTrades.ITrade[]> int2objectmap = VillagerTrades.VILLAGER_DEFAULT_TRADES.get(villagerdata.getProfession());
      if (int2objectmap != null && !int2objectmap.isEmpty()) {
         VillagerTrades.ITrade[] avillagertrades$itrade = int2objectmap.get(villagerdata.getLevel());
         if (avillagertrades$itrade != null) {
            MerchantOffers merchantoffers = this.getOffers();
            this.addTrades(merchantoffers, avillagertrades$itrade, 2);
         }
      }
   }

   public void func_213746_a(ThuvrujEntity villager, long gameTime) {
      if ((gameTime < this.field_213783_bN || gameTime >= this.field_213783_bN + 1200L) && (gameTime < villager.field_213783_bN || gameTime >= villager.field_213783_bN + 1200L)) {
         this.gossip.transferFrom(villager.gossip, this.rand, 10);
         this.field_213783_bN = gameTime;
         villager.field_213783_bN = gameTime;
         this.spawnGolems(gameTime, 5);
      }
   }

   private void tickGossip() {
      long i = this.world.getGameTime();
      if (this.lastGossipDecay == 0L) {
         this.lastGossipDecay = i;
      } else if (i >= this.lastGossipDecay + 24000L) {
         this.gossip.tick();
         this.lastGossipDecay = i;
      }
   }

   public void spawnGolems(long gameTime, int requiredPeers) {
      if (this.canSpawnGolems(gameTime)) {
         AxisAlignedBB axisalignedbb = this.getBoundingBox().grow(10.0D, 10.0D, 10.0D);
         List<ThuvrujEntity> list = this.world.getEntitiesWithinAABB(ThuvrujEntity.class, axisalignedbb);
         List<ThuvrujEntity> list1 = list.stream().filter((p_226554_2_) -> {
            return p_226554_2_.canSpawnGolems(gameTime);
         }).limit(5L).collect(Collectors.toList());
         if (list1.size() >= requiredPeers) {
            IronGolemEntity irongolementity = this.trySpawnGolem();
            if (irongolementity != null) {
               list.forEach((p_226552_2_) -> {
                  p_226552_2_.updateGolemLastSeenMemory(gameTime);
               });
            }
         }
      }
   }

   private void updateGolemLastSeenMemory(long gameTime) {
      this.brain.setMemory(MemoryModuleType.GOLEM_LAST_SEEN_TIME, gameTime);
   }

   private boolean hasSeenGolemRecently(long gameTime) {
      Optional<Long> optional = this.brain.getMemory(MemoryModuleType.GOLEM_LAST_SEEN_TIME);
      if (!optional.isPresent()) {
         return false;
      } else {
         Long olong = optional.get();
         return gameTime - olong <= 600L;
      }
   }

   public boolean canSpawnGolems(long gameTime) {
      if (!this.hasSleptAndWorkedRecently(this.world.getGameTime())) {
         return false;
      } else {
         return !this.hasSeenGolemRecently(gameTime);
      }
   }

   @Nullable
   private IronGolemEntity trySpawnGolem() {
      BlockPos blockpos = this.getPosition();

      for(int i = 0; i < 10; ++i) {
         double d0 = (double)(this.world.rand.nextInt(16) - 8);
         double d1 = (double)(this.world.rand.nextInt(16) - 8);
         BlockPos blockpos1 = this.func_241433_a_(blockpos, d0, d1);
         if (blockpos1 != null) {
            IronGolemEntity irongolementity = EntityType.IRON_GOLEM.create(this.world, (CompoundNBT)null, (ITextComponent)null, (PlayerEntity)null, blockpos1, SpawnReason.MOB_SUMMONED, false, false);
            if (irongolementity != null) {
               if (irongolementity.canSpawn(this.world, SpawnReason.MOB_SUMMONED) && irongolementity.isNotColliding(this.world)) {
                  this.world.addEntity(irongolementity);
                  return irongolementity;
               }

               irongolementity.remove();
            }
         }
      }

      return null;
   }

   @Nullable
   private BlockPos func_241433_a_(BlockPos p_241433_1_, double p_241433_2_, double p_241433_4_) {
      int i = 6;
      BlockPos blockpos = p_241433_1_.add(p_241433_2_, 6.0D, p_241433_4_);
      BlockState blockstate = this.world.getBlockState(blockpos);

      for(int j = 6; j >= -6; --j) {
         BlockPos blockpos1 = blockpos;
         BlockState blockstate1 = blockstate;
         blockpos = blockpos.down();
         blockstate = this.world.getBlockState(blockpos);
         if ((blockstate1.isAir() || blockstate1.getMaterial().isLiquid()) && blockstate.getMaterial().isOpaque()) {
            return blockpos1;
         }
      }

      return null;
   }

   public void updateReputation(IReputationType type, Entity target) {
      if (type == IReputationType.ZOMBIE_VILLAGER_CURED) {
         this.gossip.add(target.getUniqueID(), GossipType.MAJOR_POSITIVE, 20);
         this.gossip.add(target.getUniqueID(), GossipType.MINOR_POSITIVE, 25);
      } else if (type == IReputationType.TRADE) {
         this.gossip.add(target.getUniqueID(), GossipType.TRADING, 2);
      } else if (type == IReputationType.VILLAGER_HURT) {
         this.gossip.add(target.getUniqueID(), GossipType.MINOR_NEGATIVE, 25);
      } else if (type == IReputationType.VILLAGER_KILLED) {
         this.gossip.add(target.getUniqueID(), GossipType.MAJOR_NEGATIVE, 25);
      }

   }

   public int getXp() {
      return this.xp;
   }

   public void setXp(int xpIn) {
      this.xp = xpIn;
   }

   private void func_223718_eH() {
      this.func_223719_ex();
      this.field_223725_bO = 0;
   }

   public GossipManager getGossip() {
      return this.gossip;
   }

   public void func_223716_a(INBT p_223716_1_) {
      this.gossip.func_234057_a_(new Dynamic<>(NBTDynamicOps.INSTANCE, p_223716_1_));
   }

   protected void sendDebugPackets() {
      super.sendDebugPackets();
      DebugPacketSender.sendLivingEntity(this);
   }

   public void startSleeping(BlockPos pos) {
      super.startSleeping(pos);
      this.brain.setMemory(MemoryModuleType.LAST_SLEPT, this.world.getGameTime());
      this.brain.removeMemory(MemoryModuleType.WALK_TARGET);
      this.brain.removeMemory(MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE);
   }

   public void wakeUp() {
      super.wakeUp();
      this.brain.setMemory(MemoryModuleType.LAST_WOKEN, this.world.getGameTime());
   }

   private boolean hasSleptAndWorkedRecently(long gameTime) {
      Optional<Long> optional = this.brain.getMemory(MemoryModuleType.LAST_SLEPT);
      if (optional.isPresent()) {
         return gameTime - optional.get() < 24000L;
      } else {
         return false;
      }
   }*/
}