/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.render.model.BakedModel
 *  net.minecraft.client.util.ModelIdentifier
 *  net.minecraft.item.ItemStack
 *  net.minecraft.client.render.item.ItemModels
 *  net.minecraft.client.render.model.json.ModelTransformationMode
 */
package backported.updates.foundation.client.v2.render;

import backported.updates.foundation.client.v2.render.ItemRendererRegistry;
import backported.updates.foundation.core.util.event.ResultHolder;
import java.util.Set;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.item.ItemStack;
import net.minecraft.client.render.item.ItemModels;
import net.minecraft.client.render.model.json.ModelTransformationMode;

public record HandHeldItemRenderer(ModelIdentifier original, ModelIdentifier handheld) implements ItemRendererRegistry.Renderer
{
    private static final Set<ModelTransformationMode> CONTEXTS = Set.of(ModelTransformationMode.GUI, ModelTransformationMode.GROUND, ModelTransformationMode.FIXED);

    @Override
    public ResultHolder<BakedModel> renderFirstPerson(ItemStack stack, ModelTransformationMode context, ItemModels shaper) {
        if (CONTEXTS.contains(context)) {
            return ResultHolder.submit(shaper.getModelManager().getModel(this.original()));
        }
        return ResultHolder.pass();
    }

    @Override
    public ResultHolder<BakedModel> renderThirdPerson(ItemStack stack, ItemModels shaper) {
        return ResultHolder.submit(shaper.getModelManager().getModel(this.handheld()));
    }

    @Override
    public Set<ModelIdentifier> registerModels() {
        return Set.of(this.handheld());
    }
}

