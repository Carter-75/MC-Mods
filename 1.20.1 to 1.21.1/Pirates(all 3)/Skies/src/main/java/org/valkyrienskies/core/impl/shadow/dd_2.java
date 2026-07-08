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
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.valkyrienskies.core.impl.shadow.bt_1;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.cq_2;
import org.valkyrienskies.core.impl.shadow.cu_2;
import org.valkyrienskies.core.impl.shadow.cv_2;
import org.valkyrienskies.core.impl.shadow.cz_1;
import org.valkyrienskies.core.impl.shadow.da_2;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dg_2;
import org.valkyrienskies.core.impl.shadow.dj_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.dd
 */
public class dd_2
extends bt_1
implements cv_2 {
    private static final Logger g = LoggerFactory.getLogger(dd_2.class);
    private final List<cv_2> i = new ArrayList<cv_2>();
    private final String j;

    public dd_2(String string, JsonNode object, cp_2 cp_22, df_2 df_22) {
        super(string, (JsonNode)object, cp_22, dj_2.UNION_TYPE, df_22);
        this.d = df_22;
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "";
        stringBuilder.append('[');
        if (!((JsonNode)object).isArray()) {
            throw new cq_2("Expected array for type property on Union Type Definition.");
        }
        int n2 = 0;
        object = ((JsonNode)object).iterator();
        while (object.hasNext()) {
            JsonNode jsonNode = (JsonNode)object.next();
            cu_2 cu_22 = cz_1.a(jsonNode);
            stringBuilder.append(string2).append((Object)cu_22);
            string2 = ", ";
            if (jsonNode.isObject()) {
                this.i.add(new cp_2(df_22, dj_2.TYPE.a(), cp_22.i(), jsonNode, cp_22));
            } else {
                this.i.add(new da_2(string + "/" + n2, jsonNode, cp_22, df_22));
            }
            ++n2;
        }
        stringBuilder.append(']');
        this.j = stringBuilder.toString();
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode jsonNode2, String string) {
        this.a(g, jsonNode, jsonNode2, string);
        cu_2 cu_22 = cz_1.a(jsonNode, this.d.d());
        boolean bl = false;
        for (cv_2 cv_22 : this.i) {
            Set<dg_2> object = cv_22.a(jsonNode, jsonNode2, string);
            if (object != null && !object.isEmpty()) continue;
            bl = true;
            break;
        }
        if (!bl) {
            return Collections.singleton(this.a(string, cu_22.toString(), this.j));
        }
        return Collections.emptySet();
    }

    @Override
    public void a_() {
        for (cv_2 cv_22 : this.i) {
            cv_22.a_();
        }
    }
}

