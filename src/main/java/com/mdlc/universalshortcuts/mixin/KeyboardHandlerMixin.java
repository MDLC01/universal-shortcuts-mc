package com.mdlc.universalshortcuts.mixin;

import com.mdlc.universalshortcuts.Utils;
import net.minecraft.client.KeyboardHandler;
import net.minecraft.client.input.KeyEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Slice;


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

    /**
     * Remaps a debug key.
     * <p>
     * The Toggle Narrator key is not remapped; see <a
     * href="https://github.com/MDLC01/universal-shortcuts-mc/issues/3">issue #3</a>.
     */
    @ModifyVariable(method = "handleDebugKeys", at = @At("HEAD"), argsOnly = true)
    private KeyEvent remapDebugKey(KeyEvent keyEvent) {
        return Utils.remapKeyEventToQWERTY(keyEvent);
    }

    /**
     * Remaps the debug key that crashes the game when held for 10 seconds.
     */
    // We do not inject in InputConstants#isKeyDown because other mods might use it with an already remapped key code.
    // This is also why this injector is so complicated. The @Slice is there to ensure we only match the right calls.
    @ModifyArg(
            method = "keyPress",
            at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/platform/InputConstants;isKeyDown(Lcom/mojang/blaze3d/platform/Window;I)Z"),
            slice = @Slice(
                    from = @At(value = "FIELD", target = "Lnet/minecraft/client/KeyboardHandler;debugCrashKeyTime:J", ordinal = 0),
                    to = @At(value = "FIELD", target = "Lnet/minecraft/client/KeyboardHandler;debugCrashKeyReportedCount:J", ordinal = 0)
            ),
            index = 1
    )
    private int remapDebugCrashKey(int keyCode) {
        return Utils.remapKeyCodeToQWERTY(keyCode);
    }
}
