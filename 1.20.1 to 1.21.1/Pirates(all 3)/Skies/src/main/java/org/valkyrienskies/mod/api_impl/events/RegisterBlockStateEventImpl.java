/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2680
 */
package org.valkyrienskies.mod.api_impl.events;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2680;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.api.physics.blockstates.LiquidState;
import org.valkyrienskies.core.api.physics.blockstates.SolidState;
import org.valkyrienskies.core.internal.physics.blockstates.VsiBlockState;
import org.valkyrienskies.mod.api.events.RegisterBlockStateEvent;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004J(\u0010\n\u001a\u00020\t2\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\b\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ(\u0010\u0010\u001a\u00020\u000f2\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\b\u0007H\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0018J'\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0019R)\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001c0\u001b0\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \u00a8\u0006#"}, d2={"Lorg/valkyrienskies/mod/api_impl/events/RegisterBlockStateEventImpl;", "Lorg/valkyrienskies/mod/api/events/RegisterBlockStateEvent;", "Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState$Builder;", "newLiquidStateBuilder", "()Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState$Builder;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState;", "buildLiquidState", "(Lkotlin/jvm/functions/Function1;)Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState;", "Lorg/valkyrienskies/core/api/physics/blockstates/SolidState$Builder;", "newSolidStateBuilder", "()Lorg/valkyrienskies/core/api/physics/blockstates/SolidState$Builder;", "Lorg/valkyrienskies/core/api/physics/blockstates/SolidState;", "buildSolidState", "(Lkotlin/jvm/functions/Function1;)Lorg/valkyrienskies/core/api/physics/blockstates/SolidState;", "Lnet/minecraft/class_2680;", "state", "solidState", "register", "(Lnet/minecraft/class_2680;Lorg/valkyrienskies/core/api/physics/blockstates/SolidState;)V", "liquidState", "(Lnet/minecraft/class_2680;Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState;)V", "(Lnet/minecraft/class_2680;Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState;Lorg/valkyrienskies/core/api/physics/blockstates/SolidState;)V", "", "Lkotlin/Pair;", "Lorg/valkyrienskies/core/internal/physics/blockstates/VsiBlockState;", "toRegister", "Ljava/util/List;", "getToRegister", "()Ljava/util/List;", "<init>", "()V", "valkyrienskies-120"})
public final class RegisterBlockStateEventImpl
implements RegisterBlockStateEvent {
    @NotNull
    private final List<Pair<class_2680, VsiBlockState>> toRegister = new ArrayList();

    @NotNull
    public final List<Pair<class_2680, VsiBlockState>> getToRegister() {
        return this.toRegister;
    }

    @Override
    @NotNull
    public LiquidState.Builder newLiquidStateBuilder() {
        return ValkyrienSkiesMod.getVsCore().newLiquidStateBuilder();
    }

    @Override
    @NotNull
    public LiquidState buildLiquidState(@NotNull Function1<? super LiquidState.Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, (String)"block");
        LiquidState.Builder builder = ValkyrienSkiesMod.getVsCore().newLiquidStateBuilder();
        block.invoke((Object)builder);
        return builder.build();
    }

    @Override
    @NotNull
    public SolidState.Builder newSolidStateBuilder() {
        return ValkyrienSkiesMod.getVsCore().newSolidStateBuilder();
    }

    @Override
    @NotNull
    public SolidState buildSolidState(@NotNull Function1<? super SolidState.Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, (String)"block");
        SolidState.Builder builder = ValkyrienSkiesMod.getVsCore().newSolidStateBuilder();
        block.invoke((Object)builder);
        return builder.build();
    }

    @Override
    public void register(@NotNull class_2680 state, @NotNull SolidState solidState) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)solidState, (String)"solidState");
        this.toRegister.add((Pair<class_2680, VsiBlockState>)new Pair((Object)state, (Object)new VsiBlockState(solidState, null)));
    }

    @Override
    public void register(@NotNull class_2680 state, @NotNull LiquidState liquidState) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)liquidState, (String)"liquidState");
        this.toRegister.add((Pair<class_2680, VsiBlockState>)new Pair((Object)state, (Object)new VsiBlockState(null, liquidState)));
    }

    @Override
    public void register(@NotNull class_2680 state, @NotNull LiquidState liquidState, @NotNull SolidState solidState) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)liquidState, (String)"liquidState");
        Intrinsics.checkNotNullParameter((Object)solidState, (String)"solidState");
        this.toRegister.add((Pair<class_2680, VsiBlockState>)new Pair((Object)state, (Object)new VsiBlockState(solidState, liquidState)));
    }
}

