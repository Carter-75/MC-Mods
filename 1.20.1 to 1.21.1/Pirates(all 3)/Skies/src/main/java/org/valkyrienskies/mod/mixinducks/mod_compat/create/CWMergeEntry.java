/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350$class_2351
 */
package org.valkyrienskies.mod.mixinducks.mod_compat.create;

import net.minecraft.class_2338;
import net.minecraft.class_2350;

public class CWMergeEntry {
    public final class_2350.class_2351 axis;
    public final class_2338 pos;

    public CWMergeEntry(class_2350.class_2351 axis, class_2338 pos) {
        this.axis = axis;
        this.pos = pos;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CWMergeEntry)) {
            return false;
        }
        CWMergeEntry other = (CWMergeEntry)o;
        return this.axis == other.axis && this.pos.equals((Object)other.pos);
    }

    public int hashCode() {
        return this.pos.hashCode() * 31 + this.axis.ordinal();
    }
}

