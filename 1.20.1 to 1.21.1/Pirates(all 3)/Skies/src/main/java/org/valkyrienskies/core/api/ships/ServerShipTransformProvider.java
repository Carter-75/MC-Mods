/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.api.ships;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.bodies.properties.BodyTransform;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\bJ!\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\t\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/ships/ServerShipTransformProvider;", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "prevShipTransform", "shipTransform", "Lorg/valkyrienskies/core/api/ships/ServerShipTransformProvider$NextTransformAndVelocityData;", "provideNextTransformAndVelocity", "(Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;)Lorg/valkyrienskies/core/api/ships/ServerShipTransformProvider$NextTransformAndVelocityData;", "NextTransformAndVelocityData", "api"})
public interface ServerShipTransformProvider {
    @Nullable
    public NextTransformAndVelocityData provideNextTransformAndVelocity(@NotNull ShipTransform var1, @NotNull ShipTransform var2);

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\u0007J2\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012H\u00d6\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015H\u00d6\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001c\u0010\u0007\u00a8\u0006\u001f"}, d2={"Lorg/valkyrienskies/core/api/ships/ServerShipTransformProvider$NextTransformAndVelocityData;", "", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "component1", "()Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "Lorg/joml/Vector3dc;", "component2", "()Lorg/joml/Vector3dc;", "component3", "nextTransform", "nextVel", "nextOmega", "copy", "(Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/api/ships/ServerShipTransformProvider$NextTransformAndVelocityData;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/joml/Vector3dc;", "getNextOmega", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "getNextTransform", "getNextVel", "<init>", "(Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)V", "api"})
    public static final class NextTransformAndVelocityData {
        @NotNull
        private final BodyTransform nextTransform;
        @Nullable
        private final Vector3dc nextVel;
        @Nullable
        private final Vector3dc nextOmega;

        public NextTransformAndVelocityData(@NotNull BodyTransform nextTransform, @Nullable Vector3dc nextVel, @Nullable Vector3dc nextOmega) {
            Intrinsics.checkNotNullParameter((Object)nextTransform, (String)"nextTransform");
            this.nextTransform = nextTransform;
            this.nextVel = nextVel;
            this.nextOmega = nextOmega;
        }

        @NotNull
        public final BodyTransform getNextTransform() {
            return this.nextTransform;
        }

        @Nullable
        public final Vector3dc getNextVel() {
            return this.nextVel;
        }

        @Nullable
        public final Vector3dc getNextOmega() {
            return this.nextOmega;
        }

        @NotNull
        public final BodyTransform component1() {
            return this.nextTransform;
        }

        @Nullable
        public final Vector3dc component2() {
            return this.nextVel;
        }

        @Nullable
        public final Vector3dc component3() {
            return this.nextOmega;
        }

        @NotNull
        public final NextTransformAndVelocityData copy(@NotNull BodyTransform nextTransform, @Nullable Vector3dc nextVel, @Nullable Vector3dc nextOmega) {
            Intrinsics.checkNotNullParameter((Object)nextTransform, (String)"nextTransform");
            return new NextTransformAndVelocityData(nextTransform, nextVel, nextOmega);
        }

        public static /* synthetic */ NextTransformAndVelocityData copy$default(NextTransformAndVelocityData nextTransformAndVelocityData, BodyTransform bodyTransform, Vector3dc vector3dc, Vector3dc vector3dc2, int n2, Object object) {
            if ((n2 & 1) != 0) {
                bodyTransform = nextTransformAndVelocityData.nextTransform;
            }
            if ((n2 & 2) != 0) {
                vector3dc = nextTransformAndVelocityData.nextVel;
            }
            if ((n2 & 4) != 0) {
                vector3dc2 = nextTransformAndVelocityData.nextOmega;
            }
            return nextTransformAndVelocityData.copy(bodyTransform, vector3dc, vector3dc2);
        }

        @NotNull
        public String toString() {
            return "NextTransformAndVelocityData(nextTransform=" + this.nextTransform + ", nextVel=" + this.nextVel + ", nextOmega=" + this.nextOmega + ")";
        }

        public int hashCode() {
            int result2 = this.nextTransform.hashCode();
            result2 = result2 * 31 + (this.nextVel == null ? 0 : this.nextVel.hashCode());
            result2 = result2 * 31 + (this.nextOmega == null ? 0 : this.nextOmega.hashCode());
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NextTransformAndVelocityData)) {
                return false;
            }
            NextTransformAndVelocityData nextTransformAndVelocityData = (NextTransformAndVelocityData)other;
            if (!Intrinsics.areEqual((Object)this.nextTransform, (Object)nextTransformAndVelocityData.nextTransform)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.nextVel, (Object)nextTransformAndVelocityData.nextVel)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.nextOmega, (Object)nextTransformAndVelocityData.nextOmega);
        }
    }
}

