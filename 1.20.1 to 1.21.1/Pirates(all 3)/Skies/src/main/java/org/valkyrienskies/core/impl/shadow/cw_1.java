/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.HashMap;
import java.util.Map;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.cW
 */
public class cw_1 {
    private static ThreadLocal<Map<String, Object>> a = new ThreadLocal<Map<String, Object>>(){

        protected Map<String, Object> a() {
            return new HashMap<String, Object>();
        }

        @Override
        protected /* synthetic */ Object initialValue() {
            return this.a();
        }
    };

    public static Object a(String string) {
        return a.get().get(string);
    }

    public static void a(String string, Object object) {
        Map<String, Object> map2 = a.get();
        map2.put(string, object);
    }

    public static void b(String string) {
        Map<String, Object> map2 = a.get();
        map2.remove(string);
    }
}

