package net.keeblekapa.eldritchrealms.world;

import net.keeblekapa.eldritchrealms.EldritchRealms;
import net.keeblekapa.eldritchrealms.block.EldritchRealmsBlocks;
import net.keeblekapa.eldritchrealms.util.EldritchRealmsTags;
import net.keeblekapa.eldritchrealms.world.tree.UmbramOakTrunkPlacer;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.BendingTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;
import java.util.OptionalInt;


public class EldritchRealmsConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> DREADQUARTZ_ORE_KEY = registryKey("dreadquartz_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SHADOWSTEEL_ORE_KEY = registryKey("shadowsteel_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NEBULATIC_LAPIS_ORE_KEY = registryKey("nebulatic_lapis_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ECLIPSIUM_ORE_KEY = registryKey("eclipsium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HALLOW_GOLD_ORE_KEY = registryKey("hallow_gold_ore");


    public static final RegistryKey<ConfiguredFeature<?, ?>> PHONTUM_KEY = registryKey("phontum");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ELDEM_KEY = registryKey("eldem");
    public static final RegistryKey<ConfiguredFeature<?, ?>> UMBRAM_OAK_KEY = registryKey("umbram_oak");


    public static final RegistryKey<ConfiguredFeature<?, ?>> SABLEBELL_KEY = registryKey("sablebell");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PHONTUM_PETALS_KEY = registryKey("phontum_petals");

    public static final RegistryKey<ConfiguredFeature<?, ?>> MYTHRAL_GRASS_KEY = registryKey("mythral_grass");
    public static final RegistryKey<ConfiguredFeature<?, ?>> VIRELUME_GRASS_KEY = registryKey("virelume_grass");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NOCTURB_GRASS_KEY = registryKey("nocturb_grass");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TALL_MYTHRAL_GRASS_KEY = registryKey("tall_mythral_grass");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TALL_VIRELUME_GRASS_KEY = registryKey("tall_virelume_grass");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TALL_NOCTURB_GRASS_KEY = registryKey("tall_nocturb_grass");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        var placedFeatureRegistry = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        RuleTest stoneReplaceable = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceable = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceable = new BlockMatchRuleTest(Blocks.END_STONE);
        RuleTest veilstoneReplaceable = new BlockMatchRuleTest(EldritchRealmsBlocks.VEILSTONE);
        RuleTest shadowslateReplaceable = new BlockMatchRuleTest(EldritchRealmsBlocks.SHADOWSLATE);




        List<OreFeatureConfig.Target> eldritchRealmDreadquartzOres =
                List.of(OreFeatureConfig.createTarget(veilstoneReplaceable, EldritchRealmsBlocks.VEILSTONE_DREADQUARTZ_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(shadowslateReplaceable, EldritchRealmsBlocks.SHADOWSLATE_DREADQUARTZ_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> eldritchRealmShadowsteelOres =
                List.of(OreFeatureConfig.createTarget(veilstoneReplaceable, EldritchRealmsBlocks.VEILSTONE_SHADOWSTEEL_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(shadowslateReplaceable, EldritchRealmsBlocks.SHADOWSLATE_SHADOWSTEEL_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> eldritchRealmNebulaticLapisOres =
                List.of(OreFeatureConfig.createTarget(veilstoneReplaceable, EldritchRealmsBlocks.VEILSTONE_NEBULATIC_LAPIS_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(shadowslateReplaceable, EldritchRealmsBlocks.SHADOWSLATE_NEBULATIC_LAPIS_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> eldritchRealmEclipsiumOres =
                List.of(OreFeatureConfig.createTarget(veilstoneReplaceable, EldritchRealmsBlocks.VEILSTONE_ECLIPSIUM_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(shadowslateReplaceable, EldritchRealmsBlocks.SHADOWSLATE_ECLIPSIUM_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> eldritchRealmHallowGoldOres =
                List.of(OreFeatureConfig.createTarget(veilstoneReplaceable, EldritchRealmsBlocks.VEILSTONE_HALLOW_GOLD_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(shadowslateReplaceable, EldritchRealmsBlocks.SHADOWSLATE_HALLOW_GOLD_ORE.getDefaultState()));

        // Dreadquartz Ore Feature //
        register(context, DREADQUARTZ_ORE_KEY, Feature.ORE, new OreFeatureConfig(eldritchRealmDreadquartzOres, 10));
        register(context, SHADOWSTEEL_ORE_KEY, Feature.ORE, new OreFeatureConfig(eldritchRealmShadowsteelOres, 6));
        register(context, NEBULATIC_LAPIS_ORE_KEY, Feature.ORE, new OreFeatureConfig(eldritchRealmNebulaticLapisOres, 7));
        register(context, ECLIPSIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(eldritchRealmEclipsiumOres, 3));
        register(context, HALLOW_GOLD_ORE_KEY, Feature.ORE, new OreFeatureConfig(eldritchRealmHallowGoldOres, 5));

        register(context, UMBRAM_OAK_KEY, Feature.TREE,
                new TreeFeatureConfig.Builder(
                        BlockStateProvider.of(EldritchRealmsBlocks.UMBRAM_OAK_LOG),
                        new UmbramOakTrunkPlacer(7, 4, 0),
                        BlockStateProvider.of(EldritchRealmsBlocks.UMBRAM_OAK_LEAVES),
                        new BlobFoliagePlacer(
                                ConstantIntProvider.create(2),
                                ConstantIntProvider.create(0),
                                3),
                        new TwoLayersFeatureSize(1, 1, 2, OptionalInt.of(5)))
                        .dirtProvider(BlockStateProvider.of(EldritchRealmsBlocks.MARRED_SOIL))
                        .build());

        register(context, PHONTUM_KEY, Feature.TREE,
                new TreeFeatureConfig.Builder(
                        BlockStateProvider.of(EldritchRealmsBlocks.PHONTUM_LOG),
                        new BendingTrunkPlacer(4, 2, 0, 3, UniformIntProvider.create(1, 2)),
                        new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                                .add(EldritchRealmsBlocks.PHONTUM_LEAVES.getDefaultState(), 3)
                                .add(EldritchRealmsBlocks.FLOWERING_PHONTUM_LEAVES.getDefaultState(), 1)),
                        new RandomSpreadFoliagePlacer(
                                ConstantIntProvider.create(3),
                                ConstantIntProvider.create(0),
                                ConstantIntProvider.create(2),
                                50),
                        new TwoLayersFeatureSize(1, 0, 1))
                        .dirtProvider(BlockStateProvider.of(EldritchRealmsBlocks.MARRED_SOIL))
                        .forceDirt()
                        .build());

        register(context, ELDEM_KEY, Feature.TREE,
                new TreeFeatureConfig.Builder(
                        BlockStateProvider.of(EldritchRealmsBlocks.ELDEM_LOG),
                        new StraightTrunkPlacer(5, 6, 0),
                        BlockStateProvider.of(EldritchRealmsBlocks.ELDEM_LEAVES),
                        new SpruceFoliagePlacer(
                                ConstantIntProvider.create(3),
                                ConstantIntProvider.create(0),
                                ConstantIntProvider.create(4)),
                        new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))
                        .dirtProvider(BlockStateProvider.of(EldritchRealmsBlocks.MARRED_SOIL))
                        .build());

        register(context, SABLEBELL_KEY, Feature.FLOWER,
                new RandomPatchFeatureConfig(
                        16, 3, 3,
                        PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                                new SimpleBlockFeatureConfig(BlockStateProvider.of(EldritchRealmsBlocks.SABLEBELL.getDefaultState()))
                        )
                )
        );

        register(context, PHONTUM_PETALS_KEY, Feature.FLOWER,
                new RandomPatchFeatureConfig(
                        16, 5, 2,
                        PlacedFeatures.createEntry(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockFeatureConfig(BlockStateProvider.of(EldritchRealmsBlocks.PHONTUM_PETALS.getDefaultState())),
                                BlockPredicate.matchingBlocks(new Vec3i(0, -1, 0), EldritchRealmsBlocks.NOCTURB_GRASS_BLOCK)
                        )
                )
        );


        register(context, MYTHRAL_GRASS_KEY, Feature.FLOWER,
               new RandomPatchFeatureConfig(
                       32, 3, 3,
                       PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                               new SimpleBlockFeatureConfig(BlockStateProvider.of(EldritchRealmsBlocks.MYTHRAL_GRASS.getDefaultState()))
                       )
               )
        );

        register(context, VIRELUME_GRASS_KEY, Feature.FLOWER,
               new RandomPatchFeatureConfig(
                       32, 3, 3,
                       PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                               new SimpleBlockFeatureConfig(BlockStateProvider.of(EldritchRealmsBlocks.VIRELUME_GRASS.getDefaultState()))
                       )
               )
        );

        register(context, NOCTURB_GRASS_KEY, Feature.FLOWER,
               new RandomPatchFeatureConfig(
                       32, 3, 3,
                       PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                               new SimpleBlockFeatureConfig(BlockStateProvider.of(EldritchRealmsBlocks.NOCTURB_GRASS.getDefaultState()))
                       )
               )
        );

        register(context, TALL_MYTHRAL_GRASS_KEY, Feature.FLOWER,
               new RandomPatchFeatureConfig(
                       16, 3, 3,
                       PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                               new SimpleBlockFeatureConfig(BlockStateProvider.of(EldritchRealmsBlocks.TALL_MYTHRAL_GRASS.getDefaultState()))
                       )
               )
        );

        register(context, TALL_VIRELUME_GRASS_KEY, Feature.FLOWER,
               new RandomPatchFeatureConfig(
                       16, 3, 3,
                       PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                               new SimpleBlockFeatureConfig(BlockStateProvider.of(EldritchRealmsBlocks.TALL_VIRELUME_GRASS.getDefaultState()))
                       )
               )
        );

        register(context, TALL_NOCTURB_GRASS_KEY, Feature.FLOWER,
               new RandomPatchFeatureConfig(
                       16, 3, 3,
                       PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                               new SimpleBlockFeatureConfig(BlockStateProvider.of(EldritchRealmsBlocks.TALL_NOCTURB_GRASS.getDefaultState()))
                       )
               )
        );

    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(EldritchRealms.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
