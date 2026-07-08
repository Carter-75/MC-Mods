/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.physics_api_krunch;

import java.util.ArrayList;
import java.util.List;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3i;
import org.joml.Vector3ic;
import org.joml.primitives.AABBi;
import org.valkyrienskies.core.impl.shadow.GU;
import org.valkyrienskies.core.impl.shadow.Ix;
import org.valkyrienskies.core.impl.shadow.hf_0;
import org.valkyrienskies.core.impl.shadow.hh_0;
import org.valkyrienskies.core.impl.shadow.hl_0;
import org.valkyrienskies.core.impl.shadow.ig_0;
import org.valkyrienskies.physics_api_krunch.voxel.KrunchLod1BlockRegistry;
import org.valkyrienskies.physics_api_krunch.voxel.KrunchUnsafeVoxelChunk16Reference;
import org.valkyrienskies.physics_api_krunch.voxel.KrunchVoxelChunk16;

class KrunchNativeVoxelShapeReference
implements hl_0,
Ix {
    private static final long a = 0L;
    private static int b = -2;
    private static final long c = -1L;
    private long d;
    private final KrunchLod1BlockRegistry e;

    /*
     * WARNING - void declaration
     */
    protected KrunchNativeVoxelShapeReference(long shapeAddress, KrunchLod1BlockRegistry lod1BlockRegistry) {
        void var3_2;
        void var1_1;
        this.d = var1_1;
        this.e = var3_2;
    }

    @Override
    public void close() {
        this.h();
        boolean bl = KrunchNativeVoxelShapeReference.deleteVoxelShape(this.d);
        if (!bl) {
            throw new hf_0("Delete voxel shape failed! This shape is currently in use!");
        }
        this.d = -1L;
    }

    protected void finalize() {
        if (this.d != -1L) {
            this.close();
        }
    }

    @Override
    public final boolean c() {
        this.h();
        return KrunchNativeVoxelShapeReference.getIsVoxelTerrainFullyLoaded(this.d);
    }

    @Override
    public final void a(boolean bl) {
        this.h();
        KrunchNativeVoxelShapeReference.setIsVoxelTerrainFullyLoaded(this.d, bl);
    }

    @Override
    public final boolean a(AABBi aABBi) {
        this.h();
        int[] nArray = new int[6];
        boolean bl = KrunchNativeVoxelShapeReference.getVoxelShapeAABB(this.d, nArray);
        if (!bl) {
            return false;
        }
        aABBi.minX = nArray[0];
        aABBi.minY = nArray[1];
        aABBi.minZ = nArray[2];
        aABBi.maxX = nArray[3];
        aABBi.maxY = nArray[4];
        aABBi.maxZ = nArray[5];
        return true;
    }

    @Override
    public final long b() {
        this.h();
        return this.d;
    }

    @Override
    public final void a() {
        this.h();
        KrunchNativeVoxelShapeReference.bakeVoxelShape(this.d);
    }

    @Override
    public final KrunchVoxelChunk16 e(int n2, int n3, int n4) {
        this.h();
        long l2 = KrunchNativeVoxelShapeReference.copyVoxel16Chunk(this.d, n2, n3, n4);
        if (l2 != 0L) {
            return new KrunchVoxelChunk16(l2, this.e);
        }
        return null;
    }

    @Override
    public final boolean f(int n2, int n3, int n4) {
        this.h();
        return KrunchNativeVoxelShapeReference.voxel16ChunkExists(this.d, n2, n3, n4);
    }

    @Override
    public final KrunchVoxelChunk16 a(int n2, int n3, int n4, ig_0 ig_02) {
        this.h();
        long l2 = KrunchNativeVoxelShapeReference.insertChunk(this.d, n2, n3, n4, ((KrunchVoxelChunk16)ig_02).d(), true);
        if (l2 != 0L) {
            return new KrunchVoxelChunk16(l2, this.e);
        }
        return null;
    }

    @Override
    public final void b(int n2, int n3, int n4, ig_0 ig_02) {
        this.h();
        long l2 = KrunchNativeVoxelShapeReference.insertChunk(this.d, n2, n3, n4, ((KrunchVoxelChunk16)ig_02).d(), false);
        if (l2 != 0L) {
            throw new IllegalStateException("This should not be possible!");
        }
    }

    @Override
    public final KrunchVoxelChunk16 a(int n2, int n3, int n4) {
        this.h();
        long l2 = KrunchNativeVoxelShapeReference.insertAirChunk(this.d, n2, n3, n4, true);
        if (l2 != 0L) {
            return new KrunchVoxelChunk16(l2, this.e);
        }
        return null;
    }

    @Override
    public final void b(int n2, int n3, int n4) {
        this.h();
        long l2 = KrunchNativeVoxelShapeReference.insertAirChunk(this.d, n2, n3, n4, false);
        if (l2 != 0L) {
            throw new IllegalStateException("This should not be possible!");
        }
    }

    @Override
    public final KrunchVoxelChunk16 c(int n2, int n3, int n4) {
        this.h();
        long l2 = KrunchNativeVoxelShapeReference.deleteChunk(this.d, n2, n3, n4, true);
        if (l2 != 0L) {
            return new KrunchVoxelChunk16(l2, this.e);
        }
        return null;
    }

    @Override
    public final void d(int n2, int n3, int n4) {
        this.h();
        long l2 = KrunchNativeVoxelShapeReference.deleteChunk(this.d, n2, n3, n4, false);
        if (l2 != 0L) {
            throw new IllegalStateException("This should not be possible!");
        }
    }

    @Override
    public final boolean i_() {
        return KrunchNativeVoxelShapeReference.getIsBaked(this.d);
    }

    @Override
    public final GU e() {
        this.h();
        return this.e;
    }

    @Override
    public final KrunchUnsafeVoxelChunk16Reference g(int n2, int n3, int n4) {
        this.h();
        long l2 = KrunchNativeVoxelShapeReference.getVoxel16ChunkPtrUnsafe(this.d, n2, n3, n4);
        if (l2 != 0L) {
            return new KrunchUnsafeVoxelChunk16Reference(l2, this.e);
        }
        return null;
    }

    @Override
    public final void a(int n2, int n3, int n4, int n5, int n6, int n7) {
        this.h();
        KrunchNativeVoxelShapeReference.setDefinedAABBNative(this.d, n2, n3, n4, n5, n6, n7);
    }

    @Override
    public final int d() {
        this.h();
        return KrunchNativeVoxelShapeReference.getVoxelChunkCountNative(this.d);
    }

    @Override
    public final void a(Vector3dc vector3dc) {
        this.h();
        KrunchNativeVoxelShapeReference.setVoxelOffsetNative(this.d, vector3dc.x(), vector3dc.y(), vector3dc.z());
    }

    @Override
    public final Vector3dc f() {
        this.h();
        double[] dArray = new double[3];
        KrunchNativeVoxelShapeReference.getVoxelOffsetNative(this.d, dArray);
        return new Vector3d(dArray[0], dArray[1], dArray[2]);
    }

    private static native boolean getIsVoxelTerrainFullyLoaded(long var0);

    private static native void setIsVoxelTerrainFullyLoaded(long var0, boolean var2);

    private static native boolean getIsBaked(long var0);

    private static native boolean getVoxelShapeAABB(long var0, int[] var2);

    private static native void bakeVoxelShape(long var0);

    private static native long deleteChunk(long var0, int var2, int var3, int var4, boolean var5);

    private static native long insertChunk(long var0, int var2, int var3, int var4, long var5, boolean var7);

    private static native long insertAirChunk(long var0, int var2, int var3, int var4, boolean var5);

    private static native long copyVoxel16Chunk(long var0, int var2, int var3, int var4);

    private static native boolean voxel16ChunkExists(long var0, int var2, int var3, int var4);

    private static native boolean deleteVoxelShape(long var0);

    private static native long getVoxel16ChunkPtrUnsafe(long var0, int var2, int var3, int var4);

    private static native void setDefinedAABBNative(long var0, int var2, int var3, int var4, int var5, int var6, int var7);

    private static native int getVoxelChunkCountNative(long var0);

    private static native void setVoxelOffsetNative(long var0, double var2, double var4, double var6);

    private static native void getVoxelOffsetNative(long var0, double[] var2);

    private int h(int n2, int n3, int n4) {
        this.h();
        return KrunchNativeVoxelShapeReference.getSolidVoxelState(this.d, n2, n3, n4);
    }

    private int i(int n2, int n3, int n4) {
        this.h();
        return KrunchNativeVoxelShapeReference.getLiquidVoxelState(this.d, n2, n3, n4);
    }

    private List<Vector3ic> g() {
        this.h();
        int n2 = KrunchNativeVoxelShapeReference.getSolidSetVoxelsSize(this.d);
        int[] nArray = new int[n2 * 3];
        KrunchNativeVoxelShapeReference.getSolidSetVoxels(this.d, nArray);
        ArrayList<Vector3ic> arrayList = new ArrayList<Vector3ic>(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            arrayList.add(new Vector3i(nArray[i2 * 3], nArray[i2 * 3 + 1], nArray[i2 * 3 + 2]));
        }
        return arrayList;
    }

    @Override
    public final boolean j_() {
        return this.d == -1L;
    }

    private void h() {
        if (this.j_()) {
            throw new hh_0("This shape has been deleted!");
        }
    }

    private static native int getSolidVoxelState(long var0, int var2, int var3, int var4);

    private static native int getLiquidVoxelState(long var0, int var2, int var3, int var4);

    private static native int getSolidSetVoxelsSize(long var0);

    private static native void getSolidSetVoxels(long var0, int[] var2);
}

