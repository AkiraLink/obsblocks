package com.akiralink.obsblocks.registry;


import com.akiralink.obsblocks.Obsblocks;
import com.akiralink.obsblocks.entities.Penguin;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {


    public static final EntityType<Penguin> PENGUIN = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(Obsblocks.MOD_ID, "penguin"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, Penguin::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );
    //Register Method
    public static void registerEntities() {
    }
}
