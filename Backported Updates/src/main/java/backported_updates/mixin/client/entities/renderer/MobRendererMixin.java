/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.mob.MobEntity
 *  net.minecraft.client.render.entity.EntityRendererFactory$Context
 *  net.minecraft.client.render.entity.model.EntityModel
 *  net.minecraft.client.render.entity.LivingEntityRenderer
 *  net.minecraft.client.render.entity.MobEntityRenderer
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.client.entities.renderer;

import net.minecraft.entity.mob.MobEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.MobEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={MobEntityRenderer.class})
public abstract class MobRendererMixin<T extends MobEntity, M extends EntityModel<T>>
extends LivingEntityRenderer<T, M> {
    @Unique
    protected M defaultModel;
    @Unique
    protected EntityRendererFactory.Context context;

    public MobRendererMixin(EntityRendererFactory.Context context, M model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    @Inject(method={"<init>"}, at={@At(value="TAIL")})
    private void vb$init(EntityRendererFactory.Context context, M model, float shadowRadius, CallbackInfo ci) {
        this.context = context;
        this.defaultModel = model;
    }
}

