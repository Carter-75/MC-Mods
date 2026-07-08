/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.mim1q.gimm1q.interpolation.Easing
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1297
 *  net.minecraft.class_1921
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

import dev.mim1q.derelict.client.render.entity.spider.WebCasterEntityModel;
import dev.mim1q.derelict.entity.spider.WebCasterEntity;
import dev.mim1q.derelict.entity.spider.legs.SpiderLegParts;
import dev.mim1q.derelict.util.extensions.MathExtensionsKt;
import dev.mim1q.derelict.util.extensions.ModelExtensionsKt;
import dev.mim1q.gimm1q.interpolation.Easing;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1297;
import net.minecraft.class_1921;
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

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006JO\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J?\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ/\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\n !*\u0004\u0018\u00010\u00030\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010$\u001a\n !*\u0004\u0018\u00010\u00030\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010#R\u001c\u0010%\u001a\n !*\u0004\u0018\u00010\u00030\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u001c\u0010&\u001a\n !*\u0004\u0018\u00010\u00030\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010#R\u001c\u0010'\u001a\n !*\u0004\u0018\u00010\u00030\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010#R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u0006-"}, d2={"Ldev/mim1q/derelict/client/render/entity/spider/WebCasterEntityModel;", "Lnet/minecraft/class_583;", "Ldev/mim1q/derelict/entity/spider/WebCasterEntity;", "Lnet/minecraft/class_630;", "part", "<init>", "(Lnet/minecraft/class_630;)V", "Lnet/minecraft/class_4587;", "matrices", "Lnet/minecraft/class_4588;", "vertices", "", "light", "overlay", "", "red", "green", "blue", "alpha", "", "render", "(Lnet/minecraft/class_4587;Lnet/minecraft/class_4588;IIFFFF)V", "entity", "limbAngle", "limbDistance", "animationProgress", "headYaw", "headPitch", "setAngles", "(Ldev/mim1q/derelict/entity/spider/WebCasterEntity;FFFFF)V", "tickDelta", "animateModel", "(Ldev/mim1q/derelict/entity/spider/WebCasterEntity;FFF)V", "kotlin.jvm.PlatformType", "root", "Lnet/minecraft/class_630;", "web", "torso", "head", "back", "", "Ldev/mim1q/derelict/entity/spider/legs/SpiderLegParts;", "legs", "[Ldev/mim1q/derelict/entity/spider/legs/SpiderLegParts;", "Companion", "derelict"})
@SourceDebugExtension(value={"SMAP\nWebCasterEntityRenderer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebCasterEntityRenderer.kt\ndev/mim1q/derelict/client/render/entity/spider/WebCasterEntityModel\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,166:1\n13411#2,3:167\n*S KotlinDebug\n*F\n+ 1 WebCasterEntityRenderer.kt\ndev/mim1q/derelict/client/render/entity/spider/WebCasterEntityModel\n*L\n100#1:167,3\n*E\n"})
public final class WebCasterEntityModel
extends class_583<WebCasterEntity> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final class_630 root;
    private final class_630 web;
    private final class_630 torso;
    private final class_630 head;
    private final class_630 back;
    @NotNull
    private final SpiderLegParts[] legs;

    public WebCasterEntityModel(@NotNull class_630 part) {
        Intrinsics.checkNotNullParameter((Object)part, (String)"part");
        super(class_1921::method_23576);
        this.root = part.method_32086("root");
        this.web = this.root.method_32086("web");
        this.torso = this.root.method_32086("torso");
        this.head = this.torso.method_32086("head");
        this.back = this.torso.method_32086("back");
        class_630 class_6302 = this.torso;
        Intrinsics.checkNotNullExpressionValue((Object)class_6302, (String)"torso");
        this.legs = SpiderLegParts.Companion.createArray(class_6302);
    }

    public void method_2828(@NotNull class_4587 matrices, @NotNull class_4588 vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        Intrinsics.checkNotNullParameter((Object)matrices, (String)"matrices");
        Intrinsics.checkNotNullParameter((Object)vertices, (String)"vertices");
        this.root.method_22699(matrices, vertices, light, overlay, red, green, blue, alpha);
    }

    public void setAngles(@NotNull WebCasterEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        float webHold;
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        this.head.field_3675 = MathExtensionsKt.radians(headYaw);
        this.head.field_3654 = MathExtensionsKt.radians(headPitch);
        this.web.field_37938 = webHold = entity.getWebHeldAnimation().update(animationProgress);
        this.web.field_37939 = webHold;
        ModelExtensionsKt.setPartialAnglesDegrees(this.legs[0].getJoint(), 0.0f, 0.0f, 75.0f, webHold);
        ModelExtensionsKt.setPartialAnglesDegrees(this.legs[0].getUpper(), 0.0f, -40.0f, 0.0f, webHold);
        ModelExtensionsKt.setPartialAnglesDegrees(this.legs[0].getLower(), 0.0f, 40.0f, 0.0f, webHold);
        ModelExtensionsKt.setPartialAnglesDegrees(this.legs[4].getJoint(), 0.0f, 0.0f, -75.0f, webHold);
        ModelExtensionsKt.setPartialAnglesDegrees(this.legs[4].getUpper(), 0.0f, 40.0f, 0.0f, webHold);
        ModelExtensionsKt.setPartialAnglesDegrees(this.legs[4].getLower(), 0.0f, -40.0f, 0.0f, webHold);
        ModelExtensionsKt.setPartialAnglesDegrees(this.legs[1].getJoint(), 0.0f, 0.0f, 76.0f, webHold);
        ModelExtensionsKt.setPartialAnglesDegrees(this.legs[1].getUpper(), 0.0f, 15.0f, 0.0f, webHold);
        ModelExtensionsKt.setPartialAnglesDegrees(this.legs[1].getLower(), 0.0f, -16.0f, 0.0f, webHold);
        ModelExtensionsKt.setPartialAnglesDegrees(this.legs[5].getJoint(), 0.0f, 0.0f, -76.0f, webHold);
        ModelExtensionsKt.setPartialAnglesDegrees(this.legs[5].getUpper(), 0.0f, -15.0f, 0.0f, webHold);
        ModelExtensionsKt.setPartialAnglesDegrees(this.legs[5].getLower(), 0.0f, 16.0f, 0.0f, webHold);
        class_630 class_6302 = this.web;
        class_6302.field_3655 -= 20.0f * webHold;
        class_6302 = this.web;
        class_6302.field_3654 -= MathExtensionsKt.radians(10.0f) * webHold;
    }

    /*
     * WARNING - void declaration
     */
    public void animateModel(@NotNull WebCasterEntity entity, float limbAngle, float limbDistance, float tickDelta) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        super.method_2816((class_1297)entity, limbAngle, limbDistance, tickDelta);
        this.root.method_32088().forEach(arg_0 -> WebCasterEntityModel.animateModel$lambda$0(animateModel.1.INSTANCE, arg_0));
        SpiderLegParts[] $this$forEachIndexed$iv = this.legs;
        boolean $i$f$forEachIndexed = false;
        int index$iv = 0;
        for (SpiderLegParts item$iv : $this$forEachIndexed$iv) {
            void it;
            int n = index$iv++;
            SpiderLegParts spiderLegParts = item$iv;
            int index = n;
            boolean bl = false;
            it.applyIk(entity.getLegController().getIk(index), Easing.lerp((float)entity.field_6220, (float)entity.field_6283, (float)tickDelta), tickDelta);
        }
    }

    private static final void animateModel$lambda$0(Function1 $tmp0, Object p0) {
        Intrinsics.checkNotNullParameter((Object)$tmp0, (String)"$tmp0");
        $tmp0.invoke(p0);
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Ldev/mim1q/derelict/client/render/entity/spider/WebCasterEntityModel$Companion;", "", "<init>", "()V", "Lnet/minecraft/class_5607;", "createTexturedModelData", "()Lnet/minecraft/class_5607;", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final class_5607 createTexturedModelData() {
            class_5610 class_56102;
            class_5610 class_56103;
            class_5610 class_56104;
            class_5610 class_56105;
            class_5610 class_56106;
            class_5609 it = new class_5609();
            boolean bl = false;
            class_5610 $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421 = class_56106 = it.method_32111();
            boolean bl2 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420 = class_56105 = $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421.method_32117("root", class_5606.method_32108(), class_5603.method_32090((float)0.0f, (float)24.0f, (float)0.0f));
            boolean bl3 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419 = class_56104 = $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420.method_32117("torso", class_5606.method_32108().method_32101(44, 52).method_32097(-4.0f, -3.0f, -4.0f, 8.0f, 6.0f, 8.0f), class_5603.method_32090((float)0.0f, (float)-8.0f, (float)-4.0f));
            boolean bl4 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u242 = class_56103 = $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419.method_32117("head", class_5606.method_32108().method_32101(0, 54).method_32097(-3.5f, -2.5f, -8.0f, 7.0f, 5.0f, 8.0f).method_32101(0, 7).method_32097(-4.5f, -3.0f, -8.5f, 4.0f, 4.0f, 3.0f).method_32101(0, 0).method_32097(0.5f, -3.0f, -8.5f, 4.0f, 4.0f, 3.0f), class_5603.method_32090((float)0.0f, (float)-1.5f, (float)-4.0f));
            boolean bl5 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u242_u24lambda_u240 = class_56102 = $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u242.method_32117("right_fang", class_5606.method_32108(), class_5603.method_32090((float)-2.0f, (float)2.5f, (float)-6.0f));
            boolean bl6 = false;
            $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u242_u24lambda_u240.method_32117("cube_r1", class_5606.method_32108().method_32101(60, 24).method_32097(-1.0f, -3.5f, -1.5f, 2.0f, 6.0f, 3.0f), class_5603.method_32091((float)0.0f, (float)3.5f, (float)0.0f, (float)0.0f, (float)0.7854f, (float)0.0f));
            class_5610 $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u242_u24lambda_u241 = class_56102 = $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u242.method_32117("left_fang", class_5606.method_32108(), class_5603.method_32090((float)2.0f, (float)2.5f, (float)-6.0f));
            boolean bl7 = false;
            $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u242_u24lambda_u241.method_32117("cube_r2", class_5606.method_32108().method_32101(30, 54).method_32097(-1.0f, -3.5f, -1.5f, 2.0f, 6.0f, 3.0f), class_5603.method_32091((float)0.0f, (float)3.5f, (float)0.0f, (float)0.0f, (float)-0.7854f, (float)0.0f));
            $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419.method_32117("back", class_5606.method_32108().method_32101(0, 0).method_32097(-3.0f, -3.0f, 0.0f, 6.0f, 6.0f, 20.0f), class_5603.method_32090((float)0.0f, (float)0.0f, (float)4.0f));
            class_5610 $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u244 = class_56103 = $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419.method_32117("left_leg_joint0", class_5606.method_32108(), class_5603.method_32090((float)4.0f, (float)0.0f, (float)-3.0f));
            boolean bl8 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u244_u24lambda_u243 = class_56102 = $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u244.method_32117("left_leg0", class_5606.method_32108().method_32101(52, 20).method_32097(0.0f, -1.0f, -1.0f, 24.0f, 2.0f, 2.0f).method_32101(0, 14).method_32097(23.5f, -1.5f, -1.5f, 3.0f, 3.0f, 3.0f), class_5603.field_27701);
            boolean bl9 = false;
            $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u244_u24lambda_u243.method_32117("left_leg_front0", class_5606.method_32108().method_32101(0, 34).method_32097(-1.0f, -1.0f, -1.0f, 28.0f, 2.0f, 2.0f), class_5603.method_32090((float)25.0f, (float)0.0f, (float)0.0f));
            class_5610 $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u246 = class_56103 = $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419.method_32117("left_leg_joint1", class_5606.method_32108(), class_5603.method_32090((float)4.0f, (float)0.0f, (float)-1.0f));
            boolean bl10 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u246_u24lambda_u245 = class_56102 = $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u246.method_32117("left_leg1", class_5606.method_32108().method_32101(50, 48).method_32097(0.0f, -1.0f, -1.0f, 24.0f, 2.0f, 2.0f).method_32101(0, 14).method_32097(23.5f, -1.5f, -1.5f, 3.0f, 3.0f, 3.0f), class_5603.field_27701);
            boolean bl11 = false;
            $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u246_u24lambda_u245.method_32117("left_leg_front1", class_5606.method_32108().method_32101(32, 16).method_32097(-1.0f, -1.0f, -1.0f, 28.0f, 2.0f, 2.0f), class_5603.method_32090((float)25.0f, (float)0.0f, (float)0.0f));
            class_5610 $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u248 = class_56103 = $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419.method_32117("left_leg_joint2", class_5606.method_32108(), class_5603.method_32090((float)4.0f, (float)0.0f, (float)1.0f));
            boolean bl12 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u248_u24lambda_u247 = class_56102 = $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u248.method_32117("left_leg2", class_5606.method_32108().method_32101(50, 44).method_32097(0.0f, -1.0f, -1.0f, 24.0f, 2.0f, 2.0f).method_32101(0, 14).method_32097(23.5f, -1.5f, -1.5f, 3.0f, 3.0f, 3.0f), class_5603.field_27701);
            boolean bl13 = false;
            $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u248_u24lambda_u247.method_32117("left_leg_front2", class_5606.method_32108().method_32101(32, 12).method_32097(-1.0f, -1.0f, -1.0f, 28.0f, 2.0f, 2.0f), class_5603.method_32090((float)25.0f, (float)0.0f, (float)0.0f));
            class_5610 $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u2410 = class_56103 = $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419.method_32117("left_leg_joint3", class_5606.method_32108(), class_5603.method_32090((float)4.0f, (float)0.0f, (float)3.0f));
            boolean bl14 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u2410_u24lambda_u249 = class_56102 = $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u2410.method_32117("left_leg3", class_5606.method_32108().method_32101(50, 40).method_32097(0.0f, -1.0f, -1.0f, 24.0f, 2.0f, 2.0f).method_32101(0, 14).method_32097(23.5f, -1.5f, -1.5f, 3.0f, 3.0f, 3.0f), class_5603.field_27701);
            boolean bl15 = false;
            $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u2410_u24lambda_u249.method_32117("left_leg_front3", class_5606.method_32108().method_32101(32, 8).method_32097(-1.0f, -1.0f, -1.0f, 28.0f, 2.0f, 2.0f), class_5603.method_32090((float)25.0f, (float)0.0f, (float)0.0f));
            class_5610 $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u2412 = class_56103 = $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419.method_32117("right_leg_joint0", class_5606.method_32108(), class_5603.method_32090((float)-4.0f, (float)0.0f, (float)-3.0f));
            boolean bl16 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u2412_u24lambda_u2411 = class_56102 = $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u2412.method_32117("right_leg0", class_5606.method_32108().method_32101(0, 50).method_32097(-24.0f, -1.0f, -1.0f, 24.0f, 2.0f, 2.0f).method_32101(0, 14).method_32096().method_32097(-26.5f, -1.5f, -1.5f, 3.0f, 3.0f, 3.0f), class_5603.field_27701);
            boolean bl17 = false;
            $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u2412_u24lambda_u2411.method_32117("right_leg_front0", class_5606.method_32108().method_32101(32, 4).method_32097(-27.0f, -1.0f, -1.0f, 28.0f, 2.0f, 2.0f), class_5603.method_32090((float)-25.0f, (float)0.0f, (float)0.0f));
            class_5610 $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u2414 = class_56103 = $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419.method_32117("right_leg_joint1", class_5606.method_32108(), class_5603.method_32090((float)-4.0f, (float)0.0f, (float)-1.0f));
            boolean bl18 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u2414_u24lambda_u2413 = class_56102 = $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u2414.method_32117("right_leg1", class_5606.method_32108().method_32101(0, 46).method_32097(-24.0f, -1.0f, -1.0f, 24.0f, 2.0f, 2.0f).method_32101(0, 14).method_32096().method_32097(-26.5f, -1.5f, -1.5f, 3.0f, 3.0f, 3.0f), class_5603.field_27701);
            boolean bl19 = false;
            $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u2414_u24lambda_u2413.method_32117("right_leg_front1", class_5606.method_32108().method_32101(32, 0).method_32097(-27.0f, -1.0f, -1.0f, 28.0f, 2.0f, 2.0f), class_5603.method_32090((float)-25.0f, (float)0.0f, (float)0.0f));
            class_5610 $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u2416 = class_56103 = $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419.method_32117("right_leg_joint2", class_5606.method_32108(), class_5603.method_32090((float)-4.0f, (float)0.0f, (float)1.0f));
            boolean bl20 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u2416_u24lambda_u2415 = class_56102 = $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u2416.method_32117("right_leg2", class_5606.method_32108().method_32101(0, 42).method_32097(-24.0f, -1.0f, -1.0f, 24.0f, 2.0f, 2.0f).method_32101(0, 14).method_32096().method_32097(-26.5f, -1.5f, -1.5f, 3.0f, 3.0f, 3.0f), class_5603.field_27701);
            boolean bl21 = false;
            $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u2416_u24lambda_u2415.method_32117("right_leg_front2", class_5606.method_32108().method_32101(0, 30).method_32097(-27.0f, -1.0f, -1.0f, 28.0f, 2.0f, 2.0f), class_5603.method_32090((float)-25.0f, (float)0.0f, (float)0.0f));
            class_5610 $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u2418 = class_56103 = $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419.method_32117("right_leg_joint3", class_5606.method_32108(), class_5603.method_32090((float)-4.0f, (float)0.0f, (float)3.0f));
            boolean bl22 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u2418_u24lambda_u2417 = class_56102 = $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u2418.method_32117("right_leg3", class_5606.method_32108().method_32101(0, 38).method_32097(-24.0f, -1.0f, -1.0f, 24.0f, 2.0f, 2.0f).method_32101(0, 14).method_32096().method_32097(-26.5f, -1.5f, -1.5f, 3.0f, 3.0f, 3.0f), class_5603.field_27701);
            boolean bl23 = false;
            $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u2418_u24lambda_u2417.method_32117("right_leg_front3", class_5606.method_32108().method_32101(0, 26).method_32097(-27.0f, -1.0f, -1.0f, 28.0f, 2.0f, 2.0f), class_5603.method_32090((float)-25.0f, (float)0.0f, (float)0.0f));
            $this$createTexturedModelData_u24lambda_u2422_u24lambda_u2421_u24lambda_u2420.method_32117("web", class_5606.method_32108().method_32101(0, 104).method_32097(-16.0f, -12.0f, 0.0f, 32.0f, 24.0f, 0.0f), class_5603.method_32090((float)0.0f, (float)-13.0f, (float)-30.0f));
            class_5607 class_56072 = class_5607.method_32110((class_5609)it, (int)128, (int)128);
            Intrinsics.checkNotNullExpressionValue((Object)class_56072, (String)"let(...)");
            return class_56072;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

