/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.render.model.BakedModel
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.client.color.item.ItemColors
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.render.VertexConsumerProvider
 *  net.minecraft.client.render.item.ItemModels
 *  net.minecraft.client.render.model.json.ModelTransformationMode
 *  net.minecraft.client.render.item.ItemRenderer
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.foundation.client;

import backported.updates.foundation.client.v2.render.DynamicItemRenderer;
import backported.updates.foundation.client.v2.render.ItemRendererRegistry;
import backported.updates.foundation.core.util.event.ResultHolder;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemConvertible;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemModels;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.render.item.ItemRenderer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={ItemRenderer.class})
public abstract class ItemRendererMixin {
    @Shadow
    @Final
    private ItemModels models;
    @Shadow
    @Final
    private ItemColors colors;

    @Inject(method={"renderItem"}, at={@At(value="HEAD")}, cancellable=true)
    private void render(ItemStack stack, ModelTransformationMode context, boolean leftHand, MatrixStack pose, VertexConsumerProvider buffer, int light, int overlay, BakedModel model, CallbackInfo ci) {
        DynamicItemRenderer.Renderer renderer = ((DynamicItemRenderer)DynamicItemRenderer.INSTANCE.get()).get((ItemConvertible)stack.getItem());
        if (renderer != null && renderer.shouldUse()) {
            pose.push();
            renderer.renderFirstPerson(stack, context, leftHand, pose, buffer, light, overlay, model, this.models, this.colors);
            pose.pop();
            ci.cancel();
        }
    }

    @ModifyVariable(method={"renderItem"}, at=@At(value="HEAD"), argsOnly=true)
    private BakedModel render(BakedModel original, ItemStack stack, ModelTransformationMode context) {
        ResultHolder<BakedModel> result;
        ItemRendererRegistry.Renderer renderer = ((ItemRendererRegistry)ItemRendererRegistry.INSTANCE.get()).get((ItemConvertible)stack.getItem());
        if (renderer != null && renderer.shouldUse() && (result = renderer.renderFirstPerson(stack, context, this.models)).isCancelled()) {
            return result.getValue();
        }
        return original;
    }

    @ModifyVariable(method={"getModel"}, at=@At(value="STORE"))
    private BakedModel getModel(BakedModel original, ItemStack stack) {
        ResultHolder<BakedModel> result;
        ResultHolder<BakedModel> result2;
        ItemRendererRegistry.Renderer renderer = ((ItemRendererRegistry)ItemRendererRegistry.INSTANCE.get()).get((ItemConvertible)stack.getItem());
        if (renderer != null && renderer.shouldUse() && (result2 = renderer.renderThirdPerson(stack, this.models)).isCancelled()) {
            return result2.getValue();
        }
        DynamicItemRenderer.Renderer dynamic = ((DynamicItemRenderer)DynamicItemRenderer.INSTANCE.get()).get((ItemConvertible)stack.getItem());
        if (dynamic != null && dynamic.shouldUse() && (result = dynamic.renderThirdPerson(stack, this.models)).isCancelled()) {
            return result.getValue();
        }
        return original;
    }
}

