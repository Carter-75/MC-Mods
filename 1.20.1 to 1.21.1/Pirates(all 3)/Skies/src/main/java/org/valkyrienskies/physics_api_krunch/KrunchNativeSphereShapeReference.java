/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.physics_api_krunch;

import org.valkyrienskies.core.impl.shadow.Ix;
import org.valkyrienskies.core.impl.shadow.hf_0;
import org.valkyrienskies.core.impl.shadow.hg_0;
import org.valkyrienskies.core.impl.shadow.hh_0;

class KrunchNativeSphereShapeReference
implements hg_0,
Ix {
    private long a;
    private static final long b = -1L;

    /*
     * WARNING - void declaration
     */
    protected KrunchNativeSphereShapeReference(long shapeAddress) {
        void var1_1;
        this.a = var1_1;
    }

    @Override
    public void close() {
        this.d();
        boolean bl = KrunchNativeSphereShapeReference.deleteSphereShape(this.a);
        if (!bl) {
            throw new hf_0("Delete box shape failed! This shape is currently in use!");
        }
        this.a = -1L;
    }

    protected void finalize() {
        if (this.a != -1L) {
            this.close();
        }
    }

    @Override
    public final long b() {
        this.d();
        return this.a;
    }

    @Override
    public final double a() {
        this.d();
        double[] dArray = new double[1];
        boolean bl = KrunchNativeSphereShapeReference.getRadius(this.a, dArray);
        if (!bl) {
            throw new IllegalStateException("Call to getRadius() failed");
        }
        return dArray[0];
    }

    @Override
    public final void a(double d2) {
        this.d();
        boolean bl = KrunchNativeSphereShapeReference.setRadius(this.a, d2);
        if (!bl) {
            throw new IllegalStateException("Call to setRadius() failed");
        }
    }

    @Override
    public final boolean j_() {
        return this.a == -1L;
    }

    private void d() {
        if (this.j_()) {
            throw new hh_0("This shape has been deleted!");
        }
    }

    private static native boolean getRadius(long var0, double[] var2);

    private static native boolean setRadius(long var0, double var2);

    private static native boolean deleteSphereShape(long var0);
}

