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
import java.util.HashSet;
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
 * Renamed from org.valkyrienskies.core.impl.shadow.de
 */
public class de_2
extends bt_1
implements cv_2 {
    private static final Logger g = LoggerFactory.getLogger(de_2.class);
    private boolean i = false;

    public de_2(String string, JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
        super(string, jsonNode, cp_22, dj_2.UNIQUE_ITEMS, df_22);
        if (jsonNode.isBoolean()) {
            this.i = jsonNode.booleanValue();
        }
        de_2 de_22 = this;
        de_22.a(de_22.e().d());
    }

    @Override
    public Set<dg_2> a(JsonNode object, JsonNode iterable, String string) {
        this.a(g, (JsonNode)object, (JsonNode)iterable, string);
        if (this.i) {
            iterable = new HashSet();
            object = ((JsonNode)object).iterator();
            while (object.hasNext()) {
                JsonNode jsonNode = (JsonNode)object.next();
                if (iterable.add(jsonNode)) continue;
                return Collections.singleton(this.a(string, new String[0]));
            }
        }
        return Collections.emptySet();
    }
}

