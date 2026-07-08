/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.ints.Int2LongMap
 *  it.unimi.dsi.fastutil.ints.Int2LongOpenHashMap
 *  it.unimi.dsi.fastutil.longs.Long2ObjectMap
 *  it.unimi.dsi.fastutil.longs.Long2ObjectMaps
 *  it.unimi.dsi.fastutil.objects.Object2IntMap$Entry
 *  it.unimi.dsi.fastutil.objects.ObjectSet
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.ResultKt
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin._Assertions
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.IntIterator
 *  kotlin.collections.MapsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.math.MathKt
 *  kotlin.ranges.ClosedRange
 *  kotlin.ranges.IntRange
 *  kotlin.ranges.RangesKt
 *  kotlin.reflect.KProperty
 *  kotlin.text.StringsKt
 */
package org.valkyrienskies.core.impl.shadow;

import it.unimi.dsi.fastutil.ints.Int2LongMap;
import it.unimi.dsi.fastutil.ints.Int2LongOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.YieldKt;
import org.apache.logging.log4j.Logger;
import org.joml.Matrix3d;
import org.joml.Quaterniondc;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3f;
import org.joml.Vector3ic;
import org.joml.primitives.AABBd;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.events.CollisionEvent;
import org.valkyrienskies.core.api.physics.blockstates.BoxBlockShape;
import org.valkyrienskies.core.api.physics.blockstates.BoxesBlockShape;
import org.valkyrienskies.core.api.physics.blockstates.CollisionPoint;
import org.valkyrienskies.core.api.physics.blockstates.LiquidBlockShape;
import org.valkyrienskies.core.api.physics.blockstates.LiquidState;
import org.valkyrienskies.core.api.physics.blockstates.SolidBlockShape;
import org.valkyrienskies.core.api.physics.blockstates.SolidState;
import org.valkyrienskies.core.api.ships.PhysShip;
import org.valkyrienskies.core.api.ships.WingManagerChanges;
import org.valkyrienskies.core.api.ships.properties.IShipActiveChunksSet;
import org.valkyrienskies.core.api.ships.properties.PhysPose;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.api.world.LevelYRange;
import org.valkyrienskies.core.api.world.PhysLevel;
import org.valkyrienskies.core.impl.api_impl.config.ConfigPhysicsBackendType;
import org.valkyrienskies.core.impl.api_impl.physics.CollisionEventImpl;
import org.valkyrienskies.core.impl.api_impl.physics.ContactPointImpl;
import org.valkyrienskies.core.impl.config.PhysicsConfig;
import org.valkyrienskies.core.impl.config.VSCoreConfig;
import org.valkyrienskies.core.impl.game.ships.PhysShipImpl;
import org.valkyrienskies.core.impl.program.VSCoreInternal;
import org.valkyrienskies.core.impl.shadow.CP;
import org.valkyrienskies.core.impl.shadow.DN;
import org.valkyrienskies.core.impl.shadow.ER;
import org.valkyrienskies.core.impl.shadow.FA;
import org.valkyrienskies.core.impl.shadow.FB;
import org.valkyrienskies.core.impl.shadow.FC;
import org.valkyrienskies.core.impl.shadow.FH;
import org.valkyrienskies.core.impl.shadow.FQ;
import org.valkyrienskies.core.impl.shadow.FR;
import org.valkyrienskies.core.impl.shadow.FS;
import org.valkyrienskies.core.impl.shadow.FT;
import org.valkyrienskies.core.impl.shadow.FV;
import org.valkyrienskies.core.impl.shadow.FX;
import org.valkyrienskies.core.impl.shadow.GS;
import org.valkyrienskies.core.impl.shadow.GU;
import org.valkyrienskies.core.impl.shadow.GX;
import org.valkyrienskies.core.impl.shadow.GY;
import org.valkyrienskies.core.impl.shadow.GZ;
import org.valkyrienskies.core.impl.shadow.HE;
import org.valkyrienskies.core.impl.shadow.HF;
import org.valkyrienskies.core.impl.shadow.HG;
import org.valkyrienskies.core.impl.shadow.HH;
import org.valkyrienskies.core.impl.shadow.HI;
import org.valkyrienskies.core.impl.shadow.HJ;
import org.valkyrienskies.core.impl.shadow.HL;
import org.valkyrienskies.core.impl.shadow.HM;
import org.valkyrienskies.core.impl.shadow.HN;
import org.valkyrienskies.core.impl.shadow.HO;
import org.valkyrienskies.core.impl.shadow.HP;
import org.valkyrienskies.core.impl.shadow.HQ;
import org.valkyrienskies.core.impl.shadow.HR;
import org.valkyrienskies.core.impl.shadow.HS;
import org.valkyrienskies.core.impl.shadow.HT;
import org.valkyrienskies.core.impl.shadow.HX;
import org.valkyrienskies.core.impl.shadow.HZ;
import org.valkyrienskies.core.impl.shadow.IC;
import org.valkyrienskies.core.impl.shadow.It;
import org.valkyrienskies.core.impl.shadow.Iv;
import org.valkyrienskies.core.impl.shadow.Iw;
import org.valkyrienskies.core.impl.shadow.Iz;
import org.valkyrienskies.core.impl.shadow.ek_0;
import org.valkyrienskies.core.impl.shadow.er_0;
import org.valkyrienskies.core.impl.shadow.ew_0;
import org.valkyrienskies.core.impl.shadow.ex_0;
import org.valkyrienskies.core.impl.shadow.fy_0;
import org.valkyrienskies.core.impl.shadow.fz_0;
import org.valkyrienskies.core.impl.shadow.ha_0;
import org.valkyrienskies.core.impl.shadow.hb_0;
import org.valkyrienskies.core.impl.shadow.hc_0;
import org.valkyrienskies.core.impl.shadow.hi_0;
import org.valkyrienskies.core.impl.shadow.hk_0;
import org.valkyrienskies.core.impl.shadow.hl_0;
import org.valkyrienskies.core.impl.shadow.hr_0;
import org.valkyrienskies.core.impl.shadow.hz_0;
import org.valkyrienskies.core.impl.shadow.ia_0;
import org.valkyrienskies.core.impl.shadow.ib_0;
import org.valkyrienskies.core.impl.shadow.id_0;
import org.valkyrienskies.core.impl.shadow.if_0;
import org.valkyrienskies.core.impl.shadow.ig_0;
import org.valkyrienskies.core.impl.shadow.ii_0;
import org.valkyrienskies.core.impl.shadow.ij_0;
import org.valkyrienskies.core.impl.shadow.ik_0;
import org.valkyrienskies.core.impl.shadow.il_0;
import org.valkyrienskies.core.impl.shadow.im_0;
import org.valkyrienskies.core.impl.shadow.in_0;
import org.valkyrienskies.core.internal.joints.VSD6Joint;
import org.valkyrienskies.core.internal.joints.VSDistanceJoint;
import org.valkyrienskies.core.internal.joints.VSFixedJoint;
import org.valkyrienskies.core.internal.joints.VSGearJoint;
import org.valkyrienskies.core.internal.joints.VSJoint;
import org.valkyrienskies.core.internal.joints.VSJointAndId;
import org.valkyrienskies.core.internal.joints.VSJointMaxForceTorque;
import org.valkyrienskies.core.internal.joints.VSJointPose;
import org.valkyrienskies.core.internal.joints.VSJointType;
import org.valkyrienskies.core.internal.joints.VSPrismaticJoint;
import org.valkyrienskies.core.internal.joints.VSRackAndPinionJoint;
import org.valkyrienskies.core.internal.joints.VSRevoluteJoint;
import org.valkyrienskies.core.internal.joints.VSSphericalJoint;
import org.valkyrienskies.core.internal.physics.VSBoxCollisionShapeData;
import org.valkyrienskies.core.internal.physics.VSCapsuleCollisionShapeData;
import org.valkyrienskies.core.internal.physics.VSSphereCollisionShapeData;
import org.valkyrienskies.core.internal.physics.VSVoxelCollisionShapeData;
import org.valkyrienskies.core.internal.physics.VSWheelCollisionShapeData;
import org.valkyrienskies.core.internal.physics.blockstates.VsiBlockState;
import org.valkyrienskies.core.internal.world.VsiPlayerState;
import org.valkyrienskies.core.util.datastructures.BlockPos2IntOpenHashMap;
import org.valkyrienskies.core.util.datastructures.BlockPos2ObjectOpenHashMap;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u00da\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u0087\u00022\u00020\u0001:\u0002\u0087\u0002B:\b\u0007\u0012\b\u0010\u008e\u0001\u001a\u00030\u008d\u0001\u0012\b\u0010\u00d4\u0001\u001a\u00030\u00d3\u0001\u0012\b\u0010\u00f5\u0001\u001a\u00030\u00f4\u0001\u0012\u000f\u0010\u0083\u0002\u001a\n\u0012\u0005\u0012\u00030\u00fe\u00010\u0084\u0002\u00a2\u0006\u0006\b\u0085\u0002\u0010\u0086\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00060\u0007j\u0002`\n2\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u0010\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001c\u0010\u001dJ=\u0010%\u001a\u00020$2\n\u0010\u001e\u001a\u00060\u000fj\u0002`\u00102\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b%\u0010&J\u0019\u0010(\u001a\u00020'2\n\u0010\u001e\u001a\u00060\u000fj\u0002`\u0010\u00a2\u0006\u0004\b(\u0010)J;\u0010.\u001a\u00020\u00042\n\u0010+\u001a\u00060$j\u0002`*2\u0006\u0010-\u001a\u00020,2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b.\u0010/J\u0015\u00100\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b0\u0010\u0006J\u0017\u00105\u001a\u00020\u00042\u0006\u00102\u001a\u000201H\u0000\u00a2\u0006\u0004\b3\u00104J\u000f\u00106\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b6\u0010\u001dJ \u0010;\u001a\u00020\u00042\u0006\u00108\u001a\u0002072\u0006\u0010:\u001a\u000209H\u0082@\u00a2\u0006\u0004\b;\u0010<J\u001d\u0010=\u001a\u00020\u00152\u0006\u00108\u001a\u0002072\u0006\u0010:\u001a\u000209\u00a2\u0006\u0004\b=\u0010>J3\u0010E\u001a\u0010\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020D\u0018\u00010?2\u0014\u0010B\u001a\u0010\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020A\u0018\u00010?H\u0002\u00a2\u0006\u0004\bE\u0010FJ3\u0010K\u001a\u0010\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020J\u0018\u00010?2\u0014\u0010B\u001a\u0010\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020H\u0018\u00010?H\u0002\u00a2\u0006\u0004\bK\u0010FJ3\u0010N\u001a\u0010\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020M\u0018\u00010?2\u0014\u0010B\u001a\u0010\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020L\u0018\u00010?H\u0002\u00a2\u0006\u0004\bN\u0010FJ\u0017\u0010R\u001a\u00020Q2\u0006\u0010P\u001a\u00020OH\u0002\u00a2\u0006\u0004\bR\u0010SJ\u0017\u0010V\u001a\u00020Q2\u0006\u0010U\u001a\u00020TH\u0002\u00a2\u0006\u0004\bV\u0010WJ\u0017\u0010V\u001a\u00020Y2\u0006\u0010U\u001a\u00020XH\u0002\u00a2\u0006\u0004\bV\u0010ZJ\u001f\u0010_\u001a\u00020^2\u0006\u0010\\\u001a\u00020[2\u0006\u0010]\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b_\u0010`J\u001f\u0010_\u001a\u00020b2\u0006\u0010\\\u001a\u00020a2\u0006\u0010]\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b_\u0010cJ\u000f\u0010e\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\bd\u0010\u001dJ\u0013\u0010g\u001a\u00020f*\u000201H\u0002\u00a2\u0006\u0004\bg\u0010hJ\u0017\u0010k\u001a\u0004\u0018\u00010j*\u0004\u0018\u00010iH\u0002\u00a2\u0006\u0004\bk\u0010lJ\u0015\u0010k\u001a\u0004\u0018\u00010I*\u00020GH\u0002\u00a2\u0006\u0004\bk\u0010mJ\u0017\u0010k\u001a\u0004\u0018\u00010C*\u0004\u0018\u00010@H\u0002\u00a2\u0006\u0004\bk\u0010nJ\u0017\u0010k\u001a\u0004\u0018\u00010D*\u0004\u0018\u00010AH\u0002\u00a2\u0006\u0004\bk\u0010oJ\u0017\u0010k\u001a\u0004\u0018\u00010M*\u0004\u0018\u00010LH\u0002\u00a2\u0006\u0004\bk\u0010pJ\u0017\u0010k\u001a\u0004\u0018\u00010r*\u0004\u0018\u00010qH\u0002\u00a2\u0006\u0004\bk\u0010sJ\u0017\u0010k\u001a\u0004\u0018\u00010u*\u0004\u0018\u00010tH\u0002\u00a2\u0006\u0004\bk\u0010vJ\u0017\u0010k\u001a\u0004\u0018\u00010x*\u0004\u0018\u00010wH\u0002\u00a2\u0006\u0004\bk\u0010yJ\u0017\u0010k\u001a\u0004\u0018\u00010{*\u0004\u0018\u00010zH\u0002\u00a2\u0006\u0004\bk\u0010|J\u0017\u0010k\u001a\u0004\u0018\u00010~*\u0004\u0018\u00010}H\u0002\u00a2\u0006\u0004\bk\u0010\u007fJ\u001a\u0010k\u001a\u0005\u0018\u00010\u0081\u0001*\u0005\u0018\u00010\u0080\u0001H\u0002\u00a2\u0006\u0005\bk\u0010\u0082\u0001J\u0018\u0010k\u001a\u0004\u0018\u00010J*\u0004\u0018\u00010HH\u0002\u00a2\u0006\u0005\bk\u0010\u0083\u0001J\u0016\u0010k\u001a\u00030\u0085\u0001*\u00030\u0084\u0001H\u0002\u00a2\u0006\u0005\bk\u0010\u0086\u0001J\u001a\u0010k\u001a\u0005\u0018\u00010\u0088\u0001*\u0005\u0018\u00010\u0087\u0001H\u0002\u00a2\u0006\u0005\bk\u0010\u0089\u0001J\u001a\u0010k\u001a\u0005\u0018\u00010\u008b\u0001*\u0005\u0018\u00010\u008a\u0001H\u0002\u00a2\u0006\u0005\bk\u0010\u008c\u0001R\u0018\u0010\u008e\u0001\u001a\u00030\u008d\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0018\u0010\u0091\u0001\u001a\u00030\u0090\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001Rf\u0010\u0097\u0001\u001aL\u0012\u0019\u0012\u0017\u0012\b\u0012\u00060$j\u0002`*\u0012\b\u0012\u00060$j\u0002`*0\u0094\u0001\u0012\u0005\u0012\u00030\u0095\u00010\u0093\u0001j%\u0012\u0019\u0012\u0017\u0012\b\u0012\u00060$j\u0002`*\u0012\b\u0012\u00060$j\u0002`*0\u0094\u0001\u0012\u0005\u0012\u00030\u0095\u0001`\u0096\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u0097\u0001\u0010\u0098\u0001\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001Rf\u0010\u009b\u0001\u001aL\u0012\u0019\u0012\u0017\u0012\b\u0012\u00060$j\u0002`*\u0012\b\u0012\u00060$j\u0002`*0\u0094\u0001\u0012\u0005\u0012\u00030\u0095\u00010\u0093\u0001j%\u0012\u0019\u0012\u0017\u0012\b\u0012\u00060$j\u0002`*\u0012\b\u0012\u00060$j\u0002`*0\u0094\u0001\u0012\u0005\u0012\u00030\u0095\u0001`\u0096\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u009b\u0001\u0010\u0098\u0001\u001a\u0006\b\u009c\u0001\u0010\u009a\u0001Rf\u0010\u009d\u0001\u001aL\u0012\u0019\u0012\u0017\u0012\b\u0012\u00060$j\u0002`*\u0012\b\u0012\u00060$j\u0002`*0\u0094\u0001\u0012\u0005\u0012\u00030\u0095\u00010\u0093\u0001j%\u0012\u0019\u0012\u0017\u0012\b\u0012\u00060$j\u0002`*\u0012\b\u0012\u00060$j\u0002`*0\u0094\u0001\u0012\u0005\u0012\u00030\u0095\u0001`\u0096\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u009d\u0001\u0010\u0098\u0001\u001a\u0006\b\u009e\u0001\u0010\u009a\u0001R+\u0010\u00a1\u0001\u001a\u0014\u0012\b\u0012\u00060\u000fj\u0002`\u0010\u0012\u0005\u0012\u00030\u00a0\u00010\u009f\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a1\u0001\u0010\u00a2\u0001RD\u0010\u00a7\u0001\u001a'\u0012\b\u0012\u00060\u000fj\u0002`\u0010\u0012\u0018\u0012\u0016\u0012\u0005\u0012\u00030\u00a5\u00010\u00a4\u0001j\n\u0012\u0005\u0012\u00030\u00a5\u0001`\u00a6\u00010\u00a3\u00018\u0000X\u0080\u0004\u00a2\u0006\u0010\n\u0006\b\u00a7\u0001\u0010\u00a2\u0001\u001a\u0006\b\u00a8\u0001\u0010\u00a9\u0001R)\u0010\u00ab\u0001\u001a\u0014\u0012\b\u0012\u00060\u000fj\u0002`\u0010\u0012\u0005\u0012\u00030\u00aa\u00010\u00a3\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ab\u0001\u0010\u00a2\u0001R\u0018\u0010\u00ad\u0001\u001a\u00030\u00ac\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ad\u0001\u0010\u00ae\u0001R\u001e\u0010\u00b0\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u00af\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b0\u0001\u0010\u00b1\u0001R4\u0010\u00b2\u0001\u001a\u0017\u0012\b\u0012\u00060\u000fj\u0002`\u0010\u0012\b\u0012\u00060$j\u0002`*0\u00a3\u00018\u0000X\u0080\u0004\u00a2\u0006\u0010\n\u0006\b\u00b2\u0001\u0010\u00a2\u0001\u001a\u0006\b\u00b3\u0001\u0010\u00a9\u0001R\u0019\u0010\u00b4\u0001\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b4\u0001\u0010\u00b5\u0001R)\u0010\u00b6\u0001\u001a\u0002098\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0018\n\u0006\b\u00b6\u0001\u0010\u00b5\u0001\u001a\u0006\b\u00b7\u0001\u0010\u00b8\u0001\"\u0006\b\u00b9\u0001\u0010\u00ba\u0001R*\u0010\u00bc\u0001\u001a\u0002092\u0007\u0010\u00bb\u0001\u001a\u0002098\u0006@BX\u0086\u000e\u00a2\u0006\u0010\n\u0006\b\u00bc\u0001\u0010\u00b5\u0001\u001a\u0006\b\u00bc\u0001\u0010\u00b8\u0001R\u0018\u0010\u00be\u0001\u001a\u00030\u00bd\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00be\u0001\u0010\u00bf\u0001R*\u0010\u00c0\u0001\u001a\u00020\u00072\u0007\u0010\u00bb\u0001\u001a\u00020\u00078\u0006@BX\u0086\u000e\u00a2\u0006\u0010\n\u0006\b\u00c0\u0001\u0010\u00c1\u0001\u001a\u0006\b\u00c2\u0001\u0010\u00c3\u0001R\u0018\u0010\u00c5\u0001\u001a\u00030\u00c4\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c5\u0001\u0010\u00c6\u0001R)\u0010\u00c7\u0001\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00c7\u0001\u0010\u00c1\u0001\u001a\u0006\b\u00c8\u0001\u0010\u00c3\u0001\"\u0006\b\u00c9\u0001\u0010\u00ca\u0001R\u0019\u0010\u00cb\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00cb\u0001\u0010\u00c1\u0001R)\u0010\u00cd\u0001\u001a\u0014\u0012\b\u0012\u00060\u000fj\u0002`\u0010\u0012\u0005\u0012\u00030\u00cc\u00010\u00a3\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00cd\u0001\u0010\u00a2\u0001R)\u0010\u00cf\u0001\u001a\u0014\u0012\b\u0012\u00060\u000fj\u0002`\u0010\u0012\u0005\u0012\u00030\u00cc\u00010\u009f\u00018@X\u0080\u0004\u00a2\u0006\b\u001a\u0006\b\u00ce\u0001\u0010\u00a9\u0001R\u0018\u0010\u00d1\u0001\u001a\u00030\u00d0\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d1\u0001\u0010\u00d2\u0001R\u0018\u0010\u00d4\u0001\u001a\u00030\u00d3\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d4\u0001\u0010\u00d5\u0001R8\u0010\u00dc\u0001\u001a#\u0012\u0017\u0012\u00150\u00d7\u0001\u00a2\u0006\u000f\b\u00d8\u0001\u0012\n\b\u00d9\u0001\u0012\u0005\b\b(\u00da\u0001\u0012\u0005\u0012\u00030\u00db\u00010\u00d6\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00dc\u0001\u0010\u00dd\u0001R!\u0010\u00e0\u0001\u001a\n\u0012\u0005\u0012\u00030\u00df\u00010\u00de\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e0\u0001\u0010\u00e1\u0001R\u0018\u0010\u00e3\u0001\u001a\u00030\u00e2\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00e3\u0001\u0010\u00e4\u0001R9\u0010\u00e7\u0001\u001a$\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u00e6\u00010\u00e5\u00010\u00a4\u0001j\u0011\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u00e6\u00010\u00e5\u0001`\u00a6\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00e7\u0001\u0010\u00e8\u0001R\u0018\u0010\u00ea\u0001\u001a\u00030\u00e9\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ea\u0001\u0010\u00eb\u0001R)\u0010\u00da\u0001\u001a\u00020f8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0018\n\u0006\b\u00da\u0001\u0010\u00ec\u0001\u001a\u0006\b\u00ed\u0001\u0010\u00ee\u0001\"\u0006\b\u00ef\u0001\u0010\u00f0\u0001R1\u0010\u00f1\u0001\u001a\u001c\u0012\b\u0012\u00060\u000fj\u0002`\u00100\u00a4\u0001j\r\u0012\b\u0012\u00060\u000fj\u0002`\u0010`\u00a6\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00f1\u0001\u0010\u00e8\u0001RE\u0010\u00f3\u0001\u001a0\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030\u00f2\u0001\u0012\u0004\u0012\u0002090\u0094\u00010\u00a4\u0001j\u0017\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030\u00f2\u0001\u0012\u0004\u0012\u0002090\u0094\u0001`\u00a6\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00f3\u0001\u0010\u00e8\u0001R\u0018\u0010\u00f5\u0001\u001a\u00030\u00f4\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00f5\u0001\u0010\u00f6\u0001R)\u0010\u00f7\u0001\u001a\u0002098\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0018\n\u0006\b\u00f7\u0001\u0010\u00b5\u0001\u001a\u0006\b\u00f8\u0001\u0010\u00b8\u0001\"\u0006\b\u00f9\u0001\u0010\u00ba\u0001R\u001f\u0010\u00fc\u0001\u001a\n\u0012\u0005\u0012\u00030\u00fb\u00010\u00fa\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00fc\u0001\u0010\u00fd\u0001R!\u0010\u0083\u0002\u001a\u00030\u00fe\u00018FX\u0086\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00ff\u0001\u0010\u0080\u0002\u001a\u0006\b\u0081\u0002\u0010\u0082\u0002\u00a8\u0006\u0088\u0002"}, d2={"Lorg/valkyrienskies/core/impl/pipelines/VSPhysicsPipelineStage;", "", "Lorg/valkyrienskies/core/impl/pipelines/VSGameFrame;", "gameFrame", "", "applyGameFrame", "(Lorg/valkyrienskies/core/impl/pipelines/VSGameFrame;)V", "", "Lorg/valkyrienskies/core/internal/joints/VSJointId;", "vsConstraintId", "Lorg/valkyrienskies/physics_api/JointId;", "convertVSConstraintIdToConstraintId", "(I)I", "Lorg/valkyrienskies/core/internal/joints/VSJoint;", "vsJoint", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "dimension", "Lorg/valkyrienskies/physics_api/joints/JointData;", "convertVSConstraintToPhysicsConstraint", "(Lorg/valkyrienskies/core/internal/joints/VSJoint;Ljava/lang/String;)Lorg/valkyrienskies/physics_api/joints/JointData;", "Lorg/valkyrienskies/core/impl/pipelines/VSPhysicsFrame;", "createPhysicsFrame", "()Lorg/valkyrienskies/core/impl/pipelines/VSPhysicsFrame;", "Lorg/valkyrienskies/physics_api/voxel/VoxelChunk16;", "voxelChunk16", "deleteChunkAsync", "(Lorg/valkyrienskies/physics_api/voxel/VoxelChunk16;)V", "deleteResources", "()V", "dimensionId", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "transform", "chunkX", "chunkY", "chunkZ", "", "getChunkUpdatePriority", "(Ljava/lang/String;Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;III)J", "Lorg/valkyrienskies/core/api/world/PhysLevel;", "getPhysWorld", "(Ljava/lang/String;)Lorg/valkyrienskies/core/api/world/PhysLevel;", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "shipId", "Lorg/valkyrienskies/physics_api/VoxelShapeReference;", "voxShape", "handleChunkLoaded", "(JLorg/valkyrienskies/physics_api/VoxelShapeReference;III)V", "pushGameFrame", "Lorg/valkyrienskies/core/impl/config/PhysicsConfig;", "physics", "refreshSettings$impl", "(Lorg/valkyrienskies/core/impl/config/PhysicsConfig;)V", "refreshSettings", "registerBlocks", "", "timeStep", "", "simulatePhysics", "tickKrunch", "(DZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tickPhysics", "(DZ)Lorg/valkyrienskies/core/impl/pipelines/VSPhysicsFrame;", "Ljava/util/EnumMap;", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$D6Drive;", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$D6JointDrive;", "emap", "Lorg/valkyrienskies/physics_api/joints/D6Joint$D6Drive;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$D6JointDrive;", "toKrunchDrive", "(Ljava/util/EnumMap;)Ljava/util/EnumMap;", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$D6Axis;", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LinearLimitPair;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$D6Axis;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$LinearLimitPair;", "toKrunchLimit", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$D6Motion;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$D6Motion;", "toKrunchMotion", "Lorg/joml/primitives/AABBic;", "boundingBox", "Lorg/valkyrienskies/physics_api/voxel/LodBlockBoundingBox;", "toLodBoundingBox", "(Lorg/joml/primitives/AABBic;)Lorg/valkyrienskies/physics_api/voxel/LodBlockBoundingBox;", "Lorg/valkyrienskies/core/api/physics/blockstates/LiquidBlockShape;", "shape", "toLodShape", "(Lorg/valkyrienskies/core/api/physics/blockstates/LiquidBlockShape;)Lorg/valkyrienskies/physics_api/voxel/LodBlockBoundingBox;", "Lorg/valkyrienskies/core/api/physics/blockstates/SolidBlockShape;", "Lorg/valkyrienskies/physics_api/voxel/Lod1SolidCollisionShape;", "(Lorg/valkyrienskies/core/api/physics/blockstates/SolidBlockShape;)Lorg/valkyrienskies/physics_api/voxel/Lod1SolidCollisionShape;", "Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState;", "state", "id", "Lorg/valkyrienskies/physics_api/voxel/Lod1LiquidBlockState;", "toLodState", "(Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState;I)Lorg/valkyrienskies/physics_api/voxel/Lod1LiquidBlockState;", "Lorg/valkyrienskies/core/api/physics/blockstates/SolidState;", "Lorg/valkyrienskies/physics_api/voxel/Lod1SolidBlockState;", "(Lorg/valkyrienskies/core/api/physics/blockstates/SolidState;I)Lorg/valkyrienskies/physics_api/voxel/Lod1SolidBlockState;", "waitForAllVoxelUpdates$impl", "waitForAllVoxelUpdates", "Lorg/valkyrienskies/physics_api_krunch/KrunchPhysicsWorldSettings;", "makeKrunchSettings", "(Lorg/valkyrienskies/core/impl/config/PhysicsConfig;)Lorg/valkyrienskies/physics_api_krunch/KrunchPhysicsWorldSettings;", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$AngularLimitPair;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$AngularLimitPair;", "toKrunch", "(Lorg/valkyrienskies/core/internal/joints/VSD6Joint$AngularLimitPair;)Lorg/valkyrienskies/physics_api/joints/D6Joint$AngularLimitPair;", "(Lorg/valkyrienskies/core/internal/joints/VSD6Joint$D6Axis;)Lorg/valkyrienskies/physics_api/joints/D6Joint$D6Axis;", "(Lorg/valkyrienskies/core/internal/joints/VSD6Joint$D6Drive;)Lorg/valkyrienskies/physics_api/joints/D6Joint$D6Drive;", "(Lorg/valkyrienskies/core/internal/joints/VSD6Joint$D6JointDrive;)Lorg/valkyrienskies/physics_api/joints/D6Joint$D6JointDrive;", "(Lorg/valkyrienskies/core/internal/joints/VSD6Joint$D6Motion;)Lorg/valkyrienskies/physics_api/joints/D6Joint$D6Motion;", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$DrivePosition;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$DrivePosition;", "(Lorg/valkyrienskies/core/internal/joints/VSD6Joint$DrivePosition;)Lorg/valkyrienskies/physics_api/joints/D6Joint$DrivePosition;", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$DriveVelocity;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$DriveVelocity;", "(Lorg/valkyrienskies/core/internal/joints/VSD6Joint$DriveVelocity;)Lorg/valkyrienskies/physics_api/joints/D6Joint$DriveVelocity;", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$Hinges;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$Hinges;", "(Lorg/valkyrienskies/core/internal/joints/VSD6Joint$Hinges;)Lorg/valkyrienskies/physics_api/joints/D6Joint$Hinges;", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LimitCone;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$LimitCone;", "(Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LimitCone;)Lorg/valkyrienskies/physics_api/joints/D6Joint$LimitCone;", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LimitPyramid;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$LimitPyramid;", "(Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LimitPyramid;)Lorg/valkyrienskies/physics_api/joints/D6Joint$LimitPyramid;", "Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LinearLimit;", "Lorg/valkyrienskies/physics_api/joints/D6Joint$LinearLimit;", "(Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LinearLimit;)Lorg/valkyrienskies/physics_api/joints/D6Joint$LinearLimit;", "(Lorg/valkyrienskies/core/internal/joints/VSD6Joint$LinearLimitPair;)Lorg/valkyrienskies/physics_api/joints/D6Joint$LinearLimitPair;", "Lorg/valkyrienskies/core/internal/joints/VSJointPose;", "Lorg/valkyrienskies/physics_api/Pose;", "(Lorg/valkyrienskies/core/internal/joints/VSJointPose;)Lorg/valkyrienskies/physics_api/Pose;", "Lorg/valkyrienskies/core/internal/joints/VSRackAndPinionJoint$VSRackAndPinionJointData;", "Lorg/valkyrienskies/physics_api/joints/RackAndPinionJoint$Data;", "(Lorg/valkyrienskies/core/internal/joints/VSRackAndPinionJoint$VSRackAndPinionJointData;)Lorg/valkyrienskies/physics_api/joints/RackAndPinionJoint$Data;", "Lorg/valkyrienskies/core/internal/joints/VSRevoluteJoint$VSRevoluteDriveVelocity;", "Lorg/valkyrienskies/physics_api/joints/RevoluteJoint$RevoluteDriveVelocity;", "(Lorg/valkyrienskies/core/internal/joints/VSRevoluteJoint$VSRevoluteDriveVelocity;)Lorg/valkyrienskies/physics_api/joints/RevoluteJoint$RevoluteDriveVelocity;", "Lorg/valkyrienskies/core/impl/game/BlockTypesImpl;", "blockTypes", "Lorg/valkyrienskies/core/impl/game/BlockTypesImpl;", "Ljava/util/concurrent/ThreadPoolExecutor;", "chunkDeleterExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "Ljava/util/HashMap;", "Lkotlin/Pair;", "Lorg/valkyrienskies/core/api/events/CollisionEvent;", "Lkotlin/collections/HashMap;", "collisionEndEvents", "Ljava/util/HashMap;", "getCollisionEndEvents", "()Ljava/util/HashMap;", "collisionPersistEvents", "getCollisionPersistEvents", "collisionStartEvents", "getCollisionStartEvents", "", "Lorg/joml/Vector3dc;", "dimensionGravity", "Ljava/util/Map;", "", "Lit/unimi/dsi/fastutil/longs/Long2ObjectMap;", "Lorg/valkyrienskies/core/impl/game/ships/PhysShipImpl;", "Lorg/valkyrienskies/core/impl/game/ships/types/MutableShipIdMap;", "dimensionToShipIdToPhysShip", "getDimensionToShipIdToPhysShip$impl", "()Ljava/util/Map;", "Lorg/valkyrienskies/core/api/world/LevelYRange;", "dimensionYRanges", "Lorg/valkyrienskies/physics_api/VSPhysicsFactories;", "factories", "Lorg/valkyrienskies/physics_api/VSPhysicsFactories;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "gameFramesQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "groundShips", "getGroundShips$impl", "hasBeenDeleted", "Z", "hotswapSettings", "getHotswapSettings$impl", "()Z", "setHotswapSettings$impl", "(Z)V", "<set-?>", "isUsingDummy", "Lorg/valkyrienskies/physics_api/PhysicsThreadPool;", "krunchThreadPool", "Lorg/valkyrienskies/physics_api/PhysicsThreadPool;", "loadedVoxelChunks", "I", "getLoadedVoxelChunks", "()I", "Lorg/valkyrienskies/physics_api/Lod1BlockRegistry;", "lod1BlockRegistry", "Lorg/valkyrienskies/physics_api/Lod1BlockRegistry;", "nextJointId", "getNextJointId", "setNextJointId", "(I)V", "physTick", "Lorg/valkyrienskies/core/impl/pipelines/physics/PhysLevelImpl;", "physicsEngines", "getPhysicsEnginesTesting$impl", "physicsEnginesTesting", "Lit/unimi/dsi/fastutil/ints/Int2LongMap;", "physicsIdToShipId", "Lit/unimi/dsi/fastutil/ints/Int2LongMap;", "Lorg/valkyrienskies/core/impl/pipelines/physics/PhysicsThreadChecker;", "physicsThreadChecker", "Lorg/valkyrienskies/core/impl/pipelines/physics/PhysicsThreadChecker;", "Lkotlin/Function1;", "Lorg/valkyrienskies/physics_api_krunch/KrunchPhysicsWorldSettingsc;", "Lkotlin/ParameterName;", "name", "settings", "Lorg/valkyrienskies/physics_api/PhysicsWorldReference;", "physicsWorldFactory", "Lkotlin/jvm/functions/Function1;", "", "Lorg/valkyrienskies/core/internal/world/VsiPlayerState;", "playerStates", "Ljava/util/List;", "Lorg/valkyrienskies/core/impl/pipelines/physics/PriorityThreadPoolExecutor;", "priorityExecutor", "Lorg/valkyrienskies/core/impl/pipelines/physics/PriorityThreadPoolExecutor;", "Lorg/valkyrienskies/core/util/datastructures/BlockPos2ObjectOpenHashMap;", "Lorg/valkyrienskies/core/impl/pipelines/physics/TimedQueuedChunkUpdate2;", "queuedVoxelUpdates", "Lit/unimi/dsi/fastutil/longs/Long2ObjectMap;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "Lorg/valkyrienskies/physics_api_krunch/KrunchPhysicsWorldSettings;", "getSettings$impl", "()Lorg/valkyrienskies/physics_api_krunch/KrunchPhysicsWorldSettings;", "setSettings$impl", "(Lorg/valkyrienskies/physics_api_krunch/KrunchPhysicsWorldSettings;)V", "shipIdToDimension", "Lorg/valkyrienskies/core/util/datastructures/BlockPos2IntOpenHashMap;", "shipIdToInitialChunksNeedLoading", "Lorg/valkyrienskies/core/impl/game/ships/ShipObjectServerWorld;", "shipObjectServerWorld", "Lorg/valkyrienskies/core/impl/game/ships/ShipObjectServerWorld;", "useConstraintsFromGameFrame", "getUseConstraintsFromGameFrame$impl", "setUseConstraintsFromGameFrame$impl", "Ljava/lang/ThreadLocal;", "Lorg/valkyrienskies/physics_api/VSByteBuffer;", "vsByteBufferThreadLocal", "Ljava/lang/ThreadLocal;", "Lorg/valkyrienskies/core/impl/program/VSCoreInternal;", "vsCore$delegate", "Ljavax/inject/Provider;", "getVsCore", "()Lorg/valkyrienskies/core/impl/program/VSCoreInternal;", "vsCore", "Ljavax/inject/Provider;", "<init>", "(Lorg/valkyrienskies/core/impl/game/BlockTypesImpl;Lorg/valkyrienskies/core/impl/pipelines/physics/PhysicsThreadChecker;Lorg/valkyrienskies/core/impl/game/ships/ShipObjectServerWorld;Ljavax/inject/Provider;)V", "Companion", "impl"})
public final class FJ {
    public static final a a;
    public static final /* synthetic */ KProperty<Object>[] b;
    private final DN s;
    private final FR t;
    private final er_0 u;
    public final Provider c;
    final ConcurrentLinkedQueue<FC> d;
    private final Map<String, FQ> v;
    private final FS w;
    final Long2ObjectMap<BlockPos2ObjectOpenHashMap<FT>> e;
    private Map<String, ? extends Vector3dc> x;
    private final Map<String, LevelYRange> y;
    private final ThreadPoolExecutor z;
    public final Map<String, Long2ObjectMap<PhysShipImpl>> f;
    final Long2ObjectMap<String> g;
    private final Long2ObjectMap<Pair<BlockPos2IntOpenHashMap, Boolean>> A;
    private int B;
    Iv h;
    private final hk_0 C;
    final GU i;
    boolean j;
    final HashMap<Pair<Long, Long>, CollisionEvent> k;
    final HashMap<Pair<Long, Long>, CollisionEvent> l;
    final HashMap<Pair<Long, Long>, CollisionEvent> m;
    final CoroutineScope n;
    boolean o;
    private final Function1<Iw, ha_0> D;
    private final ThreadLocal<hi_0> E;
    private int F;
    private List<VsiPlayerState> G;
    public final Map<String, Long> p;
    private final Int2LongMap H;
    public int q;
    boolean r;
    private boolean I;
    private final GZ J;
    private static long K = -1L;
    private static final int L = 1000000;
    private static final Logger M;
    private static final FR N;
    private static final FR O;
    private static final Vector3dc P;

    @Inject
    public FJ(DN object, FR object2, er_0 object3, Provider<VSCoreInternal> iterator2) {
        Object object4;
        Object object5;
        Object object6;
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        Intrinsics.checkNotNullParameter((Object)object3, (String)"");
        Intrinsics.checkNotNullParameter(iterator2, (String)"");
        this.s = object;
        this.t = object2;
        this.u = object3;
        this.c = iterator2;
        this.d = new ConcurrentLinkedQueue();
        this.v = new HashMap();
        this.e = ER.a(new Pair[0]);
        this.x = MapsKt.emptyMap();
        this.y = new HashMap();
        this.z = new ThreadPoolExecutor(0, org.valkyrienskies.core.impl.shadow.FJ$a.a(a, VSCoreConfig.SERVER.getPt().getTerrainDeletionThreads()), 60L, TimeUnit.SECONDS, (BlockingQueue<Runnable>)new LinkedBlockingQueue(), FJ::a);
        this.f = new HashMap();
        this.g = ER.a(new Pair[0]);
        this.A = ER.a(new Pair[0]);
        this.h = FJ.a(VSCoreConfig.SERVER.getPhysics());
        this.k = new HashMap();
        this.l = new HashMap();
        this.m = new HashMap();
        this.n = CoroutineScopeKt.CoroutineScope((CoroutineContext)Dispatchers.getDefault());
        this.G = CollectionsKt.emptyList();
        this.p = new HashMap();
        this.H = (Int2LongMap)new Int2LongOpenHashMap();
        this.r = true;
        this.J = It.a(VSCoreConfig.SERVER.getPhysics().getPhysicsThreads());
        try {
            object3 = (Function1)new Function1<Iw, ha_0>(this){
                private /* synthetic */ FJ a;
                {
                    this.a = fJ;
                    super(1);
                }

                public final ha_0 a(Iw iw) {
                    Intrinsics.checkNotNullParameter((Object)iw, (String)"");
                    ha_0 ha_02 = It.a(this.a.J);
                    It.a(ha_02, iw);
                    return ha_02;
                }

                /*
                 * WARNING - void declaration
                 */
                public final /* synthetic */ Object invoke(Object p1) {
                    void var1_1;
                    return this.a((Iw)var1_1);
                }
            };
            object = It.INSTANCE.b();
            object2 = object.b().a(1000000);
            object2 = object.d().a((hi_0)object2);
        }
        catch (Exception exception) {
            object2 = exception;
            exception.printStackTrace();
            this.o = true;
            object = hz_0.INSTANCE;
            object2 = new hr_0();
            object3 = 2.a;
        }
        this.C = object;
        this.i = object2;
        this.D = object3;
        ThreadLocal<hi_0> threadLocal = ThreadLocal.withInitial(() -> FJ.g(this));
        Intrinsics.checkNotNullExpressionValue(threadLocal, (String)"");
        this.E = threadLocal;
        int n2 = org.valkyrienskies.core.impl.shadow.FJ$a.a(a, VSCoreConfig.SERVER.getPt().getTerrainBakingThreads());
        this.w = new FS(0, n2, VSCoreConfig.SERVER.getPt().getTerrainBakingThreadPriority(), 0L, null, null, 56, null);
        Object object7 = this;
        object3 = ((FJ)object7).s;
        Object object8 = ((DN)object3).b;
        if (!((CP)object8).h) {
            throw new IllegalStateException("A pipeline was created but the block state registry hasn't yet been frozen. Any changes to the registry will not take effect for this pipeline! This is a bug!");
        }
        object2 = ((FJ)object7).C.b().a(1000000);
        object3 = ((FJ)object7).s;
        object8 = object3 = ((DN)object3).b;
        ObjectSet objectSet = ((CP)object3).e.object2IntEntrySet();
        Intrinsics.checkNotNullExpressionValue((Object)objectSet, (String)"");
        iterator2 = (Iterable)objectSet;
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            int n3;
            Object object9 = iterator2.next();
            object6 = (SolidState)(object9 = (Object2IntMap.Entry)object9).getKey();
            if (object6 == null) continue;
            Intrinsics.checkNotNullExpressionValue((Object)object6, (String)"");
            object5 = object6;
            int n4 = n3 = object9.getIntValue();
            object4 = object5;
            object8 = object7;
            ((FJ)object7).i.a(new HZ(super.a(object4.getShape()), (float)object4.getElasticity(), (float)object4.getFriction(), (float)object4.getHardness(), n4), (hi_0)object2);
        }
        object8 = object3;
        ObjectSet objectSet2 = ((CP)object8).f.object2IntEntrySet();
        Intrinsics.checkNotNullExpressionValue((Object)objectSet2, (String)"");
        iterator2 = (Iterable)objectSet2;
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            int n5;
            Object object10 = iterator2.next();
            object6 = (LiquidState)(object10 = (Object2IntMap.Entry)object10).getKey();
            if (object6 == null) continue;
            Intrinsics.checkNotNullExpressionValue((Object)object6, (String)"");
            object5 = object6;
            int n6 = n5 = object10.getIntValue();
            object4 = object5;
            object8 = object7;
            object5 = object4.getShape();
            object6 = object8;
            if (!(object5 instanceof BoxBlockShape)) {
                object7 = "Failed requirement.";
                throw new IllegalArgumentException(object7.toString());
            }
            ((FJ)object7).i.a(new HX(FJ.a(object5.getBoundingBox()), (float)object4.getDensity(), (float)object4.getDragCoefficient(), new Vector3f((float)object4.getVelocity().x(), (float)object4.getVelocity().y(), (float)object4.getVelocity().z()), n6), (hi_0)object2);
        }
        object8 = object3;
        ObjectSet objectSet3 = ((CP)object8).g.object2IntEntrySet();
        Intrinsics.checkNotNullExpressionValue((Object)objectSet3, (String)"");
        iterator2 = (Iterable)objectSet3;
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            int n7;
            int n8;
            Object object11 = iterator2.next();
            object11 = (Object2IntMap.Entry)object11;
            object6 = (VsiBlockState)object11.getKey();
            int n9 = object11.getIntValue();
            if (n9 == 0) continue;
            if (((VsiBlockState)object6).getSolidState() != null) {
                SolidState solidState;
                object4 = solidState;
                object8 = object3;
                v5 = ((CP)object8).a.getInt(object4);
            } else {
                v5 = n8 = 0;
            }
            if (((VsiBlockState)object6).getLiquidState() != null) {
                LiquidState liquidState;
                object4 = liquidState;
                object8 = object3;
                v6 = ((CP)object8).b.getInt(object4);
            } else {
                v6 = n7 = 0;
            }
            if (!(n8 >= 0)) {
                object7 = "Solid state for " + (VsiBlockState)object6 + " is not registered!";
                throw new IllegalArgumentException(object7.toString());
            }
            if (!(n7 >= 0)) {
                object7 = "Liquid state for " + (VsiBlockState)object6 + " is not registered!";
                throw new IllegalArgumentException(object7.toString());
            }
            ((FJ)object7).i.a(n8, n7, n9);
        }
    }

    @JvmName(name="a")
    public final VSCoreInternal a() {
        return (VSCoreInternal)FV.a(this.c, b[0]);
    }

    @JvmName(name="p")
    private Map<String, FQ> p() {
        return this.v;
    }

    @JvmName(name="b")
    public final Map<String, Long2ObjectMap<PhysShipImpl>> b() {
        return this.f;
    }

    @JvmName(name="c")
    public final Iv c() {
        return this.h;
    }

    @JvmName(name="a")
    public final void a(Iv iv) {
        Intrinsics.checkNotNullParameter((Object)iv, (String)"");
        this.h = iv;
    }

    @JvmName(name="d")
    public final HashMap<Pair<Long, Long>, CollisionEvent> d() {
        return this.k;
    }

    @JvmName(name="e")
    public final HashMap<Pair<Long, Long>, CollisionEvent> e() {
        return this.l;
    }

    @JvmName(name="f")
    public final HashMap<Pair<Long, Long>, CollisionEvent> f() {
        return this.m;
    }

    @JvmName(name="g")
    public final boolean g() {
        return this.o;
    }

    @JvmName(name="q")
    private int q() {
        return this.F;
    }

    @JvmName(name="h")
    public final Map<String, Long> h() {
        return this.p;
    }

    @JvmName(name="i")
    public final int i() {
        return this.q;
    }

    @JvmName(name="a")
    public final void a(int n2) {
        this.q = n2;
    }

    @JvmName(name="j")
    public final boolean j() {
        return this.r;
    }

    @JvmName(name="a")
    private void a(boolean bl) {
        this.r = bl;
    }

    @JvmName(name="r")
    private boolean r() {
        return this.I;
    }

    @JvmName(name="b")
    private void b(boolean bl) {
        this.I = bl;
    }

    private final long a(String string, ShipTransform iterator2, int n2, int n3, int n4) {
        long l2 = 0x7FFFFFFFFFFFFFFL;
        Vector3d vector3d = new Vector3d((double)(n2 << 4) + 8.0, (double)(n3 << 4) + 8.0, (double)(n4 << 4) + 8.0);
        Iterator iterator3 = iterator2;
        if (iterator3 != null && (iterator3 = iterator3.getShipToWorld()) != null) {
            iterator3.transformPosition(vector3d);
        }
        iterator2 = this.G;
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            double d2;
            Object object = iterator2.next();
            if (!Intrinsics.areEqual((Object)((VsiPlayerState)(object = (VsiPlayerState)object)).getDimensionId(), (Object)string)) continue;
            double d3 = ((VsiPlayerState)object).getPos().distanceSquared(vector3d);
            if (!(d2 < (double)l2)) continue;
            l2 = MathKt.roundToLong((double)d3);
        }
        return l2;
    }

    private final void s() {
        Object object;
        Object object2;
        Iterator iterator2 = this.s;
        iterator2 = ((DN)((Object)iterator2)).b;
        if (!((CP)((Object)iterator2)).h) {
            throw new IllegalStateException("A pipeline was created but the block state registry hasn't yet been frozen. Any changes to the registry will not take effect for this pipeline! This is a bug!");
        }
        Object object3 = this.C.b().a(1000000);
        iterator2 = this.s;
        CP cP = ((DN)((Object)iterator2)).b;
        iterator2 = cP;
        ObjectSet objectSet = cP.e.object2IntEntrySet();
        Intrinsics.checkNotNullExpressionValue((Object)objectSet, (String)"");
        iterator2 = (Iterable)objectSet;
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            object2 = iterator2.next();
            SolidState solidState = (SolidState)(object2 = (Object2IntMap.Entry)object2).getKey();
            if (solidState == null) continue;
            Intrinsics.checkNotNullExpressionValue((Object)solidState, (String)"");
            object = solidState;
            int n2 = object2.getIntValue();
            this.i.a(this.a((SolidState)object, n2), (hi_0)object3);
        }
        iterator2 = cP;
        ObjectSet objectSet2 = ((CP)((Object)iterator2)).f.object2IntEntrySet();
        Intrinsics.checkNotNullExpressionValue((Object)objectSet2, (String)"");
        iterator2 = (Iterable)objectSet2;
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            object2 = iterator2.next();
            LiquidState liquidState = (LiquidState)(object2 = (Object2IntMap.Entry)object2).getKey();
            if (liquidState == null) continue;
            Intrinsics.checkNotNullExpressionValue((Object)liquidState, (String)"");
            object = liquidState;
            int n3 = object2.getIntValue();
            this.i.a(this.a((LiquidState)object, n3), (hi_0)object3);
        }
        iterator2 = cP;
        ObjectSet objectSet3 = ((CP)((Object)iterator2)).g.object2IntEntrySet();
        Intrinsics.checkNotNullExpressionValue((Object)objectSet3, (String)"");
        iterator2 = (Iterable)objectSet3;
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            Object object4 = iterator2.next();
            object4 = (Object2IntMap.Entry)object4;
            VsiBlockState vsiBlockState = (VsiBlockState)object4.getKey();
            int n4 = object4.getIntValue();
            if (n4 == 0) continue;
            int n5 = vsiBlockState.getSolidState() != null ? cP.a((SolidState)object3) : 0;
            int n6 = vsiBlockState.getLiquidState() != null ? cP.a((LiquidState)object3) : 0;
            if (!(n5 >= 0)) {
                String string = "Solid state for " + vsiBlockState + " is not registered!";
                throw new IllegalArgumentException(string.toString());
            }
            if (!(n6 >= 0)) {
                String string = "Liquid state for " + vsiBlockState + " is not registered!";
                throw new IllegalArgumentException(string.toString());
            }
            this.i.a(n5, n6, n4);
        }
    }

    private final ib_0 a(SolidBlockShape object) {
        Iterable<HT> iterable;
        Iterable<HT> iterable2;
        Object object2;
        if (!(object instanceof BoxesBlockShape)) {
            object = "Unsupported shape type " + (SolidBlockShape)object;
            throw new IllegalArgumentException(object.toString());
        }
        Iterable<HT> iterable3 = (Iterable<HT>)((BoxesBlockShape)object).getCollisionPoints();
        id_0 id_02 = FJ.a(object.getBoundingBox());
        Object object3 = iterable3;
        iterable3 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable3, (int)10));
        object3 = object3.iterator();
        while (object3.hasNext()) {
            object2 = object3.next();
            object2 = (CollisionPoint)object2;
            iterable2 = iterable3;
            iterable2.add(new HT(new Vector3f((float)((CollisionPoint)object2).getX(), (float)((CollisionPoint)object2).getY(), (float)((CollisionPoint)object2).getZ()), (float)((CollisionPoint)object2).getRadius()));
        }
        iterable3 = ((BoxesBlockShape)object).getPositiveBoxes();
        iterable2 = (List)iterable3;
        object3 = iterable3;
        iterable3 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable3, (int)10));
        object3 = object3.iterator();
        while (object3.hasNext()) {
            object2 = object3.next();
            object2 = (AABBic)object2;
            iterable = iterable3;
            iterable.add(FJ.a(object2));
        }
        iterable = (List)iterable3;
        iterable3 = ((BoxesBlockShape)object).getNegativeBoxes();
        object3 = iterable3;
        iterable3 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable3, (int)10));
        object3 = object3.iterator();
        while (object3.hasNext()) {
            object2 = object3.next();
            object2 = (AABBic)object2;
            object = iterable3;
            object.add(FJ.a(object2));
        }
        object = (List)iterable3;
        iterable3 = iterable;
        object3 = iterable2;
        object2 = id_02;
        return new ia_0((id_0)object2, (List<HT>)object3, (List<id_0>)iterable3, (List<id_0>)object);
    }

    private final id_0 a(LiquidBlockShape object) {
        if (!(object instanceof BoxBlockShape)) {
            object = "Failed requirement.";
            throw new IllegalArgumentException(object.toString());
        }
        return FJ.a(object.getBoundingBox());
    }

    private static id_0 a(AABBic aABBic) {
        return id_0.a.a((byte)aABBic.minX(), (byte)aABBic.minY(), (byte)aABBic.minZ(), (byte)aABBic.maxX(), (byte)aABBic.maxY(), (byte)aABBic.maxZ());
    }

    private final HZ a(SolidState solidState, int n2) {
        return new HZ(this.a(solidState.getShape()), (float)solidState.getElasticity(), (float)solidState.getFriction(), (float)solidState.getHardness(), n2);
    }

    private final HX a(LiquidState liquidState, int n2) {
        return new HX(this.a(liquidState.getShape()), (float)liquidState.getDensity(), (float)liquidState.getDragCoefficient(), new Vector3f((float)liquidState.getVelocity().x(), (float)liquidState.getVelocity().y(), (float)liquidState.getVelocity().z()), n2);
    }

    private PhysLevel a(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        FQ fQ = this.v.get(string);
        if (fQ != null) {
            return fQ;
        }
        throw new IllegalStateException("No physics engine found for dimension with ID " + string + ". Wtf?");
    }

    public final void a(FC fC) {
        Intrinsics.checkNotNullParameter((Object)fC, (String)"");
        if (this.d.size() >= 800) {
            org.valkyrienskies.core.impl.shadow.FJ$a.a(a).warn("Too many game frames in the game frame queue. Is the physics stage broken?");
            Thread.sleep(1000L);
        }
        this.d.add(fC);
    }

    public final FH a(double d2, boolean bl) {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        Iterator iterator2;
        Object object5;
        Object object6;
        Iterator iterator3;
        Object object722;
        while (!((Collection)this.d).isEmpty()) {
            FC fC = (FC)this.d.remove();
            Intrinsics.checkNotNullExpressionValue((Object)fC, (String)"");
            this.b(fC);
        }
        Long2ObjectMap long2ObjectMap = this.f.values();
        for (Object object722 : long2ObjectMap) {
            object722 = (Long2ObjectMap)object722;
            Collection collection = object722.values();
            Intrinsics.checkNotNullExpressionValue((Object)collection, (String)"");
            iterator3 = collection;
            object722 = iterator3.iterator();
            while (object722.hasNext()) {
                object6 = object722.next();
                iterator3 = (PhysShipImpl)object6;
                ((PhysShipImpl)((Object)iterator3)).setPoseVel(((PhysShipImpl)((Object)iterator3)).getRigidBodyReference$impl().d());
            }
        }
        long2ObjectMap = this.v;
        for (Map.Entry entry : long2ObjectMap.entrySet()) {
            object722 = entry;
            object722 = entry;
            iterator3 = (FQ)entry.getValue();
            ((FQ)((Object)iterator3)).physTick(d2);
        }
        long2ObjectMap = this.f.values();
        for (Object object722 : long2ObjectMap) {
            object722 = (Long2ObjectMap)object722;
            Collection collection = object722.values();
            Intrinsics.checkNotNullExpressionValue((Object)collection, (String)"");
            iterator3 = collection;
            object722 = iterator3.iterator();
            while (object722.hasNext()) {
                Pair<Vector3dc, Vector3dc> pair;
                Object object8;
                object6 = object722.next();
                iterator3 = (PhysShipImpl)object6;
                object6 = ((PhysShipImpl)((Object)iterator3)).getPhysicsListeners$impl();
                object5 = object6.iterator();
                while (object5.hasNext()) {
                    object8 = object5.next();
                    pair = (Pair<Vector3dc, Vector3dc>)object8;
                    Intrinsics.checkNotNullExpressionValue((Object)iterator3, (String)"");
                    FQ fQ = this.v.get(this.g.get(((PhysShipImpl)((Object)iterator3)).getId()));
                    if (fQ == null) continue;
                    pair.physTick((PhysShip)((Object)iterator3), (PhysLevel)fQ, d2);
                }
                if (((PhysShipImpl)((Object)iterator3)).isStatic()) continue;
                object6 = iterator3.getTransform();
                iterator2 = ((PhysShipImpl)((Object)iterator3)).getPoseVel();
                object5 = ((PhysShipImpl)((Object)iterator3)).getWingManager$impl();
                object8 = ((PhysShipImpl)((Object)iterator3)).getInertia$impl().getMomentOfInertiaTensor();
                FQ fQ = this.v.get(this.g.get(((PhysShipImpl)((Object)iterator3)).getId()));
                Intrinsics.checkNotNull((Object)fQ);
                pair = ex_0.a(fQ, object6, (hc_0)((Object)iterator2), (ew_0)object5, object8);
                Vector3dc vector3dc = (Vector3dc)pair.component1();
                Vector3dc vector3dc2 = (Vector3dc)pair.component2();
                if (vector3dc.isFinite() && vector3dc2.isFinite()) {
                    Intrinsics.checkNotNullExpressionValue(iterator3, (String)"");
                    PhysShip.applyWorldForce$default((PhysShip)((Object)iterator3), vector3dc, null, 2, null);
                    ((PhysShipImpl)((Object)iterator3)).applyWorldTorque(vector3dc2);
                }
                ((PhysShipImpl)((Object)iterator3)).applyQueuedForces();
            }
        }
        BuildersKt.runBlocking$default(null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, d2, true, null){
            private int a;
            private /* synthetic */ FJ b;
            private /* synthetic */ double c;
            private /* synthetic */ boolean d;
            {
                this.b = fJ;
                this.c = d2;
                this.d = bl;
                super(2, continuation);
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object object) {
                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.a) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)object);
                        this.a = 1;
                        if (FJ.a(this.b, this.c, this.d, (Continuation)this) != object2) return Unit.INSTANCE;
                        return object2;
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)object);
                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            /*
             * WARNING - void declaration
             */
            public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
                void var2_2;
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            private Object a(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final /* synthetic */ Object invoke(Object p1, Object p2) {
                e e2;
                CoroutineScope coroutineScope;
                Continuation continuation = (Continuation)coroutineScope;
                coroutineScope = (CoroutineScope)((Object)e2);
                e2 = this;
                return (e2.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }, 1, null);
        long2ObjectMap = this.f.values();
        for (Object object722 : long2ObjectMap) {
            object722 = (Long2ObjectMap)object722;
            Collection collection = object722.values();
            Intrinsics.checkNotNullExpressionValue((Object)collection, (String)"");
            iterator3 = collection;
            object722 = iterator3.iterator();
            while (object722.hasNext()) {
                object6 = object722.next();
                iterator3 = (PhysShipImpl)object6;
                object4 = ((PhysShipImpl)((Object)iterator3)).getRigidBodyReference$impl().d();
                if (!((hc_0)object4).b.isFinite()) {
                    org.valkyrienskies.core.impl.shadow.FJ$a.a(a).warn("NaN from physics engine detected, resetting body transform to last good one");
                    ((PhysShipImpl)((Object)iterator3)).getRigidBodyReference$impl().a(((PhysShipImpl)((Object)iterator3)).getPoseVel());
                }
                Iterator iterator4 = iterator3;
                ((PhysShipImpl)((Object)iterator4)).setPoseVel(((PhysShipImpl)((Object)iterator4)).getRigidBodyReference$impl().d());
            }
        }
        long2ObjectMap = this.v;
        for (Map.Entry<String, FQ> entry : long2ObjectMap.entrySet()) {
            object722 = entry;
            object722 = entry;
            iterator3 = entry.getKey();
            FQ fQ = (FQ)object722.getValue();
            object722 = fQ.c();
            object6 = (Iterable)object722;
            object3 = object6.iterator();
            while (object3.hasNext()) {
                object6 = object3.next();
                iterator2 = (HS)object6;
                long l2 = this.H.get(iterator2.a());
                long l3 = this.H.get(iterator2.b());
                object722 = new ArrayList();
                object6 = new ArrayList();
                object5 = new ArrayList();
                iterator2 = iterator2.c();
                iterator2 = iterator2.iterator();
                while (iterator2.hasNext()) {
                    object2 = iterator2.next();
                    Object object7 = object2 = (HQ)object2;
                    object4 = object7;
                    Object object8 = object2;
                    object4 = object8;
                    Object object9 = object2;
                    object4 = object9;
                    object4 = object2;
                    object = new ContactPointImpl(((HQ)object7).b, ((HQ)object8).c, ((HQ)object9).d, ((HQ)object4).e);
                    object4 = object2;
                    switch (org.valkyrienskies.core.impl.shadow.FJ$b.a[((HQ)object4).a.ordinal()]) {
                        case 1: {
                            object722.add(object);
                            break;
                        }
                        case 2: {
                            object6.add((Object)object);
                            break;
                        }
                        case 3: {
                            object5.add(object);
                            break;
                        }
                        case 4: {
                            org.valkyrienskies.core.impl.shadow.FJ$a.a(a).warn("Unknown collision event type for contact: " + (HQ)object2 + ", how did we get here?");
                        }
                    }
                }
                if (!((Collection)object722).isEmpty()) {
                    ((Map)this.k).put(TuplesKt.to((Object)l2, (Object)l3), new CollisionEventImpl((String)((Object)iterator3), fQ, l2, l3, (Collection)object722));
                }
                if (!((Collection)object6).isEmpty()) {
                    ((Map)this.l).put(TuplesKt.to((Object)l2, (Object)l3), new CollisionEventImpl((String)((Object)iterator3), fQ, l2, l3, (Collection)object6));
                }
                if (!(!((Collection)object5).isEmpty())) continue;
                ((Map)this.m).put(TuplesKt.to((Object)l2, (Object)l3), new CollisionEventImpl((String)((Object)iterator3), fQ, l2, l3, (Collection)object5));
            }
        }
        FJ fJ = this;
        object3 = ER.a(new Pair[0]);
        Long2ObjectMap long2ObjectMap2 = Long2ObjectMaps.emptyMap();
        Intrinsics.checkNotNullExpressionValue((Object)long2ObjectMap2, (String)"");
        long2ObjectMap = long2ObjectMap2;
        object722 = fJ.f.values();
        object722 = object722.iterator();
        while (object722.hasNext()) {
            iterator3 = object722.next();
            iterator3 = (Long2ObjectMap)iterator3;
            iterator3 = (Map)((Object)iterator3);
            for (Map.Entry entry : iterator3.entrySet()) {
                Object object12 = entry;
                object12 = entry;
                iterator2 = (Long)entry.getKey();
                object12 = (PhysShipImpl)object12.getValue();
                object5 = ((PhysShipImpl)object12).getRigidBodyReference$impl();
                object2 = object5.e();
                object = object5.d();
                object4 = object5.k();
                double d3 = object5.j();
                AABBd aABBd = new AABBd();
                object5.a(aABBd);
                int n2 = ((PhysShipImpl)object12).getLastShipTeleportId$impl();
                Map map2 = (Map)object3;
                Intrinsics.checkNotNullExpressionValue(iterator2, (String)"");
                map2.put(iterator2, new FA((Long)((Object)iterator2), (GX)object2, (hc_0)object, (Vector3dc)object4, d3, aABBd, n2));
            }
        }
        int n3 = fJ.B;
        fJ.B = n3 + 1;
        return new FH((Long2ObjectMap<? extends FA>)object3, (Long2ObjectMap<? extends List<? extends il_0>>)long2ObjectMap, n3);
    }

    private final Object a(double d2, boolean bl, Continuation<? super Unit> continuation) {
        Object object = CoroutineScopeKt.coroutineScope((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(d2, this, bl, null){
            private int a;
            private /* synthetic */ Object b;
            private /* synthetic */ double c;
            private /* synthetic */ FJ d;
            private /* synthetic */ boolean e;
            {
                this.c = d2;
                this.d = fJ;
                this.e = bl;
                super(2, continuation);
            }

            public final Object invokeSuspend(Object object) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure((Object)object);
                object = (CoroutineScope)this.b;
                if (this.c == 0.0) {
                    return Unit.INSTANCE;
                }
                Object object2 = this.d;
                if (((FJ)object2).r) {
                    Iv iv = FJ.a(VSCoreConfig.SERVER.getPhysics());
                    object2 = this.d;
                    Intrinsics.checkNotNullParameter((Object)iv, (String)"");
                    ((FJ)object2).h = iv;
                    int n2 = VSCoreConfig.SERVER.getPhysics().getPhysicsThreads();
                    if (this.d.J.a() != n2) {
                        org.valkyrienskies.core.impl.shadow.FJ$a.a(a).info("Updating krunch thread pool thread count from " + this.d.J.a() + " to " + n2);
                        this.d.J.a(n2);
                    }
                }
                Map map2 = this.d.v;
                FJ fJ = this.d;
                double d2 = this.c;
                boolean bl = this.e;
                for (Map.Entry entry : map2.entrySet()) {
                    Object object3 = entry;
                    object3 = entry;
                    String string = (String)entry.getKey();
                    object3 = (FQ)object3.getValue();
                    Object object4 = object3;
                    object2 = object4;
                    object2 = fJ;
                    It.a(((FQ)object4).b, ((FJ)object2).h);
                    BuildersKt.launch$default((CoroutineScope)object, (CoroutineContext)Dispatchers.getDefault(), null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(fJ, string, (FQ)object3, d2, bl, null){
                        private int a;
                        private /* synthetic */ FJ b;
                        private /* synthetic */ String c;
                        private /* synthetic */ FQ d;
                        private /* synthetic */ double e;
                        private /* synthetic */ boolean f;
                        {
                            this.b = fJ;
                            this.c = string;
                            this.d = fQ;
                            this.e = d2;
                            this.f = bl;
                            super(2, continuation);
                        }

                        /*
                         * Unable to fully structure code
                         */
                        public final Object invokeSuspend(Object var1_1) {
                            var3_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.a) {
                                case 0: {
                                    ResultKt.throwOnFailure((Object)var1_1);
                                    v0 = (Vector3dc)FJ.c(this.b).get(this.c);
                                    if (v0 == null) {
                                        v0 = FJ.a.b();
                                    }
                                    var1_1 = v0;
                                    var2_3 = this.d.a((Vector3dc)var1_1, this.e);
                                    var4_4 = this.b;
                                    var4_4 = var4_4.h;
                                    var4_5 = this.e / (double)var4_4.a;
                                    this.a = 1;
                                    if (CoroutineScopeKt.coroutineScope((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(var2_3, (Vector3dc)var1_1, this.e, this.f, this.b, var4_5, null){
                                        private int a;
                                        private /* synthetic */ Object b;
                                        private /* synthetic */ List<ha_0.b> c;
                                        private /* synthetic */ Vector3dc d;
                                        private /* synthetic */ double e;
                                        private /* synthetic */ boolean f;
                                        private /* synthetic */ FJ g;
                                        private /* synthetic */ double h;
                                        {
                                            this.c = list;
                                            this.d = vector3dc;
                                            this.e = d2;
                                            this.f = bl;
                                            this.g = fJ;
                                            this.h = d3;
                                            super(2, continuation);
                                        }

                                        public final Object invokeSuspend(Object object) {
                                            IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            ResultKt.throwOnFailure((Object)object);
                                            object = (CoroutineScope)this.b;
                                            Object object2 = this.c;
                                            Vector3dc vector3dc = this.d;
                                            double d2 = this.e;
                                            boolean bl = this.f;
                                            FJ fJ = this.g;
                                            double d3 = this.h;
                                            object2 = object2.iterator();
                                            while (object2.hasNext()) {
                                                Object object3 = object2.next();
                                                object3 = (ha_0.b)object3;
                                                BuildersKt.launch$default((CoroutineScope)object, (CoroutineContext)Dispatchers.getDefault(), null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(object3, vector3dc, d2, bl, fJ, d3, null){
                                                    private int a;
                                                    private int b;
                                                    private int c;
                                                    private /* synthetic */ ha_0.b d;
                                                    private /* synthetic */ Vector3dc e;
                                                    private /* synthetic */ double f;
                                                    private /* synthetic */ boolean g;
                                                    private /* synthetic */ FJ h;
                                                    private /* synthetic */ double i;
                                                    {
                                                        this.d = b2;
                                                        this.e = vector3dc;
                                                        this.f = d2;
                                                        this.g = bl;
                                                        this.h = fJ;
                                                        this.i = d3;
                                                        super(2, continuation);
                                                    }

                                                    /*
                                                     * Unable to fully structure code
                                                     */
                                                    public final Object invokeSuspend(Object var1_1) {
                                                        var4_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                        switch (this.c) {
                                                            case 0: {
                                                                ResultKt.throwOnFailure((Object)var1_1);
                                                                this.d.a(this.e, this.f);
                                                                this.c = 1;
                                                                if (YieldKt.yield((Continuation<? super Unit>)((Continuation)this)) == var4_2) {
                                                                    return var4_2;
                                                                }
                                                                ** GOTO lbl12
                                                            }
                                                            case 1: {
                                                                ResultKt.throwOnFailure((Object)var1_1);
lbl12:
                                                                // 2 sources

                                                                if (!this.g) break;
                                                                var2_3 = 0;
                                                                var1_1 = this.h;
                                                                var1_1 = var1_1.h;
                                                                var3_4 = var1_1.a;
lbl17:
                                                                // 2 sources

                                                                while (var2_3 < var3_4) {
                                                                    var1_1 = this.h;
                                                                    var1_1 = var1_1.h;
                                                                    this.d.a(this.e, this.i, (double)var2_3 / (double)var1_1.a);
                                                                    this.a = var2_3;
                                                                    this.b = var3_4;
                                                                    this.c = 2;
                                                                    if (YieldKt.yield((Continuation<? super Unit>)((Continuation)this)) == var4_2) {
                                                                        return var4_2;
                                                                    }
                                                                    ** GOTO lbl32
                                                                }
                                                                break;
                                                            }
                                                            case 2: {
                                                                var3_4 = this.b;
                                                                var2_3 = this.a;
                                                                ResultKt.throwOnFailure((Object)var1_1);
lbl32:
                                                                // 2 sources

                                                                ++var2_3;
                                                                ** GOTO lbl17
                                                            }
                                                        }
                                                        this.d.b();
                                                        return Unit.INSTANCE;
                                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                    }

                                                    /*
                                                     * WARNING - void declaration
                                                     */
                                                    public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
                                                        void var2_2;
                                                        return (Continuation)new /* invalid duplicate definition of identical inner class */;
                                                    }

                                                    private Object a(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                        return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                    }

                                                    public final /* synthetic */ Object invoke(Object p1, Object p2) {
                                                        a a2;
                                                        CoroutineScope coroutineScope;
                                                        Continuation continuation = (Continuation)coroutineScope;
                                                        coroutineScope = (CoroutineScope)((Object)a2);
                                                        a2 = this;
                                                        return (a2.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                    }
                                                }, 2, null);
                                            }
                                            return Unit.INSTANCE;
                                        }

                                        /*
                                         * WARNING - void declaration
                                         */
                                        public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
                                            void var1_1;
                                            1 var2_2;
                                            var2_2 = new /* invalid duplicate definition of identical inner class */;
                                            v0.b = var1_1;
                                            return (Continuation)var2_2;
                                        }

                                        private Object a(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }

                                        public final /* synthetic */ Object invoke(Object p1, Object p2) {
                                            1 var1_1;
                                            CoroutineScope coroutineScope;
                                            Continuation continuation = (Continuation)coroutineScope;
                                            coroutineScope = (CoroutineScope)((Object)var1_1);
                                            var1_1 = this;
                                            return (var1_1.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }
                                    }, (Continuation)this) == var3_2) {
                                        return var3_2;
                                    }
                                    ** GOTO lbl20
                                }
                                case 1: {
                                    ResultKt.throwOnFailure((Object)var1_1);
lbl20:
                                    // 2 sources

                                    this.d.h();
                                    return Unit.INSTANCE;
                                }
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        /*
                         * WARNING - void declaration
                         */
                        public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
                            void var2_2;
                            return (Continuation)new /* invalid duplicate definition of identical inner class */;
                        }

                        private Object a(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        public final /* synthetic */ Object invoke(Object p1, Object p2) {
                            a a2;
                            CoroutineScope coroutineScope;
                            Continuation continuation = (Continuation)coroutineScope;
                            coroutineScope = (CoroutineScope)((Object)a2);
                            a2 = this;
                            return (a2.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }
                    }, 2, null);
                }
                return Unit.INSTANCE;
            }

            /*
             * WARNING - void declaration
             */
            public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
                void var1_1;
                d d2;
                d2 = new /* invalid duplicate definition of identical inner class */;
                v0.b = var1_1;
                return (Continuation)d2;
            }

            private Object a(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final /* synthetic */ Object invoke(Object p1, Object p2) {
                d d2;
                CoroutineScope coroutineScope;
                Continuation continuation = (Continuation)coroutineScope;
                coroutineScope = (CoroutineScope)((Object)d2);
                d2 = this;
                return (d2.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }, continuation);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    public final void k() {
        org.valkyrienskies.core.impl.shadow.FJ$a.a(a).info("Deleting VSPhysicsPipelineStage resources!");
        if (this.j) {
            throw new IllegalStateException("Physics engine has already been deleted!");
        }
        this.g.clear();
        this.e.clear();
        this.i.close();
        BuildersKt.launch$default(this.n, (CoroutineContext)Dispatchers.getDefault(), null, (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, null){
            private int a;
            private /* synthetic */ FJ b;
            {
                this.b = fJ;
                super(2, continuation);
            }

            /*
             * Could not resolve type clashes
             * Unable to fully structure code
             */
            public final Object invokeSuspend(Object var1_1) {
                var2_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.a) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)var1_1);
                        FJ.d(this.b).shutdownNow();
                        FJ.e(this.b).shutdownNow();
lbl9:
                        // 2 sources

                        while (true) {
                            this.a = 1;
                            v0 = BuildersKt.withContext((CoroutineContext)Dispatchers.getIO(), (Function2)new Function2<CoroutineScope, Continuation<? super Boolean>, Object>(this.b, null){
                                private int a;
                                private /* synthetic */ FJ b;
                                {
                                    this.b = fJ;
                                    super(2, continuation);
                                }

                                public final Object invokeSuspend(Object object) {
                                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    ResultKt.throwOnFailure((Object)object);
                                    return Boxing.boxBoolean((boolean)this.b.w.awaitTermination(5L, TimeUnit.SECONDS));
                                }

                                /*
                                 * WARNING - void declaration
                                 */
                                public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
                                    void var2_2;
                                    return (Continuation)new /* invalid duplicate definition of identical inner class */;
                                }

                                private Object a(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
                                    return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                public final /* synthetic */ Object invoke(Object p1, Object p2) {
                                    1 var1_1;
                                    CoroutineScope coroutineScope;
                                    Continuation continuation = (Continuation)coroutineScope;
                                    coroutineScope = (CoroutineScope)((Object)var1_1);
                                    var1_1 = this;
                                    return (var1_1.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }
                            }, (Continuation)this);
                            if (v0 == var2_2) {
                                return var2_2;
                            }
                            ** GOTO lbl18
                            break;
                        }
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)var1_1);
                        v0 = var1_1;
lbl18:
                        // 2 sources

                        if (!((Boolean)v0).booleanValue()) {
                            org.valkyrienskies.core.impl.shadow.FJ$a.a(FJ.a).info("priorityExecutor thread pool is still terminating!");
                            ** continue;
                        }
lbl21:
                        // 3 sources

                        while (true) {
                            this.a = 2;
                            v1 = BuildersKt.withContext((CoroutineContext)Dispatchers.getIO(), (Function2)new Function2<CoroutineScope, Continuation<? super Boolean>, Object>(this.b, null){
                                private int a;
                                private /* synthetic */ FJ b;
                                {
                                    this.b = fJ;
                                    super(2, continuation);
                                }

                                public final Object invokeSuspend(Object object) {
                                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    ResultKt.throwOnFailure((Object)object);
                                    return Boxing.boxBoolean((boolean)this.b.z.awaitTermination(5L, TimeUnit.SECONDS));
                                }

                                /*
                                 * WARNING - void declaration
                                 */
                                public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
                                    void var2_2;
                                    return (Continuation)new /* invalid duplicate definition of identical inner class */;
                                }

                                private Object a(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
                                    return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                public final /* synthetic */ Object invoke(Object p1, Object p2) {
                                    2 var1_1;
                                    CoroutineScope coroutineScope;
                                    Continuation continuation = (Continuation)coroutineScope;
                                    coroutineScope = (CoroutineScope)((Object)var1_1);
                                    var1_1 = this;
                                    return (var1_1.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }
                            }, (Continuation)this);
                            if (v1 == var2_2) {
                                return var2_2;
                            }
                            ** GOTO lbl30
                            break;
                        }
                    }
                    case 2: {
                        ResultKt.throwOnFailure((Object)var1_1);
                        v1 = var1_1;
lbl30:
                        // 2 sources

                        if (!((Boolean)v1).booleanValue()) {
                            org.valkyrienskies.core.impl.shadow.FJ$a.a(FJ.a).info("chunkDeleterExecutor thread pool is still terminating!");
                            ** continue;
                        }
                        var1_1 = this.b;
                        var1_1 = var1_1.f;
                        for (Map.Entry v2 : var1_1.entrySet()) {
                            var2_2 = v2;
                            var2_2 = v2;
                            var2_2 = (Long2ObjectMap)v2.getValue();
                            var2_2 = (Map)var2_2;
                            for (Map.Entry<K, V> v3 : var2_2.entrySet()) {
                                var3_3 = v3;
                                var3_3 = v3;
                                var3_3 = (PhysShipImpl)v3.getValue();
                                v4 = var3_3.getRigidBodyReference$impl().c();
                                if (v4 == null) continue;
                                v4.close();
                            }
                        }
                        var1_1 = this.b;
                        var1_1.f.clear();
                        var1_1 = FJ.b(this.b);
                        for (Map.Entry<K, V> v5 : var1_1.entrySet()) {
                            var2_2 = v5;
                            var2_2 = v5;
                            var2_2 = (FQ)v5.getValue();
                            var2_2.b();
                        }
                        FJ.b(this.b).clear();
                        org.valkyrienskies.core.impl.shadow.FJ$a.a(FJ.a).info("VSPhysicsPipelineStage is fully deleted!");
                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            /*
             * WARNING - void declaration
             */
            public final Continuation<Unit> create(Object value, Continuation<?> $completion) {
                void var2_2;
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            private Object a(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return (this.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final /* synthetic */ Object invoke(Object p1, Object p2) {
                c c2;
                CoroutineScope coroutineScope;
                Continuation continuation = (Continuation)coroutineScope;
                coroutineScope = (CoroutineScope)((Object)c2);
                c2 = this;
                return (c2.create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }, 2, null);
        this.j = true;
    }

    private final void b(FC fC) {
        Iterator iterator2;
        Object object;
        Object object2;
        Object object3;
        Object object4;
        Object object5;
        Object object6;
        BlockPos2ObjectOpenHashMap<Object> blockPos2ObjectOpenHashMap;
        Object object7;
        Object object8;
        Object object9;
        Object object10;
        String string;
        Object object11;
        Object object13 = fC;
        Object object14 = ((FC)object13).j;
        for (Map.Entry object122 : object14.entrySet()) {
            object11 = object122;
            string = (String)object122.getKey();
            object10 = (LevelYRange)object11.getValue();
            this.y.put(string, (LevelYRange)object10);
        }
        object13 = fC;
        object14 = ((FC)object13).a;
        object14 = object14.iterator();
        while (object14.hasNext()) {
            Object t = object14.next();
            object13 = object11 = (fz_0)t;
            string = ((fz_0)object11).b;
            if (this.f.containsKey(string)) continue;
            this.f.put(string, ER.a(new Pair[0]));
            object10 = (ha_0)this.D.invoke((Object)this.h);
            FJ fJ = this;
            this.v.put(string, new FQ(string, (ha_0)object10, (Function0<? extends Long2ObjectMap<? extends PhysShip>>)((Function0)new Function0<Long2ObjectMap<? extends PhysShip>>(this, string){
                private /* synthetic */ FJ a;
                private /* synthetic */ String $b;
                {
                    this.a = fJ;
                    this.$b = string;
                    super(0);
                }

                public final Long2ObjectMap<? extends PhysShip> a() {
                    FJ fJ = this.a;
                    return fJ.f.get(this.$b);
                }

                public final /* synthetic */ Object invoke() {
                    return this.a();
                }
            }), fJ, fJ.u, (Function1<? super Integer, ? extends PhysShip>)((Function1)new Function1<Integer, PhysShip>(this, string){
                private /* synthetic */ FJ a;
                private /* synthetic */ String $b;
                {
                    this.a = fJ;
                    this.$b = string;
                    super(1);
                }

                public final PhysShip a(int n2) {
                    if (!this.a.H.containsKey(n2)) {
                        return null;
                    }
                    long l2 = this.a.H.get(n2);
                    FJ fJ = this.a;
                    Long2ObjectMap<PhysShipImpl> long2ObjectMap = fJ.f.get(this.$b);
                    return long2ObjectMap != null ? (PhysShipImpl)long2ObjectMap.get(l2) : null;
                }

                /*
                 * WARNING - void declaration
                 */
                public final /* synthetic */ Object invoke(Object p1) {
                    void var1_1;
                    return this.a(((Number)var1_1).intValue());
                }
            })));
        }
        object13 = fC;
        this.x = new HashMap<String, Vector3dc>(((FC)object13).i);
        object13 = fC;
        object14 = ((FC)object13).b;
        object14 = object14.iterator();
        while (object14.hasNext()) {
            Object t = object14.next();
            long l2 = ((Number)t).longValue();
            object10 = (String)this.g.get(l2);
            if (this.v.get(object10) == null) continue;
            object13 = object9;
            object8 = (Long2ObjectMap<PhysShipImpl>)((FQ)object9).c.get(l2);
            if (object8 != null) {
                Intrinsics.checkNotNullExpressionValue((Object)object8, (String)"");
                object7 = (Iterable)object8;
                blockPos2ObjectOpenHashMap = object7.iterator();
                while (blockPos2ObjectOpenHashMap.hasNext()) {
                    object6 = blockPos2ObjectOpenHashMap.next();
                    object13 = object5 = (fy_0)object6;
                    long l3 = ((fy_0)object5).b;
                    object13 = object5;
                    long l4 = ((fy_0)object13).c;
                    ((FQ)object9).enableCollisionBetween(l3, l4);
                }
            }
            object13 = object9;
            ((FQ)object13).d.add(l2);
        }
        object13 = fC;
        object14 = ((FC)object13).b;
        object14 = object14.iterator();
        while (object14.hasNext()) {
            Object t = object14.next();
            long l5 = ((Number)t).longValue();
            object10 = (String)this.g.get(l5);
            if (this.v.get(object10) == null) continue;
            Intrinsics.checkNotNull(this.f.get(object10));
            object7 = (PhysShipImpl)object8.get(l5);
            if (object7 == null) {
                throw new IllegalStateException("Tried deleting rigid body from ship with UUID " + l5 + ", but no rigid body exists for this ship!");
            }
            object4 = object7;
            blockPos2ObjectOpenHashMap = (object7 = ((PhysShipImpl)object4).getRigidBodyReference$impl()).c();
            if (blockPos2ObjectOpenHashMap instanceof hl_0) {
                this.F -= ((hl_0)((Object)blockPos2ObjectOpenHashMap)).d();
                this.z.submit(() -> FJ.a(blockPos2ObjectOpenHashMap));
            }
            object6 = new HashSet(((FQ)object9).getJointsFromShip(l5));
            object5 = (Iterable)object6;
            Iterator iterator3 = object5.iterator();
            while (iterator3.hasNext()) {
                Object t2 = iterator3.next();
                Integer n2 = (Integer)t2;
                Intrinsics.checkNotNullExpressionValue((Object)n2, (String)"");
                ((FQ)object9).removeJoint(n2);
            }
            ((FQ)object9).a(object7.a());
            this.H.remove(object7.a());
            object8.remove(l5);
            this.g.remove(l5);
            object13 = object9;
            ((FQ)object13).d.remove(l5);
        }
        object13 = fC;
        object14 = ((FC)object13).a;
        object14 = object14.iterator();
        while (object14.hasNext()) {
            Object t = object14.next();
            fz_0 fz_02 = (fz_0)t;
            object13 = fz_02;
            long l6 = fz_02.a;
            object13 = fz_02;
            object9 = ((fz_0)object13).b;
            object8 = l6;
            ((Map)this.g).put(object8, object9);
            Intrinsics.checkNotNull(this.f.get(object9));
            if (object7.containsKey(l6)) {
                throw new IllegalStateException("Tried creating rigid body from ship with UUID " + l6 + ", but a rigid body already exists for this ship!");
            }
            FQ fQ = this.v.get(object9);
            Intrinsics.checkNotNull((Object)fQ);
            object8 = fQ;
            object13 = fz_02;
            blockPos2ObjectOpenHashMap = ((fz_0)object13).c;
            if (blockPos2ObjectOpenHashMap instanceof VSVoxelCollisionShapeData) {
                object6 = ((VSVoxelCollisionShapeData)((Object)blockPos2ObjectOpenHashMap)).getMinDefined();
                object5 = ((VSVoxelCollisionShapeData)((Object)blockPos2ObjectOpenHashMap)).getMaxDefined();
                object3 = ((VSVoxelCollisionShapeData)((Object)blockPos2ObjectOpenHashMap)).getTotalVoxelRegion();
                boolean bl = ((VSVoxelCollisionShapeData)((Object)blockPos2ObjectOpenHashMap)).getShipVoxelsFullyLoaded();
                hl_0 hl_02 = this.C.a().a((Vector3ic)object6, (Vector3ic)object5, (AABBic)object3, this.i);
                hl_02.a(new Vector3d(0.5, 0.5, 0.5));
                object4 = ((FQ)object8).a((GS)hl_02);
                IShipActiveChunksSet iShipActiveChunksSet = ((VSVoxelCollisionShapeData)((Object)blockPos2ObjectOpenHashMap)).getChunksToLoad();
                if (iShipActiveChunksSet != null && iShipActiveChunksSet.getSize() > 0) {
                    hl_02.a(false);
                    BlockPos2IntOpenHashMap blockPos2IntOpenHashMap = new BlockPos2IntOpenHashMap(0, 0.0f, 3, null);
                    iShipActiveChunksSet.forEach((arg_0, arg_1) -> FJ.a(this, (String)object9, blockPos2IntOpenHashMap, arg_0, arg_1));
                    object2 = l6;
                    ((Map)this.A).put(object2, TuplesKt.to((Object)blockPos2IntOpenHashMap, (Object)bl));
                } else {
                    hl_02.a(bl);
                }
            } else if (blockPos2ObjectOpenHashMap instanceof VSSphereCollisionShapeData) {
                object6 = this.C.a().a(((VSSphereCollisionShapeData)((Object)blockPos2ObjectOpenHashMap)).getRadius());
                object4 = ((FQ)object8).a((GS)object6);
            } else if (blockPos2ObjectOpenHashMap instanceof VSWheelCollisionShapeData) {
                object6 = this.C.a().a(((VSWheelCollisionShapeData)((Object)blockPos2ObjectOpenHashMap)).getWheelRadius(), ((VSWheelCollisionShapeData)((Object)blockPos2ObjectOpenHashMap)).getHalfThickness(), ((VSWheelCollisionShapeData)((Object)blockPos2ObjectOpenHashMap)).getPointShellSize());
                object4 = ((FQ)object8).a((GS)object6);
            } else if (blockPos2ObjectOpenHashMap instanceof VSBoxCollisionShapeData) {
                object6 = this.C.a().a(new Vector3d(((VSBoxCollisionShapeData)((Object)blockPos2ObjectOpenHashMap)).getLengthX(), ((VSBoxCollisionShapeData)((Object)blockPos2ObjectOpenHashMap)).getLengthY(), ((VSBoxCollisionShapeData)((Object)blockPos2ObjectOpenHashMap)).getLengthZ()));
                object4 = ((FQ)object8).a((GS)object6);
            } else if (blockPos2ObjectOpenHashMap instanceof VSCapsuleCollisionShapeData) {
                object6 = this.C.a().a(((VSCapsuleCollisionShapeData)((Object)blockPos2ObjectOpenHashMap)).getRadius(), ((VSCapsuleCollisionShapeData)((Object)blockPos2ObjectOpenHashMap)).getLength());
                object4 = ((FQ)object8).a((GS)object6);
            } else {
                object13 = fz_02;
                throw new IllegalArgumentException("What is newShipInGameFrameData.collisionShapeData? " + ((fz_0)object13).c);
            }
            object5 = l6;
            ((Map)this.H).put(object4.a(), object5);
            object13 = fz_02;
            blockPos2ObjectOpenHashMap = ((fz_0)object13).e;
            object13 = fz_02;
            object6 = ((fz_0)object13).f;
            object13 = fz_02;
            boolean bl = ((fz_0)object13).g;
            object13 = fz_02;
            object3 = ((fz_0)object13).h;
            object13 = fz_02;
            WingManagerChanges wingManagerChanges = ((fz_0)object13).j;
            object13 = fz_02;
            int n3 = ((fz_0)object13).k;
            object13 = fz_02;
            int n4 = ((fz_0)object13).l;
            object13 = fz_02;
            double d2 = ((fz_0)object13).m;
            object13 = fz_02;
            double d3 = ((fz_0)object13).n;
            object13 = fz_02;
            double d4 = ((fz_0)object13).o;
            object4.a(org.valkyrienskies.core.impl.shadow.FJ$a.a(a, (ek_0)((Object)blockPos2ObjectOpenHashMap)));
            object4.a((hc_0)object6);
            object13 = fz_02;
            Vector3d vector3d = ((fz_0)object13).e.getCenterOfMass().mul(-1.0, new Vector3d());
            Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"");
            object4.a(vector3d);
            object13 = fz_02;
            object4.d(((fz_0)object13).d);
            object4.a(bl);
            object4.a(n4);
            object4.c(d2);
            object4.b(d3);
            object4.a(d4);
            object13 = fz_02;
            PhysShipImpl physShipImpl = new PhysShipImpl(l6, (GY)object4, ((fz_0)object13).i, (ek_0)((Object)blockPos2ObjectOpenHashMap), (hc_0)object6, n3, this.t, null, 128, null);
            physShipImpl.setStatic(bl);
            physShipImpl.setKinematicTarget((PhysPose)object3);
            if (wingManagerChanges != null) {
                physShipImpl.getWingManager$impl().a(wingManagerChanges);
            }
            object5 = l6;
            ((Map)object7).put(object5, physShipImpl);
            object13 = fz_02;
            if (!((fz_0)object13).p) continue;
            if (this.p.containsKey(object9)) {
                throw new IllegalStateException("Dimension " + (String)object9 + " cannot have more than 1 ground ship!");
            }
            object5 = l6;
            this.p.put((String)object9, (Long)object5);
            ((FQ)object8).a((Integer)object4.a());
            int n5 = object4.a();
            object13 = object8;
            ((FQ)object8).e = n5;
        }
        object13 = fC;
        object14 = (Map)((FC)object13).c;
        object14 = object14.entrySet().iterator();
        while (object14.hasNext()) {
            hc_0 hc_02;
            Pair pair;
            Pair pair2 = pair = object14.next();
            Long l7 = (Long)pair.getKey();
            object10 = (FB)pair2.getValue();
            Intrinsics.checkNotNullExpressionValue((Object)l7, (String)"");
            object9 = (String)this.g.get(l7.longValue());
            Intrinsics.checkNotNull(this.f.get(object9));
            object7 = (PhysShipImpl)object8.get(l7.longValue());
            if (object7 == null) {
                throw new IllegalStateException("Tried updating rigid body from ship with UUID " + l7 + ", but no rigid body exists for this ship!");
            }
            object4 = object7;
            object13 = object10;
            ((PhysShipImpl)object4).setKinematicTarget(((FB)object13).d);
            this.v.get(object9);
            blockPos2ObjectOpenHashMap = ((PhysShipImpl)object4).getRigidBodyReference$impl();
            object6 = blockPos2ObjectOpenHashMap.d();
            object5 = blockPos2ObjectOpenHashMap.k();
            object13 = object10;
            object3 = ((FB)object13).b.getCenterOfMass().mul(-1.0, new Vector3d());
            object13 = object6;
            Vector3d vector3d = ((hc_0)object13).c.transform(((Vector3d)object3).sub((Vector3dc)object5, new Vector3d()));
            object13 = object10;
            vector3d.mul(((FB)object13).a);
            boolean bl = ((PhysShipImpl)object4).isStatic();
            object13 = object10;
            boolean bl2 = ((FB)object13).c;
            if (bl != bl2) {
                ((PhysShipImpl)object4).setStatic(bl2);
            }
            object13 = object10;
            boolean bl3 = ((FB)object13).e;
            object13 = object10;
            object2 = ((FB)object13).g;
            object13 = object10;
            int n6 = ((FB)object13).h;
            object13 = object10;
            object = ((FB)object13).i;
            object13 = object10;
            Quaterniondc quaterniondc = ((FB)object13).j;
            object13 = object10;
            iterator2 = ((FB)object13).k;
            object13 = object10;
            Vector3dc vector3dc = ((FB)object13).l;
            boolean bl4 = ((PhysShipImpl)object4).getLastShipTeleportId$impl() != n6;
            if (!bl4) {
                object13 = object6;
                Vector3d vector3d2 = ((hc_0)object13).b.sub(vector3d, new Vector3d());
                Intrinsics.checkNotNullExpressionValue((Object)vector3d2, (String)"");
                Object object12 = object6;
                object13 = object12;
                Object object15 = object6;
                object13 = object15;
                object13 = object6;
                hc_02 = new hc_0(vector3d2, ((hc_0)object12).c, ((hc_0)object15).d, ((hc_0)object13).e);
            } else {
                hc_02 = new hc_0((Vector3dc)object, quaterniondc, (Vector3dc)((Object)iterator2), vector3dc);
            }
            hc_0 hc_03 = hc_02;
            object13 = object10;
            ((PhysShipImpl)object4).setInertia$impl(((FB)object13).b);
            object13 = object10;
            ((PhysShipImpl)object4).setPhysicsListeners$impl(((FB)object13).f);
            ((PhysShipImpl)object4).setPoseVel(hc_03);
            Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"");
            blockPos2ObjectOpenHashMap.a((Vector3dc)object3);
            blockPos2ObjectOpenHashMap.a(hc_03);
            object13 = object10;
            blockPos2ObjectOpenHashMap.a(org.valkyrienskies.core.impl.shadow.FJ$a.a(a, ((FB)object13).b));
            object13 = object10;
            blockPos2ObjectOpenHashMap.d(((FB)object13).a);
            object5 = blockPos2ObjectOpenHashMap.c();
            if (object5 instanceof hl_0) {
                AABBic aABBic;
                pair2 = (Pair)this.A.get(l7.longValue());
                if (pair2 != null && ((BlockPos2IntOpenHashMap)pair2.getFirst()).getSize() > 0) {
                    ((Map)this.A).put(l7, TuplesKt.to((Object)pair2.getFirst(), (Object)bl3));
                } else {
                    ((hl_0)object5).a(bl3);
                }
                object13 = object10;
                Intrinsics.checkNotNull((Object)((FB)object13).m);
                ((hl_0)object5).a(aABBic.minX(), aABBic.minY(), aABBic.minZ(), aABBic.maxX(), aABBic.maxY(), aABBic.maxZ());
            }
            if (object2 != null) {
                ((PhysShipImpl)object4).getWingManager$impl().a((WingManagerChanges)object2);
            }
            ((PhysShipImpl)object4).setLastShipTeleportId$impl(n6);
            if (((PhysShipImpl)object4).getKinematicTarget() != null || ((PhysShipImpl)object4).isStatic()) continue;
            ((PhysShipImpl)object4).getRigidBodyReference$impl().q();
        }
        object13 = fC;
        object14 = (Map)((FC)object13).d;
        for (Map.Entry entry : object14.entrySet()) {
            long l8;
            Object object16;
            FT fT;
            int n7;
            int n8;
            int n9;
            Object object17 = entry;
            Long l9 = (Long)entry.getKey();
            object10 = (BlockPos2ObjectOpenHashMap)object17.getValue();
            Intrinsics.checkNotNullExpressionValue((Object)l9, (String)"");
            object9 = (String)this.g.get(l9.longValue());
            Long2ObjectMap<PhysShipImpl> long2ObjectMap = this.f.get(object9);
            Intrinsics.checkNotNull(long2ObjectMap);
            object8 = (PhysShipImpl)long2ObjectMap.get(l9.longValue());
            Object obj = ((PhysShipImpl)object8).getRigidBodyReference$impl().c();
            Intrinsics.checkNotNull(obj);
            object7 = (hl_0)obj;
            object4 = object10;
            if (((BlockPos2ObjectOpenHashMap)object4).getContainsNullKey()) {
                object6 = (il_0)((BlockPos2ObjectOpenHashMap)object4).getValues()[((BlockPos2ObjectOpenHashMap)object4).getN()];
                n9 = ((BlockPos2ObjectOpenHashMap)object4).getKeys()[((BlockPos2ObjectOpenHashMap)object4).getN() * 3 + 2];
                n8 = ((BlockPos2ObjectOpenHashMap)object4).getKeys()[((BlockPos2ObjectOpenHashMap)object4).getN() * 3 + 1];
                n7 = ((BlockPos2ObjectOpenHashMap)object4).getKeys()[((BlockPos2ObjectOpenHashMap)object4).getN() * 3];
                fT = (FT)((BlockPos2ObjectOpenHashMap)this.e.computeIfAbsent(l9.longValue(), FJ::a)).getOrPut(n7, n8, n9, 5.a);
                object13 = fT;
                if (fT.a == null) {
                    object16 = object6;
                    if (object16 instanceof ik_0) {
                        if (object7.f(n7, n8, n9)) {
                            int n10 = this.F;
                            this.F = n10 + -1;
                        }
                        object2 = object7.a(n7, n8, n9);
                        this.a(l9, (hl_0)object7, n7, n8, n9);
                        this.a((ig_0)object2);
                    } else if (object16 instanceof ii_0) {
                        if (object7.f(n7, n8, n9)) {
                            int n11 = this.F;
                            this.F = n11 + -1;
                        }
                        object2 = object7.c(n7, n8, n9);
                        this.a((ig_0)object2);
                    } else if (object16 instanceof in_0 ? true : object16 instanceof im_0) {
                        object2 = object6 instanceof in_0 ? object7.g(n7, n8, n9) : null;
                        Intrinsics.checkNotNullExpressionValue((Object)object9, (String)"");
                        l8 = this.a((String)object9, object8.getTransform(), n7, n8, n9);
                        object17 = this.w.a(l8, () -> FJ.a((if_0)object2, this, (il_0)object6));
                        object13 = fT;
                        fT.a = object17;
                    }
                } else {
                    object13 = fT;
                    ((FT)object13).b.add((il_0)object6);
                }
            }
            for (int i2 = ((BlockPos2ObjectOpenHashMap)object4).getN(); i2 >= 0; --i2) {
                if (((BlockPos2ObjectOpenHashMap)object4).getKeys()[i2 * 3] == 0 && ((BlockPos2ObjectOpenHashMap)object4).getKeys()[i2 * 3 + 1] == 0 && ((BlockPos2ObjectOpenHashMap)object4).getKeys()[i2 * 3 + 2] == 0) continue;
                object6 = (il_0)((BlockPos2ObjectOpenHashMap)object4).getValues()[i2];
                n9 = ((BlockPos2ObjectOpenHashMap)object4).getKeys()[i2 * 3 + 2];
                n8 = ((BlockPos2ObjectOpenHashMap)object4).getKeys()[i2 * 3 + 1];
                n7 = ((BlockPos2ObjectOpenHashMap)object4).getKeys()[i2 * 3];
                fT = (FT)((BlockPos2ObjectOpenHashMap)this.e.computeIfAbsent(l9.longValue(), FJ::a)).getOrPut(n7, n8, n9, 5.a);
                object13 = fT;
                if (fT.a == null) {
                    object16 = object6;
                    if (object16 instanceof ik_0) {
                        if (object7.f(n7, n8, n9)) {
                            int n12 = this.F;
                            this.F = n12 + -1;
                        }
                        object2 = object7.a(n7, n8, n9);
                        this.a(l9, (hl_0)object7, n7, n8, n9);
                        this.a((ig_0)object2);
                        continue;
                    }
                    if (object16 instanceof ii_0) {
                        if (object7.f(n7, n8, n9)) {
                            int n13 = this.F;
                            this.F = n13 + -1;
                        }
                        object2 = object7.c(n7, n8, n9);
                        this.a((ig_0)object2);
                        continue;
                    }
                    if (!(object16 instanceof in_0 ? true : object16 instanceof im_0)) continue;
                    object2 = object6 instanceof in_0 ? object7.g(n7, n8, n9) : null;
                    Intrinsics.checkNotNullExpressionValue((Object)object9, (String)"");
                    l8 = this.a((String)object9, object8.getTransform(), n7, n8, n9);
                    object17 = this.w.a(l8, () -> FJ.a((if_0)object2, this, (il_0)object6));
                    object13 = fT;
                    fT.a = object17;
                    continue;
                }
                object13 = fT;
                ((FT)object13).b.add((il_0)object6);
            }
        }
        object13 = fC;
        object14 = ((FC)object13).g;
        object14 = object14.iterator();
        while (object14.hasNext()) {
            Object t = object14.next();
            fy_0 fy_02 = (fy_0)t;
            object13 = fy_02;
            FQ fQ = this.v.get(this.g.get(((fy_0)object13).b));
            if (fQ == null) continue;
            fy_0 fy_03 = fy_02;
            object13 = fy_03;
            object13 = fy_02;
            Boolean.valueOf(fQ.disableCollisionBetween(fy_03.b, ((fy_0)object13).c));
        }
        object13 = fC;
        object14 = ((FC)object13).h;
        object14 = object14.iterator();
        while (object14.hasNext()) {
            Object t = object14.next();
            fy_0 fy_04 = (fy_0)t;
            object13 = fy_04;
            FQ fQ = this.v.get(this.g.get(((fy_0)object13).b));
            if (fQ == null) continue;
            fy_0 fy_05 = fy_04;
            object13 = fy_05;
            object13 = fy_04;
            Boolean.valueOf(fQ.enableCollisionBetween(fy_05.b, ((fy_0)object13).c));
        }
        object13 = fC;
        this.G = ((FC)object13).f;
        object14 = new HashMap();
        Iterable iterable = this.G;
        Iterator iterator4 = iterable.iterator();
        block12: while (iterator4.hasNext()) {
            Object object18;
            object10 = object14;
            Object t = iterator4.next();
            VsiPlayerState vsiPlayerState = (VsiPlayerState)t;
            object9 = vsiPlayerState.getDimensionId();
            Object object19 = object10.get(object9);
            if (object19 == null) {
                BlockPos2ObjectOpenHashMap blockPos2ObjectOpenHashMap2 = new BlockPos2ObjectOpenHashMap(0, 0.0f, 3, null);
                object10.put(object9, blockPos2ObjectOpenHashMap2);
                object18 = blockPos2ObjectOpenHashMap2;
            } else {
                object18 = object19;
            }
            blockPos2ObjectOpenHashMap = (BlockPos2ObjectOpenHashMap)object18;
            object10 = vsiPlayerState.getPos();
            object9 = vsiPlayerState.getMountedShip();
            if (object9 != null) {
                Long2ObjectMap<PhysShipImpl> long2ObjectMap = this.f.get(vsiPlayerState.getDimensionId());
                PhysShipImpl physShipImpl = long2ObjectMap != null ? (PhysShipImpl)long2ObjectMap.get(((Long)object9).longValue()) : null;
                if (physShipImpl != null) {
                    Vector3dc vector3dc = vsiPlayerState.getMountedPos();
                    Intrinsics.checkNotNull((Object)vector3dc);
                    Vector3d vector3d = vector3dc.add(physShipImpl.getRigidBodyReference$impl().k(), new Vector3d()).mul(physShipImpl.getRigidBodyReference$impl().j());
                    Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"");
                    object19 = vector3d;
                    object10 = physShipImpl.getPoseVel().a((Vector3dc)object19, new Vector3d());
                }
            }
            int n14 = MathKt.roundToInt((double)object10.x()) >> 4;
            int n15 = MathKt.roundToInt((double)object10.y()) >> 4;
            int n16 = MathKt.roundToInt((double)object10.z()) >> 4;
            int n17 = n14 - 1;
            int n18 = n14 + 1;
            if (n17 > n18) continue;
            while (true) {
                int n19;
                int n20;
                if ((n20 = n15 - 1) <= (n19 = n15 + 1)) {
                    while (true) {
                        int n21;
                        int n22;
                        if ((n22 = n16 - 1) <= (n21 = n16 + 1)) {
                            while (true) {
                                blockPos2ObjectOpenHashMap.put(n17, n20, n22, null);
                                if (n22 == n21) break;
                                ++n22;
                            }
                        }
                        if (n20 == n19) break;
                        ++n20;
                    }
                }
                if (n17 == n18) continue block12;
                ++n17;
            }
        }
        Map map2 = (Map)this.e;
        Iterator iterator5 = map2.entrySet().iterator();
        while (iterator5.hasNext()) {
            long l10;
            il_0 il_02;
            Object object20;
            Object object21;
            int n23;
            int n24;
            int n25;
            Object object22;
            Object object23;
            Object object24 = object23 = iterator5.next();
            object10 = (Long)object23.getKey();
            object9 = (BlockPos2ObjectOpenHashMap)object24.getValue();
            Intrinsics.checkNotNullExpressionValue((Object)object10, (String)"");
            String string2 = (String)this.g.get(((Long)object10).longValue());
            Long2ObjectMap<PhysShipImpl> long2ObjectMap = this.f.get(string2);
            Object object25 = object22 = long2ObjectMap != null ? (PhysShipImpl)long2ObjectMap.get(((Long)object10).longValue()) : null;
            if (object25 == null) continue;
            Intrinsics.checkNotNullExpressionValue((Object)object25, (String)"");
            PhysShipImpl physShipImpl = object22;
            Object obj = physShipImpl.getRigidBodyReference$impl().c();
            Intrinsics.checkNotNull(obj);
            object22 = (hl_0)obj;
            blockPos2ObjectOpenHashMap = new BlockPos2ObjectOpenHashMap(0, 0.0f, 3, null);
            object6 = object9;
            if (((BlockPos2ObjectOpenHashMap)object6).getContainsNullKey()) {
                object24 = (FT)((BlockPos2ObjectOpenHashMap)object6).getValues()[((BlockPos2ObjectOpenHashMap)object6).getN()];
                n25 = ((BlockPos2ObjectOpenHashMap)object6).getKeys()[((BlockPos2ObjectOpenHashMap)object6).getN() * 3 + 2];
                n24 = ((BlockPos2ObjectOpenHashMap)object6).getKeys()[((BlockPos2ObjectOpenHashMap)object6).getN() * 3 + 1];
                n23 = ((BlockPos2ObjectOpenHashMap)object6).getKeys()[((BlockPos2ObjectOpenHashMap)object6).getN() * 3];
                object13 = object24;
                Future<ig_0> future = ((FT)object13).a;
                if (future != null && future.isDone()) {
                    Intrinsics.checkNotNull((Object)future.get());
                    if (!object22.f(n23, n24, n25)) {
                        int n26 = this.F;
                        this.F = n26 + 1;
                    }
                    object = object22.a(n23, n24, n25, (ig_0)object21);
                    this.a((Long)object10, (hl_0)object22, n23, n24, n25);
                    this.a((ig_0)object);
                    object23 = null;
                    object13 = object24;
                    ((FT)object24).a = object23;
                }
                object13 = object24;
                if (((FT)object13).a == null) {
                    object21 = new ArrayDeque();
                    object13 = object24;
                    object = ((FT)object13).b;
                    iterator2 = object.iterator();
                    while (iterator2.hasNext()) {
                        object20 = iterator2.next();
                        il_0 il_03 = il_02 = (il_0)object20;
                        if (il_02 instanceof ik_0) {
                            if (object22.f(il_02.a(), il_02.b(), il_02.c())) {
                                int n27 = this.F;
                                this.F = n27 + -1;
                            }
                            object23 = object22.a(il_02.a(), il_02.b(), il_02.c());
                            this.a((Long)object10, (hl_0)object22, n23, n24, n25);
                            this.a((ig_0)object23);
                            object21.clear();
                            continue;
                        }
                        if (il_03 instanceof ii_0) {
                            if (object22.f(il_02.a(), il_02.b(), il_02.c())) {
                                int n28 = this.F;
                                this.F = n28 + -1;
                            }
                            object23 = object22.c(il_02.a(), il_02.b(), il_02.c());
                            this.a((ig_0)object23);
                            object21.clear();
                            continue;
                        }
                        if (il_03 instanceof in_0) {
                            object21.add(il_02);
                            continue;
                        }
                        if (!(il_03 instanceof ij_0)) continue;
                        object21.clear();
                        object21.add(il_02);
                    }
                    object13 = object24;
                    ((FT)object13).b.clear();
                    if (!((Collection)object21).isEmpty()) {
                        object = CollectionsKt.first((Iterable)((Iterable)object21)) instanceof in_0 ? object22.g(n23, n24, n25) : null;
                        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"");
                        l10 = this.a(string2, physShipImpl.getTransform(), n23, n24, n25);
                        object23 = this.w.a(l10, () -> FJ.a((if_0)object, this, (Queue)object21));
                        object13 = object24;
                        ((FT)object24).a = object23;
                    }
                }
                if (((FT)object24).c()) {
                    blockPos2ObjectOpenHashMap.put(n23, n24, n25, null);
                }
            }
            for (int i3 = ((BlockPos2ObjectOpenHashMap)object6).getN(); i3 >= 0; --i3) {
                if (((BlockPos2ObjectOpenHashMap)object6).getKeys()[i3 * 3] == 0 && ((BlockPos2ObjectOpenHashMap)object6).getKeys()[i3 * 3 + 1] == 0 && ((BlockPos2ObjectOpenHashMap)object6).getKeys()[i3 * 3 + 2] == 0) continue;
                object24 = (FT)((BlockPos2ObjectOpenHashMap)object6).getValues()[i3];
                n25 = ((BlockPos2ObjectOpenHashMap)object6).getKeys()[i3 * 3 + 2];
                n24 = ((BlockPos2ObjectOpenHashMap)object6).getKeys()[i3 * 3 + 1];
                n23 = ((BlockPos2ObjectOpenHashMap)object6).getKeys()[i3 * 3];
                object13 = object24;
                Future<ig_0> future = ((FT)object13).a;
                if (future != null && future.isDone()) {
                    Intrinsics.checkNotNull((Object)future.get());
                    if (!object22.f(n23, n24, n25)) {
                        int n29 = this.F;
                        this.F = n29 + 1;
                    }
                    object = object22.a(n23, n24, n25, (ig_0)object21);
                    this.a((Long)object10, (hl_0)object22, n23, n24, n25);
                    this.a((ig_0)object);
                    object23 = null;
                    object13 = object24;
                    ((FT)object24).a = object23;
                }
                object13 = object24;
                if (((FT)object13).a == null) {
                    object21 = new ArrayDeque();
                    object13 = object24;
                    object = ((FT)object13).b;
                    iterator2 = object.iterator();
                    while (iterator2.hasNext()) {
                        object20 = iterator2.next();
                        il_0 il_04 = il_02 = (il_0)object20;
                        if (il_02 instanceof ik_0) {
                            if (object22.f(il_02.a(), il_02.b(), il_02.c())) {
                                int n30 = this.F;
                                this.F = n30 + -1;
                            }
                            object23 = object22.a(il_02.a(), il_02.b(), il_02.c());
                            this.a((Long)object10, (hl_0)object22, n23, n24, n25);
                            this.a((ig_0)object23);
                            object21.clear();
                            continue;
                        }
                        if (il_04 instanceof ii_0) {
                            if (object22.f(il_02.a(), il_02.b(), il_02.c())) {
                                int n31 = this.F;
                                this.F = n31 + -1;
                            }
                            object23 = object22.c(il_02.a(), il_02.b(), il_02.c());
                            this.a((ig_0)object23);
                            object21.clear();
                            continue;
                        }
                        if (il_04 instanceof in_0) {
                            object21.add(il_02);
                            continue;
                        }
                        if (!(il_04 instanceof ij_0)) continue;
                        object21.clear();
                        object21.add(il_02);
                    }
                    object13 = object24;
                    ((FT)object13).b.clear();
                    if (!((Collection)object21).isEmpty()) {
                        object = CollectionsKt.first((Iterable)((Iterable)object21)) instanceof in_0 ? object22.g(n23, n24, n25) : null;
                        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"");
                        l10 = this.a(string2, physShipImpl.getTransform(), n23, n24, n25);
                        object23 = this.w.a(l10, () -> FJ.a((if_0)object, this, (Queue)object21));
                        object13 = object24;
                        ((FT)object24).a = object23;
                    }
                }
                if (!((FT)object24).c()) continue;
                blockPos2ObjectOpenHashMap.put(n23, n24, n25, null);
            }
            object6 = blockPos2ObjectOpenHashMap;
            if (((BlockPos2ObjectOpenHashMap)object6).getContainsNullKey()) {
                Unit cfr_ignored_0 = (Unit)((BlockPos2ObjectOpenHashMap)object6).getValues()[((BlockPos2ObjectOpenHashMap)object6).getN()];
                n25 = ((BlockPos2ObjectOpenHashMap)object6).getKeys()[((BlockPos2ObjectOpenHashMap)object6).getN() * 3 + 2];
                n24 = ((BlockPos2ObjectOpenHashMap)object6).getKeys()[((BlockPos2ObjectOpenHashMap)object6).getN() * 3 + 1];
                n23 = ((BlockPos2ObjectOpenHashMap)object6).getKeys()[((BlockPos2ObjectOpenHashMap)object6).getN() * 3];
                ((BlockPos2ObjectOpenHashMap)object9).remove(n23, n24, n25);
            }
            for (int i3 = ((BlockPos2ObjectOpenHashMap)object6).getN(); i3 >= 0; --i3) {
                if (((BlockPos2ObjectOpenHashMap)object6).getKeys()[i3 * 3] == 0 && ((BlockPos2ObjectOpenHashMap)object6).getKeys()[i3 * 3 + 1] == 0 && ((BlockPos2ObjectOpenHashMap)object6).getKeys()[i3 * 3 + 2] == 0) continue;
                Unit cfr_ignored_1 = (Unit)((BlockPos2ObjectOpenHashMap)object6).getValues()[i3];
                n25 = ((BlockPos2ObjectOpenHashMap)object6).getKeys()[i3 * 3 + 2];
                n24 = ((BlockPos2ObjectOpenHashMap)object6).getKeys()[i3 * 3 + 1];
                n23 = ((BlockPos2ObjectOpenHashMap)object6).getKeys()[i3 * 3];
                ((BlockPos2ObjectOpenHashMap)object9).remove(n23, n24, n25);
            }
        }
        object13 = fC;
        Iterable iterable2 = ((FC)object13).a;
        for (Object t : iterable2) {
            FQ fQ;
            fz_0 fz_03 = (fz_0)t;
            object13 = fz_03;
            long l11 = fz_03.a;
            object13 = fz_03;
            String string3 = ((fz_0)object13).b;
            if (this.v.get(string3) == null) continue;
            object13 = fQ;
            Set set = (Set)fQ.c.get(l11);
            if (set == null) continue;
            Intrinsics.checkNotNullExpressionValue((Object)set, (String)"");
            blockPos2ObjectOpenHashMap = set;
            Iterator iterator6 = blockPos2ObjectOpenHashMap.iterator();
            while (iterator6.hasNext()) {
                fz_03 = iterator6.next();
                fy_0 fy_06 = (fy_0)((Object)fz_03);
                object13 = fy_06;
                long l12 = fy_06.b;
                object13 = fy_06;
                long l13 = ((fy_0)object13).c;
                fQ.enableCollisionBetween(l12, l13);
            }
        }
        if (this.I) {
            object13 = fC;
            Iterable iterable3 = ((FC)object13).e;
            for (Object t : iterable3) {
                VSJointAndId vSJointAndId = (VSJointAndId)t;
                Long l14 = vSJointAndId.getJoint().getShipId0();
                if (l14 == null) {
                    l14 = vSJointAndId.getJoint().getShipId1();
                }
                Long l15 = l14;
                Object object26 = this.g.get((Object)l15);
                Intrinsics.checkNotNull((Object)object26);
                object9 = (String)object26;
                FQ fQ = this.v.get(object9);
                Intrinsics.checkNotNull((Object)fQ);
                fQ.a(new HI(vSJointAndId.getJointId(), this.a(vSJointAndId.getJoint(), (String)object9)));
            }
        }
    }

    private final FH t() {
        Long2ObjectMap long2ObjectMap = ER.a(new Pair[0]);
        Long2ObjectMap long2ObjectMap2 = ER.a();
        Object object = this.f.values();
        object = object.iterator();
        while (object.hasNext()) {
            Object object2 = object.next();
            object2 = (Long2ObjectMap)object2;
            object2 = (Map)object2;
            for (Map.Entry entry : object2.entrySet()) {
                Object object3 = entry;
                object3 = entry;
                Long l2 = (Long)entry.getKey();
                object3 = (PhysShipImpl)object3.getValue();
                GY<?> gY = ((PhysShipImpl)object3).getRigidBodyReference$impl();
                GX gX = gY.e();
                hc_0 hc_02 = gY.d();
                Vector3dc vector3dc = gY.k();
                double d2 = gY.j();
                AABBd aABBd = new AABBd();
                gY.a(aABBd);
                int n2 = ((PhysShipImpl)object3).getLastShipTeleportId$impl();
                Map map2 = (Map)long2ObjectMap;
                Intrinsics.checkNotNullExpressionValue((Object)l2, (String)"");
                map2.put(l2, new FA(l2, gX, hc_02, vector3dc, d2, aABBd, n2));
            }
        }
        int n3 = this.B;
        this.B = n3 + 1;
        return new FH(long2ObjectMap, long2ObjectMap2, n3);
    }

    private static Iv a(PhysicsConfig physicsConfig) {
        Iv iv = new Iv(0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0, 0.0, 0.0, 0, null, 16383, null);
        double d2 = physicsConfig.getMaxDePenetrationSpeed();
        Iv iv2 = iv;
        iv.e = d2;
        int n2 = physicsConfig.getLodDetail();
        iv2 = iv;
        iv.f = n2;
        switch (org.valkyrienskies.core.impl.shadow.FJ$b.b[physicsConfig.getPhysicsBackend().ordinal()]) {
            case 1: {
                iv.a(Iz.KRUNCH_CLASSIC);
                break;
            }
            case 2: {
                iv.a(Iz.KRUNCH_PHYSX);
            }
        }
        iv2 = iv;
        if (iv2.g == Iz.KRUNCH_CLASSIC) {
            n2 = physicsConfig.getPhysicsSubSteps();
            iv2 = iv;
            iv.a = n2;
            iv.a(IC.GAUSS_SEIDEL);
            iv2 = iv;
            switch (org.valkyrienskies.core.impl.shadow.FJ$b.c[iv2.d.ordinal()]) {
                case 1: {
                    n2 = physicsConfig.getKrunchIterations();
                    iv2 = iv;
                    iv.b = n2;
                    n2 = physicsConfig.getKrunchIterations();
                    iv2 = iv;
                    iv.c = n2;
                    break;
                }
                case 2: {
                    int n3 = physicsConfig.getKrunchIterations();
                    if (n3 < 2) {
                        n3 = 2;
                    }
                    n2 = n3;
                    iv2 = iv;
                    iv.b = n2;
                    n2 = n3;
                    iv2 = iv;
                    iv.c = n2;
                }
            }
        } else {
            n2 = 1;
            iv2 = iv;
            iv.a = n2;
            n2 = physicsConfig.getPositionIterations();
            iv2 = iv;
            iv.b = n2;
            n2 = physicsConfig.getVelocityIterations();
            iv2 = iv;
            iv.c = n2;
        }
        return iv;
    }

    private void b(PhysicsConfig physicsConfig) {
        Intrinsics.checkNotNullParameter((Object)physicsConfig, (String)"");
        this.h = FJ.a(physicsConfig);
    }

    public final HJ a(VSJoint vSJoint, String long2ObjectMap) {
        HL hL;
        Integer n2;
        Integer n3;
        Intrinsics.checkNotNullParameter((Object)vSJoint, (String)"");
        Intrinsics.checkNotNullParameter((Object)long2ObjectMap, (String)"");
        Long2ObjectMap<PhysShipImpl> long2ObjectMap2 = this.f.get(long2ObjectMap);
        if (long2ObjectMap2 == null) {
            throw new IllegalStateException("No shipIdToPhysShip map found for dimension " + long2ObjectMap + "!");
        }
        long2ObjectMap = long2ObjectMap2;
        if (vSJoint.getShipId0() != null) {
            Long l2 = vSJoint.getShipId0();
            Intrinsics.checkNotNull((Object)l2);
            Object object = long2ObjectMap.get(l2.longValue());
            Intrinsics.checkNotNull((Object)object);
            v3 = ((PhysShipImpl)object).getRigidBodyReference$impl().a();
        } else {
            v3 = n3 = null;
        }
        if (vSJoint.getShipId1() != null) {
            Long l3 = vSJoint.getShipId1();
            Intrinsics.checkNotNull((Object)l3);
            Object object = long2ObjectMap.get(l3.longValue());
            Intrinsics.checkNotNull((Object)object);
            n2 = ((PhysShipImpl)object).getRigidBodyReference$impl().a();
        } else {
            n2 = null;
        }
        long2ObjectMap = n2;
        hb_0 hb_02 = new hb_0(vSJoint.getPose0().getPos(), vSJoint.getPose0().getRot());
        hb_0 hb_03 = new hb_0(vSJoint.getPose1().getPos(), vSJoint.getPose1().getRot());
        if (vSJoint.getMaxForceTorque() != null) {
            VSJointMaxForceTorque vSJointMaxForceTorque = vSJoint.getMaxForceTorque();
            Intrinsics.checkNotNull((Object)vSJointMaxForceTorque);
            float f2 = vSJointMaxForceTorque.getMaxForce();
            VSJointMaxForceTorque vSJointMaxForceTorque2 = vSJoint.getMaxForceTorque();
            Intrinsics.checkNotNull((Object)vSJointMaxForceTorque2);
            hL = new HL(f2, vSJointMaxForceTorque2.getMaxTorque());
        } else {
            hL = null;
        }
        HL hL2 = hL;
        double d2 = vSJoint.getCompliance();
        switch (org.valkyrienskies.core.impl.shadow.FJ$b.d[vSJoint.getJointType().ordinal()]) {
            case 1: {
                VSFixedJoint cfr_ignored_0 = (VSFixedJoint)vSJoint;
                return new HG(n3, hb_02, (Integer)long2ObjectMap, hb_03, hL2, d2);
            }
            case 2: {
                vSJoint = (VSDistanceJoint)vSJoint;
                return new HF(n3, hb_02, (Integer)long2ObjectMap, hb_03, hL2, ((VSDistanceJoint)vSJoint).getMinDistance(), ((VSDistanceJoint)vSJoint).getMaxDistance(), ((VSDistanceJoint)vSJoint).getTolerance(), ((VSDistanceJoint)vSJoint).getStiffness(), ((VSDistanceJoint)vSJoint).getDamping(), d2);
            }
            case 3: {
                vSJoint = (VSPrismaticJoint)vSJoint;
                return new HM(n3, hb_02, (Integer)long2ObjectMap, hb_03, hL2, FJ.a(((VSPrismaticJoint)vSJoint).getLinearLimitPair()), d2);
            }
            case 4: {
                vSJoint = (VSRevoluteJoint)vSJoint;
                return new HO(n3, hb_02, (Integer)long2ObjectMap, hb_03, hL2, FJ.a(((VSRevoluteJoint)vSJoint).getAngularLimitPair()), FJ.a(((VSRevoluteJoint)vSJoint).getDriveVelocity()), ((VSRevoluteJoint)vSJoint).getDriveForceLimit(), ((VSRevoluteJoint)vSJoint).getDriveGearRatio(), ((VSRevoluteJoint)vSJoint).getDriveFreeSpin(), d2);
            }
            case 5: {
                vSJoint = (VSSphericalJoint)vSJoint;
                return new HP(n3, hb_02, (Integer)long2ObjectMap, hb_03, hL2, FJ.a(((VSSphericalJoint)vSJoint).getLimitCone()), d2);
            }
            case 6: {
                vSJoint = (VSGearJoint)vSJoint;
                return new HH(n3, hb_02, (Integer)long2ObjectMap, hb_03, hL2, FJ.a(((VSGearJoint)vSJoint).getHinges()), ((VSGearJoint)vSJoint).getGearRatio(), d2);
            }
            case 7: {
                vSJoint = (VSRackAndPinionJoint)vSJoint;
                return new HN(n3, hb_02, (Integer)long2ObjectMap, hb_03, hL2, FJ.a(((VSRackAndPinionJoint)vSJoint).getHinges()), ((VSRackAndPinionJoint)vSJoint).getRatio(), FJ.a(((VSRackAndPinionJoint)vSJoint).getData()), d2);
            }
            case 8: {
                vSJoint = (VSD6Joint)vSJoint;
                return new HE(n3, hb_02, (Integer)long2ObjectMap, hb_03, hL2, this.a(((VSD6Joint)vSJoint).getMotions()), FJ.a(((VSD6Joint)vSJoint).getDistanceLimit()), this.b(((VSD6Joint)vSJoint).getLinearLimits()), FJ.a(((VSD6Joint)vSJoint).getTwistLimit()), FJ.a(((VSD6Joint)vSJoint).getSwingLimit()), FJ.a(((VSD6Joint)vSJoint).getPyramidSwingLimit()), this.c(((VSD6Joint)vSJoint).getDrives()), this.a(((VSD6Joint)vSJoint).getDrivePosition()), FJ.a(((VSD6Joint)vSJoint).getDriveVelocity()), d2);
            }
        }
        throw new IllegalArgumentException("Unknown constraint type " + vSJoint.getJointType());
    }

    private static HE.l a(VSD6Joint.LinearLimitPair linearLimitPair) {
        if (linearLimitPair == null) {
            return null;
        }
        return new HE.l(linearLimitPair.getLowerLimit(), linearLimitPair.getUpperLimit(), linearLimitPair.getRestitution(), linearLimitPair.getBounceThreshold(), linearLimitPair.getStiffness(), linearLimitPair.getDamping());
    }

    private static HE.a a(VSD6Joint.AngularLimitPair angularLimitPair) {
        if (angularLimitPair == null) {
            return null;
        }
        return new HE.a(angularLimitPair.getLowerLimit(), angularLimitPair.getUpperLimit(), angularLimitPair.getRestitution(), angularLimitPair.getBounceThreshold(), angularLimitPair.getStiffness(), angularLimitPair.getDamping());
    }

    private static HO.a a(VSRevoluteJoint.VSRevoluteDriveVelocity vSRevoluteDriveVelocity) {
        if (vSRevoluteDriveVelocity == null) {
            return null;
        }
        return new HO.a(vSRevoluteDriveVelocity.getVelocity(), vSRevoluteDriveVelocity.getAutoWake());
    }

    private static HE.i a(VSD6Joint.LimitCone limitCone) {
        if (limitCone == null) {
            return null;
        }
        return new HE.i(limitCone.getYLimitAngle(), limitCone.getZLimitAngle(), limitCone.getRestitution(), limitCone.getBounceThreshold(), limitCone.getStiffness(), limitCone.getDamping());
    }

    private static HE.h a(VSD6Joint.Hinges hinges) {
        if (hinges == null) {
            return null;
        }
        return new HE.h(hinges.getHinge0(), hinges.getHinge1());
    }

    private static HN.a a(VSRackAndPinionJoint.VSRackAndPinionJointData vSRackAndPinionJointData) {
        if (vSRackAndPinionJointData == null) {
            return null;
        }
        return new HN.a(vSRackAndPinionJointData.getRackTeeth(), vSRackAndPinionJointData.getPinionTeeth(), vSRackAndPinionJointData.getRackLength());
    }

    private final EnumMap<HE.b, HE.e> a(EnumMap<VSD6Joint.D6Axis, VSD6Joint.D6Motion> object) {
        if (object == null) {
            return null;
        }
        EnumMap<HE.b, HE.e> enumMap = new EnumMap<HE.b, HE.e>(HE.b.class);
        object = (Map)((Object)object);
        for (Map.Entry entry : object.entrySet()) {
            Object object2 = entry;
            object2 = entry;
            VSD6Joint.D6Axis d6Axis = (VSD6Joint.D6Axis)((Object)entry.getKey());
            object2 = (VSD6Joint.D6Motion)((Object)object2.getValue());
            Map map2 = enumMap;
            Intrinsics.checkNotNullExpressionValue((Object)((Object)d6Axis), (String)"");
            HE.b b2 = FJ.a(d6Axis);
            map2.put(b2, switch (object2 == null ? -1 : org.valkyrienskies.core.impl.shadow.FJ$b.f[((Enum)object2).ordinal()]) {
                case 1 -> HE.e.LOCKED;
                case 2 -> HE.e.FREE;
                case 3 -> HE.e.LIMITED;
                default -> null;
            });
        }
        return enumMap;
    }

    private static HE.b a(VSD6Joint.D6Axis d6Axis) {
        switch (org.valkyrienskies.core.impl.shadow.FJ$b.e[d6Axis.ordinal()]) {
            case 1: {
                return HE.b.X;
            }
            case 2: {
                return HE.b.Y;
            }
            case 3: {
                return HE.b.Z;
            }
            case 4: {
                return HE.b.TWIST;
            }
            case 5: {
                return HE.b.SWING1;
            }
            case 6: {
                return HE.b.SWING2;
            }
        }
        return null;
    }

    private static HE.e a(VSD6Joint.D6Motion d6Motion) {
        VSD6Joint.D6Motion d6Motion2 = d6Motion;
        switch (d6Motion2 == null ? -1 : org.valkyrienskies.core.impl.shadow.FJ$b.f[d6Motion2.ordinal()]) {
            case 1: {
                return HE.e.LOCKED;
            }
            case 2: {
                return HE.e.FREE;
            }
            case 3: {
                return HE.e.LIMITED;
            }
        }
        return null;
    }

    private static HE.k a(VSD6Joint.LinearLimit linearLimit) {
        if (linearLimit == null) {
            return null;
        }
        return new HE.k(linearLimit.getExtent(), linearLimit.getStiffness(), linearLimit.getDamping());
    }

    private final EnumMap<HE.b, HE.l> b(EnumMap<VSD6Joint.D6Axis, VSD6Joint.LinearLimitPair> object) {
        if (object == null) {
            return null;
        }
        EnumMap<HE.b, HE.l> enumMap = new EnumMap<HE.b, HE.l>(HE.b.class);
        object = (Map)((Object)object);
        for (Map.Entry entry : object.entrySet()) {
            Object object2 = entry;
            object2 = entry;
            VSD6Joint.D6Axis d6Axis = (VSD6Joint.D6Axis)((Object)entry.getKey());
            object2 = (VSD6Joint.LinearLimitPair)object2.getValue();
            Map map2 = enumMap;
            Intrinsics.checkNotNullExpressionValue((Object)((Object)d6Axis), (String)"");
            map2.put(FJ.a(d6Axis), FJ.a((VSD6Joint.LinearLimitPair)object2));
        }
        return enumMap;
    }

    private static HE.j a(VSD6Joint.LimitPyramid limitPyramid) {
        if (limitPyramid == null) {
            return null;
        }
        return new HE.j(limitPyramid.getYLimitAngleMin(), limitPyramid.getYLimitAngleMax(), limitPyramid.getZLimitAngleMin(), limitPyramid.getZLimitAngleMax(), limitPyramid.getRestitution(), limitPyramid.getBounceThreshold(), limitPyramid.getStiffness(), limitPyramid.getDamping());
    }

    private final EnumMap<HE.c, HE.d> c(EnumMap<VSD6Joint.D6Drive, VSD6Joint.D6JointDrive> object) {
        if (object == null) {
            return null;
        }
        EnumMap<HE.c, HE.d> enumMap = new EnumMap<HE.c, HE.d>(HE.c.class);
        object = (Map)((Object)object);
        for (Map.Entry entry : object.entrySet()) {
            Object object2 = entry;
            object2 = entry;
            Object object3 = (VSD6Joint.D6Drive)((Object)entry.getKey());
            object2 = (VSD6Joint.D6JointDrive)object2.getValue();
            Map map2 = enumMap;
            HE.c c2 = switch (object3 == null ? -1 : org.valkyrienskies.core.impl.shadow.FJ$b.g[((Enum)object3).ordinal()]) {
                case 1 -> HE.c.X;
                case 2 -> HE.c.Y;
                case 3 -> HE.c.Z;
                case 4 -> HE.c.SWING;
                case 5 -> HE.c.TWIST;
                case 6 -> HE.c.SLERP;
                default -> null;
            };
            object3 = object2;
            map2.put(c2, object3 == null ? null : new HE.d(((VSD6Joint.D6JointDrive)object3).getDriveStiffness(), ((VSD6Joint.D6JointDrive)object3).getDriveDamping(), ((VSD6Joint.D6JointDrive)object3).getDriveForceLimit(), ((VSD6Joint.D6JointDrive)object3).isAcceleration()));
        }
        return enumMap;
    }

    private static HE.c a(VSD6Joint.D6Drive d6Drive) {
        VSD6Joint.D6Drive d6Drive2 = d6Drive;
        switch (d6Drive2 == null ? -1 : org.valkyrienskies.core.impl.shadow.FJ$b.g[d6Drive2.ordinal()]) {
            case 1: {
                return HE.c.X;
            }
            case 2: {
                return HE.c.Y;
            }
            case 3: {
                return HE.c.Z;
            }
            case 4: {
                return HE.c.SWING;
            }
            case 5: {
                return HE.c.TWIST;
            }
            case 6: {
                return HE.c.SLERP;
            }
        }
        return null;
    }

    private static HE.d a(VSD6Joint.D6JointDrive d6JointDrive) {
        if (d6JointDrive == null) {
            return null;
        }
        return new HE.d(d6JointDrive.getDriveStiffness(), d6JointDrive.getDriveDamping(), d6JointDrive.getDriveForceLimit(), d6JointDrive.isAcceleration());
    }

    private final HE.f a(VSD6Joint.DrivePosition drivePosition) {
        if (drivePosition == null) {
            return null;
        }
        return new HE.f(FJ.a(drivePosition.getPose()), drivePosition.getAutoWake());
    }

    private static HE.g a(VSD6Joint.DriveVelocity driveVelocity) {
        if (driveVelocity == null) {
            return null;
        }
        return new HE.g(driveVelocity.getLinear(), driveVelocity.getAngular(), driveVelocity.getAutoWake());
    }

    private static hb_0 a(VSJointPose vSJointPose) {
        return new hb_0(vSJointPose.getPos(), vSJointPose.getRot());
    }

    private static int b(int n2) {
        return n2;
    }

    private void u() {
        Map map2 = (Map)this.e;
        for (Map.Entry entry : map2.entrySet()) {
            FT fT;
            BlockPos2ObjectOpenHashMap blockPos2ObjectOpenHashMap;
            Object object = entry;
            object = entry;
            object = (BlockPos2ObjectOpenHashMap)entry.getValue();
            object = object;
            if (blockPos2ObjectOpenHashMap.getContainsNullKey()) {
                int cfr_ignored_2 = ((BlockPos2ObjectOpenHashMap)object).getKeys()[((BlockPos2ObjectOpenHashMap)object).getN() * 3];
                cfr_ignored_2 = ((BlockPos2ObjectOpenHashMap)object).getKeys()[((BlockPos2ObjectOpenHashMap)object).getN() * 3 + 1];
                cfr_ignored_2 = ((BlockPos2ObjectOpenHashMap)object).getKeys()[((BlockPos2ObjectOpenHashMap)object).getN() * 3 + 2];
                FT fT2 = (FT)((BlockPos2ObjectOpenHashMap)object).getValues()[((BlockPos2ObjectOpenHashMap)object).getN()];
                fT = fT2;
                fT = fT2;
                Future<ig_0> future = fT2.a;
                if (future != null) {
                    future.get();
                }
            }
            for (int i2 = ((BlockPos2ObjectOpenHashMap)object).getN(); i2 >= 0; --i2) {
                if (((BlockPos2ObjectOpenHashMap)object).getKeys()[i2 * 3] == 0 && ((BlockPos2ObjectOpenHashMap)object).getKeys()[i2 * 3 + 1] == 0 && ((BlockPos2ObjectOpenHashMap)object).getKeys()[i2 * 3 + 2] == 0) continue;
                int cfr_ignored_5 = ((BlockPos2ObjectOpenHashMap)object).getKeys()[i2 * 3];
                cfr_ignored_5 = ((BlockPos2ObjectOpenHashMap)object).getKeys()[i2 * 3 + 1];
                cfr_ignored_5 = ((BlockPos2ObjectOpenHashMap)object).getKeys()[i2 * 3 + 2];
                FT fT3 = (FT)((BlockPos2ObjectOpenHashMap)object).getValues()[i2];
                fT = fT3;
                fT = fT3;
                Future<ig_0> future = fT3.a;
                if (future == null) continue;
                future.get();
            }
        }
    }

    private final void a(ig_0 ig_02) {
        if (ig_02 != null) {
            this.z.submit(() -> FJ.b(ig_02));
        }
    }

    private final void a(long l2, hl_0 hl_02, int n2, int n3, int n4) {
        Pair pair = (Pair)this.A.get(l2);
        if (pair == null) {
            return;
        }
        Pair pair2 = pair;
        ((BlockPos2IntOpenHashMap)pair.getFirst()).remove(n2, n3, n4);
        if (((BlockPos2IntOpenHashMap)pair2.getFirst()).getSize() == 0) {
            hl_02.a((Boolean)pair2.getSecond());
        }
    }

    private static final Thread a(Runnable runnable) {
        runnable = new Thread(runnable);
        ((Thread)runnable).setPriority(VSCoreConfig.SERVER.getPt().getTerrainDeletionThreadPriority());
        return runnable;
    }

    private static final hi_0 g(FJ fJ) {
        return fJ.C.b().a(1000000);
    }

    private static final void a(GS gS) {
        gS.close();
    }

    private static final void a(FJ iterator2, String string, BlockPos2IntOpenHashMap blockPos2IntOpenHashMap, int n2, int n3) {
        LevelYRange levelYRange = ((FJ)((Object)iterator2)).y.get(string);
        Intrinsics.checkNotNull((Object)levelYRange);
        iterator2 = levelYRange;
        iterator2 = (Iterable)new IntRange(((LevelYRange)((Object)iterator2)).getMinY() >> 4, ((LevelYRange)((Object)iterator2)).getMaxY() >> 4);
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            int n4 = ((IntIterator)iterator2).nextInt();
            int n5 = n4;
            n5 = n4;
            n5 = n4;
            blockPos2IntOpenHashMap.put(n2, n5, n3, 0);
        }
    }

    private static final BlockPos2ObjectOpenHashMap a(long l2) {
        return new BlockPos2ObjectOpenHashMap(0, 0.0f, 3, null);
    }

    private static final ig_0 a(if_0 object, FJ object2, il_0 il_02) {
        Object object3 = object;
        if (object3 == null || (object3 = object3.a()) == null) {
            object3 = ((FJ)object2).C.c().a(((FJ)object2).i);
        }
        object = object3;
        Intrinsics.checkNotNull((Object)il_02);
        object3.a((im_0)il_02);
        object2 = ((FJ)object2).E.get();
        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"");
        object.a((hi_0)object2);
        return object;
    }

    private static final ig_0 a(if_0 object, FJ fJ, Queue object2) {
        Object object3 = object;
        if (object3 == null || (object3 = object3.a()) == null) {
            object3 = fJ.C.c().a(fJ.i);
        }
        object = object3;
        object2 = (Iterable)object2;
        object2 = object2.iterator();
        while (object2.hasNext()) {
            Object object4 = object2.next();
            object4 = (im_0)object4;
            Intrinsics.checkNotNullExpressionValue(object4, (String)"");
            object.a((im_0)object4);
        }
        object2 = fJ.E.get();
        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"");
        object.a((hi_0)object2);
        return object;
    }

    private static final void b(ig_0 ig_02) {
        ig_02.close();
    }

    private static final void v() {
        String string = Thread.currentThread().getName();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"");
        boolean bl = StringsKt.startsWith$default((String)string, (String)"Physics thread", (boolean)false, (int)2, null);
        if (_Assertions.ENABLED && !bl) {
            String string2 = "Not called from physics thread";
            throw new AssertionError((Object)string2);
        }
    }

    private static final void w() {
    }

    public static final /* synthetic */ Object a(FJ fJ, double d2, boolean bl, Continuation continuation) {
        double d3 = d2;
        boolean bl2 = bl;
        Continuation continuation2 = continuation;
        Object object = CoroutineScopeKt.coroutineScope((Function2)new /* invalid duplicate definition of identical inner class */, continuation2);
        if (object != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            object = Unit.INSTANCE;
        }
        return object;
    }

    public static final /* synthetic */ Map c(FJ fJ) {
        return fJ.x;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[1];
        KProperty[] kPropertyArray2 = kPropertyArray;
        kPropertyArray[0] = Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(FJ.class, "vsCore", "getVsCore()Lorg/valkyrienskies/core/impl/program/VSCoreInternal;", 0)));
        b = kPropertyArray2;
        a = new a(null);
        M = FX.a("Burger Factory");
        N = FJ::v;
        O = FJ::w;
        P = new Vector3d(0.0, -10.0, 0.0);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\u0005\u0010\bR\u0017\u0010\u0005\u001a\u00020\t8\u0007\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\f\u001a\u00020\u000e8\u0007\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0005\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0017\u001a\u00020\u000e8\u0007\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0011R\u0014\u0010\u001a\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001b8CX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0015\u0010\u001e"}, d2={"Lorg/valkyrienskies/core/impl/shadow/FJ$a;", "", "Lorg/valkyrienskies/core/impl/shadow/Ek;", "p0", "Lorg/valkyrienskies/core/impl/shadow/GX;", "a", "(Lorg/valkyrienskies/core/impl/shadow/Ek;)Lorg/valkyrienskies/core/impl/shadow/GX;", "", "(I)I", "Lorg/joml/Vector3dc;", "P", "Lorg/joml/Vector3dc;", "b", "()Lorg/joml/Vector3dc;", "Lorg/valkyrienskies/core/impl/shadow/FR;", "N", "Lorg/valkyrienskies/core/impl/shadow/FR;", "()Lorg/valkyrienskies/core/impl/shadow/FR;", "", "K", "J", "c", "O", "d", "L", "I", "e", "Lorg/apache/logging/log4j/Logger;", "M", "Lorg/apache/logging/log4j/Logger;", "()Lorg/apache/logging/log4j/Logger;", "f", "<init>", "()V"})
    public static final class a {
        private static /* synthetic */ KProperty<Object>[] a;

        private a() {
        }

        private static GX a(ek_0 ek_02) {
            double d2;
            double d3 = d2 = 1.0 / ek_02.getShipMass();
            if (!(!Double.isInfinite(d2) && !Double.isNaN(d3))) {
                throw new IllegalStateException("invMass is not finite!");
            }
            Matrix3d matrix3d = ek_02.getMomentOfInertiaTensor().invert(new Matrix3d());
            if (!matrix3d.isFinite()) {
                throw new IllegalStateException("invInertiaMatrix is not finite!");
            }
            Intrinsics.checkNotNullExpressionValue((Object)matrix3d, (String)"");
            return new GX(d2, matrix3d);
        }

        private static int a(int n2) {
            return RangesKt.coerceIn((int)n2, (ClosedRange)((ClosedRange)new IntRange(1, Math.max(1, Runtime.getRuntime().availableProcessors() - 2))));
        }

        @JvmName(name="c")
        private final Logger c() {
            KProperty<Object> kProperty = a[0];
            Logger logger = M;
            Intrinsics.checkNotNullParameter(kProperty, (String)"");
            return logger;
        }

        @JvmName(name="a")
        public static FR a() {
            return N;
        }

        @JvmName(name="d")
        private static FR d() {
            return O;
        }

        @JvmName(name="b")
        public static Vector3dc b() {
            return P;
        }

        public static final /* synthetic */ int a(a a2, int n2) {
            int n3 = n2;
            return RangesKt.coerceIn((int)n3, (ClosedRange)((ClosedRange)new IntRange(1, Math.max(1, Runtime.getRuntime().availableProcessors() - 2))));
        }

        public static final /* synthetic */ Logger a(a object) {
            KProperty<Object> kProperty = a[0];
            object = M;
            Intrinsics.checkNotNullParameter(kProperty, (String)"");
            return object;
        }

        public static final /* synthetic */ GX a(a object, ek_0 ek_02) {
            double d2;
            object = ek_02;
            double d3 = d2 = 1.0 / object.getShipMass();
            if (!(!Double.isInfinite(d2) && !Double.isNaN(d3))) {
                throw new IllegalStateException("invMass is not finite!");
            }
            Matrix3d matrix3d = ((ek_0)object).getMomentOfInertiaTensor().invert(new Matrix3d());
            if (!matrix3d.isFinite()) {
                throw new IllegalStateException("invInertiaMatrix is not finite!");
            }
            Intrinsics.checkNotNullExpressionValue((Object)matrix3d, (String)"");
            return new GX(d2, matrix3d);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        static {
            KProperty[] kPropertyArray = new KProperty[1];
            KProperty[] kPropertyArray2 = kPropertyArray;
            kPropertyArray[0] = Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(a.class, "logger", "getLogger()Lorg/apache/logging/log4j/Logger;", 0)));
            a = kPropertyArray2;
        }
    }

    public final class b {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;
        public static final /* synthetic */ int[] d;
        public static final /* synthetic */ int[] e;
        public static final /* synthetic */ int[] f;
        public static final /* synthetic */ int[] g;

        static {
            int[] nArray = new int[HR.values().length];
            try {
                nArray[HR.START.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                nArray[HR.END.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                nArray[HR.PERSIST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                nArray[HR.UNKNOWN.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            a = nArray;
            nArray = new int[ConfigPhysicsBackendType.values().length];
            try {
                nArray[ConfigPhysicsBackendType.KRUNCH_CLASSIC.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                nArray[ConfigPhysicsBackendType.KRUNCH_PHYSX.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            b = nArray;
            nArray = new int[IC.values().length];
            try {
                nArray[IC.GAUSS_SEIDEL.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                nArray[IC.JACOBI.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            c = nArray;
            nArray = new int[VSJointType.values().length];
            try {
                nArray[VSJointType.FIXED.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                nArray[VSJointType.DISTANCE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                nArray[VSJointType.PRISMATIC.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                nArray[VSJointType.REVOLUTE.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                nArray[VSJointType.SPHERICAL.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                nArray[VSJointType.GEAR.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                nArray[VSJointType.RACK_AND_PINION.ordinal()] = 7;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                nArray[VSJointType.D6.ordinal()] = 8;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            d = nArray;
            nArray = new int[VSD6Joint.D6Axis.values().length];
            try {
                nArray[VSD6Joint.D6Axis.X.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                nArray[VSD6Joint.D6Axis.Y.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                nArray[VSD6Joint.D6Axis.Z.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                nArray[VSD6Joint.D6Axis.TWIST.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                nArray[VSD6Joint.D6Axis.SWING1.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                nArray[VSD6Joint.D6Axis.SWING2.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            e = nArray;
            nArray = new int[VSD6Joint.D6Motion.values().length];
            try {
                nArray[VSD6Joint.D6Motion.LOCKED.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                nArray[VSD6Joint.D6Motion.FREE.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                nArray[VSD6Joint.D6Motion.LIMITED.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            f = nArray;
            nArray = new int[VSD6Joint.D6Drive.values().length];
            try {
                nArray[VSD6Joint.D6Drive.X.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                nArray[VSD6Joint.D6Drive.Y.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                nArray[VSD6Joint.D6Drive.Z.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                nArray[VSD6Joint.D6Drive.SWING.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                nArray[VSD6Joint.D6Drive.TWIST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                nArray[VSD6Joint.D6Drive.SLERP.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            g = nArray;
        }
    }
}

