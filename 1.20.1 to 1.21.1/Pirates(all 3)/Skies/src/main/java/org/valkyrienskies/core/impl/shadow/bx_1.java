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
 * Renamed from org.valkyrienskies.core.impl.shadow.bX
 */
public class bx_1
extends bt_1
implements cv_2 {
    private static final Logger g = LoggerFactory.getLogger(bx_1.class);
    private final cp_2 i;

    public bx_1(String string, JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
        super(string, jsonNode, cp_22, dj_2.CONTAINS, df_22);
        this.i = jsonNode.isObject() || jsonNode.isBoolean() ? new cp_2(df_22, this.e().a(), cp_22.i(), jsonNode, cp_22) : null;
        bx_1 bx_12 = this;
        bx_12.a(bx_12.e().d());
    }

    @Override
    public Set<dg_2> a(JsonNode object, JsonNode jsonNode, String string) {
        this.a(g, (JsonNode)object, jsonNode, string);
        if (!((JsonNode)object).isArray()) {
            return Collections.emptySet();
        }
        if (((JsonNode)object).size() == 0) {
            return this.b(string);
        }
        if (((JsonNode)object).isArray()) {
            int n2 = 0;
            object = ((JsonNode)object).iterator();
            while (object.hasNext()) {
                JsonNode jsonNode2 = (JsonNode)object.next();
                if (this.i.a(jsonNode2, jsonNode, string + "[" + n2 + "]").isEmpty()) {
                    return Collections.emptySet();
                }
                ++n2;
            }
            return this.b(string);
        }
        return Collections.emptySet();
    }

    private Set<dg_2> b(String string) {
        return Collections.singleton(this.a(string, this.i.c().toString()));
    }

    @Override
    public void a_() {
        if (this.i != null) {
            this.i.o();
        }
    }
}

