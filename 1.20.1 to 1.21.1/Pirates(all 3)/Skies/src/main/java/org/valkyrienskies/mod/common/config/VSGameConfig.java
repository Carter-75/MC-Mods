/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.mod.common.config;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.internal.config.ConfigCategory;
import org.valkyrienskies.core.internal.config.ConfigEntry;
import org.valkyrienskies.mod.common.config.ShipRenderer;
import org.valkyrienskies.mod.mixinducks.feature.mass_tooltip.MassTooltipVisibility;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003\r\u000e\u000fB\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2={"Lorg/valkyrienskies/mod/common/config/VSGameConfig;", "", "Lorg/valkyrienskies/mod/common/config/VSGameConfig$Client;", "CLIENT", "Lorg/valkyrienskies/mod/common/config/VSGameConfig$Client;", "Lorg/valkyrienskies/mod/common/config/VSGameConfig$Server;", "SERVER", "Lorg/valkyrienskies/mod/common/config/VSGameConfig$Server;", "Lorg/valkyrienskies/mod/common/config/VSGameConfig$Common;", "COMMON", "Lorg/valkyrienskies/mod/common/config/VSGameConfig$Common;", "<init>", "()V", "Client", "Server", "Common", "valkyrienskies-120"})
public final class VSGameConfig {
    @NotNull
    public static final VSGameConfig INSTANCE = new VSGameConfig();
    @JvmField
    @NotNull
    public static final Client CLIENT = new Client();
    @JvmField
    @NotNull
    public static final Server SERVER = new Server();
    @JvmField
    @NotNull
    public static final Common COMMON = new Common();

    private VSGameConfig() {
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0002\u001f B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2={"Lorg/valkyrienskies/mod/common/config/VSGameConfig$Client;", "", "Lorg/valkyrienskies/mod/common/config/VSGameConfig$Client$TOOLTIP;", "Tooltip", "Lorg/valkyrienskies/mod/common/config/VSGameConfig$Client$TOOLTIP;", "getTooltip", "()Lorg/valkyrienskies/mod/common/config/VSGameConfig$Client$TOOLTIP;", "Lorg/valkyrienskies/mod/common/config/VSGameConfig$Client$BLOCKTINT;", "BlockTinting", "Lorg/valkyrienskies/mod/common/config/VSGameConfig$Client$BLOCKTINT;", "getBlockTinting", "()Lorg/valkyrienskies/mod/common/config/VSGameConfig$Client$BLOCKTINT;", "", "renderDebugText", "Z", "getRenderDebugText", "()Z", "setRenderDebugText", "(Z)V", "recommendSlugsInMcCommands", "getRecommendSlugsInMcCommands", "setRecommendSlugsInMcCommands", "Lorg/valkyrienskies/mod/common/config/ShipRenderer;", "defaultRenderer", "Lorg/valkyrienskies/mod/common/config/ShipRenderer;", "getDefaultRenderer", "()Lorg/valkyrienskies/mod/common/config/ShipRenderer;", "setDefaultRenderer", "(Lorg/valkyrienskies/mod/common/config/ShipRenderer;)V", "<init>", "()V", "TOOLTIP", "BLOCKTINT", "valkyrienskies-120"})
    public static final class Client {
        @ConfigCategory(title="Tooltips")
        @NotNull
        private final TOOLTIP Tooltip = new TOOLTIP();
        @ConfigCategory(title="Block Tint")
        @NotNull
        private final BLOCKTINT BlockTinting = new BLOCKTINT();
        @ConfigEntry(description="Renders the VS2 debug HUD with TPS")
        private boolean renderDebugText;
        @ConfigEntry(description="Recommend ship slugs in mc commands where player names could be used ex. /tp ship-name wich could pollute user autocomplete")
        private boolean recommendSlugsInMcCommands = true;
        @ConfigEntry(description="The way ships are rendered by default")
        @NotNull
        private ShipRenderer defaultRenderer = ShipRenderer.VANILLA;

        @NotNull
        public final TOOLTIP getTooltip() {
            return this.Tooltip;
        }

        @NotNull
        public final BLOCKTINT getBlockTinting() {
            return this.BlockTinting;
        }

        public final boolean getRenderDebugText() {
            return this.renderDebugText;
        }

        public final void setRenderDebugText(boolean bl) {
            this.renderDebugText = bl;
        }

        public final boolean getRecommendSlugsInMcCommands() {
            return this.recommendSlugsInMcCommands;
        }

        public final void setRecommendSlugsInMcCommands(boolean bl) {
            this.recommendSlugsInMcCommands = bl;
        }

        @NotNull
        public final ShipRenderer getDefaultRenderer() {
            return this.defaultRenderer;
        }

        public final void setDefaultRenderer(@NotNull ShipRenderer shipRenderer) {
            Intrinsics.checkNotNullParameter((Object)((Object)shipRenderer), (String)"<set-?>");
            this.defaultRenderer = shipRenderer;
        }

        @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2={"Lorg/valkyrienskies/mod/common/config/VSGameConfig$Client$BLOCKTINT;", "", "", "fixBlockTinting", "Z", "getFixBlockTinting", "()Z", "setFixBlockTinting", "(Z)V", "<init>", "()V", "valkyrienskies-120"})
        public static final class BLOCKTINT {
            @ConfigEntry(description="Partly fixes the block tinting issue with blocks on ships")
            private boolean fixBlockTinting;

            public final boolean getFixBlockTinting() {
                return this.fixBlockTinting;
            }

            public final void setFixBlockTinting(boolean bl) {
                this.fixBlockTinting = bl;
            }
        }

        @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2={"Lorg/valkyrienskies/mod/common/config/VSGameConfig$Client$TOOLTIP;", "", "Lorg/valkyrienskies/mod/mixinducks/feature/mass_tooltip/MassTooltipVisibility;", "massTooltipVisibility", "Lorg/valkyrienskies/mod/mixinducks/feature/mass_tooltip/MassTooltipVisibility;", "getMassTooltipVisibility", "()Lorg/valkyrienskies/mod/mixinducks/feature/mass_tooltip/MassTooltipVisibility;", "setMassTooltipVisibility", "(Lorg/valkyrienskies/mod/mixinducks/feature/mass_tooltip/MassTooltipVisibility;)V", "", "useImperialUnits", "Z", "getUseImperialUnits", "()Z", "setUseImperialUnits", "(Z)V", "<init>", "()V", "valkyrienskies-120"})
        public static final class TOOLTIP {
            @ConfigEntry(description="Set when the Mass Tooltip is Visible")
            @NotNull
            private MassTooltipVisibility massTooltipVisibility = MassTooltipVisibility.ADVANCED;
            @ConfigEntry(description="Use Imperial Units to show Mass")
            private boolean useImperialUnits;

            @NotNull
            public final MassTooltipVisibility getMassTooltipVisibility() {
                return this.massTooltipVisibility;
            }

            public final void setMassTooltipVisibility(@NotNull MassTooltipVisibility massTooltipVisibility) {
                Intrinsics.checkNotNullParameter((Object)((Object)massTooltipVisibility), (String)"<set-?>");
                this.massTooltipVisibility = massTooltipVisibility;
            }

            public final boolean getUseImperialUnits() {
                return this.useImperialUnits;
            }

            public final void setUseImperialUnits(boolean bl) {
                this.useImperialUnits = bl;
            }
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\b"}, d2={"Lorg/valkyrienskies/mod/common/config/VSGameConfig$Common;", "", "Lorg/valkyrienskies/mod/common/config/VSGameConfig$Common$Advanced;", "ADVANCED", "Lorg/valkyrienskies/mod/common/config/VSGameConfig$Common$Advanced;", "<init>", "()V", "Advanced", "valkyrienskies-120"})
    public static final class Common {
        @ConfigCategory(title="Advanced")
        @JvmField
        @NotNull
        public final Advanced ADVANCED = new Advanced();

        @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2={"Lorg/valkyrienskies/mod/common/config/VSGameConfig$Common$Advanced;", "", "", "renderPathfinding", "Z", "getRenderPathfinding", "()Z", "setRenderPathfinding", "(Z)V", "<init>", "()V", "valkyrienskies-120"})
        public static final class Advanced {
            @ConfigEntry(description="Renders mob pathfinding nodes. Must be set on client and server to work. Requires the system property -Dorg.valkyrienskies.render_pathfinding=true")
            private boolean renderPathfinding;

            public final boolean getRenderPathfinding() {
                return this.renderPathfinding;
            }

            public final void setRenderPathfinding(boolean bl) {
                this.renderPathfinding = bl;
            }
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0006\n\u0002\b!\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0006abcdefB\u0007\u00a2\u0006\u0004\b_\u0010`R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u00168\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\"\u0010%\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u001d\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R\"\u0010(\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u001d\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R\"\u0010+\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u001d\u001a\u0004\b,\u0010\u001f\"\u0004\b-\u0010!R\"\u0010.\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u001d\u001a\u0004\b/\u0010\u001f\"\u0004\b0\u0010!R\"\u00102\u001a\u0002018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00108\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010\u001d\u001a\u0004\b9\u0010\u001f\"\u0004\b:\u0010!R\"\u0010;\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010\u001d\u001a\u0004\b<\u0010\u001f\"\u0004\b=\u0010!R\"\u0010>\u001a\u0002018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b>\u00103\u001a\u0004\b?\u00105\"\u0004\b@\u00107R\"\u0010A\u001a\u0002018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bA\u00103\u001a\u0004\bB\u00105\"\u0004\bC\u00107R\"\u0010D\u001a\u0002018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bD\u00103\u001a\u0004\bE\u00105\"\u0004\bF\u00107R\"\u0010G\u001a\u0002018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bG\u00103\u001a\u0004\bH\u00105\"\u0004\bI\u00107R\"\u0010J\u001a\u0002018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bJ\u00103\u001a\u0004\bK\u00105\"\u0004\bL\u00107R\"\u0010M\u001a\u0002018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bM\u00103\u001a\u0004\bN\u00105\"\u0004\bO\u00107R\"\u0010P\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010\u001d\u001a\u0004\bQ\u0010\u001f\"\u0004\bR\u0010!R\"\u0010T\u001a\u00020S8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001a\u0010[\u001a\u00020Z8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\u00a8\u0006g"}, d2={"Lorg/valkyrienskies/mod/common/config/VSGameConfig$Server;", "", "Lorg/valkyrienskies/mod/common/config/VSGameConfig$Server$FTBCHUNKS;", "FTBChunks", "Lorg/valkyrienskies/mod/common/config/VSGameConfig$Server$FTBCHUNKS;", "getFTBChunks", "()Lorg/valkyrienskies/mod/common/config/VSGameConfig$Server$FTBCHUNKS;", "Lorg/valkyrienskies/mod/common/config/VSGameConfig$Server$COMPUTERCRAFT;", "ComputerCraft", "Lorg/valkyrienskies/mod/common/config/VSGameConfig$Server$COMPUTERCRAFT;", "getComputerCraft", "()Lorg/valkyrienskies/mod/common/config/VSGameConfig$Server$COMPUTERCRAFT;", "Lorg/valkyrienskies/mod/common/config/VSGameConfig$Server$WEATHER2;", "Weather2", "Lorg/valkyrienskies/mod/common/config/VSGameConfig$Server$WEATHER2;", "getWeather2", "()Lorg/valkyrienskies/mod/common/config/VSGameConfig$Server$WEATHER2;", "Lorg/valkyrienskies/mod/common/config/VSGameConfig$Server$DYNMAP;", "Dynmap", "Lorg/valkyrienskies/mod/common/config/VSGameConfig$Server$DYNMAP;", "getDynmap", "()Lorg/valkyrienskies/mod/common/config/VSGameConfig$Server$DYNMAP;", "Lorg/valkyrienskies/mod/common/config/VSGameConfig$Server$CBC;", "Cbc", "Lorg/valkyrienskies/mod/common/config/VSGameConfig$Server$CBC;", "getCbc", "()Lorg/valkyrienskies/mod/common/config/VSGameConfig$Server$CBC;", "", "enableInteractDistanceChecks", "Z", "getEnableInteractDistanceChecks", "()Z", "setEnableInteractDistanceChecks", "(Z)V", "transformTeleports", "getTransformTeleports", "setTransformTeleports", "enableMovementChecks", "getEnableMovementChecks", "setEnableMovementChecks", "teleportReconnectedPlayers", "getTeleportReconnectedPlayers", "setTeleportReconnectedPlayers", "saveMobsPositionOnShip", "getSaveMobsPositionOnShip", "setSaveMobsPositionOnShip", "preventFluidEscapingShip", "getPreventFluidEscapingShip", "setPreventFluidEscapingShip", "", "explosionBlastForce", "D", "getExplosionBlastForce", "()D", "setExplosionBlastForce", "(D)V", "allowMobSpawns", "getAllowMobSpawns", "setAllowMobSpawns", "aiOnShips", "getAiOnShips", "setAiOnShips", "miniShipSize", "getMiniShipSize", "setMiniShipSize", "minScaling", "getMinScaling", "setMinScaling", "defaultBlockMass", "getDefaultBlockMass", "setDefaultBlockMass", "defaultBlockElasticity", "getDefaultBlockElasticity", "setDefaultBlockElasticity", "defaultBlockFriction", "getDefaultBlockFriction", "setDefaultBlockFriction", "defaultBlockHardness", "getDefaultBlockHardness", "setDefaultBlockHardness", "enableWorldSplitting", "getEnableWorldSplitting", "setEnableWorldSplitting", "", "defaultSplitGraceTimer", "I", "getDefaultSplitGraceTimer", "()I", "setDefaultSplitGraceTimer", "(I)V", "Lorg/valkyrienskies/mod/common/config/VSGameConfig$Server$COMMANDS;", "Commands", "Lorg/valkyrienskies/mod/common/config/VSGameConfig$Server$COMMANDS;", "getCommands", "()Lorg/valkyrienskies/mod/common/config/VSGameConfig$Server$COMMANDS;", "<init>", "()V", "FTBCHUNKS", "COMPUTERCRAFT", "WEATHER2", "DYNMAP", "CBC", "COMMANDS", "valkyrienskies-120"})
    public static final class Server {
        @ConfigCategory(title="FTB Chunks")
        @NotNull
        private final FTBCHUNKS FTBChunks = new FTBCHUNKS();
        @ConfigCategory(title="ComputerCraft")
        @NotNull
        private final COMPUTERCRAFT ComputerCraft = new COMPUTERCRAFT();
        @ConfigCategory(title="Weather 2")
        @NotNull
        private final WEATHER2 Weather2 = new WEATHER2();
        @ConfigCategory(title="Dynmap")
        @NotNull
        private final DYNMAP Dynmap = new DYNMAP();
        @ConfigCategory(title="CBC")
        @NotNull
        private final CBC Cbc = new CBC();
        @ConfigEntry(description="By default, the vanilla server prevents block interacts past a certain distance to prevent cheat clients from breaking blocks halfway across the map. This approach breaks down in the face of extremely large ships, where the distance from the block origin to the nearest face is greater than the interact distance check allows.")
        private boolean enableInteractDistanceChecks = true;
        @ConfigEntry(description="If true, teleportation into the shipyard is redirected to the ship it belongs to instead.")
        private boolean transformTeleports = true;
        @ConfigEntry(description="By default, the server checks that player movement is legal, and if it isn't, rubber-bands the player with the infamous \"moved too quickly\" message. Since players on VS ships will move illegally, they will be affected by this check frequently. This option disables that check. (it doesn't work very well anyway, don't worry)")
        private boolean enableMovementChecks;
        @ConfigEntry(description="If true, when a player disconnects, their position on the ship is saved such that if the ship is moved, when they reconnect they will be teleported to the same position in the ship as they left, instead of being left behind.")
        private boolean teleportReconnectedPlayers = true;
        @ConfigEntry(description="If true, when a mob gets unloaded, its position on a ship is saved such that if the ship is moved, when the mob loads back in it will be teleported to the same position in the ship. This helps prevent mobs from falling off of ships.")
        private boolean saveMobsPositionOnShip = true;
        @ConfigEntry(description="If true, prevents water and other fluids from flowing out of the ship's bounding box.")
        private boolean preventFluidEscapingShip = true;
        @ConfigEntry(description="Blast force in newtons of a TNT explosion at the center of the explosion.")
        private double explosionBlastForce = 500000.0;
        @ConfigEntry(description="Allow natural mob spawning on ships")
        private boolean allowMobSpawns = true;
        @ConfigEntry(description="Allow rudimentary pathfinding on ships")
        private boolean aiOnShips = true;
        @ConfigEntry(description="Scale of the mini ship creator")
        private double miniShipSize = 0.5;
        @ConfigEntry(description="Minimum scale of ships")
        private double minScaling = 0.25;
        @ConfigEntry(description="Default mass for blocks that do not have it defined in data or code. Blocks with masses below 100 float in water")
        private double defaultBlockMass = 100.0;
        @ConfigEntry(description="Default elasticity coefficient for blocks. Higher values make blocks more bouncy")
        private double defaultBlockElasticity = 0.3;
        @ConfigEntry(description="Default friction coefficient for blocks. Lower values make blocks more slippery")
        private double defaultBlockFriction = 0.5;
        @ConfigEntry(description="Default block hardness (unused value, placeholder for later)")
        private double defaultBlockHardness = 1.0;
        @ConfigEntry(description="Enable splitting in worldspace. (Experimental!)")
        private boolean enableWorldSplitting;
        @ConfigEntry(description="The default grace timer for splitting. A split won't occur after a block break at a position until this many ticks have passed. Note that setting this too high may prevent things like explosions from properly launching split ships. (in ticks)")
        private int defaultSplitGraceTimer = 1;
        @ConfigCategory(title="Commands")
        @NotNull
        private final COMMANDS Commands = new COMMANDS();

        @NotNull
        public final FTBCHUNKS getFTBChunks() {
            return this.FTBChunks;
        }

        @NotNull
        public final COMPUTERCRAFT getComputerCraft() {
            return this.ComputerCraft;
        }

        @NotNull
        public final WEATHER2 getWeather2() {
            return this.Weather2;
        }

        @NotNull
        public final DYNMAP getDynmap() {
            return this.Dynmap;
        }

        @NotNull
        public final CBC getCbc() {
            return this.Cbc;
        }

        public final boolean getEnableInteractDistanceChecks() {
            return this.enableInteractDistanceChecks;
        }

        public final void setEnableInteractDistanceChecks(boolean bl) {
            this.enableInteractDistanceChecks = bl;
        }

        public final boolean getTransformTeleports() {
            return this.transformTeleports;
        }

        public final void setTransformTeleports(boolean bl) {
            this.transformTeleports = bl;
        }

        public final boolean getEnableMovementChecks() {
            return this.enableMovementChecks;
        }

        public final void setEnableMovementChecks(boolean bl) {
            this.enableMovementChecks = bl;
        }

        public final boolean getTeleportReconnectedPlayers() {
            return this.teleportReconnectedPlayers;
        }

        public final void setTeleportReconnectedPlayers(boolean bl) {
            this.teleportReconnectedPlayers = bl;
        }

        public final boolean getSaveMobsPositionOnShip() {
            return this.saveMobsPositionOnShip;
        }

        public final void setSaveMobsPositionOnShip(boolean bl) {
            this.saveMobsPositionOnShip = bl;
        }

        public final boolean getPreventFluidEscapingShip() {
            return this.preventFluidEscapingShip;
        }

        public final void setPreventFluidEscapingShip(boolean bl) {
            this.preventFluidEscapingShip = bl;
        }

        public final double getExplosionBlastForce() {
            return this.explosionBlastForce;
        }

        public final void setExplosionBlastForce(double d2) {
            this.explosionBlastForce = d2;
        }

        public final boolean getAllowMobSpawns() {
            return this.allowMobSpawns;
        }

        public final void setAllowMobSpawns(boolean bl) {
            this.allowMobSpawns = bl;
        }

        public final boolean getAiOnShips() {
            return this.aiOnShips;
        }

        public final void setAiOnShips(boolean bl) {
            this.aiOnShips = bl;
        }

        public final double getMiniShipSize() {
            return this.miniShipSize;
        }

        public final void setMiniShipSize(double d2) {
            this.miniShipSize = d2;
        }

        public final double getMinScaling() {
            return this.minScaling;
        }

        public final void setMinScaling(double d2) {
            this.minScaling = d2;
        }

        public final double getDefaultBlockMass() {
            return this.defaultBlockMass;
        }

        public final void setDefaultBlockMass(double d2) {
            this.defaultBlockMass = d2;
        }

        public final double getDefaultBlockElasticity() {
            return this.defaultBlockElasticity;
        }

        public final void setDefaultBlockElasticity(double d2) {
            this.defaultBlockElasticity = d2;
        }

        public final double getDefaultBlockFriction() {
            return this.defaultBlockFriction;
        }

        public final void setDefaultBlockFriction(double d2) {
            this.defaultBlockFriction = d2;
        }

        public final double getDefaultBlockHardness() {
            return this.defaultBlockHardness;
        }

        public final void setDefaultBlockHardness(double d2) {
            this.defaultBlockHardness = d2;
        }

        public final boolean getEnableWorldSplitting() {
            return this.enableWorldSplitting;
        }

        public final void setEnableWorldSplitting(boolean bl) {
            this.enableWorldSplitting = bl;
        }

        public final int getDefaultSplitGraceTimer() {
            return this.defaultSplitGraceTimer;
        }

        public final void setDefaultSplitGraceTimer(int n2) {
            this.defaultSplitGraceTimer = n2;
        }

        @NotNull
        public final COMMANDS getCommands() {
            return this.Commands;
        }

        @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2={"Lorg/valkyrienskies/mod/common/config/VSGameConfig$Server$CBC;", "", "", "shellRecoil", "Z", "getShellRecoil", "()Z", "setShellRecoil", "(Z)V", "", "shellRecoilMult", "D", "getShellRecoilMult", "()D", "setShellRecoilMult", "(D)V", "<init>", "()V", "valkyrienskies-120"})
        public static final class CBC {
            @ConfigEntry(description="Should cannon shots apply a recoil force to ships")
            private boolean shellRecoil;
            @ConfigEntry(description="The force multiplier applied to recoil on ships")
            private double shellRecoilMult = 500000.0;

            public final boolean getShellRecoil() {
                return this.shellRecoil;
            }

            public final void setShellRecoil(boolean bl) {
                this.shellRecoil = bl;
            }

            public final double getShellRecoilMult() {
                return this.shellRecoilMult;
            }

            public final void setShellRecoilMult(double d2) {
                this.shellRecoilMult = d2;
            }
        }

        @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u001e\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b\u00a8\u0006 "}, d2={"Lorg/valkyrienskies/mod/common/config/VSGameConfig$Server$COMMANDS;", "", "", "deleteShipCommandPerms", "I", "getDeleteShipCommandPerms", "()I", "setDeleteShipCommandPerms", "(I)V", "getShipCommandPerms", "getGetShipCommandPerms", "setGetShipCommandPerms", "renameShipCommandPerms", "getRenameShipCommandPerms", "setRenameShipCommandPerms", "remassShipCommandPerms", "getRemassShipCommandPerms", "setRemassShipCommandPerms", "scaleShipCommandPerms", "getScaleShipCommandPerms", "setScaleShipCommandPerms", "setStaticShipCommandPerms", "getSetStaticShipCommandPerms", "setSetStaticShipCommandPerms", "teleportShipCommandPerms", "getTeleportShipCommandPerms", "setTeleportShipCommandPerms", "changeBackendCommandPerms", "getChangeBackendCommandPerms", "setChangeBackendCommandPerms", "<init>", "()V", "valkyrienskies-120"})
        public static final class COMMANDS {
            @ConfigEntry(description="The permission level required to use the /vs delete command. Must be 0 <= x <= 4")
            private int deleteShipCommandPerms = 2;
            @ConfigEntry(description="The permission level required to use the /vs get-ship command. Must be 0 <= x <= 4")
            private int getShipCommandPerms;
            @ConfigEntry(description="The permission level required to use the /vs rename command. Must be 0 <= x <= 4")
            private int renameShipCommandPerms = 2;
            @ConfigEntry(description="The permission level required to use the /vs remass command. Must be 0 <= x <= 4")
            private int remassShipCommandPerms = 2;
            @ConfigEntry(description="The permission level required to use the /vs scale command. Must be 0 <= x <= 4")
            private int scaleShipCommandPerms = 2;
            @ConfigEntry(description="The permission level required to use the /vs set-static command. Must be 0 <= x <= 4")
            private int setStaticShipCommandPerms = 2;
            @ConfigEntry(description="The permission level required to use the /vs teleport command. Must be 0 <= x <= 4")
            private int teleportShipCommandPerms = 2;
            @ConfigEntry(description="The permission level required to use the /vs backend command. Must be 0 <= x <= 4")
            private int changeBackendCommandPerms = 4;

            public final int getDeleteShipCommandPerms() {
                return this.deleteShipCommandPerms;
            }

            public final void setDeleteShipCommandPerms(int n2) {
                this.deleteShipCommandPerms = n2;
            }

            public final int getGetShipCommandPerms() {
                return this.getShipCommandPerms;
            }

            public final void setGetShipCommandPerms(int n2) {
                this.getShipCommandPerms = n2;
            }

            public final int getRenameShipCommandPerms() {
                return this.renameShipCommandPerms;
            }

            public final void setRenameShipCommandPerms(int n2) {
                this.renameShipCommandPerms = n2;
            }

            public final int getRemassShipCommandPerms() {
                return this.remassShipCommandPerms;
            }

            public final void setRemassShipCommandPerms(int n2) {
                this.remassShipCommandPerms = n2;
            }

            public final int getScaleShipCommandPerms() {
                return this.scaleShipCommandPerms;
            }

            public final void setScaleShipCommandPerms(int n2) {
                this.scaleShipCommandPerms = n2;
            }

            public final int getSetStaticShipCommandPerms() {
                return this.setStaticShipCommandPerms;
            }

            public final void setSetStaticShipCommandPerms(int n2) {
                this.setStaticShipCommandPerms = n2;
            }

            public final int getTeleportShipCommandPerms() {
                return this.teleportShipCommandPerms;
            }

            public final void setTeleportShipCommandPerms(int n2) {
                this.teleportShipCommandPerms = n2;
            }

            public final int getChangeBackendCommandPerms() {
                return this.changeBackendCommandPerms;
            }

            public final void setChangeBackendCommandPerms(int n2) {
                this.changeBackendCommandPerms = n2;
            }
        }

        @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2={"Lorg/valkyrienskies/mod/common/config/VSGameConfig$Server$COMPUTERCRAFT;", "", "", "canTurtlesLeaveScaledShips", "Z", "getCanTurtlesLeaveScaledShips", "()Z", "setCanTurtlesLeaveScaledShips", "(Z)V", "<init>", "()V", "valkyrienskies-120"})
        public static final class COMPUTERCRAFT {
            @ConfigEntry(description="Turtles leaving scaled up/down ship may cause issuesEnable/Disable Turtles Leaving Scaled Ships?")
            private boolean canTurtlesLeaveScaledShips;

            public final boolean getCanTurtlesLeaveScaledShips() {
                return this.canTurtlesLeaveScaledShips;
            }

            public final void setCanTurtlesLeaveScaledShips(boolean bl) {
                this.canTurtlesLeaveScaledShips = bl;
            }
        }

        @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b\u00a8\u0006\u0014"}, d2={"Lorg/valkyrienskies/mod/common/config/VSGameConfig$Server$DYNMAP;", "", "", "showIconMarkers", "Z", "getShowIconMarkers", "()Z", "setShowIconMarkers", "(Z)V", "showPolylineMarkers", "getShowPolylineMarkers", "setShowPolylineMarkers", "showShipId", "getShowShipId", "setShowShipId", "showShipMass", "getShowShipMass", "setShowShipMass", "<init>", "()V", "valkyrienskies-120"})
        public static final class DYNMAP {
            @ConfigEntry(description="Show Ships as Icon Markers on Dynmap")
            private boolean showIconMarkers = true;
            @ConfigEntry(description="Show Ships as Polyline Markers on Dynmap")
            private boolean showPolylineMarkers = true;
            @ConfigEntry(description="Show the Ship ID in the label")
            private boolean showShipId = true;
            @ConfigEntry(description="Show the Ship Mass in the label")
            private boolean showShipMass = true;

            public final boolean getShowIconMarkers() {
                return this.showIconMarkers;
            }

            public final void setShowIconMarkers(boolean bl) {
                this.showIconMarkers = bl;
            }

            public final boolean getShowPolylineMarkers() {
                return this.showPolylineMarkers;
            }

            public final void setShowPolylineMarkers(boolean bl) {
                this.showPolylineMarkers = bl;
            }

            public final boolean getShowShipId() {
                return this.showShipId;
            }

            public final void setShowShipId(boolean bl) {
                this.showShipId = bl;
            }

            public final boolean getShowShipMass() {
                return this.showShipMass;
            }

            public final void setShowShipMass(boolean bl) {
                this.showShipMass = bl;
            }
        }

        @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b\u00a8\u0006\u000e"}, d2={"Lorg/valkyrienskies/mod/common/config/VSGameConfig$Server$FTBCHUNKS;", "", "", "shipsProtectedByClaims", "Z", "getShipsProtectedByClaims", "()Z", "setShipsProtectedByClaims", "(Z)V", "shipsProtectionOutOfBuildHeight", "getShipsProtectionOutOfBuildHeight", "setShipsProtectionOutOfBuildHeight", "<init>", "()V", "valkyrienskies-120"})
        public static final class FTBCHUNKS {
            @ConfigEntry(description="Are Ships protected by FTB Chunk Claims?")
            private boolean shipsProtectedByClaims = true;
            @ConfigEntry(description="Are ships protected outside of build height (max and min)?")
            private boolean shipsProtectionOutOfBuildHeight;

            public final boolean getShipsProtectedByClaims() {
                return this.shipsProtectedByClaims;
            }

            public final void setShipsProtectedByClaims(boolean bl) {
                this.shipsProtectedByClaims = bl;
            }

            public final boolean getShipsProtectionOutOfBuildHeight() {
                return this.shipsProtectionOutOfBuildHeight;
            }

            public final void setShipsProtectionOutOfBuildHeight(boolean bl) {
                this.shipsProtectionOutOfBuildHeight = bl;
            }
        }

        @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000f\u00a8\u0006\u001f"}, d2={"Lorg/valkyrienskies/mod/common/config/VSGameConfig$Server$WEATHER2;", "", "", "enableWeatherCompat", "Z", "getEnableWeatherCompat", "()Z", "setEnableWeatherCompat", "(Z)V", "", "windMultiplier", "F", "getWindMultiplier", "()F", "setWindMultiplier", "(F)V", "windMaxVel", "getWindMaxVel", "setWindMaxVel", "", "stormRange", "D", "getStormRange", "()D", "setStormRange", "(D)V", "stormDampening", "getStormDampening", "setStormDampening", "<init>", "()V", "valkyrienskies-120"})
        public static final class WEATHER2 {
            @ConfigEntry(description="If VS ships are affected by Weather2")
            private boolean enableWeatherCompat = true;
            @ConfigEntry(description="How much Weather 2's wind affects VS ships")
            private float windMultiplier = 0.1f;
            @ConfigEntry(description="The maximum velocity a VS ship can travel because of wind")
            private float windMaxVel = 20.0f;
            @ConfigEntry(description="In what range storms affect VS ships")
            private double stormRange = 150.0;
            @ConfigEntry(description="Storm effect dampening on VS ships")
            private float stormDampening;

            public final boolean getEnableWeatherCompat() {
                return this.enableWeatherCompat;
            }

            public final void setEnableWeatherCompat(boolean bl) {
                this.enableWeatherCompat = bl;
            }

            public final float getWindMultiplier() {
                return this.windMultiplier;
            }

            public final void setWindMultiplier(float f2) {
                this.windMultiplier = f2;
            }

            public final float getWindMaxVel() {
                return this.windMaxVel;
            }

            public final void setWindMaxVel(float f2) {
                this.windMaxVel = f2;
            }

            public final double getStormRange() {
                return this.stormRange;
            }

            public final void setStormRange(double d2) {
                this.stormRange = d2;
            }

            public final float getStormDampening() {
                return this.stormDampening;
            }

            public final void setStormDampening(float f2) {
                this.stormDampening = f2;
            }
        }
    }
}

