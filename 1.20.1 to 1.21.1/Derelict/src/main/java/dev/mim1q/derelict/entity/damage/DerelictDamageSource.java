/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1282
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_2960
 *  net.minecraft.class_5321
 *  net.minecraft.class_6880
 *  net.minecraft.class_7924
 *  net.minecraft.class_8110
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.mim1q.derelict.entity.damage;

import dev.mim1q.derelict.Derelict;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1282;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_6880;
import net.minecraft.class_7924;
import net.minecraft.class_8110;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J)\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\r\u0010\u000fJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u0010R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0015"}, d2={"Ldev/mim1q/derelict/entity/damage/DerelictDamageSource;", "", "Lnet/minecraft/class_5321;", "Lnet/minecraft/class_8110;", "key", "<init>", "(Lnet/minecraft/class_5321;)V", "Lnet/minecraft/class_1937;", "world", "Lnet/minecraft/class_1297;", "entity", "indirectEntity", "Lnet/minecraft/class_1282;", "get", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_1297;Lnet/minecraft/class_1297;)Lnet/minecraft/class_1282;", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_1297;)Lnet/minecraft/class_1282;", "(Lnet/minecraft/class_1937;)Lnet/minecraft/class_1282;", "Lnet/minecraft/class_5321;", "getKey", "()Lnet/minecraft/class_5321;", "Companion", "derelict"})
public final class DerelictDamageSource {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final class_5321<class_8110> key;
    @NotNull
    private static final DerelictDamageSource SPIDERLING_ALLY = dev.mim1q.derelict.entity.damage.DerelictDamageSource$Companion.access$create(Companion, "spiderling_ally");

    private DerelictDamageSource(class_5321<class_8110> key) {
        this.key = key;
    }

    @NotNull
    public final class_5321<class_8110> getKey() {
        return this.key;
    }

    @NotNull
    public final class_1282 get(@NotNull class_1937 world, @Nullable class_1297 entity, @Nullable class_1297 indirectEntity) {
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        return new class_1282((class_6880)world.method_30349().method_30530(class_7924.field_42534).method_40290(this.key), entity, indirectEntity);
    }

    @NotNull
    public final class_1282 get(@NotNull class_1937 world, @Nullable class_1297 entity) {
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        return new class_1282((class_6880)world.method_30349().method_30530(class_7924.field_42534).method_40290(this.key), entity);
    }

    @NotNull
    public final class_1282 get(@NotNull class_1937 world) {
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        return this.get(world, null);
    }

    public /* synthetic */ DerelictDamageSource(class_5321 key, DefaultConstructorMarker $constructor_marker) {
        this((class_5321<class_8110>)key);
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2={"Ldev/mim1q/derelict/entity/damage/DerelictDamageSource$Companion;", "", "<init>", "()V", "", "name", "Ldev/mim1q/derelict/entity/damage/DerelictDamageSource;", "create", "(Ljava/lang/String;)Ldev/mim1q/derelict/entity/damage/DerelictDamageSource;", "SPIDERLING_ALLY", "Ldev/mim1q/derelict/entity/damage/DerelictDamageSource;", "getSPIDERLING_ALLY", "()Ldev/mim1q/derelict/entity/damage/DerelictDamageSource;", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final DerelictDamageSource getSPIDERLING_ALLY() {
            return SPIDERLING_ALLY;
        }

        private final DerelictDamageSource create(String name) {
            class_5321 class_53212 = class_5321.method_29179((class_5321)class_7924.field_42534, (class_2960)Derelict.INSTANCE.id(name));
            Intrinsics.checkNotNullExpressionValue((Object)class_53212, (String)"of(...)");
            return new DerelictDamageSource(class_53212, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public static final /* synthetic */ DerelictDamageSource access$create(Companion $this, String name) {
            return $this.create(name);
        }
    }
}

