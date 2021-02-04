package com.akiralink.obsblocks.models;

import com.akiralink.obsblocks.Obsblocks;
import com.akiralink.obsblocks.advanced_items.ObsidianRuneSword;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AncientSwordModel extends AnimatedGeoModel<ObsidianRuneSword>
{
    @Override
    public Identifier getModelLocation(ObsidianRuneSword object)
    {
        return new Identifier(Obsblocks.MOD_ID, "geo/ancient_sword.geo.json");
    }

    @Override
    public Identifier getTextureLocation(ObsidianRuneSword object)
    {
        return new Identifier(Obsblocks.MOD_ID, "textures/items/model_textures/ancient_sword.png");
    }

    @Override
    public Identifier getAnimationFileLocation(ObsidianRuneSword object)
    {
        return new Identifier(Obsblocks.MOD_ID, "animations/ancient_sword_animation.animation.json");
    }
}
