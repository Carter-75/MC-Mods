/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SpreadBuilder
 *  net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
 *  net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer
 *  net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
 *  net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry$TexturedModelDataProvider
 *  net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
 *  net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback
 *  net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback$RegistrationHelper
 *  net.minecraft.class_1299
 *  net.minecraft.class_1921
 *  net.minecraft.class_1935
 *  net.minecraft.class_2248
 *  net.minecraft.class_5601
 *  net.minecraft.class_5616
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_922
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.init.client;

import dev.mim1q.derelict.Derelict;
import dev.mim1q.derelict.client.render.armor.NetwalkersRenderer;
import dev.mim1q.derelict.client.render.block.SpiderEggClusterRenderer;
import dev.mim1q.derelict.client.render.entity.boss.arachne.ArachneEntityRenderer;
import dev.mim1q.derelict.client.render.entity.boss.arachne.ArachneTexturedModelData;
import dev.mim1q.derelict.client.render.entity.nonliving.HangingCocoonEntityRenderer;
import dev.mim1q.derelict.client.render.entity.projectile.SpiderEggProjectileRenderer;
import dev.mim1q.derelict.client.render.entity.projectile.SpiderSilkBolaRenderer;
import dev.mim1q.derelict.client.render.entity.spider.ArachneEggRenderer;
import dev.mim1q.derelict.client.render.entity.spider.CharmingSpiderEntityModel;
import dev.mim1q.derelict.client.render.entity.spider.CharmingSpiderEntityRenderer;
import dev.mim1q.derelict.client.render.entity.spider.DaddyLongLegsEntityModel;
import dev.mim1q.derelict.client.render.entity.spider.DaddyLongLegsEntityRenderer;
import dev.mim1q.derelict.client.render.entity.spider.JumpingSpiderEntityModel;
import dev.mim1q.derelict.client.render.entity.spider.JumpingSpiderEntityRenderer;
import dev.mim1q.derelict.client.render.entity.spider.SpiderlingEntityRenderer;
import dev.mim1q.derelict.client.render.entity.spider.SpiderlingEntityRendererKt;
import dev.mim1q.derelict.client.render.entity.spider.SpinySpiderEntityModel;
import dev.mim1q.derelict.client.render.entity.spider.SpinySpiderEntityRenderer;
import dev.mim1q.derelict.client.render.entity.spider.WebCasterEntityModel;
import dev.mim1q.derelict.client.render.entity.spider.WebCasterEntityRenderer;
import dev.mim1q.derelict.init.ModBlockEntities;
import dev.mim1q.derelict.init.ModBlocksAndItems;
import dev.mim1q.derelict.init.ModEntities;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.class_1299;
import net.minecraft.class_1921;
import net.minecraft.class_1935;
import net.minecraft.class_2248;
import net.minecraft.class_5601;
import net.minecraft.class_5616;
import net.minecraft.class_5617;
import net.minecraft.class_922;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ)\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u001b\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R\u0017\u0010\u001d\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0018R\u0017\u0010!\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010\u0018R\u0017\u0010#\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u0016\u001a\u0004\b$\u0010\u0018R\u0017\u0010%\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u0018R\u0017\u0010'\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b'\u0010\u0016\u001a\u0004\b(\u0010\u0018\u00a8\u0006)"}, d2={"Ldev/mim1q/derelict/init/client/ModRender;", "", "<init>", "()V", "", "init", "Lnet/minecraft/class_5617$class_5618;", "context", "initArmor", "(Lnet/minecraft/class_5617$class_5618;)V", "Lnet/fabricmc/fabric/api/client/rendering/v1/EntityModelLayerRegistry$TexturedModelDataProvider;", "provider", "", "path", "name", "Lnet/minecraft/class_5601;", "registerLayer", "(Lnet/fabricmc/fabric/api/client/rendering/v1/EntityModelLayerRegistry$TexturedModelDataProvider;Ljava/lang/String;Ljava/lang/String;)Lnet/minecraft/class_5601;", "", "customRenderersWorkaroundInit", "Z", "ARACHNE_LAYER", "Lnet/minecraft/class_5601;", "getARACHNE_LAYER", "()Lnet/minecraft/class_5601;", "SPIDERLING_LAYER", "getSPIDERLING_LAYER", "CHARMING_SPIDER_LAYER", "getCHARMING_SPIDER_LAYER", "WEB_CASTER_LAYER", "getWEB_CASTER_LAYER", "DADDY_LONG_LEGS_LAYER", "getDADDY_LONG_LEGS_LAYER", "JUMPING_SPIDER_LAYER", "getJUMPING_SPIDER_LAYER", "SPINY_SPIDER_LAYER", "getSPINY_SPIDER_LAYER", "HANGING_COCOON_LAYER", "getHANGING_COCOON_LAYER", "NETWALKERS_LAYER", "getNETWALKERS_LAYER", "derelict"})
public final class ModRender {
    @NotNull
    public static final ModRender INSTANCE = new ModRender();
    private static boolean customRenderersWorkaroundInit;
    @NotNull
    private static final class_5601 ARACHNE_LAYER;
    @NotNull
    private static final class_5601 SPIDERLING_LAYER;
    @NotNull
    private static final class_5601 CHARMING_SPIDER_LAYER;
    @NotNull
    private static final class_5601 WEB_CASTER_LAYER;
    @NotNull
    private static final class_5601 DADDY_LONG_LEGS_LAYER;
    @NotNull
    private static final class_5601 JUMPING_SPIDER_LAYER;
    @NotNull
    private static final class_5601 SPINY_SPIDER_LAYER;
    @NotNull
    private static final class_5601 HANGING_COCOON_LAYER;
    @NotNull
    private static final class_5601 NETWALKERS_LAYER;

    private ModRender() {
    }

    @NotNull
    public final class_5601 getARACHNE_LAYER() {
        return ARACHNE_LAYER;
    }

    @NotNull
    public final class_5601 getSPIDERLING_LAYER() {
        return SPIDERLING_LAYER;
    }

    @NotNull
    public final class_5601 getCHARMING_SPIDER_LAYER() {
        return CHARMING_SPIDER_LAYER;
    }

    @NotNull
    public final class_5601 getWEB_CASTER_LAYER() {
        return WEB_CASTER_LAYER;
    }

    @NotNull
    public final class_5601 getDADDY_LONG_LEGS_LAYER() {
        return DADDY_LONG_LEGS_LAYER;
    }

    @NotNull
    public final class_5601 getJUMPING_SPIDER_LAYER() {
        return JUMPING_SPIDER_LAYER;
    }

    @NotNull
    public final class_5601 getSPINY_SPIDER_LAYER() {
        return SPINY_SPIDER_LAYER;
    }

    @NotNull
    public final class_5601 getHANGING_COCOON_LAYER() {
        return HANGING_COCOON_LAYER;
    }

    @NotNull
    public final class_5601 getNETWALKERS_LAYER() {
        return NETWALKERS_LAYER;
    }

    public final void init() {
        class_1921 class_19212 = class_1921.method_23581();
        SpreadBuilder spreadBuilder = new SpreadBuilder(23);
        spreadBuilder.add((Object)ModBlocksAndItems.INSTANCE.getBURNED_WOOD().getTrapdoor());
        spreadBuilder.add((Object)ModBlocksAndItems.INSTANCE.getBURNED_WOOD().getDoor());
        spreadBuilder.add((Object)ModBlocksAndItems.INSTANCE.getBURNED_LEAVES());
        spreadBuilder.add((Object)ModBlocksAndItems.INSTANCE.getSMOLDERING_LEAVES());
        spreadBuilder.add((Object)ModBlocksAndItems.INSTANCE.getBURNED_GRASS().getGrassBlock());
        spreadBuilder.add((Object)ModBlocksAndItems.INSTANCE.getBURNED_GRASS().getGrass());
        spreadBuilder.add((Object)ModBlocksAndItems.INSTANCE.getBURNED_GRASS().getTallGrass());
        spreadBuilder.add((Object)ModBlocksAndItems.INSTANCE.getDRIED_GRASS().getGrassBlock());
        spreadBuilder.add((Object)ModBlocksAndItems.INSTANCE.getDRIED_GRASS().getGrass());
        spreadBuilder.add((Object)ModBlocksAndItems.INSTANCE.getDRIED_GRASS().getTallGrass());
        spreadBuilder.add((Object)ModBlocksAndItems.INSTANCE.getSMOLDERING_EMBERS());
        spreadBuilder.add((Object)ModBlocksAndItems.INSTANCE.getSMOKING_EMBERS());
        spreadBuilder.add((Object)ModBlocksAndItems.INSTANCE.getFLICKERING_LANTERN());
        spreadBuilder.add((Object)ModBlocksAndItems.INSTANCE.getFLICKERING_SOUL_LANTERN());
        spreadBuilder.add((Object)ModBlocksAndItems.INSTANCE.getEXTINGUISHED_LANTERN());
        spreadBuilder.add((Object)ModBlocksAndItems.INSTANCE.getFANCY_COBWEB());
        spreadBuilder.add((Object)ModBlocksAndItems.INSTANCE.getFANCY_COBWEB_WITH_SPIDER_NEST());
        spreadBuilder.add((Object)ModBlocksAndItems.INSTANCE.getFANCY_CORNER_COBWEB());
        spreadBuilder.add((Object)ModBlocksAndItems.INSTANCE.getCORNER_COBWEB());
        spreadBuilder.addSpread((Object)ModBlocksAndItems.INSTANCE.getNOCTISTEEL().getCutoutBlocks());
        spreadBuilder.add((Object)ModBlocksAndItems.INSTANCE.getWALL_COBWEB());
        spreadBuilder.add((Object)ModBlocksAndItems.INSTANCE.getSPIDER_SILK());
        spreadBuilder.add((Object)ModBlocksAndItems.INSTANCE.getSPIDER_SILK_STRAND());
        BlockRenderLayerMap.INSTANCE.putBlocks(class_19212, (class_2248[])spreadBuilder.toArray((Object[])new class_2248[spreadBuilder.size()]));
        class_5616.method_32144(ModBlockEntities.INSTANCE.getSPIDER_EGG_BLOCK_ENTITY(), SpiderEggClusterRenderer::new);
        EntityRendererRegistry.register(ModEntities.INSTANCE.getARACHNE(), ArachneEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.INSTANCE.getSPIDERLING(), SpiderlingEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.INSTANCE.getSPIDERLING_ALLY(), SpiderlingEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.INSTANCE.getCHARMING_SPIDER(), CharmingSpiderEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.INSTANCE.getWEB_CASTER(), WebCasterEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.INSTANCE.getDADDY_LONG_LEGS(), DaddyLongLegsEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.INSTANCE.getJUMPING_SPIDER(), JumpingSpiderEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.INSTANCE.getSPINY_SPIDER(), SpinySpiderEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.INSTANCE.getARACHNE_EGG(), ArachneEggRenderer::new);
        EntityRendererRegistry.register(ModEntities.INSTANCE.getSPIDER_SILK_BOLA(), SpiderSilkBolaRenderer::new);
        EntityRendererRegistry.register(ModEntities.INSTANCE.getSPIDER_EGG_PROJECTILE(), SpiderEggProjectileRenderer::new);
        LivingEntityFeatureRendererRegistrationCallback.EVENT.register(ModRender::init$lambda$0);
    }

    private final void initArmor(class_5617.class_5618 context) {
        class_1935[] class_1935Array = new class_1935[]{ModBlocksAndItems.INSTANCE.getNETWALKERS()};
        ArmorRenderer.register((ArmorRenderer)new NetwalkersRenderer(context), (class_1935[])class_1935Array);
    }

    private final class_5601 registerLayer(EntityModelLayerRegistry.TexturedModelDataProvider provider, String path, String name) {
        class_5601 class_56012;
        class_5601 it = class_56012 = new class_5601(Derelict.INSTANCE.id(path), name);
        boolean bl = false;
        EntityModelLayerRegistry.registerModelLayer((class_5601)it, (EntityModelLayerRegistry.TexturedModelDataProvider)provider);
        return class_56012;
    }

    static /* synthetic */ class_5601 registerLayer$default(ModRender modRender, EntityModelLayerRegistry.TexturedModelDataProvider texturedModelDataProvider, String string, String string2, int n, Object object) {
        if ((n & 4) != 0) {
            string2 = "main";
        }
        return modRender.registerLayer(texturedModelDataProvider, string, string2);
    }

    private static final void init$lambda$0(class_1299 class_12992, class_922 class_9222, LivingEntityFeatureRendererRegistrationCallback.RegistrationHelper registrationHelper, class_5617.class_5618 context) {
        if (!customRenderersWorkaroundInit) {
            customRenderersWorkaroundInit = true;
            Intrinsics.checkNotNull((Object)context);
            INSTANCE.initArmor(context);
        }
    }

    static {
        ARACHNE_LAYER = ModRender.registerLayer$default(INSTANCE, ArachneTexturedModelData.INSTANCE::create, "arachne", null, 4, null);
        SPIDERLING_LAYER = ModRender.registerLayer$default(INSTANCE, SpiderlingEntityRendererKt::getSpiderlingTexturedModelData, "spiderling", null, 4, null);
        CHARMING_SPIDER_LAYER = ModRender.registerLayer$default(INSTANCE, CharmingSpiderEntityModel.Companion::createTexturedModelData, "charming_spider", null, 4, null);
        WEB_CASTER_LAYER = ModRender.registerLayer$default(INSTANCE, WebCasterEntityModel.Companion::createTexturedModelData, "web_caster", null, 4, null);
        DADDY_LONG_LEGS_LAYER = ModRender.registerLayer$default(INSTANCE, DaddyLongLegsEntityModel.Companion::createTexturedModelData, "daddy_long_legs", null, 4, null);
        JUMPING_SPIDER_LAYER = ModRender.registerLayer$default(INSTANCE, JumpingSpiderEntityModel.Companion::createTexturedModelData, "jumping_spider", null, 4, null);
        SPINY_SPIDER_LAYER = ModRender.registerLayer$default(INSTANCE, SpinySpiderEntityModel.Companion::createTexturedModelData, "spiny_spider", null, 4, null);
        HANGING_COCOON_LAYER = ModRender.registerLayer$default(INSTANCE, HangingCocoonEntityRenderer.Companion::createTexturedModelData, "hanging_cocoon", null, 4, null);
        NETWALKERS_LAYER = ModRender.registerLayer$default(INSTANCE, NetwalkersRenderer.Companion::createTexturedModelData, "netwalkers", null, 4, null);
    }
}

