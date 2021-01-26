package com.akiralink.obsblocks.renderer;

import com.akiralink.obsblocks.advanced_blocks.Heartblock;
import com.akiralink.obsblocks.advanced_blocks.HeartblockEntity;
import com.akiralink.obsblocks.models.HeartblockModel;
import com.akiralink.obsblocks.models.HeartblockV2Item;
import com.akiralink.obsblocks.models.HeartblockModel;
import com.akiralink.obsblocks.registry.ModBlocks;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.scoreboard.ScoreboardCriterion;
import software.bernie.example.block.tile.FertilizerTileEntity;
import software.bernie.example.client.model.tile.FertilizerModel;
import software.bernie.geckolib3.renderer.geo.GeoBlockRenderer;

public class HeartblockRenderer extends GeoBlockRenderer<HeartblockEntity>
{
    public HeartblockRenderer(BlockEntityRenderDispatcher rendererDispatcherIn)
    {
        super(rendererDispatcherIn, new HeartblockModel());
    }

}