/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.render.model.ModelLoader
 *  net.minecraft.client.util.ModelIdentifier
 *  net.minecraft.client.render.model.UnbakedModel
 *  net.minecraft.item.Item
 *  net.minecraft.util.Identifier
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
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={ModelLoader.class})
public abstract class ModelBakeryMixin {
    @Shadow
    @Final
    private Map<ModelIdentifier, UnbakedModel> modelsToBake;

    @Shadow
    protected abstract void loadItemModel(ModelIdentifier var1);

    @Shadow
    abstract UnbakedModel getOrLoadModel(Identifier var1);

    @Inject(method={"<init>"}, at={@At(value="RETURN")})
    public void addModel(CallbackInfo ci) {
        UnbakedModel unbaked;
        for (Map.Entry<Item, ItemRendererRegistry.Renderer> entry : ((ItemRendererRegistry)ItemRendererRegistry.INSTANCE.get()).getRenderers().entrySet()) {
            for (ModelIdentifier model : entry.getValue().registerModels()) {
                this.loadItemModel(model);
                unbaked = this.modelsToBake.get(model);
                unbaked.setParents(resource -> this.getOrLoadModel(resource));
            }
        }
        for (Map.Entry<Item, DynamicItemRenderer.Renderer> entry : ((DynamicItemRenderer)DynamicItemRenderer.INSTANCE.get()).getRenderers().entrySet()) {
            for (ModelIdentifier model : entry.getValue().registerModels()) {
                this.loadItemModel(model);
                unbaked = this.modelsToBake.get(model);
                unbaked.setParents(resource -> this.getOrLoadModel(resource));
            }
        }
    }
}

