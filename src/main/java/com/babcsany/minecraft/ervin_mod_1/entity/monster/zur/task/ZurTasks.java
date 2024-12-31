package com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.task;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurNirtreEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.AbstractZurEntity;
import com.babcsany.minecraft.ervin_mod_1.tags.ModItemTags;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.entity.ai.brain.schedule.Activity;
import net.minecraft.entity.ai.brain.task.*;
import net.minecraft.entity.monster.piglin.AdmireItemTask;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraft.entity.monster.piglin.PiglinTasks;
import net.minecraft.entity.monster.piglin.StartAdmiringItemTask;
import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RangedInteger;
import net.minecraft.util.TickRangeConverter;

public class ZurTasks {
    private static final RangedInteger tick_range_30_120 = convertTickRange(30, 120);

    protected static void hunt(AbstractZurEntity zur) {
        int i = tick_range_30_120.getRandomWithinRange(zur.world.rand);
        zur.getBrain().replaceMemory(MemoryModuleType.HUNTED_RECENTLY, true, i);
    }

    protected static boolean isLoved(Item item) {
        return item.isIn(ModItemTags.ZUR_LOVED);
    }

    private static RangedInteger convertTickRange(int min, int max) {
        return TickRangeConverter.convertRange(min, max);
    }

    public static Brain<?> func_234469_a_(AbstractZurEntity zur, Brain<AbstractZurEntity> brain) {
        func_234464_a_(brain);
        return brain;
    }

    private static void func_234464_a_(Brain<AbstractZurEntity> brain) {
        brain.registerActivity(Activity.CORE, 0, ImmutableList.<Task<? super AbstractZurEntity>>of(new LookTask(45, 90), new WalkToTargetTask(), new InteractWithDoorTask(), new ZurAdmireItemTask<>(120)));
    }

    protected static boolean func_234480_a_(Item p_234480_0_) {
        return p_234480_0_.isIn(ModItemTags.ZUR_LOVED);
    }
}
