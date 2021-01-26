package com.akiralink.obsblocks.models;

import com.akiralink.obsblocks.Obsblocks;
import com.akiralink.obsblocks.advanced_blocks.Heartblock;
import com.akiralink.obsblocks.advanced_blocks.HeartblockEntity;
import net.minecraft.util.Identifier;
import software.bernie.example.item.JackInTheBoxItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HeartblockModel extends AnimatedGeoModel<HeartblockEntity> {

    @Override
    public Identifier getModelLocation(HeartblockEntity object) {
        return new Identifier("obsblocks", "geo/obsidian_rune_heartblockv2.geo.json");
    }

    @Override
    public Identifier getTextureLocation(HeartblockEntity object) {
        return new Identifier("obsblocks", "textures/blocks/model_textures/obsidian_rune_heartblock_sheet.png");
    }

    @Override
    public Identifier getAnimationFileLocation(HeartblockEntity object) {
        return new Identifier("obsblocks", "animations/obsidian_rune_heartblockv2.animation.json");
    }
}
