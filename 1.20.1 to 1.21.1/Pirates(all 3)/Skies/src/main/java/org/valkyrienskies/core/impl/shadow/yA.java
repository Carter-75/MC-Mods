/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.kW;
import org.valkyrienskies.core.impl.shadow.xV;
import org.valkyrienskies.core.impl.shadow.xW;
import org.valkyrienskies.core.impl.shadow.ya_0;
import org.valkyrienskies.core.impl.shadow.yf_0;
import org.valkyrienskies.core.impl.shadow.yg_0;
import org.valkyrienskies.core.impl.shadow.yp_0;
import org.valkyrienskies.core.impl.shadow.yr_0;
import org.valkyrienskies.core.impl.shadow.yz_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public abstract class yA<FUNC extends kW>
extends yz_0<FUNC>
implements xV<FUNC>,
xW<FUNC> {
    @Deprecated
    protected yA() {
    }

    protected yA(ya_0<yp_0> ya_02) {
        super(ya_02);
    }

    @Override
    public final yp_0 a(int n2, FUNC FUNC, yf_0 yf_02, double[] dArray) {
        return super.a(n2, FUNC, yf_02, new yg_0(dArray));
    }

    @Override
    public final yp_0 a(int n2, FUNC FUNC, yf_0 yf_02, double[] dArray, double[] dArray2, double[] dArray3) {
        return super.a(n2, FUNC, yf_02, new yg_0(dArray), new yr_0(dArray2, dArray3));
    }
}

