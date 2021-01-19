package com.akiralink.obsblocks.renderer;

import com.akiralink.obsblocks.entities.AncientZombie;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.feature.SpiderEyesFeatureRenderer;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.util.Identifier;


@Environment(EnvType.CLIENT)
public class AncientZombieRenderer extends MobEntityRenderer<AncientZombie, ZombieEntityModel<AncientZombie>> {
    //EyeRenderer AncientEyes = new EyeRenderer(this);
    public AncientZombieRenderer(EntityRenderDispatcher entityRenderDispatcher_1) {
        super(entityRenderDispatcher_1, new ZombieEntityModel<>(0.75f,false),1);
        //this.addFeature(new EyesFeatureRenderer<AncientZombie, ZombieEntityModel<AncientZombie>>(this) {
    }

    @Override
    public Identifier getTexture(AncientZombie entity) {
        return new Identifier("obsblocks", "textures/entities/ancient_zombie_texture.png");
    }
}
