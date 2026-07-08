/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.gq_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Gk
 */
public final class gk_0<S>
implements gq_0<S> {
    private final List<S> b;

    public gk_0(List<? extends S> object) {
        Intrinsics.checkNotNullParameter(object, (String)"");
        this.b = object;
        if (!(!((Collection)this.b).isEmpty())) {
            object = "Failed requirement.";
            throw new IllegalArgumentException(object.toString());
        }
    }

    @Override
    public final String a(List<? extends S> list, boolean bl) {
        Intrinsics.checkNotNullParameter(list, (String)"");
        if (bl) {
            List<S> list2 = list;
            if (!Intrinsics.areEqual(list2.subList(list2.size() - this.b.size(), list.size()), this.b)) {
                return "Required final stages to be " + this.b;
            }
        }
        return null;
    }
}

