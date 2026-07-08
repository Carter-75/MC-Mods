/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2960
 *  net.minecraft.class_3883
 *  net.minecraft.class_3887
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_583
 *  net.minecraft.class_630
 *  net.minecraft.class_927
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.client.render.entity.spider;

import dev.mim1q.derelict.Derelict;
import dev.mim1q.derelict.client.render.entity.spider.JumpingSpiderEntityModel;
import dev.mim1q.derelict.client.render.entity.spider.SpiderRenderUtilsKt;
import dev.mim1q.derelict.entity.spider.JumpingSpiderEntity;
import dev.mim1q.derelict.init.client.ModRender;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2960;
import net.minecraft.class_3883;
import net.minecraft.class_3887;
import net.minecraft.class_5617;
import net.minecraft.class_583;
import net.minecraft.class_630;
import net.minecraft.class_927;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2={"Ldev/mim1q/derelict/client/render/entity/spider/JumpingSpiderEntityRenderer;", "Lnet/minecraft/class_927;", "Ldev/mim1q/derelict/entity/spider/JumpingSpiderEntity;", "Ldev/mim1q/derelict/client/render/entity/spider/JumpingSpiderEntityModel;", "Lnet/minecraft/class_5617$class_5618;", "context", "<init>", "(Lnet/minecraft/class_5617$class_5618;)V", "entity", "Lnet/minecraft/class_2960;", "getTexture", "(Ldev/mim1q/derelict/entity/spider/JumpingSpiderEntity;)Lnet/minecraft/class_2960;", "Companion", "derelict"})
public final class JumpingSpiderEntityRenderer
extends class_927<JumpingSpiderEntity, JumpingSpiderEntityModel> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final class_2960 TEXTURE = Derelict.INSTANCE.id("textures/entity/spider/jumping_spider.png");

    public JumpingSpiderEntityRenderer(@NotNull class_5617.class_5618 context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        class_630 class_6302 = context.method_32167(ModRender.INSTANCE.getJUMPING_SPIDER_LAYER());
        Intrinsics.checkNotNullExpressionValue((Object)class_6302, (String)"getPart(...)");
        super(context, (class_583)new JumpingSpiderEntityModel(class_6302), 0.5f);
        this.method_4046((class_3887)SpiderRenderUtilsKt.createEyesFeatureRenderer((class_3883)this, TEXTURE));
    }

    @NotNull
    public class_2960 getTexture(@NotNull JumpingSpiderEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return TEXTURE;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Ldev/mim1q/derelict/client/render/entity/spider/JumpingSpiderEntityRenderer$Companion;", "", "<init>", "()V", "Lnet/minecraft/class_2960;", "TEXTURE", "Lnet/minecraft/class_2960;", "getTEXTURE", "()Lnet/minecraft/class_2960;", "derelict"})
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

