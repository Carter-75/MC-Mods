/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  net.minecraft.class_2960
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.client.render.effect;

import dev.mim1q.derelict.Derelict;
import kotlin.Metadata;
import net.minecraft.class_2960;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\t\"\u0017\u0010\u0001\u001a\u00020\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u00020\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0004\"\u0017\u0010\u0007\u001a\u00020\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\u0004\u00a8\u0006\t"}, d2={"Lnet/minecraft/class_2960;", "SPIDER_WEB_TEXTURE_SPARSE", "Lnet/minecraft/class_2960;", "getSPIDER_WEB_TEXTURE_SPARSE", "()Lnet/minecraft/class_2960;", "SPIDER_WEB_TEXTURE_MEDIUM", "getSPIDER_WEB_TEXTURE_MEDIUM", "SPIDER_WEB_TEXTURE_DENSE", "getSPIDER_WEB_TEXTURE_DENSE", "derelict"})
public final class SpiderWebModelFeatureKt {
    @NotNull
    private static final class_2960 SPIDER_WEB_TEXTURE_SPARSE = Derelict.INSTANCE.id("textures/entity/effect/spider_web_sparse.png");
    @NotNull
    private static final class_2960 SPIDER_WEB_TEXTURE_MEDIUM = Derelict.INSTANCE.id("textures/entity/effect/spider_web.png");
    @NotNull
    private static final class_2960 SPIDER_WEB_TEXTURE_DENSE = Derelict.INSTANCE.id("textures/entity/effect/spider_web_dense.png");

    @NotNull
    public static final class_2960 getSPIDER_WEB_TEXTURE_SPARSE() {
        return SPIDER_WEB_TEXTURE_SPARSE;
    }

    @NotNull
    public static final class_2960 getSPIDER_WEB_TEXTURE_MEDIUM() {
        return SPIDER_WEB_TEXTURE_MEDIUM;
    }

    @NotNull
    public static final class_2960 getSPIDER_WEB_TEXTURE_DENSE() {
        return SPIDER_WEB_TEXTURE_DENSE;
    }
}

