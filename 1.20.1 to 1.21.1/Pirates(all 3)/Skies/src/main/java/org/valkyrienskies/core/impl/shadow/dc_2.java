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
import java.util.Iterator;
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
import org.valkyrienskies.core.impl.shadow.dj_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.dc
 */
public class dc_2
extends bt_1
implements cv_2 {
    private static final Logger j = LoggerFactory.getLogger(dc_2.class);
    public static final String g = "com.networknt.schema.UnEvaluatedPropertiesValidator.EvaluatedProperties";
    public static final String i = "com.networknt.schema.UnEvaluatedPropertiesValidator.UnevaluatedProperties";
    private JsonNode k = null;

    public dc_2(String string, JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
        super(string, jsonNode, cp_22, dj_2.UNEVALUATED_PROPERTIES, df_22);
        this.k = jsonNode;
    }

    @Override
    public Set<dg_2> a(JsonNode iterable, JsonNode jsonNode, String string) {
        if (!this.k.isBoolean()) {
            return Collections.emptySet();
        }
        boolean bl = this.k.booleanValue();
        ArrayList<String> arrayList = new ArrayList<String>();
        this.a((JsonNode)iterable, string, (List<String>)arrayList);
        if (!bl) {
            iterable = this.a((List<String>)arrayList);
            if (!iterable.isEmpty()) {
                bv_1.a().a(i, iterable);
                return Collections.singleton(this.a(String.join((CharSequence)", ", iterable), new String[0]));
            }
        } else {
            bv_1.a().a(g, arrayList);
        }
        return Collections.emptySet();
    }

    private List<String> a(List<String> list) {
        ArrayList<String> arrayList = new ArrayList<String>();
        Object object = bv_1.a().a(g);
        if (object != null) {
            object = (List)object;
            list.forEach(arg_0 -> dc_2.a((List)object, arrayList, arg_0));
        } else {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    public void a(JsonNode jsonNode, String string, List<String> list) {
        Iterator<String> iterator2 = jsonNode.fieldNames();
        while (iterator2.hasNext()) {
            String string2 = iterator2.next();
            JsonNode jsonNode2 = jsonNode.get(string2);
            if (jsonNode2.isObject()) {
                this.a(jsonNode2, string + "." + string2, list);
            }
            list.add(string + "." + string2);
        }
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode jsonNode2, String string, boolean bl) {
        if (bl) {
            return this.a(jsonNode, jsonNode2, string);
        }
        return Collections.emptySet();
    }

    private static /* synthetic */ void a(List list, List list2, String string) {
        if (!list.contains(string)) {
            list2.add(string);
        }
    }
}

