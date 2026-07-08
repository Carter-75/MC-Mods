/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Dc
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\bf\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005R\u0014\u0010\u0005\u001a\u00020\u00028'X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\u00028'X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Dc;", "", "", "b", "()D", "a"})
public interface dc_0 {
    public static final a a = org.valkyrienskies.core.impl.shadow.Dc$a.a;

    @JvmName(name="a")
    public double a();

    @JvmName(name="b")
    public double b();

    public static final class a {
        static final /* synthetic */ a a;

        private a() {
        }

        public static double a(dc_0 dc_02, dc_0 dc_03) {
            Intrinsics.checkNotNullParameter((Object)dc_02, (String)"");
            Intrinsics.checkNotNullParameter((Object)dc_03, (String)"");
            double d2 = -dc_02.b() + dc_03.a();
            double d3 = -dc_02.a() + dc_03.b();
            if (d3 <= 0.0 || d2 >= 0.0) {
                return 0.0;
            }
            if (Math.abs(d3) < Math.abs(d2)) {
                return d3;
            }
            return d2;
        }

        public static double a(dc_0 dc_02, dc_0 dc_03, double d2) {
            double d3;
            double d4;
            Intrinsics.checkNotNullParameter((Object)dc_02, (String)"");
            Intrinsics.checkNotNullParameter((Object)dc_03, (String)"");
            double d5 = -dc_02.b() + dc_03.a();
            double d6 = -dc_02.a() + dc_03.b();
            if (Math.abs(d4) < Math.abs(d5)) {
                double d7;
                double d8 = d6 - d2;
                if (d7 > 0.0) {
                    return d8;
                }
                return 0.0;
            }
            double d9 = d5 - d2;
            if (d3 < 0.0) {
                return d9;
            }
            return 0.0;
        }

        public static double b(dc_0 dc_02, dc_0 dc_03, double d2) {
            Intrinsics.checkNotNullParameter((Object)dc_02, (String)"");
            Intrinsics.checkNotNullParameter((Object)dc_03, (String)"");
            double d3 = -dc_02.b() + dc_03.a();
            double d4 = -dc_02.a() + dc_03.b();
            if (d4 <= 0.0 || d3 >= 0.0) {
                if (Math.abs(d2) < 1.0E-8) {
                    return Double.POSITIVE_INFINITY;
                }
                if (d2 > 0.0) {
                    if (d3 >= 0.0) {
                        return Math.abs(d3 / d2);
                    }
                    return Double.POSITIVE_INFINITY;
                }
                if (d4 <= 0.0) {
                    return Math.abs(d4 / d2);
                }
                return Double.POSITIVE_INFINITY;
            }
            return 0.0;
        }

        static {
            a = new a();
        }
    }
}

