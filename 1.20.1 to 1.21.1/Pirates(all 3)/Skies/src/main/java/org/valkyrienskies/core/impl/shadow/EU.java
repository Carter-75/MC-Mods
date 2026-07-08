/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import io.netty.buffer.ByteBuf;
import java.nio.file.Path;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.api.world.ShipWorld;
import org.valkyrienskies.core.impl.config.VSCoreConfig;
import org.valkyrienskies.core.impl.shadow.EY;
import org.valkyrienskies.core.internal.hooks.VsiCoreHooks;
import org.valkyrienskies.core.internal.hooks.VsiCoreHooksOut;
import org.valkyrienskies.core.internal.hooks.VsiPlayState;
import org.valkyrienskies.core.internal.world.VsiPlayer;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\r\u001a\u00020D\u00a2\u0006\u0004\bL\u0010MJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0003H\u0096\u0001\u00a2\u0006\u0004\b\u0010\u0010\u000fJ\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\nH\u0096\u0001\u00a2\u0006\u0004\b\u0011\u0010\fR\u0014\u0010\u0015\u001a\u00020\u00128\u0017X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0017X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0017X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\"\u0010#\u001a\u00020\u001c8\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010'\u001a\u00020\u001c8\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\"\u0010)\u001a\u00020(8\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00101\u001a\u00020(8\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010*\u001a\u0004\b/\u0010,\"\u0004\b0\u0010.R\"\u00104\u001a\u00020(8\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010*\u001a\u0004\b2\u0010,\"\u0004\b3\u0010.R\"\u00107\u001a\u00020(8\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010*\u001a\u0004\b5\u0010,\"\u0004\b6\u0010.R\"\u0010\u001d\u001a\u00020(8\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010*\u001a\u0004\b8\u0010,\"\u0004\b9\u0010.R\"\u0010$\u001a\u00020(8\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010*\u001a\u0004\b:\u0010,\"\u0004\b;\u0010.R\"\u0010>\u001a\u00020(8\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010*\u001a\u0004\b<\u0010,\"\u0004\b=\u0010.R\u0014\u0010@\u001a\u00020(8\u0017X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b?\u0010,R\"\u0010C\u001a\u00020\u001c8\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010\u001e\u001a\u0004\bA\u0010 \"\u0004\bB\u0010\"R\u0017\u0010G\u001a\u00020D8\u0007\u00a2\u0006\f\n\u0004\b\u0015\u0010E\u001a\u0004\b\u0015\u0010FR\u0014\u0010K\u001a\u00020H8\u0017X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bI\u0010J"}, d2={"Lorg/valkyrienskies/core/impl/shadow/EU;", "Lorg/valkyrienskies/core/internal/hooks/VsiCoreHooksOut;", "Lorg/valkyrienskies/core/internal/hooks/VsiCoreHooks;", "Lorg/valkyrienskies/core/internal/world/VsiPlayer;", "p0", "", "afterClientJoinServer", "(Lorg/valkyrienskies/core/internal/world/VsiPlayer;)V", "afterDisconnect", "()V", "Lio/netty/buffer/ByteBuf;", "onReceiveClient", "(Lio/netty/buffer/ByteBuf;)V", "p1", "onReceiveServer", "(Lio/netty/buffer/ByteBuf;Lorg/valkyrienskies/core/internal/world/VsiPlayer;)V", "sendToClient", "sendToServer", "Ljava/nio/file/Path;", "getConfigDir", "()Ljava/nio/file/Path;", "a", "Lorg/valkyrienskies/core/api/world/ShipWorld;", "getCurrentShipClientWorld", "()Lorg/valkyrienskies/core/api/world/ShipWorld;", "b", "getCurrentShipServerWorld", "c", "", "j", "D", "getDragCoefficient", "()D", "setDragCoefficient", "(D)V", "d", "k", "getDragMultiplier", "setDragMultiplier", "e", "", "f", "Z", "getEnableBlockCornerConnectivity", "()Z", "setEnableBlockCornerConnectivity", "(Z)V", "getEnableBlockEdgeConnectivity", "setEnableBlockEdgeConnectivity", "g", "getEnableConnectivity", "setEnableConnectivity", "h", "getEnableDrag", "setEnableDrag", "i", "getEnableLift", "setEnableLift", "getEnableSplitting", "setEnableSplitting", "getEnableWorldConnectivity", "setEnableWorldConnectivity", "l", "isPhysicalClient", "m", "getLiftMultiplier", "setLiftMultiplier", "n", "Lorg/valkyrienskies/core/impl/shadow/EY;", "Lorg/valkyrienskies/core/impl/shadow/EY;", "()Lorg/valkyrienskies/core/impl/shadow/EY;", "o", "Lorg/valkyrienskies/core/internal/hooks/VsiPlayState;", "getPlayState", "()Lorg/valkyrienskies/core/internal/hooks/VsiPlayState;", "p", "<init>", "(Lorg/valkyrienskies/core/internal/hooks/VsiCoreHooksOut;Lorg/valkyrienskies/core/impl/shadow/EY;)V"})
public final class EU
implements VsiCoreHooks,
VsiCoreHooksOut {
    private final EY a;
    private final /* synthetic */ VsiCoreHooksOut b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private double j;
    private double k;
    private double l;

    @Inject
    public EU(VsiCoreHooksOut vsiCoreHooksOut, EY eY) {
        Intrinsics.checkNotNullParameter((Object)vsiCoreHooksOut, (String)"");
        Intrinsics.checkNotNullParameter((Object)eY, (String)"");
        this.a = eY;
        this.b = vsiCoreHooksOut;
        this.c = VSCoreConfig.SERVER.getSp().getEnableConnectivity();
        this.d = VSCoreConfig.SERVER.getSp().getEnableWorldConnectivity();
        this.e = VSCoreConfig.SERVER.getSp().getEnableBlockEdgeConnectivity();
        this.f = VSCoreConfig.SERVER.getSp().getEnableBlockCornerConnectivity();
        this.g = VSCoreConfig.SERVER.getSp().getEnableSplitting();
        this.h = VSCoreConfig.SERVER.getDs().getEnableDrag();
        this.i = VSCoreConfig.SERVER.getDs().getEnableLift();
        this.j = VSCoreConfig.SERVER.getDs().getDragCoefficient();
        this.k = VSCoreConfig.SERVER.getDs().getDragMultiplier();
        this.l = VSCoreConfig.SERVER.getDs().getLiftMultiplier();
    }

    @JvmName(name="a")
    private EY a() {
        return this.a;
    }

    @Override
    @JvmName(name="getConfigDir")
    public final Path getConfigDir() {
        return this.b.getConfigDir();
    }

    @Override
    @JvmName(name="getCurrentShipClientWorld")
    public final ShipWorld getCurrentShipClientWorld() {
        return this.b.getCurrentShipClientWorld();
    }

    @Override
    @JvmName(name="getCurrentShipServerWorld")
    public final ShipWorld getCurrentShipServerWorld() {
        return this.b.getCurrentShipServerWorld();
    }

    @Override
    @JvmName(name="isPhysicalClient")
    public final boolean isPhysicalClient() {
        return this.b.isPhysicalClient();
    }

    @Override
    @JvmName(name="getPlayState")
    public final VsiPlayState getPlayState() {
        return this.b.getPlayState();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void sendToClient(ByteBuf buf, VsiPlayer player) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)buf, (String)"");
        Intrinsics.checkNotNullParameter((Object)player, (String)"");
        this.b.sendToClient((ByteBuf)var1_1, (VsiPlayer)var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void sendToServer(ByteBuf buf) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)buf, (String)"");
        this.b.sendToServer((ByteBuf)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void onReceiveServer(ByteBuf buf, VsiPlayer sender) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)buf, (String)"");
        Intrinsics.checkNotNullParameter((Object)sender, (String)"");
        this.a.a((ByteBuf)var1_1, (VsiPlayer)var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void onReceiveClient(ByteBuf buf) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)buf, (String)"");
        this.a.a((ByteBuf)var1_1);
    }

    @Override
    public final void afterDisconnect() {
    }

    @Override
    public final void afterClientJoinServer(VsiPlayer player) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"");
    }

    @Override
    @JvmName(name="getEnableConnectivity")
    public final boolean getEnableConnectivity() {
        return this.c;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setEnableConnectivity")
    public final void setEnableConnectivity(boolean bl) {
        void var1_1;
        this.c = var1_1;
    }

    @Override
    @JvmName(name="getEnableWorldConnectivity")
    public final boolean getEnableWorldConnectivity() {
        return this.d;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setEnableWorldConnectivity")
    public final void setEnableWorldConnectivity(boolean bl) {
        void var1_1;
        this.d = var1_1;
    }

    @Override
    @JvmName(name="getEnableBlockEdgeConnectivity")
    public final boolean getEnableBlockEdgeConnectivity() {
        return this.e;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setEnableBlockEdgeConnectivity")
    public final void setEnableBlockEdgeConnectivity(boolean bl) {
        void var1_1;
        this.e = var1_1;
    }

    @Override
    @JvmName(name="getEnableBlockCornerConnectivity")
    public final boolean getEnableBlockCornerConnectivity() {
        return this.f;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setEnableBlockCornerConnectivity")
    public final void setEnableBlockCornerConnectivity(boolean bl) {
        void var1_1;
        this.f = var1_1;
    }

    @Override
    @JvmName(name="getEnableSplitting")
    public final boolean getEnableSplitting() {
        return this.g;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setEnableSplitting")
    public final void setEnableSplitting(boolean bl) {
        void var1_1;
        this.g = var1_1;
    }

    @Override
    @JvmName(name="getEnableDrag")
    public final boolean getEnableDrag() {
        return this.h;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setEnableDrag")
    public final void setEnableDrag(boolean bl) {
        void var1_1;
        this.h = var1_1;
    }

    @Override
    @JvmName(name="getEnableLift")
    public final boolean getEnableLift() {
        return this.i;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setEnableLift")
    public final void setEnableLift(boolean bl) {
        void var1_1;
        this.i = var1_1;
    }

    @Override
    @JvmName(name="getDragCoefficient")
    public final double getDragCoefficient() {
        return this.j;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setDragCoefficient")
    public final void setDragCoefficient(double d2) {
        void var1_1;
        this.j = var1_1;
    }

    @Override
    @JvmName(name="getDragMultiplier")
    public final double getDragMultiplier() {
        return this.k;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setDragMultiplier")
    public final void setDragMultiplier(double d2) {
        void var1_1;
        this.k = var1_1;
    }

    @Override
    @JvmName(name="getLiftMultiplier")
    public final double getLiftMultiplier() {
        return this.l;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setLiftMultiplier")
    public final void setLiftMultiplier(double d2) {
        void var1_1;
        this.l = var1_1;
    }
}

