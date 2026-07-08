/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.ints.IntArrayList
 *  it.unimi.dsi.fastutil.ints.IntList
 */
package org.valkyrienskies.physics_api_krunch;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import org.joml.Vector3dc;
import org.valkyrienskies.core.impl.shadow.ha_0;
import org.valkyrienskies.physics_api_krunch.KrunchNativePhysicsWorldReference;

public class KrunchNativePhysicsWorldIsland
implements ha_0.b {
    private final int a;
    private final IntList b;
    private final KrunchNativePhysicsWorldReference c;

    /*
     * WARNING - void declaration
     */
    public KrunchNativePhysicsWorldIsland(int islandId, IntArrayList bodies, KrunchNativePhysicsWorldReference krunchPhysicsWorld) {
        void var3_3;
        void var2_2;
        void var1_1;
        this.a = var1_1;
        this.b = var2_2;
        this.c = var3_3;
    }

    @Override
    public final IntList a() {
        return this.b;
    }

    @Override
    public final void a(Vector3dc vector3dc, double d2) {
        this.c.a();
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.c;
        KrunchNativePhysicsWorldIsland.preStep(krunchNativePhysicsWorldReference.b, this.a, vector3dc.x(), vector3dc.y(), vector3dc.z(), d2);
    }

    @Override
    public final void a(Vector3dc vector3dc, double d2, double d3) {
        this.c.a();
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.c;
        KrunchNativePhysicsWorldIsland.subStep(krunchNativePhysicsWorldReference.b, this.a, vector3dc.x(), vector3dc.y(), vector3dc.z(), d2, d3);
    }

    @Override
    public final void b() {
        this.c.a();
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.c;
        KrunchNativePhysicsWorldIsland.postStep(krunchNativePhysicsWorldReference.b, this.a);
    }

    private static native void preStep(long var0, int var2, double var3, double var5, double var7, double var9);

    private static native void subStep(long var0, int var2, double var3, double var5, double var7, double var9, double var11);

    private static native void postStep(long var0, int var2);
}

