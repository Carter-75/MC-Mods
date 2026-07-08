/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1922
 *  net.minecraft.class_4184
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.client;

import backported.updates.content.common.level.entities.happyghast.HappyGhast;
import net.minecraft.class_1297;
import net.minecraft.class_1922;
import net.minecraft.class_4184;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_4184.class})
public abstract class CameraMixin {
    @Shadow
    protected abstract void method_19324(float var1, float var2, float var3);

    @Shadow
    protected abstract float method_19318(float var1);

    @Inject(method={"setup"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/Camera;getMaxZoom(F)F")}, cancellable=true)
    private void onCameraSetup(class_1922 level, class_1297 entity, boolean detached, boolean thirdPersonReverse, float partialTick, CallbackInfo ci) {
        if (entity.method_5765() && entity.method_5854() instanceof HappyGhast) {
            this.method_19324(-this.method_19318(8.0f), 0.0f, 0.0f);
            ci.cancel();
        }
    }
}

