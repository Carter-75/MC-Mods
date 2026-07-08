/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.List;
import org.valkyrienskies.core.impl.shadow.AM;
import org.valkyrienskies.core.impl.shadow.an_0;
import org.valkyrienskies.core.impl.shadow.tK;
import org.valkyrienskies.core.impl.shadow.tL;
import org.valkyrienskies.core.impl.shadow.tS;
import org.valkyrienskies.core.impl.shadow.tW;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class tT<T extends tL>
extends tS<T> {
    public tT(tW tW2) {
        super(tW2);
    }

    @Override
    public final double a(List<? extends tK<T>> object) {
        double d2 = 0.0;
        object = object.iterator();
        while (object.hasNext()) {
            Object object2;
            Object object3 = object2 = (tK)object.next();
            if (((tK)object2).b.isEmpty()) continue;
            tL tL2 = tT.a(object2);
            AM aM = new AM();
            object3 = object2;
            object2 = ((tK)object3).b.iterator();
            while (object2.hasNext()) {
                object3 = (tL)object2.next();
                ((an_0)aM).a(this.a((tL)object3, tL2));
            }
            d2 += ((an_0)aM).c();
        }
        return d2;
    }
}

