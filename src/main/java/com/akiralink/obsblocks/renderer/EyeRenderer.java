package com.akiralink.obsblocks.renderer;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.feature.SpiderEyesFeatureRenderer;
import net.minecraft.util.Identifier;

public class EyeRenderer extends EyesFeatureRenderer {
    public EyeRenderer(FeatureRendererContext featureRendererContext) {
        super(featureRendererContext);
        RenderLayer SKIN = RenderLayer.getEyes(new Identifier("obsblocks","textures/entities/ancient_zombie_eyes"));

    }

    @Override
    public RenderLayer getEyesTexture() {
        return null;
    }
}
