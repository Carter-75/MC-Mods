/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.impl.shadow.HQ;
import org.valkyrienskies.core.impl.shadow.HR;
import org.valkyrienskies.core.impl.shadow.IN;

public final class Iq {
    private static void a(IN iterator2, ByteBuffer byteBuffer) {
        Object object = iterator2;
        byteBuffer.putInt(((IN)object).a);
        object = iterator2;
        byteBuffer.putInt(((IN)object).b);
        object = iterator2;
        iterator2 = ((IN)object).c;
        byteBuffer.putInt(iterator2.size());
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            Object object2;
            object = object2 = (HQ)iterator2.next();
            byteBuffer.put((byte)((HQ)object).a.ordinal());
            object = object2;
            object = ((HQ)object).b;
            byteBuffer.putDouble(object.x()).putDouble(object.y()).putDouble(object.z());
            object = object2;
            object = ((HQ)object).c;
            byteBuffer.putDouble(object.x()).putDouble(object.y()).putDouble(object.z());
            object = object2;
            byteBuffer.putFloat(((HQ)object).d);
            object = object2;
            object2 = ((HQ)object).e;
            byteBuffer.putDouble(object2.x()).putDouble(object2.y()).putDouble(object2.z());
        }
    }

    public static IN a(ByteBuffer byteBuffer) {
        int n2 = byteBuffer.getInt();
        int n3 = byteBuffer.getInt();
        int n4 = byteBuffer.getInt();
        ArrayList<HQ> arrayList = new ArrayList<HQ>(n4);
        for (int i2 = 0; i2 < n4; ++i2) {
            Object object = HR.values()[byteBuffer.get()];
            HR hR = object;
            object = byteBuffer;
            Vector3d vector3d = new Vector3d(((ByteBuffer)object).getDouble(), ((ByteBuffer)object).getDouble(), ((ByteBuffer)object).getDouble());
            Vector3d vector3d2 = new Vector3d(((ByteBuffer)object).getDouble(), ((ByteBuffer)object).getDouble(), ((ByteBuffer)object).getDouble());
            float f2 = ((ByteBuffer)object).getFloat();
            object = new Vector3d(((ByteBuffer)object).getDouble(), ((ByteBuffer)object).getDouble(), ((ByteBuffer)object).getDouble());
            object = new HQ(hR, vector3d, vector3d2, f2, (Vector3dc)object);
            arrayList.add((HQ)object);
        }
        return new IN(n2, n3, arrayList);
    }

    private static HQ a(ByteBuffer object, HR hR) {
        Vector3d vector3d = new Vector3d(((ByteBuffer)object).getDouble(), ((ByteBuffer)object).getDouble(), ((ByteBuffer)object).getDouble());
        Vector3d vector3d2 = new Vector3d(((ByteBuffer)object).getDouble(), ((ByteBuffer)object).getDouble(), ((ByteBuffer)object).getDouble());
        float f2 = ((ByteBuffer)object).getFloat();
        object = new Vector3d(((ByteBuffer)object).getDouble(), ((ByteBuffer)object).getDouble(), ((ByteBuffer)object).getDouble());
        return new HQ(hR, vector3d, vector3d2, f2, (Vector3dc)object);
    }
}

