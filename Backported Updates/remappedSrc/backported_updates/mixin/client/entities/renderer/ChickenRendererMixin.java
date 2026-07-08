/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1309
 *  net.minecraft.class_1428
 *  net.minecraft.class_2960
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_558
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_583
 *  net.minecraft.class_882
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.client.entities.renderer;

import backported.updates.content.client.api.renderer.ChickenVariantRenderer;
import backported.updates.content.client.api.renderer.RenderConditions;
import backported.updates.content.client.api.renderer.SpecialMobRenderer;
import backported_updates.mixin.client.entities.renderer.MobRendererMixin;
import java.util.Optional;
import java.util.function.Supplier;
import net.minecraft.class_1309;
import net.minecraft.class_1428;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_558;
import net.minecraft.class_5617;
import net.minecraft.class_583;
import net.minecraft.class_882;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_882.class})
public abstract class ChickenRendererMixin
extends MobRendererMixin<class_1428, class_558<class_1428>> {
    @Unique
    private Optional<Supplier<ChickenVariantRenderer>> renderer;

    public ChickenRendererMixin(class_5617.class_5618 context, class_558<class_1428> model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    @Inject(method={"<init>"}, at={@At(value="TAIL")})
    private void onInit(class_5617.class_5618 context, CallbackInfo ci) {
        this.renderer = SpecialMobRenderer.create(context, ChickenVariantRenderer::new, RenderConditions.FARM_ANIMALS);
    }

    @Inject(method={"getTextureLocation(Lnet/minecraft/world/entity/animal/Chicken;)Lnet/minecraft/resources/ResourceLocation;"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$getTextureLocation(class_1428 entity, CallbackInfoReturnable<class_2960> cir) {
        this.renderer.flatMap(renderer -> ((ChickenVariantRenderer)renderer.get()).getTexture(entity)).ifPresent(arg_0 -> cir.setReturnValue(arg_0));
    }

    public void render(class_1428 entity, float entityYaw, float partialTicks, class_4587 poseStack, class_4597 buffer, int packedLight) {
        this.renderer.ifPresent(renderer -> {
            this.field_4737 = (class_583)((ChickenVariantRenderer)renderer.get()).getModel(entity).orElseGet(() -> (class_558)this.defaultModel);
        });
        super.method_4054((class_1309)entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}

