/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.valkyrienskies.core.impl.shadow.bt_1;
import org.valkyrienskies.core.impl.shadow.bv_1;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.cs_1;
import org.valkyrienskies.core.impl.shadow.cu_2;
import org.valkyrienskies.core.impl.shadow.cv_2;
import org.valkyrienskies.core.impl.shadow.da_2;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dg_2;
import org.valkyrienskies.core.impl.shadow.di_2;
import org.valkyrienskies.core.impl.shadow.dj_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.bR
 */
public class br_1
extends bt_1
implements cv_2 {
    private static final Logger g = LoggerFactory.getLogger(cs_1.class);
    private static final String i = "Remaining validation messages report why candidate schemas didn't match";
    private static final String j = "and the discriminator-selected candidate schema didn't pass validation";
    private final List<cp_2> k = new ArrayList<cp_2>();
    private final df_2.a l;

    public br_1(String string, JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
        super(string, jsonNode, cp_22, dj_2.ANY_OF, df_22);
        this.d = df_22;
        int n2 = jsonNode.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.k.add(new cp_2(df_22, this.e().a(), cp_22.i(), jsonNode.get(i2), cp_22));
        }
        if (this.d.d().m()) {
            this.l = new df_2.a();
            return;
        }
        this.l = null;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode jsonNode2, String string) {
        this.a(g, jsonNode, jsonNode2, string);
        di_2 di_22 = (di_2)bv_1.a().a("com.networknt.schema.ValidatorState");
        if (this.d.d().m()) {
            this.d.a(this.l, string);
        }
        Object object = new LinkedHashSet();
        String string2 = "anyOf/type";
        Object object2 = bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties");
        bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", new ArrayList());
        try {
            int n2 = 0;
            for (cp_2 cp_22 : this.k) {
                void var10_15;
                da_2 da_22;
                new HashSet();
                if (cp_22.n().containsKey(string2) && (da_22 = (da_2)cp_22.n().get(string2)).h() != cu_2.UNION && !da_22.b(jsonNode)) {
                    object.add(this.a(string, da_22.h().toString()));
                    continue;
                }
                if (!di_22.c()) {
                    Set<dg_2> set = cp_22.a(jsonNode, jsonNode2, string);
                } else {
                    Set<dg_2> set = ((bt_1)cp_22).a(jsonNode, jsonNode2, string, true);
                }
                if (var10_15.isEmpty()) {
                    if (!di_22.a()) continue;
                    ++n2;
                }
                if (var10_15.isEmpty() && !this.d.d().m()) {
                    object.clear();
                    da_22 = var10_15;
                    return da_22;
                }
                if (this.d.d().m() && this.l.b()) {
                    if (!var10_15.isEmpty()) {
                        var10_15.add(this.a(string, j));
                        object.addAll(var10_15);
                    } else {
                        object.clear();
                    }
                    da_22 = var10_15;
                    return da_22;
                }
                object.addAll(var10_15);
            }
            Set set = object.stream().filter(dg_22 -> !dj_2.REQUIRED.a().equals(dg_22.g())).collect(Collectors.toSet());
            if (n2 > 0 && set.isEmpty()) {
                object = set;
            }
            if (this.d.d().m() && this.l.c()) {
                HashSet<dg_2> hashSet = new HashSet<dg_2>();
                hashSet.add(this.a(string, "based on the provided discriminator. No alternative could be chosen based on the discriminator property"));
                Set<dg_2> set2 = Collections.unmodifiableSet(hashSet);
                return set2;
            }
        }
        finally {
            if (this.d.d().m()) {
                this.d.b(string);
            }
            if (object.isEmpty()) {
                this.a(object2);
            } else {
                bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", object2);
            }
        }
        return Collections.unmodifiableSet(object);
    }

    private void a(Object list) {
        list = list == null ? new ArrayList() : (List)list;
        list.addAll((List)bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties"));
        bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", list);
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode jsonNode2, String string, boolean bl) {
        if (bl) {
            return this.a(jsonNode, jsonNode2, string);
        }
        for (cp_2 cp_22 : this.k) {
            ((bt_1)cp_22).a(jsonNode, jsonNode2, string, false);
        }
        return new LinkedHashSet<dg_2>();
    }

    @Override
    public void a_() {
        br_1 br_12 = this;
        br_12.a(br_12.k);
    }
}

