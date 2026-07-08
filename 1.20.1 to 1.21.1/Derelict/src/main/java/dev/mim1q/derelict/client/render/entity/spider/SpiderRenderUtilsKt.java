/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  net.minecraft.class_1297
 *  net.minecraft.class_1921
 *  net.minecraft.class_2960
 *  net.minecraft.class_3883
 *  net.minecraft.class_4606
 *  net.minecraft.class_583
 *  net.minecraft.class_630
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.client.render.entity.spider;

import dev.mim1q.derelict.util.extensions.MathExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.class_1297;
import net.minecraft.class_1921;
import net.minecraft.class_2960;
import net.minecraft.class_3883;
import net.minecraft.class_4606;
import net.minecraft.class_583;
import net.minecraft.class_630;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000B\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0007\u001a\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0007\u0010\b\u001aE\u0010\u000e\u001a\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001aO\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0018\"\b\b\u0000\u0010\u0011*\u00020\u0010\"\u000e\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u00028\u00000\u00122\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001b"}, d2={"", "Lnet/minecraft/class_630;", "legs", "", "progress", "limbDistance", "", "walkSpiderLegs", "([Lnet/minecraft/class_630;FF)V", "", "index", "defaultAngle", "offset", "multiplier", "walkSpiderLeg", "([Lnet/minecraft/class_630;IFFFF)V", "Lnet/minecraft/class_1297;", "T", "Lnet/minecraft/class_583;", "M", "Lnet/minecraft/class_3883;", "ctx", "Lnet/minecraft/class_2960;", "baseTexture", "Lnet/minecraft/class_4606;", "createEyesFeatureRenderer", "(Lnet/minecraft/class_3883;Lnet/minecraft/class_2960;)Lnet/minecraft/class_4606;", "derelict"})
public final class SpiderRenderUtilsKt {
    public static final void walkSpiderLegs(@NotNull class_630[] legs, float progress, float limbDistance) {
        Intrinsics.checkNotNullParameter((Object)legs, (String)"legs");
        SpiderRenderUtilsKt.walkSpiderLeg(legs, 0, 60.0f, progress, 0.0f, 0.4f * limbDistance);
        SpiderRenderUtilsKt.walkSpiderLeg(legs, 1, 25.0f, progress, 90.0f, 0.4f * limbDistance);
        SpiderRenderUtilsKt.walkSpiderLeg(legs, 2, -15.0f, progress, 15.0f, 0.5f * limbDistance);
        SpiderRenderUtilsKt.walkSpiderLeg(legs, 3, -45.0f, progress, 105.0f, 0.6f * limbDistance);
        SpiderRenderUtilsKt.walkSpiderLeg(legs, 4, -60.0f, progress, 10.0f, 0.4f * limbDistance);
        SpiderRenderUtilsKt.walkSpiderLeg(legs, 5, -25.0f, progress, 100.0f, 0.4f * limbDistance);
        SpiderRenderUtilsKt.walkSpiderLeg(legs, 6, 15.0f, progress, 25.0f, 0.5f * limbDistance);
        SpiderRenderUtilsKt.walkSpiderLeg(legs, 7, 45.0f, progress, 115.0f, 0.6f * limbDistance);
    }

    private static final void walkSpiderLeg(class_630[] legs, int index, float defaultAngle, float progress, float offset, float multiplier) {
        class_630 leg = legs[index];
        int legMultiplier = index < 4 ? -1 : 1;
        leg.field_3675 = MathExtensionsKt.radians(defaultAngle) + (float)Math.sin(progress + MathExtensionsKt.radians(offset)) * multiplier;
        leg.field_3674 = Math.max(0.0f, (float)Math.cos(progress + MathExtensionsKt.radians(offset - 35.0f)) * multiplier);
        leg.field_3674 *= (float)legMultiplier;
        leg.field_3675 -= MathExtensionsKt.radians(defaultAngle) * 0.3f;
        leg.field_3674 -= Math.abs(MathExtensionsKt.radians(defaultAngle)) * (float)legMultiplier * 0.3f;
    }

    @NotNull
    public static final <T extends class_1297, M extends class_583<T>> class_4606<T, M> createEyesFeatureRenderer(@NotNull class_3883<T, M> ctx, @NotNull class_2960 baseTexture) {
        Intrinsics.checkNotNullParameter(ctx, (String)"ctx");
        Intrinsics.checkNotNullParameter((Object)baseTexture, (String)"baseTexture");
        return new class_4606<T, M>(baseTexture, ctx){
            private final class_2960 texture;
            {
                String string = $baseTexture.method_12836();
                String string2 = $baseTexture.method_12832();
                Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getPath(...)");
                this.texture = new class_2960(string, StringsKt.replace$default((String)string2, (String)".png", (String)"_eyes.png", (boolean)false, (int)4, null));
            }

            public final class_2960 getTexture() {
                return this.texture;
            }

            public class_1921 method_23193() {
                class_1921 class_19212 = class_1921.method_23026((class_2960)this.texture);
                Intrinsics.checkNotNullExpressionValue((Object)class_19212, (String)"getEyes(...)");
                return class_19212;
            }
        };
    }
}

