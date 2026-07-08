/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.gq_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Go
 */
public final class go_0<S>
implements gq_0<S> {
    private final List<S> b;

    public go_0(S ... objectArray) {
        Intrinsics.checkNotNullParameter(objectArray, (String)"");
        if (!(!(objectArray.length == 0))) {
            objectArray = "Failed requirement.";
            throw new IllegalArgumentException(objectArray.toString());
        }
        this.b = ArraysKt.asList((Object[])objectArray);
    }

    @Override
    public final String a(List<? extends S> list, boolean bl) {
        Intrinsics.checkNotNullParameter(list, (String)"");
        if (bl && !list.containsAll((Collection)this.b)) {
            return "Required all stages " + this.b + " - missing " + CollectionsKt.minus((Iterable)this.b, (Iterable)CollectionsKt.toSet((Iterable)list)) + ")";
        }
        return null;
    }
}

