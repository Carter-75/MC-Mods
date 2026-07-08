/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1297
 *  net.minecraft.class_1936
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  net.minecraft.class_2394
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_2769
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5778
 *  net.minecraft.class_5819
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.block.cobweb;

import dev.mim1q.derelict.block.cobweb.FancyCobwebBlock;
import dev.mim1q.derelict.init.ModParticles;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1297;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_2394;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_2769;
import net.minecraft.class_4970;
import net.minecraft.class_5778;
import net.minecraft.class_5819;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J?\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ/\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016\u00a2\u0006\u0004\b\u001f\u0010 J'\u0010!\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b!\u0010\"\u00a8\u0006#"}, d2={"Ldev/mim1q/derelict/block/cobweb/FancyCobwebWithSpiderNestBlock;", "Ldev/mim1q/derelict/block/cobweb/FancyCobwebBlock;", "Lnet/minecraft/class_4970$class_2251;", "settings", "<init>", "(Lnet/minecraft/class_4970$class_2251;)V", "Lnet/minecraft/class_2680;", "state", "Lnet/minecraft/class_1936;", "world", "Lnet/minecraft/class_2338;", "blockPos", "Lnet/minecraft/class_5819;", "random", "", "chance", "", "speed", "", "spawnParticle", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_1936;Lnet/minecraft/class_2338;Lnet/minecraft/class_5819;FD)V", "", "Lnet/minecraft/class_2350;", "getDirections", "(Lnet/minecraft/class_2680;)Ljava/util/List;", "Lnet/minecraft/class_1937;", "pos", "randomDisplayTick", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;Lnet/minecraft/class_5819;)V", "Lnet/minecraft/class_1297;", "entity", "onEntityCollision", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;Lnet/minecraft/class_1297;)V", "onBroken", "(Lnet/minecraft/class_1936;Lnet/minecraft/class_2338;Lnet/minecraft/class_2680;)V", "derelict"})
@SourceDebugExtension(value={"SMAP\nFancyCobwebWithSpiderNestBlock.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FancyCobwebWithSpiderNestBlock.kt\ndev/mim1q/derelict/block/cobweb/FancyCobwebWithSpiderNestBlock\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,57:1\n774#2:58\n865#2,2:59\n*S KotlinDebug\n*F\n+ 1 FancyCobwebWithSpiderNestBlock.kt\ndev/mim1q/derelict/block/cobweb/FancyCobwebWithSpiderNestBlock\n*L\n34#1:58\n34#1:59,2\n*E\n"})
public final class FancyCobwebWithSpiderNestBlock
extends FancyCobwebBlock {
    public FancyCobwebWithSpiderNestBlock(@NotNull class_4970.class_2251 settings) {
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        super(settings, true);
    }

    private final void spawnParticle(class_2680 state, class_1936 world, class_2338 blockPos, class_5819 random, float chance, double speed) {
        if (random.method_43057() > chance) {
            return;
        }
        class_243 vel = new class_243(random.method_43058() - 0.5, 0.0, random.method_43058() - 0.5).method_1029().method_1021((random.method_43058() + 1.0) * speed);
        List<class_2350> directions = this.getDirections(state);
        if (directions.isEmpty()) {
            return;
        }
        class_2350 direction = (class_2350)CollectionsKt.toList((Iterable)directions).get(random.method_43048(directions.size()));
        class_243 pos = class_243.method_24953((class_2382)((class_2382)blockPos)).method_1019(class_243.method_24954((class_2382)direction.method_10163()).method_1021(0.49));
        world.method_8406((class_2394)ModParticles.INSTANCE.getSPIDER().get(direction), pos.field_1352, pos.field_1351, pos.field_1350, vel.field_1352, vel.field_1351, vel.field_1350);
    }

    /*
     * WARNING - void declaration
     */
    private final List<class_2350> getDirections(class_2680 state) {
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv = (Iterable)EntriesMappings.entries$0;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            class_2350 it = (class_2350)element$iv$iv;
            boolean bl = false;
            Comparable comparable = state.method_11654((class_2769)class_5778.method_33374((class_2350)it));
            Intrinsics.checkNotNullExpressionValue((Object)comparable, (String)"get(...)");
            if (!((Boolean)comparable).booleanValue()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return CollectionsKt.toList((Iterable)((List)destination$iv$iv));
    }

    public void method_9496(@NotNull class_2680 state, @NotNull class_1937 world, @NotNull class_2338 pos, @NotNull class_5819 random) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        this.spawnParticle(state, (class_1936)world, pos, random, 0.5f, 0.03);
    }

    @Override
    public void method_9548(@NotNull class_2680 state, @NotNull class_1937 world, @NotNull class_2338 pos, @NotNull class_1297 entity) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        if (world.field_9236 && entity.method_5709()) {
            int times = !(entity.field_6014 == entity.method_23317()) || !(entity.field_6036 == entity.method_23318()) || !(entity.field_5969 == entity.method_23321()) ? 4 : 2;
            int n = 0;
            while (n < times) {
                int it = n++;
                boolean bl = false;
                class_1936 class_19362 = (class_1936)world;
                class_5819 class_58192 = world.field_9229;
                Intrinsics.checkNotNullExpressionValue((Object)class_58192, (String)"random");
                this.spawnParticle(state, class_19362, pos, class_58192, 0.5f, 0.05);
            }
        }
        super.method_9548(state, world, pos, entity);
    }

    public void method_9585(@NotNull class_1936 world, @NotNull class_2338 pos, @NotNull class_2680 state) {
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        super.method_9585(world, pos, state);
        int n = 16;
        int n2 = 0;
        while (n2 < n) {
            int it = n2++;
            boolean bl = false;
            class_5819 class_58192 = world.method_8409();
            Intrinsics.checkNotNullExpressionValue((Object)class_58192, (String)"getRandom(...)");
            this.spawnParticle(state, world, pos, class_58192, 1.0f, 0.07);
        }
    }

    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    public final class EntriesMappings {
        public static final /* synthetic */ EnumEntries<class_2350> entries$0;

        static {
            entries$0 = EnumEntriesKt.enumEntries((Enum[])((Enum[])class_2350.values()));
        }
    }
}

