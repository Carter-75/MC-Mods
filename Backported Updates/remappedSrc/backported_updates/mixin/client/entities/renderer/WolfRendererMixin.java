/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1309
 *  net.minecraft.class_1493
 *  net.minecraft.class_2960
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_624
 *  net.minecraft.class_969
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.client.entities.renderer;

import backported.updates.content.common.api.variant.VariantDataHolder;
import backported_updates.mixin.client.entities.renderer.MobRendererMixin;
import net.minecraft.class_1309;
import net.minecraft.class_1493;
import net.minecraft.class_2960;
import net.minecraft.class_5617;
import net.minecraft.class_624;
import net.minecraft.class_969;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_969.class})
public abstract class WolfRendererMixin
extends MobRendererMixin<class_1493, class_624<class_1493>> {
    public WolfRendererMixin(class_5617.class_5618 context, class_624<class_1493> model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    @Inject(method={"getTextureLocation(Lnet/minecraft/world/entity/animal/Wolf;)Lnet/minecraft/resources/ResourceLocation;"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$getTextureLocation(class_1493 entity, CallbackInfoReturnable<class_2960> cir) {
        VariantDataHolder.getHolder((class_1309)entity).getVariantData().ifPresent(variant -> {
            if (entity.method_6181()) {
                cir.setReturnValue((Object)variant.assetInfo().tame().path());
            } else {
                cir.setReturnValue((Object)(entity.method_29511() ? variant.assetInfo().angry().path() : variant.assetInfo().wild().path()));
            }
        });
    }
}

