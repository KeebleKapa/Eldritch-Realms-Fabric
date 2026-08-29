package net.keeblekapa.eldritchrealms.world;

import net.keeblekapa.eldritchrealms.EldritchRealms;
import net.keeblekapa.eldritchrealms.block.EldritchRealmsBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class EldritchRealmsPlacedFeatures {

    public static final RegistryKey<PlacedFeature> UMBRAM_OAK_PLACED_KEY = registryKey("umbram_oak_placed");
    public static final RegistryKey<PlacedFeature> PHONTUM_PLACED_KEY = registryKey("phontum_placed");
    public static final RegistryKey<PlacedFeature> ELDEM_PLACED_KEY = registryKey("eldem_placed");

    public static final RegistryKey<PlacedFeature> SABLEBELL_PLACED_KEY = registryKey("sablebell_placed");
    public static final RegistryKey<PlacedFeature> PHONTUM_PETALS_PLACED_KEY = registryKey("phontum_petals_placed");

    public static final RegistryKey<PlacedFeature> MYTHRAL_GRASS_PLACED_KEY = registryKey("mythral_grass_placed");
    public static final RegistryKey<PlacedFeature> VIRELUME_GRASS_PLACED_KEY = registryKey("virelume_grass_placed");
    public static final RegistryKey<PlacedFeature> NOCTURB_GRASS_PLACED_KEY = registryKey("nocturb_grass_placed");
    public static final RegistryKey<PlacedFeature> TALL_MYTHRAL_GRASS_PLACED_KEY = registryKey("tall_mythral_grass_placed");
    public static final RegistryKey<PlacedFeature> TALL_VIRELUME_GRASS_PLACED_KEY = registryKey("tall_virelume_grass_placed");
    public static final RegistryKey<PlacedFeature> TALL_NOCTURB_GRASS_PLACED_KEY = registryKey("tall_nocturb_grass_placed");


    public static final RegistryKey<PlacedFeature> DREADQUARTZ_ORE_PLACED_KEY = registryKey("dreadquartz_ore_placed");
    public static final RegistryKey<PlacedFeature> SHADOWSTEEL_ORE_PLACED_KEY = registryKey("shadowsteel_ore_placed");
    public static final RegistryKey<PlacedFeature> ENIGMATIC_IRON_ORE_PLACED_KEY = registryKey("enigmatic_iron_ore_placed");
    public static final RegistryKey<PlacedFeature> NEBULATIC_LAPIS_ORE_PLACED_KEY = registryKey("nebulatic_lapis_ore_placed");
    public static final RegistryKey<PlacedFeature> ECLIPSIUM_ORE_PLACED_KEY = registryKey("eclipsium_ore_placed");
    public static final RegistryKey<PlacedFeature> HALLOW_GOLD_ORE_PLACED_KEY = registryKey("hallow_gold_ore_placed");

    public static final RegistryKey<PlacedFeature> PHONTUM_LAKE_PLACED_KEY = registryKey("phontum_lake_placed");
    public static final RegistryKey<PlacedFeature> ELDEM_LAKE_PLACED_KEY = registryKey("eldem_lake_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);


        // Eerie Water Lakes
        PlacedFeatures.register(
                context,
                PHONTUM_LAKE_PLACED_KEY,

                configuredFeatureRegistryEntryLookup.getOrThrow(
                        EldritchRealmsConfiguredFeatures.PHONTUM_LAKE_KEY
                ),

                RarityFilterPlacementModifier.of(50),

                SquarePlacementModifier.of(),

                PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,

                BiomePlacementModifier.of()
        );
        PlacedFeatures.register(
                context,
                ELDEM_LAKE_PLACED_KEY,

                configuredFeatureRegistryEntryLookup.getOrThrow(
                        EldritchRealmsConfiguredFeatures.ELDEM_LAKE_KEY
                ),

                RarityFilterPlacementModifier.of(50),

                SquarePlacementModifier.of(),

                PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,

                BiomePlacementModifier.of()
        );


        // Trees
        register(context, UMBRAM_OAK_PLACED_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(EldritchRealmsConfiguredFeatures.UMBRAM_OAK_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(8, 0.1f, 1),
                        EldritchRealmsBlocks.UMBRAM_OAK_SAPLING));

        register(context, PHONTUM_PLACED_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(EldritchRealmsConfiguredFeatures.PHONTUM_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(1, 0.1f, 1),
                        EldritchRealmsBlocks.PHONTUM_SAPLING));

        register(context, ELDEM_PLACED_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(EldritchRealmsConfiguredFeatures.ELDEM_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(6, 0.1f, 1),
                        EldritchRealmsBlocks.ELDEM_SAPLING));

        // Sablebell
        register(context, SABLEBELL_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(EldritchRealmsConfiguredFeatures.SABLEBELL_KEY),
                List.of(
                        RarityFilterPlacementModifier.of(16),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()
                ));

        register(context, PHONTUM_PETALS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(EldritchRealmsConfiguredFeatures.PHONTUM_PETALS_KEY),
                List.of(
                        CountPlacementModifier.of(4),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()
                ));


        // Grasses
        register(context, MYTHRAL_GRASS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(EldritchRealmsConfiguredFeatures.MYTHRAL_GRASS_KEY),
                List.of(
                        CountPlacementModifier.of(8),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()
                ));

        register(context, VIRELUME_GRASS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(EldritchRealmsConfiguredFeatures.VIRELUME_GRASS_KEY),
                List.of(
                        CountPlacementModifier.of(8),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()
                ));

        register(context, NOCTURB_GRASS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(EldritchRealmsConfiguredFeatures.NOCTURB_GRASS_KEY),
                List.of(
                        CountPlacementModifier.of(8),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()
                ));


        register(context, TALL_MYTHRAL_GRASS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(EldritchRealmsConfiguredFeatures.TALL_MYTHRAL_GRASS_KEY),
                List.of(
                        CountPlacementModifier.of(1),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()
                ));

        register(context, TALL_VIRELUME_GRASS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(EldritchRealmsConfiguredFeatures.TALL_VIRELUME_GRASS_KEY),
                List.of(
                        CountPlacementModifier.of(1),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()
                ));

        register(context, TALL_NOCTURB_GRASS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(EldritchRealmsConfiguredFeatures.TALL_NOCTURB_GRASS_KEY),
                List.of(
                        CountPlacementModifier.of(1),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()
                ));


        // Ores
        register(context, DREADQUARTZ_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(EldritchRealmsConfiguredFeatures.DREADQUARTZ_ORE_KEY),
                EldritchRealmsOrePlacement.modifiersWithCount(32,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-32), YOffset.fixed(128))));

        register(context, NEBULATIC_LAPIS_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(EldritchRealmsConfiguredFeatures.NEBULATIC_LAPIS_ORE_KEY),
                EldritchRealmsOrePlacement.modifiersWithCount(32,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-56), YOffset.fixed(128))));

        register(context, HALLOW_GOLD_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(EldritchRealmsConfiguredFeatures.HALLOW_GOLD_ORE_KEY),
                EldritchRealmsOrePlacement.modifiersWithCount(5,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(128))));

        register(context, ECLIPSIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(EldritchRealmsConfiguredFeatures.ECLIPSIUM_ORE_KEY),
                EldritchRealmsOrePlacement.modifiersWithCount(16,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-56), YOffset.fixed(128))));

        register(context, SHADOWSTEEL_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(EldritchRealmsConfiguredFeatures.SHADOWSTEEL_ORE_KEY),
                EldritchRealmsOrePlacement.modifiersWithCount(7,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(128))));

        register(context, ENIGMATIC_IRON_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(EldritchRealmsConfiguredFeatures.ENIGMATIC_IRON_ORE_KEY),
                EldritchRealmsOrePlacement.modifiersWithCount(8,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-48), YOffset.fixed(48))));

//        register(context, VOIDSTONE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(EldritchRealmsConfiguredFeatures.VOIDSTONE_ORE_KEY),
//                EldritchRealmsOrePlacement.modifiersWithCount(3,
//                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(0))));
//
//        register(context, PHANTOMITE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(EldritchRealmsConfiguredFeatures.PHANTOMITE_ORE_KEY),
//                EldritchRealmsOrePlacement.modifiersWithCount(2,
//                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(-16))));
//
//        register(context, ETHEREALITE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(EldritchRealmsConfiguredFeatures.ETHEREALITE_ORE_KEY),
//                EldritchRealmsOrePlacement.modifiersWithCount(1,
//                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(-40))));
//
//        register(context, ELDRITCH_ESSENCE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(EldritchRealmsConfiguredFeatures.ELDRITCH_ESSENCE_ORE_KEY),
//                EldritchRealmsOrePlacement.modifiersWithCount(1,
//                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(32))));
    }

    public static RegistryKey<PlacedFeature> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(EldritchRealms.MOD_ID, name));
    }

    public static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
