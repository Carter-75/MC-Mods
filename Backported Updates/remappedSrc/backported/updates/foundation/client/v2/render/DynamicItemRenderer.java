/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Supplier
 *  com.google.common.base.Suppliers
 *  net.minecraft.class_1087
 *  net.minecraft.class_1091
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1935
 *  net.minecraft.class_2350
 *  net.minecraft.class_325
 *  net.minecraft.class_4587
 *  net.minecraft.class_4587$class_4665
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597
 *  net.minecraft.class_5253$class_5254
 *  net.minecraft.class_5819
 *  net.minecraft.class_763
 *  net.minecraft.class_777
 *  net.minecraft.class_811
 */
package backported.updates.foundation.client.v2.render;

import backported.updates.foundation.core.util.event.ResultHolder;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.class_1087;
import net.minecraft.class_1091;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1935;
import net.minecraft.class_2350;
import net.minecraft.class_325;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_5253;
import net.minecraft.class_5819;
import net.minecraft.class_763;
import net.minecraft.class_777;
import net.minecraft.class_811;

public class DynamicItemRenderer {
    public static final Supplier<DynamicItemRenderer> INSTANCE = Suppliers.memoize(DynamicItemRenderer::new);
    private static final Map<class_1792, Renderer> RENDERERS = new HashMap<class_1792, Renderer>();

    public void register(class_1935 item, Renderer renderer) {
        RENDERERS.putIfAbsent(item.method_8389(), renderer);
    }

    public Renderer get(class_1935 item) {
        return RENDERERS.get(item.method_8389());
    }

    public Map<class_1792, Renderer> getRenderers() {
        return RENDERERS;
    }

    public static interface Renderer {
        public void renderFirstPerson(class_1799 var1, class_811 var2, boolean var3, class_4587 var4, class_4597 var5, int var6, int var7, class_1087 var8, class_763 var9, class_325 var10);

        public ResultHolder<class_1087> renderThirdPerson(class_1799 var1, class_763 var2);

        public Set<class_1091> registerModels();

        default public boolean shouldUse() {
            return true;
        }

        default public void renderModelLists(class_1087 model, class_1799 stack, int light, int overlay, class_4587 pose, class_4588 buffer, class_325 colors) {
            class_5819 random = class_5819.method_43047();
            long seed = 42L;
            for (class_2350 direction : class_2350.values()) {
                random.method_43052(seed);
                this.renderQuadList(pose, buffer, model.method_4707(null, direction, random), stack, light, overlay, colors);
            }
            random.method_43052(seed);
            this.renderQuadList(pose, buffer, model.method_4707(null, null, random), stack, light, overlay, colors);
        }

        default public void renderQuadList(class_4587 pose, class_4588 buffer, List<class_777> quads, class_1799 stack, int light, int overlay, class_325 colors) {
            boolean isPresent = !stack.method_7960();
            class_4587.class_4665 last = pose.method_23760();
            for (class_777 quad : quads) {
                int tint = -1;
                if (isPresent && quad.method_3360()) {
                    tint = colors.method_1704(stack, quad.method_3359());
                }
                float alpha = (float)class_5253.class_5254.method_27762((int)tint) / 255.0f;
                float red = (float)class_5253.class_5254.method_27765((int)tint) / 255.0f;
                float green = (float)class_5253.class_5254.method_27766((int)tint) / 255.0f;
                float blue = (float)class_5253.class_5254.method_27767((int)tint) / 255.0f;
                buffer.method_22919(last, quad, red, green, blue, alpha, light, overlay);
            }
        }
    }
}

