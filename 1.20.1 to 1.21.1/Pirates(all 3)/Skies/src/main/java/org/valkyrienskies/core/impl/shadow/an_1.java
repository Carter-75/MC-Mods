/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.ab_1;
import org.valkyrienskies.core.impl.shadow.ao_1;
import org.valkyrienskies.core.impl.shadow.ar_1;
import org.valkyrienskies.core.impl.shadow.as_1;
import org.valkyrienskies.core.impl.shadow.as_2;
import org.valkyrienskies.core.impl.shadow.at_1;
import org.valkyrienskies.core.impl.shadow.av_1;
import org.valkyrienskies.core.impl.shadow.av_2;
import org.valkyrienskies.core.impl.shadow.az_1;
import org.valkyrienskies.core.impl.shadow.bq_2;
import org.valkyrienskies.core.impl.shadow.bu_2;
import org.valkyrienskies.core.impl.shadow.bv_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.aN
 */
public final class an_1
extends ao_1<av_1> {
    public Comparator<ab_1<?, ?>> a = az_1.c;
    public bq_2 b = null;
    public final List<av_2> c = new ArrayList<av_2>();
    public final List<ar_1> d = new ArrayList<ar_1>();
    public final List<at_1> e = new ArrayList<at_1>();
    private final List<as_2<av_1, String>> f = new ArrayList<as_2<av_1, String>>();
    private final List<as_2<av_1, String>> g = new ArrayList<as_2<av_1, String>>();

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public final an_1 a(bu_2 bu_22) {
        this.a = bu_22;
        return this;
    }

    public final Comparator<ab_1<?, ?>> a() {
        return this.a;
    }

    private an_1 a(bq_2 bq_22) {
        this.b = bq_22;
        return this;
    }

    public final bq_2 b() {
        return this.b;
    }

    public final an_1 a(av_2 av_22) {
        this.c.add(av_22);
        return this;
    }

    public final List<av_2> c() {
        return Collections.unmodifiableList(this.c);
    }

    public final an_1 a(bv_2 bv_22) {
        this.d.add(bv_22);
        return this;
    }

    public final List<ar_1> d() {
        return Collections.unmodifiableList(this.d);
    }

    public final an_1 a(as_1 as_12) {
        this.e.add(as_12);
        return this;
    }

    public final List<at_1> e() {
        return Collections.unmodifiableList(this.e);
    }

    private an_1 d(as_2<av_1, String> as_22) {
        this.f.add(as_22);
        return this;
    }

    public final String a(av_1 av_12) {
        return (String)an_1.a(this.f, av_12);
    }

    private an_1 e(as_2<av_1, String> as_22) {
        this.g.add(as_22);
        return this;
    }

    public final String b(av_1 av_12) {
        return (String)an_1.a(this.g, av_12);
    }

    private an_1 f(as_2<av_1, String> as_22) {
        return (an_1)super.H(as_22);
    }

    public final an_1 a(as_2<av_1, String> as_22) {
        return (an_1)super.G(as_22);
    }

    private an_1 g(as_2<av_1, Object> as_22) {
        return (an_1)super.F(as_22);
    }

    private an_1 h(as_2<av_1, Collection<?>> as_22) {
        return (an_1)super.E(as_22);
    }

    public final an_1 b(as_2<av_1, Type> as_22) {
        return (an_1)super.D(as_22);
    }

    public final an_1 c(as_2<av_1, Map<String, Type>> as_22) {
        return (an_1)super.C(as_22);
    }

    private an_1 i(as_2<av_1, Integer> as_22) {
        return (an_1)super.B(as_22);
    }

    private an_1 j(as_2<av_1, Integer> as_22) {
        return (an_1)super.A(as_22);
    }

    private an_1 k(as_2<av_1, String> as_22) {
        return (an_1)super.z(as_22);
    }

    private an_1 l(as_2<av_1, String> as_22) {
        return (an_1)super.y(as_22);
    }

    private an_1 m(as_2<av_1, BigDecimal> as_22) {
        return (an_1)super.x(as_22);
    }

    private an_1 n(as_2<av_1, BigDecimal> as_22) {
        return (an_1)super.w(as_22);
    }

    private an_1 o(as_2<av_1, BigDecimal> as_22) {
        return (an_1)super.v(as_22);
    }

    private an_1 p(as_2<av_1, BigDecimal> as_22) {
        return (an_1)super.u(as_22);
    }

    private an_1 I(as_2<av_1, BigDecimal> as_22) {
        return (an_1)super.t(as_22);
    }

    private an_1 J(as_2<av_1, Integer> as_22) {
        return (an_1)super.s(as_22);
    }

    private an_1 K(as_2<av_1, Integer> as_22) {
        return (an_1)super.r(as_22);
    }

    private an_1 L(as_2<av_1, Boolean> as_22) {
        return (an_1)super.q(as_22);
    }

    @Override
    public final /* synthetic */ ao_1 C(as_2 as_22) {
        return this.c(as_22);
    }

    @Override
    public final /* synthetic */ ao_1 D(as_2 as_22) {
        return this.b(as_22);
    }

    @Override
    public final /* synthetic */ ao_1 G(as_2 as_22) {
        return this.a(as_22);
    }
}

