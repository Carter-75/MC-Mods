/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.classmate.ResolvedType
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.aa_1;
import org.valkyrienskies.core.impl.shadow.ab_1;
import org.valkyrienskies.core.impl.shadow.ac_1;
import org.valkyrienskies.core.impl.shadow.ae_1;
import org.valkyrienskies.core.impl.shadow.ai_1;
import org.valkyrienskies.core.impl.shadow.ak_1;
import org.valkyrienskies.core.impl.shadow.am_1;
import org.valkyrienskies.core.impl.shadow.an_1;
import org.valkyrienskies.core.impl.shadow.ap_1;
import org.valkyrienskies.core.impl.shadow.aq_1;
import org.valkyrienskies.core.impl.shadow.at_1;
import org.valkyrienskies.core.impl.shadow.at_2;
import org.valkyrienskies.core.impl.shadow.av_1;
import org.valkyrienskies.core.impl.shadow.av_2;
import org.valkyrienskies.core.impl.shadow.aw_2;
import org.valkyrienskies.core.impl.shadow.ax_2;
import org.valkyrienskies.core.impl.shadow.ay_2;
import org.valkyrienskies.core.impl.shadow.bb_2;
import org.valkyrienskies.core.impl.shadow.bq_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.bc
 */
public final class bc_2
implements ak_1 {
    private final ObjectMapper a;
    private final aq_1 b;
    private final Set<ae_1> c;
    private final an_1 d;
    private final am_1<ay_2> e;
    private final am_1<ac_1> f;

    public bc_2(ObjectMapper objectMapper, aq_1 aq_12, Set<ae_1> set, an_1 an_12, am_1<ay_2> am_12, am_1<ac_1> am_13) {
        this.a = objectMapper;
        this.b = aq_12;
        this.c = set;
        this.d = an_12;
        this.e = am_12;
        this.f = am_13;
    }

    private boolean a(ae_1 ae_12) {
        return this.c.contains((Object)ae_12);
    }

    @Override
    public final aq_1 a() {
        return this.b;
    }

    @Override
    public final String a(ap_1 object) {
        ap_1 ap_12 = object;
        object = this;
        return ap_12.a(((bc_2)object).b);
    }

    @Override
    public final boolean b() {
        return this.a(ae_1.DEFINITIONS_FOR_ALL_OBJECTS);
    }

    @Override
    public final boolean c() {
        return this.a(ae_1.DEFINITION_FOR_MAIN_SCHEMA);
    }

    @Override
    public final boolean d() {
        return this.a(ae_1.INLINE_ALL_SCHEMAS);
    }

    @Override
    public final boolean f() {
        return this.a(ae_1.PLAIN_DEFINITION_KEYS);
    }

    @Override
    public final boolean g() {
        return this.a(ae_1.EXTRA_OPEN_API_FORMAT_VALUES);
    }

    @Override
    public final boolean h() {
        return this.a(ae_1.ALLOF_CLEANUP_AT_THE_END);
    }

    @Override
    public final boolean i() {
        return this.a(ae_1.PUBLIC_STATIC_FIELDS) || this.a(ae_1.NONPUBLIC_STATIC_FIELDS);
    }

    @Override
    public final boolean j() {
        return this.a(ae_1.STATIC_METHODS);
    }

    @Override
    public final boolean k() {
        return this.a(ae_1.FIELDS_DERIVED_FROM_ARGUMENTFREE_METHODS);
    }

    @Override
    public final boolean l() {
        return !this.a(ae_1.ENUM_KEYWORD_FOR_SINGLE_VALUES);
    }

    @Override
    public final boolean m() {
        return this.a(ae_1.NULLABLE_ARRAY_ITEMS_ALLOWED);
    }

    @Override
    public final boolean e() {
        return this.a(ae_1.SCHEMA_VERSION_INDICATOR);
    }

    @Override
    public final ObjectMapper n() {
        return this.a;
    }

    @Override
    public final ObjectNode o() {
        bc_2 bc_22 = this;
        return bc_22.a.createObjectNode();
    }

    @Override
    public final ArrayNode p() {
        bc_2 bc_22 = this;
        return bc_22.a.createArrayNode();
    }

    @Override
    public final int a(ab_1<?, ?> ab_12, ab_1<?, ?> ab_13) {
        an_1 an_12 = this.d;
        return an_12.a.compare(ab_12, ab_13);
    }

    @Override
    public final bq_2 q() {
        an_1 an_12 = this.d;
        return an_12.b;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    @Override
    public final at_2 a(ab_1 ab_12, bb_2 bb_22, ax_2 object) {
        if (ab_12 instanceof ay_2) {
            object = bc_2.a(this.e, (ay_2)ab_12, bb_22, object);
        } else if (ab_12 instanceof ac_1) {
            object = bc_2.a(this.f, (ac_1)ab_12, bb_22, object);
        } else {
            throw new IllegalArgumentException("Unexpected member scope: " + (ab_12 == null ? null : ab_12.getClass().getName()));
        }
        if (object == null) {
            object = this.a(ab_12.d, (ai_1)bb_22, null);
        }
        return object;
    }

    private static <M extends ab_1<?, ?>> aw_2 a(am_1<M> object, M m2, ai_1 ai_12, ax_2<? extends M> ax_23) {
        object = Collections.unmodifiableList(((am_1)object).a);
        if (ax_23 == null || object.contains(ax_23)) {
            int n2 = 1 + object.indexOf(ax_23);
            object = object.subList(n2, object.size()).stream().map(ax_22 -> ax_22.provideCustomSchemaDefinition(m2, ai_12)).filter(Objects::nonNull).findFirst().orElse(null);
        } else {
            object = null;
        }
        return object;
    }

    @Override
    public final at_2 a(ResolvedType resolvedType, ai_1 ai_12, av_2 av_23) {
        Object object = this.d;
        object = Collections.unmodifiableList(((an_1)object).c);
        int n2 = 1 + object.indexOf(av_23);
        return object.subList(n2, object.size()).stream().map(av_22 -> av_22.a(resolvedType, ai_12)).filter(Objects::nonNull).findFirst().orElse(null);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    @Override
    public final List a(ResolvedType resolvedType, bb_2 bb_22) {
        an_1 an_12 = this.d;
        return Collections.unmodifiableList(an_12.d).stream().map(ar_12 -> ar_12.b(resolvedType, bb_22)).filter(Objects::nonNull).findFirst().orElseGet(Collections::emptyList);
    }

    @Override
    public final List<at_1> r() {
        an_1 an_12 = this.d;
        return Collections.unmodifiableList(an_12.e);
    }

    @Override
    public final List<aa_1<ay_2>> s() {
        am_1<ay_2> am_12 = this.e;
        return Collections.unmodifiableList(am_12.b);
    }

    @Override
    public final List<aa_1<ac_1>> t() {
        am_1<ac_1> am_12 = this.f;
        return Collections.unmodifiableList(am_12.b);
    }

    @Override
    public final boolean a(ay_2 ay_22) {
        return Optional.ofNullable(this.e.e(ay_22)).orElseGet(() -> !ay_22.c && this.a(ae_1.NULLABLE_FIELDS_BY_DEFAULT));
    }

    @Override
    public final boolean a(ac_1 ac_12) {
        return Optional.ofNullable(this.f.e(ac_12)).orElseGet(() -> !ac_12.c && this.a(ae_1.NULLABLE_METHOD_RETURN_VALUES_BY_DEFAULT));
    }

    @Override
    public final boolean e(ay_2 ay_22) {
        return this.e.a(ay_22);
    }

    @Override
    public final boolean e(ac_1 ac_12) {
        return this.f.a(ac_12);
    }

    @Override
    public final boolean b(ay_2 ay_22) {
        return this.e.b(ay_22);
    }

    @Override
    public final boolean b(ac_1 ac_12) {
        return this.f.b(ac_12);
    }

    @Override
    public final boolean c(ay_2 ay_22) {
        return this.e.c(ay_22);
    }

    @Override
    public final boolean c(ac_1 ac_12) {
        return this.f.c(ac_12);
    }

    @Override
    public final boolean d(ay_2 ay_22) {
        return this.e.d(ay_22);
    }

    @Override
    public final boolean d(ac_1 ac_12) {
        return this.f.d(ac_12);
    }

    @Override
    public final List<ResolvedType> g(ay_2 ay_22) {
        return this.e.f(ay_22);
    }

    @Override
    public final List<ResolvedType> g(ac_1 ac_12) {
        return this.f.f(ac_12);
    }

    @Override
    public final String h(ay_2 ay_22) {
        return this.e.g(ay_22);
    }

    @Override
    public final String h(ac_1 ac_12) {
        return this.f.g(ac_12);
    }

    @Override
    public final String a(av_1 av_12) {
        return this.d.a(av_12);
    }

    @Override
    public final String b(av_1 av_12) {
        return this.d.b(av_12);
    }

    @Override
    public final String i(ay_2 ay_22) {
        return this.e.c(ay_22);
    }

    @Override
    public final String i(ac_1 ac_12) {
        return this.f.c(ac_12);
    }

    @Override
    public final String c(av_1 av_12) {
        return this.d.c(av_12);
    }

    @Override
    public final String j(ay_2 ay_22) {
        return this.e.d(ay_22);
    }

    @Override
    public final String j(ac_1 ac_12) {
        return this.f.d(ac_12);
    }

    @Override
    public final String d(av_1 av_12) {
        return this.d.d(av_12);
    }

    @Override
    public final Object k(ay_2 ay_22) {
        return this.e.e(ay_22);
    }

    @Override
    public final Object k(ac_1 ac_12) {
        return this.f.e(ac_12);
    }

    @Override
    public final Object e(av_1 av_12) {
        return this.d.e(av_12);
    }

    @Override
    public final Collection<?> l(ay_2 ay_22) {
        return this.e.f(ay_22);
    }

    @Override
    public final Collection<?> l(ac_1 ac_12) {
        return this.f.f(ac_12);
    }

    @Override
    public final Collection<?> f(av_1 av_12) {
        return this.d.f(av_12);
    }

    @Override
    public final Type m(ay_2 ay_22) {
        return this.e.g(ay_22);
    }

    @Override
    public final Type m(ac_1 ac_12) {
        return this.f.g(ac_12);
    }

    @Override
    public final Type g(av_1 av_12) {
        return this.d.g(av_12);
    }

    @Override
    public final Map<String, Type> n(ay_2 ay_22) {
        return this.e.h(ay_22);
    }

    @Override
    public final Map<String, Type> n(ac_1 ac_12) {
        return this.f.h(ac_12);
    }

    @Override
    public final Map<String, Type> h(av_1 av_12) {
        return this.d.h(av_12);
    }

    @Override
    public final Integer o(ay_2 ay_22) {
        return this.e.i(ay_22);
    }

    @Override
    public final Integer o(ac_1 ac_12) {
        return this.f.i(ac_12);
    }

    @Override
    public final Integer i(av_1 av_12) {
        return this.d.i(av_12);
    }

    @Override
    public final Integer p(ay_2 ay_22) {
        return this.e.j(ay_22);
    }

    @Override
    public final Integer p(ac_1 ac_12) {
        return this.f.j(ac_12);
    }

    @Override
    public final Integer j(av_1 av_12) {
        return this.d.j(av_12);
    }

    @Override
    public final String q(ay_2 ay_22) {
        return this.e.k(ay_22);
    }

    @Override
    public final String q(ac_1 ac_12) {
        return this.f.k(ac_12);
    }

    @Override
    public final String k(av_1 av_12) {
        return this.d.k(av_12);
    }

    @Override
    public final String r(ay_2 ay_22) {
        return this.e.l(ay_22);
    }

    @Override
    public final String r(ac_1 ac_12) {
        return this.f.l(ac_12);
    }

    @Override
    public final String l(av_1 av_12) {
        return this.d.l(av_12);
    }

    @Override
    public final BigDecimal s(ay_2 ay_22) {
        return this.e.m(ay_22);
    }

    @Override
    public final BigDecimal s(ac_1 ac_12) {
        return this.f.m(ac_12);
    }

    @Override
    public final BigDecimal m(av_1 av_12) {
        return this.d.m(av_12);
    }

    @Override
    public final BigDecimal t(ay_2 ay_22) {
        return this.e.n(ay_22);
    }

    @Override
    public final BigDecimal t(ac_1 ac_12) {
        return this.f.n(ac_12);
    }

    @Override
    public final BigDecimal n(av_1 av_12) {
        return this.d.n(av_12);
    }

    @Override
    public final BigDecimal u(ay_2 ay_22) {
        return this.e.o(ay_22);
    }

    @Override
    public final BigDecimal u(ac_1 ac_12) {
        return this.f.o(ac_12);
    }

    @Override
    public final BigDecimal o(av_1 av_12) {
        return this.d.o(av_12);
    }

    @Override
    public final BigDecimal v(ay_2 ay_22) {
        return this.e.p(ay_22);
    }

    @Override
    public final BigDecimal v(ac_1 ac_12) {
        return this.f.p(ac_12);
    }

    @Override
    public final BigDecimal p(av_1 av_12) {
        return this.d.p(av_12);
    }

    @Override
    public final BigDecimal w(ay_2 ay_22) {
        return this.e.q(ay_22);
    }

    @Override
    public final BigDecimal w(ac_1 ac_12) {
        return this.f.q(ac_12);
    }

    @Override
    public final BigDecimal q(av_1 av_12) {
        return this.d.q(av_12);
    }

    @Override
    public final Integer x(ay_2 ay_22) {
        return this.e.r(ay_22);
    }

    @Override
    public final Integer x(ac_1 ac_12) {
        return this.f.r(ac_12);
    }

    @Override
    public final Integer r(av_1 av_12) {
        return this.d.r(av_12);
    }

    @Override
    public final Integer y(ay_2 ay_22) {
        return this.e.s(ay_22);
    }

    @Override
    public final Integer y(ac_1 ac_12) {
        return this.f.s(ac_12);
    }

    @Override
    public final Integer s(av_1 av_12) {
        return this.d.s(av_12);
    }

    @Override
    public final Boolean z(ay_2 ay_22) {
        return this.e.t(ay_22);
    }

    @Override
    public final Boolean z(ac_1 ac_12) {
        return this.f.t(ac_12);
    }

    @Override
    public final Boolean t(av_1 av_12) {
        return this.d.t(av_12);
    }
}

