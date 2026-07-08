/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2960
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Mutable
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.foundation.common;

import backported.updates.foundation.common.data.DataTransformer;
import net.minecraft.class_2960;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_2960.class})
public class ResourceLocationMixin {
    @Mutable
    @Shadow
    @Final
    private String field_13353;
    @Mutable
    @Shadow
    @Final
    private String field_13355;

    @Inject(method={"<init>"}, at={@At(value="TAIL")})
    private void onInit(String namespace, String path, CallbackInfo ci) {
        if (!DataTransformer.shouldCheckNamespace()) {
            return;
        }
        class_2960 remapped = DataTransformer.applyTransformsIfPossible(namespace, path);
        if (remapped != null) {
            this.field_13353 = remapped.method_12836();
            this.field_13355 = remapped.method_12832();
        }
    }
}

