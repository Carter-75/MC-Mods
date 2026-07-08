/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.ArrayDeque
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_2680
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Vector3i
 *  org.joml.Vector3ic
 */
package g_mungus.vlib.v2.internal.assembly;

import g_mungus.vlib.VLib;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_2680;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3i;
import org.joml.Vector3ic;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B%\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\bJ4\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006H\u00c6\u0001\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013H\u00d6\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016H\u00d6\u0001\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\bR\u0017\u0010\f\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001d\u0010\b\u00a8\u0006!"}, d2={"Lg_mungus/vlib/v2/internal/assembly/BoundedVoxelSet;", "", "", "Lnet/minecraft/class_2338;", "component1", "()Ljava/util/Set;", "Lorg/joml/Vector3ic;", "component2", "()Lorg/joml/Vector3ic;", "component3", "voxels", "min", "max", "copy", "(Ljava/util/Set;Lorg/joml/Vector3ic;Lorg/joml/Vector3ic;)Lg_mungus/vlib/v2/internal/assembly/BoundedVoxelSet;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/Set;", "getVoxels", "Lorg/joml/Vector3ic;", "getMin", "getMax", "<init>", "(Ljava/util/Set;Lorg/joml/Vector3ic;Lorg/joml/Vector3ic;)V", "Companion", "vlib"})
public final class BoundedVoxelSet {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Set<class_2338> voxels;
    @NotNull
    private final Vector3ic min;
    @NotNull
    private final Vector3ic max;
    @NotNull
    private static final List<class_2248> defaultBlackList;
    @NotNull
    private static final List<class_2338> STRUCTURE_OFFSETS;

    public BoundedVoxelSet(@NotNull Set<? extends class_2338> voxels, @NotNull Vector3ic min, @NotNull Vector3ic max) {
        Intrinsics.checkNotNullParameter(voxels, (String)"voxels");
        Intrinsics.checkNotNullParameter((Object)min, (String)"min");
        Intrinsics.checkNotNullParameter((Object)max, (String)"max");
        this.voxels = voxels;
        this.min = min;
        this.max = max;
    }

    @NotNull
    public final Set<class_2338> getVoxels() {
        return this.voxels;
    }

    @NotNull
    public final Vector3ic getMin() {
        return this.min;
    }

    @NotNull
    public final Vector3ic getMax() {
        return this.max;
    }

    @NotNull
    public final Set<class_2338> component1() {
        return this.voxels;
    }

    @NotNull
    public final Vector3ic component2() {
        return this.min;
    }

    @NotNull
    public final Vector3ic component3() {
        return this.max;
    }

    @NotNull
    public final BoundedVoxelSet copy(@NotNull Set<? extends class_2338> voxels, @NotNull Vector3ic min, @NotNull Vector3ic max) {
        Intrinsics.checkNotNullParameter(voxels, (String)"voxels");
        Intrinsics.checkNotNullParameter((Object)min, (String)"min");
        Intrinsics.checkNotNullParameter((Object)max, (String)"max");
        return new BoundedVoxelSet(voxels, min, max);
    }

    public static /* synthetic */ BoundedVoxelSet copy$default(BoundedVoxelSet boundedVoxelSet, Set set, Vector3ic vector3ic, Vector3ic vector3ic2, int n, Object object) {
        if ((n & 1) != 0) {
            set = boundedVoxelSet.voxels;
        }
        if ((n & 2) != 0) {
            vector3ic = boundedVoxelSet.min;
        }
        if ((n & 4) != 0) {
            vector3ic2 = boundedVoxelSet.max;
        }
        return boundedVoxelSet.copy(set, vector3ic, vector3ic2);
    }

    @NotNull
    public String toString() {
        return "BoundedVoxelSet(voxels=" + this.voxels + ", min=" + this.min + ", max=" + this.max + ")";
    }

    public int hashCode() {
        int result = ((Object)this.voxels).hashCode();
        result = result * 31 + this.min.hashCode();
        result = result * 31 + this.max.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BoundedVoxelSet)) {
            return false;
        }
        BoundedVoxelSet boundedVoxelSet = (BoundedVoxelSet)other;
        if (!Intrinsics.areEqual(this.voxels, boundedVoxelSet.voxels)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.min, (Object)boundedVoxelSet.min)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.max, (Object)boundedVoxelSet.max);
    }

    static {
        Object[] objectArray = new class_2248[]{class_2246.field_10124, class_2246.field_10543, VLib.INSTANCE.getGHOST_BLOCK()};
        defaultBlackList = CollectionsKt.listOf((Object[])objectArray);
        objectArray = new class_2338[]{new class_2338(1, 0, 0), new class_2338(-1, 0, 0), new class_2338(0, 1, 0), new class_2338(0, -1, 0), new class_2338(0, 0, 1), new class_2338(0, 0, -1), new class_2338(1, 1, 0), new class_2338(-1, 1, 0), new class_2338(1, -1, 0), new class_2338(-1, -1, 0), new class_2338(0, 1, 1), new class_2338(0, -1, 1), new class_2338(0, 1, -1), new class_2338(0, -1, -1), new class_2338(1, 0, 1), new class_2338(-1, 0, 1), new class_2338(1, 0, -1), new class_2338(-1, 0, -1)};
        STRUCTURE_OFFSETS = CollectionsKt.listOf((Object[])objectArray);
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ-\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00070\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001b\u00a8\u0006\u001f"}, d2={"Lg_mungus/vlib/v2/internal/assembly/BoundedVoxelSet$Companion;", "", "Lnet/minecraft/class_1937;", "level", "Lnet/minecraft/class_2338;", "start", "", "Lnet/minecraft/class_2248;", "blackList", "Lg_mungus/vlib/v2/internal/assembly/BoundedVoxelSet;", "tryFillByConnectivity", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;Ljava/util/List;)Lg_mungus/vlib/v2/internal/assembly/BoundedVoxelSet;", "current", "Lorg/joml/Vector3i;", "min", "max", "", "updateBounds", "(Lnet/minecraft/class_2338;Lorg/joml/Vector3i;Lorg/joml/Vector3i;)V", "Lnet/minecraft/class_2680;", "state", "blacklist", "", "isBlockStateValid", "(Lnet/minecraft/class_2680;Ljava/util/List;)Z", "kotlin.jvm.PlatformType", "defaultBlackList", "Ljava/util/List;", "STRUCTURE_OFFSETS", "<init>", "()V", "vlib"})
    @SourceDebugExtension(value={"SMAP\nBoundedVoxelSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BoundedVoxelSet.kt\ng_mungus/vlib/v2/internal/assembly/BoundedVoxelSet$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,109:1\n1734#2,3:110\n*S KotlinDebug\n*F\n+ 1 BoundedVoxelSet.kt\ng_mungus/vlib/v2/internal/assembly/BoundedVoxelSet$Companion\n*L\n81#1:110,3\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final BoundedVoxelSet tryFillByConnectivity(@NotNull class_1937 level, @NotNull class_2338 start, @NotNull List<? extends class_2248> blackList) {
            List list;
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            Intrinsics.checkNotNullParameter((Object)start, (String)"start");
            Intrinsics.checkNotNullParameter(blackList, (String)"blackList");
            List $this$tryFillByConnectivity_u24lambda_u240 = list = (List)new ArrayList();
            boolean bl = false;
            $this$tryFillByConnectivity_u24lambda_u240.addAll(defaultBlackList);
            $this$tryFillByConnectivity_u24lambda_u240.addAll((Collection)blackList);
            List combinedBlackList = list;
            Set result = new LinkedHashSet();
            Set visited = new LinkedHashSet();
            ArrayDeque queue = new ArrayDeque();
            Vector3i min = new Vector3i(Integer.MAX_VALUE);
            Vector3i max = new Vector3i(Integer.MIN_VALUE);
            class_2680 class_26802 = level.method_8320(start);
            Intrinsics.checkNotNullExpressionValue((Object)class_26802, (String)"getBlockState(...)");
            if (!this.isBlockStateValid(class_26802, combinedBlackList)) {
                return null;
            }
            queue.add((Object)start);
            visited.add(start);
            while (!((Collection)queue).isEmpty()) {
                class_2338 current = (class_2338)queue.removeFirst();
                result.add(current);
                this.updateBounds(current, min, max);
                if (result.size() > 131068) {
                    return null;
                }
                for (class_2338 offset : STRUCTURE_OFFSETS) {
                    class_2338 neighbor = current.method_10081((class_2382)offset);
                    if (visited.contains(neighbor)) continue;
                    Intrinsics.checkNotNull((Object)neighbor);
                    visited.add(neighbor);
                    class_2680 blockState = level.method_8320(neighbor);
                    if (blockState.method_27852(class_2246.field_9987)) {
                        return null;
                    }
                    Intrinsics.checkNotNull((Object)blockState);
                    if (!this.isBlockStateValid(blockState, combinedBlackList)) continue;
                    queue.add((Object)neighbor);
                }
            }
            return new BoundedVoxelSet(result, (Vector3ic)min, (Vector3ic)max);
        }

        private final void updateBounds(class_2338 current, Vector3i min, Vector3i max) {
            if (current.method_10263() < min.x) {
                min.x = current.method_10263();
            } else if (current.method_10263() > max.x) {
                max.x = current.method_10263();
            }
            if (current.method_10264() < min.y) {
                min.y = current.method_10264();
            } else if (current.method_10264() > max.y) {
                max.y = current.method_10264();
            }
            if (current.method_10260() < min.z) {
                min.z = current.method_10260();
            } else if (current.method_10260() > max.z) {
                max.z = current.method_10260();
            }
        }

        private final boolean isBlockStateValid(class_2680 state, List<? extends class_2248> blacklist) {
            boolean bl;
            block3: {
                Iterable $this$all$iv = blacklist;
                boolean $i$f$all = false;
                if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                    bl = true;
                } else {
                    for (Object element$iv : $this$all$iv) {
                        class_2248 it = (class_2248)element$iv;
                        boolean bl2 = false;
                        if (!state.method_27852(it)) continue;
                        bl = false;
                        break block3;
                    }
                    bl = true;
                }
            }
            return bl;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

