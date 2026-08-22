package net.keeblekapa.eldritchrealms.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.keeblekapa.eldritchrealms.world.EldritchRealmsPlacedFeatures;
import net.keeblekapa.eldritchrealms.world.biome.EldritchRealmsBiomes;
import net.keeblekapa.eldritchrealms.world.dimension.EldritchRealmsDimensions;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.gen.GenerationStep;

import java.util.function.Predicate;

public class EldritchRealmsOreGeneration {

    public static void generateOres() {
    }

    public static Predicate<BiomeSelectionContext> foundInEldritchRealms() {
        return context -> context.canGenerateIn(EldritchRealmsDimensions.ELDRITCHDIM_KEY);
    }

    public static Predicate<BiomeSelectionContext> foundInOverworld() {
        return context -> context.canGenerateIn(DimensionOptions.OVERWORLD)
                && !context.getBiomeKey().equals(EldritchRealmsBiomes.UMBRAM_OAK_FOREST)
                && !context.getBiomeKey().equals(EldritchRealmsBiomes.PHONTUM_PLAINS)
                && !context.getBiomeKey().equals(EldritchRealmsBiomes.ELDEM_WOODS);
    }
}
