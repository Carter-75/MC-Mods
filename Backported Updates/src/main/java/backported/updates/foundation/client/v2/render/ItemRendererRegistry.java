/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Supplier
 *  com.google.common.base.Suppliers
 *  net.minecraft.client.render.model.BakedModel
 *  net.minecraft.client.util.ModelIdentifier
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.client.render.item.ItemModels
 *  net.minecraft.client.render.model.json.ModelTransformationMode
 */
package backported.updates.foundation.client.v2.render;

import backported.updates.foundation.core.util.event.ResultHolder;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemConvertible;
import net.minecraft.client.render.item.ItemModels;
import net.minecraft.client.render.model.json.ModelTransformationMode;

public class ItemRendererRegistry {
    public static final Supplier<ItemRendererRegistry> INSTANCE = Suppliers.memoize(ItemRendererRegistry::new);
    private static final Map<Item, Renderer> RENDERERS = new HashMap<Item, Renderer>();

    public void register(ItemConvertible item, Renderer renderer) {
        RENDERERS.putIfAbsent(item.asItem(), renderer);
    }

    public Renderer get(ItemConvertible item) {
        return RENDERERS.get(item.asItem());
    }

    public Map<Item, Renderer> getRenderers() {
        return RENDERERS;
    }

    public static interface Renderer {
        public ResultHolder<BakedModel> renderFirstPerson(ItemStack var1, ModelTransformationMode var2, ItemModels var3);

        public ResultHolder<BakedModel> renderThirdPerson(ItemStack var1, ItemModels var2);

        public Set<ModelIdentifier> registerModels();

        default public boolean shouldUse() {
            return true;
        }
    }
}

