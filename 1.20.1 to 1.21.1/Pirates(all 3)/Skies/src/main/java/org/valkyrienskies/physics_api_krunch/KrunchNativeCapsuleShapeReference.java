/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.physics_api_krunch;

import org.valkyrienskies.core.impl.shadow.GQ;
import org.valkyrienskies.core.impl.shadow.Ix;
import org.valkyrienskies.core.impl.shadow.hf_0;
import org.valkyrienskies.core.impl.shadow.hh_0;

class KrunchNativeCapsuleShapeReference
implements GQ,
Ix {
    private long a;
    private static final long b = -1L;

    /*
     * WARNING - void declaration
     */
    protected KrunchNativeCapsuleShapeReference(long shapeAddress) {
        void var1_1;
        this.a = var1_1;
    }

    @Override
    public void close() {
        this.d();
        boolean bl = KrunchNativeCapsuleShapeReference.deleteCapsuleShape(this.a);
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
    public final double h_() {
        this.d();
        double[] dArray = new double[1];
        boolean bl = KrunchNativeCapsuleShapeReference.getHalfLength(this.a, dArray);
        if (!bl) {
            throw new IllegalStateException("Call to getLengths() failed");
        }
        return dArray[0];
    }

    @Override
    public final void b(double d2) {
        this.d();
        KrunchNativeCapsuleShapeReference.setHalfLength(this.a, d2);
    }

    @Override
    public final double a() {
        this.d();
        double[] dArray = new double[1];
        boolean bl = KrunchNativeCapsuleShapeReference.getRadius(this.a, dArray);
        if (!bl) {
            throw new IllegalStateException("Call to getLengths() failed");
        }
        return dArray[0];
    }

    @Override
    public final void a(double d2) {
        this.d();
        KrunchNativeCapsuleShapeReference.setRadius(this.a, d2);
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

    private static native boolean getHalfLength(long var0, double[] var2);

    private static native boolean setHalfLength(long var0, double var2);

    private static native boolean getRadius(long var0, double[] var2);

    private static native boolean setRadius(long var0, double var2);

    private static native boolean deleteCapsuleShape(long var0);
}

