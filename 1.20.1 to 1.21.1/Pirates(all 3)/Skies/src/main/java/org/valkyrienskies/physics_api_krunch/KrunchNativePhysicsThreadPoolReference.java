/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.physics_api_krunch;

import org.valkyrienskies.core.impl.shadow.GZ;
import org.valkyrienskies.core.impl.shadow.hh_0;

public class KrunchNativePhysicsThreadPoolReference
implements AutoCloseable,
GZ {
    long a;
    private static final long b = -1L;

    /*
     * WARNING - void declaration
     */
    public KrunchNativePhysicsThreadPoolReference(int threadCount) {
        void var1_1;
        this.a = KrunchNativePhysicsThreadPoolReference.createKrunchNativePhysicsThreadPoolReference((int)var1_1);
    }

    protected final long c() {
        return this.a;
    }

    @Override
    public void close() {
        this.e();
        boolean bl = KrunchNativePhysicsThreadPoolReference.deletePhysicsThreadPool(this.a);
        if (!bl) {
            throw new IllegalStateException("Delete KrunchNativePhysicsThreadPoolReference failed! This KrunchNativePhysicsThreadPoolReference is currently in use!");
        }
        this.a = -1L;
    }

    protected void finalize() {
        if (this.a != -1L) {
            try {
                this.close();
                return;
            }
            catch (Exception exception) {
                System.out.println("Failed to finalize() KrunchNativePhysicsThreadPoolReference, this is a memory leak and a thread leak!");
                exception.printStackTrace();
            }
        }
    }

    private boolean d() {
        return this.a == -1L;
    }

    private void e() {
        if (this.d()) {
            throw new hh_0("This shape has been deleted!");
        }
    }

    @Override
    public final int b() {
        this.e();
        return KrunchNativePhysicsThreadPoolReference.getMaxThreadCountNative(this.a);
    }

    @Override
    public final int a() {
        this.e();
        return KrunchNativePhysicsThreadPoolReference.getThreadCountNative(this.a);
    }

    @Override
    public final void a(int n2) {
        this.e();
        KrunchNativePhysicsThreadPoolReference.setThreadCountNative(this.a, n2);
    }

    private static native long createKrunchNativePhysicsThreadPoolReference(int var0);

    private static native int getMaxThreadCountNative(long var0);

    private static native int getThreadCountNative(long var0);

    private static native void setThreadCountNative(long var0, int var2);

    private static native boolean deletePhysicsThreadPool(long var0);
}

