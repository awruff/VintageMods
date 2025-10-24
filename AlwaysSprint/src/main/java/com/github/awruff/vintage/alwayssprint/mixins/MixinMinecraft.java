package com.github.awruff.vintage.alwayssprint.mixins;

import net.minecraft.client.Minecraft;
import net.minecraft.client.options.GameOptions;
import net.minecraft.client.options.KeyBinding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {
    @Shadow
    public GameOptions options;

    @Inject(
            method = "tick",
            at = @At("HEAD")
    )
    private void tickSprint(CallbackInfo ci) {
        KeyBinding.set(options.sprintKey.getKeyCode(), true);
    }
}
