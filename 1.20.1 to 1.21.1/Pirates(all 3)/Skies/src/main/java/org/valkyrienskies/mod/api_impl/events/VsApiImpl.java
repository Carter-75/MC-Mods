/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1297
 *  net.minecraft.class_1923
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_310
 *  net.minecraft.class_3218
 *  net.minecraft.class_638
 *  net.minecraft.server.MinecraftServer
 */
package org.valkyrienskies.mod.api_impl.events;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1297;
import net.minecraft.class_1923;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_310;
import net.minecraft.class_3218;
import net.minecraft.class_638;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaterniondc;
import org.joml.Vector3dc;
import org.joml.primitives.AABBd;
import org.joml.primitives.AABBdc;
import org.valkyrienskies.core.api.VsBeta;
import org.valkyrienskies.core.api.VsCoreApi;
import org.valkyrienskies.core.api.attachment.AttachmentRegistration;
import org.valkyrienskies.core.api.bodies.properties.BodyKinematics;
import org.valkyrienskies.core.api.bodies.properties.BodyTransform;
import org.valkyrienskies.core.api.event.ListenableEvent;
import org.valkyrienskies.core.api.events.CollisionEvent;
import org.valkyrienskies.core.api.events.MergeEvent;
import org.valkyrienskies.core.api.events.PhysTickEvent;
import org.valkyrienskies.core.api.events.ShipLoadEvent;
import org.valkyrienskies.core.api.events.ShipLoadEventClient;
import org.valkyrienskies.core.api.events.ShipUnloadEventClient;
import org.valkyrienskies.core.api.events.SplitEvent;
import org.valkyrienskies.core.api.events.StartUpdateRenderTransformsEvent;
import org.valkyrienskies.core.api.events.TickEndEvent;
import org.valkyrienskies.core.api.ships.LoadedShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.api.world.ClientShipWorld;
import org.valkyrienskies.core.api.world.ServerShipWorld;
import org.valkyrienskies.core.api.world.ShipWorld;
import org.valkyrienskies.core.util.events.EventEmitterImpl;
import org.valkyrienskies.mod.api.VsApi;
import org.valkyrienskies.mod.api.events.PostRenderShipEvent;
import org.valkyrienskies.mod.api.events.PreRenderShipEvent;
import org.valkyrienskies.mod.api.events.RegisterBlockStateEvent;
import org.valkyrienskies.mod.common.IShipObjectWorldClientProvider;
import org.valkyrienskies.mod.common.IShipObjectWorldServerProvider;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;
import org.valkyrienskies.mod.common.entity.ShipMountedToData;
import org.valkyrienskies.mod.common.entity.ShipMountingEntity;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u00cc\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\u0006\u0010e\u001a\u00020\u0002\u00a2\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u0013H\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0015J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u001bJ\u0011\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b \u0010!J)\u0010%\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0016\u00a2\u0006\u0004\b%\u0010&J\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016\u00a2\u0006\u0004\b\u001d\u0010)J%\u0010,\u001a\u0004\u0018\u00010\r2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016\u00a2\u0006\u0004\b,\u0010-J%\u0010/\u001a\u0004\u0018\u00010\r2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010+\u001a\u0004\u0018\u00010.H\u0016\u00a2\u0006\u0004\b/\u00100J+\u0010/\u001a\u0004\u0018\u00010\r2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0016\u00a2\u0006\u0004\b/\u00101J)\u00105\u001a\b\u0012\u0004\u0012\u00020\r042\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u00103\u001a\u0004\u0018\u000102H\u0016\u00a2\u0006\u0004\b5\u00106J7\u00105\u001a\b\u0012\u0004\u0012\u00020\r042\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u0002072\u0006\u0010:\u001a\u000207H\u0016\u00a2\u0006\u0004\b5\u0010;J0\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00000@\"\n\b\u0000\u0010=*\u0004\u0018\u00010<2\f\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000>H\u0097\u0001\u00a2\u0006\u0004\bA\u0010BJ(\u0010H\u001a\u00020G2\u0006\u0010C\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\u00102\u0006\u0010F\u001a\u00020EH\u0097\u0001\u00a2\u0006\u0004\bH\u0010IJ@\u0010H\u001a\u00020G2\u0006\u0010C\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\u00102\u0006\u0010J\u001a\u00020\u00102\u0006\u0010L\u001a\u00020K2\u0006\u0010M\u001a\u00020\u00102\u0006\u0010N\u001a\u00020\u0010H\u0097\u0001\u00a2\u0006\u0004\bH\u0010OJ\u0010\u0010Q\u001a\u00020PH\u0097\u0001\u00a2\u0006\u0004\bQ\u0010RJ0\u0010S\u001a\u00020E2\u0006\u0010J\u001a\u00020\u00102\u0006\u0010L\u001a\u00020K2\u0006\u0010M\u001a\u00020\u00102\u0006\u0010N\u001a\u00020\u0010H\u0096\u0001\u00a2\u0006\u0004\bS\u0010TJ\u0010\u0010V\u001a\u00020UH\u0097\u0001\u00a2\u0006\u0004\bV\u0010WJ*\u0010Y\u001a\u00020X\"\n\b\u0000\u0010=*\u0004\u0018\u00010<2\f\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000>H\u0097\u0001\u00a2\u0006\u0004\bY\u0010ZJ*\u0010Y\u001a\u00020X\"\n\b\u0000\u0010=*\u0004\u0018\u00010<2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000[H\u0097\u0001\u00a2\u0006\u0004\bY\u0010]JI\u0010Y\u001a\u00020X\"\n\b\u0000\u0010=*\u0004\u0018\u00010<2\f\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000>2\u001d\u0010`\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000@\u0012\u0004\u0012\u00020X0^\u00a2\u0006\u0002\b_H\u0097\u0001\u00a2\u0006\u0004\bY\u0010aJ\u0018\u0010c\u001a\u00020X2\u0006\u0010b\u001a\u00020\nH\u0097\u0001\u00a2\u0006\u0004\bc\u0010dR\u0014\u0010e\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\be\u0010fR \u0010i\u001a\b\u0012\u0004\u0012\u00020h0g8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010lR \u0010n\u001a\b\u0012\u0004\u0012\u00020m0g8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bn\u0010j\u001a\u0004\bo\u0010lR \u0010q\u001a\b\u0012\u0004\u0012\u00020p0g8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bq\u0010j\u001a\u0004\br\u0010lR\u0011\u0010u\u001a\b\u0012\u0004\u0012\u00020t0s8\u0016X\u0097\u0005R\u0011\u0010v\u001a\b\u0012\u0004\u0012\u00020t0s8\u0016X\u0097\u0005R\u0011\u0010w\u001a\b\u0012\u0004\u0012\u00020t0s8\u0016X\u0097\u0005R\u0011\u0010y\u001a\b\u0012\u0004\u0012\u00020x0s8\u0016X\u0097\u0005R\u0011\u0010{\u001a\b\u0012\u0004\u0012\u00020z0s8\u0016X\u0097\u0005R\u0011\u0010}\u001a\b\u0012\u0004\u0012\u00020|0s8\u0016X\u0097\u0005R\u0011\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020~0s8\u0016X\u0097\u0005R\u0013\u0010\u0081\u0001\u001a\t\u0012\u0005\u0012\u00030\u0080\u00010s8\u0016X\u0097\u0005R\u0013\u0010\u0083\u0001\u001a\t\u0012\u0005\u0012\u00030\u0082\u00010s8\u0016X\u0097\u0005R\u0013\u0010\u0085\u0001\u001a\t\u0012\u0005\u0012\u00030\u0084\u00010s8\u0016X\u0097\u0005R\u0013\u0010\u0087\u0001\u001a\t\u0012\u0005\u0012\u00030\u0086\u00010s8\u0016X\u0097\u0005R\r\u0010\u0089\u0001\u001a\u00030\u0088\u00018\u0016X\u0097\u0005\u00a8\u0006\u008c\u0001"}, d2={"Lorg/valkyrienskies/mod/api_impl/events/VsApiImpl;", "Lorg/valkyrienskies/mod/api/VsApi;", "Lorg/valkyrienskies/core/api/VsCoreApi;", "Lnet/minecraft/class_1297;", "entity", "", "isShipMountingEntity", "(Lnet/minecraft/class_1297;)Z", "Lnet/minecraft/class_1937;", "level", "", "getDimensionId", "(Lnet/minecraft/class_1937;)Ljava/lang/String;", "Lorg/valkyrienskies/core/api/ships/Ship;", "getShipMountedTo", "(Lnet/minecraft/class_1297;)Lorg/valkyrienskies/core/api/ships/Ship;", "Lorg/joml/Vector3dc;", "getMountPosInShip", "(Lnet/minecraft/class_1297;)Lorg/joml/Vector3dc;", "", "partialTicks", "(Lnet/minecraft/class_1297;F)Lorg/joml/Vector3dc;", "Lorg/valkyrienskies/core/api/world/ServerShipWorld;", "getServerShipWorld", "()Lorg/valkyrienskies/core/api/world/ServerShipWorld;", "Lnet/minecraft/server/MinecraftServer;", "server", "(Lnet/minecraft/server/MinecraftServer;)Lorg/valkyrienskies/core/api/world/ServerShipWorld;", "Lorg/valkyrienskies/core/api/world/ClientShipWorld;", "getClientShipWorld", "()Lorg/valkyrienskies/core/api/world/ClientShipWorld;", "Lorg/valkyrienskies/core/api/world/ShipWorld;", "getShipWorld", "(Lnet/minecraft/class_1937;)Lorg/valkyrienskies/core/api/world/ShipWorld;", "", "chunkX", "chunkZ", "isChunkInShipyard", "(Lnet/minecraft/class_1937;II)Z", "Lnet/minecraft/class_310;", "client", "(Lnet/minecraft/class_310;)Lorg/valkyrienskies/core/api/world/ClientShipWorld;", "Lnet/minecraft/class_2338;", "pos", "getShipManagingBlock", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;)Lorg/valkyrienskies/core/api/ships/Ship;", "Lnet/minecraft/class_1923;", "getShipManagingChunk", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_1923;)Lorg/valkyrienskies/core/api/ships/Ship;", "(Lnet/minecraft/class_1937;II)Lorg/valkyrienskies/core/api/ships/Ship;", "Lorg/joml/primitives/AABBdc;", "aabb", "", "getShipsIntersecting", "(Lnet/minecraft/class_1937;Lorg/joml/primitives/AABBdc;)Ljava/lang/Iterable;", "", "x", "y", "z", "(Lnet/minecraft/class_1937;DDD)Ljava/lang/Iterable;", "", "T", "Ljava/lang/Class;", "attachmentClass", "Lorg/valkyrienskies/core/api/attachment/AttachmentRegistration$Builder;", "newAttachmentRegistrationBuilder", "(Ljava/lang/Class;)Lorg/valkyrienskies/core/api/attachment/AttachmentRegistration$Builder;", "velocity", "angularVelocity", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "transform", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "newBodyKinematics", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;)Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "position", "Lorg/joml/Quaterniondc;", "rotation", "scaling", "positionInModel", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics$Builder;", "newBodyKinematicsBuilder", "()Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics$Builder;", "newBodyTransform", "(Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Builder;", "newBodyTransformBuilder", "()Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Builder;", "", "registerAttachment", "(Ljava/lang/Class;)V", "Lorg/valkyrienskies/core/api/attachment/AttachmentRegistration;", "registration", "(Lorg/valkyrienskies/core/api/attachment/AttachmentRegistration;)V", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "registrationBuilder", "(Ljava/lang/Class;Lkotlin/jvm/functions/Function1;)V", "attachmentKey", "registerAttachmentForRemoval", "(Ljava/lang/String;)V", "core", "Lorg/valkyrienskies/core/api/VsCoreApi;", "Lorg/valkyrienskies/core/util/events/EventEmitterImpl;", "Lorg/valkyrienskies/mod/api/events/RegisterBlockStateEvent;", "registerBlockStateEvent", "Lorg/valkyrienskies/core/util/events/EventEmitterImpl;", "getRegisterBlockStateEvent", "()Lorg/valkyrienskies/core/util/events/EventEmitterImpl;", "Lorg/valkyrienskies/mod/api/events/PreRenderShipEvent;", "preRenderShipEvent", "getPreRenderShipEvent", "Lorg/valkyrienskies/mod/api/events/PostRenderShipEvent;", "postRenderShipEvent", "getPostRenderShipEvent", "Lorg/valkyrienskies/core/api/event/ListenableEvent;", "Lorg/valkyrienskies/core/api/events/CollisionEvent;", "collisionEndEvent", "collisionPersistEvent", "collisionStartEvent", "Lorg/valkyrienskies/core/api/events/MergeEvent;", "mergeEvent", "Lorg/valkyrienskies/core/api/events/PhysTickEvent;", "physTickEvent", "Lorg/valkyrienskies/core/api/events/ShipLoadEvent;", "shipLoadEvent", "Lorg/valkyrienskies/core/api/events/ShipLoadEventClient;", "shipLoadEventClient", "Lorg/valkyrienskies/core/api/events/ShipUnloadEventClient;", "shipUnloadEventClient", "Lorg/valkyrienskies/core/api/events/SplitEvent;", "splitEvent", "Lorg/valkyrienskies/core/api/events/StartUpdateRenderTransformsEvent;", "startUpdateRenderTransformsEvent", "Lorg/valkyrienskies/core/api/events/TickEndEvent;", "tickEndEvent", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Factory;", "transformFactory", "<init>", "(Lorg/valkyrienskies/core/api/VsCoreApi;)V", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nVsApiImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VsApiImpl.kt\norg/valkyrienskies/mod/api_impl/events/VsApiImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,114:1\n1#2:115\n*E\n"})
public final class VsApiImpl
implements VsApi,
VsCoreApi {
    @NotNull
    private final VsCoreApi core;
    @NotNull
    private final EventEmitterImpl<RegisterBlockStateEvent> registerBlockStateEvent;
    @NotNull
    private final EventEmitterImpl<PreRenderShipEvent> preRenderShipEvent;
    @NotNull
    private final EventEmitterImpl<PostRenderShipEvent> postRenderShipEvent;

    public VsApiImpl(@NotNull VsCoreApi core) {
        Intrinsics.checkNotNullParameter((Object)core, (String)"core");
        this.core = core;
        this.registerBlockStateEvent = new EventEmitterImpl();
        this.preRenderShipEvent = new EventEmitterImpl();
        this.postRenderShipEvent = new EventEmitterImpl();
    }

    @Override
    @VsBeta
    @NotNull
    public <T> AttachmentRegistration.Builder<T> newAttachmentRegistrationBuilder(@NotNull Class<T> attachmentClass) {
        Intrinsics.checkNotNullParameter(attachmentClass, (String)"attachmentClass");
        return this.core.newAttachmentRegistrationBuilder(attachmentClass);
    }

    @Override
    @VsBeta
    @NotNull
    public BodyKinematics newBodyKinematics(@NotNull Vector3dc velocity, @NotNull Vector3dc angularVelocity, @NotNull Vector3dc position, @NotNull Quaterniondc rotation, @NotNull Vector3dc scaling, @NotNull Vector3dc positionInModel) {
        Intrinsics.checkNotNullParameter((Object)velocity, (String)"velocity");
        Intrinsics.checkNotNullParameter((Object)angularVelocity, (String)"angularVelocity");
        Intrinsics.checkNotNullParameter((Object)position, (String)"position");
        Intrinsics.checkNotNullParameter((Object)rotation, (String)"rotation");
        Intrinsics.checkNotNullParameter((Object)scaling, (String)"scaling");
        Intrinsics.checkNotNullParameter((Object)positionInModel, (String)"positionInModel");
        return this.core.newBodyKinematics(velocity, angularVelocity, position, rotation, scaling, positionInModel);
    }

    @Override
    @VsBeta
    @NotNull
    public BodyKinematics newBodyKinematics(@NotNull Vector3dc velocity, @NotNull Vector3dc angularVelocity, @NotNull BodyTransform transform2) {
        Intrinsics.checkNotNullParameter((Object)velocity, (String)"velocity");
        Intrinsics.checkNotNullParameter((Object)angularVelocity, (String)"angularVelocity");
        Intrinsics.checkNotNullParameter((Object)transform2, (String)"transform");
        return this.core.newBodyKinematics(velocity, angularVelocity, transform2);
    }

    @Override
    @VsBeta
    @NotNull
    public BodyKinematics.Builder newBodyKinematicsBuilder() {
        return this.core.newBodyKinematicsBuilder();
    }

    @Override
    @NotNull
    public BodyTransform newBodyTransform(@NotNull Vector3dc position, @NotNull Quaterniondc rotation, @NotNull Vector3dc scaling, @NotNull Vector3dc positionInModel) {
        Intrinsics.checkNotNullParameter((Object)position, (String)"position");
        Intrinsics.checkNotNullParameter((Object)rotation, (String)"rotation");
        Intrinsics.checkNotNullParameter((Object)scaling, (String)"scaling");
        Intrinsics.checkNotNullParameter((Object)positionInModel, (String)"positionInModel");
        return this.core.newBodyTransform(position, rotation, scaling, positionInModel);
    }

    @Override
    @VsBeta
    @NotNull
    public BodyTransform.Builder newBodyTransformBuilder() {
        return this.core.newBodyTransformBuilder();
    }

    @Override
    @VsBeta
    public <T> void registerAttachment(@NotNull Class<T> attachmentClass) {
        Intrinsics.checkNotNullParameter(attachmentClass, (String)"attachmentClass");
        this.core.registerAttachment(attachmentClass);
    }

    @Override
    @VsBeta
    public <T> void registerAttachment(@NotNull Class<T> attachmentClass, @NotNull Function1<? super AttachmentRegistration.Builder<T>, Unit> registrationBuilder) {
        Intrinsics.checkNotNullParameter(attachmentClass, (String)"attachmentClass");
        Intrinsics.checkNotNullParameter(registrationBuilder, (String)"registrationBuilder");
        this.core.registerAttachment(attachmentClass, registrationBuilder);
    }

    @Override
    @VsBeta
    public <T> void registerAttachment(@NotNull AttachmentRegistration<T> registration) {
        Intrinsics.checkNotNullParameter(registration, (String)"registration");
        this.core.registerAttachment(registration);
    }

    @Override
    @VsBeta
    public void registerAttachmentForRemoval(@NotNull String attachmentKey) {
        Intrinsics.checkNotNullParameter((Object)attachmentKey, (String)"attachmentKey");
        this.core.registerAttachmentForRemoval(attachmentKey);
    }

    @Override
    @NotNull
    public ListenableEvent<CollisionEvent> getCollisionEndEvent() {
        return this.core.getCollisionEndEvent();
    }

    @Override
    @NotNull
    public ListenableEvent<CollisionEvent> getCollisionPersistEvent() {
        return this.core.getCollisionPersistEvent();
    }

    @Override
    @NotNull
    public ListenableEvent<CollisionEvent> getCollisionStartEvent() {
        return this.core.getCollisionStartEvent();
    }

    @Override
    @NotNull
    public ListenableEvent<MergeEvent> getMergeEvent() {
        return this.core.getMergeEvent();
    }

    @Override
    @NotNull
    public ListenableEvent<PhysTickEvent> getPhysTickEvent() {
        return this.core.getPhysTickEvent();
    }

    @Override
    @NotNull
    public ListenableEvent<ShipLoadEvent> getShipLoadEvent() {
        return this.core.getShipLoadEvent();
    }

    @Override
    @NotNull
    public ListenableEvent<ShipLoadEventClient> getShipLoadEventClient() {
        return this.core.getShipLoadEventClient();
    }

    @Override
    @NotNull
    public ListenableEvent<ShipUnloadEventClient> getShipUnloadEventClient() {
        return this.core.getShipUnloadEventClient();
    }

    @Override
    @NotNull
    public ListenableEvent<SplitEvent> getSplitEvent() {
        return this.core.getSplitEvent();
    }

    @Override
    @NotNull
    public ListenableEvent<StartUpdateRenderTransformsEvent> getStartUpdateRenderTransformsEvent() {
        return this.core.getStartUpdateRenderTransformsEvent();
    }

    @Override
    @NotNull
    public ListenableEvent<TickEndEvent> getTickEndEvent() {
        return this.core.getTickEndEvent();
    }

    @Override
    @NotNull
    public BodyTransform.Factory getTransformFactory() {
        return this.core.getTransformFactory();
    }

    @NotNull
    public EventEmitterImpl<RegisterBlockStateEvent> getRegisterBlockStateEvent() {
        return this.registerBlockStateEvent;
    }

    @NotNull
    public EventEmitterImpl<PreRenderShipEvent> getPreRenderShipEvent() {
        return this.preRenderShipEvent;
    }

    @NotNull
    public EventEmitterImpl<PostRenderShipEvent> getPostRenderShipEvent() {
        return this.postRenderShipEvent;
    }

    @Override
    public boolean isShipMountingEntity(@NotNull class_1297 entity) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        return entity instanceof ShipMountingEntity;
    }

    @Override
    @NotNull
    public String getDimensionId(@NotNull class_1937 level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        return VSGameUtilsKt.getDimensionId(level);
    }

    @Override
    @Nullable
    public Ship getShipMountedTo(@Nullable class_1297 entity) {
        LoadedShip loadedShip;
        class_1297 class_12972 = entity;
        if (class_12972 != null) {
            class_1297 it = class_12972;
            boolean bl = false;
            loadedShip = VSGameUtilsKt.getShipMountedTo(it);
        } else {
            loadedShip = null;
        }
        return loadedShip;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    @Nullable
    public Vector3dc getMountPosInShip(@Nullable class_1297 entity) {
        class_1297 class_12972 = entity;
        Object object = class_12972;
        if (class_12972 == null) return null;
        class_1297 it = object;
        boolean bl = false;
        ShipMountedToData shipMountedToData = VSGameUtilsKt.getShipMountedToData$default(it, null, 2, null);
        object = shipMountedToData;
        if (shipMountedToData == null) return null;
        Vector3dc vector3dc = ((ShipMountedToData)object).getMountPosInShip();
        return vector3dc;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    @Nullable
    public Vector3dc getMountPosInShip(@Nullable class_1297 entity, float partialTicks) {
        class_1297 class_12972 = entity;
        Object object = class_12972;
        if (class_12972 == null) return null;
        class_1297 it = object;
        boolean bl = false;
        ShipMountedToData shipMountedToData = VSGameUtilsKt.getShipMountedToData(it, Float.valueOf(partialTicks));
        object = shipMountedToData;
        if (shipMountedToData == null) return null;
        Vector3dc vector3dc = ((ShipMountedToData)object).getMountPosInShip();
        return vector3dc;
    }

    @Override
    @Nullable
    public ServerShipWorld getServerShipWorld() {
        return this.getServerShipWorld(ValkyrienSkiesMod.getCurrentServer());
    }

    @Override
    @Nullable
    public ServerShipWorld getServerShipWorld(@Nullable MinecraftServer server) {
        IShipObjectWorldServerProvider iShipObjectWorldServerProvider = (IShipObjectWorldServerProvider)server;
        return iShipObjectWorldServerProvider != null ? iShipObjectWorldServerProvider.getShipObjectWorld() : null;
    }

    @Override
    @Nullable
    public ClientShipWorld getClientShipWorld() {
        return this.getClientShipWorld(class_310.method_1551());
    }

    @Override
    @Nullable
    public ShipWorld getShipWorld(@Nullable class_1937 level) {
        class_1937 class_19372 = level;
        return class_19372 instanceof class_3218 ? (ShipWorld)this.getServerShipWorld(((class_3218)level).method_8503()) : (class_19372 instanceof class_638 ? (ShipWorld)this.getClientShipWorld() : null);
    }

    @Override
    public boolean isChunkInShipyard(@Nullable class_1937 level, int chunkX, int chunkZ) {
        if (level == null) {
            return false;
        }
        ShipWorld shipWorld = this.getShipWorld(level);
        return shipWorld != null ? shipWorld.isChunkInShipyard(chunkX, chunkZ, this.getDimensionId(level)) : false;
    }

    @Override
    @Nullable
    public ClientShipWorld getClientShipWorld(@Nullable class_310 client) {
        IShipObjectWorldClientProvider iShipObjectWorldClientProvider = (IShipObjectWorldClientProvider)client;
        return iShipObjectWorldClientProvider != null ? iShipObjectWorldClientProvider.getShipObjectWorld() : null;
    }

    @Override
    @Nullable
    public Ship getShipManagingBlock(@Nullable class_1937 level, @Nullable class_2338 pos) {
        Ship ship;
        class_2338 class_23382 = pos;
        if (class_23382 != null) {
            class_2338 it = class_23382;
            boolean bl = false;
            class_1937 class_19372 = level;
            ship = class_19372 != null ? VSGameUtilsKt.getShipManagingPos(class_19372, it) : null;
        } else {
            ship = null;
        }
        return ship;
    }

    @Override
    @Nullable
    public Ship getShipManagingChunk(@Nullable class_1937 level, @Nullable class_1923 pos) {
        Ship ship;
        class_1923 class_19232 = pos;
        if (class_19232 != null) {
            class_1923 it = class_19232;
            boolean bl = false;
            class_1937 class_19372 = level;
            ship = class_19372 != null ? VSGameUtilsKt.getShipManagingPos(class_19372, it) : null;
        } else {
            ship = null;
        }
        return ship;
    }

    @Override
    @Nullable
    public Ship getShipManagingChunk(@Nullable class_1937 level, int chunkX, int chunkZ) {
        class_1937 class_19372 = level;
        return class_19372 != null ? VSGameUtilsKt.getShipManagingPos(class_19372, chunkX, chunkZ) : null;
    }

    @Override
    @NotNull
    public Iterable<Ship> getShipsIntersecting(@Nullable class_1937 level, @Nullable AABBdc aabb) {
        if (level == null || aabb == null) {
            return CollectionsKt.emptyList();
        }
        return VSGameUtilsKt.getShipsIntersecting(level, aabb);
    }

    @Override
    @NotNull
    public Iterable<Ship> getShipsIntersecting(@Nullable class_1937 level, double x, double y, double z) {
        return this.getShipsIntersecting(level, new AABBd(x, y, z, x, y, z));
    }
}

