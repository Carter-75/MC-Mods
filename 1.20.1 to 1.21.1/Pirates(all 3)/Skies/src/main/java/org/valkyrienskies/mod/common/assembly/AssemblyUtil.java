/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1936
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_2350$class_2352
 *  net.minecraft.class_2487
 *  net.minecraft.class_2586
 *  net.minecraft.class_2680
 *  net.minecraft.class_2791
 *  net.minecraft.class_2818
 *  net.minecraft.class_2826
 *  net.minecraft.class_3532
 *  net.minecraft.class_6760
 */
package org.valkyrienskies.mod.common.assembly;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2487;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_2791;
import net.minecraft.class_2818;
import net.minecraft.class_2826;
import net.minecraft.class_3532;
import net.minecraft.class_6760;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;
import org.joml.Vector3i;
import org.valkyrienskies.mod.common.assembly.AssemblyUtilKt;
import org.valkyrienskies.mod.common.assembly.ShipAssembler;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b,\u0010-J%\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000b\u0010\fJ%\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001a\u0010\u001eJ\u0015\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b\"\u0010#J\u001d\u0010&\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004\u00a2\u0006\u0004\b&\u0010'J\u001d\u0010(\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004\u00a2\u0006\u0004\b(\u0010'J\u001d\u0010)\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004\u00a2\u0006\u0004\b)\u0010*J\u001d\u0010)\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u001c\u00a2\u0006\u0004\b)\u0010+\u00a8\u0006."}, d2={"Lorg/valkyrienskies/mod/common/assembly/AssemblyUtil;", "", "Lnet/minecraft/class_1937;", "level", "Lnet/minecraft/class_2338;", "pos", "Lnet/minecraft/class_2680;", "state", "", "setBlock", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;Lnet/minecraft/class_2680;)V", "removeBlock", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;)V", "from", "to", "copyBlock", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;Lnet/minecraft/class_2338;)V", "fromPos", "toPos", "toState", "updateBlock", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;Lnet/minecraft/class_2338;Lnet/minecraft/class_2680;)V", "", "x", "y", "z", "toBlockPos", "(DDD)Lnet/minecraft/class_2338;", "Lorg/joml/Vector3d;", "vec", "(Lorg/joml/Vector3d;)Lnet/minecraft/class_2338;", "Lorg/joml/Vector3i;", "v", "Lnet/minecraft/class_2350;", "getVecDirection", "(Lorg/joml/Vector3i;)Lnet/minecraft/class_2350;", "pos1", "pos2", "getMinCorner", "(Lnet/minecraft/class_2338;Lnet/minecraft/class_2338;)Lnet/minecraft/class_2338;", "getMaxCorner", "getMiddle", "(Lnet/minecraft/class_2338;Lnet/minecraft/class_2338;)Lorg/joml/Vector3i;", "(Lorg/joml/Vector3d;Lorg/joml/Vector3d;)Lorg/joml/Vector3d;", "<init>", "()V", "valkyrienskies-120"})
public final class AssemblyUtil {
    @NotNull
    public static final AssemblyUtil INSTANCE = new AssemblyUtil();

    private AssemblyUtil() {
    }

    public final void setBlock(@NotNull class_1937 level, @NotNull class_2338 pos, @NotNull class_2680 state) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        class_2791 class_27912 = level.method_22350(pos);
        Intrinsics.checkNotNull((Object)class_27912, (String)"null cannot be cast to non-null type net.minecraft.world.level.chunk.LevelChunk");
        class_2818 chunk = (class_2818)class_27912;
        class_2826 section = chunk.method_38259(chunk.method_31602(pos.method_10264()));
        class_2680 oldState = level.method_8320(pos);
        section.method_16675(pos.method_10263() & 0xF, pos.method_10264() & 0xF, pos.method_10260() & 0xF, state);
        ShipAssembler.INSTANCE.triggerBlockChange(level, pos, oldState, state);
    }

    public final void removeBlock(@NotNull class_1937 level, @NotNull class_2338 pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        level.method_8544(pos);
        level.method_22350(pos).method_12010(pos, class_2246.field_10124.method_9564(), false);
    }

    public final void copyBlock(@NotNull class_1937 level, @NotNull class_2338 from, @NotNull class_2338 to2) {
        block2: {
            class_2586 newBlockentity;
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            Intrinsics.checkNotNullParameter((Object)from, (String)"from");
            Intrinsics.checkNotNullParameter((Object)to2, (String)"to");
            class_2680 state = level.method_8320(from);
            class_2586 blockentity = level.method_8321(from);
            level.method_22350(to2).method_12010(to2, state, false);
            if (level.method_8397().method_8674(from, (Object)state.method_26204())) {
                level.method_8397().method_39363(new class_6760((Object)state.method_26204(), to2, 0L, 0L));
            }
            if (!state.method_31709() || blockentity == null) break block2;
            class_2487 class_24872 = blockentity.method_38243();
            Intrinsics.checkNotNullExpressionValue((Object)class_24872, (String)"saveWithId(...)");
            class_2487 data = class_24872;
            level.method_8438(blockentity);
            class_2586 class_25862 = newBlockentity = level.method_8321(to2);
            if (class_25862 != null) {
                class_25862.method_11014(data);
            }
        }
    }

    public final void updateBlock(@NotNull class_1937 level, @NotNull class_2338 fromPos, @NotNull class_2338 toPos, @NotNull class_2680 toState) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)fromPos, (String)"fromPos");
        Intrinsics.checkNotNullParameter((Object)toPos, (String)"toPos");
        Intrinsics.checkNotNullParameter((Object)toState, (String)"toState");
        int flags = 11;
        int recursionLeft = 511;
        level.method_16109(fromPos, toState, AssemblyUtilKt.access$getAIR$p());
        level.method_8413(fromPos, toState, AssemblyUtilKt.access$getAIR$p(), flags);
        level.method_8408(fromPos, AssemblyUtilKt.access$getAIR$p().method_26204());
        AssemblyUtilKt.access$getAIR$p().method_26198((class_1936)level, fromPos, flags, recursionLeft - 1);
        AssemblyUtilKt.access$getAIR$p().method_26183((class_1936)level, fromPos, flags, recursionLeft);
        AssemblyUtilKt.access$getAIR$p().method_26198((class_1936)level, fromPos, flags, recursionLeft);
        level.method_8398().method_12130().method_15513(fromPos);
        level.method_16109(toPos, AssemblyUtilKt.access$getAIR$p(), toState);
        level.method_8413(toPos, AssemblyUtilKt.access$getAIR$p(), toState, flags);
        level.method_8408(toPos, toState.method_26204());
        if (!level.field_9236 && toState.method_26221()) {
            level.method_8455(toPos, toState.method_26204());
        }
        level.method_8398().method_12130().method_15513(toPos);
    }

    @NotNull
    public final class_2338 toBlockPos(double x, double y, double z) {
        return new class_2338(class_3532.method_15357((double)x), (int)Math.floor(y), (int)Math.floor(z));
    }

    @NotNull
    public final class_2338 toBlockPos(@NotNull Vector3d vec) {
        Intrinsics.checkNotNullParameter((Object)vec, (String)"vec");
        return this.toBlockPos(vec.x, vec.y, vec.z);
    }

    @NotNull
    public final class_2350 getVecDirection(@NotNull Vector3i v) {
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        class_2350.class_2351 axis = class_2350.class_2351.field_11048;
        if (v.y() != 0) {
            axis = class_2350.class_2351.field_11052;
        }
        if (v.z() != 0) {
            axis = class_2350.class_2351.field_11051;
        }
        class_2350.class_2352 direction = v.x + v.y + v.z > 0 ? class_2350.class_2352.field_11056 : class_2350.class_2352.field_11060;
        class_2350 class_23502 = class_2350.method_10169((class_2350.class_2351)axis, (class_2350.class_2352)direction);
        Intrinsics.checkNotNullExpressionValue((Object)class_23502, (String)"fromAxisAndDirection(...)");
        return class_23502;
    }

    @NotNull
    public final class_2338 getMinCorner(@NotNull class_2338 pos1, @NotNull class_2338 pos2) {
        Intrinsics.checkNotNullParameter((Object)pos1, (String)"pos1");
        Intrinsics.checkNotNullParameter((Object)pos2, (String)"pos2");
        return new class_2338(Math.min(pos1.method_10263(), pos2.method_10263()), Math.min(pos1.method_10264(), pos2.method_10264()), Math.min(pos1.method_10260(), pos2.method_10260()));
    }

    @NotNull
    public final class_2338 getMaxCorner(@NotNull class_2338 pos1, @NotNull class_2338 pos2) {
        Intrinsics.checkNotNullParameter((Object)pos1, (String)"pos1");
        Intrinsics.checkNotNullParameter((Object)pos2, (String)"pos2");
        return new class_2338(Math.max(pos1.method_10263(), pos2.method_10263()), Math.max(pos1.method_10264(), pos2.method_10264()), Math.max(pos1.method_10260(), pos2.method_10260()));
    }

    @NotNull
    public final Vector3i getMiddle(@NotNull class_2338 pos1, @NotNull class_2338 pos2) {
        Intrinsics.checkNotNullParameter((Object)pos1, (String)"pos1");
        Intrinsics.checkNotNullParameter((Object)pos2, (String)"pos2");
        double middleX = (double)Math.min(pos1.method_10263(), pos2.method_10263()) + (double)((Math.max(pos1.method_10263(), pos2.method_10263()) - Math.min(pos1.method_10263(), pos2.method_10263()) + 1) / 2);
        double middleY = (double)Math.min(pos1.method_10264(), pos2.method_10264()) + (double)((Math.max(pos1.method_10264(), pos2.method_10264()) - Math.min(pos1.method_10264(), pos2.method_10264()) + 1) / 2);
        double middleZ = (double)Math.min(pos1.method_10260(), pos2.method_10260()) + (double)((Math.max(pos1.method_10260(), pos2.method_10260()) - Math.min(pos1.method_10260(), pos2.method_10260()) + 1) / 2);
        return new Vector3i((int)middleX, (int)middleY, (int)middleZ);
    }

    @NotNull
    public final Vector3d getMiddle(@NotNull Vector3d pos1, @NotNull Vector3d pos2) {
        Intrinsics.checkNotNullParameter((Object)pos1, (String)"pos1");
        Intrinsics.checkNotNullParameter((Object)pos2, (String)"pos2");
        double middleX = Math.min(pos1.x, pos2.x) + (Math.max(pos1.x, pos2.x) - Math.min(pos1.x, pos2.x)) / 2.0;
        double middleY = Math.min(pos1.y, pos2.y) + (Math.max(pos1.y, pos2.y) - Math.min(pos1.y, pos2.y)) / 2.0;
        double middleZ = Math.min(pos1.z, pos2.z) + (Math.max(pos1.z, pos2.z) - Math.min(pos1.z, pos2.z)) / 2.0;
        return new Vector3d(middleX, middleY, middleZ);
    }
}

