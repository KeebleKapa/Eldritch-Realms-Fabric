package net.keeblekapa.eldritchrealms.world.tree;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.keeblekapa.eldritchrealms.world.EldritchRealmsConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldView;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class UmbramOakSaplingGenerator extends SaplingGenerator {
    private static final int SAPLING_GRID_SIZE = 4;

    @Nullable
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return EldritchRealmsConfiguredFeatures.UMBRAM_OAK_KEY;
    }

    @Override
    public boolean generate(ServerWorld world,
                            ChunkGenerator chunkGenerator,
                            BlockPos pos,
                            BlockState state,
                            Random random) {
        BlockPos gridOrigin = findFourByFourGrid(world, pos, state.getBlock());
        if (gridOrigin == null) {
            return false;
        }

        RegistryEntry<ConfiguredFeature<?, ?>> tree = world.getRegistryManager()
                .get(RegistryKeys.CONFIGURED_FEATURE)
                .getEntry(EldritchRealmsConfiguredFeatures.UMBRAM_OAK_KEY)
                .orElse(null);
        if (tree == null) {
            return false;
        }

        BlockState[][] originalStates = new BlockState[SAPLING_GRID_SIZE][SAPLING_GRID_SIZE];
        BlockState[][] replacementStates = new BlockState[SAPLING_GRID_SIZE][SAPLING_GRID_SIZE];

        for (int x = 0; x < SAPLING_GRID_SIZE; x++) {
            for (int z = 0; z < SAPLING_GRID_SIZE; z++) {
                BlockPos saplingPos = gridOrigin.add(x, 0, z);
                originalStates[x][z] = world.getBlockState(saplingPos);
                replacementStates[x][z] = world.getFluidState(saplingPos).getBlockState();
                world.setBlockState(saplingPos, replacementStates[x][z], Block.NO_REDRAW);
            }
        }

        BlockPos treeOrigin = gridOrigin.add(1, 0, 1);
        if (tree.value().generate(world, chunkGenerator, random, treeOrigin)) {
            for (int x = 0; x < SAPLING_GRID_SIZE; x++) {
                for (int z = 0; z < SAPLING_GRID_SIZE; z++) {
                    BlockPos saplingPos = gridOrigin.add(x, 0, z);
                    if (world.getBlockState(saplingPos).equals(replacementStates[x][z])) {
                        world.updateListeners(saplingPos, originalStates[x][z], replacementStates[x][z], Block.NOTIFY_LISTENERS);
                    }
                }
            }
            return true;
        }

        for (int x = 0; x < SAPLING_GRID_SIZE; x++) {
            for (int z = 0; z < SAPLING_GRID_SIZE; z++) {
                world.setBlockState(gridOrigin.add(x, 0, z), originalStates[x][z], Block.NO_REDRAW);
            }
        }
        return false;
    }

    public static boolean hasFourByFourGrid(WorldView world, BlockPos pos, Block sapling) {
        return findFourByFourGrid(world, pos, sapling) != null;
    }

    @Nullable
    private static BlockPos findFourByFourGrid(WorldView world, BlockPos pos, Block sapling) {
        for (int originOffsetX = 0; originOffsetX < SAPLING_GRID_SIZE; originOffsetX++) {
            for (int originOffsetZ = 0; originOffsetZ < SAPLING_GRID_SIZE; originOffsetZ++) {
                BlockPos origin = pos.add(-originOffsetX, 0, -originOffsetZ);
                if (isCompleteGrid(world, origin, sapling)) {
                    return origin;
                }
            }
        }
        return null;
    }

    private static boolean isCompleteGrid(WorldView world, BlockPos origin, Block sapling) {
        for (int x = 0; x < SAPLING_GRID_SIZE; x++) {
            for (int z = 0; z < SAPLING_GRID_SIZE; z++) {
                if (!world.getBlockState(origin.add(x, 0, z)).isOf(sapling)) {
                    return false;
                }
            }
        }
        return true;
    }

}
