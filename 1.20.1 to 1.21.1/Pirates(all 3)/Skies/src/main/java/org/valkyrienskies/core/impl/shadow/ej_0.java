/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.NotImplementedError
 *  kotlin.ReplaceWith
 *  kotlin.Triple
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.DoubleUnaryOperator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.ReplaceWith;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3dc;
import org.joml.Vector3ic;
import org.joml.primitives.AABBdc;
import org.valkyrienskies.core.api.ships.LoadedServerShip;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.core.api.util.AerodynamicUtils;
import org.valkyrienskies.core.api.world.LevelYRange;
import org.valkyrienskies.core.api.world.connectivity.ConnectionStatus;
import org.valkyrienskies.core.api.world.connectivity.DoubleAugmentation;
import org.valkyrienskies.core.api.world.connectivity.DoubleComponentAugmentation;
import org.valkyrienskies.core.impl.shadow.em_0;
import org.valkyrienskies.core.internal.ShipTeleportData;
import org.valkyrienskies.core.internal.VsiGameServer;
import org.valkyrienskies.core.internal.physics.PhysicsEntityData;
import org.valkyrienskies.core.internal.physics.PhysicsEntityServer;
import org.valkyrienskies.core.internal.ships.VsiQueryableShipData;
import org.valkyrienskies.core.internal.world.VsiPlayer;
import org.valkyrienskies.core.internal.world.VsiServerShipWorld;
import org.valkyrienskies.core.internal.world.chunks.VsiBlockType;
import org.valkyrienskies.core.internal.world.chunks.VsiChunkUnwatchTask;
import org.valkyrienskies.core.internal.world.chunks.VsiChunkWatchTask;
import org.valkyrienskies.core.internal.world.chunks.VsiChunkWatchTasks;
import org.valkyrienskies.core.internal.world.chunks.VsiTerrainUpdate;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Ej
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u00fe\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u000b\b\u0002\u00a2\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001J;\u0010\r\u001a\u00020\f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0011\u001a\u00020\f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00060\u0013j\u0002`\u00142\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J;\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00182\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aJ;\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00182\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001aJ\u001f\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u001f\u0010 J3\u0010$\u001a\u00020#2\u0006\u0010\u0004\u001a\u00020!2\u0006\u0010\u0006\u001a\u00020\"2\u0006\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\b$\u0010%J#\u0010(\u001a\u00020'2\u0006\u0010\u0004\u001a\u00020&2\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\b(\u0010)J\u001b\u0010*\u001a\u00020\f2\n\u0010\u0004\u001a\u00060\u0013j\u0002`\u0014H\u0016\u00a2\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020#H\u0016\u00a2\u0006\u0004\b,\u0010-J;\u0010.\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00182\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\b.\u0010\u001aJ;\u0010/\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00182\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\b/\u00100J3\u00101\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00182\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\b1\u00102J)\u00105\u001a\b\u0012\u0004\u0012\u00020!042\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u000203H\u0016\u00a2\u0006\u0004\b5\u00106J)\u00107\u001a\b\u0012\u0004\u0012\u00020!042\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u000203H\u0016\u00a2\u0006\u0004\b7\u00106J\u000f\u00109\u001a\u000208H\u0016\u00a2\u0006\u0004\b9\u0010:JK\u0010=\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180<\u0012\u0004\u0012\u00020\t0;2\u0006\u0010\u0004\u001a\u00020\u00172\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00032\b\u0010\b\u001a\u0004\u0018\u000103H\u0016\u00a2\u0006\u0004\b=\u0010>JK\u0010?\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180<\u0012\u0004\u0012\u00020\t0;2\u0006\u0010\u0004\u001a\u00020\u001e2\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00032\b\u0010\b\u001a\u0004\u0018\u000103H\u0016\u00a2\u0006\u0004\b?\u0010@JK\u0010A\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180<\u0012\u0004\u0012\u00020\t0;2\u0006\u0010\u0004\u001a\u00020\u00172\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00032\b\u0010\b\u001a\u0004\u0018\u000103H\u0016\u00a2\u0006\u0004\bA\u0010>JK\u0010B\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180<\u0012\u0004\u0012\u00020\t0;2\u0006\u0010\u0004\u001a\u00020\u001e2\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00032\b\u0010\b\u001a\u0004\u0018\u000103H\u0016\u00a2\u0006\u0004\bB\u0010@J1\u0010E\u001a\b\u0012\u0004\u0012\u00020D0C2\u0006\u0010\u0004\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00182\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\bE\u0010FJ\u001d\u0010I\u001a\b\u0012\u0004\u0012\u00020H0\u000f2\u0006\u0010\u0004\u001a\u00020GH\u0017\u00a2\u0006\u0004\bI\u0010JJ;\u0010K\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00182\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\bK\u0010\u001aJ;\u0010L\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00182\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\bL\u00100J3\u0010M\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00182\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\bM\u00102J3\u0010N\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00182\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\bN\u0010OJ+\u0010P\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00182\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\bP\u0010QJK\u0010U\u001a\u00020T2\u0006\u0010\u0004\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\u00182\u0006\u0010R\u001a\u00020\u00182\n\u0010S\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\bU\u0010VJK\u0010W\u001a\u00020T2\u0006\u0010\u0004\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\u00182\u0006\u0010R\u001a\u00020\u00182\n\u0010S\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\bW\u0010VJ3\u0010X\u001a\u00020T2\u0006\u0010\u0004\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00182\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\bX\u0010YJ3\u0010Z\u001a\u00020T2\u0006\u0010\u0004\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00182\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\bZ\u0010YJ\u0017\u0010[\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020DH\u0016\u00a2\u0006\u0004\b[\u0010\\JS\u0010_\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00182\n\u0010\n\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u000b\u001a\u00020]2\u0006\u0010R\u001a\u00020]2\u0006\u0010S\u001a\u00020\t2\u0006\u0010^\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b_\u0010`J;\u0010a\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00182\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\ba\u0010bJ;\u0010c\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00182\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\bc\u0010dJ\u001b\u0010e\u001a\u00020\f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\be\u0010fJ;\u0010g\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00182\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\bg\u0010bJ;\u0010h\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00182\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0004\bh\u0010dJ\u001f\u0010i\u001a\u0012\u0012\b\u0012\u00060\u0013j\u0002`\u0014\u0012\u0004\u0012\u00020'0;H\u0016\u00a2\u0006\u0004\bi\u0010jJC\u0010k\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00182\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010R\u001a\u00020\tH\u0016\u00a2\u0006\u0004\bk\u0010lJC\u0010m\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00182\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010R\u001a\u00020\tH\u0016\u00a2\u0006\u0004\bm\u0010nJ+\u0010r\u001a\u00020\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020p0o2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020q0oH\u0016\u00a2\u0006\u0004\br\u0010sJ\u0019\u0010u\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010tH\u0016\u00a2\u0006\u0004\bu\u0010vJC\u0010w\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00182\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010R\u001a\u00020\tH\u0016\u00a2\u0006\u0004\bw\u0010lJC\u0010x\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00182\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010R\u001a\u00020\tH\u0016\u00a2\u0006\u0004\bx\u0010nJ\u001f\u0010z\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020'2\u0006\u0010\u0006\u001a\u00020yH\u0016\u00a2\u0006\u0004\bz\u0010{J\u001f\u0010|\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020#2\u0006\u0010\u0006\u001a\u00020yH\u0016\u00a2\u0006\u0004\b|\u0010}JZ\u0010\u007f\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00182$\u0010\n\u001a \u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f0~2\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0005\b\u007f\u0010\u0080\u0001J\\\u0010\u0081\u0001\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00182$\u0010\n\u001a \u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f0~2\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a2\u0006\u0006\b\u0081\u0001\u0010\u0080\u0001JG\u0010\u0083\u0001\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00182\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u00032\u0007\u0010R\u001a\u00030\u0082\u0001H\u0016\u00a2\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J:\u0010\u0085\u0001\u001a\u00020\f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a2\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001JG\u0010\u0087\u0001\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00182\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u00032\u0007\u0010R\u001a\u00030\u0082\u0001H\u0016\u00a2\u0006\u0006\b\u0087\u0001\u0010\u0084\u0001R\u0018\u0010\u008b\u0001\u001a\u00030\u0088\u00018WX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001e\u0010\u008f\u0001\u001a\t\u0012\u0004\u0012\u00020#0\u008c\u00018WX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R*\u0010\u0091\u0001\u001a\u0016\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\b\u0012\u00060\u0013j\u0002`\u00140;8WX\u0096\u0004\u00a2\u0006\u0007\u001a\u0005\b\u0090\u0001\u0010jR&\u0010\u0094\u0001\u001a\t\u0012\u0004\u0012\u00020H0\u008c\u00018\u0017X\u0096\u0004\u00a2\u0006\u0010\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u008e\u0001R/\u0010\u009a\u0001\u001a\b\u0012\u0004\u0012\u00020D048\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0018\n\u0006\b\u008f\u0001\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Ej;", "Lorg/valkyrienskies/core/internal/world/VsiServerShipWorld;", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "p0", "Lorg/valkyrienskies/core/api/world/LevelYRange;", "p1", "Lorg/joml/Vector3dc;", "p2", "", "p3", "p4", "", "addDimension", "(Ljava/lang/String;Lorg/valkyrienskies/core/api/world/LevelYRange;Lorg/joml/Vector3dc;DD)V", "", "Lorg/valkyrienskies/core/internal/world/chunks/VsiTerrainUpdate;", "addTerrainUpdates", "(Ljava/lang/String;Ljava/util/List;)V", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "allocateShipId", "(Ljava/lang/String;)J", "Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;", "", "collectAirAugmentation", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;IIILjava/lang/String;)D", "collectSolidAugmentation", "createDoubleSumAugmentation", "(Ljava/lang/String;Ljava/lang/String;)Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;", "Lorg/valkyrienskies/core/api/world/connectivity/DoubleComponentAugmentation;", "createDoubleSumComponentAugmentation", "(Ljava/lang/String;Ljava/lang/String;)Lorg/valkyrienskies/core/api/world/connectivity/DoubleComponentAugmentation;", "Lorg/joml/Vector3ic;", "", "Lorg/valkyrienskies/core/api/ships/ServerShip;", "createNewShipAtBlock", "(Lorg/joml/Vector3ic;ZDLjava/lang/String;)Lorg/valkyrienskies/core/api/ships/ServerShip;", "Lorg/valkyrienskies/core/internal/physics/PhysicsEntityData;", "Lorg/valkyrienskies/core/internal/physics/PhysicsEntityServer;", "createPhysicsEntity", "(Lorg/valkyrienskies/core/internal/physics/PhysicsEntityData;Ljava/lang/String;)Lorg/valkyrienskies/core/internal/physics/PhysicsEntityServer;", "deletePhysicsEntity", "(J)V", "deleteShip", "(Lorg/valkyrienskies/core/api/ships/ServerShip;)V", "getAirAugmentation", "getAirComponentAugmentation", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleComponentAugmentation;IIILjava/lang/String;)D", "getAirComponentSize", "(IIILjava/lang/String;)J", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "", "getAllAirComponentsFromClaim", "(Ljava/lang/String;Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;)Ljava/util/Set;", "getAllSolidComponentsFromClaim", "Lorg/valkyrienskies/core/internal/world/chunks/VsiChunkWatchTasks;", "getChunkWatchTasks", "()Lorg/valkyrienskies/core/internal/world/chunks/VsiChunkWatchTasks;", "", "Lkotlin/Triple;", "getFromEachAirComponent", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;Ljava/lang/String;Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;)Ljava/util/Map;", "getFromEachAirComponentRoot", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleComponentAugmentation;Ljava/lang/String;Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;)Ljava/util/Map;", "getFromEachSolidComponent", "getFromEachSolidComponentRoot", "", "Lorg/valkyrienskies/core/internal/world/VsiPlayer;", "getIPlayersWatchingShipChunk", "(IILjava/lang/String;)Ljava/util/Iterator;", "Lorg/joml/primitives/AABBdc;", "Lorg/valkyrienskies/core/api/ships/LoadedServerShip;", "getShipObjectsIntersecting", "(Lorg/joml/primitives/AABBdc;)Ljava/util/List;", "getSolidAugmentation", "getSolidComponentAugmentation", "getSolidComponentSize", "isBlockInShipyard", "(IIILjava/lang/String;)Z", "isChunkInShipyard", "(IILjava/lang/String;)Z", "p5", "p6", "Lorg/valkyrienskies/core/api/world/connectivity/ConnectionStatus;", "isConnectedByAir", "(IIIIIILjava/lang/String;)Lorg/valkyrienskies/core/api/world/connectivity/ConnectionStatus;", "isConnectedBySolid", "isIsolatedAir", "(IIILjava/lang/String;)Lorg/valkyrienskies/core/api/world/connectivity/ConnectionStatus;", "isIsolatedSolid", "onDisconnect", "(Lorg/valkyrienskies/core/internal/world/VsiPlayer;)V", "Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;", "p7", "onSetBlock", "(IIILjava/lang/String;Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;DD)V", "removeAirAugmentation", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;IIILjava/lang/String;)V", "removeAirComponentAugmentation", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleComponentAugmentation;IIILjava/lang/String;)V", "removeDimension", "(Ljava/lang/String;)V", "removeSolidAugmentation", "removeSolidComponentAugmentation", "retrieveLoadedPhysicsEntities", "()Ljava/util/Map;", "setAirAugmentation", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;IIILjava/lang/String;D)V", "setAirComponentAugmentation", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleComponentAugmentation;IIILjava/lang/String;D)V", "", "Lorg/valkyrienskies/core/internal/world/chunks/VsiChunkWatchTask;", "Lorg/valkyrienskies/core/internal/world/chunks/VsiChunkUnwatchTask;", "setExecutedChunkWatchTasks", "(Ljava/lang/Iterable;Ljava/lang/Iterable;)V", "Lorg/valkyrienskies/core/internal/VsiGameServer;", "setGameServer", "(Lorg/valkyrienskies/core/internal/VsiGameServer;)V", "setSolidAugmentation", "setSolidComponentAugmentation", "Lorg/valkyrienskies/core/internal/ShipTeleportData;", "teleportPhysicsEntity", "(Lorg/valkyrienskies/core/internal/physics/PhysicsEntityServer;Lorg/valkyrienskies/core/internal/ShipTeleportData;)V", "teleportShip", "(Lorg/valkyrienskies/core/api/ships/ServerShip;Lorg/valkyrienskies/core/internal/ShipTeleportData;)V", "Lkotlin/Function4;", "traverseAirComponent", "(IIILkotlin/jvm/functions/Function4;Ljava/lang/String;)V", "traverseSolidComponent", "Ljava/util/function/DoubleUnaryOperator;", "updateAirAugmentation", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;IIILjava/lang/String;Ljava/util/function/DoubleUnaryOperator;)V", "updateDimension", "(Ljava/lang/String;Lorg/joml/Vector3dc;Ljava/lang/Double;Ljava/lang/Double;)V", "updateSolidAugmentation", "Lorg/valkyrienskies/core/api/util/AerodynamicUtils;", "getAerodynamicUtils", "()Lorg/valkyrienskies/core/api/util/AerodynamicUtils;", "a", "Lorg/valkyrienskies/core/internal/ships/VsiQueryableShipData;", "getAllShips", "()Lorg/valkyrienskies/core/internal/ships/VsiQueryableShipData;", "b", "getDimensionToGroundBodyIdImmutable", "c", "Lorg/valkyrienskies/core/internal/ships/VsiQueryableShipData;", "getLoadedShips", "d", "Ljava/util/Set;", "getPlayers", "()Ljava/util/Set;", "setPlayers", "(Ljava/util/Set;)V", "e", "<init>", "()V"})
public final class ej_0
implements VsiServerShipWorld {
    public static final ej_0 INSTANCE = new ej_0();
    private static Set<? extends VsiPlayer> b = SetsKt.emptySet();
    private static final VsiQueryableShipData<LoadedServerShip> c = new em_0(null, 1, null);

    private ej_0() {
    }

    @Override
    @JvmName(name="getPlayers")
    public final Set<VsiPlayer> getPlayers() {
        return b;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @JvmName(name="setPlayers")
    public final void setPlayers(Set<? extends VsiPlayer> set) {
        void var1_1;
        Intrinsics.checkNotNullParameter(set, (String)"");
        b = var1_1;
    }

    @Override
    public final void setGameServer(VsiGameServer gameServer) {
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void addTerrainUpdates(String dimensionId, List<? extends VsiTerrainUpdate> terrainUpdates) {
        void var2_2;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Intrinsics.checkNotNullParameter((Object)var2_2, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final Iterator<VsiPlayer> getIPlayersWatchingShipChunk(int chunkX, int chunkZ, String dimensionId) {
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        return CollectionsKt.emptyList().iterator();
    }

    @Override
    public final VsiChunkWatchTasks getChunkWatchTasks() {
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void setExecutedChunkWatchTasks(Iterable<? extends VsiChunkWatchTask> watchTasks, Iterable<? extends VsiChunkUnwatchTask> unwatchTasks) {
        void var2_2;
        Intrinsics.checkNotNullParameter(watchTasks, (String)"");
        Intrinsics.checkNotNullParameter((Object)var2_2, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final ServerShip createNewShipAtBlock(Vector3ic blockPosInWorldCoordinates, boolean createShipObjectImmediately, double scaling, String dimensionId) {
        Intrinsics.checkNotNullParameter((Object)blockPosInWorldCoordinates, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final PhysicsEntityServer createPhysicsEntity(PhysicsEntityData physicsEntityData, String dimensionId) {
        void var2_2;
        Intrinsics.checkNotNullParameter((Object)physicsEntityData, (String)"");
        Intrinsics.checkNotNullParameter((Object)var2_2, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final void deletePhysicsEntity(long id) {
    }

    @Override
    public final long allocateShipId(String dimensionId) {
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void addDimension(String dimensionId, LevelYRange yRange, Vector3dc gravity, double seaLevel, double maxY) {
        void var3_3;
        void var2_2;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Intrinsics.checkNotNullParameter((Object)var2_2, (String)"");
        Intrinsics.checkNotNullParameter((Object)var3_3, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void updateDimension(String dimensionId, Vector3dc gravity, Double seaLevel, Double maxY) {
        void var2_2;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Intrinsics.checkNotNullParameter((Object)var2_2, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final void removeDimension(String dimensionId) {
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final void onDisconnect(VsiPlayer player) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"");
    }

    @Override
    public final void deleteShip(ServerShip ship) {
        Intrinsics.checkNotNullParameter((Object)ship, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void teleportShip(ServerShip ship, ShipTeleportData teleportData) {
        void var2_2;
        Intrinsics.checkNotNullParameter((Object)ship, (String)"");
        Intrinsics.checkNotNullParameter((Object)var2_2, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void teleportPhysicsEntity(PhysicsEntityServer physicsEntityServer, ShipTeleportData teleportData) {
        void var2_2;
        Intrinsics.checkNotNullParameter((Object)physicsEntityServer, (String)"");
        Intrinsics.checkNotNullParameter((Object)var2_2, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    @JvmName(name="getDimensionToGroundBodyIdImmutable")
    public final Map<String, Long> getDimensionToGroundBodyIdImmutable() {
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final void onSetBlock(int posX, int posY, int posZ, String dimensionId, VsiBlockType oldBlockType, VsiBlockType newBlockType, double oldBlockMass, double newBlockMass) {
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Intrinsics.checkNotNullParameter((Object)oldBlockType, (String)"");
        Intrinsics.checkNotNullParameter((Object)newBlockType, (String)"");
    }

    @Override
    @JvmName(name="getAllShips")
    public final VsiQueryableShipData<ServerShip> getAllShips() {
        return this.getLoadedShips();
    }

    @Override
    @JvmName(name="getLoadedShips")
    public final VsiQueryableShipData<LoadedServerShip> getLoadedShips() {
        return c;
    }

    @Override
    public final Map<Long, PhysicsEntityServer> retrieveLoadedPhysicsEntities() {
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final boolean isChunkInShipyard(int chunkX, int chunkZ, String dimensionId) {
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        return false;
    }

    @Override
    public final boolean isBlockInShipyard(int blockX, int blockY, int blockZ, String dimensionId) {
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        return false;
    }

    @Override
    @Deprecated(message="redundant", replaceWith=@ReplaceWith(expression="loadedShips.getIntersecting(aabb)", imports={}))
    public final List<LoadedServerShip> getShipObjectsIntersecting(AABBdc aabb) {
        Intrinsics.checkNotNullParameter((Object)aabb, (String)"");
        return CollectionsKt.emptyList();
    }

    @Override
    @JvmName(name="getAerodynamicUtils")
    public final AerodynamicUtils getAerodynamicUtils() {
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final ConnectionStatus isConnectedByAir(int x1, int y1, int z1, int x2, int y2, int z2, String dimension) {
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final ConnectionStatus isConnectedBySolid(int x1, int y1, int z1, int x2, int y2, int z2, String dimension) {
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final ConnectionStatus isIsolatedAir(int x, int y, int z, String dimension) {
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final ConnectionStatus isIsolatedSolid(int x, int y, int z, String dimension) {
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final DoubleAugmentation createDoubleSumAugmentation(String modId, String key) {
        void var2_2;
        Intrinsics.checkNotNullParameter((Object)modId, (String)"");
        Intrinsics.checkNotNullParameter((Object)var2_2, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final DoubleComponentAugmentation createDoubleSumComponentAugmentation(String modId, String key) {
        void var2_2;
        Intrinsics.checkNotNullParameter((Object)modId, (String)"");
        Intrinsics.checkNotNullParameter((Object)var2_2, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final double getSolidAugmentation(DoubleAugmentation key, int x, int y, int z, String dimension) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final void setSolidAugmentation(DoubleAugmentation key, int x, int y, int z, String dimension, double value) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final void removeSolidAugmentation(DoubleAugmentation key, int x, int y, int z, String dimension) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final void updateSolidAugmentation(DoubleAugmentation key, int x, int y, int z, String dimension, DoubleUnaryOperator update) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        Intrinsics.checkNotNullParameter((Object)update, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final double collectSolidAugmentation(DoubleAugmentation key, int x, int y, int z, String dimension) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final void setSolidComponentAugmentation(DoubleComponentAugmentation key, int x, int y, int z, String dimension, double value) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final double getSolidComponentAugmentation(DoubleComponentAugmentation key, int x, int y, int z, String dimension) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final void removeSolidComponentAugmentation(DoubleComponentAugmentation key, int x, int y, int z, String dimension) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final Map<Triple<Integer, Integer, Integer>, Double> getFromEachSolidComponent(DoubleAugmentation key, String dimension, ChunkClaim chunkClaim) {
        void var2_2;
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)var2_2, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final Map<Triple<Integer, Integer, Integer>, Double> getFromEachSolidComponentRoot(DoubleComponentAugmentation key, String dimension, ChunkClaim chunkClaim) {
        void var2_2;
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)var2_2, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final long getSolidComponentSize(int x, int y, int z, String dimension) {
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final Set<Vector3ic> getAllSolidComponentsFromClaim(String dimensionId, ChunkClaim chunkClaim) {
        void var2_2;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Intrinsics.checkNotNullParameter((Object)var2_2, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final double getAirAugmentation(DoubleAugmentation key, int x, int y, int z, String dimension) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final void setAirAugmentation(DoubleAugmentation key, int x, int y, int z, String dimension, double value) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final void removeAirAugmentation(DoubleAugmentation key, int x, int y, int z, String dimension) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final void updateAirAugmentation(DoubleAugmentation key, int x, int y, int z, String dimension, DoubleUnaryOperator update) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        Intrinsics.checkNotNullParameter((Object)update, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final double collectAirAugmentation(DoubleAugmentation key, int x, int y, int z, String dimension) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final void setAirComponentAugmentation(DoubleComponentAugmentation key, int x, int y, int z, String dimension, double value) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final double getAirComponentAugmentation(DoubleComponentAugmentation key, int x, int y, int z, String dimension) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final void removeAirComponentAugmentation(DoubleComponentAugmentation key, int x, int y, int z, String dimension) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final long getAirComponentSize(int x, int y, int z, String dimension) {
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final void traverseSolidComponent(int x, int y, int z, Function4<? super Integer, ? super Integer, ? super Integer, ? super Long, Unit> action, String dimension) {
        Intrinsics.checkNotNullParameter(action, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final Map<Triple<Integer, Integer, Integer>, Double> getFromEachAirComponent(DoubleAugmentation key, String dimension, ChunkClaim chunkClaim) {
        void var2_2;
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)var2_2, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final Map<Triple<Integer, Integer, Integer>, Double> getFromEachAirComponentRoot(DoubleComponentAugmentation key, String dimension, ChunkClaim chunkClaim) {
        void var2_2;
        Intrinsics.checkNotNullParameter((Object)key, (String)"");
        Intrinsics.checkNotNullParameter((Object)var2_2, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Override
    public final void traverseAirComponent(int x, int y, int z, Function4<? super Integer, ? super Integer, ? super Integer, ? super Long, Unit> action, String dimension) {
        Intrinsics.checkNotNullParameter(action, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final Set<Vector3ic> getAllAirComponentsFromClaim(String dimensionId, ChunkClaim chunkClaim) {
        void var2_2;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Intrinsics.checkNotNullParameter((Object)var2_2, (String)"");
        String string = "Not yet implemented";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }
}

