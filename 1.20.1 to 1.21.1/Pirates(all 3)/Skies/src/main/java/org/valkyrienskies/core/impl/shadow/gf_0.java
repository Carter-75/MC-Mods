/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.valkyrienskies.core.impl.shadow.gc_0;
import org.valkyrienskies.core.impl.shadow.ge_0;
import org.valkyrienskies.core.impl.shadow.gg_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Gf
 */
public final class gf_0<S>
extends gc_0<S> {
    private final S c;
    private Function1<? super String, Unit> d;
    public boolean b;
    private boolean e;

    public gf_0(S s) {
        this.c = s;
        this.e = true;
    }

    private Function1<String, Unit> d() {
        return this.d;
    }

    private void b(Function1<? super String, Unit> function1) {
        this.d = function1;
    }

    private void e() {
        this.e = false;
    }

    public final void b() {
        this.b = true;
    }

    public final ge_0<S> c() {
        return new gg_0<S>(this.c, this.a(), this.b, this.e, this.d);
    }
}

