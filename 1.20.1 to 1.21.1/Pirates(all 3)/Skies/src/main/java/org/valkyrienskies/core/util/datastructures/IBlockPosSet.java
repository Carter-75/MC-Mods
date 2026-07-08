/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 */
package org.valkyrienskies.core.util.datastructures;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nonnull;
import org.joml.Vector3ic;
import org.valkyrienskies.core.api.util.functions.IntTernaryConsumer;

public interface IBlockPosSet
extends Set<Vector3ic> {
    public boolean add(int var1, int var2, int var3) throws IllegalArgumentException;

    public boolean remove(int var1, int var2, int var3);

    public boolean contains(int var1, int var2, int var3);

    public boolean canStore(int var1, int var2, int var3);

    @Override
    public void clear();

    default public void forEach(@Nonnull IntTernaryConsumer action) {
        this.forEach((? super T blockPos) -> action.accept(blockPos.x(), blockPos.y(), blockPos.z()));
    }

    default public void forEachUnsafe(@Nonnull IntTernaryConsumer action) {
        throw new UnsupportedOperationException();
    }

    @Override
    default public boolean add(@Nonnull Vector3ic pos) throws IllegalArgumentException {
        return this.add(pos.x(), pos.y(), pos.z());
    }

    default public boolean remove(@Nonnull Vector3ic pos) {
        return this.remove(pos.x(), pos.y(), pos.z());
    }

    default public boolean contains(@Nonnull Vector3ic pos) {
        return this.contains(pos.x(), pos.y(), pos.z());
    }

    default public boolean canStore(@Nonnull Vector3ic pos) {
        return this.canStore(pos.x(), pos.y(), pos.z());
    }

    @Override
    default public boolean containsAll(@Nonnull Collection<?> c2) {
        for (Object o : c2) {
            if (this.contains(o)) continue;
            return false;
        }
        return true;
    }

    @Override
    default public boolean addAll(@Nonnull Collection<? extends Vector3ic> c2) throws IllegalArgumentException {
        boolean modified = false;
        for (Vector3ic vector3ic : c2) {
            modified |= this.add(vector3ic);
        }
        return modified;
    }

    @Override
    default public boolean removeAll(@Nonnull Collection<?> c2) {
        boolean modified = false;
        for (Object o : c2) {
            modified |= this.remove(o);
        }
        return modified;
    }

    @Override
    default public boolean retainAll(@Nonnull Collection<?> c2) {
        boolean modified = false;
        for (Vector3ic pos : this) {
            if (c2.contains(pos)) continue;
            this.remove(pos);
            modified = true;
        }
        return modified;
    }

    @Override
    default public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    default public boolean remove(@Nonnull Object o) throws IllegalArgumentException {
        if (o instanceof Vector3ic) {
            return this.remove((Vector3ic)o);
        }
        throw new IllegalArgumentException("Object " + String.valueOf(o) + " is not a BlockPos!");
    }

    @Override
    default public boolean contains(@Nonnull Object o) {
        if (o instanceof Vector3ic) {
            return this.contains((Vector3ic)o);
        }
        return false;
    }

    @Override
    @Nonnull
    default public Object[] toArray() {
        Object[] arr = new Vector3ic[this.size()];
        Iterator iter = this.iterator();
        for (int i2 = 0; i2 < this.size(); ++i2) {
            arr[i2] = (Vector3ic)iter.next();
        }
        return arr;
    }

    @Override
    @Nonnull
    default public <T> T[] toArray(@Nonnull T[] a2) {
        return this.toArray();
    }
}

