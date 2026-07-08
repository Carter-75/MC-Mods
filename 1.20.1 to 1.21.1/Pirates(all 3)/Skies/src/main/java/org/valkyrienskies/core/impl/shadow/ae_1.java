/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collections;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.valkyrienskies.core.impl.shadow.ad_1;
import org.valkyrienskies.core.impl.shadow.be_2;
import org.valkyrienskies.core.impl.shadow.bf_2;
import org.valkyrienskies.core.impl.shadow.bg_2;
import org.valkyrienskies.core.impl.shadow.bh_2;
import org.valkyrienskies.core.impl.shadow.bi_2;
import org.valkyrienskies.core.impl.shadow.bj_2;
import org.valkyrienskies.core.impl.shadow.bk_2;
import org.valkyrienskies.core.impl.shadow.bl_2;
import org.valkyrienskies.core.impl.shadow.bm_2;
import org.valkyrienskies.core.impl.shadow.bn_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.aE
 */
public enum ae_1 {
    SCHEMA_VERSION_INDICATOR(null, null, new ae_1[0]),
    ADDITIONAL_FIXED_TYPES(bm_2::b, bm_2::a, new ae_1[0]),
    SIMPLIFIED_ENUMS(bg_2::c, null, new ae_1[0]),
    FLATTENED_ENUMS(bg_2::a, null, SIMPLIFIED_ENUMS),
    FLATTENED_ENUMS_FROM_TOSTRING(bg_2::b, null, FLATTENED_ENUMS, SIMPLIFIED_ENUMS),
    SIMPLIFIED_OPTIONALS(() -> new bn_2(new String[0]), null, new ae_1[0]),
    FLATTENED_OPTIONALS(bi_2::new, null, SIMPLIFIED_OPTIONALS),
    FLATTENED_SUPPLIERS(() -> new bj_2<Supplier>(Supplier.class), null, new ae_1[0]),
    VALUES_FROM_CONSTANT_FIELDS(bf_2::new, null, new ae_1[0]),
    PUBLIC_STATIC_FIELDS(null, null, new ae_1[0]),
    PUBLIC_NONSTATIC_FIELDS(null, bh_2::a, new ae_1[0]),
    NONPUBLIC_STATIC_FIELDS(null, null, new ae_1[0]),
    NONPUBLIC_NONSTATIC_FIELDS_WITH_GETTERS(null, bh_2::b, new ae_1[0]),
    NONPUBLIC_NONSTATIC_FIELDS_WITHOUT_GETTERS(null, bh_2::c, new ae_1[0]),
    TRANSIENT_FIELDS(null, bh_2::d, new ae_1[0]),
    STATIC_METHODS(null, null, new ae_1[0]),
    VOID_METHODS(null, bl_2::a, new ae_1[0]),
    GETTER_METHODS(null, bl_2::b, new ae_1[0]),
    NONSTATIC_NONVOID_NONGETTER_METHODS(null, bl_2::c, new ae_1[0]),
    NULLABLE_FIELDS_BY_DEFAULT(null, null, new ae_1[0]),
    NULLABLE_METHOD_RETURN_VALUES_BY_DEFAULT(null, null, new ae_1[0]),
    NULLABLE_ARRAY_ITEMS_ALLOWED(null, null, new ae_1[0]),
    FIELDS_DERIVED_FROM_ARGUMENTFREE_METHODS(null, null, new ae_1[0]),
    MAP_VALUES_AS_ADDITIONAL_PROPERTIES(be_2::a, null, new ae_1[0]),
    ENUM_KEYWORD_FOR_SINGLE_VALUES(null, null, new ae_1[0]),
    FORBIDDEN_ADDITIONAL_PROPERTIES_BY_DEFAULT(be_2::b, null, new ae_1[0]),
    DEFINITIONS_FOR_ALL_OBJECTS(null, null, new ae_1[0]),
    DEFINITION_FOR_MAIN_SCHEMA(null, null, new ae_1[0]),
    INLINE_ALL_SCHEMAS(bk_2::new, null, DEFINITIONS_FOR_ALL_OBJECTS, DEFINITION_FOR_MAIN_SCHEMA),
    PLAIN_DEFINITION_KEYS(null, null, new ae_1[0]),
    EXTRA_OPEN_API_FORMAT_VALUES(null, null, new ae_1[0]),
    ALLOF_CLEANUP_AT_THE_END(null, null, new ae_1[0]);

    final Supplier<ad_1> enabledModuleProvider;
    final Supplier<ad_1> disabledModuleProvider;
    final Set<ae_1> overriddenOptions;

    private ae_1(Supplier<ad_1> supplier, Supplier<ad_1> supplier2, ae_1 ... ae_1Array) {
        this.enabledModuleProvider = supplier;
        this.disabledModuleProvider = supplier2;
        if (ae_1Array.length == 0) {
            this.overriddenOptions = Collections.emptySet();
            return;
        }
        this.overriddenOptions = Stream.of(ae_1Array).collect(Collectors.toSet());
    }

    public final boolean a(ae_1 ae_12) {
        return this.overriddenOptions.contains((Object)ae_12);
    }

    final ad_1 a(boolean bl) {
        Supplier<ad_1> supplier = bl ? this.enabledModuleProvider : this.disabledModuleProvider;
        if (supplier == null) {
            return null;
        }
        return supplier.get();
    }
}

