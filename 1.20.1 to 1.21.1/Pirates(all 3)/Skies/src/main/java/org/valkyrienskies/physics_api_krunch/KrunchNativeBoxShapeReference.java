/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.physics_api_krunch;

import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.impl.shadow.GP;
import org.valkyrienskies.core.impl.shadow.Ix;
import org.valkyrienskies.core.impl.shadow.hf_0;
import org.valkyrienskies.core.impl.shadow.hh_0;

class KrunchNativeBoxShapeReference
implements GP,
Ix {
    private long a;
    private static final long b = -1L;

    /*
     * WARNING - void declaration
     */
    protected KrunchNativeBoxShapeReference(long shapeAddress) {
        void var1_1;
        this.a = var1_1;
    }

    @Override
    public void close() {
        this.d();
        boolean bl = KrunchNativeBoxShapeReference.deleteBoxShape(this.a);
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
    public final Vector3dc a() {
        this.d();
        double[] dArray = new double[3];
        boolean bl = KrunchNativeBoxShapeReference.getLengths(this.a, dArray);
        if (!bl) {
            throw new IllegalStateException("Call to getLengths() failed");
        }
        return new Vector3d(dArray[0], dArray[1], dArray[2]);
    }

    @Override
    public final void a(Vector3dc vector3dc) {
        this.d();
        boolean bl = KrunchNativeBoxShapeReference.setLengths(this.a, new double[]{vector3dc.x(), vector3dc.y(), vector3dc.z()});
        if (!bl) {
            throw new IllegalStateException("Call to setLengths() failed");
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

    private static native boolean getLengths(long var0, double[] var2);

    private static native boolean setLengths(long var0, double[] var2);

    private static native boolean deleteBoxShape(long var0);
}

