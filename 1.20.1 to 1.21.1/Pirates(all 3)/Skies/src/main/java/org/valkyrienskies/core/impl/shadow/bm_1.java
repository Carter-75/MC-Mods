/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ci_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.bM
 */
public abstract class bm_1
implements ci_2 {
    private final String a;
    private final String b;

    public bm_1(String string) {
        this(string, "");
    }

    public bm_1(String string, String string2) {
        this.a = string;
        this.b = string2;
    }

    @Override
    public String a() {
        return this.a;
    }

    @Override
    public String b() {
        return this.b;
    }
}

