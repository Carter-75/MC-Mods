/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.fabricmc.fabric.api.client.particle.v1.FabricSpriteProvider
 *  net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry$PendingParticleFactory
 *  net.minecraft.class_4002
 *  net.minecraft.class_4003
 *  net.minecraft.class_638
 *  net.minecraft.class_703
 *  net.minecraft.class_707
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.mim1q.derelict.particle.colored;

import dev.mim1q.derelict.particle.colored.ColoredParticleEffect;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.fabricmc.fabric.api.client.particle.v1.FabricSpriteProvider;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.class_4002;
import net.minecraft.class_4003;
import net.minecraft.class_638;
import net.minecraft.class_703;
import net.minecraft.class_707;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000 \u00162\u00020\u0001:\u0003\u0017\u0018\u0016BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2={"Ldev/mim1q/derelict/particle/colored/ColoredParticle;", "Lnet/minecraft/class_4003;", "Lnet/minecraft/class_638;", "world", "", "x", "y", "z", "velocityX", "velocityY", "velocityZ", "", "color", "<init>", "(Lnet/minecraft/class_638;DDDDDDI)V", "Lnet/minecraft/class_4002;", "spriteProvider", "Lnet/minecraft/class_4002;", "getSpriteProvider", "()Lnet/minecraft/class_4002;", "setSpriteProvider", "(Lnet/minecraft/class_4002;)V", "Companion", "ColoredParticleConstructor", "Factory", "derelict"})
public abstract class ColoredParticle
extends class_4003 {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private class_4002 spriteProvider;

    public ColoredParticle(@NotNull class_638 world, double x, double y, double z, double velocityX, double velocityY, double velocityZ, int color) {
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        super(world, x, y, z, velocityX, velocityY, velocityZ);
        int r = color >> 16;
        int g = color >> 8 & 0xFF;
        int b = color & 0xFF;
        this.field_3861 = (float)r / 255.0f;
        this.field_3842 = (float)g / 255.0f;
        this.field_3859 = (float)b / 255.0f;
    }

    @Nullable
    protected final class_4002 getSpriteProvider() {
        return this.spriteProvider;
    }

    protected final void setSpriteProvider(@Nullable class_4002 class_40022) {
        this.spriteProvider = class_40022;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001JO\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&\u00a2\u0006\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2={"Ldev/mim1q/derelict/particle/colored/ColoredParticle$ColoredParticleConstructor;", "", "Lnet/minecraft/class_638;", "world", "", "x", "y", "z", "velocityX", "velocityY", "velocityZ", "", "color", "Ldev/mim1q/derelict/particle/colored/ColoredParticle;", "create", "(Lnet/minecraft/class_638;DDDDDDI)Ldev/mim1q/derelict/particle/colored/ColoredParticle;", "derelict"})
    public static interface ColoredParticleConstructor {
        @NotNull
        public ColoredParticle create(@NotNull class_638 var1, double var2, double var4, double var6, double var8, double var10, double var12, int var14);
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2={"Ldev/mim1q/derelict/particle/colored/ColoredParticle$Companion;", "", "<init>", "()V", "Ldev/mim1q/derelict/particle/colored/ColoredParticle$ColoredParticleConstructor;", "constructor", "Lnet/fabricmc/fabric/api/client/particle/v1/ParticleFactoryRegistry$PendingParticleFactory;", "Ldev/mim1q/derelict/particle/colored/ColoredParticleEffect;", "createFactory", "(Ldev/mim1q/derelict/particle/colored/ColoredParticle$ColoredParticleConstructor;)Lnet/fabricmc/fabric/api/client/particle/v1/ParticleFactoryRegistry$PendingParticleFactory;", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final ParticleFactoryRegistry.PendingParticleFactory<ColoredParticleEffect> createFactory(@NotNull ColoredParticleConstructor constructor) {
            Intrinsics.checkNotNullParameter((Object)constructor, (String)"constructor");
            return arg_0 -> Companion.createFactory$lambda$0(constructor, arg_0);
        }

        private static final class_707 createFactory$lambda$0(ColoredParticleConstructor $constructor, FabricSpriteProvider spriteProvider) {
            Intrinsics.checkNotNullParameter((Object)$constructor, (String)"$constructor");
            Intrinsics.checkNotNullParameter((Object)spriteProvider, (String)"spriteProvider");
            return new Factory((class_4002)spriteProvider, $constructor);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJO\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0017\u00a8\u0006\u0018"}, d2={"Ldev/mim1q/derelict/particle/colored/ColoredParticle$Factory;", "Lnet/minecraft/class_707;", "Ldev/mim1q/derelict/particle/colored/ColoredParticleEffect;", "Lnet/minecraft/class_4002;", "spriteProvider", "Ldev/mim1q/derelict/particle/colored/ColoredParticle$ColoredParticleConstructor;", "constructor", "<init>", "(Lnet/minecraft/class_4002;Ldev/mim1q/derelict/particle/colored/ColoredParticle$ColoredParticleConstructor;)V", "parameters", "Lnet/minecraft/class_638;", "world", "", "x", "y", "z", "velocityX", "velocityY", "velocityZ", "Lnet/minecraft/class_703;", "createParticle", "(Ldev/mim1q/derelict/particle/colored/ColoredParticleEffect;Lnet/minecraft/class_638;DDDDDD)Lnet/minecraft/class_703;", "Lnet/minecraft/class_4002;", "Ldev/mim1q/derelict/particle/colored/ColoredParticle$ColoredParticleConstructor;", "derelict"})
    public static final class Factory
    implements class_707<ColoredParticleEffect> {
        @NotNull
        private final class_4002 spriteProvider;
        @NotNull
        private final ColoredParticleConstructor constructor;

        public Factory(@NotNull class_4002 spriteProvider, @NotNull ColoredParticleConstructor constructor) {
            Intrinsics.checkNotNullParameter((Object)spriteProvider, (String)"spriteProvider");
            Intrinsics.checkNotNullParameter((Object)constructor, (String)"constructor");
            this.spriteProvider = spriteProvider;
            this.constructor = constructor;
        }

        @NotNull
        public class_703 createParticle(@NotNull ColoredParticleEffect parameters, @NotNull class_638 world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            Intrinsics.checkNotNullParameter((Object)parameters, (String)"parameters");
            Intrinsics.checkNotNullParameter((Object)world, (String)"world");
            ColoredParticle particle = this.constructor.create(world, x, y, z, velocityX, velocityY, velocityZ, parameters.color());
            particle.method_18140(this.spriteProvider);
            particle.setSpriteProvider(this.spriteProvider);
            return (class_703)particle;
        }
    }
}

