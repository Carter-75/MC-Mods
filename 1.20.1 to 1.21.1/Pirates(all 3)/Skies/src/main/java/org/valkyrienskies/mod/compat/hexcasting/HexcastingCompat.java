/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  at.petrak.hexcasting.api.casting.eval.CastingEnvironment
 *  at.petrak.hexcasting.api.casting.eval.CastingEnvironmentComponent
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2487
 */
package org.valkyrienskies.mod.compat.hexcasting;

import at.petrak.hexcasting.api.casting.eval.CastingEnvironment;
import at.petrak.hexcasting.api.casting.eval.CastingEnvironmentComponent;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2487;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.mod.compat.hexcasting.AmbitRemapping;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2={"Lorg/valkyrienskies/mod/compat/hexcasting/HexcastingCompat;", "", "Ljava/lang/Class;", "Lorg/valkyrienskies/mod/compat/hexcasting/AmbitRemapping;", "clazz", "", "register", "(Ljava/lang/Class;)V", "<init>", "()V", "valkyrienskies-120"})
public final class HexcastingCompat {
    @NotNull
    public static final HexcastingCompat INSTANCE = new HexcastingCompat();

    private HexcastingCompat() {
    }

    public final void register(@NotNull Class<? extends AmbitRemapping> clazz) {
        Intrinsics.checkNotNullParameter(clazz, (String)"clazz");
        CastingEnvironment.addCreateEventListener((arg_0, arg_1) -> HexcastingCompat.register$lambda$0(clazz, arg_0, arg_1));
    }

    private static final void register$lambda$0(Class $clazz, CastingEnvironment env, class_2487 class_24872) {
        Intrinsics.checkNotNullParameter((Object)$clazz, (String)"$clazz");
        Object[] objectArray = new Class[]{CastingEnvironment.class};
        Constructor constructor = $clazz.getConstructor((Class<?>[])objectArray);
        objectArray = new Object[]{env};
        Object t = constructor.newInstance(objectArray);
        Intrinsics.checkNotNull(t, (String)"null cannot be cast to non-null type org.valkyrienskies.mod.compat.hexcasting.AmbitRemapping");
        env.addExtension((CastingEnvironmentComponent)((AmbitRemapping)t));
    }
}

