/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.valkyrienskies.core.impl.shadow.Dh
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3dc;
import org.joml.primitives.AABBdc;
import org.valkyrienskies.core.impl.shadow.Dh;
import org.valkyrienskies.core.internal.collision.VsiConvexPolygonc;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Dh
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u000e\b\u0016\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B=\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u001c\u0010\r\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00118WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00118WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0019\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f8WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Dh;", "Lorg/valkyrienskies/core/internal/collision/VsiConvexPolygonc;", "Lorg/joml/primitives/AABBdc;", "e", "Lorg/joml/primitives/AABBdc;", "a", "", "Lorg/joml/Vector3dc;", "c", "Ljava/util/List;", "b", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "d", "Ljava/lang/Long;", "getAabb", "()Lorg/joml/primitives/AABBdc;", "", "getNormals", "()Ljava/lang/Iterable;", "f", "getPoints", "g", "getShipFrom", "()Ljava/lang/Long;", "h", "p0", "p1", "p2", "p3", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Lorg/joml/primitives/AABBdc;)V"})
public class dh_0
implements VsiConvexPolygonc {
    public static final a a = new a(null);
    private final List<Vector3dc> b;
    private final List<Vector3dc> c;
    private final Long d;
    private final AABBdc e;

    public dh_0(List<? extends Vector3dc> list, List<? extends Vector3dc> list2, Long l2, AABBdc aABBdc) {
        Intrinsics.checkNotNullParameter(list, (String)"");
        Intrinsics.checkNotNullParameter(list2, (String)"");
        Intrinsics.checkNotNullParameter((Object)aABBdc, (String)"");
        this.b = list;
        this.c = list2;
        this.d = l2;
        this.e = aABBdc;
    }

    public /* synthetic */ dh_0(List list, List list2, Long l2, AABBdc aABBdc, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 4) != 0) {
            l2 = null;
        }
        this(list, list2, l2, aABBdc);
    }

    @Override
    @JvmName(name="getPoints")
    public Iterable<Vector3dc> getPoints() {
        return this.b;
    }

    @Override
    @JvmName(name="getNormals")
    public Iterable<Vector3dc> getNormals() {
        return this.c;
    }

    @Override
    @JvmName(name="getShipFrom")
    public Long getShipFrom() {
        return this.d;
    }

    @Override
    @JvmName(name="getAabb")
    public AABBdc getAabb() {
        return this.e;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ1\u0010\t\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\t\u0010\n"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Dh$a;", "", "", "Lorg/joml/Vector3dc;", "p0", "p1", "Lorg/joml/primitives/AABBdc;", "p2", "Lorg/valkyrienskies/core/impl/shadow/Dh;", "a", "(Ljava/util/List;Ljava/util/List;Lorg/joml/primitives/AABBdc;)Lorg/valkyrienskies/core/impl/shadow/Dh;", "<init>", "()V"})
    public static final class a {
        private a() {
        }

        private static dh_0 a(List<? extends Vector3dc> list, List<? extends Vector3dc> list2, AABBdc aABBdc) {
            Intrinsics.checkNotNullParameter(list, (String)"");
            Intrinsics.checkNotNullParameter(list2, (String)"");
            Intrinsics.checkNotNullParameter((Object)aABBdc, (String)"");
            return new Dh(list, list2, null, aABBdc);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

