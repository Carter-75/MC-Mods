/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Ref$BooleanRef
 *  kotlin.jvm.internal.Ref$IntRef
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.math.MathKt
 *  kotlin.ranges.RangesKt
 *  kotlin.reflect.KProperty
 *  net.minecraft.class_1922
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2586
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_2960
 *  net.minecraft.class_3300
 *  net.minecraft.class_3609
 *  net.minecraft.class_3610
 *  net.minecraft.class_3612
 *  net.minecraft.class_3695
 *  net.minecraft.class_4309
 *  net.minecraft.class_5321
 *  net.minecraft.class_6862
 *  net.minecraft.class_6880
 *  net.minecraft.class_7923
 *  net.minecraft.class_7924
 */
package org.valkyrienskies.mod.common.config;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_1922;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2586;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2960;
import net.minecraft.class_3300;
import net.minecraft.class_3609;
import net.minecraft.class_3610;
import net.minecraft.class_3612;
import net.minecraft.class_3695;
import net.minecraft.class_4309;
import net.minecraft.class_5321;
import net.minecraft.class_6862;
import net.minecraft.class_6880;
import net.minecraft.class_7923;
import net.minecraft.class_7924;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;
import org.joml.primitives.AABBi;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.event.RegisteredListener;
import org.valkyrienskies.core.api.physics.blockstates.BoxesBlockShape;
import org.valkyrienskies.core.api.physics.blockstates.CollisionPoint;
import org.valkyrienskies.core.api.physics.blockstates.LiquidState;
import org.valkyrienskies.core.api.physics.blockstates.SolidBlockShape;
import org.valkyrienskies.core.api.physics.blockstates.SolidState;
import org.valkyrienskies.core.internal.physics.blockstates.VsiBlockState;
import org.valkyrienskies.core.internal.world.chunks.VsiBlockType;
import org.valkyrienskies.core.util.events.EventEmitterImpl;
import org.valkyrienskies.mod.api_impl.events.RegisterBlockStateEventImpl;
import org.valkyrienskies.mod.common.BlockStateInfoProvider;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;
import org.valkyrienskies.mod.common.config.VSBlockStateInfo;
import org.valkyrienskies.mod.common.config.VSGameConfig;
import org.valkyrienskies.mod.common.hooks.VSGameEvents;
import org.valkyrienskies.mod.mixin.accessors.world.level.block.SlabBlockAccessor;
import org.valkyrienskies.mod.mixin.accessors.world.level.block.StairBlockAccessor;
import org.valkyrienskies.mod.util.ClassLogger;
import org.valkyrienskies.mod.util.LoggingKt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001BB\t\b\u0002\u00a2\u0006\u0004\bA\u0010 J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u0010H\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001d\u001a\u00020\u001c2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u001cH\u0002\u00a2\u0006\u0004\b\u001f\u0010 R \u0010#\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\"0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R \u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020&0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020&0)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0011\u00101\u001a\u00020.8F\u00a2\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00104\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b2\u00103R$\u00107\u001a\u0002052\u0006\u00106\u001a\u0002058\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001b\u0010@\u001a\u00020;8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\u00a8\u0006C"}, d2={"Lorg/valkyrienskies/mod/common/config/MassDatapackResolver;", "Lorg/valkyrienskies/mod/common/BlockStateInfoProvider;", "Lnet/minecraft/class_2680;", "blockState", "", "getBlockStateMass", "(Lnet/minecraft/class_2680;)Ljava/lang/Double;", "Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;", "getBlockStateType", "(Lnet/minecraft/class_2680;)Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;", "Lnet/minecraft/class_2960;", "resourceLocation", "", "decideDefaultPriority", "(Lnet/minecraft/class_2960;)I", "", "Lnet/minecraft/class_265;", "stairShapes", "", "Lorg/valkyrienskies/core/api/physics/blockstates/SolidBlockShape;", "generateStairCollisionShapes", "([Lnet/minecraft/class_265;)Ljava/util/Map;", "voxelShape", "Lorg/valkyrienskies/core/api/physics/blockstates/BoxesBlockShape;", "generateShapeFromVoxel", "(Lnet/minecraft/class_265;)Lorg/valkyrienskies/core/api/physics/blockstates/BoxesBlockShape;", "", "blockStates", "", "registerAllBlockStates", "(Ljava/lang/Iterable;)V", "runRegisterBlockStateEvent", "()V", "Ljava/util/HashMap;", "Lorg/valkyrienskies/mod/common/config/VSBlockStateInfo;", "map", "Ljava/util/HashMap;", "", "Lorg/valkyrienskies/core/internal/physics/blockstates/VsiBlockState;", "mcBlockStateToVs", "Ljava/util/Map;", "", "blockStateData", "Ljava/util/Collection;", "getBlockStateData", "()Ljava/util/Collection;", "Lorg/valkyrienskies/mod/common/config/MassDatapackResolver$VSMassDataLoader;", "getLoader", "()Lorg/valkyrienskies/mod/common/config/MassDatapackResolver$VSMassDataLoader;", "loader", "getPriority", "()I", "priority", "", "value", "registeredBlocks", "Z", "getRegisteredBlocks", "()Z", "Lorg/apache/logging/log4j/Logger;", "logger$delegate", "Lorg/apache/logging/log4j/Logger;", "getLogger", "()Lorg/apache/logging/log4j/Logger;", "logger", "<init>", "VSMassDataLoader", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nMassDatapackResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MassDatapackResolver.kt\norg/valkyrienskies/mod/common/config/MassDatapackResolver\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,403:1\n13402#2:404\n13403#2:408\n1872#3,3:405\n1863#3,2:409\n*S KotlinDebug\n*F\n+ 1 MassDatapackResolver.kt\norg/valkyrienskies/mod/common/config/MassDatapackResolver\n*L\n197#1:404\n197#1:408\n202#1:405,3\n339#1:409,2\n*E\n"})
public final class MassDatapackResolver
implements BlockStateInfoProvider {
    @NotNull
    public static final MassDatapackResolver INSTANCE;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private static final HashMap<class_2960, VSBlockStateInfo> map;
    @NotNull
    private static final Map<class_2680, VsiBlockState> mcBlockStateToVs;
    @NotNull
    private static final Collection<VsiBlockState> blockStateData;
    private static boolean registeredBlocks;
    @NotNull
    private static final Logger logger$delegate;

    private MassDatapackResolver() {
    }

    @NotNull
    public final Collection<VsiBlockState> getBlockStateData() {
        return blockStateData;
    }

    @NotNull
    public final VSMassDataLoader getLoader() {
        return new VSMassDataLoader();
    }

    @Override
    public int getPriority() {
        return 100;
    }

    @Override
    @Nullable
    public Double getBlockStateMass(@NotNull class_2680 blockState) {
        Intrinsics.checkNotNullParameter((Object)blockState, (String)"blockState");
        VSBlockStateInfo vSBlockStateInfo = map.get(class_7923.field_41175.method_10221((Object)blockState.method_26204()));
        return vSBlockStateInfo != null ? Double.valueOf(vSBlockStateInfo.getMass()) : null;
    }

    @Override
    @Nullable
    public VsiBlockType getBlockStateType(@NotNull class_2680 blockState) {
        Intrinsics.checkNotNullParameter((Object)blockState, (String)"blockState");
        VsiBlockState vsiBlockState = mcBlockStateToVs.get(blockState);
        if (vsiBlockState == null) {
            return null;
        }
        VsiBlockState vsState = vsiBlockState;
        return VSGameUtilsKt.getVsCore().getBlockTypes().getType(vsState);
    }

    public final boolean getRegisteredBlocks() {
        return registeredBlocks;
    }

    public final int decideDefaultPriority(@NotNull class_2960 resourceLocation) {
        Intrinsics.checkNotNullParameter((Object)resourceLocation, (String)"resourceLocation");
        return resourceLocation.method_12836().equals("valkyrienskies") ? 50 : (resourceLocation.method_12836().equals("custom") ? 1000 : 100);
    }

    /*
     * WARNING - void declaration
     */
    @JvmStatic
    @NotNull
    public static final Map<class_265, SolidBlockShape> generateStairCollisionShapes(@NotNull class_265[] stairShapes) {
        Intrinsics.checkNotNullParameter((Object)stairShapes, (String)"stairShapes");
        Object[] objectArray = new CollisionPoint[]{new CollisionPoint(0.25f, 0.25f, 0.25f, 0.25f), new CollisionPoint(0.25f, 0.25f, 0.75f, 0.25f), new CollisionPoint(0.25f, 0.75f, 0.25f, 0.25f), new CollisionPoint(0.25f, 0.75f, 0.75f, 0.25f), new CollisionPoint(0.75f, 0.25f, 0.25f, 0.25f), new CollisionPoint(0.75f, 0.25f, 0.75f, 0.25f), new CollisionPoint(0.75f, 0.75f, 0.25f, 0.25f), new CollisionPoint(0.75f, 0.75f, 0.75f, 0.25f)};
        List testPoints = CollectionsKt.listOf((Object[])objectArray);
        Object[] objectArray2 = new AABBi[]{new AABBi(0, 0, 0, 7, 7, 7), new AABBi(0, 0, 8, 7, 7, 15), new AABBi(0, 8, 0, 7, 15, 7), new AABBi(0, 8, 8, 7, 15, 15), new AABBi(8, 0, 0, 15, 7, 7), new AABBi(8, 0, 8, 15, 7, 15), new AABBi(8, 8, 0, 15, 15, 7), new AABBi(8, 8, 8, 15, 15, 15)};
        List testBoxes = CollectionsKt.listOf((Object[])objectArray2);
        Map map2 = new HashMap();
        class_265[] $this$forEach$iv = stairShapes;
        boolean $i$f$forEach = false;
        int n2 = $this$forEach$iv.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            class_265 element$iv;
            class_265 stairShape = element$iv = $this$forEach$iv[i2];
            boolean bl = false;
            List points = new ArrayList();
            List positiveBoxes = new ArrayList();
            List negativeBoxes = new ArrayList();
            Iterable $this$forEachIndexed$iv = testPoints;
            boolean $i$f$forEachIndexed = false;
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                void testPoint;
                int n3;
                if ((n3 = index$iv++) < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                CollisionPoint collisionPoint = (CollisionPoint)item$iv;
                int index = n3;
                boolean bl2 = false;
                Ref.BooleanRef added = new Ref.BooleanRef();
                stairShape.method_1089((arg_0, arg_1, arg_2, arg_3, arg_4, arg_5) -> MassDatapackResolver.generateStairCollisionShapes$lambda$2$lambda$1$lambda$0((CollisionPoint)testPoint, points, added, arg_0, arg_1, arg_2, arg_3, arg_4, arg_5));
                boolean bl3 = added.element ? positiveBoxes.add(testBoxes.get(index)) : negativeBoxes.add(testBoxes.get(index));
            }
            BoxesBlockShape collisionShape = VSGameUtilsKt.getVsCore().newSolidStateBoxesShapeBuilder().addCollisionPoints(points).addPositiveBoxes((Iterable<? extends AABBic>)VSGameUtilsKt.getVsCore().getSolidShapeUtils().mergeBoxes(positiveBoxes)).addNegativeBoxes((Iterable<? extends AABBic>)VSGameUtilsKt.getVsCore().getSolidShapeUtils().mergeBoxes(negativeBoxes)).build();
            map2.put(stairShape, collisionShape);
        }
        return map2;
    }

    @JvmStatic
    @Nullable
    public static final BoxesBlockShape generateShapeFromVoxel(@NotNull class_265 voxelShape) {
        BoxesBlockShape boxesBlockShape;
        Intrinsics.checkNotNullParameter((Object)voxelShape, (String)"voxelShape");
        ArrayList posBoxes = new ArrayList();
        Ref.BooleanRef failed = new Ref.BooleanRef();
        Ref.IntRef maxBoxesToTest = new Ref.IntRef();
        maxBoxesToTest.element = 20;
        voxelShape.method_1089((arg_0, arg_1, arg_2, arg_3, arg_4, arg_5) -> MassDatapackResolver.generateShapeFromVoxel$lambda$3(failed, posBoxes, maxBoxesToTest, arg_0, arg_1, arg_2, arg_3, arg_4, arg_5));
        if (!failed.element) {
            BoxesBlockShape boxesBlockShape2;
            try {
                boxesBlockShape2 = VSGameUtilsKt.getVsCore().getSolidShapeUtils().generateShapeFromBoxes(posBoxes);
            }
            catch (IllegalArgumentException ex) {
                System.out.println((Object)("WTF ERROR WHILE PROCESSING " + voxelShape));
                boxesBlockShape2 = null;
            }
            boxesBlockShape = boxesBlockShape2;
        } else {
            boxesBlockShape = null;
        }
        return boxesBlockShape;
    }

    public final void registerAllBlockStates(@NotNull Iterable<? extends class_2680> blockStates) {
        Intrinsics.checkNotNullParameter(blockStates, (String)"blockStates");
        AABBi fullLodBoundingBox = new AABBi(0, 0, 0, 15, 15, 15);
        Object[] objectArray = new CollisionPoint[]{new CollisionPoint(0.25f, 0.25f, 0.25f, 0.25f), new CollisionPoint(0.25f, 0.25f, 0.75f, 0.25f), new CollisionPoint(0.25f, 0.75f, 0.25f, 0.25f), new CollisionPoint(0.25f, 0.75f, 0.75f, 0.25f), new CollisionPoint(0.75f, 0.25f, 0.25f, 0.25f), new CollisionPoint(0.75f, 0.25f, 0.75f, 0.25f), new CollisionPoint(0.75f, 0.75f, 0.25f, 0.25f), new CollisionPoint(0.75f, 0.75f, 0.75f, 0.25f)};
        List fullBlockCollisionPoints = CollectionsKt.listOf((Object[])objectArray);
        BoxesBlockShape fullBlockCollisionShape = VSGameUtilsKt.getVsCore().newSolidStateBoxesShapeBuilder().addCollisionPoints(fullBlockCollisionPoints).addPositiveBox(fullLodBoundingBox).build();
        class_1922 dummyBlockGetter2 = new class_1922(){

            public int method_31605() {
                return 255;
            }

            public int method_31607() {
                return 0;
            }

            public class_2586 method_8321(class_2338 blockPos) {
                Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
                return null;
            }

            public class_2680 method_8320(class_2338 blockPos) {
                Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
                class_2680 class_26802 = class_2246.field_10243.method_9564();
                Intrinsics.checkNotNullExpressionValue((Object)class_26802, (String)"defaultBlockState(...)");
                return class_26802;
            }

            public class_3610 method_8316(class_2338 blockPos) {
                Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
                class_3610 class_36102 = class_3612.field_15906.method_15785();
                Intrinsics.checkNotNullExpressionValue((Object)class_36102, (String)"defaultFluidState(...)");
                return class_36102;
            }
        };
        class_265[] class_265Array = StairBlockAccessor.getTopShapes();
        Intrinsics.checkNotNullExpressionValue((Object)class_265Array, (String)"getTopShapes(...)");
        Object[] objectArray2 = class_265Array;
        class_265[] class_265Array2 = StairBlockAccessor.getBottomShapes();
        Intrinsics.checkNotNullExpressionValue((Object)class_265Array2, (String)"getBottomShapes(...)");
        Map<class_265, SolidBlockShape> voxelShapeToCollisionShapeMap = MassDatapackResolver.generateStairCollisionShapes((class_265[])ArraysKt.plus((Object[])ArraysKt.plus((Object[])ArraysKt.plus((Object[])objectArray2, (Object[])class_265Array2), (Object)SlabBlockAccessor.getBottomAABB()), (Object)SlabBlockAccessor.getTopAABB()));
        HashMap generatedCollisionShapesMap = new HashMap();
        Pair[] pairArray = new Pair[]{TuplesKt.to((Object)class_3612.field_15910, (Object)new Pair((Object)1000.0, (Object)0.3)), TuplesKt.to((Object)class_3612.field_15908, (Object)new Pair((Object)10000.0, (Object)1.0)), TuplesKt.to((Object)class_3612.field_15909, (Object)new Pair((Object)1000.0, (Object)0.3)), TuplesKt.to((Object)class_3612.field_15907, (Object)new Pair((Object)10000.0, (Object)1.0))};
        Map liquidMaterialToDensityMap = MapsKt.mapOf((Pair[])pairArray);
        HashMap<class_3610, LiquidState> fluidStateToBlockTypeMap = new HashMap<class_3610, LiquidState>();
        Iterable<? extends class_2680> $this$forEach$iv = blockStates;
        boolean $i$f$forEach = false;
        Iterator<? extends class_2680> iterator2 = $this$forEach$iv.iterator();
        while (iterator2.hasNext()) {
            class_2680 element$iv;
            class_2680 blockState = element$iv = iterator2.next();
            boolean bl = false;
            VsiBlockState vsBlockState = null;
            if (blockState.method_26215()) {
                vsBlockState = VSGameUtilsKt.getVsCore().getBlockTypes().getAirState();
            } else {
                VsiBlockState vsiBlockState;
                if (blockState.method_51176()) {
                    class_3610 class_36102 = blockState.method_26227();
                    Intrinsics.checkNotNullExpressionValue((Object)class_36102, (String)"getFluidState(...)");
                    vsiBlockState = new VsiBlockState(null, MassDatapackResolver.registerAllBlockStates$getFluidState(fluidStateToBlockTypeMap, liquidMaterialToDensityMap, class_36102));
                } else {
                    LiquidState liquidState;
                    SolidBlockShape solidBlockShape;
                    class_265 voxelShape = null;
                    voxelShape = blockState.method_51367() ? blockState.method_26218(dummyBlockGetter2, class_2338.field_10980) : blockState.method_26220(dummyBlockGetter2, class_2338.field_10980);
                    if (voxelShapeToCollisionShapeMap.containsKey(voxelShape)) {
                        SolidBlockShape solidBlockShape2 = voxelShapeToCollisionShapeMap.get(voxelShape);
                        Intrinsics.checkNotNull((Object)solidBlockShape2);
                        solidBlockShape = solidBlockShape2;
                    } else if (((Map)generatedCollisionShapesMap).containsKey(voxelShape)) {
                        if (generatedCollisionShapesMap.get(voxelShape) != null) {
                            Object v = generatedCollisionShapesMap.get(voxelShape);
                            Intrinsics.checkNotNull(v);
                            solidBlockShape = (SolidBlockShape)v;
                        } else {
                            solidBlockShape = fullBlockCollisionShape;
                        }
                    } else {
                        BoxesBlockShape generated = MassDatapackResolver.generateShapeFromVoxel(voxelShape);
                        ((Map)generatedCollisionShapesMap).put(voxelShape, generated);
                        BoxesBlockShape boxesBlockShape = generated;
                        if (boxesBlockShape == null) {
                            boxesBlockShape = fullBlockCollisionShape;
                        }
                        solidBlockShape = boxesBlockShape;
                    }
                    SolidBlockShape collisionShape = solidBlockShape;
                    VSBlockStateInfo vsBlockStateInfo = map.get(class_7923.field_41175.method_10221((Object)blockState.method_26204()));
                    VSBlockStateInfo vSBlockStateInfo = vsBlockStateInfo;
                    VSBlockStateInfo vSBlockStateInfo2 = vsBlockStateInfo;
                    SolidState solidState = VSGameUtilsKt.getVsCore().newSolidStateBuilder().shape(collisionShape).elasticity(vSBlockStateInfo != null ? vSBlockStateInfo.getElasticity() : VSGameConfig.SERVER.getDefaultBlockElasticity()).friction(vSBlockStateInfo2 != null ? vSBlockStateInfo2.getFriction() : VSGameConfig.SERVER.getDefaultBlockFriction()).hardness(VSGameConfig.SERVER.getDefaultBlockHardness()).build();
                    if (!blockState.method_26227().method_15769()) {
                        class_3610 class_36103 = blockState.method_26227();
                        Intrinsics.checkNotNullExpressionValue((Object)class_36103, (String)"getFluidState(...)");
                        liquidState = MassDatapackResolver.registerAllBlockStates$getFluidState(fluidStateToBlockTypeMap, liquidMaterialToDensityMap, class_36103);
                    } else {
                        liquidState = null;
                    }
                    LiquidState fluidState = liquidState;
                    vsiBlockState = new VsiBlockState(solidState, fluidState);
                }
                vsBlockState = vsiBlockState;
            }
            mcBlockStateToVs.put(blockState, vsBlockState);
        }
        this.runRegisterBlockStateEvent();
        registeredBlocks = true;
    }

    private final void runRegisterBlockStateEvent() {
        RegisterBlockStateEventImpl event = new RegisterBlockStateEventImpl();
        ((EventEmitterImpl)ValkyrienSkiesMod.getApi().getRegisterBlockStateEvent()).emit(event);
        MapsKt.putAll(mcBlockStateToVs, (Iterable)event.getToRegister());
    }

    private final Logger getLogger() {
        return ClassLogger.getValue-impl(logger$delegate, this, $$delegatedProperties[0]);
    }

    private static final void generateStairCollisionShapes$lambda$2$lambda$1$lambda$0(CollisionPoint $testPoint, List $points, Ref.BooleanRef $added, double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        Intrinsics.checkNotNullParameter((Object)$testPoint, (String)"$testPoint");
        Intrinsics.checkNotNullParameter((Object)$points, (String)"$points");
        Intrinsics.checkNotNullParameter((Object)$added, (String)"$added");
        double d2 = $testPoint.getX();
        boolean bl = minX <= d2 ? d2 <= maxX : false;
        if (bl) {
            d2 = $testPoint.getY();
            boolean bl2 = minY <= d2 ? d2 <= maxY : false;
            if (bl2) {
                d2 = $testPoint.getZ();
                boolean bl3 = minZ <= d2 ? d2 <= maxZ : false;
                if (bl3) {
                    $points.add($testPoint);
                    $added.element = true;
                    return;
                }
            }
        }
    }

    private static final void generateShapeFromVoxel$lambda$3(Ref.BooleanRef $failed, ArrayList $posBoxes, Ref.IntRef $maxBoxesToTest, double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        int lodMaxZ;
        int lodMaxY;
        int lodMaxX;
        int lodMinZ;
        int lodMinY;
        int lodMinX;
        block7: {
            block6: {
                Intrinsics.checkNotNullParameter((Object)$failed, (String)"$failed");
                Intrinsics.checkNotNullParameter((Object)$posBoxes, (String)"$posBoxes");
                Intrinsics.checkNotNullParameter((Object)$maxBoxesToTest, (String)"$maxBoxesToTest");
                if ($failed.element) {
                    return;
                }
                lodMinX = MathKt.roundToInt((double)(minX * (double)16));
                lodMinY = MathKt.roundToInt((double)(minY * (double)16));
                lodMinZ = MathKt.roundToInt((double)(minZ * (double)16));
                lodMaxX = MathKt.roundToInt((double)(maxX * (double)16)) - 1;
                lodMaxY = MathKt.roundToInt((double)(maxY * (double)16)) - 1;
                lodMaxZ = MathKt.roundToInt((double)(maxZ * (double)16)) - 1;
                boolean bl = 0 <= lodMinX ? lodMinX < 16 : false;
                if (!bl) break block6;
                boolean bl2 = 0 <= lodMinY ? lodMinY < 16 : false;
                if (!bl2) break block6;
                boolean bl3 = 0 <= lodMinZ ? lodMinZ < 16 : false;
                if (!bl3) break block6;
                boolean bl4 = 0 <= lodMaxX ? lodMaxX < 16 : false;
                if (!bl4) break block6;
                boolean bl5 = 0 <= lodMaxY ? lodMaxY < 16 : false;
                if (!bl5) break block6;
                if (0 <= lodMaxZ ? lodMaxZ < 16 : false) break block7;
            }
            $failed.element = true;
            return;
        }
        $posBoxes.add(new AABBi(lodMinX, lodMinY, lodMinZ, lodMaxX, lodMaxY, lodMaxZ));
        if ($maxBoxesToTest.element == 0) {
            $failed.element = true;
        } else {
            int n2 = $maxBoxesToTest.element;
            $maxBoxesToTest.element = n2 + -1;
        }
    }

    private static final LiquidState registerAllBlockStates$getFluidState(HashMap<class_3610, LiquidState> fluidStateToBlockTypeMap, Map<class_3609, Pair<Double, Double>> liquidMaterialToDensityMap, class_3610 fluidState) {
        LiquidState liquidState;
        LiquidState cached;
        LiquidState liquidState2 = cached = fluidStateToBlockTypeMap.get(fluidState);
        if (liquidState2 != null) {
            return liquidState2;
        }
        int maxY = RangesKt.coerceIn((int)(MathKt.roundToInt((double)((double)fluidState.method_20785() * 16.0)) - 1), (int)0, (int)15);
        AABBi fluidBox = new AABBi(0, 0, 0, 15, maxY, 15);
        if (liquidMaterialToDensityMap.containsKey(fluidState.method_15772())) {
            LiquidState newFluidBlockState;
            Pair<Double, Double> pair = liquidMaterialToDensityMap.get(fluidState.method_15772());
            Intrinsics.checkNotNull(pair);
            Pair<Double, Double> pair2 = pair;
            double density = ((Number)pair2.component1()).doubleValue();
            double dragCoefficient = ((Number)pair2.component2()).doubleValue();
            liquidState = newFluidBlockState = VSGameUtilsKt.getVsCore().newLiquidStateBuilder().boxShape(fluidBox).density(density).dragCoefficient(dragCoefficient).velocity(new Vector3d()).build();
        } else {
            LiquidState liquidState3 = VSGameUtilsKt.getVsCore().getBlockTypes().getWaterState().getLiquidState();
            liquidState = liquidState3;
            Intrinsics.checkNotNull((Object)liquidState3);
        }
        return liquidState;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(MassDatapackResolver.class, "logger", "getLogger()Lorg/apache/logging/log4j/Logger;", 0)))};
        $$delegatedProperties = kPropertyArray;
        INSTANCE = new MassDatapackResolver();
        map = new HashMap();
        mcBlockStateToVs = new HashMap();
        blockStateData = mcBlockStateToVs.values();
        logger$delegate = LoggingKt.logger().provideDelegate-j8jxBIw(INSTANCE, $$delegatedProperties[0]);
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ9\u0010\u000b\u001a\u00020\n2\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\rH\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2={"Lorg/valkyrienskies/mod/common/config/MassDatapackResolver$VSMassDataLoader;", "Lnet/minecraft/class_4309;", "", "Lnet/minecraft/class_2960;", "Lcom/google/gson/JsonElement;", "objects", "Lnet/minecraft/class_3300;", "resourceManager", "Lnet/minecraft/class_3695;", "profiler", "", "apply", "(Ljava/util/Map;Lnet/minecraft/class_3300;Lnet/minecraft/class_3695;)V", "Lorg/valkyrienskies/mod/common/config/VSBlockStateInfo;", "tag", "addToBeAddedTags", "(Lorg/valkyrienskies/mod/common/config/VSBlockStateInfo;)V", "info", "add", "element", "origin", "parse", "(Lcom/google/gson/JsonElement;Lnet/minecraft/class_2960;)V", "", "tags", "Ljava/util/List;", "<init>", "()V", "valkyrienskies-120"})
    @SourceDebugExtension(value={"SMAP\nMassDatapackResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MassDatapackResolver.kt\norg/valkyrienskies/mod/common/config/MassDatapackResolver$VSMassDataLoader\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,403:1\n216#2:404\n217#2:407\n1863#3,2:405\n1863#3:408\n1863#3,2:409\n1864#3:411\n*S KotlinDebug\n*F\n+ 1 MassDatapackResolver.kt\norg/valkyrienskies/mod/common/config/MassDatapackResolver$VSMassDataLoader\n*L\n83#1:404\n83#1:407\n86#1:405,2\n100#1:408\n110#1:409,2\n100#1:411\n*E\n"})
    public static final class VSMassDataLoader
    extends class_4309 {
        @NotNull
        private final List<VSBlockStateInfo> tags = new ArrayList();

        public VSMassDataLoader() {
            super(new Gson(), "vs_mass");
            VSGameEvents.INSTANCE.getTagsAreLoaded().on((arg_0, arg_1) -> VSMassDataLoader._init_$lambda$4(this, arg_0, arg_1));
        }

        protected void apply(@Nullable Map<class_2960, JsonElement> objects, @Nullable class_3300 resourceManager, @Nullable class_3695 profiler) {
            block6: {
                map.clear();
                this.tags.clear();
                Map<class_2960, JsonElement> map2 = objects;
                if (map2 == null) break block6;
                Map<class_2960, JsonElement> $this$forEach$iv = map2;
                boolean $i$f$forEach = false;
                Iterator<Map.Entry<class_2960, JsonElement>> iterator2 = $this$forEach$iv.entrySet().iterator();
                while (iterator2.hasNext()) {
                    Map.Entry<class_2960, JsonElement> element$iv;
                    Map.Entry<class_2960, JsonElement> entry = element$iv = iterator2.next();
                    boolean bl = false;
                    class_2960 location = entry.getKey();
                    JsonElement element = entry.getValue();
                    try {
                        if (element.isJsonArray()) {
                            JsonArray jsonArray = element.getAsJsonArray();
                            Intrinsics.checkNotNullExpressionValue((Object)jsonArray, (String)"getAsJsonArray(...)");
                            Iterable $this$forEach$iv2 = (Iterable)jsonArray;
                            boolean $i$f$forEach2 = false;
                            for (Object element$iv2 : $this$forEach$iv2) {
                                JsonElement element1 = (JsonElement)element$iv2;
                                boolean bl2 = false;
                                this.parse(element1, location);
                            }
                            continue;
                        }
                        if (element.isJsonObject()) {
                            this.parse(element, location);
                            continue;
                        }
                        throw new IllegalArgumentException();
                    }
                    catch (Exception e2) {
                        INSTANCE.getLogger().error(e2);
                    }
                }
            }
        }

        private final void addToBeAddedTags(VSBlockStateInfo tag) {
            this.tags.add(tag);
        }

        private final void add(VSBlockStateInfo info) {
            if (map.containsKey(info.getId())) {
                Object v = map.get(info.getId());
                Intrinsics.checkNotNull(v);
                if (((VSBlockStateInfo)v).getPriority() < info.getPriority()) {
                    ((Map)map).put(info.getId(), info);
                }
            } else {
                ((Map)map).put(info.getId(), info);
            }
        }

        private final void parse(JsonElement element, class_2960 origin) {
            int priority;
            JsonElement jsonElement = element.getAsJsonObject().get("tag");
            String tag = jsonElement != null ? jsonElement.getAsString() : null;
            JsonElement jsonElement2 = element.getAsJsonObject().get("mass");
            if (jsonElement2 == null) {
                throw new IllegalArgumentException("No mass in file " + origin);
            }
            double weight = jsonElement2.getAsDouble();
            JsonElement jsonElement3 = element.getAsJsonObject().get("friction");
            double friction = jsonElement3 != null ? jsonElement3.getAsDouble() : VSGameConfig.SERVER.getDefaultBlockFriction();
            JsonElement jsonElement4 = element.getAsJsonObject().get("elasticity");
            double elasticity = jsonElement4 != null ? jsonElement4.getAsDouble() : VSGameConfig.SERVER.getDefaultBlockElasticity();
            JsonElement jsonElement5 = element.getAsJsonObject().get("priority");
            int n2 = priority = jsonElement5 != null ? jsonElement5.getAsInt() : INSTANCE.decideDefaultPriority(origin);
            if (tag != null) {
                this.addToBeAddedTags(new VSBlockStateInfo(new class_2960(tag), priority, weight, friction, elasticity, null));
            } else {
                Object object = element.getAsJsonObject().get("block");
                if (object == null || (object = object.getAsString()) == null) {
                    throw new IllegalArgumentException("No block or tag in file " + origin);
                }
                Object block = object;
                this.add(new VSBlockStateInfo(new class_2960((String)block), priority, weight, friction, elasticity, null));
            }
        }

        private static final void _init_$lambda$4(VSMassDataLoader this$0, Unit unit, RegisteredListener registeredListener) {
            Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
            Intrinsics.checkNotNullParameter((Object)unit, (String)"<unused var>");
            Intrinsics.checkNotNullParameter((Object)registeredListener, (String)"<unused var>");
            Iterable $this$forEach$iv = this$0.tags;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                VSBlockStateInfo tagInfo = (VSBlockStateInfo)element$iv;
                boolean bl = false;
                Optional tag = class_7923.field_41175.method_40266(class_6862.method_40092((class_5321)class_7924.field_41254, (class_2960)tagInfo.getId()));
                if (tag == null) continue;
                if (!tag.isPresent()) {
                    INSTANCE.getLogger().warn("No specified tag '" + tagInfo.getId() + "' doesn't exist!");
                    continue;
                }
                Object t = tag.get();
                Intrinsics.checkNotNullExpressionValue(t, (String)"get(...)");
                Iterable $this$forEach$iv2 = (Iterable)t;
                boolean $i$f$forEach2 = false;
                for (Object element$iv2 : $this$forEach$iv2) {
                    class_6880 it = (class_6880)element$iv2;
                    boolean bl2 = false;
                    class_2960 class_29602 = class_7923.field_41175.method_10221(it.comp_349());
                    Intrinsics.checkNotNullExpressionValue((Object)class_29602, (String)"getKey(...)");
                    this$0.add(new VSBlockStateInfo(class_29602, tagInfo.getPriority(), tagInfo.getMass(), tagInfo.getFriction(), tagInfo.getElasticity(), tagInfo.getType()));
                }
            }
        }
    }
}

