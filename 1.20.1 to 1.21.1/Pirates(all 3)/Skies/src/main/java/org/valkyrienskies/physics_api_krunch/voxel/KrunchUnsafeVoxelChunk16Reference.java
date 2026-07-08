/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.physics_api_krunch.voxel;

import org.valkyrienskies.core.impl.shadow.if_0;
import org.valkyrienskies.physics_api_krunch.voxel.KrunchLod1BlockRegistry;
import org.valkyrienskies.physics_api_krunch.voxel.KrunchVoxelChunk16;

public class KrunchUnsafeVoxelChunk16Reference
implements if_0 {
    private final long a;
    private final KrunchLod1BlockRegistry b;

    /*
     * WARNING - void declaration
     */
    public KrunchUnsafeVoxelChunk16Reference(long chunkAddress, KrunchLod1BlockRegistry lod1BlockRegistry) {
        void var3_2;
        void var1_1;
        this.a = var1_1;
        this.b = var3_2;
    }

    private KrunchVoxelChunk16 b() {
        long l2 = KrunchUnsafeVoxelChunk16Reference.copyVoxel16ChunkUnsafe(this.a);
        return new KrunchVoxelChunk16(l2, this.b);
    }

    private static native long copyVoxel16ChunkUnsafe(long var0);

    @Override
    public final /* synthetic */ KrunchVoxelChunk16 a() {
        KrunchUnsafeVoxelChunk16Reference krunchUnsafeVoxelChunk16Reference = this;
        long l2 = KrunchUnsafeVoxelChunk16Reference.copyVoxel16ChunkUnsafe(krunchUnsafeVoxelChunk16Reference.a);
        return new KrunchVoxelChunk16(l2, krunchUnsafeVoxelChunk16Reference.b);
    }
}

