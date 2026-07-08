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
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.valkyrienskies.core.impl.shadow.bt_1;
import org.valkyrienskies.core.impl.shadow.bv_1;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.cq_2;
import org.valkyrienskies.core.impl.shadow.cv_2;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dg_2;
import org.valkyrienskies.core.impl.shadow.dj_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.cL
 */
public class cl_1
extends bt_1
implements cv_2 {
    public static final String g = "patternProperties";
    private static final Logger i = LoggerFactory.getLogger(cl_1.class);
    private final Map<Pattern, cp_2> j = new IdentityHashMap<Pattern, cp_2>();

    public cl_1(String object, JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
        super((String)object, jsonNode, cp_22, dj_2.PATTERN_PROPERTIES, df_22);
        if (!jsonNode.isObject()) {
            throw new cq_2("patternProperties must be an object node");
        }
        object = jsonNode.fieldNames();
        while (object.hasNext()) {
            String string = (String)object.next();
            this.j.put(Pattern.compile(string), new cp_2(df_22, string, cp_22.i(), jsonNode.get(string), cp_22));
        }
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode jsonNode2, String string) {
        this.a(i, jsonNode, jsonNode2, string);
        LinkedHashSet<dg_2> linkedHashSet = new LinkedHashSet<dg_2>();
        if (!jsonNode.isObject()) {
            return linkedHashSet;
        }
        Iterator<String> iterator2 = jsonNode.fieldNames();
        while (iterator2.hasNext()) {
            String string2 = iterator2.next();
            JsonNode jsonNode3 = jsonNode.get(string2);
            for (Map.Entry<Pattern, cp_2> entry : this.j.entrySet()) {
                Matcher matcher = entry.getKey().matcher(string2);
                if (!matcher.find()) continue;
                this.b(string + "." + string2);
                linkedHashSet.addAll(entry.getValue().a(jsonNode3, jsonNode2, string + "." + string2));
            }
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    @Override
    public void a_() {
        cl_1 cl_12 = this;
        cl_12.a(cl_12.j.values());
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
}

