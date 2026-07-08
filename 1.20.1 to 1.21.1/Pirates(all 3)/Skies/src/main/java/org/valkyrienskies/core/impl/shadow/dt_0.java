/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.ints.Int2IntAVLTreeMap
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import it.unimi.dsi.fastutil.ints.Int2IntAVLTreeMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3ic;
import org.joml.primitives.AABBi;
import org.valkyrienskies.core.impl.shadow.dv_0;
import org.valkyrienskies.core.util.datastructures.DenseBlockPosSet;
import org.valkyrienskies.core.util.datastructures.IBlockPosSet;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Dt
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0001\u00a2\u0006\u0004\b\u001f\u0010 J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ(\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0096\u0001\u00a2\u0006\u0004\b\n\u0010\tJ\u000f\u0010\f\u001a\u00020\u000bH\u0016\u00a2\u0006\u0004\b\f\u0010\rJ(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0096\u0001\u00a2\u0006\u0004\b\u000e\u0010\tJ\u001a\u0010\u0011\u001a\f\u0012\b\u0012\u0006*\u00020\u00100\u00100\u000fH\u0096\u0003\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0016\u0010\tR\u0014\u0010\u0014\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00038\u0017X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001b"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Dt;", "Lorg/valkyrienskies/core/util/datastructures/IBlockPosSet;", "Lorg/valkyrienskies/core/impl/shadow/Dv;", "", "p0", "p1", "p2", "", "add", "(III)Z", "canStore", "", "clear", "()V", "contains", "", "Lorg/joml/Vector3ic;", "iterator", "()Ljava/util/Iterator;", "Lorg/joml/primitives/AABBi;", "a", "()Lorg/joml/primitives/AABBi;", "remove", "Lorg/valkyrienskies/core/util/datastructures/IBlockPosSet;", "b", "()I", "Lit/unimi/dsi/fastutil/ints/Int2IntAVLTreeMap;", "Lit/unimi/dsi/fastutil/ints/Int2IntAVLTreeMap;", "c", "d", "e", "<init>", "(Lorg/valkyrienskies/core/util/datastructures/IBlockPosSet;)V"})
public final class dt_0
implements dv_0,
IBlockPosSet {
    private final IBlockPosSet a;
    private final Int2IntAVLTreeMap b;
    private final Int2IntAVLTreeMap c;
    private final Int2IntAVLTreeMap d;

    private dt_0(IBlockPosSet iBlockPosSet) {
        Intrinsics.checkNotNullParameter((Object)iBlockPosSet, (String)"");
        this.a = iBlockPosSet;
        this.b = new Int2IntAVLTreeMap();
        this.c = new Int2IntAVLTreeMap();
        this.d = new Int2IntAVLTreeMap();
    }

    public /* synthetic */ dt_0(IBlockPosSet iBlockPosSet, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            iBlockPosSet = new DenseBlockPosSet();
        }
        this(iBlockPosSet);
    }

    @JvmName(name="b")
    private int b() {
        return this.a.size();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean canStore(int p0, int p1, int p2) {
        void var3_3;
        void var2_2;
        void var1_1;
        return this.a.canStore((int)var1_1, (int)var2_2, (int)var3_3);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean contains(int p0, int p1, int p2) {
        void var3_3;
        void var2_2;
        void var1_1;
        return this.a.contains((int)var1_1, (int)var2_2, (int)var3_3);
    }

    @Override
    public final Iterator<Vector3ic> iterator() {
        return this.a.iterator();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean add(int x, int y, int z) {
        if (this.a.add(x, y, z)) {
            void var3_3;
            void var2_2;
            void var1_1;
            this.b.addTo((int)var1_1, 1);
            this.c.addTo((int)var2_2, 1);
            this.d.addTo((int)var3_3, 1);
            return true;
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean remove(int x, int y, int z) {
        if (this.a.remove(x, y, z)) {
            if (this.b.addTo(x, -1) == 1) {
                void var1_1;
                this.b.remove((int)var1_1);
            }
            if (this.c.addTo(y, -1) == 1) {
                void var2_2;
                this.c.remove((int)var2_2);
            }
            if (this.d.addTo(z, -1) == 1) {
                void var3_3;
                this.d.remove((int)var3_3);
            }
            return true;
        }
        return false;
    }

    @Override
    public final void clear() {
        this.b.clear();
        this.c.clear();
        this.d.clear();
        this.a.clear();
    }

    @Override
    public final AABBi a() {
        if (this.isEmpty()) {
            return null;
        }
        return new AABBi(this.b.firstIntKey(), this.c.firstIntKey(), this.d.firstIntKey(), this.b.lastIntKey(), this.c.lastIntKey(), this.d.lastIntKey());
    }

    public dt_0() {
        this(null, 1, null);
    }
}

