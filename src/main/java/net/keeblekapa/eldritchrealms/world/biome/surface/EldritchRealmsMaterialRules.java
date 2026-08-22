package net.keeblekapa.eldritchrealms.world.biome.surface;

import net.keeblekapa.eldritchrealms.block.EldritchRealmsBlocks;
import net.keeblekapa.eldritchrealms.world.biome.EldritchRealmsBiomes;
import net.minecraft.block.Block;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class EldritchRealmsMaterialRules {

    private static final MaterialRules.MaterialRule STONE = makeStateRule(EldritchRealmsBlocks.VEILSTONE);
    private static final MaterialRules.MaterialRule DEEPSLATE = makeStateRule(EldritchRealmsBlocks.SHADOWSLATE);
    private static final MaterialRules.MaterialRule M_GRASS_BLOCK = makeStateRule(EldritchRealmsBlocks.MYTHRAL_GRASS_BLOCK);
    private static final MaterialRules.MaterialRule N_GRASS_BLOCK = makeStateRule(EldritchRealmsBlocks.NOCTURB_GRASS_BLOCK);
    private static final MaterialRules.MaterialRule V_GRASS_BLOCK = makeStateRule(EldritchRealmsBlocks.VIRELUME_GRASS_BLOCK);
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(EldritchRealmsBlocks.MARRED_SOIL);

    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        MaterialRules.MaterialRule mythralGrassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, M_GRASS_BLOCK), DIRT);
        MaterialRules.MaterialRule virelumeGrassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, V_GRASS_BLOCK), DIRT);
        MaterialRules.MaterialRule nocturbGrassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, N_GRASS_BLOCK), DIRT);

        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(EldritchRealmsBiomes.UMBRAM_OAK_FOREST),
                            MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, virelumeGrassSurface)),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, STONE)),
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(EldritchRealmsBiomes.PHONTUM_PLAINS),
                            MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, nocturbGrassSurface)),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, STONE)),
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(EldritchRealmsBiomes.ELDEM_WOODS),
                            MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, mythralGrassSurface)),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, STONE))

        );



    }




    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
