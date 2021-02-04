package com.akiralink.obsblocks.renderer;

import com.akiralink.obsblocks.advanced_items.ObsidianRuneSword;
import com.akiralink.obsblocks.models.AncientSwordModel;
import software.bernie.geckolib3.renderer.geo.GeoItemRenderer;

public class ObsidianSwordRenderer extends GeoItemRenderer<ObsidianRuneSword> {

    public ObsidianSwordRenderer(){
        super(new AncientSwordModel());
    }

}
