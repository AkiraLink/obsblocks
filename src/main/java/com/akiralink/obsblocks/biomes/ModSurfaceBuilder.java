package com.akiralink.obsblocks.biomes;

import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class ModSurfaceBuilder {
    public static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> ANCIENTLAND_SURFACE_BUILDER = SurfaceBuilder.DEFAULT
            .withConfig(new TernarySurfaceConfig(
                    Blocks.OBSIDIAN.getDefaultState(),
                    Blocks.STONE.getDefaultState(),
                    Blocks.GRAVEL.getDefaultState()));
}
