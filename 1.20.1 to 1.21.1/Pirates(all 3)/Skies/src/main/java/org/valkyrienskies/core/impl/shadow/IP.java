/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.Id
 */
package org.valkyrienskies.core.impl.shadow;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.valkyrienskies.core.impl.shadow.HT;
import org.valkyrienskies.core.impl.shadow.HV;
import org.valkyrienskies.core.impl.shadow.HX;
import org.valkyrienskies.core.impl.shadow.HY;
import org.valkyrienskies.core.impl.shadow.HZ;
import org.valkyrienskies.core.impl.shadow.Id;
import org.valkyrienskies.core.impl.shadow.ia_0;
import org.valkyrienskies.core.impl.shadow.ib_0;
import org.valkyrienskies.core.impl.shadow.ic_0;
import org.valkyrienskies.core.impl.shadow.id_0;

public final class IP {
    private IP() {
    }

    public static void a(HZ hZ, ByteBuffer byteBuffer) {
        HZ hZ2 = hZ;
        IP.a(hZ2.a, byteBuffer);
        hZ2 = hZ;
        byteBuffer.putFloat(hZ2.b);
        hZ2 = hZ;
        byteBuffer.putFloat(hZ2.c);
        hZ2 = hZ;
        byteBuffer.putFloat(hZ2.d);
        hZ2 = hZ;
        byteBuffer.putInt(hZ2.e);
    }

    public static HZ a(ByteBuffer byteBuffer) {
        ib_0 ib_02 = IP.c(byteBuffer);
        float f2 = byteBuffer.getFloat();
        float f3 = byteBuffer.getFloat();
        float f4 = byteBuffer.getFloat();
        int n2 = byteBuffer.getInt();
        return new HZ(ib_02, f2, f3, f4, n2);
    }

    public static void a(HX hX, ByteBuffer byteBuffer) {
        HX hX2 = hX;
        IP.a(hX2.a, byteBuffer);
        hX2 = hX;
        byteBuffer.putFloat(hX2.b);
        hX2 = hX;
        byteBuffer.putFloat(hX2.c);
        hX2 = hX;
        IP.a(hX2.d, byteBuffer);
        hX2 = hX;
        byteBuffer.putInt(hX2.e);
    }

    public static HX b(ByteBuffer byteBuffer) {
        id_0 id_02 = IP.f(byteBuffer);
        float f2 = byteBuffer.getFloat();
        float f3 = byteBuffer.getFloat();
        Vector3f vector3f = IP.i(byteBuffer);
        int n2 = byteBuffer.getInt();
        return new HX(id_02, f2, f3, vector3f, n2);
    }

    private static void a(ib_0 ib_02, ByteBuffer byteBuffer) {
        byteBuffer.putInt(ib_02.f().ordinal());
        switch (ib_02.f()) {
            case SOLID_BOXES: {
                IP.a((ia_0)ib_02, byteBuffer);
                return;
            }
            case BELT: {
                IP.a((HY)ib_02, byteBuffer);
            }
        }
    }

    private static ib_0 c(ByteBuffer byteBuffer) {
        ic_0 ic_02 = ic_0.values()[byteBuffer.getInt()];
        switch (ic_02) {
            case SOLID_BOXES: {
                return IP.d(byteBuffer);
            }
            case BELT: {
                return IP.e(byteBuffer);
            }
        }
        throw new RuntimeException("Failed to deserialize unknown Lod1SolidCollisionShape");
    }

    private static void a(ia_0 ia_02, ByteBuffer byteBuffer) {
        Iterator<id_0> iterator2 = ia_02;
        IP.a(((ia_0)((Object)iterator2)).a, byteBuffer);
        iterator2 = ia_02;
        IP.a(((ia_0)((Object)iterator2)).b, byteBuffer);
        iterator2 = ia_02;
        byteBuffer.putInt(((ia_0)((Object)iterator2)).c.size());
        iterator2 = ia_02;
        for (Id id : ((ia_0)((Object)iterator2)).c) {
            IP.a((id_0)id, byteBuffer);
        }
        iterator2 = ia_02;
        byteBuffer.putInt(((ia_0)((Object)iterator2)).d.size());
        iterator2 = ia_02;
        for (Id id : ((ia_0)((Object)iterator2)).d) {
            IP.a((id_0)id, byteBuffer);
        }
    }

    private static ia_0 d(ByteBuffer byteBuffer) {
        int n2;
        id_0 id_02 = IP.f(byteBuffer);
        List<HT> list = IP.g(byteBuffer);
        int n3 = byteBuffer.getInt();
        ArrayList<id_0> arrayList = new ArrayList<id_0>(n3);
        for (n2 = 0; n2 < n3; ++n2) {
            arrayList.add(IP.f(byteBuffer));
        }
        n2 = byteBuffer.getInt();
        ArrayList<id_0> arrayList2 = new ArrayList<id_0>(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            arrayList2.add(IP.f(byteBuffer));
        }
        return new ia_0(id_02, list, arrayList, arrayList2);
    }

    private static void a(HY hY, ByteBuffer byteBuffer) {
        HY hY2 = hY;
        IP.a(hY2.a, byteBuffer);
        hY2 = hY;
        IP.a(hY2.b, byteBuffer);
        hY2 = hY;
        IP.a(hY2.c, byteBuffer);
        hY2 = hY;
        byteBuffer.putInt(hY2.d.ordinal());
        hY2 = hY;
        IP.a(hY2.e, byteBuffer);
    }

    private static HY e(ByteBuffer object) {
        id_0 id_02 = IP.f((ByteBuffer)object);
        List<HT> list = IP.g((ByteBuffer)object);
        id_0 id_03 = IP.f((ByteBuffer)object);
        HV hV = HV.values()[((ByteBuffer)object).getInt()];
        object = IP.i((ByteBuffer)object);
        return new HY(id_02, list, id_03, hV, (Vector3fc)object);
    }

    public static void a(id_0 id_02, ByteBuffer byteBuffer) {
        byteBuffer.putInt(((Id)id_02).b);
    }

    private static id_0 f(ByteBuffer byteBuffer) {
        return id_0.a.a(byteBuffer.getInt());
    }

    public static void a(List<HT> object, ByteBuffer byteBuffer) {
        byteBuffer.putInt(object.size());
        object = object.iterator();
        while (object.hasNext()) {
            HT hT = (HT)object.next();
            IP.a(hT, byteBuffer);
        }
    }

    private static List<HT> g(ByteBuffer byteBuffer) {
        int n2 = byteBuffer.getInt();
        ArrayList<HT> arrayList = new ArrayList<HT>(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            arrayList.add(IP.h(byteBuffer));
        }
        return arrayList;
    }

    private static void a(HT hT, ByteBuffer byteBuffer) {
        HT hT2 = hT;
        IP.a(hT2.a, byteBuffer);
        hT2 = hT;
        byteBuffer.putFloat(hT2.b);
    }

    private static HT h(ByteBuffer byteBuffer) {
        Vector3f vector3f = IP.i(byteBuffer);
        float f2 = byteBuffer.getFloat();
        return new HT(vector3f, f2);
    }

    public static void a(Vector3fc vector3fc, ByteBuffer byteBuffer) {
        byteBuffer.putFloat(vector3fc.x());
        byteBuffer.putFloat(vector3fc.y());
        byteBuffer.putFloat(vector3fc.z());
    }

    private static Vector3f i(ByteBuffer byteBuffer) {
        float f2 = byteBuffer.getFloat();
        float f3 = byteBuffer.getFloat();
        float f4 = byteBuffer.getFloat();
        return new Vector3f(f2, f3, f4);
    }
}

