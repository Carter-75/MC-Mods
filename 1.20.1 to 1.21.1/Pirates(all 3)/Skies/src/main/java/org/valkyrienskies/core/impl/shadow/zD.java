/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Collection;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.oG;
import org.valkyrienskies.core.impl.shadow.oH;
import org.valkyrienskies.core.impl.shadow.oK;
import org.valkyrienskies.core.impl.shadow.oM;
import org.valkyrienskies.core.impl.shadow.oO;
import org.valkyrienskies.core.impl.shadow.oP;
import org.valkyrienskies.core.impl.shadow.oY;
import org.valkyrienskies.core.impl.shadow.oc_0;
import org.valkyrienskies.core.impl.shadow.oe_0;
import org.valkyrienskies.core.impl.shadow.of_0;
import org.valkyrienskies.core.impl.shadow.og_0;
import org.valkyrienskies.core.impl.shadow.oh_0;
import org.valkyrienskies.core.impl.shadow.oi_0;
import org.valkyrienskies.core.impl.shadow.on_0;
import org.valkyrienskies.core.impl.shadow.oo_0;
import org.valkyrienskies.core.impl.shadow.op_0;
import org.valkyrienskies.core.impl.shadow.os_0;
import org.valkyrienskies.core.impl.shadow.ph_0;
import org.valkyrienskies.core.impl.shadow.pi_0;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.zC;
import org.valkyrienskies.core.impl.shadow.zF;
import org.valkyrienskies.core.impl.shadow.zG;
import org.valkyrienskies.core.impl.shadow.zR;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class zD
implements Serializable,
zC {
    private static final long b = -626730818244969716L;
    private zF c = null;
    zF a = null;

    public zD() {
    }

    public zD(zF zF2) {
        this.c = zF2;
    }

    @Override
    public final String a(int n2) {
        if (n2 <= 0) {
            throw new pk_0(px_0.LENGTH, n2);
        }
        zF zF2 = this.c();
        StringBuilder stringBuilder = new StringBuilder();
        byte[] byArray = new byte[n2 / 2 + 1];
        zF2.nextBytes(byArray);
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            Object object = (int)byArray[i2];
            if (((String)(object = Integer.toHexString((Integer)object + 128))).length() == 1) {
                object = "0" + (String)object;
            }
            stringBuilder.append((String)object);
        }
        return stringBuilder.toString().substring(0, n2);
    }

    @Override
    public final int a(int n2, int n3) {
        return ((oc_0)new oM(this.c(), n2, n3)).a();
    }

    @Override
    public final long a(long l2, long l3) {
        if (l2 >= l3) {
            throw new pm_0(px_0.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, (Number)l2, l3, false);
        }
        long l4 = l3 - l2 + 1L;
        if (l4 <= 0L) {
            long l5;
            zF zF2 = this.c();
            while ((l5 = zF2.nextLong()) < l2 || l5 > l3) {
            }
            return l5;
        }
        if (l4 < Integer.MAX_VALUE) {
            return l2 + (long)this.c().nextInt((int)l4);
        }
        return l2 + zD.a(this.c(), l4);
    }

    static long a(zF zF2, long l2) {
        if (l2 > 0L) {
            long l3;
            long l4;
            byte[] byArray = new byte[8];
            do {
                zF2.nextBytes(byArray);
                l3 = 0L;
                byte[] byArray2 = byArray;
                int cfr_ignored_0 = byArray.length;
                for (int i2 = 0; i2 < 8; ++i2) {
                    byte by = byArray2[i2];
                    l3 = l3 << 8 | (long)by & 0xFFL;
                }
            } while ((l3 &= Long.MAX_VALUE) - (l4 = l3 % l2) + (l2 - 1L) < 0L);
            return l4;
        }
        throw new pk_0(l2);
    }

    @Override
    public final String b(int n2) {
        MessageDigest messageDigest;
        if (n2 <= 0) {
            throw new pk_0(px_0.LENGTH, n2);
        }
        zF zF2 = this.d();
        try {
            messageDigest = MessageDigest.getInstance("SHA-1");
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new oY(noSuchAlgorithmException);
        }
        messageDigest.reset();
        int n3 = n2 / 40 + 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 1; i2 < n3 + 1; ++i2) {
            byte[] byArray = new byte[40];
            zF2.nextBytes(byArray);
            messageDigest.update(byArray);
            byArray = messageDigest.digest();
            for (int i3 = 0; i3 < byArray.length; ++i3) {
                Object object = (int)byArray[i3];
                if (((String)(object = Integer.toHexString((Integer)object + 128))).length() == 1) {
                    object = "0" + (String)object;
                }
                stringBuilder.append((String)object);
            }
        }
        return stringBuilder.toString().substring(0, n2);
    }

    @Override
    public final int b(int n2, int n3) {
        return ((oc_0)new oM(this.d(), n2, n3)).a();
    }

    @Override
    public final long b(long l2, long l3) {
        if (l2 >= l3) {
            throw new pm_0(px_0.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, (Number)l2, l3, false);
        }
        zF zF2 = this.d();
        long l4 = l3 - l2 + 1L;
        if (l4 <= 0L) {
            long l5;
            while ((l5 = zF2.nextLong()) < l2 || l5 > l3) {
            }
            return l5;
        }
        if (l4 < Integer.MAX_VALUE) {
            return l2 + (long)zF2.nextInt((int)l4);
        }
        return l2 + zD.a(zF2, l4);
    }

    @Override
    public final long a(double d2) {
        return ((oc_0)new oH(this.c(), d2, 1.0E-12, 10000000)).a();
    }

    @Override
    public final double a(double d2, double d3) {
        if (d3 <= 0.0) {
            throw new pk_0(px_0.STANDARD_DEVIATION, d3);
        }
        return d3 * this.c().nextGaussian() + d2;
    }

    @Override
    public final double b(double d2) {
        return ((oe_0)new on_0(this.c(), d2, 1.0E-9)).b();
    }

    public final double c(double d2, double d3) {
        return ((oe_0)new op_0(this.c(), d2, d3, 1.0E-9)).b();
    }

    public final int a(int n2, int n3, int n4) {
        return new os_0(this.c(), n2, n3, n4).a();
    }

    public final int a(int n2, double d2) {
        return new oG(this.c(), n2, d2).a();
    }

    public final double c(double d2) {
        return new oK(this.c(), d2, 1.0E-9).b();
    }

    public final double d(double d2, double d3) {
        return new oO(this.c(), d2, d3, 1.0E-9).b();
    }

    public final int b(int n2, double d2) {
        return ((oc_0)new oP(this.c(), n2, d2)).a();
    }

    public final double e(double d2, double d3) {
        return ((oe_0)new of_0(this.c(), d2, d3, 1.0E-9)).b();
    }

    public final int c(int n2, double d2) {
        return new og_0(this.c(), n2, d2).a();
    }

    public final double f(double d2, double d3) {
        return new oh_0(this.c(), d2, d3, 1.0E-9).b();
    }

    public final double d(double d2) {
        return new oi_0(this.c(), d2, 1.0E-9).b();
    }

    public final double g(double d2, double d3) {
        return new oo_0(this.c(), d2, d3, 1.0E-9).b();
    }

    @Override
    public final double b(double d2, double d3) {
        return this.a(d2, d3, false);
    }

    @Override
    public final double a(double d2, double d3, boolean bl) {
        if (d2 >= d3) {
            throw new pm_0(px_0.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, (Number)d2, d3, false);
        }
        if (Double.isInfinite(d2)) {
            throw new pi_0(px_0.INFINITE_BOUND, (Number)d2, new Object[0]);
        }
        if (Double.isInfinite(d3)) {
            throw new pi_0(px_0.INFINITE_BOUND, (Number)d3, new Object[0]);
        }
        if (Double.isNaN(d2) || Double.isNaN(d3)) {
            throw new ph_0();
        }
        zF zF2 = this.c();
        double d4 = zF2.nextDouble();
        while (!bl && d4 <= 0.0) {
            d4 = zF2.nextDouble();
        }
        return d4 * d3 + (1.0 - d4) * d2;
    }

    @Override
    public final int[] c(int n2, int n3) {
        if (n3 > n2) {
            throw new pm_0(px_0.PERMUTATION_EXCEEDS_N, (Number)n3, n2, true);
        }
        if (n3 <= 0) {
            throw new pk_0(px_0.PERMUTATION_SIZE, n3);
        }
        int[] nArray = ch_0.a(n2, 0, 1);
        ch_0.a(nArray, this.c());
        return ch_0.a(nArray, n3);
    }

    @Override
    public final Object[] a(Collection<?> objectArray, int n2) {
        int n3 = objectArray.size();
        if (n2 > n3) {
            throw new pm_0(px_0.SAMPLE_SIZE_EXCEEDS_COLLECTION_SIZE, (Number)n2, n3, true);
        }
        if (n2 <= 0) {
            throw new pk_0(px_0.NUMBER_OF_SAMPLES, n2);
        }
        objectArray = objectArray.toArray();
        int[] nArray = this.c(n3, n2);
        Object[] objectArray2 = new Object[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            objectArray2[i2] = objectArray[nArray[i2]];
        }
        return objectArray2;
    }

    public final void a(long l2) {
        this.c().setSeed(l2);
    }

    public final void a() {
        this.d().setSeed(System.currentTimeMillis());
    }

    public final void b(long l2) {
        this.d().setSeed(l2);
    }

    public final void b() {
        this.c().setSeed(System.currentTimeMillis() + (long)System.identityHashCode(this));
    }

    public final void a(String string, String string2) {
        this.a = zG.a(SecureRandom.getInstance(string, string2));
    }

    public final zF c() {
        if (this.c == null) {
            this.e();
        }
        return this.c;
    }

    private void e() {
        this.c = new zR(System.currentTimeMillis() + (long)System.identityHashCode(this));
    }

    zF d() {
        if (this.a == null) {
            this.a = zG.a(new SecureRandom());
            this.a.setSeed(System.currentTimeMillis() + (long)System.identityHashCode(this));
        }
        return this.a;
    }
}

