package com.akiralink.obsblocks.advanced_blocks;

import com.akiralink.obsblocks.Obsblocks;
import com.akiralink.obsblocks.registry.ModItems;
import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.minecraft.entity.EquipmentSlot.MAINHAND;

public class HeartBlock extends FacingBlock implements BlockEntityProvider {
    public HeartBlock() {
        super(AbstractBlock.Settings.of(Material.STONE).nonOpaque());
        setDefaultState(this.stateManager.getDefaultState().with(Properties.FACING, Direction.SOUTH));
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

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {



        if (!world.isClient) {
            ServerWorld serverWorld = (ServerWorld) player.getEntityWorld();
            if (player.experienceLevel == 25){
                Vec3d tptarget = new Vec3d(10, 10, 10);
                ServerWorld ancientworld = serverWorld.getServer().getWorld(Obsblocks.ANCIENT_DIMENSION);

                FabricDimensions.teleport(player, ancientworld, new TeleportTarget(tptarget,tptarget,0,0));
            }
            if (player.experienceLevel >= 30){

                // fianally works
                if (player.getEquippedStack(MAINHAND).getItem() == ModItems.OBSIDIAN_HEART){
                    System.out.println("OBSIDIAN HEART RECOGNIZED");
                    world.getEntityById(5);
                    playAni = 1;
                    //HeartblockEntity.HeartController.markNeedsReload();
                    //HeartblockEntity.HeartController.setAnimation(HeartblockEntity.HeartBuilder);
                    //player.teleport(player.getX(),90D, player.getZ(),true);
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



}
