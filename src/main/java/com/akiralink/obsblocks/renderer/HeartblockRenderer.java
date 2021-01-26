package com.akiralink.obsblocks.renderer;

import com.akiralink.obsblocks.advanced_blocks.HeartblockEntity;
import com.akiralink.obsblocks.models.HeartblockModel;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import software.bernie.geckolib3.renderer.geo.GeoBlockRenderer;

public class HeartblockRenderer extends GeoBlockRenderer<HeartblockEntity>
{
    public HeartblockRenderer(BlockEntityRenderDispatcher rendererDispatcherIn)
    {
        super(rendererDispatcherIn, new HeartblockModel());
    }

}