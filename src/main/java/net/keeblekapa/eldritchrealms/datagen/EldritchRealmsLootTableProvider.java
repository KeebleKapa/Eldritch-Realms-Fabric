package net.keeblekapa.eldritchrealms.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.keeblekapa.eldritchrealms.block.EldritchRealmsBlocks;
import net.keeblekapa.eldritchrealms.block.custom.AlkWheatCropBlock;
import net.keeblekapa.eldritchrealms.item.EldritchRealmsItems;
import net.minecraft.block.Block;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LocationCheckLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.BlockPredicate;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.util.math.BlockPos;

public class EldritchRealmsLootTableProvider extends FabricBlockLootTableProvider {
    public EldritchRealmsLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {


                /*
                 * ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                 *
                 *   STONE DROPS
                 *
                 * ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                 */

                /// Abyssal Granite ///
                addStoneFamilyDrops(EldritchRealmsBlocks.ABYSSAL_GRANITE, EldritchRealmsBlocks.ABYSSAL_GRANITE_STAIRS, EldritchRealmsBlocks.ABYSSAL_GRANITE_SLAB, EldritchRealmsBlocks.ABYSSAL_GRANITE_WALL);
                addStoneFamilyDrops(EldritchRealmsBlocks.ABYSSAL_GRANITE_BRICKS, EldritchRealmsBlocks.ABYSSAL_GRANITE_BRICK_STAIRS, EldritchRealmsBlocks.ABYSSAL_GRANITE_BRICK_SLAB, EldritchRealmsBlocks.ABYSSAL_GRANITE_BRICK_WALL);
                addStoneFamilyDrops(EldritchRealmsBlocks.POLISHED_ABYSSAL_GRANITE, EldritchRealmsBlocks.POLISHED_ABYSSAL_GRANITE_STAIRS, EldritchRealmsBlocks.POLISHED_ABYSSAL_GRANITE_SLAB, EldritchRealmsBlocks.POLISHED_ABYSSAL_GRANITE_WALL);
                addStoneFamilyDrops(EldritchRealmsBlocks.CRACKED_ABYSSAL_GRANITE_BRICKS, EldritchRealmsBlocks.CRACKED_ABYSSAL_GRANITE_BRICK_STAIRS, EldritchRealmsBlocks.CRACKED_ABYSSAL_GRANITE_BRICK_SLAB, EldritchRealmsBlocks.CRACKED_ABYSSAL_GRANITE_BRICK_WALL);

                addStoneFamilyDrops(EldritchRealmsBlocks.MOSSY_ABYSSAL_GRANITE, EldritchRealmsBlocks.MOSSY_ABYSSAL_GRANITE_STAIRS, EldritchRealmsBlocks.MOSSY_ABYSSAL_GRANITE_SLAB, EldritchRealmsBlocks.MOSSY_ABYSSAL_GRANITE_WALL);
                addStoneFamilyDrops(EldritchRealmsBlocks.MOSSY_ABYSSAL_GRANITE_BRICKS, EldritchRealmsBlocks.MOSSY_ABYSSAL_GRANITE_BRICK_STAIRS, EldritchRealmsBlocks.MOSSY_ABYSSAL_GRANITE_BRICK_SLAB, EldritchRealmsBlocks.MOSSY_ABYSSAL_GRANITE_BRICK_WALL);
                addStoneFamilyDrops(EldritchRealmsBlocks.MOSSY_POLISHED_ABYSSAL_GRANITE, EldritchRealmsBlocks.MOSSY_POLISHED_ABYSSAL_GRANITE_STAIRS, EldritchRealmsBlocks.MOSSY_POLISHED_ABYSSAL_GRANITE_SLAB, EldritchRealmsBlocks.MOSSY_POLISHED_ABYSSAL_GRANITE_WALL);
                addStoneFamilyDrops(EldritchRealmsBlocks.CRACKED_MOSSY_ABYSSAL_GRANITE_BRICKS, EldritchRealmsBlocks.CRACKED_MOSSY_ABYSSAL_GRANITE_BRICK_STAIRS, EldritchRealmsBlocks.CRACKED_MOSSY_ABYSSAL_GRANITE_BRICK_SLAB, EldritchRealmsBlocks.CRACKED_MOSSY_ABYSSAL_GRANITE_BRICK_WALL);

                /// Veilstone ///
                addDrop(EldritchRealmsBlocks.VEILSTONE, silkTouchDrop(EldritchRealmsBlocks.VEILSTONE, EldritchRealmsBlocks.COBBLED_VEILSTONE));
                addDrop(EldritchRealmsBlocks.VEILSTONE_STAIRS);
                addDrop(EldritchRealmsBlocks.VEILSTONE_SLAB, slabDrops(EldritchRealmsBlocks.VEILSTONE_SLAB));
                addDrop(EldritchRealmsBlocks.VEILSTONE_WALL);
                addStoneFamilyDrops(EldritchRealmsBlocks.COBBLED_VEILSTONE, EldritchRealmsBlocks.COBBLED_VEILSTONE_STAIRS, EldritchRealmsBlocks.COBBLED_VEILSTONE_SLAB, EldritchRealmsBlocks.COBBLED_VEILSTONE_WALL);
                addStoneFamilyDrops(EldritchRealmsBlocks.VEILSTONE_BRICKS, EldritchRealmsBlocks.VEILSTONE_BRICK_STAIRS, EldritchRealmsBlocks.VEILSTONE_BRICK_SLAB, EldritchRealmsBlocks.VEILSTONE_BRICK_WALL);
                addStoneFamilyDrops(EldritchRealmsBlocks.SMOOTH_VEILSTONE, EldritchRealmsBlocks.SMOOTH_VEILSTONE_STAIRS, EldritchRealmsBlocks.SMOOTH_VEILSTONE_SLAB, EldritchRealmsBlocks.SMOOTH_VEILSTONE_WALL);

                /// Shadowslate ///
                addStoneFamilyDrops(EldritchRealmsBlocks.SHADOWSLATE, EldritchRealmsBlocks.SHADOWSLATE_STAIRS, EldritchRealmsBlocks.SHADOWSLATE_SLAB, EldritchRealmsBlocks.SHADOWSLATE_WALL);
                addStoneFamilyDrops(EldritchRealmsBlocks.POLISHED_SHADOWSLATE, EldritchRealmsBlocks.POLISHED_SHADOWSLATE_STAIRS, EldritchRealmsBlocks.POLISHED_SHADOWSLATE_SLAB, EldritchRealmsBlocks.POLISHED_SHADOWSLATE_WALL);
                addStoneFamilyDrops(EldritchRealmsBlocks.SHADOWSLATE_BRICKS, EldritchRealmsBlocks.SHADOWSLATE_BRICK_STAIRS, EldritchRealmsBlocks.SHADOWSLATE_BRICK_SLAB, EldritchRealmsBlocks.SHADOWSLATE_BRICK_WALL);
                addStoneFamilyDrops(EldritchRealmsBlocks.SHADOWSLATE_TILES, EldritchRealmsBlocks.SHADOWSLATE_TILE_STAIRS, EldritchRealmsBlocks.SHADOWSLATE_TILE_SLAB, EldritchRealmsBlocks.SHADOWSLATE_TILE_WALL);
                addStoneFamilyDrops(EldritchRealmsBlocks.CRACKED_SHADOWSLATE_BRICKS, EldritchRealmsBlocks.CRACKED_SHADOWSLATE_BRICK_STAIRS, EldritchRealmsBlocks.CRACKED_SHADOWSLATE_BRICK_SLAB, EldritchRealmsBlocks.CRACKED_SHADOWSLATE_BRICK_WALL);

                /// Crimson Cobble ///
                addStoneFamilyDrops(EldritchRealmsBlocks.CRIMSON_COBBLE, EldritchRealmsBlocks.CRIMSON_COBBLE_STAIRS, EldritchRealmsBlocks.CRIMSON_COBBLE_SLAB, EldritchRealmsBlocks.CRIMSON_COBBLE_WALL);

                /// Eldritch Limestone ///
                addDrop(EldritchRealmsBlocks.ELDRITCH_LIMESTONE_PILLAR);
                addStoneFamilyDrops(EldritchRealmsBlocks.ELDRITCH_LIMESTONE, EldritchRealmsBlocks.ELDRITCH_LIMESTONE_STAIRS, EldritchRealmsBlocks.ELDRITCH_LIMESTONE_SLAB, EldritchRealmsBlocks.ELDRITCH_LIMESTONE_WALL);
                addStoneFamilyDrops(EldritchRealmsBlocks.POLISHED_ELDRITCH_LIMESTONE, EldritchRealmsBlocks.POLISHED_ELDRITCH_LIMESTONE_STAIRS, EldritchRealmsBlocks.POLISHED_ELDRITCH_LIMESTONE_SLAB, EldritchRealmsBlocks.POLISHED_ELDRITCH_LIMESTONE_WALL);
                addStoneFamilyDrops(EldritchRealmsBlocks.ELDRITCH_LIMESTONE_BRICKS, EldritchRealmsBlocks.ELDRITCH_LIMESTONE_BRICK_STAIRS, EldritchRealmsBlocks.ELDRITCH_LIMESTONE_BRICK_SLAB, EldritchRealmsBlocks.ELDRITCH_LIMESTONE_BRICK_WALL);


                /*
                * ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                *
                *   WOOD DROPS
                *
                * ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                */

                /// Umbram Oak ///
                addDrop(EldritchRealmsBlocks.UMBRAM_OAK_LOG);
                addDrop(EldritchRealmsBlocks.UMBRAM_OAK_WOOD);
                addDrop(EldritchRealmsBlocks.STRIPPED_UMBRAM_OAK_LOG);
                addDrop(EldritchRealmsBlocks.STRIPPED_UMBRAM_OAK_WOOD);
                addDrop(EldritchRealmsBlocks.UMBRAM_OAK_PLANKS);
                addDrop(EldritchRealmsBlocks.UMBRAM_OAK_STAIRS);
                addDrop(EldritchRealmsBlocks.UMBRAM_OAK_SLAB, slabDrops(EldritchRealmsBlocks.UMBRAM_OAK_SLAB));
                addDrop(EldritchRealmsBlocks.UMBRAM_OAK_BUTTON);
                addDrop(EldritchRealmsBlocks.UMBRAM_OAK_PRESSURE_PLATE);
                addDrop(EldritchRealmsBlocks.UMBRAM_OAK_DOOR, doorDrops(EldritchRealmsBlocks.UMBRAM_OAK_DOOR));
                addDrop(EldritchRealmsBlocks.UMBRAM_OAK_FENCE);
                addDrop(EldritchRealmsBlocks.UMBRAM_OAK_FENCE_GATE);
                addDrop(EldritchRealmsBlocks.UMBRAM_OAK_TRAPDOOR);
                addDrop(EldritchRealmsBlocks.UMBRAM_OAK_SAPLING);
                addDrop(EldritchRealmsBlocks.UMBRAM_OAK_LEAVES, leavesDrops(EldritchRealmsBlocks.UMBRAM_OAK_LEAVES, EldritchRealmsBlocks.UMBRAM_OAK_SAPLING, 0.05f));

                /// Phontum ///
                addDrop(EldritchRealmsBlocks.PHONTUM_LOG);
                addDrop(EldritchRealmsBlocks.PHONTUM_WOOD);
                addDrop(EldritchRealmsBlocks.STRIPPED_PHONTUM_LOG);
                addDrop(EldritchRealmsBlocks.STRIPPED_PHONTUM_WOOD);
                addDrop(EldritchRealmsBlocks.PHONTUM_PLANKS);
                addDrop(EldritchRealmsBlocks.PHONTUM_STAIRS);
                addDrop(EldritchRealmsBlocks.PHONTUM_SLAB, slabDrops(EldritchRealmsBlocks.PHONTUM_SLAB));
                addDrop(EldritchRealmsBlocks.PHONTUM_BUTTON);
                addDrop(EldritchRealmsBlocks.PHONTUM_PRESSURE_PLATE);
                addDrop(EldritchRealmsBlocks.PHONTUM_DOOR, doorDrops(EldritchRealmsBlocks.PHONTUM_DOOR));
                addDrop(EldritchRealmsBlocks.PHONTUM_FENCE);
                addDrop(EldritchRealmsBlocks.PHONTUM_FENCE_GATE);
                addDrop(EldritchRealmsBlocks.PHONTUM_TRAPDOOR);
                addDrop(EldritchRealmsBlocks.PHONTUM_SAPLING);
                addDrop(EldritchRealmsBlocks.PHONTUM_LEAVES, leavesDrops(EldritchRealmsBlocks.PHONTUM_LEAVES, EldritchRealmsBlocks.PHONTUM_SAPLING, 0.05f));
                addDrop(EldritchRealmsBlocks.FLOWERING_PHONTUM_LEAVES, leavesDrops(EldritchRealmsBlocks.FLOWERING_PHONTUM_LEAVES, EldritchRealmsBlocks.PHONTUM_SAPLING, 0.05f));

                /// Eldem ///
                addDrop(EldritchRealmsBlocks.ELDEM_LOG);
                addDrop(EldritchRealmsBlocks.ELDEM_WOOD);
                addDrop(EldritchRealmsBlocks.STRIPPED_ELDEM_LOG);
                addDrop(EldritchRealmsBlocks.STRIPPED_ELDEM_WOOD);
                addDrop(EldritchRealmsBlocks.ELDEM_PLANKS);
                addDrop(EldritchRealmsBlocks.ELDEM_STAIRS);
                addDrop(EldritchRealmsBlocks.ELDEM_SLAB, slabDrops(EldritchRealmsBlocks.ELDEM_SLAB));
                addDrop(EldritchRealmsBlocks.ELDEM_BUTTON);
                addDrop(EldritchRealmsBlocks.ELDEM_PRESSURE_PLATE);
                addDrop(EldritchRealmsBlocks.ELDEM_DOOR, doorDrops(EldritchRealmsBlocks.ELDEM_DOOR));
                addDrop(EldritchRealmsBlocks.ELDEM_FENCE);
                addDrop(EldritchRealmsBlocks.ELDEM_FENCE_GATE);
                addDrop(EldritchRealmsBlocks.ELDEM_TRAPDOOR);
                addDrop(EldritchRealmsBlocks.ELDEM_SAPLING);
                addDrop(EldritchRealmsBlocks.ELDEM_LEAVES, leavesDrops(EldritchRealmsBlocks.ELDEM_LEAVES, EldritchRealmsBlocks.ELDEM_SAPLING, 0.05f));


                /*
                 * ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                 *
                 *   GROUND DROPS
                 *
                 * ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                 */

                /// Eldritch Grass and Soil ///
                addDrop(EldritchRealmsBlocks.MYTHRAL_GRASS_BLOCK, silkTouchDrop(EldritchRealmsBlocks.MYTHRAL_GRASS_BLOCK, EldritchRealmsBlocks.MARRED_SOIL));
                addDrop(EldritchRealmsBlocks.MARRED_SOIL);
                addDrop(EldritchRealmsBlocks.TILLED_MARRED_SOIL, drops(EldritchRealmsBlocks.MARRED_SOIL));
                addDrop(EldritchRealmsBlocks.MYTHRAL_GRASS, eldritchGrassDrops(EldritchRealmsBlocks.MYTHRAL_GRASS));
                addDrop(EldritchRealmsBlocks.TALL_MYTHRAL_GRASS, tallEldritchGrassDrops(EldritchRealmsBlocks.TALL_MYTHRAL_GRASS, EldritchRealmsBlocks.TALL_MYTHRAL_GRASS));

                addDrop(EldritchRealmsBlocks.NOCTURB_GRASS_BLOCK, silkTouchDrop(EldritchRealmsBlocks.NOCTURB_GRASS_BLOCK, EldritchRealmsBlocks.MARRED_SOIL));
                addDrop(EldritchRealmsBlocks.MARRED_SOIL);
                addDrop(EldritchRealmsBlocks.NOCTURB_GRASS, eldritchGrassDrops(EldritchRealmsBlocks.NOCTURB_GRASS));
                addDrop(EldritchRealmsBlocks.TALL_NOCTURB_GRASS, tallEldritchGrassDrops(EldritchRealmsBlocks.TALL_NOCTURB_GRASS, EldritchRealmsBlocks.TALL_NOCTURB_GRASS));

                addDrop(EldritchRealmsBlocks.VIRELUME_GRASS_BLOCK, silkTouchDrop(EldritchRealmsBlocks.VIRELUME_GRASS_BLOCK, EldritchRealmsBlocks.MARRED_SOIL));
                addDrop(EldritchRealmsBlocks.MARRED_SOIL);
                addDrop(EldritchRealmsBlocks.VIRELUME_GRASS, eldritchGrassDrops(EldritchRealmsBlocks.VIRELUME_GRASS));
                addDrop(EldritchRealmsBlocks.TALL_VIRELUME_GRASS, tallEldritchGrassDrops(EldritchRealmsBlocks.TALL_VIRELUME_GRASS, EldritchRealmsBlocks.TALL_VIRELUME_GRASS));

                /// Gravel ///
                addDrop(EldritchRealmsBlocks.EERIE_GRAVEL);

                /// Astral Sand ///
                addDrop(EldritchRealmsBlocks.ASTRAL_SAND);
                addStoneFamilyDrops(EldritchRealmsBlocks.ASTRAL_SANDSTONE, EldritchRealmsBlocks.ASTRAL_SANDSTONE_STAIRS, EldritchRealmsBlocks.ASTRAL_SANDSTONE_SLAB, EldritchRealmsBlocks.ASTRAL_SANDSTONE_WALL);
                addStoneFamilyDrops(EldritchRealmsBlocks.ASTRAL_SANDSTONE_BRICKS, EldritchRealmsBlocks.ASTRAL_SANDSTONE_BRICK_STAIRS, EldritchRealmsBlocks.ASTRAL_SANDSTONE_BRICK_SLAB, EldritchRealmsBlocks.ASTRAL_SANDSTONE_BRICK_WALL);
                addStoneFamilyDrops(EldritchRealmsBlocks.SMOOTH_ASTRAL_SANDSTONE, EldritchRealmsBlocks.SMOOTH_ASTRAL_SANDSTONE_STAIRS, EldritchRealmsBlocks.SMOOTH_ASTRAL_SANDSTONE_SLAB, EldritchRealmsBlocks.SMOOTH_ASTRAL_SANDSTONE_WALL);

                /// Flowers ///
                addDrop(EldritchRealmsBlocks.SABLEBELL);
                addDrop(EldritchRealmsBlocks.PHONTUM_PETALS, flowerbedDrops(EldritchRealmsBlocks.PHONTUM_PETALS));

                /// Crops ///
                BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(EldritchRealmsBlocks.ALK_WHEAT).properties(StatePredicate.Builder.create()
                        .exactMatch(AlkWheatCropBlock.AGE, 7));
                addDrop(EldritchRealmsBlocks.ALK_WHEAT, cropDrops(EldritchRealmsBlocks.ALK_WHEAT, EldritchRealmsItems.ALK_WHEAT, EldritchRealmsItems.ALK_WHEAT_SEEDS, builder));


                /*
                 * ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                 *
                 *   MATERIAL DROPS
                 *
                 * ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                 */

                /// Gloomarble ///
                addDrop(EldritchRealmsBlocks.GLOOMARBLE, sevenToNineDrops(EldritchRealmsBlocks.GLOOMARBLE, EldritchRealmsItems.GLOOMARBLE_DUST));

                /// Dreadquartz ///
                addDrop(EldritchRealmsBlocks.VEILSTONE_DREADQUARTZ_ORE, twoToFiveDrops(EldritchRealmsBlocks.VEILSTONE_DREADQUARTZ_ORE, EldritchRealmsItems.DREADQUARTZ));
                addDrop(EldritchRealmsBlocks.SHADOWSLATE_DREADQUARTZ_ORE, twoToFiveDrops(EldritchRealmsBlocks.SHADOWSLATE_DREADQUARTZ_ORE, EldritchRealmsItems.DREADQUARTZ));
                addStoneFamilyDrops(EldritchRealmsBlocks.DREADQUARTZ_BLOCK, EldritchRealmsBlocks.DREADQUARTZ_STAIRS, EldritchRealmsBlocks.DREADQUARTZ_SLAB, EldritchRealmsBlocks.DREADQUARTZ_WALL);
                addStoneFamilyDrops(EldritchRealmsBlocks.DREADQUARTZ_BRICKS, EldritchRealmsBlocks.DREADQUARTZ_BRICK_STAIRS, EldritchRealmsBlocks.DREADQUARTZ_BRICK_SLAB, EldritchRealmsBlocks.DREADQUARTZ_BRICK_WALL);
                addStoneFamilyDrops(EldritchRealmsBlocks.SMOOTH_DREADQUARTZ, EldritchRealmsBlocks.SMOOTH_DREADQUARTZ_STAIRS, EldritchRealmsBlocks.SMOOTH_DREADQUARTZ_SLAB, EldritchRealmsBlocks.SMOOTH_DREADQUARTZ_WALL);
                addDrop(EldritchRealmsBlocks.SMOOTH_DREADQUARTZ_STAIRS);
                addDrop(EldritchRealmsBlocks.SMOOTH_DREADQUARTZ_SLAB, slabDrops(EldritchRealmsBlocks.SMOOTH_DREADQUARTZ_SLAB));
                addDrop(EldritchRealmsBlocks.SMOOTH_DREADQUARTZ_WALL);
                addDrop(EldritchRealmsBlocks.DREADQUARTZ_PILLAR);
                addDrop(EldritchRealmsBlocks.CHISELED_DREADQUARTZ);

                /// Shadowsteel ///
                addDrop(EldritchRealmsBlocks.VEILSTONE_SHADOWSTEEL_ORE, oneToTwoDropsNoSilkTouch(EldritchRealmsBlocks.VEILSTONE_SHADOWSTEEL_ORE, EldritchRealmsItems.SHADOWSTEEL_DUST));
                addDrop(EldritchRealmsBlocks.SHADOWSLATE_SHADOWSTEEL_ORE, oneToTwoDropsNoSilkTouch(EldritchRealmsBlocks.SHADOWSLATE_SHADOWSTEEL_ORE, EldritchRealmsItems.SHADOWSTEEL_DUST));
                addDrop(EldritchRealmsBlocks.SHADOWSTEEL_BLOCK);

                /// Enigmatic Iron ///
                addDrop(EldritchRealmsBlocks.VEILSTONE_ENIGMATIC_IRON_ORE, oneToTwoDropsNoSilkTouch(EldritchRealmsBlocks.VEILSTONE_ENIGMATIC_IRON_ORE, EldritchRealmsItems.ENIGMATIC_IRON_NUGGET));
                addDrop(EldritchRealmsBlocks.SHADOWSLATE_ENIGMATIC_IRON_ORE, oneToTwoDropsNoSilkTouch(EldritchRealmsBlocks.SHADOWSLATE_ENIGMATIC_IRON_ORE, EldritchRealmsItems.ENIGMATIC_IRON_NUGGET));
                addDrop(EldritchRealmsBlocks.ENIGMATIC_IRON_BLOCK);

                /// Nebulatic Lapis ///
                addDrop(EldritchRealmsBlocks.NEBULATIC_LAPIS_BLOCK);
                addDrop(EldritchRealmsBlocks.VEILSTONE_NEBULATIC_LAPIS_ORE, twoToFiveDrops(EldritchRealmsBlocks.VEILSTONE_NEBULATIC_LAPIS_ORE, EldritchRealmsItems.NEBULATIC_LAPIS));
                addDrop(EldritchRealmsBlocks.SHADOWSLATE_NEBULATIC_LAPIS_ORE, twoToFiveDrops(EldritchRealmsBlocks.SHADOWSLATE_NEBULATIC_LAPIS_ORE, EldritchRealmsItems.NEBULATIC_LAPIS));
                addDrop(EldritchRealmsBlocks.NEBULATIC_ENCHANTING_TABLE);

                /// Enigma Basalt ///
                addDrop(EldritchRealmsBlocks.ENIGMA_BASALT);
                addDrop(EldritchRealmsBlocks.POLISHED_ENIGMA_BASALT);
                addStoneFamilyDrops(EldritchRealmsBlocks.SMOOTH_ENIGMA_BASALT, EldritchRealmsBlocks.SMOOTH_ENIGMA_BASALT_STAIRS, EldritchRealmsBlocks.SMOOTH_ENIGMA_BASALT_SLAB, EldritchRealmsBlocks.SMOOTH_ENIGMA_BASALT_WALL);
                addStoneFamilyDrops(EldritchRealmsBlocks.SMOOTH_ENIGMA_BASALT_BRICKS, EldritchRealmsBlocks.SMOOTH_ENIGMA_BASALT_BRICK_STAIRS, EldritchRealmsBlocks.SMOOTH_ENIGMA_BASALT_BRICK_SLAB, EldritchRealmsBlocks.SMOOTH_ENIGMA_BASALT_BRICK_WALL);

                /// Eclipsium ///
                addDrop(EldritchRealmsBlocks.VEILSTONE_ECLIPSIUM_ORE, silkTouchItemDrop(EldritchRealmsBlocks.VEILSTONE_ECLIPSIUM_ORE, EldritchRealmsItems.ECLIPSIUM));
                addDrop(EldritchRealmsBlocks.SHADOWSLATE_ECLIPSIUM_ORE, silkTouchItemDrop(EldritchRealmsBlocks.SHADOWSLATE_ECLIPSIUM_ORE, EldritchRealmsItems.ECLIPSIUM));
                addDrop(EldritchRealmsBlocks.ECLIPSIUM_BLOCK);

                /// Hallow Gold ///
                addDrop(EldritchRealmsBlocks.HALLOW_GOLD_BLOCK);
                addDrop(EldritchRealmsBlocks.SHADOWSLATE_HALLOW_GOLD_ORE, silkTouchItemDrop(EldritchRealmsBlocks.SHADOWSLATE_HALLOW_GOLD_ORE, EldritchRealmsItems.HALLOW_GOLD_NUGGET));
                addDrop(EldritchRealmsBlocks.VEILSTONE_HALLOW_GOLD_ORE, silkTouchItemDrop(EldritchRealmsBlocks.VEILSTONE_HALLOW_GOLD_ORE, EldritchRealmsItems.HALLOW_GOLD_NUGGET));

    }

    private void addStoneFamilyDrops(Block base, Block stairs, Block slab, Block wall) {
        addDrop(base);
        addDrop(stairs);
        addDrop(slab, slabDrops(slab));
        addDrop(wall);
    }

    public LootTable.Builder silkTouchDrop(Block drop, Block block) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder) this.applyExplosionDecay(drop,
                ((LeafEntry.Builder)
                        ItemEntry.builder(block)
                                .apply(SetCountLootFunction
                                        .builder(ConstantLootNumberProvider
                                                .create(1.0f))))));
    }

    public LootTable.Builder silkTouchItemDrop(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder) this.applyExplosionDecay(drop,
                ((LeafEntry.Builder)
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction
                                        .builder(ConstantLootNumberProvider
                                                .create(1.0f))))));
    }

    public LootTable.Builder oneToTwoDropsNoSilkTouch(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder) this.applyExplosionDecay(drop,
                ((LeafEntry.Builder)
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction
                                        .builder(UniformLootNumberProvider
                                                .create(1.0f, 2.0f))))));
    }

    public LootTable.Builder oneToThreeDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder) this.applyExplosionDecay(drop,
                ((LeafEntry.Builder)
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction
                                        .builder(UniformLootNumberProvider
                                                .create(1.0f, 3.0f))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }

    public LootTable.Builder twoToFiveDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder) this.applyExplosionDecay(drop,
                ((LeafEntry.Builder)
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction
                                        .builder(UniformLootNumberProvider
                                                .create(2.0f, 5.0f))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }

    public LootTable.Builder fourToSevenDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder) this.applyExplosionDecay(drop,
                ((LeafEntry.Builder)
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction
                                        .builder(UniformLootNumberProvider
                                                .create(4.0f, 7.0f))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }

    public LootTable.Builder sevenToNineDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder) this.applyExplosionDecay(drop,
                ((LeafEntry.Builder)
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction
                                        .builder(UniformLootNumberProvider
                                                .create(7.0f, 9.0f))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }

    public LootTable.Builder oneToTenDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder) this.applyExplosionDecay(drop,
                ((LeafEntry.Builder)
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction
                                        .builder(UniformLootNumberProvider
                                                .create(1.0f, 10.0f))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }

    public LootTable.Builder eldritchGrassDrops(Block dropWithShears) {
        return dropsWithShears(
                dropWithShears,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        dropWithShears,
                        ItemEntry.builder(EldritchRealmsItems.ALK_WHEAT_SEEDS)
                                .conditionally(RandomChanceLootCondition.builder(0.125F))
                                .apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE, 2))
                )
        );
    }
    public LootTable.Builder tallEldritchGrassDrops(Block tallGrass, Block grass) {
        LootPoolEntry.Builder<?> builder = ItemEntry.builder(grass)
                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2.0F)))
                .conditionally(WITH_SHEARS)
                .alternatively(
                        ((LeafEntry.Builder)this.addSurvivesExplosionCondition(tallGrass, ItemEntry.builder(EldritchRealmsItems.ALK_WHEAT_SEEDS)))
                                .conditionally(RandomChanceLootCondition.builder(0.125F))
                );
        return LootTable.builder()
                .pool(
                        LootPool.builder()
                                .with(builder)
                                .conditionally(
                                        BlockStatePropertyLootCondition.builder(tallGrass).properties(StatePredicate.Builder.create().exactMatch(TallPlantBlock.HALF, DoubleBlockHalf.LOWER))
                                )
                                .conditionally(
                                        LocationCheckLootCondition.builder(
                                                LocationPredicate.Builder.create()
                                                        .block(
                                                                BlockPredicate.Builder.create()
                                                                        .blocks(tallGrass)
                                                                        .state(StatePredicate.Builder.create().exactMatch(TallPlantBlock.HALF, DoubleBlockHalf.UPPER).build())
                                                                        .build()
                                                        ),
                                                new BlockPos(0, 1, 0)
                                        )
                                )
                )
                .pool(
                        LootPool.builder()
                                .with(builder)
                                .conditionally(
                                        BlockStatePropertyLootCondition.builder(tallGrass).properties(StatePredicate.Builder.create().exactMatch(TallPlantBlock.HALF, DoubleBlockHalf.UPPER))
                                )
                                .conditionally(
                                        LocationCheckLootCondition.builder(
                                                LocationPredicate.Builder.create()
                                                        .block(
                                                                BlockPredicate.Builder.create()
                                                                        .blocks(tallGrass)
                                                                        .state(StatePredicate.Builder.create().exactMatch(TallPlantBlock.HALF, DoubleBlockHalf.LOWER).build())
                                                                        .build()
                                                        ),
                                                new BlockPos(0, -1, 0)
                                        )
                                )
                );
    }

    public LootTable.Builder eldritchCropDrops(Block crop, Item product, Item seeds, LootCondition.Builder condition) {
        return this.applyExplosionDecay(
                crop,
                LootTable.builder()
                        .pool(LootPool.builder().with(ItemEntry.builder(product).conditionally(condition).alternatively(ItemEntry.builder(seeds))))
                        .pool(
                                LootPool.builder()
                                        .conditionally(condition)
                                        .with(ItemEntry.builder(seeds).apply(ApplyBonusLootFunction.binomialWithBonusCount(Enchantments.FORTUNE, 0.5714286F, 3)))
                        )
        );
    }


}
