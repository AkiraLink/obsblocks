package com.akiralink.obsblocks.models;

import com.akiralink.obsblocks.Obsblocks;
import com.akiralink.obsblocks.entities.Penguin;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PenguinModel extends AnimatedGeoModel<Penguin>
{
    @Override
    public Identifier getModelLocation(Penguin object)
    {
        return new Identifier(Obsblocks.MOD_ID, "geo/penguin.geo.json");
    }

    @Override
    public Identifier getTextureLocation(Penguin object)
    {
        return new Identifier(Obsblocks.MOD_ID, "textures/entities/penguin_texture.png");
    }

    @Override
    public Identifier getAnimationFileLocation(Penguin object)
    {
        return new Identifier(Obsblocks.MOD_ID, "animations/penguin.animation.json");
    }
}
