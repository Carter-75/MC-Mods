/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.GC;
import org.valkyrienskies.core.impl.shadow.GD;

public final class GE {
    private static /* synthetic */ <A, B> void a(SimpleModule simpleModule, Function1<? super A, ? extends B> function1, Function1<? super B, ? extends A> function12) {
        Intrinsics.checkNotNullParameter((Object)simpleModule, (String)"");
        Intrinsics.checkNotNullParameter(function1, (String)"");
        Intrinsics.checkNotNullParameter(function12, (String)"");
        Intrinsics.reifiedOperationMarker((int)4, (String)"A");
        Intrinsics.reifiedOperationMarker((int)4, (String)"A");
        simpleModule.addSerializer(Object.class, (JsonSerializer)new GD<Object, B>(function1, Object.class));
        Intrinsics.reifiedOperationMarker((int)4, (String)"A");
        Intrinsics.reifiedOperationMarker((int)4, (String)"A");
        Intrinsics.reifiedOperationMarker((int)4, (String)"B");
        simpleModule.addDeserializer(Object.class, (JsonDeserializer)new GC<Object, Object>(function12, Object.class, Object.class));
    }
}

