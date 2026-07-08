/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.mod.common.util;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006H\u00c2\u0003\u00a2\u0006\u0004\b\t\u0010\bJ\u001a\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u0006H\u00c6\u0001\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013H\u00d6\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\n\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0016\u00a8\u0006\u0019"}, d2={"Lorg/valkyrienskies/mod/common/util/SplittingDisablerAttachment;", "", "", "enableSplitting", "()V", "disableSplitting", "", "canSplit", "()Z", "component1", "splitt", "copy", "(Z)Lorg/valkyrienskies/mod/common/util/SplittingDisablerAttachment;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "<init>", "(Z)V", "valkyrienskies-120"})
public final class SplittingDisablerAttachment {
    private boolean splitt;

    public SplittingDisablerAttachment(boolean splitt) {
        this.splitt = splitt;
    }

    public final void enableSplitting() {
        this.splitt = true;
    }

    public final void disableSplitting() {
        this.splitt = false;
    }

    public final boolean canSplit() {
        return this.splitt;
    }

    private final boolean component1() {
        return this.splitt;
    }

    @NotNull
    public final SplittingDisablerAttachment copy(boolean splitt) {
        return new SplittingDisablerAttachment(splitt);
    }

    public static /* synthetic */ SplittingDisablerAttachment copy$default(SplittingDisablerAttachment splittingDisablerAttachment, boolean bl, int n2, Object object) {
        if ((n2 & 1) != 0) {
            bl = splittingDisablerAttachment.splitt;
        }
        return splittingDisablerAttachment.copy(bl);
    }

    @NotNull
    public String toString() {
        return "SplittingDisablerAttachment(splitt=" + this.splitt + ")";
    }

    public int hashCode() {
        return Boolean.hashCode(this.splitt);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SplittingDisablerAttachment)) {
            return false;
        }
        SplittingDisablerAttachment splittingDisablerAttachment = (SplittingDisablerAttachment)other;
        return this.splitt == splittingDisablerAttachment.splitt;
    }
}

