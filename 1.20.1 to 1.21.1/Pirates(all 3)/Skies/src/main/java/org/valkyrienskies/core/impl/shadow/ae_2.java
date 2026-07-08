/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.EnumSet;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ae
 */
public enum ae_2 {
    OMIT_VALUE_ON_REMOVE,
    OMIT_MOVE_OPERATION,
    OMIT_COPY_OPERATION,
    ADD_ORIGINAL_VALUE_ON_REPLACE,
    ADD_EXPLICIT_REMOVE_ADD_ON_REPLACE,
    EMIT_TEST_OPERATIONS;


    public static EnumSet<ae_2> a() {
        return EnumSet.of(OMIT_VALUE_ON_REMOVE);
    }

    private static EnumSet<ae_2> b() {
        return EnumSet.of(OMIT_MOVE_OPERATION, OMIT_COPY_OPERATION);
    }
}

