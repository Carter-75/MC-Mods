/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ew_1;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.fn_1;
import org.valkyrienskies.core.impl.shadow.fq_1;
import org.valkyrienskies.core.impl.shadow.fy_1;
import org.valkyrienskies.core.impl.shadow.ga_2;
import org.valkyrienskies.core.impl.shadow.gb_2;
import org.valkyrienskies.core.impl.shadow.gc_2;
import org.valkyrienskies.core.impl.shadow.gd_2;
import org.valkyrienskies.core.impl.shadow.ge_2;
import org.valkyrienskies.core.impl.shadow.gf_2;
import org.valkyrienskies.core.impl.shadow.gg_2;
import org.valkyrienskies.core.impl.shadow.gh_2;
import org.valkyrienskies.core.impl.shadow.gi_2;
import org.valkyrienskies.core.impl.shadow.gj_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.eX
 */
public final class ex_1 {
    private static ew_1 a = gi_2.a(new ga_2());
    private static fn_1 b = gj_2.a(new gh_2());

    private ex_1() {
    }

    private static <E> ew_1<E> a(ew_1<E> ew_12) {
        return gd_2.a(ew_12);
    }

    private static <E> ew_1<E> b(ew_1<? extends E> ew_12) {
        return gi_2.a(ew_12);
    }

    private static <E> ew_1<E> a(ew_1<E> ew_12, ff_1<? super E> ff_12) {
        return gb_2.a(ew_12, ff_12);
    }

    private static <E> ew_1<E> a(ew_1<E> ew_12, fq_1<? super E, ? extends E> fq_12) {
        return gf_2.a(ew_12, fq_12);
    }

    private static <E> ew_1<E> c(ew_1<E> ew_12) {
        return fy_1.a(ew_12);
    }

    private static <E> fn_1<E> a(fn_1<E> fn_12) {
        return ge_2.a(fn_12);
    }

    private static <E> fn_1<E> b(fn_1<E> fn_12) {
        return gj_2.a(fn_12);
    }

    private static <E> fn_1<E> a(fn_1<E> fn_12, ff_1<? super E> ff_12) {
        return gc_2.a(fn_12, ff_12);
    }

    private static <E> fn_1<E> a(fn_1<E> fn_12, fq_1<? super E, ? extends E> fq_12) {
        return gg_2.a(fn_12, fq_12);
    }

    private static <E> ew_1<E> a() {
        return a;
    }

    private static <E> fn_1<E> b() {
        return b;
    }
}

