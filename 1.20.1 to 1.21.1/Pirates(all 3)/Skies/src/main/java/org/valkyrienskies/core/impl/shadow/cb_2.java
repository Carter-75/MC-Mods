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
 * Renamed from org.valkyrienskies.core.impl.shadow.cb
 */
public class cb_2
extends bt_1
implements cv_2 {
    private static final Logger g = LoggerFactory.getLogger(cb_2.class);
    private final Map<String, List<String>> i = new HashMap<String, List<String>>();

    public cb_2(String object, JsonNode jsonNode, cp_2 object2, df_2 object3) {
        super((String)object, jsonNode, (cp_2)object2, dj_2.DEPENDENT_REQUIRED, (df_2)object3);
        object = jsonNode.fieldNames();
        while (object.hasNext()) {
            object2 = (String)object.next();
            object3 = jsonNode.get((String)object2);
            if (!((JsonNode)object3).isArray()) continue;
            object2 = this.i.computeIfAbsent((String)object2, string -> new ArrayList());
            for (int i2 = 0; i2 < ((JsonNode)object3).size(); ++i2) {
                object2.add(((JsonNode)object3).get(i2).asText());
            }
        }
        cb_2 cb_22 = this;
        cb_22.a(cb_22.e().d());
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode iterable, String string) {
        this.a(g, jsonNode, (JsonNode)iterable, string);
        iterable = new LinkedHashSet();
        Iterator<String> iterator2 = jsonNode.fieldNames();
        while (iterator2.hasNext()) {
            Iterator iterator3 = iterator2.next();
            if ((iterator3 = this.i.get(iterator3)) == null || iterator3.isEmpty()) continue;
            iterator3 = iterator3.iterator();
            while (iterator3.hasNext()) {
                String string2 = (String)iterator3.next();
                if (jsonNode.get(string2) != null) continue;
                iterable.add(this.a(string, this.i.toString()));
            }
        }
        return Collections.unmodifiableSet(iterable);
    }
}

