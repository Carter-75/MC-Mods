/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.EnumMap;
import java.util.Map;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ao
 */
enum ao_2 {
    ARRAY("array"),
    BOOLEAN("boolean"),
    INTEGER("integer"),
    NULL("null"),
    NUMBER("number"),
    OBJECT("object"),
    STRING("string");

    private final String name;
    private static final Map<JsonToken, ao_2> TOKEN_MAP;

    private ao_2(String string2) {
        this.name = string2;
    }

    public final String toString() {
        return this.name;
    }

    public static ao_2 a(JsonNode object) {
        ao_2 ao_22 = TOKEN_MAP.get(object = object.asToken());
        if (ao_22 == null) {
            throw new NullPointerException("unhandled token type " + object);
        }
        return ao_22;
    }

    static {
        TOKEN_MAP = new EnumMap<JsonToken, ao_2>(JsonToken.class);
        TOKEN_MAP.put(JsonToken.START_ARRAY, ARRAY);
        TOKEN_MAP.put(JsonToken.VALUE_TRUE, BOOLEAN);
        TOKEN_MAP.put(JsonToken.VALUE_FALSE, BOOLEAN);
        TOKEN_MAP.put(JsonToken.VALUE_NUMBER_INT, INTEGER);
        TOKEN_MAP.put(JsonToken.VALUE_NUMBER_FLOAT, NUMBER);
        TOKEN_MAP.put(JsonToken.VALUE_NULL, NULL);
        TOKEN_MAP.put(JsonToken.START_OBJECT, OBJECT);
        TOKEN_MAP.put(JsonToken.VALUE_STRING, STRING);
    }
}

