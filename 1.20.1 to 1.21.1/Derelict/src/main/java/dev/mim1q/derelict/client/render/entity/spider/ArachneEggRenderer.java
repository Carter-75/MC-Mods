/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1087
 *  net.minecraft.class_1092
 *  net.minecraft.class_1297
 *  net.minecraft.class_1921
 *  net.minecraft.class_1937
 *  net.minecraft.class_2960
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_5819
 *  net.minecraft.class_776
 *  net.minecraft.class_897
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.client.render.entity.spider;

import dev.mim1q.derelict.Derelict;
import dev.mim1q.derelict.entity.spider.ArachneEggEntity;
import dev.mim1q.derelict.util.render.RenderUtilKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1087;
import net.minecraft.class_1092;
import net.minecraft.class_1297;
import net.minecraft.class_1921;
import net.minecraft.class_1937;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_5617;
import net.minecraft.class_5819;
import net.minecraft.class_776;
import net.minecraft.class_897;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ?\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0019\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001c"}, d2={"Ldev/mim1q/derelict/client/render/entity/spider/ArachneEggRenderer;", "Lnet/minecraft/class_897;", "Ldev/mim1q/derelict/entity/spider/ArachneEggEntity;", "Lnet/minecraft/class_5617$class_5618;", "ctx", "<init>", "(Lnet/minecraft/class_5617$class_5618;)V", "entity", "Lnet/minecraft/class_2960;", "getTexture", "(Ldev/mim1q/derelict/entity/spider/ArachneEggEntity;)Lnet/minecraft/class_2960;", "", "yaw", "tickDelta", "Lnet/minecraft/class_4587;", "matrices", "Lnet/minecraft/class_4597;", "vertexConsumers", "", "light", "", "render", "(Ldev/mim1q/derelict/entity/spider/ArachneEggEntity;FFLnet/minecraft/class_4587;Lnet/minecraft/class_4597;I)V", "Lnet/minecraft/class_776;", "kotlin.jvm.PlatformType", "blockRenderManager", "Lnet/minecraft/class_776;", "Companion", "derelict"})
@SourceDebugExtension(value={"SMAP\nArachneEggRenderer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArachneEggRenderer.kt\ndev/mim1q/derelict/client/render/entity/spider/ArachneEggRenderer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 RenderUtil.kt\ndev/mim1q/derelict/util/render/RenderUtilKt\n*L\n1#1,60:1\n1#2:61\n12#3,4:62\n*S KotlinDebug\n*F\n+ 1 ArachneEggRenderer.kt\ndev/mim1q/derelict/client/render/entity/spider/ArachneEggRenderer\n*L\n35#1:62,4\n*E\n"})
public final class ArachneEggRenderer
extends class_897<ArachneEggEntity> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final class_776 blockRenderManager;
    @NotNull
    private static final class_2960[] MODEL_IDS;

    public ArachneEggRenderer(@NotNull class_5617.class_5618 ctx) {
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        super(ctx);
        this.blockRenderManager = ctx.method_43337();
    }

    @NotNull
    public class_2960 getTexture(@NotNull ArachneEggEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return Derelict.INSTANCE.id("none");
    }

    public void render(@NotNull ArachneEggEntity entity, float yaw, float tickDelta, @NotNull class_4587 matrices, @NotNull class_4597 vertexConsumers, int light) {
        class_2960 class_29602;
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Intrinsics.checkNotNullParameter((Object)matrices, (String)"matrices");
        Intrinsics.checkNotNullParameter((Object)vertexConsumers, (String)"vertexConsumers");
        super.method_3936((class_1297)entity, yaw, tickDelta, matrices, vertexConsumers, light);
        class_1937 world = entity.method_37908();
        class_1092 class_10922 = this.blockRenderManager.method_3351().method_3333();
        class_2960[] class_2960Array = MODEL_IDS;
        int n = entity.getStage();
        boolean bl = 0 <= n ? n < class_2960Array.length : false;
        if (bl) {
            class_29602 = class_2960Array[n];
        } else {
            int n2 = n;
            class_1092 class_10923 = class_10922;
            boolean bl2 = false;
            class_29602 = MODEL_IDS[0];
            class_10922 = class_10923;
        }
        class_1087 class_10872 = class_10922.getModel(class_29602);
        if (class_10872 == null) {
            return;
        }
        class_1087 model = class_10872;
        float time = entity.getAnimationTime(tickDelta) * 0.15f;
        class_4587 $this$entry$iv = matrices;
        boolean $i$f$entry = false;
        $this$entry$iv.method_22903();
        class_4587 $this$render_u24lambda_u241 = $this$entry$iv;
        boolean bl3 = false;
        $this$render_u24lambda_u241.method_22904(0.5, 0.0, 0.5);
        float xzScale = 0.9f + 0.05f * (float)Math.sin(time);
        float yScale = 0.9f + 0.07f * (float)Math.sin(time - 1.0f);
        $this$render_u24lambda_u241.method_22905(xzScale, yScale, xzScale);
        $this$render_u24lambda_u241.method_22904(-0.5 - 0.5 / (double)xzScale, 1.01, -0.5 - 0.5 / (double)xzScale);
        class_5819 class_58192 = world.field_9229;
        Intrinsics.checkNotNullExpressionValue((Object)class_58192, (String)"random");
        class_4588 class_45882 = vertexConsumers.getBuffer(class_1921.method_23581());
        Intrinsics.checkNotNullExpressionValue((Object)class_45882, (String)"getBuffer(...)");
        RenderUtilKt.render(model, class_58192, light, matrices, class_45882);
        $this$entry$iv.method_22909();
    }

    static {
        class_2960[] class_2960Array = new class_2960[]{Derelict.INSTANCE.id("block/special/arachne_egg"), Derelict.INSTANCE.id("block/special/arachne_egg_1"), Derelict.INSTANCE.id("block/special/arachne_egg_2"), Derelict.INSTANCE.id("block/special/arachne_egg_broken")};
        MODEL_IDS = class_2960Array;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2={"Ldev/mim1q/derelict/client/render/entity/spider/ArachneEggRenderer$Companion;", "", "<init>", "()V", "", "Lnet/minecraft/class_2960;", "MODEL_IDS", "[Lnet/minecraft/class_2960;", "getMODEL_IDS", "()[Lnet/minecraft/class_2960;", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final class_2960[] getMODEL_IDS() {
            return MODEL_IDS;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

