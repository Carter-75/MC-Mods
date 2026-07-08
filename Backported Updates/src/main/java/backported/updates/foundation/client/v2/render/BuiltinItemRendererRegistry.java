/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.render.VertexConsumerProvider
 *  net.minecraft.client.render.model.json.ModelTransformationMode
 */
package backported.updates.foundation.client.v2.render;

import backported.updates.foundation.client.v2.render.fabric.BuiltinItemRendererRegistryImpl;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemConvertible;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.model.json.ModelTransformationMode;

public abstract class BuiltinItemRendererRegistry {
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static BuiltinItemRendererRegistry getInstance() {
        return BuiltinItemRendererRegistryImpl.getInstance();
    }

    public abstract void register(ItemConvertible var1, DynamicItemRenderer var2);

    public abstract DynamicItemRenderer get(ItemConvertible var1);

    @FunctionalInterface
    public static interface DynamicItemRenderer {
        public void render(ItemStack var1, ModelTransformationMode var2, MatrixStack var3, VertexConsumerProvider var4, int var5, int var6);
    }
}

