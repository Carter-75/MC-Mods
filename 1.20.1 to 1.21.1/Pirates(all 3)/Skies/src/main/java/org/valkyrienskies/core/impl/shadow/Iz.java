/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000b"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Iz;", "", "", "backendType", "I", "getBackendType", "()I", "p0", "<init>", "(Ljava/lang/String;II)V", "KRUNCH_CLASSIC", "KRUNCH_PHYSX"})
public final class Iz
extends Enum<Iz> {
    private final int backendType;
    public static final /* enum */ Iz KRUNCH_CLASSIC = new Iz(0);
    public static final /* enum */ Iz KRUNCH_PHYSX = new Iz(1);
    private static final /* synthetic */ Iz[] $VALUES;

    private Iz(int n3) {
        this.backendType = n3;
    }

    @JvmName(name="getBackendType")
    public final int getBackendType() {
        return this.backendType;
    }

    public static Iz[] values() {
        return (Iz[])$VALUES.clone();
    }

    public static Iz valueOf(String value) {
        String string;
        return Enum.valueOf(Iz.class, string);
    }

    private static final /* synthetic */ Iz[] a() {
        Iz[] izArray = new Iz[2];
        Iz[] izArray2 = izArray;
        izArray[0] = KRUNCH_CLASSIC;
        izArray2[1] = KRUNCH_PHYSX;
        return izArray2;
    }

    static {
        Iz[] izArray = new Iz[2];
        Iz[] izArray2 = izArray;
        izArray[0] = KRUNCH_CLASSIC;
        izArray2[1] = KRUNCH_PHYSX;
        $VALUES = izArray2;
    }
}

