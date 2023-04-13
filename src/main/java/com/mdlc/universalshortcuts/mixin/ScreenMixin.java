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
    @Inject(method = "isSelectAll", at = @At("HEAD"), cancellable = true)
    private static void onIsSelectAll(int keyCode, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(
                Utils.isKey(keyCode, "A")
                        && Screen.hasControlDown()
                        && !Screen.hasShiftDown()
                        && !Screen.hasAltDown()
        );
    }

    @Inject(method = "isCopy", at = @At("HEAD"), cancellable = true)
    private static void onIsCopy(int keyCode, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(
                Utils.isKey(keyCode, "C")
                        && Screen.hasControlDown()
                        && !Screen.hasShiftDown()
                        && !Screen.hasAltDown()
        );
    }

    @Inject(method = "isPaste", at = @At("HEAD"), cancellable = true)
    private static void onIsPaste(int keyCode, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(
                Utils.isKey(keyCode, "V")
                        && Screen.hasControlDown()
                        && !Screen.hasShiftDown()
                        && !Screen.hasAltDown()
        );
    }

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
