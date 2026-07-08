/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Map;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.impl.shadow.GS;
import org.valkyrienskies.core.impl.shadow.GW;
import org.valkyrienskies.core.impl.shadow.hc_0;

public interface GT
extends GS {
    public Map<Integer, a> a();

    public a a(int var1, GS var2, hc_0 var3, double var4, Vector3dc var6, GW var7);

    public boolean a(int var1);

    public static interface a {
        public GS a();

        public void a(GS var1);

        public hc_0 b();

        public void a(hc_0 var1);

        public double c();

        public void a(double var1);

        public Vector3dc d();

        public void a(Vector3dc var1);

        public GW e();

        public void a(GW var1);
    }

    public static final class b {
        private static /* synthetic */ a a(GT gT, int n2, GS gS, hc_0 hc_02, double d2, Vector3dc vector3dc, GW gW, int n3, Object object) {
            if (object != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: makeNewSegment");
            }
            if ((n3 & 4) != 0) {
                hc_02 = hc_0.a.a();
            }
            if ((n3 & 8) != 0) {
                d2 = 1.0;
            }
            if ((n3 & 0x10) != 0) {
                vector3dc = new Vector3d();
            }
            if ((n3 & 0x20) != 0) {
                gW = null;
            }
            return gT.a(n2, gS, hc_02, d2, vector3dc, gW);
        }
    }
}

