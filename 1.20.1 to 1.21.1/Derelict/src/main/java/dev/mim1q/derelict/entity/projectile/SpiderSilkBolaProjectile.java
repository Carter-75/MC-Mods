/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1291
 *  net.minecraft.class_1293
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1309
 *  net.minecraft.class_1665
 *  net.minecraft.class_1799
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_2388
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_243
 *  net.minecraft.class_3218
 *  net.minecraft.class_3965
 *  net.minecraft.class_3966
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.entity.projectile;

import dev.mim1q.derelict.init.ModStatusEffects;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1665;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_2388;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_243;
import net.minecraft.class_3218;
import net.minecraft.class_3965;
import net.minecraft.class_3966;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0014\u00a2\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0016\u001a\u00020\n*\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J+\u0010\u001d\u001a\u00020\n*\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001bH\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0014\u00a2\u0006\u0004\b \u0010!\u00a8\u0006\""}, d2={"Ldev/mim1q/derelict/entity/projectile/SpiderSilkBolaProjectile;", "Lnet/minecraft/class_1665;", "Lnet/minecraft/class_1299;", "entityType", "Lnet/minecraft/class_1937;", "world", "<init>", "(Lnet/minecraft/class_1299;Lnet/minecraft/class_1937;)V", "Lnet/minecraft/class_3966;", "entityHitResult", "", "onEntityHit", "(Lnet/minecraft/class_3966;)V", "Lnet/minecraft/class_3965;", "blockHitResult", "onBlockHit", "(Lnet/minecraft/class_3965;)V", "Lnet/minecraft/class_3218;", "Lnet/minecraft/class_1309;", "entity", "Lnet/minecraft/class_2338;", "pos", "applyCobwebOnNearbyEntities", "(Lnet/minecraft/class_3218;Lnet/minecraft/class_1309;Lnet/minecraft/class_2338;)V", "", "level", "duration", "", "damage", "applyCobweb", "(Lnet/minecraft/class_1309;IIF)V", "Lnet/minecraft/class_1799;", "asItemStack", "()Lnet/minecraft/class_1799;", "derelict"})
@SourceDebugExtension(value={"SMAP\nSpiderSilkBolaProjectile.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpiderSilkBolaProjectile.kt\ndev/mim1q/derelict/entity/projectile/SpiderSilkBolaProjectile\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,82:1\n1863#2,2:83\n*S KotlinDebug\n*F\n+ 1 SpiderSilkBolaProjectile.kt\ndev/mim1q/derelict/entity/projectile/SpiderSilkBolaProjectile\n*L\n46#1:83,2\n*E\n"})
public final class SpiderSilkBolaProjectile
extends class_1665 {
    public SpiderSilkBolaProjectile(@NotNull class_1299<SpiderSilkBolaProjectile> entityType, @NotNull class_1937 world) {
        Intrinsics.checkNotNullParameter(entityType, (String)"entityType");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        super(entityType, world);
    }

    protected void method_7454(@NotNull class_3966 entityHitResult) {
        Intrinsics.checkNotNullParameter((Object)entityHitResult, (String)"entityHitResult");
        super.method_7454(entityHitResult);
        if (!this.method_37908().field_9236) {
            class_1937 class_19372 = this.method_37908();
            class_3218 class_32182 = class_19372 instanceof class_3218 ? (class_3218)class_19372 : null;
            if (class_32182 != null) {
                class_19372 = entityHitResult.method_17782();
                class_1309 class_13092 = class_19372 instanceof class_1309 ? (class_1309)class_19372 : null;
                class_2338 class_23382 = class_2338.method_49638((class_2374)((class_2374)entityHitResult.method_17784()));
                Intrinsics.checkNotNullExpressionValue((Object)class_23382, (String)"ofFloored(...)");
                this.applyCobwebOnNearbyEntities(class_32182, class_13092, class_23382);
            }
            this.method_31472();
        }
    }

    protected void method_24920(@NotNull class_3965 blockHitResult) {
        Intrinsics.checkNotNullParameter((Object)blockHitResult, (String)"blockHitResult");
        super.method_24920(blockHitResult);
        if (!this.method_37908().field_9236) {
            class_1937 class_19372 = this.method_37908();
            class_3218 class_32182 = class_19372 instanceof class_3218 ? (class_3218)class_19372 : null;
            if (class_32182 != null) {
                class_2338 class_23382 = blockHitResult.method_17777();
                Intrinsics.checkNotNullExpressionValue((Object)class_23382, (String)"getBlockPos(...)");
                this.applyCobwebOnNearbyEntities(class_32182, null, class_23382);
            }
            this.method_31472();
        }
    }

    private final void applyCobwebOnNearbyEntities(class_3218 $this$applyCobwebOnNearbyEntities, class_1309 entity, class_2338 pos) {
        class_1309 class_13092 = entity;
        if (class_13092 != null) {
            this.applyCobweb(class_13092, 2, 60, 4.0f);
        }
        List list = $this$applyCobwebOnNearbyEntities.method_8335(this.method_24921(), class_238.method_30048((class_243)class_243.method_24953((class_2382)((class_2382)pos)), (double)5.0, (double)5.0, (double)5.0));
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getOtherEntities(...)");
        Iterable $this$forEach$iv = list;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            class_1297 it = (class_1297)element$iv;
            boolean bl = false;
            class_1309 class_13093 = it instanceof class_1309 ? (class_1309)it : null;
            if (class_13093 == null) continue;
            this.applyCobweb(class_13093, 1, 40, 2.0f);
        }
        $this$applyCobwebOnNearbyEntities.method_14199((class_2394)new class_2388(class_2398.field_11217, class_2246.field_10343.method_9564()), this.method_23317(), this.method_23318() + 0.5, this.method_23321(), 25, 0.4, 0.4, 0.4, 0.01);
    }

    private final void applyCobweb(class_1309 $this$applyCobweb, int level, int duration, float damage) {
        $this$applyCobweb.method_6092(new class_1293((class_1291)ModStatusEffects.INSTANCE.getCOBWEBBED(), duration, level, false, false, false));
        class_1297 class_12972 = this.method_24921();
        class_1309 class_13092 = class_12972 instanceof class_1309 ? (class_1309)class_12972 : null;
        if (class_13092 == null) {
            return;
        }
        $this$applyCobweb.method_5643($this$applyCobweb.method_48923().method_48800((class_1297)$this$applyCobweb, class_13092), damage);
    }

    @NotNull
    protected class_1799 method_7445() {
        class_1799 class_17992 = class_1799.field_8037;
        Intrinsics.checkNotNullExpressionValue((Object)class_17992, (String)"EMPTY");
        return class_17992;
    }
}

