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
 * Renamed from org.valkyrienskies.core.impl.shadow.Gm
 */
public final class gm_0<S>
implements gq_0<S> {
    private final List<S> b;

    public gm_0(List<? extends S> object) {
        Intrinsics.checkNotNullParameter(object, (String)"");
        this.b = object;
        if (!(!((Collection)this.b).isEmpty())) {
            object = "Failed requirement.";
            throw new IllegalArgumentException(object.toString());
        }
    }

    @Override
    public final String a(List<? extends S> object, boolean bl) {
        Intrinsics.checkNotNullParameter(object, (String)"");
        bl = false;
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            if (!this.b.contains(e2) || Intrinsics.areEqual(e2, this.b.get(bl ? 1 : 0)) || bl + 1 >= this.b.size() || Intrinsics.areEqual(e2, this.b.get((bl += 1) ? 1 : 0))) continue;
            return "Required stages in the following order: " + this.b;
        }
        return null;
    }
}

