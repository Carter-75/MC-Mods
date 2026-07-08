/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.render.VertexConsumerProvider
 *  net.minecraft.client.render.Frustum
 *  net.minecraft.client.render.entity.EntityRendererFactory$Context
 *  net.minecraft.client.render.entity.EntityRenderer
 *  net.minecraft.client.render.entity.EntityRenderDispatcher
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
import net.minecraft.entity.Entity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={EntityRenderer.class})
public class EntityRendererMixin<T extends Entity> {
    @Unique
    private LeashFeatureRenderer<T> leashRenderer;
    @Shadow
    @Final
    protected EntityRenderDispatcher dispatcher;

    @Inject(method={"<init>"}, at={@At(value="TAIL")})
    private void vb$init(EntityRendererFactory.Context context, CallbackInfo ci) {
        this.leashRenderer = new LeashFeatureRenderer(this.dispatcher);
    }

    @Inject(method={"render"}, at={@At(value="HEAD")})
    private void renderAdditional(T entity, float entityYaw, float partialTick, MatrixStack poseStack, VertexConsumerProvider buffer, int packedLight, CallbackInfo ci) {
        this.leashRenderer.render(entity, partialTick, poseStack, buffer);
    }

    @Inject(method={"shouldRender"}, at={@At(value="TAIL")}, cancellable=true)
    private void vb$shouldRender(T entity, Frustum camera, double camX, double camY, double camZ, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(this.leashRenderer.shouldRender(entity, camera, (Boolean)cir.getReturnValue()));
    }
}

