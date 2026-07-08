/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_2680
 *  net.minecraft.class_3218
 */
package org.valkyrienskies.mod.common.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_2680;
import net.minecraft.class_3218;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3ic;
import org.valkyrienskies.core.api.ships.LoadedServerShip;
import org.valkyrienskies.core.api.world.connectivity.ConnectionStatus;
import org.valkyrienskies.core.util.datastructures.DenseBlockPosSet;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.assembly.ShipAssembler;
import org.valkyrienskies.mod.common.config.VSGameConfig;
import org.valkyrienskies.mod.common.util.SplittingDisablerAttachment;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import org.valkyrienskies.mod.util.LoggingKt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001d\u0010\u001eJ-\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u000b\u00a2\u0006\u0004\b\f\u0010\rJ5\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0014Rp\u0010\u001b\u001a^\u0012\b\u0012\u00060\u0017j\u0002`\u0018\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00040\u0016j\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0004`\u001a0\u0016j.\u0012\b\u0012\u00060\u0017j\u0002`\u0018\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00040\u0016j\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0004`\u001a`\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2={"Lorg/valkyrienskies/mod/common/util/SplitHandler;", "", "Lnet/minecraft/class_1937;", "level", "", "x", "y", "z", "", "queueSplit", "(Lnet/minecraft/class_1937;III)V", "Lnet/minecraft/class_3218;", "tick", "(Lnet/minecraft/class_3218;)V", "Lnet/minecraft/class_2680;", "newBlockState", "split", "(Lnet/minecraft/class_1937;IIILnet/minecraft/class_2680;)V", "", "doEdges", "Z", "doCorners", "Ljava/util/HashMap;", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "Lnet/minecraft/class_2338;", "Lkotlin/collections/HashMap;", "splitQueue", "Ljava/util/HashMap;", "<init>", "(ZZ)V", "Companion", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nSplitHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SplitHandler.kt\norg/valkyrienskies/mod/common/util/SplitHandler\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 AttachmentHolder.kt\norg/valkyrienskies/core/api/attachment/AttachmentHolderKt\n*L\n1#1,219:1\n1863#2,2:220\n1557#2:223\n1628#2,3:224\n66#3:222\n*S KotlinDebug\n*F\n+ 1 SplitHandler.kt\norg/valkyrienskies/mod/common/util/SplitHandler\n*L\n41#1:220,2\n165#1:223\n165#1:224,3\n51#1:222\n*E\n"})
public final class SplitHandler {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final boolean doEdges;
    private final boolean doCorners;
    @NotNull
    private final HashMap<String, HashMap<class_2338, Integer>> splitQueue;
    @NotNull
    private static final Logger SPLITLOGGER = LoggingKt.logger("kitkat factory");
    @NotNull
    private static final ArrayList<class_2382> offsetsToCheck;

    public SplitHandler(boolean doEdges, boolean doCorners) {
        this.doEdges = doEdges;
        this.doCorners = doCorners;
        this.splitQueue = new HashMap();
    }

    public final void queueSplit(@NotNull class_1937 level, int x, int y, int z) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Serializable serializable = this.splitQueue.get(VSGameUtilsKt.getDimensionId(level));
        if (serializable == null || (serializable = serializable.put(new class_2338(x, y, z), VSGameConfig.SERVER.getDefaultSplitGraceTimer())) == null) {
            SplitHandler $this$queueSplit_u24lambda_u240 = this;
            boolean bl = false;
            Map map2 = $this$queueSplit_u24lambda_u240.splitQueue;
            String string = VSGameUtilsKt.getDimensionId(level);
            Object object = new Pair[]{TuplesKt.to((Object)new class_2338(x, y, z), (Object)VSGameConfig.SERVER.getDefaultSplitGraceTimer())};
            object = MapsKt.hashMapOf((Pair[])object);
            map2.put(string, object);
            serializable = Unit.INSTANCE;
        }
    }

    public final void tick(@NotNull class_3218 level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        if (this.splitQueue.get(VSGameUtilsKt.getDimensionId((class_1937)level)) != null) {
            HashMap<class_2338, Integer> hashMap = this.splitQueue.get(VSGameUtilsKt.getDimensionId((class_1937)level));
            Intrinsics.checkNotNull(hashMap);
            if (!((Map)hashMap).isEmpty()) {
                HashSet<class_2338> splitsToProcess = new HashSet<class_2338>();
                HashMap<class_2338, Integer> hashMap2 = this.splitQueue.get(VSGameUtilsKt.getDimensionId((class_1937)level));
                Intrinsics.checkNotNull(hashMap2);
                Iterator<class_2338> iterator2 = hashMap2.keySet().iterator();
                while (iterator2.hasNext()) {
                    class_2338 splitIndex;
                    Intrinsics.checkNotNullExpressionValue((Object)iterator2.next(), (String)"next(...)");
                    HashMap<class_2338, Integer> hashMap3 = this.splitQueue.get(VSGameUtilsKt.getDimensionId((class_1937)level));
                    Intrinsics.checkNotNull(hashMap3);
                    Integer n2 = hashMap3.get(splitIndex);
                    Intrinsics.checkNotNull((Object)n2);
                    if (((Number)n2).intValue() <= 0) {
                        splitsToProcess.add(splitIndex);
                        continue;
                    }
                    HashMap<class_2338, Integer> hashMap4 = this.splitQueue.get(VSGameUtilsKt.getDimensionId((class_1937)level));
                    Intrinsics.checkNotNull(hashMap4);
                    Map map2 = hashMap4;
                    HashMap<class_2338, Integer> hashMap5 = this.splitQueue.get(VSGameUtilsKt.getDimensionId((class_1937)level));
                    Intrinsics.checkNotNull(hashMap5);
                    Integer n3 = hashMap5.get(splitIndex);
                    Intrinsics.checkNotNull((Object)n3);
                    map2.put(splitIndex, ((Number)n3).intValue() - 1);
                }
                Iterable $this$forEach$iv = splitsToProcess;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    class_2338 it = (class_2338)element$iv;
                    boolean bl = false;
                    HashMap<class_2338, Integer> hashMap6 = this.splitQueue.get(VSGameUtilsKt.getDimensionId((class_1937)level));
                    Intrinsics.checkNotNull(hashMap6);
                    hashMap6.remove(it);
                    class_1937 class_19372 = (class_1937)level;
                    int n4 = it.method_10263();
                    int n5 = it.method_10264();
                    int n6 = it.method_10260();
                    class_2680 class_26802 = level.method_8320(it);
                    Intrinsics.checkNotNullExpressionValue((Object)class_26802, (String)"getBlockState(...)");
                    this.split(class_19372, n4, n5, n6, class_26802);
                }
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    public final void split(@NotNull class_1937 level, int x, int y, int z, @NotNull class_2680 newBlockState) {
        block20: {
            Object $this$getAttachment$iv;
            LoadedServerShip loadedShip;
            block22: {
                block21: {
                    Intrinsics.checkNotNullParameter((Object)level, (String)"level");
                    Intrinsics.checkNotNullParameter((Object)newBlockState, (String)"newBlockState");
                    if (!(level instanceof class_3218)) break block20;
                    loadedShip = VSGameUtilsKt.getLoadedShipManagingPos((class_3218)level, x >> 4, z >> 4);
                    if (loadedShip == null) break block21;
                    $this$getAttachment$iv = loadedShip;
                    boolean $i$f$getAttachment = false;
                    SplittingDisablerAttachment splittingDisablerAttachment = $this$getAttachment$iv.getAttachment(SplittingDisablerAttachment.class);
                    boolean bl = splittingDisablerAttachment != null ? !splittingDisablerAttachment.canSplit() : false;
                    if (!bl) break block22;
                }
                if (loadedShip != null || !VSGameConfig.SERVER.getEnableWorldSplitting()) break block20;
            }
            if (newBlockState.method_26215()) {
                class_2680 neighborState;
                HashSet<class_2338> blockNeighbors = new HashSet<class_2338>();
                Iterator<class_2382> iterator2 = Companion.getOffsets(this.doEdges, this.doCorners).iterator();
                Intrinsics.checkNotNullExpressionValue(iterator2, (String)"iterator(...)");
                $this$getAttachment$iv = iterator2;
                while ($this$getAttachment$iv.hasNext()) {
                    Object e2 = $this$getAttachment$iv.next();
                    Intrinsics.checkNotNullExpressionValue(e2, (String)"next(...)");
                    class_2382 neighborOffset = (class_2382)e2;
                    class_2338 neighborPos = new class_2338(x + neighborOffset.method_10263(), y + neighborOffset.method_10264(), z + neighborOffset.method_10260());
                    neighborState = ((class_3218)level).method_8320(neighborPos);
                    if (neighborState.method_26215() || Intrinsics.areEqual((Object)neighborPos, (Object)new class_2338(x, y, z))) continue;
                    blockNeighbors.add(neighborPos);
                }
                if (!((Collection)blockNeighbors).isEmpty()) {
                    class_2338 current;
                    Iterable<Vector3ic> visited;
                    Object neighborPos;
                    Object largestComponentNode = (class_2338)CollectionsKt.first((Iterable)blockNeighbors);
                    long largestComponentSize = -1L;
                    class_2680 class_26802 = blockNeighbors.iterator();
                    Intrinsics.checkNotNullExpressionValue(class_26802, (String)"iterator(...)");
                    neighborState = class_26802;
                    while (neighborState.hasNext()) {
                        long size;
                        Object e3 = neighborState.next();
                        Intrinsics.checkNotNullExpressionValue(e3, (String)"next(...)");
                        neighborPos = (class_2338)e3;
                        if (VSGameUtilsKt.getShipObjectWorld((class_3218)level).isIsolatedSolid(neighborPos.method_10263(), neighborPos.method_10264(), neighborPos.method_10260(), VSGameUtilsKt.getDimensionId(level)) != ConnectionStatus.DISCONNECTED || (size = VSGameUtilsKt.getShipObjectWorld((class_3218)level).getSolidComponentSize(neighborPos.method_10263(), neighborPos.method_10264(), neighborPos.method_10260(), VSGameUtilsKt.getDimensionId(level))) <= largestComponentSize) continue;
                        largestComponentNode = neighborPos;
                        largestComponentSize = size;
                    }
                    if (largestComponentSize == -1L) {
                        return;
                    }
                    blockNeighbors.remove(largestComponentNode);
                    HashSet<class_2338> disconnected = new HashSet<class_2338>();
                    Iterator iterator3 = blockNeighbors.iterator();
                    Intrinsics.checkNotNullExpressionValue(iterator3, (String)"iterator(...)");
                    neighborPos = iterator3;
                    while (neighborPos.hasNext()) {
                        Object e4 = neighborPos.next();
                        Intrinsics.checkNotNullExpressionValue(e4, (String)"next(...)");
                        class_2338 neighborPos2 = (class_2338)e4;
                        if (VSGameUtilsKt.getShipObjectWorld((class_3218)level).isIsolatedSolid(neighborPos2.method_10263(), neighborPos2.method_10264(), neighborPos2.method_10260(), VSGameUtilsKt.getDimensionId(level)) != ConnectionStatus.DISCONNECTED || Intrinsics.areEqual((Object)neighborPos2, (Object)largestComponentNode) || VSGameUtilsKt.getShipObjectWorld((class_3218)level).isConnectedBySolid(largestComponentNode.method_10263(), largestComponentNode.method_10264(), largestComponentNode.method_10260(), neighborPos2.method_10263(), neighborPos2.method_10264(), neighborPos2.method_10260(), VSGameUtilsKt.getDimensionId(level)) != ConnectionStatus.DISCONNECTED) continue;
                        disconnected.add(neighborPos2);
                    }
                    HashSet<class_2338> toIgnore = new HashSet<class_2338>();
                    toIgnore.add(new class_2338(x, y, z));
                    Iterator iterator4 = disconnected.iterator();
                    Intrinsics.checkNotNullExpressionValue(iterator4, (String)"iterator(...)");
                    Iterator neighborPos2 = iterator4;
                    while (neighborPos2.hasNext()) {
                        Iterator iterator5;
                        Object e5 = neighborPos2.next();
                        Intrinsics.checkNotNullExpressionValue(e5, (String)"next(...)");
                        class_2338 component = (class_2338)e5;
                        Intrinsics.checkNotNullExpressionValue(disconnected.iterator(), (String)"iterator(...)");
                        while (iterator5.hasNext()) {
                            Object e6 = iterator5.next();
                            Intrinsics.checkNotNullExpressionValue(e6, (String)"next(...)");
                            class_2338 otherComponent = (class_2338)e6;
                            if (Intrinsics.areEqual((Object)component, (Object)otherComponent)) continue;
                            if (VSGameUtilsKt.getShipObjectWorld((class_3218)level).isConnectedBySolid(component.method_10263(), component.method_10264(), component.method_10260(), otherComponent.method_10263(), otherComponent.method_10264(), otherComponent.method_10260(), VSGameUtilsKt.getDimensionId(level)) == ConnectionStatus.CONNECTED && !toIgnore.contains(otherComponent) && !toIgnore.contains(component)) {
                                toIgnore.add(component);
                            }
                            if (VSGameUtilsKt.getShipObjectWorld((class_3218)level).isIsolatedSolid(otherComponent.method_10263(), otherComponent.method_10264(), otherComponent.method_10260(), VSGameUtilsKt.getDimensionId(level)) != ConnectionStatus.CONNECTED || toIgnore.contains(otherComponent) || toIgnore.contains(component)) continue;
                            toIgnore.add(component);
                        }
                    }
                    disconnected.removeAll((Collection)toIgnore);
                    if (disconnected.isEmpty()) {
                        return;
                    }
                    Object object = loadedShip;
                    if (object != null && (object = object.getAttachment(SplittingDisablerAttachment.class)) != null) {
                        ((SplittingDisablerAttachment)object).disableSplitting();
                    }
                    HashSet<Iterable<Vector3ic>> toAssemble = new HashSet<Iterable<Vector3ic>>();
                    Iterator iterator6 = disconnected.iterator();
                    Intrinsics.checkNotNullExpressionValue(iterator6, (String)"iterator(...)");
                    Iterator iterator7 = iterator6;
                    while (iterator7.hasNext()) {
                        Object e7 = iterator7.next();
                        Intrinsics.checkNotNullExpressionValue(e7, (String)"next(...)");
                        class_2338 starter = (class_2338)e7;
                        visited = new DenseBlockPosSet();
                        HashSet<class_2338> queuedPositions = new HashSet<class_2338>();
                        queuedPositions.add(starter);
                        while (!((Collection)queuedPositions).isEmpty()) {
                            current = (class_2338)CollectionsKt.first((Iterable)queuedPositions);
                            queuedPositions.remove(current);
                            visited.add(VectorConversionsMCKt.toJOML((class_2382)current));
                            HashSet<class_2338> toCheck = new HashSet<class_2338>();
                            Iterator<class_2382> iterator8 = Companion.getOffsets(this.doEdges, this.doCorners).iterator();
                            Intrinsics.checkNotNullExpressionValue(iterator8, (String)"iterator(...)");
                            Iterator<Object> iterator9 = iterator8;
                            while (iterator9.hasNext()) {
                                class_2382 offset;
                                Intrinsics.checkNotNullExpressionValue((Object)iterator9.next(), (String)"next(...)");
                                toCheck.add(new class_2338(current.method_10263() + offset.method_10263(), current.method_10264() + offset.method_10264(), current.method_10260() + offset.method_10260()));
                            }
                            Iterator iterator10 = toCheck.iterator();
                            Intrinsics.checkNotNullExpressionValue(iterator10, (String)"iterator(...)");
                            iterator9 = iterator10;
                            while (iterator9.hasNext()) {
                                Object object2 = iterator9.next();
                                Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"next(...)");
                                class_2338 check = (class_2338)object2;
                                if (visited.contains(VectorConversionsMCKt.toJOML((class_2382)check)) || ((class_3218)level).method_8320(check).method_26215()) continue;
                                queuedPositions.add(check);
                            }
                        }
                        toAssemble.add(visited);
                    }
                    if (toAssemble.isEmpty()) {
                        Object object3 = loadedShip;
                        if (object3 != null && (object3 = object3.getAttachment(SplittingDisablerAttachment.class)) != null) {
                            ((SplittingDisablerAttachment)object3).enableSplitting();
                        }
                        return;
                    }
                    Iterator iterator11 = toAssemble.iterator();
                    Intrinsics.checkNotNullExpressionValue(iterator11, (String)"iterator(...)");
                    iterator7 = iterator11;
                    while (iterator7.hasNext()) {
                        Collection<class_2338> collection;
                        void $this$mapTo$iv$iv;
                        void $this$map$iv;
                        Object e8 = iterator7.next();
                        Intrinsics.checkNotNullExpressionValue(e8, (String)"next(...)");
                        DenseBlockPosSet component = (DenseBlockPosSet)e8;
                        visited = CollectionsKt.toSet((Iterable)component);
                        class_1937 class_19372 = level;
                        ShipAssembler shipAssembler = ShipAssembler.INSTANCE;
                        boolean $i$f$map = false;
                        current = $this$map$iv;
                        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                        boolean $i$f$mapTo = false;
                        for (Object item$iv$iv : $this$mapTo$iv$iv) {
                            void it;
                            Vector3ic vector3ic = (Vector3ic)item$iv$iv;
                            collection = destination$iv$iv;
                            boolean bl = false;
                            Intrinsics.checkNotNull((Object)it);
                            collection.add(VectorConversionsMCKt.toBlockPos((Vector3ic)it));
                        }
                        collection = (List)destination$iv$iv;
                        shipAssembler.assembleToShip(class_19372, (List<? extends class_2338>)collection, true, 1.0, true);
                    }
                    Object object4 = loadedShip;
                    if (object4 != null && (object4 = object4.getAttachment(SplittingDisablerAttachment.class)) != null) {
                        ((SplittingDisablerAttachment)object4).enableSplitting();
                    }
                }
            }
        }
    }

    static {
        Object[] objectArray = new class_2382[]{new class_2382(1, 0, 0), new class_2382(-1, 0, 0), new class_2382(0, 1, 0), new class_2382(0, -1, 0), new class_2382(0, 0, 1), new class_2382(0, 0, -1)};
        offsetsToCheck = CollectionsKt.arrayListOf((Object[])objectArray);
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J-\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR'\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2={"Lorg/valkyrienskies/mod/common/util/SplitHandler$Companion;", "", "", "doEdges", "doCorners", "Ljava/util/ArrayList;", "Lnet/minecraft/class_2382;", "Lkotlin/collections/ArrayList;", "getOffsets", "(ZZ)Ljava/util/ArrayList;", "Lorg/valkyrienskies/mod/util/ClassLogger;", "SPLITLOGGER", "Lorg/apache/logging/log4j/Logger;", "getSPLITLOGGER-oA4EOhA", "()Lorg/apache/logging/log4j/Logger;", "offsetsToCheck", "Ljava/util/ArrayList;", "getOffsetsToCheck", "()Ljava/util/ArrayList;", "<init>", "()V", "valkyrienskies-120"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Logger getSPLITLOGGER-oA4EOhA() {
            return SPLITLOGGER;
        }

        @NotNull
        public final ArrayList<class_2382> getOffsetsToCheck() {
            return offsetsToCheck;
        }

        @NotNull
        public final ArrayList<class_2382> getOffsets(boolean doEdges, boolean doCorners) {
            ArrayList<class_2382> list = new ArrayList<class_2382>((Collection)this.getOffsetsToCheck());
            if (doEdges) {
                list.add(new class_2382(1, 1, 0));
                list.add(new class_2382(1, -1, 0));
                list.add(new class_2382(-1, 1, 0));
                list.add(new class_2382(-1, -1, 0));
                list.add(new class_2382(1, 0, 1));
                list.add(new class_2382(1, 0, -1));
                list.add(new class_2382(-1, 0, 1));
                list.add(new class_2382(-1, 0, -1));
                list.add(new class_2382(0, 1, 1));
                list.add(new class_2382(0, 1, -1));
                list.add(new class_2382(0, -1, 1));
                list.add(new class_2382(0, -1, -1));
            }
            if (doCorners) {
                list.add(new class_2382(1, 1, 1));
                list.add(new class_2382(1, 1, -1));
                list.add(new class_2382(1, -1, 1));
                list.add(new class_2382(1, -1, -1));
                list.add(new class_2382(-1, 1, 1));
                list.add(new class_2382(-1, 1, -1));
                list.add(new class_2382(-1, -1, 1));
                list.add(new class_2382(-1, -1, -1));
            }
            return list;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

