/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Triple
 *  kotlin.Unit
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.DoubleUnaryOperator;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.logging.log4j.Logger;
import org.joml.Vector3i;
import org.joml.Vector3ic;
import org.valkyrienskies.core.api.events.MergeEvent;
import org.valkyrienskies.core.api.events.SplitEvent;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.core.api.world.LevelYRange;
import org.valkyrienskies.core.api.world.connectivity.ConnectionStatus;
import org.valkyrienskies.core.api.world.connectivity.DoubleAugmentation;
import org.valkyrienskies.core.api.world.connectivity.DoubleComponentAugmentation;
import org.valkyrienskies.core.impl.config.VSCoreConfig;
import org.valkyrienskies.core.impl.game.ChunkAllocatorProvider;
import org.valkyrienskies.core.impl.shadow.DP;
import org.valkyrienskies.core.impl.shadow.DT;
import org.valkyrienskies.core.impl.shadow.DU;
import org.valkyrienskies.core.impl.shadow.DY;
import org.valkyrienskies.core.impl.shadow.DZ;
import org.valkyrienskies.core.impl.shadow.FX;
import org.valkyrienskies.core.impl.shadow.ee_0;
import org.valkyrienskies.core.impl.shadow.ij_0;
import org.valkyrienskies.core.impl.shadow.il_0;
import org.valkyrienskies.core.impl.shadow.ip_0;
import org.valkyrienskies.core.util.datastructures.DenseBlockPosSet;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u00cc\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u0086\u00012\u00020\u0001:\u0002\u0086\u0001B7\b\u0007\u0012\u001a\b\u0001\u0010\u0083\u0001\u001a\u0013\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0005\u0012\u00030\u0082\u00010\u007f\u0012\u0006\u0010z\u001a\u00020y\u0012\u0006\u0010}\u001a\u00020|\u00a2\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J9\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\t\u00a2\u0006\u0004\b\f\u0010\rJE\u0010\u0014\u001a.\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00130\u0010j\b\u0012\u0004\u0012\u00020\u0013`\u00120\u000f2\n\u0010\u000e\u001a\u00060\bj\u0002`\t\u00a2\u0006\u0004\b\u0014\u0010\u0015J9\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\t\u00a2\u0006\u0004\b\u0016\u0010\rJE\u0010\u0017\u001a.\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00130\u0010j\b\u0012\u0004\u0012\u00020\u0013`\u00120\u000f2\n\u0010\u000e\u001a\u00060\bj\u0002`\t\u00a2\u0006\u0004\b\u0017\u0010\u0015J\u001d\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b\u00a2\u0006\u0004\b\u001c\u0010\u001dJ9\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\t\u00a2\u0006\u0004\b\u001e\u0010\rJ9\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\t\u00a2\u0006\u0004\b\u001f\u0010 J1\u0010\"\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\t\u00a2\u0006\u0004\b\"\u0010#J'\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010%\u001a\u00020$2\n\u0010\n\u001a\u00060\bj\u0002`\t\u00a2\u0006\u0004\b(\u0010)J'\u0010*\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010%\u001a\u00020$2\n\u0010\n\u001a\u00060\bj\u0002`\t\u00a2\u0006\u0004\b*\u0010)J\u0019\u0010,\u001a\u00020+2\n\u0010\u000e\u001a\u00060\bj\u0002`\t\u00a2\u0006\u0004\b,\u0010-JK\u00100\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040/\u0012\u0004\u0012\u00020\u000b0.2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\n\u001a\u00060\bj\u0002`\t2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u00a2\u0006\u0004\b0\u00101JK\u00102\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040/\u0012\u0004\u0012\u00020\u000b0.2\u0006\u0010\u0003\u001a\u00020\u001b2\n\u0010\n\u001a\u00060\bj\u0002`\t2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u00a2\u0006\u0004\b2\u00103JK\u00104\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040/\u0012\u0004\u0012\u00020\u000b0.2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\n\u001a\u00060\bj\u0002`\t2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u00a2\u0006\u0004\b4\u00101JK\u00105\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040/\u0012\u0004\u0012\u00020\u000b0.2\u0006\u0010\u0003\u001a\u00020\u001b2\n\u0010\n\u001a\u00060\bj\u0002`\t2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u00a2\u0006\u0004\b5\u00103J9\u00106\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\t\u00a2\u0006\u0004\b6\u0010\rJ9\u00107\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\t\u00a2\u0006\u0004\b7\u0010 J1\u00108\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\t\u00a2\u0006\u0004\b8\u0010#J;\u0010;\u001a\u0002092\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010:\u001a\u0002092\n\u0010\n\u001a\u00060\bj\u0002`\t\u00a2\u0006\u0004\b;\u0010<J;\u0010=\u001a\u0002092\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010:\u001a\u0002092\n\u0010\n\u001a\u00060\bj\u0002`\t\u00a2\u0006\u0004\b=\u0010<JQ\u0010F\u001a\u00020E2\n\u0010\u000e\u001a\u00060\bj\u0002`\t2\u0006\u0010>\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u0004\u00a2\u0006\u0004\bF\u0010GJ9\u0010H\u001a\u00020E2\n\u0010\u000e\u001a\u00060\bj\u0002`\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u0004\u00a2\u0006\u0004\bH\u0010IJK\u0010M\u001a\u00020L2\n\u0010\u000e\u001a\u00060\bj\u0002`\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u00042\u0010\b\u0002\u0010K\u001a\n\u0018\u00010!j\u0004\u0018\u0001`J\u00a2\u0006\u0004\bM\u0010NJI\u0010T\u001a\u00020L2\n\u0010\u000e\u001a\u00060\bj\u0002`\t2\u0006\u0010O\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u00042\u000e\u0010K\u001a\n\u0018\u00010!j\u0004\u0018\u0001`J2\u0006\u0010S\u001a\u00020R\u00a2\u0006\u0004\bT\u0010UJ1\u0010V\u001a\u00020L2\n\u0010\u000e\u001a\u00060\bj\u0002`\t2\u0006\u0010O\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u0004\u00a2\u0006\u0004\bV\u0010WJY\u0010]\u001a\u00020L2\n\u0010\u000e\u001a\u00060\bj\u0002`\t2\u000e\u0010K\u001a\n\u0018\u00010!j\u0004\u0018\u0001`J2\u000e\u0010X\u001a\n\u0018\u00010!j\u0004\u0018\u0001`J2\u0006\u0010Y\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u00042\u0006\u0010[\u001a\u00020\u00042\u0006\u0010\\\u001a\u00020\u0004\u00a2\u0006\u0004\b]\u0010^J9\u0010_\u001a\u00020L2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\t\u00a2\u0006\u0004\b_\u0010`J9\u0010a\u001a\u00020L2\u0006\u0010\u0003\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\t\u00a2\u0006\u0004\ba\u0010bJ9\u0010c\u001a\u00020L2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\t\u00a2\u0006\u0004\bc\u0010`J9\u0010d\u001a\u00020L2\u0006\u0010\u0003\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\t\u00a2\u0006\u0004\bd\u0010bJA\u0010f\u001a\u00020L2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010e\u001a\u00020\u000b\u00a2\u0006\u0004\bf\u0010gJA\u0010h\u001a\u00020L2\u0006\u0010\u0003\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010e\u001a\u00020\u000b\u00a2\u0006\u0004\bh\u0010iJA\u0010j\u001a\u00020L2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010e\u001a\u00020\u000b\u00a2\u0006\u0004\bj\u0010gJA\u0010k\u001a\u00020L2\u0006\u0010\u0003\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010e\u001a\u00020\u000b\u00a2\u0006\u0004\bk\u0010iJW\u0010n\u001a\u00020L2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042$\u0010m\u001a \u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020L0l2\n\u0010\n\u001a\u00060\bj\u0002`\t\u00a2\u0006\u0004\bn\u0010oJW\u0010p\u001a\u00020L2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042$\u0010m\u001a \u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020L0l2\n\u0010\n\u001a\u00060\bj\u0002`\t\u00a2\u0006\u0004\bp\u0010oJA\u0010s\u001a\u00020L2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010r\u001a\u00020q\u00a2\u0006\u0004\bs\u0010tJA\u0010u\u001a\u00020L2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010r\u001a\u00020q\u00a2\u0006\u0004\bu\u0010tJ/\u0010w\u001a\u00020L2\u0006\u0010v\u001a\u00020+2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\bw\u0010xR\u0014\u0010z\u001a\u00020y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0014\u0010}\u001a\u00020|8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b}\u0010~R'\u0010\u0080\u0001\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020+0\u007f8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R(\u0010\u0083\u0001\u001a\u0013\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0005\u0012\u00030\u0082\u00010\u007f8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0081\u0001\u00a8\u0006\u0087\u0001"}, d2={"Lorg/valkyrienskies/core/impl/game/connectivity/ConnectivityHandler;", "", "Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;", "key", "", "x", "y", "z", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "dimension", "", "collectAirAugmentation", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;IIILjava/lang/String;)D", "dimensionId", "Lkotlin/Pair;", "Ljava/util/HashSet;", "Lorg/valkyrienskies/core/api/events/SplitEvent;", "Lkotlin/collections/HashSet;", "Lorg/valkyrienskies/core/api/events/MergeEvent;", "collectAirEvents", "(Ljava/lang/String;)Lkotlin/Pair;", "collectSolidAugmentation", "collectSolidEvents", "modId", "createDoubleSumAugmentation", "(Ljava/lang/String;Ljava/lang/String;)Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;", "Lorg/valkyrienskies/core/api/world/connectivity/DoubleComponentAugmentation;", "createDoubleSumComponentAugmentation", "(Ljava/lang/String;Ljava/lang/String;)Lorg/valkyrienskies/core/api/world/connectivity/DoubleComponentAugmentation;", "getAirAugmentation", "getAirComponentAugmentation", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleComponentAugmentation;IIILjava/lang/String;)D", "", "getAirComponentSize", "(IIILjava/lang/String;)J", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "chunkClaim", "", "Lorg/joml/Vector3ic;", "getAllAirComponentsFromClaim", "(Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;Ljava/lang/String;)Ljava/util/Set;", "getAllSolidComponentsFromClaim", "Lorg/valkyrienskies/core/impl/game/connectivity/DimensionBlockConnGraphs;", "getConnGraph", "(Ljava/lang/String;)Lorg/valkyrienskies/core/impl/game/connectivity/DimensionBlockConnGraphs;", "", "Lkotlin/Triple;", "getFromEachAirComponent", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;Ljava/lang/String;Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;)Ljava/util/Map;", "getFromEachAirComponentRoot", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleComponentAugmentation;Ljava/lang/String;Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;)Ljava/util/Map;", "getFromEachSolidComponent", "getFromEachSolidComponentRoot", "getSolidAugmentation", "getSolidComponentAugmentation", "getSolidComponentSize", "Lorg/valkyrienskies/core/util/datastructures/DenseBlockPosSet;", "set", "indexAirComponent", "(IIILorg/valkyrienskies/core/util/datastructures/DenseBlockPosSet;Ljava/lang/String;)Lorg/valkyrienskies/core/util/datastructures/DenseBlockPosSet;", "indexSolidComponent", "x1", "y1", "z1", "x2", "y2", "z2", "voxelType", "Lorg/valkyrienskies/core/api/world/connectivity/ConnectionStatus;", "isConnected", "(Ljava/lang/String;IIIIIII)Lorg/valkyrienskies/core/api/world/connectivity/ConnectionStatus;", "isIsolated", "(Ljava/lang/String;IIII)Lorg/valkyrienskies/core/api/world/connectivity/ConnectionStatus;", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "shipId", "", "modVertex", "(Ljava/lang/String;IIIILjava/lang/Long;)V", "chunkX", "chunkY", "chunkZ", "Lorg/valkyrienskies/physics_api/voxel/updates/IVoxelShapeUpdate;", "voxelUpdate", "onChunkLoad", "(Ljava/lang/String;IIILjava/lang/Long;Lorg/valkyrienskies/physics_api/voxel/updates/IVoxelShapeUpdate;)V", "onChunkUnload", "(Ljava/lang/String;III)V", "worldId", "posX", "posY", "posZ", "newBlockType", "onSetBlock", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;IIII)V", "removeAirAugmentation", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;IIILjava/lang/String;)V", "removeAirComponentAugmentation", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleComponentAugmentation;IIILjava/lang/String;)V", "removeSolidAugmentation", "removeSolidComponentAugmentation", "value", "setAirAugmentation", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;IIILjava/lang/String;D)V", "setAirComponentAugmentation", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleComponentAugmentation;IIILjava/lang/String;D)V", "setSolidAugmentation", "setSolidComponentAugmentation", "Lkotlin/Function4;", "action", "traverseAirComponent", "(IIILkotlin/jvm/functions/Function4;Ljava/lang/String;)V", "traverseSolidComponent", "Ljava/util/function/DoubleUnaryOperator;", "update", "updateAirAugmentation", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;IIILjava/lang/String;Ljava/util/function/DoubleUnaryOperator;)V", "updateSolidAugmentation", "dimensionGraphs", "wipeChunk", "(Lorg/valkyrienskies/core/impl/game/connectivity/DimensionBlockConnGraphs;III)V", "Lorg/valkyrienskies/core/impl/game/connectivity/augmentation/AugmentationFactory;", "augmentationFactory", "Lorg/valkyrienskies/core/impl/game/connectivity/augmentation/AugmentationFactory;", "Lorg/valkyrienskies/core/impl/game/ChunkAllocatorProvider;", "chunkAllocators", "Lorg/valkyrienskies/core/impl/game/ChunkAllocatorProvider;", "", "connGraphs", "Ljava/util/Map;", "Lorg/valkyrienskies/core/impl/game/DimensionInfo;", "dimensionInfo", "<init>", "(Ljava/util/Map;Lorg/valkyrienskies/core/impl/game/connectivity/augmentation/AugmentationFactory;Lorg/valkyrienskies/core/impl/game/ChunkAllocatorProvider;)V", "Companion", "impl"})
public final class DW {
    public static final a a = new a(null);
    private final Map<String, DP> b;
    private final DZ c;
    private final ChunkAllocatorProvider d;
    private final Map<String, DY> e;
    private static final Logger f = FX.a("5G Cell Tower");

    @Inject
    public DW(@Named(value="dimensionInfo") Map<String, DP> map2, DZ dZ2, ChunkAllocatorProvider chunkAllocatorProvider) {
        Intrinsics.checkNotNullParameter(map2, (String)"");
        Intrinsics.checkNotNullParameter((Object)dZ2, (String)"");
        Intrinsics.checkNotNullParameter((Object)chunkAllocatorProvider, (String)"");
        this.b = map2;
        this.c = dZ2;
        this.d = chunkAllocatorProvider;
        this.e = new LinkedHashMap();
    }

    public final DoubleAugmentation a(String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"");
        return this.c.a(string + ":" + string2);
    }

    public final DoubleComponentAugmentation b(String object, String object2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        object2 = (String)object + ":" + (String)object2;
        object = this.c;
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        if (((DZ)object).a.containsKey(object2)) {
            DoubleAugmentation doubleAugmentation = ((DZ)object).a.get(object2);
            Intrinsics.checkNotNull((Object)doubleAugmentation);
            return (DoubleComponentAugmentation)doubleAugmentation;
        }
        ee_0 ee_02 = new ee_0((String)object2);
        ((DZ)object).a.put((String)object2, ee_02);
        return ee_02;
    }

    public final double a(DoubleAugmentation doubleAugmentation, int n2, int n3, int n4, String object) {
        Intrinsics.checkNotNullParameter((Object)doubleAugmentation, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = this.c((String)object);
        return ((DY)object).a.a(doubleAugmentation, n2, n3, n4);
    }

    public final void a(DoubleAugmentation doubleAugmentation, int n2, int n3, int n4, String object, double d2) {
        Intrinsics.checkNotNullParameter((Object)doubleAugmentation, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = this.c((String)object);
        ((DY)object).a.a(doubleAugmentation, n2, n3, n4, d2);
    }

    public final void a(DoubleAugmentation doubleAugmentation, int n2, int n3, int n4, String object, DoubleUnaryOperator doubleUnaryOperator) {
        Intrinsics.checkNotNullParameter((Object)doubleAugmentation, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Intrinsics.checkNotNullParameter((Object)doubleUnaryOperator, (String)"");
        object = this.c((String)object);
        ((DY)object).a.a(doubleAugmentation, n2, n3, n4, doubleUnaryOperator);
    }

    public final void b(DoubleAugmentation doubleAugmentation, int n2, int n3, int n4, String object) {
        Intrinsics.checkNotNullParameter((Object)doubleAugmentation, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = this.c((String)object);
        ((DY)object).a.b(doubleAugmentation, n2, n3, n4);
    }

    public final double c(DoubleAugmentation doubleAugmentation, int n2, int n3, int n4, String object) {
        Intrinsics.checkNotNullParameter((Object)doubleAugmentation, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = this.c((String)object);
        return ((DY)object).a.c(doubleAugmentation, n2, n3, n4);
    }

    public final void a(DoubleComponentAugmentation doubleComponentAugmentation, int n2, int n3, int n4, String object, double d2) {
        Intrinsics.checkNotNullParameter((Object)doubleComponentAugmentation, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = this.c((String)object);
        ((DY)object).a.a(doubleComponentAugmentation, n2, n3, n4, d2);
    }

    public final double a(DoubleComponentAugmentation doubleComponentAugmentation, int n2, int n3, int n4, String object) {
        Intrinsics.checkNotNullParameter((Object)doubleComponentAugmentation, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = this.c((String)object);
        return ((DY)object).a.a(doubleComponentAugmentation, n2, n3, n4);
    }

    public final void b(DoubleComponentAugmentation doubleComponentAugmentation, int n2, int n3, int n4, String object) {
        Intrinsics.checkNotNullParameter((Object)doubleComponentAugmentation, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = this.c((String)object);
        ((DY)object).a.b(doubleComponentAugmentation, n2, n3, n4);
    }

    public final long a(int n2, int n3, int n4, String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = this.c((String)object);
        return ((DY)object).a.g(n2, n3, n4);
    }

    public final Map<Triple<Integer, Integer, Integer>, Double> a(DoubleAugmentation doubleAugmentation, String object, ChunkClaim chunkClaim) {
        Intrinsics.checkNotNullParameter((Object)doubleAugmentation, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = this.c((String)object);
        return ((DY)object).a.a(doubleAugmentation, chunkClaim);
    }

    private static /* synthetic */ Map a$default(DW dW, DoubleAugmentation doubleAugmentation, String string, ChunkClaim chunkClaim, int n2) {
        if ((n2 & 4) != 0) {
            chunkClaim = null;
        }
        return dW.a(doubleAugmentation, string, chunkClaim);
    }

    public final Map<Triple<Integer, Integer, Integer>, Double> a(DoubleComponentAugmentation doubleComponentAugmentation, String object, ChunkClaim chunkClaim) {
        Intrinsics.checkNotNullParameter((Object)doubleComponentAugmentation, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = this.c((String)object);
        return ((DY)object).a.a(doubleComponentAugmentation, chunkClaim);
    }

    private static /* synthetic */ Map a$default(DW dW, DoubleComponentAugmentation doubleComponentAugmentation, String string, ChunkClaim chunkClaim, int n2) {
        if ((n2 & 4) != 0) {
            chunkClaim = null;
        }
        return dW.a(doubleComponentAugmentation, string, chunkClaim);
    }

    public final Set<Vector3ic> a(ChunkClaim chunkClaim, String object) {
        Intrinsics.checkNotNullParameter((Object)chunkClaim, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = this.c((String)object);
        return ((DY)object).a.a(chunkClaim);
    }

    public final void a(int n2, int n3, int n4, Function4<? super Integer, ? super Integer, ? super Integer, ? super Long, Unit> function4, String object) {
        Intrinsics.checkNotNullParameter(function4, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = this.c((String)object);
        ((DY)object).a.a(n2, n3, n4, function4);
    }

    private DenseBlockPosSet a(int n2, int n3, int n4, DenseBlockPosSet denseBlockPosSet, String object) {
        Intrinsics.checkNotNullParameter((Object)denseBlockPosSet, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = this.c((String)object);
        return ((DY)object).a.a(n2, n3, n4, denseBlockPosSet);
    }

    private static /* synthetic */ DenseBlockPosSet a$default(DW object, int n2, int n3, int n4, DenseBlockPosSet denseBlockPosSet, String string, int n5) {
        if ((n5 & 8) != 0) {
            denseBlockPosSet = new DenseBlockPosSet();
        }
        Intrinsics.checkNotNullParameter((Object)denseBlockPosSet, (String)"");
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        object = ((DW)object).c(string);
        return ((DY)object).a.a(n2, n3, n4, denseBlockPosSet);
    }

    public final Pair<HashSet<SplitEvent>, HashSet<MergeEvent>> a(String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = this.c((String)object);
        object = ((DY)object).a;
        return object.a();
    }

    public final double d(DoubleAugmentation doubleAugmentation, int n2, int n3, int n4, String object) {
        Intrinsics.checkNotNullParameter((Object)doubleAugmentation, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = this.c((String)object);
        return ((DY)object).b.a(doubleAugmentation, n2, n3, n4);
    }

    public final void b(DoubleAugmentation doubleAugmentation, int n2, int n3, int n4, String object, double d2) {
        Intrinsics.checkNotNullParameter((Object)doubleAugmentation, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = this.c((String)object);
        ((DY)object).b.a(doubleAugmentation, n2, n3, n4, d2);
    }

    public final void b(DoubleAugmentation doubleAugmentation, int n2, int n3, int n4, String object, DoubleUnaryOperator doubleUnaryOperator) {
        Intrinsics.checkNotNullParameter((Object)doubleAugmentation, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Intrinsics.checkNotNullParameter((Object)doubleUnaryOperator, (String)"");
        object = this.c((String)object);
        ((DY)object).b.a(doubleAugmentation, n2, n3, n4, doubleUnaryOperator);
    }

    public final void e(DoubleAugmentation doubleAugmentation, int n2, int n3, int n4, String object) {
        Intrinsics.checkNotNullParameter((Object)doubleAugmentation, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = this.c((String)object);
        ((DY)object).b.b(doubleAugmentation, n2, n3, n4);
    }

    public final double f(DoubleAugmentation doubleAugmentation, int n2, int n3, int n4, String object) {
        Intrinsics.checkNotNullParameter((Object)doubleAugmentation, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = this.c((String)object);
        return ((DY)object).b.c(doubleAugmentation, n2, n3, n4);
    }

    public final void b(DoubleComponentAugmentation doubleComponentAugmentation, int n2, int n3, int n4, String object, double d2) {
        Intrinsics.checkNotNullParameter((Object)doubleComponentAugmentation, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = this.c((String)object);
        ((DY)object).b.a(doubleComponentAugmentation, n2, n3, n4, d2);
    }

    public final double c(DoubleComponentAugmentation doubleComponentAugmentation, int n2, int n3, int n4, String object) {
        Intrinsics.checkNotNullParameter((Object)doubleComponentAugmentation, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = this.c((String)object);
        return ((DY)object).b.a(doubleComponentAugmentation, n2, n3, n4);
    }

    public final void d(DoubleComponentAugmentation doubleComponentAugmentation, int n2, int n3, int n4, String object) {
        Intrinsics.checkNotNullParameter((Object)doubleComponentAugmentation, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = this.c((String)object);
        ((DY)object).b.b(doubleComponentAugmentation, n2, n3, n4);
    }

    public final long b(int n2, int n3, int n4, String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = this.c((String)object);
        return ((DY)object).b.g(n2, n3, n4);
    }

    public final Map<Triple<Integer, Integer, Integer>, Double> b(DoubleAugmentation doubleAugmentation, String object, ChunkClaim chunkClaim) {
        Intrinsics.checkNotNullParameter((Object)doubleAugmentation, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = this.c((String)object);
        return ((DY)object).b.a(doubleAugmentation, chunkClaim);
    }

    private static /* synthetic */ Map b$default(DW dW, DoubleAugmentation doubleAugmentation, String string, ChunkClaim chunkClaim, int n2) {
        if ((n2 & 4) != 0) {
            chunkClaim = null;
        }
        return dW.b(doubleAugmentation, string, chunkClaim);
    }

    public final Map<Triple<Integer, Integer, Integer>, Double> b(DoubleComponentAugmentation doubleComponentAugmentation, String object, ChunkClaim chunkClaim) {
        Intrinsics.checkNotNullParameter((Object)doubleComponentAugmentation, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = this.c((String)object);
        return ((DY)object).b.a(doubleComponentAugmentation, chunkClaim);
    }

    private static /* synthetic */ Map b$default(DW dW, DoubleComponentAugmentation doubleComponentAugmentation, String string, ChunkClaim chunkClaim, int n2) {
        if ((n2 & 4) != 0) {
            chunkClaim = null;
        }
        return dW.b(doubleComponentAugmentation, string, chunkClaim);
    }

    public final Set<Vector3ic> b(ChunkClaim chunkClaim, String object) {
        Intrinsics.checkNotNullParameter((Object)chunkClaim, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = this.c((String)object);
        return ((DY)object).b.a(chunkClaim);
    }

    public final void b(int n2, int n3, int n4, Function4<? super Integer, ? super Integer, ? super Integer, ? super Long, Unit> function4, String object) {
        Intrinsics.checkNotNullParameter(function4, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = this.c((String)object);
        ((DY)object).b.a(n2, n3, n4, function4);
    }

    private DenseBlockPosSet b(int n2, int n3, int n4, DenseBlockPosSet denseBlockPosSet, String object) {
        Intrinsics.checkNotNullParameter((Object)denseBlockPosSet, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = this.c((String)object);
        return ((DY)object).b.a(n2, n3, n4, denseBlockPosSet);
    }

    private static /* synthetic */ DenseBlockPosSet b$default(DW object, int n2, int n3, int n4, DenseBlockPosSet denseBlockPosSet, String string, int n5) {
        if ((n5 & 8) != 0) {
            denseBlockPosSet = new DenseBlockPosSet();
        }
        Intrinsics.checkNotNullParameter((Object)denseBlockPosSet, (String)"");
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        object = ((DW)object).c(string);
        return ((DY)object).b.a(n2, n3, n4, denseBlockPosSet);
    }

    public final Pair<HashSet<SplitEvent>, HashSet<MergeEvent>> b(String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        object = this.c((String)object);
        object = ((DY)object).b;
        return object.a();
    }

    private void a(String string, int n2, int n3, int n4, int n5, Long l2) {
        boolean bl;
        DT dT;
        Object object;
        block11: {
            block10: {
                Intrinsics.checkNotNullParameter((Object)string, (String)"");
                Object object2 = object = this.c(string);
                dT = ((DY)object).a;
                object2 = object;
                object = ((DY)object2).b;
                Intrinsics.checkNotNull((Object)dT);
                object2 = (DU)dT;
                if (!((DU)object2).a.contains(new Vector3i(n2 >> 4, n3 >> 4, n4 >> 4))) break block10;
                Intrinsics.checkNotNull((Object)object);
                object2 = (DU)object;
                if (((DU)object2).a.contains(new Vector3i(n2 >> 4, n3 >> 4, n4 >> 4))) break block11;
            }
            if (!this.d.forDimension(string).isBlockInShipyard(n2, n3, n4) || l2 != null) {
                if (VSCoreConfig.SERVER.getSp().getVerboseConnectivityLogging()) {
                    f.info("Attempted to add block at (" + n2 + ", " + n3 + ", " + n4 + ") in dimension " + string + ", but chunk is not loaded! wtf?");
                }
                return;
            }
        }
        Long l3 = (bl = this.d.forDimension(string).isBlockInShipyard(n2, n3, n4)) ? Long.valueOf(1L) : null;
        Long l4 = l2;
        if (l4 == null) {
            l4 = l3;
        }
        l2 = l4;
        switch (n5) {
            case 0: {
                dT.a(n2, n3, n4);
                object.a(n2, n3, n4, l2);
                if (!VSCoreConfig.SERVER.getSp().getVerboseConnectivityLogging()) break;
                f.info("Added air block at (" + n2 + ", " + n3 + ", " + n4 + ") in dimension " + string);
                return;
            }
            case 2: 
            case 3: {
                dT.a(n2, n3, n4, l2);
                DT.a((DT)object, n2, n3, n4, null, 8, null);
                if (!VSCoreConfig.SERVER.getSp().getVerboseConnectivityLogging()) break;
                f.info("Added fluid block at (" + n2 + ", " + n3 + ", " + n4 + ") in dimension " + string);
                return;
            }
            default: {
                dT.a(n2, n3, n4, l2);
                object.a(n2, n3, n4);
                if (!VSCoreConfig.SERVER.getSp().getVerboseConnectivityLogging()) break;
                f.info("Added solid block at (" + n2 + ", " + n3 + ", " + n4 + ") in dimension " + string);
            }
        }
    }

    private static /* synthetic */ void a$default(DW dW, String string, int n2, int n3, int n4, int n5, Long l2, int n6) {
        if ((n6 & 0x20) != 0) {
            l2 = null;
        }
        dW.a(string, n2, n3, n4, n5, l2);
    }

    private DY c(String object) {
        Object object2;
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Map<String, DY> map2 = this.e;
        Object object3 = map2.get(object);
        if (object3 == null) {
            LevelYRange levelYRange;
            DP dP = this.b.get(object);
            if (dP != null) {
                object3 = dP;
                levelYRange = dP.b;
            } else {
                levelYRange = null;
            }
            if (levelYRange == null) {
                object = "Requested ConnGraph for " + (String)object + " but have no information about it";
                throw new IllegalArgumentException(object.toString());
            }
            object3 = levelYRange;
            object3 = new DY(new DU(VSCoreConfig.SERVER.getSp().getEnableBlockEdgeConnectivity(), VSCoreConfig.SERVER.getSp().getEnableBlockCornerConnectivity(), (LevelYRange)object3, this.c, 1), new DU(false, false, (LevelYRange)object3, this.c, 0, 19, null));
            map2.put((String)object, (DY)object3);
            object2 = object3;
        } else {
            object2 = object3;
        }
        return object2;
    }

    private static void a(DY object, int n2, int n3, int n4) {
        DY dY = object;
        DT dT = dY.a;
        dY = object;
        object = dY.b;
        dT.c(n2, n3, n4);
        object.c(n2, n3, n4);
    }

    public final ConnectionStatus a(String object, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Object object2 = object = this.c((String)object);
        DT dT = ((DY)object).a;
        object2 = object;
        object = ((DY)object2).b;
        switch (n8) {
            case 0: {
                return object.a(n2, n3, n4, n5, n6, n7);
            }
            case 1: {
                return dT.a(n2, n3, n4, n5, n6, n7);
            }
        }
        throw new IllegalStateException("Unknown voxelType = " + n8);
    }

    public final ConnectionStatus a(String object, int n2, int n3, int n4, int n5) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Object object2 = object = this.c((String)object);
        DT dT = ((DY)object).a;
        object2 = object;
        object = ((DY)object2).b;
        switch (n5) {
            case 0: {
                return object.d(n2, n3, n4);
            }
            case 1: {
                return dT.d(n2, n3, n4);
            }
        }
        throw new IllegalStateException("Unknown voxelType = " + n5);
    }

    public final void a(String string, Long l2, int n2, int n3, int n4, int n5) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        try {
            if (VSCoreConfig.SERVER.getSp().getEnableConnectivity()) {
                if (!this.d.forDimension(string).isBlockInShipyard(n2, n3, n4) && l2 == null && !VSCoreConfig.SERVER.getSp().getEnableWorldConnectivity()) {
                    return;
                }
                this.a(string, n2, n3, n4, n5, l2);
                if (VSCoreConfig.SERVER.getSp().getVerboseConnectivityLogging()) {
                    f.info("Modified vertex at (" + n2 + ", " + n3 + ", " + n4 + ") in dimension " + string + ". World: " + !this.d.forDimension(string).isBlockInShipyard(n2, n3, n4));
                    return;
                }
            }
        }
        catch (Exception exception) {
            f.error("Valkyrien Skies: Connectivity is having an aneurysm.", (Throwable)exception);
        }
    }

    public final void a(String string, int n2, int n3, int n4, Long l2, il_0 il_02) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        Intrinsics.checkNotNullParameter((Object)il_02, (String)"");
        Object object = this.c(string);
        DY dY = object;
        DT dT = ((DY)object).a;
        dY = object;
        object = dY.b;
        boolean bl = this.d.forDimension(string).isChunkInShipyard(n2, n4);
        Long l3 = bl ? Long.valueOf(1L) : null;
        Long l4 = l2;
        if (l4 == null) {
            l4 = l2 = l3;
        }
        if (il_02.d() == ip_0.EMPTY) {
            object.f(n2 << 4, n3 << 4, n4 << 4);
        } else if (il_02.d() == ip_0.DENSE) {
            ij_0 ij_02 = (ij_0)il_02;
            dT.a(n2 << 4, n3 << 4, n4 << 4, ij_02);
            object.a(n2 << 4, n3 << 4, n4 << 4, ij_02);
        }
        long l5 = System.currentTimeMillis();
        dT.b(n2, n3, n4, l2);
        object.b(n2, n3, n4, l2);
        if (VSCoreConfig.SERVER.getSp().getVerboseConnectivityLogging()) {
            f.info("Loaded chunk at (" + n2 + ", " + n3 + ", " + n4 + ") in dimension " + string + " in " + (System.currentTimeMillis() - l5) + "ms");
        }
    }

    public final void a(String string, int n2, int n3, int n4) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        Object object = this.c(string);
        DY dY = object;
        DT dT = ((DY)object).a;
        dY = object;
        DT dT2 = dY.b;
        int n5 = n2 << 4;
        int n6 = n3 << 4;
        int n7 = n4 << 4;
        dY = object;
        DT dT3 = ((DY)object).a;
        dY = object;
        object = dY.b;
        dT3.c(n5, n6, n7);
        object.c(n5, n6, n7);
        if (this.d.forDimension(string).isChunkInShipyard(n2, n4)) {
            return;
        }
        if (VSCoreConfig.SERVER.getSp().getVerboseConnectivityLogging()) {
            f.info("Unloaded chunk at (" + n2 + ", " + n3 + ", " + n4 + ") in dimension " + string);
        }
        dT.e(n2, n3, n4);
        dT2.e(n2, n3, n4);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0005\u001a\u00020\u00028\u0007\u00f8\u0001\u0000\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b!"}, d2={"Lorg/valkyrienskies/core/impl/shadow/DW$a;", "", "Lorg/valkyrienskies/core/impl/shadow/FU;", "f", "Lorg/apache/logging/log4j/Logger;", "a", "()Lorg/apache/logging/log4j/Logger;", "<init>", "()V"})
    public static final class a {
        private a() {
        }

        @JvmName(name="a")
        public static Logger a() {
            return f;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

