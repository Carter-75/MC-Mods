/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.mim1q.gimm1q.interpolation.AnimatedProperty
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1309
 *  net.minecraft.class_1314
 *  net.minecraft.class_1352
 *  net.minecraft.class_1361
 *  net.minecraft.class_1376
 *  net.minecraft.class_1394
 *  net.minecraft.class_1657
 *  net.minecraft.class_1767
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  net.minecraft.class_2487
 *  net.minecraft.class_2680
 *  net.minecraft.class_2940
 *  net.minecraft.class_2941
 *  net.minecraft.class_2943
 *  net.minecraft.class_2945
 *  net.minecraft.class_3417
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.mim1q.derelict.entity.spider;

import dev.mim1q.derelict.entity.spider.legs.SpiderLegController;
import dev.mim1q.derelict.tag.ModBlockTags;
import dev.mim1q.gimm1q.interpolation.AnimatedProperty;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1314;
import net.minecraft.class_1352;
import net.minecraft.class_1361;
import net.minecraft.class_1376;
import net.minecraft.class_1394;
import net.minecraft.class_1657;
import net.minecraft.class_1767;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import net.minecraft.class_2487;
import net.minecraft.class_2680;
import net.minecraft.class_2940;
import net.minecraft.class_2941;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_3417;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 92\u00020\u0001:\u00019B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014\u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014\u00a2\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\f\u0010\nJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016\u00a2\u0006\u0004\b\u001e\u0010\u001dJ\u001f\u0010#\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0016\u00a2\u0006\u0004\b#\u0010$R\u0018\u0010%\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0017\u0010*\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0013\u00103\u001a\u0004\u0018\u0001008F\u00a2\u0006\u0006\u001a\u0004\b1\u00102R\u0017\u00105\u001a\u0002048\u0006\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108\u00a8\u0006:"}, d2={"Ldev/mim1q/derelict/entity/spider/DaddyLongLegsEntity;", "Lnet/minecraft/class_1314;", "Lnet/minecraft/class_1299;", "entityType", "Lnet/minecraft/class_1937;", "world", "<init>", "(Lnet/minecraft/class_1299;Lnet/minecraft/class_1937;)V", "", "initGoals", "()V", "initDataTracker", "tick", "Lnet/minecraft/class_1657;", "player", "Lnet/minecraft/class_1268;", "hand", "Lnet/minecraft/class_1269;", "interactMob", "(Lnet/minecraft/class_1657;Lnet/minecraft/class_1268;)Lnet/minecraft/class_1269;", "Lnet/minecraft/class_2338;", "songPosition", "", "playing", "setNearbySongPlaying", "(Lnet/minecraft/class_2338;Z)V", "Lnet/minecraft/class_2487;", "nbt", "writeCustomDataToNbt", "(Lnet/minecraft/class_2487;)V", "readCustomDataFromNbt", "Lnet/minecraft/class_2680;", "state", "Lnet/minecraft/class_243;", "multiplier", "slowMovement", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_243;)V", "songSource", "Lnet/minecraft/class_2338;", "isSongPlaying", "Z", "Ldev/mim1q/gimm1q/interpolation/AnimatedProperty;", "danceAnimation", "Ldev/mim1q/gimm1q/interpolation/AnimatedProperty;", "getDanceAnimation", "()Ldev/mim1q/gimm1q/interpolation/AnimatedProperty;", "danceOffsetVector", "Lnet/minecraft/class_243;", "Lnet/minecraft/class_1767;", "getSockColor", "()Lnet/minecraft/class_1767;", "sockColor", "Ldev/mim1q/derelict/entity/spider/legs/SpiderLegController;", "legController", "Ldev/mim1q/derelict/entity/spider/legs/SpiderLegController;", "getLegController", "()Ldev/mim1q/derelict/entity/spider/legs/SpiderLegController;", "Companion", "derelict"})
@SourceDebugExtension(value={"SMAP\nDaddyLongLegsEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DaddyLongLegsEntity.kt\ndev/mim1q/derelict/entity/spider/DaddyLongLegsEntity\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,166:1\n188#2,3:167\n*S KotlinDebug\n*F\n+ 1 DaddyLongLegsEntity.kt\ndev/mim1q/derelict/entity/spider/DaddyLongLegsEntity\n*L\n107#1:167,3\n*E\n"})
public final class DaddyLongLegsEntity
extends class_1314 {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private class_2338 songSource;
    private boolean isSongPlaying;
    @NotNull
    private final AnimatedProperty danceAnimation;
    @NotNull
    private class_243 danceOffsetVector;
    @NotNull
    private final SpiderLegController legController;
    @NotNull
    private static final Map<class_1792, class_1767> WOOL_TO_COLOR;
    @NotNull
    private static final class_2940<Integer> SOCK_COLOR;

    public DaddyLongLegsEntity(@NotNull class_1299<DaddyLongLegsEntity> entityType, @NotNull class_1937 world) {
        Intrinsics.checkNotNullParameter(entityType, (String)"entityType");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        super(entityType, world);
        this.danceAnimation = new AnimatedProperty(0.0f);
        class_243 class_2432 = class_243.field_1353;
        Intrinsics.checkNotNullExpressionValue((Object)class_2432, (String)"ZERO");
        this.danceOffsetVector = class_2432;
        Pair[] pairArray = new Pair[]{TuplesKt.to(() -> DaddyLongLegsEntity.legController$lambda$3(this), DaddyLongLegsEntity::legController$lambda$4), TuplesKt.to(() -> DaddyLongLegsEntity.legController$lambda$5(this), DaddyLongLegsEntity::legController$lambda$6), TuplesKt.to(() -> DaddyLongLegsEntity.legController$lambda$7(this), DaddyLongLegsEntity::legController$lambda$8), TuplesKt.to(() -> DaddyLongLegsEntity.legController$lambda$9(this), DaddyLongLegsEntity::legController$lambda$10), TuplesKt.to(() -> DaddyLongLegsEntity.legController$lambda$11(this), DaddyLongLegsEntity::legController$lambda$12), TuplesKt.to(() -> DaddyLongLegsEntity.legController$lambda$13(this), DaddyLongLegsEntity::legController$lambda$14), TuplesKt.to(() -> DaddyLongLegsEntity.legController$lambda$15(this), DaddyLongLegsEntity::legController$lambda$16), TuplesKt.to(() -> DaddyLongLegsEntity.legController$lambda$17(this), DaddyLongLegsEntity::legController$lambda$18)};
        this.legController = new SpiderLegController((class_1309)this, (Function0<Float>)((Function0)DaddyLongLegsEntity::legController$lambda$1), (Function0<Float>)((Function0)DaddyLongLegsEntity::legController$lambda$2), pairArray);
    }

    @NotNull
    public final AnimatedProperty getDanceAnimation() {
        return this.danceAnimation;
    }

    @Nullable
    public final class_1767 getSockColor() {
        class_1767 class_17672;
        Integer it = (Integer)this.field_6011.method_12789(SOCK_COLOR);
        boolean bl = false;
        Integer n = it;
        int n2 = -1;
        if (n != null && n == n2) {
            class_17672 = null;
        } else {
            Intrinsics.checkNotNull((Object)it);
            class_17672 = class_1767.method_7791((int)it);
        }
        return class_17672;
    }

    @NotNull
    public final SpiderLegController getLegController() {
        return this.legController;
    }

    protected void method_5959() {
        super.method_5959();
        this.field_6201.method_6277(4, (class_1352)new class_1394((class_1314)this, 1.0));
        this.field_6201.method_6277(3, (class_1352)new class_1361((class_1308)this, class_1657.class, 24.0f));
        this.field_6201.method_6277(3, (class_1352)new class_1376((class_1308)this));
    }

    protected void method_5693() {
        super.method_5693();
        this.field_6011.method_12784(SOCK_COLOR, (Object)-1);
    }

    public void method_5773() {
        block5: {
            block4: {
                super.method_5773();
                if (this.songSource == null) break block4;
                class_2338 class_23382 = this.songSource;
                Intrinsics.checkNotNull((Object)class_23382);
                if (class_23382.method_19769((class_2374)this.method_19538(), 3.46) && this.method_37908().method_8320(this.songSource).method_27852(class_2246.field_10223)) break block5;
            }
            this.isSongPlaying = false;
            this.songSource = null;
        }
        if (this.method_37908().field_9236) {
            this.legController.tick();
            boolean bl = this.isSongPlaying ? this.danceAnimation.transitionTo(1.0f, 20.0f) : this.danceAnimation.transitionTo(0.0f, 20.0f);
            this.danceOffsetVector = new class_243(Math.cos((double)this.field_6012 * 0.5), Math.sin((double)this.field_6012 * 0.5) - 1.0, 0.0).method_1021((double)this.danceAnimation.getValue());
        }
    }

    @NotNull
    protected class_1269 method_5992(@NotNull class_1657 player, @NotNull class_1268 hand) {
        boolean bl;
        class_1799 stack;
        block8: {
            Intrinsics.checkNotNullParameter((Object)player, (String)"player");
            Intrinsics.checkNotNullParameter((Object)hand, (String)"hand");
            stack = player.method_5998(hand);
            if (stack.method_31574(class_1802.field_8868) && this.getSockColor() != null) {
                if (!this.method_37908().field_9236) {
                    this.method_5783(class_3417.field_14975, 1.0f, 1.0f);
                    stack.method_7956(1, (class_1309)player, arg_0 -> DaddyLongLegsEntity.interactMob$lambda$19(hand, arg_0));
                    this.field_6011.method_12778(SOCK_COLOR, (Object)-1);
                }
                return class_1269.field_5812;
            }
            Map<class_1792, class_1767> $this$any$iv = WOOL_TO_COLOR;
            boolean $i$f$any = false;
            if ($this$any$iv.isEmpty()) {
                bl = false;
            } else {
                Iterator<Map.Entry<class_1792, class_1767>> iterator = $this$any$iv.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<class_1792, class_1767> element$iv;
                    Map.Entry<class_1792, class_1767> it = element$iv = iterator.next();
                    boolean bl2 = false;
                    if (!Intrinsics.areEqual((Object)it.getKey(), (Object)stack.method_7909())) continue;
                    bl = true;
                    break block8;
                }
                bl = false;
            }
        }
        if (bl) {
            class_1767 newColor = WOOL_TO_COLOR.get(stack.method_7909());
            if (newColor == this.getSockColor()) {
                return class_1269.field_5811;
            }
            if (!this.method_37908().field_9236) {
                this.method_5783(class_3417.field_15226, 1.0f, 1.0f);
                stack.method_7934(1);
                class_1767 class_17672 = WOOL_TO_COLOR.get(stack.method_7909());
                this.field_6011.method_12778(SOCK_COLOR, (Object)(class_17672 != null ? class_17672.method_7789() : -1));
            }
            return class_1269.field_5812;
        }
        class_1269 class_12692 = super.method_5992(player, hand);
        Intrinsics.checkNotNullExpressionValue((Object)class_12692, (String)"interactMob(...)");
        return class_12692;
    }

    public void method_6006(@NotNull class_2338 songPosition, boolean playing) {
        Intrinsics.checkNotNullParameter((Object)songPosition, (String)"songPosition");
        this.songSource = songPosition;
        this.isSongPlaying = playing;
    }

    public void method_5652(@NotNull class_2487 nbt) {
        Intrinsics.checkNotNullParameter((Object)nbt, (String)"nbt");
        super.method_5652(nbt);
        Integer n = (Integer)this.field_6011.method_12789(SOCK_COLOR);
        int n2 = -1;
        if (n == null || n != n2) {
            Object object = this.field_6011.method_12789(SOCK_COLOR);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"get(...)");
            nbt.method_10569("SockColor", ((Number)object).intValue());
        }
    }

    public void method_5749(@NotNull class_2487 nbt) {
        Intrinsics.checkNotNullParameter((Object)nbt, (String)"nbt");
        super.method_5749(nbt);
        if (nbt.method_10545("SockColor")) {
            this.field_6011.method_12778(SOCK_COLOR, (Object)nbt.method_10550("SockColor"));
        }
    }

    public void method_5844(@NotNull class_2680 state, @NotNull class_243 multiplier) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)multiplier, (String)"multiplier");
        if (!state.method_26164(ModBlockTags.INSTANCE.getCOBWEBS())) {
            super.method_5844(state, multiplier);
        }
    }

    private static final float legController$lambda$1() {
        return 2.0f;
    }

    private static final float legController$lambda$2() {
        return 2.0f;
    }

    private static final class_243 legController$lambda$3(DaddyLongLegsEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return this$0.danceOffsetVector.method_1031(0.25, 3.75, 0.09375);
    }

    private static final class_243 legController$lambda$4() {
        return new class_243(0.5, 0.0, 0.5);
    }

    private static final class_243 legController$lambda$5(DaddyLongLegsEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return this$0.danceOffsetVector.method_1031(0.25, 3.75, 0.03125);
    }

    private static final class_243 legController$lambda$6() {
        return new class_243(0.8, 0.0, 0.1);
    }

    private static final class_243 legController$lambda$7(DaddyLongLegsEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return this$0.danceOffsetVector.method_1031(0.25, 3.75, -0.03125);
    }

    private static final class_243 legController$lambda$8() {
        return new class_243(0.8, 0.0, -0.1);
    }

    private static final class_243 legController$lambda$9(DaddyLongLegsEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return this$0.danceOffsetVector.method_1031(0.25, 3.75, -0.09375);
    }

    private static final class_243 legController$lambda$10() {
        return new class_243(0.5, 0.0, -0.5);
    }

    private static final class_243 legController$lambda$11(DaddyLongLegsEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return this$0.danceOffsetVector.method_1031(-0.25, 3.75, 0.09375);
    }

    private static final class_243 legController$lambda$12() {
        return new class_243(-0.5, 0.0, 0.5);
    }

    private static final class_243 legController$lambda$13(DaddyLongLegsEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return this$0.danceOffsetVector.method_1031(-0.25, 3.75, 0.03125);
    }

    private static final class_243 legController$lambda$14() {
        return new class_243(-0.8, 0.0, 0.1);
    }

    private static final class_243 legController$lambda$15(DaddyLongLegsEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return this$0.danceOffsetVector.method_1031(-0.25, 3.75, -0.03125);
    }

    private static final class_243 legController$lambda$16() {
        return new class_243(-0.8, 0.0, -0.1);
    }

    private static final class_243 legController$lambda$17(DaddyLongLegsEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return this$0.danceOffsetVector.method_1031(-0.25, 3.75, -0.09375);
    }

    private static final class_243 legController$lambda$18() {
        return new class_243(-0.5, 0.0, -0.5);
    }

    private static final void interactMob$lambda$19(class_1268 $hand, class_1657 it) {
        Intrinsics.checkNotNullParameter((Object)$hand, (String)"$hand");
        it.method_20236($hand);
    }

    static {
        Pair[] pairArray = new Pair[]{TuplesKt.to((Object)class_2246.field_10446.method_8389(), (Object)class_1767.field_7952), TuplesKt.to((Object)class_2246.field_10222.method_8389(), (Object)class_1767.field_7967), TuplesKt.to((Object)class_2246.field_10423.method_8389(), (Object)class_1767.field_7944), TuplesKt.to((Object)class_2246.field_10146.method_8389(), (Object)class_1767.field_7963), TuplesKt.to((Object)class_2246.field_10113.method_8389(), (Object)class_1767.field_7957), TuplesKt.to((Object)class_2246.field_10314.method_8389(), (Object)class_1767.field_7964), TuplesKt.to((Object)class_2246.field_10095.method_8389(), (Object)class_1767.field_7946), TuplesKt.to((Object)class_2246.field_10490.method_8389(), (Object)class_1767.field_7947), TuplesKt.to((Object)class_2246.field_10028.method_8389(), (Object)class_1767.field_7961), TuplesKt.to((Object)class_2246.field_10170.method_8389(), (Object)class_1767.field_7942), TuplesKt.to((Object)class_2246.field_10619.method_8389(), (Object)class_1767.field_7955), TuplesKt.to((Object)class_2246.field_10294.method_8389(), (Object)class_1767.field_7951), TuplesKt.to((Object)class_2246.field_10514.method_8389(), (Object)class_1767.field_7966), TuplesKt.to((Object)class_2246.field_10259.method_8389(), (Object)class_1767.field_7945), TuplesKt.to((Object)class_2246.field_10215.method_8389(), (Object)class_1767.field_7958), TuplesKt.to((Object)class_2246.field_10459.method_8389(), (Object)class_1767.field_7954)};
        WOOL_TO_COLOR = MapsKt.mapOf((Pair[])pairArray);
        class_2940 class_29402 = class_2945.method_12791(DaddyLongLegsEntity.class, (class_2941)class_2943.field_13327);
        Intrinsics.checkNotNullExpressionValue((Object)class_29402, (String)"registerData(...)");
        SOCK_COLOR = class_29402;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R(\u0010\b\u001a\u0016\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\u0004\u0012\u00020\u00070\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2={"Ldev/mim1q/derelict/entity/spider/DaddyLongLegsEntity$Companion;", "", "<init>", "()V", "", "Lnet/minecraft/class_1792;", "kotlin.jvm.PlatformType", "Lnet/minecraft/class_1767;", "WOOL_TO_COLOR", "Ljava/util/Map;", "Lnet/minecraft/class_2940;", "", "SOCK_COLOR", "Lnet/minecraft/class_2940;", "getSOCK_COLOR", "()Lnet/minecraft/class_2940;", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final class_2940<Integer> getSOCK_COLOR() {
            return SOCK_COLOR;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

