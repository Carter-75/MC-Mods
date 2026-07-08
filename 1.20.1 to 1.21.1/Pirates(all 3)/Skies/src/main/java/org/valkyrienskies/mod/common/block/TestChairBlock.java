/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1750
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2183$class_2184
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  net.minecraft.class_2383
 *  net.minecraft.class_2498
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_2689$class_2690
 *  net.minecraft.class_2769
 *  net.minecraft.class_3726
 *  net.minecraft.class_3965
 *  net.minecraft.class_4970$class_2251
 */
package org.valkyrienskies.mod.common.block;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1750;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2183;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_2383;
import net.minecraft.class_2498;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2769;
import net.minecraft.class_3726;
import net.minecraft.class_3965;
import net.minecraft.class_4970;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.util.VectorConversionsKt;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;
import org.valkyrienskies.mod.common.entity.ShipMountingEntity;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J#\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0014\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ5\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0017\u00a2\u0006\u0004\b\u0015\u0010\u0016J?\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0017\u00a2\u0006\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006%"}, d2={"Lorg/valkyrienskies/mod/common/block/TestChairBlock;", "Lnet/minecraft/class_2383;", "Lnet/minecraft/class_2689$class_2690;", "Lnet/minecraft/class_2248;", "Lnet/minecraft/class_2680;", "builder", "", "createBlockStateDefinition", "(Lnet/minecraft/class_2689$class_2690;)V", "Lnet/minecraft/class_1750;", "ctx", "getStateForPlacement", "(Lnet/minecraft/class_1750;)Lnet/minecraft/class_2680;", "state", "Lnet/minecraft/class_1922;", "level", "Lnet/minecraft/class_2338;", "pos", "Lnet/minecraft/class_3726;", "context", "Lnet/minecraft/class_265;", "getShape", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_1922;Lnet/minecraft/class_2338;Lnet/minecraft/class_3726;)Lnet/minecraft/class_265;", "Lnet/minecraft/class_1937;", "Lnet/minecraft/class_1657;", "player", "Lnet/minecraft/class_1268;", "hand", "Lnet/minecraft/class_3965;", "blockHitResult", "Lnet/minecraft/class_1269;", "use", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;Lnet/minecraft/class_1657;Lnet/minecraft/class_1268;Lnet/minecraft/class_3965;)Lnet/minecraft/class_1269;", "SEAT_AABB", "Lnet/minecraft/class_265;", "<init>", "()V", "valkyrienskies-120"})
public final class TestChairBlock
extends class_2383 {
    @NotNull
    public static final TestChairBlock INSTANCE = new TestChairBlock();
    @NotNull
    private static final class_265 SEAT_AABB;

    private TestChairBlock() {
        super(class_4970.class_2251.method_9637().method_9629(1.0f, 120.0f).method_9626(class_2498.field_11543));
    }

    protected void method_9515(@NotNull class_2689.class_2690<class_2248, class_2680> builder) {
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        class_2769[] class_2769Array = new class_2769[]{class_2383.field_11177};
        builder.method_11667(class_2769Array);
    }

    @Nullable
    public class_2680 method_9605(@NotNull class_1750 ctx) {
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        return (class_2680)this.method_9564().method_11657((class_2769)class_2383.field_11177, (Comparable)ctx.method_8042().method_10153());
    }

    @Deprecated(message="Deprecated in Java")
    @NotNull
    public class_265 method_9530(@NotNull class_2680 state, @Nullable class_1922 level, @Nullable class_2338 pos, @Nullable class_3726 context) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        return SEAT_AABB;
    }

    @Deprecated(message="Deprecated in Java")
    @NotNull
    public class_1269 method_9534(@NotNull class_2680 state, @NotNull class_1937 level, @NotNull class_2338 pos, @NotNull class_1657 player, @NotNull class_1268 hand, @NotNull class_3965 blockHitResult) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)hand, (String)"hand");
        Intrinsics.checkNotNullParameter((Object)blockHitResult, (String)"blockHitResult");
        if (level.field_9236) {
            return class_1269.field_5812;
        }
        class_1297 class_12972 = ValkyrienSkiesMod.INSTANCE.getSHIP_MOUNTING_ENTITY_TYPE().method_5883(level);
        Intrinsics.checkNotNull((Object)class_12972);
        class_1297 class_12973 = class_12972;
        ShipMountingEntity $this$use_u24lambda_u240 = (ShipMountingEntity)class_12973;
        boolean bl = false;
        Vector3dc seatEntityPos = new Vector3d((double)pos.method_10263() + 0.5, pos.method_10264(), (double)pos.method_10260() + 0.5);
        $this$use_u24lambda_u240.method_24203(VectorConversionsKt.getX(seatEntityPos), VectorConversionsKt.getY(seatEntityPos), VectorConversionsKt.getZ(seatEntityPos));
        class_2382 class_23822 = ((class_2350)state.method_11654((class_2769)class_2383.field_11177)).method_10163();
        Intrinsics.checkNotNullExpressionValue((Object)class_23822, (String)"getNormal(...)");
        $this$use_u24lambda_u240.method_5702(class_2183.class_2184.field_9851, VectorConversionsMCKt.toDoubles(class_23822).method_1019($this$use_u24lambda_u240.method_19538()));
        $this$use_u24lambda_u240.setController(true);
        ShipMountingEntity seatEntity = (ShipMountingEntity)class_12973;
        level.method_8649((class_1297)seatEntity);
        player.method_5804((class_1297)seatEntity);
        return class_1269.field_21466;
    }

    static {
        class_265 class_2652 = class_2383.method_9541((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)8.0, (double)16.0);
        Intrinsics.checkNotNullExpressionValue((Object)class_2652, (String)"box(...)");
        SEAT_AABB = class_2652;
        INSTANCE.method_9590((class_2680)((class_2680)TestChairBlock.INSTANCE.field_10647.method_11664()).method_11657((class_2769)class_2383.field_11177, (Comparable)class_2350.field_11043));
    }
}

