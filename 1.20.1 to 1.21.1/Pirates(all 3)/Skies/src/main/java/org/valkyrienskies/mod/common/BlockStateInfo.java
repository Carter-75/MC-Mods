/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Lifecycle
 *  it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.comparisons.ComparisonsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2370
 *  net.minecraft.class_2378
 *  net.minecraft.class_2680
 *  net.minecraft.class_2960
 *  net.minecraft.class_3218
 *  net.minecraft.class_5321
 */
package org.valkyrienskies.mod.common;

import com.mojang.serialization.Lifecycle;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2370;
import net.minecraft.class_2378;
import net.minecraft.class_2680;
import net.minecraft.class_2960;
import net.minecraft.class_3218;
import net.minecraft.class_5321;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.event.RegisteredListener;
import org.valkyrienskies.core.api.ships.LoadedServerShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.api.ships.Wing;
import org.valkyrienskies.core.api.ships.WingManager;
import org.valkyrienskies.core.internal.world.VsiShipWorld;
import org.valkyrienskies.core.internal.world.chunks.VsiBlockType;
import org.valkyrienskies.mod.common.BlockStateInfoProvider;
import org.valkyrienskies.mod.common.DefaultBlockStateInfoProvider;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;
import org.valkyrienskies.mod.common.block.WingBlock;
import org.valkyrienskies.mod.common.config.ConfigType;
import org.valkyrienskies.mod.common.config.MassDatapackResolver;
import org.valkyrienskies.mod.common.hooks.VSGameEvents;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u00012B\t\b\u0002\u00a2\u0006\u0004\b1\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0004J#\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000b\u0010\fJ#\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\r\u0010\fJ-\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0014\u0010\u0015J=\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0014\u0010\u001aJ\u001d\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020!0&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R:\u0010,\u001a&\u0012\f\u0012\n +*\u0004\u0018\u00010*0* +*\u0012\u0012\f\u0012\n +*\u0004\u0018\u00010*0*\u0018\u00010)0)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0011\u00100\u001a\u00020*8F\u00a2\u0006\u0006\u001a\u0004\b.\u0010/\u00a8\u00063"}, d2={"Lorg/valkyrienskies/mod/common/BlockStateInfo;", "", "", "init", "()V", "invalidateCache", "Lnet/minecraft/class_2680;", "blockState", "Lkotlin/Pair;", "", "Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;", "get", "(Lnet/minecraft/class_2680;)Lkotlin/Pair;", "iterateRegistry", "Lnet/minecraft/class_1937;", "level", "Lnet/minecraft/class_2338;", "blockPos", "prevBlockState", "newBlockState", "onSetBlock", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;Lnet/minecraft/class_2680;Lnet/minecraft/class_2680;)V", "", "x", "y", "z", "(Lnet/minecraft/class_1937;IIILnet/minecraft/class_2680;Lnet/minecraft/class_2680;)V", "Lorg/valkyrienskies/core/api/ships/Ship;", "ship", "", "remassShip", "(Lnet/minecraft/class_1937;Lorg/valkyrienskies/core/api/ships/Ship;)Z", "Lnet/minecraft/class_2370;", "Lorg/valkyrienskies/mod/common/BlockStateInfoProvider;", "REGISTRY", "Lnet/minecraft/class_2370;", "getREGISTRY", "()Lnet/minecraft/class_2370;", "", "SORTED_REGISTRY", "Ljava/util/List;", "Ljava/lang/ThreadLocal;", "Lorg/valkyrienskies/mod/common/BlockStateInfo$Cache;", "kotlin.jvm.PlatformType", "_cache", "Ljava/lang/ThreadLocal;", "getCache", "()Lorg/valkyrienskies/mod/common/BlockStateInfo$Cache;", "cache", "<init>", "Cache", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nBlockStateInfoProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BlockStateInfoProvider.kt\norg/valkyrienskies/mod/common/BlockStateInfo\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,231:1\n1#2:232\n1863#3,2:233\n1863#3,2:235\n1062#3:237\n1755#3,3:238\n*S KotlinDebug\n*F\n+ 1 BlockStateInfoProvider.kt\norg/valkyrienskies/mod/common/BlockStateInfo\n*L\n189#1:233,2\n214#1:235,2\n55#1:237\n58#1:238,3\n*E\n"})
public final class BlockStateInfo {
    @NotNull
    public static final BlockStateInfo INSTANCE = new BlockStateInfo();
    @NotNull
    private static final class_2370<BlockStateInfoProvider> REGISTRY = new class_2370(class_5321.method_29180((class_2960)new class_2960("valkyrienskies", "blockstate_providers")), Lifecycle.experimental());
    private static List<? extends BlockStateInfoProvider> SORTED_REGISTRY;
    private static ThreadLocal<Cache> _cache;

    private BlockStateInfo() {
    }

    @NotNull
    public final class_2370<BlockStateInfoProvider> getREGISTRY() {
        return REGISTRY;
    }

    public final void init() {
        class_2378.method_10230((class_2378)((class_2378)REGISTRY), (class_2960)new class_2960("valkyrienskies", "data"), (Object)MassDatapackResolver.INSTANCE);
        class_2378.method_10230((class_2378)((class_2378)REGISTRY), (class_2960)new class_2960("valkyrienskies", "default"), (Object)DefaultBlockStateInfoProvider.INSTANCE);
        VSGameEvents.INSTANCE.getRegistriesCompleted().on(BlockStateInfo::init$lambda$1);
        VSGameEvents.INSTANCE.getConfigUpdated().on(arg_0 -> BlockStateInfo.init$lambda$4(BlockStateInfo::init$lambda$3, arg_0));
    }

    @NotNull
    public final Cache getCache() {
        Cache cache2 = _cache.get();
        Intrinsics.checkNotNullExpressionValue((Object)cache2, (String)"get(...)");
        return cache2;
    }

    private final void invalidateCache() {
        _cache = ThreadLocal.withInitial(BlockStateInfo::invalidateCache$lambda$6);
    }

    @Nullable
    public final Pair<Double, VsiBlockType> get(@NotNull class_2680 blockState) {
        Intrinsics.checkNotNullParameter((Object)blockState, (String)"blockState");
        return this.getCache().get(blockState);
    }

    private final Pair<Double, VsiBlockType> iterateRegistry(class_2680 blockState) {
        VsiBlockType vsiBlockType;
        Double d2;
        block9: {
            Double d3;
            block8: {
                List<? extends BlockStateInfoProvider> list = SORTED_REGISTRY;
                if (list == null) {
                    Intrinsics.throwUninitializedPropertyAccessException((String)"SORTED_REGISTRY");
                    list = null;
                }
                for (BlockStateInfoProvider it : (Iterable)list) {
                    boolean bl = false;
                    d3 = it.getBlockStateMass(blockState);
                    if (d3 == null) {
                        continue;
                    }
                    break block8;
                }
                d3 = null;
            }
            if (d3 == null) {
                throw new NoSuchElementException("No element of the collection was transformed to a non-null value.");
            }
            List<? extends BlockStateInfoProvider> list = SORTED_REGISTRY;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"SORTED_REGISTRY");
                list = null;
            }
            Iterable iterable = list;
            d2 = d3;
            for (BlockStateInfoProvider it : iterable) {
                boolean bl = false;
                vsiBlockType = it.getBlockStateType(blockState);
                if (vsiBlockType == null) {
                    continue;
                }
                break block9;
            }
            vsiBlockType = null;
        }
        if (vsiBlockType == null) {
            throw new NoSuchElementException("No element of the collection was transformed to a non-null value.");
        }
        VsiBlockType vsiBlockType2 = vsiBlockType;
        Double d4 = d2;
        return new Pair((Object)d4, (Object)vsiBlockType2);
    }

    public final void onSetBlock(@NotNull class_1937 level, @NotNull class_2338 blockPos, @NotNull class_2680 prevBlockState, @NotNull class_2680 newBlockState) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        Intrinsics.checkNotNullParameter((Object)prevBlockState, (String)"prevBlockState");
        Intrinsics.checkNotNullParameter((Object)newBlockState, (String)"newBlockState");
        this.onSetBlock(level, blockPos.method_10263(), blockPos.method_10264(), blockPos.method_10260(), prevBlockState, newBlockState);
    }

    public final void onSetBlock(@NotNull class_1937 level, int x, int y, int z, @NotNull class_2680 prevBlockState, @NotNull class_2680 newBlockState) {
        LoadedServerShip loadedShip;
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)prevBlockState, (String)"prevBlockState");
        Intrinsics.checkNotNullParameter((Object)newBlockState, (String)"newBlockState");
        if (SORTED_REGISTRY == null) {
            return;
        }
        VsiShipWorld shipObjectWorld = VSGameUtilsKt.getShipObjectWorld(level);
        Pair<Double, VsiBlockType> pair = this.get(prevBlockState);
        if (pair == null) {
            return;
        }
        Pair<Double, VsiBlockType> pair2 = pair;
        double prevBlockMass = ((Number)pair2.component1()).doubleValue();
        VsiBlockType prevBlockType = (VsiBlockType)pair2.component2();
        Pair<Double, VsiBlockType> pair3 = this.get(newBlockState);
        if (pair3 == null) {
            return;
        }
        Pair<Double, VsiBlockType> pair4 = pair3;
        double newBlockMass = ((Number)pair4.component1()).doubleValue();
        VsiBlockType newBlockType = (VsiBlockType)pair4.component2();
        if (level instanceof class_3218 && (loadedShip = VSGameUtilsKt.getLoadedShipManagingPos((class_3218)level, x >> 4, z >> 4)) != null) {
            Wing newWing;
            WingManager wingManager = loadedShip.getWingManager();
            Intrinsics.checkNotNull((Object)wingManager);
            WingManager wingManager2 = wingManager;
            boolean wasOldBlockWing = prevBlockState.method_26204() instanceof WingBlock;
            class_2248 newBlockStateBlock = newBlockState.method_26204();
            Wing wing = newWing = newBlockStateBlock instanceof WingBlock ? ((WingBlock)newBlockStateBlock).getWing(level, new class_2338(x, y, z), newBlockState) : null;
            if (newWing != null) {
                wingManager2.setWing(wingManager2.getFirstWingGroupId(), x, y, z, newWing);
            } else if (wasOldBlockWing) {
                wingManager2.setWing(wingManager2.getFirstWingGroupId(), x, y, z, null);
            }
        }
        shipObjectWorld.onSetBlock(x, y, z, VSGameUtilsKt.getDimensionId(level), prevBlockType, newBlockType, prevBlockMass, newBlockMass);
        if (ValkyrienSkiesMod.getVsCore().getHooks().getEnableConnectivity()) {
            ValkyrienSkiesMod.getSplitHandler().split(level, x, y, z, newBlockState);
        }
    }

    public final boolean remassShip(@NotNull class_1937 level, @NotNull Ship ship) {
        VsiBlockType realBlockType;
        double realBlockMass;
        Pair<Double, VsiBlockType> pair;
        class_2680 state;
        class_2338 it;
        Iterable $this$forEach$iv;
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
        if (!(level instanceof class_3218)) {
            return false;
        }
        if (!(ship instanceof LoadedServerShip)) {
            return false;
        }
        if (SORTED_REGISTRY == null) {
            return false;
        }
        AABBic aabb = ship.getShipAABB();
        if (aabb == null) {
            return false;
        }
        boolean wasStatic = ((LoadedServerShip)ship).isStatic();
        ((LoadedServerShip)ship).setStatic(true);
        class_2680 class_26802 = class_2246.field_10124.method_9564();
        Intrinsics.checkNotNullExpressionValue((Object)class_26802, (String)"defaultBlockState(...)");
        Pair<Double, VsiBlockType> pair2 = this.get(class_26802);
        if (pair2 == null) {
            return false;
        }
        Pair<Double, VsiBlockType> pair3 = pair2;
        double airBlockMass = ((Number)pair3.component1()).doubleValue();
        VsiBlockType airBlockType = (VsiBlockType)pair3.component2();
        Iterable iterable = class_2338.method_10094((int)aabb.minX(), (int)aabb.minY(), (int)aabb.minZ(), (int)aabb.maxX(), (int)aabb.maxY(), (int)aabb.maxZ());
        Intrinsics.checkNotNullExpressionValue((Object)iterable, (String)"betweenClosed(...)");
        Iterable iterable2 = iterable;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            it = (class_2338)element$iv;
            boolean bl = false;
            state = ((class_3218)level).method_8320(it);
            Intrinsics.checkNotNull((Object)state);
            if (INSTANCE.get(state) == null) {
                return false;
            }
            realBlockMass = ((Number)pair.component1()).doubleValue();
            realBlockType = (VsiBlockType)pair.component2();
            if (Intrinsics.areEqual((Object)realBlockType, (Object)airBlockType)) continue;
            VSGameUtilsKt.getShipObjectWorld((class_3218)level).onSetBlock(it.method_10263(), it.method_10264(), it.method_10260(), VSGameUtilsKt.getDimensionId(level), realBlockType, airBlockType, 0.0, 0.0);
        }
        VSGameUtilsKt.getShipObjectWorld((class_3218)level).onSetBlock(aabb.minX(), aabb.minY(), aabb.minZ(), VSGameUtilsKt.getDimensionId(level), airBlockType, airBlockType, ((LoadedServerShip)ship).getInertiaData().getMass(), 0.0);
        Iterable iterable3 = class_2338.method_10094((int)aabb.minX(), (int)aabb.minY(), (int)aabb.minZ(), (int)aabb.maxX(), (int)aabb.maxY(), (int)aabb.maxZ());
        Intrinsics.checkNotNullExpressionValue((Object)iterable3, (String)"betweenClosed(...)");
        $this$forEach$iv = iterable3;
        $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            it = (class_2338)element$iv;
            boolean bl = false;
            state = ((class_3218)level).method_8320(it);
            Intrinsics.checkNotNull((Object)state);
            if (INSTANCE.get(state) == null) {
                return false;
            }
            realBlockMass = ((Number)pair.component1()).doubleValue();
            realBlockType = (VsiBlockType)pair.component2();
            if (Intrinsics.areEqual((Object)realBlockType, (Object)airBlockType)) continue;
            VSGameUtilsKt.getShipObjectWorld((class_3218)level).onSetBlock(it.method_10263(), it.method_10264(), it.method_10260(), VSGameUtilsKt.getDimensionId(level), airBlockType, realBlockType, 0.0, realBlockMass);
        }
        ((LoadedServerShip)ship).setStatic(wasStatic);
        return true;
    }

    private static final void init$lambda$1(Unit unit, RegisteredListener registeredListener) {
        Intrinsics.checkNotNullParameter((Object)unit, (String)"<unused var>");
        Intrinsics.checkNotNullParameter((Object)registeredListener, (String)"<unused var>");
        Iterable $this$sortedByDescending$iv = (Iterable)REGISTRY;
        boolean $i$f$sortedByDescending = false;
        SORTED_REGISTRY = CollectionsKt.sortedWith((Iterable)$this$sortedByDescending$iv, (Comparator)new Comparator(){

            public final int compare(T a2, T b2) {
                BlockStateInfoProvider it = (BlockStateInfoProvider)b2;
                boolean bl = false;
                Comparable comparable = Integer.valueOf(it.getPriority());
                it = (BlockStateInfoProvider)a2;
                Comparable comparable2 = comparable;
                bl = false;
                return ComparisonsKt.compareValues((Comparable)comparable2, (Comparable)Integer.valueOf(it.getPriority()));
            }
        });
    }

    private static final Unit init$lambda$3(Set entries2) {
        boolean defaultMassChanged;
        block4: {
            Intrinsics.checkNotNullParameter((Object)entries2, (String)"entries");
            Iterable $this$any$iv = entries2;
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                v0 = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    VSGameEvents.ConfigUpdateEntry it = (VSGameEvents.ConfigUpdateEntry)element$iv;
                    boolean bl = false;
                    if (!(it.getConfigType() == ConfigType.SERVER && Intrinsics.areEqual((Object)it.getName(), (Object)"defaultBlockMass"))) continue;
                    v0 = true;
                    break block4;
                }
                v0 = defaultMassChanged = false;
            }
        }
        if (defaultMassChanged) {
            INSTANCE.invalidateCache();
        }
        return Unit.INSTANCE;
    }

    private static final void init$lambda$4(Function1 $tmp0, Object p0) {
        Intrinsics.checkNotNullParameter((Object)$tmp0, (String)"$tmp0");
        $tmp0.invoke(p0);
    }

    private static final Cache _cache$lambda$5() {
        return new Cache();
    }

    private static final Cache invalidateCache$lambda$6() {
        return new Cache();
    }

    static {
        _cache = ThreadLocal.withInitial(BlockStateInfo::_cache$lambda$5);
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR&\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2={"Lorg/valkyrienskies/mod/common/BlockStateInfo$Cache;", "", "Lnet/minecraft/class_2680;", "blockState", "Lkotlin/Pair;", "", "Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;", "get", "(Lnet/minecraft/class_2680;)Lkotlin/Pair;", "Lit/unimi/dsi/fastutil/ints/Int2ObjectOpenHashMap;", "blockStateCache", "Lit/unimi/dsi/fastutil/ints/Int2ObjectOpenHashMap;", "<init>", "()V", "valkyrienskies-120"})
    public static final class Cache {
        @NotNull
        private final Int2ObjectOpenHashMap<Pair<Double, VsiBlockType>> blockStateCache = new Int2ObjectOpenHashMap(2048, 0.5f);

        @Nullable
        public final Pair<Double, VsiBlockType> get(@NotNull class_2680 blockState) {
            Intrinsics.checkNotNullParameter((Object)blockState, (String)"blockState");
            int blockId = class_2248.method_9507((class_2680)blockState);
            if (blockId == -1) {
                return null;
            }
            return (Pair)this.blockStateCache.computeIfAbsent(blockId, arg_0 -> Cache.get$lambda$0(blockState, arg_0));
        }

        private static final Pair get$lambda$0(class_2680 $blockState, int it) {
            Intrinsics.checkNotNullParameter((Object)$blockState, (String)"$blockState");
            return INSTANCE.iterateRegistry($blockState);
        }
    }
}

