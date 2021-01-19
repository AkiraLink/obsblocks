package com.akiralink.obsblocks.registry;

import com.akiralink.obsblocks.Obsblocks;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;


public class ModBlocks {


    // Advanced Block Classes

    public static class Heartblock extends Block {

        public Heartblock(Settings settings) {
            super(settings);
        }


        @Override
        public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
            if (!world.isClient) {
                player.sendMessage(new LiteralText("Put the heart inside!"), false);
            }

            return ActionResult.SUCCESS;
        }
    }
    // Blocks
    public static final Block OBSIDIAN_RUNE_PILLAR = new Block(FabricBlockSettings.
            of(Material.STONE)
            .luminance(15)
            .breakByTool(FabricToolTags.PICKAXES,3)
            .requiresTool()
            .strength(20f,50f)
            .sounds(BlockSoundGroup.STONE)
    );

    public static final Heartblock OBSIDIAN_RUNE_HEARTBLOCK = new Heartblock(Block.Settings.of(Material.STONE).nonOpaque());

    public static final Block OBSIDIAN_RUNE_ORE = new Block(FabricBlockSettings.
            of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES,3)
            .requiresTool()
            .strength(20f,50f)
            .sounds(BlockSoundGroup.STONE));


    // Register Method
    public static void registerBlocks(){
        Registry.register(Registry.BLOCK, new Identifier(Obsblocks.MOD_ID, "obsidian_rune_pillar"),OBSIDIAN_RUNE_PILLAR);
        Registry.register(Registry.BLOCK, new Identifier(Obsblocks.MOD_ID, "obsidian_rune_heartblock"), OBSIDIAN_RUNE_HEARTBLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Obsblocks.MOD_ID, "obsidian_rune_ore"), OBSIDIAN_RUNE_ORE);
    }
}
