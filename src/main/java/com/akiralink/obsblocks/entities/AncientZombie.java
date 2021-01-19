package com.akiralink.obsblocks.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.BreakDoorGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.world.World;

// that error is irrelevant, I guess
public class AncientZombie extends ZombieEntity  {

    public AncientZombie(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }
}
