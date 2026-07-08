/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1088
 *  net.minecraft.class_1091
 *  net.minecraft.class_1100
 *  net.minecraft.class_1792
 *  net.minecraft.class_2960
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.foundation.client;

import backported.updates.foundation.client.v2.render.DynamicItemRenderer;
import backported.updates.foundation.client.v2.render.ItemRendererRegistry;
import java.util.Map;
import net.minecraft.class_1088;
import net.minecraft.class_1091;
import net.minecraft.class_1100;
import net.minecraft.class_1792;
import net.minecraft.class_2960;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_1088.class})
public abstract class ModelBakeryMixin {
    @Shadow
    @Final
    private Map<class_1091, class_1100> field_5394;

    @Shadow
    protected abstract void method_61073(class_1091 var1);

    @Shadow
    abstract class_1100 method_4726(class_2960 var1);

    @Inject(method={"<init>"}, at={@At(value="RETURN")})
    public void addModel(CallbackInfo ci) {
        class_1100 unbaked;
        for (Map.Entry<class_1792, ItemRendererRegistry.Renderer> entry : ((ItemRendererRegistry)ItemRendererRegistry.INSTANCE.get()).getRenderers().entrySet()) {
            for (class_1091 model : entry.getValue().registerModels()) {
                this.method_61073(model);
                unbaked = this.field_5394.get(model);
                unbaked.method_45785(resource -> this.method_4726((class_2960)resource));
            }
        }
        for (Map.Entry<class_1792, Object> entry : ((DynamicItemRenderer)DynamicItemRenderer.INSTANCE.get()).getRenderers().entrySet()) {
            for (class_1091 model : ((DynamicItemRenderer.Renderer)entry.getValue()).registerModels()) {
                this.method_61073(model);
                unbaked = this.field_5394.get(model);
                unbaked.method_45785(resource -> this.method_4726((class_2960)resource));
            }
        }
    }
}

