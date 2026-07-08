/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1297
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_2960
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_4608
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_7833
 *  net.minecraft.class_811
 *  net.minecraft.class_897
 *  net.minecraft.class_918
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.client.render.entity.projectile;

import dev.mim1q.derelict.entity.projectile.SpiderSilkBolaProjectile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1297;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_4608;
import net.minecraft.class_5617;
import net.minecraft.class_7833;
import net.minecraft.class_811;
import net.minecraft.class_897;
import net.minecraft.class_918;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J?\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0019\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\n \u0018*\u0004\u0018\u00010\u001b0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006\u001e"}, d2={"Ldev/mim1q/derelict/client/render/entity/projectile/SpiderSilkBolaRenderer;", "Lnet/minecraft/class_897;", "Ldev/mim1q/derelict/entity/projectile/SpiderSilkBolaProjectile;", "Lnet/minecraft/class_5617$class_5618;", "context", "<init>", "(Lnet/minecraft/class_5617$class_5618;)V", "entity", "", "yaw", "tickDelta", "Lnet/minecraft/class_4587;", "matrices", "Lnet/minecraft/class_4597;", "vertexConsumers", "", "light", "", "render", "(Ldev/mim1q/derelict/entity/projectile/SpiderSilkBolaProjectile;FFLnet/minecraft/class_4587;Lnet/minecraft/class_4597;I)V", "Lnet/minecraft/class_2960;", "getTexture", "(Ldev/mim1q/derelict/entity/projectile/SpiderSilkBolaProjectile;)Lnet/minecraft/class_2960;", "Lnet/minecraft/class_918;", "kotlin.jvm.PlatformType", "itemRenderer", "Lnet/minecraft/class_918;", "Lnet/minecraft/class_1799;", "stack", "Lnet/minecraft/class_1799;", "derelict"})
@SourceDebugExtension(value={"SMAP\nSpiderSilkBolaRenderer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpiderSilkBolaRenderer.kt\ndev/mim1q/derelict/client/render/entity/projectile/SpiderSilkBolaRenderer\n+ 2 RenderUtil.kt\ndev/mim1q/derelict/util/render/RenderUtilKt\n*L\n1#1,54:1\n12#2,4:55\n*S KotlinDebug\n*F\n+ 1 SpiderSilkBolaRenderer.kt\ndev/mim1q/derelict/client/render/entity/projectile/SpiderSilkBolaRenderer\n*L\n33#1:55,4\n*E\n"})
public final class SpiderSilkBolaRenderer
extends class_897<SpiderSilkBolaProjectile> {
    private final class_918 itemRenderer;
    private final class_1799 stack;

    public SpiderSilkBolaRenderer(@NotNull class_5617.class_5618 context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        super(context);
        this.itemRenderer = context.method_32168();
        this.stack = class_1802.field_8786.method_7854();
    }

    public void render(@NotNull SpiderSilkBolaProjectile entity, float yaw, float tickDelta, @NotNull class_4587 matrices, @NotNull class_4597 vertexConsumers, int light) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Intrinsics.checkNotNullParameter((Object)matrices, (String)"matrices");
        Intrinsics.checkNotNullParameter((Object)vertexConsumers, (String)"vertexConsumers");
        if ((float)entity.field_6012 + tickDelta < 1.5f) {
            return;
        }
        super.method_3936((class_1297)entity, yaw, tickDelta, matrices, vertexConsumers, light);
        class_4587 $this$entry$iv = matrices;
        boolean $i$f$entry = false;
        $this$entry$iv.method_22903();
        class_4587 $this$render_u24lambda_u240 = $this$entry$iv;
        boolean bl = false;
        $this$render_u24lambda_u240.method_22904(0.0, 0.5, 0.0);
        $this$render_u24lambda_u240.method_22907(class_7833.field_40716.rotationDegrees(180.0f + entity.method_36454()));
        $this$render_u24lambda_u240.method_22907(class_7833.field_40714.rotationDegrees(entity.method_36455()));
        this.itemRenderer.method_23177(null, this.stack, class_811.field_4315, false, matrices, vertexConsumers, entity.method_37908(), light, class_4608.field_21444, 0);
        $this$entry$iv.method_22909();
    }

    @NotNull
    public class_2960 getTexture(@NotNull SpiderSilkBolaProjectile entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return new class_2960("textures/item/cobweb.png");
    }
}

