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
import org.valkyrienskies.core.impl.shadow.gt_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Gn
 */
public final class gn_0<S>
implements gq_0<S> {
    private final List<gt_0<S>> b;

    public gn_0(List<? extends gt_0<S>> object) {
        Intrinsics.checkNotNullParameter(object, (String)"");
        this.b = object;
        if (!(!((Collection)this.b).isEmpty())) {
            object = "Failed requirement.";
            throw new IllegalArgumentException(object.toString());
        }
    }

    private List<gt_0<S>> a() {
        return this.b;
    }

    @Override
    public final String a(List<? extends S> object, boolean n2) {
        Intrinsics.checkNotNullParameter(object, (String)"");
        n2 = 0;
        object = object.iterator();
        while (object.hasNext()) {
            int n3;
            int n4;
            block4: {
                Object e2 = object.next();
                Object object2 = this.b;
                int n5 = 0;
                object2 = object2.iterator();
                while (object2.hasNext()) {
                    Object object3 = object2.next();
                    if ((object3 = (gt_0)object3).a(e2)) {
                        n4 = n5;
                        break block4;
                    }
                    ++n5;
                }
                n4 = n3 = -1;
            }
            if (n4 == -1) continue;
            if (n3 < n2) {
                return "Required stages matching predicate in the following order: " + this.b;
            }
            n2 = n3;
        }
        return null;
    }
}

