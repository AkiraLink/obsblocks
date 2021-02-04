package com.akiralink.obsblocks.registry;

import com.akiralink.obsblocks.Obsblocks;
import net.minecraft.entity.decoration.painting.PaintingMotive;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModVarious {
    public static final PaintingMotive ANCIENTLANDSCENE = new PaintingMotive(64, 64);

    public static void registerItems() {
        net.minecraft.util.registry.Registry.register(Registry.PAINTING_MOTIVE, new Identifier(Obsblocks.MOD_ID, "ancientlandscene"), ANCIENTLANDSCENE);
    }
}
