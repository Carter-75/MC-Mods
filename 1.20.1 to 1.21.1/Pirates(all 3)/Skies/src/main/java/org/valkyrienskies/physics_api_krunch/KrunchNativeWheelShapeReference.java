/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.physics_api_krunch;

import org.valkyrienskies.core.impl.shadow.Ix;
import org.valkyrienskies.core.impl.shadow.hf_0;
import org.valkyrienskies.core.impl.shadow.hh_0;
import org.valkyrienskies.core.impl.shadow.hm_0;

class KrunchNativeWheelShapeReference
implements hm_0,
Ix {
    private long a;
    private static final long b = -1L;

    /*
     * WARNING - void declaration
     */
    protected KrunchNativeWheelShapeReference(long shapeAddress) {
        void var1_1;
        this.a = var1_1;
    }

    @Override
    public void close() {
        this.d();
        boolean bl = KrunchNativeWheelShapeReference.deleteWheelShape(this.a);
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
    public final double k_() {
        this.d();
        double[] dArray = new double[1];
        boolean bl = KrunchNativeWheelShapeReference.getHalfThickness(this.a, dArray);
        if (!bl) {
            throw new IllegalStateException("Call to getHalfThickness() failed");
        }
        return dArray[0];
    }

    @Override
    public final void b(double d2) {
        this.d();
        if (!KrunchNativeWheelShapeReference.setHalfThickness(this.a, d2)) {
            throw new IllegalStateException("Call to setHalfThickness() failed");
        }
    }

    @Override
    public final double a() {
        this.d();
        double[] dArray = new double[1];
        boolean bl = KrunchNativeWheelShapeReference.getWheelRadius(this.a, dArray);
        if (!bl) {
            throw new IllegalStateException("Call to getLengths() failed");
        }
        return dArray[0];
    }

    @Override
    public final void a(double d2) {
        this.d();
        if (!KrunchNativeWheelShapeReference.setWheelRadius(this.a, d2)) {
            throw new IllegalStateException("Call to setWheelRadius() failed");
        }
    }

    @Override
    public final int c() {
        this.d();
        int[] nArray = new int[1];
        boolean bl = KrunchNativeWheelShapeReference.getPointShellSize(this.a, nArray);
        if (!bl) {
            throw new IllegalStateException("Call to getPointShellSize() failed");
        }
        return nArray[0];
    }

    @Override
    public final void a(int n2) {
        this.d();
        if (!KrunchNativeWheelShapeReference.setPointShellSize(this.a, n2)) {
            throw new IllegalStateException("Call to setPointShellSize() failed");
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

    private static native boolean getHalfThickness(long var0, double[] var2);

    private static native boolean setHalfThickness(long var0, double var2);

    private static native boolean getWheelRadius(long var0, double[] var2);

    private static native boolean setWheelRadius(long var0, double var2);

    private static native boolean getPointShellSize(long var0, int[] var2);

    private static native boolean setPointShellSize(long var0, int var2);

    private static native boolean deleteWheelShape(long var0);
}

