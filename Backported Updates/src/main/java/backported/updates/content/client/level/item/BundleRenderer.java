/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableSet
 *  net.minecraft.client.render.model.BakedModel
 *  net.minecraft.client.util.ModelIdentifier
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.client.render.item.ItemModels
 *  net.minecraft.registry.Registries
 *  net.minecraft.client.render.model.json.ModelTransformationMode
 */
package backported.updates.content.client.level.item;

import backported.updates.content.common.registries.ModItems;
import backported.updates.content.core.VanillaBackport;
import backported.updates.foundation.client.v2.render.ItemRendererRegistry;
import backported.updates.foundation.core.util.event.ResultHolder;
import com.google.common.collect.ImmutableSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ItemConvertible;
import net.minecraft.client.render.item.ItemModels;
import net.minecraft.registry.Registries;
import net.minecraft.client.render.model.json.ModelTransformationMode;

public class BundleRenderer
implements ItemRendererRegistry.Renderer {
    public static final Set<ItemConvertible> BUNDLES = Set.of(Items.BUNDLE, (ItemConvertible)ModItems.WHITE_BUNDLE.get(), (ItemConvertible)ModItems.ORANGE_BUNDLE.get(), (ItemConvertible)ModItems.MAGENTA_BUNDLE.get(), (ItemConvertible)ModItems.LIGHT_BLUE_BUNDLE.get(), (ItemConvertible)ModItems.YELLOW_BUNDLE.get(), (ItemConvertible)ModItems.LIME_BUNDLE.get(), (ItemConvertible)ModItems.PINK_BUNDLE.get(), (ItemConvertible)ModItems.GRAY_BUNDLE.get(), (ItemConvertible)ModItems.LIGHT_GRAY_BUNDLE.get(), (ItemConvertible)ModItems.CYAN_BUNDLE.get(), (ItemConvertible)ModItems.BLUE_BUNDLE.get(), (ItemConvertible)ModItems.BROWN_BUNDLE.get(), (ItemConvertible)ModItems.GREEN_BUNDLE.get(), (ItemConvertible)ModItems.RED_BUNDLE.get(), (ItemConvertible)ModItems.BLACK_BUNDLE.get(), (ItemConvertible)ModItems.PURPLE_BUNDLE.get());
    private static final Map<ItemConvertible, ModelIdentifier> BUNDLE_MODELS = BundleRenderer.buildModels();

    private static Map<ItemConvertible, ModelIdentifier> buildModels() {
        HashMap<ItemConvertible, ModelIdentifier> models = new HashMap<ItemConvertible, ModelIdentifier>();
        for (ItemConvertible item : BUNDLES) {
            models.put(item, BundleRenderer.create(item.asItem()));
        }
        return models;
    }

    private static ModelIdentifier create(Item item) {
        return new ModelIdentifier(VanillaBackport.resource(Registries.ITEM.getId(item).getPath()), "inventory");
    }

    @Override
    public boolean shouldUse() {
        return VanillaBackport.COMMON_CONFIG.hasUpdatedBundles.get();
    }

    @Override
    public ResultHolder<BakedModel> renderFirstPerson(ItemStack stack, ModelTransformationMode context, ItemModels shaper) {
        return ResultHolder.submit(shaper.getModelManager().getModel(BUNDLE_MODELS.get(stack.getItem())));
    }

    @Override
    public ResultHolder<BakedModel> renderThirdPerson(ItemStack stack, ItemModels shaper) {
        return ResultHolder.submit(shaper.getModelManager().getModel(BUNDLE_MODELS.get(stack.getItem())));
    }

    @Override
    public Set<ModelIdentifier> registerModels() {
        ImmutableSet models = ImmutableSet.of();
        models = ImmutableSet.builder().addAll((Iterable)models).addAll(BUNDLE_MODELS.values()).build();
        return models;
    }
}

