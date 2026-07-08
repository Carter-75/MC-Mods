/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.engine_room.flywheel.api.model.Model
 *  dev.engine_room.flywheel.api.task.Plan
 *  dev.engine_room.flywheel.lib.model.Models
 *  dev.engine_room.flywheel.lib.task.ForEachPlan
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_2246
 *  net.minecraft.class_2680
 *  net.minecraft.class_4076
 */
package org.valkyrienskies.mod.compat.flywheel.model;

import dev.engine_room.flywheel.api.model.Model;
import dev.engine_room.flywheel.api.task.Plan;
import dev.engine_room.flywheel.lib.model.Models;
import dev.engine_room.flywheel.lib.task.ForEachPlan;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_2246;
import net.minecraft.class_2680;
import net.minecraft.class_4076;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.mod.compat.flywheel.model.FlywheelSectionModelBuilder;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ1\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0002H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ;\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u00022\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0002\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2={"Lorg/valkyrienskies/mod/compat/flywheel/model/TestModelBuilder;", "Lorg/valkyrienskies/mod/compat/flywheel/model/FlywheelSectionModelBuilder;", "Lkotlin/Function2;", "Lnet/minecraft/class_4076;", "Ldev/engine_room/flywheel/api/model/Model;", "", "newModel", "Ldev/engine_room/flywheel/api/task/Plan;", "Lorg/valkyrienskies/mod/compat/flywheel/model/FlywheelSectionModelBuilder$BuildingContext;", "createBuildingPlan", "(Lkotlin/jvm/functions/Function2;)Ldev/engine_room/flywheel/api/task/Plan;", "buildChunk", "(Lkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function2;", "<init>", "()V", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nTestModelBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TestModelBuilder.kt\norg/valkyrienskies/mod/compat/flywheel/model/TestModelBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,24:1\n1557#2:25\n1628#2,3:26\n*S KotlinDebug\n*F\n+ 1 TestModelBuilder.kt\norg/valkyrienskies/mod/compat/flywheel/model/TestModelBuilder\n*L\n14#1:25\n14#1:26,3\n*E\n"})
public final class TestModelBuilder
implements FlywheelSectionModelBuilder {
    @Override
    @NotNull
    public Plan<FlywheelSectionModelBuilder.BuildingContext> createBuildingPlan(@NotNull Function2<? super class_4076, ? super Model, Unit> newModel) {
        Intrinsics.checkNotNullParameter(newModel, (String)"newModel");
        ForEachPlan forEachPlan = ForEachPlan.of(TestModelBuilder::createBuildingPlan$lambda$0, (arg_0, arg_1) -> TestModelBuilder.createBuildingPlan$lambda$1(this.buildChunk(newModel), arg_0, arg_1));
        Intrinsics.checkNotNullExpressionValue((Object)forEachPlan, (String)"of(...)");
        return (Plan)forEachPlan;
    }

    @NotNull
    public final Function2<class_4076, FlywheelSectionModelBuilder.BuildingContext, Unit> buildChunk(@NotNull Function2<? super class_4076, ? super Model, Unit> newModel) {
        Intrinsics.checkNotNullParameter(newModel, (String)"newModel");
        return (arg_0, arg_1) -> TestModelBuilder.buildChunk$lambda$3(newModel, this, arg_0, arg_1);
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

    private static final Unit buildChunk$lambda$3(Function2 $newModel, TestModelBuilder this$0, class_4076 pos, FlywheelSectionModelBuilder.BuildingContext ctx) {
        Intrinsics.checkNotNullParameter((Object)$newModel, (String)"$newModel");
        Intrinsics.checkNotNullParameter((Object)this$0, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        TestModelBuilder testModelBuilder = this$0;
        class_4076 class_40762 = pos;
        Function2 function2 = $newModel;
        boolean bl = false;
        Model model = Models.block((class_2680)class_2246.field_10566.method_9564());
        function2.invoke((Object)class_40762, (Object)model);
        return Unit.INSTANCE;
    }
}

