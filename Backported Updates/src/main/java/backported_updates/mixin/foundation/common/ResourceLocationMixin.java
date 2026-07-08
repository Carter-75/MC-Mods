/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Identifier
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
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Identifier.class})
public class ResourceLocationMixin {
    @Mutable
    @Shadow
    @Final
    private String namespace;
    @Mutable
    @Shadow
    @Final
    private String path;

    @Inject(method={"<init>"}, at={@At(value="TAIL")})
    private void onInit(String namespace, String path, CallbackInfo ci) {
        if (!DataTransformer.shouldCheckNamespace()) {
            return;
        }
        Identifier remapped = DataTransformer.applyTransformsIfPossible(namespace, path);
        if (remapped != null) {
            this.namespace = remapped.getNamespace();
            this.path = remapped.getPath();
        }
    }
}

