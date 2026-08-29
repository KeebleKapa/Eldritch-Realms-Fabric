package net.keeblekapa.eldritchrealms.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.keeblekapa.eldritchrealms.block.EldritchRealmsBlocks;
import net.keeblekapa.eldritchrealms.item.EldritchRealmsItems;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class EldritchRealmsItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public EldritchRealmsItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(EldritchRealmsBlocks.UMBRAM_OAK_LOG.asItem())
                .add(EldritchRealmsBlocks.UMBRAM_OAK_WOOD.asItem())
                .add(EldritchRealmsBlocks.STRIPPED_UMBRAM_OAK_LOG.asItem())
                .add(EldritchRealmsBlocks.STRIPPED_UMBRAM_OAK_WOOD.asItem())
                .add(EldritchRealmsBlocks.PHONTUM_LOG.asItem())
                .add(EldritchRealmsBlocks.PHONTUM_WOOD.asItem())
                .add(EldritchRealmsBlocks.STRIPPED_PHONTUM_LOG.asItem())
                .add(EldritchRealmsBlocks.STRIPPED_PHONTUM_WOOD.asItem())
                .add(EldritchRealmsBlocks.ELDEM_LOG.asItem())
                .add(EldritchRealmsBlocks.ELDEM_WOOD.asItem())
                .add(EldritchRealmsBlocks.STRIPPED_ELDEM_LOG.asItem())
                .add(EldritchRealmsBlocks.STRIPPED_ELDEM_WOOD.asItem())

        ;


        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(EldritchRealmsBlocks.UMBRAM_OAK_PLANKS.asItem())
                .add(EldritchRealmsBlocks.PHONTUM_PLANKS.asItem())
                .add(EldritchRealmsBlocks.ELDEM_PLANKS.asItem())

        ;

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(EldritchRealmsItems.SHADOWSTEEL_SWORD)
                .add(EldritchRealmsItems.ENIGMATIC_IRON_SWORD)
                .add(EldritchRealmsItems.HALLOW_GOLD_SWORD)
        ;
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(EldritchRealmsItems.SHADOWSTEEL_SHOVEL)
                .add(EldritchRealmsItems.ENIGMATIC_IRON_SHOVEL)
                .add(EldritchRealmsItems.HALLOW_GOLD_SHOVEL)

        ;
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(EldritchRealmsItems.SHADOWSTEEL_PICKAXE)
                .add(EldritchRealmsItems.ENIGMATIC_IRON_PICKAXE)
                .add(EldritchRealmsItems.HALLOW_GOLD_PICKAXE)

        ;
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(EldritchRealmsItems.SHADOWSTEEL_AXE)
                .add(EldritchRealmsItems.ENIGMATIC_IRON_AXE)
                .add(EldritchRealmsItems.HALLOW_GOLD_AXE)

        ;
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(EldritchRealmsItems.SHADOWSTEEL_HOE)
                .add(EldritchRealmsItems.ENIGMATIC_IRON_HOE)
                .add(EldritchRealmsItems.HALLOW_GOLD_HOE)

        ;
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(EldritchRealmsItems.SHADOWSTEEL_HELMET, EldritchRealmsItems.SHADOWSTEEL_CHESTPLATE, EldritchRealmsItems.SHADOWSTEEL_LEGGINGS, EldritchRealmsItems.SHADOWSTEEL_BOOTS)
                .add(EldritchRealmsItems.ENIGMATIC_IRON_HELMET, EldritchRealmsItems.ENIGMATIC_IRON_CHESTPLATE, EldritchRealmsItems.ENIGMATIC_IRON_LEGGINGS, EldritchRealmsItems.ENIGMATIC_IRON_BOOTS)
                .add(EldritchRealmsItems.HALLOW_GOLD_HELMET, EldritchRealmsItems.HALLOW_GOLD_CHESTPLATE, EldritchRealmsItems.HALLOW_GOLD_LEGGINGS, EldritchRealmsItems.HALLOW_GOLD_BOOTS)


        ;

    }
}
