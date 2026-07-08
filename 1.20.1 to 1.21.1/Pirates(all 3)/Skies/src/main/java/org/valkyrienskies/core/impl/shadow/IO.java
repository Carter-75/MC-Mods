/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.nio.ByteBuffer;
import org.valkyrienskies.core.impl.shadow.ij_0;
import org.valkyrienskies.core.impl.shadow.in_0;

public final class IO {
    private IO() {
    }

    public static void a(ij_0 ij_02, ByteBuffer byteBuffer) {
        ij_0 ij_03 = ij_02;
        byteBuffer.putInt(ij_03.b);
        ij_03 = ij_02;
        byteBuffer.putInt(ij_03.c);
        ij_03 = ij_02;
        byteBuffer.putInt(ij_03.d);
        for (int i2 = 0; i2 < 16; ++i2) {
            for (int i3 = 0; i3 < 16; ++i3) {
                for (int i4 = 0; i4 < 16; ++i4) {
                    byteBuffer.putInt(ij_02.a(i2, i3, i4));
                }
            }
        }
    }

    public static void a(in_0 in_02, ByteBuffer byteBuffer) {
        in_0 in_03 = in_02;
        byteBuffer.putInt(in_03.b);
        in_03 = in_02;
        byteBuffer.putInt(in_03.c);
        in_03 = in_02;
        byteBuffer.putInt(in_03.d);
        in_03 = in_02;
        byteBuffer.putInt(in_03.e.size());
        int n2 = 0;
        while (true) {
            in_03 = in_02;
            if (n2 >= in_03.e.size()) break;
            in_03 = in_02;
            short s = in_03.e.getShort(n2);
            in_03 = in_02;
            int n3 = in_03.f.getInt(n2);
            byteBuffer.putShort(s);
            byteBuffer.putInt(n3);
            ++n2;
        }
    }
}

