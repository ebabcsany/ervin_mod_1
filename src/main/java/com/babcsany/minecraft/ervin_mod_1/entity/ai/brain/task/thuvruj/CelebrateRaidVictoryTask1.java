package com.babcsany.minecraft.ervin_mod_1.entity.ai.brain.task.thuvruj;

/*public class CelebrateRaidVictoryTask1 extends Task<ThuvrujEntity> {
   @Nullable
   private Raid raid;

   public CelebrateRaidVictoryTask1(int p_i50370_1_, int p_i50370_2_) {
      super(ImmutableMap.of(), p_i50370_1_, p_i50370_2_);
   }

   protected boolean shouldExecute(ServerWorld worldIn, ThuvrujEntity owner) {
      BlockPos blockpos = owner.getPosition();
      this.raid = worldIn.findRaid(blockpos);
      return this.raid != null && this.raid.isVictory() && MoveToSkylightTask.func_226306_a_(worldIn, owner, blockpos);
   }

   protected boolean shouldContinueExecuting(ServerWorld worldIn, ThuvrujEntity entityIn, long gameTimeIn) {
      return this.raid != null && !this.raid.isStopped();
   }

   protected void resetTask(ServerWorld worldIn, ThuvrujEntity entityIn, long gameTimeIn) {
      this.raid = null;
      entityIn.getBrain().updateActivity(worldIn.getDayTime(), worldIn.getGameTime());
   }

   protected void updateTask(ServerWorld worldIn, ThuvrujEntity owner, long gameTime) {
      Random random = owner.getRNG();
      if (random.nextInt(100) == 0) {
         owner.playCelebrateSound();
      }

      if (random.nextInt(200) == 0 && MoveToSkylightTask.func_226306_a_(worldIn, owner, owner.getPosition())) {
         DyeColor dyecolor = Util.getRandomObject(DyeColor.values(), random);
         int i = random.nextInt(3);
         ItemStack itemstack = this.makeFirework(dyecolor, i);
         FireworkRocketEntity fireworkrocketentity = new FireworkRocketEntity(owner.world, owner, owner.getPosX(), owner.getPosYEye(), owner.getPosZ(), itemstack);
         owner.world.addEntity(fireworkrocketentity);
      }

   }

   private ItemStack makeFirework(DyeColor color, int flightTime) {
      ItemStack itemstack = new ItemStack(Items.FIREWORK_ROCKET, 1);
      ItemStack itemstack1 = new ItemStack(Items.FIREWORK_STAR);
      CompoundNBT compoundnbt = itemstack1.getOrCreateChildTag("Explosion");
      List<Integer> list = Lists.newArrayList();
      list.add(color.getFireworkColor());
      compoundnbt.putIntArray("Colors", list);
      compoundnbt.putByte("Type", (byte)FireworkRocketItem.Shape.BURST.getIndex());
      CompoundNBT compoundnbt1 = itemstack.getOrCreateChildTag("Fireworks");
      ListNBT listnbt = new ListNBT();
      CompoundNBT compoundnbt2 = itemstack1.getChildTag("Explosion");
      if (compoundnbt2 != null) {
         listnbt.add(compoundnbt2);
      }

      compoundnbt1.putByte("Flight", (byte)flightTime);
      if (!listnbt.isEmpty()) {
         compoundnbt1.put("Explosions", listnbt);
      }

      return itemstack;
   }
}

 */