/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.engine_room.flywheel.api.model.Model
 *  dev.engine_room.flywheel.api.task.Plan
 *  dev.engine_room.flywheel.lib.model.SimpleModel
 *  dev.engine_room.flywheel.lib.model.baked.BlockModelBuilder
 *  dev.engine_room.flywheel.lib.task.ForEachPlan
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.internal.markers.KMappedMarker
 *  net.minecraft.class_1920
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  net.minecraft.class_2586
 *  net.minecraft.class_2680
 *  net.minecraft.class_2818
 *  net.minecraft.class_2826
 *  net.minecraft.class_3568
 *  net.minecraft.class_3610
 *  net.minecraft.class_4076
 *  net.minecraft.class_638
 *  net.minecraft.class_6539
 */
package org.valkyrienskies.mod.compat.flywheel.model;

import dev.engine_room.flywheel.api.model.Model;
import dev.engine_room.flywheel.api.task.Plan;
import dev.engine_room.flywheel.lib.model.SimpleModel;
import dev.engine_room.flywheel.lib.model.baked.BlockModelBuilder;
import dev.engine_room.flywheel.lib.task.ForEachPlan;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import net.minecraft.class_1920;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_2818;
import net.minecraft.class_2826;
import net.minecraft.class_3568;
import net.minecraft.class_3610;
import net.minecraft.class_4076;
import net.minecraft.class_638;
import net.minecraft.class_6539;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.mod.compat.flywheel.model.FlywheelSectionModelBuilder;
import org.valkyrienskies.mod.compat.flywheel.model.MultiBlockModelSectionBuilder;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0007*\u0001\u0013\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J1\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0002H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ;\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u00022\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2={"Lorg/valkyrienskies/mod/compat/flywheel/model/MultiBlockModelSectionBuilder;", "Lorg/valkyrienskies/mod/compat/flywheel/model/FlywheelSectionModelBuilder;", "Lkotlin/Function2;", "Lnet/minecraft/class_4076;", "Ldev/engine_room/flywheel/api/model/Model;", "", "newModel", "Ldev/engine_room/flywheel/api/task/Plan;", "Lorg/valkyrienskies/mod/compat/flywheel/model/FlywheelSectionModelBuilder$BuildingContext;", "createBuildingPlan", "(Lkotlin/jvm/functions/Function2;)Ldev/engine_room/flywheel/api/task/Plan;", "buildChunk", "(Lkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function2;", "Lnet/minecraft/class_638;", "lvl", "Lnet/minecraft/class_3568;", "lightEngine", "Lnet/minecraft/class_2382;", "origin", "org/valkyrienskies/mod/compat/flywheel/model/MultiBlockModelSectionBuilder.wrapLevel.1", "wrapLevel", "(Lnet/minecraft/class_638;Lnet/minecraft/class_3568;Lnet/minecraft/class_2382;)Lorg/valkyrienskies/mod/compat/flywheel/model/MultiBlockModelSectionBuilder$wrapLevel$1;", "<init>", "()V", "AllSectionPositions", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nMultiBlockModelSectionBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MultiBlockModelSectionBuilder.kt\norg/valkyrienskies/mod/compat/flywheel/model/MultiBlockModelSectionBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,99:1\n1557#2:100\n1628#2,3:101\n*S KotlinDebug\n*F\n+ 1 MultiBlockModelSectionBuilder.kt\norg/valkyrienskies/mod/compat/flywheel/model/MultiBlockModelSectionBuilder\n*L\n24#1:100\n24#1:101,3\n*E\n"})
public final class MultiBlockModelSectionBuilder
implements FlywheelSectionModelBuilder {
    @Override
    @NotNull
    public Plan<FlywheelSectionModelBuilder.BuildingContext> createBuildingPlan(@NotNull Function2<? super class_4076, ? super Model, Unit> newModel) {
        Intrinsics.checkNotNullParameter(newModel, (String)"newModel");
        ForEachPlan forEachPlan = ForEachPlan.of(MultiBlockModelSectionBuilder::createBuildingPlan$lambda$0, (arg_0, arg_1) -> MultiBlockModelSectionBuilder.createBuildingPlan$lambda$1(this.buildChunk(newModel), arg_0, arg_1));
        Intrinsics.checkNotNullExpressionValue((Object)forEachPlan, (String)"of(...)");
        return (Plan)forEachPlan;
    }

    @NotNull
    public final Function2<class_4076, FlywheelSectionModelBuilder.BuildingContext, Unit> buildChunk(@NotNull Function2<? super class_4076, ? super Model, Unit> newModel) {
        Intrinsics.checkNotNullParameter(newModel, (String)"newModel");
        return (arg_0, arg_1) -> MultiBlockModelSectionBuilder.buildChunk$lambda$4(newModel, this, arg_0, arg_1);
    }

    private final wrapLevel.1 wrapLevel(class_638 lvl, class_3568 lightEngine, class_2382 origin) {
        return new class_1920(lvl, origin, lightEngine){
            final /* synthetic */ class_638 $lvl;
            final /* synthetic */ class_2382 $origin;
            final /* synthetic */ class_3568 $lightEngine;
            {
                this.$lvl = $lvl;
                this.$origin = $origin;
                this.$lightEngine = $lightEngine;
            }

            public int method_31605() {
                return this.$lvl.method_31605();
            }

            public int method_31607() {
                return this.$lvl.method_31607();
            }

            public class_2586 method_8321(class_2338 blockPos) {
                Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
                return this.$lvl.method_8321(blockPos.method_10081(this.$origin));
            }

            public class_2680 method_8320(class_2338 blockPos) {
                Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
                class_2680 class_26802 = this.$lvl.method_8320(blockPos.method_10081(this.$origin));
                Intrinsics.checkNotNullExpressionValue((Object)class_26802, (String)"getBlockState(...)");
                return class_26802;
            }

            public class_3610 method_8316(class_2338 blockPos) {
                Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
                class_3610 class_36102 = this.$lvl.method_8316(blockPos.method_10081(this.$origin));
                Intrinsics.checkNotNullExpressionValue((Object)class_36102, (String)"getFluidState(...)");
                return class_36102;
            }

            public float method_24852(class_2350 direction, boolean bl) {
                Intrinsics.checkNotNullParameter((Object)direction, (String)"direction");
                return 1.0f;
            }

            public class_3568 method_22336() {
                return this.$lightEngine;
            }

            public int method_23752(class_2338 blockPos, class_6539 colorResolver) {
                Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
                Intrinsics.checkNotNullParameter((Object)colorResolver, (String)"colorResolver");
                return this.$lvl.method_23752(blockPos.method_10081(this.$origin), colorResolver);
            }
        };
    }

    /*
     * WARNING - void declaration
     */
    private static final List createBuildingPlan$lambda$0(FlywheelSectionModelBuilder.BuildingContext x) {
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter((Object)x, (String)"x");
        Iterable $this$map$iv = (Iterable)x.getUpdates();
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void p0;
            long l2 = ((Number)item$iv$iv).longValue();
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(class_4076.method_18677((long)p0));
        }
        return (List)destination$iv$iv;
    }

    private static final void createBuildingPlan$lambda$1(Function2 $tmp0, class_4076 p0, FlywheelSectionModelBuilder.BuildingContext p1) {
        Intrinsics.checkNotNullParameter((Object)$tmp0, (String)"$tmp0");
        $tmp0.invoke((Object)p0, (Object)p1);
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit buildChunk$lambda$4(Function2 $newModel, MultiBlockModelSectionBuilder this$0, class_4076 pos, FlywheelSectionModelBuilder.BuildingContext ctx) {
        SimpleModel simpleModel;
        Intrinsics.checkNotNullParameter((Object)$newModel, (String)"$newModel");
        Intrinsics.checkNotNullParameter((Object)this$0, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        MultiBlockModelSectionBuilder multiBlockModelSectionBuilder = this$0;
        class_4076 class_40762 = pos;
        Function2 function2 = $newModel;
        boolean bl = false;
        class_2818 chunk = ctx.getLevel().method_8497(pos.method_10263(), pos.method_10260());
        class_2826 section = chunk.method_38259(ctx.getLevel().method_31603(pos.method_10264()));
        if (section.method_38292()) {
            simpleModel = null;
        } else {
            void $this$buildChunk_u24lambda_u244_u24lambda_u243;
            BlockModelBuilder blockModelBuilder;
            class_638 class_6382 = ctx.getLevel();
            class_3568 class_35682 = ctx.getLightEngine();
            class_2338 class_23382 = pos.method_19767();
            Intrinsics.checkNotNullExpressionValue((Object)class_23382, (String)"origin(...)");
            BlockModelBuilder $this$buildChunk_u24lambda_u244_u24lambda_u243_u24lambda_u242 = blockModelBuilder = BlockModelBuilder.create((class_1920)super.wrapLevel(class_6382, class_35682, (class_2382)class_23382), (Iterable)AllSectionPositions.INSTANCE);
            boolean bl2 = false;
            $this$buildChunk_u24lambda_u244_u24lambda_u243_u24lambda_u242.renderFluids(true);
            simpleModel = blockModelBuilder.build();
        }
        SimpleModel simpleModel2 = simpleModel;
        function2.invoke((Object)class_40762, simpleModel2);
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0006\b\u00c2\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0096\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\t"}, d2={"Lorg/valkyrienskies/mod/compat/flywheel/model/MultiBlockModelSectionBuilder$AllSectionPositions;", "", "Lnet/minecraft/class_2338;", "", "iterator", "()Ljava/util/Iterator;", "<init>", "()V", "MyIterator", "valkyrienskies-120"})
    private static final class AllSectionPositions
    implements Iterable<class_2338>,
    KMappedMarker {
        @NotNull
        public static final AllSectionPositions INSTANCE = new AllSectionPositions();

        private AllSectionPositions() {
        }

        @Override
        @NotNull
        public Iterator<class_2338> iterator() {
            return new MyIterator();
        }

        @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0004\u001a\u00020\u0003H\u0096\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u0096\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2={"Lorg/valkyrienskies/mod/compat/flywheel/model/MultiBlockModelSectionBuilder$AllSectionPositions$MyIterator;", "", "Lnet/minecraft/class_2338;", "", "hasNext", "()Z", "next", "()Lnet/minecraft/class_2338;", "Lnet/minecraft/class_2338$class_2339;", "pos", "Lnet/minecraft/class_2338$class_2339;", "<init>", "()V", "valkyrienskies-120"})
        private static final class MyIterator
        implements Iterator<class_2338>,
        KMappedMarker {
            @NotNull
            private final class_2338.class_2339 pos = new class_2338.class_2339();

            public MyIterator() {
                this.pos.method_33097(-1);
                this.pos.method_33098(0);
                this.pos.method_33099(0);
            }

            @Override
            public boolean hasNext() {
                return this.pos.method_10263() < 15 || this.pos.method_10264() < 15 || this.pos.method_10260() < 15;
            }

            @Override
            @NotNull
            public class_2338 next() {
                class_2338.class_2339 class_23392 = this.pos;
                int n2 = class_23392.method_10263();
                class_23392.method_33097(n2 + 1);
                if (this.pos.method_10263() > 15) {
                    this.pos.method_33097(0);
                    class_23392 = this.pos;
                    n2 = class_23392.method_10264();
                    class_23392.method_33098(n2 + 1);
                    if (this.pos.method_10264() > 15) {
                        this.pos.method_33098(0);
                        class_23392 = this.pos;
                        n2 = class_23392.method_10260();
                        class_23392.method_33099(n2 + 1);
                        if (this.pos.method_10260() > 15) {
                            throw new NoSuchElementException();
                        }
                    }
                }
                return (class_2338)this.pos;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }
    }
}

