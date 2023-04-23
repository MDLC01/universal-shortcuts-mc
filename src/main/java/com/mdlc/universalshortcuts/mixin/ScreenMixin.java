package com.mdlc.universalshortcuts.mixin;

import com.mdlc.universalshortcuts.Utils;
import net.minecraft.client.gui.components.events.AbstractContainerEventHandler;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(Screen.class)
public abstract class ScreenMixin extends AbstractContainerEventHandler {
    /**
     * Remaps the key that is used by the Select All shortcut to be <kbd>A</kbd> on all keyboards.
     */
    @Inject(method = "isSelectAll", at = @At("HEAD"), cancellable = true)
    private static void onIsSelectAll(int keyCode, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(
                Utils.isKey(keyCode, "A")
                        && Screen.hasControlDown()
                        && !Screen.hasShiftDown()
                        && !Screen.hasAltDown()
        );
    }

    /**
     * Remaps the key that is used by the Copy shortcut to be <kbd>C</kbd> on all keyboards.
     */
    @Inject(method = "isCopy", at = @At("HEAD"), cancellable = true)
    private static void onIsCopy(int keyCode, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(
                Utils.isKey(keyCode, "C")
                        && Screen.hasControlDown()
                        && !Screen.hasShiftDown()
                        && !Screen.hasAltDown()
        );
    }

    /**
     * Remaps the key that is used by the Paste shortcut to be <kbd>V</kbd> on all keyboards.
     */
    @Inject(method = "isPaste", at = @At("HEAD"), cancellable = true)
    private static void onIsPaste(int keyCode, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(
                Utils.isKey(keyCode, "V")
                        && Screen.hasControlDown()
                        && !Screen.hasShiftDown()
                        && !Screen.hasAltDown()
        );
    }

    /**
     * Remaps the key that is used by the Cut shortcut to be <kbd>X</kbd> on all keyboards.
     */
    @Inject(method = "isCut", at = @At("HEAD"), cancellable = true)
    private static void onIsCut(int keyCode, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(
                Utils.isKey(keyCode, "X")
                        && Screen.hasControlDown()
                        && !Screen.hasShiftDown()
                        && !Screen.hasAltDown()
        );
    }
}
