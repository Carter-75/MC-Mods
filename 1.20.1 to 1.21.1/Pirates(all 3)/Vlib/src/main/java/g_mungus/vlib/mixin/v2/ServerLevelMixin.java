/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Pair
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  net.minecraft.class_3218
 *  org.jetbrains.annotations.NotNull
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package g_mungus.vlib.mixin.v2;

import g_mungus.vlib.v2.internal.injected.HasCallbackQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.function.BooleanSupplier;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import net.minecraft.class_3218;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_3218.class})
public class ServerLevelMixin
implements HasCallbackQueue {
    @Unique
    private ConcurrentLinkedDeque<Pair<Long, Function0<Unit>>> vlib$callbacks = null;
    @Unique
    private long vlib$elapsedTicks;

    @Inject(method={"tick"}, at={@At(value="HEAD")})
    private void vlib$tick(BooleanSupplier hasTimeLeft, CallbackInfo ci) {
        if (this.vlib$callbacks == null) {
            this.vlib$callbacks = new ConcurrentLinkedDeque();
            this.vlib$elapsedTicks = 0L;
        }
        this.vlib$callbacks.removeIf(it -> {
            boolean shouldRemove;
            boolean bl = shouldRemove = (Long)it.getFirst() <= this.vlib$elapsedTicks;
            if (shouldRemove) {
                ((Function0)it.getSecond()).invoke();
            }
            return shouldRemove;
        });
        ++this.vlib$elapsedTicks;
    }

    @Override
    public void vlib$enqueue(int ticks, @NotNull Function0<Unit> callback) {
        if (this.vlib$callbacks == null) {
            this.vlib$callbacks = new ConcurrentLinkedDeque();
            this.vlib$elapsedTicks = 0L;
        }
        this.vlib$callbacks.add((Pair<Long, Function0<Unit>>)new Pair((Object)(this.vlib$elapsedTicks + (long)ticks), callback));
    }
}

