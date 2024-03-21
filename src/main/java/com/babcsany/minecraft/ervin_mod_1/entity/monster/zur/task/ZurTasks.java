package com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.task;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.AbstractZurEntity;
import com.babcsany.minecraft.ervin_mod_1.tags.ModItemTags;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.item.Item;
import net.minecraft.util.RangedInteger;
import net.minecraft.util.TickRangeConverter;

public class ZurTasks {
    private static final RangedInteger tick_range_30_120 = convertTickRange(30, 120);

    protected static void hunt(AbstractZurEntity zur) {
        int i = tick_range_30_120.getRandomWithinRange(zur.world.rand);
        zur.getBrain().replaceMemory(MemoryModuleType.HUNTED_RECENTLY, true, (long)i);
    }

    protected static boolean isLoved(Item item) {
        return item.isIn(ModItemTags.ZUR_LOVED);
    }

    private static RangedInteger convertTickRange(int min, int max) {
        return TickRangeConverter.convertRange(min, max);
    }
}
