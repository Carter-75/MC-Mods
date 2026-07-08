/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Triple
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.api.util.AerodynamicUtils;

public final class DL
implements AerodynamicUtils {
    private final a b = new a(962.0, 62.0, 0.0, 4, null);
    public final ConcurrentHashMap<String, a> a = new ConcurrentHashMap();

    private a b() {
        return this.b;
    }

    public final ConcurrentHashMap<String, a> a() {
        return this.a;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void registerDimension(String dimensionId, double maxY, double seaLevel, double gravity) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        ((Map)this.a).put(var1_1, new a((double)var2_2, seaLevel, gravity));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void updateGravityForDimension(String dimensionId, double gravity) {
        void var2_2;
        a a2;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        a a3 = this.a.get(a2);
        if (a3 == null) {
            return;
        }
        a2 = a3;
        void var6_3 = var2_2;
        a2 = a3;
        a3.c = var6_3;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void updateAerodynamicInfoForDimension(String dimensionId, Double maxY, Double seaLevel) {
        void var1_1;
        double d2;
        void var3_3;
        double d3;
        a a2;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        a a3 = this.a.get(dimensionId);
        if (a3 == null) {
            return;
        }
        a a4 = a3;
        void v1 = a2;
        if (v1 != null) {
            d3 = v1.doubleValue();
        } else {
            a2 = a4;
            d3 = a2.a;
        }
        void v3 = var3_3;
        if (v3 != null) {
            d2 = v3.doubleValue();
        } else {
            a2 = a4;
            d2 = a2.b;
        }
        a2 = a4;
        a2 = new a(d3, d2, a2.c);
        ((Map)this.a).put(var1_1, a2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final Triple<Double, Double, Double> getAtmosphereForDimension(String id) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)id, (String)"");
        a a2 = this.a.get(var1_1);
        if (a2 != null) {
            return a2.d();
        }
        return this.b.d();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final double getAirDensityForY(double y, String dimension) {
        double d2;
        int n2;
        void var1_1;
        Triple<Double, Double, Double> triple;
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        triple = this.getAtmosphereForDimension((String)triple);
        double d3 = ((Number)triple.component1()).doubleValue();
        double d4 = ((Number)triple.component2()).doubleValue();
        double d5 = ((Number)triple.component3()).doubleValue();
        if (d3 <= 0.0) {
            return 0.0;
        }
        double d6 = 71000.0 / (d3 - d4);
        double d7 = (y - d4) * d6 >= 0.0 ? (var1_1 - d4) * d6 : 0.0;
        if ((d7 < 11000.0 ? 0 : (d7 < 20000.0 ? 1 : (d7 < 32000.0 ? 2 : (d7 < 47000.0 ? 3 : (d7 < 51000.0 ? 4 : (d7 < 71000.0 ? 5 : (n2 = d7 < 84852.0 ? 6 : 7))))))) > 6) {
            return 0.0;
        }
        double d8 = switch (n2) {
            case 0 -> 0.0;
            case 1 -> 11000.0;
            case 2 -> 20000.0;
            case 3 -> 32000.0;
            case 4 -> 47000.0;
            case 5 -> 51000.0;
            case 6 -> 71000.0;
            default -> 0.0;
        };
        double d9 = switch (n2) {
            case 0 -> 1.225;
            case 1 -> 0.36391;
            case 2 -> 0.08803;
            case 3 -> 0.01322;
            case 4 -> 0.00143;
            case 5 -> 8.6E-4;
            case 6 -> 6.4E-5;
            default -> 0.0;
        };
        double d10 = switch (n2) {
            case 0 -> 288.15;
            case 1 -> 216.65;
            case 2 -> 216.65;
            case 3 -> 228.65;
            case 4 -> 270.65;
            case 5 -> 270.65;
            case 6 -> 214.65;
            default -> 0.0;
        };
        double d11 = d5;
        if (!((switch (n2) {
            case 0 -> 0.0065;
            case 1 -> 0.0;
            case 2 -> -0.001;
            case 3 -> -0.0028;
            case 4 -> 0.0;
            case 5 -> 0.0028;
            case 6 -> 0.002;
            default -> d2 = 0.0;
        }) == 0.0)) {
            return d9 * Math.pow((d10 - (d7 - d8) * d2) / d10, d11 * 0.0289644 / (d2 * 8.314) - 1.0);
        }
        return d9 * Math.exp(-d11 * 0.0289644 * (d7 - d8) / (d10 * 8.314));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final double getAirPressureForY(double y, String dimension) {
        double d2;
        int n2;
        void var1_1;
        Triple<Double, Double, Double> triple;
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        triple = this.getAtmosphereForDimension((String)triple);
        double d3 = ((Number)triple.component1()).doubleValue();
        double d4 = ((Number)triple.component2()).doubleValue();
        double d5 = ((Number)triple.component3()).doubleValue();
        if (d3 <= 0.0) {
            return 0.0;
        }
        double d6 = 71000.0 / (d3 - d4);
        double d7 = (y - d4) * d6 >= 0.0 ? (var1_1 - d4) * d6 : 0.0;
        if ((d7 < 11000.0 ? 0 : (d7 < 20000.0 ? 1 : (d7 < 32000.0 ? 2 : (d7 < 47000.0 ? 3 : (d7 < 51000.0 ? 4 : (d7 < 71000.0 ? 5 : (n2 = d7 < 84852.0 ? 6 : 7))))))) > 6) {
            return 0.0;
        }
        double d8 = switch (n2) {
            case 0 -> 0.0;
            case 1 -> 11000.0;
            case 2 -> 20000.0;
            case 3 -> 32000.0;
            case 4 -> 47000.0;
            case 5 -> 51000.0;
            case 6 -> 71000.0;
            default -> 0.0;
        };
        double d9 = switch (n2) {
            case 0 -> 101325.0;
            case 1 -> 22632.1;
            case 2 -> 5474.89;
            case 3 -> 868.02;
            case 4 -> 110.91;
            case 5 -> 66.94;
            case 6 -> 3.96;
            default -> 0.0;
        };
        double d10 = switch (n2) {
            case 0 -> 288.15;
            case 1 -> 216.65;
            case 2 -> 216.65;
            case 3 -> 228.65;
            case 4 -> 270.65;
            case 5 -> 270.65;
            case 6 -> 214.65;
            default -> 0.0;
        };
        double d11 = d5;
        if (!((switch (n2) {
            case 0 -> 0.0065;
            case 1 -> 0.0;
            case 2 -> -0.001;
            case 3 -> -0.0028;
            case 4 -> 0.0;
            case 5 -> 0.0028;
            case 6 -> 0.002;
            default -> d2 = 0.0;
        }) == 0.0)) {
            return d9 * Math.pow(1.0 - d2 / d10 * (d7 - d8), d11 * 0.0289644 / (d2 * 8.314));
        }
        return d9 * Math.exp(-d11 * 0.0289644 * (d7 - d8) / (d10 * 8.314));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final double getAirTemperatureForY(double y, String dimension) {
        double d2;
        int n2;
        void var1_1;
        Triple<Double, Double, Double> triple;
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        triple = this.getAtmosphereForDimension((String)triple);
        double d3 = ((Number)triple.component1()).doubleValue();
        double d4 = ((Number)triple.component2()).doubleValue();
        if (d3 <= 0.0) {
            return 0.0;
        }
        double d5 = 71000.0 / (d3 - d4);
        double d6 = (y - d4) * d5 >= 0.0 ? (var1_1 - d4) * d5 : 0.0;
        if ((d6 < 11000.0 ? 0 : (d6 < 20000.0 ? 1 : (d6 < 32000.0 ? 2 : (d6 < 47000.0 ? 3 : (d6 < 51000.0 ? 4 : (d6 < 71000.0 ? 5 : (n2 = d6 < 84852.0 ? 6 : 7))))))) > 6) {
            return 0.0;
        }
        double d7 = switch (n2) {
            case 0 -> 0.0;
            case 1 -> 11000.0;
            case 2 -> 20000.0;
            case 3 -> 32000.0;
            case 4 -> 47000.0;
            case 5 -> 51000.0;
            case 6 -> 71000.0;
            default -> 0.0;
        };
        double d8 = switch (n2) {
            case 0 -> 288.15;
            case 1 -> 216.65;
            case 2 -> 216.65;
            case 3 -> 228.65;
            case 4 -> 270.65;
            case 5 -> 270.65;
            case 6 -> 214.65;
            default -> 0.0;
        };
        if (!((switch (n2) {
            case 0 -> 0.0065;
            case 1 -> 0.0;
            case 2 -> -0.001;
            case 3 -> -0.0028;
            case 4 -> 0.0;
            case 5 -> 0.0028;
            case 6 -> 0.002;
            default -> d2 = 0.0;
        }) == 0.0)) {
            return d8 - (d6 - d7) * d2;
        }
        return d8;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fH\u00d6\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012H\u00d6\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0015\u00a2\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\n\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u0004\"\u0004\b\n\u0010\u001aR\u0017\u0010\u001b\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\n\u0010\u0004R\u0017\u0010\u0018\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u001b\u0010\u0004"}, d2={"Lorg/valkyrienskies/core/impl/shadow/DL$a;", "", "", "e", "()D", "f", "g", "p0", "p1", "p2", "a", "(DDD)Lorg/valkyrienskies/core/impl/shadow/DL$a;", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lkotlin/Triple;", "d", "()Lkotlin/Triple;", "c", "D", "(D)V", "b", "<init>", "(DDD)V"})
    public static final class a {
        final double a;
        final double b;
        double c;

        public a(double d2, double d3, double d4) {
            this.a = d2;
            this.b = d3;
            this.c = d4;
        }

        public /* synthetic */ a(double d2, double d3, double d4, int n2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n2 & 4) != 0) {
                d4 = 10.0;
            }
            this(d2, d3, d4);
        }

        @JvmName(name="a")
        public final double a() {
            return this.a;
        }

        @JvmName(name="b")
        public final double b() {
            return this.b;
        }

        @JvmName(name="c")
        public final double c() {
            return this.c;
        }

        @JvmName(name="a")
        public final void a(double d2) {
            this.c = d2;
        }

        public final Triple<Double, Double, Double> d() {
            return new Triple((Object)this.a, (Object)this.b, (Object)this.c);
        }

        private double e() {
            return this.a;
        }

        private double f() {
            return this.b;
        }

        private double g() {
            return this.c;
        }

        private static a a(double d2, double d3, double d4) {
            return new a(d2, d3, d4);
        }

        private static /* synthetic */ a a$default(a a2, double d2, double d3, double d4, int n2) {
            if ((n2 & 1) != 0) {
                d2 = a2.a;
            }
            if ((n2 & 2) != 0) {
                d3 = a2.b;
            }
            if ((n2 & 4) != 0) {
                d4 = a2.c;
            }
            double d5 = d4;
            double d6 = d3;
            double d7 = d2;
            return new a(d7, d6, d5);
        }

        public final String toString() {
            return "Parameters(maxY=" + this.a + ", seaLevel=" + this.b + ", gravity=" + this.c + ")";
        }

        public final int hashCode() {
            int n2 = Double.hashCode(this.a);
            n2 = n2 * 31 + Double.hashCode(this.b);
            n2 = n2 * 31 + Double.hashCode(this.c);
            return n2;
        }

        public final boolean equals(Object other) {
            a a2;
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a2 = a2;
            if (Double.compare(this.a, a2.a) != 0) {
                return false;
            }
            if (Double.compare(this.b, a2.b) != 0) {
                return false;
            }
            return Double.compare(this.c, a2.c) == 0;
        }
    }
}

