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
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
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
 * Renamed from org.valkyrienskies.core.impl.shadow.ca
 */
public class ca_2
extends bt_1
implements cv_2 {
    private static final Logger g = LoggerFactory.getLogger(ca_2.class);
    private final Map<String, List<String>> i = new HashMap<String, List<String>>();
    private final Map<String, cp_2> j = new HashMap<String, cp_2>();

    public ca_2(String object, JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
        super((String)object, jsonNode, cp_22, dj_2.DEPENDENCIES, df_22);
        object = jsonNode.fieldNames();
        while (object.hasNext()) {
            String string = (String)object.next();
            JsonNode jsonNode2 = jsonNode.get(string);
            if (jsonNode2.isArray()) {
                List<String> list = this.i.get(string);
                if (list == null) {
                    list = new ArrayList<String>();
                    this.i.put(string, list);
                }
                for (int i2 = 0; i2 < jsonNode2.size(); ++i2) {
                    list.add(jsonNode2.get(i2).asText());
                }
                continue;
            }
            if (!jsonNode2.isObject() && !jsonNode2.isBoolean()) continue;
            this.j.put(string, new cp_2(df_22, string, cp_22.i(), jsonNode2, cp_22));
        }
        ca_2 ca_22 = this;
        ca_22.a(ca_22.e().d());
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode jsonNode2, String string) {
        this.a(g, jsonNode, jsonNode2, string);
        LinkedHashSet<dg_2> linkedHashSet = new LinkedHashSet<dg_2>();
        Iterator<String> iterator2 = jsonNode.fieldNames();
        while (iterator2.hasNext()) {
            String string2 = iterator2.next();
            List<String> list = this.i.get(string2);
            if (list != null && !list.isEmpty()) {
                list = list.iterator();
                while (list.hasNext()) {
                    String string3 = (String)list.next();
                    if (jsonNode.get(string3) != null) continue;
                    linkedHashSet.add(this.a(string, this.i.toString()));
                }
            }
            if ((list = this.j.get(string2)) == null) continue;
            linkedHashSet.addAll(((cp_2)((Object)list)).a(jsonNode, jsonNode2, string));
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    @Override
    public void a_() {
        ca_2 ca_22 = this;
        ca_22.a(ca_22.j.values());
    }
}

