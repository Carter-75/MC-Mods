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
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_5603
 *  net.minecraft.class_5605
 *  net.minecraft.class_5606
 *  net.minecraft.class_5607
 *  net.minecraft.class_5609
 *  net.minecraft.class_5610
 *  net.minecraft.class_583
 *  net.minecraft.class_630
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.client.render.entity.spider;

import dev.mim1q.derelict.client.render.entity.spider.DaddyLongLegsEntityModel;
import dev.mim1q.derelict.entity.spider.DaddyLongLegsEntity;
import dev.mim1q.derelict.entity.spider.legs.SpiderLegParts;
import dev.mim1q.gimm1q.interpolation.Easing;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1297;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_5603;
import net.minecraft.class_5605;
import net.minecraft.class_5606;
import net.minecraft.class_5607;
import net.minecraft.class_5609;
import net.minecraft.class_5610;
import net.minecraft.class_583;
import net.minecraft.class_630;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006JO\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J?\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ/\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u001f\u0010 R\u001f\u0010\"\u001a\n !*\u0004\u0018\u00010\u00030\u00038\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010&\u001a\n !*\u0004\u0018\u00010\u00030\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010#R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\u00a8\u0006."}, d2={"Ldev/mim1q/derelict/client/render/entity/spider/DaddyLongLegsEntityModel;", "Lnet/minecraft/class_583;", "Ldev/mim1q/derelict/entity/spider/DaddyLongLegsEntity;", "Lnet/minecraft/class_630;", "part", "<init>", "(Lnet/minecraft/class_630;)V", "Lnet/minecraft/class_4587;", "matrices", "Lnet/minecraft/class_4588;", "vertices", "", "light", "overlay", "", "red", "green", "blue", "alpha", "", "render", "(Lnet/minecraft/class_4587;Lnet/minecraft/class_4588;IIFFFF)V", "entity", "limbAngle", "limbDistance", "animationProgress", "headYaw", "headPitch", "setAngles", "(Ldev/mim1q/derelict/entity/spider/DaddyLongLegsEntity;FFFFF)V", "tickDelta", "animateModel", "(Ldev/mim1q/derelict/entity/spider/DaddyLongLegsEntity;FFF)V", "kotlin.jvm.PlatformType", "root", "Lnet/minecraft/class_630;", "getRoot", "()Lnet/minecraft/class_630;", "body", "", "Ldev/mim1q/derelict/entity/spider/legs/SpiderLegParts;", "legs", "[Ldev/mim1q/derelict/entity/spider/legs/SpiderLegParts;", "getLegs", "()[Ldev/mim1q/derelict/entity/spider/legs/SpiderLegParts;", "Companion", "derelict"})
@SourceDebugExtension(value={"SMAP\nDaddyLongLegsEntityRenderer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DaddyLongLegsEntityRenderer.kt\ndev/mim1q/derelict/client/render/entity/spider/DaddyLongLegsEntityModel\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,156:1\n13411#2,3:157\n*S KotlinDebug\n*F\n+ 1 DaddyLongLegsEntityRenderer.kt\ndev/mim1q/derelict/client/render/entity/spider/DaddyLongLegsEntityModel\n*L\n83#1:157,3\n*E\n"})
public final class DaddyLongLegsEntityModel
extends class_583<DaddyLongLegsEntity> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final class_630 root;
    private final class_630 body;
    @NotNull
    private final SpiderLegParts[] legs;

    public DaddyLongLegsEntityModel(@NotNull class_630 part) {
        Intrinsics.checkNotNullParameter((Object)part, (String)"part");
        this.root = part.method_32086("root");
        this.body = this.root.method_32086("body");
        class_630 class_6302 = this.root;
        Intrinsics.checkNotNullExpressionValue((Object)class_6302, (String)"root");
        this.legs = SpiderLegParts.Companion.createArray(class_6302);
    }

    public final class_630 getRoot() {
        return this.root;
    }

    @NotNull
    public final SpiderLegParts[] getLegs() {
        return this.legs;
    }

    public void method_2828(@NotNull class_4587 matrices, @NotNull class_4588 vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        Intrinsics.checkNotNullParameter((Object)matrices, (String)"matrices");
        Intrinsics.checkNotNullParameter((Object)vertices, (String)"vertices");
        this.root.method_22699(matrices, vertices, light, overlay, red, green, blue, alpha);
    }

    public void setAngles(@NotNull DaddyLongLegsEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        class_630 class_6302 = this.root;
        class_6302.field_3656 -= 10.0f;
        float dance = entity.getDanceAnimation().update(animationProgress);
        class_630 class_6303 = this.root;
        class_6303.field_3657 += (float)Math.cos(animationProgress * 0.5f - 1.0471976f) * 12.0f * dance;
        class_6303 = this.root;
        class_6303.field_3656 -= ((float)Math.sin(animationProgress * 0.5f - 1.0471976f) * 16.0f - 12.0f) * dance;
    }

    /*
     * WARNING - void declaration
     */
    public void animateModel(@NotNull DaddyLongLegsEntity entity, float limbAngle, float limbDistance, float tickDelta) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        super.method_2816((class_1297)entity, limbAngle, limbDistance, tickDelta);
        this.root.method_32088().forEach(arg_0 -> DaddyLongLegsEntityModel.animateModel$lambda$0(animateModel.1.INSTANCE, arg_0));
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

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Ldev/mim1q/derelict/client/render/entity/spider/DaddyLongLegsEntityModel$Companion;", "", "<init>", "()V", "Lnet/minecraft/class_5607;", "createTexturedModelData", "()Lnet/minecraft/class_5607;", "derelict"})
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
            class_5610 $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426 = class_56106 = it.method_32111();
            boolean bl2 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425 = class_56105 = $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426.method_32117("root", class_5606.method_32108(), class_5603.method_32090((float)0.0f, (float)21.0f, (float)0.0f));
            boolean bl3 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u240 = class_56104 = $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425.method_32117("body", class_5606.method_32108().method_32101(0, 16).method_32097(-4.0f, -4.0f, -4.0f, 8.0f, 8.0f, 8.0f), class_5603.method_32090((float)0.0f, (float)-46.0f, (float)0.0f));
            boolean bl4 = false;
            $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u240.method_32117("cube_r1", class_5606.method_32108().method_32101(46, 48).method_32097(-4.5f, -4.0f, 0.0f, 9.0f, 9.0f, 0.0f), class_5603.method_32091((float)3.5f, (float)-4.0f, (float)-4.5f, (float)0.0f, (float)-0.5236f, (float)0.0f));
            class_5610 $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u243 = class_56104 = $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425.method_32117("left_leg_joint0", class_5606.method_32108(), class_5603.method_32090((float)3.0f, (float)-44.0f, (float)-1.5f));
            boolean bl5 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u243_u24lambda_u242 = class_56103 = $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u243.method_32117("left_leg0", class_5606.method_32108().method_32101(0, 15).method_32097(0.0f, -0.5f, 0.0f, 32.0f, 1.0f, 0.0f), class_5603.field_27701);
            boolean bl6 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u243_u24lambda_u242_u24lambda_u241 = class_56102 = $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u243_u24lambda_u242.method_32117("left_leg_front0", class_5606.method_32108().method_32101(0, 14).method_32097(0.0f, -0.5f, 0.0f, 32.0f, 1.0f, 0.0f), class_5603.method_32090((float)32.0f, (float)0.0f, (float)0.0f));
            boolean bl7 = false;
            $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u243_u24lambda_u242_u24lambda_u241.method_32117("left_sock0", class_5606.method_32108().method_32101(2, 62).method_32098(2.5f, -1.0f, 0.0f, 30.0f, 1.0f, 0.0f, new class_5605(0.1f)), class_5603.method_32090((float)0.0f, (float)0.5f, (float)0.0f));
            class_5610 $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u246 = class_56104 = $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425.method_32117("right_leg_joint0", class_5606.method_32108(), class_5603.method_32090((float)-3.0f, (float)-44.0f, (float)-1.5f));
            boolean bl8 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u246_u24lambda_u245 = class_56103 = $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u246.method_32117("right_leg0", class_5606.method_32108().method_32101(0, 15).method_32096().method_32097(-32.0f, -0.5f, 0.0f, 32.0f, 1.0f, 0.0f), class_5603.field_27701);
            boolean bl9 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u246_u24lambda_u245_u24lambda_u244 = class_56102 = $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u246_u24lambda_u245.method_32117("right_leg_front0", class_5606.method_32108().method_32101(0, 14).method_32096().method_32097(-32.0f, -0.5f, 0.0f, 32.0f, 1.0f, 0.0f), class_5603.method_32090((float)-32.0f, (float)0.0f, (float)0.0f));
            boolean bl10 = false;
            $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u246_u24lambda_u245_u24lambda_u244.method_32117("right_sock0", class_5606.method_32108().method_32101(2, 62).method_32096().method_32098(-32.5f, -1.0f, 0.0f, 30.0f, 1.0f, 0.0f, new class_5605(0.1f)), class_5603.method_32090((float)0.0f, (float)0.5f, (float)0.0f));
            class_5610 $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u249 = class_56104 = $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425.method_32117("left_leg_joint1", class_5606.method_32108(), class_5603.method_32090((float)3.0f, (float)-44.0f, (float)-0.5f));
            boolean bl11 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u249_u24lambda_u248 = class_56103 = $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u249.method_32117("left_leg1", class_5606.method_32108().method_32101(0, 13).method_32097(0.0f, -0.5f, 0.0f, 32.0f, 1.0f, 0.0f), class_5603.field_27701);
            boolean bl12 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u249_u24lambda_u248_u24lambda_u247 = class_56102 = $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u249_u24lambda_u248.method_32117("left_leg_front1", class_5606.method_32108().method_32101(0, 12).method_32097(0.0f, -0.5f, 0.0f, 32.0f, 1.0f, 0.0f), class_5603.method_32090((float)32.0f, (float)0.0f, (float)0.0f));
            boolean bl13 = false;
            $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u249_u24lambda_u248_u24lambda_u247.method_32117("left_sock1", class_5606.method_32108().method_32101(2, 63).method_32098(2.5f, -1.0f, 0.0f, 30.0f, 1.0f, 0.0f, new class_5605(0.1f)), class_5603.method_32090((float)0.0f, (float)0.5f, (float)0.0f));
            class_5610 $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u2412 = class_56104 = $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425.method_32117("right_leg_joint1", class_5606.method_32108(), class_5603.method_32090((float)-3.0f, (float)-44.0f, (float)-0.5f));
            boolean bl14 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u2412_u24lambda_u2411 = class_56103 = $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u2412.method_32117("right_leg1", class_5606.method_32108().method_32101(0, 13).method_32096().method_32097(-32.0f, -0.5f, 0.0f, 32.0f, 1.0f, 0.0f), class_5603.field_27701);
            boolean bl15 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u2412_u24lambda_u2411_u24lambda_u2410 = class_56102 = $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u2412_u24lambda_u2411.method_32117("right_leg_front1", class_5606.method_32108().method_32101(0, 12).method_32096().method_32097(-32.0f, -0.5f, 0.0f, 32.0f, 1.0f, 0.0f), class_5603.method_32090((float)-32.0f, (float)0.0f, (float)0.0f));
            boolean bl16 = false;
            $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u2412_u24lambda_u2411_u24lambda_u2410.method_32117("right_sock1", class_5606.method_32108().method_32101(2, 63).method_32096().method_32098(-32.5f, -1.0f, 0.0f, 30.0f, 1.0f, 0.0f, new class_5605(0.1f)), class_5603.method_32090((float)0.0f, (float)0.5f, (float)0.0f));
            class_5610 $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u2415 = class_56104 = $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425.method_32117("left_leg_joint2", class_5606.method_32108(), class_5603.method_32090((float)3.0f, (float)-44.0f, (float)0.5f));
            boolean bl17 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u2415_u24lambda_u2414 = class_56103 = $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u2415.method_32117("left_leg2", class_5606.method_32108().method_32101(0, 15).method_32097(0.0f, -0.5f, 0.0f, 32.0f, 1.0f, 0.0f), class_5603.field_27701);
            boolean bl18 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u2415_u24lambda_u2414_u24lambda_u2413 = class_56102 = $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u2415_u24lambda_u2414.method_32117("left_leg_front2", class_5606.method_32108().method_32101(0, 14).method_32097(0.0f, -0.5f, 0.0f, 32.0f, 1.0f, 0.0f), class_5603.method_32090((float)32.0f, (float)0.0f, (float)0.0f));
            boolean bl19 = false;
            $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u2415_u24lambda_u2414_u24lambda_u2413.method_32117("left_sock2", class_5606.method_32108().method_32101(2, 62).method_32098(2.5f, -1.0f, 0.0f, 30.0f, 1.0f, 0.0f, new class_5605(0.1f)), class_5603.method_32090((float)0.0f, (float)0.5f, (float)0.0f));
            class_5610 $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u2418 = class_56104 = $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425.method_32117("right_leg_joint2", class_5606.method_32108(), class_5603.method_32090((float)-3.0f, (float)-44.0f, (float)0.5f));
            boolean bl20 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u2418_u24lambda_u2417 = class_56103 = $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u2418.method_32117("right_leg2", class_5606.method_32108().method_32101(0, 15).method_32096().method_32097(-32.0f, -0.5f, 0.0f, 32.0f, 1.0f, 0.0f), class_5603.field_27701);
            boolean bl21 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u2418_u24lambda_u2417_u24lambda_u2416 = class_56102 = $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u2418_u24lambda_u2417.method_32117("right_leg_front2", class_5606.method_32108().method_32101(0, 14).method_32096().method_32097(-32.0f, -0.5f, 0.0f, 32.0f, 1.0f, 0.0f), class_5603.method_32090((float)-32.0f, (float)0.0f, (float)0.0f));
            boolean bl22 = false;
            $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u2418_u24lambda_u2417_u24lambda_u2416.method_32117("right_sock2", class_5606.method_32108().method_32101(2, 62).method_32096().method_32098(-32.5f, -1.0f, 0.0f, 30.0f, 1.0f, 0.0f, new class_5605(0.1f)), class_5603.method_32090((float)0.0f, (float)0.5f, (float)0.0f));
            class_5610 $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u2421 = class_56104 = $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425.method_32117("left_leg_joint3", class_5606.method_32108(), class_5603.method_32090((float)3.0f, (float)-44.0f, (float)1.5f));
            boolean bl23 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u2421_u24lambda_u2420 = class_56103 = $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u2421.method_32117("left_leg3", class_5606.method_32108().method_32101(0, 15).method_32097(0.0f, -0.5f, 0.0f, 32.0f, 1.0f, 0.0f), class_5603.field_27701);
            boolean bl24 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419 = class_56102 = $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u2421_u24lambda_u2420.method_32117("left_leg_front3", class_5606.method_32108().method_32101(0, 14).method_32097(0.0f, -0.5f, 0.0f, 32.0f, 1.0f, 0.0f), class_5603.method_32090((float)32.0f, (float)0.0f, (float)0.0f));
            boolean bl25 = false;
            $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419.method_32117("left_sock3", class_5606.method_32108().method_32101(2, 63).method_32098(2.5f, -1.0f, 0.0f, 30.0f, 1.0f, 0.0f, new class_5605(0.1f)), class_5603.method_32090((float)0.0f, (float)0.5f, (float)0.0f));
            class_5610 $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u2424 = class_56104 = $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425.method_32117("right_leg_joint3", class_5606.method_32108(), class_5603.method_32090((float)-3.0f, (float)-44.0f, (float)1.5f));
            boolean bl26 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u2424_u24lambda_u2423 = class_56103 = $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u2424.method_32117("right_leg3", class_5606.method_32108().method_32101(0, 15).method_32096().method_32097(-32.0f, -0.5f, 0.0f, 32.0f, 1.0f, 0.0f), class_5603.field_27701);
            boolean bl27 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u2424_u24lambda_u2423_u24lambda_u2422 = class_56102 = $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u2424_u24lambda_u2423.method_32117("right_leg_front3", class_5606.method_32108().method_32101(0, 14).method_32096().method_32097(-32.0f, -0.5f, 0.0f, 32.0f, 1.0f, 0.0f), class_5603.method_32090((float)-32.0f, (float)0.0f, (float)0.0f));
            boolean bl28 = false;
            $this$createTexturedModelData_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425_u24lambda_u2424_u24lambda_u2423_u24lambda_u2422.method_32117("right_sock3", class_5606.method_32108().method_32101(2, 63).method_32096().method_32098(-32.5f, -1.0f, 0.0f, 30.0f, 1.0f, 0.0f, new class_5605(0.1f)), class_5603.method_32090((float)0.0f, (float)0.5f, (float)0.0f));
            class_5607 class_56072 = class_5607.method_32110((class_5609)it, (int)64, (int)64);
            Intrinsics.checkNotNullExpressionValue((Object)class_56072, (String)"let(...)");
            return class_56072;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

