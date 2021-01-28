package com.akiralink.obsblocks.advanced_blocks;

import com.akiralink.obsblocks.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.CompoundTag;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;


public class HeartblockEntity extends BlockEntity implements IAnimatable {


    private int activated = 0;
    private String controllerName = "popupController";
    public int playAni = HeartBlock.playAni;

    private AnimationFactory factory = new AnimationFactory(this);
    public AnimationController HeartController = new AnimationController(this, "heartcontroller", 0, this::predicate);
    private AnimationBuilder HeartBuilder = new AnimationBuilder().addAnimation("portalopening", false);



    public HeartblockEntity() {

        super(ModBlocks.HEARTBLOCK_V2);
    }

    @Override
    public BlockEntityType<?> getType(){
        return ModBlocks.HEARTBLOCK_V2;
    }
    // Serialize the BlockEntity

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);

        // Save the current value of the number to the tag
        tag.putInt("activated", activated);

        return tag;
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        activated = tag.getInt("activated");
    }

    // Deserialize the BlockEntity


    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
    {
        playAni = HeartBlock.playAni;
        //System.out.println("WWAWAAW");
        if (playAni == 1){
            //System.out.println("Activated");
            event.getController().setAnimation(HeartBuilder);
            HeartBlock.playAni = 0;
            return PlayState.CONTINUE;

        }
        else{
            //System.out.println("DISABLED");
            return PlayState.STOP;

        }
    }


    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(HeartController);
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}
