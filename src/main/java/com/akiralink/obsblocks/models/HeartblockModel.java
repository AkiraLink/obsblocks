package com.akiralink.obsblocks.models;

import com.akiralink.obsblocks.advanced_blocks.HeartblockEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HeartblockModel extends AnimatedGeoModel<HeartblockEntity> {

    public HeartblockModel() {
    }

    @Override
    public Identifier getModelLocation(HeartblockEntity animatable) {
        return new Identifier("obsblocks", "geo/obsidian_rune_heartblock.geo.json");
    }

    @Override
    public Identifier getTextureLocation(HeartblockEntity entity) {
        return new Identifier("obsblocks", "textures/blocks/model_textures/obsidian_rune_heartblock_sheet.png");
    }

    @Override
    public Identifier getAnimationFileLocation(HeartblockEntity animatable) {
        return new Identifier("obsblocks", "animations/obsidian_rune_heartblock.animation.json");
    }
}
