/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.co_0;
import org.valkyrienskies.core.impl.shadow.oA;
import org.valkyrienskies.core.impl.shadow.oB;
import org.valkyrienskies.core.impl.shadow.zF;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.oz
 */
public final class oz_0
extends oA<oB> {
    public oz_0(double[] dArray, double[][] dArray2, double[][][] dArray3) {
        super(oz_0.a(dArray, dArray2, dArray3));
    }

    public oz_0(List<co_0<Double, oB>> list) {
        super(list);
    }

    private oz_0(zF zF2, List<co_0<Double, oB>> list) {
        super(zF2, list);
    }

    private static List<co_0<Double, oB>> a(double[] dArray, double[][] dArray2, double[][][] dArray3) {
        ArrayList<co_0<Double, oB>> arrayList = new ArrayList<co_0<Double, oB>>(dArray.length);
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            oB oB2 = new oB(dArray2[i2], dArray3[i2]);
            arrayList.add(new co_0<Double, oB>(dArray[i2], oB2));
        }
        return arrayList;
    }
}

