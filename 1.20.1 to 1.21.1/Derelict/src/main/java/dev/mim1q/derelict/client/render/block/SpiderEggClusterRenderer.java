/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1087
 *  net.minecraft.class_1921
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_243
 *  net.minecraft.class_2960
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597
 *  net.minecraft.class_5614$class_5615
 *  net.minecraft.class_5819
 *  net.minecraft.class_7833
 *  net.minecraft.class_827
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.client.render.block;

import dev.mim1q.derelict.Derelict;
import dev.mim1q.derelict.block.cobweb.SpiderEggBlock;
import dev.mim1q.derelict.util.render.RenderUtilKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1087;
import net.minecraft.class_1921;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_243;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_5614;
import net.minecraft.class_5819;
import net.minecraft.class_7833;
import net.minecraft.class_827;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J?\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J7\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J7\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u001a\u0010\u0019JW\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\u001f\u0010 R\u001f\u0010$\u001a\r\u0012\t\u0012\u00070\"\u00a2\u0006\u0002\b#0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006'"}, d2={"Ldev/mim1q/derelict/client/render/block/SpiderEggClusterRenderer;", "Lnet/minecraft/class_827;", "Ldev/mim1q/derelict/block/cobweb/SpiderEggBlock$SpiderEggBlockEntity;", "Lnet/minecraft/class_5614$class_5615;", "ctx", "<init>", "(Lnet/minecraft/class_5614$class_5615;)V", "entity", "", "tickDelta", "Lnet/minecraft/class_4587;", "matrices", "Lnet/minecraft/class_4597;", "vertexConsumers", "", "light", "overlay", "", "render", "(Ldev/mim1q/derelict/block/cobweb/SpiderEggBlock$SpiderEggBlockEntity;FLnet/minecraft/class_4587;Lnet/minecraft/class_4597;II)V", "time", "Lnet/minecraft/class_5819;", "random", "consumers", "renderBig", "(FLnet/minecraft/class_5819;Lnet/minecraft/class_4587;Lnet/minecraft/class_4597;I)V", "renderCluster", "x", "y", "z", "index", "renderEgg", "(Lnet/minecraft/class_5819;Lnet/minecraft/class_4587;Lnet/minecraft/class_4597;IFFFIF)V", "", "Lnet/minecraft/class_1087;", "Lorg/jetbrains/annotations/Nullable;", "models", "Ljava/util/List;", "Companion", "derelict"})
@SourceDebugExtension(value={"SMAP\nSpiderEggClusterRenderer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpiderEggClusterRenderer.kt\ndev/mim1q/derelict/client/render/block/SpiderEggClusterRenderer\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,84:1\n11420#2,9:85\n13346#2:94\n13347#2:96\n11429#2:97\n1#3:95\n*S KotlinDebug\n*F\n+ 1 SpiderEggClusterRenderer.kt\ndev/mim1q/derelict/client/render/block/SpiderEggClusterRenderer\n*L\n27#1:85,9\n27#1:94\n27#1:96\n27#1:97\n27#1:95\n*E\n"})
public final class SpiderEggClusterRenderer
implements class_827<SpiderEggBlock.SpiderEggBlockEntity> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final List<class_1087> models;
    @NotNull
    private static final class_2960[] MODEL_IDS;

    /*
     * WARNING - void declaration
     */
    public SpiderEggClusterRenderer(@NotNull class_5614.class_5615 ctx) {
        void $this$mapNotNullTo$iv$iv;
        void $this$mapNotNull$iv;
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        class_2960[] class_2960Array = MODEL_IDS;
        SpiderEggClusterRenderer spiderEggClusterRenderer = this;
        boolean $i$f$mapNotNull = false;
        void var4_5 = $this$mapNotNull$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$mapNotNullTo = false;
        void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
        boolean $i$f$forEach = false;
        int n = ((void)$this$forEach$iv$iv$iv).length;
        for (int i = 0; i < n; ++i) {
            class_1087 it$iv$iv;
            void element$iv$iv$iv;
            void element$iv$iv = element$iv$iv$iv = $this$forEach$iv$iv$iv[i];
            boolean bl = false;
            void it = element$iv$iv;
            boolean bl2 = false;
            if (ctx.method_32141().method_3351().method_3333().getModel((class_2960)it) == null) continue;
            boolean bl3 = false;
            destination$iv$iv.add(it$iv$iv);
        }
        spiderEggClusterRenderer.models = (List)destination$iv$iv;
    }

    public void render(@NotNull SpiderEggBlock.SpiderEggBlockEntity entity, float tickDelta, @NotNull class_4587 matrices, @NotNull class_4597 vertexConsumers, int light, int overlay) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Intrinsics.checkNotNullParameter((Object)matrices, (String)"matrices");
        Intrinsics.checkNotNullParameter((Object)vertexConsumers, (String)"vertexConsumers");
        class_2248 block = entity.method_11010().method_26204();
        if (block instanceof SpiderEggBlock) {
            matrices.method_22904(0.5, 0.0, 0.5);
            matrices.method_22907(class_7833.field_40716.rotationDegrees((float)(entity.method_11016().hashCode() % 4) * 90.0f));
            matrices.method_22904(-0.5, 0.0, -0.5);
            class_1937 class_19372 = entity.method_10997();
            if (class_19372 == null || (class_19372 = class_19372.field_9229) == null) {
                return;
            }
            class_1937 random = class_19372;
            int addedTime = entity.method_11016().hashCode() % 100 * 777;
            class_1937 class_19373 = entity.method_10997();
            if (class_19373 == null) {
                return;
            }
            float time = (float)class_19373.method_8510() + tickDelta + (float)addedTime;
            if (((SpiderEggBlock)block).getBig()) {
                class_243 offset = entity.method_11010().method_26226((class_1922)entity.method_10997(), entity.method_11016());
                matrices.method_22904(offset.field_1352, offset.field_1351, offset.field_1350);
                this.renderBig(time, (class_5819)random, matrices, vertexConsumers, light);
            } else {
                this.renderCluster(time, (class_5819)random, matrices, vertexConsumers, light);
            }
        }
    }

    private final void renderBig(float time, class_5819 random, class_4587 matrices, class_4597 consumers, int light) {
        this.renderEgg(random, matrices, consumers, light, 0.5f, 0.0f, 0.5f, 4, time);
    }

    private final void renderCluster(float time, class_5819 random, class_4587 matrices, class_4597 consumers, int light) {
        this.renderEgg(random, matrices, consumers, light, 0.9f, 0.0f, 0.5f, 0, time);
        this.renderEgg(random, matrices, consumers, light, 0.1f, 0.0f, 0.1f, 1, time + (float)10);
        this.renderEgg(random, matrices, consumers, light, 0.5f, 0.0f, 0.8f, 2, time + (float)20);
        this.renderEgg(random, matrices, consumers, light, 0.7f, 0.0f, 0.3f, 3, time + (float)30);
    }

    private final void renderEgg(class_5819 random, class_4587 matrices, class_4597 consumers, int light, float x, float y, float z, int index, float time) {
        matrices.method_22903();
        matrices.method_46416(x, y, z);
        float scale = 0.9f + 0.15f * (float)Math.sin(time * 0.15f);
        matrices.method_22905(scale, scale, scale);
        class_4588 class_45882 = consumers.getBuffer(class_1921.method_23577());
        Intrinsics.checkNotNullExpressionValue((Object)class_45882, (String)"getBuffer(...)");
        RenderUtilKt.render(this.models.get(index), random, light, matrices, class_45882);
        matrices.method_22909();
    }

    static {
        class_2960[] class_2960Array = new class_2960[]{Derelict.INSTANCE.id("block/spider_egg/tiny_spider_egg"), Derelict.INSTANCE.id("block/spider_egg/small_spider_egg"), Derelict.INSTANCE.id("block/spider_egg/medium_spider_egg"), Derelict.INSTANCE.id("block/spider_egg/large_spider_egg"), Derelict.INSTANCE.id("block/spider_egg/huge_spider_egg")};
        MODEL_IDS = class_2960Array;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2={"Ldev/mim1q/derelict/client/render/block/SpiderEggClusterRenderer$Companion;", "", "<init>", "()V", "", "Lnet/minecraft/class_2960;", "MODEL_IDS", "[Lnet/minecraft/class_2960;", "getMODEL_IDS", "()[Lnet/minecraft/class_2960;", "derelict"})
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

