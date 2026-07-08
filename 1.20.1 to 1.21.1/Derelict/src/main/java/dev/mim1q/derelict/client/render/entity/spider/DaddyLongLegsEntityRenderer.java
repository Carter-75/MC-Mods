/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  net.minecraft.class_1308
 *  net.minecraft.class_1767
 *  net.minecraft.class_1921
 *  net.minecraft.class_2960
 *  net.minecraft.class_3532
 *  net.minecraft.class_3883
 *  net.minecraft.class_3887
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597
 *  net.minecraft.class_4608
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_583
 *  net.minecraft.class_630
 *  net.minecraft.class_7833
 *  net.minecraft.class_927
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.client.render.entity.spider;

import dev.mim1q.derelict.Derelict;
import dev.mim1q.derelict.client.render.entity.spider.DaddyLongLegsEntityModel;
import dev.mim1q.derelict.client.render.entity.spider.SpiderRenderUtilsKt;
import dev.mim1q.derelict.entity.spider.DaddyLongLegsEntity;
import dev.mim1q.derelict.init.client.ModRender;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import net.minecraft.class_1308;
import net.minecraft.class_1767;
import net.minecraft.class_1921;
import net.minecraft.class_2960;
import net.minecraft.class_3532;
import net.minecraft.class_3883;
import net.minecraft.class_3887;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_4608;
import net.minecraft.class_5617;
import net.minecraft.class_583;
import net.minecraft.class_630;
import net.minecraft.class_7833;
import net.minecraft.class_927;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ?\u0010\u0017\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001a"}, d2={"Ldev/mim1q/derelict/client/render/entity/spider/DaddyLongLegsEntityRenderer;", "Lnet/minecraft/class_927;", "Ldev/mim1q/derelict/entity/spider/DaddyLongLegsEntity;", "Ldev/mim1q/derelict/client/render/entity/spider/DaddyLongLegsEntityModel;", "Lnet/minecraft/class_5617$class_5618;", "context", "<init>", "(Lnet/minecraft/class_5617$class_5618;)V", "entity", "Lnet/minecraft/class_2960;", "getTexture", "(Ldev/mim1q/derelict/entity/spider/DaddyLongLegsEntity;)Lnet/minecraft/class_2960;", "mobEntity", "", "f", "g", "Lnet/minecraft/class_4587;", "matrixStack", "Lnet/minecraft/class_4597;", "vertexConsumerProvider", "", "i", "", "render", "(Ldev/mim1q/derelict/entity/spider/DaddyLongLegsEntity;FFLnet/minecraft/class_4587;Lnet/minecraft/class_4597;I)V", "Companion", "derelict"})
@SourceDebugExtension(value={"SMAP\nDaddyLongLegsEntityRenderer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DaddyLongLegsEntityRenderer.kt\ndev/mim1q/derelict/client/render/entity/spider/DaddyLongLegsEntityRenderer\n+ 2 RenderUtil.kt\ndev/mim1q/derelict/util/render/RenderUtilKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,156:1\n12#2,4:157\n1279#3,2:161\n1293#3,4:163\n*S KotlinDebug\n*F\n+ 1 DaddyLongLegsEntityRenderer.kt\ndev/mim1q/derelict/client/render/entity/spider/DaddyLongLegsEntityRenderer\n*L\n40#1:157,4\n56#1:161,2\n56#1:163,4\n*E\n"})
public final class DaddyLongLegsEntityRenderer
extends class_927<DaddyLongLegsEntity, DaddyLongLegsEntityModel> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final class_2960 TEXTURE = Derelict.INSTANCE.id("textures/entity/spider/daddy_long_legs.png");
    @NotNull
    private static final Map<class_1767, class_2960> SOCK_TEXTURES;

    public DaddyLongLegsEntityRenderer(@NotNull class_5617.class_5618 context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        class_630 class_6302 = context.method_32167(ModRender.INSTANCE.getDADDY_LONG_LEGS_LAYER());
        Intrinsics.checkNotNullExpressionValue((Object)class_6302, (String)"getPart(...)");
        super(context, (class_583)new DaddyLongLegsEntityModel(class_6302), 0.5f);
        this.method_4046((class_3887)SpiderRenderUtilsKt.createEyesFeatureRenderer((class_3883)this, TEXTURE));
    }

    @NotNull
    public class_2960 getTexture(@NotNull DaddyLongLegsEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return TEXTURE;
    }

    public void render(@NotNull DaddyLongLegsEntity mobEntity, float f, float g, @NotNull class_4587 matrixStack, @NotNull class_4597 vertexConsumerProvider, int i) {
        Intrinsics.checkNotNullParameter((Object)((Object)mobEntity), (String)"mobEntity");
        Intrinsics.checkNotNullParameter((Object)matrixStack, (String)"matrixStack");
        Intrinsics.checkNotNullParameter((Object)vertexConsumerProvider, (String)"vertexConsumerProvider");
        super.method_4072((class_1308)mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
        class_1767 sockColor = mobEntity.getSockColor();
        if (sockColor == null || mobEntity.method_29504()) {
            return;
        }
        class_4587 $this$entry$iv = matrixStack;
        boolean $i$f$entry = false;
        $this$entry$iv.method_22903();
        class_4587 $this$render_u24lambda_u240 = $this$entry$iv;
        boolean bl = false;
        $this$render_u24lambda_u240.method_22905(-1.0f, -1.0f, 1.0f);
        $this$render_u24lambda_u240.method_22904(0.0, -1.501, 0.0);
        $this$render_u24lambda_u240.method_22907(class_7833.field_40716.rotationDegrees(180.0f + class_3532.method_17821((float)g, (float)mobEntity.field_6220, (float)mobEntity.field_6283)));
        DaddyLongLegsEntityModel daddyLongLegsEntityModel = (DaddyLongLegsEntityModel)this.method_4038();
        class_4588 class_45882 = vertexConsumerProvider.getBuffer(class_1921.method_23578((class_2960)SOCK_TEXTURES.get(sockColor)));
        Intrinsics.checkNotNullExpressionValue((Object)class_45882, (String)"getBuffer(...)");
        daddyLongLegsEntityModel.method_2828(matrixStack, class_45882, i, class_4608.field_21444, 1.0f, 1.0f, 1.0f, 1.0f);
        $this$entry$iv.method_22909();
    }

    /*
     * WARNING - void declaration
     */
    static {
        Iterable $this$associateWith$iv = (Iterable)EntriesMappings.entries$0;
        boolean $i$f$associateWith = false;
        LinkedHashMap result$iv = new LinkedHashMap(RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associateWith$iv, (int)10)), (int)16));
        Iterable $this$associateWithTo$iv$iv = $this$associateWith$iv;
        boolean $i$f$associateWithTo = false;
        for (Object element$iv$iv : $this$associateWithTo$iv$iv) {
            void it;
            class_1767 class_17672 = (class_1767)element$iv$iv;
            Object t = element$iv$iv;
            Map map = result$iv;
            boolean bl = false;
            class_2960 class_29602 = Derelict.INSTANCE.id("textures/entity/spider/sock/" + it.method_7792() + "_sock.png");
            map.put(t, class_29602);
        }
        SOCK_TEXTURES = result$iv;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR#\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2={"Ldev/mim1q/derelict/client/render/entity/spider/DaddyLongLegsEntityRenderer$Companion;", "", "<init>", "()V", "Lnet/minecraft/class_2960;", "TEXTURE", "Lnet/minecraft/class_2960;", "getTEXTURE", "()Lnet/minecraft/class_2960;", "", "Lnet/minecraft/class_1767;", "SOCK_TEXTURES", "Ljava/util/Map;", "getSOCK_TEXTURES", "()Ljava/util/Map;", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final class_2960 getTEXTURE() {
            return TEXTURE;
        }

        @NotNull
        public final Map<class_1767, class_2960> getSOCK_TEXTURES() {
            return SOCK_TEXTURES;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    public final class EntriesMappings {
        public static final /* synthetic */ EnumEntries<class_1767> entries$0;

        static {
            entries$0 = EnumEntriesKt.enumEntries((Enum[])((Enum[])class_1767.values()));
        }
    }
}

