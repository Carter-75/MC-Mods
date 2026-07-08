/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer
 *  net.minecraft.class_1304
 *  net.minecraft.class_1309
 *  net.minecraft.class_1799
 *  net.minecraft.class_1921
 *  net.minecraft.class_2960
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_4608
 *  net.minecraft.class_5603
 *  net.minecraft.class_5605
 *  net.minecraft.class_5606
 *  net.minecraft.class_5607
 *  net.minecraft.class_5609
 *  net.minecraft.class_5610
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_572
 *  net.minecraft.class_630
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.client.render.armor;

import dev.mim1q.derelict.Derelict;
import dev.mim1q.derelict.init.client.ModRender;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1799;
import net.minecraft.class_1921;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_4608;
import net.minecraft.class_5603;
import net.minecraft.class_5605;
import net.minecraft.class_5606;
import net.minecraft.class_5607;
import net.minecraft.class_5609;
import net.minecraft.class_5610;
import net.minecraft.class_5617;
import net.minecraft.class_572;
import net.minecraft.class_630;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005JM\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0012H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0019\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u001c\u0010\u001c\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u001c\u0010\u001d\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001a\u00a8\u0006\u001f"}, d2={"Ldev/mim1q/derelict/client/render/armor/NetwalkersRenderer;", "Lnet/fabricmc/fabric/api/client/rendering/v1/ArmorRenderer;", "Lnet/minecraft/class_5617$class_5618;", "ctx", "<init>", "(Lnet/minecraft/class_5617$class_5618;)V", "Lnet/minecraft/class_4587;", "matrices", "Lnet/minecraft/class_4597;", "vertexConsumers", "Lnet/minecraft/class_1799;", "stack", "Lnet/minecraft/class_1309;", "entity", "Lnet/minecraft/class_1304;", "slot", "", "light", "Lnet/minecraft/class_572;", "contextModel", "", "render", "(Lnet/minecraft/class_4587;Lnet/minecraft/class_4597;Lnet/minecraft/class_1799;Lnet/minecraft/class_1309;Lnet/minecraft/class_1304;ILnet/minecraft/class_572;)V", "Lnet/minecraft/class_630;", "kotlin.jvm.PlatformType", "modelRoot", "Lnet/minecraft/class_630;", "modelWaist", "modelLeftLeg", "modelRightLeg", "Companion", "derelict"})
public final class NetwalkersRenderer
implements ArmorRenderer {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final class_630 modelRoot;
    private final class_630 modelWaist;
    private final class_630 modelLeftLeg;
    private final class_630 modelRightLeg;
    @NotNull
    private static final class_2960 TEXTURE = Derelict.INSTANCE.id("textures/armor/netwalkers.png");

    public NetwalkersRenderer(@NotNull class_5617.class_5618 ctx) {
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        this.modelRoot = ctx.method_32167(ModRender.INSTANCE.getNETWALKERS_LAYER());
        this.modelWaist = this.modelRoot.method_32086("waist");
        this.modelLeftLeg = this.modelRoot.method_32086("left_leg");
        this.modelRightLeg = this.modelRoot.method_32086("right_leg");
    }

    public void render(@NotNull class_4587 matrices, @NotNull class_4597 vertexConsumers, @NotNull class_1799 stack, @NotNull class_1309 entity, @NotNull class_1304 slot, int light, @NotNull class_572<class_1309> contextModel) {
        Intrinsics.checkNotNullParameter((Object)matrices, (String)"matrices");
        Intrinsics.checkNotNullParameter((Object)vertexConsumers, (String)"vertexConsumers");
        Intrinsics.checkNotNullParameter((Object)stack, (String)"stack");
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)slot, (String)"slot");
        Intrinsics.checkNotNullParameter(contextModel, (String)"contextModel");
        this.modelWaist.method_17138(contextModel.field_3391);
        this.modelRightLeg.method_17138(contextModel.field_3392);
        this.modelLeftLeg.method_17138(contextModel.field_3397);
        this.modelRoot.method_22698(matrices, vertexConsumers.getBuffer(class_1921.method_23578((class_2960)TEXTURE)), light, class_4608.field_21444);
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Ldev/mim1q/derelict/client/render/armor/NetwalkersRenderer$Companion;", "", "<init>", "()V", "Lnet/minecraft/class_5607;", "createTexturedModelData", "()Lnet/minecraft/class_5607;", "Lnet/minecraft/class_2960;", "TEXTURE", "Lnet/minecraft/class_2960;", "getTEXTURE", "()Lnet/minecraft/class_2960;", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final class_2960 getTEXTURE() {
            return TEXTURE;
        }

        @NotNull
        public final class_5607 createTexturedModelData() {
            class_5610 class_56102;
            class_5610 class_56103;
            class_5609 it = new class_5609();
            boolean bl = false;
            class_5610 $this$createTexturedModelData_u24lambda_u243_u24lambda_u242 = class_56103 = it.method_32111();
            boolean bl2 = false;
            $this$createTexturedModelData_u24lambda_u243_u24lambda_u242.method_32117("waist", class_5606.method_32108().method_32101(0, 22).method_32098(-4.5f, 7.0f, -2.5f, 9.0f, 5.0f, 5.0f, new class_5605(0.1f)), class_5603.field_27701);
            class_5610 $this$createTexturedModelData_u24lambda_u243_u24lambda_u242_u24lambda_u240 = class_56102 = $this$createTexturedModelData_u24lambda_u243_u24lambda_u242.method_32117("left_leg", class_5606.method_32108().method_32101(0, 0).method_32096().method_32097(-2.5f, 0.0f, -2.48f, 5.0f, 12.0f, 5.0f).method_32101(44, 23).method_32096().method_32098(-2.5f, 4.0f, -2.48f, 5.0f, 4.0f, 5.0f, new class_5605(0.01f)), class_5603.method_32090((float)1.9f, (float)12.0f, (float)0.0f));
            boolean bl3 = false;
            $this$createTexturedModelData_u24lambda_u243_u24lambda_u242_u24lambda_u240.method_32117("left_leg_r1", class_5606.method_32108().method_32101(30, 20).method_32096().method_32097(0.0f, -6.0f, 0.0f, 1.0f, 12.0f, 0.0f), class_5603.method_32091((float)2.5f, (float)6.0f, (float)2.48f, (float)0.0f, (float)-0.7854f, (float)0.0f));
            $this$createTexturedModelData_u24lambda_u243_u24lambda_u242_u24lambda_u240.method_32117("left_leg_r2", class_5606.method_32108().method_32101(28, 20).method_32096().method_32097(0.0f, -6.0f, 0.0f, 1.0f, 12.0f, 0.0f), class_5603.method_32091((float)2.5f, (float)6.0f, (float)-2.48f, (float)0.0f, (float)0.7854f, (float)0.0f));
            class_5610 $this$createTexturedModelData_u24lambda_u243_u24lambda_u242_u24lambda_u241 = class_56102 = $this$createTexturedModelData_u24lambda_u243_u24lambda_u242.method_32117("right_leg", class_5606.method_32108().method_32101(20, 0).method_32097(-2.5f, 0.0f, -2.5f, 5.0f, 12.0f, 5.0f).method_32101(42, 0).method_32097(-2.75f, -4.0f, -2.75f, 6.0f, 9.0f, 5.0f), class_5603.method_32090((float)-1.9f, (float)12.0f, (float)0.0f));
            boolean bl4 = false;
            $this$createTexturedModelData_u24lambda_u243_u24lambda_u242_u24lambda_u241.method_32117("right_leg_r1", class_5606.method_32108().method_32101(32, 20).method_32097(-1.0f, -6.0f, 0.0f, 1.0f, 12.0f, 0.0f), class_5603.method_32091((float)-2.5f, (float)6.0f, (float)2.48f, (float)0.0f, (float)0.7854f, (float)0.0f));
            $this$createTexturedModelData_u24lambda_u243_u24lambda_u242_u24lambda_u241.method_32117("right_leg_r2", class_5606.method_32108().method_32101(34, 20).method_32097(-1.0f, -6.0f, 0.0f, 1.0f, 12.0f, 0.0f), class_5603.method_32091((float)-2.5f, (float)6.0f, (float)-2.48f, (float)0.0f, (float)-0.7854f, (float)0.0f));
            class_5607 class_56072 = class_5607.method_32110((class_5609)it, (int)64, (int)32);
            Intrinsics.checkNotNullExpressionValue((Object)class_56072, (String)"let(...)");
            return class_56072;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

