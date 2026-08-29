package net.keeblekapa.eldritchrealms.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EerieWaterBlock extends FluidBlock {
    public EerieWaterBlock(FlowableFluid fluid, Settings settings) {
        super(fluid, settings);
    }

    @Override
    public void onEntityCollision(
            BlockState state,
            World world,
            BlockPos pos,
            Entity entity
    ) {
        entity.slowMovement(
                state,
                new Vec3d(
                        0.94D,
                        0.98D,
                        0.94D
                )
        );

        super.onEntityCollision(state, world, pos, entity);
    }
}
