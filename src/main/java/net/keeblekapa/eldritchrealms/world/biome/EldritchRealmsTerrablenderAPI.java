package net.keeblekapa.eldritchrealms.world.biome;
import net.keeblekapa.eldritchrealms.EldritchRealms;
import net.keeblekapa.eldritchrealms.world.biome.surface.EldritchRealmsMaterialRules;
import net.minecraft.util.Identifier;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class EldritchRealmsTerrablenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new EldritchRealmsRegion(new Identifier(EldritchRealms.MOD_ID, "overworld"), 4));


        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, EldritchRealms.MOD_ID, EldritchRealmsMaterialRules.makeRules());
    }
}
