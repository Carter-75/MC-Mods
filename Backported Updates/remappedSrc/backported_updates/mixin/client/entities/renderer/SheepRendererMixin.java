/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1472
 *  net.minecraft.class_3883
 *  net.minecraft.class_3887
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_601
 *  net.minecraft.class_941
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.client.entities.renderer;

import backported.updates.content.client.api.renderer.RenderConditions;
import backported.updates.content.client.api.renderer.SpecialMobRenderer;
import backported.updates.content.client.level.entities.layer.SheepWoolUndercoatLayer;
import backported_updates.mixin.client.entities.renderer.MobRendererMixin;
import net.minecraft.class_1472;
import net.minecraft.class_3883;
import net.minecraft.class_3887;
import net.minecraft.class_5617;
import net.minecraft.class_601;
import net.minecraft.class_941;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_941.class})
public abstract class SheepRendererMixin
extends MobRendererMixin<class_1472, class_601<class_1472>> {
    public SheepRendererMixin(class_5617.class_5618 context, class_601<class_1472> model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    @Inject(method={"<init>"}, at={@At(value="TAIL")})
    private void onInit(class_5617.class_5618 context, CallbackInfo ci) {
        SpecialMobRenderer.create(context, ctx -> new SheepWoolUndercoatLayer((class_3883<class_1472, class_601<class_1472>>)this, ctx.method_32170()), RenderConditions.SHEEP_UNDERCOAT).ifPresent(layer -> this.method_4046((class_3887)layer.get()));
    }
}

