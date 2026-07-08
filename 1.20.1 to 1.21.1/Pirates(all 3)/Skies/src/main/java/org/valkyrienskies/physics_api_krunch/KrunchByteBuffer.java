/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.physics_api_krunch;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.valkyrienskies.core.impl.shadow.hi_0;

public final class KrunchByteBuffer
implements hi_0 {
    private final ByteBuffer a;
    private final long b;
    private final int c;

    /*
     * WARNING - void declaration
     */
    public KrunchByteBuffer(int size) {
        void var1_1;
        this.a = ByteBuffer.allocateDirect(size);
        this.b = KrunchByteBuffer.getDirectBufferAddress(this.a);
        this.c = var1_1;
        this.a.order(ByteOrder.LITTLE_ENDIAN);
    }

    @Override
    public final ByteBuffer a() {
        return this.a;
    }

    @Override
    public final long b() {
        return this.b;
    }

    @Override
    public final int c() {
        return this.c;
    }

    private static native long getDirectBufferAddress(ByteBuffer var0);
}

