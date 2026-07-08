/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Metadata;
import org.valkyrienskies.core.impl.shadow.hi_0;
import org.valkyrienskies.core.impl.shadow.hj_0;
import org.valkyrienskies.physics_api_krunch.KrunchByteBuffer;

@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2={"Lorg/valkyrienskies/core/impl/shadow/IF;", "Lorg/valkyrienskies/core/impl/shadow/Hj;", "Lorg/valkyrienskies/physics_api_krunch/KrunchByteBuffer;", "", "p0", "b", "(I)Lorg/valkyrienskies/physics_api_krunch/KrunchByteBuffer;", "<init>", "()V"})
public final class IF
implements hj_0<KrunchByteBuffer> {
    public static final IF INSTANCE = new IF();

    private IF() {
    }

    private static KrunchByteBuffer b(int n2) {
        return new KrunchByteBuffer(n2);
    }

    @Override
    public final /* synthetic */ hi_0 a(int n2) {
        n2 = 1000000;
        return new KrunchByteBuffer(n2);
    }
}

