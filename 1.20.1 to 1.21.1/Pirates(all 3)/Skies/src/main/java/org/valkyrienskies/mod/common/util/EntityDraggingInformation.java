/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.mod.common.util;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;
import org.joml.Vector3dc;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\bF\u0018\u0000 m2\u00020\u0001:\u0001mB\u0007\u00a2\u0006\u0004\bk\u0010lJ\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\u0018R:\u0010\u001f\u001a\n\u0018\u00010\u001cj\u0004\u0018\u0001`\u001d2\u000e\u0010\u001e\u001a\n\u0018\u00010\u001cj\u0004\u0018\u0001`\u001d8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R*\u0010%\u001a\n\u0018\u00010\u001cj\u0004\u0018\u0001`\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R*\u0010)\u001a\u00020(2\u0006\u0010\u001e\u001a\u00020(8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010/\u001a\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010*\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R\"\u00102\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010\u0015\u001a\u0004\b3\u0010\u0004\"\u0004\b4\u0010\u0018R\"\u00105\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010\u0015\u001a\u0004\b6\u0010\u0004\"\u0004\b7\u0010\u0018R$\u00108\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010\t\u001a\u0004\b9\u0010\u0007\"\u0004\b:\u0010\fR$\u0010;\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010\t\u001a\u0004\b<\u0010\u0007\"\u0004\b=\u0010\fR$\u0010>\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR$\u0010D\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010?\u001a\u0004\bE\u0010A\"\u0004\bF\u0010CR$\u0010G\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010?\u001a\u0004\bH\u0010A\"\u0004\bI\u0010CR$\u0010J\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010\t\u001a\u0004\bK\u0010\u0007\"\u0004\bL\u0010\fR$\u0010M\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010\t\u001a\u0004\bN\u0010\u0007\"\u0004\bO\u0010\fR$\u0010P\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010?\u001a\u0004\bQ\u0010A\"\u0004\bR\u0010CR$\u0010S\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bS\u0010?\u001a\u0004\bT\u0010A\"\u0004\bU\u0010CR$\u0010V\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010?\u001a\u0004\bW\u0010A\"\u0004\bX\u0010CR\"\u0010Y\u001a\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010*\u001a\u0004\bZ\u0010,\"\u0004\b[\u0010.R\"\u0010\\\u001a\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\\\u0010*\u001a\u0004\b]\u0010,\"\u0004\b^\u0010.R$\u0010_\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010\t\u001a\u0004\b`\u0010\u0007\"\u0004\ba\u0010\fR\"\u0010b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bb\u0010\u0015\u001a\u0004\bc\u0010\u0004\"\u0004\bd\u0010\u0018R$\u0010e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\be\u0010\t\u001a\u0004\bf\u0010\u0007\"\u0004\bg\u0010\fR$\u0010h\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bh\u0010?\u001a\u0004\bi\u0010A\"\u0004\bj\u0010C\u00a8\u0006n"}, d2={"Lorg/valkyrienskies/mod/common/util/EntityDraggingInformation;", "", "", "isEntityBeingDraggedByAShip", "()Z", "Lorg/joml/Vector3dc;", "bestRelativeEntityPosition", "()Lorg/joml/Vector3dc;", "addedMovementLastTick", "Lorg/joml/Vector3dc;", "getAddedMovementLastTick", "setAddedMovementLastTick", "(Lorg/joml/Vector3dc;)V", "", "addedYawRotLastTick", "D", "getAddedYawRotLastTick", "()D", "setAddedYawRotLastTick", "(D)V", "changedShipLastTick", "Z", "getChangedShipLastTick", "setChangedShipLastTick", "(Z)V", "shouldImpulseMovement", "getShouldImpulseMovement", "setShouldImpulseMovement", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "value", "lastShipStoodOn", "Ljava/lang/Long;", "getLastShipStoodOn", "()Ljava/lang/Long;", "setLastShipStoodOn", "(Ljava/lang/Long;)V", "lastShipStoodOnServerWriteOnly", "getLastShipStoodOnServerWriteOnly", "setLastShipStoodOnServerWriteOnly", "", "ticksSinceStoodOnShip", "I", "getTicksSinceStoodOnShip", "()I", "setTicksSinceStoodOnShip", "(I)V", "ticksSinceLastServerPacket", "getTicksSinceLastServerPacket", "setTicksSinceLastServerPacket", "ignoreNextGroundStand", "getIgnoreNextGroundStand", "setIgnoreNextGroundStand", "mountedToEntity", "getMountedToEntity", "setMountedToEntity", "lerpPositionOnShip", "getLerpPositionOnShip", "setLerpPositionOnShip", "relativeVelocityOnShip", "getRelativeVelocityOnShip", "setRelativeVelocityOnShip", "lerpYawOnShip", "Ljava/lang/Double;", "getLerpYawOnShip", "()Ljava/lang/Double;", "setLerpYawOnShip", "(Ljava/lang/Double;)V", "lerpHeadYawOnShip", "getLerpHeadYawOnShip", "setLerpHeadYawOnShip", "lerpPitchOnShip", "getLerpPitchOnShip", "setLerpPitchOnShip", "relativePositionOnShip", "getRelativePositionOnShip", "setRelativePositionOnShip", "previousRelativeVelocityOnShip", "getPreviousRelativeVelocityOnShip", "setPreviousRelativeVelocityOnShip", "relativeYawOnShip", "getRelativeYawOnShip", "setRelativeYawOnShip", "relativeHeadYawOnShip", "getRelativeHeadYawOnShip", "setRelativeHeadYawOnShip", "relativePitchOnShip", "getRelativePitchOnShip", "setRelativePitchOnShip", "lerpSteps", "getLerpSteps", "setLerpSteps", "headLerpSteps", "getHeadLerpSteps", "setHeadLerpSteps", "cachedLastPosition", "getCachedLastPosition", "setCachedLastPosition", "restoreCachedLastPosition", "getRestoreCachedLastPosition", "setRestoreCachedLastPosition", "serverRelativePlayerPosition", "getServerRelativePlayerPosition", "setServerRelativePlayerPosition", "serverRelativePlayerYaw", "getServerRelativePlayerYaw", "setServerRelativePlayerYaw", "<init>", "()V", "Companion", "valkyrienskies-120"})
public final class EntityDraggingInformation {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private Vector3dc addedMovementLastTick = new Vector3d();
    private double addedYawRotLastTick;
    private boolean changedShipLastTick;
    private boolean shouldImpulseMovement;
    @Nullable
    private Long lastShipStoodOn;
    @Nullable
    private Long lastShipStoodOnServerWriteOnly;
    private int ticksSinceStoodOnShip;
    private int ticksSinceLastServerPacket;
    private boolean ignoreNextGroundStand;
    private boolean mountedToEntity;
    @Nullable
    private Vector3dc lerpPositionOnShip;
    @Nullable
    private Vector3dc relativeVelocityOnShip;
    @Nullable
    private Double lerpYawOnShip;
    @Nullable
    private Double lerpHeadYawOnShip;
    @Nullable
    private Double lerpPitchOnShip;
    @Nullable
    private Vector3dc relativePositionOnShip;
    @Nullable
    private Vector3dc previousRelativeVelocityOnShip;
    @Nullable
    private Double relativeYawOnShip;
    @Nullable
    private Double relativeHeadYawOnShip;
    @Nullable
    private Double relativePitchOnShip;
    private int lerpSteps;
    private int headLerpSteps;
    @Nullable
    private Vector3dc cachedLastPosition;
    private boolean restoreCachedLastPosition;
    @Nullable
    private Vector3dc serverRelativePlayerPosition;
    @Nullable
    private Double serverRelativePlayerYaw;
    public static final int TICKS_TO_DRAG_ENTITIES = 25;

    @NotNull
    public final Vector3dc getAddedMovementLastTick() {
        return this.addedMovementLastTick;
    }

    public final void setAddedMovementLastTick(@NotNull Vector3dc vector3dc) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"<set-?>");
        this.addedMovementLastTick = vector3dc;
    }

    public final double getAddedYawRotLastTick() {
        return this.addedYawRotLastTick;
    }

    public final void setAddedYawRotLastTick(double d2) {
        this.addedYawRotLastTick = d2;
    }

    public final boolean getChangedShipLastTick() {
        return this.changedShipLastTick;
    }

    public final void setChangedShipLastTick(boolean bl) {
        this.changedShipLastTick = bl;
    }

    public final boolean getShouldImpulseMovement() {
        return this.shouldImpulseMovement;
    }

    public final void setShouldImpulseMovement(boolean bl) {
        this.shouldImpulseMovement = bl;
    }

    @Nullable
    public final Long getLastShipStoodOn() {
        return this.lastShipStoodOn;
    }

    public final void setLastShipStoodOn(@Nullable Long value) {
        if (value != null) {
            this.setTicksSinceStoodOnShip(0);
        }
        this.shouldImpulseMovement = !Intrinsics.areEqual((Object)this.lastShipStoodOn, (Object)value) && value != null;
        this.changedShipLastTick = !Intrinsics.areEqual((Object)this.lastShipStoodOn, (Object)value) && this.lastShipStoodOn != null && value != null;
        this.lastShipStoodOn = value;
    }

    @Nullable
    public final Long getLastShipStoodOnServerWriteOnly() {
        return this.lastShipStoodOnServerWriteOnly;
    }

    public final void setLastShipStoodOnServerWriteOnly(@Nullable Long l2) {
        this.lastShipStoodOnServerWriteOnly = l2;
    }

    public final int getTicksSinceStoodOnShip() {
        return this.ticksSinceStoodOnShip;
    }

    public final void setTicksSinceStoodOnShip(int value) {
        this.shouldImpulseMovement = false;
        this.ticksSinceStoodOnShip = value;
    }

    public final int getTicksSinceLastServerPacket() {
        return this.ticksSinceLastServerPacket;
    }

    public final void setTicksSinceLastServerPacket(int n2) {
        this.ticksSinceLastServerPacket = n2;
    }

    public final boolean getIgnoreNextGroundStand() {
        return this.ignoreNextGroundStand;
    }

    public final void setIgnoreNextGroundStand(boolean bl) {
        this.ignoreNextGroundStand = bl;
    }

    public final boolean getMountedToEntity() {
        return this.mountedToEntity;
    }

    public final void setMountedToEntity(boolean bl) {
        this.mountedToEntity = bl;
    }

    @Nullable
    public final Vector3dc getLerpPositionOnShip() {
        return this.lerpPositionOnShip;
    }

    public final void setLerpPositionOnShip(@Nullable Vector3dc vector3dc) {
        this.lerpPositionOnShip = vector3dc;
    }

    @Nullable
    public final Vector3dc getRelativeVelocityOnShip() {
        return this.relativeVelocityOnShip;
    }

    public final void setRelativeVelocityOnShip(@Nullable Vector3dc vector3dc) {
        this.relativeVelocityOnShip = vector3dc;
    }

    @Nullable
    public final Double getLerpYawOnShip() {
        return this.lerpYawOnShip;
    }

    public final void setLerpYawOnShip(@Nullable Double d2) {
        this.lerpYawOnShip = d2;
    }

    @Nullable
    public final Double getLerpHeadYawOnShip() {
        return this.lerpHeadYawOnShip;
    }

    public final void setLerpHeadYawOnShip(@Nullable Double d2) {
        this.lerpHeadYawOnShip = d2;
    }

    @Nullable
    public final Double getLerpPitchOnShip() {
        return this.lerpPitchOnShip;
    }

    public final void setLerpPitchOnShip(@Nullable Double d2) {
        this.lerpPitchOnShip = d2;
    }

    @Nullable
    public final Vector3dc getRelativePositionOnShip() {
        return this.relativePositionOnShip;
    }

    public final void setRelativePositionOnShip(@Nullable Vector3dc vector3dc) {
        this.relativePositionOnShip = vector3dc;
    }

    @Nullable
    public final Vector3dc getPreviousRelativeVelocityOnShip() {
        return this.previousRelativeVelocityOnShip;
    }

    public final void setPreviousRelativeVelocityOnShip(@Nullable Vector3dc vector3dc) {
        this.previousRelativeVelocityOnShip = vector3dc;
    }

    @Nullable
    public final Double getRelativeYawOnShip() {
        return this.relativeYawOnShip;
    }

    public final void setRelativeYawOnShip(@Nullable Double d2) {
        this.relativeYawOnShip = d2;
    }

    @Nullable
    public final Double getRelativeHeadYawOnShip() {
        return this.relativeHeadYawOnShip;
    }

    public final void setRelativeHeadYawOnShip(@Nullable Double d2) {
        this.relativeHeadYawOnShip = d2;
    }

    @Nullable
    public final Double getRelativePitchOnShip() {
        return this.relativePitchOnShip;
    }

    public final void setRelativePitchOnShip(@Nullable Double d2) {
        this.relativePitchOnShip = d2;
    }

    public final int getLerpSteps() {
        return this.lerpSteps;
    }

    public final void setLerpSteps(int n2) {
        this.lerpSteps = n2;
    }

    public final int getHeadLerpSteps() {
        return this.headLerpSteps;
    }

    public final void setHeadLerpSteps(int n2) {
        this.headLerpSteps = n2;
    }

    @Nullable
    public final Vector3dc getCachedLastPosition() {
        return this.cachedLastPosition;
    }

    public final void setCachedLastPosition(@Nullable Vector3dc vector3dc) {
        this.cachedLastPosition = vector3dc;
    }

    public final boolean getRestoreCachedLastPosition() {
        return this.restoreCachedLastPosition;
    }

    public final void setRestoreCachedLastPosition(boolean bl) {
        this.restoreCachedLastPosition = bl;
    }

    @Nullable
    public final Vector3dc getServerRelativePlayerPosition() {
        return this.serverRelativePlayerPosition;
    }

    public final void setServerRelativePlayerPosition(@Nullable Vector3dc vector3dc) {
        this.serverRelativePlayerPosition = vector3dc;
    }

    @Nullable
    public final Double getServerRelativePlayerYaw() {
        return this.serverRelativePlayerYaw;
    }

    public final void setServerRelativePlayerYaw(@Nullable Double d2) {
        this.serverRelativePlayerYaw = d2;
    }

    public final boolean isEntityBeingDraggedByAShip() {
        return this.lastShipStoodOn != null && this.ticksSinceStoodOnShip < 25 && !this.mountedToEntity;
    }

    @Nullable
    public final Vector3dc bestRelativeEntityPosition() {
        Vector3dc vector3dc;
        if (this.serverRelativePlayerPosition != null) {
            Vector3dc vector3dc2 = this.serverRelativePlayerPosition;
            vector3dc = vector3dc2;
            Intrinsics.checkNotNull((Object)vector3dc2);
        } else if (this.relativePositionOnShip != null) {
            Vector3dc vector3dc3 = this.relativePositionOnShip;
            vector3dc = vector3dc3;
            Intrinsics.checkNotNull((Object)vector3dc3);
        } else {
            vector3dc = null;
        }
        return vector3dc;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2={"Lorg/valkyrienskies/mod/common/util/EntityDraggingInformation$Companion;", "", "", "TICKS_TO_DRAG_ENTITIES", "I", "<init>", "()V", "valkyrienskies-120"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

