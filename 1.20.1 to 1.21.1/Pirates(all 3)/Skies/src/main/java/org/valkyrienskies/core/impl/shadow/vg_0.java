/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.vh
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.vh;
import org.valkyrienskies.core.impl.shadow.vh_0;
import org.valkyrienskies.core.impl.shadow.vl_0;
import org.valkyrienskies.core.impl.shadow.vm_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.vg
 */
public final class vg_0
implements vh {
    private static final int a = 100;
    private final vh_0 b;
    private final vl_0 c;
    private final vm_0[] d;
    private final double[] e;
    private boolean f;
    private double g;

    private vg_0(vh_0 vh_02, vl_0 vl_02) {
        this.b = vh_02;
        this.c = vl_02;
        this.d = new vm_0[100];
        this.e = new double[100];
    }

    public final void a(double d2, double[] dArray, double d3) {
        this.b.a(d2, dArray, d3);
        this.f = d3 >= d2;
        this.g = this.f ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
        Arrays.fill((Object[])this.d, (Object)vm_0.UNINITIALIZED);
        Arrays.fill(this.e, this.g);
    }

    public final double a(double d2, double[] object) {
        double d3 = this.b.a(d2, (double[])object);
        if (this.f) {
            int n2 = this.d.length - 1;
            if (this.g < d2) {
                vm_0 vm_02 = this.d[n2];
                vm_0 vm_03 = this.c.a(vm_02, d3, this.f);
                if (vm_03 != vm_02) {
                    System.arraycopy(this.e, 1, this.e, 0, n2);
                    System.arraycopy(this.d, 1, this.d, 0, n2);
                    this.e[n2] = this.g;
                    this.d[n2] = vm_03;
                }
                this.g = d2;
                return vm_03.a(d3);
            }
            for (int i2 = n2; i2 > 0; --i2) {
                if (!(this.e[i2] <= d2)) continue;
                return this.d[i2].a(d3);
            }
            return this.d[0].a(d3);
        }
        if (d2 < this.g) {
            object = (Object)this.d[0];
            vm_0 vm_04 = this.c.a((vm_0)((Object)object), d3, this.f);
            if (vm_04 != object) {
                System.arraycopy(this.e, 0, this.e, 1, this.e.length - 1);
                System.arraycopy(this.d, 0, this.d, 1, this.d.length - 1);
                this.e[0] = this.g;
                this.d[0] = vm_04;
            }
            this.g = d2;
            return vm_04.a(d3);
        }
        for (int i3 = 0; i3 < this.e.length - 1; ++i3) {
            if (!(d2 <= this.e[i3])) continue;
            return this.d[i3].a(d3);
        }
        return this.d[this.e.length - 1].a(d3);
    }

    public final int b(double d2, double[] dArray) {
        return this.b.b(d2, dArray);
    }

    public final void c(double d2, double[] dArray) {
    }
}

