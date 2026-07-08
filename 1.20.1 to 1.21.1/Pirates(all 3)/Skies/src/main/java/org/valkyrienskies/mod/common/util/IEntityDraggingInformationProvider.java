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
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.util.EntityDraggingInformation;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u000e\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/mod/common/util/IEntityDraggingInformationProvider;", "", "", "vs$shouldDrag", "()Z", "Lorg/valkyrienskies/core/api/ships/Ship;", "ship", "", "vs$dragImmediately", "(Lorg/valkyrienskies/core/api/ships/Ship;)V", "Lorg/valkyrienskies/mod/common/util/EntityDraggingInformation;", "getDraggingInformation", "()Lorg/valkyrienskies/mod/common/util/EntityDraggingInformation;", "draggingInformation", "valkyrienskies-120"})
public interface IEntityDraggingInformationProvider {
    @NotNull
    public EntityDraggingInformation getDraggingInformation();

    public boolean vs$shouldDrag();

    public void vs$dragImmediately(@Nullable Ship var1);
}

