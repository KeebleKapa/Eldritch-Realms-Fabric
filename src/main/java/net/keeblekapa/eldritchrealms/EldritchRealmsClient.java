package net.keeblekapa.eldritchrealms;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.keeblekapa.eldritchrealms.block.EldritchRealmsBlocks;
import net.keeblekapa.eldritchrealms.block.EldritchRealmsFluids;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class EldritchRealmsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(EldritchRealmsBlocks.UMBRAM_OAK_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EldritchRealmsBlocks.UMBRAM_OAK_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EldritchRealmsBlocks.UMBRAM_OAK_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EldritchRealmsBlocks.UMBRAM_OAK_DOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(EldritchRealmsBlocks.PHONTUM_PETALS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EldritchRealmsBlocks.PHONTUM_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EldritchRealmsBlocks.FLOWERING_PHONTUM_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EldritchRealmsBlocks.PHONTUM_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EldritchRealmsBlocks.PHONTUM_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EldritchRealmsBlocks.PHONTUM_DOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(EldritchRealmsBlocks.ELDEM_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EldritchRealmsBlocks.ELDEM_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EldritchRealmsBlocks.ELDEM_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EldritchRealmsBlocks.ELDEM_DOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(EldritchRealmsBlocks.TILLED_MARRED_SOIL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EldritchRealmsBlocks.MYTHRAL_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EldritchRealmsBlocks.TALL_MYTHRAL_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EldritchRealmsBlocks.VIRELUME_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EldritchRealmsBlocks.TALL_VIRELUME_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EldritchRealmsBlocks.NOCTURB_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EldritchRealmsBlocks.TALL_NOCTURB_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EldritchRealmsBlocks.SABLEBELL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EldritchRealmsBlocks.ALK_WHEAT, RenderLayer.getCutout());

        FluidRenderHandlerRegistry.INSTANCE.register(
                EldritchRealmsFluids.STILL_EERIE_WATER,
                EldritchRealmsFluids.FLOWING_EERIE_WATER,

                new SimpleFluidRenderHandler(
                        new Identifier(EldritchRealms.MOD_ID, "block/eerie_water_still"),
                        new Identifier(EldritchRealms.MOD_ID, "block/eerie_water_flow"),
                        new Identifier(EldritchRealms.MOD_ID, "block/eerie_water_overlay")
                )
        );

        BlockRenderLayerMap.INSTANCE.putFluids(
                RenderLayer.getTranslucent(),
                EldritchRealmsFluids.STILL_EERIE_WATER,
                EldritchRealmsFluids.FLOWING_EERIE_WATER
        );

    }
}
