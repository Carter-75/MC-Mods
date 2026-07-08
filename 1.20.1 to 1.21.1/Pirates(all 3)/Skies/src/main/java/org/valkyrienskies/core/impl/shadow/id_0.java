/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  org.valkyrienskies.core.impl.shadow.Id
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.valkyrienskies.core.impl.shadow.Id;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Id
 */
@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001%B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rH\u00d6\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004R\u0011\u0010\u0012\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0018\u001a\u00060\u0014j\u0002`\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u001a\u001a\u00060\u0014j\u0002`\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0015\u0010\u001c\u001a\u00060\u0014j\u0002`\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0017R\u0015\u0010\u001e\u001a\u00060\u0014j\u0002`\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0017R\u0015\u0010 \u001a\u00060\u0014j\u0002`\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0017R\u0015\u0010\"\u001a\u00060\u0014j\u0002`\u00158F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0017\u00a8\u0006&"}, d2={"Lorg/valkyrienskies/physics_api/voxel/LodBlockBoundingBox;", "", "", "component1", "()I", "data", "copy", "(I)Lorg/valkyrienskies/physics_api/voxel/LodBlockBoundingBox;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getData", "isEmpty", "()Z", "", "Lorg/valkyrienskies/physics_api/voxel/LodBlockBoundingBoxNibble;", "getMaxX", "()B", "maxX", "getMaxY", "maxY", "getMaxZ", "maxZ", "getMinX", "minX", "getMinY", "minY", "getMinZ", "minZ", "<init>", "(I)V", "Companion", "physics_api"})
public final class id_0 {
    public static final a a = new a(null);
    public final int b;

    public id_0(int n2) {
        this.b = n2;
    }

    public /* synthetic */ id_0(int n2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 1) != 0) {
            n2 = 0;
        }
        this(n2);
    }

    @JvmName(name="a")
    public final int a() {
        return this.b;
    }

    @JvmName(name="b")
    private byte b() {
        return (byte)(this.b & 0xF);
    }

    @JvmName(name="c")
    private byte c() {
        return (byte)(this.b >> 4 & 0xF);
    }

    @JvmName(name="d")
    private byte d() {
        return (byte)(this.b >> 8 & 0xF);
    }

    @JvmName(name="e")
    private byte e() {
        return (byte)(this.b >> 12 & 0xF);
    }

    @JvmName(name="f")
    private byte f() {
        return (byte)(this.b >> 16 & 0xF);
    }

    @JvmName(name="g")
    private byte g() {
        return (byte)(this.b >> 20 & 0xF);
    }

    @JvmName(name="h")
    private boolean h() {
        return this.b >> 24 == 0;
    }

    private int i() {
        return this.b;
    }

    private static id_0 a(int n2) {
        return new id_0(n2);
    }

    private static /* synthetic */ id_0 a$default(id_0 id_02, int n2, int n3) {
        if ((n3 & 1) != 0) {
            n2 = id_02.b;
        }
        int n4 = n2;
        return new id_0(n4);
    }

    public final String toString() {
        return "Id(a=" + this.b + ')';
    }

    public final int hashCode() {
        return Integer.hashCode(this.b);
    }

    public final boolean equals(Object other) {
        id_0 id_02;
        if (this == other) {
            return true;
        }
        if (!(other instanceof id_0)) {
            return false;
        }
        id_02 = id_02;
        return this.b == id_02.b;
    }

    public id_0() {
        this(0, 1, null);
    }

    @Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0004JU\u0010\u000e\u001a\u00020\u00022\n\u0010\b\u001a\u00060\u0006j\u0002`\u00072\n\u0010\t\u001a\u00060\u0006j\u0002`\u00072\n\u0010\n\u001a\u00060\u0006j\u0002`\u00072\n\u0010\u000b\u001a\u00060\u0006j\u0002`\u00072\n\u0010\f\u001a\u00060\u0006j\u0002`\u00072\n\u0010\r\u001a\u00060\u0006j\u0002`\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2={"Lorg/valkyrienskies/physics_api/voxel/LodBlockBoundingBox$Companion;", "", "Lorg/valkyrienskies/physics_api/voxel/LodBlockBoundingBox;", "createEmptyVSBoundingBox", "()Lorg/valkyrienskies/physics_api/voxel/LodBlockBoundingBox;", "createFullVSBoundingBox", "", "Lorg/valkyrienskies/physics_api/voxel/LodBlockBoundingBoxNibble;", "minX", "minY", "minZ", "maxX", "maxY", "maxZ", "createVSBoundingBox", "(BBBBBB)Lorg/valkyrienskies/physics_api/voxel/LodBlockBoundingBox;", "", "data", "createVSBoundingBoxFromData", "(I)Lorg/valkyrienskies/physics_api/voxel/LodBlockBoundingBox;", "<init>", "()V", "physics_api"})
    public static final class a {
        private a() {
        }

        public static id_0 a(byte by, byte by2, byte by3, byte by4, byte by5, byte by6) {
            by = (byte)(by | by2 << 4 | by3 << 8 | by4 << 12 | by5 << 16 | by6 << 20 | 0x1000000);
            return new Id((int)by);
        }

        public static id_0 a(int n2) {
            return new Id(n2);
        }

        public static id_0 a() {
            return new Id(0, 1, null);
        }

        public final id_0 b() {
            return org.valkyrienskies.core.impl.shadow.Id$a.a((byte)0, (byte)0, (byte)0, (byte)15, (byte)15, (byte)15);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

