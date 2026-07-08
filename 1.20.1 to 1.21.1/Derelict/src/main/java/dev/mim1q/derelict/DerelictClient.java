/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  dev.mim1q.gimm1q.client.highlight.HighlightDrawer
 *  dev.mim1q.gimm1q.client.highlight.HighlightDrawerCallback
 *  dev.mim1q.gimm1q.client.highlight.HighlightDrawerCallback$HighlightDrawerContext
 *  dev.mim1q.gimm1q.client.item.handheld.HandheldItemModelRegistry
 *  dev.mim1q.gimm1q.interpolation.Easing
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.internal.SpreadBuilder
 *  net.fabricmc.api.ClientModInitializer
 *  net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin
 *  net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin$Context
 *  net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback
 *  net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback
 *  net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback$RegistrationHelper
 *  net.minecraft.class_1299
 *  net.minecraft.class_1309
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_3532
 *  net.minecraft.class_3887
 *  net.minecraft.class_4184
 *  net.minecraft.class_5272
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_583
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 *  net.minecraft.class_922
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.mim1q.derelict.Derelict;
import dev.mim1q.derelict.client.render.block.SpiderEggClusterRenderer;
import dev.mim1q.derelict.client.render.effect.SpiderWebModelFeature;
import dev.mim1q.derelict.client.render.entity.spider.ArachneEggRenderer;
import dev.mim1q.derelict.config.DerelictClientConfig;
import dev.mim1q.derelict.config.DerelictConfigs;
import dev.mim1q.derelict.init.ModBlocksAndItems;
import dev.mim1q.derelict.init.ModParticles;
import dev.mim1q.derelict.init.ModStatusEffects;
import dev.mim1q.derelict.init.client.ModRender;
import dev.mim1q.derelict.init.component.ModCardinalComponents;
import dev.mim1q.derelict.interfaces.AbstractBlockAccessor;
import dev.mim1q.derelict.item.CrosshairTipItem;
import dev.mim1q.derelict.util.BlockMarkerUtils;
import dev.mim1q.gimm1q.client.highlight.HighlightDrawer;
import dev.mim1q.gimm1q.client.highlight.HighlightDrawerCallback;
import dev.mim1q.gimm1q.client.item.handheld.HandheldItemModelRegistry;
import dev.mim1q.gimm1q.interpolation.Easing;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.SpreadBuilder;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_3887;
import net.minecraft.class_4184;
import net.minecraft.class_5272;
import net.minecraft.class_5617;
import net.minecraft.class_583;
import net.minecraft.class_638;
import net.minecraft.class_746;
import net.minecraft.class_922;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0003R\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2={"Ldev/mim1q/derelict/DerelictClient;", "Lnet/fabricmc/api/ClientModInitializer;", "<init>", "()V", "", "onInitializeClient", "Ldev/mim1q/derelict/config/DerelictClientConfig;", "CLIENT_CONFIG", "Ldev/mim1q/derelict/config/DerelictClientConfig;", "getCLIENT_CONFIG", "()Ldev/mim1q/derelict/config/DerelictClientConfig;", "derelict"})
@SourceDebugExtension(value={"SMAP\nDerelictClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DerelictClient.kt\ndev/mim1q/derelict/DerelictClient\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,161:1\n1863#2,2:162\n1863#2,2:164\n*S KotlinDebug\n*F\n+ 1 DerelictClient.kt\ndev/mim1q/derelict/DerelictClient\n*L\n60#1:162,2\n127#1:164,2\n*E\n"})
public final class DerelictClient
implements ClientModInitializer {
    @NotNull
    public static final DerelictClient INSTANCE = new DerelictClient();
    @NotNull
    private static final DerelictClientConfig CLIENT_CONFIG;

    private DerelictClient() {
    }

    @NotNull
    public final DerelictClientConfig getCLIENT_CONFIG() {
        return CLIENT_CONFIG;
    }

    public void onInitializeClient() {
        CLIENT_CONFIG.save();
        ModRender.INSTANCE.init();
        ModParticles.INSTANCE.initClient();
        HudRenderCallback.EVENT.register(DerelictClient::onInitializeClient$lambda$2);
        class_2960[] class_2960Array = new class_2960[]{Derelict.INSTANCE.id("textures/gui/effect/spider_web_gui_sparse.png"), Derelict.INSTANCE.id("textures/gui/effect/spider_web_gui.png"), Derelict.INSTANCE.id("textures/gui/effect/spider_web_gui_dense.png")};
        class_2960[] hudWebTextures = class_2960Array;
        HudRenderCallback.EVENT.register((arg_0, arg_1) -> DerelictClient.onInitializeClient$lambda$3(hudWebTextures, arg_0, arg_1));
        HighlightDrawerCallback.EVENT.register(DerelictClient::onInitializeClient$lambda$5);
        LivingEntityFeatureRendererRegistrationCallback.EVENT.register(DerelictClient::onInitializeClient$lambda$6);
        ModelLoadingPlugin.register(DerelictClient::onInitializeClient$lambda$7);
        class_5272.method_27879((class_1792)ModBlocksAndItems.INSTANCE.getARACHNICANNON(), (class_2960)Derelict.INSTANCE.id("targeting"), DerelictClient::onInitializeClient$lambda$8);
        HandheldItemModelRegistry.getInstance().register((class_1792)ModBlocksAndItems.INSTANCE.getARACHNICANNON(), Derelict.INSTANCE.id("arachnicannon_hand"));
    }

    /*
     * WARNING - void declaration
     */
    private static final void onInitializeClient$lambda$2(class_332 context, float f) {
        class_746 class_7462 = class_310.method_1551().field_1724;
        if (class_7462 != null) {
            class_746 player = class_7462;
            boolean bl = false;
            Object[] objectArray = new class_1792[]{player.method_6047().method_7909(), player.method_6079().method_7909()};
            List list = CollectionsKt.listOf((Object[])objectArray);
            if (list != null) {
                void $this$forEach$iv;
                Iterable iterable = list;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    class_1792 item = (class_1792)element$iv;
                    boolean bl2 = false;
                    if ((item == null || !(item instanceof CrosshairTipItem)) && !Intrinsics.areEqual((Object)item, (Object)class_1802.field_20414)) continue;
                    Intrinsics.checkNotNull((Object)context);
                    Intrinsics.checkNotNull((Object)item, (String)"null cannot be cast to non-null type dev.mim1q.derelict.item.CrosshairTipItem");
                    BlockMarkerUtils.INSTANCE.renderCrosshairTip(context, (CrosshairTipItem)item);
                    return;
                }
            }
        }
    }

    private static final void onInitializeClient$drawFullScreenTexture(class_332 $this$onInitializeClient_u24drawFullScreenTexture, class_2960 texture, float ratio) {
        int windowHeight;
        int windowWidth = class_310.method_1551().method_22683().method_4486();
        boolean isHorizontal = (float)windowWidth / (float)(windowHeight = class_310.method_1551().method_22683().method_4502()) > ratio;
        int width = isHorizontal ? windowWidth : (int)((float)windowHeight * ratio);
        int height = isHorizontal ? (int)((float)windowWidth / ratio) : windowHeight;
        RenderSystem.enableBlend();
        $this$onInitializeClient_u24drawFullScreenTexture.method_25290(texture, (windowWidth - width) / 2, (windowHeight - height) / 2, 0.0f, 0.0f, width, height, width, height);
    }

    private static final void onInitializeClient$lambda$3(class_2960[] $hudWebTextures, class_332 context, float f) {
        Intrinsics.checkNotNullParameter((Object)$hudWebTextures, (String)"$hudWebTextures");
        class_746 class_7462 = class_310.method_1551().field_1724;
        if (class_7462 == null) {
            return;
        }
        class_746 player = class_7462;
        class_4184 camera = class_310.method_1551().field_1773.method_19418();
        class_1937 world = player.method_37908();
        float light = Easing.lerp((float)(world.method_22349(camera.method_19328()) + 0.0625f), (float)1.0f, (float)0.2f);
        RenderSystem.setShaderColor((float)light, (float)light, (float)light, (float)1.0f);
        if (ModCardinalComponents.INSTANCE.hasClientSyncedEffect((class_1309)player, ModStatusEffects.INSTANCE.getCOBWEBBED())) {
            Integer n = ModCardinalComponents.INSTANCE.getClientSyncedEffectAmplifier((class_1309)player, ModStatusEffects.INSTANCE.getCOBWEBBED());
            int level = class_3532.method_15340((int)(n != null ? n : 0), (int)0, (int)2);
            Intrinsics.checkNotNull((Object)context);
            DerelictClient.onInitializeClient$drawFullScreenTexture(context, $hudWebTextures[level], 1.7777778f);
        }
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    private static final void onInitializeClient$lambda$5(HighlightDrawer drawer, HighlightDrawerCallback.HighlightDrawerContext ctx) {
        boolean aging;
        int range = CLIENT_CONFIG.waxableAndAgeableHightlightRange();
        if (range <= 0) {
            return;
        }
        class_1799 stack = ctx.player().method_6047();
        boolean waxing = CLIENT_CONFIG.waxableHighlights() && (stack.method_31574((class_1792)ModBlocksAndItems.INSTANCE.getWAXING_STAFF()) || stack.method_31574(class_1802.field_20414));
        boolean bl = aging = CLIENT_CONFIG.ageableHighlights() && stack.method_31574((class_1792)ModBlocksAndItems.INSTANCE.getAGING_STAFF());
        if (!aging && !waxing) {
            return;
        }
        class_1937 world = ctx.player().method_37908();
        float tickDelta = class_310.method_1551().method_1488();
        int opacity = (int)((float)Math.sin(((float)world.method_8510() + tickDelta) * 0.25f) * 32.0f + 32.0f);
        int color = opacity << 24 | 0xFCAD03;
        Iterable iterable = class_2338.method_25996((class_2338)ctx.player().method_24515(), (int)range, (int)range, (int)range);
        Intrinsics.checkNotNullExpressionValue((Object)iterable, (String)"iterateOutwards(...)");
        Iterable $this$forEach$iv = iterable;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            class_2338 it = (class_2338)element$iv;
            boolean bl2 = false;
            class_2248 class_22482 = world.method_8320(it).method_26204();
            Intrinsics.checkNotNull((Object)class_22482, (String)"null cannot be cast to non-null type dev.mim1q.derelict.interfaces.AbstractBlockAccessor");
            AbstractBlockAccessor block = (AbstractBlockAccessor)class_22482;
            if ((!aging || !block.isAgeable()) && (!waxing || !block.isWaxable())) continue;
            drawer.highlightBlock(it, color, -2130924285);
        }
    }

    private static final void onInitializeClient$lambda$6(class_1299 class_12992, class_922 entityRenderer, LivingEntityFeatureRendererRegistrationCallback.RegistrationHelper registrationHelper, class_5617.class_5618 class_56182) {
        if (entityRenderer != null) {
            registrationHelper.register((class_3887)new SpiderWebModelFeature((class_922<class_1309, class_583<class_1309>>)entityRenderer));
        }
    }

    private static final void onInitializeClient$lambda$7(ModelLoadingPlugin.Context ctx) {
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.addSpread((Object)SpiderEggClusterRenderer.Companion.getMODEL_IDS());
        spreadBuilder.addSpread((Object)ArachneEggRenderer.Companion.getMODEL_IDS());
        ctx.addModels((class_2960[])spreadBuilder.toArray((Object[])new class_2960[spreadBuilder.size()]));
    }

    private static final float onInitializeClient$lambda$8(class_1799 class_17992, class_638 class_6382, class_1309 livingEntity, int n) {
        class_1309 class_13092 = livingEntity;
        return (class_13092 != null ? class_13092.method_6115() : false) ? 1.0f : 0.0f;
    }

    static {
        DerelictClientConfig derelictClientConfig = DerelictConfigs.CLIENT_CONFIG;
        Intrinsics.checkNotNullExpressionValue((Object)((Object)derelictClientConfig), (String)"CLIENT_CONFIG");
        CLIENT_CONFIG = derelictClientConfig;
    }
}

