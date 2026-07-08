/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3d
 *  org.joml.Vector3dc
 *  org.valkyrienskies.core.api.ships.LoadedServerShip
 *  org.valkyrienskies.core.api.ships.PhysShip
 *  org.valkyrienskies.core.api.ships.ShipPhysicsListener
 *  org.valkyrienskies.core.api.world.PhysLevel
 *  org.valkyrienskies.core.impl.game.ships.PhysShipImpl
 */
package g_mungus.vlib.dimension;

import g_mungus.vlib.data.DimensionSettings;
import g_mungus.vlib.dimension.DimensionSettingsManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.LoadedServerShip;
import org.valkyrienskies.core.api.ships.PhysShip;
import org.valkyrienskies.core.api.ships.ShipPhysicsListener;
import org.valkyrienskies.core.api.world.PhysLevel;
import org.valkyrienskies.core.impl.game.ships.PhysShipImpl;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\t\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bR$\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2={"Lg_mungus/vlib/dimension/GravityAttachment;", "Lorg/valkyrienskies/core/api/ships/ShipPhysicsListener;", "Lorg/valkyrienskies/core/api/ships/PhysShip;", "physShip", "Lorg/valkyrienskies/core/api/world/PhysLevel;", "physLevel", "", "physTick", "(Lorg/valkyrienskies/core/api/ships/PhysShip;Lorg/valkyrienskies/core/api/world/PhysLevel;)V", "", "value", "dimension", "Ljava/lang/String;", "getDimension", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "vlib"})
public final class GravityAttachment
implements ShipPhysicsListener {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private String dimension;

    public GravityAttachment(@NotNull String dimension) {
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"dimension");
        this.dimension = dimension;
    }

    @NotNull
    public final String getDimension() {
        return this.dimension;
    }

    public void physTick(@NotNull PhysShip physShip, @NotNull PhysLevel physLevel) {
        Intrinsics.checkNotNullParameter((Object)physShip, (String)"physShip");
        Intrinsics.checkNotNullParameter((Object)physLevel, (String)"physLevel");
        DimensionSettings dimensionSettings = DimensionSettingsManager.INSTANCE.getSettingsForLevel(this.dimension);
        if (!(dimensionSettings.getGravity() == 1.0) && dimensionSettings.getShouldApplyGravity()) {
            double gravity = (1.0 - dimensionSettings.getGravity()) * (double)10 * ((PhysShipImpl)physShip).getMass();
            try {
                ((PhysShipImpl)physShip).applyInvariantForce((Vector3dc)new Vector3d(0.0, gravity, 0.0));
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2={"Lg_mungus/vlib/dimension/GravityAttachment$Companion;", "", "Lorg/valkyrienskies/core/api/ships/LoadedServerShip;", "ship", "Lg_mungus/vlib/dimension/GravityAttachment;", "getOrCreate", "(Lorg/valkyrienskies/core/api/ships/LoadedServerShip;)Lg_mungus/vlib/dimension/GravityAttachment;", "<init>", "()V", "vlib"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final GravityAttachment getOrCreate(@NotNull LoadedServerShip ship) {
            Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
            GravityAttachment attachment = (GravityAttachment)ship.getAttachment(GravityAttachment.class);
            if (attachment == null) {
                attachment = new GravityAttachment(ship.getChunkClaimDimension());
                ship.setAttachment((Object)attachment);
            } else {
                attachment.dimension = ship.getChunkClaimDimension();
            }
            return attachment;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

