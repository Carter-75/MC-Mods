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
 * Renamed from org.valkyrienskies.core.impl.shadow.cH
 */
public class ch_1
extends bt_1
implements cv_2 {
    private static final Logger g = LoggerFactory.getLogger(ch_1.class);
    private List<String> i = new ArrayList<String>();

    public ch_1(String string, JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
        super(string, jsonNode, cp_22, dj_2.NOT_ALLOWED, df_22);
        if (jsonNode.isArray()) {
            int n2 = jsonNode.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                this.i.add(jsonNode.get(i2).asText());
            }
        }
        ch_1 ch_12 = this;
        ch_12.a(ch_12.e().d());
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode iterable, String string) {
        this.a(g, jsonNode, (JsonNode)iterable, string);
        iterable = new LinkedHashSet();
        for (String string2 : this.i) {
            JsonNode jsonNode2 = jsonNode.get(string2);
            if (jsonNode2 == null) continue;
            iterable.add(this.a(string, string2));
        }
        return Collections.unmodifiableSet(iterable);
    }
}

