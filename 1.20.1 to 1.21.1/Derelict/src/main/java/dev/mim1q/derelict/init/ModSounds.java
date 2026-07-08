/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2378
 *  net.minecraft.class_2960
 *  net.minecraft.class_3414
 *  net.minecraft.class_7923
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.init;

import dev.mim1q.derelict.Derelict;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_3414;
import net.minecraft.class_7923;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0003J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2={"Ldev/mim1q/derelict/init/ModSounds;", "", "<init>", "()V", "", "init", "", "name", "Lnet/minecraft/class_3414;", "register", "(Ljava/lang/String;)Lnet/minecraft/class_3414;", "SPIDER_CAVES_AMBIENT", "Lnet/minecraft/class_3414;", "getSPIDER_CAVES_AMBIENT", "()Lnet/minecraft/class_3414;", "derelict"})
public final class ModSounds {
    @NotNull
    public static final ModSounds INSTANCE = new ModSounds();
    @NotNull
    private static final class_3414 SPIDER_CAVES_AMBIENT = INSTANCE.register("ambient.spider_caves");

    private ModSounds() {
    }

    @NotNull
    public final class_3414 getSPIDER_CAVES_AMBIENT() {
        return SPIDER_CAVES_AMBIENT;
    }

    public final void init() {
    }

    @NotNull
    public final class_3414 register(@NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Object object = class_2378.method_10230((class_2378)class_7923.field_41172, (class_2960)Derelict.INSTANCE.id(name), (Object)class_3414.method_47908((class_2960)Derelict.INSTANCE.id(name)));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"register(...)");
        return (class_3414)object;
    }
}

