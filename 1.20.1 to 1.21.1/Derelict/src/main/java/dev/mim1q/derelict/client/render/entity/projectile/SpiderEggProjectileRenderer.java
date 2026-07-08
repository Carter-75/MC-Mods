/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1087
 *  net.minecraft.class_1297
 *  net.minecraft.class_1921
 *  net.minecraft.class_2960
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_5819
 *  net.minecraft.class_897
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.mim1q.derelict.client.render.entity.projectile;

import dev.mim1q.derelict.Derelict;
import dev.mim1q.derelict.entity.projectile.SpiderEggProjectile;
import dev.mim1q.derelict.util.render.RenderUtilKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1087;
import net.minecraft.class_1297;
import net.minecraft.class_1921;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_5617;
import net.minecraft.class_5819;
import net.minecraft.class_897;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J?\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0019\u001a\t\u0018\u00010\u0017\u00a2\u0006\u0002\b\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001d"}, d2={"Ldev/mim1q/derelict/client/render/entity/projectile/SpiderEggProjectileRenderer;", "Lnet/minecraft/class_897;", "Ldev/mim1q/derelict/entity/projectile/SpiderEggProjectile;", "Lnet/minecraft/class_5617$class_5618;", "ctx", "<init>", "(Lnet/minecraft/class_5617$class_5618;)V", "entity", "", "yaw", "tickDelta", "Lnet/minecraft/class_4587;", "matrices", "Lnet/minecraft/class_4597;", "vertexConsumers", "", "light", "", "render", "(Ldev/mim1q/derelict/entity/projectile/SpiderEggProjectile;FFLnet/minecraft/class_4587;Lnet/minecraft/class_4597;I)V", "Lnet/minecraft/class_2960;", "getTexture", "(Ldev/mim1q/derelict/entity/projectile/SpiderEggProjectile;)Lnet/minecraft/class_2960;", "Lnet/minecraft/class_1087;", "Lorg/jetbrains/annotations/Nullable;", "model", "Lnet/minecraft/class_1087;", "getModel", "()Lnet/minecraft/class_1087;", "derelict"})
@SourceDebugExtension(value={"SMAP\nSpiderEggProjectileRenderer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpiderEggProjectileRenderer.kt\ndev/mim1q/derelict/client/render/entity/projectile/SpiderEggProjectileRenderer\n+ 2 RenderUtil.kt\ndev/mim1q/derelict/util/render/RenderUtilKt\n*L\n1#1,32:1\n12#2,4:33\n*S KotlinDebug\n*F\n+ 1 SpiderEggProjectileRenderer.kt\ndev/mim1q/derelict/client/render/entity/projectile/SpiderEggProjectileRenderer\n*L\n26#1:33,4\n*E\n"})
public final class SpiderEggProjectileRenderer
extends class_897<SpiderEggProjectile> {
    @Nullable
    private final class_1087 model;

    public SpiderEggProjectileRenderer(@NotNull class_5617.class_5618 ctx) {
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        super(ctx);
        this.model = ctx.method_48481().getModel(Derelict.INSTANCE.id("block/spider_egg/huge_spider_egg"));
    }

    @Nullable
    public final class_1087 getModel() {
        return this.model;
    }

    public void render(@NotNull SpiderEggProjectile entity, float yaw, float tickDelta, @NotNull class_4587 matrices, @NotNull class_4597 vertexConsumers, int light) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Intrinsics.checkNotNullParameter((Object)matrices, (String)"matrices");
        Intrinsics.checkNotNullParameter((Object)vertexConsumers, (String)"vertexConsumers");
        super.method_3936((class_1297)entity, yaw, tickDelta, matrices, vertexConsumers, light);
        class_4587 $this$entry$iv = matrices;
        boolean $i$f$entry = false;
        $this$entry$iv.method_22903();
        class_4587 $this$render_u24lambda_u240 = $this$entry$iv;
        boolean bl = false;
        class_1087 class_10872 = this.model;
        if (class_10872 != null) {
            class_5819 class_58192 = entity.method_37908().field_9229;
            Intrinsics.checkNotNullExpressionValue((Object)class_58192, (String)"random");
            class_4588 class_45882 = vertexConsumers.getBuffer(class_1921.method_23577());
            Intrinsics.checkNotNullExpressionValue((Object)class_45882, (String)"getBuffer(...)");
            RenderUtilKt.render(class_10872, class_58192, light, matrices, class_45882);
        }
        $this$entry$iv.method_22909();
    }

    @NotNull
    public class_2960 getTexture(@NotNull SpiderEggProjectile entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return Derelict.INSTANCE.id("none");
    }
}

