/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4608
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Matrix3f
 *  org.joml.Matrix4f
 *  org.joml.Vector2f
 */
package dev.mim1q.derelict.util.extensions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4608;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector2f;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u001aq\u0010\u0012\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001aw\u0010\u001d\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001e\u00a8\u0006\u001f"}, d2={"Lnet/minecraft/class_4588;", "Lorg/joml/Matrix4f;", "positionMatrix", "Lorg/joml/Matrix3f;", "normalMatrix", "", "light", "", "x", "y", "z", "textureU", "textureV", "red", "green", "blue", "alpha", "", "produceVertex", "(Lnet/minecraft/class_4588;Lorg/joml/Matrix4f;Lorg/joml/Matrix3f;IFFFFFIIII)V", "Lnet/minecraft/class_4587;", "matrices", "Lorg/joml/Vector2f;", "from", "to", "fromUv", "toUv", "", "doubleSided", "drawBillboard", "(Lnet/minecraft/class_4588;Lnet/minecraft/class_4587;ILorg/joml/Vector2f;Lorg/joml/Vector2f;Lorg/joml/Vector2f;Lorg/joml/Vector2f;IIIIZ)V", "derelict"})
public final class RenderExtensionsKt {
    public static final void produceVertex(@NotNull class_4588 $this$produceVertex, @NotNull Matrix4f positionMatrix, @NotNull Matrix3f normalMatrix, int light, float x, float y, float z, float textureU, float textureV, int red, int green, int blue, int alpha) {
        Intrinsics.checkNotNullParameter((Object)$this$produceVertex, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)positionMatrix, (String)"positionMatrix");
        Intrinsics.checkNotNullParameter((Object)normalMatrix, (String)"normalMatrix");
        $this$produceVertex.method_22918(positionMatrix, x, y, z).method_1336(red, green, blue, alpha).method_22913(textureU, textureV).method_22922(class_4608.field_21444).method_22916(light).method_23763(normalMatrix, 0.0f, -1.0f, 0.0f).method_1344();
    }

    public static final void drawBillboard(@NotNull class_4588 $this$drawBillboard, @NotNull class_4587 matrices, int light, @NotNull Vector2f from, @NotNull Vector2f to, @NotNull Vector2f fromUv, @NotNull Vector2f toUv, int red, int green, int blue, int alpha, boolean doubleSided) {
        Intrinsics.checkNotNullParameter((Object)$this$drawBillboard, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)matrices, (String)"matrices");
        Intrinsics.checkNotNullParameter((Object)from, (String)"from");
        Intrinsics.checkNotNullParameter((Object)to, (String)"to");
        Intrinsics.checkNotNullParameter((Object)fromUv, (String)"fromUv");
        Intrinsics.checkNotNullParameter((Object)toUv, (String)"toUv");
        Matrix4f posMatrix = matrices.method_23760().method_23761();
        Matrix3f normalMatrix = matrices.method_23760().method_23762();
        Intrinsics.checkNotNull((Object)posMatrix);
        Intrinsics.checkNotNull((Object)normalMatrix);
        RenderExtensionsKt.produceVertex($this$drawBillboard, posMatrix, normalMatrix, light, from.x, from.y, 0.0f, fromUv.x, fromUv.y, red, green, blue, alpha);
        RenderExtensionsKt.produceVertex($this$drawBillboard, posMatrix, normalMatrix, light, to.x, from.y, 0.0f, toUv.x, fromUv.y, red, green, blue, alpha);
        RenderExtensionsKt.produceVertex($this$drawBillboard, posMatrix, normalMatrix, light, to.x, to.y, 0.0f, toUv.x, toUv.y, red, green, blue, alpha);
        RenderExtensionsKt.produceVertex($this$drawBillboard, posMatrix, normalMatrix, light, from.x, to.y, 0.0f, fromUv.x, toUv.y, red, green, blue, alpha);
        if (doubleSided) {
            RenderExtensionsKt.produceVertex($this$drawBillboard, posMatrix, normalMatrix, light, to.x, from.y, 0.0f, toUv.x, fromUv.y, red, green, blue, alpha);
            RenderExtensionsKt.produceVertex($this$drawBillboard, posMatrix, normalMatrix, light, from.x, from.y, 0.0f, fromUv.x, fromUv.y, red, green, blue, alpha);
            RenderExtensionsKt.produceVertex($this$drawBillboard, posMatrix, normalMatrix, light, from.x, to.y, 0.0f, fromUv.x, toUv.y, red, green, blue, alpha);
            RenderExtensionsKt.produceVertex($this$drawBillboard, posMatrix, normalMatrix, light, to.x, to.y, 0.0f, toUv.x, toUv.y, red, green, blue, alpha);
        }
    }

    public static /* synthetic */ void drawBillboard$default(class_4588 class_45882, class_4587 class_45872, int n, Vector2f vector2f, Vector2f vector2f2, Vector2f vector2f3, Vector2f vector2f4, int n2, int n3, int n4, int n5, boolean bl, int n6, Object object) {
        if ((n6 & 0x10) != 0) {
            vector2f3 = new Vector2f(0.0f, 0.0f);
        }
        if ((n6 & 0x20) != 0) {
            vector2f4 = new Vector2f(1.0f, 1.0f);
        }
        if ((n6 & 0x40) != 0) {
            n2 = 255;
        }
        if ((n6 & 0x80) != 0) {
            n3 = 255;
        }
        if ((n6 & 0x100) != 0) {
            n4 = 255;
        }
        if ((n6 & 0x200) != 0) {
            n5 = 255;
        }
        if ((n6 & 0x400) != 0) {
            bl = true;
        }
        RenderExtensionsKt.drawBillboard(class_45882, class_45872, n, vector2f, vector2f2, vector2f3, vector2f4, n2, n3, n4, n5, bl);
    }
}

