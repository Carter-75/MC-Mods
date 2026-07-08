/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry
 *  net.fabricmc.fabric.api.particle.v1.FabricParticleTypes
 *  net.minecraft.class_2378
 *  net.minecraft.class_2396
 *  net.minecraft.class_2400
 *  net.minecraft.class_2960
 *  net.minecraft.class_707
 *  net.minecraft.class_7923
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.init;

import dev.mim1q.derelict.Derelict;
import dev.mim1q.derelict.init.ModParticles;
import dev.mim1q.derelict.particle.colored.ColoredParticle;
import dev.mim1q.derelict.particle.colored.ColoredParticleType;
import dev.mim1q.derelict.particle.spider.SpiderEmitterParticle;
import dev.mim1q.derelict.particle.spider.SpiderParticle;
import dev.mim1q.derelict.particle.spider.SpiderParticleType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.class_2378;
import net.minecraft.class_2396;
import net.minecraft.class_2400;
import net.minecraft.class_2960;
import net.minecraft.class_707;
import net.minecraft.class_7923;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0003J5\u0010\r\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0007\"\u000e\b\u0001\u0010\t*\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00028\u0001H\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0010\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0015\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u001b\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\u001f"}, d2={"Ldev/mim1q/derelict/init/ModParticles;", "", "<init>", "()V", "", "init", "initClient", "P", "Lnet/minecraft/class_2396;", "T", "", "name", "particle", "register", "(Ljava/lang/String;Lnet/minecraft/class_2396;)Lnet/minecraft/class_2396;", "Ldev/mim1q/derelict/particle/colored/ColoredParticleType;", "SPRAY", "Ldev/mim1q/derelict/particle/colored/ColoredParticleType;", "getSPRAY", "()Ldev/mim1q/derelict/particle/colored/ColoredParticleType;", "Ldev/mim1q/derelict/particle/spider/SpiderParticleType;", "SPIDER", "Ldev/mim1q/derelict/particle/spider/SpiderParticleType;", "getSPIDER", "()Ldev/mim1q/derelict/particle/spider/SpiderParticleType;", "Lnet/minecraft/class_2400;", "kotlin.jvm.PlatformType", "SPIDER_EMITTER", "Lnet/minecraft/class_2400;", "getSPIDER_EMITTER", "()Lnet/minecraft/class_2400;", "derelict"})
public final class ModParticles {
    @NotNull
    public static final ModParticles INSTANCE = new ModParticles();
    @NotNull
    private static final ColoredParticleType SPRAY = (ColoredParticleType)INSTANCE.register("spray", (class_2396)ColoredParticleType.Companion.create());
    @NotNull
    private static final SpiderParticleType SPIDER = (SpiderParticleType)INSTANCE.register("spider", (class_2396)SpiderParticleType.Companion.create());
    private static final class_2400 SPIDER_EMITTER;

    private ModParticles() {
    }

    @NotNull
    public final ColoredParticleType getSPRAY() {
        return SPRAY;
    }

    @NotNull
    public final SpiderParticleType getSPIDER() {
        return SPIDER;
    }

    public final class_2400 getSPIDER_EMITTER() {
        return SPIDER_EMITTER;
    }

    public final void init() {
    }

    public final void initClient() {
        ParticleFactoryRegistry.getInstance().register((class_2396)SPRAY, ColoredParticle.Companion.createFactory(initClient.1.INSTANCE));
        ParticleFactoryRegistry.getInstance().register((class_2396)SPIDER, SpiderParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register((class_2396)SPIDER_EMITTER, (class_707)new SpiderEmitterParticle.Factory());
    }

    private final <P, T extends class_2396<P>> T register(String name, T particle) {
        Object object = class_2378.method_10230((class_2378)class_7923.field_41180, (class_2960)Derelict.INSTANCE.id(name), particle);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"register(...)");
        return (T)((class_2396)object);
    }

    static {
        class_2400 class_24002 = FabricParticleTypes.simple();
        Intrinsics.checkNotNullExpressionValue((Object)class_24002, (String)"simple(...)");
        SPIDER_EMITTER = (class_2400)INSTANCE.register("spider_emitter", (class_2396)class_24002);
    }
}

