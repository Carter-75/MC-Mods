/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_4604
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_897
 *  net.minecraft.class_898
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.leash;

import backported.updates.content.common.api.leash.LeashFeatureRenderer;
import net.minecraft.class_1297;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_4604;
import net.minecraft.class_5617;
import net.minecraft.class_897;
import net.minecraft.class_898;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_897.class})
public class EntityRendererMixin<T extends class_1297> {
    @Unique
    private LeashFeatureRenderer<T> leashRenderer;
    @Shadow
    @Final
    protected class_898 field_4676;

    @Inject(method={"<init>"}, at={@At(value="TAIL")})
    private void vb$init(class_5617.class_5618 context, CallbackInfo ci) {
        this.leashRenderer = new LeashFeatureRenderer(this.field_4676);
    }

    @Inject(method={"render"}, at={@At(value="HEAD")})
    private void renderAdditional(T entity, float entityYaw, float partialTick, class_4587 poseStack, class_4597 buffer, int packedLight, CallbackInfo ci) {
        this.leashRenderer.render(entity, partialTick, poseStack, buffer);
    }

    @Inject(method={"shouldRender"}, at={@At(value="TAIL")}, cancellable=true)
    private void vb$shouldRender(T entity, class_4604 camera, double camX, double camY, double camZ, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue((Object)this.leashRenderer.shouldRender(entity, camera, (Boolean)cir.getReturnValue()));
    }
}

