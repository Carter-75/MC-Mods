/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.api.event.RegisteredListener;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Fd
 */
public final class fd_0 {
    public static final void a(Iterable<? extends RegisteredListener> object) {
        Intrinsics.checkNotNullParameter(object, (String)"");
        object = object.iterator();
        while (object.hasNext()) {
            Object object2 = object.next();
            object2 = (RegisteredListener)object2;
            object2.unregister();
        }
    }
}

