/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  at.petrak.hexcasting.api.casting.eval.CastingEnvironment
 *  dan200.computercraft.api.pocket.IPocketAccess
 *  dan200.computercraft.api.turtle.ITurtleAccess
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_243
 *  net.walksanator.hextweaks.casting.environment.ComputerCastingEnv
 */
package org.valkyrienskies.mod.compat.hexcasting.hextweaks;

import at.petrak.hexcasting.api.casting.eval.CastingEnvironment;
import dan200.computercraft.api.pocket.IPocketAccess;
import dan200.computercraft.api.turtle.ITurtleAccess;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_243;
import net.walksanator.hextweaks.casting.environment.ComputerCastingEnv;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2={"Lorg/valkyrienskies/mod/compat/hexcasting/hextweaks/HexTweaksCompat;", "", "Lat/petrak/hexcasting/api/casting/eval/CastingEnvironment;", "env", "Lnet/minecraft/class_243;", "getComputerPosition", "(Lat/petrak/hexcasting/api/casting/eval/CastingEnvironment;)Lnet/minecraft/class_243;", "<init>", "()V", "valkyrienskies-120"})
public final class HexTweaksCompat {
    @NotNull
    public static final HexTweaksCompat INSTANCE = new HexTweaksCompat();

    private HexTweaksCompat() {
    }

    @Nullable
    public final class_243 getComputerPosition(@NotNull CastingEnvironment env) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        if (env instanceof ComputerCastingEnv) {
            IPocketAccess iPocketAccess = ((ComputerCastingEnv)env).getPocketData();
            if (iPocketAccess != null) {
                IPocketAccess data = iPocketAccess;
                boolean bl = false;
                return data.getPosition();
            }
            Pair pair = ((ComputerCastingEnv)env).getTurtleData();
            if (pair != null) {
                Pair data = pair;
                boolean bl = false;
                return ((ITurtleAccess)data.getFirst()).getPosition().method_46558();
            }
        }
        return null;
    }
}

