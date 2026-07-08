/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Identifier
 */
package backported.updates.foundation.common.data;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import net.minecraft.util.Identifier;

public class DataTransformer {
    private static final ThreadLocal<Boolean> REENTRANT_GUARD = ThreadLocal.withInitial(() -> false);
    private static final List<Function<Identifier, Identifier>> TRANSFORMERS = new CopyOnWriteArrayList<Function<Identifier, Identifier>>();

    public static void onDataTransformation(Consumer<Transformer> consumer) {
        consumer.accept(TRANSFORMERS::add);
    }

    public static boolean shouldCheckNamespace() {
        return !TRANSFORMERS.isEmpty();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Identifier applyTransformsIfPossible(String namespace, String path) {
        if (TRANSFORMERS.isEmpty() || REENTRANT_GUARD.get().booleanValue()) {
            return null;
        }
        REENTRANT_GUARD.set(true);
        try {
            Identifier original = Identifier.of((String)namespace, (String)path);
            for (Function<Identifier, Identifier> transformer : TRANSFORMERS) {
                Identifier result = transformer.apply(original);
                if (result == null) continue;
                Identifier class_29602 = result;
                return class_29602;
            }
            return null;
        }
        finally {
            REENTRANT_GUARD.set(false);
        }
    }

    public static interface Transformer {
        public void add(Function<Identifier, Identifier> var1);

        default public void remap(Identifier original, Identifier remapped) {
            this.add(path -> {
                if (path.equals(original)) {
                    return remapped;
                }
                return null;
            });
        }
    }
}

