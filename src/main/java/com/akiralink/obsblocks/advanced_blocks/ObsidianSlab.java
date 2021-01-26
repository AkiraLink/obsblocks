package com.akiralink.obsblocks.advanced_blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.data.client.model.VariantSettings;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.Direction;

import static net.minecraft.state.property.Properties.AXIS;

public class ObsidianSlab extends SlabBlock {


    public ObsidianSlab(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(AXIS, Direction.Axis.Y));
    }
}