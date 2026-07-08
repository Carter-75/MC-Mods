/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.api_impl.physics;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.physics.ContactPoint;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\u0004J8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u00d6\u0003\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015H\u00d6\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000b\u001a\u00020\u00028\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u001b\u001a\u0004\b\u001d\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00068\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010\bR\u001a\u0010\r\u001a\u00020\u00028\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b \u0010\u0004"}, d2={"Lorg/valkyrienskies/core/impl/api_impl/physics/ContactPointImpl;", "Lorg/valkyrienskies/core/api/physics/ContactPoint;", "Lorg/joml/Vector3dc;", "component1", "()Lorg/joml/Vector3dc;", "component2", "", "component3", "()F", "component4", "position", "normal", "separation", "velocity", "copy", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;FLorg/joml/Vector3dc;)Lorg/valkyrienskies/core/impl/api_impl/physics/ContactPointImpl;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/joml/Vector3dc;", "getNormal", "getPosition", "F", "getSeparation", "getVelocity", "<init>", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;FLorg/joml/Vector3dc;)V"})
public final class ContactPointImpl
implements ContactPoint {
    private final Vector3dc position;
    private final Vector3dc normal;
    private final float separation;
    private final Vector3dc velocity;

    /*
     * WARNING - void declaration
     */
    public ContactPointImpl(Vector3dc position, Vector3dc normal, float separation, Vector3dc velocity) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)position, (String)"");
        Intrinsics.checkNotNullParameter((Object)normal, (String)"");
        Intrinsics.checkNotNullParameter((Object)velocity, (String)"");
        this.position = var1_1;
        this.normal = var2_2;
        this.separation = var3_3;
        this.velocity = velocity;
    }

    @Override
    @JvmName(name="getPosition")
    public final Vector3dc getPosition() {
        return this.position;
    }

    @Override
    @JvmName(name="getNormal")
    public final Vector3dc getNormal() {
        return this.normal;
    }

    @Override
    @JvmName(name="getSeparation")
    public final float getSeparation() {
        return this.separation;
    }

    @Override
    @JvmName(name="getVelocity")
    public final Vector3dc getVelocity() {
        return this.velocity;
    }

    public final String toString() {
        return "ContactPoint(position=" + this.getPosition() + ", normal=" + this.getNormal() + ", separation=" + this.getSeparation() + ", velocity=" + this.getVelocity() + ")";
    }

    public final Vector3dc component1() {
        return this.position;
    }

    public final Vector3dc component2() {
        return this.normal;
    }

    public final float component3() {
        return this.separation;
    }

    public final Vector3dc component4() {
        return this.velocity;
    }

    /*
     * WARNING - void declaration
     */
    public final ContactPointImpl copy(Vector3dc position, Vector3dc normal, float separation, Vector3dc velocity) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)position, (String)"");
        Intrinsics.checkNotNullParameter((Object)normal, (String)"");
        Intrinsics.checkNotNullParameter((Object)velocity, (String)"");
        return new ContactPointImpl((Vector3dc)var1_1, (Vector3dc)var2_2, (float)var3_3, velocity);
    }

    public static /* synthetic */ ContactPointImpl copy$default(ContactPointImpl contactPointImpl, Vector3dc vector3dc, Vector3dc vector3dc2, float f2, Vector3dc vector3dc3, int n2, Object object) {
        if ((n2 & 1) != 0) {
            vector3dc = contactPointImpl.position;
        }
        if ((n2 & 2) != 0) {
            vector3dc2 = contactPointImpl.normal;
        }
        if ((n2 & 4) != 0) {
            f2 = contactPointImpl.separation;
        }
        if ((n2 & 8) != 0) {
            vector3dc3 = contactPointImpl.velocity;
        }
        return contactPointImpl.copy(vector3dc, vector3dc2, f2, vector3dc3);
    }

    public final int hashCode() {
        int n2 = this.position.hashCode();
        n2 = n2 * 31 + this.normal.hashCode();
        n2 = n2 * 31 + Float.hashCode(this.separation);
        n2 = n2 * 31 + this.velocity.hashCode();
        return n2;
    }

    public final boolean equals(Object other) {
        ContactPointImpl contactPointImpl;
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContactPointImpl)) {
            return false;
        }
        contactPointImpl = contactPointImpl;
        if (!Intrinsics.areEqual((Object)this.position, (Object)contactPointImpl.position)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.normal, (Object)contactPointImpl.normal)) {
            return false;
        }
        if (Float.compare(this.separation, contactPointImpl.separation) != 0) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.velocity, (Object)contactPointImpl.velocity);
    }
}

