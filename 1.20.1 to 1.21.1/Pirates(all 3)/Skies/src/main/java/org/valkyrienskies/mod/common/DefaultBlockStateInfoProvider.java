/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2404
 *  net.minecraft.class_2680
 */
package org.valkyrienskies.mod.common;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2404;
import net.minecraft.class_2680;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.internal.world.chunks.VsiBlockType;
import org.valkyrienskies.mod.common.BlockStateInfoProvider;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.config.VSGameConfig;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2={"Lorg/valkyrienskies/mod/common/DefaultBlockStateInfoProvider;", "Lorg/valkyrienskies/mod/common/BlockStateInfoProvider;", "Lnet/minecraft/class_2680;", "blockState", "", "getBlockStateMass", "(Lnet/minecraft/class_2680;)Ljava/lang/Double;", "Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;", "getBlockStateType", "(Lnet/minecraft/class_2680;)Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;", "", "getPriority", "()I", "priority", "<init>", "()V", "valkyrienskies-120"})
public final class DefaultBlockStateInfoProvider
implements BlockStateInfoProvider {
    @NotNull
    public static final DefaultBlockStateInfoProvider INSTANCE = new DefaultBlockStateInfoProvider();

    private DefaultBlockStateInfoProvider() {
    }

    @Override
    public int getPriority() {
        return Integer.MIN_VALUE;
    }

    @Override
    @NotNull
    public Double getBlockStateMass(@NotNull class_2680 blockState) {
        Intrinsics.checkNotNullParameter((Object)blockState, (String)"blockState");
        if (blockState.method_26215()) {
            return 0.0;
        }
        return VSGameConfig.SERVER.getDefaultBlockMass();
    }

    @Override
    @NotNull
    public VsiBlockType getBlockStateType(@NotNull class_2680 blockState) {
        Intrinsics.checkNotNullParameter((Object)blockState, (String)"blockState");
        if (blockState.method_26215()) {
            return VSGameUtilsKt.getVsCore().getBlockTypes().getAir();
        }
        class_2248 block = blockState.method_26204();
        if (block instanceof class_2404) {
            return Intrinsics.areEqual((Object)block, (Object)class_2246.field_10164) ? VSGameUtilsKt.getVsCore().getBlockTypes().getLava() : VSGameUtilsKt.getVsCore().getBlockTypes().getWater();
        }
        return blockState.method_51367() ? VSGameUtilsKt.getVsCore().getBlockTypes().getSolid() : VSGameUtilsKt.getVsCore().getBlockTypes().getAir();
    }
}

