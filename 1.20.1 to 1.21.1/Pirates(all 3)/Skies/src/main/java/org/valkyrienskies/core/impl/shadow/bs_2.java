/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.classmate.ResolvedType
 *  com.fasterxml.classmate.members.HierarchicType
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.classmate.members.HierarchicType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.ab_1;
import org.valkyrienskies.core.impl.shadow.ac_1;
import org.valkyrienskies.core.impl.shadow.ad_1;
import org.valkyrienskies.core.impl.shadow.al_1;
import org.valkyrienskies.core.impl.shadow.am_1;
import org.valkyrienskies.core.impl.shadow.an_1;
import org.valkyrienskies.core.impl.shadow.ar_1;
import org.valkyrienskies.core.impl.shadow.av_1;
import org.valkyrienskies.core.impl.shadow.av_2;
import org.valkyrienskies.core.impl.shadow.ay_2;
import org.valkyrienskies.core.impl.shadow.br_2;
import org.valkyrienskies.core.impl.shadow.bt_2;
import org.valkyrienskies.core.impl.shadow.bu_2;
import org.valkyrienskies.core.impl.shadow.bv_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.bs
 */
public final class bs_2
implements ad_1 {
    private final Set<bt_2> a;
    private ObjectMapper b;
    private final Map<Class<?>, BeanDescription> c = Collections.synchronizedMap(new HashMap());
    private final Map<Class<?>, PropertyNamingStrategy> d = Collections.synchronizedMap(new HashMap());

    public bs_2() {
        this.a = Collections.emptySet();
    }

    private bs_2(bt_2 ... bt_2Array) {
        this.a = bt_2Array == null ? Collections.emptySet() : new HashSet<bt_2>(Arrays.asList(bt_2Array));
    }

    @Override
    public final void a(al_1 object) {
        Object object2;
        al_1 al_12 = object;
        this.b = al_12.a;
        al_12 = object;
        am_1<ay_2> am_12 = al_12.c;
        al_12 = object;
        am_1<ac_1> am_13 = al_12.d;
        this.a(am_12);
        this.a(am_13);
        am_12.a(this::b);
        am_13.a(this::a);
        if (!this.a.contains((Object)bt_2.IGNORE_PROPERTY_NAMING_STRATEGY)) {
            am_12.c(this::a);
        }
        al_12 = object;
        object = al_12.b;
        ((an_1)object).a(this::a);
        boolean bl = this.a.contains((Object)bt_2.FLATTENED_ENUMS_FROM_JSONVALUE);
        boolean bl2 = this.a.contains((Object)bt_2.FLATTENED_ENUMS_FROM_JSONPROPERTY);
        if (bl || bl2) {
            ((an_1)object).a(new br_2(bl, bl2));
        }
        if (this.a.contains((Object)bt_2.RESPECT_JSONPROPERTY_ORDER)) {
            object2 = new bu_2(true);
            Object object3 = object;
            ((an_1)object).a = object2;
        }
        boolean bl3 = !this.a.contains((Object)bt_2.SKIP_SUBTYPE_LOOKUP);
        boolean bl4 = bl2 = !this.a.contains((Object)bt_2.IGNORE_TYPE_INFO_TRANSFORM);
        if (bl3 || bl2) {
            bv_2 bv_22 = new bv_2();
            if (bl3) {
                object2 = bv_22;
                Object object4 = object;
                ((an_1)object4).d.add((ar_1)object2);
                am_12.b(bv_22::a);
                am_13.b(bv_22::a);
            }
            if (bl2) {
                ((an_1)object).a((av_2)bv_22);
                am_12.a(bv_22::a);
                am_13.a(bv_22::a);
            }
        }
    }

    private void a(am_1<?> am_12) {
        am_12.e(this::a);
        am_12.c(this::b);
        am_12.c(this::d);
        am_12.d(this::e);
        if (this.a.contains((Object)bt_2.RESPECT_JSONPROPERTY_REQUIRED)) {
            am_12.b(this::c);
        }
    }

    protected final String a(ab_1<?, ?> object) {
        if ((object = ((ab_1)object).e(JsonPropertyDescription.class)) != null) {
            return object.value();
        }
        return null;
    }

    protected final String a(av_1 object) {
        object = ((av_1)object).d.getErasedType();
        if ((object = ((Class)object).getAnnotation(JsonClassDescription.class)) != null) {
            return object.value();
        }
        return null;
    }

    protected final String b(ab_1<?, ?> ab_12) {
        Object object = ab_12.b(JsonProperty.class);
        if (object != null && (object = object.value()) != null && !((String)object).isEmpty() && !((String)object).equals(ab_12.k())) {
            return object;
        }
        return null;
    }

    protected final String a(ay_2 ay_22) {
        Object object;
        Map<Class<?>, PropertyNamingStrategy> map2 = this.d;
        synchronized (map2) {
            object = ay_22;
            object = this.d.computeIfAbsent(((ab_1)object).a.getDeclaringType().getErasedType(), this::a);
        }
        if (object == null) {
            return null;
        }
        return ((PropertyNamingStrategy)object).nameForField(null, null, ay_22.m());
    }

    private PropertyNamingStrategy a(Class<?> clazz2) {
        return Optional.ofNullable(clazz2.getAnnotation(JsonNaming.class)).map(JsonNaming::value).map(clazz -> {
            try {
                return (PropertyNamingStrategy)clazz.getConstructor(new Class[0]).newInstance(new Object[0]);
            }
            catch (ReflectiveOperationException | SecurityException exception) {
                return null;
            }
        }).orElse(null);
    }

    private BeanDescription a(ResolvedType resolvedType) {
        Map<Class<?>, BeanDescription> map2 = this.c;
        synchronized (map2) {
            return this.c.computeIfAbsent(resolvedType.getErasedType(), clazz -> this.b.getSerializationConfig().introspect(this.b.getTypeFactory().constructType((Type)clazz)));
        }
    }

    protected final boolean b(ay_2 object) {
        if (((ab_1)object).e(JsonBackReference.class) != null) {
            return true;
        }
        Object object2 = object;
        object2 = (HierarchicType)((ab_1)object2).b.allTypesAndOverrides().get(0);
        object2 = this.a(object2.getType());
        Set<String> set = this.b.getSerializationConfig().getAnnotationIntrospector().findPropertyIgnoralByName(null, ((BeanDescription)object2).getClassInfo()).getIgnored();
        if (set.contains(object = ((ab_1)object).m())) {
            return true;
        }
        return ((BeanDescription)object2).findProperties().stream().noneMatch(arg_0 -> bs_2.a((String)object, arg_0));
    }

    protected final boolean a(ac_1 ac_12) {
        ay_2 ay_22 = ac_12.c();
        if (ay_22 != null && this.b(ay_22)) {
            return true;
        }
        if (ay_22 == null && ac_12.e(JsonBackReference.class) != null) {
            return true;
        }
        return this.a.contains((Object)bt_2.INCLUDE_ONLY_JSONPROPERTY_ANNOTATED_METHODS) && ((ab_1)ac_12).b(JsonProperty.class) == null;
    }

    protected final boolean c(ab_1<?, ?> object) {
        return (object = ((ab_1)object).e(JsonProperty.class)) != null && object.required();
    }

    protected final boolean d(ab_1<?, ?> object) {
        return (object = ((ab_1)object).b(JsonProperty.class)) != null && object.access() == JsonProperty.Access.READ_ONLY;
    }

    protected final boolean e(ab_1<?, ?> object) {
        return (object = ((ab_1)object).b(JsonProperty.class)) != null && object.access() == JsonProperty.Access.WRITE_ONLY;
    }

    private static /* synthetic */ boolean a(String string, BeanPropertyDefinition beanPropertyDefinition) {
        return string.equals(beanPropertyDefinition.getInternalName());
    }
}

