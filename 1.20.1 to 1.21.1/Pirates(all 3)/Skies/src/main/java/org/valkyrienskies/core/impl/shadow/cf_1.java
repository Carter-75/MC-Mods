/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import java.math.BigDecimal;
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
 * Renamed from org.valkyrienskies.core.impl.shadow.cF
 */
public class cf_1
extends bt_1
implements cv_2 {
    private static final Logger g = LoggerFactory.getLogger(cf_1.class);
    private double i = 0.0;

    public cf_1(String string, JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
        super(string, jsonNode, cp_22, dj_2.MULTIPLE_OF, df_22);
        if (jsonNode.isNumber()) {
            this.i = jsonNode.doubleValue();
        }
        cf_1 cf_12 = this;
        cf_12.a(cf_12.e().d());
    }

    @Override
    public Set<dg_2> a(JsonNode object, JsonNode object2, String string) {
        this.a(g, (JsonNode)object, (JsonNode)object2, string);
        if (((JsonNode)object).isNumber()) {
            double d2 = ((JsonNode)object).doubleValue();
            if (this.i != 0.0 && ((BigDecimal)(object = ((JsonNode)object).isBigDecimal() ? ((JsonNode)object).decimalValue() : new BigDecimal(String.valueOf(d2)))).divideAndRemainder((BigDecimal)(object2 = new BigDecimal(String.valueOf(this.i))))[1].abs().compareTo(BigDecimal.ZERO) > 0) {
                return Collections.singleton(this.a(string, "" + this.i));
            }
        }
        return Collections.emptySet();
    }
}

