package com.akiralink.obsblocks.registry;

import com.akiralink.obsblocks.Obsblocks;
import com.akiralink.obsblocks.advanced_blocks.*;
import com.akiralink.obsblocks.models.HeartblockModel;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import software.bernie.example.block.tile.FertilizerTileEntity;
import software.bernie.example.registry.BlockRegistry;
import software.bernie.geckolib3.util.RegistryUtils;


public class ModBlocks {
    
    // Blocks

    public static BlockEntityType<HeartblockEntity> HEARTBLOCK_V2;
    public static final HeartblockClass OBSIDIAN_RUNE_HEARTBLOCKV2 = new HeartblockClass(Block.Settings.of(Material.STONE).nonOpaque());
    public static final Heartblock OBSIDIAN_RUNE_HEARTBLOCK = new Heartblock(Block.Settings.of(Material.STONE).nonOpaque());

    public static final Block OBSIDIAN_RUNE_ORE = new Block(FabricBlockSettings.
            of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES,3)
            .requiresTool()
            .strength(20f,50f)
            .sounds(BlockSoundGroup.STONE));

    public static final Block OBSIDIAN_SLAB = new SlabBlock(FabricBlockSettings.copy(Blocks.OBSIDIAN));

    public static final Block OBSIDIAN_STAIRS = new ObsidianStairs(Blocks.OBSIDIAN.getDefaultState(), FabricBlockSettings.copy(Blocks.DIRT));

    public static final Block OBSIDIAN_RUNE_PILLAR = new ObsidianPillarBlock(FabricBlockSettings.
            of(Material.STONE)
            .luminance(10)
            .breakByTool(FabricToolTags.PICKAXES,3)
            .requiresTool()
            .strength(40f,50f)
            .sounds(BlockSoundGroup.STONE));

    public static final Block OBSIDIAN_RUNE_ENERGY_BLOCK = new Block(FabricBlockSettings.
            of(Material.STONE)
            .luminance(15)
            .breakByTool(FabricToolTags.PICKAXES,3)
            .requiresTool()
            .strength(40f,50f)
            .sounds(BlockSoundGroup.STONE));


    //public static final AbstractBlock ANCIENT_RUNE_TORCH = new ObsidianTorch(new AbstractBlock.Settings(Material.STONE,MaterialColor.BLACK),)


    // Register Method
    public static void registerBlocks(){
        HEARTBLOCK_V2 = RegistryUtils.registerBlockEntity("heartblockv2", BlockEntityType.Builder.create(HeartblockEntity::new, new Block[]{ModBlocks.OBSIDIAN_RUNE_HEARTBLOCKV2}));
        //HEARTBLOCK_V2 = Registry.register(Registry.BLOCK_ENTITY_TYPE, "obsblocks:heartblockv2", BlockEntityType.Builder.create(HeartblockEntity::new, OBSIDIAN_RUNE_HEARTBLOCKV2 ).build(null));
        Registry.register(Registry.BLOCK, new Identifier(Obsblocks.MOD_ID, "obsidian_rune_heartblockv2"),OBSIDIAN_RUNE_HEARTBLOCKV2);
        Registry.register(Registry.BLOCK, new Identifier(Obsblocks.MOD_ID, "obsidian_rune_energy_block"),OBSIDIAN_RUNE_ENERGY_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Obsblocks.MOD_ID, "obsidian_stairs"),OBSIDIAN_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier(Obsblocks.MOD_ID, "obsidian_slab"),OBSIDIAN_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(Obsblocks.MOD_ID, "obsidian_rune_pillar"),OBSIDIAN_RUNE_PILLAR);
        Registry.register(Registry.BLOCK, new Identifier(Obsblocks.MOD_ID, "obsidian_rune_heartblock"), OBSIDIAN_RUNE_HEARTBLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Obsblocks.MOD_ID, "obsidian_rune_ore"), OBSIDIAN_RUNE_ORE);

    }
}
