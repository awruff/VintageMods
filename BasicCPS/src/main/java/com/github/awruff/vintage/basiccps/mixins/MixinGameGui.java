package com.github.awruff.vintage.basiccps.mixins;

import com.github.awruff.vintage.basiccps.utils.CPSCounter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GameGui;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameGui.class)
public class MixinGameGui {
    @Shadow @Final private Minecraft minecraft;

    @Inject(
            method = "render",
            at = @At(value = "FIELD", target = "Lnet/minecraft/client/options/GameOptions;debugEnabled:Z")
    )
    private void drawCps(CallbackInfo ci) {
        if (!minecraft.options.debugEnabled && !minecraft.options.hideGui) {
            minecraft.textRenderer.drawWithShadow(CPSCounter.getText(), 3, CPSCounter.getOffset(), -1);
        }
    }
}
