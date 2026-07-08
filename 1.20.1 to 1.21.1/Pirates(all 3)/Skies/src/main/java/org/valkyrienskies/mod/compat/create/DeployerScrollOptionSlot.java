/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.contraptions.DirectionalExtenderScrollOptionSlot
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1936
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_2741
 *  net.minecraft.class_2769
 */
package org.valkyrienskies.mod.compat.create;

import com.simibubi.create.content.contraptions.DirectionalExtenderScrollOptionSlot;
import java.util.function.BiPredicate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1936;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_2769;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2={"Lorg/valkyrienskies/mod/compat/create/DeployerScrollOptionSlot;", "Lcom/simibubi/create/content/contraptions/DirectionalExtenderScrollOptionSlot;", "Lnet/minecraft/class_1936;", "level", "Lnet/minecraft/class_2338;", "pos", "Lnet/minecraft/class_2680;", "state", "Lnet/minecraft/class_243;", "getLocalOffset", "(Lnet/minecraft/class_1936;Lnet/minecraft/class_2338;Lnet/minecraft/class_2680;)Lnet/minecraft/class_243;", "Ljava/util/function/BiPredicate;", "Lnet/minecraft/class_2350;", "allowedDirections", "<init>", "(Ljava/util/function/BiPredicate;)V", "valkyrienskies-120"})
public final class DeployerScrollOptionSlot
extends DirectionalExtenderScrollOptionSlot {
    public DeployerScrollOptionSlot(@NotNull BiPredicate<class_2680, class_2350> allowedDirections) {
        Intrinsics.checkNotNullParameter(allowedDirections, (String)"allowedDirections");
        super(allowedDirections);
    }

    @NotNull
    public class_243 getLocalOffset(@NotNull class_1936 level, @NotNull class_2338 pos, @NotNull class_2680 state) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        class_243 class_2432 = super.getLocalOffset(level, pos, state).method_1019(class_243.method_24954((class_2382)((class_2350)state.method_11654((class_2769)class_2741.field_12525)).method_10163()).method_1021(-0.25));
        Intrinsics.checkNotNullExpressionValue((Object)class_2432, (String)"add(...)");
        return class_2432;
    }
}

