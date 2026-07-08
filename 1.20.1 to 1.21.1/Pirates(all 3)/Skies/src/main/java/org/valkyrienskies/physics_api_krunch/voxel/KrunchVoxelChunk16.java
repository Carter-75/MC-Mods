/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.physics_api_krunch.voxel;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.GU;
import org.valkyrienskies.core.impl.shadow.hh_0;
import org.valkyrienskies.core.impl.shadow.hi_0;
import org.valkyrienskies.core.impl.shadow.ig_0;
import org.valkyrienskies.core.impl.shadow.ij_0;
import org.valkyrienskies.core.impl.shadow.im_0;
import org.valkyrienskies.core.impl.shadow.in_0;
import org.valkyrienskies.physics_api_krunch.voxel.KrunchLod1BlockRegistry;

public class KrunchVoxelChunk16
implements ig_0 {
    private static final long a = 0L;
    private long b;
    private final KrunchLod1BlockRegistry c;
    private final List<im_0> d;

    /*
     * WARNING - void declaration
     */
    public KrunchVoxelChunk16(long chunkAddress, KrunchLod1BlockRegistry lod1BlockRegistry) {
        void var3_2;
        void var1_1;
        this.b = var1_1;
        this.c = var3_2;
        this.d = new ArrayList<im_0>();
    }

    /*
     * WARNING - void declaration
     */
    public KrunchVoxelChunk16(KrunchLod1BlockRegistry lod1BlockRegistry) {
        void var1_1;
        this.b = KrunchVoxelChunk16.createEmptyVoxelChunk16Native();
        this.c = var1_1;
        this.d = new ArrayList<im_0>();
    }

    public final long d() {
        this.e();
        long l2 = this.b;
        this.b = 0L;
        return l2;
    }

    @Override
    public final void a(hi_0 hi_02) {
        this.e();
        for (im_0 im_02 : this.d) {
            short s;
            int n2;
            im_0 im_03;
            ByteBuffer byteBuffer;
            hi_02.a().position(0);
            if (im_02 instanceof ij_0) {
                byteBuffer = hi_02.a();
                im_03 = im_02 = (ij_0)im_02;
                byteBuffer.putInt(((ij_0)im_03).b);
                im_03 = im_02;
                byteBuffer.putInt(((ij_0)im_03).c);
                im_03 = im_02;
                byteBuffer.putInt(((ij_0)im_03).d);
                for (n2 = 0; n2 < 16; ++n2) {
                    for (s = 0; s < 16; ++s) {
                        for (int i2 = 0; i2 < 16; ++i2) {
                            byteBuffer.putInt(((ij_0)im_02).a(n2, s, i2));
                        }
                    }
                }
                KrunchVoxelChunk16.applyDenseVoxelChunkUpdate(this.b, this.c.e(), hi_02.b(), hi_02.c());
                continue;
            }
            if (im_02 instanceof in_0) {
                byteBuffer = hi_02.a();
                im_03 = im_02 = (in_0)im_02;
                byteBuffer.putInt(((in_0)im_03).b);
                im_03 = im_02;
                byteBuffer.putInt(((in_0)im_03).c);
                im_03 = im_02;
                byteBuffer.putInt(((in_0)im_03).d);
                im_03 = im_02;
                byteBuffer.putInt(((in_0)im_03).e.size());
                n2 = 0;
                while (true) {
                    im_0 im_04 = im_02;
                    if (n2 >= ((in_0)im_04).e.size()) break;
                    im_04 = im_02;
                    s = ((in_0)im_04).e.getShort(n2);
                    im_04 = im_02;
                    int n3 = ((in_0)im_04).f.getInt(n2);
                    byteBuffer.putShort(s);
                    byteBuffer.putInt(n3);
                    ++n2;
                }
                KrunchVoxelChunk16.applySparseVoxelChunkUpdate(this.b, this.c.e(), hi_02.b(), hi_02.c());
                continue;
            }
            throw new IllegalStateException("Unsupported voxel update!");
        }
        this.d.clear();
        KrunchVoxelChunk16.bakeVoxel16Chunk(this.b, this.c.e());
    }

    @Override
    public final boolean a() {
        this.e();
        return this.d.isEmpty();
    }

    @Override
    public final void a(im_0 im_02) {
        this.e();
        this.d.add(im_02);
    }

    @Override
    public final GU c() {
        this.e();
        return this.c;
    }

    @Override
    public void close() {
        if (!this.b()) {
            KrunchVoxelChunk16.deleteChunk(this.b);
            this.b = 0L;
        }
    }

    protected void finalize() {
        if (!this.b()) {
            this.close();
        }
    }

    @Override
    public final boolean b() {
        return this.b == 0L;
    }

    private void e() {
        if (this.b()) {
            throw new hh_0("This shape has been deleted!");
        }
    }

    private int a(int n2, int n3, int n4) {
        this.e();
        return KrunchVoxelChunk16.getLod1SolidBlockStateId(this.b, n2, n3, n4);
    }

    private int b(int n2, int n3, int n4) {
        this.e();
        return KrunchVoxelChunk16.getLod1LiquidBlockStateId(this.b, n2, n3, n4);
    }

    private static native void applyDenseVoxelChunkUpdate(long var0, long var2, long var4, int var6);

    private static native void applySparseVoxelChunkUpdate(long var0, long var2, long var4, int var6);

    private static native void bakeVoxel16Chunk(long var0, long var2);

    private static native void deleteChunk(long var0);

    private static native long createEmptyVoxelChunk16Native();

    private static native int getLod1SolidBlockStateId(long var0, int var2, int var3, int var4);

    private static native int getLod1LiquidBlockStateId(long var0, int var2, int var3, int var4);
}

