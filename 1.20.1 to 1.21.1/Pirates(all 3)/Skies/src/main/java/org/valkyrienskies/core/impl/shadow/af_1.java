/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.ae_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.aF
 */
public final class af_1 {
    public static final af_1 a = new af_1(ae_1.VALUES_FROM_CONSTANT_FIELDS, ae_1.PUBLIC_STATIC_FIELDS, ae_1.PUBLIC_NONSTATIC_FIELDS, ae_1.NONPUBLIC_STATIC_FIELDS, ae_1.NONPUBLIC_NONSTATIC_FIELDS_WITH_GETTERS, ae_1.NONPUBLIC_NONSTATIC_FIELDS_WITHOUT_GETTERS, ae_1.TRANSIENT_FIELDS, ae_1.STATIC_METHODS, ae_1.VOID_METHODS, ae_1.GETTER_METHODS, ae_1.NONSTATIC_NONVOID_NONGETTER_METHODS, ae_1.SIMPLIFIED_ENUMS, ae_1.SIMPLIFIED_OPTIONALS, ae_1.DEFINITIONS_FOR_ALL_OBJECTS, ae_1.NULLABLE_FIELDS_BY_DEFAULT, ae_1.NULLABLE_METHOD_RETURN_VALUES_BY_DEFAULT, ae_1.ALLOF_CLEANUP_AT_THE_END);
    private static af_1 c;
    private static af_1 d;
    final Set<ae_1> b;

    private af_1(ae_1 ... ae_1Array) {
        this.b = new HashSet<ae_1>(Arrays.asList(ae_1Array));
    }

    public final boolean a(ae_1 ae_12) {
        return this.b.contains((Object)ae_12);
    }

    static {
        new af_1(ae_1.SCHEMA_VERSION_INDICATOR, ae_1.ADDITIONAL_FIXED_TYPES, ae_1.FLATTENED_ENUMS, ae_1.FLATTENED_OPTIONALS, ae_1.FLATTENED_SUPPLIERS, ae_1.VALUES_FROM_CONSTANT_FIELDS, ae_1.PUBLIC_NONSTATIC_FIELDS, ae_1.NONPUBLIC_NONSTATIC_FIELDS_WITH_GETTERS, ae_1.NONPUBLIC_NONSTATIC_FIELDS_WITHOUT_GETTERS, ae_1.ALLOF_CLEANUP_AT_THE_END);
        new af_1(ae_1.VALUES_FROM_CONSTANT_FIELDS, ae_1.PUBLIC_STATIC_FIELDS, ae_1.PUBLIC_NONSTATIC_FIELDS, ae_1.STATIC_METHODS, ae_1.VOID_METHODS, ae_1.GETTER_METHODS, ae_1.NONSTATIC_NONVOID_NONGETTER_METHODS, ae_1.SIMPLIFIED_ENUMS, ae_1.SIMPLIFIED_OPTIONALS, ae_1.ALLOF_CLEANUP_AT_THE_END);
    }
}

