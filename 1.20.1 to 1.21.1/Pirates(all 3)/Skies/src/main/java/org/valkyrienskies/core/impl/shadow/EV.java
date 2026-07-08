/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.ReplaceWith
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference0
 *  kotlin.jvm.internal.MutablePropertyReference0Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KMutableProperty0
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KMutableProperty0;
import org.valkyrienskies.core.impl.shadow.EU;

public final class EV {
    private static EU a;

    public static final void a(EU eU) {
        Intrinsics.checkNotNullParameter((Object)eU, (String)"");
        a = eU;
    }

    private static EU a() {
        EU eU = a;
        if (eU == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"");
            eU = null;
        }
        return eU;
    }

    private static void b(EU eU) {
        Intrinsics.checkNotNullParameter((Object)eU, (String)"");
        a = eU;
    }

    @Deprecated(message="Obtain an instance of VSCore and get hooks from there.", replaceWith=@ReplaceWith(expression="vsCore.hooks", imports={}), level=DeprecationLevel.ERROR)
    private static /* synthetic */ void b() {
    }

    private static KMutableProperty0 c() {
        return Reflection.mutableProperty0((MutablePropertyReference0)((MutablePropertyReference0)new MutablePropertyReference0Impl(EV.class, "CoreHooksInstance", "getCoreHooksInstance()Lorg/valkyrienskies/core/impl/hooks_impl/CoreHooksImpl;", 1)));
    }
}

