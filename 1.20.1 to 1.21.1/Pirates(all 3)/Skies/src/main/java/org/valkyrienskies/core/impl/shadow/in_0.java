/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.ints.IntArrayList
 *  it.unimi.dsi.fastutil.shorts.ShortArrayList
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.valkyrienskies.core.impl.shadow.In
 */
package org.valkyrienskies.core.impl.shadow;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.shorts.ShortArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3ic;
import org.valkyrienskies.core.impl.shadow.In;
import org.valkyrienskies.core.impl.shadow.im_0;
import org.valkyrienskies.core.impl.shadow.ip_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.In
 */
@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u0000 =2\u00020\u0001:\u0001=B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b;\u0010<J1\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u0006\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u000e\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u000e\u0010\fJ.\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003\u00a2\u0006\u0004\b\u0017\u0010\u0018Jy\u0010\u001d\u001a\u00020\b2d\u0010\u001c\u001a`\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0005\u0012\u0017\u0012\u00150\u0002j\u0002`\u0006\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0019H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001eJh\u0010!\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00022K\u0010\u001c\u001aG\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\b0 H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b#\u0010\fJ'\u0010$\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010'\u001a\u00020&H\u00d6\u0001\u00a2\u0006\u0004\b'\u0010(R\u001a\u0010\u000f\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010)\u001a\u0004\b*\u0010\fR\u001a\u0010\u0010\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010)\u001a\u0004\b+\u0010\fR\u001a\u0010\u0011\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010)\u001a\u0004\b,\u0010\fR\u0017\u0010.\u001a\u00020-8\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0017\u00103\u001a\u0002028\u0006\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0014\u0010:\u001a\u0002078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b8\u00109\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006>"}, d2={"Lorg/valkyrienskies/physics_api/voxel/updates/SparseVoxelShapeUpdate;", "Lorg/valkyrienskies/physics_api/voxel/updates/QueueableVoxelShapeUpdate;", "", "x", "y", "z", "Lorg/valkyrienskies/physics_api/Lod1BlockStateId;", "voxelState", "", "addUpdate", "(IIII)V", "component1", "()I", "component2", "component3", "regionX", "regionY", "regionZ", "copy", "(III)Lorg/valkyrienskies/physics_api/voxel/updates/SparseVoxelShapeUpdate;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "function", "forEachVoxelUpdate", "(Lkotlin/jvm/functions/Function4;)V", "index", "Lkotlin/Function3;", "fromIndex", "(ILkotlin/jvm/functions/Function3;)V", "hashCode", "toIndex", "(III)I", "", "toString", "()Ljava/lang/String;", "I", "getRegionX", "getRegionY", "getRegionZ", "Lit/unimi/dsi/fastutil/shorts/ShortArrayList;", "updatesPositions", "Lit/unimi/dsi/fastutil/shorts/ShortArrayList;", "getUpdatesPositions", "()Lit/unimi/dsi/fastutil/shorts/ShortArrayList;", "Lit/unimi/dsi/fastutil/ints/IntArrayList;", "updatesTypes", "Lit/unimi/dsi/fastutil/ints/IntArrayList;", "getUpdatesTypes", "()Lit/unimi/dsi/fastutil/ints/IntArrayList;", "Lorg/valkyrienskies/physics_api/voxel/updates/VoxelShapeUpdateType;", "getVoxelShapeUpdateType", "()Lorg/valkyrienskies/physics_api/voxel/updates/VoxelShapeUpdateType;", "voxelShapeUpdateType", "<init>", "(III)V", "Companion", "physics_api"})
public final class in_0
implements im_0 {
    public static final a a = new a(null);
    public final int b;
    public final int c;
    public final int d;
    public final ShortArrayList e;
    public final IntArrayList f;

    public in_0(int n2, int n3, int n4) {
        this.b = n2;
        this.c = n3;
        this.d = n4;
        this.e = new ShortArrayList();
        this.f = new IntArrayList();
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

    @JvmName(name="e")
    public final ShortArrayList e() {
        return this.e;
    }

    @JvmName(name="f")
    public final IntArrayList f() {
        return this.f;
    }

    @Override
    @JvmName(name="d")
    public final ip_0 d() {
        return ip_0.SPARSE;
    }

    public final void a(int n2, int n3, int n4, int n5) {
        n2 = in_0.a(n2, n3, n4);
        this.e.add((short)n2);
        this.f.add(n5);
    }

    private void a(Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> function4) {
        Intrinsics.checkNotNullParameter(function4, (String)"");
        int n2 = 0;
        in_0 in_02 = this;
        int n3 = in_02.e.size();
        while (n2 < n3) {
            int n4 = n2++;
            in_02 = this;
            int n5 = in_02.e.getShort(n4);
            in_02 = this;
            n4 = in_02.f.getInt(n4);
            int n6 = n5 >> 8 & 0xF;
            int n7 = n5 >> 4 & 0xF;
            n5 &= 0xF;
            int n8 = n6;
            n6 = n7;
            n7 = n8;
            function4.invoke((Object)n7, (Object)n6, (Object)n5, (Object)n4);
        }
    }

    private static int a(int n2, int n3, int n4) {
        return n4 | n3 << 4 | n2 << 8;
    }

    private static void a(int n2, Function3<? super Integer, ? super Integer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, (String)"");
        int n3 = n2 >> 8 & 0xF;
        int n4 = n2 >> 4 & 0xF;
        function3.invoke((Object)n3, (Object)n4, (Object)(n2 &= 0xF));
    }

    private int g() {
        in_0 in_02 = this;
        return in_02.b;
    }

    private int h() {
        in_0 in_02 = this;
        return in_02.c;
    }

    private int i() {
        in_0 in_02 = this;
        return in_02.d;
    }

    private static in_0 b(int n2, int n3, int n4) {
        return new in_0(n2, n3, n4);
    }

    private static /* synthetic */ in_0 b$default(in_0 in_02, int n2, int n3, int n4, int n5) {
        in_0 in_03;
        if ((n5 & 1) != 0) {
            in_03 = in_02;
            n2 = in_03.b;
        }
        if ((n5 & 2) != 0) {
            in_03 = in_02;
            n3 = in_03.c;
        }
        if ((n5 & 4) != 0) {
            in_03 = in_02;
            n4 = in_03.d;
        }
        int n6 = n2;
        int n7 = n3;
        n3 = n4;
        n2 = n7;
        int n8 = n6;
        return new in_0(n8, n2, n3);
    }

    public final String toString() {
        in_0 in_02 = this;
        in_0 in_03 = in_02;
        in_0 in_04 = this;
        in_03 = in_04;
        in_03 = this;
        return "In(a=" + in_02.b + ", b=" + in_04.c + ", c=" + in_03.d + ')';
    }

    public final int hashCode() {
        in_0 in_02 = this;
        int n2 = Integer.hashCode(in_02.b);
        in_0 in_03 = this;
        int n3 = n2 * 31 + Integer.hashCode(in_03.c);
        in_0 in_04 = this;
        int n4 = n3 * 31 + Integer.hashCode(in_04.d);
        return n4;
    }

    public final boolean equals(Object other) {
        in_0 in_02;
        if (this == other) {
            return true;
        }
        if (!(other instanceof in_0)) {
            return false;
        }
        in_02 = in_02;
        in_0 in_03 = this;
        in_0 in_04 = in_03;
        in_04 = in_02;
        if (in_03.b != in_04.b) {
            return false;
        }
        in_0 in_05 = this;
        in_04 = in_05;
        in_04 = in_02;
        if (in_05.c != in_04.c) {
            return false;
        }
        in_0 in_06 = this;
        in_04 = in_06;
        in_04 = in_02;
        return in_06.d == in_04.d;
    }

    @Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2={"Lorg/valkyrienskies/core/impl/shadow/In$a;", "", "Lorg/joml/Vector3ic;", "p0", "Lorg/valkyrienskies/core/impl/shadow/In;", "a", "(Lorg/joml/Vector3ic;)Lorg/valkyrienskies/core/impl/shadow/In;", "<init>", "()V"})
    public static final class a {
        private a() {
        }

        public static in_0 a(Vector3ic vector3ic) {
            Intrinsics.checkNotNullParameter((Object)vector3ic, (String)"");
            return new In(vector3ic.x(), vector3ic.y(), vector3ic.z());
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

