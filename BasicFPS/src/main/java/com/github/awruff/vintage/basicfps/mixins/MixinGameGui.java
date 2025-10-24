package com.github.awruff.vintage.basicfps.mixins;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GameGui;
import net.minecraft.client.gui.GuiElement;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameGui.class)
public class MixinGameGui extends GuiElement {
    @Shadow @Final private Minecraft minecraft;

    @Inject(
            method = "render",
            at = @At(value = "FIELD", target = "Lnet/minecraft/client/options/GameOptions;debugEnabled:Z")
    )
    private void drawFps(CallbackInfo ci) {
        if (!minecraft.options.debugEnabled && !minecraft.options.hideGui) {
            minecraft.textRenderer.drawWithShadow(minecraft.fpsDebugString.split(",")[0], 3, 3, -1);
        }
    }
}
