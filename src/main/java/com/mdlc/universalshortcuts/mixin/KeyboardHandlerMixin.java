package com.mdlc.universalshortcuts.mixin;

import com.mdlc.universalshortcuts.Utils;
import net.minecraft.client.KeyboardHandler;
import net.minecraft.client.input.KeyEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;


@Mixin(KeyboardHandler.class)
public abstract class KeyboardHandlerMixin {
    /**
     * Remaps a chunk debug key.
     * <p>
     * Chunk debug keys are not accessible in vanilla, but can be activated through modifications.
     */
    @ModifyVariable(method = "handleChunkDebugKeys", at = @At("HEAD"), argsOnly = true)
    private KeyEvent remapChunkDebugKey(KeyEvent keyEvent) {
        return Utils.remapKeyEventToQWERTY(keyEvent);
    }
}
