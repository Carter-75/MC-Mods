/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.valkyrienskies.core.impl.shadow.bt_1;
import org.valkyrienskies.core.impl.shadow.bv_1;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.cv_2;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dg_2;
import org.valkyrienskies.core.impl.shadow.di_2;
import org.valkyrienskies.core.impl.shadow.dj_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.bQ
 */
public class bq_1
extends bt_1
implements cv_2 {
    private static final Logger g = LoggerFactory.getLogger(bq_1.class);
    private final List<cp_2> i = new ArrayList<cp_2>();

    public bq_1(String string, JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
        super(string, jsonNode, cp_22, dj_2.ALL_OF, df_22);
        this.d = df_22;
        int n2 = jsonNode.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.i.add(new cp_2(df_22, this.e().a(), cp_22.i(), jsonNode.get(i2), cp_22));
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode iterable, String string) {
        this.a(g, jsonNode, (JsonNode)iterable, string);
        di_2 di_22 = (di_2)bv_1.a().a("com.networknt.schema.ValidatorState");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Object object = bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties");
        ArrayList arrayList = new ArrayList();
        for (cp_2 cp_22 : this.i) {
            block10: {
                List list;
                try {
                    void var9_14;
                    bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", new ArrayList());
                    new HashSet();
                    if (!di_22.c()) {
                        Set<dg_2> set = cp_22.a(jsonNode, (JsonNode)iterable, string);
                    } else {
                        Set<dg_2> set = ((bt_1)cp_22).a(jsonNode, (JsonNode)iterable, string, true);
                    }
                    linkedHashSet.addAll(var9_14);
                    if (var9_14.isEmpty()) {
                        arrayList.addAll((List)bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties"));
                    }
                    if (this.d.d().m()) {
                        Iterator<JsonNode> iterator2 = this.b.elements();
                        while (iterator2.hasNext()) {
                            ObjectNode objectNode = (ObjectNode)iterator2.next();
                            Object object2 = ((JsonNode)objectNode).get("$ref");
                            if (object2 == null || (object2 = this.d.e()) == null || (objectNode = ((df_2.a)object2).a(((JsonNode)objectNode).get("$ref").asText())) == null) continue;
                            bq_1.a((df_2.a)object2, objectNode, this.c, string);
                            Object object3 = ((JsonNode)objectNode).get("propertyName").asText();
                            object3 = jsonNode.get((String)object3);
                            object3 = object3 == null ? null : ((JsonNode)object3).textValue();
                            cp_2 cp_23 = this.c;
                            bq_1.a((df_2.a)object2, objectNode, (String)object3, cp_23);
                        }
                    }
                    if (!linkedHashSet.isEmpty()) break block10;
                    list = object == null ? new ArrayList() : (List)object;
                }
                catch (Throwable throwable) {
                    if (linkedHashSet.isEmpty()) {
                        iterable = object == null ? new ArrayList() : (List)object;
                        iterable.addAll(arrayList);
                        bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", iterable);
                    } else {
                        bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", object);
                    }
                    throw throwable;
                }
                list.addAll(arrayList);
                bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", list);
                continue;
            }
            bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", object);
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode jsonNode2, String string, boolean bl) {
        if (bl) {
            return this.a(jsonNode, jsonNode2, string);
        }
        for (cp_2 cp_22 : this.i) {
            ((bt_1)cp_22).a(jsonNode, jsonNode2, string, false);
        }
        return Collections.emptySet();
    }

    @Override
    public void a_() {
        bq_1 bq_12 = this;
        bq_12.a(bq_12.i);
    }
}

