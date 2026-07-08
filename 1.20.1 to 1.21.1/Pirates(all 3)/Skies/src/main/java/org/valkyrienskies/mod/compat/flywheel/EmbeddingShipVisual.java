/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.engine_room.flywheel.api.task.Plan
 *  dev.engine_room.flywheel.api.visual.DynamicVisual
 *  dev.engine_room.flywheel.api.visual.DynamicVisual$Context
 *  dev.engine_room.flywheel.api.visual.EffectVisual
 *  dev.engine_room.flywheel.api.visual.LightUpdatedVisual
 *  dev.engine_room.flywheel.api.visual.SectionTrackedVisual$SectionCollector
 *  dev.engine_room.flywheel.api.visual.ShaderLightVisual
 *  dev.engine_room.flywheel.api.visualization.VisualEmbedding
 *  dev.engine_room.flywheel.api.visualization.VisualizationContext
 *  dev.engine_room.flywheel.lib.task.NestedPlan
 *  dev.engine_room.flywheel.lib.task.RunnablePlan
 *  it.unimi.dsi.fastutil.longs.LongArraySet
 *  it.unimi.dsi.fastutil.longs.LongSet
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2382
 *  net.minecraft.class_3532
 *  net.minecraft.class_4076
 */
package org.valkyrienskies.mod.compat.flywheel;

import dev.engine_room.flywheel.api.task.Plan;
import dev.engine_room.flywheel.api.visual.DynamicVisual;
import dev.engine_room.flywheel.api.visual.EffectVisual;
import dev.engine_room.flywheel.api.visual.LightUpdatedVisual;
import dev.engine_room.flywheel.api.visual.SectionTrackedVisual;
import dev.engine_room.flywheel.api.visual.ShaderLightVisual;
import dev.engine_room.flywheel.api.visualization.VisualEmbedding;
import dev.engine_room.flywheel.api.visualization.VisualizationContext;
import dev.engine_room.flywheel.lib.task.NestedPlan;
import dev.engine_room.flywheel.lib.task.RunnablePlan;
import it.unimi.dsi.fastutil.longs.LongArraySet;
import it.unimi.dsi.fastutil.longs.LongSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2382;
import net.minecraft.class_3532;
import net.minecraft.class_4076;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.FrustumIntersection;
import org.joml.Matrix3f;
import org.joml.Matrix3fc;
import org.joml.Matrix4dc;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionf;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.primitives.AABBdc;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.core.api.world.LevelYRange;
import org.valkyrienskies.mod.common.config.ShipRenderer;
import org.valkyrienskies.mod.common.config.ShipRendererKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import org.valkyrienskies.mod.compat.flywheel.EmbeddingShipVisual;
import org.valkyrienskies.mod.compat.flywheel.IfNotNullPlan;
import org.valkyrienskies.mod.compat.flywheel.RenderingShipVisual;
import org.valkyrienskies.mod.compat.flywheel.ShipEffect;
import org.valkyrienskies.mod.compat.flywheel.ShipEffectCamera;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 T2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0001TB\u0017\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010%\u001a\u00020$\u00a2\u0006\u0004\bR\u0010SJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\rH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\rH\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010 \u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010%\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0011\u0010,\u001a\u00020)8F\u00a2\u0006\u0006\u001a\u0004\b*\u0010+R\u001f\u0010/\u001a\n .*\u0004\u0018\u00010-0-8\u0006\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0017\u00104\u001a\u0002038\u0006\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0017\u00109\u001a\u0002088\u0006\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001d\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010\u001fR\"\u0010B\u001a\u00020A8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010H\u001a\u00020A8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010C\u001a\u0004\bI\u0010E\"\u0004\bJ\u0010GR$\u0010L\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010Q\u00a8\u0006U"}, d2={"Lorg/valkyrienskies/mod/compat/flywheel/EmbeddingShipVisual;", "Ldev/engine_room/flywheel/api/visual/EffectVisual;", "Lorg/valkyrienskies/mod/compat/flywheel/ShipEffect;", "Ldev/engine_room/flywheel/api/visual/DynamicVisual;", "Ldev/engine_room/flywheel/api/visual/ShaderLightVisual;", "Ldev/engine_room/flywheel/api/visual/LightUpdatedVisual;", "", "partialTick", "", "update", "(F)V", "updateLight", "Ldev/engine_room/flywheel/api/task/Plan;", "Ldev/engine_room/flywheel/api/visual/DynamicVisual$Context;", "planFrame", "()Ldev/engine_room/flywheel/api/task/Plan;", "ctx", "updateEmbedding", "(Ldev/engine_room/flywheel/api/visual/DynamicVisual$Context;)V", "updateSections", "Lit/unimi/dsi/fastutil/longs/LongSet;", "collectLightSections", "()Lit/unimi/dsi/fastutil/longs/LongSet;", "", "hasMovedSections", "()Z", "delete", "()V", "Ldev/engine_room/flywheel/api/visual/SectionTrackedVisual$SectionCollector;", "collector", "setSectionCollector", "(Ldev/engine_room/flywheel/api/visual/SectionTrackedVisual$SectionCollector;)V", "effect", "Lorg/valkyrienskies/mod/compat/flywheel/ShipEffect;", "getEffect", "()Lorg/valkyrienskies/mod/compat/flywheel/ShipEffect;", "Ldev/engine_room/flywheel/api/visualization/VisualizationContext;", "visualContext", "Ldev/engine_room/flywheel/api/visualization/VisualizationContext;", "getVisualContext", "()Ldev/engine_room/flywheel/api/visualization/VisualizationContext;", "Lorg/valkyrienskies/core/api/ships/ClientShip;", "getShip", "()Lorg/valkyrienskies/core/api/ships/ClientShip;", "ship", "Ldev/engine_room/flywheel/api/visualization/VisualEmbedding;", "kotlin.jvm.PlatformType", "embedding", "Ldev/engine_room/flywheel/api/visualization/VisualEmbedding;", "getEmbedding", "()Ldev/engine_room/flywheel/api/visualization/VisualEmbedding;", "Lorg/valkyrienskies/mod/compat/flywheel/ShipEffectCamera;", "camera", "Lorg/valkyrienskies/mod/compat/flywheel/ShipEffectCamera;", "getCamera", "()Lorg/valkyrienskies/mod/compat/flywheel/ShipEffectCamera;", "Lorg/joml/FrustumIntersection;", "frustum", "Lorg/joml/FrustumIntersection;", "getFrustum", "()Lorg/joml/FrustumIntersection;", "Ldev/engine_room/flywheel/api/visual/SectionTrackedVisual$SectionCollector;", "getCollector", "()Ldev/engine_room/flywheel/api/visual/SectionTrackedVisual$SectionCollector;", "setCollector", "", "minSection", "J", "getMinSection", "()J", "setMinSection", "(J)V", "maxSection", "getMaxSection", "setMaxSection", "Lorg/valkyrienskies/mod/compat/flywheel/RenderingShipVisual;", "renderingShipVisual", "Lorg/valkyrienskies/mod/compat/flywheel/RenderingShipVisual;", "getRenderingShipVisual", "()Lorg/valkyrienskies/mod/compat/flywheel/RenderingShipVisual;", "setRenderingShipVisual", "(Lorg/valkyrienskies/mod/compat/flywheel/RenderingShipVisual;)V", "<init>", "(Lorg/valkyrienskies/mod/compat/flywheel/ShipEffect;Ldev/engine_room/flywheel/api/visualization/VisualizationContext;)V", "Companion", "valkyrienskies-120"})
public final class EmbeddingShipVisual
implements EffectVisual<ShipEffect>,
DynamicVisual,
ShaderLightVisual,
LightUpdatedVisual {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ShipEffect effect;
    @NotNull
    private final VisualizationContext visualContext;
    private final VisualEmbedding embedding;
    @NotNull
    private final ShipEffectCamera camera;
    @NotNull
    private final FrustumIntersection frustum;
    public SectionTrackedVisual.SectionCollector collector;
    private long minSection;
    private long maxSection;
    @Nullable
    private RenderingShipVisual renderingShipVisual;
    public static final int LIGHT_PADDING = 1;

    public EmbeddingShipVisual(@NotNull ShipEffect effect, @NotNull VisualizationContext visualContext) {
        Intrinsics.checkNotNullParameter((Object)effect, (String)"effect");
        Intrinsics.checkNotNullParameter((Object)visualContext, (String)"visualContext");
        this.effect = effect;
        this.visualContext = visualContext;
        this.embedding = this.visualContext.createEmbedding((class_2382)VectorConversionsMCKt.toBlockPos(ChunkClaim.getCenterBlockCoordinates$default(this.effect.getShip().getChunkClaim(), new LevelYRange(this.effect.getLevel().method_31607(), this.effect.getLevel().method_31600() - 1), null, 2, null)));
        this.camera = new ShipEffectCamera(this.getShip());
        this.frustum = new FrustumIntersection();
    }

    @NotNull
    public final ShipEffect getEffect() {
        return this.effect;
    }

    @NotNull
    public final VisualizationContext getVisualContext() {
        return this.visualContext;
    }

    @NotNull
    public final ClientShip getShip() {
        return this.effect.getShip();
    }

    public final VisualEmbedding getEmbedding() {
        return this.embedding;
    }

    @NotNull
    public final ShipEffectCamera getCamera() {
        return this.camera;
    }

    @NotNull
    public final FrustumIntersection getFrustum() {
        return this.frustum;
    }

    @NotNull
    public final SectionTrackedVisual.SectionCollector getCollector() {
        SectionTrackedVisual.SectionCollector sectionCollector = this.collector;
        if (sectionCollector != null) {
            return sectionCollector;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"collector");
        return null;
    }

    public final void setCollector(@NotNull SectionTrackedVisual.SectionCollector sectionCollector) {
        Intrinsics.checkNotNullParameter((Object)sectionCollector, (String)"<set-?>");
        this.collector = sectionCollector;
    }

    public final long getMinSection() {
        return this.minSection;
    }

    public final void setMinSection(long l2) {
        this.minSection = l2;
    }

    public final long getMaxSection() {
        return this.maxSection;
    }

    public final void setMaxSection(long l2) {
        this.maxSection = l2;
    }

    @Nullable
    public final RenderingShipVisual getRenderingShipVisual() {
        return this.renderingShipVisual;
    }

    public final void setRenderingShipVisual(@Nullable RenderingShipVisual renderingShipVisual) {
        this.renderingShipVisual = renderingShipVisual;
    }

    public void update(float partialTick) {
        if (this.renderingShipVisual == null && ShipRendererKt.getShipRenderer(this.getShip()) == ShipRenderer.FLYWHEEL) {
            VisualEmbedding visualEmbedding = this.embedding;
            Intrinsics.checkNotNullExpressionValue((Object)visualEmbedding, (String)"embedding");
            this.renderingShipVisual = new RenderingShipVisual(this.effect, (VisualizationContext)visualEmbedding);
        } else if (this.renderingShipVisual != null) {
            if (ShipRendererKt.getShipRenderer(this.getShip()) != ShipRenderer.FLYWHEEL) {
                RenderingShipVisual renderingShipVisual = this.renderingShipVisual;
                Intrinsics.checkNotNull((Object)renderingShipVisual);
                renderingShipVisual.delete();
                this.renderingShipVisual = null;
            } else {
                RenderingShipVisual renderingShipVisual = this.renderingShipVisual;
                Intrinsics.checkNotNull((Object)renderingShipVisual);
                renderingShipVisual.update(partialTick);
            }
        }
    }

    public void updateLight(float partialTick) {
    }

    @NotNull
    public Plan<DynamicVisual.Context> planFrame() {
        Plan[] planArray = new Plan[]{RunnablePlan.of(this::updateEmbedding), RunnablePlan.of(this::updateSections), new IfNotNullPlan(() -> EmbeddingShipVisual.planFrame$lambda$0(this), planFrame.4.INSTANCE)};
        NestedPlan nestedPlan = NestedPlan.of((Plan[])planArray);
        Intrinsics.checkNotNullExpressionValue((Object)nestedPlan, (String)"of(...)");
        return (Plan)nestedPlan;
    }

    private final void updateEmbedding(DynamicVisual.Context ctx) {
        Matrix4dc matrix4dc = this.getShip().getRenderTransform().getShipToWorld();
        class_2382 class_23822 = this.embedding.renderOrigin();
        Intrinsics.checkNotNullExpressionValue((Object)class_23822, (String)"renderOrigin(...)");
        Vector3d pos = matrix4dc.transformPosition(VectorConversionsMCKt.toJOMLD(class_23822));
        Quaternionf rotation = VectorConversionsMCKt.toFloat(this.getShip().getRenderTransform().getShipToWorldRotation());
        Vector3dc scale = this.getShip().getRenderTransform().getShipToWorldScaling();
        Matrix4f pose = new Matrix4f().identity().translate((float)(pos.x() - (double)this.visualContext.renderOrigin().method_10263()), (float)(pos.y() - (double)this.visualContext.renderOrigin().method_10264()), (float)(pos.z() - (double)this.visualContext.renderOrigin().method_10260())).scale((float)scale.x(), (float)scale.y(), (float)scale.z()).rotate(rotation);
        Matrix3f normal = new Matrix3f().set(rotation);
        this.embedding.transforms((Matrix4fc)pose, (Matrix3fc)normal);
    }

    private final void updateSections(DynamicVisual.Context ctx) {
        if (this.hasMovedSections()) {
            this.getCollector().sections(this.collectLightSections());
        }
    }

    private final LongSet collectLightSections() {
        AABBdc boundingBox = this.getShip().getRenderAABB();
        int minSectionX = Companion.minLightSection(boundingBox.minX());
        int minSectionY = Companion.minLightSection(boundingBox.minY());
        int minSectionZ = Companion.minLightSection(boundingBox.minZ());
        int maxSectionX = Companion.maxLightSection(boundingBox.maxX());
        int maxSectionY = Companion.maxLightSection(boundingBox.maxY());
        int maxSectionZ = Companion.maxLightSection(boundingBox.maxZ());
        this.minSection = class_4076.method_18685((int)minSectionX, (int)minSectionY, (int)minSectionZ);
        this.maxSection = class_4076.method_18685((int)maxSectionX, (int)maxSectionY, (int)maxSectionZ);
        LongSet longSet = (LongSet)new LongArraySet();
        int x = 0;
        int n2 = maxSectionX - minSectionX;
        if (x <= n2) {
            while (true) {
                int n3;
                int y;
                if ((y = 0) <= (n3 = maxSectionY - minSectionY)) {
                    while (true) {
                        int n4;
                        int z;
                        if ((z = 0) <= (n4 = maxSectionZ - minSectionZ)) {
                            while (true) {
                                longSet.add(class_4076.method_18678((long)this.minSection, (int)x, (int)y, (int)z));
                                if (z == n4) break;
                                ++z;
                            }
                        }
                        if (y == n3) break;
                        ++y;
                    }
                }
                if (x == n2) break;
                ++x;
            }
        }
        return longSet;
    }

    private final boolean hasMovedSections() {
        AABBdc boundingBox = this.getShip().getRenderAABB();
        int minSectionX = Companion.minLightSection(boundingBox.minX());
        int minSectionY = Companion.minLightSection(boundingBox.minY());
        int minSectionZ = Companion.minLightSection(boundingBox.minZ());
        int maxSectionX = Companion.maxLightSection(boundingBox.maxX());
        int maxSectionY = Companion.maxLightSection(boundingBox.maxY());
        int maxSectionZ = Companion.maxLightSection(boundingBox.maxZ());
        return this.minSection != class_4076.method_18685((int)minSectionX, (int)minSectionY, (int)minSectionZ) || this.maxSection != class_4076.method_18685((int)maxSectionX, (int)maxSectionY, (int)maxSectionZ);
    }

    public void delete() {
        RenderingShipVisual renderingShipVisual = this.renderingShipVisual;
        if (renderingShipVisual != null) {
            renderingShipVisual.delete();
        }
        this.embedding.delete();
    }

    public void setSectionCollector(@NotNull SectionTrackedVisual.SectionCollector collector2) {
        Intrinsics.checkNotNullParameter((Object)collector2, (String)"collector");
        this.setCollector(collector2);
    }

    private static final RenderingShipVisual planFrame$lambda$0(EmbeddingShipVisual this$0) {
        Intrinsics.checkNotNullParameter((Object)this$0, (String)"this$0");
        return this$0.renderingShipVisual;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2={"Lorg/valkyrienskies/mod/compat/flywheel/EmbeddingShipVisual$Companion;", "", "", "aabbPos", "", "minLight", "(D)I", "maxLight", "minLightSection", "maxLightSection", "LIGHT_PADDING", "I", "<init>", "()V", "valkyrienskies-120"})
    public static final class Companion {
        private Companion() {
        }

        public final int minLight(double aabbPos) {
            return class_3532.method_15357((double)aabbPos) - 1;
        }

        public final int maxLight(double aabbPos) {
            return class_3532.method_15384((double)aabbPos) + 1;
        }

        public final int minLightSection(double aabbPos) {
            return class_4076.method_18675((int)this.minLight(aabbPos));
        }

        public final int maxLightSection(double aabbPos) {
            return class_4076.method_18675((int)this.maxLight(aabbPos));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

