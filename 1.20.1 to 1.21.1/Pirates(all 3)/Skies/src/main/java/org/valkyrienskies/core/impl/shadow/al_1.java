/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.core.json.JsonWriteFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.valkyrienskies.core.impl.shadow.ac_1;
import org.valkyrienskies.core.impl.shadow.ad_1;
import org.valkyrienskies.core.impl.shadow.ae_1;
import org.valkyrienskies.core.impl.shadow.af_1;
import org.valkyrienskies.core.impl.shadow.am_1;
import org.valkyrienskies.core.impl.shadow.an_1;
import org.valkyrienskies.core.impl.shadow.aq_1;
import org.valkyrienskies.core.impl.shadow.as_1;
import org.valkyrienskies.core.impl.shadow.av_2;
import org.valkyrienskies.core.impl.shadow.ay_2;
import org.valkyrienskies.core.impl.shadow.bc_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.aL
 */
public final class al_1 {
    public final ObjectMapper a;
    private final af_1 e;
    private final aq_1 f;
    private final Map<ae_1, Boolean> g = new HashMap<ae_1, Boolean>();
    public final an_1 b = new an_1();
    public final am_1<ay_2> c = new am_1();
    public final am_1<ac_1> d = new am_1();

    private static ObjectMapper e() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.getSerializationConfig().with(JsonWriteFeature.WRITE_NUMBERS_AS_STRINGS);
        objectMapper.setNodeFactory(JsonNodeFactory.withExactBigDecimals(true));
        return objectMapper;
    }

    @Deprecated
    private al_1(ObjectMapper objectMapper) {
        this(objectMapper, aq_1.DRAFT_7, af_1.a);
    }

    private al_1(ObjectMapper objectMapper, aq_1 aq_12) {
        this(objectMapper, aq_12, af_1.a);
    }

    private al_1(aq_1 aq_12) {
        this(al_1.e(), aq_12, af_1.a);
    }

    @Deprecated
    private al_1(ObjectMapper objectMapper, af_1 af_12) {
        this(objectMapper, aq_1.DRAFT_7, af_12);
    }

    private al_1(aq_1 aq_12, af_1 af_12) {
        this(al_1.e(), aq_12, af_12);
    }

    private al_1(ObjectMapper objectMapper, aq_1 aq_12, af_1 af_12) {
        this.a = objectMapper;
        this.f = aq_12;
        this.e = af_12;
    }

    private bc_2 f() {
        Object object2 = EnumSet.allOf(ae_1.class);
        Set<ae_1> set = EnumSet.allOf(ae_1.class).stream().filter(object -> {
            ae_1 ae_12;
            ae_1 ae_13 = ae_12 = object;
            object = this.e;
            return this.g.getOrDefault((Object)ae_13, ((af_1)object).b.contains((Object)ae_12));
        }).collect(Collectors.toSet());
        object2 = object2.stream().filter(ae_12 -> set.stream().noneMatch(ae_13 -> {
            ae_1 ae_14 = ae_13;
            ae_13 = ae_12;
            ae_12 = ae_14;
            return ae_14.overriddenOptions.contains(ae_13);
        })).collect(Collectors.toMap(ae_12 -> ae_12, set::contains, (bl, bl2) -> bl, LinkedHashMap::new));
        object2.entrySet().stream().map(object -> {
            boolean bl = (Boolean)object.getValue();
            object = (ae_1)((Object)((Object)object.getKey()));
            object = bl ? ((ae_1)((Object)((Object)object))).enabledModuleProvider : ((ae_1)((Object)((Object)object))).disabledModuleProvider;
            if (object == null) {
                return null;
            }
            return (ad_1)object.get();
        }).filter(Objects::nonNull).forEach(this::a);
        set.retainAll(object2.keySet());
        return new bc_2(this.a, this.f, set, this.b, this.c, this.d);
    }

    public final an_1 a() {
        return this.b;
    }

    public final am_1<ay_2> b() {
        return this.c;
    }

    public final am_1<ac_1> c() {
        return this.d;
    }

    public final ObjectMapper d() {
        return this.a;
    }

    private Boolean a(ae_1 ae_12) {
        return this.g.get((Object)ae_12);
    }

    public final al_1 a(ad_1 ad_12) {
        ad_12.a(this);
        return this;
    }

    @Deprecated
    private al_1 a(av_2 av_22) {
        this.b.a(av_22);
        return this;
    }

    @Deprecated
    private al_1 a(as_1 object) {
        as_1 as_12 = object;
        object = this.b;
        ((an_1)object).e.add(as_12);
        return this;
    }

    private al_1 a(ae_1 ae_12, ae_1 ... ae_1Array) {
        return this.a(ae_12, ae_1Array, true);
    }

    private al_1 b(ae_1 ae_12, ae_1 ... ae_1Array) {
        return this.a(ae_12, ae_1Array, false);
    }

    private al_1 a(ae_1 ae_1Array, ae_1[] ae_1Array2, boolean bl) {
        this.g.put((ae_1)ae_1Array, bl);
        if (ae_1Array2 != null) {
            ae_1Array = ae_1Array2;
            int n2 = ae_1Array2.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                ae_1 ae_12 = ae_1Array[i2];
                this.g.put(ae_12, bl);
            }
        }
        return this;
    }
}

