/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.fd_2;
import org.valkyrienskies.core.impl.shadow.gq_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Gj
 */
public final class gj_0<S>
implements gq_0<S> {
    private final List<S> b;

    public gj_0(S ... objectArray) {
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
        if (!fd_2.b((Collection)list, (Collection)this.b)) {
            return "Required exact stages " + this.b;
        }
        if (bl && !fd_2.c((Collection)list, (Collection)this.b)) {
            return "Required exact stages " + this.b;
        }
        return null;
    }
}

