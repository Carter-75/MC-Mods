/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.mim1q.gimm1q.interpolation.AnimatedProperty
 *  dev.mim1q.gimm1q.interpolation.Easing
 *  dev.mim1q.gimm1q.screenshake.ScreenShakeUtils
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.MapsKt
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  kotlin.reflect.KProperty
 *  net.minecraft.class_1259$class_1260
 *  net.minecraft.class_1259$class_1261
 *  net.minecraft.class_1282
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1297$class_4738
 *  net.minecraft.class_1297$class_5529
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1309
 *  net.minecraft.class_1313
 *  net.minecraft.class_1314
 *  net.minecraft.class_1352
 *  net.minecraft.class_1352$class_4134
 *  net.minecraft.class_1361
 *  net.minecraft.class_1366
 *  net.minecraft.class_1376
 *  net.minecraft.class_1400
 *  net.minecraft.class_1588
 *  net.minecraft.class_1657
 *  net.minecraft.class_1922
 *  net.minecraft.class_1927
 *  net.minecraft.class_1937
 *  net.minecraft.class_1937$class_7867
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_243
 *  net.minecraft.class_2487
 *  net.minecraft.class_2680
 *  net.minecraft.class_2940
 *  net.minecraft.class_2941
 *  net.minecraft.class_2943
 *  net.minecraft.class_2945
 *  net.minecraft.class_3213
 *  net.minecraft.class_3218
 *  net.minecraft.class_3222
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_4050
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_5134
 *  net.minecraft.class_5362
 *  net.minecraft.class_5819
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.mim1q.derelict.entity.boss;

import dev.mim1q.derelict.entity.boss.ArachneEntity;
import dev.mim1q.derelict.entity.goal.ReturnGoal;
import dev.mim1q.derelict.entity.goal.TickingGoal;
import dev.mim1q.derelict.entity.projectile.SpiderSilkBolaProjectile;
import dev.mim1q.derelict.entity.spider.control.ArachneBodyControl;
import dev.mim1q.derelict.entity.spider.legs.SpiderLegController;
import dev.mim1q.derelict.init.ModEntities;
import dev.mim1q.derelict.tag.ModBlockTags;
import dev.mim1q.derelict.tag.ModEntityTags;
import dev.mim1q.derelict.util.MathUtilsKt;
import dev.mim1q.derelict.util.entity.TrackedDataIntAsEnumDelegate;
import dev.mim1q.derelict.util.extensions.MathExtensionsKt;
import dev.mim1q.gimm1q.interpolation.AnimatedProperty;
import dev.mim1q.gimm1q.interpolation.Easing;
import dev.mim1q.gimm1q.screenshake.ScreenShakeUtils;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_1259;
import net.minecraft.class_1282;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1313;
import net.minecraft.class_1314;
import net.minecraft.class_1352;
import net.minecraft.class_1361;
import net.minecraft.class_1366;
import net.minecraft.class_1376;
import net.minecraft.class_1400;
import net.minecraft.class_1588;
import net.minecraft.class_1657;
import net.minecraft.class_1922;
import net.minecraft.class_1927;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_243;
import net.minecraft.class_2487;
import net.minecraft.class_2680;
import net.minecraft.class_2940;
import net.minecraft.class_2941;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_3213;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_4050;
import net.minecraft.class_5132;
import net.minecraft.class_5134;
import net.minecraft.class_5362;
import net.minecraft.class_5819;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u00d7\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b&*\u0001L\u0018\u0000 \u00a4\u00012\u00020\u0001:\u0004\u00a5\u0001\u00a4\u0001B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014\u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\bH\u0014\u00a2\u0006\u0004\b\u001a\u0010\nJ\u001b\u0010\u001d\u001a\u00020\b2\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0002\u00a2\u0006\u0004\b \u0010!J5\u0010'\u001a\u00028\u0000\"\u0004\b\u0000\u0010\"2\u0006\u0010#\u001a\u00028\u00002\u0006\u0010$\u001a\u00028\u00002\u0006\u0010%\u001a\u00028\u00002\u0006\u0010&\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u001fH\u0002\u00a2\u0006\u0004\b)\u0010!J\u000f\u0010*\u001a\u00020\u001fH\u0002\u00a2\u0006\u0004\b*\u0010!J\u0017\u0010,\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u001fH\u0002\u00a2\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\u0013\u00a2\u0006\u0004\b.\u0010/J\u0017\u00103\u001a\u0002022\u0006\u00101\u001a\u000200H\u0016\u00a2\u0006\u0004\b3\u00104J'\u0010:\u001a\u0002092\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u0002052\u0006\u00108\u001a\u000205H\u0002\u00a2\u0006\u0004\b:\u0010;J\u0017\u0010>\u001a\u00020\b2\u0006\u0010=\u001a\u00020<H\u0016\u00a2\u0006\u0004\b>\u0010?J\u0017\u0010@\u001a\u00020\b2\u0006\u0010=\u001a\u00020<H\u0016\u00a2\u0006\u0004\b@\u0010?J\u001f\u0010D\u001a\u00020\b2\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u000209H\u0016\u00a2\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\bH\u0002\u00a2\u0006\u0004\bF\u0010\nJ\u0017\u0010I\u001a\u00020\b2\u0006\u0010H\u001a\u00020GH\u0016\u00a2\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020\bH\u0014\u00a2\u0006\u0004\bK\u0010\nJ\u000f\u0010M\u001a\u00020LH\u0002\u00a2\u0006\u0004\bM\u0010NJ\u000f\u0010O\u001a\u00020LH\u0002\u00a2\u0006\u0004\bO\u0010NJ\u000f\u0010P\u001a\u00020LH\u0002\u00a2\u0006\u0004\bP\u0010NJ\u000f\u0010Q\u001a\u00020LH\u0002\u00a2\u0006\u0004\bQ\u0010NJ\u0085\u0001\u0010^\u001a\u00020L2\u0006\u0010S\u001a\u00020R2\u0006\u0010T\u001a\u00020\u001f2!\u0010Y\u001a\u001d\u0012\u0013\u0012\u00110\u001f\u00a2\u0006\f\bV\u0012\b\bW\u0012\u0004\b\b(X\u0012\u0004\u0012\u00020\b0U2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u000e0Z2\u000e\b\u0002\u0010\\\u001a\b\u0012\u0004\u0012\u00020\b0Z2#\b\u0002\u0010]\u001a\u001d\u0012\u0013\u0012\u00110\u001f\u00a2\u0006\f\bV\u0012\b\bW\u0012\u0004\b\b(X\u0012\u0004\u0012\u00020\u000e0UH\u0002\u00a2\u0006\u0004\b^\u0010_J\u0017\u0010b\u001a\u00020\u000e2\u0006\u0010a\u001a\u00020`H\u0016\u00a2\u0006\u0004\bb\u0010cJ\u0017\u0010d\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020GH\u0016\u00a2\u0006\u0004\bd\u0010eJ\u001f\u0010i\u001a\u00020\b2\u0006\u0010f\u001a\u00020`2\u0006\u0010h\u001a\u00020gH\u0014\u00a2\u0006\u0004\bi\u0010jJ\u000f\u0010k\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\bk\u0010\u0010J\u0017\u0010n\u001a\u00020\b2\u0006\u0010m\u001a\u00020lH\u0016\u00a2\u0006\u0004\bn\u0010oJ\u0017\u0010p\u001a\u00020\b2\u0006\u0010m\u001a\u00020lH\u0016\u00a2\u0006\u0004\bp\u0010oR$\u0010r\u001a\u0004\u0018\u00010q8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\br\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u0014\u0010y\u001a\u00020x8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\by\u0010zR\u0017\u0010|\u001a\u00020{8\u0006\u00a2\u0006\f\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007fR\u001d\u0010\u0081\u0001\u001a\u00030\u0080\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001d\u0010\u0085\u0001\u001a\u00030\u0080\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u0085\u0001\u0010\u0082\u0001\u001a\u0006\b\u0086\u0001\u0010\u0084\u0001R\u001d\u0010\u0087\u0001\u001a\u00030\u0080\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u0087\u0001\u0010\u0082\u0001\u001a\u0006\b\u0088\u0001\u0010\u0084\u0001R\u001d\u0010\u0089\u0001\u001a\u00030\u0080\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u0089\u0001\u0010\u0082\u0001\u001a\u0006\b\u008a\u0001\u0010\u0084\u0001R\u001d\u0010\u008b\u0001\u001a\u00030\u0080\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u008b\u0001\u0010\u0082\u0001\u001a\u0006\b\u008c\u0001\u0010\u0084\u0001R\u001d\u0010\u008d\u0001\u001a\u00030\u0080\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u008d\u0001\u0010\u0082\u0001\u001a\u0006\b\u008e\u0001\u0010\u0084\u0001R\u0019\u0010\u008f\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0019\u0010\u0091\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0019\u0010\u0093\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0093\u0001\u0010\u0092\u0001R\u0019\u0010\u0094\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0090\u0001R3\u0010\u009c\u0001\u001a\u00020R2\u0007\u0010\u0095\u0001\u001a\u00020R8B@BX\u0082\u008e\u0002\u00a2\u0006\u0018\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0019\u0010\u009d\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009d\u0001\u0010\u0090\u0001R\u0019\u0010\u009e\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009e\u0001\u0010\u0090\u0001R\u0019\u0010\u009f\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009f\u0001\u0010\u0090\u0001R\u0019\u0010\u00a0\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a0\u0001\u0010\u0090\u0001R\u0019\u0010\u00a1\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a1\u0001\u0010\u0090\u0001R\u0019\u0010\u00a2\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a2\u0001\u0010\u0092\u0001R\u0019\u0010\u00a3\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a3\u0001\u0010\u0090\u0001\u00a8\u0006\u00a6\u0001"}, d2={"Ldev/mim1q/derelict/entity/boss/ArachneEntity;", "Lnet/minecraft/class_1588;", "Lnet/minecraft/class_1299;", "entityType", "Lnet/minecraft/class_1937;", "world", "<init>", "(Lnet/minecraft/class_1299;Lnet/minecraft/class_1937;)V", "", "initGoals", "()V", "tick", "processScreaming", "handleAnimations", "", "shouldShake", "()Z", "shouldRaiseLegs", "shouldRaiseFangs", "", "bodyYaw", "setBodyYaw", "(F)V", "Ldev/mim1q/derelict/entity/spider/control/ArachneBodyControl;", "createBodyControl", "()Ldev/mim1q/derelict/entity/spider/control/ArachneBodyControl;", "initDataTracker", "Lnet/minecraft/class_2940;", "data", "onTrackedDataSet", "(Lnet/minecraft/class_2940;)V", "", "getStage", "()I", "T", "stage0", "stage1", "stage2", "stage3", "stageBasedValue", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getStompWait", "getStompInterval", "stage", "changeStage", "(I)V", "getScale", "()F", "Lnet/minecraft/class_4050;", "pose", "Lnet/minecraft/class_238;", "getBoundingBox", "(Lnet/minecraft/class_4050;)Lnet/minecraft/class_238;", "", "x", "y", "z", "Lnet/minecraft/class_243;", "ikVec", "(DDD)Lnet/minecraft/class_243;", "Lnet/minecraft/class_3222;", "player", "onStartedTrackingBy", "(Lnet/minecraft/class_3222;)V", "onStoppedTrackingBy", "Lnet/minecraft/class_2680;", "state", "multiplier", "slowMovement", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_243;)V", "setGlobalCooldown", "Lnet/minecraft/class_1282;", "damageSource", "onDeath", "(Lnet/minecraft/class_1282;)V", "updatePostDeath", "dev/mim1q/derelict/entity/boss/ArachneEntity.createArachneAttack.3", "createSmashAttack", "()Ldev/mim1q/derelict/entity/boss/ArachneEntity$createArachneAttack$3;", "createSpawnAttack", "createRushAttack", "createShootAttack", "Ldev/mim1q/derelict/entity/boss/ArachneEntity$ArachneAttackType;", "type", "duration", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ticks", "onTick", "Lkotlin/Function0;", "startPredicate", "cooldownSetter", "shouldContinue", "createArachneAttack", "(Ldev/mim1q/derelict/entity/boss/ArachneEntity$ArachneAttackType;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Ldev/mim1q/derelict/entity/boss/ArachneEntity$createArachneAttack$3;", "Lnet/minecraft/class_1297;", "target", "tryAttack", "(Lnet/minecraft/class_1297;)Z", "isInvulnerableTo", "(Lnet/minecraft/class_1282;)Z", "passenger", "Lnet/minecraft/class_1297$class_4738;", "positionUpdater", "updatePassengerPosition", "(Lnet/minecraft/class_1297;Lnet/minecraft/class_1297$class_4738;)V", "arePlayersNearby", "Lnet/minecraft/class_2487;", "nbt", "readCustomDataFromNbt", "(Lnet/minecraft/class_2487;)V", "writeCustomDataToNbt", "Lnet/minecraft/class_2338;", "spawnPos", "Lnet/minecraft/class_2338;", "getSpawnPos", "()Lnet/minecraft/class_2338;", "setSpawnPos", "(Lnet/minecraft/class_2338;)V", "Lnet/minecraft/class_3213;", "bossBar", "Lnet/minecraft/class_3213;", "Ldev/mim1q/derelict/entity/spider/legs/SpiderLegController;", "legController", "Ldev/mim1q/derelict/entity/spider/legs/SpiderLegController;", "getLegController", "()Ldev/mim1q/derelict/entity/spider/legs/SpiderLegController;", "Ldev/mim1q/gimm1q/interpolation/AnimatedProperty;", "legsRaisedAnimation", "Ldev/mim1q/gimm1q/interpolation/AnimatedProperty;", "getLegsRaisedAnimation", "()Ldev/mim1q/gimm1q/interpolation/AnimatedProperty;", "shakingAnimation", "getShakingAnimation", "leftLegStomp", "getLeftLegStomp", "rightLegStomp", "getRightLegStomp", "fangsAnimation", "getFangsAnimation", "deathAnimation", "getDeathAnimation", "screamingTicks", "I", "wasScreaming", "Z", "goalsSetup", "lastStage", "<set-?>", "currentAttack$delegate", "Ldev/mim1q/derelict/util/entity/TrackedDataIntAsEnumDelegate;", "getCurrentAttack", "()Ldev/mim1q/derelict/entity/boss/ArachneEntity$ArachneAttackType;", "setCurrentAttack", "(Ldev/mim1q/derelict/entity/boss/ArachneEntity$ArachneAttackType;)V", "currentAttack", "attackTicks", "stompCooldown", "spawnCooldown", "rushCooldown", "shootCooldown", "forceSpawnAttack", "playerInFangsTimer", "Companion", "ArachneAttackType", "derelict"})
@SourceDebugExtension(value={"SMAP\nArachneEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArachneEntity.kt\ndev/mim1q/derelict/entity/boss/ArachneEntity\n+ 2 EntityUtil.kt\ndev/mim1q/derelict/util/entity/EntityUtilKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,610:1\n28#2:611\n37#3,2:612\n1863#4,2:614\n1863#4,2:616\n*S KotlinDebug\n*F\n+ 1 ArachneEntity.kt\ndev/mim1q/derelict/entity/boss/ArachneEntity\n*L\n91#1:611\n91#1:612,2\n176#1:614,2\n393#1:616,2\n*E\n"})
public final class ArachneEntity
extends class_1588 {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @Nullable
    private class_2338 spawnPos;
    @NotNull
    private final class_3213 bossBar;
    @NotNull
    private final SpiderLegController legController;
    @NotNull
    private final AnimatedProperty legsRaisedAnimation;
    @NotNull
    private final AnimatedProperty shakingAnimation;
    @NotNull
    private final AnimatedProperty leftLegStomp;
    @NotNull
    private final AnimatedProperty rightLegStomp;
    @NotNull
    private final AnimatedProperty fangsAnimation;
    @NotNull
    private final AnimatedProperty deathAnimation;
    private int screamingTicks;
    private boolean wasScreaming;
    private boolean goalsSetup;
    private int lastStage;
    @NotNull
    private final TrackedDataIntAsEnumDelegate currentAttack$delegate;
    private int attackTicks;
    private int stompCooldown;
    private int spawnCooldown;
    private int rushCooldown;
    private int shootCooldown;
    private boolean forceSpawnAttack;
    private int playerInFangsTimer;
    @NotNull
    private static final class_2940<Boolean> SCREAMING;
    @NotNull
    private static final class_2940<Boolean> SHAKING;
    @NotNull
    private static final class_2940<Integer> CURRENT_ATTACK;

    /*
     * WARNING - void declaration
     */
    public ArachneEntity(@NotNull class_1299<ArachneEntity> entityType, @NotNull class_1937 world) {
        void data$iv;
        Intrinsics.checkNotNullParameter(entityType, (String)"entityType");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        super(entityType, world);
        this.field_5985 = true;
        this.bossBar = new class_3213(this.method_5477(), class_1259.class_1260.field_5784, class_1259.class_1261.field_5793);
        class_2940<Integer> class_29402 = new class_2940<Integer>[]{TuplesKt.to(() -> ArachneEntity.legController$lambda$2(this), () -> ArachneEntity.legController$lambda$3(this)), TuplesKt.to(() -> ArachneEntity.legController$lambda$4(this), () -> ArachneEntity.legController$lambda$5(this)), TuplesKt.to(() -> ArachneEntity.legController$lambda$6(this), () -> ArachneEntity.legController$lambda$7(this)), TuplesKt.to(() -> ArachneEntity.legController$lambda$8(this), () -> ArachneEntity.legController$lambda$9(this)), TuplesKt.to(() -> ArachneEntity.legController$lambda$10(this), () -> ArachneEntity.legController$lambda$11(this)), TuplesKt.to(() -> ArachneEntity.legController$lambda$12(this), () -> ArachneEntity.legController$lambda$13(this)), TuplesKt.to(() -> ArachneEntity.legController$lambda$14(this), () -> ArachneEntity.legController$lambda$15(this)), TuplesKt.to(() -> ArachneEntity.legController$lambda$16(this), () -> ArachneEntity.legController$lambda$17(this))};
        this.legController = new SpiderLegController((class_1309)this, (Function0<Float>)((Function0)() -> ArachneEntity.legController$lambda$0(this)), (Function0<Float>)((Function0)() -> ArachneEntity.legController$lambda$1(this)), (Pair<? extends Function0<? extends class_243>, ? extends Function0<? extends class_243>>)class_29402);
        this.legsRaisedAnimation = new AnimatedProperty(0.0f, Easing::easeOutBack);
        this.shakingAnimation = new AnimatedProperty(0.0f, Easing::easeInOutCubic);
        this.leftLegStomp = new AnimatedProperty(0.0f, Easing::easeInOutCubic);
        this.rightLegStomp = new AnimatedProperty(0.0f, Easing::easeInOutCubic);
        this.fangsAnimation = new AnimatedProperty(0.0f, Easing::easeInOutCubic);
        this.deathAnimation = new AnimatedProperty(0.0f, Easing::easeInOutCubic);
        class_29402 = CURRENT_ATTACK;
        EnumEntries<ArachneAttackType> values$iv = ArachneAttackType.getEntries();
        boolean $i$f$trackedEnum = false;
        Collection $this$toTypedArray$iv$iv = (Collection)values$iv;
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv$iv = $this$toTypedArray$iv$iv;
        this.currentAttack$delegate = new TrackedDataIntAsEnumDelegate((class_2940)data$iv, (Enum[])thisCollection$iv$iv.toArray(new ArachneAttackType[0]));
        this.stompCooldown = 100;
        this.spawnCooldown = 600;
        this.rushCooldown = 400;
        this.shootCooldown = 80;
    }

    @Nullable
    public final class_2338 getSpawnPos() {
        return this.spawnPos;
    }

    public final void setSpawnPos(@Nullable class_2338 class_23382) {
        this.spawnPos = class_23382;
    }

    @NotNull
    public final SpiderLegController getLegController() {
        return this.legController;
    }

    @NotNull
    public final AnimatedProperty getLegsRaisedAnimation() {
        return this.legsRaisedAnimation;
    }

    @NotNull
    public final AnimatedProperty getShakingAnimation() {
        return this.shakingAnimation;
    }

    @NotNull
    public final AnimatedProperty getLeftLegStomp() {
        return this.leftLegStomp;
    }

    @NotNull
    public final AnimatedProperty getRightLegStomp() {
        return this.rightLegStomp;
    }

    @NotNull
    public final AnimatedProperty getFangsAnimation() {
        return this.fangsAnimation;
    }

    @NotNull
    public final AnimatedProperty getDeathAnimation() {
        return this.deathAnimation;
    }

    private final ArachneAttackType getCurrentAttack() {
        return (ArachneAttackType)((Object)this.currentAttack$delegate.getValue((class_1297)this, $$delegatedProperties[0]));
    }

    private final void setCurrentAttack(ArachneAttackType arachneAttackType) {
        this.currentAttack$delegate.setValue((class_1297)this, $$delegatedProperties[0], (Enum)arachneAttackType);
    }

    protected void method_5959() {
        if (this.field_6012 < 40 || this.goalsSetup) {
            return;
        }
        this.goalsSetup = true;
        this.field_6201.method_35113(ArachneEntity::initGoals$lambda$18);
        this.field_6201.method_6277(4, (class_1352)new class_1376((class_1308)this));
        this.field_6201.method_6277(3, (class_1352)new class_1361((class_1308)this, class_1657.class, 24.0f));
        this.field_6201.method_6277(2, (class_1352)new class_1366((class_1314)this, 0.6, true));
        this.field_6201.method_6277(1, (class_1352)this.createSmashAttack());
        this.field_6201.method_6277(1, (class_1352)this.createSpawnAttack());
        this.field_6201.method_6277(1, (class_1352)this.createRushAttack());
        this.field_6201.method_6277(1, (class_1352)this.createShootAttack());
        this.field_6201.method_6277(0, (class_1352)new ReturnGoal<class_1308>((class_1308)this, (Function0<Boolean>)((Function0)() -> ArachneEntity.initGoals$lambda$19(this)), (Function0<? extends class_2338>)((Function0)() -> ArachneEntity.initGoals$lambda$20(this))));
        if (this.field_6185.method_35115().isEmpty()) {
            this.field_6185.method_6277(0, (class_1352)new class_1400((class_1308)this, class_1657.class, false));
        }
    }

    public void method_5773() {
        if (this.method_37908().field_9236) {
            this.legController.tick();
            this.handleAnimations();
        } else {
            if (this.field_6012 == 45) {
                this.method_5959();
            }
            if (this.field_6012 % 5 == 0) {
                class_1657 passenger;
                class_1297 class_12972 = this.method_31483();
                class_1657 class_16572 = passenger = class_12972 instanceof class_1657 ? (class_1657)class_12972 : null;
                if (passenger != null) {
                    passenger.method_5643(this.method_48923().method_48812((class_1309)this), (float)this.method_26825(class_5134.field_23721));
                    if (this.playerInFangsTimer == 30) {
                        this.method_5783(class_3417.field_15016, 1.0f, 0.8f);
                        passenger.method_6092(new class_1293(class_1294.field_5899, 80, 1));
                    }
                    this.playerInFangsTimer += 5;
                } else {
                    this.playerInFangsTimer = 0;
                }
            }
            if (!this.field_6272) {
                this.processScreaming();
            }
            this.bossBar.method_5408(this.method_6032() / this.method_6063());
            int passenger = this.stompCooldown;
            this.stompCooldown = passenger + -1;
            passenger = this.spawnCooldown;
            this.spawnCooldown = passenger + -1;
            passenger = this.rushCooldown;
            this.rushCooldown = passenger + -1;
            passenger = this.shootCooldown;
            this.shootCooldown = passenger + -1;
            int currentStage = RangesKt.coerceAtLeast((int)this.getStage(), (int)this.lastStage);
            if (this.lastStage != currentStage) {
                class_1937 class_19372 = this.method_37908();
                class_3218 class_32182 = class_19372 instanceof class_3218 ? (class_3218)class_19372 : null;
                if (class_32182 != null) {
                    class_32182.method_14199((class_2394)class_2398.field_11221, this.method_19538().field_1352, this.method_19538().field_1351, this.method_19538().field_1350, 8, 2.0, 2.0, 2.0, 0.0);
                }
                this.method_5783(class_3417.field_15152, 1.0f, 0.8f);
                List list = this.method_37908().method_8390(class_1309.class, this.method_5829().method_1014(8.0), arg_0 -> ArachneEntity.tick$lambda$22(arg_0 -> ArachneEntity.tick$lambda$21(this, arg_0), arg_0));
                Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getEntitiesByClass(...)");
                Iterable $this$forEach$iv = list;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    class_1309 it = (class_1309)element$iv;
                    boolean bl = false;
                    it.method_6005(1.0, it.method_23317() - this.method_23317(), it.method_23321() - this.method_23321());
                }
                if (this.lastStage < currentStage) {
                    this.changeStage(currentStage);
                }
                this.lastStage = currentStage;
            }
            if (!this.arePlayersNearby() && this.field_6012 % 20 == 0) {
                this.method_6025(0.5f);
            }
        }
        int n = this.attackTicks;
        this.attackTicks = n + 1;
        super.method_5773();
    }

    private final void processScreaming() {
        this.wasScreaming = this.screamingTicks > 0;
        int n = this.screamingTicks;
        this.screamingTicks = n + -1;
        if (this.field_6012 == 20) {
            this.screamingTicks = 40;
        }
        this.field_6011.method_12778(SCREAMING, (Object)(this.screamingTicks > 0 ? 1 : 0));
        this.field_6011.method_12778(SHAKING, (Object)(this.screamingTicks > 0 ? 1 : 0));
        if (!this.wasScreaming && this.screamingTicks > 0) {
            class_1937 class_19372 = this.method_37908();
            Intrinsics.checkNotNull((Object)class_19372, (String)"null cannot be cast to non-null type net.minecraft.server.world.ServerWorld");
            ScreenShakeUtils.shakeAround((class_3218)((class_3218)class_19372), (class_243)this.method_19538(), (float)1.2f, (int)this.screamingTicks, (double)5.0, (double)30.0);
            this.method_37908().method_8396(null, this.method_24515(), class_3417.field_15170, class_3419.field_15251, 1.3f, 0.3f);
        }
    }

    private final void handleAnimations() {
        if (this.shouldShake()) {
            this.shakingAnimation.transitionTo(1.0f, 5.0f, Easing::easeInOutCubic);
        } else {
            this.shakingAnimation.transitionTo(0.0f, 20.0f, Easing::easeInOutCubic);
        }
        if (this.shouldRaiseLegs()) {
            this.legsRaisedAnimation.transitionTo(1.0f, 15.0f, Easing::easeOutBack);
        } else {
            this.legsRaisedAnimation.transitionTo(0.0f, 40.0f, Easing::easeInOutCubic);
        }
        if (this.shouldRaiseFangs()) {
            this.fangsAnimation.transitionTo(1.0f, 15.0f, Easing::easeOutBack);
        } else {
            this.fangsAnimation.transitionTo(0.0f, 15.0f, Easing::easeInOutCubic);
        }
        if (this.getCurrentAttack() == ArachneAttackType.SMASH) {
            if (this.attackTicks > this.getStompWait()) {
                int interval = this.getStompInterval();
                int n = this.attackTicks % interval;
                if (n == 1) {
                    this.leftLegStomp.transitionTo(1.0f, (float)interval / 2.0f, Easing::easeOutBounce);
                } else if (n == interval / 2 - 1) {
                    this.leftLegStomp.transitionTo(0.0f, (float)interval, Easing::easeInOutCubic);
                } else if (n == interval / 2 + 1) {
                    this.rightLegStomp.transitionTo(1.0f, (float)interval / 2.0f, Easing::easeOutBounce);
                } else if (n == interval - 1) {
                    this.rightLegStomp.transitionTo(0.0f, (float)interval, Easing::easeInOutCubic);
                }
            }
        } else {
            this.leftLegStomp.transitionTo(0.0f, 10.0f, Easing::easeInOutCubic);
            this.rightLegStomp.transitionTo(0.0f, 10.0f, Easing::easeInOutCubic);
        }
    }

    private final boolean shouldShake() {
        return (Boolean)this.field_6011.method_12789(SHAKING) != false ? true : this.getCurrentAttack() == ArachneAttackType.SPAWN && this.attackTicks < 100;
    }

    private final boolean shouldRaiseLegs() {
        return (Boolean)this.field_6011.method_12789(SCREAMING) != false ? true : this.getCurrentAttack() == ArachneAttackType.SMASH;
    }

    private final boolean shouldRaiseFangs() {
        return this.getCurrentAttack() == ArachneAttackType.SHOOT;
    }

    public void method_5636(float bodyYaw) {
        super.method_5636(MathUtilsKt.wrapDegrees(this.field_6283, bodyYaw, 10.0f));
    }

    @NotNull
    protected ArachneBodyControl createBodyControl() {
        return new ArachneBodyControl((class_1308)this, 0.0f, 2, null);
    }

    protected void method_5693() {
        super.method_5693();
        this.field_6011.method_12784(SCREAMING, (Object)false);
        this.field_6011.method_12784(SHAKING, (Object)false);
        this.field_6011.method_12784(CURRENT_ATTACK, (Object)0);
    }

    public void method_5674(@NotNull class_2940<?> data) {
        Intrinsics.checkNotNullParameter(data, (String)"data");
        if (Intrinsics.areEqual(data, CURRENT_ATTACK)) {
            this.attackTicks = 0;
        }
        super.method_5674(data);
    }

    private final int getStage() {
        int n;
        block1: {
            double d;
            float f;
            block0: {
                f = this.method_6032() / this.method_6063();
                d = f;
                boolean bl = 0.0 <= d ? d <= 0.25 : false;
                if (!bl) break block0;
                n = 3;
                break block1;
            }
            d = f;
            n = (0.25 <= d ? d <= 0.5 : false) ? 2 : ((0.5 <= (d = (double)f) ? d <= 0.75 : false) ? 1 : 0);
        }
        return n;
    }

    private final <T> T stageBasedValue(T stage0, T stage1, T stage2, T stage3) {
        return switch (this.getStage()) {
            case 0 -> stage0;
            case 1 -> stage1;
            case 2 -> stage2;
            default -> stage3;
        };
    }

    private final int getStompWait() {
        return ((Number)this.stageBasedValue(60, 55, 40, 20)).intValue();
    }

    private final int getStompInterval() {
        return ((Number)this.stageBasedValue(20, 16, 14, 10)).intValue();
    }

    private final void changeStage(int stage) {
        this.forceSpawnAttack = true;
        this.spawnCooldown = 80;
        this.stompCooldown = 80;
        this.rushCooldown = 80;
        this.shootCooldown = 80;
        this.screamingTicks = 40;
    }

    public final float getScale() {
        return 1.0f + 0.05f * (float)this.getStage();
    }

    @NotNull
    public class_238 method_24833(@NotNull class_4050 pose) {
        Intrinsics.checkNotNullParameter((Object)pose, (String)"pose");
        class_238 it = super.method_24833(pose);
        boolean bl = false;
        double scale = (double)(this.getScale() - 1.0f) * 0.5;
        class_238 class_2384 = it.method_1009(it.method_17939() * scale, it.method_17940() * scale, it.method_17941() * scale);
        Intrinsics.checkNotNullExpressionValue((Object)class_2384, (String)"let(...)");
        return class_2384;
    }

    private final class_243 ikVec(double x, double y, double z) {
        float scale = this.getScale();
        return new class_243(x * (double)scale, y * (double)scale, z * (double)scale);
    }

    public void method_5837(@NotNull class_3222 player) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        super.method_5837(player);
        this.bossBar.method_14088(player);
    }

    public void method_5742(@NotNull class_3222 player) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        super.method_5742(player);
        this.bossBar.method_14089(player);
    }

    public void method_5844(@NotNull class_2680 state, @NotNull class_243 multiplier) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)multiplier, (String)"multiplier");
        if (!state.method_26164(ModBlockTags.INSTANCE.getCOBWEBS())) {
            super.method_5844(state, multiplier);
        }
    }

    private final void setGlobalCooldown() {
        int cooldown = ((Number)this.stageBasedValue(30, 25, 20, 15)).intValue();
        this.spawnCooldown = RangesKt.coerceAtLeast((int)this.spawnCooldown, (int)cooldown);
        this.stompCooldown = RangesKt.coerceAtLeast((int)this.stompCooldown, (int)cooldown);
        this.rushCooldown = RangesKt.coerceAtLeast((int)this.rushCooldown, (int)cooldown);
    }

    public void method_6078(@NotNull class_1282 damageSource) {
        block0: {
            Intrinsics.checkNotNullParameter((Object)damageSource, (String)"damageSource");
            super.method_6078(damageSource);
            class_1937 class_19372 = this.method_37908();
            class_3218 class_32182 = class_19372 instanceof class_3218 ? (class_3218)class_19372 : null;
            if (class_32182 == null) break block0;
            class_3218 it = class_32182;
            boolean bl = false;
            ScreenShakeUtils.shakeAround((class_3218)it, (class_243)this.method_19538(), (float)1.5f, (int)60, (double)5.0, (double)30.0);
        }
    }

    protected void method_6108() {
        ++this.field_6213;
        if (this.method_37908().field_9236) {
            this.deathAnimation.transitionTo(1.0f, 60.0f);
        } else {
            this.field_6011.method_12778(SHAKING, (Object)(this.field_6213 < 60 ? 1 : 0));
        }
        if (this.field_6213 >= 100 && !this.method_37908().method_8608() && !this.method_31481()) {
            if (this.field_6213 == 100) {
                this.method_5783(class_3417.field_14579, 1.0f, 0.1f);
                this.method_5783(class_3417.field_14579, 1.0f, 0.2f);
                this.method_5783(class_3417.field_14579, 1.0f, 0.3f);
            }
            this.method_37908().method_8421((class_1297)this, (byte)60);
            this.method_5650(class_1297.class_5529.field_26998);
        }
    }

    private final createArachneAttack.3 createSmashAttack() {
        return ArachneEntity.createArachneAttack$default(this, ArachneAttackType.SMASH, 120, arg_0 -> ArachneEntity.createSmashAttack$lambda$27(this, arg_0), () -> ArachneEntity.createSmashAttack$lambda$28(this), () -> ArachneEntity.createSmashAttack$lambda$29(this), null, 32, null);
    }

    private final createArachneAttack.3 createSpawnAttack() {
        return ArachneEntity.createArachneAttack$default(this, ArachneAttackType.SPAWN, 300, arg_0 -> ArachneEntity.createSpawnAttack$lambda$30(this, arg_0), () -> ArachneEntity.createSpawnAttack$lambda$33(this), () -> ArachneEntity.createSpawnAttack$lambda$34(this), null, 32, null);
    }

    private final createArachneAttack.3 createRushAttack() {
        return this.createArachneAttack(ArachneAttackType.RUSH, 50, (Function1<? super Integer, Unit>)((Function1)arg_0 -> ArachneEntity.createRushAttack$lambda$35(this, arg_0)), (Function0<Boolean>)((Function0)() -> ArachneEntity.createRushAttack$lambda$36(this)), (Function0<Unit>)((Function0)() -> ArachneEntity.createRushAttack$lambda$37(this)), (Function1<? super Integer, Boolean>)((Function1)arg_0 -> ArachneEntity.createRushAttack$lambda$38(this, arg_0)));
    }

    private final createArachneAttack.3 createShootAttack() {
        return ArachneEntity.createArachneAttack$default(this, ArachneAttackType.SHOOT, 40, arg_0 -> ArachneEntity.createShootAttack$lambda$39(this, arg_0), () -> ArachneEntity.createShootAttack$lambda$40(this), () -> ArachneEntity.createShootAttack$lambda$41(this), null, 32, null);
    }

    private final createArachneAttack.3 createArachneAttack(ArachneAttackType type, int duration, Function1<? super Integer, Unit> onTick, Function0<Boolean> startPredicate, Function0<Unit> cooldownSetter, Function1<? super Integer, Boolean> shouldContinue) {
        Function0 function0 = () -> ArachneEntity.createArachneAttack$lambda$44(this, type);
        Function0 function02 = () -> ArachneEntity.createArachneAttack$lambda$45(this, cooldownSetter);
        Function0 function03 = () -> ArachneEntity.createArachneAttack$lambda$46(this, startPredicate);
        return new TickingGoal(duration, onTick, shouldContinue, (Function0<Unit>)function0, (Function0<Unit>)function02, (Function0<Boolean>)function03){
            {
                this.method_6271().add(class_1352.class_4134.field_18405);
            }
        };
    }

    static /* synthetic */ createArachneAttack.3 createArachneAttack$default(ArachneEntity arachneEntity, ArachneAttackType arachneAttackType, int n, Function1 function1, Function0 function0, Function0 function02, Function1 function12, int n2, Object object) {
        if ((n2 & 0x10) != 0) {
            function02 = ArachneEntity::createArachneAttack$lambda$42;
        }
        if ((n2 & 0x20) != 0) {
            function12 = ArachneEntity::createArachneAttack$lambda$43;
        }
        return arachneEntity.createArachneAttack(arachneAttackType, n, (Function1<? super Integer, Unit>)function1, (Function0<Boolean>)function0, (Function0<Unit>)function02, (Function1<? super Integer, Boolean>)function12);
    }

    public boolean method_6121(@NotNull class_1297 target) {
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        boolean result = super.method_6121(target);
        if (result && target instanceof class_1657 && this.field_5974.method_43057() < 0.1f) {
            target.method_5873((class_1297)this, true);
        }
        return result;
    }

    public boolean method_5679(@NotNull class_1282 damageSource) {
        Intrinsics.checkNotNullParameter((Object)damageSource, (String)"damageSource");
        return (Boolean)this.field_6011.method_12789(SCREAMING) != false || !this.arePlayersNearby() || super.method_5679(damageSource);
    }

    protected void method_5865(@NotNull class_1297 passenger, @NotNull class_1297.class_4738 positionUpdater) {
        Intrinsics.checkNotNullParameter((Object)passenger, (String)"passenger");
        Intrinsics.checkNotNullParameter((Object)positionUpdater, (String)"positionUpdater");
        if (this.method_5626(passenger)) {
            double y = this.method_23318() + 0.3 + passenger.method_5678();
            float bodyYawRad = MathExtensionsKt.radians(this.field_6283 + (float)90);
            double dx = (double)((float)Math.cos(bodyYawRad)) * 2.0 * (double)this.getScale();
            double dz = (double)((float)Math.sin(bodyYawRad)) * 2.0 * (double)this.getScale();
            positionUpdater.accept(passenger, this.method_23317() + dx, y, this.method_23321() + dz);
        }
    }

    private final boolean arePlayersNearby() {
        class_2338 class_23382 = this.spawnPos;
        if (class_23382 == null) {
            class_23382 = this.method_24515();
        }
        class_243 pos = class_243.method_24955((class_2382)((class_2382)class_23382));
        return this.method_37908().method_18459(pos.field_1352, pos.field_1351, pos.field_1350, 16.0, false) != null;
    }

    public void method_5749(@NotNull class_2487 nbt) {
        Intrinsics.checkNotNullParameter((Object)nbt, (String)"nbt");
        super.method_5749(nbt);
        if (nbt.method_10545("spawn_pos")) {
            this.spawnPos = class_2338.method_10092((long)nbt.method_10537("spawn_pos"));
        }
        if (nbt.method_10545("stomp_cooldown")) {
            this.stompCooldown = nbt.method_10550("stomp_cooldown");
        }
        if (nbt.method_10545("rush_cooldown")) {
            this.rushCooldown = nbt.method_10550("rush_cooldown");
        }
        if (nbt.method_10545("shoot_cooldown")) {
            this.shootCooldown = nbt.method_10550("shoot_cooldown");
        }
        if (nbt.method_10545("spawn_cooldown")) {
            this.spawnCooldown = nbt.method_10550("spawn_cooldown");
        }
        if (nbt.method_10545("last_stage")) {
            this.lastStage = nbt.method_10550("last_stage");
        }
    }

    public void method_5652(@NotNull class_2487 nbt) {
        Intrinsics.checkNotNullParameter((Object)nbt, (String)"nbt");
        super.method_5652(nbt);
        if (this.spawnPos != null) {
            class_2338 class_23382 = this.spawnPos;
            Intrinsics.checkNotNull((Object)class_23382);
            nbt.method_10544("spawn_pos", class_23382.method_10063());
        }
        nbt.method_10569("stomp_cooldown", this.stompCooldown);
        nbt.method_10569("rush_cooldown", this.rushCooldown);
        nbt.method_10569("shoot_cooldown", this.shootCooldown);
        nbt.method_10569("spawn_cooldown", this.spawnCooldown);
        nbt.method_10569("last_stage", this.lastStage);
    }

    private static final float legController$lambda$0(ArachneEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return this$0.getScale() * (float)24 / 16.0f;
    }

    private static final float legController$lambda$1(ArachneEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return this$0.getScale() * (float)28 / 16.0f;
    }

    private static final class_243 legController$lambda$2(ArachneEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return this$0.ikVec(0.6, 0.9, 1.0);
    }

    private static final class_243 legController$lambda$3(ArachneEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return this$0.ikVec(1.5, 0.0, 3.5);
    }

    private static final class_243 legController$lambda$4(ArachneEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return this$0.ikVec(0.6, 1.0, 0.65);
    }

    private static final class_243 legController$lambda$5(ArachneEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return this$0.ikVec(2.5, 0.0, 1.5);
    }

    private static final class_243 legController$lambda$6(ArachneEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return this$0.ikVec(0.6, 1.1, 0.3);
    }

    private static final class_243 legController$lambda$7(ArachneEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return this$0.ikVec(2.0, 0.0, 0.5);
    }

    private static final class_243 legController$lambda$8(ArachneEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return this$0.ikVec(0.6, 1.2, 0.0);
    }

    private static final class_243 legController$lambda$9(ArachneEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return this$0.ikVec(1.5, 0.0, -1.0);
    }

    private static final class_243 legController$lambda$10(ArachneEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return this$0.ikVec(-0.6, 0.9, 1.0);
    }

    private static final class_243 legController$lambda$11(ArachneEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return this$0.ikVec(-1.5, 0.0, 3.5);
    }

    private static final class_243 legController$lambda$12(ArachneEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return this$0.ikVec(-0.6, 1.0, 0.65);
    }

    private static final class_243 legController$lambda$13(ArachneEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return this$0.ikVec(-2.5, 0.0, 1.5);
    }

    private static final class_243 legController$lambda$14(ArachneEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return this$0.ikVec(-0.6, 1.1, 0.3);
    }

    private static final class_243 legController$lambda$15(ArachneEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return this$0.ikVec(-2.0, 0.0, -0.5);
    }

    private static final class_243 legController$lambda$16(ArachneEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return this$0.ikVec(-0.6, 1.2, 0.0);
    }

    private static final class_243 legController$lambda$17(ArachneEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return this$0.ikVec(-1.5, 0.0, -1.0);
    }

    private static final boolean initGoals$lambda$18(class_1352 it) {
        return true;
    }

    private static final boolean initGoals$lambda$19(ArachneEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return !this$0.arePlayersNearby();
    }

    private static final class_2338 initGoals$lambda$20(ArachneEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return this$0.spawnPos;
    }

    private static final boolean tick$lambda$21(ArachneEntity this$0, class_1309 it) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return !Intrinsics.areEqual((Object)it, (Object)((Object)this$0));
    }

    private static final boolean tick$lambda$22(Function1 $tmp0, Object p0) {
        Intrinsics.checkNotNullParameter((Object)$tmp0, (String)"$tmp0");
        return (Boolean)$tmp0.invoke(p0);
    }

    private static final Unit createSmashAttack$lambda$27(ArachneEntity this$0, int ticks) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        class_1937 class_19372 = this$0.method_37908();
        class_3218 class_32182 = class_19372 instanceof class_3218 ? (class_3218)class_19372 : null;
        if (class_32182 == null) {
            return Unit.INSTANCE;
        }
        class_3218 world = class_32182;
        int interval = this$0.getStompInterval();
        if (ticks > this$0.getStompWait() && (ticks % interval == interval / 4 || ticks % interval == interval * 3 / 4)) {
            class_1309 target = this$0.method_5968();
            if (target != null) {
                this$0.field_6189.method_6335((class_1297)target, ((Number)this$0.stageBasedValue(0.5, 0.6, 0.65, 0.7)).doubleValue());
            }
            ScreenShakeUtils.shakeAround((class_3218)world, (class_243)this$0.method_19538(), (float)1.0f, (int)20, (double)4.0, (double)16.0);
            float bodyYawRad = MathExtensionsKt.radians(this$0.field_6283 + (float)90);
            float scale = this$0.getScale();
            class_243 pos = this$0.method_19538().method_1031(3.0 * (double)((float)Math.cos(bodyYawRad)) * (double)scale, 0.0, 3.0 * (double)((float)Math.sin(bodyYawRad)) * (double)scale);
            world.method_14199((class_2394)class_2398.field_11236, pos.field_1352, pos.field_1351 + 0.5, pos.field_1350, 2, 0.3, 0.3, 0.3, 0.0);
            this$0.method_5783(class_3417.field_15152, 0.7f, 0.3f + this$0.field_5974.method_43057() * 0.2f);
            List list = world.method_8335((class_1297)this$0, class_238.method_30048((class_243)pos, (double)5.0, (double)4.0, (double)5.0));
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getOtherEntities(...)");
            Iterable $this$forEach$iv = list;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                class_1297 it = (class_1297)element$iv;
                boolean bl = false;
                if (!(it instanceof class_1309)) continue;
                ((class_1309)it).method_5643(this$0.method_48923().method_48812((class_1309)this$0), (float)this$0.method_26825(class_5134.field_23721) * 1.5f);
                ((class_1309)it).method_6005(0.1, this$0.method_23317() - ((class_1309)it).method_23317(), this$0.method_23321() - ((class_1309)it).method_23321());
            }
        }
        return Unit.INSTANCE;
    }

    private static final boolean createSmashAttack$lambda$28(ArachneEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return this$0.stompCooldown <= 0 && this$0.field_5974.method_43057() < 0.1f;
    }

    private static final Unit createSmashAttack$lambda$29(ArachneEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        this$0.stompCooldown = 200;
        return Unit.INSTANCE;
    }

    private static final Unit createSpawnAttack$lambda$30(ArachneEntity this$0, int ticks) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        if (ticks <= 80 && ticks % 10 == 0) {
            Pair[] pairArray = new Pair[]{TuplesKt.to(ModEntities.INSTANCE.getSPIDERLING(), (Object)80), TuplesKt.to((Object)class_1299.field_6079, (Object)6), TuplesKt.to(ModEntities.INSTANCE.getJUMPING_SPIDER(), (Object)4), TuplesKt.to((Object)class_1299.field_6084, (Object)2), TuplesKt.to(ModEntities.INSTANCE.getSPINY_SPIDER(), (Object)2), TuplesKt.to(ModEntities.INSTANCE.getWEB_CASTER(), (Object)1)};
            Map map = MapsKt.mapOf((Pair[])pairArray);
            class_5819 class_58192 = this$0.field_5974;
            Intrinsics.checkNotNullExpressionValue((Object)class_58192, (String)"random");
            class_1299 class_12992 = (class_1299)MathUtilsKt.pickWeightedRandom(map, class_58192);
            if (class_12992 == null) {
                return Unit.INSTANCE;
            }
            class_1299 entityType = class_12992;
            class_1937 class_19372 = this$0.method_37908();
            class_3218 class_32182 = class_19372 instanceof class_3218 ? (class_3218)class_19372 : null;
            if (class_32182 == null) {
                return Unit.INSTANCE;
            }
            class_3218 world = class_32182;
            class_1588 class_15882 = (class_1588)entityType.method_5883((class_1937)world);
            if (class_15882 == null) {
                return Unit.INSTANCE;
            }
            class_1588 entity = class_15882;
            entity.method_5814(this$0.method_19538().field_1352 + this$0.field_5974.method_43058() - 0.5, this$0.method_19538().field_1351 + 0.75, this$0.method_19538().field_1350 + this$0.field_5974.method_43058() - 0.5);
            if (this$0.method_5968() != null) {
                entity.method_5980(this$0.method_5968());
            }
            world.method_8649((class_1297)entity);
        }
        return Unit.INSTANCE;
    }

    private static final boolean createSpawnAttack$lambda$33$lambda$31(class_1297 it) {
        return it.method_5864().method_20210(ModEntityTags.INSTANCE.getSPAWNS_SPIDERLINGS_ON_DEATH());
    }

    private static final boolean createSpawnAttack$lambda$33$lambda$32(Function1 $tmp0, Object p0) {
        Intrinsics.checkNotNullParameter((Object)$tmp0, (String)"$tmp0");
        return (Boolean)$tmp0.invoke(p0);
    }

    private static final boolean createSpawnAttack$lambda$33(ArachneEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return this$0.forceSpawnAttack || this$0.spawnCooldown <= 0 && this$0.field_5974.method_43057() < 0.01f && this$0.method_37908().method_8333((class_1297)this$0, class_238.method_30048((class_243)this$0.method_19538(), (double)20.0, (double)20.0, (double)20.0), arg_0 -> ArachneEntity.createSpawnAttack$lambda$33$lambda$32(ArachneEntity::createSpawnAttack$lambda$33$lambda$31, arg_0)).size() <= 3;
    }

    private static final Unit createSpawnAttack$lambda$34(ArachneEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        this$0.spawnCooldown = 1200;
        this$0.forceSpawnAttack = false;
        return Unit.INSTANCE;
    }

    private static final Unit createRushAttack$lambda$35(ArachneEntity this$0, int ticks) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        class_1937 class_19372 = this$0.method_37908();
        class_3218 class_32182 = class_19372 instanceof class_3218 ? (class_3218)class_19372 : null;
        if (class_32182 != null) {
            class_32182.method_14199((class_2394)class_2398.field_11237, this$0.method_19538().field_1352, this$0.method_19538().field_1351 + 0.5, this$0.method_19538().field_1350, 3, 0.5, 0.2, 0.5, 0.01);
        }
        if (ticks < 30) {
            return Unit.INSTANCE;
        }
        if (ticks == 30) {
            this$0.method_5762(0.0, 0.5, 0.0);
        }
        float bodyYawRad = MathExtensionsKt.radians(this$0.field_6283 + (float)90);
        this$0.method_5784(class_1313.field_6308, new class_243((double)((float)Math.cos(bodyYawRad)) * 0.7, 0.0, (double)((float)Math.sin(bodyYawRad)) * 0.7));
        return Unit.INSTANCE;
    }

    private static final boolean createRushAttack$lambda$36(ArachneEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return this$0.rushCooldown <= 0 && this$0.field_5974.method_43057() < 0.1f;
    }

    private static final Unit createRushAttack$lambda$37(ArachneEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        this$0.method_37908().method_46407((class_1297)this$0, null, new class_5362(){

            public boolean method_29554(class_1927 explosion, class_1922 world, class_2338 pos, class_2680 state, float power) {
                Intrinsics.checkNotNullParameter((Object)explosion, (String)"explosion");
                Intrinsics.checkNotNullParameter((Object)world, (String)"world");
                Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
                Intrinsics.checkNotNullParameter((Object)state, (String)"state");
                return false;
            }
        }, this$0.method_19538().method_1031(0.0, 0.5, 0.0), 2.0f, false, class_1937.class_7867.field_40890);
        this$0.rushCooldown = ((Number)this$0.stageBasedValue(200, 160, 130, 100)).intValue();
        this$0.setGlobalCooldown();
        return Unit.INSTANCE;
    }

    private static final boolean createRushAttack$lambda$38(ArachneEntity this$0, int ticks) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return ticks <= 40 || !(this$0.field_6014 == this$0.method_23317()) || !(this$0.field_5969 == this$0.method_23321());
    }

    private static final Unit createShootAttack$lambda$39(ArachneEntity this$0, int ticks) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        class_1309 target = this$0.method_5968();
        if (ticks == 30 && target != null) {
            SpiderSilkBolaProjectile spiderSilkBolaProjectile = (SpiderSilkBolaProjectile)ModEntities.INSTANCE.getSPIDER_SILK_BOLA().method_5883(this$0.method_37908());
            if (spiderSilkBolaProjectile == null) {
                return Unit.INSTANCE;
            }
            SpiderSilkBolaProjectile projectile = spiderSilkBolaProjectile;
            class_243 diff = target.method_19538().method_1031(0.0, 1.5, 0.0).method_1020(this$0.method_19538()).method_1029();
            projectile.method_18800(diff.field_1352, diff.field_1351 + 0.03, diff.field_1350);
            projectile.method_33574(this$0.method_19538().method_1031(0.0, 0.5, 0.0).method_1019(this$0.method_5720()));
            projectile.method_7432((class_1297)this$0);
            this$0.method_37908().method_8649((class_1297)projectile);
        }
        return Unit.INSTANCE;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final boolean createShootAttack$lambda$40(ArachneEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        if (this$0.shootCooldown > 0) return false;
        if (!(this$0.field_5974.method_43057() < 0.1f)) return false;
        if (this$0.method_5968() == null) return false;
        class_1309 class_13092 = this$0.method_5968();
        Intrinsics.checkNotNull((Object)class_13092);
        if (!((double)class_13092.method_5739((class_1297)this$0) > 6.0)) return false;
        return true;
    }

    private static final Unit createShootAttack$lambda$41(ArachneEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        this$0.shootCooldown = ((Number)this$0.stageBasedValue(110, 100, 90, 80)).intValue();
        return Unit.INSTANCE;
    }

    private static final Unit createArachneAttack$lambda$42() {
        return Unit.INSTANCE;
    }

    private static final boolean createArachneAttack$lambda$43(int it) {
        return true;
    }

    private static final Unit createArachneAttack$lambda$44(ArachneEntity this$0, ArachneAttackType $type) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)((Object)$type), (String)"$type");
        this$0.setCurrentAttack($type);
        this$0.field_6189.method_6340();
        return Unit.INSTANCE;
    }

    private static final Unit createArachneAttack$lambda$45(ArachneEntity this$0, Function0 $cooldownSetter) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)$cooldownSetter, (String)"$cooldownSetter");
        this$0.setCurrentAttack(ArachneAttackType.NONE);
        this$0.setGlobalCooldown();
        $cooldownSetter.invoke();
        return Unit.INSTANCE;
    }

    private static final boolean createArachneAttack$lambda$46(ArachneEntity this$0, Function0 $startPredicate) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)$startPredicate, (String)"$startPredicate");
        return this$0.getCurrentAttack() == ArachneAttackType.NONE && (Boolean)$startPredicate.invoke() != false;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ArachneEntity.class, "currentAttack", "getCurrentAttack()Ldev/mim1q/derelict/entity/boss/ArachneEntity$ArachneAttackType;", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        class_2940 class_29402 = class_2945.method_12791(ArachneEntity.class, (class_2941)class_2943.field_13323);
        Intrinsics.checkNotNullExpressionValue((Object)class_29402, (String)"registerData(...)");
        SCREAMING = class_29402;
        class_2940 class_29403 = class_2945.method_12791(ArachneEntity.class, (class_2941)class_2943.field_13323);
        Intrinsics.checkNotNullExpressionValue((Object)class_29403, (String)"registerData(...)");
        SHAKING = class_29403;
        class_2940 class_29404 = class_2945.method_12791(ArachneEntity.class, (class_2941)class_2943.field_13327);
        Intrinsics.checkNotNullExpressionValue((Object)class_29404, (String)"registerData(...)");
        CURRENT_ATTACK = class_29404;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2={"Ldev/mim1q/derelict/entity/boss/ArachneEntity$ArachneAttackType;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "SMASH", "SPAWN", "RUSH", "SHOOT", "derelict"})
    public static final class ArachneAttackType
    extends Enum<ArachneAttackType> {
        public static final /* enum */ ArachneAttackType NONE = new ArachneAttackType();
        public static final /* enum */ ArachneAttackType SMASH = new ArachneAttackType();
        public static final /* enum */ ArachneAttackType SPAWN = new ArachneAttackType();
        public static final /* enum */ ArachneAttackType RUSH = new ArachneAttackType();
        public static final /* enum */ ArachneAttackType SHOOT = new ArachneAttackType();
        private static final /* synthetic */ ArachneAttackType[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static ArachneAttackType[] values() {
            return (ArachneAttackType[])$VALUES.clone();
        }

        public static ArachneAttackType valueOf(String value) {
            return Enum.valueOf(ArachneAttackType.class, value);
        }

        @NotNull
        public static EnumEntries<ArachneAttackType> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = arachneAttackTypeArray = new ArachneAttackType[]{ArachneAttackType.NONE, ArachneAttackType.SMASH, ArachneAttackType.SPAWN, ArachneAttackType.RUSH, ArachneAttackType.SHOOT};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\u00a8\u0006\u0012"}, d2={"Ldev/mim1q/derelict/entity/boss/ArachneEntity$Companion;", "", "<init>", "()V", "Lnet/minecraft/class_5132$class_5133;", "createArachneAttributes", "()Lnet/minecraft/class_5132$class_5133;", "Lnet/minecraft/class_2940;", "", "SCREAMING", "Lnet/minecraft/class_2940;", "getSCREAMING", "()Lnet/minecraft/class_2940;", "SHAKING", "getSHAKING", "", "CURRENT_ATTACK", "getCURRENT_ATTACK", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final class_2940<Boolean> getSCREAMING() {
            return SCREAMING;
        }

        @NotNull
        public final class_2940<Boolean> getSHAKING() {
            return SHAKING;
        }

        @NotNull
        public final class_2940<Integer> getCURRENT_ATTACK() {
            return CURRENT_ATTACK;
        }

        @NotNull
        public final class_5132.class_5133 createArachneAttributes() {
            class_5132.class_5133 class_51332 = class_1588.method_26918().method_26868(class_5134.field_23716, 250.0).method_26868(class_5134.field_23724, 8.0).method_26868(class_5134.field_23719, 0.45).method_26868(class_5134.field_23718, 0.9).method_26868(class_5134.field_23721, 4.0).method_26868(class_5134.field_23723, 0.5);
            Intrinsics.checkNotNullExpressionValue((Object)class_51332, (String)"add(...)");
            return class_51332;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

