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
 * Renamed from org.valkyrienskies.core.impl.shadow.cx
 */
public class cx_2
extends bt_1
implements cv_2 {
    private static final Logger g = LoggerFactory.getLogger(cx_2.class);
    private int i = 0;

    public cx_2(String string, JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
        super(string, jsonNode, cp_22, dj_2.MAX_ITEMS, df_22);
        if (jsonNode.canConvertToExactIntegral()) {
            this.i = jsonNode.intValue();
        }
        this.d = df_22;
        cx_2 cx_22 = this;
        cx_22.a(cx_22.e().d());
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode jsonNode2, String string) {
        this.a(g, jsonNode, jsonNode2, string);
        if (jsonNode.isArray() ? jsonNode.size() > this.i : this.d.d().a() && this.i <= 0) {
            return Collections.singleton(this.a(string, "" + this.i));
        }
        return Collections.emptySet();
    }
}

