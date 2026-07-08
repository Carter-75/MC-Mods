/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.Unit
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.program;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import javax.inject.Inject;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Matrix3dc;
import org.joml.Quaterniondc;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.VsBeta;
import org.valkyrienskies.core.api.attachment.AttachmentRegistration;
import org.valkyrienskies.core.api.bodies.properties.BodyKinematics;
import org.valkyrienskies.core.api.bodies.properties.BodyTransform;
import org.valkyrienskies.core.api.event.ListenableEvent;
import org.valkyrienskies.core.api.event.SingleEvent;
import org.valkyrienskies.core.api.events.CollisionEvent;
import org.valkyrienskies.core.api.events.MergeEvent;
import org.valkyrienskies.core.api.events.PhysTickEvent;
import org.valkyrienskies.core.api.events.ShipLoadEvent;
import org.valkyrienskies.core.api.events.ShipLoadEventClient;
import org.valkyrienskies.core.api.events.ShipUnloadEventClient;
import org.valkyrienskies.core.api.events.SplitEvent;
import org.valkyrienskies.core.api.events.StartUpdateRenderTransformsEvent;
import org.valkyrienskies.core.api.events.TickEndEvent;
import org.valkyrienskies.core.api.physics.blockstates.BoxesBlockShape;
import org.valkyrienskies.core.api.physics.blockstates.LiquidState;
import org.valkyrienskies.core.api.physics.blockstates.SolidState;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.core.api.ships.properties.ShipInertiaData;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.api.world.ServerShipWorld;
import org.valkyrienskies.core.impl.networking.simple.SimplePacketNetworking;
import org.valkyrienskies.core.impl.program.VSCoreImpl;
import org.valkyrienskies.core.impl.program.VSCoreInternal;
import org.valkyrienskies.core.impl.shadow.EU;
import org.valkyrienskies.core.impl.shadow.FJ;
import org.valkyrienskies.core.impl.shadow.FL;
import org.valkyrienskies.core.impl.shadow.fi_0;
import org.valkyrienskies.core.impl.shadow.fj_0;
import org.valkyrienskies.core.internal.ShipTeleportData;
import org.valkyrienskies.core.internal.VsiCoreServer;
import org.valkyrienskies.core.internal.collision.VsiEntityPolygonCollider;
import org.valkyrienskies.core.internal.collision.VsiSolidShapeUtils;
import org.valkyrienskies.core.internal.config.VsiConfigModel;
import org.valkyrienskies.core.internal.physics.blockstates.VsiBlockState;
import org.valkyrienskies.core.internal.world.VsiClientShipWorld;
import org.valkyrienskies.core.internal.world.VsiPipeline;
import org.valkyrienskies.core.internal.world.VsiServerShipWorld;
import org.valkyrienskies.core.internal.world.chunks.VsiBlockTypes;
import org.valkyrienskies.core.internal.world.chunks.VsiTerrainUpdate;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u00ca\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\b\u0007\u0012\b\u0010\u0090\u0001\u001a\u00030\u008f\u0001\u00a2\u0006\u0006\b\u00ea\u0001\u0010\u00eb\u0001J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096\u0001\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u0096\u0001\u00a2\u0006\u0004\b\f\u0010\rJ \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0097\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013J*\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\"\u0004\b\u0000\u0010\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0097\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0019J@\u0010#\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u001aH\u0097\u0001\u00a2\u0006\u0004\b#\u0010$J(\u0010#\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020%H\u0097\u0001\u00a2\u0006\u0004\b#\u0010'J\u0010\u0010)\u001a\u00020(H\u0097\u0001\u00a2\u0006\u0004\b)\u0010*J0\u0010+\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u001aH\u0096\u0001\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010.\u001a\u00020-H\u0097\u0001\u00a2\u0006\u0004\b.\u0010/J \u00103\u001a\u0002022\u0006\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u000eH\u0096\u0001\u00a2\u0006\u0004\b3\u00104J \u00105\u001a\u0002022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0096\u0001\u00a2\u0006\u0004\b5\u00104J(\u00108\u001a\u0002072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0096\u0001\u00a2\u0006\u0004\b8\u00109J(\u0010;\u001a\u00020:2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0096\u0001\u00a2\u0006\u0004\b;\u0010<J0\u0010>\u001a\u0002072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u0011H\u0096\u0001\u00a2\u0006\u0004\b>\u0010?J\u0010\u0010A\u001a\u00020@H\u0096\u0001\u00a2\u0006\u0004\bA\u0010BJ\u0010\u0010D\u001a\u00020CH\u0096\u0001\u00a2\u0006\u0004\bD\u0010EJ\u0018\u0010D\u001a\u00020C2\u0006\u0010G\u001a\u00020FH\u0096\u0001\u00a2\u0006\u0004\bD\u0010HJ \u0010K\u001a\u00020C2\u0006\u0010I\u001a\u00020F2\u0006\u0010J\u001a\u00020FH\u0096\u0001\u00a2\u0006\u0004\bK\u0010LJ(\u0010S\u001a\u00020R2\u0006\u0010M\u001a\u00020\u001a2\u0006\u0010O\u001a\u00020N2\u0006\u0010Q\u001a\u00020PH\u0096\u0001\u00a2\u0006\u0004\bS\u0010TJT\u0010_\u001a\u00020^2\u0006\u0010U\u001a\u00020\u001a2\u0006\u0010V\u001a\u00020\u001e2\u0006\u0010W\u001a\u00020\u001a2\u0006\u0010X\u001a\u00020\u001a2\u000e\u0010[\u001a\n\u0018\u00010Yj\u0004\u0018\u0001`Z2\b\u0010\\\u001a\u0004\u0018\u00010N2\b\u0010]\u001a\u0004\u0018\u00010\u001aH\u0096\u0001\u00a2\u0006\u0004\b_\u0010`J0\u0010f\u001a\u00020e2\u0006\u0010a\u001a\u00020\u001a2\u0006\u0010b\u001a\u00020\u001a2\u0006\u0010c\u001a\u00020\u001e2\u0006\u0010d\u001a\u00020\u001aH\u0096\u0001\u00a2\u0006\u0004\bf\u0010gJ\u0010\u0010i\u001a\u00020hH\u0096\u0001\u00a2\u0006\u0004\bi\u0010jJ\u0010\u0010l\u001a\u00020kH\u0096\u0001\u00a2\u0006\u0004\bl\u0010mJ(\u0010n\u001a\u00020:2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0096\u0001\u00a2\u0006\u0004\bn\u0010<J\u0011\u0010p\u001a\u0004\u0018\u00010oH\u0000\u00a2\u0006\u0004\bp\u0010qJ$\u0010r\u001a\u00020\b\"\u0004\b\u0000\u0010\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0097\u0001\u00a2\u0006\u0004\br\u0010sJC\u0010r\u001a\u00020\b\"\u0004\b\u0000\u0010\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\u001d\u0010v\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0017\u0012\u0004\u0012\u00020\b0t\u00a2\u0006\u0002\buH\u0097\u0001\u00a2\u0006\u0004\br\u0010wJ$\u0010r\u001a\u00020\b\"\u0004\b\u0000\u0010\u00142\f\u0010y\u001a\b\u0012\u0004\u0012\u00028\u00000xH\u0097\u0001\u00a2\u0006\u0004\br\u0010zJ\u0018\u0010|\u001a\u00020\b2\u0006\u0010{\u001a\u00020YH\u0097\u0001\u00a2\u0006\u0004\b|\u0010}J\"\u0010\u0081\u0001\u001a\u00020\b2\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u007f0~H\u0096\u0001\u00a2\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J%\u0010\u0085\u0001\u001a\u00020\b2\u0007\u0010\u0083\u0001\u001a\u00020\u00062\u0007\u0010\u0084\u0001\u001a\u00020YH\u0096\u0001\u00a2\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J,\u0010\u0087\u0001\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0007\u0010\u0083\u0001\u001a\u00020\u00062\u0006\u0010\\\u001a\u00020NH\u0096\u0001\u00a2\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u001c\u0010\u008a\u0001\u001a\u00020F2\u0007\u0010\u0089\u0001\u001a\u00020CH\u0096\u0001\u00a2\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J-\u0010\u008d\u0001\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0007\u0010\u0083\u0001\u001a\u00020\u00062\u0007\u0010\u008c\u0001\u001a\u00020^H\u0096\u0001\u00a2\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0018\u0010\u0090\u0001\u001a\u00030\u008f\u00018\u0002X\u0083\u0004\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0018\u0010\u0095\u0001\u001a\u00030\u0092\u00018\u0017X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R!\u0010\u009a\u0001\u001a\u00020\u00118\u0017@\u0017X\u0096\u000f\u00a2\u0006\u0010\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001f\u0010\u009f\u0001\u001a\n\u0012\u0005\u0012\u00030\u009c\u00010\u009b\u00018\u0017X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R\u001f\u0010\u00a1\u0001\u001a\n\u0012\u0005\u0012\u00030\u009c\u00010\u009b\u00018\u0017X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u00a0\u0001\u0010\u009e\u0001R\u001f\u0010\u00a3\u0001\u001a\n\u0012\u0005\u0012\u00030\u009c\u00010\u009b\u00018\u0017X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u00a2\u0001\u0010\u009e\u0001R\u0018\u0010\u00a7\u0001\u001a\u00030\u00a4\u00018\u0017X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u00a5\u0001\u0010\u00a6\u0001R\u0018\u0010\u00ab\u0001\u001a\u00030\u00a8\u00018\u0017X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u00a9\u0001\u0010\u00aa\u0001R\u0018\u0010\u00af\u0001\u001a\u00030\u00ac\u00018\u0017X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u00ad\u0001\u0010\u00ae\u0001R\u0018\u0010\u00b3\u0001\u001a\u00030\u00b0\u00018\u0017X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u00b1\u0001\u0010\u00b2\u0001R\u0018\u0010\u00b7\u0001\u001a\u00030\u00b4\u00018\u0017X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u00b5\u0001\u0010\u00b6\u0001R\u0018\u0010\u00bb\u0001\u001a\u00030\u00b8\u00018\u0017X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u00b9\u0001\u0010\u00ba\u0001R\u001f\u0010\u00be\u0001\u001a\n\u0012\u0005\u0012\u00030\u00bc\u00010\u009b\u00018\u0017X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u00bd\u0001\u0010\u009e\u0001R\u0018\u0010\u00c2\u0001\u001a\u00030\u00bf\u00018\u0017X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u00c0\u0001\u0010\u00c1\u0001R\u001f\u0010\u00c5\u0001\u001a\n\u0012\u0005\u0012\u00030\u00c3\u00010\u009b\u00018\u0017X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u00c4\u0001\u0010\u009e\u0001R\u0018\u0010\u00c9\u0001\u001a\u00030\u00c6\u00018\u0017X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u00c7\u0001\u0010\u00c8\u0001R\u001f\u0010\u00ce\u0001\u001a\n\u0012\u0005\u0012\u00030\u00cb\u00010\u00ca\u00018\u0017X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u00cc\u0001\u0010\u00cd\u0001R\u001f\u0010\u00d1\u0001\u001a\n\u0012\u0005\u0012\u00030\u00cf\u00010\u00ca\u00018\u0017X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u00d0\u0001\u0010\u00cd\u0001R\u001f\u0010\u00d4\u0001\u001a\n\u0012\u0005\u0012\u00030\u00d2\u00010\u00ca\u00018\u0017X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u00d3\u0001\u0010\u00cd\u0001R\u0018\u0010\u00d8\u0001\u001a\u00030\u00d5\u00018\u0017X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u00d6\u0001\u0010\u00d7\u0001R\u0018\u0010\u00dc\u0001\u001a\u00030\u00d9\u00018\u0017X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u00da\u0001\u0010\u00db\u0001R\u001f\u0010\u00df\u0001\u001a\n\u0012\u0005\u0012\u00030\u00dd\u00010\u009b\u00018\u0017X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u00de\u0001\u0010\u009e\u0001R\u001f\u0010\u00e2\u0001\u001a\n\u0012\u0005\u0012\u00030\u00e0\u00010\u00ca\u00018\u0017X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u00e1\u0001\u0010\u00cd\u0001R\u001f\u0010\u00e5\u0001\u001a\n\u0012\u0005\u0012\u00030\u00e3\u00010\u00ca\u00018\u0017X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u00e4\u0001\u0010\u00cd\u0001R\u0018\u0010\u00e9\u0001\u001a\u00030\u00e6\u00018\u0017X\u0096\u0005\u00a2\u0006\b\u001a\u0006\b\u00e7\u0001\u0010\u00e8\u0001"}, d2={"Lorg/valkyrienskies/core/impl/program/VSCoreServerImpl;", "Lorg/valkyrienskies/core/impl/program/VSCoreInternal;", "Lorg/valkyrienskies/core/internal/VsiCoreServer;", "Lorg/valkyrienskies/core/api/world/ServerShipWorld;", "world", "", "Lorg/valkyrienskies/core/api/ships/ServerShip;", "ships", "", "deleteShips", "(Lorg/valkyrienskies/core/api/world/ServerShipWorld;Ljava/util/List;)V", "Lorg/valkyrienskies/core/internal/config/VsiConfigModel;", "getServerConfig", "()Lorg/valkyrienskies/core/internal/config/VsiConfigModel;", "", "chunkX", "chunkZ", "", "isChunkInShipyard", "(II)Z", "T", "Ljava/lang/Class;", "attachmentClass", "Lorg/valkyrienskies/core/api/attachment/AttachmentRegistration$Builder;", "newAttachmentRegistrationBuilder", "(Ljava/lang/Class;)Lorg/valkyrienskies/core/api/attachment/AttachmentRegistration$Builder;", "Lorg/joml/Vector3dc;", "velocity", "angularVelocity", "position", "Lorg/joml/Quaterniondc;", "rotation", "scaling", "positionInModel", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "newBodyKinematics", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "transform", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;)Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics$Builder;", "newBodyKinematicsBuilder", "()Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics$Builder;", "newBodyTransform", "(Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Builder;", "newBodyTransformBuilder", "()Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Builder;", "claimX", "claimZ", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "newChunkClaim", "(II)Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "newChunkClaimFromChunkPos", "chunkY", "Lorg/valkyrienskies/core/internal/world/chunks/VsiTerrainUpdate;", "newDeleteTerrainUpdate", "(III)Lorg/valkyrienskies/core/internal/world/chunks/VsiTerrainUpdate;", "Lorg/valkyrienskies/core/internal/world/chunks/VsiTerrainUpdate$Builder;", "newDenseTerrainUpdateBuilder", "(III)Lorg/valkyrienskies/core/internal/world/chunks/VsiTerrainUpdate$Builder;", "overwrite", "newEmptyVoxelShapeUpdate", "(IIIZ)Lorg/valkyrienskies/core/internal/world/chunks/VsiTerrainUpdate;", "Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState$Builder;", "newLiquidStateBuilder", "()Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState$Builder;", "Lorg/valkyrienskies/core/internal/world/VsiPipeline;", "newPipeline", "()Lorg/valkyrienskies/core/internal/world/VsiPipeline;", "", "data", "([B)Lorg/valkyrienskies/core/internal/world/VsiPipeline;", "queryableShipDataBytes", "chunkAllocatorBytes", "newPipelineLegacyData", "([B[B)Lorg/valkyrienskies/core/internal/world/VsiPipeline;", "centerOfMassInShip", "", "mass", "Lorg/joml/Matrix3dc;", "momentOfInertiaTensor", "Lorg/valkyrienskies/core/api/ships/properties/ShipInertiaData;", "newShipInertiaData", "(Lorg/joml/Vector3dc;DLorg/joml/Matrix3dc;)Lorg/valkyrienskies/core/api/ships/properties/ShipInertiaData;", "newPos", "newRot", "newVel", "newOmega", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "newDimension", "newScale", "newPosInShip", "Lorg/valkyrienskies/core/internal/ShipTeleportData;", "newShipTeleportData", "(Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Ljava/lang/String;Ljava/lang/Double;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/internal/ShipTeleportData;", "positionInWorld", "positionInShip", "shipToWorldRotation", "shipToWorldScaling", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "newShipTransform", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "Lorg/valkyrienskies/core/api/physics/blockstates/BoxesBlockShape$Builder;", "newSolidStateBoxesShapeBuilder", "()Lorg/valkyrienskies/core/api/physics/blockstates/BoxesBlockShape$Builder;", "Lorg/valkyrienskies/core/api/physics/blockstates/SolidState$Builder;", "newSolidStateBuilder", "()Lorg/valkyrienskies/core/api/physics/blockstates/SolidState$Builder;", "newSparseTerrainUpdateBuilder", "Lorg/valkyrienskies/core/impl/shadow/FJ;", "newVSPhysicsPipelineStage$impl", "()Lorg/valkyrienskies/core/impl/shadow/FJ;", "registerAttachment", "(Ljava/lang/Class;)V", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "registrationBuilder", "(Ljava/lang/Class;Lkotlin/jvm/functions/Function1;)V", "Lorg/valkyrienskies/core/api/attachment/AttachmentRegistration;", "registration", "(Lorg/valkyrienskies/core/api/attachment/AttachmentRegistration;)V", "attachmentKey", "registerAttachmentForRemoval", "(Ljava/lang/String;)V", "", "Lorg/valkyrienskies/core/internal/physics/blockstates/VsiBlockState;", "states", "registerBlockStates", "(Ljava/lang/Iterable;)V", "ship", "newName", "renameShip", "(Lorg/valkyrienskies/core/api/ships/ServerShip;Ljava/lang/String;)V", "scaleShip", "(Lorg/valkyrienskies/core/api/world/ServerShipWorld;Lorg/valkyrienskies/core/api/ships/ServerShip;D)V", "pipeline", "serializePipeline", "(Lorg/valkyrienskies/core/internal/world/VsiPipeline;)[B", "teleportData", "teleportShip", "(Lorg/valkyrienskies/core/api/world/ServerShipWorld;Lorg/valkyrienskies/core/api/ships/ServerShip;Lorg/valkyrienskies/core/internal/ShipTeleportData;)V", "Lorg/valkyrienskies/core/impl/program/VSCoreImpl;", "base", "Lorg/valkyrienskies/core/impl/program/VSCoreImpl;", "Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockTypes;", "getBlockTypes", "()Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockTypes;", "blockTypes", "getClientUsesUDP", "()Z", "setClientUsesUDP", "(Z)V", "clientUsesUDP", "Lorg/valkyrienskies/core/api/event/SingleEvent;", "Lorg/valkyrienskies/core/api/events/CollisionEvent;", "getCollisionEndEvent", "()Lorg/valkyrienskies/core/api/event/SingleEvent;", "collisionEndEvent", "getCollisionPersistEvent", "collisionPersistEvent", "getCollisionStartEvent", "collisionStartEvent", "Lorg/valkyrienskies/core/impl/shadow/Fj;", "getConfigurator", "()Lorg/valkyrienskies/core/impl/shadow/Fj;", "configurator", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "getDefaultMapper", "()Lcom/fasterxml/jackson/databind/ObjectMapper;", "defaultMapper", "Lorg/valkyrienskies/core/internal/world/VsiClientShipWorld;", "getDummyShipWorldClient", "()Lorg/valkyrienskies/core/internal/world/VsiClientShipWorld;", "dummyShipWorldClient", "Lorg/valkyrienskies/core/internal/world/VsiServerShipWorld;", "getDummyShipWorldServer", "()Lorg/valkyrienskies/core/internal/world/VsiServerShipWorld;", "dummyShipWorldServer", "Lorg/valkyrienskies/core/internal/collision/VsiEntityPolygonCollider;", "getEntityPolygonCollider", "()Lorg/valkyrienskies/core/internal/collision/VsiEntityPolygonCollider;", "entityPolygonCollider", "Lorg/valkyrienskies/core/impl/shadow/EU;", "getHooks", "()Lorg/valkyrienskies/core/impl/shadow/EU;", "hooks", "Lorg/valkyrienskies/core/api/events/MergeEvent;", "getMergeEvent", "mergeEvent", "Lorg/valkyrienskies/core/impl/shadow/Fi;", "getNetworking", "()Lorg/valkyrienskies/core/impl/shadow/Fi;", "networking", "Lorg/valkyrienskies/core/api/events/PhysTickEvent;", "getPhysTickEvent", "physTickEvent", "Lorg/valkyrienskies/core/impl/shadow/FL$a;", "getPipelineComponentFactory", "()Lorg/valkyrienskies/core/impl/shadow/FL$a;", "pipelineComponentFactory", "Lorg/valkyrienskies/core/api/event/ListenableEvent;", "Lorg/valkyrienskies/core/api/events/ShipLoadEvent;", "getShipLoadEvent", "()Lorg/valkyrienskies/core/api/event/ListenableEvent;", "shipLoadEvent", "Lorg/valkyrienskies/core/api/events/ShipLoadEventClient;", "getShipLoadEventClient", "shipLoadEventClient", "Lorg/valkyrienskies/core/api/events/ShipUnloadEventClient;", "getShipUnloadEventClient", "shipUnloadEventClient", "Lorg/valkyrienskies/core/impl/networking/simple/SimplePacketNetworking;", "getSimplePacketNetworking", "()Lorg/valkyrienskies/core/impl/networking/simple/SimplePacketNetworking;", "simplePacketNetworking", "Lorg/valkyrienskies/core/internal/collision/VsiSolidShapeUtils;", "getSolidShapeUtils", "()Lorg/valkyrienskies/core/internal/collision/VsiSolidShapeUtils;", "solidShapeUtils", "Lorg/valkyrienskies/core/api/events/SplitEvent;", "getSplitEvent", "splitEvent", "Lorg/valkyrienskies/core/api/events/StartUpdateRenderTransformsEvent;", "getStartUpdateRenderTransformsEvent", "startUpdateRenderTransformsEvent", "Lorg/valkyrienskies/core/api/events/TickEndEvent;", "getTickEndEvent", "tickEndEvent", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Factory;", "getTransformFactory", "()Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Factory;", "transformFactory", "<init>", "(Lorg/valkyrienskies/core/impl/program/VSCoreImpl;)V"})
public final class VSCoreServerImpl
implements VSCoreInternal,
VsiCoreServer {
    private final VSCoreImpl base;

    /*
     * WARNING - void declaration
     */
    @Inject
    public VSCoreServerImpl(VSCoreImpl base) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)base, (String)"");
        this.base = var1_1;
    }

    @Override
    @JvmName(name="getBlockTypes")
    public final VsiBlockTypes getBlockTypes() {
        return this.base.getBlockTypes();
    }

    @Override
    @JvmName(name="getClientUsesUDP")
    public final boolean getClientUsesUDP() {
        return this.base.getClientUsesUDP();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setClientUsesUDP")
    public final void setClientUsesUDP(boolean bl) {
        void var1_1;
        this.base.setClientUsesUDP((boolean)var1_1);
    }

    @Override
    @JvmName(name="getCollisionEndEvent")
    public final SingleEvent<CollisionEvent> getCollisionEndEvent() {
        return this.base.getCollisionEndEvent();
    }

    @Override
    @JvmName(name="getCollisionPersistEvent")
    public final SingleEvent<CollisionEvent> getCollisionPersistEvent() {
        return this.base.getCollisionPersistEvent();
    }

    @Override
    @JvmName(name="getCollisionStartEvent")
    public final SingleEvent<CollisionEvent> getCollisionStartEvent() {
        return this.base.getCollisionStartEvent();
    }

    @Override
    @JvmName(name="getConfigurator")
    public final fj_0 getConfigurator() {
        return this.base.getConfigurator();
    }

    @Override
    @JvmName(name="getDefaultMapper")
    public final ObjectMapper getDefaultMapper() {
        return this.base.getDefaultMapper();
    }

    @Override
    @JvmName(name="getDummyShipWorldClient")
    public final VsiClientShipWorld getDummyShipWorldClient() {
        return this.base.getDummyShipWorldClient();
    }

    @Override
    @JvmName(name="getDummyShipWorldServer")
    public final VsiServerShipWorld getDummyShipWorldServer() {
        return this.base.getDummyShipWorldServer();
    }

    @Override
    @JvmName(name="getEntityPolygonCollider")
    public final VsiEntityPolygonCollider getEntityPolygonCollider() {
        return this.base.getEntityPolygonCollider();
    }

    @Override
    @JvmName(name="getHooks")
    public final EU getHooks() {
        return this.base.getHooks();
    }

    @Override
    @JvmName(name="getMergeEvent")
    public final SingleEvent<MergeEvent> getMergeEvent() {
        return this.base.getMergeEvent();
    }

    @Override
    @JvmName(name="getNetworking")
    public final fi_0 getNetworking() {
        return this.base.getNetworking();
    }

    @Override
    @JvmName(name="getPhysTickEvent")
    public final SingleEvent<PhysTickEvent> getPhysTickEvent() {
        return this.base.getPhysTickEvent();
    }

    @Override
    @JvmName(name="getPipelineComponentFactory")
    public final FL.a getPipelineComponentFactory() {
        return this.base.getPipelineComponentFactory();
    }

    @Override
    @JvmName(name="getShipLoadEvent")
    public final ListenableEvent<ShipLoadEvent> getShipLoadEvent() {
        return this.base.getShipLoadEvent();
    }

    @Override
    @JvmName(name="getShipLoadEventClient")
    public final ListenableEvent<ShipLoadEventClient> getShipLoadEventClient() {
        return this.base.getShipLoadEventClient();
    }

    @Override
    @JvmName(name="getShipUnloadEventClient")
    public final ListenableEvent<ShipUnloadEventClient> getShipUnloadEventClient() {
        return this.base.getShipUnloadEventClient();
    }

    @Override
    @JvmName(name="getSimplePacketNetworking")
    public final SimplePacketNetworking getSimplePacketNetworking() {
        return this.base.getSimplePacketNetworking();
    }

    @Override
    @JvmName(name="getSolidShapeUtils")
    public final VsiSolidShapeUtils getSolidShapeUtils() {
        return this.base.getSolidShapeUtils();
    }

    @Override
    @JvmName(name="getSplitEvent")
    public final SingleEvent<SplitEvent> getSplitEvent() {
        return this.base.getSplitEvent();
    }

    @Override
    @JvmName(name="getStartUpdateRenderTransformsEvent")
    public final ListenableEvent<StartUpdateRenderTransformsEvent> getStartUpdateRenderTransformsEvent() {
        return this.base.getStartUpdateRenderTransformsEvent();
    }

    @Override
    @JvmName(name="getTickEndEvent")
    public final ListenableEvent<TickEndEvent> getTickEndEvent() {
        return this.base.getTickEndEvent();
    }

    @Override
    @JvmName(name="getTransformFactory")
    public final BodyTransform.Factory getTransformFactory() {
        return this.base.getTransformFactory();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void deleteShips(ServerShipWorld world, List<? extends ServerShip> ships) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)world, (String)"");
        Intrinsics.checkNotNullParameter(ships, (String)"");
        this.base.deleteShips((ServerShipWorld)var1_1, (List<? extends ServerShip>)var2_2);
    }

    @Override
    public final VsiConfigModel getServerConfig() {
        return this.base.getServerConfig();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Deprecated(message="This method isn't tied to a world, which is bad if we want to have different chunk allocation strategies per world in the future.", replaceWith=@ReplaceWith(expression="ShipWorld.isChunkInShipyard(chunkX, chunkZ, DimensionId)", imports={}))
    public final boolean isChunkInShipyard(int chunkX, int chunkZ) {
        void var2_2;
        void var1_1;
        return this.base.isChunkInShipyard((int)var1_1, (int)var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @VsBeta
    public final <T> AttachmentRegistration.Builder<T> newAttachmentRegistrationBuilder(Class<T> attachmentClass) {
        void var1_1;
        Intrinsics.checkNotNullParameter(attachmentClass, (String)"");
        return this.base.newAttachmentRegistrationBuilder(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @VsBeta
    public final BodyKinematics newBodyKinematics(Vector3dc velocity, Vector3dc angularVelocity, Vector3dc position, Quaterniondc rotation, Vector3dc scaling, Vector3dc positionInModel) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)velocity, (String)"");
        Intrinsics.checkNotNullParameter((Object)angularVelocity, (String)"");
        Intrinsics.checkNotNullParameter((Object)position, (String)"");
        Intrinsics.checkNotNullParameter((Object)rotation, (String)"");
        Intrinsics.checkNotNullParameter((Object)scaling, (String)"");
        Intrinsics.checkNotNullParameter((Object)positionInModel, (String)"");
        return this.base.newBodyKinematics((Vector3dc)var1_1, (Vector3dc)var2_2, (Vector3dc)var3_3, rotation, scaling, positionInModel);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @VsBeta
    public final BodyKinematics newBodyKinematics(Vector3dc velocity, Vector3dc angularVelocity, BodyTransform transform2) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)velocity, (String)"");
        Intrinsics.checkNotNullParameter((Object)angularVelocity, (String)"");
        Intrinsics.checkNotNullParameter((Object)transform2, (String)"");
        return this.base.newBodyKinematics((Vector3dc)var1_1, (Vector3dc)var2_2, (BodyTransform)var3_3);
    }

    @Override
    @VsBeta
    public final BodyKinematics.Builder newBodyKinematicsBuilder() {
        return this.base.newBodyKinematicsBuilder();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final BodyTransform newBodyTransform(Vector3dc position, Quaterniondc rotation, Vector3dc scaling, Vector3dc positionInModel) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)position, (String)"");
        Intrinsics.checkNotNullParameter((Object)rotation, (String)"");
        Intrinsics.checkNotNullParameter((Object)scaling, (String)"");
        Intrinsics.checkNotNullParameter((Object)positionInModel, (String)"");
        return this.base.newBodyTransform((Vector3dc)var1_1, (Quaterniondc)var2_2, (Vector3dc)var3_3, positionInModel);
    }

    @Override
    @VsBeta
    public final BodyTransform.Builder newBodyTransformBuilder() {
        return this.base.newBodyTransformBuilder();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final ChunkClaim newChunkClaim(int claimX, int claimZ) {
        void var2_2;
        void var1_1;
        return this.base.newChunkClaim((int)var1_1, (int)var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final ChunkClaim newChunkClaimFromChunkPos(int chunkX, int chunkZ) {
        void var2_2;
        void var1_1;
        return this.base.newChunkClaimFromChunkPos((int)var1_1, (int)var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final VsiTerrainUpdate newDeleteTerrainUpdate(int chunkX, int chunkY, int chunkZ) {
        void var3_3;
        void var2_2;
        void var1_1;
        return this.base.newDeleteTerrainUpdate((int)var1_1, (int)var2_2, (int)var3_3);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final VsiTerrainUpdate.Builder newDenseTerrainUpdateBuilder(int chunkX, int chunkY, int chunkZ) {
        void var3_3;
        void var2_2;
        void var1_1;
        return this.base.newDenseTerrainUpdateBuilder((int)var1_1, (int)var2_2, (int)var3_3);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final VsiTerrainUpdate newEmptyVoxelShapeUpdate(int chunkX, int chunkY, int chunkZ, boolean overwrite) {
        void var3_3;
        void var2_2;
        void var1_1;
        return this.base.newEmptyVoxelShapeUpdate((int)var1_1, (int)var2_2, (int)var3_3, overwrite);
    }

    @Override
    public final LiquidState.Builder newLiquidStateBuilder() {
        return this.base.newLiquidStateBuilder();
    }

    @Override
    public final VsiPipeline newPipeline() {
        return this.base.newPipeline();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final VsiPipeline newPipeline(byte[] data) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)data, (String)"");
        return this.base.newPipeline((byte[])var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final VsiPipeline newPipelineLegacyData(byte[] queryableShipDataBytes, byte[] chunkAllocatorBytes) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)queryableShipDataBytes, (String)"");
        Intrinsics.checkNotNullParameter((Object)chunkAllocatorBytes, (String)"");
        return this.base.newPipelineLegacyData((byte[])var1_1, (byte[])var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final ShipInertiaData newShipInertiaData(Vector3dc centerOfMassInShip, double mass, Matrix3dc momentOfInertiaTensor) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)centerOfMassInShip, (String)"");
        Intrinsics.checkNotNullParameter((Object)momentOfInertiaTensor, (String)"");
        return this.base.newShipInertiaData((Vector3dc)var1_1, (double)var2_2, momentOfInertiaTensor);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final ShipTeleportData newShipTeleportData(Vector3dc newPos, Quaterniondc newRot, Vector3dc newVel, Vector3dc newOmega, String newDimension, Double newScale, Vector3dc newPosInShip) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)newPos, (String)"");
        Intrinsics.checkNotNullParameter((Object)newRot, (String)"");
        Intrinsics.checkNotNullParameter((Object)newVel, (String)"");
        Intrinsics.checkNotNullParameter((Object)newOmega, (String)"");
        return this.base.newShipTeleportData((Vector3dc)var1_1, (Quaterniondc)var2_2, (Vector3dc)var3_3, newOmega, newDimension, newScale, newPosInShip);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final ShipTransform newShipTransform(Vector3dc positionInWorld, Vector3dc positionInShip, Quaterniondc shipToWorldRotation, Vector3dc shipToWorldScaling) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)positionInWorld, (String)"");
        Intrinsics.checkNotNullParameter((Object)positionInShip, (String)"");
        Intrinsics.checkNotNullParameter((Object)shipToWorldRotation, (String)"");
        Intrinsics.checkNotNullParameter((Object)shipToWorldScaling, (String)"");
        return this.base.newShipTransform((Vector3dc)var1_1, (Vector3dc)var2_2, (Quaterniondc)var3_3, shipToWorldScaling);
    }

    @Override
    public final BoxesBlockShape.Builder newSolidStateBoxesShapeBuilder() {
        return this.base.newSolidStateBoxesShapeBuilder();
    }

    @Override
    public final SolidState.Builder newSolidStateBuilder() {
        return this.base.newSolidStateBuilder();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final VsiTerrainUpdate.Builder newSparseTerrainUpdateBuilder(int chunkX, int chunkY, int chunkZ) {
        void var3_3;
        void var2_2;
        void var1_1;
        return this.base.newSparseTerrainUpdateBuilder((int)var1_1, (int)var2_2, (int)var3_3);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @VsBeta
    public final <T> void registerAttachment(Class<T> attachmentClass) {
        void var1_1;
        Intrinsics.checkNotNullParameter(attachmentClass, (String)"");
        this.base.registerAttachment(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @VsBeta
    public final <T> void registerAttachment(Class<T> attachmentClass, Function1<? super AttachmentRegistration.Builder<T>, Unit> registrationBuilder) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter(attachmentClass, (String)"");
        Intrinsics.checkNotNullParameter(registrationBuilder, (String)"");
        this.base.registerAttachment(var1_1, var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @VsBeta
    public final <T> void registerAttachment(AttachmentRegistration<T> registration) {
        void var1_1;
        Intrinsics.checkNotNullParameter(registration, (String)"");
        this.base.registerAttachment(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @VsBeta
    public final void registerAttachmentForRemoval(String attachmentKey) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)attachmentKey, (String)"");
        this.base.registerAttachmentForRemoval((String)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void registerBlockStates(Iterable<VsiBlockState> states) {
        void var1_1;
        Intrinsics.checkNotNullParameter(states, (String)"");
        this.base.registerBlockStates((Iterable<VsiBlockState>)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void renameShip(ServerShip ship, String newName) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)ship, (String)"");
        Intrinsics.checkNotNullParameter((Object)newName, (String)"");
        this.base.renameShip((ServerShip)var1_1, (String)var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void scaleShip(ServerShipWorld world, ServerShip ship, double newScale) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)world, (String)"");
        Intrinsics.checkNotNullParameter((Object)ship, (String)"");
        this.base.scaleShip((ServerShipWorld)var1_1, (ServerShip)var2_2, (double)var3_3);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final byte[] serializePipeline(VsiPipeline pipeline) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)pipeline, (String)"");
        return this.base.serializePipeline((VsiPipeline)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void teleportShip(ServerShipWorld world, ServerShip ship, ShipTeleportData teleportData) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)world, (String)"");
        Intrinsics.checkNotNullParameter((Object)ship, (String)"");
        Intrinsics.checkNotNullParameter((Object)teleportData, (String)"");
        this.base.teleportShip((ServerShipWorld)var1_1, (ServerShip)var2_2, (ShipTeleportData)var3_3);
    }

    public final FJ newVSPhysicsPipelineStage$impl() {
        return this.base.newVSPhysicsPipelineStage$impl();
    }
}

