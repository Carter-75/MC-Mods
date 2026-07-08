/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1291
 *  net.minecraft.class_1293
 *  net.minecraft.class_1309
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2378
 *  net.minecraft.class_2388
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_2960
 *  net.minecraft.class_3218
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_4081
 *  net.minecraft.class_5131
 *  net.minecraft.class_7923
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.init;

import dev.mim1q.derelict.Derelict;
import dev.mim1q.derelict.effect.DerelictStatusEffect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1309;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2378;
import net.minecraft.class_2388;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_2960;
import net.minecraft.class_3218;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_4081;
import net.minecraft.class_5131;
import net.minecraft.class_7923;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0003J'\u0010\u000b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0007*\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00028\u0000\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2={"Ldev/mim1q/derelict/init/ModStatusEffects;", "", "<init>", "()V", "", "init", "Lnet/minecraft/class_1291;", "S", "", "name", "effect", "register", "(Ljava/lang/String;Lnet/minecraft/class_1291;)Lnet/minecraft/class_1291;", "Ldev/mim1q/derelict/effect/DerelictStatusEffect;", "COBWEBBED", "Ldev/mim1q/derelict/effect/DerelictStatusEffect;", "getCOBWEBBED", "()Ldev/mim1q/derelict/effect/DerelictStatusEffect;", "derelict"})
public final class ModStatusEffects {
    @NotNull
    public static final ModStatusEffects INSTANCE = new ModStatusEffects();
    @NotNull
    private static final DerelictStatusEffect COBWEBBED;

    private ModStatusEffects() {
    }

    @NotNull
    public final DerelictStatusEffect getCOBWEBBED() {
        return COBWEBBED;
    }

    public final void init() {
    }

    @NotNull
    public final <S extends class_1291> S register(@NotNull String name, @NotNull S effect) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(effect, (String)"effect");
        Object object = class_2378.method_10230((class_2378)class_7923.field_41174, (class_2960)Derelict.INSTANCE.id(name), effect);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"register(...)");
        return (S)((class_1291)object);
    }

    static {
        class_4081 class_40812 = class_4081.field_18272;
        COBWEBBED = (DerelictStatusEffect)INSTANCE.register("cobwebbed", (class_1291)new DerelictStatusEffect(class_40812){

            public boolean method_5552(int duration, int amplifier) {
                return duration == 5 && amplifier > 0;
            }

            public void method_5572(class_1309 entity, int amplifier) {
                Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
                entity.method_6111((class_1291)this);
                entity.method_6092(new class_1293((class_1291)this, entity.method_31747() ? 60 : 40, amplifier - 1, false, false, true));
                this.spawnParticlesAndPlaySound(entity);
            }

            public void method_5562(class_1309 entity, class_5131 attributes, int amplifier) {
                Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
                Intrinsics.checkNotNullParameter((Object)attributes, (String)"attributes");
                super.method_5562(entity, attributes, amplifier);
                this.spawnParticlesAndPlaySound(entity);
            }

            private final void spawnParticlesAndPlaySound(class_1309 entity) {
                block0: {
                    class_1937 class_19372 = entity.method_37908();
                    class_3218 class_32182 = class_19372 instanceof class_3218 ? (class_3218)class_19372 : null;
                    if (class_32182 == null) break block0;
                    class_3218 it = class_32182;
                    boolean bl = false;
                    it.method_14199((class_2394)new class_2388(class_2398.field_11217, class_2246.field_10343.method_9564()), entity.method_23317(), entity.method_23318() + (double)entity.method_17682() / 2.0, entity.method_23321(), 20, (double)entity.method_17681() / 3.0, (double)entity.method_17682() / 3.0, (double)entity.method_17681() / 3.0, 0.0);
                    it.method_8396(null, entity.method_24515(), class_3417.field_14983, class_3419.field_15245, 1.0f, 1.2f);
                }
            }
        });
    }
}

