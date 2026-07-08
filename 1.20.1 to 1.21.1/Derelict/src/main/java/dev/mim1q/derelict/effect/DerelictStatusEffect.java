/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.mim1q.gimm1q.effect.ExtendedStatusEffect
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1291
 *  net.minecraft.class_1309
 *  net.minecraft.class_4081
 *  net.minecraft.class_5131
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.effect;

import dev.mim1q.derelict.init.component.ModCardinalComponents;
import dev.mim1q.gimm1q.effect.ExtendedStatusEffect;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1291;
import net.minecraft.class_1309;
import net.minecraft.class_4081;
import net.minecraft.class_5131;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0013\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0016\u00a8\u0006\u0017"}, d2={"Ldev/mim1q/derelict/effect/DerelictStatusEffect;", "Lnet/minecraft/class_1291;", "Ldev/mim1q/gimm1q/effect/ExtendedStatusEffect;", "Lnet/minecraft/class_4081;", "category", "", "color", "", "curable", "<init>", "(Lnet/minecraft/class_4081;IZ)V", "Lnet/minecraft/class_1309;", "entity", "Lnet/minecraft/class_5131;", "attributes", "amplifier", "", "onApplied", "(Lnet/minecraft/class_1309;Lnet/minecraft/class_5131;I)V", "onRemoved", "canBeCuredWithMilk", "()Z", "Z", "derelict"})
public class DerelictStatusEffect
extends class_1291
implements ExtendedStatusEffect {
    private final boolean curable;

    public DerelictStatusEffect(@NotNull class_4081 category, int color, boolean curable) {
        Intrinsics.checkNotNullParameter((Object)category, (String)"category");
        super(category, color);
        this.curable = curable;
    }

    public /* synthetic */ DerelictStatusEffect(class_4081 class_40812, int n, boolean bl, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 4) != 0) {
            bl = true;
        }
        this(class_40812, n, bl);
    }

    public void method_5555(@NotNull class_1309 entity, @NotNull class_5131 attributes, int amplifier) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)attributes, (String)"attributes");
        super.method_5555(entity, attributes, amplifier);
        ModCardinalComponents.INSTANCE.getStatusEffectComponent(entity).addEffect(this, amplifier);
    }

    public void method_5562(@NotNull class_1309 entity, @NotNull class_5131 attributes, int amplifier) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)attributes, (String)"attributes");
        super.method_5562(entity, attributes, amplifier);
        ModCardinalComponents.INSTANCE.getStatusEffectComponent(entity).removeEffect(this);
    }

    public boolean canBeCuredWithMilk() {
        return this.curable;
    }
}

