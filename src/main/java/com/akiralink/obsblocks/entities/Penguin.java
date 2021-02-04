package com.akiralink.obsblocks.entities;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class Penguin extends WolfEntity implements IAnimatable {

    private AnimationFactory factory = new AnimationFactory(this);

    public Penguin(EntityType<? extends WolfEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_EGG_THROW, 0.15F, 1.0F);
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
    {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("walk", true));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    public void angerToTag(CompoundTag tag) {

    }

    @Override
    public void angerFromTag(ServerWorld world, CompoundTag tag) {

    }

    @Override
    public void tickAngerLogic(ServerWorld world, boolean bl) {

    }

    @Override
    public boolean shouldAngerAt(LivingEntity entity) {
        return false;
    }

    @Override
    public boolean isUniversallyAngry(World world) {
        return false;
    }

    @Override
    public boolean hasAngerTime() {
        return false;
    }

    @Override
    public void forgive(PlayerEntity player) {

    }

    @Override
    public void universallyAnger() {

    }

    @Override
    public void stopAnger() {

    }
}
