/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.mim1q.gimm1q.interpolation.AnimatedProperty
 *  dev.mim1q.gimm1q.interpolation.Easing
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1299
 *  net.minecraft.class_1628
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_5134
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.mim1q.derelict.entity.spider;

import dev.mim1q.gimm1q.interpolation.AnimatedProperty;
import dev.mim1q.gimm1q.interpolation.Easing;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1299;
import net.minecraft.class_1628;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_5132;
import net.minecraft.class_5134;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001f\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014\u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\u000b\u0010\nJ\u001f\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0017\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001a\u00a8\u0006\u001e"}, d2={"Ldev/mim1q/derelict/entity/spider/CharmingSpiderEntity;", "Lnet/minecraft/class_1628;", "Lnet/minecraft/class_1299;", "entityType", "Lnet/minecraft/class_1937;", "world", "<init>", "(Lnet/minecraft/class_1299;Lnet/minecraft/class_1937;)V", "", "initDataTracker", "()V", "tick", "Lnet/minecraft/class_2338;", "songPosition", "", "playing", "setNearbySongPlaying", "(Lnet/minecraft/class_2338;Z)V", "songSource", "Lnet/minecraft/class_2338;", "isSongPlaying", "Z", "Ldev/mim1q/gimm1q/interpolation/AnimatedProperty;", "tailDanceAnimation", "Ldev/mim1q/gimm1q/interpolation/AnimatedProperty;", "getTailDanceAnimation", "()Ldev/mim1q/gimm1q/interpolation/AnimatedProperty;", "bodyDanceAnimation", "getBodyDanceAnimation", "Companion", "derelict"})
public final class CharmingSpiderEntity
extends class_1628 {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private class_2338 songSource;
    private boolean isSongPlaying;
    @NotNull
    private final AnimatedProperty tailDanceAnimation;
    @NotNull
    private final AnimatedProperty bodyDanceAnimation;

    public CharmingSpiderEntity(@NotNull class_1299<? extends class_1628> entityType, @NotNull class_1937 world) {
        Intrinsics.checkNotNullParameter(entityType, (String)"entityType");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        super(entityType, world);
        this.tailDanceAnimation = new AnimatedProperty(0.0f);
        this.bodyDanceAnimation = new AnimatedProperty(0.0f, Easing::easeOutBack);
    }

    @NotNull
    public final AnimatedProperty getTailDanceAnimation() {
        return this.tailDanceAnimation;
    }

    @NotNull
    public final AnimatedProperty getBodyDanceAnimation() {
        return this.bodyDanceAnimation;
    }

    protected void method_5693() {
        super.method_5693();
    }

    public void method_5773() {
        block11: {
            block10: {
                super.method_5773();
                if (this.songSource == null) break block10;
                class_2338 class_23382 = this.songSource;
                Intrinsics.checkNotNull((Object)class_23382);
                if (class_23382.method_19769((class_2374)this.method_19538(), 3.46) && this.method_37908().method_8320(this.songSource).method_27852(class_2246.field_10223)) break block11;
            }
            this.isSongPlaying = false;
            this.songSource = null;
        }
        if (this.method_37908().field_9236) {
            if (this.isSongPlaying) {
                this.tailDanceAnimation.transitionTo(1.0f, 10.0f);
                switch (this.field_6012 % 20) {
                    case 0: {
                        this.bodyDanceAnimation.transitionTo(1.0f, 10.0f);
                        break;
                    }
                    case 10: {
                        this.bodyDanceAnimation.transitionTo(-1.0f, 10.0f);
                    }
                }
            } else {
                this.tailDanceAnimation.transitionTo(0.0f, 10.0f);
                this.bodyDanceAnimation.transitionTo(0.0f, 10.0f);
            }
        }
    }

    public void method_6006(@NotNull class_2338 songPosition, boolean playing) {
        Intrinsics.checkNotNullParameter((Object)songPosition, (String)"songPosition");
        this.songSource = songPosition;
        this.isSongPlaying = playing;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Ldev/mim1q/derelict/entity/spider/CharmingSpiderEntity$Companion;", "", "<init>", "()V", "Lnet/minecraft/class_5132$class_5133;", "createCharmingSpiderAttributes", "()Lnet/minecraft/class_5132$class_5133;", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final class_5132.class_5133 createCharmingSpiderAttributes() {
            class_5132.class_5133 class_51332 = class_1628.method_26923().method_26868(class_5134.field_23716, 10.0);
            Intrinsics.checkNotNullExpressionValue((Object)class_51332, (String)"add(...)");
            return class_51332;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

