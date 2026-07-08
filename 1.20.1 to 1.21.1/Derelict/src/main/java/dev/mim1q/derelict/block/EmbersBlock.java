/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings
 *  net.minecraft.class_1750
 *  net.minecraft.class_1936
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_2400
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_2689$class_2690
 *  net.minecraft.class_2741
 *  net.minecraft.class_2746
 *  net.minecraft.class_2769
 *  net.minecraft.class_3610
 *  net.minecraft.class_3611
 *  net.minecraft.class_3612
 *  net.minecraft.class_3737
 *  net.minecraft.class_4538
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5778
 *  net.minecraft.class_5819
 *  net.minecraft.class_7118
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.mim1q.derelict.block;

import dev.mim1q.derelict.init.ModBlocksAndItems;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.class_1750;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_2400;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2769;
import net.minecraft.class_3610;
import net.minecraft.class_3611;
import net.minecraft.class_3612;
import net.minecraft.class_3737;
import net.minecraft.class_4538;
import net.minecraft.class_4970;
import net.minecraft.class_5778;
import net.minecraft.class_5819;
import net.minecraft.class_7118;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Uses 'sealed' constructs - enablewith --sealed true
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 12\u00020\u00012\u00020\u0002:\u0003123B\u001b\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0014\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aJ?\u0010#\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 H\u0016\u00a2\u0006\u0004\b#\u0010$J\u001f\u0010(\u001a\u00020'2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020%H\u0002\u00a2\u0006\u0004\b(\u0010)J/\u0010+\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020*2\u0006\u0010!\u001a\u00020 2\u0006\u0010&\u001a\u00020%H\u0016\u00a2\u0006\u0004\b+\u0010,J\u0019\u0010.\u001a\u0004\u0018\u00010-2\u0006\u0010&\u001a\u00020%H&\u00a2\u0006\u0004\b.\u0010/R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u00100\u0082\u0001\u000245\u00a8\u00066"}, d2={"Ldev/mim1q/derelict/block/EmbersBlock;", "Lnet/minecraft/class_5778;", "Lnet/minecraft/class_3737;", "Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;", "settings", "", "particleVelocity", "<init>", "(Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;D)V", "Lnet/minecraft/class_7118;", "getGrower", "()Lnet/minecraft/class_7118;", "Lnet/minecraft/class_2689$class_2690;", "Lnet/minecraft/class_2248;", "Lnet/minecraft/class_2680;", "builder", "", "appendProperties", "(Lnet/minecraft/class_2689$class_2690;)V", "Lnet/minecraft/class_1750;", "ctx", "getPlacementState", "(Lnet/minecraft/class_1750;)Lnet/minecraft/class_2680;", "state", "Lnet/minecraft/class_3610;", "getFluidState", "(Lnet/minecraft/class_2680;)Lnet/minecraft/class_3610;", "Lnet/minecraft/class_2350;", "direction", "neighborState", "Lnet/minecraft/class_1936;", "world", "Lnet/minecraft/class_2338;", "pos", "neighborPos", "getStateForNeighborUpdate", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_2350;Lnet/minecraft/class_2680;Lnet/minecraft/class_1936;Lnet/minecraft/class_2338;Lnet/minecraft/class_2338;)Lnet/minecraft/class_2680;", "Lnet/minecraft/class_5819;", "random", "Lnet/minecraft/class_243;", "getBaseParticleOffset", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_5819;)Lnet/minecraft/class_243;", "Lnet/minecraft/class_1937;", "randomDisplayTick", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;Lnet/minecraft/class_5819;)V", "Lnet/minecraft/class_2394;", "getParticle", "(Lnet/minecraft/class_5819;)Lnet/minecraft/class_2394;", "D", "Companion", "Smoldering", "Smoking", "Ldev/mim1q/derelict/block/EmbersBlock$Smoking;", "Ldev/mim1q/derelict/block/EmbersBlock$Smoldering;", "derelict"})
public abstract class EmbersBlock
extends class_5778
implements class_3737 {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final double particleVelocity;
    @NotNull
    private static final class_2746 WATERLOGGED;

    private EmbersBlock(FabricBlockSettings settings, double particleVelocity) {
        super((class_4970.class_2251)settings.noCollision().ticksRandomly());
        this.particleVelocity = particleVelocity;
        this.method_9590((class_2680)this.method_9564().method_11657((class_2769)WATERLOGGED, (Comparable)Boolean.valueOf(false)));
    }

    public /* synthetic */ EmbersBlock(FabricBlockSettings fabricBlockSettings, double d, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            d = 0.01;
        }
        this(fabricBlockSettings, d, null);
    }

    @NotNull
    public class_7118 method_41432() {
        Intrinsics.checkNotNull(null);
        return null;
    }

    protected void method_9515(@NotNull class_2689.class_2690<class_2248, class_2680> builder) {
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        super.method_9515(builder);
        class_2769[] class_2769Array = new class_2769[]{WATERLOGGED};
        builder.method_11667(class_2769Array);
    }

    @Nullable
    public class_2680 method_9605(@NotNull class_1750 ctx) {
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        class_2680 class_26802 = super.method_9605(ctx);
        return class_26802 != null ? (class_2680)class_26802.method_11657((class_2769)WATERLOGGED, (Comparable)Boolean.valueOf(ctx.method_8045().method_8316(ctx.method_8037()).method_15772() == class_3612.field_15910)) : null;
    }

    @NotNull
    public class_3610 method_9545(@NotNull class_2680 state) {
        class_3610 class_36102;
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        if (((Boolean)state.method_11654((class_2769)WATERLOGGED)).booleanValue()) {
            class_3610 class_36103 = class_3612.field_15910.method_15729(false);
            class_36102 = class_36103;
            Intrinsics.checkNotNullExpressionValue((Object)class_36103, (String)"getStill(...)");
        } else {
            class_3610 class_36104 = super.method_9545(state);
            class_36102 = class_36104;
            Intrinsics.checkNotNullExpressionValue((Object)class_36104, (String)"getFluidState(...)");
        }
        return class_36102;
    }

    @NotNull
    public class_2680 method_9559(@NotNull class_2680 state, @NotNull class_2350 direction, @NotNull class_2680 neighborState, @NotNull class_1936 world, @NotNull class_2338 pos, @NotNull class_2338 neighborPos) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)direction, (String)"direction");
        Intrinsics.checkNotNullParameter((Object)neighborState, (String)"neighborState");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)neighborPos, (String)"neighborPos");
        world.method_39281(pos, (class_3611)class_3612.field_15910, class_3612.field_15910.method_15789((class_4538)world));
        class_2680 class_26802 = super.method_9559(state, direction, neighborState, world, pos, neighborPos);
        Intrinsics.checkNotNullExpressionValue((Object)class_26802, (String)"getStateForNeighborUpdate(...)");
        return class_26802;
    }

    private final class_243 getBaseParticleOffset(class_2680 state, class_5819 random) {
        Set directions = class_5778.method_41440((class_2680)state);
        Intrinsics.checkNotNull((Object)directions);
        class_2350 direction = (class_2350)CollectionsKt.toList((Iterable)directions).get(random.method_43048(directions.size()));
        class_243 planeVector = new class_243(1.0, 1.0, 1.0).method_1020(class_243.method_24954((class_2382)direction.method_10163().method_35862(direction.method_10171().method_10181())));
        class_243 randomOffset = planeVector.method_18805(random.method_43058(), random.method_43058(), random.method_43058()).method_1020(planeVector.method_1021(0.4));
        class_243 class_2432 = class_243.method_24954((class_2382)direction.method_10163()).method_1021(0.35).method_1019(randomOffset);
        Intrinsics.checkNotNullExpressionValue((Object)class_2432, (String)"add(...)");
        return class_2432;
    }

    public void method_9496(@NotNull class_2680 state, @NotNull class_1937 world, @NotNull class_2338 pos, @NotNull class_5819 random) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        class_2394 class_23942 = this.getParticle(random);
        if (class_23942 == null) {
            return;
        }
        class_2394 particle = class_23942;
        class_243 particlePos = this.getBaseParticleOffset(state, random).method_1019(class_243.method_24953((class_2382)((class_2382)pos)));
        world.method_8406(particle, particlePos.field_1352, particlePos.field_1351, particlePos.field_1350, 0.0, this.particleVelocity, 0.0);
    }

    @Nullable
    public abstract class_2394 getParticle(@NotNull class_5819 var1);

    public /* synthetic */ EmbersBlock(FabricBlockSettings settings, double particleVelocity, DefaultConstructorMarker $constructor_marker) {
        this(settings, particleVelocity);
    }

    static {
        class_2746 class_27462 = class_2741.field_12508;
        Intrinsics.checkNotNullExpressionValue((Object)class_27462, (String)"WATERLOGGED");
        WATERLOGGED = class_27462;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Ldev/mim1q/derelict/block/EmbersBlock$Companion;", "", "<init>", "()V", "Lnet/minecraft/class_2746;", "WATERLOGGED", "Lnet/minecraft/class_2746;", "getWATERLOGGED", "()Lnet/minecraft/class_2746;", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final class_2746 getWATERLOGGED() {
            return WATERLOGGED;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2={"Ldev/mim1q/derelict/block/EmbersBlock$Smoking;", "Ldev/mim1q/derelict/block/EmbersBlock;", "Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;", "settings", "<init>", "(Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;)V", "Lnet/minecraft/class_5819;", "random", "Lnet/minecraft/class_2394;", "getParticle", "(Lnet/minecraft/class_5819;)Lnet/minecraft/class_2394;", "derelict"})
    public static final class Smoking
    extends EmbersBlock {
        public Smoking(@NotNull FabricBlockSettings settings) {
            Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
            super(settings, 0.07, null);
        }

        @Override
        @NotNull
        public class_2394 getParticle(@NotNull class_5819 random) {
            Intrinsics.checkNotNullParameter((Object)random, (String)"random");
            class_2400 class_24002 = class_2398.field_17430;
            Intrinsics.checkNotNullExpressionValue((Object)class_24002, (String)"CAMPFIRE_COSY_SMOKE");
            return (class_2394)class_24002;
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ/\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001a"}, d2={"Ldev/mim1q/derelict/block/EmbersBlock$Smoldering;", "Ldev/mim1q/derelict/block/EmbersBlock;", "Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;", "settings", "<init>", "(Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;)V", "Lnet/minecraft/class_5819;", "random", "Lnet/minecraft/class_2394;", "getParticle", "(Lnet/minecraft/class_5819;)Lnet/minecraft/class_2394;", "Lnet/minecraft/class_1936;", "world", "Lnet/minecraft/class_2338;", "pos", "Lnet/minecraft/class_2680;", "state", "Lnet/minecraft/class_3610;", "fluid", "", "tryFillWithFluid", "(Lnet/minecraft/class_1936;Lnet/minecraft/class_2338;Lnet/minecraft/class_2680;Lnet/minecraft/class_3610;)Z", "Lnet/minecraft/class_1750;", "ctx", "getPlacementState", "(Lnet/minecraft/class_1750;)Lnet/minecraft/class_2680;", "derelict"})
    public static final class Smoldering
    extends EmbersBlock {
        public Smoldering(@NotNull FabricBlockSettings settings) {
            Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
            super(settings, 0.0, 2, null);
        }

        @Override
        @Nullable
        public class_2394 getParticle(@NotNull class_5819 random) {
            Intrinsics.checkNotNullParameter((Object)random, (String)"random");
            if (random.method_43057() < 0.8f) {
                return null;
            }
            return random.method_43057() < 0.4f ? (class_2394)class_2398.field_11240 : (class_2394)class_2398.field_11251;
        }

        public boolean method_10311(@NotNull class_1936 world, @NotNull class_2338 pos, @NotNull class_2680 state, @NotNull class_3610 fluid) {
            Intrinsics.checkNotNullParameter((Object)world, (String)"world");
            Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
            Intrinsics.checkNotNullParameter((Object)state, (String)"state");
            Intrinsics.checkNotNullParameter((Object)fluid, (String)"fluid");
            boolean canFillWithFluid = super.method_10311(world, pos, state, fluid);
            if (canFillWithFluid) {
                world.method_8652(pos, (class_2680)ModBlocksAndItems.INSTANCE.getSMOKING_EMBERS().method_34725(state).method_11657((class_2769)Companion.getWATERLOGGED(), (Comparable)Boolean.valueOf(true)), 3);
            }
            return canFillWithFluid;
        }

        @Override
        @Nullable
        public class_2680 method_9605(@NotNull class_1750 ctx) {
            Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
            class_2680 class_26802 = super.method_9605(ctx);
            if (class_26802 == null) {
                return null;
            }
            class_2680 state = class_26802;
            if (((Boolean)state.method_11654((class_2769)Companion.getWATERLOGGED())).booleanValue()) {
                return (class_2680)ModBlocksAndItems.INSTANCE.getSMOKING_EMBERS().method_34725(state).method_11657((class_2769)Companion.getWATERLOGGED(), (Comparable)Boolean.valueOf(true));
            }
            return state;
        }
    }
}

