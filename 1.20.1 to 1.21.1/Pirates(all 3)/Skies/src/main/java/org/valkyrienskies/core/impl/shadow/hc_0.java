/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.valkyrienskies.core.impl.shadow.Hc
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Matrix4d;
import org.joml.Matrix4dc;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.impl.shadow.Hc;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Hc
 */
@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\u0004J8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013H\u00d6\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0017\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001a\u0010\u0018J\u001d\u0010\u001a\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001a\u0010\u0019J\u0010\u0010\u001c\u001a\u00020\u001bH\u00d6\u0001\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001e\u0010\u0018J\u001d\u0010\u001e\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001e\u0010\u0019J\u0015\u0010\u000e\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u0016\u00a2\u0006\u0004\b\u000e\u0010\u0018J\u001d\u0010\u000e\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0016\u00a2\u0006\u0004\b\u000e\u0010\u0019R\u0014\u0010\u000e\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010 R\u0017\u0010\u001a\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u0017\u0010\u0004R\u0017\u0010\u001e\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\u001a\u0010\"\u001a\u0004\b\u000e\u0010\u0004R\u0017\u0010\u0017\u001a\u00020\u00058\u0007\u00a2\u0006\f\n\u0004\b\u001e\u0010#\u001a\u0004\b\u001a\u0010\u0007R\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010 R\u0017\u0010\u0003\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\u0017\u0010\"\u001a\u0004\b\u001e\u0010\u0004"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Hc;", "", "Lorg/joml/Vector3dc;", "f", "()Lorg/joml/Vector3dc;", "Lorg/joml/Quaterniondc;", "g", "()Lorg/joml/Quaterniondc;", "h", "i", "p0", "p1", "p2", "p3", "a", "(Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/impl/shadow/Hc;", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lorg/joml/Vector3d;", "d", "(Lorg/joml/Vector3d;)Lorg/joml/Vector3d;", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3d;)Lorg/joml/Vector3d;", "b", "", "toString", "()Ljava/lang/String;", "c", "Lorg/joml/Matrix4dc;", "Lorg/joml/Matrix4dc;", "e", "Lorg/joml/Vector3dc;", "Lorg/joml/Quaterniondc;", "<init>", "(Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)V"})
public final class hc_0 {
    public static final a a = new a(null);
    public final Vector3dc b;
    public final Quaterniondc c;
    public final Vector3dc d;
    public final Vector3dc e;
    private final Matrix4dc f;
    private final Matrix4dc g;
    private static final hc_0 h = new hc_0(new Vector3d(), new Quaterniond(), new Vector3d(), new Vector3d());

    public hc_0(Vector3dc object, Quaterniondc quaterniondc, Vector3dc vector3dc, Vector3dc vector3dc2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Intrinsics.checkNotNullParameter((Object)quaterniondc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc2, (String)"");
        this.b = object;
        this.c = quaterniondc;
        this.d = vector3dc;
        this.e = vector3dc2;
        object = new Matrix4d().translate(this.b).rotate(this.c);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"");
        this.f = (Matrix4dc)object;
        object = new Matrix4d().rotate(this.c.conjugate(new Quaterniond())).translate(-this.b.x(), -this.b.y(), -this.b.z());
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"");
        this.g = (Matrix4dc)object;
    }

    @JvmName(name="a")
    public final Vector3dc a() {
        return this.b;
    }

    @JvmName(name="b")
    public final Quaterniondc b() {
        return this.c;
    }

    @JvmName(name="c")
    public final Vector3dc c() {
        return this.d;
    }

    @JvmName(name="d")
    public final Vector3dc d() {
        return this.e;
    }

    public final Vector3d a(Vector3dc vector3dc, Vector3d vector3d) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3d, (String)"");
        vector3d.set(vector3dc);
        if (this == h) {
            return vector3d;
        }
        vector3dc = this.f.transformPosition(vector3d);
        Intrinsics.checkNotNullExpressionValue((Object)vector3dc, (String)"");
        return vector3dc;
    }

    private Vector3d b(Vector3dc vector3dc, Vector3d vector3d) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3d, (String)"");
        vector3d.set(vector3dc);
        if (this == h) {
            return vector3d;
        }
        vector3dc = this.g.transformPosition(vector3d);
        Intrinsics.checkNotNullExpressionValue((Object)vector3dc, (String)"");
        return vector3dc;
    }

    private Vector3d c(Vector3dc vector3dc, Vector3d vector3d) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3d, (String)"");
        vector3d.set(vector3dc);
        if (this == h) {
            return vector3d;
        }
        vector3dc = this.f.transformDirection(vector3d);
        Intrinsics.checkNotNullExpressionValue((Object)vector3dc, (String)"");
        return vector3dc;
    }

    private Vector3d d(Vector3dc vector3dc, Vector3d vector3d) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3d, (String)"");
        vector3d.set(vector3dc);
        if (this == h) {
            return vector3d;
        }
        vector3dc = this.g.transformDirection(vector3d);
        Intrinsics.checkNotNullExpressionValue((Object)vector3dc, (String)"");
        return vector3dc;
    }

    private Vector3d a(Vector3d vector3d) {
        Intrinsics.checkNotNullParameter((Object)vector3d, (String)"");
        return this.a(vector3d, vector3d);
    }

    private Vector3d b(Vector3d object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Vector3d vector3d = object;
        Vector3dc vector3dc = (Vector3dc)object;
        object = this;
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3d, (String)"");
        vector3d.set(vector3dc);
        if (object == h) {
            return vector3d;
        }
        object = ((hc_0)object).g.transformPosition(vector3d);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"");
        return object;
    }

    private Vector3d c(Vector3d object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Vector3d vector3d = object;
        Vector3dc vector3dc = (Vector3dc)object;
        object = this;
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3d, (String)"");
        vector3d.set(vector3dc);
        if (object == h) {
            return vector3d;
        }
        object = ((hc_0)object).f.transformDirection(vector3d);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"");
        return object;
    }

    private Vector3d d(Vector3d object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Vector3d vector3d = object;
        Vector3dc vector3dc = (Vector3dc)object;
        object = this;
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3d, (String)"");
        vector3d.set(vector3dc);
        if (object == h) {
            return vector3d;
        }
        object = ((hc_0)object).g.transformDirection(vector3d);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"");
        return object;
    }

    private Vector3dc f() {
        return this.b;
    }

    private Quaterniondc g() {
        return this.c;
    }

    private Vector3dc h() {
        return this.d;
    }

    private Vector3dc i() {
        return this.e;
    }

    private static hc_0 a(Vector3dc vector3dc, Quaterniondc quaterniondc, Vector3dc vector3dc2, Vector3dc vector3dc3) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)quaterniondc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc2, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc3, (String)"");
        return new hc_0(vector3dc, quaterniondc, vector3dc2, vector3dc3);
    }

    private static /* synthetic */ hc_0 a$default(hc_0 object, Vector3dc object2, Quaterniondc object3, Vector3dc vector3dc, Vector3dc vector3dc2, int n2) {
        if ((n2 & 1) != 0) {
            object2 = ((hc_0)object).b;
        }
        if ((n2 & 2) != 0) {
            object3 = ((hc_0)object).c;
        }
        if ((n2 & 4) != 0) {
            vector3dc = ((hc_0)object).d;
        }
        if ((n2 & 8) != 0) {
            vector3dc2 = ((hc_0)object).e;
        }
        Vector3dc vector3dc3 = object2;
        Quaterniondc quaterniondc = object3;
        Vector3dc vector3dc4 = vector3dc;
        vector3dc = vector3dc2;
        object3 = vector3dc4;
        object2 = quaterniondc;
        object = vector3dc3;
        Intrinsics.checkNotNullParameter((Object)vector3dc3, (String)"");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        Intrinsics.checkNotNullParameter((Object)object3, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        return new hc_0((Vector3dc)object, (Quaterniondc)object2, (Vector3dc)object3, vector3dc);
    }

    public final String toString() {
        return "Hc(c=" + this.b + ", d=" + this.c + ", f=" + this.d + ", b=" + this.e + ')';
    }

    public final int hashCode() {
        int n2 = this.b.hashCode();
        n2 = n2 * 31 + this.c.hashCode();
        n2 = n2 * 31 + this.d.hashCode();
        n2 = n2 * 31 + this.e.hashCode();
        return n2;
    }

    public final boolean equals(Object other) {
        hc_0 hc_02;
        if (this == other) {
            return true;
        }
        if (!(other instanceof hc_0)) {
            return false;
        }
        hc_02 = hc_02;
        if (!Intrinsics.areEqual((Object)this.b, (Object)hc_02.b)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.c, (Object)hc_02.c)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.d, (Object)hc_02.d)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.e, (Object)hc_02.e);
    }

    public static final /* synthetic */ hc_0 e() {
        return h;
    }

    @Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0007\u001a\u00020\u00068\u0007\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\u000b"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Hc$a;", "", "Lorg/joml/Vector3dc;", "p0", "Lorg/joml/Quaterniondc;", "p1", "Lorg/valkyrienskies/core/impl/shadow/Hc;", "a", "(Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;)Lorg/valkyrienskies/core/impl/shadow/Hc;", "h", "Lorg/valkyrienskies/core/impl/shadow/Hc;", "()Lorg/valkyrienskies/core/impl/shadow/Hc;", "<init>", "()V"})
    public static final class a {
        private a() {
        }

        @JvmName(name="a")
        public static hc_0 a() {
            return Hc.e();
        }

        public static hc_0 a(Vector3dc vector3dc, Quaterniondc quaterniondc) {
            Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
            Intrinsics.checkNotNullParameter((Object)quaterniondc, (String)"");
            return new Hc(vector3dc, quaterniondc, (Vector3dc)new Vector3d(), (Vector3dc)new Vector3d());
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

