/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.function.Function;
import org.valkyrienskies.core.impl.shadow.aq_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.aP
 */
public enum ap_1 {
    TAG_SCHEMA("$schema"),
    TAG_SCHEMA_VALUE(aq_1::a),
    TAG_ID("$id"),
    TAG_ANCHOR("$anchor"),
    TAG_DEFINITIONS(aq_12 -> {
        if (aq_12 == aq_1.DRAFT_6 || aq_12 == aq_1.DRAFT_7) {
            return "definitions";
        }
        return "$defs";
    }),
    TAG_REF("$ref"),
    TAG_REF_MAIN("#"),
    TAG_REF_PREFIX(aq_12 -> {
        if (aq_12 == aq_1.DRAFT_6 || aq_12 == aq_1.DRAFT_7) {
            return "#/definitions/";
        }
        return "#/$defs/";
    }),
    TAG_TYPE("type"),
    TAG_TYPE_NULL("null"),
    TAG_TYPE_ARRAY("array"),
    TAG_TYPE_OBJECT("object"),
    TAG_TYPE_BOOLEAN("boolean"),
    TAG_TYPE_STRING("string"),
    TAG_TYPE_INTEGER("integer"),
    TAG_TYPE_NUMBER("number"),
    TAG_PROPERTIES("properties"),
    TAG_ITEMS("items"),
    TAG_REQUIRED("required"),
    TAG_ADDITIONAL_PROPERTIES("additionalProperties"),
    TAG_PATTERN_PROPERTIES("patternProperties"),
    TAG_PROPERTIES_MIN("minProperties"),
    TAG_PROPERTIES_MAX("maxProperties"),
    TAG_ALLOF("allOf"),
    TAG_ANYOF("anyOf"),
    TAG_ONEOF("oneOf"),
    TAG_NOT("not"),
    TAG_TITLE("title"),
    TAG_DESCRIPTION("description"),
    TAG_CONST("const"),
    TAG_ENUM("enum"),
    TAG_DEFAULT("default"),
    TAG_READ_ONLY("readOnly"),
    TAG_WRITE_ONLY("writeOnly"),
    TAG_LENGTH_MIN("minLength"),
    TAG_LENGTH_MAX("maxLength"),
    TAG_FORMAT("format"),
    TAG_PATTERN("pattern"),
    TAG_MINIMUM("minimum"),
    TAG_MINIMUM_EXCLUSIVE("exclusiveMinimum"),
    TAG_MAXIMUM("maximum"),
    TAG_MAXIMUM_EXCLUSIVE("exclusiveMaximum"),
    TAG_MULTIPLE_OF("multipleOf"),
    TAG_ITEMS_MIN("minItems"),
    TAG_ITEMS_MAX("maxItems"),
    TAG_ITEMS_UNIQUE("uniqueItems"),
    TAG_IF("if"),
    TAG_THEN("then"),
    TAG_ELSE("else");

    private final Function<aq_1, String> valueProvider;

    private ap_1(String string2) {
        this.valueProvider = aq_12 -> string2;
    }

    private ap_1(Function<aq_1, String> function) {
        this.valueProvider = function;
    }

    public final String a(aq_1 aq_12) {
        return this.valueProvider.apply(aq_12);
    }
}

