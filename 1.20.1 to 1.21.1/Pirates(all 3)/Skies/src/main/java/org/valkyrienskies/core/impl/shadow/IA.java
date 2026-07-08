/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.joml.Matrix3d;
import org.joml.Matrix3dc;
import org.valkyrienskies.core.impl.shadow.GX;

public final class IA {
    private static int a = 80;

    public static byte[] a(GX gX) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(80);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        GX gX2 = gX;
        byteBuffer.putDouble(gX2.a);
        gX2 = gX;
        byteBuffer.putDouble(gX2.b.m00());
        gX2 = gX;
        byteBuffer.putDouble(gX2.b.m10());
        gX2 = gX;
        byteBuffer.putDouble(gX2.b.m20());
        gX2 = gX;
        byteBuffer.putDouble(gX2.b.m01());
        gX2 = gX;
        byteBuffer.putDouble(gX2.b.m11());
        gX2 = gX;
        byteBuffer.putDouble(gX2.b.m21());
        gX2 = gX;
        byteBuffer.putDouble(gX2.b.m02());
        gX2 = gX;
        byteBuffer.putDouble(gX2.b.m12());
        gX2 = gX;
        byteBuffer.putDouble(gX2.b.m22());
        return byteBuffer.array();
    }

    public static GX a(byte[] object) {
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
}

