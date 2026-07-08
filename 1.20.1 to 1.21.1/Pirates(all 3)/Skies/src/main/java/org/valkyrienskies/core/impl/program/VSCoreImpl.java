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
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference0
 *  kotlin.jvm.internal.MutablePropertyReference0Impl
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KProperty
 *  org.valkyrienskies.core.impl.shadow.Fi
 */
package org.valkyrienskies.core.impl.program;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.apache.logging.log4j.Logger;
import org.joml.Matrix3d;
import org.joml.Matrix3dc;
import org.joml.Quaterniondc;
import org.joml.Vector3d;
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
import org.valkyrienskies.core.impl.api_impl.config.VsiConfigModelImpl;
import org.valkyrienskies.core.impl.bodies.properties.BodyKinematicsFactory;
import org.valkyrienskies.core.impl.bodies.properties.BodyTransformFactory;
import org.valkyrienskies.core.impl.config.VSCoreConfig;
import org.valkyrienskies.core.impl.game.ChunkClaimImpl;
import org.valkyrienskies.core.impl.game.ShipTeleportDataImpl;
import org.valkyrienskies.core.impl.game.ships.ShipInertiaDataImpl;
import org.valkyrienskies.core.impl.game.ships.ShipTransformImpl;
import org.valkyrienskies.core.impl.game.ships.serialization.vspipeline.VSPipelineSerializer;
import org.valkyrienskies.core.impl.hooks.VSEvents;
import org.valkyrienskies.core.impl.networking.simple.SimplePacketNetworking;
import org.valkyrienskies.core.impl.program.VSCoreImpl;
import org.valkyrienskies.core.impl.program.VSCoreInternal;
import org.valkyrienskies.core.impl.shadow.CF;
import org.valkyrienskies.core.impl.shadow.CH;
import org.valkyrienskies.core.impl.shadow.CP;
import org.valkyrienskies.core.impl.shadow.DN;
import org.valkyrienskies.core.impl.shadow.DS;
import org.valkyrienskies.core.impl.shadow.EG;
import org.valkyrienskies.core.impl.shadow.EQ;
import org.valkyrienskies.core.impl.shadow.ES;
import org.valkyrienskies.core.impl.shadow.ET;
import org.valkyrienskies.core.impl.shadow.EU;
import org.valkyrienskies.core.impl.shadow.EY;
import org.valkyrienskies.core.impl.shadow.FJ;
import org.valkyrienskies.core.impl.shadow.FL;
import org.valkyrienskies.core.impl.shadow.FM;
import org.valkyrienskies.core.impl.shadow.FX;
import org.valkyrienskies.core.impl.shadow.Fi;
import org.valkyrienskies.core.impl.shadow.It;
import org.valkyrienskies.core.impl.shadow.dk_0;
import org.valkyrienskies.core.impl.shadow.eh_0;
import org.valkyrienskies.core.impl.shadow.ei_0;
import org.valkyrienskies.core.impl.shadow.ej_0;
import org.valkyrienskies.core.impl.shadow.ew_0;
import org.valkyrienskies.core.impl.shadow.fi_0;
import org.valkyrienskies.core.impl.shadow.fj_0;
import org.valkyrienskies.core.impl.shadow.ii_0;
import org.valkyrienskies.core.impl.shadow.ik_0;
import org.valkyrienskies.core.impl.util.serialization.VSJacksonUtil;
import org.valkyrienskies.core.internal.ShipTeleportData;
import org.valkyrienskies.core.internal.VsiCoreCommands;
import org.valkyrienskies.core.internal.collision.VsiEntityPolygonCollider;
import org.valkyrienskies.core.internal.collision.VsiSolidShapeUtils;
import org.valkyrienskies.core.internal.config.VsiConfigModel;
import org.valkyrienskies.core.internal.physics.blockstates.VsiBlockState;
import org.valkyrienskies.core.internal.world.VsiClientShipWorld;
import org.valkyrienskies.core.internal.world.VsiPipeline;
import org.valkyrienskies.core.internal.world.VsiServerShipWorld;
import org.valkyrienskies.core.internal.world.chunks.VsiTerrainUpdate;
import org.valkyrienskies.core.util.events.EventEmitterImpl;

@Singleton
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u00f2\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u0092\u00022\u00020\u00012\u00020\u0002:\u0002\u0092\u0002B\u009d\u0001\b\u0007\u0012\b\u0010\u00d4\u0001\u001a\u00030\u00d3\u0001\u0012\b\u0010\u00cb\u0001\u001a\u00030\u00ca\u0001\u0012\b\u0010\u00b6\u0001\u001a\u00030\u00b5\u0001\u0012\b\u0010\u008f\u0002\u001a\u00030\u008e\u0002\u0012\b\u0010\u00df\u0001\u001a\u00030\u00de\u0001\u0012\b\u0010\u00e4\u0001\u001a\u00030\u00e3\u0001\u0012\b\u0010\u0099\u0001\u001a\u00030\u0098\u0001\u0012\b\u0010\u00f5\u0001\u001a\u00030\u00f4\u0001\u0012\b\u0010\u00fa\u0001\u001a\u00030\u00f9\u0001\u0012\r\u0010H\u001a\t\u0012\u0004\u0012\u00020G0\u00d7\u0001\u0012\r\u0010r\u001a\t\u0012\u0004\u0012\u00020q0\u00d7\u0001\u0012\u000e\u0010\u00d8\u0001\u001a\t\u0012\u0004\u0012\u00020n0\u00d7\u0001\u0012\b\u0010\u0096\u0001\u001a\u00030\u0095\u0001\u00a2\u0006\u0006\b\u0090\u0002\u0010\u0091\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0096\u0001\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e\"\u0004\b\u0000\u0010\u001b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0016\u00a2\u0006\u0004\b\u001f\u0010 J?\u0010*\u001a\u00020)2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020!H\u0017\u00a2\u0006\u0004\b*\u0010+J'\u0010*\u001a\u00020)2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010-\u001a\u00020,H\u0017\u00a2\u0006\u0004\b*\u0010.J\u000f\u00100\u001a\u00020/H\u0017\u00a2\u0006\u0004\b0\u00101J/\u00102\u001a\u00020,2\u0006\u0010$\u001a\u00020!2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020!H\u0016\u00a2\u0006\u0004\b2\u00103J\u000f\u00105\u001a\u000204H\u0017\u00a2\u0006\u0004\b5\u00106J\u001f\u0010:\u001a\u0002092\u0006\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u00020\u0015H\u0016\u00a2\u0006\u0004\b:\u0010;J\u001f\u0010<\u001a\u0002092\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016\u00a2\u0006\u0004\b<\u0010;J'\u0010?\u001a\u00020>2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016\u00a2\u0006\u0004\b?\u0010@J'\u0010B\u001a\u00020A2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016\u00a2\u0006\u0004\bB\u0010CJ/\u0010E\u001a\u00020>2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010D\u001a\u00020\u0018H\u0016\u00a2\u0006\u0004\bE\u0010FJ\u000f\u0010H\u001a\u00020GH\u0016\u00a2\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\bJ\u0010KJ\u0017\u0010J\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020LH\u0016\u00a2\u0006\u0004\bJ\u0010NJ\u001f\u0010Q\u001a\u00020\u000f2\u0006\u0010O\u001a\u00020L2\u0006\u0010P\u001a\u00020LH\u0016\u00a2\u0006\u0004\bQ\u0010RJ'\u0010Y\u001a\u00020X2\u0006\u0010S\u001a\u00020!2\u0006\u0010U\u001a\u00020T2\u0006\u0010W\u001a\u00020VH\u0016\u00a2\u0006\u0004\bY\u0010ZJS\u0010e\u001a\u00020d2\u0006\u0010[\u001a\u00020!2\u0006\u0010\\\u001a\u00020%2\u0006\u0010]\u001a\u00020!2\u0006\u0010^\u001a\u00020!2\u000e\u0010a\u001a\n\u0018\u00010_j\u0004\u0018\u0001``2\b\u0010b\u001a\u0004\u0018\u00010T2\b\u0010c\u001a\u0004\u0018\u00010!H\u0016\u00a2\u0006\u0004\be\u0010fJ/\u0010l\u001a\u00020k2\u0006\u0010g\u001a\u00020!2\u0006\u0010h\u001a\u00020!2\u0006\u0010i\u001a\u00020%2\u0006\u0010j\u001a\u00020!H\u0016\u00a2\u0006\u0004\bl\u0010mJ\u000f\u0010o\u001a\u00020nH\u0016\u00a2\u0006\u0004\bo\u0010pJ\u000f\u0010r\u001a\u00020qH\u0016\u00a2\u0006\u0004\br\u0010sJ'\u0010t\u001a\u00020A2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016\u00a2\u0006\u0004\bt\u0010CJ\u0011\u0010v\u001a\u0004\u0018\u00010uH\u0000\u00a2\u0006\u0004\bv\u0010wJB\u0010{\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u001b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c2\u001d\u0010z\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001e\u0012\u0004\u0012\u00020\u00030x\u00a2\u0006\u0002\byH\u0016\u00a2\u0006\u0004\b{\u0010|J#\u0010{\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u001b2\f\u0010~\u001a\b\u0012\u0004\u0012\u00028\u00000}H\u0016\u00a2\u0006\u0004\b{\u0010\u007fJ\u001b\u0010\u0081\u0001\u001a\u00020\u00032\u0007\u0010\u0080\u0001\u001a\u00020_H\u0016\u00a2\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J#\u0010\u0086\u0001\u001a\u00020\u00032\u000f\u0010\u0085\u0001\u001a\n\u0012\u0005\u0012\u00030\u0084\u00010\u0083\u0001H\u0016\u00a2\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J%\u0010\u008a\u0001\u001a\u00020\u00032\u0007\u0010\u0088\u0001\u001a\u00020\t2\u0007\u0010\u0089\u0001\u001a\u00020_H\u0096\u0001\u00a2\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J,\u0010\u008c\u0001\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0007\u0010\u0088\u0001\u001a\u00020\t2\u0006\u0010b\u001a\u00020TH\u0096\u0001\u00a2\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\u001c\u0010\u0090\u0001\u001a\u00020L2\b\u0010\u008f\u0001\u001a\u00030\u008e\u0001H\u0016\u00a2\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J-\u0010\u0093\u0001\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0007\u0010\u0088\u0001\u001a\u00020\t2\u0007\u0010\u0092\u0001\u001a\u00020dH\u0096\u0001\u00a2\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0018\u0010\u0096\u0001\u001a\u00030\u0095\u00018\u0002X\u0083\u0004\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R \u0010\u0099\u0001\u001a\u00030\u0098\u00018\u0017X\u0097\u0004\u00a2\u0006\u0010\n\u0006\b\u0099\u0001\u0010\u009a\u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001RB\u0010\u00a7\u0001\u001a\u00020\u00182\u0007\u0010\u009d\u0001\u001a\u00020\u00188W@WX\u0097\u008e\u0002\u00a2\u0006'\n\u0006\b\u009e\u0001\u0010\u009f\u0001\u0012\u0005\b\u00a4\u0001\u0010\u0005\u001a\u0006\b\u00a0\u0001\u0010\u00a1\u0001\"\u0006\b\u00a2\u0001\u0010\u00a3\u0001*\u0006\b\u00a5\u0001\u0010\u00a6\u0001R.\u0010\u00aa\u0001\u001a\n\u0012\u0005\u0012\u00030\u00a9\u00010\u00a8\u00018\u0017X\u0097\u0004\u00a2\u0006\u0017\n\u0006\b\u00aa\u0001\u0010\u00ab\u0001\u0012\u0005\b\u00ae\u0001\u0010\u0005\u001a\u0006\b\u00ac\u0001\u0010\u00ad\u0001R.\u0010\u00af\u0001\u001a\n\u0012\u0005\u0012\u00030\u00a9\u00010\u00a8\u00018\u0017X\u0097\u0004\u00a2\u0006\u0017\n\u0006\b\u00af\u0001\u0010\u00ab\u0001\u0012\u0005\b\u00b1\u0001\u0010\u0005\u001a\u0006\b\u00b0\u0001\u0010\u00ad\u0001R.\u0010\u00b2\u0001\u001a\n\u0012\u0005\u0012\u00030\u00a9\u00010\u00a8\u00018\u0017X\u0097\u0004\u00a2\u0006\u0017\n\u0006\b\u00b2\u0001\u0010\u00ab\u0001\u0012\u0005\b\u00b4\u0001\u0010\u0005\u001a\u0006\b\u00b3\u0001\u0010\u00ad\u0001R \u0010\u00b6\u0001\u001a\u00030\u00b5\u00018\u0017X\u0096\u0004\u00a2\u0006\u0010\n\u0006\b\u00b6\u0001\u0010\u00b7\u0001\u001a\u0006\b\u00b8\u0001\u0010\u00b9\u0001R\u0018\u0010\u00bd\u0001\u001a\u00030\u00ba\u00018WX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u00bb\u0001\u0010\u00bc\u0001R\u0018\u0010\u00c1\u0001\u001a\u00030\u00be\u00018WX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u00bf\u0001\u0010\u00c0\u0001R\u0018\u0010\u00c5\u0001\u001a\u00030\u00c2\u00018WX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u00c3\u0001\u0010\u00c4\u0001R\u0018\u0010\u00c9\u0001\u001a\u00030\u00c6\u00018WX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u00c7\u0001\u0010\u00c8\u0001R \u0010\u00cb\u0001\u001a\u00030\u00ca\u00018\u0017X\u0096\u0004\u00a2\u0006\u0010\n\u0006\b\u00cb\u0001\u0010\u00cc\u0001\u001a\u0006\b\u00cd\u0001\u0010\u00ce\u0001R.\u0010\u00d0\u0001\u001a\n\u0012\u0005\u0012\u00030\u00cf\u00010\u00a8\u00018\u0017X\u0097\u0004\u00a2\u0006\u0017\n\u0006\b\u00d0\u0001\u0010\u00ab\u0001\u0012\u0005\b\u00d2\u0001\u0010\u0005\u001a\u0006\b\u00d1\u0001\u0010\u00ad\u0001R \u0010\u00d4\u0001\u001a\u00030\u00d3\u00018\u0017X\u0096\u0004\u00a2\u0006\u0010\n\u0006\b\u00d4\u0001\u0010\u009f\u0001\u001a\u0006\b\u00d5\u0001\u0010\u00d6\u0001R\u001e\u0010\u00d8\u0001\u001a\t\u0012\u0004\u0012\u00020n0\u00d7\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d8\u0001\u0010\u00d9\u0001R\u001c\u0010H\u001a\t\u0012\u0004\u0012\u00020G0\u00d7\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bH\u0010\u00d9\u0001R\u001c\u0010r\u001a\t\u0012\u0004\u0012\u00020q0\u00d7\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\br\u0010\u00d9\u0001R.\u0010\u00db\u0001\u001a\n\u0012\u0005\u0012\u00030\u00da\u00010\u00a8\u00018\u0017X\u0097\u0004\u00a2\u0006\u0017\n\u0006\b\u00db\u0001\u0010\u00ab\u0001\u0012\u0005\b\u00dd\u0001\u0010\u0005\u001a\u0006\b\u00dc\u0001\u0010\u00ad\u0001R \u0010\u00df\u0001\u001a\u00030\u00de\u00018\u0017X\u0096\u0004\u00a2\u0006\u0010\n\u0006\b\u00df\u0001\u0010\u00e0\u0001\u001a\u0006\b\u00e1\u0001\u0010\u00e2\u0001R\u0018\u0010\u00e4\u0001\u001a\u00030\u00e3\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00e4\u0001\u0010\u00e5\u0001R&\u0010\u00eb\u0001\u001a\n\u0012\u0005\u0012\u00030\u00e7\u00010\u00e6\u00018WX\u0097\u0004\u00a2\u0006\u000f\u0012\u0005\b\u00ea\u0001\u0010\u0005\u001a\u0006\b\u00e8\u0001\u0010\u00e9\u0001R&\u0010\u00ef\u0001\u001a\n\u0012\u0005\u0012\u00030\u00ec\u00010\u00e6\u00018WX\u0097\u0004\u00a2\u0006\u000f\u0012\u0005\b\u00ee\u0001\u0010\u0005\u001a\u0006\b\u00ed\u0001\u0010\u00e9\u0001R&\u0010\u00f3\u0001\u001a\n\u0012\u0005\u0012\u00030\u00f0\u00010\u00e6\u00018WX\u0097\u0004\u00a2\u0006\u000f\u0012\u0005\b\u00f2\u0001\u0010\u0005\u001a\u0006\b\u00f1\u0001\u0010\u00e9\u0001R \u0010\u00f5\u0001\u001a\u00030\u00f4\u00018\u0017X\u0096\u0004\u00a2\u0006\u0010\n\u0006\b\u00f5\u0001\u0010\u00f6\u0001\u001a\u0006\b\u00f7\u0001\u0010\u00f8\u0001R \u0010\u00fa\u0001\u001a\u00030\u00f9\u00018\u0017X\u0096\u0004\u00a2\u0006\u0010\n\u0006\b\u00fa\u0001\u0010\u00fb\u0001\u001a\u0006\b\u00fc\u0001\u0010\u00fd\u0001R.\u0010\u00ff\u0001\u001a\n\u0012\u0005\u0012\u00030\u00fe\u00010\u00a8\u00018\u0017X\u0097\u0004\u00a2\u0006\u0017\n\u0006\b\u00ff\u0001\u0010\u00ab\u0001\u0012\u0005\b\u0081\u0002\u0010\u0005\u001a\u0006\b\u0080\u0002\u0010\u00ad\u0001R&\u0010\u0085\u0002\u001a\n\u0012\u0005\u0012\u00030\u0082\u00020\u00e6\u00018WX\u0097\u0004\u00a2\u0006\u000f\u0012\u0005\b\u0084\u0002\u0010\u0005\u001a\u0006\b\u0083\u0002\u0010\u00e9\u0001R&\u0010\u0089\u0002\u001a\n\u0012\u0005\u0012\u00030\u0086\u00020\u00e6\u00018WX\u0097\u0004\u00a2\u0006\u000f\u0012\u0005\b\u0088\u0002\u0010\u0005\u001a\u0006\b\u0087\u0002\u0010\u00e9\u0001R\u0018\u0010\u008d\u0002\u001a\u00030\u008a\u00028WX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u008b\u0002\u0010\u008c\u0002"}, d2={"Lorg/valkyrienskies/core/impl/program/VSCoreImpl;", "Lorg/valkyrienskies/core/impl/program/VSCoreInternal;", "Lorg/valkyrienskies/core/internal/VsiCoreCommands;", "", "configureAttachments", "()V", "Lorg/valkyrienskies/core/api/world/ServerShipWorld;", "world", "", "Lorg/valkyrienskies/core/api/ships/ServerShip;", "ships", "deleteShips", "(Lorg/valkyrienskies/core/api/world/ServerShipWorld;Ljava/util/List;)V", "Lorg/valkyrienskies/core/impl/shadow/EG;", "module", "Lorg/valkyrienskies/core/impl/shadow/FM;", "fromModule", "(Lorg/valkyrienskies/core/impl/shadow/EG;)Lorg/valkyrienskies/core/impl/shadow/FM;", "Lorg/valkyrienskies/core/internal/config/VsiConfigModel;", "getServerConfig", "()Lorg/valkyrienskies/core/internal/config/VsiConfigModel;", "", "chunkX", "chunkZ", "", "isChunkInShipyard", "(II)Z", "T", "Ljava/lang/Class;", "attachmentClass", "Lorg/valkyrienskies/core/api/attachment/AttachmentRegistration$Builder;", "newAttachmentRegistrationBuilder", "(Ljava/lang/Class;)Lorg/valkyrienskies/core/api/attachment/AttachmentRegistration$Builder;", "Lorg/joml/Vector3dc;", "velocity", "angularVelocity", "position", "Lorg/joml/Quaterniondc;", "rotation", "scaling", "positionInModel", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "newBodyKinematics", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "transform", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;)Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics$Builder;", "newBodyKinematicsBuilder", "()Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics$Builder;", "newBodyTransform", "(Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Builder;", "newBodyTransformBuilder", "()Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Builder;", "claimX", "claimZ", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "newChunkClaim", "(II)Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "newChunkClaimFromChunkPos", "chunkY", "Lorg/valkyrienskies/core/internal/world/chunks/VsiTerrainUpdate;", "newDeleteTerrainUpdate", "(III)Lorg/valkyrienskies/core/internal/world/chunks/VsiTerrainUpdate;", "Lorg/valkyrienskies/core/internal/world/chunks/VsiTerrainUpdate$Builder;", "newDenseTerrainUpdateBuilder", "(III)Lorg/valkyrienskies/core/internal/world/chunks/VsiTerrainUpdate$Builder;", "overwrite", "newEmptyVoxelShapeUpdate", "(IIIZ)Lorg/valkyrienskies/core/internal/world/chunks/VsiTerrainUpdate;", "Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState$Builder;", "newLiquidStateBuilder", "()Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState$Builder;", "newPipeline", "()Lorg/valkyrienskies/core/impl/shadow/FM;", "", "data", "([B)Lorg/valkyrienskies/core/impl/shadow/FM;", "queryableShipDataBytes", "chunkAllocatorBytes", "newPipelineLegacyData", "([B[B)Lorg/valkyrienskies/core/impl/shadow/FM;", "centerOfMassInShip", "", "mass", "Lorg/joml/Matrix3dc;", "momentOfInertiaTensor", "Lorg/valkyrienskies/core/api/ships/properties/ShipInertiaData;", "newShipInertiaData", "(Lorg/joml/Vector3dc;DLorg/joml/Matrix3dc;)Lorg/valkyrienskies/core/api/ships/properties/ShipInertiaData;", "newPos", "newRot", "newVel", "newOmega", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "newDimension", "newScale", "newPosInShip", "Lorg/valkyrienskies/core/internal/ShipTeleportData;", "newShipTeleportData", "(Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Ljava/lang/String;Ljava/lang/Double;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/internal/ShipTeleportData;", "positionInWorld", "positionInShip", "shipToWorldRotation", "shipToWorldScaling", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "newShipTransform", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/joml/Quaterniondc;Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "Lorg/valkyrienskies/core/api/physics/blockstates/BoxesBlockShape$Builder;", "newSolidStateBoxesShapeBuilder", "()Lorg/valkyrienskies/core/api/physics/blockstates/BoxesBlockShape$Builder;", "Lorg/valkyrienskies/core/api/physics/blockstates/SolidState$Builder;", "newSolidStateBuilder", "()Lorg/valkyrienskies/core/api/physics/blockstates/SolidState$Builder;", "newSparseTerrainUpdateBuilder", "Lorg/valkyrienskies/core/impl/shadow/FJ;", "newVSPhysicsPipelineStage$impl", "()Lorg/valkyrienskies/core/impl/shadow/FJ;", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "registrationBuilder", "registerAttachment", "(Ljava/lang/Class;Lkotlin/jvm/functions/Function1;)V", "Lorg/valkyrienskies/core/api/attachment/AttachmentRegistration;", "registration", "(Lorg/valkyrienskies/core/api/attachment/AttachmentRegistration;)V", "attachmentKey", "registerAttachmentForRemoval", "(Ljava/lang/String;)V", "", "Lorg/valkyrienskies/core/internal/physics/blockstates/VsiBlockState;", "states", "registerBlockStates", "(Ljava/lang/Iterable;)V", "ship", "newName", "renameShip", "(Lorg/valkyrienskies/core/api/ships/ServerShip;Ljava/lang/String;)V", "scaleShip", "(Lorg/valkyrienskies/core/api/world/ServerShipWorld;Lorg/valkyrienskies/core/api/ships/ServerShip;D)V", "Lorg/valkyrienskies/core/internal/world/VsiPipeline;", "pipeline", "serializePipeline", "(Lorg/valkyrienskies/core/internal/world/VsiPipeline;)[B", "teleportData", "teleportShip", "(Lorg/valkyrienskies/core/api/world/ServerShipWorld;Lorg/valkyrienskies/core/api/ships/ServerShip;Lorg/valkyrienskies/core/internal/ShipTeleportData;)V", "Lorg/valkyrienskies/core/impl/shadow/CH;", "attachmentRegistry", "Lorg/valkyrienskies/core/impl/shadow/CH;", "Lorg/valkyrienskies/core/impl/shadow/DN;", "blockTypes", "Lorg/valkyrienskies/core/impl/shadow/DN;", "getBlockTypes", "()Lorg/valkyrienskies/core/impl/shadow/DN;", "<set-?>", "clientUsesUDP$receiver", "Lorg/valkyrienskies/core/impl/shadow/Fi;", "getClientUsesUDP", "()Z", "setClientUsesUDP", "(Z)V", "getClientUsesUDP$annotations", "getClientUsesUDP$delegate", "(Lorg/valkyrienskies/core/impl/program/VSCoreImpl;)Ljava/lang/Object;", "clientUsesUDP", "Lorg/valkyrienskies/core/api/event/SingleEvent;", "Lorg/valkyrienskies/core/api/events/CollisionEvent;", "collisionEndEvent", "Lorg/valkyrienskies/core/api/event/SingleEvent;", "getCollisionEndEvent", "()Lorg/valkyrienskies/core/api/event/SingleEvent;", "getCollisionEndEvent$annotations", "collisionPersistEvent", "getCollisionPersistEvent", "getCollisionPersistEvent$annotations", "collisionStartEvent", "getCollisionStartEvent", "getCollisionStartEvent$annotations", "Lorg/valkyrienskies/core/impl/shadow/Fj;", "configurator", "Lorg/valkyrienskies/core/impl/shadow/Fj;", "getConfigurator", "()Lorg/valkyrienskies/core/impl/shadow/Fj;", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "getDefaultMapper", "()Lcom/fasterxml/jackson/databind/ObjectMapper;", "defaultMapper", "Lorg/valkyrienskies/core/internal/world/VsiClientShipWorld;", "getDummyShipWorldClient", "()Lorg/valkyrienskies/core/internal/world/VsiClientShipWorld;", "dummyShipWorldClient", "Lorg/valkyrienskies/core/internal/world/VsiServerShipWorld;", "getDummyShipWorldServer", "()Lorg/valkyrienskies/core/internal/world/VsiServerShipWorld;", "dummyShipWorldServer", "Lorg/valkyrienskies/core/internal/collision/VsiEntityPolygonCollider;", "getEntityPolygonCollider", "()Lorg/valkyrienskies/core/internal/collision/VsiEntityPolygonCollider;", "entityPolygonCollider", "Lorg/valkyrienskies/core/impl/shadow/EU;", "hooks", "Lorg/valkyrienskies/core/impl/shadow/EU;", "getHooks", "()Lorg/valkyrienskies/core/impl/shadow/EU;", "Lorg/valkyrienskies/core/api/events/MergeEvent;", "mergeEvent", "getMergeEvent", "getMergeEvent$annotations", "Lorg/valkyrienskies/core/impl/shadow/Fi;", "networking", "getNetworking", "()Lorg/valkyrienskies/core/impl/shadow/Fi;", "Ljavax/inject/Provider;", "newBoxesBlockShapeBuilder", "Ljavax/inject/Provider;", "Lorg/valkyrienskies/core/api/events/PhysTickEvent;", "physTickEvent", "getPhysTickEvent", "getPhysTickEvent$annotations", "Lorg/valkyrienskies/core/impl/shadow/FL$a;", "pipelineComponentFactory", "Lorg/valkyrienskies/core/impl/shadow/FL$a;", "getPipelineComponentFactory", "()Lorg/valkyrienskies/core/impl/shadow/FL$a;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/VSPipelineSerializer;", "pipelineSerializer", "Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/VSPipelineSerializer;", "Lorg/valkyrienskies/core/api/event/ListenableEvent;", "Lorg/valkyrienskies/core/api/events/ShipLoadEvent;", "getShipLoadEvent", "()Lorg/valkyrienskies/core/api/event/ListenableEvent;", "getShipLoadEvent$annotations", "shipLoadEvent", "Lorg/valkyrienskies/core/api/events/ShipLoadEventClient;", "getShipLoadEventClient", "getShipLoadEventClient$annotations", "shipLoadEventClient", "Lorg/valkyrienskies/core/api/events/ShipUnloadEventClient;", "getShipUnloadEventClient", "getShipUnloadEventClient$annotations", "shipUnloadEventClient", "Lorg/valkyrienskies/core/impl/networking/simple/SimplePacketNetworking;", "simplePacketNetworking", "Lorg/valkyrienskies/core/impl/networking/simple/SimplePacketNetworking;", "getSimplePacketNetworking", "()Lorg/valkyrienskies/core/impl/networking/simple/SimplePacketNetworking;", "Lorg/valkyrienskies/core/internal/collision/VsiSolidShapeUtils;", "solidShapeUtils", "Lorg/valkyrienskies/core/internal/collision/VsiSolidShapeUtils;", "getSolidShapeUtils", "()Lorg/valkyrienskies/core/internal/collision/VsiSolidShapeUtils;", "Lorg/valkyrienskies/core/api/events/SplitEvent;", "splitEvent", "getSplitEvent", "getSplitEvent$annotations", "Lorg/valkyrienskies/core/api/events/StartUpdateRenderTransformsEvent;", "getStartUpdateRenderTransformsEvent", "getStartUpdateRenderTransformsEvent$annotations", "startUpdateRenderTransformsEvent", "Lorg/valkyrienskies/core/api/events/TickEndEvent;", "getTickEndEvent", "getTickEndEvent$annotations", "tickEndEvent", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Factory;", "getTransformFactory", "()Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform$Factory;", "transformFactory", "Lorg/valkyrienskies/core/impl/shadow/EY;", "tcp", "<init>", "(Lorg/valkyrienskies/core/impl/shadow/Fi;Lorg/valkyrienskies/core/impl/shadow/EU;Lorg/valkyrienskies/core/impl/shadow/Fj;Lorg/valkyrienskies/core/impl/shadow/EY;Lorg/valkyrienskies/core/impl/shadow/FL$a;Lorg/valkyrienskies/core/impl/game/ships/serialization/vspipeline/VSPipelineSerializer;Lorg/valkyrienskies/core/impl/shadow/DN;Lorg/valkyrienskies/core/impl/networking/simple/SimplePacketNetworking;Lorg/valkyrienskies/core/internal/collision/VsiSolidShapeUtils;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Lorg/valkyrienskies/core/impl/shadow/CH;)V", "Companion"})
public final class VSCoreImpl
implements VSCoreInternal,
VsiCoreCommands {
    public static final Companion Companion = new Companion(null);
    private final fi_0 networking;
    private final EU hooks;
    private final fj_0 configurator;
    private final FL.a pipelineComponentFactory;
    private final VSPipelineSerializer pipelineSerializer;
    private final DN blockTypes;
    private final SimplePacketNetworking simplePacketNetworking;
    private final VsiSolidShapeUtils solidShapeUtils;
    private final Provider<LiquidState.Builder> newLiquidStateBuilder;
    private final Provider<SolidState.Builder> newSolidStateBuilder;
    private final Provider<BoxesBlockShape.Builder> newBoxesBlockShapeBuilder;
    private final CH attachmentRegistry;
    private final /* synthetic */ DS $$delegate_0;
    private final SingleEvent<CollisionEvent> collisionStartEvent;
    private final SingleEvent<CollisionEvent> collisionEndEvent;
    private final SingleEvent<CollisionEvent> collisionPersistEvent;
    private final SingleEvent<PhysTickEvent> physTickEvent;
    private final SingleEvent<MergeEvent> mergeEvent;
    private final SingleEvent<SplitEvent> splitEvent;
    private final fi_0 clientUsesUDP$receiver;
    private static final Logger logger$delegate = FX.a("VSCore");

    /*
     * WARNING - void declaration
     */
    @Inject
    public VSCoreImpl(fi_0 networking, EU hooks, fj_0 configurator2, EY tcp, FL.a pipelineComponentFactory, VSPipelineSerializer pipelineSerializer, DN blockTypes, SimplePacketNetworking simplePacketNetworking, VsiSolidShapeUtils solidShapeUtils, Provider<LiquidState.Builder> newLiquidStateBuilder, Provider<SolidState.Builder> newSolidStateBuilder, Provider<BoxesBlockShape.Builder> newBoxesBlockShapeBuilder, CH attachmentRegistry) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)networking, (String)"");
        Intrinsics.checkNotNullParameter((Object)hooks, (String)"");
        Intrinsics.checkNotNullParameter((Object)configurator2, (String)"");
        Intrinsics.checkNotNullParameter((Object)tcp, (String)"");
        Intrinsics.checkNotNullParameter((Object)pipelineComponentFactory, (String)"");
        Intrinsics.checkNotNullParameter((Object)pipelineSerializer, (String)"");
        Intrinsics.checkNotNullParameter((Object)blockTypes, (String)"");
        Intrinsics.checkNotNullParameter((Object)simplePacketNetworking, (String)"");
        Intrinsics.checkNotNullParameter((Object)solidShapeUtils, (String)"");
        Intrinsics.checkNotNullParameter(newLiquidStateBuilder, (String)"");
        Intrinsics.checkNotNullParameter(newSolidStateBuilder, (String)"");
        Intrinsics.checkNotNullParameter(newBoxesBlockShapeBuilder, (String)"");
        Intrinsics.checkNotNullParameter((Object)attachmentRegistry, (String)"");
        this.networking = var1_1;
        this.hooks = var2_2;
        this.configurator = var3_3;
        this.pipelineComponentFactory = pipelineComponentFactory;
        this.pipelineSerializer = pipelineSerializer;
        this.blockTypes = blockTypes;
        this.simplePacketNetworking = simplePacketNetworking;
        this.solidShapeUtils = solidShapeUtils;
        this.newLiquidStateBuilder = newLiquidStateBuilder;
        this.newSolidStateBuilder = newSolidStateBuilder;
        this.newBoxesBlockShapeBuilder = newBoxesBlockShapeBuilder;
        this.attachmentRegistry = attachmentRegistry;
        this.$$delegate_0 = DS.INSTANCE;
        this.getConfigurator().configure(tcp);
        this.getNetworking().e();
        this.configureAttachments();
        this.collisionStartEvent = new EventEmitterImpl();
        this.collisionEndEvent = new EventEmitterImpl();
        this.collisionPersistEvent = new EventEmitterImpl();
        this.physTickEvent = new EventEmitterImpl();
        this.mergeEvent = new EventEmitterImpl();
        this.splitEvent = new EventEmitterImpl();
        this.clientUsesUDP$receiver = this.getNetworking();
    }

    @Override
    @JvmName(name="getNetworking")
    public final fi_0 getNetworking() {
        return this.networking;
    }

    @Override
    @JvmName(name="getHooks")
    public final EU getHooks() {
        return this.hooks;
    }

    @Override
    @JvmName(name="getConfigurator")
    public final fj_0 getConfigurator() {
        return this.configurator;
    }

    @Override
    @JvmName(name="getPipelineComponentFactory")
    public final FL.a getPipelineComponentFactory() {
        return this.pipelineComponentFactory;
    }

    @Override
    @JvmName(name="getBlockTypes")
    public final DN getBlockTypes() {
        return this.blockTypes;
    }

    @Override
    @JvmName(name="getSimplePacketNetworking")
    public final SimplePacketNetworking getSimplePacketNetworking() {
        return this.simplePacketNetworking;
    }

    @Override
    @JvmName(name="getSolidShapeUtils")
    public final VsiSolidShapeUtils getSolidShapeUtils() {
        return this.solidShapeUtils;
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
        this.$$delegate_0.deleteShips((ServerShipWorld)var1_1, (List<? extends ServerShip>)var2_2);
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
        this.$$delegate_0.renameShip((ServerShip)var1_1, (String)var2_2);
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
        this.$$delegate_0.scaleShip((ServerShipWorld)var1_1, (ServerShip)var2_2, (double)var3_3);
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
        this.$$delegate_0.teleportShip((ServerShipWorld)var1_1, (ServerShip)var2_2, (ShipTeleportData)var3_3);
    }

    private final void configureAttachments() {
        this.registerAttachment(ew_0.class, configureAttachments.1.INSTANCE);
        this.registerAttachment(eh_0.class, configureAttachments.2.INSTANCE);
    }

    @Override
    @JvmName(name="getTransformFactory")
    public final BodyTransform.Factory getTransformFactory() {
        return BodyTransformFactory.INSTANCE;
    }

    @Override
    @JvmName(name="getShipLoadEvent")
    public final ListenableEvent<ShipLoadEvent> getShipLoadEvent() {
        return VSEvents.INSTANCE.getShipLoadEvent();
    }

    @VsBeta
    public static /* synthetic */ void getShipLoadEvent$annotations() {
    }

    @Override
    @JvmName(name="getShipLoadEventClient")
    public final ListenableEvent<ShipLoadEventClient> getShipLoadEventClient() {
        return VSEvents.INSTANCE.getShipLoadEventClient();
    }

    @VsBeta
    public static /* synthetic */ void getShipLoadEventClient$annotations() {
    }

    @Override
    @JvmName(name="getShipUnloadEventClient")
    public final ListenableEvent<ShipUnloadEventClient> getShipUnloadEventClient() {
        return VSEvents.INSTANCE.getShipUnloadEventClient();
    }

    @VsBeta
    public static /* synthetic */ void getShipUnloadEventClient$annotations() {
    }

    @Override
    @JvmName(name="getStartUpdateRenderTransformsEvent")
    public final ListenableEvent<StartUpdateRenderTransformsEvent> getStartUpdateRenderTransformsEvent() {
        return VSEvents.INSTANCE.getStartUpdateRenderTransformsEvent();
    }

    @VsBeta
    public static /* synthetic */ void getStartUpdateRenderTransformsEvent$annotations() {
    }

    @Override
    @JvmName(name="getTickEndEvent")
    public final ListenableEvent<TickEndEvent> getTickEndEvent() {
        return VSEvents.INSTANCE.getTickEndEvent();
    }

    @VsBeta
    public static /* synthetic */ void getTickEndEvent$annotations() {
    }

    @Override
    @JvmName(name="getCollisionStartEvent")
    public final SingleEvent<CollisionEvent> getCollisionStartEvent() {
        return this.collisionStartEvent;
    }

    @VsBeta
    public static /* synthetic */ void getCollisionStartEvent$annotations() {
    }

    @Override
    @JvmName(name="getCollisionEndEvent")
    public final SingleEvent<CollisionEvent> getCollisionEndEvent() {
        return this.collisionEndEvent;
    }

    @VsBeta
    public static /* synthetic */ void getCollisionEndEvent$annotations() {
    }

    @Override
    @JvmName(name="getCollisionPersistEvent")
    public final SingleEvent<CollisionEvent> getCollisionPersistEvent() {
        return this.collisionPersistEvent;
    }

    @VsBeta
    public static /* synthetic */ void getCollisionPersistEvent$annotations() {
    }

    @Override
    @JvmName(name="getPhysTickEvent")
    public final SingleEvent<PhysTickEvent> getPhysTickEvent() {
        return this.physTickEvent;
    }

    @VsBeta
    public static /* synthetic */ void getPhysTickEvent$annotations() {
    }

    @Override
    @JvmName(name="getMergeEvent")
    public final SingleEvent<MergeEvent> getMergeEvent() {
        return this.mergeEvent;
    }

    @VsBeta
    public static /* synthetic */ void getMergeEvent$annotations() {
    }

    @Override
    @JvmName(name="getSplitEvent")
    public final SingleEvent<SplitEvent> getSplitEvent() {
        return this.splitEvent;
    }

    @VsBeta
    public static /* synthetic */ void getSplitEvent$annotations() {
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
        return BodyKinematicsFactory.INSTANCE.create((Vector3dc)var1_1, (Vector3dc)var2_2, (BodyTransform)var3_3);
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
        return BodyKinematicsFactory.INSTANCE.create((Vector3dc)var1_1, (Vector3dc)var2_2, (Vector3dc)var3_3, rotation, scaling, positionInModel);
    }

    @Override
    @VsBeta
    public final BodyKinematics.Builder newBodyKinematicsBuilder() {
        return BodyKinematicsFactory.INSTANCE.newBuilder();
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
        return this.getTransformFactory().create((Vector3dc)var1_1, (Quaterniondc)var2_2, (Vector3dc)var3_3, positionInModel);
    }

    @Override
    @VsBeta
    public final BodyTransform.Builder newBodyTransformBuilder() {
        return this.getTransformFactory().newBuilder();
    }

    @Override
    @JvmName(name="getEntityPolygonCollider")
    public final VsiEntityPolygonCollider getEntityPolygonCollider() {
        return dk_0.INSTANCE;
    }

    @Override
    @JvmName(name="getDummyShipWorldClient")
    public final VsiClientShipWorld getDummyShipWorldClient() {
        return ei_0.INSTANCE;
    }

    @Override
    @JvmName(name="getDummyShipWorldServer")
    public final VsiServerShipWorld getDummyShipWorldServer() {
        return ej_0.INSTANCE;
    }

    @Override
    public final void registerBlockStates(Iterable<VsiBlockState> states) {
        Object object;
        Intrinsics.checkNotNullParameter(states, (String)"");
        Object object2 = this.getBlockTypes();
        object2 = ((DN)object2).b;
        object = object.iterator();
        while (object.hasNext()) {
            Object object3 = object.next();
            object3 = (VsiBlockState)object3;
            ((CP)object2).b((VsiBlockState)object3);
        }
        object = object2;
        ((CP)object2).h = true;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final VsiTerrainUpdate newEmptyVoxelShapeUpdate(int chunkX, int chunkY, int chunkZ, boolean overwrite) {
        void var3_3;
        void var2_2;
        void var1_1;
        return new ET(new ik_0((int)var1_1, (int)var2_2, (int)var3_3, overwrite));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final VsiTerrainUpdate newDeleteTerrainUpdate(int chunkX, int chunkY, int chunkZ) {
        void var3_3;
        void var2_2;
        void var1_1;
        return new ET(new ii_0((int)var1_1, (int)var2_2, (int)var3_3));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final VsiTerrainUpdate.Builder newDenseTerrainUpdateBuilder(int chunkX, int chunkY, int chunkZ) {
        void var3_3;
        void var2_2;
        void var1_1;
        return new EQ((int)var1_1, (int)var2_2, (int)var3_3);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final VsiTerrainUpdate.Builder newSparseTerrainUpdateBuilder(int chunkX, int chunkY, int chunkZ) {
        void var3_3;
        void var2_2;
        void var1_1;
        return new ES((int)var1_1, (int)var2_2, (int)var3_3);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final FM newPipelineLegacyData(byte[] queryableShipDataBytes, byte[] chunkAllocatorBytes) {
        void var2_2;
        EG eG;
        Intrinsics.checkNotNullParameter((Object)queryableShipDataBytes, (String)"");
        Intrinsics.checkNotNullParameter((Object)chunkAllocatorBytes, (String)"");
        eG = this.pipelineSerializer.deserializeLegacy((byte[])eG, (byte[])var2_2);
        return this.fromModule(eG);
    }

    @Override
    public final FM newPipeline() {
        return this.fromModule(EG.a.a());
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final FM newPipeline(byte[] data) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)data, (String)"");
        VSCoreImpl vSCoreImpl = this;
        return vSCoreImpl.fromModule(vSCoreImpl.pipelineSerializer.deserialize((byte[])var1_1));
    }

    public final FJ newVSPhysicsPipelineStage$impl() {
        Companion.loadKrunch();
        return this.getPipelineComponentFactory().newPipelineComponent(EG.a.a()).newPhysicsStage();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final byte[] serializePipeline(VsiPipeline pipeline) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)pipeline, (String)"");
        return this.pipelineSerializer.serialize((FM)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final ChunkClaim newChunkClaim(int claimX, int claimZ) {
        void var2_2;
        void var1_1;
        return new ChunkClaimImpl((int)var1_1, (int)var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final ChunkClaim newChunkClaimFromChunkPos(int chunkX, int chunkZ) {
        void var2_2;
        void var1_1;
        return new ChunkClaimImpl(ChunkClaim.Companion.getClaimXIndex((int)var1_1), ChunkClaim.Companion.getClaimZIndex((int)var2_2));
    }

    @Override
    public final SolidState.Builder newSolidStateBuilder() {
        SolidState.Builder builder = this.newSolidStateBuilder.get();
        Intrinsics.checkNotNullExpressionValue((Object)builder, (String)"");
        return builder;
    }

    @Override
    public final LiquidState.Builder newLiquidStateBuilder() {
        LiquidState.Builder builder = this.newLiquidStateBuilder.get();
        Intrinsics.checkNotNullExpressionValue((Object)builder, (String)"");
        return builder;
    }

    @Override
    public final BoxesBlockShape.Builder newSolidStateBoxesShapeBuilder() {
        BoxesBlockShape.Builder builder = this.newBoxesBlockShapeBuilder.get();
        Intrinsics.checkNotNullExpressionValue((Object)builder, (String)"");
        return builder;
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
        return ShipTransformImpl.Companion.create((Vector3dc)var1_1, (Vector3dc)var2_2, (Quaterniondc)var3_3, shipToWorldScaling);
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
        return new ShipTeleportDataImpl((Vector3dc)var1_1, (Quaterniondc)var2_2, (Vector3dc)var3_3, newOmega, newDimension, newScale, newPosInShip);
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
        return new ShipInertiaDataImpl(new Vector3d((Vector3dc)var1_1), (double)var2_2, new Matrix3d(momentOfInertiaTensor));
    }

    @Override
    public final VsiConfigModel getServerConfig() {
        return VsiConfigModelImpl.Companion.build(VSCoreConfig.SERVER);
    }

    @Override
    @JvmName(name="getDefaultMapper")
    public final ObjectMapper getDefaultMapper() {
        return VSJacksonUtil.INSTANCE.getDefaultMapper();
    }

    @Override
    @Deprecated(message="This method isn't tied to a world, which is bad if we want to have different chunk allocation strategies per world in the future.", replaceWith=@ReplaceWith(expression="ShipWorld.isChunkInShipyard(chunkX, chunkZ, DimensionId)", imports={}))
    public final boolean isChunkInShipyard(int chunkX, int chunkZ) {
        int n2;
        int n3;
        n3 = ChunkClaim.Companion.getClaimXIndex(n3);
        n2 = ChunkClaim.Companion.getClaimZIndex(n2);
        return (-7000 <= n3 ? n3 < 7001 : false) & (3000 <= n2 ? n2 < 7001 : false);
    }

    @Override
    @JvmName(name="getClientUsesUDP")
    public final boolean getClientUsesUDP() {
        fi_0 fi_02 = this.clientUsesUDP$receiver;
        return ((Fi)fi_02).d;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setClientUsesUDP")
    public final void setClientUsesUDP(boolean bl) {
        void var1_1;
        void var2_3 = var1_1;
        fi_0 fi_02 = this.clientUsesUDP$receiver;
        ((Fi)this.clientUsesUDP$receiver).d = var2_3;
    }

    @Deprecated(message="Surely we can do better than this")
    public static /* synthetic */ void getClientUsesUDP$annotations() {
    }

    private static Object getClientUsesUDP$delegate(VSCoreImpl vSCoreImpl) {
        VSCoreImpl vSCoreImpl2;
        return Reflection.mutableProperty0((MutablePropertyReference0)((MutablePropertyReference0)new MutablePropertyReference0Impl((Object)vSCoreImpl2.clientUsesUDP$receiver, Fi.class, "clientUsesUDP", "getClientUsesUDP()Z", 0)));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final <T> AttachmentRegistration.Builder<T> newAttachmentRegistrationBuilder(Class<T> attachmentClass) {
        void var1_1;
        Intrinsics.checkNotNullParameter(attachmentClass, (String)"");
        return new CF(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final <T> void registerAttachment(AttachmentRegistration<T> registration) {
        void var1_1;
        Intrinsics.checkNotNullParameter(registration, (String)"");
        this.attachmentRegistry.a(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final <T> void registerAttachment(Class<T> attachmentClass, Function1<? super AttachmentRegistration.Builder<T>, Unit> registrationBuilder) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter(attachmentClass, (String)"");
        Intrinsics.checkNotNullParameter(registrationBuilder, (String)"");
        this.attachmentRegistry.a(var1_1, var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void registerAttachmentForRemoval(String attachmentKey) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)attachmentKey, (String)"");
        this.attachmentRegistry.a((String)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    private final FM fromModule(EG module) {
        void var1_1;
        Companion.loadKrunch();
        return this.getPipelineComponentFactory().newPipelineComponent((EG)var1_1).newPipeline();
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u001b\u0010\n\u001a\u00020\u00058CX\u0083\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t"}, d2={"Lorg/valkyrienskies/core/impl/program/VSCoreImpl$Companion;", "", "", "loadKrunch", "()V", "Lorg/apache/logging/log4j/Logger;", "logger$delegate", "Lorg/apache/logging/log4j/Logger;", "getLogger", "()Lorg/apache/logging/log4j/Logger;", "logger", "<init>"})
    public static final class Companion {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;

        private Companion() {
        }

        @JvmName(name="getLogger")
        private final Logger getLogger() {
            KProperty<Object> kProperty = $$delegatedProperties[0];
            Logger logger = logger$delegate;
            Intrinsics.checkNotNullParameter(kProperty, (String)"");
            return logger;
        }

        public final void loadKrunch() {
            try {
                String string = System.getenv("KRUNCH_TEST_BINARY");
                CharSequence charSequence = string;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    this.getLogger().info("Loading Krunch testing binaries from " + string);
                    Intrinsics.checkNotNullExpressionValue((Object)string, (String)"");
                    It.a(string);
                    return;
                }
                It.INSTANCE.a();
                return;
            }
            catch (Exception exception) {
                this.getLogger().error("Failed to load Krunch binary!", (Throwable)exception);
                return;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        static {
            KProperty[] kPropertyArray = new KProperty[1];
            KProperty[] kPropertyArray2 = kPropertyArray;
            kPropertyArray[0] = Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(Companion.class, "logger", "getLogger()Lorg/apache/logging/log4j/Logger;", 0)));
            $$delegatedProperties = kPropertyArray2;
        }
    }
}

