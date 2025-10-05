package com.mdlc.universalshortcuts.mixin;

import com.mdlc.universalshortcuts.Utils;
import net.minecraft.client.input.InputWithModifiers;
import net.minecraft.client.input.KeyEvent;
import org.spongepowered.asm.mixin.Mixin;


@Mixin(KeyEvent.class)
public abstract class KeyEventMixin implements InputWithModifiers {
    /**
     * Remaps the key that is used by the Select All shortcut to be <kbd>A</kbd> on all keyboards.
     */
    public boolean isSelectAll() {
        return Utils.isKey(this.input(), "A")
                && this.hasControlDown()
                && !this.hasShiftDown()
                && !this.hasAltDown();
    }

    /**
     * Remaps the key that is used by the Copy shortcut to be <kbd>C</kbd> on all keyboards.
     */
    public boolean isCopy() {
        return Utils.isKey(this.input(), "C")
                && this.hasControlDown()
                && !this.hasShiftDown()
                && !this.hasAltDown();
    }

    /**
     * Remaps the key that is used by the Paste shortcut to be <kbd>V</kbd> on all keyboards.
     */
    public boolean isPaste() {
        return Utils.isKey(this.input(), "V")
                && this.hasControlDown()
                && !this.hasShiftDown()
                && !this.hasAltDown();
    }

    /**
     * Remaps the key that is used by the Cut shortcut to be <kbd>X</kbd> on all keyboards.
     */
    public boolean isCut() {
        return Utils.isKey(this.input(), "X")
                && this.hasControlDown()
                && !this.hasShiftDown()
                && !this.hasAltDown();
    }
}
