package com.akiralink.obsblocks.advanced_blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;

public class ObsidianStairs extends StairsBlock {
    public final Block baseBlock;

    public ObsidianStairs(BlockState blockState, Settings settings) {
        super(blockState, settings);
        this.baseBlock = blockState.getBlock();
    }

}