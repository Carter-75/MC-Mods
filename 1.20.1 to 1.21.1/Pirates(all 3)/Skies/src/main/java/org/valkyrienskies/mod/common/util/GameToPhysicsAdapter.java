/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package org.valkyrienskies.mod.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.PhysShip;
import org.valkyrienskies.core.api.world.PhysLevel;
import org.valkyrienskies.core.internal.joints.VSJoint;
import org.valkyrienskies.core.internal.joints.VSJointAndId;
import org.valkyrienskies.core.internal.world.VsiPhysLevel;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001dB\u0007\u00a2\u0006\u0004\bb\u0010cJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000f\u001a\u00020\u00062\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u00020\u00062\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0016\u001a\u00020\u00062\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0016\u0010\u0010J!\u0010\u0018\u001a\u00020\u00062\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\u0017\u001a\u00020\f\u00a2\u0006\u0004\b\u0018\u0010\u0013J)\u0010\u0019\u001a\u00020\u00062\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f\u00a2\u0006\u0004\b\u0019\u0010\u0010J+\u0010\u001c\u001a\u00020\u00062\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f\u00a2\u0006\u0004\b\u001c\u0010\u0010J!\u0010\u001e\u001a\u00020\u00062\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\u001d\u001a\u00020\f\u00a2\u0006\u0004\b\u001e\u0010\u0013J+\u0010\u001f\u001a\u00020\u00062\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f\u00a2\u0006\u0004\b\u001f\u0010\u0010J#\u0010!\u001a\u00020\u00062\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010 \u001a\u00020\fH\u0007\u00a2\u0006\u0004\b!\u0010\u0013J#\u0010#\u001a\u00020\u00062\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\"\u001a\u00020\fH\u0007\u00a2\u0006\u0004\b#\u0010\u0013J#\u0010$\u001a\u00020\u00062\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010 \u001a\u00020\fH\u0007\u00a2\u0006\u0004\b$\u0010\u0013J#\u0010%\u001a\u00020\u00062\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\"\u001a\u00020\fH\u0007\u00a2\u0006\u0004\b%\u0010\u0013J+\u0010'\u001a\u00020\u00062\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010 \u001a\u00020\f2\u0006\u0010&\u001a\u00020\fH\u0007\u00a2\u0006\u0004\b'\u0010\u0010J+\u0010(\u001a\u00020\u00062\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010 \u001a\u00020\f2\u0006\u0010&\u001a\u00020\fH\u0007\u00a2\u0006\u0004\b(\u0010\u0010J!\u0010+\u001a\u00020\u00062\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010*\u001a\u00020)\u00a2\u0006\u0004\b+\u0010,J1\u00104\u001a\u00020\u00062\u0006\u0010.\u001a\u00020-2\b\b\u0002\u00100\u001a\u00020/2\u0010\u00103\u001a\f\u0012\b\u0012\u00060/j\u0002`201\u00a2\u0006\u0004\b4\u00105J\u0015\u00108\u001a\u00020\u00062\u0006\u00107\u001a\u000206\u00a2\u0006\u0004\b8\u00109J\u0019\u0010;\u001a\u00020\u00062\n\u0010:\u001a\u00060/j\u0002`2\u00a2\u0006\u0004\b;\u0010<J\u001b\u0010=\u001a\u0004\u0018\u00010-2\n\u0010:\u001a\u00060/j\u0002`2\u00a2\u0006\u0004\b=\u0010>J%\u0010A\u001a\u000e\u0012\b\u0012\u00060/j\u0002`2\u0018\u00010@2\n\u0010?\u001a\u00060\tj\u0002`\n\u00a2\u0006\u0004\bA\u0010BJ\u001d\u0010D\u001a\u0012\u0012\b\u0012\u00060/j\u0002`2\u0012\u0004\u0012\u00020-0C\u00a2\u0006\u0004\bD\u0010EJ'\u0010F\u001a\u001c\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u000e\u0012\f\u0012\b\u0012\u00060/j\u0002`20@0C\u00a2\u0006\u0004\bF\u0010EJ%\u0010I\u001a\u00020\u00062\n\u0010G\u001a\u00060\tj\u0002`\n2\n\u0010H\u001a\u00060\tj\u0002`\n\u00a2\u0006\u0004\bI\u0010JJ%\u0010K\u001a\u00020\u00062\n\u0010G\u001a\u00060\tj\u0002`\n2\n\u0010H\u001a\u00060\tj\u0002`\n\u00a2\u0006\u0004\bK\u0010JR*\u0010O\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020N0M0L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR*\u0010Q\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\f0M0L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010PR*\u0010R\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020N0M0L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010PR*\u0010S\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\f0M0L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010PR*\u0010T\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020N0M0L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010PR*\u0010U\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\f0M0L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010PR*\u0010V\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020N0M0L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010PR*\u0010W\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020N0M0L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010PR6\u0010Y\u001a$\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020-\u0012\u000e\u0012\f\u0012\b\u0012\u00060/j\u0002`2010M\u0012\u0004\u0012\u00020/0X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u001a\u0010[\u001a\b\u0012\u0004\u0012\u0002060L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010PR\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00020/0L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010PR&\u0010]\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0@0X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010ZR \u0010^\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020-0X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010ZR*\u0010_\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020)0M0L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010PR.\u0010`\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\tj\u0002`\n\u0012\b\u0012\u00060\tj\u0002`\n0M0L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010PR.\u0010a\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\tj\u0002`\n\u0012\b\u0012\u00060\tj\u0002`\n0M0L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010P\u00a8\u0006e"}, d2={"Lorg/valkyrienskies/mod/common/util/GameToPhysicsAdapter;", "", "Lorg/valkyrienskies/core/api/world/PhysLevel;", "physLevel", "", "delta", "", "physTick", "(Lorg/valkyrienskies/core/api/world/PhysLevel;D)V", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "ship", "Lorg/joml/Vector3dc;", "forceInWorld", "posInWorld", "applyWorldForce", "(JLorg/joml/Vector3dc;Lorg/joml/Vector3dc;)V", "torqueInWorld", "applyWorldTorque", "(JLorg/joml/Vector3dc;)V", "forceInShip", "posInShip", "applyModelForce", "torqueInShip", "applyModelTorque", "applyWorldForceToModelPos", "forceInBody", "posInBody", "applyBodyForce", "torqueInBody", "applyBodyTorque", "applyWorldForceToBodyPos", "force", "applyInvariantForce", "torque", "applyInvariantTorque", "applyRotDependentForce", "applyRotDependentTorque", "pos", "applyInvariantForceToPos", "applyRotDependentForceToPos", "", "b", "setStatic", "(JZ)V", "Lorg/valkyrienskies/core/internal/joints/VSJoint;", "joint", "", "delay", "Ljava/util/function/Consumer;", "Lorg/valkyrienskies/core/internal/joints/VSJointId;", "function", "addJoint", "(Lorg/valkyrienskies/core/internal/joints/VSJoint;ILjava/util/function/Consumer;)V", "Lorg/valkyrienskies/core/internal/joints/VSJointAndId;", "jointAndId", "updateJoint", "(Lorg/valkyrienskies/core/internal/joints/VSJointAndId;)V", "jointId", "removeJoint", "(I)V", "getJointById", "(I)Lorg/valkyrienskies/core/internal/joints/VSJoint;", "shipId", "", "getJointsFromShip", "(J)Ljava/util/Set;", "", "getAllJoints", "()Ljava/util/Map;", "getJointsByShipIds", "shipA", "shipB", "enableCollisionBetween", "(JJ)V", "disableCollisionBetween", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lkotlin/Pair;", "Lorg/valkyrienskies/mod/common/util/GameToPhysicsAdapter$ForceAtPos;", "worldForces", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "worldTorques", "modelForces", "modelTorques", "bodyForces", "bodyTorques", "worldToModelForces", "worldToBodyForces", "Ljava/util/concurrent/ConcurrentHashMap;", "addedJoints", "Ljava/util/concurrent/ConcurrentHashMap;", "updatedJoints", "deletedJoints", "shipToJointIds", "jointById", "toBeStatic", "enablePairs", "disablePairs", "<init>", "()V", "ForceAtPos", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nGameToPhysicsAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GameToPhysicsAdapter.kt\norg/valkyrienskies/mod/common/util/GameToPhysicsAdapter\n+ 2 Util.kt\norg/valkyrienskies/core/util/UtilKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,323:1\n42#2,2:324\n42#2,2:326\n42#2,2:328\n42#2,2:330\n42#2,2:332\n42#2,2:334\n42#2,2:336\n42#2,2:338\n42#2,2:340\n42#2,2:342\n42#2,2:346\n42#2,2:348\n42#2,2:350\n1863#3,2:344\n*S KotlinDebug\n*F\n+ 1 GameToPhysicsAdapter.kt\norg/valkyrienskies/mod/common/util/GameToPhysicsAdapter\n*L\n43#1:324,2\n53#1:326,2\n57#1:328,2\n67#1:330,2\n71#1:332,2\n82#1:334,2\n86#1:336,2\n97#1:338,2\n123#1:340,2\n126#1:342,2\n140#1:346,2\n142#1:348,2\n143#1:350,2\n138#1:344,2\n*E\n"})
public final class GameToPhysicsAdapter {
    @NotNull
    private final ConcurrentLinkedQueue<Pair<Long, ForceAtPos>> worldForces = new ConcurrentLinkedQueue();
    @NotNull
    private final ConcurrentLinkedQueue<Pair<Long, Vector3dc>> worldTorques = new ConcurrentLinkedQueue();
    @NotNull
    private final ConcurrentLinkedQueue<Pair<Long, ForceAtPos>> modelForces = new ConcurrentLinkedQueue();
    @NotNull
    private final ConcurrentLinkedQueue<Pair<Long, Vector3dc>> modelTorques = new ConcurrentLinkedQueue();
    @NotNull
    private final ConcurrentLinkedQueue<Pair<Long, ForceAtPos>> bodyForces = new ConcurrentLinkedQueue();
    @NotNull
    private final ConcurrentLinkedQueue<Pair<Long, Vector3dc>> bodyTorques = new ConcurrentLinkedQueue();
    @NotNull
    private final ConcurrentLinkedQueue<Pair<Long, ForceAtPos>> worldToModelForces = new ConcurrentLinkedQueue();
    @NotNull
    private final ConcurrentLinkedQueue<Pair<Long, ForceAtPos>> worldToBodyForces = new ConcurrentLinkedQueue();
    @NotNull
    private final ConcurrentHashMap<Pair<VSJoint, Consumer<Integer>>, Integer> addedJoints = new ConcurrentHashMap();
    @NotNull
    private final ConcurrentLinkedQueue<VSJointAndId> updatedJoints = new ConcurrentLinkedQueue();
    @NotNull
    private final ConcurrentLinkedQueue<Integer> deletedJoints = new ConcurrentLinkedQueue();
    @NotNull
    private final ConcurrentHashMap<Long, Set<Integer>> shipToJointIds = new ConcurrentHashMap();
    @NotNull
    private final ConcurrentHashMap<Integer, VSJoint> jointById = new ConcurrentHashMap();
    @NotNull
    private final ConcurrentLinkedQueue<Pair<Long, Boolean>> toBeStatic = new ConcurrentLinkedQueue();
    @NotNull
    private final ConcurrentLinkedQueue<Pair<Long, Long>> enablePairs = new ConcurrentLinkedQueue();
    @NotNull
    private final ConcurrentLinkedQueue<Pair<Long, Long>> disablePairs = new ConcurrentLinkedQueue();

    public final void physTick(@NotNull PhysLevel physLevel, double delta) {
        Pair pair;
        PhysShip ship;
        Pair pair2;
        Intrinsics.checkNotNullParameter((Object)physLevel, (String)"physLevel");
        Queue $this$pollUntilEmpty$iv = this.worldForces;
        boolean $i$f$pollUntilEmpty = false;
        while (true) {
            Object e2 = $this$pollUntilEmpty$iv.poll();
            if (e2 == null) break;
            pair2 = (Pair)e2;
            boolean bl = false;
            ship = physLevel.getShipById(((Number)pair2.getFirst()).longValue());
            if (((ForceAtPos)pair2.getSecond()).getPos() != null) {
                PhysShip physShip = ship;
                if (physShip != null) {
                    Vector3dc vector3dc = ((ForceAtPos)pair2.getSecond()).getForce();
                    Vector3dc vector3dc2 = ((ForceAtPos)pair2.getSecond()).getPos();
                    Intrinsics.checkNotNull((Object)vector3dc2);
                    physShip.applyWorldForce(vector3dc, vector3dc2);
                }
                continue;
            }
            PhysShip physShip = ship;
            if (physShip != null) {
                PhysShip.applyWorldForce$default(physShip, ((ForceAtPos)pair2.getSecond()).getForce(), null, 2, null);
            }
        }
        $this$pollUntilEmpty$iv = this.worldTorques;
        $i$f$pollUntilEmpty = false;
        while (true) {
            Object e3 = $this$pollUntilEmpty$iv.poll();
            if (e3 == null) break;
            pair2 = (Pair)e3;
            boolean bl = false;
            ship = physLevel.getShipById(((Number)pair2.getFirst()).longValue());
            if (ship == null) continue;
            ship.applyWorldTorque((Vector3dc)pair2.getSecond());
        }
        $this$pollUntilEmpty$iv = this.modelForces;
        $i$f$pollUntilEmpty = false;
        while (true) {
            Object e4 = $this$pollUntilEmpty$iv.poll();
            if (e4 == null) break;
            pair2 = (Pair)e4;
            boolean bl = false;
            ship = physLevel.getShipById(((Number)pair2.getFirst()).longValue());
            if (((ForceAtPos)pair2.getSecond()).getPos() != null) {
                PhysShip physShip = ship;
                if (physShip != null) {
                    Vector3dc vector3dc = ((ForceAtPos)pair2.getSecond()).getForce();
                    Vector3dc vector3dc3 = ((ForceAtPos)pair2.getSecond()).getPos();
                    Intrinsics.checkNotNull((Object)vector3dc3);
                    physShip.applyModelForce(vector3dc, vector3dc3);
                }
                continue;
            }
            PhysShip physShip = ship;
            if (physShip != null) {
                PhysShip.applyModelForce$default(physShip, ((ForceAtPos)pair2.getSecond()).getForce(), null, 2, null);
            }
        }
        $this$pollUntilEmpty$iv = this.modelTorques;
        $i$f$pollUntilEmpty = false;
        while (true) {
            Object e5 = $this$pollUntilEmpty$iv.poll();
            if (e5 == null) break;
            pair2 = (Pair)e5;
            boolean bl = false;
            ship = physLevel.getShipById(((Number)pair2.getFirst()).longValue());
            if (ship == null) continue;
            ship.applyModelTorque((Vector3dc)pair2.getSecond());
        }
        $this$pollUntilEmpty$iv = this.bodyForces;
        $i$f$pollUntilEmpty = false;
        while (true) {
            Object e6 = $this$pollUntilEmpty$iv.poll();
            if (e6 == null) break;
            pair2 = (Pair)e6;
            boolean bl = false;
            ship = physLevel.getShipById(((Number)pair2.getFirst()).longValue());
            if (((ForceAtPos)pair2.getSecond()).getPos() != null) {
                PhysShip physShip = ship;
                if (physShip != null) {
                    Vector3dc vector3dc = ((ForceAtPos)pair2.getSecond()).getForce();
                    Vector3dc vector3dc4 = ((ForceAtPos)pair2.getSecond()).getPos();
                    Intrinsics.checkNotNull((Object)vector3dc4);
                    physShip.applyBodyForce(vector3dc, vector3dc4);
                }
                continue;
            }
            PhysShip physShip = ship;
            if (physShip != null) {
                PhysShip.applyBodyForce$default(physShip, ((ForceAtPos)pair2.getSecond()).getForce(), null, 2, null);
            }
        }
        $this$pollUntilEmpty$iv = this.bodyTorques;
        $i$f$pollUntilEmpty = false;
        while (true) {
            Object e7 = $this$pollUntilEmpty$iv.poll();
            if (e7 == null) break;
            pair2 = (Pair)e7;
            boolean bl = false;
            ship = physLevel.getShipById(((Number)pair2.getFirst()).longValue());
            if (ship == null) continue;
            ship.applyBodyTorque((Vector3dc)pair2.getSecond());
        }
        $this$pollUntilEmpty$iv = this.worldToModelForces;
        $i$f$pollUntilEmpty = false;
        while (true) {
            Object e8 = $this$pollUntilEmpty$iv.poll();
            if (e8 == null) break;
            pair2 = (Pair)e8;
            boolean bl = false;
            ship = physLevel.getShipById(((Number)pair2.getFirst()).longValue());
            if (((ForceAtPos)pair2.getSecond()).getPos() != null) {
                PhysShip physShip = ship;
                if (physShip != null) {
                    Vector3dc vector3dc = ((ForceAtPos)pair2.getSecond()).getForce();
                    Vector3dc vector3dc5 = ((ForceAtPos)pair2.getSecond()).getPos();
                    Intrinsics.checkNotNull((Object)vector3dc5);
                    physShip.applyWorldForceToModelPos(vector3dc, vector3dc5);
                }
                continue;
            }
            PhysShip physShip = ship;
            if (physShip != null) {
                PhysShip.applyWorldForceToModelPos$default(physShip, ((ForceAtPos)pair2.getSecond()).getForce(), null, 2, null);
            }
        }
        $this$pollUntilEmpty$iv = this.worldToBodyForces;
        $i$f$pollUntilEmpty = false;
        while (true) {
            Object e9 = $this$pollUntilEmpty$iv.poll();
            if (e9 == null) break;
            pair2 = (Pair)e9;
            boolean bl = false;
            ship = physLevel.getShipById(((Number)pair2.getFirst()).longValue());
            if (((ForceAtPos)pair2.getSecond()).getPos() != null) {
                PhysShip physShip = ship;
                if (physShip != null) {
                    Vector3dc vector3dc = ((ForceAtPos)pair2.getSecond()).getForce();
                    Vector3dc vector3dc6 = ((ForceAtPos)pair2.getSecond()).getPos();
                    Intrinsics.checkNotNull((Object)vector3dc6);
                    physShip.applyWorldForceToBodyPos(vector3dc, vector3dc6);
                }
                continue;
            }
            PhysShip physShip = ship;
            if (physShip != null) {
                PhysShip.applyWorldForceToBodyPos$default(physShip, ((ForceAtPos)pair2.getSecond()).getForce(), null, 2, null);
            }
        }
        ArrayList callbackQueue = new ArrayList();
        HashMap<Object, Object> safeJoints = new HashMap<Object, Object>((Map)this.addedJoints);
        safeJoints.forEach((arg_0, arg_1) -> GameToPhysicsAdapter.physTick$lambda$9((arg_0, arg_1) -> GameToPhysicsAdapter.physTick$lambda$8(this, callbackQueue, physLevel, arg_0, arg_1), arg_0, arg_1));
        Queue $this$pollUntilEmpty$iv2 = this.updatedJoints;
        boolean $i$f$pollUntilEmpty2 = false;
        while (true) {
            Object e10 = $this$pollUntilEmpty$iv2.poll();
            if (e10 == null) break;
            VSJointAndId jointAndId = (VSJointAndId)e10;
            boolean bl = false;
            ((VsiPhysLevel)physLevel).updateJoint(jointAndId.getJointId(), jointAndId.getJoint());
        }
        $this$pollUntilEmpty$iv2 = this.deletedJoints;
        $i$f$pollUntilEmpty2 = false;
        while (true) {
            Object e11 = $this$pollUntilEmpty$iv2.poll();
            if (e11 == null) break;
            Integer jointId = (Integer)e11;
            boolean bl = false;
            VsiPhysLevel vsiPhysLevel = (VsiPhysLevel)physLevel;
            Intrinsics.checkNotNull((Object)jointId);
            vsiPhysLevel.removeJoint(jointId);
        }
        this.shipToJointIds.clear();
        this.jointById.clear();
        this.shipToJointIds.putAll(((VsiPhysLevel)physLevel).getJointsByShipIds());
        this.jointById.putAll(((VsiPhysLevel)physLevel).getAllJoints());
        Iterable $this$forEach$iv = callbackQueue;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Pair pair3 = (Pair)element$iv;
            boolean bl = false;
            Consumer consumer = (Consumer)pair3.component1();
            int i2 = ((Number)pair3.component2()).intValue();
            consumer.accept(i2);
        }
        $this$pollUntilEmpty$iv2 = this.toBeStatic;
        $i$f$pollUntilEmpty2 = false;
        while (true) {
            Object e12 = $this$pollUntilEmpty$iv2.poll();
            if (e12 == null) break;
            pair = (Pair)e12;
            boolean bl = false;
            PhysShip physShip = physLevel.getShipById(((Number)pair.getFirst()).longValue());
            if (physShip == null) continue;
            physShip.setStatic((Boolean)pair.getSecond());
        }
        $this$pollUntilEmpty$iv2 = this.enablePairs;
        $i$f$pollUntilEmpty2 = false;
        while (true) {
            Object e13 = $this$pollUntilEmpty$iv2.poll();
            if (e13 == null) break;
            pair = (Pair)e13;
            boolean bl = false;
            physLevel.enableCollisionBetween(((Number)pair.getFirst()).longValue(), ((Number)pair.getSecond()).longValue());
        }
        $this$pollUntilEmpty$iv2 = this.disablePairs;
        $i$f$pollUntilEmpty2 = false;
        while (true) {
            Object e14 = $this$pollUntilEmpty$iv2.poll();
            if (e14 == null) break;
            pair = (Pair)e14;
            boolean bl = false;
            physLevel.disableCollisionBetween(((Number)pair.getFirst()).longValue(), ((Number)pair.getSecond()).longValue());
        }
    }

    public final void applyWorldForce(long ship, @NotNull Vector3dc forceInWorld, @Nullable Vector3dc posInWorld) {
        Intrinsics.checkNotNullParameter((Object)forceInWorld, (String)"forceInWorld");
        this.worldForces.add((Pair<Long, ForceAtPos>)TuplesKt.to((Object)ship, (Object)new ForceAtPos(forceInWorld, posInWorld)));
    }

    public final void applyWorldTorque(long ship, @NotNull Vector3dc torqueInWorld) {
        Intrinsics.checkNotNullParameter((Object)torqueInWorld, (String)"torqueInWorld");
        this.worldTorques.add((Pair<Long, Vector3dc>)TuplesKt.to((Object)ship, (Object)torqueInWorld));
    }

    public final void applyModelForce(long ship, @NotNull Vector3dc forceInShip, @Nullable Vector3dc posInShip) {
        Intrinsics.checkNotNullParameter((Object)forceInShip, (String)"forceInShip");
        this.modelForces.add((Pair<Long, ForceAtPos>)TuplesKt.to((Object)ship, (Object)new ForceAtPos(forceInShip, posInShip)));
    }

    public final void applyModelTorque(long ship, @NotNull Vector3dc torqueInShip) {
        Intrinsics.checkNotNullParameter((Object)torqueInShip, (String)"torqueInShip");
        this.modelTorques.add((Pair<Long, Vector3dc>)TuplesKt.to((Object)ship, (Object)torqueInShip));
    }

    public final void applyWorldForceToModelPos(long ship, @NotNull Vector3dc forceInWorld, @NotNull Vector3dc posInShip) {
        Intrinsics.checkNotNullParameter((Object)forceInWorld, (String)"forceInWorld");
        Intrinsics.checkNotNullParameter((Object)posInShip, (String)"posInShip");
        this.worldToModelForces.add((Pair<Long, ForceAtPos>)TuplesKt.to((Object)ship, (Object)new ForceAtPos(forceInWorld, posInShip)));
    }

    public final void applyBodyForce(long ship, @NotNull Vector3dc forceInBody, @NotNull Vector3dc posInBody) {
        Intrinsics.checkNotNullParameter((Object)forceInBody, (String)"forceInBody");
        Intrinsics.checkNotNullParameter((Object)posInBody, (String)"posInBody");
        this.bodyForces.add((Pair<Long, ForceAtPos>)TuplesKt.to((Object)ship, (Object)new ForceAtPos(forceInBody, posInBody)));
    }

    public static /* synthetic */ void applyBodyForce$default(GameToPhysicsAdapter gameToPhysicsAdapter, long l2, Vector3dc vector3dc, Vector3dc vector3dc2, int n2, Object object) {
        if ((n2 & 4) != 0) {
            vector3dc2 = new Vector3d();
        }
        gameToPhysicsAdapter.applyBodyForce(l2, vector3dc, vector3dc2);
    }

    public final void applyBodyTorque(long ship, @NotNull Vector3dc torqueInBody) {
        Intrinsics.checkNotNullParameter((Object)torqueInBody, (String)"torqueInBody");
        this.bodyTorques.add((Pair<Long, Vector3dc>)TuplesKt.to((Object)ship, (Object)torqueInBody));
    }

    public final void applyWorldForceToBodyPos(long ship, @NotNull Vector3dc forceInWorld, @NotNull Vector3dc posInBody) {
        Intrinsics.checkNotNullParameter((Object)forceInWorld, (String)"forceInWorld");
        Intrinsics.checkNotNullParameter((Object)posInBody, (String)"posInBody");
        this.worldToBodyForces.add((Pair<Long, ForceAtPos>)TuplesKt.to((Object)ship, (Object)new ForceAtPos(forceInWorld, posInBody)));
    }

    public static /* synthetic */ void applyWorldForceToBodyPos$default(GameToPhysicsAdapter gameToPhysicsAdapter, long l2, Vector3dc vector3dc, Vector3dc vector3dc2, int n2, Object object) {
        if ((n2 & 4) != 0) {
            vector3dc2 = new Vector3d();
        }
        gameToPhysicsAdapter.applyWorldForceToBodyPos(l2, vector3dc, vector3dc2);
    }

    @Deprecated(message="Use applyWorldForceToBodyPos instead")
    public final void applyInvariantForce(long ship, @NotNull Vector3dc force) {
        Intrinsics.checkNotNullParameter((Object)force, (String)"force");
        GameToPhysicsAdapter.applyWorldForceToBodyPos$default(this, ship, force, null, 4, null);
    }

    @Deprecated(message="Use applyWorldTorque instead")
    public final void applyInvariantTorque(long ship, @NotNull Vector3dc torque) {
        Intrinsics.checkNotNullParameter((Object)torque, (String)"torque");
        this.applyWorldTorque(ship, torque);
    }

    @Deprecated(message="Use applyBodyForce instead")
    public final void applyRotDependentForce(long ship, @NotNull Vector3dc force) {
        Intrinsics.checkNotNullParameter((Object)force, (String)"force");
        GameToPhysicsAdapter.applyBodyForce$default(this, ship, force, null, 4, null);
    }

    @Deprecated(message="Use applyBodyTorque instead")
    public final void applyRotDependentTorque(long ship, @NotNull Vector3dc torque) {
        Intrinsics.checkNotNullParameter((Object)torque, (String)"torque");
        this.applyBodyTorque(ship, torque);
    }

    @Deprecated(message="Use applyWorldForceToBodyPos instead")
    public final void applyInvariantForceToPos(long ship, @NotNull Vector3dc force, @NotNull Vector3dc pos) {
        Intrinsics.checkNotNullParameter((Object)force, (String)"force");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        this.applyWorldForceToBodyPos(ship, force, pos);
    }

    @Deprecated(message="Use applyBodyForce instead")
    public final void applyRotDependentForceToPos(long ship, @NotNull Vector3dc force, @NotNull Vector3dc pos) {
        Intrinsics.checkNotNullParameter((Object)force, (String)"force");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        this.applyBodyForce(ship, force, pos);
    }

    public final void setStatic(long ship, boolean b2) {
        this.toBeStatic.add((Pair<Long, Boolean>)TuplesKt.to((Object)ship, (Object)b2));
    }

    public final void addJoint(@NotNull VSJoint joint, int delay, @NotNull Consumer<Integer> function) {
        Intrinsics.checkNotNullParameter((Object)joint, (String)"joint");
        Intrinsics.checkNotNullParameter(function, (String)"function");
        this.addedJoints.put((Pair<VSJoint, Consumer<Integer>>)TuplesKt.to((Object)joint, function), delay);
    }

    public static /* synthetic */ void addJoint$default(GameToPhysicsAdapter gameToPhysicsAdapter, VSJoint vSJoint, int n2, Consumer consumer, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n2 = 0;
        }
        gameToPhysicsAdapter.addJoint(vSJoint, n2, consumer);
    }

    public final void updateJoint(@NotNull VSJointAndId jointAndId) {
        Intrinsics.checkNotNullParameter((Object)jointAndId, (String)"jointAndId");
        this.updatedJoints.add(jointAndId);
    }

    public final void removeJoint(int jointId) {
        this.deletedJoints.add(jointId);
    }

    @Nullable
    public final VSJoint getJointById(int jointId) {
        return this.jointById.get(jointId);
    }

    @Nullable
    public final Set<Integer> getJointsFromShip(long shipId) {
        return this.shipToJointIds.get(shipId);
    }

    @NotNull
    public final Map<Integer, VSJoint> getAllJoints() {
        return MapsKt.toMap((Map)this.jointById);
    }

    @NotNull
    public final Map<Long, Set<Integer>> getJointsByShipIds() {
        return MapsKt.toMap((Map)this.shipToJointIds);
    }

    public final void enableCollisionBetween(long shipA, long shipB) {
        this.enablePairs.add((Pair<Long, Long>)TuplesKt.to((Object)shipA, (Object)shipB));
    }

    public final void disableCollisionBetween(long shipA, long shipB) {
        this.disablePairs.add((Pair<Long, Long>)TuplesKt.to((Object)shipA, (Object)shipB));
    }

    private static final Unit physTick$lambda$8(GameToPhysicsAdapter this$0, ArrayList $callbackQueue, PhysLevel $physLevel, Pair newJoint, Integer timer) {
        Intrinsics.checkNotNullParameter((Object)this$0, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)$callbackQueue, (String)"$callbackQueue");
        Intrinsics.checkNotNullParameter((Object)$physLevel, (String)"$physLevel");
        if (timer > 0) {
            ((Map)this$0.addedJoints).put(newJoint, timer - 1);
        } else {
            $callbackQueue.add(new Pair(newJoint.getSecond(), (Object)((VsiPhysLevel)$physLevel).addJoint((VSJoint)newJoint.getFirst())));
            this$0.addedJoints.remove(newJoint);
        }
        return Unit.INSTANCE;
    }

    private static final void physTick$lambda$9(Function2 $tmp0, Object p0, Object p1) {
        Intrinsics.checkNotNullParameter((Object)$tmp0, (String)"$tmp0");
        $tmp0.invoke(p0, p1);
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J&\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004\u00a8\u0006\u0019"}, d2={"Lorg/valkyrienskies/mod/common/util/GameToPhysicsAdapter$ForceAtPos;", "", "Lorg/joml/Vector3dc;", "component1", "()Lorg/joml/Vector3dc;", "component2", "force", "pos", "copy", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/mod/common/util/GameToPhysicsAdapter$ForceAtPos;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/joml/Vector3dc;", "getForce", "getPos", "<init>", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)V", "valkyrienskies-120"})
    private static final class ForceAtPos {
        @NotNull
        private final Vector3dc force;
        @Nullable
        private final Vector3dc pos;

        public ForceAtPos(@NotNull Vector3dc force, @Nullable Vector3dc pos) {
            Intrinsics.checkNotNullParameter((Object)force, (String)"force");
            this.force = force;
            this.pos = pos;
        }

        @NotNull
        public final Vector3dc getForce() {
            return this.force;
        }

        @Nullable
        public final Vector3dc getPos() {
            return this.pos;
        }

        @NotNull
        public final Vector3dc component1() {
            return this.force;
        }

        @Nullable
        public final Vector3dc component2() {
            return this.pos;
        }

        @NotNull
        public final ForceAtPos copy(@NotNull Vector3dc force, @Nullable Vector3dc pos) {
            Intrinsics.checkNotNullParameter((Object)force, (String)"force");
            return new ForceAtPos(force, pos);
        }

        public static /* synthetic */ ForceAtPos copy$default(ForceAtPos forceAtPos, Vector3dc vector3dc, Vector3dc vector3dc2, int n2, Object object) {
            if ((n2 & 1) != 0) {
                vector3dc = forceAtPos.force;
            }
            if ((n2 & 2) != 0) {
                vector3dc2 = forceAtPos.pos;
            }
            return forceAtPos.copy(vector3dc, vector3dc2);
        }

        @NotNull
        public String toString() {
            return "ForceAtPos(force=" + this.force + ", pos=" + this.pos + ")";
        }

        public int hashCode() {
            int result2 = this.force.hashCode();
            result2 = result2 * 31 + (this.pos == null ? 0 : this.pos.hashCode());
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ForceAtPos)) {
                return false;
            }
            ForceAtPos forceAtPos = (ForceAtPos)other;
            if (!Intrinsics.areEqual((Object)this.force, (Object)forceAtPos.force)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.pos, (Object)forceAtPos.pos);
        }
    }
}

