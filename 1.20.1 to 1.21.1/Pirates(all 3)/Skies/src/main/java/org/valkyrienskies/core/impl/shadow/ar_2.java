/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.imifou.jsonschema.module.addon.TypeFormat;
import com.github.imifou.jsonschema.module.addon.annotation.JsonSchema;
import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Stream;
import org.valkyrienskies.core.impl.shadow.ab_1;
import org.valkyrienskies.core.impl.shadow.ac_1;
import org.valkyrienskies.core.impl.shadow.ad_1;
import org.valkyrienskies.core.impl.shadow.al_1;
import org.valkyrienskies.core.impl.shadow.am_1;
import org.valkyrienskies.core.impl.shadow.ay_2;
import org.valkyrienskies.core.impl.shadow.az_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ar
 */
public final class ar_2
implements ad_1 {
    @Override
    public final void a(al_1 al_12) {
        al_1 al_13 = al_12;
        this.a(al_13.c);
        al_13 = al_12;
        this.a(al_13.d);
    }

    private void a(am_1<?> am_12) {
        az_2<ab_1> az_22 = this::a;
        am_12 = am_12.d(this::i).e(this::j).j(this::k).f(this::l).b(this::m).a(this::n);
        am_12.b(az_22).p(this::a).l(this::b).n(this::c).m(this::d).o(this::e).h(this::f).i(this::g).k(this::h);
    }

    private String i(ab_1<?, ?> ab_12) {
        return ar_2.a(ab_12, JsonSchema.class).map(JsonSchema::title).filter(string -> !string.isEmpty()).orElse(null);
    }

    private String j(ab_1<?, ?> ab_12) {
        return ar_2.a(ab_12, JsonSchema.class).map(JsonSchema::description).filter(string -> !string.isEmpty()).orElse(null);
    }

    private String k(ab_1<?, ?> ab_12) {
        return ar_2.a(ab_12, JsonSchema.class).map(JsonSchema::format).filter(typeFormat -> !TypeFormat.NONE.equals(typeFormat)).map(TypeFormat::toString).orElse(null);
    }

    private String l(ab_1<?, ?> ab_12) {
        return ar_2.a(ab_12, JsonSchema.class).map(JsonSchema::defaultValue).filter(string -> !string.isEmpty()).orElse(null);
    }

    private boolean m(ab_1<?, ?> ab_12) {
        return ar_2.a(ab_12, JsonSchema.class).map(JsonSchema::required).orElse(Boolean.FALSE);
    }

    private boolean n(ab_1<?, ?> ab_12) {
        return ar_2.a(ab_12, JsonSchema.class).map(JsonSchema::ignore).orElse(Boolean.FALSE);
    }

    protected final void a(ObjectNode objectNode, ab_1<?, ?> ab_12) {
        ar_2.a(ab_12, JsonSchema.class).map(JsonSchema::metadata).ifPresent(jSDataArray -> Stream.of(jSDataArray).filter(jSData -> !jSData.key().isEmpty()).filter(jSData -> !jSData.value().isEmpty()).forEach(jSData -> objectNode.put(jSData.key(), jSData.value())));
    }

    protected final BigDecimal a(ab_1<?, ?> ab_12) {
        return ar_2.a(ab_12, JsonSchema.class).map(JsonSchema::multipleOf).filter(d2 -> d2 != 0.0).map(BigDecimal::new).orElse(null);
    }

    protected final BigDecimal b(ab_1<?, ?> ab_12) {
        return ar_2.a(ab_12, JsonSchema.class).filter(jsonSchema -> !jsonSchema.exclusiveMin()).map(JsonSchema::min).filter(d2 -> d2 != Double.MIN_VALUE).map(BigDecimal::new).orElse(null);
    }

    protected final BigDecimal c(ab_1<?, ?> ab_12) {
        return ar_2.a(ab_12, JsonSchema.class).filter(jsonSchema -> !jsonSchema.exclusiveMax()).map(JsonSchema::max).filter(d2 -> d2 != Double.MAX_VALUE).map(BigDecimal::new).orElse(null);
    }

    protected final BigDecimal d(ab_1<?, ?> ab_12) {
        return ar_2.a(ab_12, JsonSchema.class).filter(JsonSchema::exclusiveMin).map(JsonSchema::min).filter(d2 -> d2 != Double.MIN_VALUE).map(BigDecimal::new).orElse(null);
    }

    protected final BigDecimal e(ab_1<?, ?> ab_12) {
        return ar_2.a(ab_12, JsonSchema.class).filter(JsonSchema::exclusiveMax).map(JsonSchema::max).filter(d2 -> d2 != Double.MAX_VALUE).map(BigDecimal::new).orElse(null);
    }

    protected final Integer f(ab_1<?, ?> ab_12) {
        return ar_2.a(ab_12, JsonSchema.class).map(JsonSchema::minLength).filter(n2 -> n2 > 0).orElse(null);
    }

    protected final Integer g(ab_1<?, ?> ab_12) {
        return ar_2.a(ab_12, JsonSchema.class).map(JsonSchema::maxLength).filter(n2 -> n2 != Integer.MAX_VALUE).orElse(null);
    }

    protected final String h(ab_1<?, ?> ab_12) {
        return ar_2.a(ab_12, JsonSchema.class).map(JsonSchema::pattern).filter(string -> !string.isEmpty()).orElse(null);
    }

    private static <A extends Annotation> Optional<A> a(ab_1<?, ?> ab_12, Class<A> clazz) {
        A a2 = ab_12.d(clazz);
        if (a2 == null) {
            ab_12 = ab_12 instanceof ay_2 ? ((ay_2)ab_12).c() : (ab_12 instanceof ac_1 ? ((ac_1)ab_12).c() : null);
            a2 = ab_12 == null ? null : ab_12.d(clazz);
        }
        return Optional.ofNullable(a2);
    }
}

