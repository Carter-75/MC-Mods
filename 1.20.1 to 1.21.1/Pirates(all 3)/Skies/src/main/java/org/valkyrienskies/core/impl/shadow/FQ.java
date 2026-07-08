/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.Long2ObjectMap
 *  it.unimi.dsi.fastutil.objects.ObjectCollection
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KProperty
 *  org.valkyrienskies.core.impl.shadow.Ha
 */
package org.valkyrienskies.core.impl.shadow;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.objects.ObjectCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.apache.logging.log4j.Logger;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.physics.RayCastResult;
import org.valkyrienskies.core.api.ships.PhysShip;
import org.valkyrienskies.core.api.util.AerodynamicUtils;
import org.valkyrienskies.core.impl.api_impl.physics.PhysTickEventImpl;
import org.valkyrienskies.core.impl.game.ships.PhysShipImpl;
import org.valkyrienskies.core.impl.program.VSCoreInternal;
import org.valkyrienskies.core.impl.shadow.ER;
import org.valkyrienskies.core.impl.shadow.FJ;
import org.valkyrienskies.core.impl.shadow.FV;
import org.valkyrienskies.core.impl.shadow.FX;
import org.valkyrienskies.core.impl.shadow.GS;
import org.valkyrienskies.core.impl.shadow.GY;
import org.valkyrienskies.core.impl.shadow.HI;
import org.valkyrienskies.core.impl.shadow.HS;
import org.valkyrienskies.core.impl.shadow.Ha;
import org.valkyrienskies.core.impl.shadow.er_0;
import org.valkyrienskies.core.impl.shadow.fy_0;
import org.valkyrienskies.core.impl.shadow.ha_0;
import org.valkyrienskies.core.impl.shadow.hd_0;
import org.valkyrienskies.core.impl.shadow.he_0;
import org.valkyrienskies.core.internal.joints.VSJoint;
import org.valkyrienskies.core.internal.world.VsiPhysLevel;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u009c\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u009e\u00012\u00020\u00012\u00020\u0002:\u0002\u009e\u0001Bu\u0012\n\u0010m\u001a\u00060kj\u0002`l\u0012\u0007\u0010\u0098\u0001\u001a\u00020\u0001\u0012%\u0010\u0089\u0001\u001a \u0012\u001b\u0012\u0019\u0012\u0006\b\u0001\u0012\u00020+\u0018\u00010qj\u000b\u0012\u0004\u0012\u00020+\u0018\u0001`\u0088\u00010\u0087\u0001\u0012\b\u0010\u008c\u0001\u001a\u00030\u008b\u0001\u0012\b\u0010\u0096\u0001\u001a\u00030\u0095\u0001\u0012\u001a\u0010\u0085\u0001\u001a\u0015\u0012\b\u0012\u00060\nj\u0002`\u0017\u0012\u0006\u0012\u0004\u0018\u00010+0\u0084\u0001\u00a2\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\f\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\t\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\f\u0010\rJ(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\b\b\u0000\u0010\u000f*\u00020\u000e2\u0006\u0010\u0010\u001a\u00028\u0000H\u0096\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014H\u0096\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001c\u0010\u0019\u001a\u00020\u00052\n\u0010\u0018\u001a\u00060\nj\u0002`\u0017H\u0096\u0001\u00a2\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001f\u001a\u00020\u00052\n\u0010\u001d\u001a\u00060\u001bj\u0002`\u001c2\n\u0010\u001e\u001a\u00060\u001bj\u0002`\u001cH\u0016\u00a2\u0006\u0004\b\u001f\u0010 J(\u0010#\u001a\u00020\u00142\n\u0010!\u001a\u00060\nj\u0002`\u00172\n\u0010\"\u001a\u00060\nj\u0002`\u0017H\u0096\u0001\u00a2\u0006\u0004\b#\u0010$J'\u0010%\u001a\u00020\u00052\n\u0010\u001d\u001a\u00060\u001bj\u0002`\u001c2\n\u0010\u001e\u001a\u00060\u001bj\u0002`\u001cH\u0016\u00a2\u0006\u0004\b%\u0010 J(\u0010&\u001a\u00020\u00142\n\u0010!\u001a\u00060\nj\u0002`\u00172\n\u0010\"\u001a\u00060\nj\u0002`\u0017H\u0096\u0001\u00a2\u0006\u0004\b&\u0010$J\u001f\u0010(\u001a\u0012\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0004\u0012\u00020\b0'H\u0016\u00a2\u0006\u0004\b(\u0010)J\u0015\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*H\u0016\u00a2\u0006\u0004\b,\u0010-J\u0016\u00100\u001a\b\u0012\u0004\u0012\u00020/0.H\u0096\u0001\u00a2\u0006\u0004\b0\u00101J\u0016\u00102\u001a\b\u0012\u0004\u0012\u00020\u00030.H\u0096\u0001\u00a2\u0006\u0004\b2\u00101J\u0016\u00103\u001a\b\u0012\u0004\u0012\u00020\u00030.H\u0096\u0001\u00a2\u0006\u0004\b3\u00101J\u0016\u00104\u001a\b\u0012\u0004\u0012\u00020\u00030.H\u0096\u0001\u00a2\u0006\u0004\b4\u00101J\u001d\u00106\u001a\u0004\u0018\u00010\b2\n\u00105\u001a\u00060\nj\u0002`\u000bH\u0016\u00a2\u0006\u0004\b6\u00107J)\u00108\u001a\u001c\u0012\b\u0012\u00060\u001bj\u0002`\u001c\u0012\u000e\u0012\f\u0012\b\u0012\u00060\nj\u0002`\u000b0*0'H\u0016\u00a2\u0006\u0004\b8\u0010)J%\u0010:\u001a\f\u0012\b\u0012\u00060\nj\u0002`\u000b0*2\n\u00109\u001a\u00060\u001bj\u0002`\u001cH\u0016\u00a2\u0006\u0004\b:\u0010;J\u001d\u0010<\u001a\u0004\u0018\u00010+2\n\u00109\u001a\u00060\u001bj\u0002`\u001cH\u0016\u00a2\u0006\u0004\b<\u0010=J\u0010\u0010>\u001a\u00020\u0005H\u0096\u0001\u00a2\u0006\u0004\b>\u0010?J\u0017\u0010B\u001a\u00020\u00142\u0006\u0010A\u001a\u00020@H\u0016\u00a2\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u00020\u0014H\u0096\u0001\u00a2\u0006\u0004\bD\u0010\u0016J&\u0010I\u001a\b\u0012\u0004\u0012\u00020H0.2\u0006\u0010F\u001a\u00020E2\u0006\u0010G\u001a\u00020@H\u0096\u0001\u00a2\u0006\u0004\bI\u0010JJ9\u0010Q\u001a\u0004\u0018\u00010P2\u0006\u0010K\u001a\u00020E2\u0006\u0010L\u001a\u00020E2\u0006\u0010M\u001a\u00020@2\u000e\u0010O\u001a\u00020N\"\u00060\u001bj\u0002`\u001cH\u0016\u00a2\u0006\u0004\bQ\u0010RJ:\u0010X\u001a\u0004\u0018\u00010W2\u0006\u0010K\u001a\u00020E2\u0006\u0010S\u001a\u00020E2\u0006\u0010T\u001a\u00020@2\u000e\u0010V\u001a\u00020U\"\u00060\nj\u0002`\u0017H\u0096\u0001\u00a2\u0006\u0004\bX\u0010YJ:\u0010[\u001a\u0004\u0018\u00010Z2\u0006\u0010K\u001a\u00020E2\u0006\u0010S\u001a\u00020E2\u0006\u0010T\u001a\u00020@2\u000e\u0010V\u001a\u00020U\"\u00060\nj\u0002`\u0017H\u0096\u0001\u00a2\u0006\u0004\b[\u0010\\J\u001c\u0010^\u001a\u00020\u00052\n\u00105\u001a\u00060\nj\u0002`]H\u0096\u0001\u00a2\u0006\u0004\b^\u0010\u001aJ\u001b\u0010_\u001a\u00020\u00052\n\u00105\u001a\u00060\nj\u0002`\u000bH\u0016\u00a2\u0006\u0004\b_\u0010\u001aJ \u0010a\u001a\u00020\u00142\u000e\u0010`\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u0017H\u0096\u0001\u00a2\u0006\u0004\ba\u0010bJ\u0018\u0010c\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0001\u00a2\u0006\u0004\bc\u0010\u0007J#\u0010e\u001a\u00020\u00052\n\u00105\u001a\u00060\nj\u0002`\u000b2\u0006\u0010d\u001a\u00020\bH\u0016\u00a2\u0006\u0004\be\u0010fR\u0014\u0010j\u001a\u00020g8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bh\u0010iR\u001e\u0010m\u001a\u00060kj\u0002`l8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bm\u0010n\u001a\u0004\bo\u0010pR3\u0010u\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020s0r0qj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020s0r`t8\u0006\u00a2\u0006\f\n\u0004\bu\u0010v\u001a\u0004\bw\u0010xR\u001a\u0010y\u001a\b\u0012\u0004\u0012\u00020s0r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\by\u0010zR#\u0010{\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R(\u0010\u0082\u0001\u001a\u0013\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0004\u0012\u00020\b0\u0081\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R*\u0010\u0085\u0001\u001a\u0015\u0012\b\u0012\u00060\nj\u0002`\u0017\u0012\u0006\u0012\u0004\u0018\u00010+0\u0084\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R5\u0010\u0089\u0001\u001a \u0012\u001b\u0012\u0019\u0012\u0006\b\u0001\u0012\u00020+\u0018\u00010qj\u000b\u0012\u0004\u0012\u00020+\u0018\u0001`\u0088\u00010\u0087\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0018\u0010\u008c\u0001\u001a\u00030\u008b\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R6\u0010\u0090\u0001\u001a\u001c\u0012\b\u0012\u00060\u001bj\u0002`\u001c0\u008e\u0001j\r\u0012\b\u0012\u00060\u001bj\u0002`\u001c`\u008f\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R2\u0010\u0094\u0001\u001a\u001d\u0012\b\u0012\u00060\u001bj\u0002`\u001c\u0012\u000e\u0012\f\u0012\b\u0012\u00060\nj\u0002`\u000b0r0\u0081\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0083\u0001R\u0018\u0010\u0096\u0001\u001a\u00030\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001f\u0010\u0098\u0001\u001a\u00020\u00018\u0000X\u0080\u0004\u00a2\u0006\u0010\n\u0006\b\u0098\u0001\u0010\u0099\u0001\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\u00a8\u0006\u009f\u0001"}, d2={"Lorg/valkyrienskies/core/impl/pipelines/physics/PhysLevelImpl;", "Lorg/valkyrienskies/physics_api/PhysicsWorldReference;", "Lorg/valkyrienskies/core/internal/world/VsiPhysLevel;", "Lorg/valkyrienskies/physics_api/joints/JointAndId;", "jointAndId", "", "addConstraint", "(Lorg/valkyrienskies/physics_api/joints/JointAndId;)Z", "Lorg/valkyrienskies/core/internal/joints/VSJoint;", "newJoint", "", "Lorg/valkyrienskies/core/internal/joints/VSJointId;", "addJoint", "(Lorg/valkyrienskies/core/internal/joints/VSJoint;)I", "Lorg/valkyrienskies/physics_api/CollisionShapeReference;", "T", "shape", "Lorg/valkyrienskies/physics_api/PhysicsBodyReference;", "createRigidBody", "(Lorg/valkyrienskies/physics_api/CollisionShapeReference;)Lorg/valkyrienskies/physics_api/PhysicsBodyReference;", "", "deletePhysicsWorldResources", "()V", "Lorg/valkyrienskies/physics_api/PhysicsBodyId;", "physicsBodyId", "deleteRigidBody", "(I)Z", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "shipId0", "shipId1", "disableCollisionBetween", "(JJ)Z", "body0", "body1", "disableCollisionBetweenBodies", "(II)V", "enableCollisionBetween", "enableCollisionBetweenBodies", "", "getAllJoints", "()Ljava/util/Map;", "", "Lorg/valkyrienskies/core/api/ships/PhysShip;", "getAllPhysShips", "()Ljava/util/Set;", "", "Lorg/valkyrienskies/physics_api/simevents/ContactEvent;", "getCollisionEvents", "()Ljava/util/List;", "getConstraints", "getConstraintsBrokenLastTick", "getConstraintsRemovedFromDeletedBodiesLastTick", "jointId", "getJointById", "(I)Lorg/valkyrienskies/core/internal/joints/VSJoint;", "getJointsByShipIds", "shipId", "getJointsFromShip", "(J)Ljava/util/Set;", "getShipById", "(J)Lorg/valkyrienskies/core/api/ships/PhysShip;", "hasBeenDeleted", "()Z", "", "delta", "physTick", "(D)V", "postStep", "Lorg/joml/Vector3dc;", "gravity", "timeStep", "Lorg/valkyrienskies/physics_api/PhysicsWorldReference$PhysicsWorldIsland;", "preStep", "(Lorg/joml/Vector3dc;D)Ljava/util/List;", "start", "direction", "length", "", "ignoredShips", "Lorg/valkyrienskies/core/api/physics/RayCastResult;", "rayCast", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;D[J)Lorg/valkyrienskies/core/api/physics/RayCastResult;", "normal", "distance", "", "ignoredBodies", "Lorg/valkyrienskies/physics_api/RayCastResult;", "rayTrace", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;D[I)Lorg/valkyrienskies/physics_api/RayCastResult;", "Lorg/valkyrienskies/physics_api/RayCastResultWithVelocity;", "rayTraceWithVel", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;D[I)Lorg/valkyrienskies/physics_api/RayCastResultWithVelocity;", "Lorg/valkyrienskies/physics_api/JointId;", "removeConstraint", "removeJoint", "groundBodyId", "setGroundBodyId", "(Ljava/lang/Integer;)V", "updateConstraint", "updatedJoint", "updateJoint", "(ILorg/valkyrienskies/core/internal/joints/VSJoint;)Z", "Lorg/valkyrienskies/core/api/util/AerodynamicUtils;", "getAerodynamicUtils", "()Lorg/valkyrienskies/core/api/util/AerodynamicUtils;", "aerodynamicUtils", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "dimension", "Ljava/lang/String;", "getDimension", "()Ljava/lang/String;", "Lit/unimi/dsi/fastutil/longs/Long2ObjectMap;", "", "Lorg/valkyrienskies/core/impl/pipelines/DisabledCollisionPair;", "Lorg/valkyrienskies/core/impl/game/ships/types/MutableShipIdMap;", "disabledCollisionMap", "Lit/unimi/dsi/fastutil/longs/Long2ObjectMap;", "getDisabledCollisionMap", "()Lit/unimi/dsi/fastutil/longs/Long2ObjectMap;", "disabledCollisionPairs", "Ljava/util/Set;", "groundShipReferenceId", "I", "getGroundShipReferenceId", "()I", "setGroundShipReferenceId", "(I)V", "", "joints", "Ljava/util/Map;", "Lkotlin/Function1;", "physShipLookup", "Lkotlin/jvm/functions/Function1;", "Lkotlin/Function0;", "Lorg/valkyrienskies/core/impl/game/ships/types/ShipIdMap;", "physShipsSupplier", "Lkotlin/jvm/functions/Function0;", "Lorg/valkyrienskies/core/impl/pipelines/VSPhysicsPipelineStage;", "physicsStage", "Lorg/valkyrienskies/core/impl/pipelines/VSPhysicsPipelineStage;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "removingShips", "Ljava/util/HashSet;", "getRemovingShips", "()Ljava/util/HashSet;", "shipIdToJoints", "Lorg/valkyrienskies/core/impl/game/ships/ShipObjectServerWorld;", "shipObjectServerWorld", "Lorg/valkyrienskies/core/impl/game/ships/ShipObjectServerWorld;", "wrapper", "Lorg/valkyrienskies/physics_api/PhysicsWorldReference;", "getWrapper$impl", "()Lorg/valkyrienskies/physics_api/PhysicsWorldReference;", "<init>", "(Ljava/lang/String;Lorg/valkyrienskies/physics_api/PhysicsWorldReference;Lkotlin/jvm/functions/Function0;Lorg/valkyrienskies/core/impl/pipelines/VSPhysicsPipelineStage;Lorg/valkyrienskies/core/impl/game/ships/ShipObjectServerWorld;Lkotlin/jvm/functions/Function1;)V", "Companion", "impl"})
public final class FQ
implements Ha,
VsiPhysLevel {
    public static final a a = new a(null);
    private final String f;
    public final ha_0 b;
    private final Function0<Long2ObjectMap<? extends PhysShip>> g;
    private final FJ h;
    private final er_0 i;
    private final Function1<Integer, PhysShip> j;
    private final Set<fy_0> k;
    public final Long2ObjectMap<Set<fy_0>> c;
    private final Map<Integer, VSJoint> l;
    private final Map<Long, Set<Integer>> m;
    public final HashSet<Long> d;
    public int e;
    private static final Logger n = FX.a("Pie Factory");

    public FQ(String string, ha_0 ha_02, Function0<? extends Long2ObjectMap<? extends PhysShip>> function0, FJ fJ, er_0 er_02, Function1<? super Integer, ? extends PhysShip> function1) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        Intrinsics.checkNotNullParameter((Object)ha_02, (String)"");
        Intrinsics.checkNotNullParameter(function0, (String)"");
        Intrinsics.checkNotNullParameter((Object)fJ, (String)"");
        Intrinsics.checkNotNullParameter((Object)er_02, (String)"");
        Intrinsics.checkNotNullParameter(function1, (String)"");
        this.f = string;
        this.b = ha_02;
        this.g = function0;
        this.h = fJ;
        this.i = er_02;
        this.j = function1;
        this.k = new HashSet();
        this.c = ER.a(new Pair[0]);
        this.l = new HashMap();
        this.m = new HashMap();
        this.d = new HashSet();
        this.e = -1;
    }

    @Override
    @JvmName(name="getDimension")
    public final String getDimension() {
        return this.f;
    }

    @JvmName(name="a")
    public final ha_0 a() {
        return this.b;
    }

    public final boolean a(HI hI) {
        Intrinsics.checkNotNullParameter((Object)hI, (String)"");
        return this.b.a(hI);
    }

    public final <T extends GS> GY<T> a(T t) {
        Intrinsics.checkNotNullParameter(t, (String)"");
        return this.b.a(t);
    }

    public final void b() {
        this.b.b();
    }

    public final boolean a(int n2) {
        return this.b.a(n2);
    }

    public final void a(int n2, int n3) {
        this.b.a(n2, n3);
    }

    public final void b(int n2, int n3) {
        this.b.b(n2, n3);
    }

    public final List<HS> c() {
        return this.b.c();
    }

    public final List<HI> d() {
        return this.b.d();
    }

    public final List<HI> e() {
        return this.b.e();
    }

    public final List<HI> f() {
        return this.b.f();
    }

    public final boolean g() {
        return this.b.g();
    }

    public final void h() {
        this.b.h();
    }

    public final List<ha_0.b> a(Vector3dc vector3dc, double d2) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        return this.b.a(vector3dc, d2);
    }

    public final hd_0 a(Vector3dc vector3dc, Vector3dc vector3dc2, double d2, int ... nArray) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc2, (String)"");
        Intrinsics.checkNotNullParameter((Object)nArray, (String)"");
        return this.b.a(vector3dc, vector3dc2, d2, nArray);
    }

    public final he_0 b(Vector3dc vector3dc, Vector3dc vector3dc2, double d2, int ... nArray) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc2, (String)"");
        Intrinsics.checkNotNullParameter((Object)nArray, (String)"");
        return this.b.b(vector3dc, vector3dc2, d2, nArray);
    }

    public final boolean b(int n2) {
        return this.b.b(n2);
    }

    public final void a(Integer n2) {
        this.b.a(n2);
    }

    public final boolean b(HI hI) {
        Intrinsics.checkNotNullParameter((Object)hI, (String)"");
        return this.b.b(hI);
    }

    @JvmName(name="i")
    public final Long2ObjectMap<Set<fy_0>> i() {
        return this.c;
    }

    @JvmName(name="j")
    public final HashSet<Long> j() {
        return this.d;
    }

    @JvmName(name="l")
    private int l() {
        return this.e;
    }

    @JvmName(name="c")
    public final void c(int n2) {
        this.e = n2;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void physTick(double delta) {
        void var1_1;
        FJ fJ = this.h;
        ((VSCoreInternal)FV.a(fJ.c, FJ.b[0])).getPhysTickEvent().emit(new PhysTickEventImpl(this, (double)var1_1));
    }

    @Override
    @JvmName(name="getAerodynamicUtils")
    public final AerodynamicUtils getAerodynamicUtils() {
        er_0 er_02 = this.i;
        return er_02.x;
    }

    @Override
    public final Map<Integer, VSJoint> getAllJoints() {
        return this.l;
    }

    @Override
    public final Map<Long, Set<Integer>> getJointsByShipIds() {
        return this.m;
    }

    @Override
    public final Set<PhysShip> getAllPhysShips() {
        FJ fJ = this.h;
        Object object = fJ.f.get(this.getDimension());
        if (object == null || (object = (ObjectCollection)object.values()) == null || (object = CollectionsKt.toSet((Iterable)((Iterable)object))) == null) {
            object = SetsKt.emptySet();
        }
        return object;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final PhysShip getShipById(long shipId) {
        void var1_1;
        FJ fJ = this.h;
        Long2ObjectMap<PhysShipImpl> long2ObjectMap = fJ.f.get(this.getDimension());
        Intrinsics.checkNotNull(long2ObjectMap);
        return (PhysShip)long2ObjectMap.get((long)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final RayCastResult rayCast(Vector3dc start, Vector3dc direction, double length, long ... ignoredShips) {
        void var3_3;
        void var2_2;
        Object object;
        Intrinsics.checkNotNullParameter((Object)start, (String)"");
        Intrinsics.checkNotNullParameter((Object)direction, (String)"");
        Intrinsics.checkNotNullParameter((Object)ignoredShips, (String)"");
        Object object2 = ArraysKt.toList((long[])ignoredShips);
        Collection collection = new ArrayList();
        object2 = object2.iterator();
        while (object2.hasNext()) {
            Object e2 = object2.next();
            Object object3 = e2;
            object3 = e2;
            long l2 = ((Number)e2).longValue();
            Object object4 = (PhysShipImpl)this.getShipById(l2);
            Integer n2 = object4 != null && (object4 = ((PhysShipImpl)object4).getRigidBodyReference$impl()) != null ? Integer.valueOf(object4.a()) : null;
            if (n2 == null) continue;
            object3 = n2;
            collection.add(object3);
        }
        Object object5 = object2 = (Object)CollectionsKt.toIntArray((Collection)((List)collection));
        he_0 he_02 = this.b.b((Vector3dc)object, (Vector3dc)var2_2, (double)var3_3, Arrays.copyOf((int[])object5, ((Object)object5).length));
        if (he_02 == null) {
            return null;
        }
        object2 = he_02;
        object = (PhysShip)this.j.invoke((Object)object2.a());
        if (object == null) {
            if (object2.a() == this.e) {
                FQ fQ = this;
                object = fQ.h;
                Long l3 = ((FJ)object).p.get(this.getDimension());
                Intrinsics.checkNotNull((Object)l3);
                object = fQ.getShipById(((Number)l3).longValue());
            }
            if (object == null) {
                a.a().warn("Raycast hit a body with rigidbody id " + object2.a() + " that does not correspond to any known PhysShip!");
                return null;
            }
        }
        return new RayCastResult((PhysShip)object, object2.b(), object2.c(), object2.d(), object2.e());
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean enableCollisionBetween(long shipId0, long shipId1) {
        block4: {
            void var3_2;
            void var1_1;
            fy_0 fy_02 = new fy_0(shipId0, shipId1);
            if (!this.k.contains(fy_02)) {
                return false;
            }
            Object object = (PhysShipImpl)this.getShipById(shipId0);
            if (object == null || (object = ((PhysShipImpl)object).getRigidBodyReference$impl()) == null) {
                return false;
            }
            int n2 = object.a();
            Object object2 = (PhysShipImpl)this.getShipById(shipId1);
            if (object2 == null || (object2 = ((PhysShipImpl)object2).getRigidBodyReference$impl()) == null) {
                return false;
            }
            int n3 = object2.a();
            this.b.b(n2, n3);
            this.k.remove(fy_02);
            Set set = (Set)this.c.get((long)var1_1);
            if (set != null) {
                set.remove(fy_02);
            }
            Set set2 = (Set)this.c.get((long)var3_2);
            if (set2 == null) break block4;
            set2.remove(fy_02);
        }
        return true;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean disableCollisionBetween(long shipId0, long shipId1) {
        void var3_2;
        void var1_1;
        fy_0 fy_02 = new fy_0(shipId0, shipId1);
        if (this.k.contains(fy_02)) {
            return false;
        }
        Object object = (PhysShipImpl)this.getShipById(shipId0);
        if (object == null || (object = ((PhysShipImpl)object).getRigidBodyReference$impl()) == null) {
            return false;
        }
        int n2 = object.a();
        Object object2 = (PhysShipImpl)this.getShipById(shipId1);
        if (object2 == null || (object2 = ((PhysShipImpl)object2).getRigidBodyReference$impl()) == null) {
            return false;
        }
        int n3 = object2.a();
        this.b.a(n2, n3);
        this.k.add(fy_02);
        ((Set)this.c.computeIfAbsent((long)var1_1, FQ::a)).add(fy_02);
        ((Set)this.c.computeIfAbsent((long)var3_2, FQ::b)).add(fy_02);
        return true;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final VSJoint getJointById(int jointId) {
        void var1_1;
        return this.l.get((int)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final Set<Integer> getJointsFromShip(long shipId) {
        void var1_1;
        Set set = this.m.get((long)var1_1);
        if (set == null) {
            set = SetsKt.emptySet();
        }
        return set;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final int addJoint(VSJoint newJoint) {
        void var1_1;
        FJ fJ;
        block8: {
            block7: {
                block6: {
                    Intrinsics.checkNotNullParameter((Object)newJoint, (String)"");
                    if (newJoint.getShipId0() == null) break block6;
                    Long l2 = newJoint.getShipId0();
                    Intrinsics.checkNotNull((Object)l2);
                    if (this.getShipById(l2) == null) break block7;
                }
                if (newJoint.getShipId1() == null) break block8;
                Long l3 = newJoint.getShipId1();
                Intrinsics.checkNotNull((Object)l3);
                if (this.getShipById(l3) != null) break block8;
            }
            a.a().warn("Attempted to make a joint with ships that don't exist! Has the ship been loaded yet?");
            return -1;
        }
        if (CollectionsKt.contains((Iterable)this.d, (Object)newJoint.getShipId0()) || CollectionsKt.contains((Iterable)this.d, (Object)newJoint.getShipId1())) {
            a.a().warn("Attempted to make a joint with a ship that is being removed! Ship IDs: " + newJoint.getShipId0() + ", " + newJoint.getShipId1());
            return -1;
        }
        if (Intrinsics.areEqual((Object)newJoint.getShipId0(), (Object)newJoint.getShipId1())) {
            a.a().warn("You can't create a joint that connects the same body to itself!");
            return -1;
        }
        Long l4 = newJoint.getShipId0();
        long l5 = l4 != null ? l4 : -1L;
        Long l6 = newJoint.getShipId1();
        long l7 = l6 != null ? l6 : -1L;
        FJ fJ2 = fJ = this.h;
        int n2 = fJ.q;
        int n3 = n2 + 1;
        fJ2 = fJ;
        fJ.q = n3;
        n3 = n2;
        if (!this.b.a(new HI(n3, this.h.a(newJoint, this.getDimension())))) {
            a.a().warn("Failed to create joint with prospective id " + n3 + " between " + l5 + " and " + l7 + "! STAGE: Krunch Bridge");
            return -1;
        }
        Integer n4 = n3;
        this.l.put(n4, (VSJoint)var1_1);
        this.m.computeIfAbsent(l5, arg_0 -> FQ.a(1.a, arg_0)).add(n3);
        this.m.computeIfAbsent(l7, arg_0 -> FQ.b(2.a, arg_0)).add(n3);
        return n3;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean updateJoint(int jointId, VSJoint updatedJoint) {
        block13: {
            block12: {
                block11: {
                    Intrinsics.checkNotNullParameter((Object)updatedJoint, (String)"");
                    if (updatedJoint.getShipId0() == null) break block11;
                    Long l2 = updatedJoint.getShipId0();
                    Intrinsics.checkNotNull((Object)l2);
                    if (this.getShipById(l2) == null) break block12;
                }
                if (updatedJoint.getShipId1() == null) break block13;
                Long l3 = updatedJoint.getShipId1();
                Intrinsics.checkNotNull((Object)l3);
                if (this.getShipById(l3) != null) break block13;
            }
            a.a().warn("Attempted to update a joint with ships that don't exist! Has the ship been loaded yet?");
            return false;
        }
        if (CollectionsKt.contains((Iterable)this.d, (Object)updatedJoint.getShipId0()) || CollectionsKt.contains((Iterable)this.d, (Object)updatedJoint.getShipId1())) {
            a.a().warn("Attempted to update a joint with a ship that is being removed! Ship IDs: " + updatedJoint.getShipId0() + ", " + updatedJoint.getShipId1());
            return false;
        }
        if (Intrinsics.areEqual((Object)updatedJoint.getShipId0(), (Object)updatedJoint.getShipId1())) {
            a.a().warn("You can't update a joint to connect the same body to itself!");
            return false;
        }
        VSJoint vSJoint = this.l.get(jointId);
        if (vSJoint == null) {
            return false;
        }
        Object object = vSJoint;
        Long l4 = updatedJoint.getShipId0();
        long l5 = l4 != null ? l4 : -1L;
        Long l6 = updatedJoint.getShipId1();
        long l7 = l6 != null ? l6 : -1L;
        boolean bl = this.b.b(new HI(jointId, this.h.a(updatedJoint, this.getDimension())));
        if (bl) {
            void var2_2;
            if (!Intrinsics.areEqual((Object)object.getShipId0(), (Object)updatedJoint.getShipId0()) || !Intrinsics.areEqual((Object)object.getShipId1(), (Object)updatedJoint.getShipId1())) {
                Long l8 = object.getShipId0();
                Set<Integer> set = this.m.get(l8 != null ? l8 : -1L);
                if (set != null) {
                    set.remove(jointId);
                }
                Long l9 = object.getShipId1();
                Set<Integer> set2 = this.m.get(l9 != null ? l9 : -1L);
                if (set2 != null) {
                    set2.remove(jointId);
                }
            }
            object = jointId;
            this.l.put((Integer)object, (VSJoint)var2_2);
            this.m.computeIfAbsent(l5, arg_0 -> FQ.c(3.a, arg_0)).add(jointId);
            this.m.computeIfAbsent(l7, arg_0 -> FQ.d(4.a, arg_0)).add(jointId);
        } else {
            void var1_1;
            a.a().warn("Failed to update joint with id " + (int)var1_1 + " between " + l5 + " and " + l7 + "! STAGE: Krunch Bridge");
        }
        return bl;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean removeJoint(int jointId) {
        boolean bl;
        Integer n2 = jointId;
        if (!this.l.containsKey(n2)) {
            a.a().warn("Tried to remove a joint with id " + jointId + " that does not exist!");
            return false;
        }
        VSJoint vSJoint = this.l.remove(jointId);
        if (vSJoint == null) {
            return false;
        }
        VSJoint vSJoint2 = vSJoint;
        Long l2 = vSJoint2.getShipId0();
        Set<Integer> set = this.m.get(l2 != null ? l2 : -1L);
        if (set != null) {
            set.remove(jointId);
        }
        Long l3 = vSJoint2.getShipId1();
        Set<Integer> set2 = this.m.get(l3 != null ? l3 : -1L);
        if (set2 != null) {
            set2.remove(jointId);
        }
        boolean bl2 = bl = this.b.b(jointId);
        if (!bl) {
            void var1_1;
            a.a().warn("Failed to remove joint with id " + (int)var1_1 + " between " + vSJoint2.getShipId0() + " and " + vSJoint2.getShipId1() + "! STAGE: Krunch Bridge");
        }
        return bl;
    }

    private static final Set a(long l2) {
        return new HashSet();
    }

    private static final Set b(long l2) {
        return new HashSet();
    }

    private static final Set a(Function1 function1, Object object) {
        return (Set)function1.invoke(object);
    }

    private static final Set b(Function1 function1, Object object) {
        return (Set)function1.invoke(object);
    }

    private static final Set c(Function1 function1, Object object) {
        return (Set)function1.invoke(object);
    }

    private static final Set d(Function1 function1, Object object) {
        return (Set)function1.invoke(object);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u0005\u001a\u00020\u00028GX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2={"Lorg/valkyrienskies/core/impl/shadow/FQ$a;", "", "Lorg/apache/logging/log4j/Logger;", "n", "Lorg/apache/logging/log4j/Logger;", "a", "()Lorg/apache/logging/log4j/Logger;", "<init>", "()V"})
    public static final class a {
        private static /* synthetic */ KProperty<Object>[] a;

        private a() {
        }

        @JvmName(name="a")
        public final Logger a() {
            KProperty<Object> kProperty = a[0];
            Logger logger = n;
            Intrinsics.checkNotNullParameter(kProperty, (String)"");
            return logger;
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
}

