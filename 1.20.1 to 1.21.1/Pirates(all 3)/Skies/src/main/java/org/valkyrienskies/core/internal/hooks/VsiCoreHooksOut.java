/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.internal.hooks;

import io.netty.buffer.ByteBuf;
import java.nio.file.Path;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.api.world.ShipWorld;
import org.valkyrienskies.core.internal.hooks.VsiPlayState;
import org.valkyrienskies.core.internal.world.VsiPlayer;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u000f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u001a\u001a\u00020\u00158&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001d\u001a\u00020\u00158&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001c\u0010#\u001a\u00020\u001e8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010&\u001a\u00020\u001e8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001c\u0010)\u001a\u00020\u001e8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001c\u0010,\u001a\u00020\u001e8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"R\u001c\u0010/\u001a\u00020\u001e8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"R\u001c\u00102\u001a\u00020\u001e8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b0\u0010 \"\u0004\b1\u0010\"R\u001c\u00105\u001a\u00020\u001e8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b3\u0010 \"\u0004\b4\u0010\"R\u0014\u00106\u001a\u00020\u001e8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b6\u0010 R\u001c\u00109\u001a\u00020\u00158&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b7\u0010\u0017\"\u0004\b8\u0010\u0019R\u0014\u0010=\u001a\u00020:8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b;\u0010<\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006>\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/internal/hooks/VsiCoreHooksOut;", "", "Lio/netty/buffer/ByteBuf;", "buf", "Lorg/valkyrienskies/core/internal/world/VsiPlayer;", "player", "", "sendToClient", "(Lio/netty/buffer/ByteBuf;Lorg/valkyrienskies/core/internal/world/VsiPlayer;)V", "sendToServer", "(Lio/netty/buffer/ByteBuf;)V", "Ljava/nio/file/Path;", "getConfigDir", "()Ljava/nio/file/Path;", "configDir", "Lorg/valkyrienskies/core/api/world/ShipWorld;", "getCurrentShipClientWorld", "()Lorg/valkyrienskies/core/api/world/ShipWorld;", "currentShipClientWorld", "getCurrentShipServerWorld", "currentShipServerWorld", "", "getDragCoefficient", "()D", "setDragCoefficient", "(D)V", "dragCoefficient", "getDragMultiplier", "setDragMultiplier", "dragMultiplier", "", "getEnableBlockCornerConnectivity", "()Z", "setEnableBlockCornerConnectivity", "(Z)V", "enableBlockCornerConnectivity", "getEnableBlockEdgeConnectivity", "setEnableBlockEdgeConnectivity", "enableBlockEdgeConnectivity", "getEnableConnectivity", "setEnableConnectivity", "enableConnectivity", "getEnableDrag", "setEnableDrag", "enableDrag", "getEnableLift", "setEnableLift", "enableLift", "getEnableSplitting", "setEnableSplitting", "enableSplitting", "getEnableWorldConnectivity", "setEnableWorldConnectivity", "enableWorldConnectivity", "isPhysicalClient", "getLiftMultiplier", "setLiftMultiplier", "liftMultiplier", "Lorg/valkyrienskies/core/internal/hooks/VsiPlayState;", "getPlayState", "()Lorg/valkyrienskies/core/internal/hooks/VsiPlayState;", "playState", "internal"})
public interface VsiCoreHooksOut {
    public boolean isPhysicalClient();

    @NotNull
    public Path getConfigDir();

    @NotNull
    public VsiPlayState getPlayState();

    @Nullable
    public ShipWorld getCurrentShipServerWorld();

    @NotNull
    public ShipWorld getCurrentShipClientWorld();

    public boolean getEnableConnectivity();

    public void setEnableConnectivity(boolean var1);

    public boolean getEnableWorldConnectivity();

    public void setEnableWorldConnectivity(boolean var1);

    public boolean getEnableBlockEdgeConnectivity();

    public void setEnableBlockEdgeConnectivity(boolean var1);

    public boolean getEnableBlockCornerConnectivity();

    public void setEnableBlockCornerConnectivity(boolean var1);

    public boolean getEnableSplitting();

    public void setEnableSplitting(boolean var1);

    public boolean getEnableDrag();

    public void setEnableDrag(boolean var1);

    public boolean getEnableLift();

    public void setEnableLift(boolean var1);

    public double getDragCoefficient();

    public void setDragCoefficient(double var1);

    public double getDragMultiplier();

    public void setDragMultiplier(double var1);

    public double getLiftMultiplier();

    public void setLiftMultiplier(double var1);

    public void sendToServer(@NotNull ByteBuf var1);

    public void sendToClient(@NotNull ByteBuf var1, @NotNull VsiPlayer var2);
}

