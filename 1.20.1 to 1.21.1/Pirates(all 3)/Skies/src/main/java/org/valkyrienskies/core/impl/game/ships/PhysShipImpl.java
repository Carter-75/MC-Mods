/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.NotImplementedError
 *  kotlin.ReplaceWith
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference0
 *  kotlin.jvm.internal.MutablePropertyReference0Impl
 *  kotlin.jvm.internal.Reflection
 */
package org.valkyrienskies.core.impl.game.ships;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import org.joml.Matrix3dc;
import org.joml.Quaterniondc;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.primitives.AABBdc;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.VsBeta;
import org.valkyrienskies.core.api.bodies.properties.BodyKinematics;
import org.valkyrienskies.core.api.bodies.properties.BodyTransform;
import org.valkyrienskies.core.api.ships.DragController;
import org.valkyrienskies.core.api.ships.PhysShip;
import org.valkyrienskies.core.api.ships.ShipPhysicsListener;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.core.api.ships.properties.IShipActiveChunksSet;
import org.valkyrienskies.core.api.ships.properties.PhysPose;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.impl.bodies.properties.BodyKinematicsFactory;
import org.valkyrienskies.core.impl.game.ships.PhysPoseImpl;
import org.valkyrienskies.core.impl.shadow.FR;
import org.valkyrienskies.core.impl.shadow.GY;
import org.valkyrienskies.core.impl.shadow.ek_0;
import org.valkyrienskies.core.impl.shadow.ew_0;
import org.valkyrienskies.core.impl.shadow.ga_0;
import org.valkyrienskies.core.impl.shadow.hb_0;
import org.valkyrienskies.core.impl.shadow.hc_0;
import org.valkyrienskies.core.internal.ships.VsiPhysShip;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u00e8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\n\u0010B\u001a\u00060(j\u0002`)\u0012\n\u0010C\u001a\u0006\u0012\u0002\b\u00030,\u0012\f\u0010D\u001a\b\u0012\u0004\u0012\u0002000/\u0012\u0006\u0010E\u001a\u000203\u0012\u0006\u0010F\u001a\u000206\u0012\u0006\u0010G\u001a\u000209\u0012\u0006\u0010H\u001a\u00020<\u0012\b\b\u0002\u0010I\u001a\u00020?\u00a2\u0006\u0006\b\u00d1\u0001\u0010\u00d2\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0002H\u0017\u00a2\u0006\u0004\b\f\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0017\u00a2\u0006\u0004\b\u000e\u0010\u0007J\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0002H\u0017\u00a2\u0006\u0004\b\u0010\u0010\nJ\u001f\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0007J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0015\u0010\nJ\r\u0010\u0016\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0002H\u0017\u00a2\u0006\u0004\b\u0018\u0010\nJ\u001f\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0017\u00a2\u0006\u0004\b\u0019\u0010\u0007J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0002H\u0017\u00a2\u0006\u0004\b\u001a\u0010\nJ\u001f\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u001d\u0010\u0007J\u001f\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u001e\u0010\u0007J\u001f\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u001f\u0010\u0007J\u0017\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b!\u0010\nJ+\u0010&\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00022\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b&\u0010'J\u0014\u0010*\u001a\u00060(j\u0002`)H\u00c6\u0003\u00a2\u0006\u0004\b*\u0010+J\u0014\u0010-\u001a\u0006\u0012\u0002\b\u00030,H\u00c0\u0003\u00a2\u0006\u0004\b-\u0010.J\u0016\u00101\u001a\b\u0012\u0004\u0012\u0002000/H\u00c0\u0003\u00a2\u0006\u0004\b1\u00102J\u0010\u00104\u001a\u000203H\u00c0\u0003\u00a2\u0006\u0004\b4\u00105J\u0010\u00107\u001a\u000206H\u00c2\u0003\u00a2\u0006\u0004\b7\u00108J\u0010\u0010:\u001a\u000209H\u00c0\u0003\u00a2\u0006\u0004\b:\u0010;J\u0010\u0010=\u001a\u00020<H\u00c2\u0003\u00a2\u0006\u0004\b=\u0010>J\u0010\u0010@\u001a\u00020?H\u00c0\u0003\u00a2\u0006\u0004\b@\u0010AJn\u0010J\u001a\u00020\u00002\f\b\u0002\u0010B\u001a\u00060(j\u0002`)2\f\b\u0002\u0010C\u001a\u0006\u0012\u0002\b\u00030,2\u000e\b\u0002\u0010D\u001a\b\u0012\u0004\u0012\u0002000/2\b\b\u0002\u0010E\u001a\u0002032\b\b\u0002\u0010F\u001a\u0002062\b\b\u0002\u0010G\u001a\u0002092\b\b\u0002\u0010H\u001a\u00020<2\b\b\u0002\u0010I\u001a\u00020?H\u00c6\u0001\u00a2\u0006\u0004\bJ\u0010KJ\u001a\u0010N\u001a\u00020\"2\b\u0010M\u001a\u0004\u0018\u00010LH\u00d6\u0003\u00a2\u0006\u0004\bN\u0010OJ\u0010\u0010P\u001a\u000209H\u00d6\u0001\u00a2\u0006\u0004\bP\u0010;J\u0017\u0010S\u001a\u00020\u00052\u0006\u0010R\u001a\u00020QH\u0016\u00a2\u0006\u0004\bS\u0010TJ\u0010\u0010V\u001a\u00020UH\u00d6\u0001\u00a2\u0006\u0004\bV\u0010WJ\u0017\u0010Z\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020XH\u0016\u00a2\u0006\u0004\bZ\u0010[J\u000f\u0010\\\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\\\u0010\u0017J\u0017\u0010^\u001a\u0006*\u00020]0]*\u00020\u0002H\u0002\u00a2\u0006\u0004\b^\u0010_J\u0017\u0010`\u001a\u0006*\u00020]0]*\u00020\u0002H\u0002\u00a2\u0006\u0004\b`\u0010_J\u0017\u0010a\u001a\u0006*\u00020]0]*\u00020\u0002H\u0002\u00a2\u0006\u0004\ba\u0010_R\u0016\u0010F\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010bR\u0014\u0010f\u001a\u00020c8WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bd\u0010eR\u0014\u0010i\u001a\u00020\u00028WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bg\u0010hR1\u0010s\u001a\u00020j2\u0006\u0010k\u001a\u00020j8W@WX\u0097\u008e\u0002\u00a2\u0006\u0018\u0012\u0004\bp\u0010\u0017\u001a\u0004\bl\u0010m\"\u0004\bn\u0010o*\u0004\bq\u0010rR\u0014\u0010u\u001a\u00020\u00028WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bt\u0010hR\u0014\u0010y\u001a\u00020v8WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bw\u0010xR,\u0010\u007f\u001a\u00060Uj\u0002`z2\n\u0010{\u001a\u00060Uj\u0002`z8W@WX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b|\u0010W\"\u0004\b}\u0010~R8\u0010\u0086\u0001\u001a\u00020\"2\u0006\u0010k\u001a\u00020\"8W@WX\u0097\u008e\u0002\u00a2\u0006\u001e\u0012\u0005\b\u0084\u0001\u0010\u0017\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001*\u0005\b\u0085\u0001\u0010rR\u001a\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0087\u00018WX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R \u0010B\u001a\u00060(j\u0002`)8\u0017X\u0096\u0004\u00a2\u0006\u000e\n\u0005\bB\u0010\u008b\u0001\u001a\u0005\b\u008c\u0001\u0010+R&\u0010E\u001a\u0002038\u0001@\u0001X\u0080\u000e\u00a2\u0006\u0016\n\u0005\bE\u0010\u008d\u0001\u001a\u0005\b\u008e\u0001\u00105\"\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001e\u0010\u0092\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u0091\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001e\u0010\u0094\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u0091\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0093\u0001R\u001e\u0010\u0095\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u0091\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0095\u0001\u0010\u0093\u0001R\u001e\u0010\u0096\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u0091\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0093\u0001R\u001e\u0010\u0097\u0001\u001a\u00020\"8WX\u0097\u0004\u00a2\u0006\u000f\u0012\u0005\b\u0098\u0001\u0010\u0017\u001a\u0006\b\u0097\u0001\u0010\u0081\u0001R/\u0010#\u001a\u00020\"2\u0006\u0010k\u001a\u00020\"8W@WX\u0096\u008e\u0002\u00a2\u0006\u0016\u001a\u0005\b#\u0010\u0081\u0001\"\u0006\b\u0099\u0001\u0010\u0083\u0001*\u0005\b\u009a\u0001\u0010rR/\u0010\u00a0\u0001\u001a\u0005\u0018\u00010\u009b\u00012\t\u0010{\u001a\u0005\u0018\u00010\u009b\u00018W@WX\u0096\u000e\u00a2\u0006\u0010\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001\"\u0006\b\u009e\u0001\u0010\u009f\u0001R(\u0010Y\u001a\u00020X2\u0007\u0010\u00a1\u0001\u001a\u00020X8\u0017@RX\u0096.\u00a2\u0006\u000f\n\u0005\bY\u0010\u00a2\u0001\u001a\u0006\b\u00a3\u0001\u0010\u00a4\u0001R&\u0010G\u001a\u0002098\u0001@\u0001X\u0080\u000e\u00a2\u0006\u0016\n\u0005\bG\u0010\u00a5\u0001\u001a\u0005\b\u00a6\u0001\u0010;\"\u0006\b\u00a7\u0001\u0010\u00a8\u0001R\u001d\u0010\u00ab\u0001\u001a\u00020j8WX\u0097\u0004\u00a2\u0006\u000e\u0012\u0005\b\u00aa\u0001\u0010\u0017\u001a\u0005\b\u00a9\u0001\u0010mR\u0016\u0010\u00ad\u0001\u001a\u00020j8WX\u0096\u0004\u00a2\u0006\u0007\u001a\u0005\b\u00ac\u0001\u0010mR\u0018\u0010\u00b1\u0001\u001a\u00030\u00ae\u00018WX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u00af\u0001\u0010\u00b0\u0001R,\u0010D\u001a\b\u0012\u0004\u0012\u0002000/8\u0001@\u0001X\u0080\u000e\u00a2\u0006\u0016\n\u0005\bD\u0010\u00b2\u0001\u001a\u0005\b\u00b3\u0001\u00102\"\u0006\b\u00b4\u0001\u0010\u00b5\u0001R\u0015\u0010H\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bH\u0010\u00b6\u0001R)\u0010\u00b7\u0001\u001a\u0002062\u0007\u0010\u00b7\u0001\u001a\u0002068G@GX\u0086\u000e\u00a2\u0006\u000f\u001a\u0005\b\u00b8\u0001\u00108\"\u0006\b\u00b9\u0001\u0010\u00ba\u0001R\u0018\u0010\u00be\u0001\u001a\u00030\u00bb\u00018WX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u00bc\u0001\u0010\u00bd\u0001R \u0010C\u001a\u0006\u0012\u0002\b\u00030,8\u0001X\u0080\u0004\u00a2\u0006\u000e\n\u0005\bC\u0010\u00bf\u0001\u001a\u0005\b\u00c0\u0001\u0010.R\u001e\u0010\u00c1\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u0091\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c1\u0001\u0010\u0093\u0001R\u001e\u0010\u00c2\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u0091\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c2\u0001\u0010\u0093\u0001R\u001a\u0010\u00c6\u0001\u001a\u0005\u0018\u00010\u00c3\u00018WX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u00c4\u0001\u0010\u00c5\u0001R\u0018\u0010\u00c8\u0001\u001a\u0004\u0018\u00010U8WX\u0096\u0004\u00a2\u0006\u0007\u001a\u0005\b\u00c7\u0001\u0010WR\u0016\u0010\u00ca\u0001\u001a\u00020\u00028WX\u0096\u0004\u00a2\u0006\u0007\u001a\u0005\b\u00c9\u0001\u0010hR\u001c\u0010I\u001a\u00020?8\u0001X\u0080\u0004\u00a2\u0006\u000e\n\u0005\bI\u0010\u00cb\u0001\u001a\u0005\b\u00cc\u0001\u0010AR\u0018\u0010\u00d0\u0001\u001a\u00030\u00cd\u00018WX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u00ce\u0001\u0010\u00cf\u0001"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/PhysShipImpl;", "Lorg/valkyrienskies/core/internal/ships/VsiPhysShip;", "Lorg/joml/Vector3dc;", "forceInBody", "posInBody", "", "applyBodyForce", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)V", "torqueInBody", "applyBodyTorque", "(Lorg/joml/Vector3dc;)V", "force", "applyInvariantForce", "pos", "applyInvariantForceToPos", "torque", "applyInvariantTorque", "forceInShip", "posInShip", "applyModelForce", "torqueInShip", "applyModelTorque", "applyQueuedForces", "()V", "applyRotDependentForce", "applyRotDependentForceToPos", "applyRotDependentTorque", "forceInWorld", "posInWorld", "applyWorldForce", "applyWorldForceToBodyPos", "applyWorldForceToModelPos", "torqueInWorld", "applyWorldTorque", "", "isStatic", "vec0", "vec1", "canApplyWrenches", "(ZLorg/joml/Vector3dc;Lorg/joml/Vector3dc;)Z", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "component1", "()J", "Lorg/valkyrienskies/core/impl/shadow/GY;", "component2$impl", "()Lorg/valkyrienskies/core/impl/shadow/GY;", "", "Lorg/valkyrienskies/core/api/ships/ShipPhysicsListener;", "component3$impl", "()Ljava/util/List;", "Lorg/valkyrienskies/core/impl/shadow/Ek;", "component4$impl", "()Lorg/valkyrienskies/core/impl/shadow/Ek;", "Lorg/valkyrienskies/core/impl/shadow/Hc;", "component5", "()Lorg/valkyrienskies/core/impl/shadow/Hc;", "", "component6$impl", "()I", "Lorg/valkyrienskies/core/impl/shadow/FR;", "component7", "()Lorg/valkyrienskies/core/impl/shadow/FR;", "Lorg/valkyrienskies/core/impl/shadow/Ew;", "component8$impl", "()Lorg/valkyrienskies/core/impl/shadow/Ew;", "id", "rigidBodyReference", "physicsListeners", "inertia", "_poseVel", "lastShipTeleportId", "physicsThreadChecker", "wingManager", "copy", "(JLorg/valkyrienskies/core/impl/shadow/GY;Ljava/util/List;Lorg/valkyrienskies/core/impl/shadow/Ek;Lorg/valkyrienskies/core/impl/shadow/Hc;ILorg/valkyrienskies/core/impl/shadow/FR;Lorg/valkyrienskies/core/impl/shadow/Ew;)Lorg/valkyrienskies/core/impl/game/ships/PhysShipImpl;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "transform", "setFromTransform", "(Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;)V", "", "toString", "()Ljava/lang/String;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "kinematics", "unsafeSetKinematics", "(Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;)V", "updatePhysTransform", "Lorg/joml/Vector3d;", "rotateForceToWorld", "(Lorg/joml/Vector3dc;)Lorg/joml/Vector3d;", "scaleForceToWorld", "scaleTorqueToWorld", "Lorg/valkyrienskies/core/impl/shadow/Hc;", "Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "getActiveChunksSet", "()Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "activeChunksSet", "getAngularVelocity", "()Lorg/joml/Vector3dc;", "angularVelocity", "", "<set-?>", "getBuoyantFactor", "()D", "setBuoyantFactor", "(D)V", "getBuoyantFactor$annotations", "getBuoyantFactor$delegate", "(Lorg/valkyrienskies/core/impl/game/ships/PhysShipImpl;)Ljava/lang/Object;", "buoyantFactor", "getCenterOfMass", "centerOfMass", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "getChunkClaim", "()Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "chunkClaim", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "value", "getChunkClaimDimension", "setChunkClaimDimension", "(Ljava/lang/String;)V", "chunkClaimDimension", "getDoFluidDrag", "()Z", "setDoFluidDrag", "(Z)V", "getDoFluidDrag$annotations", "getDoFluidDrag$delegate", "doFluidDrag", "Lorg/valkyrienskies/core/api/ships/DragController;", "getDragController", "()Lorg/valkyrienskies/core/api/ships/DragController;", "dragController", "J", "getId", "Lorg/valkyrienskies/core/impl/shadow/Ek;", "getInertia$impl", "setInertia$impl", "(Lorg/valkyrienskies/core/impl/shadow/Ek;)V", "Ljava/util/ArrayDeque;", "invForces", "Ljava/util/ArrayDeque;", "invPosForces", "invPosPositions", "invTorques", "isSleeping", "isSleeping$annotations", "setStatic", "isStatic$delegate", "Lorg/valkyrienskies/core/api/ships/properties/PhysPose;", "getKinematicTarget", "()Lorg/valkyrienskies/core/api/ships/properties/PhysPose;", "setKinematicTarget", "(Lorg/valkyrienskies/core/api/ships/properties/PhysPose;)V", "kinematicTarget", "p0", "Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "getKinematics", "()Lorg/valkyrienskies/core/api/bodies/properties/BodyKinematics;", "I", "getLastShipTeleportId$impl", "setLastShipTeleportId$impl", "(I)V", "getLiquidOverlap", "getLiquidOverlap$annotations", "liquidOverlap", "getMass", "mass", "Lorg/joml/Matrix3dc;", "getMomentOfInertia", "()Lorg/joml/Matrix3dc;", "momentOfInertia", "Ljava/util/List;", "getPhysicsListeners$impl", "setPhysicsListeners$impl", "(Ljava/util/List;)V", "Lorg/valkyrienskies/core/impl/shadow/FR;", "poseVel", "getPoseVel", "setPoseVel", "(Lorg/valkyrienskies/core/impl/shadow/Hc;)V", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "getPrevTickTransform", "()Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "prevTickTransform", "Lorg/valkyrienskies/core/impl/shadow/GY;", "getRigidBodyReference$impl", "rotForces", "rotTorques", "Lorg/joml/primitives/AABBic;", "getShipAABB", "()Lorg/joml/primitives/AABBic;", "shipAABB", "getSlug", "slug", "getVelocity", "velocity", "Lorg/valkyrienskies/core/impl/shadow/Ew;", "getWingManager$impl", "Lorg/joml/primitives/AABBdc;", "getWorldAABB", "()Lorg/joml/primitives/AABBdc;", "worldAABB", "<init>", "(JLorg/valkyrienskies/core/impl/shadow/GY;Ljava/util/List;Lorg/valkyrienskies/core/impl/shadow/Ek;Lorg/valkyrienskies/core/impl/shadow/Hc;ILorg/valkyrienskies/core/impl/shadow/FR;Lorg/valkyrienskies/core/impl/shadow/Ew;)V"})
public final class PhysShipImpl
implements VsiPhysShip {
    private final long id;
    private final GY<?> rigidBodyReference;
    private List<? extends ShipPhysicsListener> physicsListeners;
    private ek_0 inertia;
    private hc_0 _poseVel;
    private int lastShipTeleportId;
    private final FR physicsThreadChecker;
    private final ew_0 wingManager;
    private BodyKinematics kinematics;
    private final ArrayDeque<Vector3dc> invForces;
    private final ArrayDeque<Vector3dc> invTorques;
    private final ArrayDeque<Vector3dc> rotForces;
    private final ArrayDeque<Vector3dc> rotTorques;
    private final ArrayDeque<Vector3dc> invPosForces;
    private final ArrayDeque<Vector3dc> invPosPositions;

    /*
     * WARNING - void declaration
     */
    public PhysShipImpl(long id, GY<?> rigidBodyReference, List<? extends ShipPhysicsListener> physicsListeners, ek_0 inertia, hc_0 _poseVel, int lastShipTeleportId, FR physicsThreadChecker, ew_0 wingManager) {
        void var3_2;
        void var1_1;
        Intrinsics.checkNotNullParameter(rigidBodyReference, (String)"");
        Intrinsics.checkNotNullParameter(physicsListeners, (String)"");
        Intrinsics.checkNotNullParameter((Object)inertia, (String)"");
        Intrinsics.checkNotNullParameter((Object)_poseVel, (String)"");
        Intrinsics.checkNotNullParameter((Object)physicsThreadChecker, (String)"");
        Intrinsics.checkNotNullParameter((Object)wingManager, (String)"");
        this.id = var1_1;
        this.rigidBodyReference = var3_2;
        this.physicsListeners = physicsListeners;
        this.inertia = inertia;
        this._poseVel = _poseVel;
        this.lastShipTeleportId = lastShipTeleportId;
        this.physicsThreadChecker = physicsThreadChecker;
        this.wingManager = wingManager;
        this.updatePhysTransform();
        this.invForces = new ArrayDeque();
        this.invTorques = new ArrayDeque();
        this.rotForces = new ArrayDeque();
        this.rotTorques = new ArrayDeque();
        this.invPosForces = new ArrayDeque();
        this.invPosPositions = new ArrayDeque();
    }

    public /* synthetic */ PhysShipImpl(long l2, GY gY, List list, ek_0 ek_02, hc_0 hc_02, int n2, FR fR, ew_0 ew_02, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 0x80) != 0) {
            ew_02 = new ew_0();
        }
        this(l2, gY, list, ek_02, hc_02, n2, fR, ew_02);
    }

    @Override
    @JvmName(name="getId")
    public final long getId() {
        return this.id;
    }

    @JvmName(name="getRigidBodyReference$impl")
    public final GY<?> getRigidBodyReference$impl() {
        return this.rigidBodyReference;
    }

    @JvmName(name="getPhysicsListeners$impl")
    public final List<ShipPhysicsListener> getPhysicsListeners$impl() {
        return this.physicsListeners;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="setPhysicsListeners$impl")
    public final void setPhysicsListeners$impl(List<? extends ShipPhysicsListener> list) {
        void var1_1;
        Intrinsics.checkNotNullParameter(list, (String)"");
        this.physicsListeners = var1_1;
    }

    @JvmName(name="getInertia$impl")
    public final ek_0 getInertia$impl() {
        return this.inertia;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="setInertia$impl")
    public final void setInertia$impl(ek_0 ek_02) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)ek_02, (String)"");
        this.inertia = var1_1;
    }

    @JvmName(name="getLastShipTeleportId$impl")
    public final int getLastShipTeleportId$impl() {
        return this.lastShipTeleportId;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="setLastShipTeleportId$impl")
    public final void setLastShipTeleportId$impl(int n2) {
        void var1_1;
        this.lastShipTeleportId = var1_1;
    }

    @JvmName(name="getWingManager$impl")
    public final ew_0 getWingManager$impl() {
        return this.wingManager;
    }

    @JvmName(name="getPoseVel")
    public final hc_0 getPoseVel() {
        return this._poseVel;
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="setPoseVel")
    public final void setPoseVel(hc_0 poseVel) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)poseVel, (String)"");
        this._poseVel = var1_1;
        this.updatePhysTransform();
    }

    @Override
    @JvmName(name="isStatic")
    public final boolean isStatic() {
        return this.rigidBodyReference.f();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setStatic")
    public final void setStatic(boolean bl) {
        void var1_1;
        this.rigidBodyReference.a((boolean)var1_1);
    }

    private static Object isStatic$delegate(PhysShipImpl physShipImpl) {
        PhysShipImpl physShipImpl2;
        return Reflection.mutableProperty0((MutablePropertyReference0)((MutablePropertyReference0)new MutablePropertyReference0Impl(physShipImpl2.rigidBodyReference, GY.class, "isStatic", "isStatic()Z", 0)));
    }

    @Override
    @JvmName(name="getKinematicTarget")
    public final PhysPose getKinematicTarget() {
        PhysPoseImpl physPoseImpl;
        hb_0 hb_02 = this.rigidBodyReference.o();
        if (hb_02 != null) {
            hb_0 hb_03 = hb_02;
            Intrinsics.checkNotNullParameter((Object)hb_02, (String)"");
            hb_0 hb_04 = hb_03;
            hb_0 hb_05 = hb_04;
            hb_05 = hb_03;
            physPoseImpl = new PhysPoseImpl(hb_04.a, hb_05.b);
        } else {
            physPoseImpl = null;
        }
        return physPoseImpl;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setKinematicTarget")
    public final void setKinematicTarget(PhysPose value) {
        hb_0 hb_02;
        void var1_1;
        void v0 = var1_1;
        if (v0 != null) {
            var1_1 = v0;
            Intrinsics.checkNotNullParameter((Object)v0, (String)"");
            hb_02 = new hb_0(var1_1.getPos(), var1_1.getRot());
        } else {
            hb_02 = null;
        }
        this.rigidBodyReference.a(hb_02);
    }

    @Override
    @JvmName(name="getKinematics")
    public final BodyKinematics getKinematics() {
        BodyKinematics bodyKinematics = this.kinematics;
        if (bodyKinematics != null) {
            return bodyKinematics;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"");
        return null;
    }

    @Override
    @JvmName(name="getDragController")
    public final DragController getDragController() {
        Object object;
        Object object2;
        block2: {
            object2 = this.physicsListeners;
            object2 = object2.iterator();
            while (object2.hasNext()) {
                Object e2 = object2.next();
                ShipPhysicsListener shipPhysicsListener = (ShipPhysicsListener)e2;
                if (!(shipPhysicsListener instanceof DragController)) continue;
                object = e2;
                break block2;
            }
            object = object2 = null;
        }
        if (object instanceof DragController) {
            return (DragController)object2;
        }
        return null;
    }

    @Override
    @JvmName(name="getBuoyantFactor")
    public final double getBuoyantFactor() {
        return this.rigidBodyReference.l();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setBuoyantFactor")
    public final void setBuoyantFactor(double d2) {
        void var1_1;
        this.rigidBodyReference.e((double)var1_1);
    }

    @VsBeta
    public static /* synthetic */ void getBuoyantFactor$annotations() {
    }

    private static Object getBuoyantFactor$delegate(PhysShipImpl physShipImpl) {
        PhysShipImpl physShipImpl2;
        return Reflection.mutableProperty0((MutablePropertyReference0)((MutablePropertyReference0)new MutablePropertyReference0Impl(physShipImpl2.rigidBodyReference, GY.class, "buoyantFactor", "getBuoyantFactor()D", 0)));
    }

    @Override
    @JvmName(name="getDoFluidDrag")
    public final boolean getDoFluidDrag() {
        return this.rigidBodyReference.m();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setDoFluidDrag")
    public final void setDoFluidDrag(boolean bl) {
        void var1_1;
        this.rigidBodyReference.b((boolean)var1_1);
    }

    @VsBeta
    public static /* synthetic */ void getDoFluidDrag$annotations() {
    }

    private static Object getDoFluidDrag$delegate(PhysShipImpl physShipImpl) {
        PhysShipImpl physShipImpl2;
        return Reflection.mutableProperty0((MutablePropertyReference0)((MutablePropertyReference0)new MutablePropertyReference0Impl(physShipImpl2.rigidBodyReference, GY.class, "doFluidDrag", "getDoFluidDrag()Z", 0)));
    }

    @Override
    @JvmName(name="getMomentOfInertia")
    public final Matrix3dc getMomentOfInertia() {
        return this.inertia.getMomentOfInertiaTensor();
    }

    @Override
    @JvmName(name="getLiquidOverlap")
    public final double getLiquidOverlap() {
        return this.rigidBodyReference.s();
    }

    @VsBeta
    public static /* synthetic */ void getLiquidOverlap$annotations() {
    }

    @Override
    @JvmName(name="isSleeping")
    public final boolean isSleeping() {
        return this.rigidBodyReference.r();
    }

    @VsBeta
    public static /* synthetic */ void isSleeping$annotations() {
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void applyWorldForce(Vector3dc forceInWorld, Vector3dc posInWorld) {
        void var1_1;
        Vector3d vector3d;
        Intrinsics.checkNotNullParameter((Object)forceInWorld, (String)"");
        Intrinsics.checkNotNullParameter((Object)posInWorld, (String)"");
        PhysShipImpl physShipImpl = this;
        if (!physShipImpl.canApplyWrenches(physShipImpl.isStatic(), forceInWorld, posInWorld)) {
            return;
        }
        vector3d = this.getKinematics().getTransform().getToModel().transformPosition(vector3d, new Vector3d());
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"");
        this.applyWorldForceToModelPos((Vector3dc)var1_1, vector3d);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void applyWorldForceToModelPos(Vector3dc forceInWorld, Vector3dc posInShip) {
        void var1_1;
        Vector3d vector3d;
        Intrinsics.checkNotNullParameter((Object)forceInWorld, (String)"");
        Intrinsics.checkNotNullParameter((Object)posInShip, (String)"");
        PhysShipImpl physShipImpl = this;
        if (!physShipImpl.canApplyWrenches(physShipImpl.isStatic(), forceInWorld, posInShip)) {
            return;
        }
        vector3d = new Vector3d(vector3d).sub(this.getKinematics().getPositionInModel());
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"");
        this.applyWorldForceToBodyPos((Vector3dc)var1_1, vector3d);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void applyWorldForceToBodyPos(Vector3dc forceInWorld, Vector3dc posInBody) {
        void var1_1;
        void var2_2;
        Intrinsics.checkNotNullParameter((Object)forceInWorld, (String)"");
        Intrinsics.checkNotNullParameter((Object)posInBody, (String)"");
        PhysShipImpl physShipImpl = this;
        if (!physShipImpl.canApplyWrenches(physShipImpl.isStatic(), forceInWorld, posInBody)) {
            return;
        }
        this.invPosPositions.add((Vector3dc)var2_2);
        this.invPosForces.add((Vector3dc)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void applyWorldTorque(Vector3dc torqueInWorld) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)torqueInWorld, (String)"");
        PhysShipImpl physShipImpl = this;
        if (!PhysShipImpl.canApplyWrenches$default(physShipImpl, physShipImpl.isStatic(), torqueInWorld, null, 4, null)) {
            return;
        }
        this.invTorques.add((Vector3dc)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void applyModelForce(Vector3dc forceInShip, Vector3dc posInShip) {
        void var1_1;
        Vector3d vector3d;
        Intrinsics.checkNotNullParameter((Object)forceInShip, (String)"");
        Intrinsics.checkNotNullParameter((Object)posInShip, (String)"");
        PhysShipImpl physShipImpl = this;
        if (!physShipImpl.canApplyWrenches(physShipImpl.isStatic(), forceInShip, posInShip)) {
            return;
        }
        vector3d = new Vector3d(vector3d).sub(this.getKinematics().getPositionInModel());
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"");
        this.applyBodyForce((Vector3dc)var1_1, vector3d);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void applyModelTorque(Vector3dc torqueInShip) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)torqueInShip, (String)"");
        PhysShipImpl physShipImpl = this;
        if (!PhysShipImpl.canApplyWrenches$default(physShipImpl, physShipImpl.isStatic(), torqueInShip, null, 4, null)) {
            return;
        }
        this.applyBodyTorque((Vector3dc)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void applyBodyForce(Vector3dc forceInBody, Vector3dc posInBody) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)forceInBody, (String)"");
        Intrinsics.checkNotNullParameter((Object)posInBody, (String)"");
        PhysShipImpl physShipImpl = this;
        if (!physShipImpl.canApplyWrenches(physShipImpl.isStatic(), forceInBody, posInBody)) {
            return;
        }
        PhysShipImpl physShipImpl2 = this;
        Vector3d vector3d = physShipImpl2.scaleForceToWorld((Vector3dc)var1_1);
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"");
        this.invPosForces.add(physShipImpl2.rotateForceToWorld(vector3d));
        this.invPosPositions.add((Vector3dc)var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void applyBodyTorque(Vector3dc torqueInBody) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)torqueInBody, (String)"");
        PhysShipImpl physShipImpl = this;
        if (!PhysShipImpl.canApplyWrenches$default(physShipImpl, physShipImpl.isStatic(), torqueInBody, null, 4, null)) {
            return;
        }
        this.rotTorques.add(this.scaleTorqueToWorld((Vector3dc)var1_1));
    }

    /*
     * WARNING - void declaration
     */
    private final Vector3d rotateForceToWorld(Vector3dc $this$rotateForceToWorld) {
        void var1_1;
        hc_0 hc_02 = this.getPoseVel();
        return hc_02.c.transform((Vector3dc)var1_1, new Vector3d());
    }

    private final Vector3d scaleForceToWorld(Vector3dc $this$scaleForceToWorld) {
        Vector3dc vector3dc;
        Vector3d vector3d = new Vector3d(vector3dc);
        vector3dc = this.getKinematics().getScaling();
        Vector3d vector3d2 = vector3d;
        double d2 = vector3dc.x() * vector3dc.y() * vector3dc.z();
        return vector3d2.mul(d2);
    }

    private final Vector3d scaleTorqueToWorld(Vector3dc $this$scaleTorqueToWorld) {
        Vector3dc vector3dc;
        Vector3d vector3d = new Vector3d(vector3dc);
        vector3dc = this.getKinematics().getScaling();
        Vector3d vector3d2 = vector3d;
        double d2 = vector3dc.x() * vector3dc.x() * vector3dc.x() * vector3dc.x() * vector3dc.x();
        return vector3d2.mul(d2);
    }

    /*
     * WARNING - void declaration
     */
    private final boolean canApplyWrenches(boolean isStatic, Vector3dc vec0, Vector3dc vec1) {
        void var1_1;
        void var3_3;
        ga_0.a(vec0);
        void v0 = var3_3;
        if (v0 != null) {
            void var2_2 = v0;
            ga_0.a((Vector3dc)v0);
        }
        this.physicsThreadChecker.assertIsPhysicsThread();
        return var1_1 == false;
    }

    static /* synthetic */ boolean canApplyWrenches$default(PhysShipImpl physShipImpl, boolean bl, Vector3dc vector3dc, Vector3dc vector3dc2, int n2, Object object) {
        if ((n2 & 4) != 0) {
            vector3dc2 = null;
        }
        return physShipImpl.canApplyWrenches(bl, vector3dc, vector3dc2);
    }

    @Override
    @JvmName(name="getCenterOfMass")
    public final Vector3dc getCenterOfMass() {
        return this.inertia.getCenterOfMassInShip();
    }

    @Override
    @JvmName(name="getMass")
    public final double getMass() {
        return this.inertia.getMass();
    }

    @Override
    @JvmName(name="getVelocity")
    public final Vector3dc getVelocity() {
        hc_0 hc_02 = this.getPoseVel();
        return hc_02.d;
    }

    @Override
    @JvmName(name="getAngularVelocity")
    public final Vector3dc getAngularVelocity() {
        hc_0 hc_02 = this.getPoseVel();
        return hc_02.e;
    }

    public final void applyQueuedForces() {
        Object object;
        if (this.isStatic()) {
            return;
        }
        double d2 = 0.1 * this.getMass();
        double d3 = d2 * d2;
        Function1 function1 = (Function1)new Function1<Vector3dc, Boolean>(d3){
            private /* synthetic */ double $a;
            {
                this.$a = d2;
                super(1);
            }

            public final Boolean a(Vector3dc vector3dc) {
                Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
                return vector3dc.lengthSquared() > this.$a;
            }

            /*
             * WARNING - void declaration
             */
            public final /* synthetic */ Object invoke(Object p1) {
                void var1_1;
                return this.a((Vector3dc)var1_1);
            }
        };
        Object object2 = this.invForces;
        Object object3 = this.rigidBodyReference;
        while (object2.poll() != null) {
            if (!((Boolean)function1.invoke(object)).booleanValue()) continue;
            object = (Vector3dc)object;
            object3.e((Vector3dc)object);
        }
        object2 = this.invTorques;
        object3 = this.rigidBodyReference;
        while (object2.poll() != null) {
            if (!((Boolean)function1.invoke(object)).booleanValue()) continue;
            object = (Vector3dc)object;
            object3.c((Vector3dc)object);
        }
        object2 = this.rotForces;
        object3 = this.rigidBodyReference;
        while (object2.poll() != null) {
            if (!((Boolean)function1.invoke(object)).booleanValue()) continue;
            object = (Vector3dc)object;
            object3.d((Vector3dc)object);
        }
        object2 = this.rotTorques;
        object3 = this.rigidBodyReference;
        while (object2.poll() != null) {
            if (!((Boolean)function1.invoke(object)).booleanValue()) continue;
            object = (Vector3dc)object;
            object3.b((Vector3dc)object);
        }
        while (!((Collection)this.invPosForces).isEmpty()) {
            object2 = this.invPosPositions.removeFirst();
            object3 = this.invPosForces.removeFirst();
            Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"");
            if (!((Boolean)function1.invoke(object3)).booleanValue()) continue;
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"");
            this.rigidBodyReference.a((Vector3dc)object2, (Vector3dc)object3);
        }
        if (!this.invPosPositions.isEmpty()) {
            throw new IllegalStateException("Check failed.");
        }
        if (!this.invPosForces.isEmpty()) {
            throw new IllegalStateException("Check failed.");
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Deprecated(message="Use applyWorldForce instead", replaceWith=@ReplaceWith(expression="applyWorldForce(force, posInWorld)", imports={}))
    public final void applyInvariantForce(Vector3dc force) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)force, (String)"");
        PhysShip.applyWorldForceToBodyPos$default(this, (Vector3dc)var1_1, null, 2, null);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Deprecated(message="Use applyWorldTorque instead", replaceWith=@ReplaceWith(expression="applyWorldTorque(torque)", imports={}))
    public final void applyInvariantTorque(Vector3dc torque) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)torque, (String)"");
        this.applyWorldTorque((Vector3dc)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Deprecated(message="Use applyModelForce or applyBodyForce instead", replaceWith=@ReplaceWith(expression="applyBodyForce(force, posInBody)", imports={}))
    public final void applyRotDependentForce(Vector3dc force) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)force, (String)"");
        PhysShip.applyBodyForce$default(this, (Vector3dc)var1_1, null, 2, null);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Deprecated(message="Use applyModelTorque or applyBodyTorque instead", replaceWith=@ReplaceWith(expression="applyBodyTorque(torque)", imports={}))
    public final void applyRotDependentTorque(Vector3dc torque) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)torque, (String)"");
        this.applyBodyTorque((Vector3dc)var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Deprecated(message="Use applyWorldForce instead", replaceWith=@ReplaceWith(expression="applyWorldForce(force, pos)", imports={}))
    public final void applyInvariantForceToPos(Vector3dc force, Vector3dc pos) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)force, (String)"");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"");
        this.applyWorldForceToBodyPos((Vector3dc)var1_1, (Vector3dc)var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Deprecated(message="Use applyModelForce or applyBodyForce instead", replaceWith=@ReplaceWith(expression="applyBodyForce(force, pos)", imports={}))
    public final void applyRotDependentForceToPos(Vector3dc force, Vector3dc pos) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)force, (String)"");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"");
        this.applyBodyForce((Vector3dc)var1_1, (Vector3dc)var2_2);
    }

    private final void updatePhysTransform() {
        hc_0 hc_02 = this.getPoseVel();
        Vector3dc vector3dc = hc_02.d;
        hc_02 = this.getPoseVel();
        Vector3dc vector3dc2 = hc_02.e;
        hc_02 = this.getPoseVel();
        Vector3dc vector3dc3 = hc_02.b;
        hc_02 = this.getPoseVel();
        Quaterniondc quaterniondc = hc_02.c;
        Vector3dc vector3dc4 = new Vector3d(this.rigidBodyReference.j());
        Vector3d vector3d = new Vector3d(this.rigidBodyReference.k()).mul(-1.0);
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"");
        this.kinematics = BodyKinematicsFactory.INSTANCE.create(vector3dc, vector3dc2, vector3dc3, quaterniondc, vector3dc4, vector3d);
    }

    @Override
    @JvmName(name="getPrevTickTransform")
    public final ShipTransform getPrevTickTransform() {
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    @JvmName(name="getChunkClaim")
    public final ChunkClaim getChunkClaim() {
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    @JvmName(name="getChunkClaimDimension")
    public final String getChunkClaimDimension() {
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @JvmName(name="setChunkClaimDimension")
    public final void setChunkClaimDimension(String value) {
        Intrinsics.checkNotNullParameter((Object)value, (String)"");
    }

    @Override
    @JvmName(name="getWorldAABB")
    public final AABBdc getWorldAABB() {
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    @JvmName(name="getShipAABB")
    public final AABBic getShipAABB() {
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    @JvmName(name="getSlug")
    public final String getSlug() {
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    @JvmName(name="getActiveChunksSet")
    public final IShipActiveChunksSet getActiveChunksSet() {
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final void setFromTransform(BodyTransform transform2) {
        Intrinsics.checkNotNullParameter((Object)transform2, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final void unsafeSetKinematics(BodyKinematics kinematics) {
        Intrinsics.checkNotNullParameter((Object)kinematics, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    public final long component1() {
        return this.id;
    }

    public final GY<?> component2$impl() {
        return this.rigidBodyReference;
    }

    public final List<ShipPhysicsListener> component3$impl() {
        return this.physicsListeners;
    }

    public final ek_0 component4$impl() {
        return this.inertia;
    }

    private final hc_0 component5() {
        return this._poseVel;
    }

    public final int component6$impl() {
        return this.lastShipTeleportId;
    }

    private final FR component7() {
        return this.physicsThreadChecker;
    }

    public final ew_0 component8$impl() {
        return this.wingManager;
    }

    /*
     * WARNING - void declaration
     */
    public final PhysShipImpl copy(long id, GY<?> rigidBodyReference, List<? extends ShipPhysicsListener> physicsListeners, ek_0 inertia, hc_0 _poseVel, int lastShipTeleportId, FR physicsThreadChecker, ew_0 wingManager) {
        void var3_2;
        void var1_1;
        Intrinsics.checkNotNullParameter(rigidBodyReference, (String)"");
        Intrinsics.checkNotNullParameter(physicsListeners, (String)"");
        Intrinsics.checkNotNullParameter((Object)inertia, (String)"");
        Intrinsics.checkNotNullParameter((Object)_poseVel, (String)"");
        Intrinsics.checkNotNullParameter((Object)physicsThreadChecker, (String)"");
        Intrinsics.checkNotNullParameter((Object)wingManager, (String)"");
        return new PhysShipImpl((long)var1_1, (GY<?>)var3_2, physicsListeners, inertia, _poseVel, lastShipTeleportId, physicsThreadChecker, wingManager);
    }

    public static /* synthetic */ PhysShipImpl copy$default(PhysShipImpl physShipImpl, long l2, GY gY, List list, ek_0 ek_02, hc_0 hc_02, int n2, FR fR, ew_0 ew_02, int n3, Object object) {
        if ((n3 & 1) != 0) {
            l2 = physShipImpl.id;
        }
        if ((n3 & 2) != 0) {
            gY = physShipImpl.rigidBodyReference;
        }
        if ((n3 & 4) != 0) {
            list = physShipImpl.physicsListeners;
        }
        if ((n3 & 8) != 0) {
            ek_02 = physShipImpl.inertia;
        }
        if ((n3 & 0x10) != 0) {
            hc_02 = physShipImpl._poseVel;
        }
        if ((n3 & 0x20) != 0) {
            n2 = physShipImpl.lastShipTeleportId;
        }
        if ((n3 & 0x40) != 0) {
            fR = physShipImpl.physicsThreadChecker;
        }
        if ((n3 & 0x80) != 0) {
            ew_02 = physShipImpl.wingManager;
        }
        return physShipImpl.copy(l2, gY, list, ek_02, hc_02, n2, fR, ew_02);
    }

    public final String toString() {
        return "PhysShipImpl(id=" + this.id + ", rigidBodyReference=" + this.rigidBodyReference + ", physicsListeners=" + this.physicsListeners + ", inertia=" + this.inertia + ", _poseVel=" + this._poseVel + ", lastShipTeleportId=" + this.lastShipTeleportId + ", physicsThreadChecker=" + this.physicsThreadChecker + ", wingManager=" + this.wingManager + ")";
    }

    public final int hashCode() {
        int n2 = Long.hashCode(this.id);
        n2 = n2 * 31 + this.rigidBodyReference.hashCode();
        n2 = n2 * 31 + ((Object)this.physicsListeners).hashCode();
        n2 = n2 * 31 + this.inertia.hashCode();
        n2 = n2 * 31 + this._poseVel.hashCode();
        n2 = n2 * 31 + Integer.hashCode(this.lastShipTeleportId);
        n2 = n2 * 31 + this.physicsThreadChecker.hashCode();
        n2 = n2 * 31 + this.wingManager.hashCode();
        return n2;
    }

    public final boolean equals(Object other) {
        PhysShipImpl physShipImpl;
        if (this == other) {
            return true;
        }
        if (!(other instanceof PhysShipImpl)) {
            return false;
        }
        physShipImpl = physShipImpl;
        if (this.id != physShipImpl.id) {
            return false;
        }
        if (!Intrinsics.areEqual(this.rigidBodyReference, physShipImpl.rigidBodyReference)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.physicsListeners, physShipImpl.physicsListeners)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.inertia, (Object)physShipImpl.inertia)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this._poseVel, (Object)physShipImpl._poseVel)) {
            return false;
        }
        if (this.lastShipTeleportId != physShipImpl.lastShipTeleportId) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.physicsThreadChecker, (Object)physShipImpl.physicsThreadChecker)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.wingManager, (Object)physShipImpl.wingManager);
    }
}

