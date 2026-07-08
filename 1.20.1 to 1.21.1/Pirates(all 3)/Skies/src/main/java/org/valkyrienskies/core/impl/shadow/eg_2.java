/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.eg
 */
public final class eg_2 {
    private static final int a = 0x40000000;

    private eg_2() {
    }

    public static <T> List<T> a(int size) {
        if (size == 0) {
            return Collections.emptyList();
        }
        return new ArrayList(size);
    }

    public static <T> boolean a(List<T> list) {
        if (list.size() < 2) {
            return false;
        }
        HashSet<T> hashSet = new HashSet<T>(list);
        return list.size() != hashSet.size();
    }

    static <T> HashSet<T> b(int expectedSize) {
        return new HashSet(eg_2.d(expectedSize));
    }

    public static <K, V> LinkedHashMap<K, V> c(int expectedSize) {
        return new LinkedHashMap(eg_2.d(expectedSize));
    }

    static int d(int expectedSize) {
        if (expectedSize < 3) {
            return expectedSize + 1;
        }
        if (expectedSize < 0x40000000) {
            return (int)((float)expectedSize / 0.75f + 1.0f);
        }
        return Integer.MAX_VALUE;
    }
}

