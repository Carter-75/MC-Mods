/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import java.net.URI;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.valkyrienskies.core.impl.shadow.bt_1;
import org.valkyrienskies.core.impl.shadow.bv_1;
import org.valkyrienskies.core.impl.shadow.by_1;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.cq_2;
import org.valkyrienskies.core.impl.shadow.cs_2;
import org.valkyrienskies.core.impl.shadow.cv_2;
import org.valkyrienskies.core.impl.shadow.dd_1;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dg_2;
import org.valkyrienskies.core.impl.shadow.dj_2;
import org.valkyrienskies.core.impl.shadow.dx_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.cR
 */
public class cr_1
extends bt_1
implements cv_2 {
    private static final Logger i = LoggerFactory.getLogger(cr_1.class);
    protected cs_2 g;
    private cp_2 j;
    private static final String k = "#";

    public cr_1(String string, JsonNode object, cp_2 cp_22, df_2 df_22) {
        super(string, (JsonNode)object, cp_22, dj_2.REF, df_22);
        object = ((JsonNode)object).asText();
        this.j = cp_22;
        this.g = cr_1.a(cp_22, df_22, (String)object);
        if (this.g == null) {
            String string2 = string;
            throw new cq_2(dg_2.a(dj_2.REF.a(), by_1.a("internal.unresolvedRef", new MessageFormat("{0}: Reference {1} cannot be resolved")), string2, string2, new String[]{object}));
        }
    }

    static cs_2 a(cp_2 object, df_2 df_22, String string) {
        Object object2;
        String string2 = string;
        if (!string.startsWith(k)) {
            int n2 = string.indexOf(k);
            object2 = n2 > 0 ? string.substring(0, n2) : string;
            object = cr_1.a(df_22.a(), (cp_2)object, (String)object2);
            if (object == null) {
                if (df_22.b() == null) {
                    return null;
                }
                object = cr_1.a(df_22.b(), (String)object2);
                if (object == null) {
                    return null;
                }
            }
            object = df_22.c().a((URI)object, df_22.d());
            if (n2 < 0) {
                return new cs_2(((cp_2)object).j());
            }
            string = string.substring(n2);
        }
        if (string.equals(k)) {
            return new cs_2(((cp_2)object).j());
        }
        object2 = ((cp_2)object).b(string);
        if (object2 != null) {
            cs_2 cs_22 = df_22.a(string2);
            if (cs_22 == null) {
                object = new cp_2(df_22, string, ((cp_2)object).i(), (JsonNode)object2, (cp_2)object);
                cs_22 = new cs_2((cp_2)object);
                df_22.a(string2, cs_22);
            }
            return cs_22;
        }
        return null;
    }

    private static URI a(dx_2 object, cp_2 object2, String string) {
        object2 = ((cp_2)object2).i();
        try {
            object = object2 == null ? object.a(string) : object.a((URI)object2, string);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            object = null;
        }
        return object;
    }

    private static URI a(dd_1 object, String string) {
        try {
            object = object.a(string);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            object = null;
        }
        return object;
    }

    @Override
    public Set<dg_2> a(JsonNode iterable, JsonNode iterable2, String string) {
        Set<Object> set;
        block5: {
            Object object;
            block4: {
                set = new HashSet();
                object = bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties");
                bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", new ArrayList());
                try {
                    this.a(i, (JsonNode)iterable, (JsonNode)iterable2, string);
                    this.g.a().h().a(this.j.h().d());
                    set = this.g != null ? this.g.a((JsonNode)iterable, (JsonNode)iterable2, string) : Collections.emptySet();
                    if (!set.isEmpty()) break block4;
                    iterable = object == null ? new ArrayList() : (List)object;
                }
                catch (Throwable throwable) {
                    if (set.isEmpty()) {
                        iterable2 = object == null ? new ArrayList() : (List)object;
                        iterable2.addAll((List)bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties"));
                        bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", iterable2);
                    } else {
                        bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", object);
                    }
                    throw throwable;
                }
                iterable.addAll((List)bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties"));
                bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", iterable);
                break block5;
            }
            bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", object);
        }
        return set;
    }

    @Override
    public Set<dg_2> a(JsonNode iterable, JsonNode iterable2, String string, boolean bl) {
        block6: {
            Object object;
            block7: {
                Set<Object> set = new HashSet();
                object = bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties");
                bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", new ArrayList());
                try {
                    this.a(i, (JsonNode)iterable, (JsonNode)iterable2, string);
                    this.g.a().h().a(this.j.h().d());
                    if (this.g != null) {
                        set = this.g.a((JsonNode)iterable, (JsonNode)iterable2, string, bl);
                    }
                    iterable = set;
                    if (!bl) break block6;
                    if (!set.isEmpty()) break block7;
                    iterable2 = object == null ? new ArrayList() : (List)object;
                }
                catch (Throwable throwable) {
                    if (bl) {
                        if (set.isEmpty()) {
                            iterable2 = object == null ? new ArrayList() : (List)object;
                            iterable2.addAll((List)bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties"));
                            bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", iterable2);
                        } else {
                            bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", object);
                        }
                    }
                    throw throwable;
                }
                iterable2.addAll((List)bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties"));
                bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", iterable2);
                break block6;
            }
            bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", object);
        }
        return iterable;
    }

    public cs_2 h() {
        return this.g;
    }

    @Override
    public void a_() {
        this.g.a().o();
    }
}

