/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  net.minecraft.class_2680
 */
package org.valkyrienskies.mod.api.events;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import net.minecraft.class_2680;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.api.physics.blockstates.LiquidState;
import org.valkyrienskies.core.api.physics.blockstates.SolidState;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0003\u0010\u0004J(\u0010\n\u001a\u00020\t2\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\b\u0007H&\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&\u00a2\u0006\u0004\b\r\u0010\u000eJ(\u0010\u0010\u001a\u00020\u000f2\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\b\u0007H&\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000fH&\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\tH&\u00a2\u0006\u0004\b\u0015\u0010\u0018J'\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000fH&\u00a2\u0006\u0004\b\u0015\u0010\u0019\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u001a\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/mod/api/events/RegisterBlockStateEvent;", "", "Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState$Builder;", "newLiquidStateBuilder", "()Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState$Builder;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState;", "buildLiquidState", "(Lkotlin/jvm/functions/Function1;)Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState;", "Lorg/valkyrienskies/core/api/physics/blockstates/SolidState$Builder;", "newSolidStateBuilder", "()Lorg/valkyrienskies/core/api/physics/blockstates/SolidState$Builder;", "Lorg/valkyrienskies/core/api/physics/blockstates/SolidState;", "buildSolidState", "(Lkotlin/jvm/functions/Function1;)Lorg/valkyrienskies/core/api/physics/blockstates/SolidState;", "Lnet/minecraft/class_2680;", "state", "solidState", "register", "(Lnet/minecraft/class_2680;Lorg/valkyrienskies/core/api/physics/blockstates/SolidState;)V", "liquidState", "(Lnet/minecraft/class_2680;Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState;)V", "(Lnet/minecraft/class_2680;Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState;Lorg/valkyrienskies/core/api/physics/blockstates/SolidState;)V", "valkyrienskies-120"})
@ApiStatus.Experimental
public interface RegisterBlockStateEvent {
    @NotNull
    public LiquidState.Builder newLiquidStateBuilder();

    @NotNull
    public LiquidState buildLiquidState(@NotNull Function1<? super LiquidState.Builder, Unit> var1);

    @NotNull
    public SolidState.Builder newSolidStateBuilder();

    @NotNull
    public SolidState buildSolidState(@NotNull Function1<? super SolidState.Builder, Unit> var1);

    public void register(@NotNull class_2680 var1, @NotNull SolidState var2);

    public void register(@NotNull class_2680 var1, @NotNull LiquidState var2);

    public void register(@NotNull class_2680 var1, @NotNull LiquidState var2, @NotNull SolidState var3);
}

