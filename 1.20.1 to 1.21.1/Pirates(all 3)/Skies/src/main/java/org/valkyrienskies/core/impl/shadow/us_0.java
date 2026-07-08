/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.us$a
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.oX;
import org.valkyrienskies.core.impl.shadow.ue_0;
import org.valkyrienskies.core.impl.shadow.uq_0;
import org.valkyrienskies.core.impl.shadow.us;
import org.valkyrienskies.core.impl.shadow.us_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.us
 */
public final class us_0 {
    private final Map<Long, a_0> a = new HashMap<Long, a_0>();

    public us_0(uq_0 uq_02) {
        Serializable serializable = uq_02;
        int n2 = serializable.b;
        serializable = uq_02;
        int n3 = serializable.c;
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                serializable = uq_02.a(i2, i3);
                serializable = Long.valueOf(((ue_0)serializable).a);
                if (this.a.get(serializable) != null) {
                    throw new oX();
                }
                this.a.put((Long)serializable, (a_0)new us.a(i2, i3));
            }
        }
    }

    public final a_0 a(ue_0 ue_02) {
        return (us.a)this.a.get(ue_02.a);
    }
}

