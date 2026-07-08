/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.createmod.catnip.data.Iterate
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_2350$class_2352
 *  net.minecraft.class_2382
 */
package org.valkyrienskies.mod.mixinducks.mod_compat.create;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.createmod.catnip.data.Iterate;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import org.valkyrienskies.mod.mixinducks.mod_compat.create.CWMergeEntry;

public class CWCluster {
    public class_2338 anchor;
    public final Map<CWMergeEntry, class_2350.class_2352> visibleFaces;
    public final Set<CWMergeEntry> visibleEdges = new HashSet<CWMergeEntry>();

    public CWCluster() {
        this.visibleFaces = new HashMap<CWMergeEntry, class_2350.class_2352>();
    }

    public boolean isEmpty() {
        return this.anchor == null;
    }

    public void include(class_2338 pos) {
        if (this.anchor == null) {
            this.anchor = pos;
        }
        pos = pos.method_10059((class_2382)this.anchor);
        for (class_2350.class_2351 axis : Iterate.axes) {
            class_2350 direction = class_2350.method_10156((class_2350.class_2352)class_2350.class_2352.field_11056, (class_2350.class_2351)axis);
            int[] nArray = Iterate.zeroAndOne;
            int n2 = nArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                int offset = nArray[i2];
                CWMergeEntry entry = new CWMergeEntry(axis, pos.method_10079(direction, offset));
                if (this.visibleFaces.remove(entry) != null) continue;
                this.visibleFaces.put(entry, offset == 0 ? class_2350.class_2352.field_11060 : class_2350.class_2352.field_11056);
            }
        }
        block2: for (class_2350.class_2351 axis : Iterate.axes) {
            for (class_2350.class_2351 axis2 : Iterate.axes) {
                if (axis == axis2) continue;
                for (class_2350.class_2351 axis3 : Iterate.axes) {
                    if (axis == axis3 || axis2 == axis3) continue;
                    class_2350 direction = class_2350.method_10156((class_2350.class_2352)class_2350.class_2352.field_11056, (class_2350.class_2351)axis2);
                    class_2350 direction2 = class_2350.method_10156((class_2350.class_2352)class_2350.class_2352.field_11056, (class_2350.class_2351)axis3);
                    for (int offset : Iterate.zeroAndOne) {
                        class_2338 entryPos = pos.method_10079(direction, offset);
                        for (int offset2 : Iterate.zeroAndOne) {
                            CWMergeEntry entry = new CWMergeEntry(axis, entryPos = entryPos.method_10079(direction2, offset2));
                            if (this.visibleEdges.remove(entry)) continue;
                            this.visibleEdges.add(entry);
                        }
                    }
                }
                continue block2;
            }
        }
    }
}

