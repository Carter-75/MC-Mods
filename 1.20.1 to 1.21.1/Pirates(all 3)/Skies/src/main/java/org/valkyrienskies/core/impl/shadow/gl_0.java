/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.gq_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Gl
 */
public final class gl_0<S>
implements gq_0<S> {
    private final List<S> b;

    public gl_0(S ... SArray) {
        Intrinsics.checkNotNullParameter(SArray, (String)"");
        this.b = ArraysKt.asList((Object[])SArray);
    }

    @Override
    public final String a(List<? extends S> list, boolean bl) {
        boolean bl2;
        Intrinsics.checkNotNullParameter(list, (String)"");
        if (bl) {
            return null;
        }
        if (this.b.isEmpty() && SetsKt.setOf(list).size() != list.size()) {
            return "Expected no duplicates";
        }
        Object object = this.b;
        if (!(object instanceof Collection) || !((Collection)object).isEmpty()) {
            object = object.iterator();
            while (object.hasNext()) {
                int n2;
                Object e2 = object.next();
                Object object2 = list;
                if (object2 instanceof Collection && ((Collection)object2).isEmpty()) {
                    n2 = 0;
                } else {
                    int n3 = 0;
                    object2 = object2.iterator();
                    while (object2.hasNext()) {
                        Object e3;
                        Object e4 = object2.next();
                        e4 = e4;
                        if (!Intrinsics.areEqual(e3, e2) || ++n3 >= 0) continue;
                        CollectionsKt.throwCountOverflow();
                    }
                    n2 = n3;
                }
                if (!(n2 > 1)) continue;
                bl2 = true;
                break;
            }
        } else {
            bl2 = false;
        }
        if (bl2) {
            return "Expected no duplicates of the following stages: " + this.b;
        }
        return null;
    }
}

