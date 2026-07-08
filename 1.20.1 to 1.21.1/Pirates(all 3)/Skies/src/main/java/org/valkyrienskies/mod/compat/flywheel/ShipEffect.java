/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.engine_room.flywheel.api.visual.Effect
 *  dev.engine_room.flywheel.api.visual.EffectVisual
 *  dev.engine_room.flywheel.api.visualization.VisualManager
 *  dev.engine_room.flywheel.api.visualization.VisualizationContext
 *  dev.engine_room.flywheel.lib.visualization.VisualizationHelper
 *  it.unimi.dsi.fastutil.longs.LongArraySet
 *  it.unimi.dsi.fastutil.longs.LongCollection
 *  it.unimi.dsi.fastutil.longs.LongOpenHashSet
 *  it.unimi.dsi.fastutil.longs.LongSet
 *  it.unimi.dsi.fastutil.longs.LongSets
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KProperty
 *  net.minecraft.class_1936
 *  net.minecraft.class_2586
 *  net.minecraft.class_310
 *  net.minecraft.class_4076
 *  net.minecraft.class_638
 */
package org.valkyrienskies.mod.compat.flywheel;

import dev.engine_room.flywheel.api.visual.Effect;
import dev.engine_room.flywheel.api.visual.EffectVisual;
import dev.engine_room.flywheel.api.visualization.VisualManager;
import dev.engine_room.flywheel.api.visualization.VisualizationContext;
import dev.engine_room.flywheel.lib.visualization.VisualizationHelper;
import it.unimi.dsi.fastutil.longs.LongArraySet;
import it.unimi.dsi.fastutil.longs.LongCollection;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;
import it.unimi.dsi.fastutil.longs.LongSets;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import net.minecraft.class_1936;
import net.minecraft.class_2586;
import net.minecraft.class_310;
import net.minecraft.class_4076;
import net.minecraft.class_638;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.compat.flywheel.EmbeddingShipVisual;
import org.valkyrienskies.mod.util.ClassLogger;
import org.valkyrienskies.mod.util.LoggingKt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 72\u00020\u0001:\u00017B\u0017\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010\u0012\u001a\u00020'\u00a2\u0006\u0004\b5\u00106J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\u0006J/\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00000\u00182\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001e\u001a\u00020\u001bH\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010!\u001a\u00020\rH\u0000\u00a2\u0006\u0004\b\u001f\u0010 R\u0017\u0010#\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\u0012\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b)\u0010*R*\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010+8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u00103\u001a\n 2*\u0004\u0018\u00010\u001b0\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u00068"}, d2={"Lorg/valkyrienskies/mod/compat/flywheel/ShipEffect;", "Ldev/engine_room/flywheel/api/visual/Effect;", "Lnet/minecraft/class_2586;", "blockEntity", "", "queueAddition", "(Lnet/minecraft/class_2586;)V", "queueUpdate", "queueRemoval", "", "sectionX", "sectionY", "sectionZ", "", "important", "setDirty", "(IIIZ)V", "Lnet/minecraft/class_1936;", "level", "()Lnet/minecraft/class_1936;", "Ldev/engine_room/flywheel/api/visualization/VisualizationContext;", "ctx", "", "partialTick", "Ldev/engine_room/flywheel/api/visual/EffectVisual;", "visualize", "(Ldev/engine_room/flywheel/api/visualization/VisualizationContext;F)Ldev/engine_room/flywheel/api/visual/EffectVisual;", "Lit/unimi/dsi/fastutil/longs/LongSet;", "pullQueuedSections$valkyrienskies_120", "()Lit/unimi/dsi/fastutil/longs/LongSet;", "pullQueuedSections", "areSectionsDirty$valkyrienskies_120", "()Z", "areSectionsDirty", "Lorg/valkyrienskies/core/api/ships/ClientShip;", "ship", "Lorg/valkyrienskies/core/api/ships/ClientShip;", "getShip", "()Lorg/valkyrienskies/core/api/ships/ClientShip;", "Lnet/minecraft/class_638;", "Lnet/minecraft/class_638;", "getLevel", "()Lnet/minecraft/class_638;", "Ldev/engine_room/flywheel/api/visualization/VisualManager;", "manager", "Ldev/engine_room/flywheel/api/visualization/VisualManager;", "getManager$valkyrienskies_120", "()Ldev/engine_room/flywheel/api/visualization/VisualManager;", "setManager$valkyrienskies_120", "(Ldev/engine_room/flywheel/api/visualization/VisualManager;)V", "kotlin.jvm.PlatformType", "dirtySections", "Lit/unimi/dsi/fastutil/longs/LongSet;", "<init>", "(Lorg/valkyrienskies/core/api/ships/ClientShip;Lnet/minecraft/class_638;)V", "Companion", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nShipEffect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShipEffect.kt\norg/valkyrienskies/mod/compat/flywheel/ShipEffect\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,75:1\n1#2:76\n*E\n"})
public final class ShipEffect
implements Effect {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ClientShip ship;
    @NotNull
    private final class_638 level;
    @Nullable
    private VisualManager<class_2586> manager;
    private LongSet dirtySections;
    @NotNull
    private static final WeakHashMap<ClientShip, ShipEffect> map = new WeakHashMap();
    @NotNull
    private static final Logger logger$delegate = LoggingKt.logger("ShipEffect-Flywheel");

    public ShipEffect(@NotNull ClientShip ship, @NotNull class_638 level) {
        Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        this.ship = ship;
        this.level = level;
        ((Map)map).put(this.ship, this);
        this.dirtySections = LongSets.synchronize((LongSet)((LongSet)new LongOpenHashSet()));
    }

    @NotNull
    public final ClientShip getShip() {
        return this.ship;
    }

    @NotNull
    public final class_638 getLevel() {
        return this.level;
    }

    @Nullable
    public final VisualManager<class_2586> getManager$valkyrienskies_120() {
        return this.manager;
    }

    public final void setManager$valkyrienskies_120(@Nullable VisualManager<class_2586> visualManager) {
        this.manager = visualManager;
    }

    public final void queueAddition(@NotNull class_2586 blockEntity) {
        block0: {
            Intrinsics.checkNotNullParameter((Object)blockEntity, (String)"blockEntity");
            VisualManager<class_2586> visualManager = this.manager;
            if (visualManager == null) break block0;
            visualManager.queueAdd((Object)blockEntity);
        }
    }

    public final void queueUpdate(@NotNull class_2586 blockEntity) {
        block0: {
            Intrinsics.checkNotNullParameter((Object)blockEntity, (String)"blockEntity");
            VisualManager<class_2586> visualManager = this.manager;
            if (visualManager == null) break block0;
            visualManager.queueUpdate((Object)blockEntity);
        }
    }

    public final void queueRemoval(@NotNull class_2586 blockEntity) {
        block0: {
            Intrinsics.checkNotNullParameter((Object)blockEntity, (String)"blockEntity");
            VisualManager<class_2586> visualManager = this.manager;
            if (visualManager == null) break block0;
            visualManager.queueRemove((Object)blockEntity);
        }
    }

    public final void setDirty(int sectionX, int sectionY, int sectionZ, boolean important) {
        this.dirtySections.add(class_4076.method_18685((int)sectionX, (int)sectionY, (int)sectionZ));
    }

    public static /* synthetic */ void setDirty$default(ShipEffect shipEffect, int n2, int n3, int n4, boolean bl, int n5, Object object) {
        if ((n5 & 8) != 0) {
            bl = false;
        }
        shipEffect.setDirty(n2, n3, n4, bl);
    }

    @NotNull
    public class_1936 level() {
        return (class_1936)this.level;
    }

    @NotNull
    public EffectVisual<ShipEffect> visualize(@NotNull VisualizationContext ctx, float partialTick) {
        EmbeddingShipVisual embeddingShipVisual;
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        EmbeddingShipVisual $this$visualize_u24lambda_u240 = embeddingShipVisual = new EmbeddingShipVisual(this, ctx);
        boolean bl = false;
        $this$visualize_u24lambda_u240.update(partialTick);
        return embeddingShipVisual;
    }

    @NotNull
    public final LongSet pullQueuedSections$valkyrienskies_120() {
        LongArraySet r = new LongArraySet();
        r.addAll((LongCollection)this.dirtySections);
        this.dirtySections.clear();
        LongSet longSet = LongSets.unmodifiable((LongSet)((LongSet)r));
        Intrinsics.checkNotNullExpressionValue((Object)longSet, (String)"unmodifiable(...)");
        return longSet;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final boolean areSectionsDirty$valkyrienskies_120() {
        LongSet longSet = this.dirtySections;
        Intrinsics.checkNotNullExpressionValue((Object)longSet, (String)"dirtySections");
        LongSet longSet2 = longSet;
        synchronized (longSet2) {
            boolean bl = false;
            boolean bl2 = !this.dirtySections.isEmpty();
            return bl2;
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2={"Lorg/valkyrienskies/mod/compat/flywheel/ShipEffect$Companion;", "", "Lorg/valkyrienskies/core/api/ships/ClientShip;", "ship", "Lorg/valkyrienskies/mod/compat/flywheel/ShipEffect;", "getShipEffect", "(Lorg/valkyrienskies/core/api/ships/ClientShip;)Lorg/valkyrienskies/mod/compat/flywheel/ShipEffect;", "Ljava/util/WeakHashMap;", "map", "Ljava/util/WeakHashMap;", "Lorg/apache/logging/log4j/Logger;", "logger$delegate", "Lorg/apache/logging/log4j/Logger;", "getLogger", "()Lorg/apache/logging/log4j/Logger;", "logger", "<init>", "()V", "valkyrienskies-120"})
    @SourceDebugExtension(value={"SMAP\nShipEffect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShipEffect.kt\norg/valkyrienskies/mod/compat/flywheel/ShipEffect$Companion\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,75:1\n381#2,7:76\n*S KotlinDebug\n*F\n+ 1 ShipEffect.kt\norg/valkyrienskies/mod/compat/flywheel/ShipEffect$Companion\n*L\n67#1:76,7\n*E\n"})
    public static final class Companion {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;

        private Companion() {
        }

        private final Logger getLogger() {
            return ClassLogger.getValue-impl(logger$delegate, this, $$delegatedProperties[0]);
        }

        @NotNull
        public final ShipEffect getShipEffect(@NotNull ClientShip ship) {
            Object object;
            Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
            Map $this$getOrPut$iv = map;
            boolean $i$f$getOrPut = false;
            Object value$iv = $this$getOrPut$iv.get(ship);
            if (value$iv == null) {
                ShipEffect shipEffect;
                boolean bl = false;
                class_638 class_6382 = class_310.method_1551().field_1687;
                Intrinsics.checkNotNull((Object)class_6382);
                ShipEffect $this$getShipEffect_u24lambda_u241_u24lambda_u240 = shipEffect = new ShipEffect(ship, class_6382);
                boolean bl2 = false;
                Companion.getLogger().warn("Added dynamically a ship effect, shouldn't happen.");
                VisualizationHelper.queueAdd((Effect)$this$getShipEffect_u24lambda_u241_u24lambda_u240);
                ShipEffect answer$iv = shipEffect;
                $this$getOrPut$iv.put(ship, answer$iv);
                object = answer$iv;
            } else {
                object = value$iv;
            }
            return (ShipEffect)object;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        static {
            KProperty[] kPropertyArray = new KProperty[]{Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(Companion.class, "logger", "getLogger()Lorg/apache/logging/log4j/Logger;", 0)))};
            $$delegatedProperties = kPropertyArray;
        }
    }
}

