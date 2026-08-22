package net.keeblekapa.eldritchrealms.world.biome;

import net.keeblekapa.eldritchrealms.EldritchRealms;
import net.keeblekapa.eldritchrealms.sound.EldritchRealmsSounds;
import net.keeblekapa.eldritchrealms.world.EldritchRealmsPlacedFeatures;
import net.minecraft.client.sound.MusicType;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.carver.ConfiguredCarvers;

public class EldritchRealmsBiomes {

    public static final RegistryKey<Biome> UMBRAM_OAK_FOREST = RegistryKey.of(RegistryKeys.BIOME,
            new Identifier(EldritchRealms.MOD_ID, "umbram_oak_forest"));
    public static final RegistryKey<Biome> PHONTUM_PLAINS = RegistryKey.of(RegistryKeys.BIOME,
            new Identifier(EldritchRealms.MOD_ID, "phontum_plains"));
    public static final RegistryKey<Biome> ELDEM_WOODS = RegistryKey.of(RegistryKeys.BIOME,
            new Identifier(EldritchRealms.MOD_ID, "eldem_woods"));

    public static void bootstrap(Registerable<Biome> context) {
        context.register(UMBRAM_OAK_FOREST, umbramOakForest(context));
        context.register(PHONTUM_PLAINS, phontumPlains(context));
        context.register(ELDEM_WOODS, eldemWoods(context));
    }

    public static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder) {
        addLandCarversWithoutLavaLakes(builder);
        DefaultBiomeFeatures.addAmethystGeodes(builder);
        DefaultBiomeFeatures.addDungeons(builder);
        DefaultBiomeFeatures.addMineables(builder);
        DefaultBiomeFeatures.addSprings(builder);
        DefaultBiomeFeatures.addFrozenTopLayer(builder);
    }

    public static Biome umbramOakForest(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        /**spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.BAT, 4, 4, 4));
         **/

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        addLandCarversWithoutLavaLakes(biomeBuilder);

        addEldritchRealmsMineables(biomeBuilder);
        addUmbramOakForestVegetation(biomeBuilder);




        return new Biome.Builder()
                .precipitation(false)
                .downfall(0f)
                .temperature(0.4f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .skyColor(0x2d3f39)
                        .fogColor(0x588476)
                        .waterColor(0x3b826a)
                        .waterFogColor(0x568778)
                        .grassColor(0x1f6552)
                        .foliageColor(0x1a5645)
                        .moodSound(BiomeMoodSound.CAVE)
                        .music(MusicType.createIngameMusic(RegistryEntry.of(EldritchRealmsSounds.ELDRITCH_REALMS_DIMENSION_AMBIENCE))).build())
                .build();
    }

    public static Biome phontumPlains(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        /**spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.BAT, 4, 4, 4));
         **/

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        addLandCarversWithoutLavaLakes(biomeBuilder);
        addEldritchRealmsMineables(biomeBuilder);
        addPhontumPlainsVegetation(biomeBuilder);



        return new Biome.Builder()
                .precipitation(false)
                .downfall(0f)
                .temperature(0.4f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .skyColor(0x3d1635)
                        .fogColor(0x634e5f)
                        .waterColor(0x563a51)
                        .waterFogColor(0x543f50)
                        .grassColor(0x702e64)
                        .foliageColor(0x531b41)
                        .moodSound(BiomeMoodSound.CAVE)
                        .music(MusicType.createIngameMusic(RegistryEntry.of(EldritchRealmsSounds.ELDRITCH_REALMS_DIMENSION_AMBIENCE))).build())
                .build();
    }

    public static Biome eldemWoods(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        /**spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.BAT, 4, 4, 4));
         **/

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        addLandCarversWithoutLavaLakes(biomeBuilder);

        addEldritchRealmsMineables(biomeBuilder);
        addEldemWoodsVegetation(biomeBuilder);


        return new Biome.Builder()
                .precipitation(false)
                .downfall(0f)
                .temperature(0.4f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .skyColor(0x182d3b)
                        .fogColor(0x556168)
                        .waterColor(0x335366)
                        .waterFogColor(0x324c5b)
                        .grassColor(0x334556)
                        .foliageColor(0x2d3d4c)
                        .moodSound(BiomeMoodSound.CAVE)
                        .music(MusicType.createIngameMusic(RegistryEntry.of(EldritchRealmsSounds.ELDRITCH_REALMS_DIMENSION_AMBIENCE))).build())
                .build();
    }


    public static void addEldritchRealmsMineables(GenerationSettings.LookupBackedBuilder builder) {
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, EldritchRealmsPlacedFeatures.DREADQUARTZ_ORE_PLACED_KEY);
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, EldritchRealmsPlacedFeatures.SHADOWSTEEL_ORE_PLACED_KEY);
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, EldritchRealmsPlacedFeatures.HALLOW_GOLD_ORE_PLACED_KEY);
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, EldritchRealmsPlacedFeatures.NEBULATIC_LAPIS_ORE_PLACED_KEY);
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, EldritchRealmsPlacedFeatures.ECLIPSIUM_ORE_PLACED_KEY);
    }

    public static void addLandCarversWithoutLavaLakes(GenerationSettings.LookupBackedBuilder builder) {
        builder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.CAVE);
        builder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.CAVE_EXTRA_UNDERGROUND);
        builder.carver(GenerationStep.Carver.AIR, ConfiguredCarvers.CANYON);
    }

    public static void addEldritchRealmsFlowersVegetation(GenerationSettings.LookupBackedBuilder builder) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, EldritchRealmsPlacedFeatures.SABLEBELL_PLACED_KEY);
    }

    public static void addUmbramOakForestVegetation(GenerationSettings.LookupBackedBuilder builder) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, EldritchRealmsPlacedFeatures.UMBRAM_OAK_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, EldritchRealmsPlacedFeatures.VIRELUME_GRASS_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, EldritchRealmsPlacedFeatures.TALL_VIRELUME_GRASS_PLACED_KEY);

    }

    public static void addPhontumPlainsVegetation(GenerationSettings.LookupBackedBuilder builder) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, EldritchRealmsPlacedFeatures.PHONTUM_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, EldritchRealmsPlacedFeatures.PHONTUM_PETALS_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, EldritchRealmsPlacedFeatures.NOCTURB_GRASS_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, EldritchRealmsPlacedFeatures.TALL_NOCTURB_GRASS_PLACED_KEY);

    }

    public static void addEldemWoodsVegetation(GenerationSettings.LookupBackedBuilder builder) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, EldritchRealmsPlacedFeatures.ELDEM_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, EldritchRealmsPlacedFeatures.SABLEBELL_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, EldritchRealmsPlacedFeatures.MYTHRAL_GRASS_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, EldritchRealmsPlacedFeatures.TALL_MYTHRAL_GRASS_PLACED_KEY);
    }




}
