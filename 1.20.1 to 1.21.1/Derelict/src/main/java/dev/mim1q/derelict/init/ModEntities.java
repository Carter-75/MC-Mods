/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry
 *  net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1299$class_4049
 *  net.minecraft.class_1309
 *  net.minecraft.class_1311
 *  net.minecraft.class_1314
 *  net.minecraft.class_1628
 *  net.minecraft.class_1642
 *  net.minecraft.class_2378
 *  net.minecraft.class_2960
 *  net.minecraft.class_4048
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_7923
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.init;

import dev.mim1q.derelict.Derelict;
import dev.mim1q.derelict.entity.SpiderlingEntity;
import dev.mim1q.derelict.entity.boss.ArachneEntity;
import dev.mim1q.derelict.entity.projectile.SpiderEggProjectile;
import dev.mim1q.derelict.entity.projectile.SpiderSilkBolaProjectile;
import dev.mim1q.derelict.entity.spider.ArachneEggEntity;
import dev.mim1q.derelict.entity.spider.CharmingSpiderEntity;
import dev.mim1q.derelict.entity.spider.DaddyLongLegsEntity;
import dev.mim1q.derelict.entity.spider.JumpingSpiderEntity;
import dev.mim1q.derelict.entity.spider.SpinySpiderEntity;
import dev.mim1q.derelict.entity.spider.WebCasterEntity;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1311;
import net.minecraft.class_1314;
import net.minecraft.class_1628;
import net.minecraft.class_1642;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_4048;
import net.minecraft.class_5132;
import net.minecraft.class_7923;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0003JV\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\b\b\u0000\u0010\u0007*\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u001f\b\u0002\u0010\u000f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0004\u0012\u00020\u00040\f\u00a2\u0006\u0002\b\u000eH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012Jj\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\b\b\u0000\u0010\u0007*\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00162\u001f\b\u0002\u0010\u000f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0004\u0012\u00020\u00040\f\u00a2\u0006\u0002\b\u000eH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0018R%\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u00190\u00108\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR%\u0010 \u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u001f0\u001f0\u00108\u0006\u00a2\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u001eR%\u0010\"\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u001f0\u001f0\u00108\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001eR%\u0010%\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010$0$0\u00108\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u001c\u001a\u0004\b&\u0010\u001eR%\u0010(\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010'0'0\u00108\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u001c\u001a\u0004\b)\u0010\u001eR%\u0010+\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010*0*0\u00108\u0006\u00a2\u0006\f\n\u0004\b+\u0010\u001c\u001a\u0004\b,\u0010\u001eR%\u0010.\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010-0-0\u00108\u0006\u00a2\u0006\f\n\u0004\b.\u0010\u001c\u001a\u0004\b/\u0010\u001eR%\u00101\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u000100000\u00108\u0006\u00a2\u0006\f\n\u0004\b1\u0010\u001c\u001a\u0004\b2\u0010\u001eR%\u00104\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u000103030\u00108\u0006\u00a2\u0006\f\n\u0004\b4\u0010\u001c\u001a\u0004\b5\u0010\u001eR%\u00107\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u000106060\u00108\u0006\u00a2\u0006\f\n\u0004\b7\u0010\u001c\u001a\u0004\b8\u0010\u001eR%\u0010:\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u000109090\u00108\u0006\u00a2\u0006\f\n\u0004\b:\u0010\u001c\u001a\u0004\b;\u0010\u001eR-\u0010>\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n \u001a*\u0004\u0018\u00010=0=0\u00100<8\u0006\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\u00a8\u0006B"}, d2={"Ldev/mim1q/derelict/init/ModEntities;", "", "<init>", "()V", "", "init", "Lnet/minecraft/class_1297;", "E", "", "name", "Lnet/minecraft/class_1299$class_4049;", "entityfactory", "Lkotlin/Function1;", "Lnet/fabricmc/fabric/api/object/builder/v1/entity/FabricEntityTypeBuilder;", "Lkotlin/ExtensionFunctionType;", "builderSetup", "Lnet/minecraft/class_1299;", "register", "(Ljava/lang/String;Lnet/minecraft/class_1299$class_4049;Lkotlin/jvm/functions/Function1;)Lnet/minecraft/class_1299;", "Lnet/minecraft/class_1309;", "Lnet/minecraft/class_5132$class_5133;", "attributes", "Lnet/minecraft/class_1311;", "spawnGroup", "(Ljava/lang/String;Lnet/minecraft/class_1299$class_4049;Lnet/minecraft/class_5132$class_5133;Lnet/minecraft/class_1311;Lkotlin/jvm/functions/Function1;)Lnet/minecraft/class_1299;", "Ldev/mim1q/derelict/entity/boss/ArachneEntity;", "kotlin.jvm.PlatformType", "ARACHNE", "Lnet/minecraft/class_1299;", "getARACHNE", "()Lnet/minecraft/class_1299;", "Ldev/mim1q/derelict/entity/SpiderlingEntity;", "SPIDERLING", "getSPIDERLING", "SPIDERLING_ALLY", "getSPIDERLING_ALLY", "Ldev/mim1q/derelict/entity/spider/CharmingSpiderEntity;", "CHARMING_SPIDER", "getCHARMING_SPIDER", "Ldev/mim1q/derelict/entity/spider/WebCasterEntity;", "WEB_CASTER", "getWEB_CASTER", "Ldev/mim1q/derelict/entity/spider/DaddyLongLegsEntity;", "DADDY_LONG_LEGS", "getDADDY_LONG_LEGS", "Ldev/mim1q/derelict/entity/spider/JumpingSpiderEntity;", "JUMPING_SPIDER", "getJUMPING_SPIDER", "Ldev/mim1q/derelict/entity/spider/SpinySpiderEntity;", "SPINY_SPIDER", "getSPINY_SPIDER", "Ldev/mim1q/derelict/entity/spider/ArachneEggEntity;", "ARACHNE_EGG", "getARACHNE_EGG", "Ldev/mim1q/derelict/entity/projectile/SpiderSilkBolaProjectile;", "SPIDER_SILK_BOLA", "getSPIDER_SILK_BOLA", "Ldev/mim1q/derelict/entity/projectile/SpiderEggProjectile;", "SPIDER_EGG_PROJECTILE", "getSPIDER_EGG_PROJECTILE", "", "Lnet/minecraft/class_1314;", "SPAWN_ON_GROUND", "Ljava/util/Set;", "getSPAWN_ON_GROUND", "()Ljava/util/Set;", "derelict"})
public final class ModEntities {
    @NotNull
    public static final ModEntities INSTANCE = new ModEntities();
    @NotNull
    private static final class_1299<ArachneEntity> ARACHNE = ModEntities.register$default(INSTANCE, "arachne", ArachneEntity::new, ArachneEntity.Companion.createArachneAttributes(), null, ModEntities::ARACHNE$lambda$0, 8, null);
    @NotNull
    private static final class_1299<SpiderlingEntity> SPIDERLING = ModEntities.register$default(INSTANCE, "spiderling", SpiderlingEntity.Enemy::new, SpiderlingEntity.Companion.createSpiderlingAttributes(), null, ModEntities::SPIDERLING$lambda$1, 8, null);
    @NotNull
    private static final class_1299<SpiderlingEntity> SPIDERLING_ALLY = ModEntities.register$default(INSTANCE, "spiderling_ally", SpiderlingEntity.Ally::new, SpiderlingEntity.Companion.createSpiderlingAllyAttributes(), null, ModEntities::SPIDERLING_ALLY$lambda$2, 8, null);
    @NotNull
    private static final class_1299<CharmingSpiderEntity> CHARMING_SPIDER = ModEntities.register$default(INSTANCE, "charming_spider", CharmingSpiderEntity::new, CharmingSpiderEntity.Companion.createCharmingSpiderAttributes(), null, ModEntities::CHARMING_SPIDER$lambda$3, 8, null);
    @NotNull
    private static final class_1299<WebCasterEntity> WEB_CASTER = ModEntities.register$default(INSTANCE, "web_caster", WebCasterEntity::new, WebCasterEntity.Companion.createWebCasterAttributes(), null, ModEntities::WEB_CASTER$lambda$4, 8, null);
    @NotNull
    private static final class_1299<DaddyLongLegsEntity> DADDY_LONG_LEGS;
    @NotNull
    private static final class_1299<JumpingSpiderEntity> JUMPING_SPIDER;
    @NotNull
    private static final class_1299<SpinySpiderEntity> SPINY_SPIDER;
    @NotNull
    private static final class_1299<ArachneEggEntity> ARACHNE_EGG;
    @NotNull
    private static final class_1299<SpiderSilkBolaProjectile> SPIDER_SILK_BOLA;
    @NotNull
    private static final class_1299<SpiderEggProjectile> SPIDER_EGG_PROJECTILE;
    @NotNull
    private static final Set<class_1299<? extends class_1314>> SPAWN_ON_GROUND;

    private ModEntities() {
    }

    @NotNull
    public final class_1299<ArachneEntity> getARACHNE() {
        return ARACHNE;
    }

    @NotNull
    public final class_1299<SpiderlingEntity> getSPIDERLING() {
        return SPIDERLING;
    }

    @NotNull
    public final class_1299<SpiderlingEntity> getSPIDERLING_ALLY() {
        return SPIDERLING_ALLY;
    }

    @NotNull
    public final class_1299<CharmingSpiderEntity> getCHARMING_SPIDER() {
        return CHARMING_SPIDER;
    }

    @NotNull
    public final class_1299<WebCasterEntity> getWEB_CASTER() {
        return WEB_CASTER;
    }

    @NotNull
    public final class_1299<DaddyLongLegsEntity> getDADDY_LONG_LEGS() {
        return DADDY_LONG_LEGS;
    }

    @NotNull
    public final class_1299<JumpingSpiderEntity> getJUMPING_SPIDER() {
        return JUMPING_SPIDER;
    }

    @NotNull
    public final class_1299<SpinySpiderEntity> getSPINY_SPIDER() {
        return SPINY_SPIDER;
    }

    @NotNull
    public final class_1299<ArachneEggEntity> getARACHNE_EGG() {
        return ARACHNE_EGG;
    }

    @NotNull
    public final class_1299<SpiderSilkBolaProjectile> getSPIDER_SILK_BOLA() {
        return SPIDER_SILK_BOLA;
    }

    @NotNull
    public final class_1299<SpiderEggProjectile> getSPIDER_EGG_PROJECTILE() {
        return SPIDER_EGG_PROJECTILE;
    }

    public final void init() {
    }

    @NotNull
    public final Set<class_1299<? extends class_1314>> getSPAWN_ON_GROUND() {
        return SPAWN_ON_GROUND;
    }

    private final <E extends class_1297> class_1299<E> register(String name, class_1299.class_4049<E> entityfactory, Function1<? super FabricEntityTypeBuilder<E>, Unit> builderSetup) {
        class_2378 class_23782 = (class_2378)class_7923.field_41177;
        class_2960 class_29602 = Derelict.INSTANCE.id(name);
        FabricEntityTypeBuilder fabricEntityTypeBuilder = FabricEntityTypeBuilder.create((class_1311)class_1311.field_17715, entityfactory);
        builderSetup.invoke((Object)fabricEntityTypeBuilder);
        Object object = class_2378.method_10230((class_2378)class_23782, (class_2960)class_29602, (Object)fabricEntityTypeBuilder.build());
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"register(...)");
        return (class_1299)object;
    }

    static /* synthetic */ class_1299 register$default(ModEntities modEntities, String string, class_1299.class_4049 class_40492, Function1 function1, int n, Object object) {
        if ((n & 4) != 0) {
            function1 = ModEntities::register$lambda$11;
        }
        return modEntities.register(string, class_40492, function1);
    }

    private final <E extends class_1309> class_1299<E> register(String name, class_1299.class_4049<E> entityfactory, class_5132.class_5133 attributes, class_1311 spawnGroup, Function1<? super FabricEntityTypeBuilder<E>, Unit> builderSetup) {
        class_2378 class_23782 = (class_2378)class_7923.field_41177;
        class_2960 class_29602 = Derelict.INSTANCE.id(name);
        Object object = FabricEntityTypeBuilder.create((class_1311)spawnGroup, entityfactory);
        builderSetup.invoke(object);
        object = class_2378.method_10230((class_2378)class_23782, (class_2960)class_29602, (Object)object.build());
        class_1299 it = (class_1299)object;
        boolean bl = false;
        FabricDefaultAttributeRegistry.register((class_1299)it, (class_5132.class_5133)attributes);
        Object object2 = object;
        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"also(...)");
        return (class_1299)object2;
    }

    static /* synthetic */ class_1299 register$default(ModEntities modEntities, String string, class_1299.class_4049 class_40492, class_5132.class_5133 class_51332, class_1311 class_13112, Function1 function1, int n, Object object) {
        if ((n & 4) != 0) {
            class_51332 = class_1642.method_26918();
        }
        if ((n & 8) != 0) {
            class_13112 = class_1311.field_6302;
        }
        if ((n & 0x10) != 0) {
            function1 = ModEntities::register$lambda$12;
        }
        return modEntities.register(string, class_40492, class_51332, class_13112, function1);
    }

    private static final Unit ARACHNE$lambda$0(FabricEntityTypeBuilder $this$register) {
        Intrinsics.checkNotNullParameter((Object)$this$register, (String)"$this$register");
        $this$register.dimensions(class_4048.method_18385((float)2.5f, (float)1.9f));
        return Unit.INSTANCE;
    }

    private static final Unit SPIDERLING$lambda$1(FabricEntityTypeBuilder $this$register) {
        Intrinsics.checkNotNullParameter((Object)$this$register, (String)"$this$register");
        $this$register.dimensions(class_4048.method_18385((float)0.7f, (float)0.7f));
        return Unit.INSTANCE;
    }

    private static final Unit SPIDERLING_ALLY$lambda$2(FabricEntityTypeBuilder $this$register) {
        Intrinsics.checkNotNullParameter((Object)$this$register, (String)"$this$register");
        $this$register.dimensions(class_4048.method_18385((float)0.7f, (float)0.7f));
        return Unit.INSTANCE;
    }

    private static final Unit CHARMING_SPIDER$lambda$3(FabricEntityTypeBuilder $this$register) {
        Intrinsics.checkNotNullParameter((Object)$this$register, (String)"$this$register");
        $this$register.dimensions(class_4048.method_18385((float)0.8f, (float)0.8f));
        return Unit.INSTANCE;
    }

    private static final Unit WEB_CASTER$lambda$4(FabricEntityTypeBuilder $this$register) {
        Intrinsics.checkNotNullParameter((Object)$this$register, (String)"$this$register");
        $this$register.dimensions(class_4048.method_18385((float)1.9f, (float)1.2f));
        return Unit.INSTANCE;
    }

    private static final Unit DADDY_LONG_LEGS$lambda$5(FabricEntityTypeBuilder $this$register) {
        Intrinsics.checkNotNullParameter((Object)$this$register, (String)"$this$register");
        $this$register.dimensions(class_4048.method_18385((float)0.9f, (float)3.6f));
        return Unit.INSTANCE;
    }

    private static final Unit JUMPING_SPIDER$lambda$6(FabricEntityTypeBuilder $this$register) {
        Intrinsics.checkNotNullParameter((Object)$this$register, (String)"$this$register");
        $this$register.dimensions(class_4048.method_18385((float)1.6f, (float)0.9f));
        return Unit.INSTANCE;
    }

    private static final Unit SPINY_SPIDER$lambda$7(FabricEntityTypeBuilder $this$register) {
        Intrinsics.checkNotNullParameter((Object)$this$register, (String)"$this$register");
        $this$register.dimensions(class_4048.method_18385((float)0.8f, (float)0.8f));
        return Unit.INSTANCE;
    }

    private static final Unit ARACHNE_EGG$lambda$8(FabricEntityTypeBuilder $this$register) {
        Intrinsics.checkNotNullParameter((Object)$this$register, (String)"$this$register");
        $this$register.dimensions(class_4048.method_18385((float)1.5f, (float)2.25f));
        return Unit.INSTANCE;
    }

    private static final Unit SPIDER_SILK_BOLA$lambda$9(FabricEntityTypeBuilder $this$register) {
        Intrinsics.checkNotNullParameter((Object)$this$register, (String)"$this$register");
        $this$register.dimensions(class_4048.method_18385((float)1.0f, (float)1.0f));
        return Unit.INSTANCE;
    }

    private static final Unit SPIDER_EGG_PROJECTILE$lambda$10(FabricEntityTypeBuilder $this$register) {
        Intrinsics.checkNotNullParameter((Object)$this$register, (String)"$this$register");
        $this$register.dimensions(class_4048.method_18385((float)0.5f, (float)0.5f));
        return Unit.INSTANCE;
    }

    private static final Unit register$lambda$11(FabricEntityTypeBuilder fabricEntityTypeBuilder) {
        Intrinsics.checkNotNullParameter((Object)fabricEntityTypeBuilder, (String)"<this>");
        return Unit.INSTANCE;
    }

    private static final Unit register$lambda$12(FabricEntityTypeBuilder fabricEntityTypeBuilder) {
        Intrinsics.checkNotNullParameter((Object)fabricEntityTypeBuilder, (String)"<this>");
        return Unit.INSTANCE;
    }

    static {
        class_1299.class_4049 class_40492 = DaddyLongLegsEntity::new;
        class_5132.class_5133 class_51332 = class_1628.method_26923();
        Intrinsics.checkNotNullExpressionValue((Object)class_51332, (String)"createSpiderAttributes(...)");
        DADDY_LONG_LEGS = ModEntities.register$default(INSTANCE, "daddy_long_legs", class_40492, class_51332, null, ModEntities::DADDY_LONG_LEGS$lambda$5, 8, null);
        class_1299.class_4049 class_40493 = JumpingSpiderEntity::new;
        class_5132.class_5133 class_51333 = class_1628.method_26923();
        Intrinsics.checkNotNullExpressionValue((Object)class_51333, (String)"createSpiderAttributes(...)");
        JUMPING_SPIDER = ModEntities.register$default(INSTANCE, "jumping_spider", class_40493, class_51333, null, ModEntities::JUMPING_SPIDER$lambda$6, 8, null);
        class_1299.class_4049 class_40494 = SpinySpiderEntity::new;
        class_5132.class_5133 class_51334 = class_1628.method_26923();
        Intrinsics.checkNotNullExpressionValue((Object)class_51334, (String)"createSpiderAttributes(...)");
        SPINY_SPIDER = ModEntities.register$default(INSTANCE, "spiny_spider", class_40494, class_51334, null, ModEntities::SPINY_SPIDER$lambda$7, 8, null);
        ARACHNE_EGG = INSTANCE.register("arachne_egg", ArachneEggEntity::new, ModEntities::ARACHNE_EGG$lambda$8);
        SPIDER_SILK_BOLA = INSTANCE.register("spider_silk_bola", SpiderSilkBolaProjectile::new, ModEntities::SPIDER_SILK_BOLA$lambda$9);
        SPIDER_EGG_PROJECTILE = INSTANCE.register("spider_egg_projectile", SpiderEggProjectile::new, ModEntities::SPIDER_EGG_PROJECTILE$lambda$10);
        Object[] objectArray = new class_1299[6];
        objectArray[0] = SPIDERLING;
        objectArray[1] = CHARMING_SPIDER;
        objectArray[2] = WEB_CASTER;
        objectArray[3] = DADDY_LONG_LEGS;
        objectArray[4] = JUMPING_SPIDER;
        objectArray[5] = SPINY_SPIDER;
        SPAWN_ON_GROUND = SetsKt.setOf((Object[])objectArray);
    }
}

