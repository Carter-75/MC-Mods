/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.valkyrienskies.core.impl.shadow.De
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.impl.shadow.De;
import org.valkyrienskies.core.impl.shadow.da_0;
import org.valkyrienskies.core.impl.shadow.df_0;
import org.valkyrienskies.core.impl.shadow.dl_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.De
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bH\u00c6\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0010H\u00d6\u0003\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013H\u00d6\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016H\u00d6\u0001\u00a2\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u000e\u001a\u00020\u00058\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000e\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004\"\u0004\b\u000e\u0010\u001fR\"\u0010\u0019\u001a\u00020\b8\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\n\"\u0004\b\u000e\u0010#R\u0014\u0010 \u001a\u00020$8WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010%R\u0014\u0010\u001e\u001a\u00020\u00028WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u0004R\u0014\u0010\"\u001a\u00020\b8WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010\n"}, d2={"Lorg/valkyrienskies/core/impl/shadow/De;", "Lorg/valkyrienskies/core/impl/shadow/Df;", "", "g", "()Z", "Lorg/joml/Vector3d;", "h", "()Lorg/joml/Vector3d;", "", "i", "()D", "p0", "p1", "p2", "a", "(ZLorg/joml/Vector3d;D)Lorg/valkyrienskies/core/impl/shadow/De;", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "c", "Lorg/joml/Vector3d;", "(Lorg/joml/Vector3d;)V", "b", "Z", "e", "(Z)V", "d", "D", "f", "(D)V", "Lorg/joml/Vector3dc;", "()Lorg/joml/Vector3dc;", "<init>", "(ZLorg/joml/Vector3d;D)V"})
public final class de_0
implements df_0 {
    public static final a a = new a(null);
    boolean b;
    Vector3d c;
    double d;

    public de_0(boolean bl, Vector3d vector3d, double d2) {
        Intrinsics.checkNotNullParameter((Object)vector3d, (String)"");
        this.b = bl;
        this.c = vector3d;
        this.d = d2;
    }

    @JvmName(name="e")
    private boolean e() {
        return this.b;
    }

    @JvmName(name="a")
    public final void a(boolean bl) {
        this.b = bl;
    }

    @JvmName(name="a")
    public final Vector3d a() {
        return this.c;
    }

    @JvmName(name="a")
    private void a(Vector3d vector3d) {
        Intrinsics.checkNotNullParameter((Object)vector3d, (String)"");
        this.c = vector3d;
    }

    @JvmName(name="f")
    private double f() {
        return this.d;
    }

    @JvmName(name="a")
    public final void a(double d2) {
        this.d = d2;
    }

    @Override
    @JvmName(name="b")
    public final boolean b() {
        return this.b;
    }

    @Override
    @JvmName(name="c")
    public final Vector3dc c() {
        de_0 de_02 = this;
        if (de_02.b) {
            throw new da_0("Cannot access collisionAxis because we are colliding!");
        }
        if (this.d == Double.POSITIVE_INFINITY) {
            throw new dl_0("Cannot access collisionAxis because we will never collide!");
        }
        return this.c;
    }

    @Override
    @JvmName(name="d")
    public final double d() {
        de_0 de_02 = this;
        if (de_02.b) {
            throw new da_0("Cannot access timeToCollision because we are colliding!");
        }
        return this.d;
    }

    private boolean g() {
        return this.b;
    }

    private Vector3d h() {
        return this.c;
    }

    private double i() {
        return this.d;
    }

    private static de_0 a(boolean bl, Vector3d vector3d, double d2) {
        Intrinsics.checkNotNullParameter((Object)vector3d, (String)"");
        return new de_0(bl, vector3d, d2);
    }

    private static /* synthetic */ de_0 a$default(de_0 de_02, boolean bl, Vector3d vector3d, double d2, int n2) {
        if ((n2 & 1) != 0) {
            bl = de_02.b;
        }
        if ((n2 & 2) != 0) {
            vector3d = de_02.c;
        }
        if ((n2 & 4) != 0) {
            d2 = de_02.d;
        }
        double d3 = d2;
        Vector3d vector3d2 = vector3d;
        boolean bl2 = bl;
        Intrinsics.checkNotNullParameter((Object)vector3d2, (String)"");
        return new de_0(bl2, vector3d2, d3);
    }

    public final String toString() {
        return "CollisionResultTimeToCollision(_initiallyColliding=" + this.b + ", _collisionAxis=" + this.c + ", _timeToCollision=" + this.d + ")";
    }

    public final int hashCode() {
        int n2 = Boolean.hashCode(this.b);
        n2 = n2 * 31 + this.c.hashCode();
        n2 = n2 * 31 + Double.hashCode(this.d);
        return n2;
    }

    public final boolean equals(Object other) {
        de_0 de_02;
        if (this == other) {
            return true;
        }
        if (!(other instanceof de_0)) {
            return false;
        }
        de_02 = de_02;
        if (this.b != de_02.b) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.c, (Object)de_02.c)) {
            return false;
        }
        return Double.compare(this.d, de_02.d) == 0;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2={"Lorg/valkyrienskies/core/impl/shadow/De$a;", "", "Lorg/valkyrienskies/core/impl/shadow/De;", "a", "()Lorg/valkyrienskies/core/impl/shadow/De;", "<init>", "()V"})
    public static final class a {
        private a() {
        }

        public static de_0 a() {
            return new De(false, new Vector3d(), Double.POSITIVE_INFINITY);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

