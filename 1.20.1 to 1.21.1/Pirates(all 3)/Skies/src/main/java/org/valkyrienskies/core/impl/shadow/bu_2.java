/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.classmate.members.HierarchicType
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.classmate.members.HierarchicType;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import org.valkyrienskies.core.impl.shadow.ab_1;
import org.valkyrienskies.core.impl.shadow.ac_1;
import org.valkyrienskies.core.impl.shadow.az_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.bu
 */
public final class bu_2
implements Comparator<ab_1<?, ?>> {
    private final boolean a;
    private final Map<Class<?>, List<String>> b = new HashMap();
    private final Map<Class<?>, Boolean> c = new HashMap();

    public bu_2(boolean bl) {
        this.a = true;
    }

    private int a(ab_1<?, ?> ab_13, ab_1<?, ?> ab_14) {
        int n2 = az_1.a.compare(ab_13, ab_14);
        if (n2 == 0) {
            n2 = this.a(ab_13) - this.a(ab_14);
        }
        if (n2 == 0 && Stream.of(ab_13, ab_14).map(ab_12 -> ab_12.a.getDeclaringType().getErasedType()).anyMatch(clazz -> this.c.computeIfAbsent((Class<?>)clazz, this::a))) {
            n2 = az_1.b.compare(ab_13, ab_14);
        }
        return n2;
    }

    private int a(ab_1<?, ?> object) {
        Object object2 = object;
        object2 = (HierarchicType)((ab_1)object2).b.allTypesAndOverrides().get(0);
        int n2 = (object2 = this.b.computeIfAbsent(object2.getErasedType(), this::b)).indexOf(object = object instanceof ac_1 ? (String)Optional.ofNullable(((ac_1)object).c()).map(ab_1::s).orElse(null) : object.s());
        if (n2 == -1) {
            n2 = Integer.MAX_VALUE;
        }
        return n2;
    }

    protected final boolean a(Class<?> clazz) {
        return Optional.ofNullable(clazz.getAnnotation(JsonPropertyOrder.class)).map(JsonPropertyOrder::alphabetic).orElse(this.a);
    }

    private List<String> b(Class<?> clazz) {
        return Optional.ofNullable(clazz.getAnnotation(JsonPropertyOrder.class)).map(JsonPropertyOrder::value).filter(stringArray -> ((String[])stringArray).length != 0).map(Arrays::asList).orElseGet(Collections::emptyList);
    }

    @Override
    public final /* synthetic */ int compare(Object object, Object object2) {
        ab_1 ab_13 = (ab_1)object2;
        object2 = (ab_1)object;
        object = this;
        int n2 = az_1.a.compare((ab_1<?, ?>)object2, ab_13);
        if (n2 == 0) {
            n2 = ((bu_2)object).a((ab_1<?, ?>)object2) - ((bu_2)object).a(ab_13);
        }
        if (n2 == 0 && Stream.of(object2, ab_13).map(ab_12 -> ab_12.a.getDeclaringType().getErasedType()).anyMatch(clazz -> this.c.computeIfAbsent((Class<?>)clazz, this::a))) {
            n2 = az_1.b.compare((ab_1<?, ?>)object2, ab_13);
        }
        return n2;
    }
}

