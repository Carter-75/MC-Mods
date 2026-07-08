/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_310
 *  net.minecraft.class_634
 *  net.minecraft.server.MinecraftServer
 */
package org.valkyrienskies.mod.common.hooks;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.api.world.ShipWorld;
import org.valkyrienskies.core.internal.hooks.VsiCoreHooksOut;
import org.valkyrienskies.core.internal.hooks.VsiPlayState;
import org.valkyrienskies.core.internal.world.VsiClientShipWorld;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b1\u00102R$\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R$\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R$\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007R$\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0007R$\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u0005\"\u0004\b\u0016\u0010\u0007R$\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0018\u0010\u0005\"\u0004\b\u0019\u0010\u0007R$\u0010 \u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u001b8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010#\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u001b8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR$\u0010&\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u001b8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\u0014\u0010*\u001a\u00020'8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R\u0016\u0010.\u001a\u0004\u0018\u00010+8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u00100\u001a\u00020+8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b/\u0010-\u00a8\u00063"}, d2={"Lorg/valkyrienskies/mod/common/hooks/CommonHooksImpl;", "Lorg/valkyrienskies/core/internal/hooks/VsiCoreHooksOut;", "", "value", "getEnableBlockEdgeConnectivity", "()Z", "setEnableBlockEdgeConnectivity", "(Z)V", "enableBlockEdgeConnectivity", "getEnableBlockCornerConnectivity", "setEnableBlockCornerConnectivity", "enableBlockCornerConnectivity", "getEnableConnectivity", "setEnableConnectivity", "enableConnectivity", "getEnableWorldConnectivity", "setEnableWorldConnectivity", "enableWorldConnectivity", "getEnableSplitting", "setEnableSplitting", "enableSplitting", "getEnableDrag", "setEnableDrag", "enableDrag", "getEnableLift", "setEnableLift", "enableLift", "", "getDragCoefficient", "()D", "setDragCoefficient", "(D)V", "dragCoefficient", "getDragMultiplier", "setDragMultiplier", "dragMultiplier", "getLiftMultiplier", "setLiftMultiplier", "liftMultiplier", "Lorg/valkyrienskies/core/internal/hooks/VsiPlayState;", "getPlayState", "()Lorg/valkyrienskies/core/internal/hooks/VsiPlayState;", "playState", "Lorg/valkyrienskies/core/api/world/ShipWorld;", "getCurrentShipServerWorld", "()Lorg/valkyrienskies/core/api/world/ShipWorld;", "currentShipServerWorld", "getCurrentShipClientWorld", "currentShipClientWorld", "<init>", "()V", "valkyrienskies-120"})
public abstract class CommonHooksImpl
implements VsiCoreHooksOut {
    @Override
    public boolean getEnableBlockEdgeConnectivity() {
        return VSGameUtilsKt.getVsCore().getHooks().getEnableBlockEdgeConnectivity();
    }

    @Override
    public void setEnableBlockEdgeConnectivity(boolean value) {
    }

    @Override
    public boolean getEnableBlockCornerConnectivity() {
        return VSGameUtilsKt.getVsCore().getHooks().getEnableBlockCornerConnectivity();
    }

    @Override
    public void setEnableBlockCornerConnectivity(boolean value) {
    }

    @Override
    public boolean getEnableConnectivity() {
        return VSGameUtilsKt.getVsCore().getHooks().getEnableConnectivity();
    }

    @Override
    public void setEnableConnectivity(boolean value) {
    }

    @Override
    public boolean getEnableWorldConnectivity() {
        return VSGameUtilsKt.getVsCore().getHooks().getEnableWorldConnectivity();
    }

    @Override
    public void setEnableWorldConnectivity(boolean value) {
    }

    @Override
    public boolean getEnableSplitting() {
        return VSGameUtilsKt.getVsCore().getHooks().getEnableSplitting();
    }

    @Override
    public void setEnableSplitting(boolean value) {
    }

    @Override
    public boolean getEnableDrag() {
        return VSGameUtilsKt.getVsCore().getHooks().getEnableDrag();
    }

    @Override
    public void setEnableDrag(boolean value) {
    }

    @Override
    public boolean getEnableLift() {
        return VSGameUtilsKt.getVsCore().getHooks().getEnableLift();
    }

    @Override
    public void setEnableLift(boolean value) {
    }

    @Override
    public double getDragCoefficient() {
        return VSGameUtilsKt.getVsCore().getHooks().getDragCoefficient();
    }

    @Override
    public void setDragCoefficient(double value) {
    }

    @Override
    public double getDragMultiplier() {
        return VSGameUtilsKt.getVsCore().getHooks().getDragMultiplier();
    }

    @Override
    public void setDragMultiplier(double value) {
    }

    @Override
    public double getLiftMultiplier() {
        return VSGameUtilsKt.getVsCore().getHooks().getLiftMultiplier();
    }

    @Override
    public void setLiftMultiplier(double value) {
    }

    @Override
    @NotNull
    public VsiPlayState getPlayState() {
        if (!this.isPhysicalClient()) {
            return VsiPlayState.SERVERSIDE;
        }
        class_634 class_6342 = class_310.method_1551().method_1562();
        if (!(class_6342 != null && (class_6342 = class_6342.method_48296()) != null ? class_6342.method_10758() : false)) {
            return VsiPlayState.CLIENT_TITLESCREEN;
        }
        if (class_310.method_1551().method_1576() != null) {
            return VsiPlayState.CLIENT_SINGLEPLAYER;
        }
        return VsiPlayState.CLIENT_MULTIPLAYER;
    }

    @Override
    @Nullable
    public ShipWorld getCurrentShipServerWorld() {
        MinecraftServer minecraftServer = ValkyrienSkiesMod.getCurrentServer();
        return minecraftServer != null ? VSGameUtilsKt.getShipObjectWorld(minecraftServer) : null;
    }

    @Override
    @NotNull
    public ShipWorld getCurrentShipClientWorld() {
        class_310 class_3102 = class_310.method_1551();
        Intrinsics.checkNotNullExpressionValue((Object)class_3102, (String)"getInstance(...)");
        VsiClientShipWorld vsiClientShipWorld = VSGameUtilsKt.getShipObjectWorld(class_3102);
        Intrinsics.checkNotNull((Object)vsiClientShipWorld);
        return vsiClientShipWorld;
    }
}

