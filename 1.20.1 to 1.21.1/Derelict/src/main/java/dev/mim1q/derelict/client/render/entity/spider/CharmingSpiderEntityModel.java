/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
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

import dev.mim1q.derelict.client.render.entity.spider.CharmingSpiderEntityModel;
import dev.mim1q.derelict.client.render.entity.spider.SpiderRenderUtilsKt;
import dev.mim1q.derelict.entity.spider.CharmingSpiderEntity;
import dev.mim1q.derelict.util.extensions.MathExtensionsKt;
import dev.mim1q.derelict.util.extensions.ModelExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010\u0011\n\u0002\b\u0004\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006JO\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J?\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001fR\u0014\u0010!\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0014\u0010\"\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001fR\u0014\u0010#\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\u001fR\u0014\u0010$\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u001fR\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006)"}, d2={"Ldev/mim1q/derelict/client/render/entity/spider/CharmingSpiderEntityModel;", "Lnet/minecraft/class_583;", "Ldev/mim1q/derelict/entity/spider/CharmingSpiderEntity;", "Lnet/minecraft/class_630;", "part", "<init>", "(Lnet/minecraft/class_630;)V", "Lnet/minecraft/class_4587;", "matrices", "Lnet/minecraft/class_4588;", "vertices", "", "light", "overlay", "", "red", "green", "blue", "alpha", "", "render", "(Lnet/minecraft/class_4587;Lnet/minecraft/class_4588;IIFFFF)V", "entity", "limbAngle", "limbDistance", "animationProgress", "headYaw", "headPitch", "setAngles", "(Ldev/mim1q/derelict/entity/spider/CharmingSpiderEntity;FFFFF)V", "root", "Lnet/minecraft/class_630;", "leftLegs", "rightLegs", "torso", "tail", "head", "", "allLegs", "[Lnet/minecraft/class_630;", "Companion", "derelict"})
public final class CharmingSpiderEntityModel
extends class_583<CharmingSpiderEntity> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final class_630 root;
    @NotNull
    private final class_630 leftLegs;
    @NotNull
    private final class_630 rightLegs;
    @NotNull
    private final class_630 torso;
    @NotNull
    private final class_630 tail;
    @NotNull
    private final class_630 head;
    @NotNull
    private final class_630[] allLegs;

    public CharmingSpiderEntityModel(@NotNull class_630 part) {
        Intrinsics.checkNotNullParameter((Object)part, (String)"part");
        super(class_1921::method_23576);
        class_630 class_6302 = part.method_32086("root");
        Intrinsics.checkNotNullExpressionValue((Object)class_6302, (String)"getChild(...)");
        this.root = class_6302;
        class_630 class_6303 = this.root.method_32086("left_legs");
        Intrinsics.checkNotNullExpressionValue((Object)class_6303, (String)"getChild(...)");
        this.leftLegs = class_6303;
        class_630 class_6304 = this.root.method_32086("right_legs");
        Intrinsics.checkNotNullExpressionValue((Object)class_6304, (String)"getChild(...)");
        this.rightLegs = class_6304;
        class_630 class_6305 = this.root.method_32086("torso");
        Intrinsics.checkNotNullExpressionValue((Object)class_6305, (String)"getChild(...)");
        this.torso = class_6305;
        class_630 class_6306 = this.torso.method_32086("tail");
        Intrinsics.checkNotNullExpressionValue((Object)class_6306, (String)"getChild(...)");
        this.tail = class_6306;
        class_630 class_6307 = this.torso.method_32086("head");
        Intrinsics.checkNotNullExpressionValue((Object)class_6307, (String)"getChild(...)");
        this.head = class_6307;
        class_630[] class_630Array = new class_630[8];
        CharmingSpiderEntityModel charmingSpiderEntityModel = this;
        for (int i = 0; i < 8; ++i) {
            int n = i;
            String child = n < 4 ? "left_leg" : "right_leg";
            Intrinsics.checkNotNullExpressionValue((Object)this.root.method_32086(child + "s").method_32086(child + n % 4), (String)"getChild(...)");
        }
        charmingSpiderEntityModel.allLegs = class_630Array;
    }

    public void method_2828(@NotNull class_4587 matrices, @NotNull class_4588 vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        Intrinsics.checkNotNullParameter((Object)matrices, (String)"matrices");
        Intrinsics.checkNotNullParameter((Object)vertices, (String)"vertices");
        this.root.method_22698(matrices, vertices, light, overlay);
    }

    public void setAngles(@NotNull CharmingSpiderEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        this.root.method_32088().forEach(arg_0 -> CharmingSpiderEntityModel.setAngles$lambda$0(setAngles.1.INSTANCE, arg_0));
        class_630 class_6302 = this.root;
        class_6302.field_3656 -= 2.0f;
        this.leftLegs.field_3674 = MathExtensionsKt.radians(20.0f);
        this.rightLegs.field_3674 = MathExtensionsKt.radians(-20.0f);
        SpiderRenderUtilsKt.walkSpiderLegs(this.allLegs, animationProgress, limbDistance);
        float tailWiggle = entity.getTailDanceAnimation().update(animationProgress);
        float bodyWiggle = entity.getBodyDanceAnimation().update(animationProgress);
        class_630 class_6303 = this.tail;
        class_6303.field_3674 += MathExtensionsKt.radians(180.0f) * tailWiggle;
        class_6303 = this.tail;
        class_6303.field_3654 -= MathExtensionsKt.radians(60.0f) * tailWiggle;
        class_6303 = this.tail;
        class_6303.field_3675 += tailWiggle * (float)Math.sin(animationProgress * 0.5f) * MathExtensionsKt.radians(30.0f);
        ModelExtensionsKt.setPartialAnglesDegrees(this.allLegs[1], 0.0f, -65.0f + bodyWiggle * 15.0f, 15.0f, tailWiggle);
        ModelExtensionsKt.setPartialAnglesDegrees(this.allLegs[5], 0.0f, 65.0f + bodyWiggle * 15.0f, -15.0f, tailWiggle);
        class_6303 = this.torso;
        class_6303.field_3657 += bodyWiggle * 0.5f;
        this.torso.field_3675 = bodyWiggle * MathExtensionsKt.radians(5.0f);
        for (int i = 0; i < 8; ++i) {
            class_630 class_6304 = this.allLegs[i];
            class_6304.field_3675 += bodyWiggle * MathExtensionsKt.radians(5.0f);
        }
        this.head.field_3675 = MathExtensionsKt.radians(headYaw);
        this.head.field_3654 = MathExtensionsKt.radians(headPitch);
    }

    private static final void setAngles$lambda$0(Function1 $tmp0, Object p0) {
        Intrinsics.checkNotNullParameter((Object)$tmp0, (String)"$tmp0");
        $tmp0.invoke(p0);
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Ldev/mim1q/derelict/client/render/entity/spider/CharmingSpiderEntityModel$Companion;", "", "<init>", "()V", "Lnet/minecraft/class_5607;", "createTexturedModelData", "()Lnet/minecraft/class_5607;", "derelict"})
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
            class_5610 $this$createTexturedModelData_u24lambda_u245_u24lambda_u244 = class_56104 = it.method_32111();
            boolean bl2 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u245_u24lambda_u244_u24lambda_u243 = class_56103 = $this$createTexturedModelData_u24lambda_u245_u24lambda_u244.method_32117("root", class_5606.method_32108(), class_5603.method_32090((float)0.0f, (float)23.0f, (float)3.0f));
            boolean bl3 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u245_u24lambda_u244_u24lambda_u243_u24lambda_u240 = class_56102 = $this$createTexturedModelData_u24lambda_u245_u24lambda_u244_u24lambda_u243.method_32117("left_legs", class_5606.method_32108(), class_5603.method_32090((float)2.0f, (float)-3.0f, (float)-3.0f));
            boolean bl4 = false;
            $this$createTexturedModelData_u24lambda_u245_u24lambda_u244_u24lambda_u243_u24lambda_u240.method_32117("left_leg0", class_5606.method_32108().method_32101(26, 26).method_32097(0.0f, -1.0f, -1.0f, 12.0f, 2.0f, 2.0f), class_5603.method_32090((float)0.0f, (float)0.0f, (float)-1.0f));
            $this$createTexturedModelData_u24lambda_u245_u24lambda_u244_u24lambda_u243_u24lambda_u240.method_32117("left_leg1", class_5606.method_32108().method_32101(26, 22).method_32097(0.0f, -1.0f, -1.0f, 12.0f, 2.0f, 2.0f), class_5603.method_32090((float)0.0f, (float)0.0f, (float)1.0f));
            $this$createTexturedModelData_u24lambda_u245_u24lambda_u244_u24lambda_u243_u24lambda_u240.method_32117("left_leg2", class_5606.method_32108().method_32101(26, 18).method_32097(0.0f, -1.0f, -1.0f, 12.0f, 2.0f, 2.0f), class_5603.method_32090((float)0.0f, (float)0.0f, (float)1.0f));
            $this$createTexturedModelData_u24lambda_u245_u24lambda_u244_u24lambda_u243_u24lambda_u240.method_32117("left_leg3", class_5606.method_32108().method_32101(26, 14).method_32097(0.0f, -1.0f, -1.0f, 12.0f, 2.0f, 2.0f), class_5603.method_32090((float)0.0f, (float)0.0f, (float)3.0f));
            class_5610 $this$createTexturedModelData_u24lambda_u245_u24lambda_u244_u24lambda_u243_u24lambda_u241 = class_56102 = $this$createTexturedModelData_u24lambda_u245_u24lambda_u244_u24lambda_u243.method_32117("right_legs", class_5606.method_32108(), class_5603.method_32090((float)-2.0f, (float)-3.0f, (float)-3.0f));
            boolean bl5 = false;
            $this$createTexturedModelData_u24lambda_u245_u24lambda_u244_u24lambda_u243_u24lambda_u241.method_32117("right_leg0", class_5606.method_32108().method_32101(0, 24).method_32097(-12.0f, -1.0f, -1.0f, 12.0f, 2.0f, 2.0f), class_5603.method_32090((float)0.0f, (float)0.0f, (float)-1.0f));
            $this$createTexturedModelData_u24lambda_u245_u24lambda_u244_u24lambda_u243_u24lambda_u241.method_32117("right_leg1", class_5606.method_32108().method_32101(0, 20).method_32097(-12.0f, -1.0f, -1.0f, 12.0f, 2.0f, 2.0f), class_5603.method_32090((float)0.0f, (float)0.0f, (float)1.0f));
            $this$createTexturedModelData_u24lambda_u245_u24lambda_u244_u24lambda_u243_u24lambda_u241.method_32117("right_leg2", class_5606.method_32108().method_32101(0, 16).method_32097(-12.0f, -1.0f, -1.0f, 12.0f, 2.0f, 2.0f), class_5603.method_32090((float)0.0f, (float)0.0f, (float)1.0f));
            $this$createTexturedModelData_u24lambda_u245_u24lambda_u244_u24lambda_u243_u24lambda_u241.method_32117("right_leg3", class_5606.method_32108().method_32101(0, 12).method_32097(-12.0f, -1.0f, -1.0f, 12.0f, 2.0f, 2.0f), class_5603.method_32090((float)0.0f, (float)0.0f, (float)3.0f));
            class_5610 $this$createTexturedModelData_u24lambda_u245_u24lambda_u244_u24lambda_u243_u24lambda_u242 = class_56102 = $this$createTexturedModelData_u24lambda_u245_u24lambda_u244_u24lambda_u243.method_32117("torso", class_5606.method_32108().method_32101(0, 28).method_32097(-2.0f, -5.0f, -6.0f, 4.0f, 3.0f, 6.0f), class_5603.field_27701);
            boolean bl6 = false;
            $this$createTexturedModelData_u24lambda_u245_u24lambda_u244_u24lambda_u243_u24lambda_u242.method_32117("tail", class_5606.method_32108().method_32101(0, 0).method_32097(-8.0f, 0.0f, 0.0f, 16.0f, 0.0f, 12.0f), class_5603.method_32090((float)0.0f, (float)-5.0f, (float)0.0f));
            $this$createTexturedModelData_u24lambda_u245_u24lambda_u244_u24lambda_u243_u24lambda_u242.method_32117("head", class_5606.method_32108().method_32101(20, 30).method_32097(-3.0f, -2.0f, -4.0f, 6.0f, 4.0f, 4.0f).method_32101(0, 0).method_32097(-2.5f, 2.0f, -4.0f, 2.0f, 2.0f, 2.0f).method_32101(0, 0).method_32097(0.5f, 2.0f, -4.0f, 2.0f, 2.0f, 2.0f), class_5603.method_32090((float)0.0f, (float)-4.0f, (float)-6.0f));
            class_5607 class_56072 = class_5607.method_32110((class_5609)it, (int)64, (int)64);
            Intrinsics.checkNotNullExpressionValue((Object)class_56072, (String)"let(...)");
            return class_56072;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

