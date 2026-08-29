package net.keeblekapa.eldritchrealms.world.biome.surface;

import net.keeblekapa.eldritchrealms.block.EldritchRealmsBlocks;
import net.keeblekapa.eldritchrealms.world.biome.EldritchRealmsBiomes;
import net.minecraft.block.Block;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class EldritchRealmsMaterialRules {

    private static final MaterialRules.MaterialRule STONE =
            makeStateRule(EldritchRealmsBlocks.VEILSTONE);

    private static final MaterialRules.MaterialRule DEEPSLATE =
            makeStateRule(EldritchRealmsBlocks.SHADOWSLATE);


    // Grass

    private static final MaterialRules.MaterialRule M_GRASS_BLOCK =
            makeStateRule(EldritchRealmsBlocks.MYTHRAL_GRASS_BLOCK);

    private static final MaterialRules.MaterialRule N_GRASS_BLOCK =
            makeStateRule(EldritchRealmsBlocks.NOCTURB_GRASS_BLOCK);

    private static final MaterialRules.MaterialRule V_GRASS_BLOCK =
            makeStateRule(EldritchRealmsBlocks.VIRELUME_GRASS_BLOCK);


    // Ground

    private static final MaterialRules.MaterialRule MARRED_SOIL =
            makeStateRule(EldritchRealmsBlocks.MARRED_SOIL);

    private static final MaterialRules.MaterialRule ASTRAL_SAND =
            makeStateRule(EldritchRealmsBlocks.ASTRAL_SAND);

    private static final MaterialRules.MaterialRule ASTRAL_SANDSTONE =
            makeStateRule(EldritchRealmsBlocks.ASTRAL_SANDSTONE);

    private static final MaterialRules.MaterialRule EERIE_GRAVEL =
            makeStateRule(EldritchRealmsBlocks.EERIE_GRAVEL);


    public static MaterialRules.MaterialRule makeRules() {

        /*
         * Fluid level
         */
        MaterialRules.MaterialCondition aboveWater =
                MaterialRules.water(-1, 0);


        /*
         * Material patch noises
         */
        MaterialRules.MaterialCondition gravelPatch =
                MaterialRules.noiseThreshold(
                        NoiseParametersKeys.GRAVEL,
                        -0.05D,
                        0.05D
                );

        MaterialRules.MaterialCondition soilPatch =
                MaterialRules.noiseThreshold(
                        NoiseParametersKeys.PATCH,
                        0.35D
                );

        MaterialRules.MaterialCondition sandPatch =
                MaterialRules.noiseThreshold(
                        NoiseParametersKeys.PATCH,
                        0.10D
                );


        /*
         * Shadowslate transition:
         *
         * Y <= 0   = Shadowslate
         * Y 0-8    = blended
         * Y >= 8   = Veilstone
         */
        MaterialRules.MaterialCondition shadowslateDepth =
                MaterialRules.verticalGradient(
                        "eldritchrealms:shadowslate",
                        YOffset.fixed(0),
                        YOffset.fixed(8)
                );


        /*
         * =========================================
         * Ocean
         * =========================================
         */

        MaterialRules.MaterialRule eerieOceanFloor =
                MaterialRules.sequence(

                        MaterialRules.condition(
                                gravelPatch,
                                EERIE_GRAVEL
                        ),

                        MaterialRules.condition(
                                soilPatch,
                                MARRED_SOIL
                        ),

                        ASTRAL_SAND
                );


        /*
         * =========================================
         * River
         * =========================================
         */

        MaterialRules.MaterialRule eerieRiverFloor =
                MaterialRules.sequence(

                        MaterialRules.condition(
                                gravelPatch,
                                EERIE_GRAVEL
                        ),

                        MaterialRules.condition(
                                sandPatch,
                                ASTRAL_SAND
                        ),

                        MARRED_SOIL
                );


        /*
         * =========================================
         * Beach
         * =========================================
         */

        MaterialRules.MaterialRule beachTop =
                MaterialRules.sequence(

                        MaterialRules.condition(
                                gravelPatch,
                                EERIE_GRAVEL
                        ),

                        MaterialRules.condition(
                                soilPatch,
                                MARRED_SOIL
                        ),

                        ASTRAL_SAND
                );


        /*
         * =========================================
         * Land top blocks
         * =========================================
         */

        MaterialRules.MaterialRule mythralGrassSurface =
                MaterialRules.sequence(
                        MaterialRules.condition(
                                aboveWater,
                                M_GRASS_BLOCK
                        ),
                        MARRED_SOIL
                );

        MaterialRules.MaterialRule virelumeGrassSurface =
                MaterialRules.sequence(
                        MaterialRules.condition(
                                aboveWater,
                                V_GRASS_BLOCK
                        ),
                        MARRED_SOIL
                );

        MaterialRules.MaterialRule nocturbGrassSurface =
                MaterialRules.sequence(
                        MaterialRules.condition(
                                aboveWater,
                                N_GRASS_BLOCK
                        ),
                        MARRED_SOIL
                );


        /*
         * =========================================
         * Actual WORLD SURFACE rules
         *
         * MaterialRules.surface() prevents these
         * from being applied to deep noise caves.
         * =========================================
         */

        MaterialRules.MaterialRule worldSurface =
                MaterialRules.sequence(

                        /*
                         * Eerie Beach
                         */

                        MaterialRules.condition(
                                MaterialRules.biome(
                                        EldritchRealmsBiomes.EERIE_BEACH
                                ),
                                MaterialRules.sequence(

                                        // Visible top
                                        MaterialRules.condition(
                                                MaterialRules.STONE_DEPTH_FLOOR,
                                                beachTop
                                        ),

                                        // Sand underneath top layer
                                        MaterialRules.condition(
                                                MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH,
                                                ASTRAL_SAND
                                        ),

                                        // Sandstone below sand
                                        MaterialRules.condition(
                                                MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH_RANGE_6,
                                                ASTRAL_SANDSTONE
                                        )
                                )
                        ),


                        /*
                         * Eerie Ocean
                         */

                        MaterialRules.condition(
                                MaterialRules.biome(
                                        EldritchRealmsBiomes.EERIE_OCEAN
                                ),
                                MaterialRules.condition(
                                        MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH,
                                        eerieOceanFloor
                                )
                        ),


                        /*
                         * Eerie River
                         */

                        MaterialRules.condition(
                                MaterialRules.biome(
                                        EldritchRealmsBiomes.EERIE_RIVER
                                ),
                                MaterialRules.condition(
                                        MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH,
                                        eerieRiverFloor
                                )
                        ),


                        /*
                         * Umbram Oak Forest
                         */

                        MaterialRules.condition(
                                MaterialRules.biome(
                                        EldritchRealmsBiomes.UMBRAM_OAK_FOREST
                                ),
                                MaterialRules.sequence(

                                        MaterialRules.condition(
                                                MaterialRules.STONE_DEPTH_FLOOR,
                                                virelumeGrassSurface
                                        ),

                                        MaterialRules.condition(
                                                MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH,
                                                MARRED_SOIL
                                        )
                                )
                        ),


                        /*
                         * Phontum Plains
                         */

                        MaterialRules.condition(
                                MaterialRules.biome(
                                        EldritchRealmsBiomes.PHONTUM_PLAINS
                                ),
                                MaterialRules.sequence(

                                        MaterialRules.condition(
                                                MaterialRules.STONE_DEPTH_FLOOR,
                                                nocturbGrassSurface
                                        ),

                                        MaterialRules.condition(
                                                MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH,
                                                MARRED_SOIL
                                        )
                                )
                        ),


                        /*
                         * Eldem Woods
                         */

                        MaterialRules.condition(
                                MaterialRules.biome(
                                        EldritchRealmsBiomes.ELDEM_WOODS
                                ),
                                MaterialRules.sequence(

                                        MaterialRules.condition(
                                                MaterialRules.STONE_DEPTH_FLOOR,
                                                mythralGrassSurface
                                        ),

                                        MaterialRules.condition(
                                                MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH,
                                                MARRED_SOIL
                                        )
                                )
                        )
                );


        /*
         * =========================================
         * Cave material
         * =========================================
         *
         * These rules are AFTER the real surface.
         * Therefore grass/beach/etc gets first
         * priority on the actual terrain surface.
         *
         * Deep caves:
         * Shadowslate
         *
         * Higher caves:
         * Veilstone
         */

        MaterialRules.MaterialRule caveStone =
                MaterialRules.sequence(

                        MaterialRules.condition(
                                shadowslateDepth,
                                DEEPSLATE
                        ),

                        STONE
                );


        return MaterialRules.sequence(

                /*
                 * Only apply grass, beaches,
                 * ocean floor, etc. to the actual
                 * preliminary world surface.
                 */
                MaterialRules.condition(
                        MaterialRules.surface(),
                        worldSurface
                ),


                /*
                 * Cave floors
                 */
                MaterialRules.condition(
                        MaterialRules.STONE_DEPTH_FLOOR,
                        caveStone
                ),


                /*
                 * Cave ceilings
                 */
                MaterialRules.condition(
                        MaterialRules.STONE_DEPTH_CEILING,
                        caveStone
                )
        );
    }


    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}