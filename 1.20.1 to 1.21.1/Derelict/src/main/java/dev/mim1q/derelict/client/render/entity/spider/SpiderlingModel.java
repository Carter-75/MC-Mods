/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1921
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_583
 *  net.minecraft.class_630
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.client.render.entity.spider;

import dev.mim1q.derelict.client.render.entity.spider.SpiderRenderUtilsKt;
import dev.mim1q.derelict.entity.SpiderlingEntity;
import dev.mim1q.derelict.util.extensions.MathExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1921;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_583;
import net.minecraft.class_630;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006JO\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J?\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001eR\u001c\u0010 \u001a\n \u001f*\u0004\u0018\u00010\u00030\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u001c\u0010!\u001a\n \u001f*\u0004\u0018\u00010\u00030\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001eR\u001c\u0010\"\u001a\n \u001f*\u0004\u0018\u00010\u00030\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001eR\u001c\u0010#\u001a\n \u001f*\u0004\u0018\u00010\u00030\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\u001eR\u001c\u0010$\u001a\n \u001f*\u0004\u0018\u00010\u00030\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u001eR\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006("}, d2={"Ldev/mim1q/derelict/client/render/entity/spider/SpiderlingModel;", "Lnet/minecraft/class_583;", "Ldev/mim1q/derelict/entity/SpiderlingEntity;", "Lnet/minecraft/class_630;", "root", "<init>", "(Lnet/minecraft/class_630;)V", "Lnet/minecraft/class_4587;", "matrices", "Lnet/minecraft/class_4588;", "vertices", "", "light", "overlay", "", "red", "green", "blue", "alpha", "", "render", "(Lnet/minecraft/class_4587;Lnet/minecraft/class_4588;IIFFFF)V", "entity", "limbAngle", "limbDistance", "animationProgress", "headYaw", "headPitch", "setAngles", "(Ldev/mim1q/derelict/entity/SpiderlingEntity;FFFFF)V", "Lnet/minecraft/class_630;", "kotlin.jvm.PlatformType", "main", "rightLegs", "leftLegs", "neck", "head", "", "legs", "[Lnet/minecraft/class_630;", "derelict"})
public final class SpiderlingModel
extends class_583<SpiderlingEntity> {
    @NotNull
    private final class_630 root;
    private final class_630 main;
    private final class_630 rightLegs;
    private final class_630 leftLegs;
    private final class_630 neck;
    private final class_630 head;
    @NotNull
    private final class_630[] legs;

    public SpiderlingModel(@NotNull class_630 root) {
        Intrinsics.checkNotNullParameter((Object)root, (String)"root");
        super(class_1921::method_23576);
        this.root = root;
        this.main = this.root.method_32086("");
        this.rightLegs = this.main.method_32086("rightLegs");
        this.leftLegs = this.main.method_32086("leftLegs");
        this.neck = this.main.method_32086("neck");
        this.head = this.neck.method_32086("head");
        class_630[] class_630Array = new class_630[8];
        SpiderlingModel spiderlingModel = this;
        for (int i = 0; i < 8; ++i) {
            int n = i;
            String child = n < 4 ? "leftLeg" : "rightLeg";
            Intrinsics.checkNotNullExpressionValue((Object)this.main.method_32086(child + "s").method_32086(child + n % 4), (String)"getChild(...)");
        }
        spiderlingModel.legs = class_630Array;
    }

    public void method_2828(@NotNull class_4587 matrices, @NotNull class_4588 vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        Intrinsics.checkNotNullParameter((Object)matrices, (String)"matrices");
        Intrinsics.checkNotNullParameter((Object)vertices, (String)"vertices");
        this.root.method_22699(matrices, vertices, light, overlay, red, green, blue, alpha);
    }

    public void setAngles(@NotNull SpiderlingEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        this.root.field_3654 = 0.0f;
        this.main.field_3654 = entity.getAnchored().update(animationProgress) * MathExtensionsKt.radians(90.0f);
        this.leftLegs.field_3674 = MathExtensionsKt.radians(25.0f);
        this.rightLegs.field_3674 = MathExtensionsKt.radians(-25.0f);
        float progress = limbAngle * 1.0f;
        SpiderRenderUtilsKt.walkSpiderLegs(this.legs, progress, limbDistance);
        this.neck.field_3675 = 0.0f;
        this.head.field_3675 = 0.0f;
        this.head.field_3654 = 0.0f;
        this.neck.field_3654 = MathExtensionsKt.radians(headPitch) - entity.getAnchored().getValue() * MathExtensionsKt.radians(75.0f);
        if (entity.getAnchorPosition() == null) {
            this.head.field_3654 = MathExtensionsKt.radians(headPitch);
            this.neck.field_3654 = 0.0f;
        }
        this.head.field_3675 = MathExtensionsKt.radians(headYaw);
    }
}

