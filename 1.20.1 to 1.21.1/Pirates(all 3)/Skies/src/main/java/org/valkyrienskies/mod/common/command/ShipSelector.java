/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 */
package org.valkyrienskies.mod.common.command;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.api.ships.QueryableShipData;
import org.valkyrienskies.core.api.ships.Ship;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b#\u0010$J!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fH\u00c6\u0003\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fH\u00c6\u0003\u00a2\u0006\u0004\b\u0010\u0010\u0011J8\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\u0013\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f2\b\b\u0002\u0010\u0014\u001a\u00020\u000fH\u00c6\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u000fH\u00d6\u0001\u00a2\u0006\u0004\b\u001b\u0010\u0011J\u0010\u0010\u001c\u001a\u00020\bH\u00d6\u0001\u00a2\u0006\u0004\b\u001c\u0010\nR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b\u001e\u0010\nR\u001f\u0010\u0013\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b \u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010\u0011\u00a8\u0006%"}, d2={"Lorg/valkyrienskies/mod/common/command/ShipSelector;", "", "Lorg/valkyrienskies/core/api/ships/QueryableShipData;", "Lorg/valkyrienskies/core/api/ships/Ship;", "queryableShipData", "", "select", "(Lorg/valkyrienskies/core/api/ships/QueryableShipData;)Ljava/util/Set;", "", "component1", "()Ljava/lang/String;", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "component2", "()Ljava/lang/Long;", "", "component3", "()I", "slug", "id", "maxAmount", "copy", "(Ljava/lang/String;Ljava/lang/Long;I)Lorg/valkyrienskies/mod/common/command/ShipSelector;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/String;", "getSlug", "Ljava/lang/Long;", "getId", "I", "getMaxAmount", "<init>", "(Ljava/lang/String;Ljava/lang/Long;I)V", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nShipSelecter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShipSelecter.kt\norg/valkyrienskies/mod/common/command/ShipSelector\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,23:1\n1#2:24\n*E\n"})
public final class ShipSelector {
    @Nullable
    private final String slug;
    @Nullable
    private final Long id;
    private final int maxAmount;

    public ShipSelector(@Nullable String slug, @Nullable Long id, int maxAmount) {
        this.slug = slug;
        this.id = id;
        this.maxAmount = maxAmount;
    }

    public /* synthetic */ ShipSelector(String string, Long l2, int n2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 1) != 0) {
            string = null;
        }
        if ((n3 & 2) != 0) {
            l2 = null;
        }
        if ((n3 & 4) != 0) {
            n2 = Integer.MAX_VALUE;
        }
        this(string, l2, n2);
    }

    @Nullable
    public final String getSlug() {
        return this.slug;
    }

    @Nullable
    public final Long getId() {
        return this.id;
    }

    public final int getMaxAmount() {
        return this.maxAmount;
    }

    @NotNull
    public final Set<Ship> select(@NotNull QueryableShipData<? extends Ship> queryableShipData) {
        Sequence found;
        block1: {
            Intrinsics.checkNotNullParameter(queryableShipData, (String)"queryableShipData");
            found = null;
            found = CollectionsKt.asSequence((Iterable)queryableShipData);
            String string = this.slug;
            if (string != null) {
                String slug = string;
                boolean bl = false;
                found = SequencesKt.filter((Sequence)found, arg_0 -> ShipSelector.select$lambda$1$lambda$0(slug, arg_0));
            }
            Long l2 = this.id;
            if (l2 == null) break block1;
            long id = ((Number)l2).longValue();
            boolean bl = false;
            found = SequencesKt.filter((Sequence)found, arg_0 -> ShipSelector.select$lambda$3$lambda$2(id, arg_0));
        }
        return SequencesKt.toSet((Sequence)SequencesKt.take((Sequence)found, (int)this.maxAmount));
    }

    @Nullable
    public final String component1() {
        return this.slug;
    }

    @Nullable
    public final Long component2() {
        return this.id;
    }

    public final int component3() {
        return this.maxAmount;
    }

    @NotNull
    public final ShipSelector copy(@Nullable String slug, @Nullable Long id, int maxAmount) {
        return new ShipSelector(slug, id, maxAmount);
    }

    public static /* synthetic */ ShipSelector copy$default(ShipSelector shipSelector, String string, Long l2, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            string = shipSelector.slug;
        }
        if ((n3 & 2) != 0) {
            l2 = shipSelector.id;
        }
        if ((n3 & 4) != 0) {
            n2 = shipSelector.maxAmount;
        }
        return shipSelector.copy(string, l2, n2);
    }

    @NotNull
    public String toString() {
        return "ShipSelector(slug=" + this.slug + ", id=" + this.id + ", maxAmount=" + this.maxAmount + ")";
    }

    public int hashCode() {
        int result2 = this.slug == null ? 0 : this.slug.hashCode();
        result2 = result2 * 31 + (this.id == null ? 0 : ((Object)this.id).hashCode());
        result2 = result2 * 31 + Integer.hashCode(this.maxAmount);
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShipSelector)) {
            return false;
        }
        ShipSelector shipSelector = (ShipSelector)other;
        if (!Intrinsics.areEqual((Object)this.slug, (Object)shipSelector.slug)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.id, (Object)shipSelector.id)) {
            return false;
        }
        return this.maxAmount == shipSelector.maxAmount;
    }

    private static final boolean select$lambda$1$lambda$0(String $slug, Ship it) {
        Intrinsics.checkNotNullParameter((Object)$slug, (String)"$slug");
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return Intrinsics.areEqual((Object)it.getSlug(), (Object)$slug);
    }

    private static final boolean select$lambda$3$lambda$2(long $id, Ship it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return it.getId() == $id;
    }

    public ShipSelector() {
        this(null, null, 0, 7, null);
    }
}

