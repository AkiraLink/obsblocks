package com.akiralink.obsblocks.registry;

import com.akiralink.obsblocks.advanced_blocks.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.akiralink.obsblocks.Obsblocks.MOD_ID;


public class ModBlocks {
    
    // Blocks



    public static final HeartblockOld OBSIDIAN_RUNE_HEARTBLOCK_OLD = new HeartblockOld(Block.Settings.of(Material.STONE).nonOpaque());

    public static final Block OBSIDIAN_RUNE_ORE = new Block(FabricBlockSettings.
            of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES,3)
            .requiresTool()
            .strength(20f,50f)
            .sounds(BlockSoundGroup.STONE));

    public static final Block OBSIDIAN_SLAB = new SlabBlock(FabricBlockSettings.copy(Blocks.OBSIDIAN));

    public static final Block OBSIDIAN_STAIRS = new ObsidianStairs(Blocks.OBSIDIAN.getDefaultState(), FabricBlockSettings.copy(Blocks.OBSIDIAN));

    public static final Block OBSIDIAN_RUNE_PILLAR = new ObsidianPillarBlock(FabricBlockSettings.
            of(Material.STONE)
            .luminance(10)
            .breakByTool(FabricToolTags.PICKAXES,3)
            .requiresTool()
            .strength(40f,50f)
            .sounds(BlockSoundGroup.STONE));

    public static final Block OBSIDIAN_BRICK = new Block(FabricBlockSettings.
            of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES,3)
            .requiresTool()
            .strength(40f,50f)
            .sounds(BlockSoundGroup.STONE));

    public static final Block OBSIDIAN_CHISELED_BRICK = new Block(FabricBlockSettings.
            of(Material.STONE)
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
    public static HeartBlock OBSIDIAN_RUNE_HEARTBLOCK = new HeartBlock();
    //public static final BlockEntityType<HeartblockEntity> HEARTBLOCK_V2 = (BlockEntityType<HeartblockEntity>) RegistryUtils.registerBlockEntity("heartblocktile", BlockEntityType.Builder.create(HeartblockEntity::new, ModBlocks.OBSIDIAN_RUNE_HEARTBLOCK).build(null));


    public static BlockEntityType<HeartblockEntity> HEARTBLOCK_V2;

    public static void registerBlocks(){

        HEARTBLOCK_V2 = Registry.register(Registry.BLOCK_ENTITY_TYPE, MOD_ID + ":heartblocktile", BlockEntityType.Builder.create(HeartblockEntity::new,  ModBlocks.OBSIDIAN_RUNE_HEARTBLOCK).build(null));


        //HEARTBLOCK_V2 = RegistryUtils.registerBlockEntity("heartblockv2", BlockEntityType.Builder.create(HeartblockEntity::new, new Block[]{ModBlocks.OBSIDIAN_RUNE_HEARTBLOCKV2}));

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "obsidian_rune_heartblock"),OBSIDIAN_RUNE_HEARTBLOCK);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "obsidian_rune_energy_block"),OBSIDIAN_RUNE_ENERGY_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "obsidian_stairs"),OBSIDIAN_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "obsidian_slab"),OBSIDIAN_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "obsidian_rune_pillar"),OBSIDIAN_RUNE_PILLAR);
        //Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "obsidian_rune_heartblock_old"), OBSIDIAN_RUNE_HEARTBLOCK_OLD);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "obsidian_rune_ore"), OBSIDIAN_RUNE_ORE);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "obsidian_brick"), OBSIDIAN_BRICK);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "obsidian_chiseled_brick"), OBSIDIAN_CHISELED_BRICK);
    }
}
