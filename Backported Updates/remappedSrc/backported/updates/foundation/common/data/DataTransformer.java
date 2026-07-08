/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2960
 */
package backported.updates.foundation.common.data;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import net.minecraft.class_2960;

public class DataTransformer {
    private static final ThreadLocal<Boolean> REENTRANT_GUARD = ThreadLocal.withInitial(() -> false);
    private static final List<Function<class_2960, class_2960>> TRANSFORMERS = new CopyOnWriteArrayList<Function<class_2960, class_2960>>();

    public static void onDataTransformation(Consumer<Transformer> consumer) {
        consumer.accept(TRANSFORMERS::add);
    }

    public static boolean shouldCheckNamespace() {
        return !TRANSFORMERS.isEmpty();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static class_2960 applyTransformsIfPossible(String namespace, String path) {
        if (TRANSFORMERS.isEmpty() || REENTRANT_GUARD.get().booleanValue()) {
            return null;
        }
        REENTRANT_GUARD.set(true);
        try {
            class_2960 original = class_2960.method_60655((String)namespace, (String)path);
            for (Function<class_2960, class_2960> transformer : TRANSFORMERS) {
                class_2960 result = transformer.apply(original);
                if (result == null) continue;
                class_2960 class_29602 = result;
                return class_29602;
            }
            Iterator<Function<class_2960, class_2960>> iterator = null;
            return iterator;
        }
        finally {
            REENTRANT_GUARD.set(false);
        }
    }

    public static interface Transformer {
        public void add(Function<class_2960, class_2960> var1);

        default public void remap(class_2960 original, class_2960 remapped) {
            this.add(path -> {
                if (path.equals((Object)original)) {
                    return remapped;
                }
                return null;
            });
        }
    }
}

