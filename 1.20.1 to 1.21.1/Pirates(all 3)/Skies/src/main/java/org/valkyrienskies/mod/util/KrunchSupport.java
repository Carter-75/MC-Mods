/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.mod.util;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2={"Lorg/valkyrienskies/mod/util/KrunchSupport;", "", "", "isKrunchSupported", "Z", "()Z", "setKrunchSupported", "(Z)V", "<init>", "()V", "valkyrienskies-120"})
public final class KrunchSupport {
    @NotNull
    public static final KrunchSupport INSTANCE = new KrunchSupport();
    private static boolean isKrunchSupported;

    private KrunchSupport() {
    }

    public final boolean isKrunchSupported() {
        return isKrunchSupported;
    }

    public final void setKrunchSupported(boolean bl) {
        isKrunchSupported = bl;
    }
}

