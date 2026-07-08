/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  net.minecraft.class_1297
 */
package org.valkyrienskies.mod.common.entity;

import kotlin.Metadata;
import net.minecraft.class_1297;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.mod.common.entity.ShipMountedToData;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a2\u0006\u0004\b\u0007\u0010\b\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\t\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/mod/common/entity/ShipMountedToDataProvider;", "", "Lnet/minecraft/class_1297;", "passenger", "", "partialTicks", "Lorg/valkyrienskies/mod/common/entity/ShipMountedToData;", "provideShipMountedToData", "(Lnet/minecraft/class_1297;Ljava/lang/Float;)Lorg/valkyrienskies/mod/common/entity/ShipMountedToData;", "valkyrienskies-120"})
public interface ShipMountedToDataProvider {
    @Nullable
    public ShipMountedToData provideShipMountedToData(@NotNull class_1297 var1, @Nullable Float var2);
}

