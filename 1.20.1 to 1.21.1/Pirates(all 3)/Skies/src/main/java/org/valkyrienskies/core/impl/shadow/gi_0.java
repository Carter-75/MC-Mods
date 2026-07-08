/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.gq_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Gi
 */
public final class gi_0<S>
implements gq_0<S> {
    private final gq_0<S>[] b;

    public gi_0(gq_0<S> ... gq_0Array) {
        Intrinsics.checkNotNullParameter(gq_0Array, (String)"");
        this.b = gq_0Array;
    }

    @Override
    public final String a(List<? extends S> list, boolean bl) {
        Intrinsics.checkNotNullParameter(list, (String)"");
        gq_0<S>[] gq_0Array = this.b;
        gq_0Array = this.b;
        Collection collection = new ArrayList();
        for (gq_0<S> gq_02 : gq_0Array) {
            Object object = gq_02;
            object = gq_02;
            object = gq_02;
            String string = gq_02.a(list, bl);
            if (string == null) continue;
            object = string;
            collection.add(object);
        }
        list = (List)collection;
        if (list.size() > 1) {
            return "Composite failure: " + CollectionsKt.joinToString$default((Iterable)list, null, null, null, (int)0, null, null, (int)63, null);
        }
        if (list.size() == 1) {
            return (String)CollectionsKt.first((List)list);
        }
        return null;
    }
}

