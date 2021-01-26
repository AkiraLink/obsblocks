package com.akiralink.obsblocks.advanced_blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.TorchBlock;
import net.minecraft.particle.ParticleEffect;

public class ObsidianTorch extends TorchBlock {

    public ObsidianTorch(Settings settings, ParticleEffect particle) {
        super(settings, particle);
    }
}
