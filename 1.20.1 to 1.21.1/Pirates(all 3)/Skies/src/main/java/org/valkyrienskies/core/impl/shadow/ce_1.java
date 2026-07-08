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
 * Renamed from org.valkyrienskies.core.impl.shadow.cE
 */
public class ce_1
extends bt_1
implements cv_2 {
    private static final Logger g = LoggerFactory.getLogger(ce_1.class);
    private static final String i = "exclusiveMinimum";
    private boolean j = false;
    private final cx_1 k;

    public ce_1(String object, final JsonNode jsonNode, cp_2 cp_22, df_2 df_22) {
        super((String)object, jsonNode, cp_22, dj_2.MINIMUM, df_22);
        if (!jsonNode.isNumber()) {
            throw new cq_2("minimum value is not a number");
        }
        object = this.d().c().get(i);
        if (object != null && ((JsonNode)object).isBoolean()) {
            this.j = ((JsonNode)object).booleanValue();
        }
        ce_1 ce_12 = this;
        ce_12.a(ce_12.e().d());
        object = jsonNode.asText();
        if ((jsonNode.isLong() || jsonNode.isInt()) && cu_2.INTEGER.toString().equals(this.f())) {
            long l2 = jsonNode.asLong();
            this.k = new cx_1((String)object, l2){
                final /* synthetic */ String a;
                final /* synthetic */ long b;
                {
                    this.a = string;
                    this.b = l2;
                }

                @Override
                public boolean a(JsonNode jsonNode) {
                    if (jsonNode.isBigInteger()) {
                        int n2 = jsonNode.bigIntegerValue().compareTo(new BigInteger(this.a));
                        return n2 < 0 || ce_1.this.j && n2 == 0;
                    }
                    if (jsonNode.isTextual()) {
                        BigDecimal bigDecimal = new BigDecimal(this.a);
                        BigDecimal bigDecimal2 = new BigDecimal(jsonNode.asText());
                        int n3 = bigDecimal2.compareTo(bigDecimal);
                        return n3 < 0 || ce_1.this.j && n3 == 0;
                    }
                    long l2 = jsonNode.asLong();
                    return this.b > l2 || ce_1.this.j && this.b == l2;
                }

                @Override
                public String a() {
                    return String.valueOf(this.b);
                }
            };
        } else {
            this.k = new cx_1((String)object){
                final /* synthetic */ String b;
                {
                    this.b = string;
                }

                @Override
                public boolean a(JsonNode object) {
                    if (jsonNode.isDouble() && jsonNode.doubleValue() == Double.NEGATIVE_INFINITY) {
                        return false;
                    }
                    if (jsonNode.isDouble() && jsonNode.doubleValue() == Double.POSITIVE_INFINITY) {
                        return true;
                    }
                    if (((JsonNode)object).isDouble() && ((JsonNode)object).doubleValue() == Double.NEGATIVE_INFINITY) {
                        return true;
                    }
                    if (((JsonNode)object).isDouble() && ((JsonNode)object).doubleValue() == Double.POSITIVE_INFINITY) {
                        return false;
                    }
                    BigDecimal bigDecimal = new BigDecimal(this.b);
                    int n2 = ((BigDecimal)(object = new BigDecimal(((JsonNode)object).asText()))).compareTo(bigDecimal);
                    return n2 < 0 || ce_1.this.j && n2 == 0;
                }

                @Override
                public String a() {
                    return this.b;
                }
            };
        }
        this.d = df_22;
    }

    @Override
    public Set<dg_2> a(JsonNode jsonNode, JsonNode jsonNode2, String string) {
        this.a(g, jsonNode, jsonNode2, string);
        if (!da_2.a(jsonNode, this.d.d())) {
            return Collections.emptySet();
        }
        if (this.k.a(jsonNode)) {
            return Collections.singleton(this.a(string, this.k.a()));
        }
        return Collections.emptySet();
    }
}

