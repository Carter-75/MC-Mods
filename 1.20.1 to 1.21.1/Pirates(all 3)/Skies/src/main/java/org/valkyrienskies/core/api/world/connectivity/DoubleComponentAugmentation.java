/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.api.world.connectivity;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.api.util.DoublePair;
import org.valkyrienskies.core.api.world.connectivity.Component;
import org.valkyrienskies.core.api.world.connectivity.DoubleAugmentation;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\b\u0010\t\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\n\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/world/connectivity/DoubleComponentAugmentation;", "Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;", "", "value", "Lorg/valkyrienskies/core/api/world/connectivity/Component;", "component1", "component2", "Lorg/valkyrienskies/core/api/util/DoublePair;", "splitDouble", "(DLorg/valkyrienskies/core/api/world/connectivity/Component;Lorg/valkyrienskies/core/api/world/connectivity/Component;)Lorg/valkyrienskies/core/api/util/DoublePair;", "api"})
public interface DoubleComponentAugmentation
extends DoubleAugmentation {
    @NotNull
    public DoublePair splitDouble(double var1, @NotNull Component var3, @NotNull Component var4);
}

