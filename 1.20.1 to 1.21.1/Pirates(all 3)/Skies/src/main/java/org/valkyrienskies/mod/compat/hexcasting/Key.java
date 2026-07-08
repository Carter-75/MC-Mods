/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  at.petrak.hexcasting.api.casting.eval.CastingEnvironmentComponent$Key
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.mod.compat.hexcasting;

import at.petrak.hexcasting.api.casting.eval.CastingEnvironmentComponent;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.mod.compat.hexcasting.AmbitRemapping;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2={"Lorg/valkyrienskies/mod/compat/hexcasting/Key;", "Lat/petrak/hexcasting/api/casting/eval/CastingEnvironmentComponent$Key;", "Lorg/valkyrienskies/mod/compat/hexcasting/AmbitRemapping;", "Ljava/util/UUID;", "id", "Ljava/util/UUID;", "getId", "()Ljava/util/UUID;", "<init>", "(Ljava/util/UUID;)V", "valkyrienskies-120"})
public final class Key
implements CastingEnvironmentComponent.Key<AmbitRemapping> {
    @NotNull
    private final UUID id;

    public Key(@NotNull UUID id) {
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        this.id = id;
    }

    @NotNull
    public final UUID getId() {
        return this.id;
    }
}

