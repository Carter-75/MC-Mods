/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1792
 *  net.minecraft.class_2960
 *  net.minecraft.class_5321
 *  net.minecraft.class_6862
 *  net.minecraft.class_7924
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.tag;

import dev.mim1q.derelict.Derelict;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1792;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_6862;
import net.minecraft.class_7924;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\r\u00a8\u0006\u0014"}, d2={"Ldev/mim1q/derelict/tag/ModItemTags;", "", "<init>", "()V", "", "id", "Lnet/minecraft/class_6862;", "Lnet/minecraft/class_1792;", "of", "(Ljava/lang/String;)Lnet/minecraft/class_6862;", "UNWAXED_METALS", "Lnet/minecraft/class_6862;", "getUNWAXED_METALS", "()Lnet/minecraft/class_6862;", "WAXED_METALS", "getWAXED_METALS", "GENERAL_TAB", "getGENERAL_TAB", "WAXED", "getWAXED", "derelict"})
public final class ModItemTags {
    @NotNull
    public static final ModItemTags INSTANCE = new ModItemTags();
    @NotNull
    private static final class_6862<class_1792> UNWAXED_METALS = INSTANCE.of("unwaxed_metals");
    @NotNull
    private static final class_6862<class_1792> WAXED_METALS = INSTANCE.of("waxed_metals");
    @NotNull
    private static final class_6862<class_1792> GENERAL_TAB = INSTANCE.of("general_tab");
    @NotNull
    private static final class_6862<class_1792> WAXED = INSTANCE.of("waxed");

    private ModItemTags() {
    }

    @NotNull
    public final class_6862<class_1792> getUNWAXED_METALS() {
        return UNWAXED_METALS;
    }

    @NotNull
    public final class_6862<class_1792> getWAXED_METALS() {
        return WAXED_METALS;
    }

    @NotNull
    public final class_6862<class_1792> getGENERAL_TAB() {
        return GENERAL_TAB;
    }

    @NotNull
    public final class_6862<class_1792> getWAXED() {
        return WAXED;
    }

    private final class_6862<class_1792> of(String id) {
        class_6862 class_68622 = class_6862.method_40092((class_5321)class_7924.field_41197, (class_2960)Derelict.INSTANCE.id(id));
        Intrinsics.checkNotNullExpressionValue((Object)class_68622, (String)"of(...)");
        return class_68622;
    }
}

