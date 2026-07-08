/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_3218
 *  org.jetbrains.annotations.NotNull
 */
package g_mungus.vlib.v2.api.extension;

import g_mungus.vlib.v2.internal.injected.HasCallbackQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_3218;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a'\u0010\u0006\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/minecraft/class_3218;", "", "ticks", "Lkotlin/Function0;", "", "callback", "scheduleCallback", "(Lnet/minecraft/class_3218;ILkotlin/jvm/functions/Function0;)V", "vlib"})
public final class ServerLevelExtKt {
    public static final void scheduleCallback(@NotNull class_3218 $this$scheduleCallback, int ticks, @NotNull Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter((Object)$this$scheduleCallback, (String)"<this>");
        Intrinsics.checkNotNullParameter(callback, (String)"callback");
        ((HasCallbackQueue)$this$scheduleCallback).vlib$enqueue(ticks, callback);
    }
}

