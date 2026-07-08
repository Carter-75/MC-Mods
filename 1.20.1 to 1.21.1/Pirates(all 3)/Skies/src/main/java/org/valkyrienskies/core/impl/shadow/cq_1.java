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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.valkyrienskies.core.impl.shadow.bt_1;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.cs_1;
import org.valkyrienskies.core.impl.shadow.cv_2;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dg_2;
import org.valkyrienskies.core.impl.shadow.dj_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.cQ
 */
public class cq_1
extends bt_1
implements cv_2 {
    private static final Logger g = LoggerFactory.getLogger(cs_1.class);
    private List<String> i = new ArrayList<String>();

    public cq_1(String string, JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
        super(string, jsonNode, cp_22, dj_2.READ_ONLY, df_22);
        if (jsonNode.isArray()) {
            int n2 = jsonNode.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                this.i.add(jsonNode.get(i2).asText());
            }
        }
        cq_1 cq_12 = this;
        cq_12.a(cq_12.e().d());
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode jsonNode2, String string) {
        this.a(g, jsonNode, jsonNode2, string);
        LinkedHashSet<dg_2> linkedHashSet = new LinkedHashSet<dg_2>();
        for (String object : this.i) {
            JsonNode jsonNode3 = jsonNode.get(object);
            String string2 = "";
            string2 = string.equals("$") ? string2 + "#original." + object : string2 + "#original." + string.substring(2) + "." + object;
            JsonNode jsonNode4 = this.a(string2, jsonNode2);
            boolean bl = jsonNode3 != null && jsonNode4 != null && jsonNode3.equals(jsonNode4);
            if (bl) continue;
            linkedHashSet.add(this.a(string, new String[0]));
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    private JsonNode a(String stringArray, JsonNode jsonNode) {
        stringArray = this.a((String)stringArray, "$.");
        stringArray = stringArray.split("\\.");
        JsonNode jsonNode2 = null;
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            if (stringArray[i2].contains("[")) {
                int n2 = stringArray[i2].indexOf("[");
                int n3 = stringArray[i2].indexOf("]");
                String string = stringArray[i2].substring(0, n2).trim();
                n2 = Integer.parseInt(stringArray[i2].substring(n2 + 1, n3).trim());
                jsonNode2 = jsonNode.get(string).get(n2);
            } else {
                jsonNode2 = jsonNode.get(stringArray[i2]);
            }
            if (jsonNode2 == null) break;
            jsonNode = jsonNode2;
        }
        return jsonNode2;
    }

    private String a(String string, String string2) {
        if (string.startsWith(string2)) {
            string = string.substring(2);
        }
        return string;
    }
}

