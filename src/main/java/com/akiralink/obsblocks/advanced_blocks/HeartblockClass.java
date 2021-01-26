package com.akiralink.obsblocks.advanced_blocks;

import com.akiralink.obsblocks.registry.ModBlocks;
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

import static net.minecraft.state.property.Properties.FACING;

public class HeartblockClass extends FacingBlock implements BlockEntityProvider {
    public HeartblockClass() {
        super(AbstractBlock.Settings.of(Material.STONE).nonOpaque());
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return ModBlocks.HEARTBLOCK_V2.instantiate();
    }

    @Override
    public BlockRenderType getRenderType(BlockState state)
    {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState().with(FACING, context.getPlayerLookDirection().getOpposite());
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options)
    {
        tooltip.add(new LiteralText("Turn on rain to see the fertilizer model!"));
        super.appendTooltip(stack, world, tooltip, options);
    }




}
