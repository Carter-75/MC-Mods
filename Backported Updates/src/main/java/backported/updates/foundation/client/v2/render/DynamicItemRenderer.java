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
 *  net.minecraft.util.math.Direction
 *  net.minecraft.client.color.item.ItemColors
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.util.math.MatrixStack$Entry
 *  net.minecraft.client.render.VertexConsumer
 *  net.minecraft.client.render.VertexConsumerProvider
 *  net.minecraft.util.math.ColorHelper$Argb
 *  net.minecraft.util.math.random.Random
 *  net.minecraft.client.render.item.ItemModels
 *  net.minecraft.client.render.model.BakedQuad
 *  net.minecraft.client.render.model.json.ModelTransformationMode
 */
package backported.updates.foundation.client.v2.render;

import backported.updates.foundation.core.util.event.ResultHolder;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.math.Direction;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.client.render.item.ItemModels;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.json.ModelTransformationMode;

public class DynamicItemRenderer {
    public static final Supplier<DynamicItemRenderer> INSTANCE = Suppliers.memoize(DynamicItemRenderer::new);
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
        public void renderFirstPerson(ItemStack var1, ModelTransformationMode var2, boolean var3, MatrixStack var4, VertexConsumerProvider var5, int var6, int var7, BakedModel var8, ItemModels var9, ItemColors var10);

        public ResultHolder<BakedModel> renderThirdPerson(ItemStack var1, ItemModels var2);

        public Set<ModelIdentifier> registerModels();

        default public boolean shouldUse() {
            return true;
        }

        default public void renderModelLists(BakedModel model, ItemStack stack, int light, int overlay, MatrixStack pose, VertexConsumer buffer, ItemColors colors) {
            Random random = Random.create();
            long seed = 42L;
            for (Direction direction : Direction.values()) {
                random.setSeed(seed);
                this.renderQuadList(pose, buffer, model.getQuads(null, direction, random), stack, light, overlay, colors);
            }
            random.setSeed(seed);
            this.renderQuadList(pose, buffer, model.getQuads(null, null, random), stack, light, overlay, colors);
        }

        default public void renderQuadList(MatrixStack pose, VertexConsumer buffer, List<BakedQuad> quads, ItemStack stack, int light, int overlay, ItemColors colors) {
            boolean isPresent = !stack.isEmpty();
            MatrixStack.Entry last = pose.peek();
            for (BakedQuad quad : quads) {
                int tint = -1;
                if (isPresent && quad.hasColor()) {
                    tint = colors.getColor(stack, quad.getColorIndex());
                }
                float alpha = (float)ColorHelper.Argb.getAlpha((int)tint) / 255.0f;
                float red = (float)ColorHelper.Argb.getRed((int)tint) / 255.0f;
                float green = (float)ColorHelper.Argb.getGreen((int)tint) / 255.0f;
                float blue = (float)ColorHelper.Argb.getBlue((int)tint) / 255.0f;
                buffer.quad(last, quad, red, green, blue, alpha, light, overlay);
            }
        }
    }
}

