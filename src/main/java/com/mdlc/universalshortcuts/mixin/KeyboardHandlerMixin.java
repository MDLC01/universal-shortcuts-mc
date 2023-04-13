package com.mdlc.universalshortcuts.mixin;

import com.mdlc.universalshortcuts.Utils;
import net.minecraft.client.KeyboardHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;


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
}
