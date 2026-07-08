/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package com.fasterxml.jackson.module.kotlin;

import kotlin.Metadata;

@Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Lcom/fasterxml/jackson/module/kotlin/SingletonSupport;", "", "<init>", "(Ljava/lang/String;I)V", "DISABLED", "CANONICALIZE", "jackson-module-kotlin"})
public final class SingletonSupport
extends Enum<SingletonSupport> {
    public static final /* enum */ SingletonSupport DISABLED = new SingletonSupport();
    public static final /* enum */ SingletonSupport CANONICALIZE = new SingletonSupport();
    private static final /* synthetic */ SingletonSupport[] $VALUES;

    public static SingletonSupport[] values() {
        return (SingletonSupport[])$VALUES.clone();
    }

    public static SingletonSupport valueOf(String value) {
        return Enum.valueOf(SingletonSupport.class, value);
    }

    static {
        $VALUES = singletonSupportArray = new SingletonSupport[]{SingletonSupport.DISABLED, SingletonSupport.CANONICALIZE};
    }
}

