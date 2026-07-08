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
 *  net.minecraft.class_763
 *  net.minecraft.class_811
 */
package backported.updates.foundation.client.v2.render;

import backported.updates.foundation.core.util.event.ResultHolder;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import net.minecraft.class_1087;
import net.minecraft.class_1091;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1935;
import net.minecraft.class_763;
import net.minecraft.class_811;

public class ItemRendererRegistry {
    public static final Supplier<ItemRendererRegistry> INSTANCE = Suppliers.memoize(ItemRendererRegistry::new);
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
        public ResultHolder<class_1087> renderFirstPerson(class_1799 var1, class_811 var2, class_763 var3);

        public ResultHolder<class_1087> renderThirdPerson(class_1799 var1, class_763 var2);

        public Set<class_1091> registerModels();

        default public boolean shouldUse() {
            return true;
        }
    }
}

