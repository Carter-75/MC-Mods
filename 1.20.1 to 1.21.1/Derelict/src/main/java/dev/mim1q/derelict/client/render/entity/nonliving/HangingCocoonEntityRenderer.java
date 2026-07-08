/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1921
 *  net.minecraft.class_2960
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_4608
 *  net.minecraft.class_5603
 *  net.minecraft.class_5606
 *  net.minecraft.class_5607
 *  net.minecraft.class_5609
 *  net.minecraft.class_5610
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_630
 *  net.minecraft.class_7833
 *  net.minecraft.class_897
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.client.render.entity.nonliving;

import dev.mim1q.derelict.Derelict;
import dev.mim1q.derelict.entity.nonliving.HangingCocoonEntity;
import dev.mim1q.derelict.init.client.ModRender;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1921;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_4608;
import net.minecraft.class_5603;
import net.minecraft.class_5606;
import net.minecraft.class_5607;
import net.minecraft.class_5609;
import net.minecraft.class_5610;
import net.minecraft.class_5617;
import net.minecraft.class_630;
import net.minecraft.class_7833;
import net.minecraft.class_897;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J?\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0019\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001c"}, d2={"Ldev/mim1q/derelict/client/render/entity/nonliving/HangingCocoonEntityRenderer;", "Lnet/minecraft/class_897;", "Ldev/mim1q/derelict/entity/nonliving/HangingCocoonEntity;", "Lnet/minecraft/class_5617$class_5618;", "ctx", "<init>", "(Lnet/minecraft/class_5617$class_5618;)V", "entity", "", "yaw", "tickDelta", "Lnet/minecraft/class_4587;", "matrices", "Lnet/minecraft/class_4597;", "vertexConsumers", "", "light", "", "render", "(Ldev/mim1q/derelict/entity/nonliving/HangingCocoonEntity;FFLnet/minecraft/class_4587;Lnet/minecraft/class_4597;I)V", "Lnet/minecraft/class_2960;", "getTexture", "(Ldev/mim1q/derelict/entity/nonliving/HangingCocoonEntity;)Lnet/minecraft/class_2960;", "Lnet/minecraft/class_630;", "kotlin.jvm.PlatformType", "modelPart", "Lnet/minecraft/class_630;", "Companion", "derelict"})
@SourceDebugExtension(value={"SMAP\nHangingCocoonEntityRenderer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HangingCocoonEntityRenderer.kt\ndev/mim1q/derelict/client/render/entity/nonliving/HangingCocoonEntityRenderer\n+ 2 RenderUtil.kt\ndev/mim1q/derelict/util/render/RenderUtilKt\n*L\n1#1,75:1\n12#2,4:76\n*S KotlinDebug\n*F\n+ 1 HangingCocoonEntityRenderer.kt\ndev/mim1q/derelict/client/render/entity/nonliving/HangingCocoonEntityRenderer\n*L\n33#1:76,4\n*E\n"})
public final class HangingCocoonEntityRenderer
extends class_897<HangingCocoonEntity> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final class_630 modelPart;
    @NotNull
    private static final class_2960 TEXTURE = Derelict.INSTANCE.id("textures/entity/hanging_cocoon/hanging_cocoon.png");
    @NotNull
    private static final class_2960 BROKEN_TEXTURE = Derelict.INSTANCE.id("textures/entity/hanging_cocoon/hanging_cocoon_broken.png");

    public HangingCocoonEntityRenderer(@NotNull class_5617.class_5618 ctx) {
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        super(ctx);
        this.modelPart = ctx.method_32167(ModRender.INSTANCE.getHANGING_COCOON_LAYER());
    }

    public void render(@NotNull HangingCocoonEntity entity, float yaw, float tickDelta, @NotNull class_4587 matrices, @NotNull class_4597 vertexConsumers, int light) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Intrinsics.checkNotNullParameter((Object)matrices, (String)"matrices");
        Intrinsics.checkNotNullParameter((Object)vertexConsumers, (String)"vertexConsumers");
        class_4587 $this$entry$iv = matrices;
        boolean $i$f$entry = false;
        $this$entry$iv.method_22903();
        class_4587 $this$render_u24lambda_u240 = $this$entry$iv;
        boolean bl = false;
        $this$render_u24lambda_u240.method_22905(-1.0f, -1.0f, 1.0f);
        $this$render_u24lambda_u240.method_22904(0.0, -2.5, 0.0);
        float animationProgress = (float)entity.field_6012 + tickDelta;
        float punchYaw = entity.getPunchYaw().update(animationProgress);
        float punchDistance = entity.getPunchDistance().update(animationProgress);
        $this$render_u24lambda_u240.method_22907(class_7833.field_40716.rotation(punchYaw));
        $this$render_u24lambda_u240.method_22907(class_7833.field_40714.rotation(punchDistance * -((float)Math.sin((entity.getPunchTime() + tickDelta) * 0.2f))));
        $this$render_u24lambda_u240.method_22907(class_7833.field_40716.rotation(-punchYaw));
        $this$render_u24lambda_u240.method_22904(0.0, 2.5, 0.0);
        $this$render_u24lambda_u240.method_22904(0.0, -2.501, -0.0);
        this.modelPart.method_22698(matrices, vertexConsumers.getBuffer(class_1921.method_23576((class_2960)this.getTexture(entity))), light, class_4608.field_21444);
        $this$entry$iv.method_22909();
    }

    @NotNull
    public class_2960 getTexture(@NotNull HangingCocoonEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return (Boolean)entity.method_5841().method_12789(HangingCocoonEntity.Companion.getBROKEN()) != false ? BROKEN_TEXTURE : TEXTURE;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u000e"}, d2={"Ldev/mim1q/derelict/client/render/entity/nonliving/HangingCocoonEntityRenderer$Companion;", "", "<init>", "()V", "Lnet/minecraft/class_5607;", "createTexturedModelData", "()Lnet/minecraft/class_5607;", "Lnet/minecraft/class_2960;", "TEXTURE", "Lnet/minecraft/class_2960;", "getTEXTURE", "()Lnet/minecraft/class_2960;", "BROKEN_TEXTURE", "getBROKEN_TEXTURE", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final class_2960 getTEXTURE() {
            return TEXTURE;
        }

        @NotNull
        public final class_2960 getBROKEN_TEXTURE() {
            return BROKEN_TEXTURE;
        }

        @NotNull
        public final class_5607 createTexturedModelData() {
            class_5610 class_56102;
            class_5610 class_56103;
            class_5609 it = new class_5609();
            boolean bl = false;
            class_5610 $this$createTexturedModelData_u24lambda_u242_u24lambda_u241 = class_56103 = it.method_32111();
            boolean bl2 = false;
            class_5610 $this$createTexturedModelData_u24lambda_u242_u24lambda_u241_u24lambda_u240 = class_56102 = $this$createTexturedModelData_u24lambda_u242_u24lambda_u241.method_32117("root", class_5606.method_32108().method_32101(0, -10).method_32097(-5.0f, 4.0f, -5.0f, 0.0f, 28.0f, 10.0f).method_32101(20, -10).method_32097(5.0f, 4.0f, -5.0f, 0.0f, 28.0f, 10.0f).method_32101(20, 28).method_32097(-5.0f, 4.0f, 5.0f, 10.0f, 28.0f, 0.0f).method_32101(30, 18).method_32097(-5.0f, 4.0f, -5.0f, 10.0f, 0.0f, 10.0f).method_32101(30, 28).method_32097(-5.0f, 32.0f, -5.0f, 10.0f, 0.0f, 10.0f).method_32101(0, 28).method_32097(-5.0f, 4.0f, -5.0f, 10.0f, 28.0f, 0.0f), class_5603.method_32090((float)0.0f, (float)8.0f, (float)0.0f));
            boolean bl3 = false;
            $this$createTexturedModelData_u24lambda_u242_u24lambda_u241_u24lambda_u240.method_32117("cube_r1", class_5606.method_32108().method_32101(48, 12).method_32097(-1.0f, 2.0f, 0.0f, 1.0f, 6.0f, 0.0f).method_32101(40, 0).method_32097(-5.0f, 7.0f, 0.0f, 10.0f, 6.0f, 0.0f), class_5603.method_32091((float)0.0f, (float)-9.0f, (float)0.0f, (float)0.0f, (float)-1.1345f, (float)0.0f));
            $this$createTexturedModelData_u24lambda_u242_u24lambda_u241_u24lambda_u240.method_32117("cube_r2", class_5606.method_32108().method_32101(40, 6).method_32097(-5.0f, 2.0f, 0.0f, 10.0f, 6.0f, 0.0f), class_5603.method_32091((float)0.0f, (float)-4.0f, (float)0.0f, (float)0.0f, (float)0.48f, (float)0.0f));
            class_5607 class_56072 = class_5607.method_32110((class_5609)it, (int)64, (int)64);
            Intrinsics.checkNotNullExpressionValue((Object)class_56072, (String)"let(...)");
            return class_56072;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

