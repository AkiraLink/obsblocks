package com.akiralink.obsblocks.advanced_blocks;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HeartBlock extends FacingBlock implements BlockEntityProvider {
    public HeartBlock() {
        super(AbstractBlock.Settings.of(Material.STONE));
    }

    public static int playAni = 0;

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new HeartblockEntity();
    }

    //@Override
    public BlockRenderType getRenderType(BlockState state)
    {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        System.out.print("Getting Default State!");
        return this.getDefaultState().with(FACING, context.getPlayerLookDirection().getOpposite());
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options)
    {
        tooltip.add(new LiteralText("You're not supposed to see this!"));
        super.appendTooltip(stack, world, tooltip, options);
    }

    // Animation Stuff

    /*
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {



        if (!world.isClient) {
            if (player.experienceLevel >= 30){

                // fianally works
                if (player.getEquippedStack(MAINHAND).getItem() == ModItems.OBSIDIAN_HEART){
                    System.out.println("OBSIDIAN HEART RECOGNIZED");
                    world.getEntityById(5);
                    playAni = 1;
                    //HeartblockEntity.HeartController.markNeedsReload();
                    //HeartblockEntity.HeartController.setAnimation(HeartblockEntity.HeartBuilder);
                    player.teleport(player.getX(),90D, player.getZ(),true);
                    //playAni = 0;
                }
                else{
                    player.sendMessage(new LiteralText("Put the heart inside!"), true);
                    //new AncientPortalEntrance.Start(Obsblocks.ANCIENT_ENTRANCE_PIECE, 5, 5, 1, null, null);
                }
            }
            else{
                player.sendMessage(new LiteralText("You are not strong enough to travel the Ancient Dimension!"), true);
            }

        }



        return ActionResult.SUCCESS;
}

     */

}
