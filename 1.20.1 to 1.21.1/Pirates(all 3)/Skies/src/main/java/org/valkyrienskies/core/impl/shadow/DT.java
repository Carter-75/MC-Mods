/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Pair
 *  kotlin.Triple
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function4
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.DoubleUnaryOperator;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import org.joml.Vector3ic;
import org.valkyrienskies.core.api.events.MergeEvent;
import org.valkyrienskies.core.api.events.SplitEvent;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.core.api.world.connectivity.ConnectionStatus;
import org.valkyrienskies.core.api.world.connectivity.DoubleAugmentation;
import org.valkyrienskies.core.api.world.connectivity.DoubleComponentAugmentation;
import org.valkyrienskies.core.impl.shadow.ij_0;
import org.valkyrienskies.core.util.datastructures.DenseBlockPosSet;
import org.valkyrienskies.core.util.datastructures.SparseVoxelPosition;

public interface DT {
    public void a(int var1, int var2, int var3, Long var4);

    public static /* synthetic */ void a(DT dT, int n2, int n3, int n4, Long l2, int n5, Object object) {
        dT.a(n2, n3, n4, (Long)null);
    }

    public void a(int var1, int var2, int var3, long var4, Long var6);

    public static /* synthetic */ void a(DT dT, int n2, int n3, int n4, long l2, Long l3, int n5, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addVoxel");
        }
        if ((n5 & 0x10) != 0) {
            l3 = null;
        }
        dT.a(n2, n3, n4, l2, l3);
    }

    public void a(int var1, int var2, int var3);

    public SparseVoxelPosition b(int var1, int var2, int var3);

    public void c(int var1, int var2, int var3);

    public ConnectionStatus a(int var1, int var2, int var3, int var4, int var5, int var6);

    public ConnectionStatus d(int var1, int var2, int var3);

    public void b(int var1, int var2, int var3, Long var4);

    public static /* synthetic */ void b(DT dT, int n2, int n3, int n4, Long l2, int n5, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: markChunkLoaded");
        }
        if ((n5 & 8) != 0) {
            l2 = null;
        }
        dT.b(n2, n3, n4, l2);
    }

    public void e(int var1, int var2, int var3);

    public void c(int var1, int var2, int var3, Long var4);

    public void a(int var1, int var2, int var3, ij_0 var4);

    public void f(int var1, int var2, int var3);

    public double a(DoubleAugmentation var1, int var2, int var3, int var4);

    public void a(DoubleAugmentation var1, int var2, int var3, int var4, double var5);

    public void a(DoubleAugmentation var1, int var2, int var3, int var4, DoubleUnaryOperator var5);

    public void b(DoubleAugmentation var1, int var2, int var3, int var4);

    public double c(DoubleAugmentation var1, int var2, int var3, int var4);

    public boolean a(DoubleComponentAugmentation var1, int var2, int var3, int var4, double var5);

    public double a(DoubleComponentAugmentation var1, int var2, int var3, int var4);

    public boolean b(DoubleComponentAugmentation var1, int var2, int var3, int var4);

    public long g(int var1, int var2, int var3);

    public Map<Triple<Integer, Integer, Integer>, Double> a(DoubleAugmentation var1, ChunkClaim var2);

    public static /* synthetic */ Map a(DT dT, DoubleAugmentation doubleAugmentation, ChunkClaim chunkClaim, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: gatherFromEachComponent");
        }
        if ((n2 & 2) != 0) {
            chunkClaim = null;
        }
        return dT.a(doubleAugmentation, chunkClaim);
    }

    public Map<Triple<Integer, Integer, Integer>, Double> a(DoubleComponentAugmentation var1, ChunkClaim var2);

    public static /* synthetic */ Map a(DT dT, DoubleComponentAugmentation doubleComponentAugmentation, ChunkClaim chunkClaim, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: gatherFromEachComponentRoot");
        }
        if ((n2 & 2) != 0) {
            chunkClaim = null;
        }
        return dT.a(doubleComponentAugmentation, chunkClaim);
    }

    public Set<Vector3ic> a(ChunkClaim var1);

    public void a(int var1, int var2, int var3, Function4<? super Integer, ? super Integer, ? super Integer, ? super Long, Unit> var4);

    public DenseBlockPosSet a(int var1, int var2, int var3, DenseBlockPosSet var4);

    public static /* synthetic */ DenseBlockPosSet a(DT dT, int n2, int n3, int n4, DenseBlockPosSet denseBlockPosSet, int n5, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getComponentBlocks");
        }
        if ((n5 & 8) != 0) {
            denseBlockPosSet = new DenseBlockPosSet();
        }
        return dT.a(n2, n3, n4, denseBlockPosSet);
    }

    public Pair<HashSet<SplitEvent>, HashSet<MergeEvent>> a();
}

