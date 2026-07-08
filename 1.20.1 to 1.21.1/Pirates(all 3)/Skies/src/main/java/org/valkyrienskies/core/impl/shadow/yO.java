/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.kQ;
import org.valkyrienskies.core.impl.shadow.li_0;
import org.valkyrienskies.core.impl.shadow.lk_0;
import org.valkyrienskies.core.impl.shadow.ya_0;
import org.valkyrienskies.core.impl.shadow.yf_0;
import org.valkyrienskies.core.impl.shadow.yg_0;
import org.valkyrienskies.core.impl.shadow.yo_0;
import org.valkyrienskies.core.impl.shadow.yp_0;
import org.valkyrienskies.core.impl.shadow.yz_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public abstract class yO
extends yz_0<lk_0> {
    private li_0 b;

    private yO(ya_0<yp_0> ya_02) {
        super(ya_02);
    }

    private double[] b(double[] dArray) {
        return this.b.a(dArray);
    }

    @Override
    @Deprecated
    private yp_0 a(int n2, lk_0 lk_02, yf_0 yf_02, double[] dArray) {
        return this.a(n2, lk_02, yf_02, new yo_0[]{new yg_0(dArray)});
    }

    @Override
    private yp_0 a(int n2, lk_0 lk_02, yf_0 yf_02, yo_0 ... yo_0Array) {
        this.b = new li_0(lk_02);
        return super.a(n2, lk_02, yf_02, yo_0Array);
    }

    @Override
    @Deprecated
    public final /* synthetic */ yp_0 a(int n2, kQ kQ2, yf_0 object, double[] object2) {
        double[] dArray = object2;
        object2 = object;
        object = (lk_0)((Object)kQ2);
        int n3 = n2;
        yO yO2 = this;
        return yO2.a(n3, (lk_0)object, (yf_0)object2, new yo_0[]{new yg_0(dArray)});
    }
}

