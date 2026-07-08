/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.classmate.ResolvedType
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.classmate.ResolvedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.valkyrienskies.core.impl.shadow.aa_1;
import org.valkyrienskies.core.impl.shadow.ab_1;
import org.valkyrienskies.core.impl.shadow.ao_1;
import org.valkyrienskies.core.impl.shadow.as_2;
import org.valkyrienskies.core.impl.shadow.ax_2;
import org.valkyrienskies.core.impl.shadow.az_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.aM
 */
public final class am_1<M extends ab_1<?, ?>>
extends ao_1<M> {
    public final List<ax_2<M>> a = new ArrayList<ax_2<M>>();
    public final List<aa_1<M>> b = new ArrayList<aa_1<M>>();
    private final List<Predicate<M>> c = new ArrayList<Predicate<M>>();
    private final List<Predicate<M>> d = new ArrayList<Predicate<M>>();
    private final List<Predicate<M>> e = new ArrayList<Predicate<M>>();
    private final List<Predicate<M>> f = new ArrayList<Predicate<M>>();
    private final List<as_2<M, Boolean>> g = new ArrayList<as_2<M, Boolean>>();
    private final List<as_2<M, List<ResolvedType>>> h = new ArrayList<as_2<M, List<ResolvedType>>>();
    private final List<as_2<M, String>> i = new ArrayList<as_2<M, String>>();

    public final am_1<M> a(ax_2<M> ax_22) {
        this.a.add(ax_22);
        return this;
    }

    public final List<ax_2<M>> a() {
        return Collections.unmodifiableList(this.a);
    }

    @Deprecated
    public final am_1<M> a(az_2<M> az_22) {
        return this.b(az_22);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public final am_1 b(az_2 az_22) {
        this.b.add(az_22);
        return this;
    }

    public final List<aa_1<M>> b() {
        return Collections.unmodifiableList(this.b);
    }

    public final am_1<M> a(Predicate<M> predicate) {
        this.c.add(predicate);
        return this;
    }

    public final boolean a(M m2) {
        return this.c.stream().anyMatch(predicate -> predicate.test(m2));
    }

    public final am_1<M> b(Predicate<M> predicate) {
        this.d.add(predicate);
        return this;
    }

    public final boolean b(M m2) {
        return this.d.stream().anyMatch(predicate -> predicate.test(m2));
    }

    public final am_1<M> c(Predicate<M> predicate) {
        this.e.add(predicate);
        return this;
    }

    public final boolean c(M m2) {
        return this.e.stream().anyMatch(predicate -> predicate.test(m2));
    }

    public final am_1<M> d(Predicate<M> predicate) {
        this.f.add(predicate);
        return this;
    }

    public final boolean d(M m2) {
        return this.f.stream().anyMatch(predicate -> predicate.test(m2));
    }

    public final am_1<M> a(as_2<M, Boolean> as_22) {
        this.g.add(as_22);
        return this;
    }

    public final Boolean e(M object) {
        object = this.g.stream().map(as_22 -> (Boolean)as_22.apply(object)).filter(Objects::nonNull).collect(Collectors.toSet());
        if (object.isEmpty()) {
            return null;
        }
        return object.stream().anyMatch(bl -> bl);
    }

    @Deprecated
    private am_1<M> I(as_2<M, ResolvedType> as_22) {
        this.h.add(ab_12 -> Optional.ofNullable((ResolvedType)as_22.apply(ab_12)).map(Collections::singletonList).orElse(null));
        return this;
    }

    public final am_1<M> b(as_2<M, List<ResolvedType>> as_22) {
        this.h.add(as_22);
        return this;
    }

    @Override
    public final List<ResolvedType> f(M m2) {
        return (List)am_1.a(this.h, m2);
    }

    public final am_1<M> c(as_2<M, String> as_22) {
        this.i.add(as_22);
        return this;
    }

    public final String g(M m2) {
        return (String)am_1.a(this.i, m2);
    }

    public final am_1<M> d(as_2<M, String> as_22) {
        return (am_1)super.H(as_22);
    }

    public final am_1<M> e(as_2<M, String> as_22) {
        return (am_1)super.G(as_22);
    }

    @Override
    public final am_1<M> f(as_2<M, Object> as_22) {
        return (am_1)super.F(as_22);
    }

    public final am_1<M> g(as_2<M, Collection<?>> as_22) {
        return (am_1)super.E(as_22);
    }

    private am_1<M> J(as_2<M, Type> as_22) {
        return (am_1)super.D(as_22);
    }

    private am_1<M> K(as_2<M, Map<String, Type>> as_22) {
        return (am_1)super.C(as_22);
    }

    public final am_1<M> h(as_2<M, Integer> as_22) {
        return (am_1)super.B(as_22);
    }

    public final am_1<M> i(as_2<M, Integer> as_22) {
        return (am_1)super.A(as_22);
    }

    public final am_1<M> j(as_2<M, String> as_22) {
        return (am_1)super.z(as_22);
    }

    public final am_1<M> k(as_2<M, String> as_22) {
        return (am_1)super.y(as_22);
    }

    public final am_1<M> l(as_2<M, BigDecimal> as_22) {
        return (am_1)super.x(as_22);
    }

    public final am_1<M> m(as_2<M, BigDecimal> as_22) {
        return (am_1)super.w(as_22);
    }

    public final am_1<M> n(as_2<M, BigDecimal> as_22) {
        return (am_1)super.v(as_22);
    }

    public final am_1<M> o(as_2<M, BigDecimal> as_22) {
        return (am_1)super.u(as_22);
    }

    public final am_1<M> p(as_2<M, BigDecimal> as_22) {
        return (am_1)super.t(as_22);
    }

    private am_1<M> L(as_2<M, Integer> as_22) {
        return (am_1)super.s(as_22);
    }

    private am_1<M> M(as_2<M, Integer> as_22) {
        return (am_1)super.r(as_22);
    }

    private am_1<M> N(as_2<M, Boolean> as_22) {
        return (am_1)super.q(as_22);
    }

    @Override
    public final /* synthetic */ ao_1 t(as_2 as_22) {
        return this.p(as_22);
    }

    @Override
    public final /* synthetic */ ao_1 u(as_2 as_22) {
        return this.o(as_22);
    }

    @Override
    public final /* synthetic */ ao_1 v(as_2 as_22) {
        return this.n(as_22);
    }

    @Override
    public final /* synthetic */ ao_1 w(as_2 as_22) {
        return this.m(as_22);
    }

    @Override
    public final /* synthetic */ ao_1 x(as_2 as_22) {
        return this.l(as_22);
    }

    @Override
    public final /* synthetic */ ao_1 y(as_2 as_22) {
        return this.k(as_22);
    }

    @Override
    public final /* synthetic */ ao_1 z(as_2 as_22) {
        return this.j(as_22);
    }

    @Override
    public final /* synthetic */ ao_1 A(as_2 as_22) {
        return this.i(as_22);
    }

    @Override
    public final /* synthetic */ ao_1 B(as_2 as_22) {
        return this.h(as_22);
    }

    @Override
    public final /* synthetic */ ao_1 E(as_2 as_22) {
        return this.g(as_22);
    }

    @Override
    public final /* synthetic */ ao_1 F(as_2 as_22) {
        return this.f(as_22);
    }

    @Override
    public final /* synthetic */ ao_1 G(as_2 as_22) {
        return this.e(as_22);
    }

    @Override
    public final /* synthetic */ ao_1 H(as_2 as_22) {
        return this.d(as_22);
    }
}

