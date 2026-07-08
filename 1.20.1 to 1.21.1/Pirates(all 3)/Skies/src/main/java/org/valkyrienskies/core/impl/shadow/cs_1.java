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
import org.valkyrienskies.core.impl.shadow.cv_2;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dg_2;
import org.valkyrienskies.core.impl.shadow.dj_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.cS
 */
public class cs_1
extends bt_1
implements cv_2 {
    private static final Logger g = LoggerFactory.getLogger(cs_1.class);
    private List<String> i = new ArrayList<String>();

    public cs_1(String object, JsonNode jsonNode2, cp_2 cp_22, df_2 df_22) {
        super((String)object, jsonNode2, cp_22, dj_2.REQUIRED, df_22);
        if (jsonNode2.isArray()) {
            for (JsonNode jsonNode2 : jsonNode2) {
                this.i.add(jsonNode2.asText());
            }
        }
        cs_1 cs_12 = this;
        cs_12.a(cs_12.e().d());
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode iterable, String string) {
        this.a(g, jsonNode, (JsonNode)iterable, string);
        if (!jsonNode.isObject()) {
            return Collections.emptySet();
        }
        iterable = new LinkedHashSet();
        for (String string2 : this.i) {
            JsonNode jsonNode2 = jsonNode.get(string2);
            if (jsonNode2 != null) continue;
            iterable.add(this.a(string, string2));
        }
        return Collections.unmodifiableSet(iterable);
    }
}

