/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.valkyrienskies.core.impl.shadow.pc_0;
import org.valkyrienskies.core.impl.shadow.uA;
import org.valkyrienskies.core.impl.shadow.uE;
import org.valkyrienskies.core.impl.shadow.wm_0;
import org.valkyrienskies.core.impl.shadow.ws_0;

final class vJ
extends wm_0 {
    private static final long n = 20111120L;
    private static final double o = 0.054293734116568765;
    private static final double p = 4.450312892752409;
    private static final double q = 1.8915178993145003;
    private static final double r = -5.801203960010585;
    private static final double s = 0.3111643669578199;
    private static final double t = -0.1521609496625161;
    private static final double u = 0.20136540080403034;
    private static final double v = 0.04471061572777259;
    private static final double w = 0.1;
    private static final double x = 0.0018737681664791894;
    private static final double y = -4.450312892752409;
    private static final double z = -1.6380176890978755;
    private static final double A = 5.554964922539782;
    private static final double B = -0.4353557902216363;
    private static final double C = 0.30545274794128174;
    private static final double D = -0.19316434850839564;
    private static final double E = -0.03714271806722689;
    private static final double F = -0.008298;
    private static final double G = 0.2;
    private static final double H = -0.022459085953066622;
    private static final double I = -4.422011983080043;
    private static final double J = -1.8379759110070617;
    private static final double K = 5.746280211439194;
    private static final double L = -0.3111643669578199;
    private static final double M = 0.1521609496625161;
    private static final double N = -0.2014737481327276;
    private static final double O = -0.04432804463693693;
    private static final double P = -3.4046500868740456E-4;
    private static final double Q = 0.1413124436746325;
    private static final double R = 0.7777777777777778;
    private static final double S = -0.4831900357003607;
    private static final double T = -9.147934308113573;
    private static final double U = 5.791903296748099;
    private static final double V = 9.870193778407696;
    private static final double W = 0.04556282049746119;
    private static final double X = 0.1521609496625161;
    private static final double Y = -0.20136540080403034;
    private static final double Z = -0.04471061572777259;
    private static final double aa = -0.0013990241651590145;
    private static final double ab = 2.9475147891527724;
    private static final double ac = -9.15095847217987;
    private static final double[][] ad = new double[][]{{-8.428938276109013, 0.5667149535193777, -3.0689499459498917, 2.38466765651207, 2.1170345824450285, -0.871391583777973, 2.2404374302607883, 0.6315787787694688, -0.08899033645133331, 18.148505520854727, -9.194632392478356, -4.436036387594894}, {10.427508642579134, 242.28349177525817, 165.20045171727028, -374.5467547226902, -22.113666853125302, 7.733432668472264, -30.674084731089398, -9.332130526430229, 15.697238121770845, -31.139403219565178, -9.35292435884448, 35.81684148639408}, {19.985053242002433, -387.0373087493518, -189.17813819516758, 527.8081592054236, -11.573902539959631, 6.8812326946963, -1.0006050966910838, 0.7777137798053443, -2.778205752353508, -60.19669523126412, 84.32040550667716, 11.99229113618279}, {-25.69393346270375, -154.18974869023643, -231.5293791760455, 357.6391179106141, 93.4053241836243, -37.45832313645163, 104.0996495089623, 29.8402934266605, -43.53345659001114, 96.32455395918828, -39.17726167561544, -149.72683625798564}};
    private double[][] ae;
    private double[][] af;
    private boolean ag;

    public vJ() {
        this.ae = null;
        this.af = null;
        this.ag = false;
    }

    private vJ(vJ vJ2) {
        super(vJ2);
        int n2;
        if (vJ2.e == null) {
            this.ae = null;
            this.af = null;
            this.ag = false;
            return;
        }
        int n3 = vJ2.e.length;
        this.ae = new double[3][];
        for (n2 = 0; n2 < this.ae.length; ++n2) {
            this.ae[n2] = new double[n3];
            System.arraycopy(vJ2.ae[n2], 0, this.ae[n2], 0, n3);
        }
        this.af = new double[7][];
        for (n2 = 0; n2 < this.af.length; ++n2) {
            this.af[n2] = new double[n3];
            System.arraycopy(vJ2.af[n2], 0, this.af[n2], 0, n3);
        }
        this.ag = vJ2.ag;
    }

    public final ws_0 a() {
        return new vJ(this);
    }

    public final void a(uA uA2, double[] dArray, double[][] dArray2, boolean bl, uE uE2, uE[] uEArray) {
        int n2;
        super.a(uA2, dArray, dArray2, bl, uE2, uEArray);
        int n3 = this.e.length;
        this.ae = new double[3][];
        for (n2 = 0; n2 < this.ae.length; ++n2) {
            this.ae[n2] = new double[n3];
        }
        this.af = new double[7][];
        for (n2 = 0; n2 < this.af.length; ++n2) {
            this.af[n2] = new double[n3];
        }
        this.ag = false;
    }

    public final void a(double d2) {
        super.a(d2);
        this.ag = false;
    }

    public final void a(double d2, double d3) {
        if (!this.ag) {
            int n2;
            if (this.af == null) {
                this.af = new double[7][];
                for (n2 = 0; n2 < 7; ++n2) {
                    this.af[n2] = new double[this.g.length];
                }
            }
            this.m();
            for (n2 = 0; n2 < this.g.length; ++n2) {
                double d4 = this.b[0][n2];
                double d5 = this.b[5][n2];
                double d6 = this.b[6][n2];
                double d7 = this.b[7][n2];
                double d8 = this.b[8][n2];
                double d9 = this.b[9][n2];
                double d10 = this.b[10][n2];
                double d11 = this.b[11][n2];
                double d12 = this.b[12][n2];
                double d13 = this.ae[0][n2];
                double d14 = this.ae[1][n2];
                double d15 = this.ae[2][n2];
                this.af[0][n2] = d4 * 0.054293734116568765 + d5 * 4.450312892752409 + d6 * 1.8915178993145003 + d7 * -5.801203960010585 + d8 * 0.3111643669578199 + d9 * -0.1521609496625161 + d10 * 0.20136540080403034 + d11 * 0.04471061572777259;
                this.af[1][n2] = d4 - this.af[0][n2];
                this.af[2][n2] = this.af[0][n2] - this.af[1][n2] - this.b[12][n2];
                for (int i2 = 0; i2 < ad.length; ++i2) {
                    this.af[i2 + 3][n2] = ad[i2][0] * d4 + ad[i2][1] * d5 + ad[i2][2] * d6 + ad[i2][3] * d7 + ad[i2][4] * d8 + ad[i2][5] * d9 + ad[i2][6] * d10 + ad[i2][7] * d11 + ad[i2][8] * d12 + ad[i2][9] * d13 + ad[i2][10] * d14 + ad[i2][11] * d15;
                }
            }
            this.ag = true;
        }
        double d16 = 1.0 - d2;
        double d17 = d2 * 2.0;
        double d18 = d2;
        double d19 = d18 * d18;
        double d20 = 1.0 - d17;
        double d21 = d2 * (2.0 - d2 * 3.0);
        double d22 = d17 * (1.0 + d2 * (d17 - 3.0));
        double d23 = d19 * (3.0 + d2 * (5.0 * d2 - 8.0));
        double d24 = d19 * (3.0 + d2 * (-12.0 + d2 * (15.0 - d2 * 6.0)));
        double d25 = d19 * d2 * (4.0 + d2 * (-15.0 + d2 * (18.0 - d2 * 7.0)));
        if (this.a != null && d2 <= 0.5) {
            for (int i3 = 0; i3 < this.g.length; ++i3) {
                this.g[i3] = this.a[i3] + d2 * this.d * (this.af[0][i3] + d16 * (this.af[1][i3] + d2 * (this.af[2][i3] + d16 * (this.af[3][i3] + d2 * (this.af[4][i3] + d16 * (this.af[5][i3] + d2 * this.af[6][i3]))))));
                this.h[i3] = this.af[0][i3] + d20 * this.af[1][i3] + d21 * this.af[2][i3] + d22 * this.af[3][i3] + d23 * this.af[4][i3] + d24 * this.af[5][i3] + d25 * this.af[6][i3];
            }
            return;
        }
        for (int i4 = 0; i4 < this.g.length; ++i4) {
            this.g[i4] = this.e[i4] - d3 * (this.af[0][i4] - d2 * (this.af[1][i4] + d2 * (this.af[2][i4] + d16 * (this.af[3][i4] + d2 * (this.af[4][i4] + d16 * (this.af[5][i4] + d2 * this.af[6][i4]))))));
            this.h[i4] = this.af[0][i4] + d20 * this.af[1][i4] + d21 * this.af[2][i4] + d22 * this.af[3][i4] + d23 * this.af[4][i4] + d24 * this.af[5][i4] + d25 * this.af[6][i4];
        }
    }

    public final void b() {
        double d2;
        int n2;
        if (this.e == null) {
            return;
        }
        double[] dArray = new double[this.e.length];
        double d3 = this.e();
        for (n2 = 0; n2 < this.e.length; ++n2) {
            d2 = 0.0018737681664791894 * this.b[0][n2] + -4.450312892752409 * this.b[5][n2] + -1.6380176890978755 * this.b[6][n2] + 5.554964922539782 * this.b[7][n2] + -0.4353557902216363 * this.b[8][n2] + 0.30545274794128174 * this.b[9][n2] + -0.19316434850839564 * this.b[10][n2] + -0.03714271806722689 * this.b[11][n2] + -0.008298 * this.b[12][n2];
            dArray[n2] = this.e[n2] + this.d * d2;
        }
        this.c.a(d3 + 0.1 * this.d, dArray, this.ae[0]);
        for (n2 = 0; n2 < this.e.length; ++n2) {
            d2 = -0.022459085953066622 * this.b[0][n2] + -4.422011983080043 * this.b[5][n2] + -1.8379759110070617 * this.b[6][n2] + 5.746280211439194 * this.b[7][n2] + -0.3111643669578199 * this.b[8][n2] + 0.1521609496625161 * this.b[9][n2] + -0.2014737481327276 * this.b[10][n2] + -0.04432804463693693 * this.b[11][n2] + -3.4046500868740456E-4 * this.b[12][n2] + 0.1413124436746325 * this.ae[0][n2];
            dArray[n2] = this.e[n2] + this.d * d2;
        }
        this.c.a(d3 + 0.2 * this.d, dArray, this.ae[1]);
        for (n2 = 0; n2 < this.e.length; ++n2) {
            d2 = -0.4831900357003607 * this.b[0][n2] + -9.147934308113573 * this.b[5][n2] + 5.791903296748099 * this.b[6][n2] + 9.870193778407696 * this.b[7][n2] + 0.04556282049746119 * this.b[8][n2] + 0.1521609496625161 * this.b[9][n2] + -0.20136540080403034 * this.b[10][n2] + -0.04471061572777259 * this.b[11][n2] + -0.0013990241651590145 * this.b[12][n2] + 2.9475147891527724 * this.ae[0][n2] + -9.15095847217987 * this.ae[1][n2];
            dArray[n2] = this.e[n2] + this.d * d2;
        }
        this.c.a(d3 + 0.7777777777777778 * this.d, dArray, this.ae[2]);
    }

    /*
     * WARNING - void declaration
     */
    public final void writeExternal(ObjectOutput out) {
        void var1_1;
        try {
            this.m();
        }
        catch (pc_0 pc_02) {
            IOException iOException = new IOException(pc_02.getLocalizedMessage());
            iOException.initCause(pc_02);
            throw iOException;
        }
        int n2 = this.e == null ? -1 : this.e.length;
        out.writeInt(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            out.writeDouble(this.ae[0][i2]);
            out.writeDouble(this.ae[1][i2]);
            out.writeDouble(this.ae[2][i2]);
        }
        super.writeExternal((ObjectOutput)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    public final void readExternal(ObjectInput in) {
        void var1_1;
        this.ae = new double[3][];
        int n2 = in.readInt();
        this.ae[0] = n2 < 0 ? null : new double[n2];
        this.ae[1] = n2 < 0 ? null : new double[n2];
        this.ae[2] = n2 < 0 ? null : new double[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            this.ae[0][i2] = in.readDouble();
            this.ae[1][i2] = in.readDouble();
            this.ae[2][i2] = in.readDouble();
        }
        super.readExternal((ObjectInput)var1_1);
    }
}

