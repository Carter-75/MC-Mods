/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry
 *  net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry$DynamicItemRenderer
 *  net.minecraft.item.ItemConvertible
 */
package backported.updates.foundation.client.v2.render.fabric;

import backported.updates.foundation.client.v2.render.BuiltinItemRendererRegistry;
import java.util.Objects;
import net.minecraft.item.ItemConvertible;

public class BuiltinItemRendererRegistryImpl
extends BuiltinItemRendererRegistry {
    private static final BuiltinItemRendererRegistry INSTANCE = new BuiltinItemRendererRegistryImpl();

    public static BuiltinItemRendererRegistry getInstance() {
        return INSTANCE;
    }

    @Override
    public void register(ItemConvertible item, BuiltinItemRendererRegistry.DynamicItemRenderer renderer) {
        net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry.INSTANCE.register(item.asItem(), renderer::render);
    }

    @Override
    public BuiltinItemRendererRegistry.DynamicItemRenderer get(ItemConvertible item) {
        return (arg_0, arg_1, arg_2, arg_3, arg_4, arg_5) -> ((BuiltinItemRendererRegistry.DynamicItemRenderer)Objects.requireNonNull(net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry.INSTANCE.get(item))).render(arg_0, arg_1, arg_2, arg_3, arg_4, arg_5);
    }
}

