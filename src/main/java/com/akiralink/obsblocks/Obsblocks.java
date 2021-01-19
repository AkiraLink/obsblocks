package com.akiralink.obsblocks;

import com.akiralink.obsblocks.entities.AncientZombie;
import com.akiralink.obsblocks.registry.ModBlocks;
import com.akiralink.obsblocks.registry.ModEntities;
import com.akiralink.obsblocks.registry.ModItems;
import com.akiralink.obsblocks.renderer.AncientZombieRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.kyrptonaught.customportalapi.CustomPortalApiRegistry;
import net.kyrptonaught.customportalapi.portal.PortalIgnitionSource;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
//import net.kyrptonaught.
import static com.akiralink.obsblocks.registry.ModItems.registerItems;
import static net.minecraft.data.client.model.Models.CUBE;


public class Obsblocks implements ModInitializer,ClientModInitializer {


    // making that shit a lot easier
    public static final String MOD_ID = "obsblocks";

    public void onInitializeClient() {
        System.out.println("Obsblocks: Starting Client Initializer!");
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OBSIDIAN_RUNE_HEARTBLOCK, RenderLayer.getCutout());
        EntityRendererRegistry.INSTANCE.register(Ancient_Zombie, (entityRenderDispatcher_1, context) -> new AncientZombieRenderer(entityRenderDispatcher_1));
    }

    // registering Entities

    //public static final EntityType<AncientZombie> Ancient_Zombie = Registry.register(
            //Registry.ENTITY_TYPE, new Identifier("obsblocks", "ancient_zombie"),
            //FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, AncientZombie::new).dimensions(EntityDimensions.fixed(1f, 2f)).build());

    // setting an item group for Obsblocks

    public static final ItemGroup OBSBLOCK_GROUP = FabricItemGroupBuilder.build(
            new Identifier(MOD_ID, "general"),
            () -> new ItemStack(Blocks.OBSIDIAN));

    // setting the feature to spawn Obsidian Ore
    public static ConfiguredFeature<?, ?> OBSIDIAN_ORE_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    ModBlocks.OBSIDIAN_RUNE_ORE.getDefaultState(),
                    9)) // vein size
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0, // bottom offset
                    0, // min y level
                    20))) // max y level
            .spreadHorizontally()
            .repeat(5); // number of veins per chunk


    public static final EntityType<AncientZombie> Ancient_Zombie = Registry.register(
            Registry.ENTITY_TYPE, new Identifier("obsblocks", "ancient_zombie"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, AncientZombie::new).dimensions(EntityDimensions.fixed(1f, 2f)).build());

    @Override
    public void onInitialize() {
        //CustomPortal


        FabricDefaultAttributeRegistry.register(Ancient_Zombie, AncientZombie.createZombieAttributes());
        //Ancient_Zombie.createZombieAttributes();
        CustomPortalApiRegistry.addPortal(ModBlocks.OBSIDIAN_RUNE_PILLAR, PortalIgnitionSource.FluidSource(Fluids.LAVA), new Identifier("the_nether"), 51, 52, 49);
        System.out.println("Obsblocks: Portals loaded!");
        onInitializeClient();
        System.out.println("Hello Fabric World! <3 Obsblocks Mod is loading!");
        registerItems();
        System.out.println("Obsblocks: Items loaded!");
        ModBlocks.registerBlocks();
        System.out.println("Obsblocks: Blocks loaded!");
        //ModEntities.registerEntities();
        System.out.println("Obsblocks: Entities loaded!");
        //Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("obsblocks", "obsidian_ore_overworld"), OBSIDIAN_ORE_OVERWORLD);
        RegistryKey<ConfiguredFeature<?, ?>> obsidianOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier("obsblocks", "ore_wool_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, obsidianOreOverworld.getValue(), OBSIDIAN_ORE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, obsidianOreOverworld);
    }
    private void modifyVanillaLootTables(){
    }


}
