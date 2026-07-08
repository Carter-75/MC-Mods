/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_5603
 *  net.minecraft.class_5606
 *  net.minecraft.class_5607
 *  net.minecraft.class_5609
 *  net.minecraft.class_5610
 *  net.minecraft.class_583
 *  net.minecraft.class_630
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.client.render.entity.spider;

import dev.mim1q.derelict.client.render.entity.spider.JumpingSpiderEntityModel;
import dev.mim1q.derelict.client.render.entity.spider.SpiderRenderUtilsKt;
import dev.mim1q.derelict.entity.spider.JumpingSpiderEntity;
import dev.mim1q.derelict.util.extensions.MathExtensionsKt;
import dev.mim1q.derelict.util.extensions.ModelExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_5603;
import net.minecraft.class_5606;
import net.minecraft.class_5607;
import net.minecraft.class_5609;
import net.minecraft.class_5610;
import net.minecraft.class_583;
import net.minecraft.class_630;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u0011\n\u0002\b\u0004\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006JO\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J?\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\n \u001e*\u0004\u0018\u00010\u00030\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010 R\u0014\u0010\"\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u001c\u0010#\u001a\n \u001e*\u0004\u0018\u00010\u00030\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010 R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006("}, d2={"Ldev/mim1q/derelict/client/render/entity/spider/JumpingSpiderEntityModel;", "Lnet/minecraft/class_583;", "Ldev/mim1q/derelict/entity/spider/JumpingSpiderEntity;", "Lnet/minecraft/class_630;", "bone", "<init>", "(Lnet/minecraft/class_630;)V", "Lnet/minecraft/class_4587;", "matrices", "Lnet/minecraft/class_4588;", "vertices", "", "light", "overlay", "", "red", "green", "blue", "alpha", "", "render", "(Lnet/minecraft/class_4587;Lnet/minecraft/class_4588;IIFFFF)V", "entity", "limbAngle", "limbDistance", "animationProgress", "headYaw", "headPitch", "setAngles", "(Ldev/mim1q/derelict/entity/spider/JumpingSpiderEntity;FFFFF)V", "kotlin.jvm.PlatformType", "root", "Lnet/minecraft/class_630;", "leftLegs", "rightLegs", "head", "", "allLegs", "[Lnet/minecraft/class_630;", "Companion", "derelict"})
@SourceDebugExtension(value={"SMAP\nJumpingSpiderEntityRenderer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JumpingSpiderEntityRenderer.kt\ndev/mim1q/derelict/client/render/entity/spider/JumpingSpiderEntityModel\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,116:1\n13411#2,3:117\n*S KotlinDebug\n*F\n+ 1 JumpingSpiderEntityRenderer.kt\ndev/mim1q/derelict/client/render/entity/spider/JumpingSpiderEntityModel\n*L\n78#1:117,3\n*E\n"})
public final class JumpingSpiderEntityModel
extends class_583<JumpingSpiderEntity> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final class_630 root;
    @NotNull
    private final class_630 leftLegs;
    @NotNull
    private final class_630 rightLegs;
    private final class_630 head;
    @NotNull
    private final class_630[] allLegs;

    public JumpingSpiderEntityModel(@NotNull class_630 bone) {
        Intrinsics.checkNotNullParameter((Object)bone, (String)"bone");
        this.root = bone.method_32086("root");
        class_630 class_6302 = this.root.method_32086("left_legs");
        Intrinsics.checkNotNullExpressionValue((Object)class_6302, (String)"getChild(...)");
        this.leftLegs = class_6302;
        class_630 class_6303 = this.root.method_32086("right_legs");
        Intrinsics.checkNotNullExpressionValue((Object)class_6303, (String)"getChild(...)");
        this.rightLegs = class_6303;
        this.head = this.root.method_32086("head");
        class_630[] class_630Array = new class_630[8];
        JumpingSpiderEntityModel jumpingSpiderEntityModel = this;
        for (int i = 0; i < 8; ++i) {
            int n = i;
            String child = n < 4 ? "left_leg" : "right_leg";
            Intrinsics.checkNotNullExpressionValue((Object)this.root.method_32086(child + "s").method_32086(child + n % 4), (String)"getChild(...)");
        }
        jumpingSpiderEntityModel.allLegs = class_630Array;
    }

    public void method_2828(@NotNull class_4587 matrices, @NotNull class_4588 vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        Intrinsics.checkNotNullParameter((Object)matrices, (String)"matrices");
        Intrinsics.checkNotNullParameter((Object)vertices, (String)"vertices");
        this.root.method_22698(matrices, vertices, light, overlay);
    }

    /*
     * WARNING - void declaration
     */
    public void setAngles(@NotNull JumpingSpiderEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        this.root.method_32088().forEach(arg_0 -> JumpingSpiderEntityModel.setAngles$lambda$0(setAngles.1.INSTANCE, arg_0));
        this.leftLegs.field_3674 = MathExtensionsKt.radians(25.0f);
        this.rightLegs.field_3674 = MathExtensionsKt.radians(-25.0f);
        SpiderRenderUtilsKt.walkSpiderLegs(this.allLegs, animationProgress, limbDistance);
        float jumpCharge = entity.getJumpChargeAnimation().update(animationProgress);
        if (jumpCharge > 1.0E-5f) {
            class_630[] $this$forEachIndexed$iv = this.allLegs;
            boolean $i$f$forEachIndexed = false;
            int index$iv = 0;
            for (class_630 item$iv : $this$forEachIndexed$iv) {
                void it;
                int n = index$iv++;
                class_630 class_6302 = item$iv;
                int index = n;
                boolean bl = false;
                int multiplier = index < 4 ? 1 : -1;
                int i = index % 4;
                ModelExtensionsKt.setPartialAnglesDegrees((class_630)it, 0.0f, (5.0f - (float)i * 5.0f) * (float)multiplier, (60.0f - 10.0f * (float)i) * (float)multiplier, jumpCharge);
            }
            class_630 class_6303 = this.root;
            class_6303.field_3656 += 4.0f * jumpCharge;
            class_6303 = this.root;
            class_6303.field_3655 += 8.0f * jumpCharge;
        }
        this.head.field_3654 = MathExtensionsKt.radians(headPitch);
        this.head.field_3675 = MathExtensionsKt.radians(headYaw);
    }

    private static final void setAngles$lambda$0(Function1 $tmp0, Object p0) {
        Intrinsics.checkNotNullParameter((Object)$tmp0, (String)"$tmp0");
        $tmp0.invoke(p0);
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Ldev/mim1q/derelict/client/render/entity/spider/JumpingSpiderEntityModel$Companion;", "", "<init>", "()V", "Lnet/minecraft/class_5607;", "createTexturedModelData", "()Lnet/minecraft/class_5607;", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final class_5607 createTexturedModelData() {
            class_5610 class_56102;
            class_5610 class_56103;
            class_5610 class_56104;
            class_5609 it = new class_5609();
            boolean bl = false;
            class_5610 $this$createTexturedModelData_u24lambda_u244_u24lambda_u243 = class_56104 = it.method_32111();
            boolean bl2 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u244_u24lambda_u243_u24lambda_u242 = class_56103 = $this$createTexturedModelData_u24lambda_u244_u24lambda_u243.method_32117("root", class_5606.method_32108().method_32101(30, 32).method_32097(-3.0f, -2.0f, 0.0f, 6.0f, 4.0f, 6.0f).method_32101(0, 0).method_32097(-5.0f, -3.0f, 6.0f, 10.0f, 6.0f, 10.0f).method_32101(0, 43).method_32097(0.0f, -5.0f, 7.0f, 0.0f, 2.0f, 10.0f), class_5603.method_32090((float)0.0f, (float)15.0f, (float)-3.0f));
            boolean bl3 = false;
            $this$createTexturedModelData_u24lambda_u244_u24lambda_u243_u24lambda_u242.method_32117("body_r1", class_5606.method_32108().method_32101(0, 43).method_32097(0.0f, 0.0f, -5.0f, 0.0f, 1.0f, 10.0f), class_5603.method_32091((float)-3.5f, (float)-4.0f, (float)11.0f, (float)0.0f, (float)-0.2618f, (float)0.0f));
            $this$createTexturedModelData_u24lambda_u244_u24lambda_u243_u24lambda_u242.method_32117("body_r2", class_5606.method_32108().method_32101(0, 43).method_32097(0.0f, 0.0f, -5.0f, 0.0f, 1.0f, 10.0f), class_5603.method_32091((float)3.5f, (float)-4.0f, (float)11.0f, (float)0.0f, (float)0.2618f, (float)0.0f));
            $this$createTexturedModelData_u24lambda_u244_u24lambda_u243_u24lambda_u242.method_32117("head", class_5606.method_32108().method_32101(0, 16).method_32097(-4.0f, -3.0f, -8.0f, 8.0f, 6.0f, 8.0f).method_32101(0, 42).method_32097(-3.0f, -4.0f, -8.0f, 0.0f, 1.0f, 8.0f).method_32101(0, 42).method_32097(0.0f, -5.0f, -9.0f, 0.0f, 2.0f, 8.0f).method_32101(0, 42).method_32097(3.0f, -4.0f, -8.0f, 0.0f, 1.0f, 8.0f).method_32101(0, 0).method_32097(0.5f, 3.0f, -7.5f, 3.0f, 4.0f, 2.0f).method_32101(0, 38).method_32097(-3.5f, 3.0f, -7.5f, 3.0f, 4.0f, 2.0f), class_5603.method_32090((float)0.0f, (float)-1.0f, (float)0.0f));
            class_5610 $this$createTexturedModelData_u24lambda_u244_u24lambda_u243_u24lambda_u242_u24lambda_u240 = class_56102 = $this$createTexturedModelData_u24lambda_u244_u24lambda_u243_u24lambda_u242.method_32117("left_legs", class_5606.method_32108(), class_5603.method_32090((float)4.0f, (float)0.0f, (float)2.5f));
            boolean bl4 = false;
            $this$createTexturedModelData_u24lambda_u244_u24lambda_u243_u24lambda_u242_u24lambda_u240.method_32117("left_leg0", class_5606.method_32108().method_32101(34, 28).method_32097(0.0f, -1.0f, -1.0f, 16.0f, 2.0f, 2.0f), class_5603.method_32090((float)-1.0f, (float)0.0f, (float)-2.5f));
            $this$createTexturedModelData_u24lambda_u244_u24lambda_u243_u24lambda_u242_u24lambda_u240.method_32117("left_leg1", class_5606.method_32108().method_32101(0, 34).method_32097(0.0f, -1.0f, -1.0f, 16.0f, 2.0f, 2.0f), class_5603.method_32090((float)-1.0f, (float)0.0f, (float)-0.5f));
            $this$createTexturedModelData_u24lambda_u244_u24lambda_u243_u24lambda_u242_u24lambda_u240.method_32117("left_leg2", class_5606.method_32108().method_32101(32, 24).method_32097(0.0f, -1.0f, -1.0f, 16.0f, 2.0f, 2.0f), class_5603.method_32090((float)-1.0f, (float)0.0f, (float)1.5f));
            $this$createTexturedModelData_u24lambda_u244_u24lambda_u243_u24lambda_u242_u24lambda_u240.method_32117("left_leg3", class_5606.method_32108().method_32101(30, 4).method_32097(0.0f, -1.0f, -1.0f, 16.0f, 2.0f, 2.0f), class_5603.method_32090((float)-1.0f, (float)0.0f, (float)3.5f));
            class_5610 $this$createTexturedModelData_u24lambda_u244_u24lambda_u243_u24lambda_u242_u24lambda_u241 = class_56102 = $this$createTexturedModelData_u24lambda_u244_u24lambda_u243_u24lambda_u242.method_32117("right_legs", class_5606.method_32108(), class_5603.method_32090((float)-4.0f, (float)0.0f, (float)2.5f));
            boolean bl5 = false;
            $this$createTexturedModelData_u24lambda_u244_u24lambda_u243_u24lambda_u242_u24lambda_u241.method_32117("right_leg0", class_5606.method_32108().method_32101(30, 0).method_32097(-16.0f, -1.0f, -1.0f, 16.0f, 2.0f, 2.0f), class_5603.method_32090((float)1.0f, (float)0.0f, (float)-2.5f));
            $this$createTexturedModelData_u24lambda_u244_u24lambda_u243_u24lambda_u242_u24lambda_u241.method_32117("right_leg1", class_5606.method_32108().method_32101(0, 30).method_32097(-16.0f, -1.0f, -1.0f, 16.0f, 2.0f, 2.0f), class_5603.method_32090((float)1.0f, (float)0.0f, (float)-0.5f));
            $this$createTexturedModelData_u24lambda_u244_u24lambda_u243_u24lambda_u242_u24lambda_u241.method_32117("right_leg2", class_5606.method_32108().method_32101(24, 20).method_32097(-16.0f, -1.0f, -1.0f, 16.0f, 2.0f, 2.0f), class_5603.method_32090((float)1.0f, (float)0.0f, (float)1.5f));
            $this$createTexturedModelData_u24lambda_u244_u24lambda_u243_u24lambda_u242_u24lambda_u241.method_32117("right_leg3", class_5606.method_32108().method_32101(24, 16).method_32097(-16.0f, -1.0f, -1.0f, 16.0f, 2.0f, 2.0f), class_5603.method_32090((float)1.0f, (float)0.0f, (float)3.5f));
            class_5607 class_56072 = class_5607.method_32110((class_5609)it, (int)128, (int)128);
            Intrinsics.checkNotNullExpressionValue((Object)class_56072, (String)"let(...)");
            return class_56072;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

