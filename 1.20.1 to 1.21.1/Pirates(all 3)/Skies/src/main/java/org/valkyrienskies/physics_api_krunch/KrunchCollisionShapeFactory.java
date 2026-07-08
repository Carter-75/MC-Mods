/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.physics_api_krunch;

import org.joml.Vector3dc;
import org.joml.Vector3ic;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.impl.shadow.GP;
import org.valkyrienskies.core.impl.shadow.GQ;
import org.valkyrienskies.core.impl.shadow.GR;
import org.valkyrienskies.core.impl.shadow.GT;
import org.valkyrienskies.core.impl.shadow.GU;
import org.valkyrienskies.core.impl.shadow.hg_0;
import org.valkyrienskies.core.impl.shadow.hl_0;
import org.valkyrienskies.core.impl.shadow.hm_0;
import org.valkyrienskies.physics_api_krunch.KrunchNativeBoxShapeReference;
import org.valkyrienskies.physics_api_krunch.KrunchNativeCapsuleShapeReference;
import org.valkyrienskies.physics_api_krunch.KrunchNativeCompoundShapeReference;
import org.valkyrienskies.physics_api_krunch.KrunchNativeSphereShapeReference;
import org.valkyrienskies.physics_api_krunch.KrunchNativeVoxelShapeReference;
import org.valkyrienskies.physics_api_krunch.KrunchNativeWheelShapeReference;
import org.valkyrienskies.physics_api_krunch.voxel.KrunchLod1BlockRegistry;

public class KrunchCollisionShapeFactory
implements GR {
    private static KrunchNativeVoxelShapeReference b(Vector3ic object, Vector3ic vector3ic, AABBic aABBic, GU gU) {
        long l2 = KrunchCollisionShapeFactory.createVoxelShape(object.x(), object.y(), object.z(), vector3ic.x(), vector3ic.y(), vector3ic.z(), aABBic.minX(), aABBic.minY(), aABBic.minZ(), aABBic.maxX(), aABBic.maxY(), aABBic.maxZ(), ((KrunchLod1BlockRegistry)gU).e());
        object = new KrunchNativeVoxelShapeReference(l2, (KrunchLod1BlockRegistry)gU);
        ((KrunchNativeVoxelShapeReference)object).a(false);
        return object;
    }

    private static KrunchNativeBoxShapeReference b(Vector3dc vector3dc) {
        long l2 = KrunchCollisionShapeFactory.createBoxShape(vector3dc.x(), vector3dc.y(), vector3dc.z());
        return new KrunchNativeBoxShapeReference(l2);
    }

    private static KrunchNativeCapsuleShapeReference b(double d2, double d3) {
        long l2 = KrunchCollisionShapeFactory.createCapsuleShape(d2, d3);
        return new KrunchNativeCapsuleShapeReference(l2);
    }

    private static KrunchNativeSphereShapeReference b(double d2) {
        long l2 = KrunchCollisionShapeFactory.createSphereShape(d2);
        return new KrunchNativeSphereShapeReference(l2);
    }

    private static KrunchNativeWheelShapeReference b(double d2, double d3, int n2) {
        long l2 = KrunchCollisionShapeFactory.createWheelShape(d2, d3, n2);
        return new KrunchNativeWheelShapeReference(l2);
    }

    @Override
    public final GT a() {
        long l2 = KrunchCollisionShapeFactory.createCompoundShape();
        return new KrunchNativeCompoundShapeReference(l2);
    }

    private static native long createVoxelShape(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, long var12);

    private static native long createBoxShape(double var0, double var2, double var4);

    private static native long createSphereShape(double var0);

    private static native long createCapsuleShape(double var0, double var2);

    private static native long createWheelShape(double var0, double var2, int var4);

    private static native long createCompoundShape();

    @Override
    public final /* synthetic */ GP a(Vector3dc vector3dc) {
        long l2 = KrunchCollisionShapeFactory.createBoxShape(vector3dc.x(), vector3dc.y(), vector3dc.z());
        return new KrunchNativeBoxShapeReference(l2);
    }

    @Override
    public final /* synthetic */ hg_0 a(double d2) {
        double d3 = d2;
        long l2 = KrunchCollisionShapeFactory.createSphereShape(d3);
        return new KrunchNativeSphereShapeReference(l2);
    }

    @Override
    public final /* synthetic */ hm_0 a(double d2, double d3, int n2) {
        int n3 = n2;
        double d4 = d3;
        double d5 = d2;
        long l2 = KrunchCollisionShapeFactory.createWheelShape(d5, d4, n3);
        return new KrunchNativeWheelShapeReference(l2);
    }

    @Override
    public final /* synthetic */ GQ a(double d2, double d3) {
        double d4 = d3;
        double d5 = d2;
        long l2 = KrunchCollisionShapeFactory.createCapsuleShape(d5, d4);
        return new KrunchNativeCapsuleShapeReference(l2);
    }

    @Override
    public final /* synthetic */ hl_0 a(Vector3ic object, Vector3ic vector3ic, AABBic aABBic, GU gU) {
        long l2 = KrunchCollisionShapeFactory.createVoxelShape(object.x(), object.y(), object.z(), vector3ic.x(), vector3ic.y(), vector3ic.z(), aABBic.minX(), aABBic.minY(), aABBic.minZ(), aABBic.maxX(), aABBic.maxY(), aABBic.maxZ(), ((KrunchLod1BlockRegistry)gU).e());
        object = new KrunchNativeVoxelShapeReference(l2, (KrunchLod1BlockRegistry)gU);
        ((KrunchNativeVoxelShapeReference)object).a(false);
        return object;
    }
}

