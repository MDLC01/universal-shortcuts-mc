package com.mdlc.universalshortcuts.mixin;

import com.mdlc.universalshortcuts.Utils;
import net.minecraft.client.KeyboardHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Slice;


@Mixin(KeyboardHandler.class)
public abstract class KeyboardHandlerMixin {
    @ModifyVariable(method = "handleChunkDebugKeys", at = @At("HEAD"), argsOnly = true)
    private int remapChunkDebugKey(int keyCode) {
        return Utils.remapKeyCodeToQWERTY(keyCode);
    }

    @ModifyVariable(method = "handleDebugKeys", at = @At("HEAD"), argsOnly = true)
    private int remapDebugKey(int keyCode) {
        return Utils.remapKeyCodeToQWERTY(keyCode);
    }

    // We do not inject in InputConstants#isKeyDown because other mods might use it with an already remapped key code.
    // This is also why this injector is so complicated. The @Slice is there to ensure we only match the right calls.
    @ModifyArg(
            method = "keyPress",
            at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/platform/InputConstants;isKeyDown(JI)Z"),
            slice = @Slice(
                    from = @At(value = "FIELD", target = "Lnet/minecraft/client/KeyboardHandler;debugCrashKeyTime:J", ordinal = 0),
                    to = @At(value = "FIELD", target = "Lnet/minecraft/client/KeyboardHandler;debugCrashKeyReportedCount:J", ordinal = 0)
            )
    )
    private int remapIsKeyDownArgument(int keyCode) {
        return Utils.remapKeyCodeToQWERTY(keyCode);
    }
}
