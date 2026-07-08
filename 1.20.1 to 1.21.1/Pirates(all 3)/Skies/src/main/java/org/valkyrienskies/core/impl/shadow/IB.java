/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.joml.Quaterniond;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.impl.shadow.hb_0;
import org.valkyrienskies.core.impl.shadow.hc_0;

public final class IB {
    private static int a = 104;
    private static int b = 56;

    private static void a(hc_0 hc_02, ByteBuffer byteBuffer) {
        hc_0 hc_03 = hc_02;
        byteBuffer.putDouble(hc_03.b.x());
        hc_03 = hc_02;
        byteBuffer.putDouble(hc_03.b.y());
        hc_03 = hc_02;
        byteBuffer.putDouble(hc_03.b.z());
        hc_03 = hc_02;
        byteBuffer.putDouble(hc_03.c.x());
        hc_03 = hc_02;
        byteBuffer.putDouble(hc_03.c.y());
        hc_03 = hc_02;
        byteBuffer.putDouble(hc_03.c.z());
        hc_03 = hc_02;
        byteBuffer.putDouble(hc_03.c.w());
        hc_03 = hc_02;
        byteBuffer.putDouble(hc_03.d.x());
        hc_03 = hc_02;
        byteBuffer.putDouble(hc_03.d.y());
        hc_03 = hc_02;
        byteBuffer.putDouble(hc_03.d.z());
        hc_03 = hc_02;
        byteBuffer.putDouble(hc_03.e.x());
        hc_03 = hc_02;
        byteBuffer.putDouble(hc_03.e.y());
        hc_03 = hc_02;
        byteBuffer.putDouble(hc_03.e.z());
    }

    public static byte[] a(hc_0 hc_02) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(104);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        IB.a(hc_02, byteBuffer);
        return byteBuffer.array();
    }

    private static hc_0 a(ByteBuffer object) {
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
        double d12 = ((ByteBuffer)object).getDouble();
        double d13 = ((ByteBuffer)object).getDouble();
        double d14 = ((ByteBuffer)object).getDouble();
        object = new Vector3d(d2, d3, d4);
        Quaterniond quaterniond = new Quaterniond(d5, d6, d7, d8);
        Vector3d vector3d = new Vector3d(d9, d10, d11);
        Vector3d vector3d2 = new Vector3d(d12, d13, d14);
        return new hc_0((Vector3dc)object, quaterniond, vector3d, vector3d2);
    }

    public static hc_0 a(byte[] object) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(object);
        object = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return IB.a((ByteBuffer)object);
    }

    private static void a(hb_0 hb_02, ByteBuffer byteBuffer) {
        hb_0 hb_03 = hb_02;
        byteBuffer.putDouble(hb_03.a.x());
        hb_03 = hb_02;
        byteBuffer.putDouble(hb_03.a.y());
        hb_03 = hb_02;
        byteBuffer.putDouble(hb_03.a.z());
        hb_03 = hb_02;
        byteBuffer.putDouble(hb_03.b.x());
        hb_03 = hb_02;
        byteBuffer.putDouble(hb_03.b.y());
        hb_03 = hb_02;
        byteBuffer.putDouble(hb_03.b.z());
        hb_03 = hb_02;
        byteBuffer.putDouble(hb_03.b.w());
    }

    public static byte[] a(hb_0 hb_02) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(56);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        IB.a(hb_02, byteBuffer);
        return byteBuffer.array();
    }

    private static hb_0 b(ByteBuffer object) {
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

    public static hb_0 b(byte[] object) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(object);
        object = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return IB.b((ByteBuffer)object);
    }
}

