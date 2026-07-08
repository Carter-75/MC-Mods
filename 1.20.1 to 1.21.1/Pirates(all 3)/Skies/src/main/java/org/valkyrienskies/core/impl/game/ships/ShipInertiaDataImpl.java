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
import org.joml.Matrix3d;
import org.joml.Matrix3dc;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.properties.ShipInertiaData;
import org.valkyrienskies.core.impl.shadow.ek_0;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u0000 H2\u00020\u0001:\u0001HB\u001f\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\bF\u0010GJ/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nH\u00c2\u0003\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002H\u00c2\u0003\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fH\u00c2\u0003\u00a2\u0006\u0004\b\u0010\u0010\u0011J.\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u000fH\u00c6\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u00d6\u0003\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 H\u00d6\u0001\u00a2\u0006\u0004\b!\u0010\"J5\u0010(\u001a\u00020\u00072\u0006\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0002\u00a2\u0006\u0004\b(\u0010)J5\u0010*\u001a\u00020\u00072\u0006\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0002\u00a2\u0006\u0004\b*\u0010)J\u0010\u0010,\u001a\u00020+H\u00d6\u0001\u00a2\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b.\u0010/R\u0014\u0010\u0012\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u00100R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u00101R\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u00102R\u0014\u00106\u001a\u0002038WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u00105R\"\u00107\u001a\u00020\u001d8\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0014\u0010@\u001a\u00020=8WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b>\u0010?R\u0014\u0010B\u001a\u00020\u00028WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bA\u0010\u000eR\u0016\u0010C\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u00102R\u0011\u0010E\u001a\u00020=8G\u00a2\u0006\u0006\u001a\u0004\bD\u0010?"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/ShipInertiaDataImpl;", "Lorg/valkyrienskies/core/api/ships/properties/ShipInertiaData;", "", "x", "y", "z", "addedMass", "", "addMassAt", "(DDDD)V", "Lorg/joml/Vector3d;", "component1", "()Lorg/joml/Vector3d;", "component2", "()D", "Lorg/joml/Matrix3d;", "component3", "()Lorg/joml/Matrix3d;", "_centerOfMassInShip", "_mass", "_momentOfInertiaTensor", "copy", "(Lorg/joml/Vector3d;DLorg/joml/Matrix3d;)Lorg/valkyrienskies/core/impl/game/ships/ShipInertiaDataImpl;", "scaling", "Lorg/valkyrienskies/core/impl/shadow/Ek;", "copyToPhyInertia", "(D)Lorg/valkyrienskies/core/impl/shadow/Ek;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "posX", "posY", "posZ", "oldBlockMass", "newBlockMass", "onSetBlock", "(IIIDD)V", "onSetBlockUseSphereMOI", "", "toString", "()Ljava/lang/String;", "updateSphericalMOI", "()V", "Lorg/joml/Vector3d;", "D", "Lorg/joml/Matrix3d;", "Lorg/joml/Vector3dc;", "getCenterOfMass", "()Lorg/joml/Vector3dc;", "centerOfMass", "cmChangedThisTick", "Z", "getCmChangedThisTick", "()Z", "setCmChangedThisTick", "(Z)V", "Lorg/joml/Matrix3dc;", "getInertiaTensor", "()Lorg/joml/Matrix3dc;", "inertiaTensor", "getMass", "mass", "momentOfInertiaSpherical", "getMomentOfInertiaTensorToSave", "momentOfInertiaTensorToSave", "<init>", "(Lorg/joml/Vector3d;DLorg/joml/Matrix3d;)V", "Companion"})
public final class ShipInertiaDataImpl
implements ShipInertiaData {
    public static final Companion Companion = new Companion(null);
    private final Vector3d _centerOfMassInShip;
    private double _mass;
    private final Matrix3d _momentOfInertiaTensor;
    private Matrix3d momentOfInertiaSpherical;
    private boolean cmChangedThisTick;
    private static final double EPSILON = 1.0E-6;
    private static final double INERTIA_OFFSET = 0.4;

    /*
     * WARNING - void declaration
     */
    public ShipInertiaDataImpl(Vector3d _centerOfMassInShip, double _mass, Matrix3d _momentOfInertiaTensor) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)_centerOfMassInShip, (String)"");
        Intrinsics.checkNotNullParameter((Object)_momentOfInertiaTensor, (String)"");
        this._centerOfMassInShip = var1_1;
        this._mass = var2_2;
        this._momentOfInertiaTensor = _momentOfInertiaTensor;
        this.momentOfInertiaSpherical = new Matrix3d(this._momentOfInertiaTensor);
        this.updateSphericalMOI();
    }

    @JvmName(name="getCmChangedThisTick")
    public final boolean getCmChangedThisTick() {
        return this.cmChangedThisTick;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="setCmChangedThisTick")
    public final void setCmChangedThisTick(boolean bl) {
        void var1_1;
        this.cmChangedThisTick = var1_1;
    }

    @Override
    @JvmName(name="getInertiaTensor")
    public final Matrix3dc getInertiaTensor() {
        return this.momentOfInertiaSpherical;
    }

    @JvmName(name="getMomentOfInertiaTensorToSave")
    public final Matrix3dc getMomentOfInertiaTensorToSave() {
        return this._momentOfInertiaTensor;
    }

    @Override
    @JvmName(name="getCenterOfMass")
    public final Vector3dc getCenterOfMass() {
        return this._centerOfMassInShip;
    }

    @Override
    @JvmName(name="getMass")
    public final double getMass() {
        return this._mass;
    }

    /*
     * WARNING - void declaration
     */
    public final void onSetBlock(int posX, int posY, int posZ, double oldBlockMass, double newBlockMass) {
        void var3_3;
        void var2_2;
        void var1_1;
        double d2;
        double d3 = newBlockMass - oldBlockMass;
        if (Math.abs(d2) < 1.0E-6) {
            return;
        }
        double d4 = d3 / 8.0;
        double d5 = (double)var1_1 + 0.5;
        double d6 = (double)var2_2 + 0.5;
        double d7 = (double)var3_3 + 0.5;
        this.addMassAt(d5 + 0.4, d6 + 0.4, d7 + 0.4, d4);
        this.addMassAt(d5 + 0.4, d6 + 0.4, d7 - 0.4, d4);
        this.addMassAt(d5 + 0.4, d6 - 0.4, d7 + 0.4, d4);
        this.addMassAt(d5 + 0.4, d6 - 0.4, d7 - 0.4, d4);
        this.addMassAt(d5 - 0.4, d6 + 0.4, d7 + 0.4, d4);
        this.addMassAt(d5 - 0.4, d6 + 0.4, d7 - 0.4, d4);
        this.addMassAt(d5 - 0.4, d6 - 0.4, d7 + 0.4, d4);
        this.addMassAt(d5 - 0.4, d6 - 0.4, d7 - 0.4, d4);
    }

    /*
     * WARNING - void declaration
     */
    public final void onSetBlockUseSphereMOI(int posX, int posY, int posZ, double oldBlockMass, double newBlockMass) {
        void var3_3;
        void var2_2;
        void var1_1;
        this.onSetBlock((int)var1_1, (int)var2_2, (int)var3_3, oldBlockMass, newBlockMass);
        this.updateSphericalMOI();
    }

    private final void updateSphericalMOI() {
        double d2 = this._momentOfInertiaTensor.transform(new Vector3d(1.0, 0.0, 0.0)).length();
        double d3 = this._momentOfInertiaTensor.transform(new Vector3d(0.0, 1.0, 0.0)).length();
        double d4 = this._momentOfInertiaTensor.transform(new Vector3d(0.0, 0.0, 1.0)).length();
        double d5 = (d2 + d3 + d4) / 3.0;
        this.momentOfInertiaSpherical.identity().scale(d5);
    }

    /*
     * WARNING - void declaration
     */
    private final void addMassAt(double x, double y, double z, double addedMass) {
        double[] dArray = new double[9];
        Matrix3d matrix3d = this._momentOfInertiaTensor.transpose(new Matrix3d());
        Intrinsics.checkNotNullExpressionValue((Object)matrix3d, (String)"");
        Cloneable cloneable = matrix3d;
        matrix3d.get(dArray);
        double d2 = this.getMass();
        cloneable = new Vector3d(this.getCenterOfMassInShip());
        if (d2 + addedMass > 1.0E-6) {
            Vector3d vector3d = this.getCenterOfMassInShip().mul(d2, new Vector3d());
            Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"");
            Vector3d vector3d2 = vector3d;
            vector3d.add(x * addedMass, y * addedMass, z * addedMass);
            vector3d2.mul(1.0 / (d2 + addedMass));
            this._centerOfMassInShip.set(vector3d2);
            double d3 = ((Vector3d)cloneable).x - this.getCenterOfMassInShip().x();
            double d4 = ((Vector3d)cloneable).y - this.getCenterOfMassInShip().y();
            double d5 = ((Vector3d)cloneable).z - this.getCenterOfMassInShip().z();
            double d6 = x - this.getCenterOfMassInShip().x();
            double d7 = y - this.getCenterOfMassInShip().y();
            double d8 = z - this.getCenterOfMassInShip().z();
            double d9 = d4;
            double d10 = d5;
            double d11 = d7;
            double d12 = d8;
            dArray[0] = dArray[0] + (d9 * d9 + d10 * d10) * d2 + (d11 * d11 + d12 * d12) * addedMass;
            dArray[1] = dArray[1] - d3 * d4 * d2 - d6 * d7 * addedMass;
            dArray[2] = dArray[2] - d3 * d5 * d2 - d6 * d8 * addedMass;
            dArray[3] = dArray[1];
            double d13 = d3;
            double d14 = d5;
            double d15 = d6;
            double d16 = d8;
            dArray[4] = dArray[4] + (d13 * d13 + d14 * d14) * d2 + (d15 * d15 + d16 * d16) * addedMass;
            dArray[5] = dArray[5] - d4 * d5 * d2 - d7 * d8 * addedMass;
            dArray[6] = dArray[2];
            dArray[7] = dArray[5];
            double d17 = d3;
            double d18 = d4;
            double d19 = d6;
            double d20 = d7;
            dArray[8] = dArray[8] + (d17 * d17 + d18 * d18) * d2 + (d19 * d19 + d20 * d20) * addedMass;
            this._momentOfInertiaTensor.set(dArray).transpose();
            this._mass += addedMass;
        } else {
            void var3_2;
            void var1_1;
            this._centerOfMassInShip.set((double)var1_1, (double)var3_2, z);
            this._momentOfInertiaTensor.zero();
            this._mass = 0.0;
        }
        this.cmChangedThisTick = true;
    }

    /*
     * WARNING - void declaration
     */
    public final ek_0 copyToPhyInertia(double scaling) {
        void var1_1;
        double d2 = this.getMass() * scaling * scaling * scaling;
        double d3 = scaling;
        Matrix3d matrix3d = new Matrix3d(this.momentOfInertiaSpherical).scale(d3 * d3 * scaling * scaling * var1_1);
        Intrinsics.checkNotNullExpressionValue((Object)matrix3d, (String)"");
        return new ek_0(d2, matrix3d, new Vector3d(this.getCenterOfMassInShip()), this.cmChangedThisTick);
    }

    public static /* synthetic */ ek_0 copyToPhyInertia$default(ShipInertiaDataImpl shipInertiaDataImpl, double d2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            d2 = 1.0;
        }
        return shipInertiaDataImpl.copyToPhyInertia(d2);
    }

    private final Vector3d component1() {
        return this._centerOfMassInShip;
    }

    private final double component2() {
        return this._mass;
    }

    private final Matrix3d component3() {
        return this._momentOfInertiaTensor;
    }

    /*
     * WARNING - void declaration
     */
    public final ShipInertiaDataImpl copy(Vector3d _centerOfMassInShip, double _mass, Matrix3d _momentOfInertiaTensor) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)_centerOfMassInShip, (String)"");
        Intrinsics.checkNotNullParameter((Object)_momentOfInertiaTensor, (String)"");
        return new ShipInertiaDataImpl((Vector3d)var1_1, (double)var2_2, _momentOfInertiaTensor);
    }

    public static /* synthetic */ ShipInertiaDataImpl copy$default(ShipInertiaDataImpl shipInertiaDataImpl, Vector3d vector3d, double d2, Matrix3d matrix3d, int n2, Object object) {
        if ((n2 & 1) != 0) {
            vector3d = shipInertiaDataImpl._centerOfMassInShip;
        }
        if ((n2 & 2) != 0) {
            d2 = shipInertiaDataImpl._mass;
        }
        if ((n2 & 4) != 0) {
            matrix3d = shipInertiaDataImpl._momentOfInertiaTensor;
        }
        return shipInertiaDataImpl.copy(vector3d, d2, matrix3d);
    }

    public final String toString() {
        return "ShipInertiaDataImpl(_centerOfMassInShip=" + this._centerOfMassInShip + ", _mass=" + this._mass + ", _momentOfInertiaTensor=" + this._momentOfInertiaTensor + ")";
    }

    public final int hashCode() {
        int n2 = this._centerOfMassInShip.hashCode();
        n2 = n2 * 31 + Double.hashCode(this._mass);
        n2 = n2 * 31 + this._momentOfInertiaTensor.hashCode();
        return n2;
    }

    public final boolean equals(Object other) {
        ShipInertiaDataImpl shipInertiaDataImpl;
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShipInertiaDataImpl)) {
            return false;
        }
        shipInertiaDataImpl = shipInertiaDataImpl;
        if (!Intrinsics.areEqual((Object)this._centerOfMassInShip, (Object)shipInertiaDataImpl._centerOfMassInShip)) {
            return false;
        }
        if (Double.compare(this._mass, shipInertiaDataImpl._mass) != 0) {
            return false;
        }
        return Intrinsics.areEqual((Object)this._momentOfInertiaTensor, (Object)shipInertiaDataImpl._momentOfInertiaTensor);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/ShipInertiaDataImpl$Companion;", "", "Lorg/valkyrienskies/core/impl/game/ships/ShipInertiaDataImpl;", "newEmptyShipInertiaData", "()Lorg/valkyrienskies/core/impl/game/ships/ShipInertiaDataImpl;", "", "EPSILON", "D", "INERTIA_OFFSET", "<init>", "()V"})
    public static final class Companion {
        private Companion() {
        }

        public final ShipInertiaDataImpl newEmptyShipInertiaData() {
            return new ShipInertiaDataImpl(new Vector3d(), 0.0, new Matrix3d());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

