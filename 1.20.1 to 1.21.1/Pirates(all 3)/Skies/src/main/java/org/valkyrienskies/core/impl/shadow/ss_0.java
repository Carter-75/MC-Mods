/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.sg
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.rL;
import org.valkyrienskies.core.impl.shadow.rV;
import org.valkyrienskies.core.impl.shadow.rY;
import org.valkyrienskies.core.impl.shadow.rs_0;
import org.valkyrienskies.core.impl.shadow.sb_0;
import org.valkyrienskies.core.impl.shadow.sf_0;
import org.valkyrienskies.core.impl.shadow.sg;
import org.valkyrienskies.core.impl.shadow.sg_0;
import org.valkyrienskies.core.impl.shadow.sj_0;
import org.valkyrienskies.core.impl.shadow.sl_0;
import org.valkyrienskies.core.impl.shadow.sq_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.ss
 */
public final class ss_0
extends rL<sq_0, sj_0> {
    public ss_0(rV<sq_0> rV2, rY<sj_0> rY2) {
        super(rV2, rY2);
    }

    @Override
    public final rL<sq_0, sj_0> a(rV<sq_0> rV2, rY<sj_0> rY2) {
        return new ss_0(rV2, rY2);
    }

    @Override
    public final sb_0.a<sq_0> a(rV<sq_0> object) {
        Object object2;
        sl_0 sl_02;
        block3: {
            block2: {
                sl_0 sl_03;
                sl_02 = (sl_0)this.c();
                object = (sl_0)object;
                sl_0 sl_04 = sl_02;
                object2 = sl_04;
                object2 = object;
                double d2 = rs_0.a(sl_04.a, ((sl_0)object2).a);
                object2 = sl_02;
                if (d2 < ((sl_0)object2).d) break block2;
                object2 = sl_02;
                if (!(d2 > Math.PI - sl_03.d)) break block3;
            }
            return new sb_0.a<sq_0>(null, null);
        }
        object = sl_02.a((sl_0)object);
        Object object3 = object = ((sg)this.d()).a((sf_0)object);
        object2 = ((sg_0.b)object).a;
        object3 = object;
        object = ((sg_0.b)object3).b;
        return new sb_0.a<sq_0>(object2 == null ? null : new ss_0(sl_02.a(), (rY<sj_0>)object2), object == null ? null : new ss_0(sl_02.a(), (rY<sj_0>)object));
    }
}

