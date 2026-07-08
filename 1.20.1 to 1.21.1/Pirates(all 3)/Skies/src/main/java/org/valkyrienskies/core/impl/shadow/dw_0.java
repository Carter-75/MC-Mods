/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.joml.Vector3i;
import org.joml.Vector3ic;
import org.valkyrienskies.core.util.datastructures.IBlockPosSet;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Dw
 */
public final class dw_0
implements IBlockPosSet {
    private final Set<Vector3ic> a = new HashSet<Vector3ic>();

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean add(int x, int y, int z) {
        void var3_3;
        void var2_2;
        void var1_1;
        return this.a.add(new Vector3i((int)var1_1, (int)var2_2, (int)var3_3));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean remove(int x, int y, int z) {
        void var3_3;
        void var2_2;
        void var1_1;
        return this.a.remove(new Vector3i((int)var1_1, (int)var2_2, (int)var3_3));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean contains(int x, int y, int z) {
        void var3_3;
        void var2_2;
        void var1_1;
        return this.a.contains(new Vector3i((int)var1_1, (int)var2_2, (int)var3_3));
    }

    @Override
    public final boolean canStore(int x, int y, int z) {
        return true;
    }

    @Override
    public final int size() {
        return this.a.size();
    }

    @Override
    public final Iterator<Vector3ic> iterator() {
        return this.a.iterator();
    }

    @Override
    public final void clear() {
        this.a.clear();
    }
}

