/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.ints.Int2ObjectMap
 *  it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap
 *  kotlin.NotImplementedError
 */
package org.valkyrienskies.physics_api_krunch.voxel;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import kotlin.NotImplementedError;
import org.valkyrienskies.core.impl.shadow.GU;
import org.valkyrienskies.core.impl.shadow.HW;
import org.valkyrienskies.core.impl.shadow.HX;
import org.valkyrienskies.core.impl.shadow.HY;
import org.valkyrienskies.core.impl.shadow.HZ;
import org.valkyrienskies.core.impl.shadow.IP;
import org.valkyrienskies.core.impl.shadow.hh_0;
import org.valkyrienskies.core.impl.shadow.hi_0;
import org.valkyrienskies.core.impl.shadow.ia_0;
import org.valkyrienskies.core.impl.shadow.id_0;

public class KrunchLod1BlockRegistry
implements GU {
    private static final long e = 0L;
    private long f;
    private final Int2ObjectMap<HZ> g = new Int2ObjectOpenHashMap();
    private final Int2ObjectMap<HX> h = new Int2ObjectOpenHashMap();
    private final HZ i;
    private final HX j;
    private final HW k;

    /*
     * WARNING - void declaration
     */
    public KrunchLod1BlockRegistry(hi_0 vsByteBuffer) {
        HW hW;
        void var1_1;
        this.f = KrunchLod1BlockRegistry.allocateNewKrunchLod1BlockRegistry();
        this.i = this.a(0, vsByteBuffer);
        this.j = this.b(0, vsByteBuffer);
        void var2_4 = var1_1;
        boolean bl = false;
        Object object = this;
        ((KrunchLod1BlockRegistry)object).f();
        int n2 = KrunchLod1BlockRegistry.getLod1BlockState(((KrunchLod1BlockRegistry)object).f, 0, var2_4.b(), var2_4.c());
        if (n2 != 0) {
            var2_4.a().position(0);
            n2 = var2_4.a().getInt();
            int n3 = var2_4.a().getInt();
            HZ hZ = ((KrunchLod1BlockRegistry)object).a(n2, (hi_0)var2_4);
            if (hZ == null) {
                throw new RuntimeException("Lod1SolidBlockState with id " + n2 + " not found!");
            }
            if ((object = ((KrunchLod1BlockRegistry)object).b(n3, (hi_0)var2_4)) == null) {
                throw new RuntimeException("Lod1LiquidBlockState with id " + n3 + " not found!");
            }
            hW = new HW(hZ, (HX)object, 0);
        } else {
            hW = null;
        }
        ((KrunchLod1BlockRegistry)object).k = hW;
        this.g.put(0, (Object)this.i);
        this.h.put(0, (Object)this.j);
    }

    public final long e() {
        this.f();
        return this.f;
    }

    @Override
    public final void a(HZ hZ, hi_0 hi_02) {
        Iterator<id_0> iterator2;
        this.f();
        hi_02.a().position(0);
        ByteBuffer byteBuffer = hi_02.a();
        HZ hZ2 = hZ;
        Object object = hZ2;
        ByteBuffer byteBuffer2 = byteBuffer;
        object = hZ2.a;
        byteBuffer2.putInt(object.f().ordinal());
        switch (object.f()) {
            case SOLID_BOXES: {
                object = (ia_0)object;
                iterator2 = object;
                IP.a(((ia_0)object).a, byteBuffer2);
                iterator2 = object;
                IP.a(((ia_0)((Object)iterator2)).b, byteBuffer2);
                iterator2 = object;
                byteBuffer2.putInt(((ia_0)((Object)iterator2)).c.size());
                iterator2 = object;
                for (id_0 id_02 : ((ia_0)((Object)iterator2)).c) {
                    IP.a(id_02, byteBuffer2);
                }
                iterator2 = object;
                byteBuffer2.putInt(((ia_0)((Object)iterator2)).d.size());
                iterator2 = object;
                for (id_0 id_02 : ((ia_0)((Object)iterator2)).d) {
                    IP.a(id_02, byteBuffer2);
                }
                break;
            }
            case BELT: {
                object = (HY)object;
                iterator2 = object;
                IP.a(((HY)object).a, byteBuffer2);
                iterator2 = object;
                IP.a(((HY)((Object)iterator2)).b, byteBuffer2);
                iterator2 = object;
                IP.a(((HY)((Object)iterator2)).c, byteBuffer2);
                iterator2 = object;
                byteBuffer2.putInt(((HY)((Object)iterator2)).d.ordinal());
                iterator2 = object;
                IP.a(((HY)((Object)iterator2)).e, byteBuffer2);
            }
        }
        object = hZ2;
        byteBuffer.putFloat(((HZ)object).b);
        object = hZ2;
        byteBuffer.putFloat(((HZ)object).c);
        object = hZ2;
        byteBuffer.putFloat(((HZ)object).d);
        iterator2 = hZ2;
        byteBuffer.putInt(((HZ)((Object)iterator2)).e);
        boolean bl = KrunchLod1BlockRegistry.registerLod1SolidBlockState(this.f, hi_02.b(), hi_02.c());
        if (!bl) {
            throw new IllegalArgumentException("Already existing Lod1SolidBlockState found for Lod1SolidBlockState.lod1SolidBlockStateId");
        }
        iterator2 = hZ;
        this.g.put(((HZ)((Object)iterator2)).e, (Object)hZ);
    }

    @Override
    public final void a(HX hX, hi_0 hi_02) {
        HX hX2;
        this.f();
        hi_02.a().position(0);
        ByteBuffer byteBuffer = hi_02.a();
        HX hX3 = hX2 = hX;
        IP.a(hX2.a, byteBuffer);
        hX3 = hX2;
        byteBuffer.putFloat(hX3.b);
        hX3 = hX2;
        byteBuffer.putFloat(hX3.c);
        hX3 = hX2;
        IP.a(hX3.d, byteBuffer);
        byteBuffer.putInt(hX2.e);
        boolean bl = KrunchLod1BlockRegistry.registerLod1LiquidBlockState(this.f, hi_02.b(), hi_02.c());
        if (!bl) {
            throw new IllegalArgumentException("Already existing Lod1LiquidBlockState found for lod1LiquidBlockState.lod1LiquidBlockStateId");
        }
        hX2 = hX;
        this.h.put(hX2.e, (Object)hX);
    }

    @Override
    public final HW a(int n2, int n3, int n4) {
        this.f();
        HZ hZ = (HZ)this.g.get(n2);
        if (hZ == null) {
            throw new IllegalArgumentException("No Lod1SolidBlockState found for id " + n2);
        }
        HX hX = (HX)this.h.get(n3);
        if (hX == null) {
            throw new IllegalArgumentException("No Lod1LiquidBlockState found for id " + n3);
        }
        boolean bl = KrunchLod1BlockRegistry.registerLod1BlockState(this.f, n4, n2, n3);
        n2 = bl ? 1 : 0;
        if (!bl) {
            throw new IllegalArgumentException("Already existing Lod1BlockState found for lod1BlockStateId");
        }
        return new HW(hZ, hX, n4);
    }

    @Override
    public final HZ a(int n2, hi_0 hi_02) {
        this.f();
        boolean bl = KrunchLod1BlockRegistry.getLod1SolidBlockState(this.f, n2, hi_02.b(), hi_02.c());
        n2 = bl ? 1 : 0;
        if (!bl) {
            throw new IllegalArgumentException("No Lod1SolidBlockState found for lod1SolidBlockStateId");
        }
        hi_02.a().position(0);
        return IP.a(hi_02.a());
    }

    @Override
    public final HX b(int n2, hi_0 hi_02) {
        this.f();
        boolean bl = KrunchLod1BlockRegistry.getLod1LiquidBlockState(this.f, n2, hi_02.b(), hi_02.c());
        n2 = bl ? 1 : 0;
        if (!bl) {
            throw new IllegalArgumentException("No Lod1LiquidBlockState found for lod1LiquidBlockStateId");
        }
        hi_02.a().position(0);
        return IP.b(hi_02.a());
    }

    @Override
    public final HW c(int n2, hi_0 hi_02) {
        this.f();
        boolean bl = KrunchLod1BlockRegistry.getLod1BlockState(this.f, 0, hi_02.b(), hi_02.c());
        n2 = bl ? 1 : 0;
        if (bl) {
            hi_02.a().position(0);
            n2 = hi_02.a().getInt();
            int n3 = hi_02.a().getInt();
            HZ hZ = this.a(n2, hi_02);
            if (hZ == null) {
                throw new RuntimeException("Lod1SolidBlockState with id " + n2 + " not found!");
            }
            HX hX = this.b(n3, hi_02);
            if (hX == null) {
                throw new RuntimeException("Lod1LiquidBlockState with id " + n3 + " not found!");
            }
            return new HW(hZ, hX, 0);
        }
        return null;
    }

    @Override
    public final Map<Integer, HZ> a(hi_0 hi_02) {
        throw new NotImplementedError();
    }

    @Override
    public final Map<Integer, HZ> b(hi_0 hi_02) {
        throw new NotImplementedError();
    }

    @Override
    public final Map<Integer, HW> c(hi_0 hi_02) {
        throw new NotImplementedError();
    }

    @Override
    public final HX c() {
        return this.j;
    }

    @Override
    public final HZ b() {
        return this.i;
    }

    @Override
    public final HW d() {
        return this.k;
    }

    @Override
    public final boolean a() {
        return this.f == 0L;
    }

    @Override
    public void close() {
        if (!this.a()) {
            long l2 = this.f;
            this.f = 0L;
            KrunchLod1BlockRegistry.deleteKrunchLod1BlockRegistry(l2);
        }
    }

    protected void finalize() {
        if (!this.a()) {
            this.close();
        }
    }

    private void f() {
        if (this.a()) {
            throw new hh_0("This shape has been deleted!");
        }
    }

    private static native long allocateNewKrunchLod1BlockRegistry();

    private static native void deleteKrunchLod1BlockRegistry(long var0);

    private static native boolean registerLod1SolidBlockState(long var0, long var2, int var4);

    private static native boolean registerLod1LiquidBlockState(long var0, long var2, int var4);

    private static native boolean registerLod1BlockState(long var0, int var2, int var3, int var4);

    private static native boolean getLod1SolidBlockState(long var0, int var2, long var3, int var5);

    private static native boolean getLod1LiquidBlockState(long var0, int var2, long var3, int var5);

    private static native boolean getLod1BlockState(long var0, int var2, long var3, int var5);
}

