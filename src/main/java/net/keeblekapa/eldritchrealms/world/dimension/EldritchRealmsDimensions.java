package net.keeblekapa.eldritchrealms.world.dimension;

import net.keeblekapa.eldritchrealms.EldritchRealms;
import net.keeblekapa.eldritchrealms.world.biome.EldritchRealmsBiomes;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

import java.util.OptionalLong;

public class EldritchRealmsDimensions {

    public static final RegistryKey<DimensionOptions> ELDRITCHDIM_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(EldritchRealms.MOD_ID, "eldritchdim"));
    public static final RegistryKey<World> ELDRITCHDIM_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(EldritchRealms.MOD_ID, "eldritchdim"));
    public static final RegistryKey<DimensionType> ELDRITCH_DIM_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(EldritchRealms.MOD_ID, "eldritchdim_type"));

    public static void bootstrapType(Registerable<DimensionType> context) {
        context.register(ELDRITCH_DIM_TYPE, new DimensionType(
                OptionalLong.of(0),
                false,
                true,
                false,
                false,
                0.0625,
                false,
                false,
                -64,
                320,
                320,
                BlockTags.INFINIBURN_OVERWORLD,
                new Identifier(EldritchRealms.MOD_ID, "the_eldritch_realm"),
                0.05f,
                new DimensionType.MonsterSettings(true, false, UniformIntProvider.create(0, 15), 15)
        ));
    }



}
