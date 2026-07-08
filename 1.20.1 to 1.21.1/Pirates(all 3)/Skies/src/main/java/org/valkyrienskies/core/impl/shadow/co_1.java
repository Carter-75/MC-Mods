/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
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
import org.valkyrienskies.core.impl.shadow.dj_1;
import org.valkyrienskies.core.impl.shadow.dj_2;
import org.valkyrienskies.core.impl.shadow.do_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.cO
 */
public class co_1
extends bt_1
implements cv_2 {
    public static final String g = "properties";
    private static final Logger i = LoggerFactory.getLogger(co_1.class);
    private final Map<String, cp_2> j = new HashMap<String, cp_2>();

    public co_1(String string, JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
        super(string, jsonNode, cp_22, dj_2.PROPERTIES, df_22);
        this.d = df_22;
        Iterator<String> iterator2 = jsonNode.fieldNames();
        while (iterator2.hasNext()) {
            String string2 = iterator2.next();
            this.j.put(string2, new cp_2(df_22, string + "/" + string2, cp_22.i(), jsonNode.get(string2), cp_22));
        }
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode jsonNode2, String string) {
        this.a(i, jsonNode, jsonNode2, string);
        dj_1 dj_12 = new dj_1(this.d.d().h());
        LinkedHashSet<dg_2> linkedHashSet = new LinkedHashSet<dg_2>();
        di_2 di_22 = (di_2)bv_1.a().a("com.networknt.schema.ValidatorState");
        for (Map.Entry<String, cp_2> entry : this.j.entrySet()) {
            Set<dg_2> set;
            cp_2 cp_22 = entry.getValue();
            JsonNode jsonNode3 = jsonNode.get(entry.getKey());
            if (jsonNode3 != null) {
                this.b(string + "." + entry.getKey());
                boolean bl = di_22.b();
                if (di_22.b()) {
                    di_22.a(true);
                }
                di_22.b(false);
                if (!di_22.c()) {
                    linkedHashSet.addAll(cp_22.a(jsonNode3, jsonNode2, string + "." + entry.getKey()));
                } else {
                    this.a(entry, jsonNode, jsonNode2, string, di_22.d(), linkedHashSet, dj_12);
                }
                di_22.b(bl);
                if (!di_22.b()) continue;
                di_22.a(true);
                continue;
            }
            if (!this.d().l() || (set = this.d().m().a(jsonNode, jsonNode2, string)).isEmpty()) continue;
            if (di_22.b()) {
                di_22.a(false);
                return Collections.unmodifiableSet(new LinkedHashSet());
            }
            linkedHashSet.addAll(set);
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    private void b(String string) {
        ArrayList<String> arrayList = bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties");
        if (arrayList == null) {
            arrayList = new ArrayList<String>();
            bv_1.a().a("com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties", arrayList);
        } else {
            arrayList = arrayList;
        }
        arrayList.add(string);
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode jsonNode2, String string, boolean bl) {
        LinkedHashSet<dg_2> linkedHashSet = new LinkedHashSet<dg_2>();
        if (this.f.a() && jsonNode.getNodeType() == JsonNodeType.OBJECT) {
            this.a((ObjectNode)jsonNode);
        }
        if (bl) {
            linkedHashSet.addAll(this.a(jsonNode, jsonNode2, string));
        } else {
            dj_1 dj_12 = new dj_1(this.d.d().h());
            for (Map.Entry<String, cp_2> entry : this.j.entrySet()) {
                this.a(entry, jsonNode, jsonNode2, string, bl, linkedHashSet, dj_12);
            }
        }
        return linkedHashSet;
    }

    private void a(ObjectNode objectNode) {
        for (Map.Entry<String, cp_2> entry : this.j.entrySet()) {
            boolean bl;
            JsonNode jsonNode = ((JsonNode)objectNode).get(entry.getKey());
            JsonNode jsonNode2 = this.a(entry);
            if (jsonNode2 == null || !(bl = jsonNode == null || jsonNode.isNull() && this.f.b())) continue;
            objectNode.set(entry.getKey(), jsonNode2);
        }
    }

    private JsonNode a(Map.Entry<String, cp_2> object) {
        object = object.getValue();
        return ((bt_1)object).c().get("default");
    }

    private void a(Map.Entry<String, cp_2> entry, JsonNode jsonNode, JsonNode jsonNode2, String string, boolean bl, Set<dg_2> set, do_1 do_12) {
        cp_2 cp_22 = entry.getValue();
        jsonNode = jsonNode == null ? null : jsonNode.get(entry.getKey());
        boolean bl2 = do_12.b(dj_2.PROPERTIES.a(), jsonNode, jsonNode2, string + "." + entry.getKey(), cp_22.b(), cp_22.c(), cp_22.d(), this.d, this.d.c());
        if (bl2) {
            set.addAll(((bt_1)cp_22).a(jsonNode, jsonNode2, string + "." + entry.getKey(), bl));
        }
        do_12.a(dj_2.PROPERTIES.a(), jsonNode, jsonNode2, string + "." + entry.getKey(), cp_22.b(), cp_22.c(), cp_22.d(), this.d, this.d.c(), set);
    }

    public Map<String, cp_2> h() {
        return this.j;
    }

    @Override
    public void a_() {
        co_1 co_12 = this;
        co_12.a(co_12.j.values());
    }
}

