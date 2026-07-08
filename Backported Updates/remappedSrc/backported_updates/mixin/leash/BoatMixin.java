/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1690
 *  net.minecraft.class_1937
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.leash;

import backported.updates.content.common.api.leash.InterpolationHandler;
import backported.updates.content.common.api.leash.LeashExtension;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1690;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_1690.class})
public abstract class BoatMixin
extends class_1297
implements LeashExtension {
    @Unique
    private final InterpolationHandler interpolation = new InterpolationHandler(this, 3);

    public BoatMixin(class_1299<?> entityType, class_1937 level) {
        super(entityType, level);
    }

    @Inject(method={"lerpTo"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$lerpTo(double x, double y, double z, float yRot, float xRot, int steps, CallbackInfo ci) {
        this.interpolation.interpolateTo(new class_243(x, y, z), yRot, xRot);
        ci.cancel();
    }

    @Inject(method={"tickLerp"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$tickLerp(CallbackInfo ci) {
        if (this.method_5787()) {
            this.interpolation.cancel();
            this.method_43391(this.method_23317(), this.method_23318(), this.method_23321());
        }
        this.interpolation.interpolate();
        ci.cancel();
    }
}

