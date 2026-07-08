/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.api.event;

import java.util.function.Consumer;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.api.event.EventConsumer;
import org.valkyrienskies.core.api.event.ListenableEvent;
import org.valkyrienskies.core.api.event.RegisteredListener;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0003H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\bH&\u00a2\u0006\u0004\b\u0006\u0010\tJ\u001f\u0010\n\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0003H\u0016\u00a2\u0006\u0004\b\n\u0010\u0007J/\u0010\n\u001a\u00020\u00052\u000e\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u000b2\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0003H\u0016\u00a2\u0006\u0004\b\n\u0010\r\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u000e\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/event/ListenableEvent;", "T", "", "Ljava/util/function/Consumer;", "cb", "Lorg/valkyrienskies/core/api/event/RegisteredListener;", "on", "(Ljava/util/function/Consumer;)Lorg/valkyrienskies/core/api/event/RegisteredListener;", "Lorg/valkyrienskies/core/api/event/EventConsumer;", "(Lorg/valkyrienskies/core/api/event/EventConsumer;)Lorg/valkyrienskies/core/api/event/RegisteredListener;", "once", "Ljava/util/function/Predicate;", "predicate", "(Ljava/util/function/Predicate;Ljava/util/function/Consumer;)Lorg/valkyrienskies/core/api/event/RegisteredListener;", "api"})
public interface ListenableEvent<T> {
    @NotNull
    public RegisteredListener on(@NotNull EventConsumer<? super T> var1);

    @NotNull
    default public RegisteredListener on(@NotNull Consumer<? super T> cb) {
        Intrinsics.checkNotNullParameter(cb, (String)"cb");
        return this.on((arg_0, arg_1) -> ListenableEvent.on$lambda$0(cb, arg_0, arg_1));
    }

    @NotNull
    default public RegisteredListener once(@NotNull Consumer<? super T> cb) {
        Intrinsics.checkNotNullParameter(cb, (String)"cb");
        return this.once(arg_0 -> ListenableEvent.once$lambda$1(once.1.INSTANCE, arg_0), cb);
    }

    @NotNull
    default public RegisteredListener once(@NotNull Predicate<? super T> predicate, @NotNull Consumer<? super T> cb) {
        Intrinsics.checkNotNullParameter(predicate, (String)"predicate");
        Intrinsics.checkNotNullParameter(cb, (String)"cb");
        return this.on((arg_0, arg_1) -> ListenableEvent.once$lambda$2(predicate, cb, arg_0, arg_1));
    }

    private static void on$lambda$0(Consumer $cb, Object value, RegisteredListener registeredListener) {
        Intrinsics.checkNotNullParameter((Object)registeredListener, (String)"<anonymous parameter 1>");
        $cb.accept(value);
    }

    private static boolean once$lambda$1(Function1 $tmp0, Object p0) {
        return (Boolean)$tmp0.invoke(p0);
    }

    private static void once$lambda$2(Predicate $predicate, Consumer $cb, Object value, RegisteredListener handler) {
        Intrinsics.checkNotNullParameter((Object)handler, (String)"handler");
        if ($predicate.test(value)) {
            $cb.accept(value);
            handler.unregister();
        }
    }
}

