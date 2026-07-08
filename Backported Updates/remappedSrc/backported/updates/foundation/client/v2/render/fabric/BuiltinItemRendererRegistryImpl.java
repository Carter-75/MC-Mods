/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry
 *  net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry$DynamicItemRenderer
 *  net.minecraft.class_1935
 */
package backported.updates.foundation.client.v2.render.fabric;

import backported.updates.foundation.client.v2.render.BuiltinItemRendererRegistry;
import java.util.Objects;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.class_1935;

public class BuiltinItemRendererRegistryImpl
extends backported.updates.foundation.client.v2.render.BuiltinItemRendererRegistry {
    private static final backported.updates.foundation.client.v2.render.BuiltinItemRendererRegistry INSTANCE = new BuiltinItemRendererRegistryImpl();

    public static backported.updates.foundation.client.v2.render.BuiltinItemRendererRegistry getInstance() {
        return INSTANCE;
    }

    @Override
    public void register(class_1935 item, backported.updates.foundation.client.v2.render.BuiltinItemRendererRegistry.DynamicItemRenderer renderer) {
        net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry.INSTANCE.register((class_1935)item.method_8389(), renderer::render);
    }

    @Override
    public backported.updates.foundation.client.v2.render.BuiltinItemRendererRegistry.DynamicItemRenderer get(class_1935 item) {
        return (arg_0, arg_1, arg_2, arg_3, arg_4, arg_5) -> ((backported.updates.foundation.client.v2.render.BuiltinItemRendererRegistry.DynamicItemRenderer)Objects.requireNonNull(net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry.INSTANCE.get(item))).render(arg_0, arg_1, arg_2, arg_3, arg_4, arg_5);
    }
}

