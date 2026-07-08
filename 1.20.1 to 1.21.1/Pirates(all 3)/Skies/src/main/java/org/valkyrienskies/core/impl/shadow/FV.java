/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KProperty
 */
package org.valkyrienskies.core.impl.shadow;

import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.valkyrienskies.core.impl.shadow.dt_1;

public final class FV {
    public static final <T> T a(dt_1<T> dt_12, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(dt_12, (String)"");
        Intrinsics.checkNotNullParameter(kProperty, (String)"");
        return dt_12.get();
    }

    public static final <T> T a(Provider<T> provider, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(provider, (String)"");
        Intrinsics.checkNotNullParameter(kProperty, (String)"");
        return provider.get();
    }
}

