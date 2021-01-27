package com.akiralink.obsblocks.advanced_blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HeartblockOld extends Block {

    public HeartblockOld(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            if (player.experienceLevel >= 30){
                player.sendMessage(new LiteralText("Put the heart inside!"), true);
                //player.teleport(player.getX(),90F, player.getZ(),true);
                //new AncientPortalEntrance.Start(Obsblocks.ANCIENT_ENTRANCE_PIECE, 5, 5, 1, null, null);
            }
            else{
                player.sendMessage(new LiteralText("You are not strong enough to travel the Ancient Dimension!"), true);
            }

        }

        return ActionResult.SUCCESS;
    }
}