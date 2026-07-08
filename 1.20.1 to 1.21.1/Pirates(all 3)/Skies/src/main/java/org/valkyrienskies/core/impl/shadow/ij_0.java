/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.valkyrienskies.core.impl.shadow.Ij
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3ic;
import org.valkyrienskies.core.impl.shadow.Ij;
import org.valkyrienskies.core.impl.shadow.im_0;
import org.valkyrienskies.core.impl.shadow.ip_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Ij
 */
@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u0000 ;2\u00020\u0001:\u0001;B)\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007H\u00c2\u0003\u00a2\u0006\u0004\b\b\u0010\tJ8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0007H\u00c6\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0096\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014Jy\u0010\u001f\u001a\u00020\u001d2d\u0010\u001e\u001a`\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001a\u0012\u0017\u0012\u00150\u0002j\u0002`\u001b\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d0\u0015H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010 J)\u0010!\u001a\u00060\u0002j\u0002`\u001b2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u00a2\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0007\u00a2\u0006\u0004\b#\u0010\tJ\u000f\u0010$\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b$\u0010\u0004J`\u0010&\u001a\u00020\u001d2K\u0010\u001e\u001aG\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001d0%H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010'Jd\u0010(\u001a\u00020\u001d2O\u0010\u001e\u001aK\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001a\u0012\b\u0012\u00060\u0002j\u0002`\u001b0%H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010'J1\u0010*\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\n\u0010)\u001a\u00060\u0002j\u0002`\u001b\u00a2\u0006\u0004\b*\u0010+J'\u0010,\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b,\u0010\"J\u0010\u0010.\u001a\u00020-H\u00d6\u0001\u00a2\u0006\u0004\b.\u0010/R\u001a\u0010\n\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u00100\u001a\u0004\b1\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u00100\u001a\u0004\b2\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\f\u00100\u001a\u0004\b3\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u00104R\u0014\u00108\u001a\u0002058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b6\u00107\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006<"}, d2={"Lorg/valkyrienskies/physics_api/voxel/updates/DenseVoxelShapeUpdate;", "Lorg/valkyrienskies/physics_api/voxel/updates/QueueableVoxelShapeUpdate;", "", "component1", "()I", "component2", "component3", "", "component4", "()[I", "regionX", "regionY", "regionZ", "voxelDataRaw", "copy", "(III[I)Lorg/valkyrienskies/physics_api/voxel/updates/DenseVoxelShapeUpdate;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "x", "y", "z", "Lorg/valkyrienskies/physics_api/Lod1BlockStateId;", "voxelState", "", "function", "forEachVoxel", "(Lkotlin/jvm/functions/Function4;)V", "getVoxel", "(III)I", "getVoxelDataRaw", "hashCode", "Lkotlin/Function3;", "iterate", "(Lkotlin/jvm/functions/Function3;)V", "setData", "data", "setVoxel", "(IIII)V", "toIndex", "", "toString", "()Ljava/lang/String;", "I", "getRegionX", "getRegionY", "getRegionZ", "[I", "Lorg/valkyrienskies/physics_api/voxel/updates/VoxelShapeUpdateType;", "getVoxelShapeUpdateType", "()Lorg/valkyrienskies/physics_api/voxel/updates/VoxelShapeUpdateType;", "voxelShapeUpdateType", "<init>", "(III[I)V", "Companion", "physics_api"})
public final class ij_0
implements im_0 {
    public static final a a = new a(null);
    public final int b;
    public final int c;
    public final int d;
    public final int[] e;

    private ij_0(int n2, int n3, int n4, int[] nArray) {
        Intrinsics.checkNotNullParameter((Object)nArray, (String)"");
        this.b = n2;
        this.c = n3;
        this.d = n4;
        this.e = nArray;
    }

    public /* synthetic */ ij_0(int n2, int n3, int n4, int[] nArray, int n5, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n5 & 8) != 0) {
            nArray = new int[4096];
        }
        this(n2, n3, n4, nArray);
    }

    @Override
    @JvmName(name="a")
    public final int a() {
        return this.b;
    }

    @Override
    @JvmName(name="b")
    public final int b() {
        return this.c;
    }

    @Override
    @JvmName(name="c")
    public final int c() {
        return this.d;
    }

    @Override
    @JvmName(name="d")
    public final ip_0 d() {
        return ip_0.DENSE;
    }

    public final void a(int n2, int n3, int n4, int n5) {
        n2 = ij_0.b(n2, n3, n4);
        this.e[n2] = n5;
    }

    public final int a(int n2, int n3, int n4) {
        n2 = ij_0.b(n2, n3, n4);
        return this.e[n2];
    }

    private void a(Function3<? super Integer, ? super Integer, ? super Integer, Integer> function3) {
        Intrinsics.checkNotNullParameter(function3, (String)"");
        int n2 = 0;
        while (n2 < 16) {
            int n3 = n2++;
            int n4 = 0;
            while (n4 < 16) {
                int n5 = n4++;
                int n6 = 0;
                while (n6 < 16) {
                    int n7;
                    int n8 = n7 = n6++;
                    n7 = n5;
                    int n9 = n3;
                    int n10 = n8;
                    this.a(n10, n9, n7, ((Number)function3.invoke((Object)n10, (Object)n9, (Object)n7)).intValue());
                }
            }
        }
    }

    private void a(Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> function4) {
        Intrinsics.checkNotNullParameter(function4, (String)"");
        int n2 = 0;
        while (n2 < 16) {
            int n3 = n2++;
            int n4 = 0;
            while (n4 < 16) {
                int n5 = n4++;
                int n6 = 0;
                while (n6 < 16) {
                    int n7;
                    int n8 = n7 = n6++;
                    n7 = n5;
                    int n9 = n3;
                    int n10 = n8;
                    function4.invoke((Object)n10, (Object)n9, (Object)n7, (Object)this.a(n10, n9, n7));
                }
            }
        }
    }

    private static void b(Function3<? super Integer, ? super Integer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, (String)"");
        int n2 = 0;
        while (n2 < 16) {
            int n3 = n2++;
            int n4 = 0;
            while (n4 < 16) {
                int n5 = n4++;
                int n6 = 0;
                while (n6 < 16) {
                    int n7 = n6++;
                    function3.invoke((Object)n7, (Object)n3, (Object)n5);
                }
            }
        }
    }

    private static int b(int n2, int n3, int n4) {
        return n2 | n4 << 4 | n3 << 8;
    }

    public final int[] e() {
        return this.e;
    }

    /*
     * WARNING - void declaration
     */
    public final boolean equals(Object other) {
        void var1_1;
        if (this == other) {
            return true;
        }
        Object object = other;
        if (!Intrinsics.areEqual(this.getClass(), object == null ? null : object.getClass())) {
            return false;
        }
        Object object2 = other;
        if (object2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type org.valkyrienskies.physics_api.voxel.updates.DenseVoxelShapeUpdate");
        }
        ij_0 cfr_ignored_0 = (ij_0)object2;
        ij_0 ij_02 = this;
        ij_0 ij_03 = ij_02;
        ij_03 = (ij_0)other;
        if (ij_02.b != ij_03.b) {
            return false;
        }
        ij_0 ij_04 = this;
        ij_03 = ij_04;
        ij_03 = (ij_0)other;
        if (ij_04.c != ij_03.c) {
            return false;
        }
        ij_0 ij_05 = this;
        ij_03 = ij_05;
        ij_03 = (ij_0)other;
        if (ij_05.d != ij_03.d) {
            return false;
        }
        return Arrays.equals(this.e, ((ij_0)var1_1).e);
    }

    public final int hashCode() {
        ij_0 ij_02 = this;
        int n2 = ij_02.b;
        ij_0 ij_03 = this;
        int n3 = n2 * 31 + ij_03.c;
        ij_0 ij_04 = this;
        int n4 = n3 * 31 + ij_04.d;
        n4 = n4 * 31 + Arrays.hashCode(this.e);
        return n4;
    }

    private int f() {
        ij_0 ij_02 = this;
        return ij_02.b;
    }

    private int g() {
        ij_0 ij_02 = this;
        return ij_02.c;
    }

    private int h() {
        ij_0 ij_02 = this;
        return ij_02.d;
    }

    private final int[] i() {
        return this.e;
    }

    private static ij_0 a(int n2, int n3, int n4, int[] nArray) {
        Intrinsics.checkNotNullParameter((Object)nArray, (String)"");
        return new ij_0(n2, n3, n4, nArray);
    }

    private static /* synthetic */ ij_0 a$default(ij_0 ij_02, int n2, int n3, int n4, int[] nArray, int n5) {
        ij_0 ij_03;
        if ((n5 & 1) != 0) {
            ij_03 = ij_02;
            n2 = ij_03.b;
        }
        if ((n5 & 2) != 0) {
            ij_03 = ij_02;
            n3 = ij_03.c;
        }
        if ((n5 & 4) != 0) {
            ij_03 = ij_02;
            n4 = ij_03.d;
        }
        if ((n5 & 8) != 0) {
            nArray = ij_02.e;
        }
        int n6 = n2;
        int n7 = n3;
        int[] nArray2 = nArray;
        n3 = n4;
        n2 = n7;
        int n8 = n6;
        Intrinsics.checkNotNullParameter((Object)nArray2, (String)"");
        return new ij_0(n8, n2, n3, nArray2);
    }

    public final String toString() {
        ij_0 ij_02 = this;
        ij_0 ij_03 = ij_02;
        ij_0 ij_04 = this;
        ij_03 = ij_04;
        ij_03 = this;
        return "Ij(a=" + ij_02.b + ", b=" + ij_04.c + ", c=" + ij_03.d + ", d=" + Arrays.toString(this.e) + ')';
    }

    @Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Ij$a;", "", "Lorg/joml/Vector3ic;", "p0", "Lorg/valkyrienskies/core/impl/shadow/Ij;", "a", "(Lorg/joml/Vector3ic;)Lorg/valkyrienskies/core/impl/shadow/Ij;", "<init>", "()V"})
    public static final class a {
        private a() {
        }

        private static ij_0 a(Vector3ic vector3ic) {
            Intrinsics.checkNotNullParameter((Object)vector3ic, (String)"");
            return new Ij(vector3ic.x(), vector3ic.y(), vector3ic.z(), null, 8, null);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

