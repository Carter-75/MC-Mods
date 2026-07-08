/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2960
 *  net.minecraft.class_3532
 *  net.minecraft.class_3883
 *  net.minecraft.class_3887
 *  net.minecraft.class_4587
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_583
 *  net.minecraft.class_630
 *  net.minecraft.class_927
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.client.render.entity.spider;

import dev.mim1q.derelict.Derelict;
import dev.mim1q.derelict.client.render.entity.spider.SpiderRenderUtilsKt;
import dev.mim1q.derelict.client.render.entity.spider.SpinySpiderEntityModel;
import dev.mim1q.derelict.entity.spider.SpinySpiderEntity;
import dev.mim1q.derelict.init.client.ModRender;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2960;
import net.minecraft.class_3532;
import net.minecraft.class_3883;
import net.minecraft.class_3887;
import net.minecraft.class_4587;
import net.minecraft.class_5617;
import net.minecraft.class_583;
import net.minecraft.class_630;
import net.minecraft.class_927;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0014\u00a2\u0006\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0016"}, d2={"Ldev/mim1q/derelict/client/render/entity/spider/SpinySpiderEntityRenderer;", "Lnet/minecraft/class_927;", "Ldev/mim1q/derelict/entity/spider/SpinySpiderEntity;", "Ldev/mim1q/derelict/client/render/entity/spider/SpinySpiderEntityModel;", "Lnet/minecraft/class_5617$class_5618;", "context", "<init>", "(Lnet/minecraft/class_5617$class_5618;)V", "entity", "Lnet/minecraft/class_2960;", "getTexture", "(Ldev/mim1q/derelict/entity/spider/SpinySpiderEntity;)Lnet/minecraft/class_2960;", "Lnet/minecraft/class_4587;", "matrixStack", "", "f", "", "scale", "(Ldev/mim1q/derelict/entity/spider/SpinySpiderEntity;Lnet/minecraft/class_4587;F)V", "getAnimationCounter", "(Ldev/mim1q/derelict/entity/spider/SpinySpiderEntity;F)F", "Companion", "derelict"})
public final class SpinySpiderEntityRenderer
extends class_927<SpinySpiderEntity, SpinySpiderEntityModel> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final class_2960 TEXTURE = Derelict.INSTANCE.id("textures/entity/spider/spiny_spider.png");

    public SpinySpiderEntityRenderer(@NotNull class_5617.class_5618 context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        class_630 class_6302 = context.method_32167(ModRender.INSTANCE.getSPINY_SPIDER_LAYER());
        Intrinsics.checkNotNullExpressionValue((Object)class_6302, (String)"getPart(...)");
        super(context, (class_583)new SpinySpiderEntityModel(class_6302), 0.5f);
        this.method_4046((class_3887)SpiderRenderUtilsKt.createEyesFeatureRenderer((class_3883)this, TEXTURE));
    }

    @NotNull
    public class_2960 getTexture(@NotNull SpinySpiderEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return TEXTURE;
    }

    protected void scale(@NotNull SpinySpiderEntity entity, @NotNull class_4587 matrixStack, float f) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Intrinsics.checkNotNullParameter((Object)matrixStack, (String)"matrixStack");
        float g = entity.getFuse(f);
        float h = 1.0f + class_3532.method_15374((float)(g * 100.0f)) * g * 0.01f;
        g = class_3532.method_15363((float)g, (float)0.0f, (float)1.0f);
        g *= g;
        g *= g;
        float i = (1.0f + g * 0.4f) * h;
        float j = (1.0f + g * 0.1f) / h;
        matrixStack.method_22905(i, j, i);
    }

    protected float getAnimationCounter(@NotNull SpinySpiderEntity entity, float f) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        float g = entity.getFuse(f);
        return (int)(g * 10.0f) % 2 == 0 ? 0.0f : class_3532.method_15363((float)g, (float)0.5f, (float)1.0f);
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Ldev/mim1q/derelict/client/render/entity/spider/SpinySpiderEntityRenderer$Companion;", "", "<init>", "()V", "Lnet/minecraft/class_2960;", "TEXTURE", "Lnet/minecraft/class_2960;", "getTEXTURE", "()Lnet/minecraft/class_2960;", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final class_2960 getTEXTURE() {
            return TEXTURE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

