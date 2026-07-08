/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_3999
 *  net.minecraft.class_638
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.particle.colored;

import dev.mim1q.derelict.particle.colored.ColoredParticle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_3999;
import net.minecraft.class_638;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0015"}, d2={"Ldev/mim1q/derelict/particle/colored/SprayParticle;", "Ldev/mim1q/derelict/particle/colored/ColoredParticle;", "Lnet/minecraft/class_638;", "world", "", "x", "y", "z", "velocityX", "velocityY", "velocityZ", "", "color", "<init>", "(Lnet/minecraft/class_638;DDDDDDI)V", "", "tick", "()V", "Lnet/minecraft/class_3999;", "getType", "()Lnet/minecraft/class_3999;", "derelict"})
public final class SprayParticle
extends ColoredParticle {
    public SprayParticle(@NotNull class_638 world, double x, double y, double z, double velocityX, double velocityY, double velocityZ, int color) {
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        super(world, x, y, z, velocityX, velocityY, velocityZ, color);
        this.field_3852 = velocityX;
        this.field_3869 = velocityY;
        this.field_3850 = velocityZ;
        this.field_17867 = 0.1f + world.method_8409().method_43057() * 0.1f;
        this.field_3847 = 30;
        float multiplier = 1.0f - this.field_3840.method_43057() * 0.25f;
        this.field_3861 *= multiplier;
        this.field_3842 *= multiplier;
        this.field_3859 *= multiplier;
    }

    public void method_3070() {
        super.method_3070();
        float progress = (float)this.field_3866 / (float)this.field_3847;
        this.field_28786 = 1.0f - progress * 0.2f;
        this.method_18142(this.getSpriteProvider());
    }

    @NotNull
    public class_3999 method_18122() {
        class_3999 class_39992 = class_3999.field_17828;
        Intrinsics.checkNotNullExpressionValue((Object)class_39992, (String)"PARTICLE_SHEET_OPAQUE");
        return class_39992;
    }
}

