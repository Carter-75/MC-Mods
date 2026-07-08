/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.classmate.ResolvedType
 *  org.valkyrienskies.core.impl.shadow.at
 *  org.valkyrienskies.core.impl.shadow.at$a
 *  org.valkyrienskies.core.impl.shadow.bm
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Stream;
import org.valkyrienskies.core.impl.shadow.ab_1;
import org.valkyrienskies.core.impl.shadow.ad_1;
import org.valkyrienskies.core.impl.shadow.ai_1;
import org.valkyrienskies.core.impl.shadow.al_1;
import org.valkyrienskies.core.impl.shadow.ap_1;
import org.valkyrienskies.core.impl.shadow.at;
import org.valkyrienskies.core.impl.shadow.at_2;
import org.valkyrienskies.core.impl.shadow.av_1;
import org.valkyrienskies.core.impl.shadow.av_2;
import org.valkyrienskies.core.impl.shadow.bm;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.bm
 */
public final class bm_2
implements ad_1 {
    final Map<Class<?>, ap_1> a = new HashMap();
    final Map<Class<?>, String> b = new HashMap();

    public static bm_2 a() {
        bm_2 bm_22 = new bm_2();
        Class<Object> clazz2 = Object.class;
        bm_2 bm_23 = bm_22;
        bm_22.a(clazz2, ap_1.TAG_TYPE_NULL, null);
        Stream.of(String.class, Character.class, Character.TYPE, CharSequence.class, Byte.class, Byte.TYPE).forEach(bm_22::a);
        Stream.of(Boolean.class, Boolean.TYPE).forEach(bm_22::b);
        Stream.of(Integer.class, Integer.TYPE).forEach(clazz -> bm_22.b((Class<?>)clazz, "int32"));
        Stream.of(Long.class, Long.TYPE).forEach(clazz -> bm_22.b((Class<?>)clazz, "int64"));
        Stream.of(Short.class, Short.TYPE).forEach(bm_22::c);
        Stream.of(Double.class, Double.TYPE).forEach(clazz -> bm_22.c((Class<?>)clazz, "double"));
        Stream.of(Float.class, Float.TYPE).forEach(clazz -> bm_22.c((Class<?>)clazz, "float"));
        return bm_22;
    }

    public static bm_2 b() {
        bm_2 bm_22 = bm_2.a();
        bm_22.a(LocalDate.class, "date");
        Stream.of(LocalDateTime.class, LocalTime.class, ZonedDateTime.class, OffsetDateTime.class, OffsetTime.class, Instant.class, Date.class, Calendar.class).forEach(clazz -> bm_22.a((Class<?>)clazz, "date-time"));
        bm_22.a(UUID.class, "uuid");
        bm_22.a(URI.class, "uri");
        bm_22.a(ZoneId.class);
        bm_22.c(BigInteger.class);
        Stream.of(BigDecimal.class, Number.class).forEach(bm_22::d);
        return bm_22;
    }

    private bm_2 a(Class<?> clazz, ap_1 ap_12, String string) {
        this.a.put(clazz, ap_12);
        if (string != null) {
            this.b.put(clazz, string);
        }
        return this;
    }

    private bm_2 e(Class<?> clazz) {
        return this.a(clazz, ap_1.TAG_TYPE_NULL, null);
    }

    @Deprecated
    private bm_2 f(Class<?> clazz) {
        return this.a(clazz, ap_1.TAG_TYPE_OBJECT, null);
    }

    public final bm_2 a(Class<?> clazz) {
        return this.a(clazz, null);
    }

    private bm_2 a(Class<?> clazz, String string) {
        return this.a(clazz, ap_1.TAG_TYPE_STRING, string);
    }

    public final bm_2 b(Class<?> clazz) {
        return this.a(clazz, ap_1.TAG_TYPE_BOOLEAN, null);
    }

    public final bm_2 c(Class<?> clazz) {
        return this.b(clazz, null);
    }

    private bm_2 b(Class<?> clazz, String string) {
        return this.a(clazz, ap_1.TAG_TYPE_INTEGER, string);
    }

    public final bm_2 d(Class<?> clazz) {
        return this.c(clazz, null);
    }

    private bm_2 c(Class<?> clazz, String string) {
        return this.a(clazz, ap_1.TAG_TYPE_NUMBER, string);
    }

    private Boolean a(ab_1<?, ?> ab_12) {
        if (ab_12.d.isPrimitive()) {
            return Boolean.FALSE;
        }
        return null;
    }

    @Override
    public final void a(al_1 al_12) {
        al_1 al_13 = al_12;
        al_13.c.a(this::a);
        al_13 = al_12;
        al_13.d.a(this::a);
        al_13 = al_12;
        al_13.b.b(this::a).c(this::b).a(new a(this, 0));
    }

    private Type a(av_1 av_12) {
        av_1 av_13 = av_12;
        if (av_13.d.getTypeParameters().isEmpty()) {
            av_13 = av_12;
            if (ap_1.TAG_TYPE_NULL == this.a.get(av_13.d.getErasedType())) {
                return Object.class;
            }
        }
        return null;
    }

    private Map<String, Type> b(av_1 av_12) {
        av_1 av_13 = av_12;
        if (av_13.d.getTypeParameters().isEmpty()) {
            av_13 = av_12;
            if (ap_1.TAG_TYPE_NULL == this.a.get(av_13.d.getErasedType())) {
                return Collections.emptyMap();
            }
        }
        return null;
    }

    static /* synthetic */ Map a(bm_2 bm_22) {
        return bm_22.a;
    }

    static /* synthetic */ Map b(bm_2 bm_22) {
        return bm_22.b;
    }

    final class a
    implements av_2 {
        private /* synthetic */ bm_2 a;

        private a(bm_2 bm_22) {
            this.a = bm_22;
        }

        @Override
        public final at_2 a(ResolvedType object, ai_1 ai_12) {
            if (!object.getTypeParameters().isEmpty()) {
                return null;
            }
            Object object2 = this.a;
            object2 = (ap_1)((Object)((bm)object2).a.get(object.getErasedType()));
            if (object2 == null) {
                return null;
            }
            ObjectNode objectNode = ai_12.a().o();
            if (object2 != ap_1.TAG_TYPE_NULL) {
                objectNode.put(ai_12.a(ap_1.TAG_TYPE), ai_12.a((ap_1)((Object)object2)));
            }
            if (ai_12.a().g()) {
                object2 = this.a;
                if ((object = (String)((bm)object2).b.get(object.getErasedType())) != null) {
                    objectNode.put(ai_12.a(ap_1.TAG_FORMAT), (String)object);
                }
            }
            return new at(objectNode, at_2.b.INLINE, at.a.YES);
        }

        /* synthetic */ a(bm_2 bm_22, byte by) {
            this(bm_22);
        }
    }
}

