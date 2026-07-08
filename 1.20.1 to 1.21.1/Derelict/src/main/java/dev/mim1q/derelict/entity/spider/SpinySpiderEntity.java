/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.mim1q.gimm1q.interpolation.Easing
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  net.minecraft.class_1282
 *  net.minecraft.class_1291
 *  net.minecraft.class_1293
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1309
 *  net.minecraft.class_1314
 *  net.minecraft.class_1352
 *  net.minecraft.class_1359
 *  net.minecraft.class_1399
 *  net.minecraft.class_1400
 *  net.minecraft.class_1439
 *  net.minecraft.class_1628
 *  net.minecraft.class_1657
 *  net.minecraft.class_1922
 *  net.minecraft.class_1927
 *  net.minecraft.class_1937
 *  net.minecraft.class_1937$class_7867
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_2392
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_2940
 *  net.minecraft.class_2941
 *  net.minecraft.class_2943
 *  net.minecraft.class_2945
 *  net.minecraft.class_3218
 *  net.minecraft.class_3417
 *  net.minecraft.class_3532
 *  net.minecraft.class_5362
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.entity.spider;

import dev.mim1q.derelict.init.ModStatusEffects;
import dev.mim1q.gimm1q.interpolation.Easing;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import net.minecraft.class_1282;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1314;
import net.minecraft.class_1352;
import net.minecraft.class_1359;
import net.minecraft.class_1399;
import net.minecraft.class_1400;
import net.minecraft.class_1439;
import net.minecraft.class_1628;
import net.minecraft.class_1657;
import net.minecraft.class_1922;
import net.minecraft.class_1927;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_2392;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_2940;
import net.minecraft.class_2941;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_3218;
import net.minecraft.class_3417;
import net.minecraft.class_3532;
import net.minecraft.class_5362;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001f\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014\u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014\u00a2\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\f\u0010\nJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\u0014\u0010\nJ\u0015\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0019\u00a8\u0006\u001c"}, d2={"Ldev/mim1q/derelict/entity/spider/SpinySpiderEntity;", "Lnet/minecraft/class_1628;", "Lnet/minecraft/class_1299;", "entityType", "Lnet/minecraft/class_1937;", "world", "<init>", "(Lnet/minecraft/class_1299;Lnet/minecraft/class_1937;)V", "", "initGoals", "()V", "initDataTracker", "tick", "Lnet/minecraft/class_1282;", "source", "", "amount", "", "damage", "(Lnet/minecraft/class_1282;F)Z", "explode", "tickDelta", "getFuse", "(F)F", "prevFuse", "F", "fuse", "Companion", "derelict"})
@SourceDebugExtension(value={"SMAP\nSpinySpiderEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpinySpiderEntity.kt\ndev/mim1q/derelict/entity/spider/SpinySpiderEntity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,154:1\n1863#2,2:155\n*S KotlinDebug\n*F\n+ 1 SpinySpiderEntity.kt\ndev/mim1q/derelict/entity/spider/SpinySpiderEntity\n*L\n130#1:155,2\n*E\n"})
public final class SpinySpiderEntity
extends class_1628 {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private float prevFuse;
    private float fuse;
    @NotNull
    private static final class_2940<Integer> FUSE_SPEED;

    public SpinySpiderEntity(@NotNull class_1299<? extends class_1628> entityType, @NotNull class_1937 world) {
        Intrinsics.checkNotNullParameter(entityType, (String)"entityType");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        super(entityType, world);
    }

    protected void method_5959() {
        super.method_5959();
        this.method_47825(SpinySpiderEntity::initGoals$lambda$0);
        this.field_6185.method_35113(SpinySpiderEntity::initGoals$lambda$1);
        this.field_6185.method_6277(1, (class_1352)new class_1399((class_1314)this, new Class[0]));
        this.field_6185.method_6277(2, (class_1352)new class_1400((class_1308)this, class_1657.class, true));
        this.field_6185.method_6277(3, (class_1352)new class_1400((class_1308)this, class_1439.class, true));
    }

    protected void method_5693() {
        super.method_5693();
        this.field_6011.method_12784(FUSE_SPEED, (Object)-1);
    }

    public void method_5773() {
        super.method_5773();
        Integer fuseSpeed = (Integer)this.field_6011.method_12789(FUSE_SPEED);
        this.prevFuse = this.fuse;
        Intrinsics.checkNotNull((Object)fuseSpeed);
        this.fuse = Math.max(this.fuse + (float)fuseSpeed.intValue(), 0.0f);
        if (!this.method_37908().field_9236) {
            int n = -1;
            if (fuseSpeed == n && this.method_37908().method_18460((class_1297)this, 2.0) != null) {
                this.field_6011.method_12778(FUSE_SPEED, (Object)1);
                this.method_5783(class_3417.field_15079, 1.0f, 1.0f);
            } else {
                n = 1;
                if (fuseSpeed == n && this.method_37908().method_18460((class_1297)this, 4.0) == null) {
                    this.field_6011.method_12778(FUSE_SPEED, (Object)-1);
                }
            }
            if (this.fuse > 30.0f) {
                this.explode();
            }
        }
    }

    public boolean method_5643(@NotNull class_1282 source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        class_1297 class_12972 = source.method_5529();
        boolean bl = class_12972 != null ? class_12972.method_31747() : false;
        if (bl) {
            class_1297 class_12973 = source.method_5529();
            Intrinsics.checkNotNull((Object)class_12973);
            class_12973.method_5643(this.method_37908().method_48963().method_48818((class_1297)this), class_3532.method_15363((float)(amount * 0.2f), (float)1.0f, (float)5.0f));
        }
        return super.method_5643(source, amount);
    }

    private final void explode() {
        this.field_6272 = true;
        this.method_31472();
        this.method_37908().method_46407((class_1297)this, null, new class_5362(){

            public boolean method_29554(class_1927 explosion, class_1922 world, class_2338 pos, class_2680 state, float power) {
                Intrinsics.checkNotNullParameter((Object)explosion, (String)"explosion");
                Intrinsics.checkNotNullParameter((Object)world, (String)"world");
                Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
                Intrinsics.checkNotNullParameter((Object)state, (String)"state");
                return false;
            }
        }, this.method_19538().method_1031(0.0, 0.5, 0.0), 1.5f, false, class_1937.class_7867.field_40890);
        class_1937 class_19372 = this.method_37908();
        class_3218 class_32182 = class_19372 instanceof class_3218 ? (class_3218)class_19372 : null;
        if (class_32182 != null) {
            class_32182.method_14199((class_2394)new class_2392(class_2398.field_11218, class_2246.field_10343.method_8389().method_7854()), this.method_19538().field_1352 + 0.5, this.method_19538().field_1351 + 0.5, this.method_19538().field_1350 + 0.5, 40, 0.5, 0.5, 0.5, 0.3);
        }
        List list = this.method_37908().method_8333((class_1297)this, class_238.method_30048((class_243)this.method_19538(), (double)4.0, (double)4.0, (double)4.0), arg_0 -> SpinySpiderEntity.explode$lambda$3(arg_0 -> SpinySpiderEntity.explode$lambda$2(this, arg_0), arg_0));
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getOtherEntities(...)");
        Iterable $this$forEach$iv = list;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            class_1297 it = (class_1297)element$iv;
            boolean bl = false;
            if (!(it instanceof class_1309) || it instanceof SpinySpiderEntity) continue;
            class_1293 class_12932 = ((class_1309)it).method_6112((class_1291)ModStatusEffects.INSTANCE.getCOBWEBBED());
            int currentLevel = class_12932 != null ? class_12932.method_5578() : -1;
            ((class_1309)it).method_6092(new class_1293((class_1291)ModStatusEffects.INSTANCE.getCOBWEBBED(), 60, RangesKt.coerceAtMost((int)(currentLevel + 1), (int)2), true, true, false));
        }
    }

    public final float getFuse(float tickDelta) {
        return Easing.lerp((float)this.prevFuse, (float)this.fuse, (float)tickDelta) / 28.0f;
    }

    private static final boolean initGoals$lambda$0(class_1352 it) {
        return it instanceof class_1359;
    }

    private static final boolean initGoals$lambda$1(class_1352 it) {
        return true;
    }

    private static final boolean explode$lambda$2(SpinySpiderEntity this$0, class_1297 it) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return (double)it.method_5739((class_1297)this$0) <= 4.0;
    }

    private static final boolean explode$lambda$3(Function1 $tmp0, Object p0) {
        Intrinsics.checkNotNullParameter((Object)$tmp0, (String)"$tmp0");
        return (Boolean)$tmp0.invoke(p0);
    }

    static {
        class_2940 class_29402 = class_2945.method_12791(SpinySpiderEntity.class, (class_2941)class_2943.field_13327);
        Intrinsics.checkNotNullExpressionValue((Object)class_29402, (String)"registerData(...)");
        FUSE_SPEED = class_29402;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Ldev/mim1q/derelict/entity/spider/SpinySpiderEntity$Companion;", "", "<init>", "()V", "Lnet/minecraft/class_2940;", "", "FUSE_SPEED", "Lnet/minecraft/class_2940;", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

