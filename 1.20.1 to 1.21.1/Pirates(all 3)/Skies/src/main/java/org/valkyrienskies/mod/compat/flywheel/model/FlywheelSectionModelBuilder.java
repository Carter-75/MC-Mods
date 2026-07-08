/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.engine_room.flywheel.api.model.Model
 *  dev.engine_room.flywheel.api.task.Plan
 *  it.unimi.dsi.fastutil.longs.LongSet
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_3568
 *  net.minecraft.class_4076
 *  net.minecraft.class_638
 */
package org.valkyrienskies.mod.compat.flywheel.model;

import dev.engine_room.flywheel.api.model.Model;
import dev.engine_room.flywheel.api.task.Plan;
import it.unimi.dsi.fastutil.longs.LongSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_3568;
import net.minecraft.class_4076;
import net.minecraft.class_638;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ1\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0002H&\u00a2\u0006\u0004\b\t\u0010\n\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\f\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/mod/compat/flywheel/model/FlywheelSectionModelBuilder;", "", "Lkotlin/Function2;", "Lnet/minecraft/class_4076;", "Ldev/engine_room/flywheel/api/model/Model;", "", "newModel", "Ldev/engine_room/flywheel/api/task/Plan;", "Lorg/valkyrienskies/mod/compat/flywheel/model/FlywheelSectionModelBuilder$BuildingContext;", "createBuildingPlan", "(Lkotlin/jvm/functions/Function2;)Ldev/engine_room/flywheel/api/task/Plan;", "BuildingContext", "valkyrienskies-120"})
public interface FlywheelSectionModelBuilder {
    @NotNull
    public Plan<BuildingContext> createBuildingPlan(@NotNull Function2<? super class_4076, ? super Model, Unit> var1);

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bH\u00c6\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014H\u00d6\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017H\u00d6\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0017\u0010\f\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\n\u00a8\u0006\""}, d2={"Lorg/valkyrienskies/mod/compat/flywheel/model/FlywheelSectionModelBuilder$BuildingContext;", "", "Lnet/minecraft/class_638;", "component1", "()Lnet/minecraft/class_638;", "Lit/unimi/dsi/fastutil/longs/LongSet;", "component2", "()Lit/unimi/dsi/fastutil/longs/LongSet;", "Lnet/minecraft/class_3568;", "component3", "()Lnet/minecraft/class_3568;", "level", "updates", "lightEngine", "copy", "(Lnet/minecraft/class_638;Lit/unimi/dsi/fastutil/longs/LongSet;Lnet/minecraft/class_3568;)Lorg/valkyrienskies/mod/compat/flywheel/model/FlywheelSectionModelBuilder$BuildingContext;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lnet/minecraft/class_638;", "getLevel", "Lit/unimi/dsi/fastutil/longs/LongSet;", "getUpdates", "Lnet/minecraft/class_3568;", "getLightEngine", "<init>", "(Lnet/minecraft/class_638;Lit/unimi/dsi/fastutil/longs/LongSet;Lnet/minecraft/class_3568;)V", "valkyrienskies-120"})
    public static final class BuildingContext {
        @NotNull
        private final class_638 level;
        @NotNull
        private final LongSet updates;
        @NotNull
        private final class_3568 lightEngine;

        public BuildingContext(@NotNull class_638 level, @NotNull LongSet updates, @NotNull class_3568 lightEngine) {
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            Intrinsics.checkNotNullParameter((Object)updates, (String)"updates");
            Intrinsics.checkNotNullParameter((Object)lightEngine, (String)"lightEngine");
            this.level = level;
            this.updates = updates;
            this.lightEngine = lightEngine;
        }

        @NotNull
        public final class_638 getLevel() {
            return this.level;
        }

        @NotNull
        public final LongSet getUpdates() {
            return this.updates;
        }

        @NotNull
        public final class_3568 getLightEngine() {
            return this.lightEngine;
        }

        @NotNull
        public final class_638 component1() {
            return this.level;
        }

        @NotNull
        public final LongSet component2() {
            return this.updates;
        }

        @NotNull
        public final class_3568 component3() {
            return this.lightEngine;
        }

        @NotNull
        public final BuildingContext copy(@NotNull class_638 level, @NotNull LongSet updates, @NotNull class_3568 lightEngine) {
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            Intrinsics.checkNotNullParameter((Object)updates, (String)"updates");
            Intrinsics.checkNotNullParameter((Object)lightEngine, (String)"lightEngine");
            return new BuildingContext(level, updates, lightEngine);
        }

        public static /* synthetic */ BuildingContext copy$default(BuildingContext buildingContext, class_638 class_6382, LongSet longSet, class_3568 class_35682, int n2, Object object) {
            if ((n2 & 1) != 0) {
                class_6382 = buildingContext.level;
            }
            if ((n2 & 2) != 0) {
                longSet = buildingContext.updates;
            }
            if ((n2 & 4) != 0) {
                class_35682 = buildingContext.lightEngine;
            }
            return buildingContext.copy(class_6382, longSet, class_35682);
        }

        @NotNull
        public String toString() {
            return "BuildingContext(level=" + this.level + ", updates=" + this.updates + ", lightEngine=" + this.lightEngine + ")";
        }

        public int hashCode() {
            int result2 = this.level.hashCode();
            result2 = result2 * 31 + this.updates.hashCode();
            result2 = result2 * 31 + this.lightEngine.hashCode();
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BuildingContext)) {
                return false;
            }
            BuildingContext buildingContext = (BuildingContext)other;
            if (!Intrinsics.areEqual((Object)this.level, (Object)buildingContext.level)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.updates, (Object)buildingContext.updates)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.lightEngine, (Object)buildingContext.lightEngine);
        }
    }
}

