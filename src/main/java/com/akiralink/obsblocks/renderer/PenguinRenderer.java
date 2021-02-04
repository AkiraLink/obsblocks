package com.akiralink.obsblocks.renderer;

import com.akiralink.obsblocks.entities.Penguin;
import com.akiralink.obsblocks.models.PenguinModel;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import software.bernie.geckolib3.renderer.geo.GeoEntityRenderer;

public class PenguinRenderer extends GeoEntityRenderer<Penguin>
{
    public PenguinRenderer(EntityRenderDispatcher renderManager)
    {
        super(renderManager, new PenguinModel());
        this.shadowRadius = 0.7F; //change 0.7 to the desired shadow size.
    }
}
