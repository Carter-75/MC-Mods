/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1309
 *  net.minecraft.class_2960
 *  net.minecraft.class_3883
 *  net.minecraft.class_3887
 *  net.minecraft.class_4587
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_583
 *  net.minecraft.class_630
 *  net.minecraft.class_927
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.client.render.entity.boss.arachne;

import dev.mim1q.derelict.Derelict;
import dev.mim1q.derelict.client.render.entity.boss.arachne.ArachneEntityModel;
import dev.mim1q.derelict.client.render.entity.spider.SpiderRenderUtilsKt;
import dev.mim1q.derelict.entity.boss.ArachneEntity;
import dev.mim1q.derelict.init.client.ModRender;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1309;
import net.minecraft.class_2960;
import net.minecraft.class_3883;
import net.minecraft.class_3887;
import net.minecraft.class_4587;
import net.minecraft.class_5617;
import net.minecraft.class_583;
import net.minecraft.class_630;
import net.minecraft.class_927;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J7\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0014\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0002H\u0014\u00a2\u0006\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0018"}, d2={"Ldev/mim1q/derelict/client/render/entity/boss/arachne/ArachneEntityRenderer;", "Lnet/minecraft/class_927;", "Ldev/mim1q/derelict/entity/boss/ArachneEntity;", "Ldev/mim1q/derelict/client/render/entity/boss/arachne/ArachneEntityModel;", "Lnet/minecraft/class_5617$class_5618;", "ctx", "<init>", "(Lnet/minecraft/class_5617$class_5618;)V", "entity", "Lnet/minecraft/class_4587;", "matrices", "", "animationProgress", "bodyYaw", "tickDelta", "", "setupTransforms", "(Ldev/mim1q/derelict/entity/boss/ArachneEntity;Lnet/minecraft/class_4587;FFF)V", "Lnet/minecraft/class_2960;", "getTexture", "(Ldev/mim1q/derelict/entity/boss/ArachneEntity;)Lnet/minecraft/class_2960;", "getLyingAngle", "(Ldev/mim1q/derelict/entity/boss/ArachneEntity;)F", "Companion", "derelict"})
public final class ArachneEntityRenderer
extends class_927<ArachneEntity, ArachneEntityModel> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final class_2960 TEXTURE = Derelict.INSTANCE.id("textures/entity/boss/arachne.png");

    public ArachneEntityRenderer(@NotNull class_5617.class_5618 ctx) {
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        class_630 class_6302 = ctx.method_32167(ModRender.INSTANCE.getARACHNE_LAYER());
        Intrinsics.checkNotNullExpressionValue((Object)class_6302, (String)"getPart(...)");
        super(ctx, (class_583)new ArachneEntityModel(class_6302), 1.5f);
        this.method_4046((class_3887)SpiderRenderUtilsKt.createEyesFeatureRenderer((class_3883)this, TEXTURE));
    }

    protected void setupTransforms(@NotNull ArachneEntity entity, @NotNull class_4587 matrices, float animationProgress, float bodyYaw, float tickDelta) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Intrinsics.checkNotNullParameter((Object)matrices, (String)"matrices");
        super.method_4058((class_1309)entity, matrices, animationProgress, bodyYaw, tickDelta);
        float scale = entity.getScale();
        matrices.method_22905(scale, scale, scale);
    }

    @NotNull
    public class_2960 getTexture(@NotNull ArachneEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return TEXTURE;
    }

    protected float getLyingAngle(@NotNull ArachneEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return 0.0f;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Ldev/mim1q/derelict/client/render/entity/boss/arachne/ArachneEntityRenderer$Companion;", "", "<init>", "()V", "Lnet/minecraft/class_2960;", "TEXTURE", "Lnet/minecraft/class_2960;", "getTEXTURE", "()Lnet/minecraft/class_2960;", "derelict"})
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

