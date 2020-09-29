package com.babcsany.minecraft.ervin_mod_1.entity.animal;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;

public class ViltAttackGoal extends MeleeAttackGoal {
    private final ViltEntity viltEntity;
    private int raiseArmTicks;

    public ViltAttackGoal(ViltEntity viltEntity, double speedIn, boolean longMemoryIn) {
        super(viltEntity, speedIn, longMemoryIn);
        this.viltEntity = viltEntity;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting() {
        super.startExecuting();
        this.raiseArmTicks = 0;
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    public void resetTask() {
        super.resetTask();
        this.viltEntity.setAggroed(false);
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void tick() {
        super.tick();
        ++this.raiseArmTicks;
        if (this.raiseArmTicks >= 5 && this.func_234041_j_() < this.func_234042_k_() / 2) {
            this.viltEntity.setAggroed(true);
        } else {
            this.viltEntity.setAggroed(false);
        }

    }
}

