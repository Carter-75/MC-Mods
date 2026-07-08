/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.valkyrienskies.core.impl.shadow.bt_1;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.cv_2;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dg_2;
import org.valkyrienskies.core.impl.shadow.dj_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.cc
 */
public class cc_2
extends bt_1
implements cv_2 {
    private static final Logger g = LoggerFactory.getLogger(cc_2.class);
    private final Map<String, cp_2> i = new HashMap<String, cp_2>();

    public cc_2(String object, JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
        super((String)object, jsonNode, cp_22, dj_2.DEPENDENT_SCHEMAS, df_22);
        object = jsonNode.fieldNames();
        while (object.hasNext()) {
            String string = (String)object.next();
            JsonNode jsonNode2 = jsonNode.get(string);
            if (!jsonNode2.isObject() && !jsonNode2.isBoolean()) continue;
            this.i.put(string, new cp_2(df_22, string, cp_22.i(), jsonNode2, cp_22));
        }
        cc_2 cc_22 = this;
        cc_22.a(cc_22.e().d());
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode jsonNode2, String string) {
        this.a(g, jsonNode, jsonNode2, string);
        LinkedHashSet<dg_2> linkedHashSet = new LinkedHashSet<dg_2>();
        Iterator<String> iterator2 = jsonNode.fieldNames();
        while (iterator2.hasNext()) {
            Object object = iterator2.next();
            if ((object = this.i.get(object)) == null) continue;
            linkedHashSet.addAll(((cp_2)object).a(jsonNode, jsonNode2, string));
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    @Override
    public void a_() {
        cc_2 cc_22 = this;
        cc_22.a(cc_22.i.values());
    }
}

