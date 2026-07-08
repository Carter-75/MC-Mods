/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.sugar.Local
 *  com.simibubi.create.content.equipment.symmetryWand.mirror.SymmetryMirror
 *  net.minecraft.class_243
 *  net.minecraft.class_2487
 *  net.minecraft.class_2489
 *  net.minecraft.class_2499
 *  net.minecraft.class_2520
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.equipment.symmetryWand.mirror.SymmetryMirror;
import net.minecraft.class_243;
import net.minecraft.class_2487;
import net.minecraft.class_2489;
import net.minecraft.class_2499;
import net.minecraft.class_2520;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={SymmetryMirror.class})
public class MixinSymmetryMirror {
    @Shadow
    protected class_243 position;

    @Inject(method={"writeToNbt"}, at={@At(value="RETURN")})
    private void writeWithDouble(CallbackInfoReturnable<class_2487> cir) {
        class_2499 doubleList = new class_2499();
        doubleList.add((Object)class_2489.method_23241((double)this.position.field_1352));
        doubleList.add((Object)class_2489.method_23241((double)this.position.field_1351));
        doubleList.add((Object)class_2489.method_23241((double)this.position.field_1350));
        ((class_2487)cir.getReturnValue()).method_10566("vsDoublePos", (class_2520)doubleList);
    }

    @ModifyVariable(method={"fromNBT"}, at=@At(value="STORE"), name={"pos"})
    private static class_243 readWithDouble(class_243 instance, @Local(argsOnly=true) class_2487 tag) {
        class_2499 doubleList = tag.method_10554("vsDoublePos", 6);
        return new class_243(doubleList.method_10611(0), doubleList.method_10611(1), doubleList.method_10611(2));
    }
}

