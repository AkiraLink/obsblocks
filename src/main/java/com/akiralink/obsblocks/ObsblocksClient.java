package com.akiralink.obsblocks;

import com.akiralink.obsblocks.registry.ModBlocks;
import com.akiralink.obsblocks.registry.ModEntities;
import com.akiralink.obsblocks.registry.ModItems;
import com.akiralink.obsblocks.renderer.AncientZombieRenderer;
import com.akiralink.obsblocks.renderer.HeartblockRenderer;
import com.akiralink.obsblocks.renderer.ObsidianSwordRenderer;
import com.akiralink.obsblocks.renderer.PenguinRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import software.bernie.geckolib3.GeckoLib;
import software.bernie.geckolib3.renderer.geo.GeoItemRenderer;

import static com.akiralink.obsblocks.Obsblocks.Ancient_Zombie;
@Environment(EnvType.CLIENT)
public class ObsblocksClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        GeckoLib.initialize();
        System.out.println("Obsblocks: Starting Client Initializer!");
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OBSIDIAN_RUNE_HEARTBLOCK_OLD, RenderLayer.getCutout());
        EntityRendererRegistry.INSTANCE.register(Ancient_Zombie, (entityRenderDispatcher_1, context) -> new AncientZombieRenderer(entityRenderDispatcher_1));
        BlockEntityRendererRegistry.INSTANCE.register(ModBlocks.HEARTBLOCK_V2, HeartblockRenderer::new);
        GeoItemRenderer.registerItemRenderer(ModItems.ANCIENT_RUNE_SWORD, new ObsidianSwordRenderer());
        EntityRendererRegistry.INSTANCE.register(ModEntities.PENGUIN,
                (entityRenderDispatcher, context) -> new PenguinRenderer(entityRenderDispatcher));
    }
}
