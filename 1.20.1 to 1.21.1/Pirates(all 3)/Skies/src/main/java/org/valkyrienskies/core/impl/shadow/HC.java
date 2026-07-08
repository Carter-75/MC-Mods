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
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3ic;
import org.joml.primitives.AABBi;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.impl.shadow.GU;
import org.valkyrienskies.core.impl.shadow.hl_0;
import org.valkyrienskies.core.impl.shadow.ig_0;
import org.valkyrienskies.physics_api_krunch.voxel.KrunchUnsafeVoxelChunk16Reference;
import org.valkyrienskies.physics_api_krunch.voxel.KrunchVoxelChunk16;

@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001b\u001a\u00020\n\u0012\u0006\u0010\u001c\u001a\u00020\r\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0016\u00a2\u0006\u0004\bD\u0010EJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\bJ\u0010\u0010\u000b\u001a\u00020\nH\u00c6\u0003\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH\u00c2\u0003\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010H\u00c6\u0003\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013H\u00c6\u0003\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016H\u00c6\u0003\u00a2\u0006\u0004\b\u0017\u0010\u0018JV\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\u00102\b\b\u0002\u0010\u001e\u001a\u00020\u00132\b\b\u0002\u0010\u001f\u001a\u00020\u0016H\u00c6\u0001\u00a2\u0006\u0004\b\u0003\u0010 J)\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0016\u00a2\u0006\u0004\b\"\u0010#J'\u0010$\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0016\u00a2\u0006\u0004\b$\u0010%J)\u0010&\u001a\u0004\u0018\u00010!2\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0016\u00a2\u0006\u0004\b&\u0010#J\u001a\u0010(\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010'H\u00d6\u0003\u00a2\u0006\u0004\b(\u0010)J\u000f\u0010\"\u001a\u00020\rH\u0016\u00a2\u0006\u0004\b\"\u0010\u000fJ)\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0016\u00a2\u0006\u0004\b+\u0010,J\u0017\u0010\u0003\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020-H\u0016\u00a2\u0006\u0004\b\u0003\u0010.J\u0010\u0010/\u001a\u00020\u0013H\u00d6\u0001\u00a2\u0006\u0004\b/\u0010\u0015J'\u00100\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0016\u00a2\u0006\u0004\b0\u0010%J)\u0010\u0003\u001a\u0004\u0018\u00010!2\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0016\u00a2\u0006\u0004\b\u0003\u0010#J/\u00100\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020!H\u0016\u00a2\u0006\u0004\b0\u00101J1\u0010\u0003\u001a\u0004\u0018\u00010!2\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020!H\u0016\u00a2\u0006\u0004\b\u0003\u00102J\u000f\u00103\u001a\u00020\u0010H\u0016\u00a2\u0006\u0004\b3\u0010\u0012J?\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0013H\u0016\u00a2\u0006\u0004\b\u0003\u00104J\u0010\u00106\u001a\u000205H\u00d6\u0001\u00a2\u0006\u0004\b6\u00107J'\u00108\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0016\u00a2\u0006\u0004\b8\u00109R\u0016\u0010\u0003\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\"\u00100\u001a\u00020\u00108\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010;\u001a\u0004\b&\u0010\u0012\"\u0004\b\u0003\u0010<R\u0014\u0010&\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010=R\u0017\u0010$\u001a\u00020\u00068\u0007\u00a2\u0006\f\n\u0004\b0\u0010>\u001a\u0004\b:\u0010\bR\u0017\u0010\"\u001a\u00020\u00068\u0007\u00a2\u0006\f\n\u0004\b\u0003\u0010>\u001a\u0004\b+\u0010\bR\u0017\u00108\u001a\u00020\n8\u0007\u00a2\u0006\f\n\u0004\b&\u0010?\u001a\u0004\b@\u0010\fR\u001a\u0010+\u001a\u00020\u00138\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b8\u0010A\u001a\u0004\b$\u0010\u0015R\"\u0010:\u001a\u00020\u00168\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010B\u001a\u0004\b8\u0010\u0018\"\u0004\b\u0003\u0010C"}, d2={"Lorg/valkyrienskies/core/impl/shadow/HC;", "Lorg/valkyrienskies/core/impl/shadow/Hl;", "", "a", "()V", "close", "Lorg/joml/Vector3ic;", "j", "()Lorg/joml/Vector3ic;", "k", "Lorg/joml/primitives/AABBic;", "l", "()Lorg/joml/primitives/AABBic;", "Lorg/valkyrienskies/core/impl/shadow/GU;", "m", "()Lorg/valkyrienskies/core/impl/shadow/GU;", "", "n", "()Z", "", "o", "()I", "Lorg/joml/Vector3dc;", "p", "()Lorg/joml/Vector3dc;", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "(Lorg/joml/Vector3ic;Lorg/joml/Vector3ic;Lorg/joml/primitives/AABBic;Lorg/valkyrienskies/core/impl/shadow/GU;ZILorg/joml/Vector3dc;)Lorg/valkyrienskies/core/impl/shadow/HC;", "Lorg/valkyrienskies/core/impl/shadow/Ig;", "e", "(III)Lorg/valkyrienskies/physics_api_krunch/voxel/KrunchVoxelChunk16;", "d", "(III)V", "c", "", "equals", "(Ljava/lang/Object;)Z", "Lorg/valkyrienskies/core/impl/shadow/If;", "g", "(III)Lorg/valkyrienskies/physics_api_krunch/voxel/KrunchUnsafeVoxelChunk16Reference;", "Lorg/joml/primitives/AABBi;", "(Lorg/joml/primitives/AABBi;)Z", "hashCode", "b", "(IIILorg/valkyrienskies/core/impl/shadow/Ig;)V", "(IIILorg/valkyrienskies/core/impl/shadow/Ig;)Lorg/valkyrienskies/physics_api_krunch/voxel/KrunchVoxelChunk16;", "i_", "(IIIIII)V", "", "toString", "()Ljava/lang/String;", "f", "(III)Z", "h", "Z", "(Z)V", "Lorg/valkyrienskies/core/impl/shadow/GU;", "Lorg/joml/Vector3ic;", "Lorg/joml/primitives/AABBic;", "i", "I", "Lorg/joml/Vector3dc;", "(Lorg/joml/Vector3dc;)V", "<init>", "(Lorg/joml/Vector3ic;Lorg/joml/Vector3ic;Lorg/joml/primitives/AABBic;Lorg/valkyrienskies/core/impl/shadow/GU;ZILorg/joml/Vector3dc;)V"})
public final class HC
implements hl_0 {
    private final Vector3ic a;
    private final Vector3ic b;
    private final AABBic c;
    private final GU d;
    private boolean e;
    private final int f;
    private Vector3dc g;
    private boolean h;

    private HC(Vector3ic vector3ic, Vector3ic vector3ic2, AABBic aABBic, GU gU, boolean bl, int n2, Vector3dc vector3dc) {
        Intrinsics.checkNotNullParameter((Object)vector3ic, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3ic2, (String)"");
        Intrinsics.checkNotNullParameter((Object)aABBic, (String)"");
        Intrinsics.checkNotNullParameter((Object)gU, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        this.a = vector3ic;
        this.b = vector3ic2;
        this.c = aABBic;
        this.d = gU;
        this.e = bl;
        this.f = n2;
        this.g = vector3dc;
        this.h = true;
    }

    public /* synthetic */ HC(Vector3ic vector3ic, Vector3ic vector3ic2, AABBic aABBic, GU gU, boolean bl, int n2, Vector3dc vector3dc, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 0x10) != 0) {
            bl = false;
        }
        if ((n3 & 0x20) != 0) {
            n2 = 0;
        }
        if ((n3 & 0x40) != 0) {
            vector3dc = new Vector3d();
        }
        this(vector3ic, vector3ic2, aABBic, gU, bl, n2, vector3dc);
    }

    @JvmName(name="g")
    private Vector3ic g() {
        return this.a;
    }

    @JvmName(name="h")
    private Vector3ic h() {
        return this.b;
    }

    @JvmName(name="i")
    private AABBic i() {
        return this.c;
    }

    @Override
    @JvmName(name="c")
    public final boolean c() {
        return this.e;
    }

    @Override
    @JvmName(name="a")
    public final void a(boolean bl) {
        this.e = bl;
    }

    @Override
    @JvmName(name="d")
    public final int d() {
        return this.f;
    }

    @Override
    @JvmName(name="f")
    public final Vector3dc f() {
        return this.g;
    }

    @Override
    @JvmName(name="a")
    public final void a(Vector3dc vector3dc) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        this.g = vector3dc;
    }

    @Override
    public final KrunchVoxelChunk16 a(int n2, int n3, int n4, ig_0 ig_02) {
        Intrinsics.checkNotNullParameter((Object)ig_02, (String)"");
        this.h = false;
        return null;
    }

    @Override
    public final void b(int n2, int n3, int n4, ig_0 ig_02) {
        Intrinsics.checkNotNullParameter((Object)ig_02, (String)"");
        this.h = false;
    }

    @Override
    public final KrunchVoxelChunk16 a(int n2, int n3, int n4) {
        this.h = false;
        return null;
    }

    @Override
    public final void b(int n2, int n3, int n4) {
        this.h = false;
    }

    @Override
    public final KrunchVoxelChunk16 c(int n2, int n3, int n4) {
        this.h = false;
        return null;
    }

    @Override
    public final void d(int n2, int n3, int n4) {
        this.h = false;
    }

    @Override
    public final void a() {
        this.h = true;
    }

    @Override
    public final boolean i_() {
        return this.h;
    }

    @Override
    public final KrunchVoxelChunk16 e(int n2, int n3, int n4) {
        return null;
    }

    @Override
    public final boolean f(int n2, int n3, int n4) {
        return true;
    }

    @Override
    public final KrunchUnsafeVoxelChunk16Reference g(int n2, int n3, int n4) {
        return null;
    }

    @Override
    public final void a(int n2, int n3, int n4, int n5, int n6, int n7) {
    }

    @Override
    public final boolean a(AABBi aABBi) {
        Intrinsics.checkNotNullParameter((Object)aABBi, (String)"");
        aABBi.setMin(0, 0, 0);
        aABBi.setMax(0, 0, 0);
        return true;
    }

    @Override
    public final GU e() {
        return this.d;
    }

    @Override
    public final void close() {
    }

    private Vector3ic j() {
        return this.a;
    }

    private Vector3ic k() {
        return this.b;
    }

    private AABBic l() {
        return this.c;
    }

    private final GU m() {
        return this.d;
    }

    private boolean n() {
        HC hC = this;
        return hC.e;
    }

    private int o() {
        HC hC = this;
        return hC.f;
    }

    private Vector3dc p() {
        HC hC = this;
        return hC.g;
    }

    private static HC a(Vector3ic vector3ic, Vector3ic vector3ic2, AABBic aABBic, GU gU, boolean bl, int n2, Vector3dc vector3dc) {
        Intrinsics.checkNotNullParameter((Object)vector3ic, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3ic2, (String)"");
        Intrinsics.checkNotNullParameter((Object)aABBic, (String)"");
        Intrinsics.checkNotNullParameter((Object)gU, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        return new HC(vector3ic, vector3ic2, aABBic, gU, bl, n2, vector3dc);
    }

    /*
     * WARNING - void declaration
     */
    private static /* synthetic */ HC a$default(HC object, Vector3ic vector3ic, Vector3ic object2, AABBic object3, GU gU, boolean bl, int n2, Vector3dc vector3dc, int n3) {
        Vector3dc vector3dc2;
        int n4;
        boolean bl2;
        Object object4;
        void var8_12;
        if ((var8_12 & 1) != 0) {
            vector3ic = ((HC)object).a;
        }
        if ((var8_12 & 2) != 0) {
            object2 = ((HC)object).b;
        }
        if ((var8_12 & 4) != 0) {
            object3 = ((HC)object).c;
        }
        if ((var8_12 & 8) != 0) {
            gU = ((HC)object).d;
        }
        if ((var8_12 & 0x10) != 0) {
            object4 = object;
            bl2 = ((HC)object4).e;
        }
        if ((var8_12 & 0x20) != 0) {
            object4 = object;
            n4 = ((HC)object4).f;
        }
        if ((var8_12 & 0x40) != 0) {
            object4 = object;
            vector3dc2 = ((HC)object4).g;
        }
        Vector3ic vector3ic2 = vector3ic;
        Object object5 = object2;
        Object object6 = object3;
        Vector3dc vector3dc3 = vector3dc2;
        int n5 = n4;
        boolean bl3 = bl2;
        object3 = gU;
        object2 = object6;
        vector3ic = object5;
        object = vector3ic2;
        Intrinsics.checkNotNullParameter((Object)vector3ic2, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3ic, (String)"");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        Intrinsics.checkNotNullParameter((Object)object3, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc3, (String)"");
        return new HC((Vector3ic)object, (Vector3ic)vector3ic, (AABBic)object2, (GU)object3, bl3, n5, vector3dc3);
    }

    public final String toString() {
        HC hC = this;
        HC hC2 = hC;
        HC hC3 = this;
        hC2 = hC3;
        hC2 = this;
        return "HC(e=" + this.a + ", d=" + this.b + ", f=" + this.c + ", c=" + this.d + ", b=" + hC.e + ", g=" + hC3.f + ", h=" + hC2.g + ')';
    }

    public final int hashCode() {
        int n2 = this.a.hashCode();
        n2 = n2 * 31 + this.b.hashCode();
        n2 = n2 * 31 + this.c.hashCode();
        n2 = n2 * 31 + this.d.hashCode();
        HC hC = this;
        int n3 = hC.e ? 1 : 0;
        if (n3 != 0) {
            n3 = 1;
        }
        int n4 = n2 * 31 + n3;
        HC hC2 = this;
        int n5 = n4 * 31 + Integer.hashCode(hC2.f);
        HC hC3 = this;
        int n6 = n5 * 31 + hC3.g.hashCode();
        return n6;
    }

    public final boolean equals(Object other) {
        HC hC;
        if (this == other) {
            return true;
        }
        if (!(other instanceof HC)) {
            return false;
        }
        hC = hC;
        if (!Intrinsics.areEqual((Object)this.a, (Object)hC.a)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.b, (Object)hC.b)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.c, (Object)hC.c)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.d, (Object)hC.d)) {
            return false;
        }
        HC hC2 = this;
        HC hC3 = hC2;
        hC3 = hC;
        if (hC2.e != hC3.e) {
            return false;
        }
        HC hC4 = this;
        hC3 = hC4;
        hC3 = hC;
        if (hC4.f != hC3.f) {
            return false;
        }
        HC hC5 = this;
        hC3 = hC5;
        hC3 = hC;
        return Intrinsics.areEqual((Object)hC5.g, (Object)hC3.g);
    }
}

