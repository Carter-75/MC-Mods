/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.kQ;
import org.valkyrienskies.core.impl.shadow.kV;
import org.valkyrienskies.core.impl.shadow.kW;
import org.valkyrienskies.core.impl.shadow.kY;
import org.valkyrienskies.core.impl.shadow.lg_0;
import org.valkyrienskies.core.impl.shadow.lk_0;
import org.valkyrienskies.core.impl.shadow.ya_0;
import org.valkyrienskies.core.impl.shadow.yc_0;
import org.valkyrienskies.core.impl.shadow.yf_0;
import org.valkyrienskies.core.impl.shadow.yp_0;
import org.valkyrienskies.core.impl.shadow.yz_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Deprecated
public abstract class yQ
extends yz_0<kQ>
implements yc_0 {
    private kY b;

    @Deprecated
    protected yQ() {
    }

    protected yQ(ya_0<yp_0> ya_02) {
        super(ya_02);
    }

    protected final double[] b(double[] dArray) {
        return this.b.a(dArray);
    }

    private yp_0 b(int n2, kQ kQ2, yf_0 yf_02, double[] dArray) {
        this.b = kQ2.a();
        return super.a(n2, kQ2, yf_02, dArray);
    }

    @Override
    private yp_0 a(int n2, lk_0 lk_02, yf_0 yf_02, double[] dArray) {
        lk_0 lk_03 = lk_02;
        return this.b(n2, new kQ(){

            public final double a(double[] dArray) {
                return lk_02.a(dArray);
            }

            public final kV.1 a(int n2) {
                return new kW(this, n2){
                    private /* synthetic */ int a;
                    private /* synthetic */ kV.8 b;
                    {
                        this.b = var1_1;
                        this.a = n2;
                    }

                    public final double a(double[] dArray) {
                        int n2 = dArray.length;
                        lg_0[] lg_0Array = new lg_0[n2];
                        for (int i2 = 0; i2 < n2; ++i2) {
                            lg_0Array[i2] = i2 == this.a ? new lg_0(1, 1, 0, dArray[i2]) : new lg_0(1, 1, dArray[i2]);
                        }
                        lg_0 lg_02 = this.b.lk_02.a(lg_0Array);
                        return lg_02.a(new int[]{1});
                    }
                };
            }

            public final kV.2 a() {
                return new kY(this){
                    private /* synthetic */ kV.8 a;
                    {
                        this.a = var1_1;
                    }

                    public final double[] a(double[] dArray) {
                        int n2 = dArray.length;
                        Object[] objectArray = new lg_0[n2];
                        for (int i2 = 0; i2 < n2; ++i2) {
                            objectArray[i2] = new lg_0(n2, 1, i2, dArray[i2]);
                        }
                        lg_0 lg_02 = this.a.lk_02.a((lg_0[])objectArray);
                        dArray = new double[n2];
                        objectArray = new int[n2];
                        for (int i3 = 0; i3 < n2; ++i3) {
                            objectArray[i3] = (lg_0)true;
                            dArray[i3] = lg_02.a((int[])objectArray);
                            objectArray[i3] = (lg_0)false;
                        }
                        return dArray;
                    }
                };
            }
        }, yf_02, dArray);
    }

    @Override
    public final /* synthetic */ yp_0 a(int n2, kQ kQ2, yf_0 yf_02, double[] dArray) {
        return this.b(n2, kQ2, yf_02, dArray);
    }
}

