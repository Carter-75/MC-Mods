/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.ints.Int2ObjectMap
 *  it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap
 *  kotlin.Pair
 *  org.valkyrienskies.core.impl.shadow.Ha
 */
package org.valkyrienskies.physics_api_krunch;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.impl.shadow.GS;
import org.valkyrienskies.core.impl.shadow.GY;
import org.valkyrienskies.core.impl.shadow.HI;
import org.valkyrienskies.core.impl.shadow.HQ;
import org.valkyrienskies.core.impl.shadow.HR;
import org.valkyrienskies.core.impl.shadow.HS;
import org.valkyrienskies.core.impl.shadow.Ha;
import org.valkyrienskies.core.impl.shadow.IJ;
import org.valkyrienskies.core.impl.shadow.IN;
import org.valkyrienskies.core.impl.shadow.Ir;
import org.valkyrienskies.core.impl.shadow.Iu;
import org.valkyrienskies.core.impl.shadow.Iw;
import org.valkyrienskies.core.impl.shadow.Ix;
import org.valkyrienskies.core.impl.shadow.ha_0;
import org.valkyrienskies.core.impl.shadow.hd_0;
import org.valkyrienskies.core.impl.shadow.he_0;
import org.valkyrienskies.core.impl.shadow.hh_0;
import org.valkyrienskies.physics_api_krunch.KrunchNativePhysicsThreadPoolReference;
import org.valkyrienskies.physics_api_krunch.KrunchNativeRigidBodyReference;
import org.valkyrienskies.physics_api_krunch.KrunchNativeVoxelShapeReference;

public class KrunchNativePhysicsWorldReference
implements Ha {
    private static final ThreadLocal<ByteBuffer> d = ThreadLocal.withInitial(() -> ByteBuffer.allocate(8192).order(ByteOrder.LITTLE_ENDIAN));
    private static final long e = 0L;
    private static final int f = -1;
    long b;
    boolean c;
    private final Int2ObjectMap<Pair<Integer, Integer>> g = new Int2ObjectOpenHashMap();
    private final Int2ObjectMap<GY<?>> h = new Int2ObjectOpenHashMap();
    private final KrunchNativePhysicsThreadPoolReference i;

    /*
     * WARNING - void declaration
     */
    public KrunchNativePhysicsWorldReference(KrunchNativePhysicsThreadPoolReference physicsThreadPoolReference) {
        void var1_1;
        this.i = physicsThreadPoolReference;
        this.b = KrunchNativePhysicsWorldReference.createKrunchNativePhysicsWorld(var1_1.a);
        this.c = false;
    }

    private static ByteBuffer j() {
        ByteBuffer byteBuffer = d.get();
        byteBuffer.clear();
        return byteBuffer;
    }

    public final List<ha_0.b> a(Vector3dc object, double d2) {
        this.a();
        byte[] byArray = KrunchNativePhysicsWorldReference.preStep(this.b, object.x(), object.y(), object.z(), d2);
        object = byArray;
        object = ByteBuffer.wrap(byArray).order(ByteOrder.LITTLE_ENDIAN);
        return Iu.a((ByteBuffer)object, this);
    }

    public final void h() {
        this.a();
        KrunchNativePhysicsWorldReference.postStep(this.b);
    }

    public final void a(Iw iw) {
        this.a();
        KrunchNativePhysicsWorldReference.setSettings(this.b, iw.a(), iw.b(), iw.c(), iw.d(), iw.e(), iw.f(), iw.g(), iw.h(), iw.i().getSolverType(), iw.j(), iw.k(), iw.l(), iw.m(), iw.n().getBackendType());
    }

    public final void b() {
        if (!this.c) {
            KrunchNativePhysicsWorldReference.deleteKrunchNativePhysicsWorld(this.b);
            this.b = 0L;
            this.c = true;
        }
    }

    public final boolean a(int n2) {
        this.a();
        this.h.remove(n2);
        return KrunchNativePhysicsWorldReference.deleteRigidBody(this.b, n2);
    }

    public final boolean g() {
        return this.c;
    }

    private void b(Integer object) {
        if (object == null) {
            return;
        }
        if ((object = (GY)this.h.get(((Integer)object).intValue())) != null) {
            object.q();
        }
    }

    public final boolean a(HI hI) {
        this.a();
        ByteBuffer byteBuffer = KrunchNativePhysicsWorldReference.j();
        Ir.a(hI, byteBuffer);
        boolean bl = KrunchNativePhysicsWorldReference.addConstraintAndId(this.b, byteBuffer.array());
        HI hI2 = hI;
        HI hI3 = hI2;
        HI hI4 = hI;
        hI3 = hI4;
        hI3 = hI;
        this.g.put(hI2.a, (Object)new Pair((Object)hI4.b.a(), (Object)hI3.b.c()));
        hI3 = hI;
        this.b(hI3.b.a());
        hI3 = hI;
        this.b(hI3.b.c());
        return bl;
    }

    public final List<HI> d() {
        this.a();
        byte[] byArray = KrunchNativePhysicsWorldReference.getConstraints(this.b);
        return Ir.a(ByteBuffer.wrap(byArray).order(ByteOrder.LITTLE_ENDIAN));
    }

    public final List<HI> e() {
        this.a();
        byte[] byArray = KrunchNativePhysicsWorldReference.getConstraintsBrokenLastTick(this.b);
        return Ir.a(ByteBuffer.wrap(byArray).order(ByteOrder.LITTLE_ENDIAN));
    }

    public final List<HI> f() {
        this.a();
        byte[] byArray = KrunchNativePhysicsWorldReference.getConstraintsRemovedFromDeletedBodiesLastTick(this.b);
        return Ir.a(ByteBuffer.wrap(byArray).order(ByteOrder.LITTLE_ENDIAN));
    }

    public final boolean b(int n2) {
        this.a();
        boolean bl = KrunchNativePhysicsWorldReference.removeConstraint(this.b, n2);
        Pair pair = (Pair)this.g.remove(n2);
        this.b((Integer)pair.getFirst());
        this.b((Integer)pair.getSecond());
        return bl;
    }

    public final boolean b(HI hI) {
        this.a();
        ByteBuffer byteBuffer = KrunchNativePhysicsWorldReference.j();
        Ir.a(hI, byteBuffer);
        boolean bl = KrunchNativePhysicsWorldReference.updateConstraint(this.b, byteBuffer.array());
        HI hI2 = hI;
        Pair pair = (Pair)this.g.get(hI2.a);
        HI hI3 = hI;
        hI2 = hI3;
        HI hI4 = hI;
        hI2 = hI4;
        hI2 = hI;
        this.g.put(hI3.a, (Object)new Pair((Object)hI4.b.a(), (Object)hI2.b.c()));
        this.b((Integer)pair.getFirst());
        this.b((Integer)pair.getSecond());
        hI2 = hI;
        this.b(hI2.b.a());
        hI2 = hI;
        this.b(hI2.b.c());
        return bl;
    }

    private <T extends GS> KrunchNativeRigidBodyReference<T> b(T object) {
        this.a();
        Ix ix = (Ix)object;
        int n2 = KrunchNativePhysicsWorldReference.createRigidBody(this.b, ix.b(), ix instanceof KrunchNativeVoxelShapeReference);
        if (n2 == -1) {
            throw new hh_0("Create rigid body failed because shape with id " + ((Ix)object).b() + " was deleted!");
        }
        Object object2 = object = new KrunchNativeRigidBodyReference<T>(this, n2, object);
        this.h.put(((KrunchNativeRigidBodyReference)object2).a, object);
        return object;
    }

    public final void a(int n2, int n3) {
        this.a();
        KrunchNativePhysicsWorldReference.disableCollisionBetweenBodies(this.b, n2, n3);
    }

    public final void b(int n2, int n3) {
        this.a();
        KrunchNativePhysicsWorldReference.enableCollisionBetweenBodies(this.b, n2, n3);
    }

    public final hd_0 a(Vector3dc object, Vector3dc vector3dc, double d2, int ... nArray) {
        this.a();
        byte[] byArray = KrunchNativePhysicsWorldReference.rayTrace(this.b, object.x(), object.y(), object.z(), vector3dc.x(), vector3dc.y(), vector3dc.z(), d2, nArray);
        object = byArray;
        if (byArray == null) {
            return null;
        }
        return IJ.a((byte[])object);
    }

    public final he_0 b(Vector3dc object, Vector3dc vector3dc, double d2, int ... nArray) {
        this.a();
        byte[] byArray = KrunchNativePhysicsWorldReference.rayTraceWithVel(this.b, object.x(), object.y(), object.z(), vector3dc.x(), vector3dc.y(), vector3dc.z(), d2, nArray);
        object = byArray;
        if (byArray == null) {
            return null;
        }
        return IJ.b((byte[])object);
    }

    public final void a(Integer n2) {
        if (n2 != null) {
            KrunchNativePhysicsWorldReference.setGroundBodyId(this.b, n2, true);
            return;
        }
        KrunchNativePhysicsWorldReference.setGroundBodyId(this.b, -1, false);
    }

    public final List<HS> c() {
        this.a();
        Object object = KrunchNativePhysicsWorldReference.getCollisionEvents(this.b);
        if (object == null || ((byte[])object).length == 0) {
            return new ArrayList<HS>();
        }
        ByteBuffer byteBuffer = ByteBuffer.wrap((byte[])object).order(ByteOrder.LITTLE_ENDIAN);
        object = byteBuffer;
        int n2 = byteBuffer.getInt();
        if (n2 == 0) {
            return new ArrayList<HS>();
        }
        ArrayList<HS> arrayList = new ArrayList<HS>(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object2 = object;
            int n3 = ((ByteBuffer)object2).getInt();
            int n4 = ((ByteBuffer)object2).getInt();
            int n5 = ((ByteBuffer)object2).getInt();
            ArrayList<HQ> arrayList2 = new ArrayList<HQ>(n5);
            for (int i3 = 0; i3 < n5; ++i3) {
                Object object3 = HR.values()[((ByteBuffer)object2).get()];
                HR hR = object3;
                object3 = object2;
                Vector3d vector3d = new Vector3d(((ByteBuffer)object3).getDouble(), ((ByteBuffer)object3).getDouble(), ((ByteBuffer)object3).getDouble());
                Vector3d vector3d2 = new Vector3d(((ByteBuffer)object3).getDouble(), ((ByteBuffer)object3).getDouble(), ((ByteBuffer)object3).getDouble());
                float f2 = ((ByteBuffer)object3).getFloat();
                object3 = new Vector3d(((ByteBuffer)object3).getDouble(), ((ByteBuffer)object3).getDouble(), ((ByteBuffer)object3).getDouble());
                object3 = new HQ(hR, vector3d, vector3d2, f2, (Vector3dc)object3);
                arrayList2.add((HQ)object3);
            }
            object2 = new IN(n3, n4, arrayList2);
            arrayList.add((HS)object2);
        }
        return arrayList;
    }

    protected final void a() {
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this;
        if (krunchNativePhysicsWorldReference.c) {
            throw new hh_0("The underlying physics world has already been deleted!");
        }
    }

    protected final long i() {
        return this.b;
    }

    private static native long createKrunchNativePhysicsWorld(long var0);

    private static native void deleteKrunchNativePhysicsWorld(long var0);

    private static native void setSettings(long var0, int var2, int var3, int var4, double var5, double var7, double var9, double var11, double var13, int var15, int var16, double var17, double var19, int var21, int var22);

    private static native boolean deleteRigidBody(long var0, int var2);

    private static native boolean addConstraintAndId(long var0, byte[] var2);

    private static native byte[] getConstraints(long var0);

    private static native byte[] getConstraintsBrokenLastTick(long var0);

    private static native byte[] getConstraintsRemovedFromDeletedBodiesLastTick(long var0);

    private static native boolean removeConstraint(long var0, int var2);

    private static native boolean updateConstraint(long var0, byte[] var2);

    private static native int createRigidBody(long var0, long var2, boolean var4);

    private static native byte[] preStep(long var0, double var2, double var4, double var6, double var8);

    private static native void postStep(long var0);

    private static native void disableCollisionBetweenBodies(long var0, int var2, int var3);

    private static native void enableCollisionBetweenBodies(long var0, int var2, int var3);

    private static native byte[] rayTrace(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, int[] var16);

    private static native byte[] rayTraceWithVel(long var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, int[] var16);

    private static native void setGroundBodyId(long var0, int var2, boolean var3);

    private static native byte[] getCollisionEvents(long var0);

    public final /* synthetic */ GY a(GS object) {
        Object object2 = object;
        object = this;
        ((KrunchNativePhysicsWorldReference)object).a();
        Ix ix = (Ix)object2;
        int n2 = KrunchNativePhysicsWorldReference.createRigidBody(((KrunchNativePhysicsWorldReference)object).b, ix.b(), ix instanceof KrunchNativeVoxelShapeReference);
        if (n2 == -1) {
            throw new hh_0("Create rigid body failed because shape with id " + ((Ix)object2).b() + " was deleted!");
        }
        object = object2 = new KrunchNativeRigidBodyReference<GS>((KrunchNativePhysicsWorldReference)object, n2, (GS)object2);
        ((KrunchNativePhysicsWorldReference)object).h.put(((KrunchNativeRigidBodyReference)object).a, object2);
        return object2;
    }
}

