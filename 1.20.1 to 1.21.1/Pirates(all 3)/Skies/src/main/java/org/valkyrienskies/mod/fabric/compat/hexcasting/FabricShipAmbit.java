/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  at.petrak.hexcasting.api.casting.eval.CastingEnvironment
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.fabricmc.loader.api.FabricLoader
 *  net.minecraft.class_243
 */
package org.valkyrienskies.mod.fabric.compat.hexcasting;

import at.petrak.hexcasting.api.casting.eval.CastingEnvironment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.class_243;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.mod.compat.hexcasting.AmbitRemapping;
import org.valkyrienskies.mod.compat.hexcasting.hextweaks.HexTweaksCompat;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\t"}, d2={"Lorg/valkyrienskies/mod/fabric/compat/hexcasting/FabricShipAmbit;", "Lorg/valkyrienskies/mod/compat/hexcasting/AmbitRemapping;", "Lnet/minecraft/class_243;", "getCasterPosition", "()Lnet/minecraft/class_243;", "Lat/petrak/hexcasting/api/casting/eval/CastingEnvironment;", "env", "<init>", "(Lat/petrak/hexcasting/api/casting/eval/CastingEnvironment;)V", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nFabricShipAmbit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FabricShipAmbit.kt\norg/valkyrienskies/mod/fabric/compat/hexcasting/FabricShipAmbit\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,19:1\n1#2:20\n*E\n"})
public final class FabricShipAmbit
extends AmbitRemapping {
    public FabricShipAmbit(@NotNull CastingEnvironment env) {
        Intrinsics.checkNotNullParameter((Object)env, (String)"env");
        super(env);
    }

    @Override
    @Nullable
    public class_243 getCasterPosition() {
        class_243 class_2432 = super.getCasterPosition();
        if (class_2432 != null) {
            class_243 it = class_2432;
            boolean bl = false;
            return it;
        }
        if (FabricLoader.getInstance().isModLoaded("hextweaks") && (class_2432 = HexTweaksCompat.INSTANCE.getComputerPosition(this.getEnv())) != null) {
            class_243 it = class_2432;
            boolean bl = false;
            return it;
        }
        return null;
    }
}

