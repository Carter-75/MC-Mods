/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import org.valkyrienskies.core.impl.shadow.ct_1;
import org.valkyrienskies.core.impl.shadow.cu_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.cZ
 */
public class cz_1 {
    public static cu_2 a(JsonNode jsonNode) {
        if (jsonNode.isTextual()) {
            String string = jsonNode.textValue();
            if ("object".equals(string)) {
                return cu_2.OBJECT;
            }
            if ("array".equals(string)) {
                return cu_2.ARRAY;
            }
            if ("string".equals(string)) {
                return cu_2.STRING;
            }
            if ("number".equals(string)) {
                return cu_2.NUMBER;
            }
            if ("integer".equals(string)) {
                return cu_2.INTEGER;
            }
            if ("boolean".equals(string)) {
                return cu_2.BOOLEAN;
            }
            if ("any".equals(string)) {
                return cu_2.ANY;
            }
            if ("null".equals(string)) {
                return cu_2.NULL;
            }
        }
        if (jsonNode.isArray()) {
            return cu_2.UNION;
        }
        return cu_2.UNKNOWN;
    }

    public static cu_2 a(JsonNode jsonNode, ct_1 ct_12) {
        if (jsonNode.isContainerNode()) {
            if (jsonNode.isObject()) {
                return cu_2.OBJECT;
            }
            if (jsonNode.isArray()) {
                return cu_2.ARRAY;
            }
            return cu_2.UNKNOWN;
        }
        if (jsonNode.isValueNode()) {
            if (jsonNode.isTextual()) {
                return cu_2.STRING;
            }
            if (jsonNode.isIntegralNumber()) {
                return cu_2.INTEGER;
            }
            if (jsonNode.isNumber()) {
                if (ct_12 != null && ct_12.g() && jsonNode.canConvertToExactIntegral()) {
                    return cu_2.INTEGER;
                }
                if (ct_12 != null && ct_12.l() && jsonNode.canConvertToExactIntegral()) {
                    return cu_2.INTEGER;
                }
                return cu_2.NUMBER;
            }
            if (jsonNode.isBoolean()) {
                return cu_2.BOOLEAN;
            }
            if (jsonNode.isNull()) {
                return cu_2.NULL;
            }
            return cu_2.UNKNOWN;
        }
        return cu_2.UNKNOWN;
    }
}

