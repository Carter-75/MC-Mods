/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package org.valkyrienskies.core.util.events;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.api.event.EventConsumer;
import org.valkyrienskies.core.api.event.RegisteredListener;
import org.valkyrienskies.core.api.event.SingleEvent;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bRl\u0010\u0010\u001aZ\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \u000e*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r0\r\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u000f0\u000f \u000e*,\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \u000e*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r0\r\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010\f0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2={"Lorg/valkyrienskies/core/util/events/EventEmitterImpl;", "T", "Lorg/valkyrienskies/core/api/event/SingleEvent;", "value", "", "emit", "(Ljava/lang/Object;)V", "Lorg/valkyrienskies/core/api/event/EventConsumer;", "cb", "Lorg/valkyrienskies/core/api/event/RegisteredListener;", "on", "(Lorg/valkyrienskies/core/api/event/EventConsumer;)Lorg/valkyrienskies/core/api/event/RegisteredListener;", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "Lorg/valkyrienskies/core/util/events/EventEmitterImpl$EventListener;", "kotlin.jvm.PlatformType", "", "listeners", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "<init>", "()V", "EventListener", "util"})
@SourceDebugExtension(value={"SMAP\nEventEmitterImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventEmitterImpl.kt\norg/valkyrienskies/core/util/events/EventEmitterImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,31:1\n1863#2,2:32\n*S KotlinDebug\n*F\n+ 1 EventEmitterImpl.kt\norg/valkyrienskies/core/util/events/EventEmitterImpl\n*L\n13#1:32,2\n*E\n"})
public final class EventEmitterImpl<T>
implements SingleEvent<T> {
    private final ConcurrentHashMap.KeySetView<EventListener<T>, Boolean> listeners = ConcurrentHashMap.newKeySet();

    @Override
    public void emit(T value) {
        ConcurrentHashMap.KeySetView<EventListener<T>, Boolean> keySetView = this.listeners;
        Intrinsics.checkNotNullExpressionValue(keySetView, (String)"listeners");
        Iterable $this$forEach$iv = keySetView;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            EventListener it = (EventListener)element$iv;
            boolean bl = false;
            it.accept(value);
        }
    }

    @Override
    @NotNull
    public RegisteredListener on(@NotNull EventConsumer<? super T> cb) {
        Intrinsics.checkNotNullParameter(cb, (String)"cb");
        EventListener<T> listener = new EventListener<T>(cb);
        listener.setHandler(() -> EventEmitterImpl.on$lambda$1(this, listener));
        this.listeners.add(listener);
        return listener.getHandler();
    }

    private static final void on$lambda$1(EventEmitterImpl this$0, EventListener $listener) {
        this$0.listeners.remove($listener);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\u00a2\u0006\u0004\b \u0010!J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\tJ&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007H\u00c6\u0001\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014H\u00d6\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\tR\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006\""}, d2={"Lorg/valkyrienskies/core/util/events/EventEmitterImpl$EventListener;", "T", "", "event", "", "accept", "(Ljava/lang/Object;)V", "Lorg/valkyrienskies/core/api/event/EventConsumer;", "component1", "()Lorg/valkyrienskies/core/api/event/EventConsumer;", "cb", "copy", "(Lorg/valkyrienskies/core/api/event/EventConsumer;)Lorg/valkyrienskies/core/util/events/EventEmitterImpl$EventListener;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/valkyrienskies/core/api/event/EventConsumer;", "getCb", "Lorg/valkyrienskies/core/api/event/RegisteredListener;", "handler", "Lorg/valkyrienskies/core/api/event/RegisteredListener;", "getHandler", "()Lorg/valkyrienskies/core/api/event/RegisteredListener;", "setHandler", "(Lorg/valkyrienskies/core/api/event/RegisteredListener;)V", "<init>", "(Lorg/valkyrienskies/core/api/event/EventConsumer;)V", "util"})
    private static final class EventListener<T> {
        @NotNull
        private final EventConsumer<T> cb;
        public RegisteredListener handler;

        public EventListener(@NotNull EventConsumer<? super T> cb) {
            Intrinsics.checkNotNullParameter(cb, (String)"cb");
            this.cb = cb;
        }

        @NotNull
        public final EventConsumer<T> getCb() {
            return this.cb;
        }

        @NotNull
        public final RegisteredListener getHandler() {
            RegisteredListener registeredListener = this.handler;
            if (registeredListener != null) {
                return registeredListener;
            }
            Intrinsics.throwUninitializedPropertyAccessException((String)"handler");
            return null;
        }

        public final void setHandler(@NotNull RegisteredListener registeredListener) {
            Intrinsics.checkNotNullParameter((Object)registeredListener, (String)"<set-?>");
            this.handler = registeredListener;
        }

        public final void accept(T event) {
            this.cb.accept(event, this.getHandler());
        }

        @NotNull
        public final EventConsumer<T> component1() {
            return this.cb;
        }

        @NotNull
        public final EventListener<T> copy(@NotNull EventConsumer<? super T> cb) {
            Intrinsics.checkNotNullParameter(cb, (String)"cb");
            return new EventListener<T>(cb);
        }

        public static /* synthetic */ EventListener copy$default(EventListener eventListener, EventConsumer eventConsumer, int n2, Object object) {
            if ((n2 & 1) != 0) {
                eventConsumer = eventListener.cb;
            }
            return eventListener.copy(eventConsumer);
        }

        @NotNull
        public String toString() {
            return "EventListener(cb=" + this.cb + ")";
        }

        public int hashCode() {
            return this.cb.hashCode();
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EventListener)) {
                return false;
            }
            EventListener eventListener = (EventListener)other;
            return Intrinsics.areEqual(this.cb, eventListener.cb);
        }
    }
}

