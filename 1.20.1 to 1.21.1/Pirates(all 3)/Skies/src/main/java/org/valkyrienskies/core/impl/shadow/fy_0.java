/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  org.valkyrienskies.core.impl.shadow.Fy
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.valkyrienskies.core.impl.shadow.Fy;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Fy
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u0000 \t2\u00020\u0001:\u0001\tB!\b\u0000\u0012\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0005J,\u0010\t\u001a\u00020\u00002\f\b\u0002\u0010\u0007\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\b\u001a\u00060\u0002j\u0002`\u0003H\u00c6\u0001\u00a2\u0006\u0004\b\t\u0010\nJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u001b\u0010\t\u001a\u00060\u0002j\u0002`\u00038\u0007\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\t\u0010\u0005R\u001b\u0010\u0014\u001a\u00060\u0002j\u0002`\u00038\u0007\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0014\u0010\u0005"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Fy;", "", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "c", "()J", "d", "p0", "p1", "a", "(JJ)Lorg/valkyrienskies/core/impl/shadow/Fy;", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "b", "J", "<init>", "(JJ)V"})
public final class fy_0 {
    public static final a a = new a(null);
    final long b;
    final long c;

    public fy_0(long l2, long l3) {
        this.b = l2;
        this.c = l3;
    }

    @JvmName(name="a")
    public final long a() {
        return this.b;
    }

    @JvmName(name="b")
    public final long b() {
        return this.c;
    }

    public final long c() {
        return this.b;
    }

    public final long d() {
        return this.c;
    }

    private static fy_0 a(long l2, long l3) {
        return new fy_0(l2, l3);
    }

    private static /* synthetic */ fy_0 a$default(fy_0 fy_02, long l2, long l3, int n2) {
        if ((n2 & 1) != 0) {
            l2 = fy_02.b;
        }
        if ((n2 & 2) != 0) {
            l3 = fy_02.c;
        }
        long l4 = l3;
        long l5 = l2;
        return new fy_0(l5, l4);
    }

    public final String toString() {
        return "DisabledCollisionPair(ship0Id=" + this.b + ", ship1Id=" + this.c + ")";
    }

    public final int hashCode() {
        int n2 = Long.hashCode(this.b);
        n2 = n2 * 31 + Long.hashCode(this.c);
        return n2;
    }

    public final boolean equals(Object other) {
        fy_0 fy_02;
        if (this == other) {
            return true;
        }
        if (!(other instanceof fy_0)) {
            return false;
        }
        fy_02 = fy_02;
        if (this.b != fy_02.b) {
            return false;
        }
        return this.c == fy_02.c;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ'\u0010\u0007\u001a\u00020\u00062\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u0003H\u0000\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Fy$a;", "", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "p0", "p1", "Lorg/valkyrienskies/core/impl/shadow/Fy;", "a", "(JJ)Lorg/valkyrienskies/core/impl/shadow/Fy;", "<init>", "()V"})
    public static final class a {
        private a() {
        }

        private static fy_0 a(long l2, long l3) {
            if (l2 < l3) {
                return new Fy(l2, l3);
            }
            return new Fy(l3, l2);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

