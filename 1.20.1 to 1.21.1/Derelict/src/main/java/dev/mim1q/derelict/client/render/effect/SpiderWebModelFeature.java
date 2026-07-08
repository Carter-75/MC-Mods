/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.mim1q.gimm1q.client.render.overlay.ModelOverlayFeatureRenderer
 *  dev.mim1q.gimm1q.client.render.overlay.ModelOverlayVertexConsumer
 *  dev.mim1q.gimm1q.interpolation.Easing
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1309
 *  net.minecraft.class_1920
 *  net.minecraft.class_1921
 *  net.minecraft.class_2680
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_3883
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597
 *  net.minecraft.class_583
 *  net.minecraft.class_776
 *  net.minecraft.class_7833
 *  net.minecraft.class_922
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.client.render.effect;

import dev.mim1q.derelict.client.render.effect.SpiderWebModelFeatureKt;
import dev.mim1q.derelict.init.ModBlocksAndItems;
import dev.mim1q.derelict.init.ModStatusEffects;
import dev.mim1q.derelict.init.component.ModCardinalComponents;
import dev.mim1q.gimm1q.client.render.overlay.ModelOverlayFeatureRenderer;
import dev.mim1q.gimm1q.client.render.overlay.ModelOverlayVertexConsumer;
import dev.mim1q.gimm1q.interpolation.Easing;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1309;
import net.minecraft.class_1920;
import net.minecraft.class_1921;
import net.minecraft.class_2680;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3883;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_583;
import net.minecraft.class_776;
import net.minecraft.class_7833;
import net.minecraft.class_922;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001B!\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J_\u0010\u0017\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018\u00a8\u0006\u0019"}, d2={"Ldev/mim1q/derelict/client/render/effect/SpiderWebModelFeature;", "Ldev/mim1q/gimm1q/client/render/overlay/ModelOverlayFeatureRenderer;", "Lnet/minecraft/class_1309;", "Lnet/minecraft/class_583;", "Lnet/minecraft/class_922;", "context", "<init>", "(Lnet/minecraft/class_922;)V", "Lnet/minecraft/class_4587;", "matrices", "Lnet/minecraft/class_4597;", "vertexConsumers", "", "light", "entity", "", "limbAngle", "limbDistance", "tickDelta", "animationProgress", "headYaw", "headPitch", "", "render", "(Lnet/minecraft/class_4587;Lnet/minecraft/class_4597;ILnet/minecraft/class_1309;FFFFFF)V", "derelict"})
@SourceDebugExtension(value={"SMAP\nSpiderWebModelFeature.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpiderWebModelFeature.kt\ndev/mim1q/derelict/client/render/effect/SpiderWebModelFeature\n+ 2 RenderUtil.kt\ndev/mim1q/derelict/util/render/RenderUtilKt\n*L\n1#1,77:1\n12#2,2:78\n12#2,4:80\n14#2,2:84\n*S KotlinDebug\n*F\n+ 1 SpiderWebModelFeature.kt\ndev/mim1q/derelict/client/render/effect/SpiderWebModelFeature\n*L\n63#1:78,2\n67#1:80,4\n63#1:84,2\n*E\n"})
public final class SpiderWebModelFeature
extends ModelOverlayFeatureRenderer<class_1309, class_583<class_1309>> {
    public SpiderWebModelFeature(@NotNull class_922<class_1309, class_583<class_1309>> context) {
        Intrinsics.checkNotNullParameter(context, (String)"context");
        super((class_3883)context, SpiderWebModelFeature::_init_$lambda$0, SpiderWebModelFeature::_init_$lambda$1, true);
    }

    public void render(@NotNull class_4587 matrices, @NotNull class_4597 vertexConsumers, int light, @NotNull class_1309 entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        Intrinsics.checkNotNullParameter((Object)matrices, (String)"matrices");
        Intrinsics.checkNotNullParameter((Object)vertexConsumers, (String)"vertexConsumers");
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        super.render(matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch);
        if (!ModCardinalComponents.INSTANCE.hasClientSyncedEffect(entity, ModStatusEffects.INSTANCE.getCOBWEBBED())) {
            return;
        }
        class_776 blockRenderer = class_310.method_1551().method_1541();
        class_2680 cobweb = ModBlocksAndItems.INSTANCE.getCORNER_COBWEB().method_9564();
        class_4587 $this$entry$iv = matrices;
        boolean $i$f$entry = false;
        $this$entry$iv.method_22903();
        class_4587 $this$render_u24lambda_u244 = $this$entry$iv;
        boolean bl = false;
        $this$render_u24lambda_u244.method_22907(class_7833.field_40716.rotationDegrees(180.0f - Easing.lerp((float)entity.field_6220, (float)entity.field_6283, (float)tickDelta) + (float)(entity.method_5628() * 777)));
        if ((double)entity.method_17682() >= 0.7 && (double)entity.method_17681() <= 4.0) {
            int n = 3;
            int n2 = 0;
            while (n2 < n) {
                int it = n2++;
                boolean bl2 = false;
                $this$render_u24lambda_u244.method_22907(class_7833.field_40716.rotationDegrees(120.0f));
                class_4587 $this$entry$iv2 = matrices;
                boolean $i$f$entry2 = false;
                $this$entry$iv2.method_22903();
                class_4587 $this$render_u24lambda_u244_u24lambda_u243_u24lambda_u242 = $this$entry$iv2;
                boolean bl3 = false;
                $this$render_u24lambda_u244_u24lambda_u243_u24lambda_u242.method_22904(-0.5, 0.6, -0.45 * (double)(entity.method_17681() + (float)2));
                blockRenderer.method_3355(cobweb, entity.method_24515(), (class_1920)entity.method_37908(), matrices, vertexConsumers.getBuffer(class_1921.method_23581()), true, entity.method_37908().field_9229);
                $this$entry$iv2.method_22909();
            }
        }
        $this$entry$iv.method_22909();
    }

    private static final boolean _init_$lambda$0(class_1309 it) {
        Intrinsics.checkNotNull((Object)it);
        return ModCardinalComponents.INSTANCE.hasClientSyncedEffect(it, ModStatusEffects.INSTANCE.getCOBWEBBED());
    }

    private static final ModelOverlayVertexConsumer _init_$lambda$1(class_1309 entity, class_4597 vertexConsumers) {
        class_2960 class_29602;
        Integer n;
        Intrinsics.checkNotNull((Object)entity);
        Integer n2 = n = ModCardinalComponents.INSTANCE.getClientSyncedEffectAmplifier(entity, ModStatusEffects.INSTANCE.getCOBWEBBED());
        int n3 = 2;
        if (n2 != null && n2 == n3) {
            class_29602 = SpiderWebModelFeatureKt.getSPIDER_WEB_TEXTURE_DENSE();
        } else {
            Integer n4 = n;
            n3 = 1;
            class_29602 = n4 != null && n4 == n3 ? SpiderWebModelFeatureKt.getSPIDER_WEB_TEXTURE_MEDIUM() : SpiderWebModelFeatureKt.getSPIDER_WEB_TEXTURE_SPARSE();
        }
        class_2960 texture = class_29602;
        return ModelOverlayVertexConsumer.of((class_4588)vertexConsumers.getBuffer(class_1921.method_23576((class_2960)texture))).textureSize(64).offset(1.101f).skipPlanes();
    }
}

