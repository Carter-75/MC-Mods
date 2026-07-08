/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.valkyrienskies.core.impl.shadow.Eo
 *  org.valkyrienskies.core.impl.shadow.Eo$a
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Matrix4dc;
import org.joml.Vector3dc;
import org.joml.primitives.AABBdc;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.attachment.AttachmentHolder;
import org.valkyrienskies.core.api.bodies.properties.BodyKinematics;
import org.valkyrienskies.core.api.bodies.properties.BodyTransform;
import org.valkyrienskies.core.api.ships.DragController;
import org.valkyrienskies.core.api.ships.ServerShipTransformProvider;
import org.valkyrienskies.core.api.ships.ServerTickListener;
import org.valkyrienskies.core.api.ships.ShipPhysicsListener;
import org.valkyrienskies.core.api.ships.WingManager;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.core.api.ships.properties.IShipActiveChunksSet;
import org.valkyrienskies.core.api.ships.properties.PhysPose;
import org.valkyrienskies.core.api.ships.properties.ShipInertiaData;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.impl.api.LoadedServerShipInternal;
import org.valkyrienskies.core.impl.api.ServerShipInternal;
import org.valkyrienskies.core.impl.api.ServerShipUser;
import org.valkyrienskies.core.impl.game.ships.ShipData;
import org.valkyrienskies.core.impl.game.ships.ShipDataCommon;
import org.valkyrienskies.core.impl.shadow.Eo;
import org.valkyrienskies.core.impl.shadow.eh_0;
import org.valkyrienskies.core.impl.shadow.ew_0;
import org.valkyrienskies.core.impl.shadow.fn_0;
import org.valkyrienskies.core.impl.shadow.fp_0;
import org.valkyrienskies.core.impl.util.serialization.VSJacksonUtil;
import org.valkyrienskies.core.internal.ShipTeleportData;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Eq
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0098\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00ad\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u00ad\u0001B\u0011\u0012\u0006\u0010\u0006\u001a\u00020|\u00a2\u0006\u0006\b\u00ab\u0001\u0010\u00ac\u0001J%\u0010\n\u001a\u00020\t2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fH\u0096\u0001\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fH\u0096\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0018\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0017*\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J5\u0010\u001b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0017*\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\u001d\u0010\u0013J\u000f\u0010\u001e\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\u001e\u0010\u000eJ \u0010 \u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u001f2\u0006\u0010\b\u001a\u00020\u001fH\u0096\u0001\u00a2\u0006\u0004\b \u0010!JH\u0010(\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u001f2\u0006\u0010\b\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\fH\u0096\u0001\u00a2\u0006\u0004\b(\u0010)J \u0010*\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u001f2\u0006\u0010\b\u001a\u00020\u001fH\u0096\u0001\u00a2\u0006\u0004\b*\u0010!J)\u0010+\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0017*\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016\u00a2\u0006\u0004\b+\u0010\u0019J.\u0010-\u001a\u00020,\"\u0004\b\u0000\u0010\u00172\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0010\b\u001a\u0004\u0018\u00018\u0000H\u0097\u0001\u00a2\u0006\u0004\b-\u0010.J#\u0010/\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0017*\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b/\u00100J\u0018\u00102\u001a\u00020\t2\u0006\u0010\u0006\u001a\u000201H\u0096\u0001\u00a2\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u00020\t2\u0006\u0010\u0006\u001a\u000204H\u0016\u00a2\u0006\u0004\b5\u00106J\u0018\u00108\u001a\u00020\t2\u0006\u0010\u0006\u001a\u000207H\u0096\u0001\u00a2\u0006\u0004\b8\u00109J\u0018\u0010:\u001a\u00020\t2\u0006\u0010\u0006\u001a\u000201H\u0096\u0001\u00a2\u0006\u0004\b:\u00103J0\u0010;\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u001f2\u0006\u0010\b\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\fH\u0096\u0001\u00a2\u0006\u0004\b;\u0010<R\u0014\u0010\n\u001a\u00020=8\u0017X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b>\u0010?R\u0014\u0010C\u001a\u00020@8WX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bA\u0010BR\u0014\u0010G\u001a\u00020D8\u0017X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bE\u0010FR \u0010N\u001a\u00060Hj\u0002`I8\u0017@\u0017X\u0096\u000f\u00a2\u0006\f\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0016\u0010R\u001a\u0004\u0018\u00010O8WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bP\u0010QR\u0018\u0010W\u001a\u00060Sj\u0002`T8\u0017X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bU\u0010VR\u0014\u0010[\u001a\u00020X8\u0017X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bY\u0010ZR\u001c\u0010_\u001a\u00020\f8\u0017@\u0017X\u0096\u000f\u00a2\u0006\f\u001a\u0004\b\\\u0010\u000e\"\u0004\b]\u0010^R\u001e\u0010e\u001a\u0004\u0018\u00010`8\u0017@\u0017X\u0096\u000f\u00a2\u0006\f\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u0014\u0010h\u001a\u0002078\u0017X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bf\u0010gR\u0014\u0010j\u001a\u00020@8WX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bi\u0010BR'\u0010o\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020l0k8\u0007\u00a2\u0006\f\n\u0004\bR\u0010m\u001a\u0004\bR\u0010nR\u0014\u0010s\u001a\u00020p8WX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bq\u0010rR\u0014\u0010u\u001a\u00020p8\u0017X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bt\u0010rR\u0016\u0010y\u001a\u0004\u0018\u00010v8\u0017X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bw\u0010xR\u0014\u0010{\u001a\u00020=8WX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bz\u0010?R\u001a\u0010\u007f\u001a\u00020|8\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\bC\u0010}\u001a\u0004\bG\u0010~R\"\u0010\u0084\u0001\u001a\n\u0012\u0005\u0012\u00030\u0081\u00010\u0080\u00018\u0007\u00a2\u0006\u000e\n\u0005\bN\u0010\u0082\u0001\u001a\u0005\bN\u0010\u0083\u0001R/\u0010\u0089\u0001\u001a\u00020\u001f2\u0006\u0010\u0006\u001a\u00020\u001f8\u0017@QX\u0096\u000e\u00a2\u0006\u0016\n\u0005\bG\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0005\b\n\u0010\u0088\u0001R\u0018\u0010\u008d\u0001\u001a\u00030\u008a\u00018WX\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0016\u0010\u008f\u0001\u001a\u00020p8WX\u0096\u0005\u00a2\u0006\u0007\u001a\u0005\b\u008e\u0001\u0010rR\u0018\u0010\u0091\u0001\u001a\u0004\u0018\u00010v8WX\u0096\u0005\u00a2\u0006\u0007\u001a\u0005\b\u0090\u0001\u0010xR!\u0010\u0094\u0001\u001a\u0004\u0018\u00010H8\u0017@\u0017X\u0096\u000f\u00a2\u0006\u000e\u001a\u0005\b\u0092\u0001\u0010K\"\u0005\b\u0093\u0001\u0010MR)\u0010\u0096\u0001\u001a\u0013\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0005\u0012\u00030\u0095\u00010k8\u0007\u00a2\u0006\f\n\u0004\bW\u0010m\u001a\u0004\bW\u0010nR\u0016\u0010\u0098\u0001\u001a\u00020p8WX\u0096\u0005\u00a2\u0006\u0007\u001a\u0005\b\u0097\u0001\u0010rR$\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u0099\u00018\u0017@\u0017X\u0096\u000f\u00a2\u0006\u0010\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0016\u0010\u00a0\u0001\u001a\u00020@8WX\u0096\u0005\u00a2\u0006\u0007\u001a\u0005\b\u009f\u0001\u0010BR\u001a\u0010\u00a4\u0001\u001a\u0005\u0018\u00010\u00a1\u00018WX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u00a2\u0001\u0010\u00a3\u0001R\u0018\u0010\u00a8\u0001\u001a\u00030\u00a5\u00018\u0017X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u00a6\u0001\u0010\u00a7\u0001R\u0018\u0010\u00aa\u0001\u001a\u00030\u008a\u00018WX\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u00a9\u0001\u0010\u008c\u0001"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Eq;", "Lorg/valkyrienskies/core/impl/shadow/Eo;", "Lorg/valkyrienskies/core/impl/api/LoadedServerShipInternal;", "Lorg/valkyrienskies/core/impl/api/ServerShipInternal;", "Lorg/valkyrienskies/core/api/attachment/AttachmentHolder;", "Ljava/lang/Class;", "p0", "", "p1", "", "a", "(Ljava/lang/Class;Ljava/lang/Object;)V", "", "areVoxelsFullyLoaded", "()Z", "Lorg/valkyrienskies/core/impl/game/ships/ShipDataCommon;", "asShipDataCommon", "()Lorg/valkyrienskies/core/impl/game/ships/ShipDataCommon;", "decayPortalCoolDown", "()V", "", "getAllAttachments", "()Ljava/lang/Iterable;", "T", "getAttachment", "(Ljava/lang/Class;)Ljava/lang/Object;", "Ljava/util/function/Supplier;", "getOrPutAttachment", "(Ljava/lang/Class;Ljava/util/function/Supplier;)Ljava/lang/Object;", "handleInsidePortal", "isOnPortalCoolDown", "", "onLoadChunk", "(II)V", "p2", "p3", "", "p4", "p5", "p6", "onSetBlock", "(IIIZDDZ)V", "onUnloadChunk", "removeAttachment", "", "saveAttachment", "(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Void;", "setAttachment", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "setFromTransform", "(Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;)V", "Lorg/valkyrienskies/core/internal/ShipTeleportData;", "teleportShip", "(Lorg/valkyrienskies/core/internal/ShipTeleportData;)V", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "unsafeSetKinematics", "(Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;)V", "unsafeSetTransform", "updateShipAABBGenerator", "(IIIZ)V", "Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "getActiveChunksSet", "()Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "Lorg/joml/Vector3dc;", "getAngularVelocity", "()Lorg/joml/Vector3dc;", "b", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "getChunkClaim", "()Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "c", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "getChunkClaimDimension", "()Ljava/lang/String;", "setChunkClaimDimension", "(Ljava/lang/String;)V", "d", "Lorg/valkyrienskies/core/api/ships/DragController;", "getDragController", "()Lorg/valkyrienskies/core/api/ships/DragController;", "e", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "getId", "()J", "f", "Lorg/valkyrienskies/core/api/ships/properties/ShipInertiaData;", "getInertiaData", "()Lorg/valkyrienskies/core/api/ships/properties/ShipInertiaData;", "g", "isStatic", "setStatic", "(Z)V", "h", "Lorg/valkyrienskies/core/api/ships/properties/PhysPose;", "getKinematicTarget", "()Lorg/valkyrienskies/core/api/ships/properties/PhysPose;", "setKinematicTarget", "(Lorg/valkyrienskies/core/api/ships/properties/PhysPose;)V", "i", "getKinematics", "()Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "j", "getOmega", "k", "", "Lorg/valkyrienskies/core/api/ships/ShipPhysicsListener;", "Ljava/util/Map;", "()Ljava/util/Map;", "l", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "getPrevTickShipTransform", "()Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "m", "getPrevTickTransform", "n", "Lorg/joml/primitives/AABBic;", "getShipAABB", "()Lorg/joml/primitives/AABBic;", "o", "getShipActiveChunksSet", "p", "Lorg/valkyrienskies/core/impl/game/ships/ShipData;", "Lorg/valkyrienskies/core/impl/game/ships/ShipData;", "()Lorg/valkyrienskies/core/impl/game/ships/ShipData;", "q", "Lorg/valkyrienskies/core/impl/shadow/Fp;", "Lcom/fasterxml/jackson/databind/JsonNode;", "Lorg/valkyrienskies/core/impl/shadow/Fp;", "()Lorg/valkyrienskies/core/impl/shadow/Fp;", "r", "I", "getShipTeleportId", "()I", "(I)V", "s", "Lorg/joml/Matrix4dc;", "getShipToWorld", "()Lorg/joml/Matrix4dc;", "t", "getShipTransform", "u", "getShipVoxelAABB", "v", "getSlug", "setSlug", "w", "Lorg/valkyrienskies/core/api/ships/ServerTickListener;", "x", "getTransform", "y", "Lorg/valkyrienskies/core/api/ships/ServerShipTransformProvider;", "getTransformProvider", "()Lorg/valkyrienskies/core/api/ships/ServerShipTransformProvider;", "setTransformProvider", "(Lorg/valkyrienskies/core/api/ships/ServerShipTransformProvider;)V", "z", "getVelocity", "A", "Lorg/valkyrienskies/core/api/ships/WingManager;", "getWingManager", "()Lorg/valkyrienskies/core/api/ships/WingManager;", "B", "Lorg/joml/primitives/AABBdc;", "getWorldAABB", "()Lorg/joml/primitives/AABBdc;", "C", "getWorldToShip", "D", "<init>", "(Lorg/valkyrienskies/core/impl/game/ships/ShipData;)V", "a_"})
public final class eq_0
extends Eo
implements AttachmentHolder,
LoadedServerShipInternal,
ServerShipInternal {
    public static final a_ a_ = new a_(null);
    public final ShipData b;
    public int c;
    public final fp_0<JsonNode> d;
    public final Map<Class<?>, ShipPhysicsListener> e;
    public final Map<Class<?>, ServerTickListener> f;
    private static final int g = 300;

    public eq_0(ShipData iterator2) {
        Intrinsics.checkNotNullParameter((Object)iterator2, (String)"");
        super((ShipDataCommon)((Object)iterator2));
        this.b = iterator2;
        fn_0 fn_02 = Eo.a.a();
        iterator2 = this;
        Object t = VSJacksonUtil.INSTANCE.getDeltaMapper().valueToTree(((eq_0)((Object)iterator2)).b);
        Intrinsics.checkNotNullExpressionValue(t, (String)"");
        this.d = new fp_0(fn_02, t);
        this.e = new LinkedHashMap();
        this.f = new LinkedHashMap();
        iterator2 = new ew_0();
        Object object2 = new eh_0(false, 1, null);
        WingManager.createWingGroup$default((WingManager)((Object)iterator2), false, 1, null);
        this.setAttachment(iterator2);
        this.setAttachment(object2);
        iterator2 = this;
        for (Object object2 : ((eq_0)((Object)iterator2)).b.getAttachmentHolder().getAllAttachments()) {
            this.a(object2.getClass(), object2);
        }
    }

    @JvmName(name="c")
    public final ShipData c() {
        return this.b;
    }

    @Override
    @JvmName(name="getActiveChunksSet")
    public final IShipActiveChunksSet getActiveChunksSet() {
        return this.b.getActiveChunksSet();
    }

    @Override
    @JvmName(name="getAngularVelocity")
    public final Vector3dc getAngularVelocity() {
        return this.b.getAngularVelocity();
    }

    @Override
    @JvmName(name="getChunkClaim")
    public final ChunkClaim getChunkClaim() {
        return this.b.getChunkClaim();
    }

    @Override
    @JvmName(name="getChunkClaimDimension")
    public final String getChunkClaimDimension() {
        return this.b.getChunkClaimDimension();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setChunkClaimDimension")
    public final void setChunkClaimDimension(String string) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        this.b.setChunkClaimDimension((String)var1_1);
    }

    @Override
    @JvmName(name="getId")
    public final long getId() {
        return this.b.getId();
    }

    @Override
    @JvmName(name="getInertiaData")
    public final ShipInertiaData getInertiaData() {
        return this.b.getInertiaData();
    }

    @Override
    @JvmName(name="isStatic")
    public final boolean isStatic() {
        return this.b.isStatic();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setStatic")
    public final void setStatic(boolean bl) {
        void var1_1;
        this.b.setStatic((boolean)var1_1);
    }

    @Override
    @JvmName(name="getKinematicTarget")
    public final PhysPose getKinematicTarget() {
        return this.b.getKinematicTarget();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setKinematicTarget")
    public final void setKinematicTarget(PhysPose physPose) {
        void var1_1;
        this.b.setKinematicTarget((PhysPose)var1_1);
    }

    @Override
    @JvmName(name="getKinematics")
    public final BodyKinematics getKinematics() {
        return this.b.getKinematics();
    }

    @Override
    @JvmName(name="getOmega")
    public final Vector3dc getOmega() {
        return this.b.getOmega();
    }

    @Override
    @JvmName(name="getPrevTickShipTransform")
    public final ShipTransform getPrevTickShipTransform() {
        return this.b.getPrevTickShipTransform();
    }

    @Override
    @JvmName(name="getPrevTickTransform")
    public final ShipTransform getPrevTickTransform() {
        return this.b.getPrevTickTransform();
    }

    @Override
    @JvmName(name="getShipAABB")
    public final AABBic getShipAABB() {
        return this.b.getShipAABB();
    }

    @Override
    @JvmName(name="getShipActiveChunksSet")
    public final IShipActiveChunksSet getShipActiveChunksSet() {
        return this.b.getShipActiveChunksSet();
    }

    @Override
    @JvmName(name="getShipToWorld")
    public final Matrix4dc getShipToWorld() {
        return this.b.getShipToWorld();
    }

    @Override
    @JvmName(name="getShipTransform")
    public final ShipTransform getShipTransform() {
        return this.b.getShipTransform();
    }

    @Override
    @JvmName(name="getShipVoxelAABB")
    public final AABBic getShipVoxelAABB() {
        return this.b.getShipVoxelAABB();
    }

    @Override
    @JvmName(name="getSlug")
    public final String getSlug() {
        return this.b.getSlug();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setSlug")
    public final void setSlug(String string) {
        void var1_1;
        this.b.setSlug((String)var1_1);
    }

    @Override
    @JvmName(name="getTransform")
    public final ShipTransform getTransform() {
        return this.b.getTransform();
    }

    @Override
    @JvmName(name="getTransformProvider")
    public final ServerShipTransformProvider getTransformProvider() {
        return this.b.getTransformProvider();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setTransformProvider")
    public final void setTransformProvider(ServerShipTransformProvider serverShipTransformProvider) {
        void var1_1;
        this.b.setTransformProvider((ServerShipTransformProvider)var1_1);
    }

    @Override
    @JvmName(name="getVelocity")
    public final Vector3dc getVelocity() {
        return this.b.getVelocity();
    }

    @Override
    @JvmName(name="getWorldAABB")
    public final AABBdc getWorldAABB() {
        return this.b.getWorldAABB();
    }

    @Override
    @JvmName(name="getWorldToShip")
    public final Matrix4dc getWorldToShip() {
        return this.b.getWorldToShip();
    }

    @Override
    public final boolean areVoxelsFullyLoaded() {
        return this.b.areVoxelsFullyLoaded();
    }

    @Override
    public final ShipDataCommon asShipDataCommon() {
        return this.b.asShipDataCommon();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void onLoadChunk(int chunkX, int chunkZ) {
        void var2_2;
        void var1_1;
        this.b.onLoadChunk((int)var1_1, (int)var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void onSetBlock(int posX, int posY, int posZ, boolean newBlockIsAir, double oldBlockMass, double newBlockMass, boolean isRunningOnServer) {
        void var3_3;
        void var2_2;
        void var1_1;
        ((ShipDataCommon)this.b).onSetBlock((int)var1_1, (int)var2_2, (int)var3_3, newBlockIsAir, oldBlockMass, newBlockMass, isRunningOnServer);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void onUnloadChunk(int chunkX, int chunkZ) {
        void var2_2;
        void var1_1;
        this.b.onUnloadChunk((int)var1_1, (int)var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Deprecated(message="Since VS 2.5, attachments can only be saved to a LoadedServerShip", replaceWith=@ReplaceWith(expression="this.setAttachment(clazz, value)", imports={}), level=DeprecationLevel.ERROR)
    public final <T> Void saveAttachment(Class<T> clazz, T value) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter(clazz, (String)"");
        this.b.saveAttachment((Class)var1_1, var2_2);
        return null;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void setFromTransform(BodyTransform transform2) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)transform2, (String)"");
        this.b.setFromTransform((BodyTransform)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void unsafeSetKinematics(BodyKinematics kinematics) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)kinematics, (String)"");
        this.b.unsafeSetKinematics((BodyKinematics)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void unsafeSetTransform(BodyTransform transform2) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)transform2, (String)"");
        this.b.unsafeSetTransform((BodyTransform)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void updateShipAABBGenerator(int posX, int posY, int posZ, boolean set) {
        void var3_3;
        void var2_2;
        void var1_1;
        this.b.updateShipAABBGenerator((int)var1_1, (int)var2_2, (int)var3_3, set);
    }

    @Override
    @JvmName(name="getShipTeleportId")
    public final int getShipTeleportId() {
        return this.c;
    }

    @JvmName(name="a")
    public final void a(int n2) {
        this.c = n2;
    }

    @Override
    @JvmName(name="getWingManager")
    public final WingManager getWingManager() {
        AttachmentHolder attachmentHolder = this;
        return attachmentHolder.getAttachment(ew_0.class);
    }

    @Override
    @JvmName(name="getDragController")
    public final DragController getDragController() {
        AttachmentHolder attachmentHolder = this;
        return attachmentHolder.getAttachment(eh_0.class);
    }

    @JvmName(name="d")
    public final fp_0<JsonNode> d() {
        return this.d;
    }

    @JvmName(name="e")
    public final Map<Class<?>, ShipPhysicsListener> e() {
        return this.e;
    }

    @JvmName(name="f")
    public final Map<Class<?>, ServerTickListener> f() {
        return this.f;
    }

    @Override
    public final boolean isOnPortalCoolDown() {
        eq_0 eq_02 = this;
        return eq_02.b.getPortalCoolDown$impl() > 0;
    }

    @Override
    public final void handleInsidePortal() {
        eq_0 eq_02 = this;
        eq_02.b.setPortalCoolDown$impl(300);
    }

    @Override
    public final void decayPortalCoolDown() {
        if (this.isOnPortalCoolDown()) {
            ServerShipInternal serverShipInternal = this;
            serverShipInternal = ((eq_0)serverShipInternal).b;
            int n2 = ((ShipData)serverShipInternal).getPortalCoolDown$impl();
            ((ShipData)serverShipInternal).setPortalCoolDown$impl(n2 + -1);
        }
    }

    private final void a(Class<?> clazz, Object object) {
        if (object == null) {
            this.e.remove(clazz);
            this.f.remove(clazz);
            return;
        }
        if (object instanceof ShipPhysicsListener) {
            this.e.put(clazz, (ShipPhysicsListener)object);
        }
        if (object instanceof ServerShipUser) {
            ((ServerShipUser)object).setShip(this);
        }
        if (object instanceof ServerTickListener) {
            this.f.put(clazz, (ServerTickListener)object);
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void teleportShip(ShipTeleportData teleportData) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)teleportData, (String)"");
        int n2 = this.getShipTeleportId();
        int n3 = n2 + 1;
        eq_0 eq_02 = this;
        this.c = n3;
        eq_02 = this;
        eq_02.b.setKinematics(var1_1.createNewShipTransform(this.getTransform()));
        eq_02 = this;
        eq_02.b.setNeedsUpdating(true);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final <T> T getAttachment(Class<T> clazz) {
        void var1_1;
        Intrinsics.checkNotNullParameter(clazz, (String)"");
        if (Intrinsics.areEqual(clazz, WingManager.class)) {
            WingManager wingManager = this.getWingManager();
            Intrinsics.checkNotNull((Object)wingManager);
            return (T)wingManager;
        }
        eq_0 eq_02 = this;
        return eq_02.b.getAttachmentHolder().getAttachment(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final <T> T getOrPutAttachment(Class<T> clazz, Supplier<T> supplier) {
        void var2_2;
        Object t;
        Intrinsics.checkNotNullParameter(clazz, (String)"");
        Intrinsics.checkNotNullParameter(supplier, (String)"");
        eq_0 eq_02 = this;
        t = eq_02.b.getAttachmentHolder().getOrPutAttachment(t, var2_2);
        this.a(t.getClass(), t);
        return t;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final <T> T setAttachment(T value) {
        void var1_1;
        Intrinsics.checkNotNullParameter(value, (String)"");
        this.a(value.getClass(), value);
        eq_0 eq_02 = this;
        return eq_02.b.getAttachmentHolder().setAttachment(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final <T> T removeAttachment(Class<T> clazz) {
        void var1_1;
        Intrinsics.checkNotNullParameter(clazz, (String)"");
        this.a(clazz, null);
        eq_0 eq_02 = this;
        return eq_02.b.getAttachmentHolder().removeAttachment(var1_1);
    }

    @Override
    public final Iterable<Object> getAllAttachments() {
        eq_0 eq_02 = this;
        return eq_02.b.getAttachmentHolder().getAllAttachments();
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Eq$a_;", "", "", "g", "I", "a", "<init>", "()V"})
    public static final class a_ {
        private a_() {
        }

        public /* synthetic */ a_(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

