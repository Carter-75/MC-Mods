/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Matrix3dc;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.properties.ShipInertiaData;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Ek
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u00c6\u0003\u00a2\u0006\u0004\b\f\u0010\rJ8\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u000bH\u00c6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017H\u00d6\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aH\u00d6\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0012\u001a\u00020\b8WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\nR\u001a\u0010\u0003\u001a\u00020\b8\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010\nR\u0017\u0010\u0006\u001a\u00020\u000b8\u0007\u00a2\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b\u0012\u0010\rR\u0014\u0010\t\u001a\u00020\u00058WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0007R\u001a\u0010\f\u001a\u00020\u00028\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b#\u0010\u0004R\u001a\u0010&\u001a\u00020\u00058\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010\u0007"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Ek;", "Lorg/valkyrienskies/core/api/ships/properties/ShipInertiaData;", "", "b", "()D", "Lorg/joml/Matrix3dc;", "c", "()Lorg/joml/Matrix3dc;", "Lorg/joml/Vector3dc;", "d", "()Lorg/joml/Vector3dc;", "", "e", "()Z", "p0", "p1", "p2", "p3", "a", "(DLorg/joml/Matrix3dc;Lorg/joml/Vector3dc;Z)Lorg/valkyrienskies/core/impl/shadow/Ek;", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getCenterOfMass", "Lorg/joml/Vector3dc;", "getCenterOfMassInShip", "Z", "getInertiaTensor", "D", "getMass", "Lorg/joml/Matrix3dc;", "getMomentOfInertiaTensor", "f", "<init>", "(DLorg/joml/Matrix3dc;Lorg/joml/Vector3dc;Z)V"})
public final class ek_0
implements ShipInertiaData {
    private final double a;
    private final Matrix3dc b;
    private final Vector3dc c;
    private final boolean d;

    public ek_0(double d2, Matrix3dc matrix3dc, Vector3dc vector3dc, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)matrix3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        this.a = d2;
        this.b = matrix3dc;
        this.c = vector3dc;
        this.d = bl;
    }

    public /* synthetic */ ek_0(double d2, Matrix3dc matrix3dc, Vector3dc vector3dc, boolean bl, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 8) != 0) {
            bl = false;
        }
        this(d2, matrix3dc, vector3dc, bl);
    }

    @Override
    @JvmName(name="getMass")
    public final double getMass() {
        return this.a;
    }

    @Override
    @JvmName(name="getMomentOfInertiaTensor")
    public final Matrix3dc getMomentOfInertiaTensor() {
        return this.b;
    }

    @Override
    @JvmName(name="getCenterOfMassInShip")
    public final Vector3dc getCenterOfMassInShip() {
        return this.c;
    }

    @JvmName(name="a")
    private boolean a() {
        return this.d;
    }

    @Override
    @JvmName(name="getInertiaTensor")
    public final Matrix3dc getInertiaTensor() {
        return this.getMomentOfInertiaTensor();
    }

    @Override
    @JvmName(name="getCenterOfMass")
    public final Vector3dc getCenterOfMass() {
        return this.getCenterOfMassInShip();
    }

    private double b() {
        return this.a;
    }

    private Matrix3dc c() {
        return this.b;
    }

    private Vector3dc d() {
        return this.c;
    }

    private boolean e() {
        return this.d;
    }

    private static ek_0 a(double d2, Matrix3dc matrix3dc, Vector3dc vector3dc, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)matrix3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        return new ek_0(d2, matrix3dc, vector3dc, bl);
    }

    private static /* synthetic */ ek_0 a$default(ek_0 object, double d2, Matrix3dc matrix3dc, Vector3dc vector3dc, boolean bl, int n2) {
        if ((n2 & 1) != 0) {
            d2 = ((ek_0)object).a;
        }
        if ((n2 & 2) != 0) {
            matrix3dc = ((ek_0)object).b;
        }
        if ((n2 & 4) != 0) {
            vector3dc = ((ek_0)object).c;
        }
        if ((n2 & 8) != 0) {
            bl = ((ek_0)object).d;
        }
        boolean bl2 = bl;
        Vector3dc vector3dc2 = vector3dc;
        object = matrix3dc;
        double d3 = d2;
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc2, (String)"");
        return new ek_0(d3, (Matrix3dc)object, vector3dc2, bl2);
    }

    public final String toString() {
        return "PhysInertia(mass=" + this.a + ", momentOfInertiaTensor=" + this.b + ", centerOfMassInShip=" + this.c + ", cmChangedThisTick=" + this.d + ")";
    }

    public final int hashCode() {
        int n2 = Double.hashCode(this.a);
        n2 = n2 * 31 + this.b.hashCode();
        n2 = n2 * 31 + this.c.hashCode();
        n2 = n2 * 31 + Boolean.hashCode(this.d);
        return n2;
    }

    public final boolean equals(Object other) {
        ek_0 ek_02;
        if (this == other) {
            return true;
        }
        if (!(other instanceof ek_0)) {
            return false;
        }
        ek_02 = ek_02;
        if (Double.compare(this.a, ek_02.a) != 0) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.b, (Object)ek_02.b)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.c, (Object)ek_02.c)) {
            return false;
        }
        return this.d == ek_02.d;
    }
}

