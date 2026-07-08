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
 * Renamed from org.valkyrienskies.core.impl.shadow.cB
 */
public class cb_1
extends bt_1
implements cv_2 {
    private static final Logger g = LoggerFactory.getLogger(cb_1.class);
    private int i = 0;

    public cb_1(String string, JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
        super(string, jsonNode, cp_22, dj_2.MIN_ITEMS, df_22);
        if (jsonNode.canConvertToExactIntegral()) {
            this.i = jsonNode.intValue();
        }
        this.d = df_22;
        cb_1 cb_12 = this;
        cb_12.a(cb_12.e().d());
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode jsonNode2, String string) {
        this.a(g, jsonNode, jsonNode2, string);
        if (jsonNode.isArray() ? jsonNode.size() < this.i : this.d.d().a() && 1 < this.i) {
            return Collections.singleton(this.a(string, "" + this.i));
        }
        return Collections.emptySet();
    }
}

