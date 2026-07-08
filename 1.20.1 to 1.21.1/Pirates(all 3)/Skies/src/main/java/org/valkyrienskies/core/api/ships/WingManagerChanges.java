/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.api.ships;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.api.ships.WingGroupChanges;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u001e\u0010\n\u001a\u001a\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u00060\u0003\u0018\u00010\u0002\u0012\u0012\u0010\u000b\u001a\u000e\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ(\u0010\u0007\u001a\u001a\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u00060\u0003\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\t\u001a\u000e\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\bJH\u0010\f\u001a\u00020\u00002 \b\u0002\u0010\n\u001a\u001a\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u00060\u0003\u0018\u00010\u00022\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0018\u00010\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0004H\u00d6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014H\u00d6\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016R#\u0010\u000b\u001a\u000e\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\bR/\u0010\n\u001a\u001a\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u00060\u0003\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0019\u0010\b\u00a8\u0006\u001c"}, d2={"Lorg/valkyrienskies/core/api/ships/WingManagerChanges;", "", "", "Lkotlin/Pair;", "", "Lorg/valkyrienskies/core/api/ships/WingGroupId;", "Lorg/valkyrienskies/core/api/ships/WingGroupChanges;", "component1", "()Ljava/util/List;", "component2", "wingGroupChanges", "deletedWingGroups", "copy", "(Ljava/util/List;Ljava/util/List;)Lorg/valkyrienskies/core/api/ships/WingManagerChanges;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getDeletedWingGroups", "getWingGroupChanges", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "api"})
public final class WingManagerChanges {
    @Nullable
    private final List<Pair<Integer, WingGroupChanges>> wingGroupChanges;
    @Nullable
    private final List<Integer> deletedWingGroups;

    public WingManagerChanges(@Nullable List<Pair<Integer, WingGroupChanges>> wingGroupChanges, @Nullable List<Integer> deletedWingGroups) {
        this.wingGroupChanges = wingGroupChanges;
        this.deletedWingGroups = deletedWingGroups;
    }

    @Nullable
    public final List<Pair<Integer, WingGroupChanges>> getWingGroupChanges() {
        return this.wingGroupChanges;
    }

    @Nullable
    public final List<Integer> getDeletedWingGroups() {
        return this.deletedWingGroups;
    }

    @Nullable
    public final List<Pair<Integer, WingGroupChanges>> component1() {
        return this.wingGroupChanges;
    }

    @Nullable
    public final List<Integer> component2() {
        return this.deletedWingGroups;
    }

    @NotNull
    public final WingManagerChanges copy(@Nullable List<Pair<Integer, WingGroupChanges>> wingGroupChanges, @Nullable List<Integer> deletedWingGroups) {
        return new WingManagerChanges(wingGroupChanges, deletedWingGroups);
    }

    public static /* synthetic */ WingManagerChanges copy$default(WingManagerChanges wingManagerChanges, List list, List list2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            list = wingManagerChanges.wingGroupChanges;
        }
        if ((n2 & 2) != 0) {
            list2 = wingManagerChanges.deletedWingGroups;
        }
        return wingManagerChanges.copy(list, list2);
    }

    @NotNull
    public String toString() {
        return "WingManagerChanges(wingGroupChanges=" + this.wingGroupChanges + ", deletedWingGroups=" + this.deletedWingGroups + ")";
    }

    public int hashCode() {
        int result2 = this.wingGroupChanges == null ? 0 : ((Object)this.wingGroupChanges).hashCode();
        result2 = result2 * 31 + (this.deletedWingGroups == null ? 0 : ((Object)this.deletedWingGroups).hashCode());
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WingManagerChanges)) {
            return false;
        }
        WingManagerChanges wingManagerChanges = (WingManagerChanges)other;
        if (!Intrinsics.areEqual(this.wingGroupChanges, wingManagerChanges.wingGroupChanges)) {
            return false;
        }
        return Intrinsics.areEqual(this.deletedWingGroups, wingManagerChanges.deletedWingGroups);
    }
}

