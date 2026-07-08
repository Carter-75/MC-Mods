/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2248
 *  net.minecraft.class_2960
 *  net.minecraft.class_5321
 *  net.minecraft.class_6862
 *  net.minecraft.class_7924
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.tag;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2248;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_6862;
import net.minecraft.class_7924;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u0010"}, d2={"Ldev/mim1q/derelict/tag/ModBlockTags;", "", "<init>", "()V", "", "id", "Lnet/minecraft/class_6862;", "Lnet/minecraft/class_2248;", "of", "(Ljava/lang/String;)Lnet/minecraft/class_6862;", "COBWEBS", "Lnet/minecraft/class_6862;", "getCOBWEBS", "()Lnet/minecraft/class_6862;", "FULL_COBWEBS", "getFULL_COBWEBS", "derelict"})
public final class ModBlockTags {
    @NotNull
    public static final ModBlockTags INSTANCE = new ModBlockTags();
    @NotNull
    private static final class_6862<class_2248> COBWEBS = INSTANCE.of("cobwebs");
    @NotNull
    private static final class_6862<class_2248> FULL_COBWEBS = INSTANCE.of("full_cobwebs");

    private ModBlockTags() {
    }

    @NotNull
    public final class_6862<class_2248> getCOBWEBS() {
        return COBWEBS;
    }

    @NotNull
    public final class_6862<class_2248> getFULL_COBWEBS() {
        return FULL_COBWEBS;
    }

    private final class_6862<class_2248> of(String id) {
        class_6862 class_68622 = class_6862.method_40092((class_5321)class_7924.field_41254, (class_2960)new class_2960("derelict", id));
        Intrinsics.checkNotNullExpressionValue((Object)class_68622, (String)"of(...)");
        return class_68622;
    }
}

