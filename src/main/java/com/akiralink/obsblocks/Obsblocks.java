package com.akiralink.obsblocks;

import com.akiralink.obsblocks.advanced_blocks.HeartblockClass;
import com.akiralink.obsblocks.advanced_blocks.HeartblockEntity;
import com.akiralink.obsblocks.biomes.CustomBiome;
import com.akiralink.obsblocks.entities.AncientZombie;
import com.akiralink.obsblocks.features.AncientEnergyOutbreak;
import com.akiralink.obsblocks.features.AncientPortalEntrance;
import com.akiralink.obsblocks.generator.AncientGenerator;
import com.akiralink.obsblocks.registry.ModBlocks;
import com.akiralink.obsblocks.renderer.AncientZombieRenderer;
import com.akiralink.obsblocks.renderer.HeartblockRenderer;
import com.akiralink.obsblocks.sound.ModMusic;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.kyrptonaught.customportalapi.CustomPortalApiRegistry;
import net.kyrptonaught.customportalapi.portal.PortalIgnitionSource;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.SkyProperties;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.example.client.renderer.tile.FertilizerTileRenderer;
import software.bernie.example.registry.TileRegistry;
import software.bernie.geckolib3.GeckoLib;

import static com.akiralink.obsblocks.registry.ModItems.registerItems;


public class Obsblocks implements ModInitializer,ClientModInitializer {


    public static Logger LOGGER = LogManager.getLogger();
    // making that shit a lot easier
    public static final String MOD_ID = "obsblocks";

    /// Features

    // Portal Entrance
    public static final StructurePieceType ANCIENT_ENTRANCE_PIECE = AncientGenerator.MyPiece::new;
    private static final StructureFeature<DefaultFeatureConfig> ANCIENT_ENTRANCE = new AncientPortalEntrance(DefaultFeatureConfig.CODEC);
    private static final ConfiguredStructureFeature<?, ?> ANCIENT_ENTRANCE_CONFIGURED = ANCIENT_ENTRANCE.configure(DefaultFeatureConfig.DEFAULT);


    // Ancient Temple
    public static final StructurePieceType MY_PIECE = AncientGenerator.MyPiece::new;
    private static final StructureFeature<DefaultFeatureConfig> MY_STRUCTURE = new AncientPortalEntrance(DefaultFeatureConfig.CODEC);
    private static final ConfiguredStructureFeature<?, ?> MY_CONFIGURED = MY_STRUCTURE.configure(DefaultFeatureConfig.DEFAULT);


    // Ancient Energy Outbreak Feature
    private static final Feature<DefaultFeatureConfig> ANCIENT_ENERGY_OUTBREAK = new AncientEnergyOutbreak(DefaultFeatureConfig.CODEC);
    public static final ConfiguredFeature<?, ?> ANCIENT_ENERGY_OUTBREAK_CONFIGURED = ANCIENT_ENERGY_OUTBREAK.configure(FeatureConfig.DEFAULT)
            .decorate(Decorator.CHANCE.configure(new ChanceDecoratorConfig(5)));




    //registering Biome
    public static final RegistryKey<Biome> ANCIENTLAND_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier("obsblocks", "ancientland"));

    public void onInitializeClient() {
        GeckoLib.initialize();
        System.out.println("Obsblocks: Starting Client Initializer!");
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OBSIDIAN_RUNE_HEARTBLOCK, RenderLayer.getCutout());
        EntityRendererRegistry.INSTANCE.register(Ancient_Zombie, (entityRenderDispatcher_1, context) -> new AncientZombieRenderer(entityRenderDispatcher_1));
        BlockEntityRendererRegistry.INSTANCE.register(ModBlocks.HEARTBLOCK_V2, HeartblockRenderer::new);
    }

    // registering Entities

    //public static final EntityType<AncientZombie> Ancient_Zombie = Registry.register(
            //Registry.ENTITY_TYPE, new Identifier("obsblocks", "ancient_zombie"),
            //FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, AncientZombie::new).dimensions(EntityDimensions.fixed(1f, 2f)).build());

    // Biome

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


    // registering Ancient Zombie

    public static final EntityType<AncientZombie> Ancient_Zombie = Registry.register(
            Registry.ENTITY_TYPE, new Identifier("obsblocks", "ancient_zombie"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, AncientZombie::new).fireImmune().dimensions(EntityDimensions.fixed(1f, 2f)).build());

    @Override
    public void onInitialize() {

        //APIS
        //GeckoLib.initialize();

        // Ancient Entrance
        FabricStructureBuilder.create(new Identifier("obsblocks", "ancient_entrance"), ANCIENT_ENTRANCE)
                .step(GenerationStep.Feature.SURFACE_STRUCTURES)
                .defaultConfig(32, 8, 12345)
                .adjustsSurface()
                .register();

        RegistryKey<ConfiguredStructureFeature<?, ?>> ancientEntranceKey = RegistryKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_WORLDGEN,
                new Identifier("obsblocks", "ancient_entrance"));

        BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, ancientEntranceKey.getValue(), ANCIENT_ENTRANCE_CONFIGURED);

        // Ancient Temple
        Registry.register(Registry.STRUCTURE_PIECE, new Identifier("obsblocks", "my_piece"), MY_PIECE);

        FabricStructureBuilder.create(new Identifier("obsblocks", "ancient_temple"), MY_STRUCTURE)
                .step(GenerationStep.Feature.SURFACE_STRUCTURES)
                .defaultConfig(32, 8, 12345)
                .adjustsSurface()
                .register();

        RegistryKey<ConfiguredStructureFeature<?, ?>> myConfigured = RegistryKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_WORLDGEN,
                new Identifier("obsblocks", "ancient_temple"));
        BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, myConfigured.getValue(), MY_CONFIGURED);

        Registry.register(Registry.FEATURE, new Identifier("obsblocks", "ancient_energy_outbreak"), ANCIENT_ENERGY_OUTBREAK);

        RegistryKey<ConfiguredFeature<?, ?>> AncientEnergyOutbreakKey = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier("obsblocks", "ancient_energy_outbreak"));

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, AncientEnergyOutbreakKey.getValue(), ANCIENT_ENERGY_OUTBREAK_CONFIGURED);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ANCIENTLAND_KEY), GenerationStep.Feature.UNDERGROUND_ORES, AncientEnergyOutbreakKey);
        BiomeModifications.addStructure(BiomeSelectors.includeByKey(ANCIENTLAND_KEY), myConfigured);
        //BiomeModifications.addStructure(BiomeSelectors.all(), myConfigured);

        //Custom Music
        //Registry.register(Registry.SOUND_EVENT_KEY, new Identifier(Obsblocks.MOD_ID, "ancientlandmusic"), ModMusic.ANCIENTLANDMUSIC);
        Registry.register(Registry.SOUND_EVENT, ModMusic.ANCIENTLANDSOUND, ModMusic.ANCIENTLANDMUSIC);

        //CustomBiomes
        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier("obsblocks", "obsidian_surface_builder"), CustomBiome.OBSIDIAN_SURFACE_BUILDER);
        Registry.register(BuiltinRegistries.BIOME, ANCIENTLAND_KEY.getValue(), CustomBiome.ANCIENTLAND);

        // Add Biome as spawning biome
        OverworldBiomes.addContinentalBiome(ANCIENTLAND_KEY, OverworldClimate.TEMPERATE, 3D);
        OverworldBiomes.addContinentalBiome(ANCIENTLAND_KEY, OverworldClimate.COOL, 3D);




        FabricDefaultAttributeRegistry.register(Ancient_Zombie, AncientZombie.createZombieAttributes());
        //Ancient_Zombie.createZombieAttributes();
        CustomPortalApiRegistry.addPortal(ModBlocks.OBSIDIAN_RUNE_PILLAR, PortalIgnitionSource.FluidSource(Fluids.LAVA), new Identifier("obsblocks", "ancientdimension"), 51, 52, 49);
        LOGGER.debug("Obsblocks: \"Load Complete Event\" Starting...");
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
