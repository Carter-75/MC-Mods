/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.ints.Int2ObjectMap
 *  it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap
 */
package org.valkyrienskies.physics_api_krunch;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import java.util.Map;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.impl.shadow.GS;
import org.valkyrienskies.core.impl.shadow.GT;
import org.valkyrienskies.core.impl.shadow.GW;
import org.valkyrienskies.core.impl.shadow.IB;
import org.valkyrienskies.core.impl.shadow.Ix;
import org.valkyrienskies.core.impl.shadow.hc_0;
import org.valkyrienskies.core.impl.shadow.hf_0;
import org.valkyrienskies.core.impl.shadow.hh_0;

class KrunchNativeCompoundShapeReference
implements GT,
Ix {
    private long a;
    private static final long b = -1L;
    private final Int2ObjectMap<GT.a> c = new Int2ObjectOpenHashMap();

    /*
     * WARNING - void declaration
     */
    protected KrunchNativeCompoundShapeReference(long shapeAddress) {
        void var1_1;
        this.a = var1_1;
    }

    @Override
    public void close() {
        this.d();
        boolean bl = KrunchNativeCompoundShapeReference.deleteCompoundShape(this.a);
        if (!bl) {
            throw new hf_0("Delete compound shape failed! This shape is currently in use!");
        }
        this.a = -1L;
    }

    protected void finalize() {
        if (this.a != -1L) {
            this.close();
        }
        this.a = -1L;
    }

    @Override
    public final long b() {
        this.d();
        return this.a;
    }

    @Override
    public final boolean j_() {
        return this.a == -1L;
    }

    @Override
    public final Map<Integer, GT.a> a() {
        this.d();
        return this.c;
    }

    @Override
    public final boolean a(int n2) {
        this.d();
        boolean bl = this.c.remove(n2) != null;
        if (!bl) {
            return false;
        }
        return KrunchNativeCompoundShapeReference.deleteSegmentNative(this.b(), n2);
    }

    @Override
    public final GT.a a(int n2, GS gS, hc_0 hc_02, double d2, Vector3dc vector3dc, GW object) {
        this.d();
        if (this.c.containsKey(n2)) {
            throw new IllegalArgumentException("Segment with id " + n2 + " already exists!");
        }
        KrunchNativeCompoundShapeReference.createSegmentNative(this.b(), n2);
        object = new a(this, n2, gS, 0);
        KrunchNativeCompoundShapeReference.setSegmentCollisionShape(this.b(), n2, ((Ix)((Object)gS)).b());
        object.a(hc_02);
        object.a(d2);
        object.a(vector3dc);
        this.c.put(n2, object);
        return object;
    }

    private void d() {
        if (this.j_()) {
            throw new hh_0("This shape has been deleted!");
        }
    }

    private static native boolean createSegmentNative(long var0, int var2);

    private static native boolean deleteSegmentNative(long var0, int var2);

    private static native boolean setSegmentCollisionShape(long var0, int var2, long var3);

    private static native boolean getCollisionShapeOffsetNative(long var0, int var2, double[] var3);

    private static native boolean setCollisionShapeOffsetNative(long var0, int var2, double[] var3);

    private static native double getCollisionShapeScalingNative(long var0, int var2);

    private static native double setCollisionShapeScalingNative(long var0, int var2, double var3);

    private static native void getPoseVelNative(long var0, int var2, byte[] var3);

    private static native void setPoseVelNative(long var0, int var2, byte[] var3);

    private static native boolean deleteCompoundShape(long var0);

    final class a
    implements GT.a {
        private final int a;
        private GS b;
        private GW c;
        private /* synthetic */ KrunchNativeCompoundShapeReference d;

        private a(KrunchNativeCompoundShapeReference krunchNativeCompoundShapeReference, int n2, GS gS) {
            this.d = krunchNativeCompoundShapeReference;
            this.a = n2;
            this.b = gS;
            this.c = null;
        }

        @Override
        public final GS a() {
            this.d.d();
            return this.b;
        }

        @Override
        public final void a(GS gS) {
            this.d.d();
            this.b = gS;
            KrunchNativeCompoundShapeReference.setSegmentCollisionShape(this.d.b(), this.a, ((Ix)((Object)gS)).b());
        }

        @Override
        public final Vector3dc d() {
            this.d.d();
            double[] dArray = new double[3];
            boolean bl = KrunchNativeCompoundShapeReference.getCollisionShapeOffsetNative(this.d.a, this.a, dArray);
            if (!bl) {
                throw new IllegalStateException("Call to getCollisionShapeOffset() failed");
            }
            return new Vector3d(dArray[0], dArray[1], dArray[2]);
        }

        @Override
        public final void a(Vector3dc vector3dc) {
            this.d.d();
            boolean bl = KrunchNativeCompoundShapeReference.setCollisionShapeOffsetNative(this.d.a, this.a, new double[]{vector3dc.x(), vector3dc.y(), vector3dc.z()});
            if (!bl) {
                throw new IllegalStateException("Call to setCollisionShapeOffset() failed");
            }
        }

        @Override
        public final double c() {
            this.d.d();
            return KrunchNativeCompoundShapeReference.getCollisionShapeScalingNative(this.d.a, this.a);
        }

        @Override
        public final void a(double d2) {
            this.d.d();
            KrunchNativeCompoundShapeReference.setCollisionShapeScalingNative(this.d.a, this.a, d2);
        }

        @Override
        public final GW e() {
            this.d.d();
            return this.c;
        }

        @Override
        public final void a(GW gW) {
            this.d.d();
            this.c = gW;
        }

        @Override
        public final hc_0 b() {
            this.d.d();
            byte[] byArray = new byte[104];
            KrunchNativeCompoundShapeReference.getPoseVelNative(this.d.a, this.a, byArray);
            return IB.a(byArray);
        }

        @Override
        public final void a(hc_0 object) {
            this.d.d();
            object = IB.a((hc_0)object);
            KrunchNativeCompoundShapeReference.setPoseVelNative(this.d.a, this.a, (byte[])object);
        }

        /* synthetic */ a(KrunchNativeCompoundShapeReference krunchNativeCompoundShapeReference, int n2, GS gS, byte by) {
            this(krunchNativeCompoundShapeReference, n2, gS);
        }
    }
}

