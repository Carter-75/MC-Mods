/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1087
 *  net.minecraft.class_1799
 *  net.minecraft.class_1935
 *  net.minecraft.class_325
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_763
 *  net.minecraft.class_811
 *  net.minecraft.class_918
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
import net.minecraft.class_1087;
import net.minecraft.class_1799;
import net.minecraft.class_1935;
import net.minecraft.class_325;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_763;
import net.minecraft.class_811;
import net.minecraft.class_918;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_918.class})
public abstract class ItemRendererMixin {
    @Shadow
    @Final
    private class_763 field_4732;
    @Shadow
    @Final
    private class_325 field_4733;

    @Inject(method={"render"}, at={@At(value="HEAD")}, cancellable=true)
    private void render(class_1799 stack, class_811 context, boolean leftHand, class_4587 pose, class_4597 buffer, int light, int overlay, class_1087 model, CallbackInfo ci) {
        DynamicItemRenderer.Renderer renderer = ((DynamicItemRenderer)DynamicItemRenderer.INSTANCE.get()).get((class_1935)stack.method_7909());
        if (renderer != null && renderer.shouldUse()) {
            pose.method_22903();
            renderer.renderFirstPerson(stack, context, leftHand, pose, buffer, light, overlay, model, this.field_4732, this.field_4733);
            pose.method_22909();
            ci.cancel();
        }
    }

    @ModifyVariable(method={"render"}, at=@At(value="HEAD"), argsOnly=true)
    private class_1087 render(class_1087 original, class_1799 stack, class_811 context) {
        ResultHolder<class_1087> result;
        ItemRendererRegistry.Renderer renderer = ((ItemRendererRegistry)ItemRendererRegistry.INSTANCE.get()).get((class_1935)stack.method_7909());
        if (renderer != null && renderer.shouldUse() && (result = renderer.renderFirstPerson(stack, context, this.field_4732)).isCancelled()) {
            return result.getValue();
        }
        return original;
    }

    @ModifyVariable(method={"getModel"}, at=@At(value="STORE"))
    private class_1087 getModel(class_1087 original, class_1799 stack) {
        ResultHolder<class_1087> result;
        ResultHolder<class_1087> result2;
        ItemRendererRegistry.Renderer renderer = ((ItemRendererRegistry)ItemRendererRegistry.INSTANCE.get()).get((class_1935)stack.method_7909());
        if (renderer != null && renderer.shouldUse() && (result2 = renderer.renderThirdPerson(stack, this.field_4732)).isCancelled()) {
            return result2.getValue();
        }
        DynamicItemRenderer.Renderer dynamic = ((DynamicItemRenderer)DynamicItemRenderer.INSTANCE.get()).get((class_1935)stack.method_7909());
        if (dynamic != null && dynamic.shouldUse() && (result = dynamic.renderThirdPerson(stack, this.field_4732)).isCancelled()) {
            return result.getValue();
        }
        return original;
    }
}

