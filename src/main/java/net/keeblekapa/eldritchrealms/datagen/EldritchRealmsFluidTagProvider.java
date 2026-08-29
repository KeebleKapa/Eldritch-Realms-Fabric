package net.keeblekapa.eldritchrealms.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.keeblekapa.eldritchrealms.block.EldritchRealmsFluids;
import net.keeblekapa.eldritchrealms.util.EldritchRealmsTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.FluidTags;

import java.util.concurrent.CompletableFuture;

public class EldritchRealmsFluidTagProvider extends FabricTagProvider.FluidTagProvider {
    public EldritchRealmsFluidTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(EldritchRealmsTags.Fluids.EERIE_WATER)
                .add(EldritchRealmsFluids.STILL_EERIE_WATER)
                .add(EldritchRealmsFluids.FLOWING_EERIE_WATER);

        getOrCreateTagBuilder(FluidTags.WATER)
                .addTag(EldritchRealmsTags.Fluids.EERIE_WATER);
    }
}
