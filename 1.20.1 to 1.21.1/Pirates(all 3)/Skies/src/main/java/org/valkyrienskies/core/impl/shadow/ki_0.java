/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.fs_2;
import org.valkyrienskies.core.impl.shadow.kg_0;
import org.valkyrienskies.core.impl.shadow.kh_0;
import org.valkyrienskies.core.impl.shadow.kj_0;
import org.valkyrienskies.core.impl.shadow.kk_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ki
 */
public final class ki_0<T> {
    public final List<kh_0<T>> a = new ArrayList<kh_0<T>>();
    private int b = 0;
    private int c = 0;

    public final void a(kk_0<T> kk_02) {
        this.a.add(kk_02);
        ++this.b;
    }

    public final void a(kj_0<T> kj_02) {
        this.a.add(kj_02);
        ++this.c;
    }

    public final void a(kg_0<T> kg_02) {
        this.a.add(kg_02);
        ++this.c;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public final void a(fs_2.b b2) {
        for (kh_0<T> kh_02 : this.a) {
            kh_02.a(b2);
        }
    }

    private int a() {
        return this.b;
    }

    private int b() {
        return this.c;
    }
}

