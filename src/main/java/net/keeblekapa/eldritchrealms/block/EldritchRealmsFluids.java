package net.keeblekapa.eldritchrealms.block;

import net.keeblekapa.eldritchrealms.EldritchRealms;
import net.keeblekapa.eldritchrealms.block.custom.EerieWaterFluid;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EldritchRealmsFluids {

    public static final FlowableFluid STILL_EERIE_WATER = Registry.register(
            Registries.FLUID,
            new Identifier(EldritchRealms.MOD_ID, "eerie_water"),
            new EerieWaterFluid.Still()
    );

    public static final FlowableFluid FLOWING_EERIE_WATER = Registry.register(
            Registries.FLUID,
            new Identifier(EldritchRealms.MOD_ID, "flowing_eerie_water"),
            new EerieWaterFluid.Flowing()
    );

    public static void registerFluids() {
        EldritchRealms.LOGGER.info(
                "Registering fluids for " + EldritchRealms.MOD_ID
        );
    }
}