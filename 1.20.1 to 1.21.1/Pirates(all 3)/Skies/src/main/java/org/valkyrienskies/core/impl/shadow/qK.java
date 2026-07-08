/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collections;
import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qF;
import org.valkyrienskies.core.impl.shadow.qI;
import org.valkyrienskies.core.impl.shadow.qp_0;
import org.valkyrienskies.core.impl.shadow.qq_0;
import org.valkyrienskies.core.impl.shadow.qt_0;
import org.valkyrienskies.core.impl.shadow.qx_0;
import org.valkyrienskies.core.impl.shadow.qz_0;

public final class qK
implements qI {
    private int a;

    private qK(int n2) {
        this.a = n2;
    }

    public final qq_0 a(qF qF2) {
        return new qq_0(this.a((qz_0)qF2), this.a((qz_0)qF2));
    }

    private qp_0 a(qz_0 object) {
        if (((qz_0)object).f() < this.a) {
            throw new oV(px_0.TOO_LARGE_TOURNAMENT_ARITY, this.a, ((qz_0)object).f());
        }
        qK qK2 = this;
        Object object2 = new qz_0(qK2, qK2.a){
            private /* synthetic */ qK b;
            {
                this.b = qK2;
                super(n2);
            }

            public final qt_0 a() {
                return null;
            }
        };
        object = new ArrayList<qp_0>(Collections.unmodifiableList(((qz_0)object).a));
        for (int i2 = 0; i2 < this.a; ++i2) {
            int n2 = qx_0.a().nextInt(object.size());
            ((qz_0)object2).a((qp_0)object.get(n2));
            object.remove(n2);
        }
        object = object2;
        object2 = ((qz_0)object).a.get(0);
        for (qp_0 qp_02 : ((qz_0)object).a) {
            if (qp_02.b((qp_0)object2) <= 0) continue;
            object2 = qp_02;
        }
        return object2;
    }

    private int a() {
        return this.a;
    }

    private void a(int n2) {
        this.a = n2;
    }
}

