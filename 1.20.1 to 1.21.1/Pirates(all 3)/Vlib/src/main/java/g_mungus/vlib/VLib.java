/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1792
 *  net.minecraft.class_2248
 *  net.minecraft.server.MinecraftServer
 *  org.jetbrains.annotations.NotNull
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.valkyrienskies.core.api.attachment.AttachmentRegistration$Builder
 *  org.valkyrienskies.core.impl.hooks.VSEvents
 *  org.valkyrienskies.core.impl.hooks.VSEvents$ShipLoadEvent
 *  org.valkyrienskies.mod.common.VSGameUtilsKt
 *  org.valkyrienskies.mod.common.ValkyrienSkiesMod
 */
package g_mungus.vlib;

import g_mungus.vlib.dimension.GravityAttachment;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1792;
import net.minecraft.class_2248;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.valkyrienskies.core.api.attachment.AttachmentRegistration;
import org.valkyrienskies.core.impl.hooks.VSEvents;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0017\u0010\n\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\u00020\u001f8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\"\u0010\u0004\u001a\u0004\b \u0010!\u00a8\u0006$"}, d2={"Lg_mungus/vlib/VLib;", "", "", "init", "()V", "initClient", "", "MOD_ID", "Ljava/lang/String;", "Lorg/slf4j/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "getLOGGER", "()Lorg/slf4j/Logger;", "", "MAX_RECURSION", "I", "Lnet/minecraft/class_2248;", "GHOST_BLOCK", "Lnet/minecraft/class_2248;", "getGHOST_BLOCK", "()Lnet/minecraft/class_2248;", "setGHOST_BLOCK", "(Lnet/minecraft/class_2248;)V", "Lnet/minecraft/class_1792;", "ASSEMBLY_STICK", "Lnet/minecraft/class_1792;", "getASSEMBLY_STICK", "()Lnet/minecraft/class_1792;", "setASSEMBLY_STICK", "(Lnet/minecraft/class_1792;)V", "", "isDuringWorldGen", "()Z", "isDuringWorldGen$annotations", "<init>", "vlib"})
public final class VLib {
    @NotNull
    public static final VLib INSTANCE = new VLib();
    @NotNull
    public static final String MOD_ID = "vlib";
    @NotNull
    private static final Logger LOGGER;
    public static final int MAX_RECURSION = 131068;
    public static class_2248 GHOST_BLOCK;
    public static class_1792 ASSEMBLY_STICK;

    private VLib() {
    }

    @NotNull
    public final Logger getLOGGER() {
        return LOGGER;
    }

    @NotNull
    public final class_2248 getGHOST_BLOCK() {
        class_2248 class_22482 = GHOST_BLOCK;
        if (class_22482 != null) {
            return class_22482;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"GHOST_BLOCK");
        return null;
    }

    public final void setGHOST_BLOCK(@NotNull class_2248 class_22482) {
        Intrinsics.checkNotNullParameter((Object)class_22482, (String)"<set-?>");
        GHOST_BLOCK = class_22482;
    }

    @NotNull
    public final class_1792 getASSEMBLY_STICK() {
        class_1792 class_17922 = ASSEMBLY_STICK;
        if (class_17922 != null) {
            return class_17922;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"ASSEMBLY_STICK");
        return null;
    }

    public final void setASSEMBLY_STICK(@NotNull class_1792 class_17922) {
        Intrinsics.checkNotNullParameter((Object)class_17922, (String)"<set-?>");
        ASSEMBLY_STICK = class_17922;
    }

    @JvmStatic
    public static final void init() {
        LOGGER.info("VLib init");
        VSGameUtilsKt.getVsCore().registerAttachment(GravityAttachment.class, VLib::init$lambda$0);
        VSEvents.INSTANCE.getShipLoadEvent().on(arg_0 -> VLib.init$lambda$2(VLib::init$lambda$1, arg_0));
    }

    @JvmStatic
    public static final void initClient() {
    }

    public static final boolean isDuringWorldGen() {
        MinecraftServer minecraftServer = ValkyrienSkiesMod.getCurrentServer();
        return !Intrinsics.areEqual((Object)Thread.currentThread(), (Object)(minecraftServer != null ? minecraftServer.method_3777() : null));
    }

    @JvmStatic
    @Deprecated(message="Will be removed, do not use this")
    public static /* synthetic */ void isDuringWorldGen$annotations() {
    }

    private static final Unit init$lambda$0(AttachmentRegistration.Builder $this$registerAttachment) {
        Intrinsics.checkNotNullParameter((Object)$this$registerAttachment, (String)"$this$registerAttachment");
        $this$registerAttachment.useLegacySerializer();
        return Unit.INSTANCE;
    }

    private static final Unit init$lambda$1(VSEvents.ShipLoadEvent event) {
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        GravityAttachment.Companion.getOrCreate(event.getShip());
        return Unit.INSTANCE;
    }

    private static final void init$lambda$2(Function1 $tmp0, Object p0) {
        Intrinsics.checkNotNullParameter((Object)$tmp0, (String)"$tmp0");
        $tmp0.invoke(p0);
    }

    static {
        Logger logger = LoggerFactory.getLogger((String)"VLib");
        Intrinsics.checkNotNullExpressionValue((Object)logger, (String)"getLogger(...)");
        LOGGER = logger;
    }
}

