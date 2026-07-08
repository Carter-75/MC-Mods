/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.config;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.impl.config.PhysicsConfig;
import org.valkyrienskies.core.internal.config.ConfigCategory;
import org.valkyrienskies.core.internal.config.ConfigEntry;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\b"}, d2={"Lorg/valkyrienskies/core/impl/config/VSCoreConfig;", "", "Lorg/valkyrienskies/core/impl/config/VSCoreConfig$Server;", "SERVER", "Lorg/valkyrienskies/core/impl/config/VSCoreConfig$Server;", "<init>", "()V", "Server", "internal"})
public final class VSCoreConfig {
    @NotNull
    public static final VSCoreConfig INSTANCE = new VSCoreConfig();
    @JvmField
    @NotNull
    public static final Server SERVER = new Server();

    private VSCoreConfig() {
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0003234B\u0007\u00a2\u0006\u0004\b0\u00101R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\u00158\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001a\u0010%\u001a\u00020$8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/\u00a8\u00065"}, d2={"Lorg/valkyrienskies/core/impl/config/VSCoreConfig$Server;", "", "Lorg/valkyrienskies/core/impl/config/VSCoreConfig$Server$DragSettings;", "ds", "Lorg/valkyrienskies/core/impl/config/VSCoreConfig$Server$DragSettings;", "getDs", "()Lorg/valkyrienskies/core/impl/config/VSCoreConfig$Server$DragSettings;", "", "enableUdp", "Z", "getEnableUdp", "()Z", "setEnableUdp", "(Z)V", "Lorg/valkyrienskies/core/impl/config/PhysicsConfig;", "physics", "Lorg/valkyrienskies/core/impl/config/PhysicsConfig;", "getPhysics", "()Lorg/valkyrienskies/core/impl/config/PhysicsConfig;", "setPhysics", "(Lorg/valkyrienskies/core/impl/config/PhysicsConfig;)V", "Lorg/valkyrienskies/core/impl/config/VSCoreConfig$Server$PhysicsThreadSettings;", "pt", "Lorg/valkyrienskies/core/impl/config/VSCoreConfig$Server$PhysicsThreadSettings;", "getPt", "()Lorg/valkyrienskies/core/impl/config/VSCoreConfig$Server$PhysicsThreadSettings;", "", "shipLoadDistance", "D", "getShipLoadDistance", "()D", "setShipLoadDistance", "(D)V", "shipUnloadDistance", "getShipUnloadDistance", "setShipUnloadDistance", "Lorg/valkyrienskies/core/impl/config/VSCoreConfig$Server$ConnectivitySettings;", "sp", "Lorg/valkyrienskies/core/impl/config/VSCoreConfig$Server$ConnectivitySettings;", "getSp", "()Lorg/valkyrienskies/core/impl/config/VSCoreConfig$Server$ConnectivitySettings;", "", "udpPort", "I", "getUdpPort", "()I", "setUdpPort", "(I)V", "<init>", "()V", "ConnectivitySettings", "DragSettings", "PhysicsThreadSettings", "internal"})
    public static final class Server {
        @ConfigCategory(title="Physics Thread Settings")
        @NotNull
        private final PhysicsThreadSettings pt = new PhysicsThreadSettings();
        @ConfigCategory(title="Connectivity Settings (Experimental)")
        @NotNull
        private final ConnectivitySettings sp = new ConnectivitySettings();
        @ConfigCategory(title="Drag Settings")
        @NotNull
        private final DragSettings ds = new DragSettings();
        @ConfigEntry(description="Port to attempt to establish UDP connections on")
        private int udpPort = 25565;
        @ConfigEntry(description="Is udp enabled? If not, the server will only use TCP")
        private boolean enableUdp;
        @ConfigEntry(description="Ship load distance in blocks")
        private double shipLoadDistance = 128.0;
        @ConfigEntry(description="Ship unload distance in blocks")
        private double shipUnloadDistance = 196.0;
        @ConfigCategory(title="Krunch Konfig")
        @NotNull
        private PhysicsConfig physics = new PhysicsConfig();

        @NotNull
        public final PhysicsThreadSettings getPt() {
            return this.pt;
        }

        @NotNull
        public final ConnectivitySettings getSp() {
            return this.sp;
        }

        @NotNull
        public final DragSettings getDs() {
            return this.ds;
        }

        public final int getUdpPort() {
            return this.udpPort;
        }

        public final void setUdpPort(int n2) {
            this.udpPort = n2;
        }

        public final boolean getEnableUdp() {
            return this.enableUdp;
        }

        public final void setEnableUdp(boolean bl) {
            this.enableUdp = bl;
        }

        public final double getShipLoadDistance() {
            return this.shipLoadDistance;
        }

        public final void setShipLoadDistance(double d2) {
            this.shipLoadDistance = d2;
        }

        public final double getShipUnloadDistance() {
            return this.shipUnloadDistance;
        }

        public final void setShipUnloadDistance(double d2) {
            this.shipUnloadDistance = d2;
        }

        @NotNull
        public final PhysicsConfig getPhysics() {
            return this.physics;
        }

        public final void setPhysics(@NotNull PhysicsConfig physicsConfig) {
            Intrinsics.checkNotNullParameter((Object)physicsConfig, (String)"<set-?>");
            this.physics = physicsConfig;
        }

        @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b\u00a8\u0006\u001a"}, d2={"Lorg/valkyrienskies/core/impl/config/VSCoreConfig$Server$ConnectivitySettings;", "", "", "enableBlockCornerConnectivity", "Z", "getEnableBlockCornerConnectivity", "()Z", "setEnableBlockCornerConnectivity", "(Z)V", "enableBlockEdgeConnectivity", "getEnableBlockEdgeConnectivity", "setEnableBlockEdgeConnectivity", "enableConnectivity", "getEnableConnectivity", "setEnableConnectivity", "enableSplitting", "getEnableSplitting", "setEnableSplitting", "enableWorldConnectivity", "getEnableWorldConnectivity", "setEnableWorldConnectivity", "verboseConnectivityLogging", "getVerboseConnectivityLogging", "setVerboseConnectivityLogging", "<init>", "()V", "internal"})
        public static final class ConnectivitySettings {
            @ConfigEntry(description="Enable/Disable Connectivity (May reduce memory usage. Use [enableSplitting] instead if you just want to disable ship splitting.)")
            private boolean enableConnectivity = true;
            @ConfigEntry(description="Enable/Disable World Connectivity (Experimental!)")
            private boolean enableWorldConnectivity;
            @ConfigEntry(description="Enable/Disable Block Edge Connectivity (WARNING! May significantly increase memory usage)")
            private boolean enableBlockEdgeConnectivity = true;
            @ConfigEntry(description="Enable/Disable Block Corner Connectivity (WARNING! May significantly increase memory usage)")
            private boolean enableBlockCornerConnectivity;
            @ConfigEntry(description="Enable/Disable Splitting (Disabling this setting will not prevent the use of Air Pockets.)")
            private boolean enableSplitting;
            @ConfigEntry(description="Enable verbose logging of connectivity (May result in very large log files)")
            private boolean verboseConnectivityLogging;

            public final boolean getEnableConnectivity() {
                return this.enableConnectivity;
            }

            public final void setEnableConnectivity(boolean bl) {
                this.enableConnectivity = bl;
            }

            public final boolean getEnableWorldConnectivity() {
                return this.enableWorldConnectivity;
            }

            public final void setEnableWorldConnectivity(boolean bl) {
                this.enableWorldConnectivity = bl;
            }

            public final boolean getEnableBlockEdgeConnectivity() {
                return this.enableBlockEdgeConnectivity;
            }

            public final void setEnableBlockEdgeConnectivity(boolean bl) {
                this.enableBlockEdgeConnectivity = bl;
            }

            public final boolean getEnableBlockCornerConnectivity() {
                return this.enableBlockCornerConnectivity;
            }

            public final void setEnableBlockCornerConnectivity(boolean bl) {
                this.enableBlockCornerConnectivity = bl;
            }

            public final boolean getEnableSplitting() {
                return this.enableSplitting;
            }

            public final void setEnableSplitting(boolean bl) {
                this.enableSplitting = bl;
            }

            public final boolean getVerboseConnectivityLogging() {
                return this.verboseConnectivityLogging;
            }

            public final void setVerboseConnectivityLogging(boolean bl) {
                this.verboseConnectivityLogging = bl;
            }
        }

        @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b\u00a8\u0006\u001b"}, d2={"Lorg/valkyrienskies/core/impl/config/VSCoreConfig$Server$DragSettings;", "", "", "dragCoefficient", "D", "getDragCoefficient", "()D", "setDragCoefficient", "(D)V", "dragMultiplier", "getDragMultiplier", "setDragMultiplier", "", "enableDrag", "Z", "getEnableDrag", "()Z", "setEnableDrag", "(Z)V", "enableLift", "getEnableLift", "setEnableLift", "liftMultiplier", "getLiftMultiplier", "setLiftMultiplier", "<init>", "()V", "internal"})
        public static final class DragSettings {
            @ConfigEntry(description="Enable/Disable Drag on all bodies.")
            private boolean enableDrag = true;
            @ConfigEntry(description="Enable/Disable Lift on all bodies.")
            private boolean enableLift = true;
            @ConfigEntry(description="The drag coefficient used to represent a solid 1x1x1 cube. This is an exaggerated value by default due to the scale of builds in MC.")
            private double dragCoefficient = 2.18;
            @ConfigEntry(description="A static multiplier applied to drag forces. Useful for when your configured masses are higher/lower than the default.")
            private double dragMultiplier = 10.0;
            @ConfigEntry(description="A static multiplier applied to lift forces. Useful for when your configured masses are higher/lower than the default.")
            private double liftMultiplier = 10.0;

            public final boolean getEnableDrag() {
                return this.enableDrag;
            }

            public final void setEnableDrag(boolean bl) {
                this.enableDrag = bl;
            }

            public final boolean getEnableLift() {
                return this.enableLift;
            }

            public final void setEnableLift(boolean bl) {
                this.enableLift = bl;
            }

            public final double getDragCoefficient() {
                return this.dragCoefficient;
            }

            public final void setDragCoefficient(double d2) {
                this.dragCoefficient = d2;
            }

            public final double getDragMultiplier() {
                return this.dragMultiplier;
            }

            public final void setDragMultiplier(double d2) {
                this.dragMultiplier = d2;
            }

            public final double getLiftMultiplier() {
                return this.liftMultiplier;
            }

            public final void setLiftMultiplier(double d2) {
                this.liftMultiplier = d2;
            }
        }

        @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b\u00a8\u0006\u001e"}, d2={"Lorg/valkyrienskies/core/impl/config/VSCoreConfig$Server$PhysicsThreadSettings;", "", "", "physicsTicksPerGameTick", "I", "getPhysicsTicksPerGameTick", "()I", "setPhysicsTicksPerGameTick", "(I)V", "", "synchronizePhysics", "Z", "getSynchronizePhysics", "()Z", "setSynchronizePhysics", "(Z)V", "terrainBakingThreadPriority", "getTerrainBakingThreadPriority", "setTerrainBakingThreadPriority", "terrainBakingThreads", "getTerrainBakingThreads", "setTerrainBakingThreads", "terrainDeletionThreadPriority", "getTerrainDeletionThreadPriority", "setTerrainDeletionThreadPriority", "terrainDeletionThreads", "getTerrainDeletionThreads", "setTerrainDeletionThreads", "<init>", "()V", "internal"})
        public static final class PhysicsThreadSettings {
            @ConfigEntry(description="Synchronize the physics thread and the game thread")
            private boolean synchronizePhysics;
            @ConfigEntry(description="default is 3, for 60 phys ticks per second")
            private int physicsTicksPerGameTick = 3;
            @ConfigEntry(description="Number of terrain baking threads, more is good for preventing stutters when flying fast ships. However, too many will overload the cpu which will lag the game.")
            private int terrainBakingThreads = Runtime.getRuntime().availableProcessors() - 4;
            @ConfigEntry(description="Thread priority of terrain baking threads. 5 is default priority, higher is higher priority, lower is lower priority.")
            private int terrainBakingThreadPriority = 5;
            @ConfigEntry(description="Number of terrain deletion threads. Typically just 1 is fine.")
            private int terrainDeletionThreads = 1;
            @ConfigEntry(description="Thread priority of terrain deletion threads. These are used to clean up memory, so they can be lower priority than.")
            private int terrainDeletionThreadPriority = 4;

            public final boolean getSynchronizePhysics() {
                return this.synchronizePhysics;
            }

            public final void setSynchronizePhysics(boolean bl) {
                this.synchronizePhysics = bl;
            }

            public final int getPhysicsTicksPerGameTick() {
                return this.physicsTicksPerGameTick;
            }

            public final void setPhysicsTicksPerGameTick(int n2) {
                this.physicsTicksPerGameTick = n2;
            }

            public final int getTerrainBakingThreads() {
                return this.terrainBakingThreads;
            }

            public final void setTerrainBakingThreads(int n2) {
                this.terrainBakingThreads = n2;
            }

            public final int getTerrainBakingThreadPriority() {
                return this.terrainBakingThreadPriority;
            }

            public final void setTerrainBakingThreadPriority(int n2) {
                this.terrainBakingThreadPriority = n2;
            }

            public final int getTerrainDeletionThreads() {
                return this.terrainDeletionThreads;
            }

            public final void setTerrainDeletionThreads(int n2) {
                this.terrainDeletionThreads = n2;
            }

            public final int getTerrainDeletionThreadPriority() {
                return this.terrainDeletionThreadPriority;
            }

            public final void setTerrainDeletionThreadPriority(int n2) {
                this.terrainDeletionThreadPriority = n2;
            }
        }
    }
}

