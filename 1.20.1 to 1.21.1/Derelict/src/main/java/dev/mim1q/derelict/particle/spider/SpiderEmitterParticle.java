/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1922
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2350
 *  net.minecraft.class_2394
 *  net.minecraft.class_2400
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_3998
 *  net.minecraft.class_638
 *  net.minecraft.class_703
 *  net.minecraft.class_707
 *  net.minecraft.class_746
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.particle.spider;

import dev.mim1q.derelict.init.ModParticles;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1922;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2394;
import net.minecraft.class_2400;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3998;
import net.minecraft.class_638;
import net.minecraft.class_703;
import net.minecraft.class_707;
import net.minecraft.class_746;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\rB)\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2={"Ldev/mim1q/derelict/particle/spider/SpiderEmitterParticle;", "Lnet/minecraft/class_3998;", "Lnet/minecraft/class_638;", "world", "", "x", "y", "z", "<init>", "(Lnet/minecraft/class_638;DDD)V", "", "tick", "()V", "Factory", "derelict"})
public final class SpiderEmitterParticle
extends class_3998 {
    private SpiderEmitterParticle(class_638 world, double x, double y, double z) {
        super(world, x, y, z);
    }

    public void method_3070() {
        class_2338.class_2339 blockPos = new class_2338.class_2339((int)this.field_3874, (int)this.field_3854, (int)this.field_3871);
        class_746 player = class_310.method_1551().field_1724;
        if (player == null) {
            this.method_3085();
            return;
        }
        class_243 direction = player.method_19538().method_1023(this.field_3874, this.field_3854, this.field_3871).method_18805(1.0, 0.0, 1.0).method_1029().method_1021(this.field_3840.method_43058() * 0.05 + 0.02);
        int n = 10;
        for (int i = 0; i < n; ++i) {
            int it = i;
            boolean bl = false;
            if (this.field_3851.method_8320((class_2338)blockPos).method_26206((class_1922)this.field_3851, (class_2338)blockPos, class_2350.field_11036) && this.field_3851.method_8320(blockPos.method_10084()).method_26215()) {
                this.field_3851.method_8406((class_2394)ModParticles.INSTANCE.getSPIDER().get(class_2350.field_11033), this.field_3874, (double)blockPos.method_10264() + 1.1, this.field_3871, direction.field_1352, direction.field_1351, direction.field_1350);
                this.method_3085();
                return;
            }
            blockPos.method_10100(0, -1, 0);
        }
        this.method_3085();
    }

    public /* synthetic */ SpiderEmitterParticle(class_638 world, double x, double y, double z, DefaultConstructorMarker $constructor_marker) {
        this(world, x, y, z);
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004JO\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2={"Ldev/mim1q/derelict/particle/spider/SpiderEmitterParticle$Factory;", "Lnet/minecraft/class_707;", "Lnet/minecraft/class_2400;", "<init>", "()V", "defaultParticleType", "Lnet/minecraft/class_638;", "clientWorld", "", "d", "e", "f", "g", "h", "i", "Lnet/minecraft/class_703;", "createParticle", "(Lnet/minecraft/class_2400;Lnet/minecraft/class_638;DDDDDD)Lnet/minecraft/class_703;", "derelict"})
    public static final class Factory
    implements class_707<class_2400> {
        @NotNull
        public class_703 createParticle(@NotNull class_2400 defaultParticleType, @NotNull class_638 clientWorld, double d, double e, double f, double g, double h, double i) {
            Intrinsics.checkNotNullParameter((Object)defaultParticleType, (String)"defaultParticleType");
            Intrinsics.checkNotNullParameter((Object)clientWorld, (String)"clientWorld");
            return (class_703)new SpiderEmitterParticle(clientWorld, d, e, f, null);
        }
    }
}

