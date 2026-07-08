/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.functions.Function0
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Map;
import kotlin.jvm.functions.Function0;

public final class CI {
    private static final <K, V> void a(Map<K, V> object, K k2, V v, Function0<String> function0) {
        if (!(object.putIfAbsent(k2, v) == null)) {
            object = function0.invoke();
            throw new IllegalArgumentException(object.toString());
        }
    }

    private static /* synthetic */ void a(Map object, Object object2, Object object3, Function0 function0, int n2) {
        if ((n2 & 4) != 0) {
            function0 = (Function0)new Function0<String>(object2){
                private /* synthetic */ K $a;
                {
                    this.$a = k2;
                    super(0);
                }

                public final String a() {
                    return this.$a + " was already in the map";
                }

                public final /* synthetic */ Object invoke() {
                    return this.a();
                }
            };
        }
        if (!(object.putIfAbsent(object2, object3) == null)) {
            object = function0.invoke();
            throw new IllegalArgumentException(object.toString());
        }
    }
}

