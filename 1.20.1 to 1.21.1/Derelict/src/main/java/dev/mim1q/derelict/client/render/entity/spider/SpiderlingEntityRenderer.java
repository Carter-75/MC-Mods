/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.mim1q.gimm1q.interpolation.Easing
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1308
 *  net.minecraft.class_1921
 *  net.minecraft.class_2338
 *  net.minecraft.class_2960
 *  net.minecraft.class_3883
 *  net.minecraft.class_3887
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_583
 *  net.minecraft.class_630
 *  net.minecraft.class_7833
 *  net.minecraft.class_927
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector2f
 */
package dev.mim1q.derelict.client.render.entity.spider;

import dev.mim1q.derelict.Derelict;
import dev.mim1q.derelict.client.render.entity.spider.SpiderRenderUtilsKt;
import dev.mim1q.derelict.client.render.entity.spider.SpiderlingModel;
import dev.mim1q.derelict.entity.SpiderlingEntity;
import dev.mim1q.derelict.init.client.ModRender;
import dev.mim1q.derelict.util.extensions.RenderExtensionsKt;
import dev.mim1q.gimm1q.interpolation.Easing;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1308;
import net.minecraft.class_1921;
import net.minecraft.class_2338;
import net.minecraft.class_2960;
import net.minecraft.class_3883;
import net.minecraft.class_3887;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_5617;
import net.minecraft.class_583;
import net.minecraft.class_630;
import net.minecraft.class_7833;
import net.minecraft.class_927;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2f;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ?\u0010\u0017\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0002H\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001c"}, d2={"Ldev/mim1q/derelict/client/render/entity/spider/SpiderlingEntityRenderer;", "Lnet/minecraft/class_927;", "Ldev/mim1q/derelict/entity/SpiderlingEntity;", "Ldev/mim1q/derelict/client/render/entity/spider/SpiderlingModel;", "Lnet/minecraft/class_5617$class_5618;", "context", "<init>", "(Lnet/minecraft/class_5617$class_5618;)V", "entity", "Lnet/minecraft/class_2960;", "getTexture", "(Ldev/mim1q/derelict/entity/SpiderlingEntity;)Lnet/minecraft/class_2960;", "mob", "", "f", "tickDelta", "Lnet/minecraft/class_4587;", "matrixStack", "Lnet/minecraft/class_4597;", "vertexConsumerProvider", "", "light", "", "render", "(Ldev/mim1q/derelict/entity/SpiderlingEntity;FFLnet/minecraft/class_4587;Lnet/minecraft/class_4597;I)V", "getLyingAngle", "(Ldev/mim1q/derelict/entity/SpiderlingEntity;)F", "Companion", "derelict"})
@SourceDebugExtension(value={"SMAP\nSpiderlingEntityRenderer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpiderlingEntityRenderer.kt\ndev/mim1q/derelict/client/render/entity/spider/SpiderlingEntityRenderer\n+ 2 RenderUtil.kt\ndev/mim1q/derelict/util/render/RenderUtilKt\n*L\n1#1,174:1\n12#2,4:175\n*S KotlinDebug\n*F\n+ 1 SpiderlingEntityRenderer.kt\ndev/mim1q/derelict/client/render/entity/spider/SpiderlingEntityRenderer\n*L\n54#1:175,4\n*E\n"})
public final class SpiderlingEntityRenderer
extends class_927<SpiderlingEntity, SpiderlingModel> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final class_2960 TEXTURE = Derelict.INSTANCE.id("textures/entity/spider/spiderling.png");
    @NotNull
    private static final class_2960 TEXTURE_PINK = Derelict.INSTANCE.id("textures/entity/spider/spiderling_pink.png");

    public SpiderlingEntityRenderer(@NotNull class_5617.class_5618 context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        class_630 class_6302 = context.method_32167(ModRender.INSTANCE.getSPIDERLING_LAYER());
        Intrinsics.checkNotNullExpressionValue((Object)class_6302, (String)"getPart(...)");
        super(context, (class_583)new SpiderlingModel(class_6302), 0.3f);
        this.method_4046((class_3887)SpiderRenderUtilsKt.createEyesFeatureRenderer((class_3883)this, TEXTURE));
    }

    @NotNull
    public class_2960 getTexture(@NotNull SpiderlingEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return entity instanceof SpiderlingEntity.Ally ? TEXTURE_PINK : TEXTURE;
    }

    public void render(@NotNull SpiderlingEntity mob, float f, float tickDelta, @NotNull class_4587 matrixStack, @NotNull class_4597 vertexConsumerProvider, int light) {
        Intrinsics.checkNotNullParameter((Object)((Object)mob), (String)"mob");
        Intrinsics.checkNotNullParameter((Object)matrixStack, (String)"matrixStack");
        Intrinsics.checkNotNullParameter((Object)vertexConsumerProvider, (String)"vertexConsumerProvider");
        super.method_4072((class_1308)mob, f, tickDelta, matrixStack, vertexConsumerProvider, light);
        if (mob.getAnchorPosition() == null) {
            return;
        }
        double yOffset = 0.65;
        class_4588 vertexConsumer = vertexConsumerProvider.getBuffer(class_1921.method_23576((class_2960)this.getTexture(mob)));
        class_2338 class_23382 = mob.getAnchorPosition();
        Intrinsics.checkNotNull((Object)class_23382);
        class_2338 anchor = class_23382;
        double x = (double)anchor.method_10263() + 0.5 - (double)Easing.lerp((float)((float)mob.field_6014), (float)((float)mob.method_23317()), (float)tickDelta);
        double y = (double)anchor.method_10264() - (double)Easing.lerp((float)((float)mob.field_6036), (float)((float)mob.method_23318()), (float)tickDelta) - yOffset;
        double z = (double)anchor.method_10260() + 0.5 - (double)Easing.lerp((float)((float)mob.field_5969), (float)((float)mob.method_23321()), (float)tickDelta);
        class_4587 $this$entry$iv = matrixStack;
        boolean $i$f$entry = false;
        $this$entry$iv.method_22903();
        class_4587 $this$render_u24lambda_u240 = $this$entry$iv;
        boolean bl = false;
        float distance = (float)Math.sqrt(x * x + y * y + z * z);
        float roll = (float)Math.atan2(y, Math.sqrt(x * x + z * z));
        float yaw = (float)Math.atan2(x, z) - 1.5707964f;
        $this$render_u24lambda_u240.method_22904(0.0, yOffset, 0.0);
        matrixStack.method_22907(class_7833.field_40716.rotation(yaw));
        matrixStack.method_22907(class_7833.field_40718.rotation(roll));
        matrixStack.method_22907(class_7833.field_40714.rotationDegrees(90.0f));
        $this$render_u24lambda_u240.method_22905(distance, 1.0f, 1.0f);
        Intrinsics.checkNotNull((Object)vertexConsumer);
        RenderExtensionsKt.drawBillboard(vertexConsumer, matrixStack, light, new Vector2f(0.0f, -0.03125f), new Vector2f(1.0f, 0.03125f), new Vector2f(0.5f, 0.0f), new Vector2f(1.0f, 0.03125f), 255, 255, 255, 255, true);
        $this$entry$iv.method_22909();
    }

    protected float getLyingAngle(@NotNull SpiderlingEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return entity.getAnchorPosition() != null ? 15.0f : 180.0f;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\b\u00a8\u0006\u000b"}, d2={"Ldev/mim1q/derelict/client/render/entity/spider/SpiderlingEntityRenderer$Companion;", "", "<init>", "()V", "Lnet/minecraft/class_2960;", "TEXTURE", "Lnet/minecraft/class_2960;", "getTEXTURE", "()Lnet/minecraft/class_2960;", "TEXTURE_PINK", "getTEXTURE_PINK", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final class_2960 getTEXTURE() {
            return TEXTURE;
        }

        @NotNull
        public final class_2960 getTEXTURE_PINK() {
            return TEXTURE_PINK;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

