/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1657
 *  net.minecraft.class_1750
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2318
 *  net.minecraft.class_2338
 *  net.minecraft.class_2343
 *  net.minecraft.class_2350
 *  net.minecraft.class_2498
 *  net.minecraft.class_2586
 *  net.minecraft.class_2680
 *  net.minecraft.class_2689$class_2690
 *  net.minecraft.class_2741
 *  net.minecraft.class_2769
 *  net.minecraft.class_3218
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5819
 */
package org.valkyrienskies.mod.common.block;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1657;
import net.minecraft.class_1750;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2318;
import net.minecraft.class_2338;
import net.minecraft.class_2343;
import net.minecraft.class_2350;
import net.minecraft.class_2498;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2741;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_4970;
import net.minecraft.class_5819;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.mod.common.blockentity.TestThrusterBlockEntity;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J?\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u0019\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001d\u001a\u00020\u00122\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u001bH\u0014\u00a2\u0006\u0004\b\u001d\u0010\u001eJ!\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b \u0010!\u00a8\u0006$"}, d2={"Lorg/valkyrienskies/mod/common/block/TestThrusterBlock;", "Lnet/minecraft/class_2318;", "Lnet/minecraft/class_2343;", "Lnet/minecraft/class_1750;", "blockPlaceContext", "Lnet/minecraft/class_2680;", "getStateForPlacement", "(Lnet/minecraft/class_1750;)Lnet/minecraft/class_2680;", "blockState", "Lnet/minecraft/class_1937;", "level", "Lnet/minecraft/class_2338;", "blockPos", "Lnet/minecraft/class_2248;", "block", "blockPos2", "", "bl", "", "neighborChanged", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;Lnet/minecraft/class_2248;Lnet/minecraft/class_2338;Z)V", "Lnet/minecraft/class_3218;", "serverLevel", "Lnet/minecraft/class_5819;", "randomSource", "tick", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_3218;Lnet/minecraft/class_2338;Lnet/minecraft/class_5819;)V", "Lnet/minecraft/class_2689$class_2690;", "builder", "createBlockStateDefinition", "(Lnet/minecraft/class_2689$class_2690;)V", "Lnet/minecraft/class_2586;", "newBlockEntity", "(Lnet/minecraft/class_2338;Lnet/minecraft/class_2680;)Lnet/minecraft/class_2586;", "<init>", "()V", "valkyrienskies-120"})
public final class TestThrusterBlock
extends class_2318
implements class_2343 {
    @NotNull
    public static final TestThrusterBlock INSTANCE = new TestThrusterBlock();

    private TestThrusterBlock() {
        super(class_4970.class_2251.method_9637().method_9629(10.0f, 1200.0f).method_9626(class_2498.field_11533));
    }

    /*
     * Enabled aggressive block sorting
     */
    @Nullable
    public class_2680 method_9605(@NotNull class_1750 blockPlaceContext) {
        class_2350 class_23502;
        Intrinsics.checkNotNullParameter((Object)blockPlaceContext, (String)"blockPlaceContext");
        class_2680 class_26802 = (class_2680)this.method_9564().method_11657((class_2769)class_2741.field_12484, (Comparable)Boolean.valueOf(blockPlaceContext.method_8045().method_49803(blockPlaceContext.method_8037())));
        class_2769 class_27692 = (class_2769)class_2318.field_10927;
        if (blockPlaceContext.method_8036() != null) {
            class_1657 class_16572 = blockPlaceContext.method_8036();
            Intrinsics.checkNotNull((Object)class_16572);
            if (class_16572.method_18276()) {
                class_23502 = blockPlaceContext.method_7715().method_10153();
                return (class_2680)class_26802.method_11657(class_27692, (Comparable)class_23502);
            }
        }
        class_23502 = blockPlaceContext.method_8042();
        return (class_2680)class_26802.method_11657(class_27692, (Comparable)class_23502);
    }

    public void method_9612(@NotNull class_2680 blockState, @NotNull class_1937 level, @NotNull class_2338 blockPos, @NotNull class_2248 block, @NotNull class_2338 blockPos2, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)blockState, (String)"blockState");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        Intrinsics.checkNotNullParameter((Object)block, (String)"block");
        Intrinsics.checkNotNullParameter((Object)blockPos2, (String)"blockPos2");
        if (!level.field_9236) {
            Boolean previouslyPowered = (Boolean)blockState.method_11654((class_2769)class_2741.field_12484);
            if (!Intrinsics.areEqual((Object)previouslyPowered, (Object)level.method_49803(blockPos))) {
                Object object = blockState.method_28493((class_2769)class_2741.field_12484);
                Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type net.minecraft.world.level.block.state.BlockState");
                level.method_8652(blockPos, (class_2680)object, 2);
            }
            if (level instanceof class_3218 && ((class_3218)level).method_8321(blockPos) instanceof TestThrusterBlockEntity) {
                class_2586 class_25862 = ((class_3218)level).method_8321(blockPos);
                Intrinsics.checkNotNull((Object)class_25862, (String)"null cannot be cast to non-null type org.valkyrienskies.mod.common.blockentity.TestThrusterBlockEntity");
                TestThrusterBlockEntity blockEntity = (TestThrusterBlockEntity)class_25862;
                blockEntity.setActive((Boolean)blockState.method_11654((class_2769)class_2741.field_12484));
            }
        }
    }

    public void method_9588(@NotNull class_2680 blockState, @NotNull class_3218 serverLevel, @NotNull class_2338 blockPos, @NotNull class_5819 randomSource) {
        Intrinsics.checkNotNullParameter((Object)blockState, (String)"blockState");
        Intrinsics.checkNotNullParameter((Object)serverLevel, (String)"serverLevel");
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        Intrinsics.checkNotNullParameter((Object)randomSource, (String)"randomSource");
    }

    protected void method_9515(@NotNull class_2689.class_2690<class_2248, class_2680> builder) {
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        class_2769[] class_2769Array = new class_2769[]{class_2741.field_12484};
        class_2689.class_2690 class_26902 = builder.method_11667(class_2769Array);
        class_2769Array = new class_2769[]{class_2318.field_10927};
        class_26902.method_11667(class_2769Array);
    }

    @Nullable
    public class_2586 method_10123(@NotNull class_2338 blockPos, @NotNull class_2680 blockState) {
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        Intrinsics.checkNotNullParameter((Object)blockState, (String)"blockState");
        return new TestThrusterBlockEntity(blockPos, blockState);
    }

    static {
        INSTANCE.method_9590((class_2680)((class_2680)((class_2680)TestThrusterBlock.INSTANCE.field_10647.method_11664()).method_11657((class_2769)class_2741.field_12484, (Comparable)Boolean.valueOf(false))).method_11657((class_2769)class_2318.field_10927, (Comparable)class_2350.field_11043));
    }
}

