/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.valkyrienskies.core.impl.shadow.as_2;
import org.valkyrienskies.core.impl.shadow.av_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.aO
 */
public class ao_1<S extends av_1> {
    private final List<as_2<S, String>> a = new ArrayList<as_2<S, String>>();
    private final List<as_2<S, String>> b = new ArrayList<as_2<S, String>>();
    private final List<as_2<S, Object>> c = new ArrayList<as_2<S, Object>>();
    private final List<as_2<S, Collection<?>>> d = new ArrayList();
    private final List<as_2<S, Type>> e = new ArrayList<as_2<S, Type>>();
    private final List<as_2<S, Map<String, Type>>> f = new ArrayList<as_2<S, Map<String, Type>>>();
    private final List<as_2<S, Integer>> g = new ArrayList<as_2<S, Integer>>();
    private final List<as_2<S, Integer>> h = new ArrayList<as_2<S, Integer>>();
    private final List<as_2<S, String>> i = new ArrayList<as_2<S, String>>();
    private final List<as_2<S, String>> j = new ArrayList<as_2<S, String>>();
    private final List<as_2<S, BigDecimal>> k = new ArrayList<as_2<S, BigDecimal>>();
    private final List<as_2<S, BigDecimal>> l = new ArrayList<as_2<S, BigDecimal>>();
    private final List<as_2<S, BigDecimal>> m = new ArrayList<as_2<S, BigDecimal>>();
    private final List<as_2<S, BigDecimal>> n = new ArrayList<as_2<S, BigDecimal>>();
    private final List<as_2<S, BigDecimal>> o = new ArrayList<as_2<S, BigDecimal>>();
    private final List<as_2<S, Integer>> p = new ArrayList<as_2<S, Integer>>();
    private final List<as_2<S, Integer>> q = new ArrayList<as_2<S, Integer>>();
    private final List<as_2<S, Boolean>> r = new ArrayList<as_2<S, Boolean>>();

    protected static <S extends av_1, R> R a(List<as_2<S, R>> list, S s) {
        return list.stream().map(as_22 -> as_22.apply(s)).filter(Objects::nonNull).findFirst().orElse(null);
    }

    public ao_1<S> H(as_2<S, String> as_22) {
        this.a.add(as_22);
        return this;
    }

    public final String c(S s) {
        return (String)ao_1.a(this.a, s);
    }

    public ao_1<S> G(as_2<S, String> as_22) {
        this.b.add(as_22);
        return this;
    }

    public final String d(S s) {
        return (String)ao_1.a(this.b, s);
    }

    public ao_1<S> F(as_2<S, Object> as_22) {
        this.c.add(as_22);
        return this;
    }

    public final Object e(S s) {
        return ao_1.a(this.c, s);
    }

    public ao_1<S> E(as_2<S, Collection<?>> as_22) {
        this.d.add(as_22);
        return this;
    }

    public final Collection<?> f(S s) {
        return (Collection)ao_1.a(this.d, s);
    }

    public ao_1<S> D(as_2<S, Type> as_22) {
        this.e.add(as_22);
        return this;
    }

    public final Type g(S s) {
        return (Type)ao_1.a(this.e, s);
    }

    public ao_1<S> C(as_2<S, Map<String, Type>> as_22) {
        this.f.add(as_22);
        return this;
    }

    public final Map<String, Type> h(S s) {
        return (Map)ao_1.a(this.f, s);
    }

    public ao_1<S> B(as_2<S, Integer> as_22) {
        this.g.add(as_22);
        return this;
    }

    public final Integer i(S s) {
        return (Integer)ao_1.a(this.g, s);
    }

    public ao_1<S> A(as_2<S, Integer> as_22) {
        this.h.add(as_22);
        return this;
    }

    public final Integer j(S s) {
        return (Integer)ao_1.a(this.h, s);
    }

    public ao_1<S> z(as_2<S, String> as_22) {
        this.i.add(as_22);
        return this;
    }

    public final String k(S s) {
        return (String)ao_1.a(this.i, s);
    }

    public ao_1<S> y(as_2<S, String> as_22) {
        this.j.add(as_22);
        return this;
    }

    public final String l(S s) {
        return (String)ao_1.a(this.j, s);
    }

    public ao_1<S> x(as_2<S, BigDecimal> as_22) {
        this.k.add(as_22);
        return this;
    }

    public final BigDecimal m(S s) {
        return (BigDecimal)ao_1.a(this.k, s);
    }

    public ao_1<S> w(as_2<S, BigDecimal> as_22) {
        this.l.add(as_22);
        return this;
    }

    public final BigDecimal n(S s) {
        return (BigDecimal)ao_1.a(this.l, s);
    }

    public ao_1<S> v(as_2<S, BigDecimal> as_22) {
        this.m.add(as_22);
        return this;
    }

    public final BigDecimal o(S s) {
        return (BigDecimal)ao_1.a(this.m, s);
    }

    public ao_1<S> u(as_2<S, BigDecimal> as_22) {
        this.n.add(as_22);
        return this;
    }

    public final BigDecimal p(S s) {
        return (BigDecimal)ao_1.a(this.n, s);
    }

    public ao_1<S> t(as_2<S, BigDecimal> as_22) {
        this.o.add(as_22);
        return this;
    }

    public final BigDecimal q(S s) {
        return (BigDecimal)ao_1.a(this.o, s);
    }

    public ao_1<S> s(as_2<S, Integer> as_22) {
        this.p.add(as_22);
        return this;
    }

    public final Integer r(S s) {
        return (Integer)ao_1.a(this.p, s);
    }

    public ao_1<S> r(as_2<S, Integer> as_22) {
        this.q.add(as_22);
        return this;
    }

    public final Integer s(S s) {
        return (Integer)ao_1.a(this.q, s);
    }

    public ao_1<S> q(as_2<S, Boolean> as_22) {
        this.r.add(as_22);
        return this;
    }

    public final Boolean t(S s) {
        return (Boolean)ao_1.a(this.r, s);
    }
}

