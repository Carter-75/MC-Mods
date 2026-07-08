/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.um_0;
import org.valkyrienskies.core.impl.shadow.uo_0;
import org.valkyrienskies.core.impl.shadow.up_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.un
 */
public final class un_0 {
    private un_0() {
    }

    private static 1 a(double d2, double d3, long l2) {
        return new um_0(d2, d3, l2){
            private final uo_0 a;
            private /* synthetic */ double b;
            private /* synthetic */ double c;
            private /* synthetic */ long d;
            {
                this.b = d2;
                this.c = d3;
                this.d = l2;
                this.a = new uo_0(this.b, this.c, this.d);
            }

            public final int a(long l2) {
                return (int)BY.A(this.a.a(l2));
            }
        };
    }

    private static 2 b(double d2, double d3, long l2) {
        return new um_0(d2, d3, l2){
            private final up_0 a;
            private /* synthetic */ double b;
            private /* synthetic */ double c;
            private /* synthetic */ long d;
            {
                this.b = d2;
                this.c = d3;
                this.d = l2;
                this.a = new up_0(this.b, this.c, this.d);
            }

            public final int a(long l2) {
                return (int)BY.A(this.a.a(l2));
            }
        };
    }
}

