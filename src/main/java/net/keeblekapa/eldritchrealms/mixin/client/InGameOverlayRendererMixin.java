package net.keeblekapa.eldritchrealms.mixin.client;


import net.keeblekapa.eldritchrealms.util.EldritchRealmsTags;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameOverlayRenderer;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(InGameOverlayRenderer.class)
public class InGameOverlayRendererMixin {

    private static final Identifier EERIE_WATER_OVERLAY = new Identifier("eldritchrealms", "textures/misc/undereeriewater.png");

    @ModifyArg(
            method = "renderUnderwaterOverlay",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/mojang/blaze3d/systems/RenderSystem;setShaderTexture(ILnet/minecraft/util/Identifier;)V"
            ),
            index = 1
    )
    private static Identifier eldritchrealms$useEerieWaterOverlay(
            Identifier original
    ) {
        MinecraftClient client = MinecraftClient.getInstance();

        if (client.world == null) {
            return original;
        }

        Vec3d cameraPos =
                client.gameRenderer.getCamera().getPos();

        BlockPos blockPos =
                BlockPos.ofFloored(cameraPos);

        FluidState fluidState =
                client.world.getFluidState(blockPos);

        if (fluidState.isIn(EldritchRealmsTags.Fluids.EERIE_WATER)) {
            return EERIE_WATER_OVERLAY;
        }

        return original;
    }
}
