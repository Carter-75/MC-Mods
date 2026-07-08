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
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.valkyrienskies.core.impl.shadow.bt_1;
import org.valkyrienskies.core.impl.shadow.bv_1;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.cs_1;
import org.valkyrienskies.core.impl.shadow.cv_2;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dg_2;
import org.valkyrienskies.core.impl.shadow.dj_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.cI
 */
public class ci_1
extends bt_1
implements cv_2 {
    private static final Logger g = LoggerFactory.getLogger(cs_1.class);
    private final cp_2 i;

    public ci_1(String string, JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
        super(string, jsonNode, cp_22, dj_2.NOT, df_22);
        this.i = new cp_2(df_22, this.e().a(), cp_22.i(), jsonNode, cp_22);
        ci_1 ci_12 = this;
        ci_12.a(ci_12.e().d());
    }

    @Override
    public Set<dg_2> a(JsonNode iterable, JsonNode iterable2, String string) {
        block9: {
            Object object;
            block7: {
                Set<Object> set;
                block5: {
                    block8: {
                        block6: {
                            set = new HashSet();
                            object = bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties");
                            bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", new ArrayList());
                            try {
                                this.a(g, (JsonNode)iterable, (JsonNode)iterable2, string);
                                set = this.i.a((JsonNode)iterable, (JsonNode)iterable2, string);
                                if (!set.isEmpty()) break block5;
                                iterable = Collections.singleton(this.a(string, this.i.toString()));
                                if (!set.isEmpty()) break block6;
                                iterable2 = object == null ? new ArrayList() : (List)object;
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
                            iterable2.addAll((List)bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties"));
                            bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", iterable2);
                            break block8;
                        }
                        bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", object);
                    }
                    return iterable;
                }
                iterable = Collections.emptySet();
                if (!set.isEmpty()) break block7;
                iterable2 = object == null ? new ArrayList() : (List)object;
                iterable2.addAll((List)bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties"));
                bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", iterable2);
                break block9;
            }
            bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", object);
        }
        return iterable;
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode jsonNode2, String string, boolean bl) {
        if (bl) {
            return this.a(jsonNode, jsonNode2, string);
        }
        return ((bt_1)this.i).a(jsonNode, jsonNode2, string, bl);
    }

    @Override
    public void a_() {
        if (this.i != null) {
            this.i.o();
        }
    }
}

