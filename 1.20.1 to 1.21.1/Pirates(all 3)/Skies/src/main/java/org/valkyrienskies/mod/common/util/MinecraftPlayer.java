/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 */
package org.valkyrienskies.mod.common.util;

import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;
import org.valkyrienskies.core.internal.world.VsiPlayer;
import org.valkyrienskies.core.internal.world.VsiPlayerState;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.entity.ShipMountedToData;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010.\u001a\u00020\u0017\u00a2\u0006\u0004\b/\u00100J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001e\u001a\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010 R\u0018\u0010'\u001a\u00060#j\u0002`$8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010&R \u0010*\u001a\b\u0012\u0004\u0012\u00020)0(8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\u00a8\u00061"}, d2={"Lorg/valkyrienskies/mod/common/util/MinecraftPlayer;", "Lorg/valkyrienskies/core/internal/world/VsiPlayer;", "Lorg/joml/Vector3d;", "dest", "getPosition", "(Lorg/joml/Vector3d;)Lorg/joml/Vector3d;", "Lorg/valkyrienskies/core/internal/world/VsiPlayerState;", "getPlayerState", "()Lorg/valkyrienskies/core/internal/world/VsiPlayerState;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/UUID;", "uuid", "Ljava/util/UUID;", "getUuid", "()Ljava/util/UUID;", "Ljava/lang/ref/WeakReference;", "Lnet/minecraft/class_1657;", "playerEntityReference", "Ljava/lang/ref/WeakReference;", "getPlayerEntityReference", "()Ljava/lang/ref/WeakReference;", "getPlayer", "()Lnet/minecraft/class_1657;", "player", "isAdmin", "()Z", "getCanModifyServerConfig", "canModifyServerConfig", "", "Lorg/valkyrienskies/core/internal/world/properties/DimensionId;", "getDimension", "()Ljava/lang/String;", "dimension", "Ljava/util/HashSet;", "", "forceWatchingShips", "Ljava/util/HashSet;", "getForceWatchingShips", "()Ljava/util/HashSet;", "playerObject", "<init>", "(Lnet/minecraft/class_1657;)V", "valkyrienskies-120"})
public final class MinecraftPlayer
implements VsiPlayer {
    @NotNull
    private final UUID uuid;
    @NotNull
    private final WeakReference<class_1657> playerEntityReference;
    @NotNull
    private final HashSet<Long> forceWatchingShips;

    public MinecraftPlayer(@NotNull class_1657 playerObject) {
        Intrinsics.checkNotNullParameter((Object)playerObject, (String)"playerObject");
        UUID uUID = playerObject.method_5667();
        Intrinsics.checkNotNullExpressionValue((Object)uUID, (String)"getUUID(...)");
        this.uuid = uUID;
        this.playerEntityReference = new WeakReference<class_1657>(playerObject);
        this.forceWatchingShips = new HashSet();
    }

    @Override
    @NotNull
    public UUID getUuid() {
        return this.uuid;
    }

    @NotNull
    public final WeakReference<class_1657> getPlayerEntityReference() {
        return this.playerEntityReference;
    }

    @NotNull
    public final class_1657 getPlayer() {
        Object t = this.playerEntityReference.get();
        Intrinsics.checkNotNull(t);
        return (class_1657)t;
    }

    @Override
    public boolean isAdmin() {
        return this.getPlayer().method_5687(4);
    }

    @Override
    public boolean getCanModifyServerConfig() {
        return VSGameUtilsKt.getVsCore().getHooks().isPhysicalClient() || this.getPlayer().method_5687(4);
    }

    @Override
    @NotNull
    public String getDimension() {
        class_1937 class_19372 = this.getPlayer().method_37908();
        Intrinsics.checkNotNullExpressionValue((Object)class_19372, (String)"level(...)");
        return VSGameUtilsKt.getDimensionId(class_19372);
    }

    @NotNull
    public HashSet<Long> getForceWatchingShips() {
        return this.forceWatchingShips;
    }

    @Override
    @NotNull
    public Vector3d getPosition(@NotNull Vector3d dest) {
        Intrinsics.checkNotNullParameter((Object)dest, (String)"dest");
        Vector3d vector3d = dest.set(this.getPlayer().method_23317(), this.getPlayer().method_23318(), this.getPlayer().method_23321());
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"set(...)");
        return vector3d;
    }

    @Override
    @NotNull
    public VsiPlayerState getPlayerState() {
        Object object;
        ShipMountedToData mountedShipAndPos = VSGameUtilsKt.getShipMountedToData$default((class_1297)this.getPlayer(), null, 2, null);
        ShipMountedToData shipMountedToData = mountedShipAndPos;
        return new VsiPlayerState(new Vector3d(this.getPlayer().method_23317(), this.getPlayer().method_23318(), this.getPlayer().method_23321()), new Vector3d(new Vector3d(this.getPlayer().method_23317() - this.getPlayer().field_6014, this.getPlayer().method_23318() - this.getPlayer().field_6036, this.getPlayer().method_23321() - this.getPlayer().field_5969)), this.getDimension(), (object = mountedShipAndPos) != null && (object = ((ShipMountedToData)object).getShipMountedTo()) != null ? Long.valueOf(object.getId()) : null, shipMountedToData != null ? shipMountedToData.getMountPosInShip() : null);
    }

    public int hashCode() {
        return this.getUuid().hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (super.equals(other)) {
            return true;
        }
        if (other instanceof MinecraftPlayer) {
            return Intrinsics.areEqual((Object)this.getUuid(), (Object)((MinecraftPlayer)other).getUuid());
        }
        return false;
    }
}

