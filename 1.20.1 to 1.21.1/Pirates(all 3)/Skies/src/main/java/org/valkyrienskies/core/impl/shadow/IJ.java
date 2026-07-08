/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.impl.shadow.IK;
import org.valkyrienskies.core.impl.shadow.IL;
import org.valkyrienskies.core.impl.shadow.Ir;

@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\nJ\u0015\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0005\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\rR\u0014\u0010\b\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\r"}, d2={"Lorg/valkyrienskies/core/impl/shadow/IJ;", "", "", "p0", "Lorg/valkyrienskies/core/impl/shadow/IK;", "a", "([B)Lorg/valkyrienskies/core/impl/shadow/IK;", "Lorg/valkyrienskies/core/impl/shadow/IL;", "b", "([B)Lorg/valkyrienskies/core/impl/shadow/IL;", "(Lorg/valkyrienskies/core/impl/shadow/IK;)[B", "(Lorg/valkyrienskies/core/impl/shadow/IL;)[B", "", "I", "c", "<init>", "()V"})
public final class IJ {
    public static final IJ INSTANCE = new IJ();
    private static final int b = 36;
    private static final int c = 84;

    private IJ() {
    }

    private static byte[] a(IK iK) {
        Intrinsics.checkNotNullParameter((Object)iK, (String)"");
        byte[] byArray = new byte[36];
        ByteBuffer byteBuffer = ByteBuffer.wrap(byArray).order(ByteOrder.LITTLE_ENDIAN);
        IK iK2 = iK;
        byteBuffer.putInt(iK2.b);
        iK2 = iK;
        byteBuffer.putDouble(iK2.c);
        iK2 = iK;
        Ir.a(iK2.d, byteBuffer);
        return byArray;
    }

    public static IK a(byte[] object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        if (((byte[])object).length != 36) {
            throw new IllegalArgumentException(Intrinsics.stringPlus((String)"rayCastResultBytes has the wrong size ", (Object)((byte[])object).length));
        }
        ByteBuffer byteBuffer = ByteBuffer.wrap((byte[])object).order(ByteOrder.LITTLE_ENDIAN);
        object = byteBuffer;
        int n2 = byteBuffer.getInt();
        double d2 = ((ByteBuffer)object).getDouble();
        object = Ir.b((ByteBuffer)object);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"");
        return new IK(n2, d2, (Vector3dc)object);
    }

    private static byte[] a(IL iL) {
        Intrinsics.checkNotNullParameter((Object)iL, (String)"");
        byte[] byArray = new byte[84];
        ByteBuffer byteBuffer = ByteBuffer.wrap(byArray).order(ByteOrder.LITTLE_ENDIAN);
        IL iL2 = iL;
        byteBuffer.putInt(iL2.b);
        iL2 = iL;
        byteBuffer.putDouble(iL2.c);
        iL2 = iL;
        Ir.a(iL2.d, byteBuffer);
        iL2 = iL;
        Ir.a(iL2.e, byteBuffer);
        iL2 = iL;
        Ir.a(iL2.f, byteBuffer);
        return byArray;
    }

    public static IL b(byte[] object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        if (((byte[])object).length != 84) {
            throw new IllegalArgumentException(Intrinsics.stringPlus((String)"rayCastResultWithVelocityBytes has the wrong size ", (Object)((byte[])object).length));
        }
        ByteBuffer byteBuffer = ByteBuffer.wrap((byte[])object).order(ByteOrder.LITTLE_ENDIAN);
        object = byteBuffer;
        int n2 = byteBuffer.getInt();
        double d2 = ((ByteBuffer)object).getDouble();
        Vector3d vector3d = Ir.b((ByteBuffer)object);
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"");
        Vector3d vector3d2 = vector3d;
        Object object2 = Ir.b((ByteBuffer)object);
        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"");
        vector3d = object2;
        object = Ir.b((ByteBuffer)object);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"");
        object2 = object;
        return new IL(n2, d2, vector3d2, vector3d, (Vector3dc)object2);
    }
}

