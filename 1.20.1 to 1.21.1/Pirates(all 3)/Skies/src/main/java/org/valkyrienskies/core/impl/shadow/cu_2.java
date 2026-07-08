/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.cu
 */
public enum cu_2 {
    OBJECT("object"),
    ARRAY("array"),
    STRING("string"),
    NUMBER("number"),
    INTEGER("integer"),
    BOOLEAN("boolean"),
    NULL("null"),
    ANY("any"),
    UNKNOWN("unknown"),
    UNION("union");

    private String type;

    private cu_2(String string2) {
        this.type = string2;
    }

    public final String toString() {
        return this.type;
    }
}

