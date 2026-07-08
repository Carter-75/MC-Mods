/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Pair
 */
package org.valkyrienskies.physics_api_krunch;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import org.joml.Matrix3d;
import org.joml.Matrix3dc;
import org.joml.Quaterniond;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.primitives.AABBd;
import org.valkyrienskies.core.impl.shadow.GS;
import org.valkyrienskies.core.impl.shadow.GX;
import org.valkyrienskies.core.impl.shadow.GY;
import org.valkyrienskies.core.impl.shadow.IB;
import org.valkyrienskies.core.impl.shadow.Ix;
import org.valkyrienskies.core.impl.shadow.ha_0;
import org.valkyrienskies.core.impl.shadow.hb_0;
import org.valkyrienskies.core.impl.shadow.hc_0;
import org.valkyrienskies.core.impl.shadow.hh_0;
import org.valkyrienskies.physics_api_krunch.KrunchNativePhysicsWorldReference;
import org.valkyrienskies.physics_api_krunch.KrunchNativeVoxelShapeReference;

class KrunchNativeRigidBodyReference<T extends GS>
implements GY<T> {
    private static final int b = 0;
    private static final int c = -1;
    private final KrunchNativePhysicsWorldReference d;
    final int a;
    private int e;
    private T f;

    /*
     * WARNING - void declaration
     */
    protected KrunchNativeRigidBodyReference(KrunchNativePhysicsWorldReference physicsWorldReference, int rigidBodyUniqueId, T collisionShape) {
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference;
        void var2_2;
        KrunchNativeRigidBodyReference krunchNativeRigidBodyReference;
        this.d = krunchNativeRigidBodyReference;
        this.a = var2_2;
        this.e = 0;
        this.f = collisionShape;
        void var2_3 = krunchNativePhysicsWorldReference;
        krunchNativeRigidBodyReference = this;
        krunchNativeRigidBodyReference.t();
        long l2 = ((Ix)var2_3).b();
        krunchNativePhysicsWorldReference = krunchNativeRigidBodyReference.d;
        KrunchNativeRigidBodyReference.setCollisionShape(krunchNativePhysicsWorldReference.b, krunchNativeRigidBodyReference.a, krunchNativeRigidBodyReference.e, l2, var2_3 instanceof KrunchNativeVoxelShapeReference);
        krunchNativeRigidBodyReference.f = var2_3;
        krunchNativeRigidBodyReference.q();
    }

    @Override
    public final int a() {
        return this.a;
    }

    @Override
    public final hc_0 d() {
        this.t();
        byte[] byArray = new byte[104];
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        KrunchNativeRigidBodyReference.getPoseVel(krunchNativePhysicsWorldReference.b, this.a, this.e, byArray);
        return IB.a(byArray);
    }

    @Override
    public final void a(hc_0 object) {
        this.t();
        object = IB.a((hc_0)object);
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        KrunchNativeRigidBodyReference.setPoseVel(krunchNativePhysicsWorldReference.b, this.a, this.e, (byte[])object);
        this.q();
    }

    @Override
    public final double h() {
        this.t();
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        return KrunchNativeRigidBodyReference.getDynamicFrictionCoefficient(krunchNativePhysicsWorldReference.b, this.a, this.e);
    }

    @Override
    public final void b(double d2) {
        this.t();
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        KrunchNativeRigidBodyReference.setDynamicFrictionCoefficient(krunchNativePhysicsWorldReference.b, this.a, this.e, d2);
        this.q();
    }

    @Override
    public final boolean f() {
        this.t();
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        return KrunchNativeRigidBodyReference.getIsStatic(krunchNativePhysicsWorldReference.b, this.a, this.e);
    }

    @Override
    public final void a(boolean bl) {
        this.t();
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        KrunchNativeRigidBodyReference.setStatic(krunchNativePhysicsWorldReference.b, this.a, this.e, bl);
        this.q();
    }

    @Override
    public final double g() {
        this.t();
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        return KrunchNativeRigidBodyReference.getRestitutionCoefficient(krunchNativePhysicsWorldReference.b, this.a, this.e);
    }

    @Override
    public final void a(double d2) {
        this.t();
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        KrunchNativeRigidBodyReference.setRestitutionCoefficient(krunchNativePhysicsWorldReference.b, this.a, this.e, d2);
        this.q();
    }

    @Override
    public final double i() {
        this.t();
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        return KrunchNativeRigidBodyReference.getStaticFrictionCoefficient(krunchNativePhysicsWorldReference.b, this.a, this.e);
    }

    @Override
    public final void c(double d2) {
        this.t();
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        KrunchNativeRigidBodyReference.setStaticFrictionCoefficient(krunchNativePhysicsWorldReference.b, this.a, this.e, d2);
        this.q();
    }

    @Override
    public final Vector3dc k() {
        this.t();
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        return KrunchNativeRigidBodyReference.getCollisionShapeOffset(krunchNativePhysicsWorldReference.b, this.a, this.e);
    }

    @Override
    public final void a(Vector3dc vector3dc) {
        this.t();
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        KrunchNativeRigidBodyReference.setCollisionShapeOffset(krunchNativePhysicsWorldReference.b, this.a, this.e, vector3dc.x(), vector3dc.y(), vector3dc.z());
        this.q();
    }

    @Override
    public final double l() {
        this.t();
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        return KrunchNativeRigidBodyReference.getBuoyancyFactor(krunchNativePhysicsWorldReference.b, this.a, this.e);
    }

    @Override
    public final void e(double d2) {
        this.t();
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        KrunchNativeRigidBodyReference.setBuoyancyFactor(krunchNativePhysicsWorldReference.b, this.a, this.e, d2);
        this.q();
    }

    @Override
    public final GX e() {
        this.t();
        Object object = new byte[80];
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        KrunchNativeRigidBodyReference.getInertiaData(krunchNativePhysicsWorldReference.b, this.a, this.e, (byte[])object);
        ByteBuffer byteBuffer = ByteBuffer.wrap((byte[])object);
        object = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        double d2 = ((ByteBuffer)object).getDouble();
        double d3 = ((ByteBuffer)object).getDouble();
        double d4 = ((ByteBuffer)object).getDouble();
        double d5 = ((ByteBuffer)object).getDouble();
        double d6 = ((ByteBuffer)object).getDouble();
        double d7 = ((ByteBuffer)object).getDouble();
        double d8 = ((ByteBuffer)object).getDouble();
        double d9 = ((ByteBuffer)object).getDouble();
        double d10 = ((ByteBuffer)object).getDouble();
        double d11 = ((ByteBuffer)object).getDouble();
        object = new Matrix3d(d3, d6, d9, d4, d7, d10, d5, d8, d11);
        return new GX(d2, (Matrix3dc)object);
    }

    @Override
    public final void a(GX object) {
        this.t();
        ByteBuffer byteBuffer = ByteBuffer.allocate(80);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        Object object2 = object;
        byteBuffer.putDouble(((GX)object2).a);
        object2 = object;
        byteBuffer.putDouble(((GX)object2).b.m00());
        object2 = object;
        byteBuffer.putDouble(((GX)object2).b.m10());
        object2 = object;
        byteBuffer.putDouble(((GX)object2).b.m20());
        object2 = object;
        byteBuffer.putDouble(((GX)object2).b.m01());
        object2 = object;
        byteBuffer.putDouble(((GX)object2).b.m11());
        object2 = object;
        byteBuffer.putDouble(((GX)object2).b.m21());
        object2 = object;
        byteBuffer.putDouble(((GX)object2).b.m02());
        object2 = object;
        byteBuffer.putDouble(((GX)object2).b.m12());
        object2 = object;
        byteBuffer.putDouble(((GX)object2).b.m22());
        object = byteBuffer.array();
        object2 = this.d;
        KrunchNativeRigidBodyReference.setInertiaData(((KrunchNativePhysicsWorldReference)object2).b, this.a, this.e, (byte[])object);
        this.q();
    }

    @Override
    public final double j() {
        this.t();
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        return KrunchNativeRigidBodyReference.getCollisionShapeScaling(krunchNativePhysicsWorldReference.b, this.a, this.e);
    }

    @Override
    public final void d(double d2) {
        this.t();
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        KrunchNativeRigidBodyReference.setCollisionShapeScaling(krunchNativePhysicsWorldReference.b, this.a, this.e, d2);
        this.q();
    }

    private void t() {
        if (this.p()) {
            throw new hh_0("The underlying rigid body has been deleted!");
        }
    }

    @Override
    public final boolean p() {
        this.u();
        return this.v();
    }

    private void u() {
        if (this.v()) {
            return;
        }
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        if (krunchNativePhysicsWorldReference.c) {
            this.e = -1;
            return;
        }
        krunchNativePhysicsWorldReference = this.d;
        this.e = KrunchNativeRigidBodyReference.getCachedRigidBodyIndex(krunchNativePhysicsWorldReference.b, this.a, this.e);
    }

    private boolean v() {
        return this.e == -1;
    }

    @Override
    public final ha_0 b() {
        return this.d;
    }

    @Override
    public final void a(Vector3dc vector3dc, Vector3dc vector3dc2) {
        this.t();
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        KrunchNativeRigidBodyReference.addInvariantForceAtPosToNextPhysTick(krunchNativePhysicsWorldReference.b, this.a, this.e, vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z());
        this.q();
    }

    @Override
    public final void e(Vector3dc vector3dc) {
        this.t();
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        KrunchNativeRigidBodyReference.addInvariantForceToNextPhysTick(krunchNativePhysicsWorldReference.b, this.a, this.e, vector3dc.x(), vector3dc.y(), vector3dc.z());
        this.q();
    }

    @Override
    public final void c(Vector3dc vector3dc) {
        this.t();
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        KrunchNativeRigidBodyReference.addInvariantTorqueToNextPhysTick(krunchNativePhysicsWorldReference.b, this.a, this.e, vector3dc.x(), vector3dc.y(), vector3dc.z());
        this.q();
    }

    @Override
    public final void d(Vector3dc vector3dc) {
        this.t();
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        KrunchNativeRigidBodyReference.addRotDependentForceToNextPhysTick(krunchNativePhysicsWorldReference.b, this.a, this.e, vector3dc.x(), vector3dc.y(), vector3dc.z());
        this.q();
    }

    @Override
    public final void b(Vector3dc vector3dc) {
        this.t();
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        KrunchNativeRigidBodyReference.addRotDependentTorqueToNextPhysTick(krunchNativePhysicsWorldReference.b, this.a, this.e, vector3dc.x(), vector3dc.y(), vector3dc.z());
        this.q();
    }

    @Override
    public final boolean a(AABBd aABBd) {
        this.t();
        double[] dArray = new double[6];
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        boolean bl = KrunchNativeRigidBodyReference.getAABB(krunchNativePhysicsWorldReference.b, this.a, this.e, dArray);
        if (!bl) {
            return false;
        }
        aABBd.minX = dArray[0];
        aABBd.minY = dArray[1];
        aABBd.minZ = dArray[2];
        aABBd.maxX = dArray[3];
        aABBd.maxY = dArray[4];
        aABBd.maxZ = dArray[5];
        return true;
    }

    @Override
    public final boolean m() {
        this.t();
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        return KrunchNativeRigidBodyReference.getDoFluidDrag(krunchNativePhysicsWorldReference.b, this.a, this.e);
    }

    @Override
    public final void b(boolean bl) {
        this.t();
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        KrunchNativeRigidBodyReference.setDoFluidDrag(krunchNativePhysicsWorldReference.b, this.a, this.e, bl);
    }

    @Override
    public final int n() {
        this.t();
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        return KrunchNativeRigidBodyReference.getCollisionMask(krunchNativePhysicsWorldReference.b, this.a, this.e);
    }

    @Override
    public final void a(int n2) {
        this.t();
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        KrunchNativeRigidBodyReference.setCollisionMask(krunchNativePhysicsWorldReference.b, this.a, this.e, n2);
    }

    @Override
    public final T c() {
        return this.f;
    }

    @Override
    public final void a(T t) {
        this.t();
        long l2 = ((Ix)t).b();
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        KrunchNativeRigidBodyReference.setCollisionShape(krunchNativePhysicsWorldReference.b, this.a, this.e, l2, t instanceof KrunchNativeVoxelShapeReference);
        this.f = t;
        this.q();
    }

    @Override
    public final hb_0 o() {
        this.t();
        Object object = new byte[56];
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        boolean bl = KrunchNativeRigidBodyReference.getKinematicTarget(krunchNativePhysicsWorldReference.b, this.a, this.e, (byte[])object);
        if (bl) {
            ByteBuffer byteBuffer = ByteBuffer.wrap((byte[])object);
            object = byteBuffer;
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            double d2 = ((ByteBuffer)object).getDouble();
            double d3 = ((ByteBuffer)object).getDouble();
            double d4 = ((ByteBuffer)object).getDouble();
            double d5 = ((ByteBuffer)object).getDouble();
            double d6 = ((ByteBuffer)object).getDouble();
            double d7 = ((ByteBuffer)object).getDouble();
            double d8 = ((ByteBuffer)object).getDouble();
            object = new Vector3d(d2, d3, d4);
            Quaterniond quaterniond = new Quaterniond(d5, d6, d7, d8);
            return new hb_0((Vector3dc)object, quaterniond);
        }
        return null;
    }

    @Override
    public final void a(hb_0 object) {
        this.t();
        if (object != null) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(56);
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            ByteBuffer byteBuffer2 = byteBuffer;
            Object object2 = object;
            byteBuffer2.putDouble(((hb_0)object2).a.x());
            object2 = object;
            byteBuffer2.putDouble(((hb_0)object2).a.y());
            object2 = object;
            byteBuffer2.putDouble(((hb_0)object2).a.z());
            object2 = object;
            byteBuffer2.putDouble(((hb_0)object2).b.x());
            object2 = object;
            byteBuffer2.putDouble(((hb_0)object2).b.y());
            object2 = object;
            byteBuffer2.putDouble(((hb_0)object2).b.z());
            object2 = object;
            byteBuffer2.putDouble(((hb_0)object2).b.w());
            object = byteBuffer.array();
            object2 = this.d;
            KrunchNativeRigidBodyReference.setKinematicTarget(((KrunchNativePhysicsWorldReference)object2).b, this.a, this.e, true, (byte[])object);
        } else {
            KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
            KrunchNativeRigidBodyReference.setKinematicTarget(krunchNativePhysicsWorldReference.b, this.a, this.e, false, new byte[0]);
        }
        this.q();
    }

    @Override
    public final void q() {
        this.t();
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        KrunchNativeRigidBodyReference.wakeUp(krunchNativePhysicsWorldReference.b, this.a, this.e);
    }

    @Override
    public final double s() {
        this.t();
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        return KrunchNativeRigidBodyReference.getLiquidCollisionOverlap(krunchNativePhysicsWorldReference.b, this.a, this.e);
    }

    @Override
    public final boolean r() {
        this.t();
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        return KrunchNativeRigidBodyReference.isAsleep(krunchNativePhysicsWorldReference.b, this.a, this.e);
    }

    private Vector3d w() {
        this.t();
        double[] dArray = new double[3];
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        KrunchNativeRigidBodyReference.getTotalInvariantForcesNextPhysTick(krunchNativePhysicsWorldReference.b, this.a, this.e, dArray);
        return new Vector3d(dArray[0], dArray[1], dArray[2]);
    }

    private Vector3d x() {
        this.t();
        double[] dArray = new double[3];
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        KrunchNativeRigidBodyReference.getTotalInvariantTorquesNextPhysTick(krunchNativePhysicsWorldReference.b, this.a, this.e, dArray);
        return new Vector3d(dArray[0], dArray[1], dArray[2]);
    }

    private Vector3d y() {
        this.t();
        double[] dArray = new double[3];
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        KrunchNativeRigidBodyReference.getTotalRotDependentForcesNextPhysTick(krunchNativePhysicsWorldReference.b, this.a, this.e, dArray);
        return new Vector3d(dArray[0], dArray[1], dArray[2]);
    }

    private Vector3d z() {
        this.t();
        double[] dArray = new double[3];
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        KrunchNativeRigidBodyReference.getTotalRotDependentTorquesNextPhysTick(krunchNativePhysicsWorldReference.b, this.a, this.e, dArray);
        return new Vector3d(dArray[0], dArray[1], dArray[2]);
    }

    private List<Pair<Vector3dc, Vector3dc>> A() {
        this.t();
        Object object = this.d;
        int n2 = KrunchNativeRigidBodyReference.getInvariantForcesAtPosNextPhysTickCount(((KrunchNativePhysicsWorldReference)object).b, this.a, this.e);
        double[] dArray = new double[n2 * 6];
        object = this.d;
        KrunchNativeRigidBodyReference.getInvariantForcesAtPosNextPhysTick(((KrunchNativePhysicsWorldReference)object).b, this.a, this.e, dArray);
        object = new ArrayList();
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = i2 * 6;
            Vector3d vector3d = new Vector3d(dArray[n3], dArray[n3 + 1], dArray[n3 + 2]);
            Vector3d vector3d2 = new Vector3d(dArray[n3 + 3], dArray[n3 + 4], dArray[n3 + 5]);
            object.add(new Pair((Object)vector3d, (Object)vector3d2));
        }
        return object;
    }

    private boolean B() {
        KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference = this.d;
        return KrunchNativeRigidBodyReference.getIsStatic(krunchNativePhysicsWorldReference.b, this.a, this.e);
    }

    private static native int getCachedRigidBodyIndex(long var0, int var2, int var3);

    private static native void getPoseVel(long var0, int var2, int var3, byte[] var4);

    private static native void setPoseVel(long var0, int var2, int var3, byte[] var4);

    private static native double getDynamicFrictionCoefficient(long var0, int var2, int var3);

    private static native void setDynamicFrictionCoefficient(long var0, int var2, int var3, double var4);

    private static native boolean getIsStatic(long var0, int var2, int var3);

    private static native void setStatic(long var0, int var2, int var3, boolean var4);

    private static native double getRestitutionCoefficient(long var0, int var2, int var3);

    private static native void setRestitutionCoefficient(long var0, int var2, int var3, double var4);

    private static native double getStaticFrictionCoefficient(long var0, int var2, int var3);

    private static native void setStaticFrictionCoefficient(long var0, int var2, int var3, double var4);

    private static native Vector3dc getCollisionShapeOffset(long var0, int var2, int var3);

    private static native void setCollisionShapeOffset(long var0, int var2, int var3, double var4, double var6, double var8);

    private static native double getBuoyancyFactor(long var0, int var2, int var3);

    private static native void setBuoyancyFactor(long var0, int var2, int var3, double var4);

    private static native void getInertiaData(long var0, int var2, int var3, byte[] var4);

    private static native void setInertiaData(long var0, int var2, int var3, byte[] var4);

    private static native double getCollisionShapeScaling(long var0, int var2, int var3);

    private static native void setCollisionShapeScaling(long var0, int var2, int var3, double var4);

    private static native void addInvariantForceAtPosToNextPhysTick(long var0, int var2, int var3, double var4, double var6, double var8, double var10, double var12, double var14);

    private static native void addInvariantForceToNextPhysTick(long var0, int var2, int var3, double var4, double var6, double var8);

    private static native void addInvariantTorqueToNextPhysTick(long var0, int var2, int var3, double var4, double var6, double var8);

    private static native void addRotDependentForceToNextPhysTick(long var0, int var2, int var3, double var4, double var6, double var8);

    private static native void addRotDependentTorqueToNextPhysTick(long var0, int var2, int var3, double var4, double var6, double var8);

    private static native boolean getAABB(long var0, int var2, int var3, double[] var4);

    private static native void getTotalInvariantForcesNextPhysTick(long var0, int var2, int var3, double[] var4);

    private static native void getTotalInvariantTorquesNextPhysTick(long var0, int var2, int var3, double[] var4);

    private static native void getTotalRotDependentForcesNextPhysTick(long var0, int var2, int var3, double[] var4);

    private static native void getTotalRotDependentTorquesNextPhysTick(long var0, int var2, int var3, double[] var4);

    private static native int getInvariantForcesAtPosNextPhysTickCount(long var0, int var2, int var3);

    private static native void getInvariantForcesAtPosNextPhysTick(long var0, int var2, int var3, double[] var4);

    private static native boolean getDoFluidDrag(long var0, int var2, int var3);

    private static native void setDoFluidDrag(long var0, int var2, int var3, boolean var4);

    private static native void setCollisionMask(long var0, int var2, int var3, int var4);

    private static native int getCollisionMask(long var0, int var2, int var3);

    private static native void setCollisionShape(long var0, int var2, int var3, long var4, boolean var6);

    private static native boolean getKinematicTarget(long var0, int var2, int var3, byte[] var4);

    private static native void setKinematicTarget(long var0, int var2, int var3, boolean var4, byte[] var5);

    private static native void wakeUp(long var0, int var2, int var3);

    private static native double getLiquidCollisionOverlap(long var0, int var2, int var3);

    private static native boolean isAsleep(long var0, int var2, int var3);
}

