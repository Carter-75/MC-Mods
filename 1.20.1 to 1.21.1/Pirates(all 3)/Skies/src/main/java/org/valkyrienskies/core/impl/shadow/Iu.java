/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.ints.IntArrayList
 */
package org.valkyrienskies.core.impl.shadow;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.ha_0;
import org.valkyrienskies.physics_api_krunch.KrunchNativePhysicsWorldIsland;
import org.valkyrienskies.physics_api_krunch.KrunchNativePhysicsWorldReference;

public final class Iu {
    public static List<ha_0.b> a(ByteBuffer byteBuffer, KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference) {
        int n2 = byteBuffer.getInt();
        ArrayList<ha_0.b> arrayList = new ArrayList<ha_0.b>();
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = i2;
            KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference2 = krunchNativePhysicsWorldReference;
            Object object = byteBuffer;
            int n4 = ((ByteBuffer)object).getInt();
            IntArrayList intArrayList = new IntArrayList(n4);
            for (int i3 = 0; i3 < n4; ++i3) {
                int n5 = ((ByteBuffer)object).getInt();
                intArrayList.add(n5);
            }
            object = new KrunchNativePhysicsWorldIsland(n3, intArrayList, krunchNativePhysicsWorldReference2);
            arrayList.add((ha_0.b)object);
        }
        return arrayList;
    }

    private static KrunchNativePhysicsWorldIsland a(ByteBuffer byteBuffer, KrunchNativePhysicsWorldReference krunchNativePhysicsWorldReference, int n2) {
        int n3 = byteBuffer.getInt();
        IntArrayList intArrayList = new IntArrayList(n3);
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = byteBuffer.getInt();
            intArrayList.add(n4);
        }
        return new KrunchNativePhysicsWorldIsland(n2, intArrayList, krunchNativePhysicsWorldReference);
    }
}

