/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.cl_0;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.px_0;

public final class BW
implements Serializable,
cl_0 {
    private static final long a = 4019938025047800455L;

    public final double a(Object object) {
        if (object == null) {
            throw new pl_0(px_0.OBJECT_TRANSFORMATION, new Object[0]);
        }
        if (object instanceof Number) {
            return ((Number)object).doubleValue();
        }
        try {
            return Double.parseDouble(object.toString());
        }
        catch (NumberFormatException numberFormatException) {
            throw new oV(px_0.CANNOT_TRANSFORM_TO_DOUBLE, object.toString());
        }
    }

    /*
     * WARNING - void declaration
     */
    public final boolean equals(Object other) {
        void var1_1;
        if (this == other) {
            return true;
        }
        return var1_1 instanceof BW;
    }

    public final int hashCode() {
        return 401993047;
    }
}

