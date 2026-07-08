/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.api.ships;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4dc;
import org.valkyrienskies.core.api.ships.PositionedWing;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ.\u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014H\u00d6\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\bR\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005\u00a8\u0006\u001d"}, d2={"Lorg/valkyrienskies/core/api/ships/WingGroupChanges;", "", "", "Lorg/valkyrienskies/core/api/ships/PositionedWing;", "component1", "()Ljava/util/List;", "Lorg/joml/Matrix4dc;", "component2", "()Lorg/joml/Matrix4dc;", "changedWings", "changedTransform", "copy", "(Ljava/util/List;Lorg/joml/Matrix4dc;)Lorg/valkyrienskies/core/api/ships/WingGroupChanges;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/joml/Matrix4dc;", "getChangedTransform", "Ljava/util/List;", "getChangedWings", "<init>", "(Ljava/util/List;Lorg/joml/Matrix4dc;)V", "api"})
public final class WingGroupChanges {
    @Nullable
    private final List<PositionedWing> changedWings;
    @Nullable
    private final Matrix4dc changedTransform;

    public WingGroupChanges(@Nullable List<PositionedWing> changedWings, @Nullable Matrix4dc changedTransform) {
        this.changedWings = changedWings;
        this.changedTransform = changedTransform;
    }

    @Nullable
    public final List<PositionedWing> getChangedWings() {
        return this.changedWings;
    }

    @Nullable
    public final Matrix4dc getChangedTransform() {
        return this.changedTransform;
    }

    @Nullable
    public final List<PositionedWing> component1() {
        return this.changedWings;
    }

    @Nullable
    public final Matrix4dc component2() {
        return this.changedTransform;
    }

    @NotNull
    public final WingGroupChanges copy(@Nullable List<PositionedWing> changedWings, @Nullable Matrix4dc changedTransform) {
        return new WingGroupChanges(changedWings, changedTransform);
    }

    public static /* synthetic */ WingGroupChanges copy$default(WingGroupChanges wingGroupChanges, List list, Matrix4dc matrix4dc, int n2, Object object) {
        if ((n2 & 1) != 0) {
            list = wingGroupChanges.changedWings;
        }
        if ((n2 & 2) != 0) {
            matrix4dc = wingGroupChanges.changedTransform;
        }
        return wingGroupChanges.copy(list, matrix4dc);
    }

    @NotNull
    public String toString() {
        return "WingGroupChanges(changedWings=" + this.changedWings + ", changedTransform=" + this.changedTransform + ")";
    }

    public int hashCode() {
        int result2 = this.changedWings == null ? 0 : ((Object)this.changedWings).hashCode();
        result2 = result2 * 31 + (this.changedTransform == null ? 0 : this.changedTransform.hashCode());
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WingGroupChanges)) {
            return false;
        }
        WingGroupChanges wingGroupChanges = (WingGroupChanges)other;
        if (!Intrinsics.areEqual(this.changedWings, wingGroupChanges.changedWings)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.changedTransform, (Object)wingGroupChanges.changedTransform);
    }
}

