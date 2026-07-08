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
import java.math.BigInteger;
import java.util.Collections;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.valkyrienskies.core.impl.shadow.bt_1;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.cq_2;
import org.valkyrienskies.core.impl.shadow.cu_2;
import org.valkyrienskies.core.impl.shadow.cv_2;
import org.valkyrienskies.core.impl.shadow.cx_1;
import org.valkyrienskies.core.impl.shadow.da_2;
import org.valkyrienskies.core.impl.shadow.df_2;
import org.valkyrienskies.core.impl.shadow.dg_2;
import org.valkyrienskies.core.impl.shadow.dj_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.cf
 */
public class cf_2
extends bt_1
implements cv_2 {
    private static final Logger g = LoggerFactory.getLogger(cf_2.class);
    private final cx_1 i;

    public cf_2(final String string, final JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
        super(string, jsonNode, cp_22, dj_2.EXCLUSIVE_MAXIMUM, df_22);
        this.d = df_22;
        if (!jsonNode.isNumber()) {
            throw new cq_2("exclusiveMaximum value is not a number");
        }
        cf_2 cf_22 = this;
        cf_22.a(cf_22.e().d());
        string = jsonNode.asText();
        if ((jsonNode.isLong() || jsonNode.isInt()) && cu_2.INTEGER.toString().equals(this.f())) {
            final long l2 = jsonNode.asLong();
            this.i = new cx_1(){

                @Override
                public boolean a(JsonNode jsonNode2) {
                    if (jsonNode2.isBigInteger()) {
                        int n2 = jsonNode2.bigIntegerValue().compareTo(new BigInteger(jsonNode.asText()));
                        return n2 > 0 || n2 == 0;
                    }
                    if (jsonNode2.isTextual()) {
                        BigDecimal bigDecimal = new BigDecimal(string);
                        BigDecimal bigDecimal2 = new BigDecimal(jsonNode2.asText());
                        int n3 = bigDecimal2.compareTo(bigDecimal);
                        return n3 > 0 || n3 == 0;
                    }
                    long l22 = jsonNode2.asLong();
                    return l2 < l22 || l2 == l22;
                }

                @Override
                public String a() {
                    return String.valueOf(l2);
                }
            };
            return;
        }
        this.i = new cx_1(){

            @Override
            public boolean a(JsonNode object) {
                if (jsonNode.isDouble() && jsonNode.doubleValue() == Double.POSITIVE_INFINITY) {
                    return false;
                }
                if (jsonNode.isDouble() && jsonNode.doubleValue() == Double.NEGATIVE_INFINITY) {
                    return true;
                }
                if (((JsonNode)object).isDouble() && ((JsonNode)object).doubleValue() == Double.NEGATIVE_INFINITY) {
                    return false;
                }
                if (((JsonNode)object).isDouble() && ((JsonNode)object).doubleValue() == Double.POSITIVE_INFINITY) {
                    return true;
                }
                BigDecimal bigDecimal = new BigDecimal(string);
                int n2 = ((BigDecimal)(object = new BigDecimal(((JsonNode)object).asText()))).compareTo(bigDecimal);
                return n2 > 0 || n2 == 0;
            }

            @Override
            public String a() {
                return string;
            }
        };
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode jsonNode2, String string) {
        this.a(g, jsonNode, jsonNode2, string);
        if (!da_2.a(jsonNode, this.d.d())) {
            return Collections.emptySet();
        }
        if (this.i.a(jsonNode)) {
            return Collections.singleton(this.a(string, this.i.a()));
        }
        return Collections.emptySet();
    }
}

