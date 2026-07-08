/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.hooks;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.function.Consumer;
import java.util.function.Predicate;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.api.event.EventConsumer;
import org.valkyrienskies.core.api.event.ListenableEvent;
import org.valkyrienskies.core.api.event.RegisteredListener;
import org.valkyrienskies.core.api.event.SingleEvent;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.LoadedServerShip;
import org.valkyrienskies.core.api.world.ClientShipWorld;
import org.valkyrienskies.core.api.world.ServerShipWorld;

@Deprecated(message="Use VsCoreApi (generally accessed via org.valkyrienskies.mod.api.vsApi)")
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0005!\"#$%B\t\b\u0002\u00a2\u0006\u0004\b \u0010\u000bJ\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0002H\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005R&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00038\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\t\u0010\u0005R&\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00038\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\r\u0010\b\u0012\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u000e\u0010\u0005R&\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00038\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\b\u0012\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0012\u0010\u0005R\u001c\u0010\u0016\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R&\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00038\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\b\u0012\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001a\u0010\u0005R&\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00038\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\b\u0012\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001e\u0010\u0005\u00a8\u0006&"}, d2={"Lorg/valkyrienskies/core/impl/hooks/VSEvents;", "", "T", "Lorg/valkyrienskies/core/api/event/SingleEvent;", "newSingleEvent", "()Lorg/valkyrienskies/core/api/event/SingleEvent;", "Lorg/valkyrienskies/core/impl/hooks/VSEvents$ShipLoadEvent;", "shipLoadEvent", "Lorg/valkyrienskies/core/api/event/SingleEvent;", "getShipLoadEvent", "getShipLoadEvent$annotations", "()V", "Lorg/valkyrienskies/core/impl/hooks/VSEvents$ShipLoadEventClient;", "shipLoadEventClient", "getShipLoadEventClient", "getShipLoadEventClient$annotations", "Lorg/valkyrienskies/core/impl/hooks/VSEvents$ShipUnloadEventClient;", "shipUnloadEventClient", "getShipUnloadEventClient", "getShipUnloadEventClient$annotations", "Ljava/lang/invoke/MethodHandle;", "kotlin.jvm.PlatformType", "singleEventConstructor", "Ljava/lang/invoke/MethodHandle;", "Lorg/valkyrienskies/core/impl/hooks/VSEvents$StartUpdateRenderTransformsEvent;", "startUpdateRenderTransformsEvent", "getStartUpdateRenderTransformsEvent", "getStartUpdateRenderTransformsEvent$annotations", "Lorg/valkyrienskies/core/impl/hooks/VSEvents$TickEndEvent;", "tickEndEvent", "getTickEndEvent", "getTickEndEvent$annotations", "<init>", "ShipLoadEvent", "ShipLoadEventClient", "ShipUnloadEventClient", "StartUpdateRenderTransformsEvent", "TickEndEvent", "api"})
public final class VSEvents {
    @NotNull
    public static final VSEvents INSTANCE = new VSEvents();
    private static final MethodHandle singleEventConstructor = MethodHandles.lookup().findConstructor(Class.forName("org.valkyrienskies.core.util.events.EventEmitterImpl"), MethodType.methodType(Void.TYPE));
    @NotNull
    private static final SingleEvent<ShipLoadEvent> shipLoadEvent = INSTANCE.newSingleEvent();
    @NotNull
    private static final SingleEvent<ShipLoadEventClient> shipLoadEventClient = INSTANCE.newSingleEvent();
    @NotNull
    private static final SingleEvent<ShipUnloadEventClient> shipUnloadEventClient = INSTANCE.newSingleEvent();
    @NotNull
    private static final SingleEvent<StartUpdateRenderTransformsEvent> startUpdateRenderTransformsEvent = INSTANCE.newSingleEvent();
    @NotNull
    private static final SingleEvent<TickEndEvent> tickEndEvent = INSTANCE.newSingleEvent();

    private VSEvents() {
    }

    private final <T> SingleEvent<T> newSingleEvent() {
        return singleEventConstructor.invoke();
    }

    @NotNull
    public final SingleEvent<ShipLoadEvent> getShipLoadEvent() {
        return shipLoadEvent;
    }

    @Deprecated(message="Use vsApi.shipLoadEvent", replaceWith=@ReplaceWith(expression="vsApi.shipLoadEvent", imports={"org.valkyrienskies.mod.api.vsApi"}))
    public static /* synthetic */ void getShipLoadEvent$annotations() {
    }

    @NotNull
    public final SingleEvent<ShipLoadEventClient> getShipLoadEventClient() {
        return shipLoadEventClient;
    }

    @Deprecated(message="Use vsApi.shipLoadEventClient", replaceWith=@ReplaceWith(expression="vsApi.shipLoadEventClient", imports={"org.valkyrienskies.mod.api.vsApi"}))
    public static /* synthetic */ void getShipLoadEventClient$annotations() {
    }

    @NotNull
    public final SingleEvent<ShipUnloadEventClient> getShipUnloadEventClient() {
        return shipUnloadEventClient;
    }

    @Deprecated(message="Use vsApi.shipUnloadEvent", replaceWith=@ReplaceWith(expression="vsApi.shipUnloadEvent", imports={"org.valkyrienskies.mod.api.vsApi"}))
    public static /* synthetic */ void getShipUnloadEventClient$annotations() {
    }

    @NotNull
    public final SingleEvent<StartUpdateRenderTransformsEvent> getStartUpdateRenderTransformsEvent() {
        return startUpdateRenderTransformsEvent;
    }

    @Deprecated(message="Use vsApi.startUpdateRenderTransformsEvent", replaceWith=@ReplaceWith(expression="vsApi.startUpdateRenderTransformsEvent", imports={"org.valkyrienskies.mod.api.vsApi"}))
    public static /* synthetic */ void getStartUpdateRenderTransformsEvent$annotations() {
    }

    @NotNull
    public final SingleEvent<TickEndEvent> getTickEndEvent() {
        return tickEndEvent;
    }

    @Deprecated(message="Use vsApi.tickEndEvent", replaceWith=@ReplaceWith(expression="vsApi.tickEndEvent", imports={"org.valkyrienskies.mod.api.vsApi"}))
    public static /* synthetic */ void getTickEndEvent$annotations() {
    }

    @Deprecated(message="Use the interface variant", replaceWith=@ReplaceWith(expression="ShipLoadEvent", imports={"org.valkyrienskies.mod.api.events.ShipLoadEvent"}))
    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00d6\u0003\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH\u00d6\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004\u00a8\u0006\u0018"}, d2={"Lorg/valkyrienskies/core/impl/hooks/VSEvents$ShipLoadEvent;", "Lorg/valkyrienskies/core/api/events/ShipLoadEvent;", "Lorg/valkyrienskies/core/api/ships/LoadedServerShip;", "component1", "()Lorg/valkyrienskies/core/api/ships/LoadedServerShip;", "ship", "copy", "(Lorg/valkyrienskies/core/api/ships/LoadedServerShip;)Lorg/valkyrienskies/core/impl/hooks/VSEvents$ShipLoadEvent;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/valkyrienskies/core/api/ships/LoadedServerShip;", "getShip", "<init>", "(Lorg/valkyrienskies/core/api/ships/LoadedServerShip;)V", "Companion", "api"})
    public static final class ShipLoadEvent
    implements org.valkyrienskies.core.api.events.ShipLoadEvent {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final LoadedServerShip ship;

        public ShipLoadEvent(@NotNull LoadedServerShip ship) {
            Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
            this.ship = ship;
        }

        @Override
        @NotNull
        public LoadedServerShip getShip() {
            return this.ship;
        }

        @NotNull
        public final LoadedServerShip component1() {
            return this.ship;
        }

        @NotNull
        public final ShipLoadEvent copy(@NotNull LoadedServerShip ship) {
            Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
            return new ShipLoadEvent(ship);
        }

        public static /* synthetic */ ShipLoadEvent copy$default(ShipLoadEvent shipLoadEvent, LoadedServerShip loadedServerShip, int n2, Object object) {
            if ((n2 & 1) != 0) {
                loadedServerShip = shipLoadEvent.ship;
            }
            return shipLoadEvent.copy(loadedServerShip);
        }

        @NotNull
        public String toString() {
            return "ShipLoadEvent(ship=" + this.ship + ")";
        }

        public int hashCode() {
            return this.ship.hashCode();
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShipLoadEvent)) {
                return false;
            }
            ShipLoadEvent shipLoadEvent = (ShipLoadEvent)other;
            return Intrinsics.areEqual((Object)this.ship, (Object)shipLoadEvent.ship);
        }

        @Deprecated(message="Use vsApi.shipLoadEvent", replaceWith=@ReplaceWith(expression="vsApi.shipLoadEvent", imports={"org.valkyrienskies.mod.api.vsApi"}))
        @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0096\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0096\u0001\u00a2\u0006\u0004\b\u0006\u0010\tJ \u0010\n\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0096\u0001\u00a2\u0006\u0004\b\n\u0010\u0007J0\u0010\n\u001a\u00020\u00052\u000e\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u000b2\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0096\u0001\u00a2\u0006\u0004\b\n\u0010\r\u00a8\u0006\u0010"}, d2={"Lorg/valkyrienskies/core/impl/hooks/VSEvents$ShipLoadEvent$Companion;", "Lorg/valkyrienskies/core/api/event/ListenableEvent;", "Lorg/valkyrienskies/core/impl/hooks/VSEvents$ShipLoadEvent;", "Ljava/util/function/Consumer;", "cb", "Lorg/valkyrienskies/core/api/event/RegisteredListener;", "on", "(Ljava/util/function/Consumer;)Lorg/valkyrienskies/core/api/event/RegisteredListener;", "Lorg/valkyrienskies/core/api/event/EventConsumer;", "(Lorg/valkyrienskies/core/api/event/EventConsumer;)Lorg/valkyrienskies/core/api/event/RegisteredListener;", "once", "Ljava/util/function/Predicate;", "predicate", "(Ljava/util/function/Predicate;Ljava/util/function/Consumer;)Lorg/valkyrienskies/core/api/event/RegisteredListener;", "<init>", "()V", "api"})
        public static final class Companion
        implements ListenableEvent<ShipLoadEvent> {
            private final /* synthetic */ SingleEvent<ShipLoadEvent> $$delegate_0;

            private Companion() {
                this.$$delegate_0 = INSTANCE.getShipLoadEvent();
            }

            @Override
            @NotNull
            public RegisteredListener on(@NotNull Consumer<? super ShipLoadEvent> cb) {
                Intrinsics.checkNotNullParameter(cb, (String)"cb");
                return this.$$delegate_0.on(cb);
            }

            @Override
            @NotNull
            public RegisteredListener on(@NotNull EventConsumer<? super ShipLoadEvent> cb) {
                Intrinsics.checkNotNullParameter(cb, (String)"cb");
                return this.$$delegate_0.on(cb);
            }

            @Override
            @NotNull
            public RegisteredListener once(@NotNull Consumer<? super ShipLoadEvent> cb) {
                Intrinsics.checkNotNullParameter(cb, (String)"cb");
                return this.$$delegate_0.once(cb);
            }

            @Override
            @NotNull
            public RegisteredListener once(@NotNull Predicate<? super ShipLoadEvent> predicate, @NotNull Consumer<? super ShipLoadEvent> cb) {
                Intrinsics.checkNotNullParameter(predicate, (String)"predicate");
                Intrinsics.checkNotNullParameter(cb, (String)"cb");
                return this.$$delegate_0.once(predicate, cb);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    @Deprecated(message="Use the interface variant", replaceWith=@ReplaceWith(expression="ShipLoadEventClient", imports={"org.valkyrienskies.mod.api.events.ShipLoadEventClient"}))
    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00d6\u0003\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH\u00d6\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004\u00a8\u0006\u0018"}, d2={"Lorg/valkyrienskies/core/impl/hooks/VSEvents$ShipLoadEventClient;", "Lorg/valkyrienskies/core/api/events/ShipLoadEventClient;", "Lorg/valkyrienskies/core/api/ships/ClientShip;", "component1", "()Lorg/valkyrienskies/core/api/ships/ClientShip;", "ship", "copy", "(Lorg/valkyrienskies/core/api/ships/ClientShip;)Lorg/valkyrienskies/core/impl/hooks/VSEvents$ShipLoadEventClient;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/valkyrienskies/core/api/ships/ClientShip;", "getShip", "<init>", "(Lorg/valkyrienskies/core/api/ships/ClientShip;)V", "Companion", "api"})
    public static final class ShipLoadEventClient
    implements org.valkyrienskies.core.api.events.ShipLoadEventClient {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final ClientShip ship;

        public ShipLoadEventClient(@NotNull ClientShip ship) {
            Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
            this.ship = ship;
        }

        @Override
        @NotNull
        public ClientShip getShip() {
            return this.ship;
        }

        @NotNull
        public final ClientShip component1() {
            return this.ship;
        }

        @NotNull
        public final ShipLoadEventClient copy(@NotNull ClientShip ship) {
            Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
            return new ShipLoadEventClient(ship);
        }

        public static /* synthetic */ ShipLoadEventClient copy$default(ShipLoadEventClient shipLoadEventClient, ClientShip clientShip, int n2, Object object) {
            if ((n2 & 1) != 0) {
                clientShip = shipLoadEventClient.ship;
            }
            return shipLoadEventClient.copy(clientShip);
        }

        @NotNull
        public String toString() {
            return "ShipLoadEventClient(ship=" + this.ship + ")";
        }

        public int hashCode() {
            return this.ship.hashCode();
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShipLoadEventClient)) {
                return false;
            }
            ShipLoadEventClient shipLoadEventClient = (ShipLoadEventClient)other;
            return Intrinsics.areEqual((Object)this.ship, (Object)shipLoadEventClient.ship);
        }

        @Deprecated(message="Use vsApi.shipLoadEventClient", replaceWith=@ReplaceWith(expression="vsApi.shipLoadEventClient", imports={"org.valkyrienskies.mod.api.vsApi"}))
        @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0096\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0096\u0001\u00a2\u0006\u0004\b\u0006\u0010\tJ \u0010\n\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0096\u0001\u00a2\u0006\u0004\b\n\u0010\u0007J0\u0010\n\u001a\u00020\u00052\u000e\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u000b2\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0096\u0001\u00a2\u0006\u0004\b\n\u0010\r\u00a8\u0006\u0010"}, d2={"Lorg/valkyrienskies/core/impl/hooks/VSEvents$ShipLoadEventClient$Companion;", "Lorg/valkyrienskies/core/api/event/ListenableEvent;", "Lorg/valkyrienskies/core/impl/hooks/VSEvents$ShipLoadEventClient;", "Ljava/util/function/Consumer;", "cb", "Lorg/valkyrienskies/core/api/event/RegisteredListener;", "on", "(Ljava/util/function/Consumer;)Lorg/valkyrienskies/core/api/event/RegisteredListener;", "Lorg/valkyrienskies/core/api/event/EventConsumer;", "(Lorg/valkyrienskies/core/api/event/EventConsumer;)Lorg/valkyrienskies/core/api/event/RegisteredListener;", "once", "Ljava/util/function/Predicate;", "predicate", "(Ljava/util/function/Predicate;Ljava/util/function/Consumer;)Lorg/valkyrienskies/core/api/event/RegisteredListener;", "<init>", "()V", "api"})
        public static final class Companion
        implements ListenableEvent<ShipLoadEventClient> {
            private final /* synthetic */ SingleEvent<ShipLoadEventClient> $$delegate_0;

            private Companion() {
                this.$$delegate_0 = INSTANCE.getShipLoadEventClient();
            }

            @Override
            @NotNull
            public RegisteredListener on(@NotNull Consumer<? super ShipLoadEventClient> cb) {
                Intrinsics.checkNotNullParameter(cb, (String)"cb");
                return this.$$delegate_0.on(cb);
            }

            @Override
            @NotNull
            public RegisteredListener on(@NotNull EventConsumer<? super ShipLoadEventClient> cb) {
                Intrinsics.checkNotNullParameter(cb, (String)"cb");
                return this.$$delegate_0.on(cb);
            }

            @Override
            @NotNull
            public RegisteredListener once(@NotNull Consumer<? super ShipLoadEventClient> cb) {
                Intrinsics.checkNotNullParameter(cb, (String)"cb");
                return this.$$delegate_0.once(cb);
            }

            @Override
            @NotNull
            public RegisteredListener once(@NotNull Predicate<? super ShipLoadEventClient> predicate, @NotNull Consumer<? super ShipLoadEventClient> cb) {
                Intrinsics.checkNotNullParameter(predicate, (String)"predicate");
                Intrinsics.checkNotNullParameter(cb, (String)"cb");
                return this.$$delegate_0.once(predicate, cb);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    @Deprecated(message="Use the interface variant", replaceWith=@ReplaceWith(expression="ShipUnloadEventClient", imports={"org.valkyrienskies.mod.api.events.ShipUnloadEventClient"}))
    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00d6\u0003\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH\u00d6\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004\u00a8\u0006\u0018"}, d2={"Lorg/valkyrienskies/core/impl/hooks/VSEvents$ShipUnloadEventClient;", "Lorg/valkyrienskies/core/api/events/ShipUnloadEventClient;", "Lorg/valkyrienskies/core/api/ships/ClientShip;", "component1", "()Lorg/valkyrienskies/core/api/ships/ClientShip;", "ship", "copy", "(Lorg/valkyrienskies/core/api/ships/ClientShip;)Lorg/valkyrienskies/core/impl/hooks/VSEvents$ShipUnloadEventClient;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/valkyrienskies/core/api/ships/ClientShip;", "getShip", "<init>", "(Lorg/valkyrienskies/core/api/ships/ClientShip;)V", "Companion", "api"})
    public static final class ShipUnloadEventClient
    implements org.valkyrienskies.core.api.events.ShipUnloadEventClient {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final ClientShip ship;

        public ShipUnloadEventClient(@NotNull ClientShip ship) {
            Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
            this.ship = ship;
        }

        @Override
        @NotNull
        public ClientShip getShip() {
            return this.ship;
        }

        @NotNull
        public final ClientShip component1() {
            return this.ship;
        }

        @NotNull
        public final ShipUnloadEventClient copy(@NotNull ClientShip ship) {
            Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
            return new ShipUnloadEventClient(ship);
        }

        public static /* synthetic */ ShipUnloadEventClient copy$default(ShipUnloadEventClient shipUnloadEventClient, ClientShip clientShip, int n2, Object object) {
            if ((n2 & 1) != 0) {
                clientShip = shipUnloadEventClient.ship;
            }
            return shipUnloadEventClient.copy(clientShip);
        }

        @NotNull
        public String toString() {
            return "ShipUnloadEventClient(ship=" + this.ship + ")";
        }

        public int hashCode() {
            return this.ship.hashCode();
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShipUnloadEventClient)) {
                return false;
            }
            ShipUnloadEventClient shipUnloadEventClient = (ShipUnloadEventClient)other;
            return Intrinsics.areEqual((Object)this.ship, (Object)shipUnloadEventClient.ship);
        }

        @Deprecated(message="Use vsApi.shipUnloadEvent", replaceWith=@ReplaceWith(expression="vsApi.shipUnloadEvent", imports={"org.valkyrienskies.mod.api.vsApi"}))
        @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0096\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0096\u0001\u00a2\u0006\u0004\b\u0006\u0010\tJ \u0010\n\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0096\u0001\u00a2\u0006\u0004\b\n\u0010\u0007J0\u0010\n\u001a\u00020\u00052\u000e\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u000b2\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0096\u0001\u00a2\u0006\u0004\b\n\u0010\r\u00a8\u0006\u0010"}, d2={"Lorg/valkyrienskies/core/impl/hooks/VSEvents$ShipUnloadEventClient$Companion;", "Lorg/valkyrienskies/core/api/event/ListenableEvent;", "Lorg/valkyrienskies/core/impl/hooks/VSEvents$ShipUnloadEventClient;", "Ljava/util/function/Consumer;", "cb", "Lorg/valkyrienskies/core/api/event/RegisteredListener;", "on", "(Ljava/util/function/Consumer;)Lorg/valkyrienskies/core/api/event/RegisteredListener;", "Lorg/valkyrienskies/core/api/event/EventConsumer;", "(Lorg/valkyrienskies/core/api/event/EventConsumer;)Lorg/valkyrienskies/core/api/event/RegisteredListener;", "once", "Ljava/util/function/Predicate;", "predicate", "(Ljava/util/function/Predicate;Ljava/util/function/Consumer;)Lorg/valkyrienskies/core/api/event/RegisteredListener;", "<init>", "()V", "api"})
        public static final class Companion
        implements ListenableEvent<ShipUnloadEventClient> {
            private final /* synthetic */ SingleEvent<ShipUnloadEventClient> $$delegate_0;

            private Companion() {
                this.$$delegate_0 = INSTANCE.getShipUnloadEventClient();
            }

            @Override
            @NotNull
            public RegisteredListener on(@NotNull Consumer<? super ShipUnloadEventClient> cb) {
                Intrinsics.checkNotNullParameter(cb, (String)"cb");
                return this.$$delegate_0.on(cb);
            }

            @Override
            @NotNull
            public RegisteredListener on(@NotNull EventConsumer<? super ShipUnloadEventClient> cb) {
                Intrinsics.checkNotNullParameter(cb, (String)"cb");
                return this.$$delegate_0.on(cb);
            }

            @Override
            @NotNull
            public RegisteredListener once(@NotNull Consumer<? super ShipUnloadEventClient> cb) {
                Intrinsics.checkNotNullParameter(cb, (String)"cb");
                return this.$$delegate_0.once(cb);
            }

            @Override
            @NotNull
            public RegisteredListener once(@NotNull Predicate<? super ShipUnloadEventClient> predicate, @NotNull Consumer<? super ShipUnloadEventClient> cb) {
                Intrinsics.checkNotNullParameter(predicate, (String)"predicate");
                Intrinsics.checkNotNullParameter(cb, (String)"cb");
                return this.$$delegate_0.once(predicate, cb);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    @Deprecated(message="Use the interface variant", replaceWith=@ReplaceWith(expression="StartUpdateRenderTransformsEvent", imports={"org.valkyrienskies.mod.api.events.StartUpdateRenderTransformsEvent"}))
    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00d6\u0003\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH\u00d6\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004\u00a8\u0006\u0018"}, d2={"Lorg/valkyrienskies/core/impl/hooks/VSEvents$StartUpdateRenderTransformsEvent;", "Lorg/valkyrienskies/core/api/events/StartUpdateRenderTransformsEvent;", "Lorg/valkyrienskies/core/api/world/ClientShipWorld;", "component1", "()Lorg/valkyrienskies/core/api/world/ClientShipWorld;", "shipWorld", "copy", "(Lorg/valkyrienskies/core/api/world/ClientShipWorld;)Lorg/valkyrienskies/core/impl/hooks/VSEvents$StartUpdateRenderTransformsEvent;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/valkyrienskies/core/api/world/ClientShipWorld;", "getShipWorld", "<init>", "(Lorg/valkyrienskies/core/api/world/ClientShipWorld;)V", "Companion", "api"})
    public static final class StartUpdateRenderTransformsEvent
    implements org.valkyrienskies.core.api.events.StartUpdateRenderTransformsEvent {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final ClientShipWorld shipWorld;

        public StartUpdateRenderTransformsEvent(@NotNull ClientShipWorld shipWorld) {
            Intrinsics.checkNotNullParameter((Object)shipWorld, (String)"shipWorld");
            this.shipWorld = shipWorld;
        }

        @Override
        @NotNull
        public ClientShipWorld getShipWorld() {
            return this.shipWorld;
        }

        @NotNull
        public final ClientShipWorld component1() {
            return this.shipWorld;
        }

        @NotNull
        public final StartUpdateRenderTransformsEvent copy(@NotNull ClientShipWorld shipWorld) {
            Intrinsics.checkNotNullParameter((Object)shipWorld, (String)"shipWorld");
            return new StartUpdateRenderTransformsEvent(shipWorld);
        }

        public static /* synthetic */ StartUpdateRenderTransformsEvent copy$default(StartUpdateRenderTransformsEvent startUpdateRenderTransformsEvent, ClientShipWorld clientShipWorld, int n2, Object object) {
            if ((n2 & 1) != 0) {
                clientShipWorld = startUpdateRenderTransformsEvent.shipWorld;
            }
            return startUpdateRenderTransformsEvent.copy(clientShipWorld);
        }

        @NotNull
        public String toString() {
            return "StartUpdateRenderTransformsEvent(shipWorld=" + this.shipWorld + ")";
        }

        public int hashCode() {
            return this.shipWorld.hashCode();
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StartUpdateRenderTransformsEvent)) {
                return false;
            }
            StartUpdateRenderTransformsEvent startUpdateRenderTransformsEvent = (StartUpdateRenderTransformsEvent)other;
            return Intrinsics.areEqual((Object)this.shipWorld, (Object)startUpdateRenderTransformsEvent.shipWorld);
        }

        @Deprecated(message="Use vsApi.startUpdateRenderTransformsEvent", replaceWith=@ReplaceWith(expression="vsApi.startUpdateRenderTransformsEvent", imports={"org.valkyrienskies.mod.api.vsApi"}))
        @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0096\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0096\u0001\u00a2\u0006\u0004\b\u0006\u0010\tJ \u0010\n\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0096\u0001\u00a2\u0006\u0004\b\n\u0010\u0007J0\u0010\n\u001a\u00020\u00052\u000e\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u000b2\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0096\u0001\u00a2\u0006\u0004\b\n\u0010\r\u00a8\u0006\u0010"}, d2={"Lorg/valkyrienskies/core/impl/hooks/VSEvents$StartUpdateRenderTransformsEvent$Companion;", "Lorg/valkyrienskies/core/api/event/ListenableEvent;", "Lorg/valkyrienskies/core/impl/hooks/VSEvents$StartUpdateRenderTransformsEvent;", "Ljava/util/function/Consumer;", "cb", "Lorg/valkyrienskies/core/api/event/RegisteredListener;", "on", "(Ljava/util/function/Consumer;)Lorg/valkyrienskies/core/api/event/RegisteredListener;", "Lorg/valkyrienskies/core/api/event/EventConsumer;", "(Lorg/valkyrienskies/core/api/event/EventConsumer;)Lorg/valkyrienskies/core/api/event/RegisteredListener;", "once", "Ljava/util/function/Predicate;", "predicate", "(Ljava/util/function/Predicate;Ljava/util/function/Consumer;)Lorg/valkyrienskies/core/api/event/RegisteredListener;", "<init>", "()V", "api"})
        public static final class Companion
        implements ListenableEvent<StartUpdateRenderTransformsEvent> {
            private final /* synthetic */ SingleEvent<StartUpdateRenderTransformsEvent> $$delegate_0;

            private Companion() {
                this.$$delegate_0 = INSTANCE.getStartUpdateRenderTransformsEvent();
            }

            @Override
            @NotNull
            public RegisteredListener on(@NotNull Consumer<? super StartUpdateRenderTransformsEvent> cb) {
                Intrinsics.checkNotNullParameter(cb, (String)"cb");
                return this.$$delegate_0.on(cb);
            }

            @Override
            @NotNull
            public RegisteredListener on(@NotNull EventConsumer<? super StartUpdateRenderTransformsEvent> cb) {
                Intrinsics.checkNotNullParameter(cb, (String)"cb");
                return this.$$delegate_0.on(cb);
            }

            @Override
            @NotNull
            public RegisteredListener once(@NotNull Consumer<? super StartUpdateRenderTransformsEvent> cb) {
                Intrinsics.checkNotNullParameter(cb, (String)"cb");
                return this.$$delegate_0.once(cb);
            }

            @Override
            @NotNull
            public RegisteredListener once(@NotNull Predicate<? super StartUpdateRenderTransformsEvent> predicate, @NotNull Consumer<? super StartUpdateRenderTransformsEvent> cb) {
                Intrinsics.checkNotNullParameter(predicate, (String)"predicate");
                Intrinsics.checkNotNullParameter(cb, (String)"cb");
                return this.$$delegate_0.once(predicate, cb);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    @Deprecated(message="Use the interface variant", replaceWith=@ReplaceWith(expression="TickEndEvent", imports={"org.valkyrienskies.mod.api.events.TickEndEvent"}))
    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00d6\u0003\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH\u00d6\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004\u00a8\u0006\u0018"}, d2={"Lorg/valkyrienskies/core/impl/hooks/VSEvents$TickEndEvent;", "Lorg/valkyrienskies/core/api/events/TickEndEvent;", "Lorg/valkyrienskies/core/api/world/ServerShipWorld;", "component1", "()Lorg/valkyrienskies/core/api/world/ServerShipWorld;", "world", "copy", "(Lorg/valkyrienskies/core/api/world/ServerShipWorld;)Lorg/valkyrienskies/core/impl/hooks/VSEvents$TickEndEvent;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/valkyrienskies/core/api/world/ServerShipWorld;", "getWorld", "<init>", "(Lorg/valkyrienskies/core/api/world/ServerShipWorld;)V", "Companion", "api"})
    public static final class TickEndEvent
    implements org.valkyrienskies.core.api.events.TickEndEvent {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final ServerShipWorld world;

        public TickEndEvent(@NotNull ServerShipWorld world) {
            Intrinsics.checkNotNullParameter((Object)world, (String)"world");
            this.world = world;
        }

        @Override
        @NotNull
        public ServerShipWorld getWorld() {
            return this.world;
        }

        @NotNull
        public final ServerShipWorld component1() {
            return this.world;
        }

        @NotNull
        public final TickEndEvent copy(@NotNull ServerShipWorld world) {
            Intrinsics.checkNotNullParameter((Object)world, (String)"world");
            return new TickEndEvent(world);
        }

        public static /* synthetic */ TickEndEvent copy$default(TickEndEvent tickEndEvent, ServerShipWorld serverShipWorld, int n2, Object object) {
            if ((n2 & 1) != 0) {
                serverShipWorld = tickEndEvent.world;
            }
            return tickEndEvent.copy(serverShipWorld);
        }

        @NotNull
        public String toString() {
            return "TickEndEvent(world=" + this.world + ")";
        }

        public int hashCode() {
            return this.world.hashCode();
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TickEndEvent)) {
                return false;
            }
            TickEndEvent tickEndEvent = (TickEndEvent)other;
            return Intrinsics.areEqual((Object)this.world, (Object)tickEndEvent.world);
        }

        @Deprecated(message="Use vsApi.tickEndEvent", replaceWith=@ReplaceWith(expression="vsApi.tickEndEvent", imports={"org.valkyrienskies.mod.api.vsApi"}))
        @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0096\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0096\u0001\u00a2\u0006\u0004\b\u0006\u0010\tJ \u0010\n\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0096\u0001\u00a2\u0006\u0004\b\n\u0010\u0007J0\u0010\n\u001a\u00020\u00052\u000e\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u000b2\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0096\u0001\u00a2\u0006\u0004\b\n\u0010\r\u00a8\u0006\u0010"}, d2={"Lorg/valkyrienskies/core/impl/hooks/VSEvents$TickEndEvent$Companion;", "Lorg/valkyrienskies/core/api/event/ListenableEvent;", "Lorg/valkyrienskies/core/impl/hooks/VSEvents$TickEndEvent;", "Ljava/util/function/Consumer;", "cb", "Lorg/valkyrienskies/core/api/event/RegisteredListener;", "on", "(Ljava/util/function/Consumer;)Lorg/valkyrienskies/core/api/event/RegisteredListener;", "Lorg/valkyrienskies/core/api/event/EventConsumer;", "(Lorg/valkyrienskies/core/api/event/EventConsumer;)Lorg/valkyrienskies/core/api/event/RegisteredListener;", "once", "Ljava/util/function/Predicate;", "predicate", "(Ljava/util/function/Predicate;Ljava/util/function/Consumer;)Lorg/valkyrienskies/core/api/event/RegisteredListener;", "<init>", "()V", "api"})
        public static final class Companion
        implements ListenableEvent<TickEndEvent> {
            private final /* synthetic */ SingleEvent<TickEndEvent> $$delegate_0;

            private Companion() {
                this.$$delegate_0 = INSTANCE.getTickEndEvent();
            }

            @Override
            @NotNull
            public RegisteredListener on(@NotNull Consumer<? super TickEndEvent> cb) {
                Intrinsics.checkNotNullParameter(cb, (String)"cb");
                return this.$$delegate_0.on(cb);
            }

            @Override
            @NotNull
            public RegisteredListener on(@NotNull EventConsumer<? super TickEndEvent> cb) {
                Intrinsics.checkNotNullParameter(cb, (String)"cb");
                return this.$$delegate_0.on(cb);
            }

            @Override
            @NotNull
            public RegisteredListener once(@NotNull Consumer<? super TickEndEvent> cb) {
                Intrinsics.checkNotNullParameter(cb, (String)"cb");
                return this.$$delegate_0.once(cb);
            }

            @Override
            @NotNull
            public RegisteredListener once(@NotNull Predicate<? super TickEndEvent> predicate, @NotNull Consumer<? super TickEndEvent> cb) {
                Intrinsics.checkNotNullParameter(predicate, (String)"predicate");
                Intrinsics.checkNotNullParameter(cb, (String)"cb");
                return this.$$delegate_0.once(predicate, cb);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }
}

