/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1309
 *  net.minecraft.class_1451
 *  net.minecraft.class_2960
 *  net.minecraft.class_3680
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_929
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.client.entities.renderer;

import backported.updates.content.common.api.variant.VariantDataHolder;
import backported_updates.mixin.client.entities.renderer.MobRendererMixin;
import net.minecraft.class_1309;
import net.minecraft.class_1451;
import net.minecraft.class_2960;
import net.minecraft.class_3680;
import net.minecraft.class_5617;
import net.minecraft.class_929;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_929.class})
public abstract class CatRendererMixin
extends MobRendererMixin<class_1451, class_3680<class_1451>> {
    public CatRendererMixin(class_5617.class_5618 context, class_3680<class_1451> model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    @Inject(method={"getTextureLocation(Lnet/minecraft/world/entity/animal/Cat;)Lnet/minecraft/resources/ResourceLocation;"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$getTextureLocation(class_1451 entity, CallbackInfoReturnable<class_2960> cir) {
        VariantDataHolder.getHolder((class_1309)entity).getVariantData().ifPresent(variant -> cir.setReturnValue((Object)variant.assetInfo().path()));
    }
}

