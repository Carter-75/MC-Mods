/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1309
 *  net.minecraft.class_2960
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_7102
 *  net.minecraft.class_7198
 *  net.minecraft.class_7213
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.client.entities.renderer;

import backported.updates.content.common.api.variant.VariantDataHolder;
import backported_updates.mixin.client.entities.renderer.MobRendererMixin;
import net.minecraft.class_1309;
import net.minecraft.class_2960;
import net.minecraft.class_5617;
import net.minecraft.class_7102;
import net.minecraft.class_7198;
import net.minecraft.class_7213;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_7213.class})
public abstract class FrogRendererMixin
extends MobRendererMixin<class_7102, class_7198<class_7102>> {
    public FrogRendererMixin(class_5617.class_5618 context, class_7198<class_7102> model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    @Inject(method={"getTextureLocation(Lnet/minecraft/world/entity/animal/frog/Frog;)Lnet/minecraft/resources/ResourceLocation;"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$getTextureLocation(class_7102 entity, CallbackInfoReturnable<class_2960> cir) {
        VariantDataHolder.getHolder((class_1309)entity).getVariantData().ifPresent(variant -> cir.setReturnValue((Object)variant.assetInfo().path()));
    }
}

