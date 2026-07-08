/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Comparator;

public abstract class kI<K>
implements Serializable,
Comparator<K> {
    private static final long a = -20497563720380683L;
    private static int b = -1;
    private static int c = -2;
    private static int d = -3;

    static boolean a(int n2) {
        return n2 == -3;
    }

    static boolean b(int n2) {
        return n2 == -2;
    }

    static boolean c(int n2) {
        return n2 == -1;
    }

    static boolean d(int n2) {
        return n2 >= 0;
    }

    public abstract int a();

    public abstract int a(K var1);

    public abstract boolean a(K var1, int var2, int var3);

    public abstract int a(K var1, int var2, int var3, K var4, int var5, int var6);

    public abstract boolean a(K var1, int var2, int var3, K var4);

    /*
     * WARNING - void declaration
     */
    @Override
    public int compare(K o1, K o2) {
        void var2_2;
        void var1_1;
        if (o1 == null) {
            if (o2 == null) {
                return 0;
            }
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        return ((Comparable)var1_1).compareTo(var2_2);
    }
}

