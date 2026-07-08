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
import java.util.LinkedHashSet;
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
 * Renamed from org.valkyrienskies.core.impl.shadow.bW
 */
public class bw_1
extends bt_1
implements cv_2 {
    private static final Logger i = LoggerFactory.getLogger(bw_1.class);
    JsonNode g;

    public bw_1(String string, JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
        super(string, jsonNode, cp_22, dj_2.CONST, df_22);
        this.g = jsonNode;
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode iterable, String string) {
        this.a(i, jsonNode, (JsonNode)iterable, string);
        iterable = new LinkedHashSet();
        if (this.g.isNumber() && jsonNode.isNumber()) {
            if (this.g.decimalValue().compareTo(jsonNode.decimalValue()) != 0) {
                iterable.add((dg_2)this.a(string, this.g.asText()));
            }
        } else if (!this.g.equals(jsonNode)) {
            iterable.add(this.a(string, this.g.asText()));
        }
        return Collections.unmodifiableSet(iterable);
    }
}

