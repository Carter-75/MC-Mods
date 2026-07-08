/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.ci_2;
import org.valkyrienskies.core.impl.shadow.co_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ct
 */
abstract class ct_2 {
    protected static String a;
    protected static String b;
    public static final List<ci_2> c;

    ct_2() {
    }

    abstract co_2 a();

    static {
        c = new ArrayList<ci_2>(co_2.a);
    }
}

