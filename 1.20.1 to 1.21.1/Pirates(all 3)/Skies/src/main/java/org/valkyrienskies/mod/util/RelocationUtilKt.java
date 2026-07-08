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
 *  net.minecraft.class_2470
 *  net.minecraft.class_2487
 *  net.minecraft.class_2586
 *  net.minecraft.class_2621
 *  net.minecraft.class_2680
 *  net.minecraft.class_2818
 *  net.minecraft.class_3829
 */
package org.valkyrienskies.mod.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2470;
import net.minecraft.class_2487;
import net.minecraft.class_2586;
import net.minecraft.class_2621;
import net.minecraft.class_2680;
import net.minecraft.class_2818;
import net.minecraft.class_3829;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.api.ships.ServerShip;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001aI\u0010\r\u001a\u00020\f2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\r\u0010\u000e\u001a-\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001a;\u0010\r\u001a\u00020\f*\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\r\u0010\u0017\"\u001c\u0010\u0019\u001a\n \u0018*\u0004\u0018\u00010\u00130\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001b"}, d2={"Lnet/minecraft/class_2818;", "fromChunk", "Lnet/minecraft/class_2338;", "from", "toChunk", "to", "", "doUpdate", "Lorg/valkyrienskies/core/api/ships/ServerShip;", "toShip", "Lnet/minecraft/class_2470;", "rotation", "", "relocateBlock", "(Lnet/minecraft/class_2818;Lnet/minecraft/class_2338;Lnet/minecraft/class_2818;Lnet/minecraft/class_2338;ZLorg/valkyrienskies/core/api/ships/ServerShip;Lnet/minecraft/class_2470;)V", "Lnet/minecraft/class_1937;", "level", "fromPos", "toPos", "Lnet/minecraft/class_2680;", "toState", "updateBlock", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;Lnet/minecraft/class_2338;Lnet/minecraft/class_2680;)V", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;Lnet/minecraft/class_2338;ZLorg/valkyrienskies/core/api/ships/ServerShip;Lnet/minecraft/class_2470;)V", "kotlin.jvm.PlatformType", "AIR", "Lnet/minecraft/class_2680;", "valkyrienskies-120"})
public final class RelocationUtilKt {
    private static final class_2680 AIR = class_2246.field_10124.method_9564();

    public static final void relocateBlock(@NotNull class_2818 fromChunk, @NotNull class_2338 from, @NotNull class_2818 toChunk, @NotNull class_2338 to2, boolean doUpdate, @Nullable ServerShip toShip, @NotNull class_2470 rotation) {
        block5: {
            class_2487 class_24872;
            class_2586 it;
            Intrinsics.checkNotNullParameter((Object)fromChunk, (String)"fromChunk");
            Intrinsics.checkNotNullParameter((Object)from, (String)"from");
            Intrinsics.checkNotNullParameter((Object)toChunk, (String)"toChunk");
            Intrinsics.checkNotNullParameter((Object)to2, (String)"to");
            Intrinsics.checkNotNullParameter((Object)rotation, (String)"rotation");
            class_2680 state = fromChunk.method_8320(from);
            class_2586 entity = fromChunk.method_8321(from);
            class_1937 level = toChunk.method_12200();
            class_2586 class_25862 = entity;
            if (class_25862 != null) {
                it = class_25862;
                boolean bl = false;
                class_2487 tag = it.method_38242();
                tag.method_10569("x", to2.method_10263());
                tag.method_10569("y", to2.method_10264());
                tag.method_10569("z", to2.method_10260());
                if (it instanceof class_3829) {
                    class_2586 blockEntity = it;
                    class_2487 emptyTag = new class_2487();
                    blockEntity.method_11014(emptyTag);
                }
                if (it instanceof class_2621) {
                    ((class_2621)it).method_11285(null, 0L);
                }
                level.method_8544(from);
                class_24872 = tag;
            } else {
                class_24872 = null;
            }
            class_2487 tag = class_24872;
            state = state.method_26186(rotation);
            fromChunk.method_12010(from, AIR, false);
            toChunk.method_12010(to2, state, false);
            if (doUpdate) {
                Intrinsics.checkNotNull((Object)level);
                class_2680 class_26802 = state;
                Intrinsics.checkNotNull((Object)class_26802);
                RelocationUtilKt.updateBlock(level, from, to2, class_26802);
            }
            class_2487 class_24873 = tag;
            if (class_24873 == null) break block5;
            it = class_24873;
            boolean bl = false;
            class_2586 class_25863 = level.method_8321(to2);
            Intrinsics.checkNotNull((Object)class_25863);
            class_2586 be = class_25863;
            be.method_11014((class_2487)it);
        }
    }

    public static /* synthetic */ void relocateBlock$default(class_2818 class_28182, class_2338 class_23382, class_2818 class_28183, class_2338 class_23383, boolean bl, ServerShip serverShip, class_2470 class_24702, int n2, Object object) {
        if ((n2 & 0x40) != 0) {
            class_24702 = class_2470.field_11467;
        }
        RelocationUtilKt.relocateBlock(class_28182, class_23382, class_28183, class_23383, bl, serverShip, class_24702);
    }

    public static final void updateBlock(@NotNull class_1937 level, @NotNull class_2338 fromPos, @NotNull class_2338 toPos, @NotNull class_2680 toState) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)fromPos, (String)"fromPos");
        Intrinsics.checkNotNullParameter((Object)toPos, (String)"toPos");
        Intrinsics.checkNotNullParameter((Object)toState, (String)"toState");
        int flags = 107;
        int recursionLeft = 511;
        level.method_16109(fromPos, toState, AIR);
        level.method_8413(fromPos, toState, AIR, flags);
        level.method_8408(fromPos, AIR.method_26204());
        AIR.method_26198((class_1936)level, fromPos, flags, recursionLeft - 1);
        AIR.method_26183((class_1936)level, fromPos, flags, recursionLeft);
        AIR.method_26198((class_1936)level, fromPos, flags, recursionLeft);
        level.method_8398().method_12130().method_15513(fromPos);
        level.method_16109(toPos, AIR, toState);
        level.method_8413(toPos, AIR, toState, flags);
        level.method_8408(toPos, toState.method_26204());
        if (!level.field_9236 && toState.method_26221()) {
            level.method_8455(toPos, toState.method_26204());
        }
        level.method_8398().method_12130().method_15513(toPos);
    }

    public static final void relocateBlock(@NotNull class_1937 $this$relocateBlock, @NotNull class_2338 from, @NotNull class_2338 to2, boolean doUpdate, @Nullable ServerShip toShip, @NotNull class_2470 rotation) {
        Intrinsics.checkNotNullParameter((Object)$this$relocateBlock, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)from, (String)"from");
        Intrinsics.checkNotNullParameter((Object)to2, (String)"to");
        Intrinsics.checkNotNullParameter((Object)rotation, (String)"rotation");
        class_2818 class_28182 = $this$relocateBlock.method_8500(from);
        Intrinsics.checkNotNullExpressionValue((Object)class_28182, (String)"getChunkAt(...)");
        class_2818 class_28183 = $this$relocateBlock.method_8500(to2);
        Intrinsics.checkNotNullExpressionValue((Object)class_28183, (String)"getChunkAt(...)");
        RelocationUtilKt.relocateBlock(class_28182, from, class_28183, to2, doUpdate, toShip, rotation);
    }
}

