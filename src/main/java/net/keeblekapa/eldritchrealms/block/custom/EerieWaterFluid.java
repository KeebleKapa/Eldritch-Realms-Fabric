package net.keeblekapa.eldritchrealms.block.custom;

import net.keeblekapa.eldritchrealms.block.EldritchRealmsBlocks;
import net.keeblekapa.eldritchrealms.block.EldritchRealmsFluids;
import net.keeblekapa.eldritchrealms.item.EldritchRealmsItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public abstract class EerieWaterFluid extends FlowableFluid {

    @Override
    public Fluid getFlowing() {
        return EldritchRealmsFluids.FLOWING_EERIE_WATER;
    }

    @Override
    public Fluid getStill() {
        return EldritchRealmsFluids.STILL_EERIE_WATER;
    }

    @Override
    public boolean matchesType(Fluid fluid) {
        return fluid == EldritchRealmsFluids.STILL_EERIE_WATER
                || fluid == EldritchRealmsFluids.FLOWING_EERIE_WATER;
    }

    @Override
    protected boolean isInfinite(World world) {
        return false;
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        Block.dropStacks(state, world, pos, world.getBlockEntity(pos));
    }

    @Override
    protected int getFlowSpeed(WorldView world) {
        return 3;
    }

    @Override
    protected int getLevelDecreasePerBlock(WorldView world) {
        return 1;
    }

    @Override
    public Item getBucketItem() {
        return EldritchRealmsItems.EERIE_WATER_BUCKET;
    }

    @Override
    protected boolean canBeReplacedWith(
            FluidState state,
            BlockView world,
            BlockPos pos,
            Fluid fluid,
            Direction direction
    ) {
        return false;
    }

    @Override
    public int getTickRate(WorldView world) {
        return 7;
    }

    @Override
    protected float getBlastResistance() {
        return 100.0F;
    }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return EldritchRealmsBlocks.EERIE_WATER
                .getDefaultState()
                .with(FluidBlock.LEVEL, getBlockStateLevel(state));
    }


    public static class Flowing extends EerieWaterFluid {

        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public boolean isStill(FluidState state) {
            return false;
        }

        @Override
        public int getLevel(FluidState state) {
            return state.get(LEVEL);
        }
    }


    public static class Still extends EerieWaterFluid {

        @Override
        public boolean isStill(FluidState state) {
            return true;
        }

        @Override
        public int getLevel(FluidState state) {
            return 8;
        }
    }
}