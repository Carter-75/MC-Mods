/*
 * Decompiled with CFR 0.152.
 */
package org.joml;

import org.joml.Math;
import org.joml.Matrix3d;
import org.joml.Quaterniond;

public class QuaterniondInterpolator {
    private final SvdDecomposition3d svdDecomposition3d = new SvdDecomposition3d();
    private final double[] m = new double[9];
    private final Matrix3d u = new Matrix3d();
    private final Matrix3d v = new Matrix3d();

    public Quaterniond computeWeightedAverage(Quaterniond[] qs, double[] weights, int maxSvdIterations, Quaterniond dest) {
        double m00 = 0.0;
        double m01 = 0.0;
        double m02 = 0.0;
        double m10 = 0.0;
        double m11 = 0.0;
        double m12 = 0.0;
        double m20 = 0.0;
        double m21 = 0.0;
        double m22 = 0.0;
        for (int i2 = 0; i2 < qs.length; ++i2) {
            Quaterniond q = qs[i2];
            double dx = q.x + q.x;
            double dy = q.y + q.y;
            double dz = q.z + q.z;
            double q00 = dx * q.x;
            double q11 = dy * q.y;
            double q22 = dz * q.z;
            double q01 = dx * q.y;
            double q02 = dx * q.z;
            double q03 = dx * q.w;
            double q12 = dy * q.z;
            double q13 = dy * q.w;
            double q23 = dz * q.w;
            m00 += weights[i2] * (1.0 - q11 - q22);
            m01 += weights[i2] * (q01 + q23);
            m02 += weights[i2] * (q02 - q13);
            m10 += weights[i2] * (q01 - q23);
            m11 += weights[i2] * (1.0 - q22 - q00);
            m12 += weights[i2] * (q12 + q03);
            m20 += weights[i2] * (q02 + q13);
            m21 += weights[i2] * (q12 - q03);
            m22 += weights[i2] * (1.0 - q11 - q00);
        }
        this.m[0] = m00;
        this.m[1] = m01;
        this.m[2] = m02;
        this.m[3] = m10;
        this.m[4] = m11;
        this.m[5] = m12;
        this.m[6] = m20;
        this.m[7] = m21;
        this.m[8] = m22;
        this.svdDecomposition3d.svd(this.m, maxSvdIterations, this.u, this.v);
        this.u.mul(this.v.transpose());
        return dest.setFromNormalized(this.u).normalize();
    }

    private static class SvdDecomposition3d {
        private final double[] rv1 = new double[3];
        private final double[] w = new double[3];
        private final double[] v = new double[9];

        SvdDecomposition3d() {
        }

        private double SIGN(double a2, double b2) {
            return b2 >= 0.0 ? Math.abs(a2) : -Math.abs(a2);
        }

        void svd(double[] a2, int maxIterations, Matrix3d destU, Matrix3d destV) {
            int j2;
            double h2;
            double f2;
            int k2;
            double s;
            int i2;
            int l2 = 0;
            int nm = 0;
            double anorm = 0.0;
            double g2 = 0.0;
            double scale = 0.0;
            for (i2 = 0; i2 < 3; ++i2) {
                l2 = i2 + 1;
                this.rv1[i2] = scale * g2;
                scale = 0.0;
                s = 0.0;
                g2 = 0.0;
                for (k2 = i2; k2 < 3; ++k2) {
                    scale += Math.abs(a2[k2 + 3 * i2]);
                }
                if (scale != 0.0) {
                    for (k2 = i2; k2 < 3; ++k2) {
                        a2[k2 + 3 * i2] = a2[k2 + 3 * i2] / scale;
                        s += a2[k2 + 3 * i2] * a2[k2 + 3 * i2];
                    }
                    f2 = a2[i2 + 3 * i2];
                    g2 = -this.SIGN(Math.sqrt(s), f2);
                    h2 = f2 * g2 - s;
                    a2[i2 + 3 * i2] = f2 - g2;
                    if (i2 != 2) {
                        for (j2 = l2; j2 < 3; ++j2) {
                            s = 0.0;
                            for (k2 = i2; k2 < 3; ++k2) {
                                s += a2[k2 + 3 * i2] * a2[k2 + 3 * j2];
                            }
                            f2 = s / h2;
                            for (k2 = i2; k2 < 3; ++k2) {
                                int n2 = k2 + 3 * j2;
                                a2[n2] = a2[n2] + f2 * a2[k2 + 3 * i2];
                            }
                        }
                    }
                    for (k2 = i2; k2 < 3; ++k2) {
                        a2[k2 + 3 * i2] = a2[k2 + 3 * i2] * scale;
                    }
                }
                this.w[i2] = scale * g2;
                scale = 0.0;
                s = 0.0;
                g2 = 0.0;
                if (i2 < 3 && i2 != 2) {
                    for (k2 = l2; k2 < 3; ++k2) {
                        scale += Math.abs(a2[i2 + 3 * k2]);
                    }
                    if (scale != 0.0) {
                        for (k2 = l2; k2 < 3; ++k2) {
                            a2[i2 + 3 * k2] = a2[i2 + 3 * k2] / scale;
                            s += a2[i2 + 3 * k2] * a2[i2 + 3 * k2];
                        }
                        f2 = a2[i2 + 3 * l2];
                        g2 = -this.SIGN(Math.sqrt(s), f2);
                        h2 = f2 * g2 - s;
                        a2[i2 + 3 * l2] = f2 - g2;
                        for (k2 = l2; k2 < 3; ++k2) {
                            this.rv1[k2] = a2[i2 + 3 * k2] / h2;
                        }
                        if (i2 != 2) {
                            for (j2 = l2; j2 < 3; ++j2) {
                                s = 0.0;
                                for (k2 = l2; k2 < 3; ++k2) {
                                    s += a2[j2 + 3 * k2] * a2[i2 + 3 * k2];
                                }
                                for (k2 = l2; k2 < 3; ++k2) {
                                    int n3 = j2 + 3 * k2;
                                    a2[n3] = a2[n3] + s * this.rv1[k2];
                                }
                            }
                        }
                        for (k2 = l2; k2 < 3; ++k2) {
                            a2[i2 + 3 * k2] = a2[i2 + 3 * k2] * scale;
                        }
                    }
                }
                anorm = Math.max(anorm, Math.abs(this.w[i2]) + Math.abs(this.rv1[i2]));
            }
            i2 = 2;
            while (i2 >= 0) {
                if (i2 < 2) {
                    if (g2 != 0.0) {
                        for (j2 = l2; j2 < 3; ++j2) {
                            this.v[j2 + 3 * i2] = a2[i2 + 3 * j2] / a2[i2 + 3 * l2] / g2;
                        }
                        for (j2 = l2; j2 < 3; ++j2) {
                            s = 0.0;
                            for (k2 = l2; k2 < 3; ++k2) {
                                s += a2[i2 + 3 * k2] * this.v[k2 + 3 * j2];
                            }
                            for (k2 = l2; k2 < 3; ++k2) {
                                int n4 = k2 + 3 * j2;
                                this.v[n4] = this.v[n4] + s * this.v[k2 + 3 * i2];
                            }
                        }
                    }
                    for (j2 = l2; j2 < 3; ++j2) {
                        this.v[j2 + 3 * i2] = 0.0;
                        this.v[i2 + 3 * j2] = 0.0;
                    }
                }
                this.v[i2 + 3 * i2] = 1.0;
                g2 = this.rv1[i2];
                l2 = i2--;
            }
            for (i2 = 2; i2 >= 0; --i2) {
                l2 = i2 + 1;
                g2 = this.w[i2];
                if (i2 < 2) {
                    for (j2 = l2; j2 < 3; ++j2) {
                        a2[i2 + 3 * j2] = 0.0;
                    }
                }
                if (g2 != 0.0) {
                    g2 = 1.0 / g2;
                    if (i2 != 2) {
                        for (j2 = l2; j2 < 3; ++j2) {
                            s = 0.0;
                            for (k2 = l2; k2 < 3; ++k2) {
                                s += a2[k2 + 3 * i2] * a2[k2 + 3 * j2];
                            }
                            f2 = s / a2[i2 + 3 * i2] * g2;
                            for (k2 = i2; k2 < 3; ++k2) {
                                int n5 = k2 + 3 * j2;
                                a2[n5] = a2[n5] + f2 * a2[k2 + 3 * i2];
                            }
                        }
                    }
                    for (j2 = i2; j2 < 3; ++j2) {
                        a2[j2 + 3 * i2] = a2[j2 + 3 * i2] * g2;
                    }
                } else {
                    for (j2 = i2; j2 < 3; ++j2) {
                        a2[j2 + 3 * i2] = 0.0;
                    }
                }
                int n6 = i2 + 3 * i2;
                a2[n6] = a2[n6] + 1.0;
            }
            block27: for (k2 = 2; k2 >= 0; --k2) {
                for (int its = 0; its < maxIterations; ++its) {
                    double z;
                    double y;
                    double c2;
                    boolean flag = true;
                    for (l2 = k2; l2 >= 0; --l2) {
                        nm = l2 - 1;
                        if (Math.abs(this.rv1[l2]) + anorm == anorm) {
                            flag = false;
                            break;
                        }
                        if (Math.abs(this.w[nm]) + anorm == anorm) break;
                    }
                    if (flag) {
                        c2 = 0.0;
                        s = 1.0;
                        for (i2 = l2; i2 <= k2; ++i2) {
                            f2 = s * this.rv1[i2];
                            if (Math.abs(f2) + anorm == anorm) continue;
                            g2 = this.w[i2];
                            this.w[i2] = h2 = SvdDecomposition3d.PYTHAG(f2, g2);
                            h2 = 1.0 / h2;
                            c2 = g2 * h2;
                            s = -f2 * h2;
                            for (j2 = 0; j2 < 3; ++j2) {
                                y = a2[j2 + 3 * nm];
                                z = a2[j2 + 3 * i2];
                                a2[j2 + 3 * nm] = y * c2 + z * s;
                                a2[j2 + 3 * i2] = z * c2 - y * s;
                            }
                        }
                    }
                    z = this.w[k2];
                    if (l2 == k2) {
                        if (!(z < 0.0)) continue block27;
                        this.w[k2] = -z;
                        for (j2 = 0; j2 < 3; ++j2) {
                            this.v[j2 + 3 * k2] = -this.v[j2 + 3 * k2];
                        }
                        continue block27;
                    }
                    if (its == maxIterations - 1) {
                        throw new RuntimeException("No convergence after " + maxIterations + " iterations");
                    }
                    double x = this.w[l2];
                    nm = k2 - 1;
                    y = this.w[nm];
                    g2 = this.rv1[nm];
                    h2 = this.rv1[k2];
                    f2 = ((y - z) * (y + z) + (g2 - h2) * (g2 + h2)) / (2.0 * h2 * y);
                    g2 = SvdDecomposition3d.PYTHAG(f2, 1.0);
                    f2 = ((x - z) * (x + z) + h2 * (y / (f2 + this.SIGN(g2, f2)) - h2)) / x;
                    s = 1.0;
                    c2 = 1.0;
                    for (j2 = l2; j2 <= nm; ++j2) {
                        int jj;
                        i2 = j2 + 1;
                        g2 = this.rv1[i2];
                        y = this.w[i2];
                        h2 = s * g2;
                        g2 = c2 * g2;
                        this.rv1[j2] = z = SvdDecomposition3d.PYTHAG(f2, h2);
                        c2 = f2 / z;
                        s = h2 / z;
                        f2 = x * c2 + g2 * s;
                        g2 = g2 * c2 - x * s;
                        h2 = y * s;
                        y *= c2;
                        for (jj = 0; jj < 3; ++jj) {
                            x = this.v[jj + 3 * j2];
                            z = this.v[jj + 3 * i2];
                            this.v[jj + 3 * j2] = x * c2 + z * s;
                            this.v[jj + 3 * i2] = z * c2 - x * s;
                        }
                        this.w[j2] = z = SvdDecomposition3d.PYTHAG(f2, h2);
                        if (z != 0.0) {
                            z = 1.0 / z;
                            c2 = f2 * z;
                            s = h2 * z;
                        }
                        f2 = c2 * g2 + s * y;
                        x = c2 * y - s * g2;
                        for (jj = 0; jj < 3; ++jj) {
                            y = a2[jj + 3 * j2];
                            z = a2[jj + 3 * i2];
                            a2[jj + 3 * j2] = y * c2 + z * s;
                            a2[jj + 3 * i2] = z * c2 - y * s;
                        }
                    }
                    this.rv1[l2] = 0.0;
                    this.rv1[k2] = f2;
                    this.w[k2] = x;
                }
            }
            destU.set(a2);
            destV.set(this.v);
        }

        private static double PYTHAG(double a2, double b2) {
            double result2;
            double bt;
            double at = Math.abs(a2);
            if (at > (bt = Math.abs(b2))) {
                double ct = bt / at;
                result2 = at * Math.sqrt(1.0 + ct * ct);
            } else if (bt > 0.0) {
                double ct = at / bt;
                result2 = bt * Math.sqrt(1.0 + ct * ct);
            } else {
                result2 = 0.0;
            }
            return result2;
        }
    }
}

