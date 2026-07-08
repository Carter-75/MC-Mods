/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Set;
import org.valkyrienskies.core.impl.shadow.bv_1;
import org.valkyrienskies.core.impl.shadow.dg_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.dh
 */
public class dh_2 {
    private Set<dg_2> a;
    private bv_1 b;

    public dh_2(Set<dg_2> set, bv_1 bv_12) {
        this.a = set;
        this.b = bv_12;
    }

    public Set<dg_2> a() {
        return this.a;
    }

    public bv_1 b() {
        return this.b;
    }
}

