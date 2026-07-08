/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_3491
 *  net.minecraft.class_3492
 *  net.minecraft.class_3499$class_3501
 *  net.minecraft.class_3828
 *  net.minecraft.class_4538
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.world.feature;

import com.mojang.serialization.Codec;
import dev.mim1q.derelict.init.worldgen.ModFeatures;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2338;
import net.minecraft.class_3491;
import net.minecraft.class_3492;
import net.minecraft.class_3499;
import net.minecraft.class_3828;
import net.minecraft.class_4538;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J?\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0014\u00a2\u0006\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2={"Ldev/mim1q/derelict/world/feature/LocalGravityProcessor;", "Lnet/minecraft/class_3491;", "<init>", "()V", "Lnet/minecraft/class_4538;", "world", "Lnet/minecraft/class_2338;", "pos", "pivot", "Lnet/minecraft/class_3499$class_3501;", "originalBlockInfo", "currentBlockInfo", "Lnet/minecraft/class_3492;", "data", "process", "(Lnet/minecraft/class_4538;Lnet/minecraft/class_2338;Lnet/minecraft/class_2338;Lnet/minecraft/class_3499$class_3501;Lnet/minecraft/class_3499$class_3501;Lnet/minecraft/class_3492;)Lnet/minecraft/class_3499$class_3501;", "Lnet/minecraft/class_3828;", "getType", "()Lnet/minecraft/class_3828;", "Companion", "derelict"})
public final class LocalGravityProcessor
extends class_3491 {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Codec<LocalGravityProcessor> CODEC;

    @NotNull
    public class_3499.class_3501 method_15110(@NotNull class_4538 world, @NotNull class_2338 pos, @NotNull class_2338 pivot, @NotNull class_3499.class_3501 originalBlockInfo, @NotNull class_3499.class_3501 currentBlockInfo, @NotNull class_3492 data) {
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)pivot, (String)"pivot");
        Intrinsics.checkNotNullParameter((Object)originalBlockInfo, (String)"originalBlockInfo");
        Intrinsics.checkNotNullParameter((Object)currentBlockInfo, (String)"currentBlockInfo");
        Intrinsics.checkNotNullParameter((Object)data, (String)"data");
        class_2338.class_2339 mutPos = currentBlockInfo.comp_1341().method_25503();
        int diff = mutPos.method_10264() - pos.method_10264();
        int i = 0;
        int n = 10 + diff;
        if (i <= n) {
            while (true) {
                if (i == 10) {
                    return originalBlockInfo;
                }
                if (!world.method_8320((class_2338)mutPos).method_26215()) {
                    mutPos.method_10100(0, 1, 0);
                    break;
                }
                mutPos.method_10100(0, -1, 0);
                if (i == n) break;
                ++i;
            }
        }
        return new class_3499.class_3501(mutPos.method_10069(0, diff, 0), originalBlockInfo.comp_1342(), originalBlockInfo.comp_1343());
    }

    @NotNull
    protected class_3828<?> method_16772() {
        return ModFeatures.INSTANCE.getLOCAL_GRAVITY_PROCESSOR();
    }

    static {
        Codec codec = Codec.unit((Object)((Object)new LocalGravityProcessor()));
        Intrinsics.checkNotNullExpressionValue((Object)codec, (String)"unit(...)");
        CODEC = codec;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2={"Ldev/mim1q/derelict/world/feature/LocalGravityProcessor$Companion;", "", "<init>", "()V", "Lcom/mojang/serialization/Codec;", "Ldev/mim1q/derelict/world/feature/LocalGravityProcessor;", "CODEC", "Lcom/mojang/serialization/Codec;", "getCODEC", "()Lcom/mojang/serialization/Codec;", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Codec<LocalGravityProcessor> getCODEC() {
            return CODEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

