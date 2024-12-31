package com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.task;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.AbstractZurEntity;
import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.ai.brain.memory.MemoryModuleStatus;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.entity.ai.brain.task.Task;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.piglin.PiglinTasks;
import net.minecraft.world.server.ServerWorld;

public class ZurAdmireItemTask<E extends AbstractZurEntity> extends Task<E> {
    private final int timesToLive;

    public ZurAdmireItemTask(int timesToLive) {
        super(ImmutableMap.of(MemoryModuleType.NEAREST_VISIBLE_WANTED_ITEM, MemoryModuleStatus.VALUE_PRESENT, MemoryModuleType.ADMIRING_ITEM, MemoryModuleStatus.VALUE_ABSENT, MemoryModuleType.ADMIRING_DISABLED, MemoryModuleStatus.VALUE_ABSENT, MemoryModuleType.DISABLE_WALK_TO_ADMIRE_ITEM, MemoryModuleStatus.VALUE_ABSENT));
        this.timesToLive = timesToLive;
    }

    protected boolean shouldExecute(ServerWorld worldIn, E owner) {
        ItemEntity itementity = owner.getBrain().getMemory(MemoryModuleType.NEAREST_VISIBLE_WANTED_ITEM).get();
        return ZurTasks.func_234480_a_(itementity.getItem().getItem());
    }

    protected void startExecuting(ServerWorld worldIn, E entityIn, long gameTimeIn) {
        entityIn.getBrain().replaceMemory(MemoryModuleType.ADMIRING_ITEM, true, (long)this.timesToLive);
    }
}
