package com.mdlc.universalshortcuts.mixin;

import net.minecraft.client.gui.components.events.AbstractContainerEventHandler;
import net.minecraft.client.gui.screens.Screen;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(Screen.class)
public abstract class ScreenMixin extends AbstractContainerEventHandler {
    private static boolean isKey(int keyCode, String keyName) {
        if (keyCode == GLFW.GLFW_KEY_UNKNOWN) return false;
        return keyName.equalsIgnoreCase(GLFW.glfwGetKeyName(keyCode, 0));
    }

    @Inject(method = "isSelectAll", at = @At("HEAD"), cancellable = true)
    private static void onIsSelectAll(int keyCode, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(
                isKey(keyCode, "A")
                        && Screen.hasControlDown()
                        && !Screen.hasShiftDown()
                        && !Screen.hasAltDown()
        );
    }

    @Inject(method = "isCopy", at = @At("HEAD"), cancellable = true)
    private static void onIsCopy(int keyCode, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(
                isKey(keyCode, "C")
                        && Screen.hasControlDown()
                        && !Screen.hasShiftDown()
                        && !Screen.hasAltDown()
        );
    }

    @Inject(method = "isPaste", at = @At("HEAD"), cancellable = true)
    private static void onIsPaste(int keyCode, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(
                isKey(keyCode, "V")
                        && Screen.hasControlDown()
                        && !Screen.hasShiftDown()
                        && !Screen.hasAltDown()
        );
    }

    @Inject(method = "isCut", at = @At("HEAD"), cancellable = true)
    private static void onIsCut(int keyCode, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(
                isKey(keyCode, "X")
                        && Screen.hasControlDown()
                        && !Screen.hasShiftDown()
                        && !Screen.hasAltDown()
        );
    }
}
