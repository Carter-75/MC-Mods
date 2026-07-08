/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1309
 *  net.minecraft.class_1588
 *  net.minecraft.class_1665
 *  net.minecraft.class_1799
 *  net.minecraft.class_1937
 *  net.minecraft.class_238
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_243
 *  net.minecraft.class_3218
 *  net.minecraft.class_3414
 *  net.minecraft.class_3417
 *  net.minecraft.class_3965
 *  net.minecraft.class_3966
 *  net.minecraft.class_4051
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.entity.projectile;

import dev.mim1q.derelict.entity.SpiderlingEntity;
import dev.mim1q.derelict.init.ModEntities;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1588;
import net.minecraft.class_1665;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_238;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_243;
import net.minecraft.class_3218;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3965;
import net.minecraft.class_3966;
import net.minecraft.class_4051;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0014\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001b"}, d2={"Ldev/mim1q/derelict/entity/projectile/SpiderEggProjectile;", "Lnet/minecraft/class_1665;", "Lnet/minecraft/class_1299;", "type", "Lnet/minecraft/class_1937;", "world", "<init>", "(Lnet/minecraft/class_1299;Lnet/minecraft/class_1937;)V", "Lnet/minecraft/class_3966;", "entityHitResult", "", "onEntityHit", "(Lnet/minecraft/class_3966;)V", "Lnet/minecraft/class_3965;", "blockHitResult", "onBlockHit", "(Lnet/minecraft/class_3965;)V", "Lnet/minecraft/class_243;", "pos", "explodeIntoSpiderling", "(Lnet/minecraft/class_243;)V", "Lnet/minecraft/class_3414;", "getHitSound", "()Lnet/minecraft/class_3414;", "Lnet/minecraft/class_1799;", "asItemStack", "()Lnet/minecraft/class_1799;", "derelict"})
@SourceDebugExtension(value={"SMAP\nSpiderEggProjectile.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpiderEggProjectile.kt\ndev/mim1q/derelict/entity/projectile/SpiderEggProjectile\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,73:1\n1863#2,2:74\n*S KotlinDebug\n*F\n+ 1 SpiderEggProjectile.kt\ndev/mim1q/derelict/entity/projectile/SpiderEggProjectile\n*L\n46#1:74,2\n*E\n"})
public final class SpiderEggProjectile
extends class_1665 {
    public SpiderEggProjectile(@NotNull class_1299<? extends class_1665> type, @NotNull class_1937 world) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        super(type, world);
    }

    protected void method_7454(@NotNull class_3966 entityHitResult) {
        Intrinsics.checkNotNullParameter((Object)entityHitResult, (String)"entityHitResult");
        super.method_7454(entityHitResult);
        class_243 class_2432 = entityHitResult.method_17784();
        Intrinsics.checkNotNullExpressionValue((Object)class_2432, (String)"getPos(...)");
        this.explodeIntoSpiderling(class_2432);
    }

    protected void method_24920(@NotNull class_3965 blockHitResult) {
        Intrinsics.checkNotNullParameter((Object)blockHitResult, (String)"blockHitResult");
        super.method_24920(blockHitResult);
        class_243 class_2432 = blockHitResult.method_17784();
        Intrinsics.checkNotNullExpressionValue((Object)class_2432, (String)"getPos(...)");
        this.explodeIntoSpiderling(class_2432);
    }

    private final void explodeIntoSpiderling(class_243 pos) {
        if (this.method_37908().field_9236) {
            return;
        }
        class_1937 class_19372 = this.method_37908();
        class_3218 class_32182 = class_19372 instanceof class_3218 ? (class_3218)class_19372 : null;
        if (class_32182 != null) {
            class_32182.method_14199((class_2394)class_2398.field_11236, pos.field_1352, pos.field_1351 + 1.0, pos.field_1350, 3, 0.8, 0.8, 0.8, 0.01);
        }
        List list = this.method_37908().method_8333((class_1297)this, class_238.method_30048((class_243)pos, (double)4.0, (double)4.0, (double)4.0), arg_0 -> SpiderEggProjectile.explodeIntoSpiderling$lambda$1(SpiderEggProjectile::explodeIntoSpiderling$lambda$0, arg_0));
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getOtherEntities(...)");
        Iterable $this$forEach$iv = list;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            class_1297 it = (class_1297)element$iv;
            boolean bl = false;
            it.method_5643(this.method_48923().method_48819((class_1297)this, this.method_24921()), 6.0f);
        }
        SpiderlingEntity spiderlingEntity = (SpiderlingEntity)ModEntities.INSTANCE.getSPIDERLING_ALLY().method_5883(this.method_37908());
        if (spiderlingEntity == null) {
            return;
        }
        SpiderlingEntity spiderling = spiderlingEntity;
        spiderling.method_33574(pos);
        spiderling.method_5808(spiderling.method_23317(), spiderling.method_23318(), spiderling.method_23321(), this.field_5974.method_43057() * 360.0f, 0.0f);
        SpiderlingEntity.Ally ally = spiderling instanceof SpiderlingEntity.Ally ? (SpiderlingEntity.Ally)spiderling : null;
        if (ally != null) {
            class_1297 class_12972 = this.method_24921();
            ally.setOwner(class_12972 != null ? class_12972.method_5667() : null);
        }
        class_1588 class_15882 = (class_1588)this.method_37908().method_18468(this.method_37908().method_8390(class_1588.class, class_238.method_30048((class_243)pos, (double)4.0, (double)4.0, (double)4.0), arg_0 -> SpiderEggProjectile.explodeIntoSpiderling$lambda$4(SpiderEggProjectile::explodeIntoSpiderling$lambda$3, arg_0)), class_4051.field_18092, (class_1309)spiderling, this.method_23317(), this.method_23318(), this.method_23321());
        if (class_15882 != null) {
            class_1588 it = class_15882;
            boolean bl = false;
            spiderling.method_5980((class_1309)it);
        }
        this.method_37908().method_8649((class_1297)spiderling);
        this.method_31472();
    }

    @NotNull
    protected class_3414 method_7440() {
        class_3414 class_34142 = class_3417.field_15197;
        Intrinsics.checkNotNullExpressionValue((Object)class_34142, (String)"ENTITY_ITEM_PICKUP");
        return class_34142;
    }

    @NotNull
    protected class_1799 method_7445() {
        class_1799 class_17992 = class_1799.field_8037;
        Intrinsics.checkNotNullExpressionValue((Object)class_17992, (String)"EMPTY");
        return class_17992;
    }

    private static final boolean explodeIntoSpiderling$lambda$0(class_1297 it) {
        return !(it instanceof SpiderlingEntity.Ally);
    }

    private static final boolean explodeIntoSpiderling$lambda$1(Function1 $tmp0, Object p0) {
        Intrinsics.checkNotNullParameter((Object)$tmp0, (String)"$tmp0");
        return (Boolean)$tmp0.invoke(p0);
    }

    private static final boolean explodeIntoSpiderling$lambda$3(class_1588 it) {
        return !(it instanceof SpiderlingEntity.Ally);
    }

    private static final boolean explodeIntoSpiderling$lambda$4(Function1 $tmp0, Object p0) {
        Intrinsics.checkNotNullParameter((Object)$tmp0, (String)"$tmp0");
        return (Boolean)$tmp0.invoke(p0);
    }
}

