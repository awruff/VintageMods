package com.github.awruff.vintage.alwayssprint.mixins;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {
    @Shadow
    public GameSettings gameSettings;

    @Inject(
            method = "runTick",
            at = @At("HEAD")
    )
    private void tickSprint(CallbackInfo ci) {
        KeyBinding.setKeyBindState(gameSettings.keyBindSprint.getKeyCode(), true);
    }
}
