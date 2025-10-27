package com.github.awruff.vintage.potionstatus.mixins;

import com.github.awruff.vintage.potionstatus.utils.StatusEffectRenderer;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GameGui;
import net.minecraft.client.render.Window;
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
    private void drawFps(CallbackInfo ci, @Local Window window) {
        if (!minecraft.options.debugEnabled && !minecraft.options.hideGui) {
            StatusEffectRenderer.draw(minecraft, window, minecraft.textRenderer);
        }
    }
}
