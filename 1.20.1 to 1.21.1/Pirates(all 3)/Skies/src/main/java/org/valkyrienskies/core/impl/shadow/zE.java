/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Collection;
import org.valkyrienskies.core.impl.shadow.oG;
import org.valkyrienskies.core.impl.shadow.oH;
import org.valkyrienskies.core.impl.shadow.oI;
import org.valkyrienskies.core.impl.shadow.oK;
import org.valkyrienskies.core.impl.shadow.oM;
import org.valkyrienskies.core.impl.shadow.oO;
import org.valkyrienskies.core.impl.shadow.oP;
import org.valkyrienskies.core.impl.shadow.oc_0;
import org.valkyrienskies.core.impl.shadow.oe_0;
import org.valkyrienskies.core.impl.shadow.of_0;
import org.valkyrienskies.core.impl.shadow.og_0;
import org.valkyrienskies.core.impl.shadow.oh_0;
import org.valkyrienskies.core.impl.shadow.oi_0;
import org.valkyrienskies.core.impl.shadow.oo_0;
import org.valkyrienskies.core.impl.shadow.op_0;
import org.valkyrienskies.core.impl.shadow.os_0;
import org.valkyrienskies.core.impl.shadow.ot_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zC;
import org.valkyrienskies.core.impl.shadow.zD;
import org.valkyrienskies.core.impl.shadow.zF;
import org.valkyrienskies.core.impl.shadow.zG;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public final class zE
implements Serializable,
zC {
    private static final long b = -626730818244969716L;
    final zD a;

    public zE() {
        this.a = new zD();
    }

    private zE(zF zF2) {
        this.a = new zD(zF2);
    }

    @Deprecated
    final zD a() {
        return this.a;
    }

    @Override
    public final String a(int n2) {
        int n3 = n2;
        Object object = this.a;
        if (n3 <= 0) {
            throw new pk_0(px_0.LENGTH, n3);
        }
        object = ((zD)object).c();
        StringBuilder stringBuilder = new StringBuilder();
        byte[] byArray = new byte[n3 / 2 + 1];
        object.nextBytes(byArray);
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            Object object2 = (int)byArray[i2];
            if (((String)(object2 = Integer.toHexString((Integer)object2 + 128))).length() == 1) {
                object2 = "0" + (String)object2;
            }
            stringBuilder.append((String)object2);
        }
        return stringBuilder.toString().substring(0, n3);
    }

    @Override
    public final int a(int n2, int n3) {
        int n4 = n3;
        n3 = n2;
        zD zD2 = this.a;
        return ((oc_0)new oM(zD2.c(), n3, n4)).a();
    }

    @Override
    public final long a(long l2, long l3) {
        return this.a.a(l2, l3);
    }

    @Override
    public final String b(int n2) {
        return this.a.b(n2);
    }

    @Override
    public final int b(int n2, int n3) {
        int n4 = n3;
        n3 = n2;
        zD zD2 = this.a;
        return ((oc_0)new oM(zD2.d(), n3, n4)).a();
    }

    @Override
    public final long b(long l2, long l3) {
        long l4 = l3;
        long l5 = l2;
        Object object = this.a;
        if (l5 >= l4) {
            throw new pm_0(px_0.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, (Number)l5, l4, false);
        }
        object = ((zD)object).d();
        long l6 = l4 - l5 + 1L;
        if (l6 <= 0L) {
            long l7;
            while ((l7 = object.nextLong()) < l5 || l7 > l4) {
            }
            return l7;
        }
        if (l6 < Integer.MAX_VALUE) {
            return l5 + (long)object.nextInt((int)l6);
        }
        return l5 + zD.a((zF)object, l6);
    }

    @Override
    public final long a(double d2) {
        double d3 = d2;
        zD zD2 = this.a;
        return ((oc_0)new oH(zD2.c(), d3, 1.0E-12, 10000000)).a();
    }

    @Override
    public final double a(double d2, double d3) {
        return this.a.a(d2, d3);
    }

    @Override
    public final double b(double d2) {
        return this.a.b(d2);
    }

    @Override
    public final double b(double d2, double d3) {
        double d4 = d3;
        double d5 = d2;
        zD zD2 = this.a;
        return zD2.a(d5, d4, false);
    }

    @Override
    public final double a(double d2, double d3, boolean bl) {
        return this.a.a(d2, d3, bl);
    }

    private double c(double d2, double d3) {
        double d4 = d3;
        double d5 = d2;
        zD zD2 = this.a;
        return ((oe_0)new of_0(zD2.c(), d5, d4, 1.0E-9)).b();
    }

    private int a(int n2, double d2) {
        double d3 = d2;
        int n3 = n2;
        zD zD2 = this.a;
        return new og_0(zD2.c(), n3, d3).a();
    }

    private double d(double d2, double d3) {
        double d4 = d3;
        double d5 = d2;
        zD zD2 = this.a;
        return new oh_0(zD2.c(), d5, d4, 1.0E-9).b();
    }

    private double c(double d2) {
        double d3 = d2;
        zD zD2 = this.a;
        return new oi_0(zD2.c(), d3, 1.0E-9).b();
    }

    private double e(double d2, double d3) {
        double d4 = d3;
        double d5 = d2;
        zD zD2 = this.a;
        return new oo_0(zD2.c(), d5, d4, 1.0E-9).b();
    }

    private double f(double d2, double d3) {
        double d4 = d3;
        double d5 = d2;
        zD zD2 = this.a;
        return ((oe_0)new op_0(zD2.c(), d5, d4, 1.0E-9)).b();
    }

    private int a(int n2, int n3, int n4) {
        int n5 = n4;
        n4 = n3;
        n3 = n2;
        zD zD2 = this.a;
        return new os_0(zD2.c(), n3, n4, n5).a();
    }

    private int b(int n2, double d2) {
        double d3 = d2;
        int n3 = n2;
        zD zD2 = this.a;
        return new oG(zD2.c(), n3, d3).a();
    }

    private double d(double d2) {
        double d3 = d2;
        zD zD2 = this.a;
        return new oK(zD2.c(), d3, 1.0E-9).b();
    }

    private double g(double d2, double d3) {
        double d4 = d3;
        double d5 = d2;
        zD zD2 = this.a;
        return new oO(zD2.c(), d5, d4, 1.0E-9).b();
    }

    private int c(int n2, double d2) {
        double d3 = d2;
        int n3 = n2;
        zD zD2 = this.a;
        return ((oc_0)new oP(zD2.c(), n3, d3)).a();
    }

    public final void a(long l2) {
        this.a.a(l2);
    }

    private void b() {
        zD zD2 = this.a;
        zD2.d().setSeed(System.currentTimeMillis());
    }

    private void b(long l2) {
        long l3 = l2;
        zD zD2 = this.a;
        zD2.d().setSeed(l3);
    }

    private void c() {
        zD zD2 = this.a;
        zD2.c().setSeed(System.currentTimeMillis() + (long)System.identityHashCode(zD2));
    }

    private void a(String object, String string) {
        String string2 = string;
        string = object;
        object = this.a;
        this.a.a = zG.a(SecureRandom.getInstance(string, string2));
    }

    @Override
    public final int[] c(int n2, int n3) {
        return this.a.c(n2, n3);
    }

    @Override
    public final Object[] a(Collection<?> object, int n2) {
        int n3 = n2;
        Object[] objectArray = object;
        object = this.a;
        int n4 = objectArray.size();
        if (n3 > n4) {
            throw new pm_0(px_0.SAMPLE_SIZE_EXCEEDS_COLLECTION_SIZE, (Number)n3, n4, true);
        }
        if (n3 <= 0) {
            throw new pk_0(px_0.NUMBER_OF_SAMPLES, n3);
        }
        objectArray = objectArray.toArray();
        object = ((zD)object).c(n4, n3);
        Object[] objectArray2 = new Object[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            objectArray2[i2] = objectArray[object[i2]];
        }
        return objectArray2;
    }

    @Deprecated
    private double a(oI oI2) {
        return oI2.a(this.b(0.0, 1.0));
    }

    @Deprecated
    private int a(ot_0 ot_02) {
        return ot_02.a(this.b(0.0, 1.0));
    }
}

