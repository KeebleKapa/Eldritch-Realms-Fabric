package net.keeblekapa.eldritchrealms.world.tree;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class UmbramOakTrunkPlacer extends TrunkPlacer {
    public static final Codec<UmbramOakTrunkPlacer> CODEC = RecordCodecBuilder.create(instance ->
            fillTrunkPlacerFields(instance).apply(instance, UmbramOakTrunkPlacer::new));

    public UmbramOakTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return EldritchRealmsTrunkPlacerTypes.UMBRAM_OAK_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world,
                                                  BiConsumer<BlockPos, BlockState> replacer,
                                                  Random random,
                                                  int height,
                                                  BlockPos startPos,
                                                  TreeFeatureConfig config) {
        setDirtUnderTrunk(world, replacer, random, startPos, config);

        Direction bendDirection = Direction.Type.HORIZONTAL.random(random);
        int bendStart = Math.max(3, height - 2 - random.nextInt(2));
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for (int y = 0; y < height; y++) {
            int bendOffset = y >= bendStart ? 1 : 0;
            BlockPos corner = startPos.offset(bendDirection, bendOffset);
            placeTrunkLayer(world, replacer, random, mutable, config, corner, y);
        }

        List<FoliagePlacer.TreeNode> foliageNodes = new ArrayList<>();
        BlockPos topCorner = startPos.offset(bendDirection, 1);
        foliageNodes.add(new FoliagePlacer.TreeNode(topCorner.add(1, height, 1), 1, true));

        List<Direction> availableDirections = new ArrayList<>(List.of(
                Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST));
        int branchCount = 2 + random.nextInt(3);

        for (int branchIndex = 0; branchIndex < branchCount; branchIndex++) {
            Direction direction = availableDirections.remove(random.nextInt(availableDirections.size()));
            int branchY = Math.max(2, height - 4 + random.nextInt(3));
            int bendOffset = branchY >= bendStart ? 1 : 0;
            BlockPos trunkCorner = startPos.offset(bendDirection, bendOffset);
            BlockPos.Mutable branchPos = branchStart(trunkCorner, branchY, direction, random);
            int branchLength = 2 + random.nextInt(2);

            for (int step = 0; step < branchLength; step++) {
                branchPos.move(direction);
                getAndSetState(world, replacer, random, branchPos, config,
                        state -> state.withIfExists(PillarBlock.AXIS, direction.getAxis()));
            }

            if (random.nextBoolean()) {
                branchPos.move(Direction.UP);
                getAndSetState(world, replacer, random, branchPos, config);
            }

            foliageNodes.add(new FoliagePlacer.TreeNode(branchPos.up().toImmutable(), 0, false));
        }

        return foliageNodes;
    }

    private static void setDirtUnderTrunk(TestableWorld world,
                                           BiConsumer<BlockPos, BlockState> replacer,
                                           Random random,
                                           BlockPos startPos,
                                           TreeFeatureConfig config) {
        setToDirt(world, replacer, random, startPos.down(), config);
        setToDirt(world, replacer, random, startPos.down().east(), config);
        setToDirt(world, replacer, random, startPos.down().south(), config);
        setToDirt(world, replacer, random, startPos.down().south().east(), config);
    }

    private void placeTrunkLayer(TestableWorld world,
                                 BiConsumer<BlockPos, BlockState> replacer,
                                 Random random,
                                 BlockPos.Mutable mutable,
                                 TreeFeatureConfig config,
                                 BlockPos corner,
                                 int y) {
        trySetState(world, replacer, random, mutable.set(corner, 0, y, 0), config);
        trySetState(world, replacer, random, mutable.set(corner, 1, y, 0), config);
        trySetState(world, replacer, random, mutable.set(corner, 0, y, 1), config);
        trySetState(world, replacer, random, mutable.set(corner, 1, y, 1), config);
    }

    private static BlockPos.Mutable branchStart(BlockPos trunkCorner,
                                                 int y,
                                                 Direction direction,
                                                 Random random) {
        int x = trunkCorner.getX();
        int z = trunkCorner.getZ();

        if (direction == Direction.EAST) {
            x++;
            z += random.nextInt(2);
        } else if (direction == Direction.WEST) {
            z += random.nextInt(2);
        } else if (direction == Direction.SOUTH) {
            x += random.nextInt(2);
            z++;
        } else {
            x += random.nextInt(2);
        }

        return new BlockPos.Mutable(x, trunkCorner.getY() + y, z);
    }
}
