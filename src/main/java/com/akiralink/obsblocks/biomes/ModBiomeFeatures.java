package com.akiralink.obsblocks.biomes;

import com.akiralink.obsblocks.Obsblocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.SpawnSettings;

public class ModBiomeFeatures {
    //ModBiomeFeatures ModBiomeFeatures = new ModBiomeFeatures();
    public static void addMonstersAncientLand(SpawnSettings.Builder builder, int ancientZombieWeight) {
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(Obsblocks.Ancient_Zombie, ancientZombieWeight, 4, 20));
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 30, 1, 4));
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SPIDER, 40, 4, 4));
    }
}
