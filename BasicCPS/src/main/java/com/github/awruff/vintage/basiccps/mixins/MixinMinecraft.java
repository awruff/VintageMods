package com.github.awruff.vintage.basiccps.mixins;

import com.github.awruff.vintage.basiccps.utils.CPSCounter;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {
    @Inject(
            method = "tick", at = @At("HEAD")
    )
    private void tick(CallbackInfo ci) {
        CPSCounter.tick();
    }

    @Inject(
            method = "doAttack", at = @At("HEAD")
    )
    private void leftClick(CallbackInfo ci) {
        CPSCounter.leftClick();
    }

    @Inject(
            method = "doUse", at = @At("HEAD")
    )
    private void rightClick(CallbackInfo ci) {
        CPSCounter.rightClick();
    }
}
