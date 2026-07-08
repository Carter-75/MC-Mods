/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_742
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 *  org.spongepowered.asm.mixin.injection.callback.LocalCapture
 */
package backported_updates.mixin.foundation.client;

import backported.updates.foundation.client.event.FovRendering;
import com.mojang.authlib.GameProfile;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_742;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(value={class_742.class})
public abstract class AbstractClientPlayerMixin
extends class_1657 {
    public AbstractClientPlayerMixin(class_1937 level, class_2338 pos, float yRot, GameProfile gameProfile) {
        super(level, pos, yRot, gameProfile);
    }

    @Inject(method={"getFieldOfViewModifier"}, at={@At(value="RETURN", ordinal=1)}, cancellable=true, locals=LocalCapture.CAPTURE_FAILHARD)
    public void updateFov(CallbackInfoReturnable<Float> cir, float currentFov) {
        float fov = FovRendering.EVENT.invoker().setFov(this, currentFov);
        if (fov != currentFov) {
            cir.setReturnValue((Object)Float.valueOf(fov));
        }
    }
}

