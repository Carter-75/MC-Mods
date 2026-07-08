/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  net.minecraft.class_2680
 */
package org.valkyrienskies.mod.common;

import kotlin.Metadata;
import net.minecraft.class_2680;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.internal.world.chunks.VsiBlockType;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u000e\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/mod/common/BlockStateInfoProvider;", "", "Lnet/minecraft/class_2680;", "blockState", "", "getBlockStateMass", "(Lnet/minecraft/class_2680;)Ljava/lang/Double;", "Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;", "getBlockStateType", "(Lnet/minecraft/class_2680;)Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;", "", "getPriority", "()I", "priority", "valkyrienskies-120"})
public interface BlockStateInfoProvider {
    public int getPriority();

    @Nullable
    public Double getBlockStateMass(@NotNull class_2680 var1);

    @Nullable
    public VsiBlockType getBlockStateType(@NotNull class_2680 var1);
}

