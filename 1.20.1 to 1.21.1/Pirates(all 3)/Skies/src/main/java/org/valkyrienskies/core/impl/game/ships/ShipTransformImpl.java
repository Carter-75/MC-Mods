/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.game.ships;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.bodies.properties.BodyTransform;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.impl.bodies.properties.BodyTransformFactory;
import org.valkyrienskies.core.impl.shadow.eu_0;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/ShipTransformImpl;", "", "<init>", "()V", "Companion"})
public final class ShipTransformImpl {
    public static final Companion Companion = new Companion(null);
    private static final Quaterniondc ZERO_ROTATION = new Quaterniond();
    private static final Vector3dc UNIT_SCALING = new Vector3d(1.0, 1.0, 1.0);
    private static final Vector3dc ZERO = new Vector3d();

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\u0006\u0010\nJ-\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\fJ\r\u0010\r\u001a\u00020\u0005\u00a2\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u001b\u001a\u00020\b8\u0007\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/ShipTransformImpl$Companion;", "", "Lorg/joml/Vector3dc;", "centerCoordinateInWorld", "centerCoordinateInShip", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "create", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "Lorg/joml/Quaterniondc;", "shipRotation", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;)Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "shipScaling", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "createEmpty", "()Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "prevTransform", "curTransform", "", "alpha", "createFromSlerp", "(Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;D)Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "UNIT_SCALING", "Lorg/joml/Vector3dc;", "getUNIT_SCALING", "()Lorg/joml/Vector3dc;", "ZERO", "getZERO", "ZERO_ROTATION", "Lorg/joml/Quaterniondc;", "getZERO_ROTATION", "()Lorg/joml/Quaterniondc;", "<init>", "()V"})
    public static final class Companion {
        private Companion() {
        }

        @JvmName(name="getZERO_ROTATION")
        public final Quaterniondc getZERO_ROTATION() {
            return ZERO_ROTATION;
        }

        @JvmName(name="getUNIT_SCALING")
        public final Vector3dc getUNIT_SCALING() {
            return UNIT_SCALING;
        }

        @JvmName(name="getZERO")
        public final Vector3dc getZERO() {
            return ZERO;
        }

        public final ShipTransform createEmpty() {
            Companion companion = this;
            return companion.create(companion.getZERO(), this.getZERO());
        }

        /*
         * WARNING - void declaration
         */
        public final ShipTransform create(Vector3dc centerCoordinateInWorld, Vector3dc centerCoordinateInShip) {
            void var2_2;
            void var1_1;
            Intrinsics.checkNotNullParameter((Object)centerCoordinateInWorld, (String)"");
            Intrinsics.checkNotNullParameter((Object)centerCoordinateInShip, (String)"");
            return this.create((Vector3dc)var1_1, (Vector3dc)var2_2, this.getZERO_ROTATION());
        }

        /*
         * WARNING - void declaration
         */
        public final ShipTransform create(Vector3dc centerCoordinateInWorld, Vector3dc centerCoordinateInShip, Quaterniondc shipRotation) {
            void var3_3;
            void var2_2;
            void var1_1;
            Intrinsics.checkNotNullParameter((Object)centerCoordinateInWorld, (String)"");
            Intrinsics.checkNotNullParameter((Object)centerCoordinateInShip, (String)"");
            Intrinsics.checkNotNullParameter((Object)shipRotation, (String)"");
            return eu_0.a((Vector3dc)var1_1, (Vector3dc)var2_2, (Quaterniondc)var3_3, this.getUNIT_SCALING());
        }

        /*
         * WARNING - void declaration
         */
        public final ShipTransform create(Vector3dc centerCoordinateInWorld, Vector3dc centerCoordinateInShip, Quaterniondc shipRotation, Vector3dc shipScaling) {
            void var3_3;
            void var2_2;
            void var1_1;
            Intrinsics.checkNotNullParameter((Object)centerCoordinateInWorld, (String)"");
            Intrinsics.checkNotNullParameter((Object)centerCoordinateInShip, (String)"");
            Intrinsics.checkNotNullParameter((Object)shipRotation, (String)"");
            Intrinsics.checkNotNullParameter((Object)shipScaling, (String)"");
            return eu_0.a((Vector3dc)var1_1, (Vector3dc)var2_2, (Quaterniondc)var3_3, shipScaling);
        }

        /*
         * WARNING - void declaration
         */
        public final ShipTransform createFromSlerp(ShipTransform prevTransform, ShipTransform curTransform, double alpha) {
            void var3_3;
            void var2_2;
            void var1_1;
            Intrinsics.checkNotNullParameter((Object)prevTransform, (String)"");
            Intrinsics.checkNotNullParameter((Object)curTransform, (String)"");
            return BodyTransformFactory.INSTANCE.createFromSlerp((BodyTransform)var1_1, (BodyTransform)var2_2, (double)var3_3);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

