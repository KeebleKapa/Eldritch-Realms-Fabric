package net.keeblekapa.eldritchrealms.world.tree;

import net.keeblekapa.eldritchrealms.EldritchRealms;
import net.keeblekapa.eldritchrealms.mixin.TrunkPlacerTypeInvoker;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class EldritchRealmsTrunkPlacerTypes {

    public static final TrunkPlacerType<UmbramOakTrunkPlacer> UMBRAM_OAK_TRUNK_PLACER =
            TrunkPlacerTypeInvoker.callRegister(
                    EldritchRealms.MOD_ID + ":umbram_oak_trunk_placer",
                    UmbramOakTrunkPlacer.CODEC);

    public static void register() {
        EldritchRealms.LOGGER.info("Registering Trunk Placer Types for " + EldritchRealms.MOD_ID);
    }

}
