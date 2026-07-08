/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.valkyrienskies.core.impl.shadow.bt_1;
import org.valkyrienskies.core.impl.shadow.cp_2;
import org.valkyrienskies.core.impl.shadow.ct_1;
import org.valkyrienskies.core.impl.shadow.cu_2;
import org.valkyrienskies.core.impl.shadow.cz_1;
import org.valkyrienskies.core.impl.shadow.df_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.dE
 */
public class de_1 {
    private static final String a = "type";
    private static final String b = "enum";
    private static final String c = "$ref";
    private static final String d = "nullable";

    public static boolean a(JsonNode jsonNode) {
        return (jsonNode = jsonNode.get(d)) != null && jsonNode.asBoolean();
    }

    public static boolean a(JsonNode jsonNode, ct_1 ct_12) {
        if (ct_12.e()) {
            return de_1.a(jsonNode);
        }
        return false;
    }

    public static boolean a(ArrayNode object, ct_1 ct_12) {
        object = ((JsonNode)object).elements();
        while (object.hasNext()) {
            if (!de_1.a((JsonNode)object.next(), ct_12)) continue;
            return true;
        }
        return false;
    }

    public static boolean a(JsonNode object, cu_2 cu_22) {
        object = ((JsonNode)object).elements();
        while (object.hasNext()) {
            JsonNode jsonNode = (JsonNode)object.next();
            if ((jsonNode = jsonNode.get(a)) == null || !jsonNode.asText().equals(cu_22.toString())) continue;
            return true;
        }
        return false;
    }

    public static boolean a(JsonNode jsonNode, cp_2 cp_22, ct_1 ct_12) {
        cu_2 cu_22 = de_1.a(cp_22);
        return de_1.a(jsonNode, cu_22, cp_22.d(), ct_12);
    }

    public static cu_2 a(cp_2 object) {
        if ((object = ((bt_1)object).c().get(a)) != null) {
            return cu_2.valueOf(((JsonNode)object).asText().toUpperCase());
        }
        return cu_2.UNKNOWN;
    }

    public static boolean a(JsonNode jsonNode, cu_2 cu_22, cp_2 cp_22, ct_1 ct_12) {
        cu_2 cu_23 = cz_1.a(jsonNode, ct_12);
        if (cu_23 != cu_22) {
            if (cu_22 == cu_2.ANY) {
                return true;
            }
            if (cu_22 == cu_2.NUMBER && cu_23 == cu_2.INTEGER) {
                return true;
            }
            if (cu_2.NULL.equals((Object)cu_23) && cp_22 != null && (cp_22.d() != null && de_1.a(cp_22.d().c(), ct_12) || de_1.a(cp_22.c()))) {
                return true;
            }
            if (de_1.b(cp_22)) {
                return true;
            }
            if (ct_12 != null && ct_12.a()) {
                if (cu_22 == cu_2.ARRAY) {
                    return true;
                }
                if (cu_23 == cu_2.STRING && (cu_22 == cu_2.INTEGER ? df_1.a(jsonNode.textValue()) : (cu_22 == cu_2.BOOLEAN ? df_1.b(jsonNode.textValue()) : cu_22 == cu_2.NUMBER && df_1.c(jsonNode.textValue())))) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public static boolean b(JsonNode jsonNode, ct_1 ct_12) {
        if (jsonNode.isNumber()) {
            return true;
        }
        if (ct_12.a() && cz_1.a(jsonNode, ct_12) == cu_2.STRING) {
            return df_1.c(jsonNode.textValue());
        }
        return false;
    }

    private static boolean b(cp_2 cp_22) {
        JsonNode jsonNode = null;
        JsonNode jsonNode2 = null;
        JsonNode jsonNode3 = null;
        if (cp_22 != null) {
            if (cp_22.c() != null) {
                jsonNode = cp_22.c().get(a);
                jsonNode2 = cp_22.c().get(b);
            }
            if (cp_22.d() != null && cp_22.d().c() != null) {
                jsonNode3 = cp_22.d().c().get(c);
            }
        }
        if (jsonNode != null && jsonNode2 != null && jsonNode3 != null) {
            return cz_1.a(jsonNode) == cu_2.OBJECT && jsonNode2.isArray();
        }
        return false;
    }
}

