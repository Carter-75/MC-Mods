/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.engine_room.flywheel.api.instance.Instance
 *  dev.engine_room.flywheel.api.instance.Instancer
 *  dev.engine_room.flywheel.api.model.Model
 *  dev.engine_room.flywheel.api.task.Plan
 *  dev.engine_room.flywheel.api.visual.DynamicVisual
 *  dev.engine_room.flywheel.api.visual.DynamicVisual$Context
 *  dev.engine_room.flywheel.api.visual.Visual
 *  dev.engine_room.flywheel.api.visualization.VisualizationContext
 *  dev.engine_room.flywheel.lib.instance.InstanceTypes
 *  dev.engine_room.flywheel.lib.instance.TransformedInstance
 *  dev.engine_room.flywheel.lib.task.IfElsePlan
 *  dev.engine_room.flywheel.lib.task.MapContextPlan
 *  it.unimi.dsi.fastutil.longs.Long2ObjectMap
 *  it.unimi.dsi.fastutil.longs.Long2ObjectMaps
 *  it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2382
 *  net.minecraft.class_2823
 *  net.minecraft.class_3568
 *  net.minecraft.class_4076
 */
package org.valkyrienskies.mod.compat.flywheel;

import dev.engine_room.flywheel.api.instance.Instance;
import dev.engine_room.flywheel.api.instance.Instancer;
import dev.engine_room.flywheel.api.model.Model;
import dev.engine_room.flywheel.api.task.Plan;
import dev.engine_room.flywheel.api.visual.DynamicVisual;
import dev.engine_room.flywheel.api.visual.Visual;
import dev.engine_room.flywheel.api.visualization.VisualizationContext;
import dev.engine_room.flywheel.lib.instance.InstanceTypes;
import dev.engine_room.flywheel.lib.instance.TransformedInstance;
import dev.engine_room.flywheel.lib.task.IfElsePlan;
import dev.engine_room.flywheel.lib.task.MapContextPlan;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectMaps;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2382;
import net.minecraft.class_2823;
import net.minecraft.class_3568;
import net.minecraft.class_4076;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.mod.compat.flywheel.ShipEffect;
import org.valkyrienskies.mod.compat.flywheel.model.FlywheelSectionModelBuilder;
import org.valkyrienskies.mod.compat.flywheel.model.MultiBlockModelSectionBuilder;
import org.valkyrienskies.mod.mixin.mod_compat.flywheel_renderer.LevelLightEngineAccessor;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b3\u00104J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ'\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\nH\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001d\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\"\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R8\u0010(\u001a&\u0012\f\u0012\n '*\u0004\u0018\u00010\u000b0\u000b '*\u0012\u0012\f\u0012\n '*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010&0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00065"}, d2={"Lorg/valkyrienskies/mod/compat/flywheel/RenderingShipVisual;", "Ldev/engine_room/flywheel/api/visual/Visual;", "Ldev/engine_room/flywheel/api/visual/DynamicVisual;", "Lnet/minecraft/class_4076;", "pos", "Ldev/engine_room/flywheel/api/model/Model;", "model", "", "newModel", "(Lnet/minecraft/class_4076;Ldev/engine_room/flywheel/api/model/Model;)V", "Ldev/engine_room/flywheel/api/instance/Instancer;", "Ldev/engine_room/flywheel/lib/instance/TransformedInstance;", "instancer", "makeChunkInstance", "(Lnet/minecraft/class_4076;Ldev/engine_room/flywheel/api/instance/Instancer;)Ldev/engine_room/flywheel/lib/instance/TransformedInstance;", "", "partialTick", "update", "(F)V", "delete", "()V", "Ldev/engine_room/flywheel/api/task/Plan;", "Ldev/engine_room/flywheel/api/visual/DynamicVisual$Context;", "planFrame", "()Ldev/engine_room/flywheel/api/task/Plan;", "Lorg/valkyrienskies/mod/compat/flywheel/model/FlywheelSectionModelBuilder$BuildingContext;", "makeBuildingContext", "()Lorg/valkyrienskies/mod/compat/flywheel/model/FlywheelSectionModelBuilder$BuildingContext;", "Lorg/valkyrienskies/mod/compat/flywheel/ShipEffect;", "effect", "Lorg/valkyrienskies/mod/compat/flywheel/ShipEffect;", "getEffect", "()Lorg/valkyrienskies/mod/compat/flywheel/ShipEffect;", "Ldev/engine_room/flywheel/api/visualization/VisualizationContext;", "ctx", "Ldev/engine_room/flywheel/api/visualization/VisualizationContext;", "getCtx", "()Ldev/engine_room/flywheel/api/visualization/VisualizationContext;", "Lit/unimi/dsi/fastutil/longs/Long2ObjectMap;", "kotlin.jvm.PlatformType", "instances", "Lit/unimi/dsi/fastutil/longs/Long2ObjectMap;", "Lnet/minecraft/class_2382;", "shipCenter", "Lnet/minecraft/class_2382;", "Lorg/valkyrienskies/mod/compat/flywheel/model/FlywheelSectionModelBuilder;", "models", "Lorg/valkyrienskies/mod/compat/flywheel/model/FlywheelSectionModelBuilder;", "Lnet/minecraft/class_3568;", "lightEngine", "Lnet/minecraft/class_3568;", "<init>", "(Lorg/valkyrienskies/mod/compat/flywheel/ShipEffect;Ldev/engine_room/flywheel/api/visualization/VisualizationContext;)V", "valkyrienskies-120"})
public final class RenderingShipVisual
implements Visual,
DynamicVisual {
    @NotNull
    private final ShipEffect effect;
    @NotNull
    private final VisualizationContext ctx;
    private final Long2ObjectMap<TransformedInstance> instances;
    @NotNull
    private final class_2382 shipCenter;
    @NotNull
    private final FlywheelSectionModelBuilder models;
    @NotNull
    private final class_3568 lightEngine;

    public RenderingShipVisual(@NotNull ShipEffect effect, @NotNull VisualizationContext ctx) {
        Intrinsics.checkNotNullParameter((Object)effect, (String)"effect");
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        this.effect = effect;
        this.ctx = ctx;
        this.instances = Long2ObjectMaps.synchronize((Long2ObjectMap)((Long2ObjectMap)new Long2ObjectOpenHashMap()));
        this.shipCenter = new class_2382(this.effect.getShip().getChunkClaim().getXMiddle(), this.effect.getLevel().method_31604(this.effect.getLevel().method_32890() - 1) / 2 - 1, this.effect.getShip().getChunkClaim().getZMiddle());
        this.models = new MultiBlockModelSectionBuilder();
        this.lightEngine = new class_3568((class_2823)this.effect.getLevel().method_2935(), false, false);
        class_3568 class_35682 = this.lightEngine;
        Intrinsics.checkNotNull((Object)class_35682, (String)"null cannot be cast to non-null type org.valkyrienskies.mod.mixin.mod_compat.flywheel_renderer.LevelLightEngineAccessor");
        LevelLightEngineAccessor levelLightEngineAccessor = (LevelLightEngineAccessor)class_35682;
        class_3568 class_35683 = this.effect.getLevel().method_22336();
        Intrinsics.checkNotNull((Object)class_35683, (String)"null cannot be cast to non-null type org.valkyrienskies.mod.mixin.mod_compat.flywheel_renderer.LevelLightEngineAccessor");
        levelLightEngineAccessor.setBlockLightEngine(((LevelLightEngineAccessor)class_35683).getBlockLightEngine());
    }

    @NotNull
    public final ShipEffect getEffect() {
        return this.effect;
    }

    @NotNull
    public final VisualizationContext getCtx() {
        return this.ctx;
    }

    private final void newModel(class_4076 pos, Model model) {
        if (model == null) {
            TransformedInstance transformedInstance = (TransformedInstance)this.instances.remove(pos.method_18694());
            if (transformedInstance != null) {
                transformedInstance.delete();
            }
            return;
        }
        TransformedInstance oldInstance = (TransformedInstance)this.instances.get(pos.method_18694());
        Instancer instancer = this.ctx.instancerProvider().instancer(InstanceTypes.TRANSFORMED, model);
        if (oldInstance != null) {
            instancer.stealInstance((Instance)oldInstance);
        } else {
            long l2 = pos.method_18694();
            Intrinsics.checkNotNull((Object)instancer);
            this.instances.put(l2, (Object)this.makeChunkInstance(pos, (Instancer<? extends TransformedInstance>)instancer));
        }
    }

    private final TransformedInstance makeChunkInstance(class_4076 pos, Instancer<? extends TransformedInstance> instancer) {
        TransformedInstance transformedInstance = ((TransformedInstance)instancer.createInstance()).translate((float)(pos.method_10263() - this.shipCenter.method_10263()) * (float)16, (float)(pos.method_10264() - this.shipCenter.method_10264()) * (float)16, (float)(pos.method_10260() - this.shipCenter.method_10260()) * (float)16 + 1.0f);
        Intrinsics.checkNotNullExpressionValue((Object)transformedInstance, (String)"translate(...)");
        return transformedInstance;
    }

    public void update(float partialTick) {
    }

    public void delete() {
        this.instances.forEach((arg_0, arg_1) -> RenderingShipVisual.delete$lambda$1(RenderingShipVisual::delete$lambda$0, arg_0, arg_1));
        this.instances.clear();
    }

    @NotNull
    public Plan<DynamicVisual.Context> planFrame() {
        IfElsePlan ifElsePlan = IfElsePlan.on(this.effect::areSectionsDirty$valkyrienskies_120).ifTrue((Plan)MapContextPlan.map(arg_0 -> RenderingShipVisual.planFrame$lambda$2(this, arg_0)).to(this.models.createBuildingPlan((Function2<? super class_4076, ? super Model, Unit>)((Function2)new Function2<class_4076, Model, Unit>((Object)this){

            public final void invoke(class_4076 p0, Model p1) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                RenderingShipVisual.access$newModel((RenderingShipVisual)this.receiver, p0, p1);
            }
        })))).plan();
        Intrinsics.checkNotNullExpressionValue((Object)ifElsePlan, (String)"plan(...)");
        return (Plan)ifElsePlan;
    }

    private final FlywheelSectionModelBuilder.BuildingContext makeBuildingContext() {
        return new FlywheelSectionModelBuilder.BuildingContext(this.effect.getLevel(), this.effect.pullQueuedSections$valkyrienskies_120(), this.lightEngine);
    }

    private static final Unit delete$lambda$0(Long t, TransformedInstance u) {
        u.delete();
        return Unit.INSTANCE;
    }

    private static final void delete$lambda$1(Function2 $tmp0, Object p0, Object p1) {
        Intrinsics.checkNotNullParameter((Object)$tmp0, (String)"$tmp0");
        $tmp0.invoke(p0, p1);
    }

    private static final FlywheelSectionModelBuilder.BuildingContext planFrame$lambda$2(RenderingShipVisual this$0, DynamicVisual.Context c2) {
        Intrinsics.checkNotNullParameter((Object)this$0, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)c2, (String)"c");
        return this$0.makeBuildingContext();
    }

    public static final /* synthetic */ void access$newModel(RenderingShipVisual $this, class_4076 pos, Model model) {
        $this.newModel(pos, model);
    }
}

