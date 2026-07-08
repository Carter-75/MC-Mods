/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.PrintStream;
import org.valkyrienskies.core.impl.shadow.oS;

final class BZ {
    private static final long a = 0x40000000L;
    private static final double[] b = new double[]{1.0, 1.0, 2.0, 6.0, 24.0, 120.0, 720.0, 5040.0, 40320.0, 362880.0, 3628800.0, 3.99168E7, 4.790016E8, 6.2270208E9, 8.71782912E10, 1.307674368E12, 2.0922789888E13, 3.55687428096E14, 6.402373705728E15, 1.21645100408832E17};
    private static final double[][] c = new double[][]{{2.0, 0.0}, {0.6666666269302368, 3.9736429850260626E-8}, {0.3999999761581421, 2.3841857910019882E-8}, {0.2857142686843872, 1.7029898543501842E-8}, {0.2222222089767456, 1.3245471311735498E-8}, {0.1818181574344635, 2.4384203044354907E-8}, {0.1538461446762085, 9.140260083262505E-9}, {0.13333332538604736, 9.220590270857665E-9}, {0.11764700710773468, 1.2393345855018391E-8}, {0.10526403784751892, 8.251545029714408E-9}, {0.0952233225107193, 1.2675934823758863E-8}, {0.08713622391223907, 1.1430250008909141E-8}, {0.07842259109020233, 2.404307984052299E-9}, {0.08371849358081818, 1.176342548272881E-8}, {0.03058958f, 1.2958646899018938E-9}, {0.14982303977012634, 1.225743062930824E-8}};
    private static final String d = "    {";
    private static final String e = "    };";

    private BZ() {
    }

    private static void a(double[] dArray, double[] dArray2, double[] dArray3, double[] dArray4, int n2, double[] dArray5, double[] dArray6) {
        double[] dArray7;
        double[] dArray8;
        double[] dArray9;
        double[] dArray10;
        int n3;
        double[] dArray11 = new double[2];
        for (n3 = 0; n3 < 7; ++n3) {
            double d2 = (double)n3 / 8.0;
            dArray10 = dArray11;
            double d3 = d2;
            dArray9 = new double[2];
            dArray8 = new double[2];
            double[] dArray12 = new double[2];
            double[] dArray13 = new double[2];
            BZ.d(d3, dArray9);
            dArray8[1] = 0.0;
            dArray8[0] = 0.0;
            for (int i2 = b.length - 1; i2 >= 0; --i2) {
                BZ.a(dArray9, dArray8, dArray13);
                dArray8[0] = dArray13[0];
                dArray8[1] = dArray13[1];
                if ((i2 & 1) == 0) continue;
                BZ.d(b[i2], dArray13);
                BZ.a(dArray13, dArray12);
                if ((i2 & 2) != 0) {
                    dArray12[0] = -dArray12[0];
                    dArray12[1] = -dArray12[1];
                }
                BZ.b(dArray8, dArray12, dArray13);
                dArray8[0] = dArray13[0];
                dArray8[1] = dArray13[1];
            }
            dArray10[0] = dArray8[0];
            dArray10[1] = dArray8[1];
            double cfr_ignored_0 = dArray8[0] + dArray8[1];
            dArray[n3] = dArray11[0];
            dArray2[n3] = dArray11[1];
            dArray10 = dArray11;
            double d4 = d2;
            dArray9 = new double[2];
            dArray8 = new double[2];
            dArray12 = new double[2];
            dArray13 = new double[2];
            BZ.d(d4, dArray9);
            dArray8[1] = 0.0;
            dArray8[0] = 0.0;
            for (int i3 = b.length - 1; i3 >= 0; --i3) {
                BZ.a(dArray9, dArray8, dArray13);
                dArray8[0] = dArray13[0];
                dArray8[1] = dArray13[1];
                if ((i3 & 1) != 0) continue;
                BZ.d(b[i3], dArray13);
                BZ.a(dArray13, dArray12);
                if ((i3 & 2) != 0) {
                    dArray12[0] = -dArray12[0];
                    dArray12[1] = -dArray12[1];
                }
                BZ.b(dArray8, dArray12, dArray13);
                dArray8[0] = dArray13[0];
                dArray8[1] = dArray13[1];
            }
            dArray10[0] = dArray8[0];
            dArray10[1] = dArray8[1];
            double cfr_ignored_1 = dArray8[0] + dArray8[1];
            dArray3[n3] = dArray11[0];
            dArray4[n3] = dArray11[1];
        }
        for (n3 = 7; n3 < n2; ++n3) {
            double[] dArray14 = new double[2];
            dArray7 = new double[2];
            dArray10 = new double[2];
            dArray9 = new double[2];
            dArray8 = new double[2];
            if ((n3 & 1) == 0) {
                dArray14[0] = dArray[n3 / 2];
                dArray14[1] = dArray2[n3 / 2];
                dArray7[0] = dArray3[n3 / 2];
                dArray7[1] = dArray4[n3 / 2];
                BZ.a(dArray14, dArray7, dArray11);
                dArray[n3] = dArray11[0] * 2.0;
                dArray2[n3] = dArray11[1] * 2.0;
                BZ.a(dArray7, dArray7, dArray10);
                BZ.a(dArray14, dArray14, dArray8);
                dArray8[0] = -dArray8[0];
                dArray8[1] = -dArray8[1];
                BZ.b(dArray10, dArray8, dArray11);
                dArray3[n3] = dArray11[0];
                dArray4[n3] = dArray11[1];
                continue;
            }
            dArray14[0] = dArray[n3 / 2];
            dArray14[1] = dArray2[n3 / 2];
            dArray7[0] = dArray3[n3 / 2];
            dArray7[1] = dArray4[n3 / 2];
            dArray10[0] = dArray[n3 / 2 + 1];
            dArray10[1] = dArray2[n3 / 2 + 1];
            dArray9[0] = dArray3[n3 / 2 + 1];
            dArray9[1] = dArray4[n3 / 2 + 1];
            BZ.a(dArray14, dArray9, dArray8);
            BZ.a(dArray7, dArray10, dArray11);
            BZ.b(dArray11, dArray8, dArray11);
            dArray[n3] = dArray11[0];
            dArray2[n3] = dArray11[1];
            BZ.a(dArray7, dArray9, dArray11);
            BZ.a(dArray14, dArray10, dArray8);
            dArray8[0] = -dArray8[0];
            dArray8[1] = -dArray8[1];
            BZ.b(dArray11, dArray8, dArray11);
            dArray3[n3] = dArray11[0];
            dArray4[n3] = dArray11[1];
        }
        for (n3 = 0; n3 < n2; ++n3) {
            double[] dArray15 = new double[2];
            dArray7 = new double[2];
            double[] dArray16 = new double[2];
            dArray10 = dArray16;
            dArray16[0] = dArray3[n3];
            dArray10[1] = dArray4[n3];
            BZ.a(dArray10, dArray7);
            dArray15[0] = dArray[n3];
            dArray15[1] = dArray2[n3];
            BZ.a(dArray15, dArray7, dArray10);
            dArray5[n3] = dArray10[0];
            dArray6[n3] = dArray10[1];
        }
    }

    private static double a(double d2, double[] dArray) {
        double[] dArray2 = new double[2];
        double[] dArray3 = new double[2];
        double[] dArray4 = new double[2];
        double[] dArray5 = new double[2];
        BZ.d(d2, dArray2);
        dArray3[1] = 0.0;
        dArray3[0] = 0.0;
        for (int i2 = b.length - 1; i2 >= 0; --i2) {
            BZ.a(dArray2, dArray3, dArray5);
            dArray3[0] = dArray5[0];
            dArray3[1] = dArray5[1];
            if ((i2 & 1) != 0) continue;
            BZ.d(b[i2], dArray5);
            BZ.a(dArray5, dArray4);
            if ((i2 & 2) != 0) {
                dArray4[0] = -dArray4[0];
                dArray4[1] = -dArray4[1];
            }
            BZ.b(dArray3, dArray4, dArray5);
            dArray3[0] = dArray5[0];
            dArray3[1] = dArray5[1];
        }
        dArray[0] = dArray3[0];
        dArray[1] = dArray3[1];
        return dArray3[0] + dArray3[1];
    }

    private static double b(double d2, double[] dArray) {
        double[] dArray2 = new double[2];
        double[] dArray3 = new double[2];
        double[] dArray4 = new double[2];
        double[] dArray5 = new double[2];
        BZ.d(d2, dArray2);
        dArray3[1] = 0.0;
        dArray3[0] = 0.0;
        for (int i2 = b.length - 1; i2 >= 0; --i2) {
            BZ.a(dArray2, dArray3, dArray5);
            dArray3[0] = dArray5[0];
            dArray3[1] = dArray5[1];
            if ((i2 & 1) == 0) continue;
            BZ.d(b[i2], dArray5);
            BZ.a(dArray5, dArray4);
            if ((i2 & 2) != 0) {
                dArray4[0] = -dArray4[0];
                dArray4[1] = -dArray4[1];
            }
            BZ.b(dArray3, dArray4, dArray5);
            dArray3[0] = dArray5[0];
            dArray3[1] = dArray5[1];
        }
        dArray[0] = dArray3[0];
        dArray[1] = dArray3[1];
        return dArray3[0] + dArray3[1];
    }

    private static double c(double d2, double[] dArray) {
        double[] dArray2 = new double[2];
        double[] dArray3 = new double[2];
        double[] dArray4 = new double[2];
        double[] dArray5 = new double[2];
        BZ.d(d2, dArray2);
        dArray3[1] = 0.0;
        dArray3[0] = 0.0;
        for (int i2 = b.length - 1; i2 >= 0; --i2) {
            BZ.a(dArray2, dArray3, dArray5);
            dArray3[0] = dArray5[0];
            dArray3[1] = dArray5[1];
            BZ.d(b[i2], dArray5);
            BZ.a(dArray5, dArray4);
            BZ.b(dArray3, dArray4, dArray5);
            dArray3[0] = dArray5[0];
            dArray3[1] = dArray5[1];
        }
        if (dArray != null) {
            dArray[0] = dArray3[0];
            dArray[1] = dArray3[1];
        }
        return dArray3[0] + dArray3[1];
    }

    private static void d(double d2, double[] dArray) {
        if (d2 < 8.0E298 && d2 > -8.0E298) {
            double d3 = d2 * 1.073741824E9;
            dArray[0] = d2 + d3 - d3;
            dArray[1] = d2 - dArray[0];
            return;
        }
        double d4 = d2 * 9.313225746154785E-10;
        dArray[0] = (d2 + d4 - d2) * 1.073741824E9;
        dArray[1] = d2 - dArray[0];
    }

    private static void a(double[] dArray) {
        double d2 = dArray[0] + dArray[1];
        double d3 = -(d2 - dArray[0] - dArray[1]);
        if (d2 < 8.0E298 && d2 > -8.0E298) {
            double d4 = d2 * 1.073741824E9;
            dArray[0] = d2 + d4 - d4;
            dArray[1] = d2 - dArray[0] + d3;
            return;
        }
        double d5 = d2 * 9.313225746154785E-10;
        dArray[0] = (d2 + d5 - d2) * 1.073741824E9;
        dArray[1] = d2 - dArray[0] + d3;
    }

    private static void a(double[] dArray, double[] dArray2, double[] dArray3) {
        dArray3[0] = dArray[0] * dArray2[0];
        dArray3[1] = dArray[0] * dArray2[1] + dArray[1] * dArray2[0] + dArray[1] * dArray2[1];
        BZ.a(dArray3);
    }

    private static void b(double[] dArray, double[] dArray2, double[] dArray3) {
        dArray3[0] = dArray[0] + dArray2[0];
        dArray3[1] = dArray[1] + dArray2[1];
        BZ.a(dArray3);
    }

    private static void a(double[] dArray, double[] dArray2) {
        if (dArray[0] == 0.0) {
            dArray[0] = dArray[1];
            dArray[1] = 0.0;
        }
        dArray2[0] = 0.9999997615814209 / dArray[0];
        dArray2[1] = (2.384185791015625E-7 * dArray[0] - 0.9999997615814209 * dArray[1]) / (dArray[0] * dArray[0] + dArray[0] * dArray[1]);
        if (dArray2[1] != dArray2[1]) {
            dArray2[1] = 0.0;
        }
        BZ.a(dArray2);
        for (int i2 = 0; i2 < 2; ++i2) {
            double d2 = 1.0 - dArray2[0] * dArray[0] - dArray2[0] * dArray[1] - dArray2[1] * dArray[0] - dArray2[1] * dArray[1];
            dArray2[1] = dArray2[1] + (d2 *= dArray2[0] + dArray2[1]);
        }
    }

    private static void c(double[] dArray, double[] dArray2, double[] dArray3) {
        double[] dArray4 = new double[2];
        double[] dArray5 = new double[2];
        double[] dArray6 = new double[2];
        BZ.d(dArray[0], dArray4);
        BZ.d(dArray2[0], dArray5);
        BZ.a(dArray4, dArray5, dArray6);
        dArray3[0] = dArray6[0];
        dArray3[1] = dArray6[1];
        BZ.d(dArray2[1], dArray5);
        BZ.a(dArray4, dArray5, dArray6);
        double d2 = dArray3[0] + dArray6[0];
        dArray3[1] = dArray3[1] - (d2 - dArray3[0] - dArray6[0]);
        dArray3[0] = d2;
        d2 = dArray3[0] + dArray6[1];
        dArray3[1] = dArray3[1] - (d2 - dArray3[0] - dArray6[1]);
        dArray3[0] = d2;
        BZ.d(dArray[1], dArray4);
        BZ.d(dArray2[0], dArray5);
        BZ.a(dArray4, dArray5, dArray6);
        d2 = dArray3[0] + dArray6[0];
        dArray3[1] = dArray3[1] - (d2 - dArray3[0] - dArray6[0]);
        dArray3[0] = d2;
        d2 = dArray3[0] + dArray6[1];
        dArray3[1] = dArray3[1] - (d2 - dArray3[0] - dArray6[1]);
        dArray3[0] = d2;
        BZ.d(dArray[1], dArray4);
        BZ.d(dArray2[1], dArray5);
        BZ.a(dArray4, dArray5, dArray6);
        d2 = dArray3[0] + dArray6[0];
        dArray3[1] = dArray3[1] - (d2 - dArray3[0] - dArray6[0]);
        dArray3[0] = d2;
        d2 = dArray3[0] + dArray6[1];
        dArray3[1] = dArray3[1] - (d2 - dArray3[0] - dArray6[1]);
        dArray3[0] = d2;
    }

    private static double a(int n2, double[] dArray) {
        double[] dArray2 = new double[2];
        double[] dArray3 = new double[2];
        double[] dArray4 = new double[2];
        dArray2[0] = Math.E;
        dArray2[1] = 1.4456468917292502E-16;
        BZ.d(1.0, dArray4);
        while (n2 > 0) {
            if ((n2 & 1) != 0) {
                BZ.c(dArray4, dArray2, dArray3);
                dArray4[0] = dArray3[0];
                dArray4[1] = dArray3[1];
            }
            BZ.c(dArray2, dArray2, dArray3);
            dArray2[0] = dArray3[0];
            dArray2[1] = dArray3[1];
            n2 >>= 1;
        }
        if (dArray != null) {
            dArray[0] = dArray4[0];
            dArray[1] = dArray4[1];
            BZ.a(dArray);
        }
        return dArray4[0] + dArray4[1];
    }

    private static double[] a(double d2) {
        double[] dArray = new double[2];
        double[] dArray2 = new double[2];
        double[] dArray3 = new double[2];
        double[] dArray4 = new double[2];
        BZ.d(d2, dArray);
        dArray[0] = dArray[0] + 1.0;
        BZ.a(dArray);
        BZ.a(dArray, dArray4);
        dArray[0] = dArray[0] - 2.0;
        BZ.a(dArray);
        BZ.a(dArray, dArray4, dArray3);
        dArray[0] = dArray3[0];
        dArray[1] = dArray3[1];
        BZ.a(dArray, dArray, dArray2);
        dArray3[0] = c[c.length - 1][0];
        dArray3[1] = c[c.length - 1][1];
        for (int i2 = c.length - 2; i2 >= 0; --i2) {
            BZ.a(dArray3, dArray2, dArray4);
            dArray3[0] = dArray4[0];
            dArray3[1] = dArray4[1];
            BZ.b(dArray3, c[i2], dArray4);
            dArray3[0] = dArray4[0];
            dArray3[1] = dArray4[1];
        }
        BZ.a(dArray3, dArray, dArray4);
        dArray3[0] = dArray4[0];
        dArray3[1] = dArray4[1];
        return dArray3;
    }

    static void a(PrintStream printStream, String string, int n2, double[][] dArray) {
        printStream.println(string);
        BZ.a(1024, dArray.length);
        printStream.println("    { ");
        int n3 = 0;
        double[][] dArray2 = dArray;
        int n4 = dArray.length;
        for (int i2 = 0; i2 < n4; ++i2) {
            double[] dArray3 = dArray2[i2];
            printStream.print("        {");
            for (double d2 : dArray3) {
                printStream.printf("%-25.25s", BZ.b(d2));
            }
            printStream.println("}, // " + n3++);
        }
        printStream.println(e);
    }

    static void a(PrintStream printStream, String object, int n2, double[] dArray) {
        printStream.println((String)object + "=");
        BZ.a(n2, dArray.length);
        printStream.println(d);
        object = dArray;
        n2 = dArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object2 = object[i2];
            printStream.printf("        %s%n", BZ.b((double)object2));
        }
        printStream.println(e);
    }

    private static String b(double d2) {
        double d3 = d2;
        if (d3 != d3) {
            return "Double.NaN,";
        }
        return (d2 >= 0.0 ? "+" : "") + Double.toString(d2) + "d,";
    }

    private static void a(int n2, int n3) {
        if (n2 != n3) {
            throw new oS(n3, n2);
        }
    }
}

