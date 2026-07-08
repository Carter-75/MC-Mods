/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.oY;
import org.valkyrienskies.core.impl.shadow.oZ;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.zH;

public final class zI
implements zH {
    private static final int a = 52;
    private static final double b = BY.a(2.0, 52);
    private static final int c = 1000;
    private static final String d = "/assets/org/apache/commons/math3/random/new-joe-kuo-6.1000";
    private static final String e = "US-ASCII";
    private final int f;
    private int g = 0;
    private final long[][] h;
    private final long[] i;

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private zI(int n2) {
        if (n2 <= 0) throw new po_0(n2, (Number)1, 1000);
        if (n2 > 1000) {
            throw new po_0(n2, (Number)1, 1000);
        }
        InputStream inputStream = this.getClass().getResourceAsStream(d);
        if (inputStream == null) {
            throw new oY();
        }
        this.f = n2;
        this.h = new long[n2][53];
        this.i = new long[n2];
        try {
            this.a(inputStream);
        }
        catch (IOException iOException) {
            try {
                throw new oY();
                catch (oZ oZ2) {
                    throw new oY();
                }
            }
            catch (Throwable throwable) {
                try {
                    inputStream.close();
                    throw throwable;
                }
                catch (IOException iOException2) {}
                throw throwable;
            }
        }
        try {
            inputStream.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    private zI(int n2, InputStream inputStream) {
        if (n2 <= 0) {
            throw new pk_0(n2);
        }
        this.f = n2;
        this.h = new long[n2][53];
        this.i = new long[n2];
        int n3 = this.a(inputStream);
        if (n3 < n2) {
            throw new po_0(n2, (Number)1, n3);
        }
    }

    private int a(InputStream closeable) {
        for (int i2 = 1; i2 <= 52; ++i2) {
            this.h[0][i2] = 1L << 52 - i2;
        }
        Charset charset = Charset.forName(e);
        closeable = new BufferedReader(new InputStreamReader((InputStream)closeable, charset));
        int n2 = -1;
        try {
            String string;
            ((BufferedReader)closeable).readLine();
            int n3 = 2;
            int n4 = 1;
            while ((string = ((BufferedReader)closeable).readLine()) != null) {
                Object object = new StringTokenizer(string, " ");
                try {
                    int n5;
                    n2 = Integer.parseInt(((StringTokenizer)object).nextToken());
                    if (n2 >= 2 && n2 <= this.f) {
                        int n6;
                        int n7;
                        n5 = Integer.parseInt(((StringTokenizer)object).nextToken());
                        int n8 = Integer.parseInt(((StringTokenizer)object).nextToken());
                        int[] nArray = new int[n5 + 1];
                        for (n7 = 1; n7 <= n5; ++n7) {
                            nArray[n7] = Integer.parseInt(((StringTokenizer)object).nextToken());
                        }
                        n5 = n4++;
                        object = this;
                        n7 = nArray.length - 1;
                        for (n6 = 1; n6 <= n7; ++n6) {
                            ((zI)object).h[n5][n6] = (long)nArray[n6] << 52 - n6;
                        }
                        for (n6 = n7 + 1; n6 <= 52; ++n6) {
                            long[] lArray = ((zI)object).h[n5];
                            lArray[n6] = lArray[n6 - n7] ^ ((zI)object).h[n5][n6 - n7] >> n7;
                            for (int i3 = 1; i3 <= n7 - 1; ++i3) {
                                long[] lArray2 = ((zI)object).h[n5];
                                int n9 = n6;
                                lArray2[n9] = lArray2[n9] ^ (long)(n8 >> n7 - 1 - i3 & 1) * ((zI)object).h[n5][n6 - i3];
                            }
                        }
                    }
                    if (n2 > this.f) {
                        n5 = n2;
                        return n5;
                    }
                }
                catch (NoSuchElementException noSuchElementException) {
                    throw new oZ(string, n3);
                }
                catch (NumberFormatException numberFormatException) {
                    throw new oZ(string, n3);
                }
                ++n3;
            }
        }
        finally {
            ((BufferedReader)closeable).close();
        }
        return n2;
    }

    private void a(int n2, int n3, int[] nArray) {
        int n4;
        int n5 = nArray.length - 1;
        for (n4 = 1; n4 <= n5; ++n4) {
            this.h[n2][n4] = (long)nArray[n4] << 52 - n4;
        }
        for (n4 = n5 + 1; n4 <= 52; ++n4) {
            long[] lArray = this.h[n2];
            lArray[n4] = lArray[n4 - n5] ^ this.h[n2][n4 - n5] >> n5;
            for (int i2 = 1; i2 <= n5 - 1; ++i2) {
                long[] lArray2 = this.h[n2];
                int n6 = n4;
                lArray2[n6] = lArray2[n6] ^ (long)(n3 >> n5 - 1 - i2 & 1) * this.h[n2][n4 - i2];
            }
        }
    }

    public final double[] a() {
        double[] dArray = new double[this.f];
        if (this.g == 0) {
            ++this.g;
            return dArray;
        }
        int n2 = 1;
        int n3 = this.g - 1;
        while ((n3 & 1) == 1) {
            n3 >>= 1;
            ++n2;
        }
        for (n3 = 0; n3 < this.f; ++n3) {
            int n4 = n3;
            this.i[n4] = this.i[n4] ^ this.h[n3][n2];
            dArray[n3] = (double)this.i[n3] / b;
        }
        ++this.g;
        return dArray;
    }

    private double[] a(int n2) {
        if (n2 == 0) {
            Arrays.fill(this.i, 0L);
        } else {
            int n3 = n2 - 1;
            long l2 = n3 ^ n3 >> 1;
            for (n3 = 0; n3 < this.f; ++n3) {
                long l3;
                long l4 = 0L;
                for (int i2 = 1; i2 <= 52 && (l3 = l2 >> i2 - 1) != 0L; ++i2) {
                    long l5 = l3 & 1L;
                    l4 ^= l5 * this.h[n3][i2];
                }
                this.i[n3] = l4;
            }
        }
        this.g = n2;
        return this.a();
    }

    private int b() {
        return this.g;
    }
}

