/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.objects.Object2DoubleMap
 *  it.unimi.dsi.fastutil.objects.Object2DoubleMap$Entry
 *  it.unimi.dsi.fastutil.objects.Object2DoubleMaps
 *  it.unimi.dsi.fastutil.objects.Object2DoubleOpenHashMap
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Triple
 *  kotlin.Unit
 *  kotlin.collections.ArrayDeque
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$BooleanRef
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.TypeIntrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import it.unimi.dsi.fastutil.objects.Object2DoubleMap;
import it.unimi.dsi.fastutil.objects.Object2DoubleMaps;
import it.unimi.dsi.fastutil.objects.Object2DoubleOpenHashMap;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.DoubleUnaryOperator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import org.joml.Vector3i;
import org.joml.Vector3ic;
import org.valkyrienskies.core.api.events.MergeEvent;
import org.valkyrienskies.core.api.events.SplitEvent;
import org.valkyrienskies.core.api.ships.properties.ChunkClaim;
import org.valkyrienskies.core.api.util.DoublePair;
import org.valkyrienskies.core.api.world.LevelYRange;
import org.valkyrienskies.core.api.world.connectivity.Component;
import org.valkyrienskies.core.api.world.connectivity.ConnectionStatus;
import org.valkyrienskies.core.api.world.connectivity.DoubleAugmentation;
import org.valkyrienskies.core.api.world.connectivity.DoubleComponentAugmentation;
import org.valkyrienskies.core.impl.api_impl.connectivity.MergeEventImpl;
import org.valkyrienskies.core.impl.api_impl.connectivity.SplitEventImpl;
import org.valkyrienskies.core.impl.config.VSCoreConfig;
import org.valkyrienskies.core.impl.game.ChunkClaimImpl;
import org.valkyrienskies.core.impl.shadow.DA;
import org.valkyrienskies.core.impl.shadow.DB;
import org.valkyrienskies.core.impl.shadow.DD;
import org.valkyrienskies.core.impl.shadow.DE;
import org.valkyrienskies.core.impl.shadow.DF;
import org.valkyrienskies.core.impl.shadow.DG;
import org.valkyrienskies.core.impl.shadow.DH;
import org.valkyrienskies.core.impl.shadow.DT;
import org.valkyrienskies.core.impl.shadow.DW;
import org.valkyrienskies.core.impl.shadow.DZ;
import org.valkyrienskies.core.impl.shadow.dy_0;
import org.valkyrienskies.core.impl.shadow.ed_0;
import org.valkyrienskies.core.impl.shadow.ij_0;
import org.valkyrienskies.core.util.datastructures.DenseBlockPosSet;
import org.valkyrienskies.core.util.datastructures.SparseVoxelOpenHashMap;
import org.valkyrienskies.core.util.datastructures.SparseVoxelPosition;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0096\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\b\u00dd\u0001\u00de\u0001\u00df\u0001\u00e0\u0001B>\u0012\t\b\u0002\u0010\u00b4\u0001\u001a\u00020\\\u0012\t\b\u0002\u0010\u00b0\u0001\u001a\u00020\\\u0012\b\u0010\u00d5\u0001\u001a\u00030\u00d4\u0001\u0012\b\u0010\u0098\u0001\u001a\u00030\u0097\u0001\u0012\t\b\u0002\u0010\u00c9\u0001\u001a\u00020\u0002\u00a2\u0006\u0006\b\u00db\u0001\u0010\u00dc\u0001J7\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ'\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007\u00a2\u0006\u0004\b\n\u0010\u000eJ?\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00062\u000e\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u000e\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0012H\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J/\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ;\u0010\"\u001a.\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` \u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020!0\u001ej\b\u0012\u0004\u0012\u00020!` 0\u001dH\u0016\u00a2\u0006\u0004\b\"\u0010#J'\u0010$\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b$\u0010%J\u0017\u0010$\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002\u00a2\u0006\u0004\b$\u0010&J)\u0010'\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b'\u0010(J'\u0010,\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b,\u0010%J?\u00101\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000200\u0012\u0004\u0012\u00020\u001a0/2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010.\u001a\u0004\u0018\u00010-H\u0016\u00a2\u0006\u0004\b1\u00102J?\u00104\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000200\u0012\u0004\u0012\u00020\u001a0/2\u0006\u0010\u0019\u001a\u0002032\b\u0010.\u001a\u0004\u0018\u00010-H\u0016\u00a2\u0006\u0004\b4\u00105J\u001d\u00108\u001a\b\u0012\u0004\u0012\u00020\f072\u0006\u00106\u001a\u00020-H\u0016\u00a2\u0006\u0004\b8\u00109J5\u0010:\u001a\b\u0012\u0004\u0012\u00020\u0012072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u00a2\u0006\u0004\b:\u0010;J)\u0010=\u001a\u0004\u0018\u00010<2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b=\u0010>J/\u0010?\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b?\u0010\u001cJ/\u0010B\u001a\u00020@2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010A\u001a\u00020@H\u0016\u00a2\u0006\u0004\bB\u0010CJ'\u0010D\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\bD\u0010EJ\u001d\u0010G\u001a\b\u0012\u0004\u0012\u00020F072\u0006\u0010\r\u001a\u00020\fH\u0002\u00a2\u0006\u0004\bG\u0010HJ?\u0010I\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00062\u000e\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0016\u00a2\u0006\u0004\bI\u0010\u0011J?\u0010Q\u001a\u00020P2\u0006\u0010J\u001a\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u00022\u0006\u0010M\u001a\u00020\u00022\u0006\u0010N\u001a\u00020\u00022\u0006\u0010O\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\bQ\u0010RJ\u001f\u0010Q\u001a\u00020P2\u0006\u0010T\u001a\u00020S2\u0006\u0010U\u001a\u00020SH\u0002\u00a2\u0006\u0004\bQ\u0010VJ'\u0010W\u001a\u00020P2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\bW\u0010XJ\u0017\u0010W\u001a\u00020P2\u0006\u0010\r\u001a\u00020SH\u0002\u00a2\u0006\u0004\bW\u0010YJ\u0019\u0010W\u001a\u00020P2\b\u0010Z\u001a\u0004\u0018\u00010FH\u0002\u00a2\u0006\u0004\bW\u0010[J\u0017\u0010]\u001a\u00020\\2\u0006\u0010Z\u001a\u00020FH\u0002\u00a2\u0006\u0004\b]\u0010^J7\u0010_\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0016\u00a2\u0006\u0004\b_\u0010\u000bJ'\u0010`\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b`\u0010%J%\u0010e\u001a\u00020\\2\u0006\u0010b\u001a\u00020a2\u0006\u0010c\u001a\u00020a2\u0006\u0010d\u001a\u00020a\u00a2\u0006\u0004\be\u0010fJ%\u0010h\u001a\u00020\\2\u0006\u0010b\u001a\u00020a2\u0006\u0010c\u001a\u00020a2\u0006\u0010g\u001a\u00020a\u00a2\u0006\u0004\bh\u0010fJ?\u0010k\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010j\u001a\u00020i2\u000e\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0016\u00a2\u0006\u0004\bk\u0010lJ/\u0010m\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\bm\u0010nJ/\u0010o\u001a\u00020\\2\u0006\u0010\u0019\u001a\u0002032\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\bo\u0010pJ/\u0010q\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u0002032\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\bq\u0010rJ7\u0010t\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010s\u001a\u00020\u001aH\u0016\u00a2\u0006\u0004\bt\u0010uJ\u001f\u0010x\u001a\u00020\t2\u0006\u0010v\u001a\u00020\f2\u0006\u0010w\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\bx\u0010yJ?\u0010z\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010s\u001a\u00020\u001aH\u0002\u00a2\u0006\u0004\bz\u0010{J7\u0010|\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0016\u00a2\u0006\u0004\b|\u0010\u000bJ7\u0010}\u001a\u00020\\2\u0006\u0010\u0019\u001a\u0002032\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010s\u001a\u00020\u001aH\u0016\u00a2\u0006\u0004\b}\u0010~JD\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\u0012072\u0006\u0010\u0013\u001a\u00020\u00122\u0007\u0010\u0080\u0001\u001a\u00020\u007f2\u000e\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\t\b\u0002\u0010\u0081\u0001\u001a\u00020\u0002H\u0002\u00a2\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001JJ\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\u0012072\u0006\u0010\u0013\u001a\u00020\u00122\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\f072\u000e\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\t\b\u0002\u0010\u0081\u0001\u001a\u00020\u0002H\u0002\u00a2\u0006\u0006\b\u0082\u0001\u0010\u0084\u0001JR\u0010\u0087\u0001\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022&\u0010\u0086\u0001\u001a!\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0085\u0001H\u0016\u00a2\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J;\u0010\u008a\u0001\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0007\u0010j\u001a\u00030\u0089\u0001H\u0016\u00a2\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J \u0010\u008e\u0001\u001a\u0004\u0018\u00010\f2\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0002\u00a2\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J9\u0010\u0093\u0001\u001a\u00020\u007f*\u00020\u007f2\u0007\u0010\u0090\u0001\u001a\u00020\u00022\u0007\u0010\u0091\u0001\u001a\u00020\u00022\u0007\u0010\u0092\u0001\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0002\u00a2\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J\u0016\u0010\u0095\u0001\u001a\u00020\u0002*\u00020\u007fH\u0002\u00a2\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001d\u0010\u0098\u0001\u001a\u00030\u0097\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u0098\u0001\u0010\u0099\u0001\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001RP\u0010\u009e\u0001\u001a6\u0012\u0004\u0012\u00020-\u0012\n\u0012\b\u0012\u0004\u0012\u00020a0\u001e0\u009c\u0001j\u001f\u0012\u0004\u0012\u00020-\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020a0\u001ej\b\u0012\u0004\u0012\u00020a` `\u009d\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u009e\u0001\u0010\u009f\u0001\u001a\u0006\b\u00a0\u0001\u0010\u00a1\u0001R:\u0010\u00a2\u0001\u001a \u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020i0\u009c\u0001j\u000f\u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020i`\u009d\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00a2\u0001\u0010\u009f\u0001\u001a\u0006\b\u00a3\u0001\u0010\u00a1\u0001R<\u0010\u00a5\u0001\u001a\"\u0012\u0004\u0012\u00020a\u0012\u0005\u0012\u00030\u00a4\u00010\u009c\u0001j\u0010\u0012\u0004\u0012\u00020a\u0012\u0005\u0012\u00030\u00a4\u0001`\u009d\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00a5\u0001\u0010\u009f\u0001\u001a\u0006\b\u00a6\u0001\u0010\u00a1\u0001R\u001c\u0010\u00a7\u0001\u001a\u00020\u00188\u0006\u00a2\u0006\u0010\n\u0006\b\u00a7\u0001\u0010\u00a8\u0001\u001a\u0006\b\u00a9\u0001\u0010\u00aa\u0001R\u001d\u0010\u00ac\u0001\u001a\u00030\u00ab\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00ac\u0001\u0010\u00ad\u0001\u001a\u0006\b\u00ae\u0001\u0010\u00af\u0001R\u001c\u0010\u00b0\u0001\u001a\u00020\\8\u0006\u00a2\u0006\u0010\n\u0006\b\u00b0\u0001\u0010\u00b1\u0001\u001a\u0006\b\u00b2\u0001\u0010\u00b3\u0001R\u001c\u0010\u00b4\u0001\u001a\u00020\\8\u0006\u00a2\u0006\u0010\n\u0006\b\u00b4\u0001\u0010\u00b1\u0001\u001a\u0006\b\u00b5\u0001\u0010\u00b3\u0001R,\u0010\u00b6\u0001\u001a\u0012\u0012\u0004\u0012\u00020S0\u001ej\b\u0012\u0004\u0012\u00020S` 8\u0006\u00a2\u0006\u0010\n\u0006\b\u00b6\u0001\u0010\u00b7\u0001\u001a\u0006\b\u00b8\u0001\u0010\u00b9\u0001R,\u0010\u00ba\u0001\u001a\u0012\u0012\u0004\u0012\u00020!0\u001ej\b\u0012\u0004\u0012\u00020!` 8\u0006\u00a2\u0006\u0010\n\u0006\b\u00ba\u0001\u0010\u00b7\u0001\u001a\u0006\b\u00bb\u0001\u0010\u00b9\u0001R#\u0010\u00bd\u0001\u001a\t\u0012\u0004\u0012\u00020F0\u00bc\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00bd\u0001\u0010\u00be\u0001\u001a\u0006\b\u00bf\u0001\u0010\u00c0\u0001R\u001d\u0010\u00c2\u0001\u001a\u00030\u00c1\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00c2\u0001\u0010\u00c3\u0001\u001a\u0006\b\u00c4\u0001\u0010\u00c5\u0001R,\u0010\u00c6\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` 8\u0006\u00a2\u0006\u0010\n\u0006\b\u00c6\u0001\u0010\u00b7\u0001\u001a\u0006\b\u00c7\u0001\u0010\u00b9\u0001R\u0015\u0010w\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bw\u0010\u00c8\u0001R\u001c\u0010\u00c9\u0001\u001a\u00020\u00028\u0006\u00a2\u0006\u0010\n\u0006\b\u00c9\u0001\u0010\u00ca\u0001\u001a\u0006\b\u00cb\u0001\u0010\u00cc\u0001R\u001c\u0010\u00cd\u0001\u001a\u00020F8\u0006\u00a2\u0006\u0010\n\u0006\b\u00cd\u0001\u0010\u00c8\u0001\u001a\u0006\b\u00ce\u0001\u0010\u00cf\u0001R\u001c\u0010\u00d0\u0001\u001a\u00020\u00188\u0006\u00a2\u0006\u0010\n\u0006\b\u00d0\u0001\u0010\u00a8\u0001\u001a\u0006\b\u00d1\u0001\u0010\u00aa\u0001R\u001c\u0010\u00d2\u0001\u001a\u00020\u00188\u0006\u00a2\u0006\u0010\n\u0006\b\u00d2\u0001\u0010\u00a8\u0001\u001a\u0006\b\u00d3\u0001\u0010\u00aa\u0001R\u001d\u0010\u00d5\u0001\u001a\u00030\u00d4\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00d5\u0001\u0010\u00d6\u0001\u001a\u0006\b\u00d7\u0001\u0010\u00d8\u0001R\u001c\u0010\u00d9\u0001\u001a\u00020\u00188\u0006\u00a2\u0006\u0010\n\u0006\b\u00d9\u0001\u0010\u00a8\u0001\u001a\u0006\b\u00da\u0001\u0010\u00aa\u0001\u00a8\u0006\u00e1\u0001"}, d2={"Lorg/valkyrienskies/core/impl/game/connectivity/BtrekkieBlockConnGraph;", "Lorg/valkyrienskies/core/impl/game/connectivity/BlockConnGraph;", "", "x", "y", "z", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "shipId", "", "addBlock", "(IIILjava/lang/Long;)V", "Lorg/joml/Vector3ic;", "pos", "(Lorg/joml/Vector3ic;Ljava/lang/Long;)V", "extent", "addVoxel", "(IIIJLjava/lang/Long;)V", "Lorg/valkyrienskies/core/util/datastructures/SparseVoxelPosition;", "voxel", "(Lorg/valkyrienskies/core/util/datastructures/SparseVoxelPosition;Ljava/lang/Long;)V", "sparseVoxelPosition", "clearPosition", "(Lorg/valkyrienskies/core/util/datastructures/SparseVoxelPosition;)V", "Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;", "key", "", "collectAugmentation", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;III)D", "Lkotlin/Pair;", "Ljava/util/HashSet;", "Lorg/valkyrienskies/core/api/events/SplitEvent;", "Lkotlin/collections/HashSet;", "Lorg/valkyrienskies/core/api/events/MergeEvent;", "collectEvents", "()Lkotlin/Pair;", "delBlock", "(III)V", "(Lorg/joml/Vector3ic;)V", "delVoxel", "(III)Lorg/valkyrienskies/core/util/datastructures/SparseVoxelPosition;", "chunkX", "chunkY", "chunkZ", "dumpChunk", "Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;", "claim", "", "Lkotlin/Triple;", "gatherFromEachComponent", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;)Ljava/util/Map;", "Lorg/valkyrienskies/core/api/world/connectivity/DoubleComponentAugmentation;", "gatherFromEachComponentRoot", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleComponentAugmentation;Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;)Ljava/util/Map;", "chunkClaim", "", "getAllComponentRootsFromClaim", "(Lorg/valkyrienskies/core/api/ships/properties/ChunkClaim;)Ljava/util/Set;", "getAllowedNeighbors", "(IIIJ)Ljava/util/Set;", "Lorg/valkyrienskies/core/impl/game/connectivity/BtrekkieBlockConnGraph$AugData;", "getAugData", "(III)Lorg/valkyrienskies/core/impl/game/connectivity/BtrekkieBlockConnGraph$AugData;", "getAugmentation", "Lorg/valkyrienskies/core/util/datastructures/DenseBlockPosSet;", "set", "getComponentBlocks", "(IIILorg/valkyrienskies/core/util/datastructures/DenseBlockPosSet;)Lorg/valkyrienskies/core/util/datastructures/DenseBlockPosSet;", "getComponentSize", "(III)J", "Lorg/valkyrienskies/core/impl/datastructures/btrekkie/ConnVertex;", "getConnected", "(Lorg/joml/Vector3ic;)Ljava/util/Set;", "insertDefiniteVoxel", "x1", "y1", "z1", "x2", "y2", "z2", "Lorg/valkyrienskies/core/api/world/connectivity/ConnectionStatus;", "isConnected", "(IIIIII)Lorg/valkyrienskies/core/api/world/connectivity/ConnectionStatus;", "Lorg/joml/Vector3i;", "pos1", "pos2", "(Lorg/joml/Vector3i;Lorg/joml/Vector3i;)Lorg/valkyrienskies/core/api/world/connectivity/ConnectionStatus;", "isIsolated", "(III)Lorg/valkyrienskies/core/api/world/connectivity/ConnectionStatus;", "(Lorg/joml/Vector3i;)Lorg/valkyrienskies/core/api/world/connectivity/ConnectionStatus;", "node", "(Lorg/valkyrienskies/core/impl/datastructures/btrekkie/ConnVertex;)Lorg/valkyrienskies/core/api/world/connectivity/ConnectionStatus;", "", "isTouchingUnloaded", "(Lorg/valkyrienskies/core/impl/datastructures/btrekkie/ConnVertex;)Z", "markChunkLoaded", "markChunkUnloaded", "Lorg/valkyrienskies/core/impl/datastructures/btrekkie/EulerTourNode;", "root1", "root2", "newRoot", "onMerge", "(Lorg/valkyrienskies/core/impl/datastructures/btrekkie/EulerTourNode;Lorg/valkyrienskies/core/impl/datastructures/btrekkie/EulerTourNode;Lorg/valkyrienskies/core/impl/datastructures/btrekkie/EulerTourNode;)Z", "oldRoot", "onSplit", "Lorg/valkyrienskies/physics_api/voxel/updates/DenseVoxelShapeUpdate;", "update", "populateVoxel", "(IIILorg/valkyrienskies/physics_api/voxel/updates/DenseVoxelShapeUpdate;Ljava/lang/Long;)V", "removeAugmentation", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;III)V", "removeFromComponent", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleComponentAugmentation;III)Z", "retrieveFromComponent", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleComponentAugmentation;III)D", "value", "setAugmentation", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;IIID)V", "v", "unloaded", "setUnloaded", "(Lorg/joml/Vector3ic;I)V", "setVoxelAugmentation", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;IIIJD)V", "sparsifyVoxels", "storeToComponent", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleComponentAugmentation;IIID)Z", "", "voxels", "expectedSize", "subdivideVoxel", "(Lorg/valkyrienskies/core/util/datastructures/SparseVoxelPosition;[ILjava/lang/Long;I)Ljava/util/Set;", "(Lorg/valkyrienskies/core/util/datastructures/SparseVoxelPosition;Ljava/util/Set;Ljava/lang/Long;I)Ljava/util/Set;", "Lkotlin/Function4;", "action", "traverseConnectedComponent", "(IIILkotlin/jvm/functions/Function4;)V", "Ljava/util/function/DoubleUnaryOperator;", "updateAugmentation", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;IIILjava/util/function/DoubleUnaryOperator;)V", "", "augment", "vectorFromAugment", "(Ljava/lang/Object;)Lorg/joml/Vector3ic;", "startX", "startY", "startZ", "boundLock", "([IIIII)[I", "gatherVoxelSize", "([I)I", "Lorg/valkyrienskies/core/impl/game/connectivity/augmentation/AugmentationFactory;", "augmentationFactory", "Lorg/valkyrienskies/core/impl/game/connectivity/augmentation/AugmentationFactory;", "getAugmentationFactory", "()Lorg/valkyrienskies/core/impl/game/connectivity/augmentation/AugmentationFactory;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "chunkClaimToComponentIndex", "Ljava/util/HashMap;", "getChunkClaimToComponentIndex", "()Ljava/util/HashMap;", "chunkPrep", "getChunkPrep", "Lorg/valkyrienskies/core/impl/game/connectivity/BtrekkieBlockConnGraph$ComponentData;", "componentInfo", "getComponentInfo", "extentKey", "Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;", "getExtentKey", "()Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;", "Lorg/valkyrienskies/core/impl/datastructures/btrekkie/ConnGraph;", "graph", "Lorg/valkyrienskies/core/impl/datastructures/btrekkie/ConnGraph;", "getGraph", "()Lorg/valkyrienskies/core/impl/datastructures/btrekkie/ConnGraph;", "includeCorners", "Z", "getIncludeCorners", "()Z", "includeEdges", "getIncludeEdges", "loadedChunks", "Ljava/util/HashSet;", "getLoadedChunks", "()Ljava/util/HashSet;", "mergesToEmit", "getMergesToEmit", "Lorg/valkyrienskies/core/util/datastructures/SparseVoxelOpenHashMap;", "nodes", "Lorg/valkyrienskies/core/util/datastructures/SparseVoxelOpenHashMap;", "getNodes", "()Lorg/valkyrienskies/core/util/datastructures/SparseVoxelOpenHashMap;", "Lorg/valkyrienskies/core/impl/game/connectivity/BtrekkieBlockConnGraph$BtrekkieSplitEmitter;", "splitEmitter", "Lorg/valkyrienskies/core/impl/game/connectivity/BtrekkieBlockConnGraph$BtrekkieSplitEmitter;", "getSplitEmitter", "()Lorg/valkyrienskies/core/impl/game/connectivity/BtrekkieBlockConnGraph$BtrekkieSplitEmitter;", "splitsToEmit", "getSplitsToEmit", "Lorg/valkyrienskies/core/impl/datastructures/btrekkie/ConnVertex;", "voxelType", "I", "getVoxelType", "()I", "world", "getWorld", "()Lorg/valkyrienskies/core/impl/datastructures/btrekkie/ConnVertex;", "xKey", "getXKey", "yKey", "getYKey", "Lorg/valkyrienskies/core/api/world/LevelYRange;", "yRange", "Lorg/valkyrienskies/core/api/world/LevelYRange;", "getYRange", "()Lorg/valkyrienskies/core/api/world/LevelYRange;", "zKey", "getZKey", "<init>", "(ZZLorg/valkyrienskies/core/api/world/LevelYRange;Lorg/valkyrienskies/core/impl/game/connectivity/augmentation/AugmentationFactory;I)V", "AugData", "BtrekkieComponent", "BtrekkieSplitEmitter", "ComponentData", "impl"})
public final class DU
implements DT {
    private final boolean b;
    private final boolean c;
    private final LevelYRange d;
    private final DZ e;
    private final int f;
    private final c g;
    private final DA h;
    private final HashSet<SplitEvent> i;
    private final HashSet<MergeEvent> j;
    private final SparseVoxelOpenHashMap<DB> k;
    final HashSet<Vector3i> a;
    private final HashMap<Vector3i, ij_0> l;
    private final DB m;
    private final DB n;
    private final HashMap<DD, d> o;
    private final HashMap<ChunkClaim, HashSet<DD>> p;
    private final DoubleAugmentation q;
    private final DoubleAugmentation r;
    private final DoubleAugmentation s;
    private final DoubleAugmentation t;

    public DU(boolean bl, boolean bl2, LevelYRange levelYRange, DZ dZ2, int n2) {
        Intrinsics.checkNotNullParameter((Object)levelYRange, (String)"");
        Intrinsics.checkNotNullParameter((Object)dZ2, (String)"");
        this.b = bl;
        this.c = bl2;
        this.d = levelYRange;
        this.e = dZ2;
        this.f = n2;
        this.g = new c(this);
        this.h = new DA(new a(null, 0, 3, null), this.g);
        this.i = new HashSet();
        this.j = new HashSet();
        this.k = new SparseVoxelOpenHashMap();
        this.a = new HashSet();
        this.l = new HashMap();
        this.m = new DB();
        this.n = new DB();
        this.o = new HashMap();
        this.p = new HashMap();
        this.q = this.e.a("core:x");
        this.r = this.e.a("core:y");
        this.s = this.e.a("core:z");
        this.t = this.e.a("core:extent");
    }

    public /* synthetic */ DU(boolean bl, boolean bl2, LevelYRange levelYRange, DZ dZ2, int n2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 1) != 0) {
            bl = false;
        }
        if ((n3 & 2) != 0) {
            bl2 = false;
        }
        if ((n3 & 0x10) != 0) {
            n2 = 0;
        }
        this(bl, bl2, levelYRange, dZ2, n2);
    }

    @JvmName(name="c")
    private boolean c() {
        return this.b;
    }

    @JvmName(name="d")
    private boolean d() {
        return this.c;
    }

    @JvmName(name="e")
    private LevelYRange e() {
        return this.d;
    }

    @JvmName(name="f")
    private DZ f() {
        return this.e;
    }

    @JvmName(name="g")
    private int g() {
        return this.f;
    }

    @JvmName(name="h")
    private c h() {
        return this.g;
    }

    @JvmName(name="i")
    private DA i() {
        return this.h;
    }

    @JvmName(name="j")
    private HashSet<SplitEvent> j() {
        return this.i;
    }

    @JvmName(name="k")
    private HashSet<MergeEvent> k() {
        return this.j;
    }

    @JvmName(name="l")
    private SparseVoxelOpenHashMap<DB> l() {
        return this.k;
    }

    @JvmName(name="b")
    public final HashSet<Vector3i> b() {
        return this.a;
    }

    @JvmName(name="m")
    private HashMap<Vector3i, ij_0> m() {
        return this.l;
    }

    @JvmName(name="n")
    private DB n() {
        return this.m;
    }

    @JvmName(name="o")
    private HashMap<DD, d> o() {
        return this.o;
    }

    @JvmName(name="p")
    private HashMap<ChunkClaim, HashSet<DD>> p() {
        return this.p;
    }

    @JvmName(name="q")
    private DoubleAugmentation q() {
        return this.q;
    }

    @JvmName(name="r")
    private DoubleAugmentation r() {
        return this.r;
    }

    @JvmName(name="s")
    private DoubleAugmentation s() {
        return this.s;
    }

    @JvmName(name="t")
    private DoubleAugmentation t() {
        return this.t;
    }

    private void a(Vector3ic object, Long object2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Set<Vector3ic> set = new Vector3i(object.x() >> 4, object.y() >> 4, object.z() >> 4);
        if (object2 == null && !this.a.contains(set)) {
            throw new IllegalArgumentException("Connectivity: Trying to insert " + (Vector3ic)object + " into a chunk not marked loaded! This is only legal if we're on a ship, but shipId is null.");
        }
        if (this.k.containsKey((Vector3ic)object)) {
            return;
        }
        long l2 = 1L;
        if (object instanceof SparseVoxelPosition) {
            l2 = ((SparseVoxelPosition)object).getExtent();
        }
        if (l2 != 16L) {
            Object object4;
            boolean bl;
            long l3 = object instanceof SparseVoxelPosition ? ((SparseVoxelPosition)object).getVolume() : 1L;
            set = new SparseVoxelPosition(object.x(), object.y(), object.z(), l2);
            do {
                Vector3i vector3i = set;
                object4 = ((SparseVoxelPosition)vector3i).getHigherLevelVoxel(vector3i.x, ((Vector3i)((Object)set)).y, ((Vector3i)((Object)set)).z, ((SparseVoxelPosition)((Object)set)).getExtent());
                bl = this.k.containsNodesToFill((SparseVoxelPosition)object4, l3);
                if (!bl) continue;
                set = object4;
            } while (((SparseVoxelPosition)((Object)set)).getExtent() != 16L && bl);
            if (!((SparseVoxelPosition)((Object)set)).equalsCertain(new SparseVoxelPosition(object.x(), object.y(), object.z(), l2))) {
                Object object3;
                this.a((SparseVoxelPosition)((Object)set), (Long)object2);
                object4 = null;
                Object object622 = this.k;
                Map object7 = object622;
                object = new LinkedHashMap();
                for (Map.Entry entry : object7.entrySet()) {
                    object3 = entry;
                    if (!(((SparseVoxelPosition)((Object)set)).contains((SparseVoxelPosition)object3.getKey()) && !((SparseVoxelPosition)((Object)set)).equalsCertain((SparseVoxelPosition)object3.getKey()))) continue;
                    object.put(entry.getKey(), entry.getValue());
                }
                for (Object object622 : object.keySet()) {
                    a a2 = this.h(((Vector3i)object622).x, ((Vector3i)object622).y, ((Vector3i)object622).z);
                    if (a2 != null) {
                        a a3;
                        if (object4 == null) {
                            a3 = a2;
                        } else {
                            Object object5 = object4;
                            a a4 = ((a)object5).a(object5, a2);
                            Intrinsics.checkNotNull((Object)a4);
                            a3 = a4;
                        }
                        object4 = a3;
                    }
                    object2 = object622;
                    object = this;
                    if (((DU)object).k.get(object2) == null) continue;
                    DB dB = ((DU)object).k.get(object2);
                    object3 = super.b((Vector3ic)object2);
                    object3 = object3.iterator();
                    while (object3.hasNext()) {
                        DB dB2 = object3.next();
                        ((DU)object).h.b(dB, dB2);
                    }
                    ((DU)object).k.remove(object2);
                }
                if (object4 != null && this.k.get(set) != null) {
                    DB dB = this.k.get(set);
                    Intrinsics.checkNotNull((Object)dB);
                    this.h.a(dB, object4);
                }
                return;
            }
        }
        if (this.k.containsKey((Vector3ic)object)) {
            return;
        }
        DB dB = new DB();
        this.k.put((Vector3ic)object, dB);
        HashSet<SparseVoxelPosition> hashSet = new HashSet<SparseVoxelPosition>();
        for (SparseVoxelPosition sparseVoxelPosition : this.a(object.x(), object.y(), object.z(), l2)) {
            Object v5;
            block22: {
                Iterable iterable = hashSet;
                for (Object t : iterable) {
                    SparseVoxelPosition sparseVoxelPosition2 = (SparseVoxelPosition)t;
                    if (!sparseVoxelPosition2.contains(sparseVoxelPosition)) continue;
                    v5 = t;
                    break block22;
                }
                v5 = null;
            }
            if (v5 != null || this.k.get((Object)sparseVoxelPosition) == null || Intrinsics.areEqual((Object)sparseVoxelPosition, (Object)object)) continue;
            this.h.a(dB, this.k.get((Object)sparseVoxelPosition));
            SparseVoxelPosition sparseVoxelPosition3 = this.k.findContainingVoxel(sparseVoxelPosition.x(), sparseVoxelPosition.y(), sparseVoxelPosition.z());
            Intrinsics.checkNotNull((Object)sparseVoxelPosition3);
            hashSet.add(sparseVoxelPosition3);
        }
        if (object2 == null) {
            set = new SparseVoxelPosition(object.x(), object.y(), object.z(), l2).allRelativeTo(this.c, this.b);
            Vector3i vector3i = new Vector3i(object.x() >> 4, object.y() >> 4, object.z() >> 4);
            for (Vector3ic vector3ic : set) {
                Vector3i object3 = new Vector3i(vector3ic.x() >> 4, vector3ic.y() >> 4, vector3ic.z() >> 4);
                if (Intrinsics.areEqual((Object)object3, (Object)vector3i) || this.a.contains(object3)) continue;
                this.a((Vector3ic)object, 1);
                break;
            }
        }
        if (object.y() <= this.d.getMinY() || object.y() + (int)l2 - 1 >= this.d.getMaxY()) {
            this.h.a(dB, this.m);
        }
        if (this.k.containsKeyCertain(new SparseVoxelPosition(object.x(), object.y(), object.z(), l2))) {
            DU dU = this;
            dU.a(dU.q, object.x(), object.y(), object.z(), (double)object.x());
            DU dU2 = this;
            dU2.a(dU2.r, object.x(), object.y(), object.z(), (double)object.y());
            DU dU3 = this;
            dU3.a(dU3.s, object.x(), object.y(), object.z(), (double)object.z());
            if (l2 > 1L) {
                DU dU4 = this;
                dU4.a(dU4.t, object.x(), object.y(), object.z(), (double)l2 - 1.0);
            }
        }
        if (VSCoreConfig.SERVER.getSp().getVerboseConnectivityLogging()) {
            DW.a.a().info("Added vertex : " + (Vector3ic)object);
        }
    }

    private static /* synthetic */ void a$default(DU dU, Vector3ic vector3ic, Long l2, int n2) {
        if ((n2 & 2) != 0) {
            l2 = null;
        }
        dU.a(vector3ic, l2);
    }

    private final void a(SparseVoxelPosition sparseVoxelPosition) {
        if (this.k.get((Object)sparseVoxelPosition) == null) {
            return;
        }
        DB dB = this.k.get((Object)sparseVoxelPosition);
        Object object = this.b(sparseVoxelPosition);
        object = object.iterator();
        while (object.hasNext()) {
            DB dB2 = (DB)object.next();
            this.h.b(dB, dB2);
        }
        this.k.remove((Object)sparseVoxelPosition);
    }

    @Override
    public final void a(int n2, int n3, int n4, Long l2) {
        this.a((Vector3ic)new Vector3i(n2, n3, n4), l2);
    }

    @Override
    public final void a(int n2, int n3, int n4, long l2, Long l3) {
        Set<Vector3ic> set = new Vector3i(n2 >> 4, n3 >> 4, n4 >> 4);
        if (l3 == null && !this.a.contains(set)) {
            throw new IllegalArgumentException("Connectivity: Trying to insert voxel " + n2 + ", " + n3 + ", " + n4 + ", with extent " + l2 + " into a chunk not marked loaded! This is only legal if we're on a ship, but shipId is null.");
        }
        if (this.k.containsKeyCertain(new SparseVoxelPosition(n2, n3, n4, l2))) {
            return;
        }
        SparseVoxelPosition sparseVoxelPosition = new SparseVoxelPosition(n2, n3, n4, l2);
        DB dB = new DB();
        this.k.putCertain(sparseVoxelPosition, dB);
        HashSet<Object> hashSet = new HashSet<Object>();
        for (SparseVoxelPosition vector3i : this.a(sparseVoxelPosition.x(), sparseVoxelPosition.y(), sparseVoxelPosition.z(), l2)) {
            Object v0;
            Object object2;
            block10: {
                Iterable iterable = hashSet;
                for (Object object2 : iterable) {
                    SparseVoxelPosition sparseVoxelPosition2 = (SparseVoxelPosition)object2;
                    if (!sparseVoxelPosition2.contains(vector3i)) continue;
                    v0 = object2;
                    break block10;
                }
                v0 = null;
            }
            if (v0 != null || this.k.get((Object)vector3i) == null) continue;
            DB dB2 = this.k.get((Object)vector3i);
            Intrinsics.checkNotNull((Object)dB2);
            this.h.a(dB, dB2);
            object2 = this.k.findContainingVoxel(vector3i.x(), vector3i.y(), vector3i.z());
            if (object2 == null) continue;
            hashSet.add(object2);
        }
        if (l3 == null) {
            set = new SparseVoxelPosition(sparseVoxelPosition.x(), sparseVoxelPosition.y(), sparseVoxelPosition.z(), l2).allRelativeTo(this.c, this.b);
            Vector3i vector3i = new Vector3i(sparseVoxelPosition.x() >> 4, sparseVoxelPosition.y() >> 4, sparseVoxelPosition.z() >> 4);
            for (Vector3ic vector3ic : set) {
                Vector3i vector3i2 = new Vector3i(vector3ic.x() >> 4, vector3ic.y() >> 4, vector3ic.z() >> 4);
                if (Intrinsics.areEqual((Object)vector3i2, (Object)vector3i) || this.a.contains(vector3i2)) continue;
                this.a((Vector3ic)sparseVoxelPosition, 1);
                break;
            }
        }
        if (sparseVoxelPosition.y() <= this.d.getMinY() || sparseVoxelPosition.y() + (int)l2 - 1 >= this.d.getMaxY()) {
            this.h.a(dB, this.m);
        }
        if (this.k.containsKeyCertain(sparseVoxelPosition)) {
            DU dU = this;
            dU.a(dU.q, sparseVoxelPosition.x(), sparseVoxelPosition.y(), sparseVoxelPosition.z(), sparseVoxelPosition.getExtent(), (double)sparseVoxelPosition.x());
            DU dU2 = this;
            dU2.a(dU2.r, sparseVoxelPosition.x(), sparseVoxelPosition.y(), sparseVoxelPosition.z(), sparseVoxelPosition.getExtent(), (double)sparseVoxelPosition.y());
            DU dU3 = this;
            dU3.a(dU3.s, sparseVoxelPosition.x(), sparseVoxelPosition.y(), sparseVoxelPosition.z(), sparseVoxelPosition.getExtent(), (double)sparseVoxelPosition.z());
            if (l2 > 1L) {
                DU dU4 = this;
                dU4.a(dU4.t, sparseVoxelPosition.x(), sparseVoxelPosition.y(), sparseVoxelPosition.z(), sparseVoxelPosition.getExtent(), (double)l2 - 1.0);
            }
        }
        if (VSCoreConfig.SERVER.getSp().getVerboseConnectivityLogging()) {
            DW.a.a().info("Added voxel : " + sparseVoxelPosition);
        }
    }

    private final void a(SparseVoxelPosition sparseVoxelPosition, Long l2) {
        this.a(sparseVoxelPosition.x, sparseVoxelPosition.y, sparseVoxelPosition.z, sparseVoxelPosition.getExtent(), l2);
    }

    private final void a(Vector3ic vector3ic) {
        Object object;
        Set<SparseVoxelPosition> set;
        if (!this.k.containsKey(vector3ic)) {
            return;
        }
        SparseVoxelPosition sparseVoxelPosition = this.k.findContainingVoxel(vector3ic.x(), vector3ic.y(), vector3ic.z());
        Intrinsics.checkNotNull((Object)sparseVoxelPosition);
        SparseVoxelPosition object22 = sparseVoxelPosition;
        DB dB = this.k.get(vector3ic);
        Intrinsics.checkNotNull((Object)dB);
        DB dB2 = dB;
        Object object2 = this.h.b(dB2);
        Set<DB> set2 = this.b(vector3ic);
        if (set2.isEmpty() && (set = (Map)this.o).get((object = this.h.a.get(dB2)) != null && (object = ((DG)object).a) != null && (object = ((DE)object).c) != null ? (DD)((DH)object).e() : null) != null) {
            set = this.o;
            Object object3 = this.h.a.get(dB2);
            DD dD = object3 != null && (object3 = ((DG)object3).a) != null && (object3 = ((DE)object3).c) != null ? (DD)((DH)object3).e() : null;
            TypeIntrinsics.asMutableMap(set).remove(dD);
        }
        this.k.removeCertain(object22);
        if (object22.getExtent() > 1L) {
            SparseVoxelPosition sparseVoxelPosition2 = object22;
            int n2 = 8;
            boolean bl = false;
            Object var2_5 = null;
            Set set3 = SetsKt.minus(sparseVoxelPosition2.getContaining(), (Object)vector3ic);
            set = sparseVoxelPosition2;
            DU dU = this;
            if ((set = dU.a((SparseVoxelPosition)((Object)set), set3, null, 4096)).size() == 1) {
                this.a((Vector3ic)CollectionsKt.first((Iterable)set), null);
                if (this.k.get(CollectionsKt.first((Iterable)set)) != null) {
                    DB dB3 = this.k.get(CollectionsKt.first((Iterable)set));
                    Intrinsics.checkNotNull((Object)dB3);
                    this.h.a(dB3, object2);
                }
            } else if (!((Collection)set).isEmpty()) {
                for (SparseVoxelPosition sparseVoxelPosition3 : set) {
                    this.a(sparseVoxelPosition3, null);
                }
                if (this.k.get(CollectionsKt.first((Iterable)set)) != null) {
                    DB dB4 = this.k.get(CollectionsKt.first((Iterable)set));
                    Intrinsics.checkNotNull((Object)dB4);
                    this.h.a(dB4, object2);
                }
            }
        }
        for (DB dB5 : set2) {
            this.h.b(dB2, dB5);
        }
        if (VSCoreConfig.SERVER.getSp().getVerboseConnectivityLogging()) {
            DW.a.a().info("Deleted vertex : " + vector3ic);
        }
    }

    @Override
    public final void a(int n2, int n3, int n4) {
        Vector3ic vector3ic = new Vector3i(n2, n3, n4);
        DU dU = this;
        if (dU.k.containsKey(vector3ic)) {
            Object object;
            Set<SparseVoxelPosition> set;
            SparseVoxelPosition sparseVoxelPosition = dU.k.findContainingVoxel(vector3ic.x(), vector3ic.y(), vector3ic.z());
            Intrinsics.checkNotNull((Object)sparseVoxelPosition);
            SparseVoxelPosition object22 = sparseVoxelPosition;
            DB dB = dU.k.get(vector3ic);
            Intrinsics.checkNotNull((Object)dB);
            DB dB2 = dB;
            Object object2 = dU.h.b(dB2);
            Set<DB> set2 = dU.b(vector3ic);
            if (set2.isEmpty() && (set = (Map)dU.o).get((object = dU.h.a.get(dB2)) != null && (object = ((DG)object).a) != null && (object = ((DE)object).c) != null ? (DD)((DH)object).e() : null) != null) {
                set = dU.o;
                Object object3 = dU.h.a.get(dB2);
                DD dD = object3 != null && (object3 = ((DG)object3).a) != null && (object3 = ((DE)object3).c) != null ? (DD)((DH)object3).e() : null;
                TypeIntrinsics.asMutableMap(set).remove(dD);
            }
            dU.k.removeCertain(object22);
            if (object22.getExtent() > 1L) {
                SparseVoxelPosition sparseVoxelPosition2 = object22;
                int n5 = 8;
                boolean bl = false;
                Object var3_9 = null;
                Set set3 = SetsKt.minus(sparseVoxelPosition2.getContaining(), (Object)vector3ic);
                set = sparseVoxelPosition2;
                DU dU2 = dU;
                if ((set = dU2.a((SparseVoxelPosition)((Object)set), set3, null, 4096)).size() == 1) {
                    dU.a((Vector3ic)CollectionsKt.first((Iterable)set), null);
                    if (dU.k.get(CollectionsKt.first((Iterable)set)) != null) {
                        DA dA = dU.h;
                        DB dB3 = dU.k.get(CollectionsKt.first((Iterable)set));
                        Intrinsics.checkNotNull((Object)dB3);
                        dA.a(dB3, object2);
                    }
                } else if (!((Collection)set).isEmpty()) {
                    for (SparseVoxelPosition sparseVoxelPosition3 : set) {
                        dU.a(sparseVoxelPosition3, null);
                    }
                    if (dU.k.get(CollectionsKt.first((Iterable)set)) != null) {
                        DA dA = dU.h;
                        DB dB4 = dU.k.get(CollectionsKt.first((Iterable)set));
                        Intrinsics.checkNotNull((Object)dB4);
                        dA.a(dB4, object2);
                    }
                }
            }
            for (DB dB5 : set2) {
                dU.h.b(dB2, dB5);
            }
            if (VSCoreConfig.SERVER.getSp().getVerboseConnectivityLogging()) {
                DW.a.a().info("Deleted vertex : " + vector3ic);
            }
        }
    }

    @Override
    public final SparseVoxelPosition b(int n2, int n3, int n4) {
        Object object;
        Map map2;
        if (!this.k.containsKey(n2, n3, n4)) {
            return null;
        }
        SparseVoxelPosition sparseVoxelPosition = this.k.findContainingVoxel(n2, n3, n4);
        Intrinsics.checkNotNull((Object)sparseVoxelPosition);
        SparseVoxelPosition sparseVoxelPosition2 = sparseVoxelPosition;
        DB dB = this.k.get(n2, n3, n4);
        Intrinsics.checkNotNull((Object)dB);
        DB dB2 = dB;
        Set<DB> set = this.b(sparseVoxelPosition2);
        if (set.isEmpty() && (map2 = (Map)this.o).get((object = this.h.a.get(dB2)) != null && (object = ((DG)object).a) != null && (object = ((DE)object).c) != null ? (DD)((DH)object).e() : null) != null) {
            map2 = this.o;
            Object object2 = this.h.a.get(dB2);
            DB dB3 = object2 != null && (object2 = ((DG)object2).a) != null && (object2 = ((DE)object2).c) != null ? (DD)((DH)object2).e() : null;
            TypeIntrinsics.asMutableMap((Object)map2).remove(dB3);
        }
        this.k.remove((Object)sparseVoxelPosition2);
        for (DB dB3 : set) {
            this.h.b(dB2, dB3);
        }
        this.h.b(dB2);
        if (VSCoreConfig.SERVER.getSp().getVerboseConnectivityLogging()) {
            DW.a.a().info("Deleted voxel : " + sparseVoxelPosition2);
        }
        return sparseVoxelPosition2;
    }

    @Override
    public final void c(int n2, int n3, int n4) {
        HashSet<SparseVoxelPosition> hashSet = new HashSet<SparseVoxelPosition>();
        int n5 = n2;
        n2 += 16;
        while (n5 < n2) {
            int n6 = n3 + 16;
            for (int i2 = n3; i2 < n6; ++i2) {
                int n7 = n4 + 16;
                for (int i3 = n4; i3 < n7; ++i3) {
                    DB dB;
                    Object object;
                    Map map2;
                    SparseVoxelPosition sparseVoxelPosition;
                    SparseVoxelPosition sparseVoxelPosition2;
                    DU dU;
                    Object v0;
                    block8: {
                        if (!this.k.containsKey(n5, i2, i3)) continue;
                        Intrinsics.checkNotNull((Object)this.k.findContainingVoxel(n5, i2, i3));
                        Object object2 = hashSet;
                        object2 = object2.iterator();
                        while (object2.hasNext()) {
                            Object e2 = object2.next();
                            SparseVoxelPosition sparseVoxelPosition3 = (SparseVoxelPosition)e2;
                            if (!sparseVoxelPosition3.contains(n5, i2, i3)) continue;
                            v0 = e2;
                            break block8;
                        }
                        v0 = null;
                    }
                    if (v0 != null) continue;
                    hashSet.add((SparseVoxelPosition)((Object)dU));
                    int n8 = i3;
                    int n9 = i2;
                    int n10 = n5;
                    dU = this;
                    if (!dU.k.containsKey(n10, n9, n8)) {
                        sparseVoxelPosition2 = null;
                        continue;
                    }
                    Intrinsics.checkNotNull((Object)dU.k.findContainingVoxel(n10, n9, n8));
                    Intrinsics.checkNotNull((Object)dU.k.get(n10, n9, n8));
                    Set<DB> set = super.b(sparseVoxelPosition);
                    if (set.isEmpty() && (map2 = (Map)dU.o).get((object = dU.h.a.get(dB)) != null && (object = ((DG)object).a) != null && (object = ((DE)object).c) != null ? (DD)((DH)object).e() : null) != null) {
                        map2 = dU.o;
                        Object object3 = dU.h.a.get(dB);
                        DB dB2 = object3 != null && (object3 = ((DG)object3).a) != null && (object3 = ((DE)object3).c) != null ? (DD)((DH)object3).e() : null;
                        TypeIntrinsics.asMutableMap((Object)map2).remove(dB2);
                    }
                    dU.k.remove((Object)sparseVoxelPosition);
                    for (DB dB2 : set) {
                        dU.h.b(dB, dB2);
                    }
                    dU.h.b(dB);
                    if (VSCoreConfig.SERVER.getSp().getVerboseConnectivityLogging()) {
                        DW.a.a().info("Deleted voxel : " + sparseVoxelPosition);
                    }
                    sparseVoxelPosition2 = sparseVoxelPosition;
                }
            }
            ++n5;
        }
    }

    @Override
    public final ConnectionStatus a(int n2, int n3, int n4, int n5, int n6, int n7) {
        Object object = new Vector3i(n5, n6, n7);
        Object object2 = new Vector3i(n2, n3, n4);
        DU dU = this;
        if (Intrinsics.areEqual((Object)(object2 = dU.k.get((Vector3i)object2)), (Object)(object = dU.k.get((Vector3i)object)))) {
            return ConnectionStatus.CONNECTED;
        }
        if (object2 == null || object == null) {
            return ConnectionStatus.UNKNOWN;
        }
        if (dU.h.c((DB)object2, (DB)object)) {
            return ConnectionStatus.CONNECTED;
        }
        if (dU.b((DB)object2) && dU.b((DB)object)) {
            return ConnectionStatus.UNKNOWN;
        }
        return ConnectionStatus.DISCONNECTED;
    }

    @Override
    public final ConnectionStatus d(int n2, int n3, int n4) {
        return this.a(new Vector3i(n2, n3, n4));
    }

    private final ConnectionStatus a(Vector3i object, Vector3i object2) {
        if (Intrinsics.areEqual((Object)(object = this.k.get((Vector3i)object)), (Object)(object2 = this.k.get((Vector3i)object2)))) {
            return ConnectionStatus.CONNECTED;
        }
        if (object == null || object2 == null) {
            return ConnectionStatus.UNKNOWN;
        }
        if (this.h.c((DB)object, (DB)object2)) {
            return ConnectionStatus.CONNECTED;
        }
        if (this.b((DB)object) && this.b((DB)object2)) {
            return ConnectionStatus.UNKNOWN;
        }
        return ConnectionStatus.DISCONNECTED;
    }

    private final ConnectionStatus a(Vector3i object) {
        object = this.k.get((Vector3i)object);
        return this.a((DB)object);
    }

    private final ConnectionStatus a(DB dB) {
        if (dB == null) {
            return ConnectionStatus.UNKNOWN;
        }
        if (this.h.c(dB, this.m)) {
            return ConnectionStatus.CONNECTED;
        }
        if (this.b(dB)) {
            return ConnectionStatus.UNKNOWN;
        }
        return ConnectionStatus.DISCONNECTED;
    }

    private final Set<DB> b(Vector3ic vector3ic) {
        if (!this.k.containsKey(vector3ic)) {
            return SetsKt.emptySet();
        }
        DB dB = this.k.get(vector3ic);
        Intrinsics.checkNotNull((Object)dB);
        return new HashSet<DB>(this.h.a(dB));
    }

    private Set<SparseVoxelPosition> a(int n2, int n3, int n4, long l2) {
        HashSet<Object> hashSet = new HashSet<Object>();
        SparseVoxelPosition sparseVoxelPosition = new SparseVoxelPosition(n2, n3, n4, l2);
        int n5 = n2 - 1;
        int n6 = n2 + (int)l2;
        if (n5 <= n6) {
            while (true) {
                int n7;
                int n8;
                if ((n8 = n3 - 1) <= (n7 = n3 + (int)l2)) {
                    while (true) {
                        int n9;
                        int n10;
                        if ((n10 = n4 - 1) <= (n9 = n4 + (int)l2)) {
                            while (true) {
                                if (!sparseVoxelPosition.contains(n5, n8, n10)) {
                                    Object object;
                                    (object = new Integer[3])[0] = n5 < n2 ? 1 : (n5 == n2 + (int)l2 ? 1 : 0);
                                    object[1] = n8 < n3 ? 1 : (n8 == n3 + (int)l2 ? 1 : 0);
                                    object[2] = n10 < n4 ? 1 : (n10 == n4 + (int)l2 ? 1 : 0);
                                    object = CollectionsKt.listOf((Object[])object);
                                    if ((this.c || CollectionsKt.sumOfInt((Iterable)((Iterable)object)) != 3) && (this.b || CollectionsKt.sumOfInt((Iterable)((Iterable)object)) != 2)) {
                                        boolean bl;
                                        object = hashSet;
                                        if (!((Collection)object).isEmpty()) {
                                            object = object.iterator();
                                            while (object.hasNext()) {
                                                Object object2 = object.next();
                                                if (!((SparseVoxelPosition)(object2 = (SparseVoxelPosition)object2)).contains(n5, n8, n10)) continue;
                                                bl = true;
                                                break;
                                            }
                                        } else {
                                            bl = false;
                                        }
                                        if (!bl) {
                                            SparseVoxelPosition sparseVoxelPosition2 = this.k.findContainingVoxel(n5, n8, n10);
                                            if (sparseVoxelPosition2 != null) {
                                                object = sparseVoxelPosition2;
                                                hashSet.add(object);
                                            }
                                        }
                                    }
                                }
                                if (n10 == n9) break;
                                ++n10;
                            }
                        }
                        if (n8 == n7) break;
                        ++n8;
                    }
                }
                if (n5 == n6) break;
                ++n5;
            }
        }
        return hashSet;
    }

    private static /* synthetic */ Set a$default(DU dU, int n2, int n3, int n4, long l2, int n5) {
        if ((n5 & 8) != 0) {
            l2 = 1L;
        }
        return dU.a(n2, n3, n4, l2);
    }

    @Override
    public final void b(int n2, int n3, int n4, Long object) {
        int n5;
        int n6;
        int n7;
        this.a.add(new Vector3i(n2, n3, n4));
        if (object == null) {
            HashSet<SparseVoxelPosition> hashSet = new HashSet<SparseVoxelPosition>();
            int n8 = n2 - 1;
            int n9 = n2 + 1;
            if (n8 <= n9) {
                while (true) {
                    if ((n7 = n3 - 1) <= (n6 = n3 + 1)) {
                        while (true) {
                            int n10;
                            if ((n5 = n4 - 1) <= (n10 = n4 + 1)) {
                                while (true) {
                                    if (!(!this.a.contains(new Vector3i(n8, n7, n5)) || !this.b && (n8 != n2 && n7 != n3 || n8 != n2 && n5 != n4 || n7 != n3 && n5 != n4) || !this.c && n8 != n2 && n7 != n3 && n5 != n4)) {
                                        Set<SparseVoxelPosition> set = this.k.getBorderingDirection(n8, n7, n5, new Vector3i(n2 - n8, n3 - n7, n4 - n5));
                                        for (SparseVoxelPosition sparseVoxelPosition : set) {
                                            if (hashSet.contains(sparseVoxelPosition)) continue;
                                            hashSet.add(sparseVoxelPosition);
                                            if (this.k.get((Object)sparseVoxelPosition) != null) {
                                                DU dU = this;
                                                DB dB = dU.k.get((Object)sparseVoxelPosition);
                                                Intrinsics.checkNotNull((Object)dB);
                                                if (!dU.b(dB)) continue;
                                            }
                                            this.a((Vector3ic)sparseVoxelPosition, 0);
                                        }
                                    }
                                    if (n5 == n10) break;
                                    ++n5;
                                }
                            }
                            if (n7 == n6) break;
                            ++n7;
                        }
                    }
                    if (n8 == n9) break;
                    ++n8;
                }
            }
        }
        long l2 = System.currentTimeMillis();
        if (VSCoreConfig.SERVER.getSp().getVerboseConnectivityLogging()) {
            DW.a.a().info("Marking Chunk Loaded: " + n2 + ", " + n3 + ", " + n4);
        }
        Long l3 = object;
        n5 = n4;
        n6 = n3;
        n7 = n2;
        DU dU = this;
        if (dU.l.containsKey(new Vector3i(n7, n6, n5))) {
            int n11;
            int n12 = n7 << 4;
            int n13 = n6 << 4;
            int n14 = n5 << 4;
            ij_0 ij_02 = dU.l.get(new Vector3i(n7, n6, n5));
            Intrinsics.checkNotNull((Object)ij_02);
            Object object2 = ij_02;
            n6 = 0;
            n5 = -1;
            Object object3 = object2;
            int n15 = ((ij_0)object3).e.length;
            for (int i2 = 0; i2 < n15; ++i2) {
                int n16;
                object3 = object2;
                n11 = n16 = ((ij_0)object3).e[i2];
                if (!(switch (n16) {
                    case 2, 3 -> true;
                    default -> n11 == dU.f;
                })) continue;
                ++n6;
                if (n5 != -1) continue;
                n5 = i2;
            }
            switch (n6) {
                case 0: {
                    break;
                }
                case 1: {
                    n15 = n5 & 0xF;
                    int n17 = n5 >> 4 & 0xF;
                    n11 = n5 >> 8 & 0xF;
                    object2 = new SparseVoxelPosition(n12 + n15, n13 + n17, n14 + n11, 1L);
                    dU.a((SparseVoxelPosition)object2, l3);
                    break;
                }
                case 4096: {
                    SparseVoxelPosition sparseVoxelPosition = new SparseVoxelPosition(n12, n13, n14, 16L);
                    dU.a(sparseVoxelPosition, l3);
                    break;
                }
                default: {
                    object3 = object2;
                    int n18 = 8;
                    n18 = 0;
                    Long l4 = l3;
                    int[] nArray = ((ij_0)object3).e;
                    SparseVoxelPosition sparseVoxelPosition = new SparseVoxelPosition(n12, n13, n14, 16L);
                    DU dU2 = dU;
                    Set<SparseVoxelPosition> set = dU2.a(sparseVoxelPosition, nArray, l4, 4096);
                    for (SparseVoxelPosition sparseVoxelPosition2 : set) {
                        dU.a(sparseVoxelPosition2, l3);
                    }
                }
            }
        }
        if (VSCoreConfig.SERVER.getSp().getVerboseConnectivityLogging()) {
            DW.a.a().info("Sparsified chunk in " + (System.currentTimeMillis() - l2) + "ms");
        }
        if (object != null) {
            return;
        }
        int n19 = n2 - 1;
        int n20 = n2 + 1;
        if (n19 <= n20) {
            while (true) {
                int n21;
                int n22;
                if ((n22 = n3 - 1) <= (n21 = n3 + 1)) {
                    while (true) {
                        int n23;
                        int n24;
                        if ((n24 = n4 - 1) <= (n23 = n4 + 1)) {
                            while (true) {
                                if (!(this.a.contains(new Vector3i(n19, n22, n24)) || !this.b && (n19 != n2 && n22 != n3 || n19 != n2 && n24 != n4 || n22 != n3 && n24 != n4) || !this.c && n19 != n2 && n22 != n3 && n24 != n4)) {
                                    HashSet hashSet = new HashSet();
                                    Set<SparseVoxelPosition> set = this.k.getBorderingDirection(n2, n3, n4, new Vector3i(n19 - n2, n22 - n3, n24 - n4));
                                    for (SparseVoxelPosition sparseVoxelPosition : set) {
                                        if (hashSet.contains(sparseVoxelPosition)) continue;
                                        hashSet.add(sparseVoxelPosition);
                                        if (this.a((Vector3i)sparseVoxelPosition) != ConnectionStatus.DISCONNECTED) continue;
                                        this.a((Vector3ic)sparseVoxelPosition, 1);
                                    }
                                }
                                if (n24 == n23) break;
                                ++n24;
                            }
                        }
                        if (n22 == n21) break;
                        ++n22;
                    }
                }
                if (n19 == n20) break;
                ++n19;
            }
        }
    }

    private final boolean b(DB object) {
        Object object2 = this.h.d((DB)object);
        Intrinsics.checkNotNull((Object)object2);
        object = (a)object2;
        return ((a)object).b > 0;
    }

    private final void a(Vector3ic object, int n2) {
        if ((object = this.k.get((Vector3ic)object)) != null) {
            boolean bl;
            a a2 = (a)this.h.c((DB)object);
            if (a2 != null) {
                a a3 = a2;
                bl = a2.b == n2;
            } else {
                bl = false;
            }
            if (bl) {
                return;
            }
            if (a2 == null) {
                this.h.a((DB)object, new a(null, n2, 1, null));
                return;
            }
            this.h.a((DB)object, org.valkyrienskies.core.impl.shadow.DU$a.a$default(a2, null, n2, 1));
        }
    }

    @Override
    public final void e(int n2, int n3, int n4) {
        this.a.remove(new Vector3i(n2, n3, n4));
        HashSet<SparseVoxelPosition> hashSet = new HashSet<SparseVoxelPosition>();
        int n5 = n2 - 1;
        int n6 = n2 + 1;
        if (n5 <= n6) {
            while (true) {
                int n7;
                int n8;
                if ((n8 = n3 - 1) <= (n7 = n3 + 1)) {
                    while (true) {
                        int n9;
                        int n10;
                        if ((n10 = n4 - 1) <= (n9 = n4 + 1)) {
                            while (true) {
                                if (!(!this.a.contains(new Vector3i(n5, n8, n10)) || !this.b && (n5 != n2 && n8 != n3 || n5 != n2 && n10 != n4 || n8 != n3 && n10 != n4) || !this.c && n5 != n2 && n8 != n3 && n10 != n4)) {
                                    Object object = this.k.getBorderingDirection(n5, n8, n10, new Vector3i(n2 - n5, n3 - n8, n4 - n10));
                                    object = object.iterator();
                                    while (object.hasNext()) {
                                        SparseVoxelPosition sparseVoxelPosition = (SparseVoxelPosition)object.next();
                                        if (hashSet.contains(sparseVoxelPosition)) continue;
                                        hashSet.add(sparseVoxelPosition);
                                        if (this.a((Vector3i)sparseVoxelPosition) != ConnectionStatus.UNKNOWN) continue;
                                        this.a((Vector3ic)sparseVoxelPosition, 1);
                                    }
                                }
                                if (n10 == n9) break;
                                ++n10;
                            }
                        }
                        if (n8 == n7) break;
                        ++n8;
                    }
                }
                if (n5 == n6) break;
                ++n5;
            }
        }
    }

    @Override
    public final void c(int n2, int n3, int n4, Long l2) {
        if (this.l.containsKey(new Vector3i(n2, n3, n4))) {
            int n5;
            int n6 = n2 << 4;
            int n7 = n3 << 4;
            int n8 = n4 << 4;
            ij_0 ij_02 = this.l.get(new Vector3i(n2, n3, n4));
            Intrinsics.checkNotNull((Object)ij_02);
            Object object = ij_02;
            n3 = 0;
            n4 = -1;
            Object object2 = object;
            int n9 = ((ij_0)object2).e.length;
            for (int i2 = 0; i2 < n9; ++i2) {
                int n10;
                object2 = object;
                n5 = n10 = ((ij_0)object2).e[i2];
                if (!(switch (n10) {
                    case 2, 3 -> true;
                    default -> n5 == this.f;
                })) continue;
                ++n3;
                if (n4 != -1) continue;
                n4 = i2;
            }
            switch (n3) {
                case 0: {
                    return;
                }
                case 1: {
                    n9 = n4 & 0xF;
                    int n11 = n4 >> 4 & 0xF;
                    n5 = n4 >> 8 & 0xF;
                    object = new SparseVoxelPosition(n6 + n9, n7 + n11, n8 + n5, 1L);
                    this.a((SparseVoxelPosition)object, l2);
                    return;
                }
                case 4096: {
                    SparseVoxelPosition sparseVoxelPosition = new SparseVoxelPosition(n6, n7, n8, 16L);
                    this.a(sparseVoxelPosition, l2);
                    return;
                }
            }
            object2 = object;
            Set set = this.a(new SparseVoxelPosition(n6, n7, n8, 16L), ((ij_0)object2).e, l2, 4096);
            for (SparseVoxelPosition sparseVoxelPosition : set) {
                this.a(sparseVoxelPosition, l2);
            }
        }
    }

    private final Set<SparseVoxelPosition> a(SparseVoxelPosition cloneable, Set<? extends Vector3ic> set, Long l2, int n2) {
        if (set.size() == n2) {
            return SetsKt.setOf((Object)cloneable);
        }
        if (((SparseVoxelPosition)cloneable).getExtent() == 1L && set.isEmpty()) {
            return SetsKt.emptySet();
        }
        n2 = ((Vector3i)cloneable).x + Math.max(1, (int)((SparseVoxelPosition)cloneable).getExtent() / 2);
        int n3 = ((Vector3i)cloneable).y + Math.max(1, (int)((SparseVoxelPosition)cloneable).getExtent() / 2);
        int n4 = ((Vector3i)cloneable).z + Math.max(1, (int)((SparseVoxelPosition)cloneable).getExtent() / 2);
        Object object = new HashSet<SparseVoxelPosition>();
        ((HashSet)object).add(new SparseVoxelPosition(((Vector3i)cloneable).x, ((Vector3i)cloneable).y, ((Vector3i)cloneable).z, ((SparseVoxelPosition)cloneable).getExtent() / 2L));
        ((HashSet)object).add(new SparseVoxelPosition(n2, ((Vector3i)cloneable).y, ((Vector3i)cloneable).z, ((SparseVoxelPosition)cloneable).getExtent() / 2L));
        ((HashSet)object).add(new SparseVoxelPosition(((Vector3i)cloneable).x, n3, ((Vector3i)cloneable).z, ((SparseVoxelPosition)cloneable).getExtent() / 2L));
        ((HashSet)object).add(new SparseVoxelPosition(n2, n3, ((Vector3i)cloneable).z, ((SparseVoxelPosition)cloneable).getExtent() / 2L));
        ((HashSet)object).add(new SparseVoxelPosition(((Vector3i)cloneable).x, ((Vector3i)cloneable).y, n4, ((SparseVoxelPosition)cloneable).getExtent() / 2L));
        ((HashSet)object).add(new SparseVoxelPosition(n2, ((Vector3i)cloneable).y, n4, ((SparseVoxelPosition)cloneable).getExtent() / 2L));
        ((HashSet)object).add(new SparseVoxelPosition(((Vector3i)cloneable).x, n3, n4, ((SparseVoxelPosition)cloneable).getExtent() / 2L));
        ((HashSet)object).add(new SparseVoxelPosition(n2, n3, n4, ((SparseVoxelPosition)cloneable).getExtent() / 2L));
        cloneable = new HashSet();
        Iterator iterator2 = ((HashSet)object).iterator();
        while (iterator2.hasNext()) {
            Object object2 = (SparseVoxelPosition)iterator2.next();
            n4 = (int)((SparseVoxelPosition)object2).getVolume();
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"");
            object = set;
            SparseVoxelPosition sparseVoxelPosition = object2;
            DU dU = this;
            Cloneable cloneable2 = cloneable;
            Collection collection = new ArrayList();
            object = object.iterator();
            while (object.hasNext()) {
                Object e2 = object.next();
                Vector3ic vector3ic = (Vector3ic)e2;
                if (!((SparseVoxelPosition)object2).contains(vector3ic)) continue;
                collection.add(e2);
            }
            object2 = (List)collection;
            ((AbstractCollection)((Object)cloneable2)).addAll((Collection)dU.a(sparseVoxelPosition, CollectionsKt.toSet((Iterable)((Iterable)object2)), l2, n4));
        }
        return (Set)((Object)cloneable);
    }

    private static /* synthetic */ Set a$default(DU dU, SparseVoxelPosition sparseVoxelPosition, Set set, Long l2, int n2, int n3) {
        return dU.a(sparseVoxelPosition, set, null, 4096);
    }

    private final Set<SparseVoxelPosition> a(SparseVoxelPosition cloneable, int[] nArray, Long l2, int n2) {
        if (this.a(nArray) == n2) {
            return SetsKt.setOf((Object)cloneable);
        }
        if (((SparseVoxelPosition)cloneable).getExtent() == 1L && this.a(nArray) == 0) {
            return SetsKt.emptySet();
        }
        n2 = ((Vector3i)cloneable).x + Math.max(1, (int)((SparseVoxelPosition)cloneable).getExtent() / 2);
        int n3 = ((Vector3i)cloneable).y + Math.max(1, (int)((SparseVoxelPosition)cloneable).getExtent() / 2);
        int n4 = ((Vector3i)cloneable).z + Math.max(1, (int)((SparseVoxelPosition)cloneable).getExtent() / 2);
        HashSet<SparseVoxelPosition> hashSet = new HashSet<SparseVoxelPosition>();
        hashSet.add(new SparseVoxelPosition(((Vector3i)cloneable).x, ((Vector3i)cloneable).y, ((Vector3i)cloneable).z, ((SparseVoxelPosition)cloneable).getExtent() / 2L));
        hashSet.add(new SparseVoxelPosition(n2, ((Vector3i)cloneable).y, ((Vector3i)cloneable).z, ((SparseVoxelPosition)cloneable).getExtent() / 2L));
        hashSet.add(new SparseVoxelPosition(((Vector3i)cloneable).x, n3, ((Vector3i)cloneable).z, ((SparseVoxelPosition)cloneable).getExtent() / 2L));
        hashSet.add(new SparseVoxelPosition(n2, n3, ((Vector3i)cloneable).z, ((SparseVoxelPosition)cloneable).getExtent() / 2L));
        hashSet.add(new SparseVoxelPosition(((Vector3i)cloneable).x, ((Vector3i)cloneable).y, n4, ((SparseVoxelPosition)cloneable).getExtent() / 2L));
        hashSet.add(new SparseVoxelPosition(n2, ((Vector3i)cloneable).y, n4, ((SparseVoxelPosition)cloneable).getExtent() / 2L));
        hashSet.add(new SparseVoxelPosition(((Vector3i)cloneable).x, n3, n4, ((SparseVoxelPosition)cloneable).getExtent() / 2L));
        hashSet.add(new SparseVoxelPosition(n2, n3, n4, ((SparseVoxelPosition)cloneable).getExtent() / 2L));
        cloneable = new HashSet();
        for (SparseVoxelPosition sparseVoxelPosition : hashSet) {
            n4 = (int)sparseVoxelPosition.getVolume();
            Intrinsics.checkNotNullExpressionValue((Object)sparseVoxelPosition, (String)"");
            ((AbstractCollection)((Object)cloneable)).addAll((Collection)this.a(sparseVoxelPosition, DU.a(nArray, sparseVoxelPosition.x, sparseVoxelPosition.y, sparseVoxelPosition.z, (int)sparseVoxelPosition.getExtent()), l2, n4));
        }
        return (Set)((Object)cloneable);
    }

    private final int a(int[] nArray) {
        int n2 = 0;
        for (int n3 : nArray) {
            if (n3 == -1) continue;
            if (!(switch (n3) {
                case 2, 3 -> true;
                default -> n3 == this.f;
            })) continue;
            ++n2;
        }
        return n2;
    }

    private static int[] a(int[] nArray, int n2, int n3, int n4, int n5) {
        int[] nArray2 = new int[4096];
        int n6 = nArray.length;
        for (int i2 = 0; i2 < n6; ++i2) {
            int n7 = (i2 & 0xF) + n2;
            int n8 = (i2 >> 4 & 0xF) + n3;
            int n9 = (i2 >> 8 & 0xF) + n4;
            nArray2[i2] = n7 < n2 || n7 >= n2 + n5 || n8 < n3 || n8 >= n3 + n5 || n9 < n4 || n9 >= n4 + n5 ? -1 : nArray[i2];
        }
        return nArray2;
    }

    @Override
    public final void a(int n2, int n3, int n4, ij_0 ij_02) {
        Intrinsics.checkNotNullParameter((Object)ij_02, (String)"");
        if (this.a.contains(new Vector3i(n2 >> 4, n3 >> 4, n4 >> 4))) {
            return;
        }
        Map map2 = this.l;
        Vector3i vector3i = new Vector3i(n2 >> 4, n3 >> 4, n4 >> 4);
        Object object = map2.get(vector3i);
        if (object == null) {
            object = ij_02;
            map2.put(vector3i, object);
        }
    }

    @Override
    public final void f(int n2, int n3, int n4) {
        if (this.a.contains(new Vector3i(n2 >> 4, n3 >> 4, n4 >> 4))) {
            return;
        }
        Map map2 = this.l;
        Vector3i vector3i = new Vector3i(n2 >> 4, n3 >> 4, n4 >> 4);
        Object v = map2.get(vector3i);
        if (v == null) {
            ij_0 ij_02 = new ij_0(n2 >> 4, n3 >> 4, n4 >> 4, null, 8, null);
            map2.put(vector3i, ij_02);
        }
    }

    public final boolean a(DD dD, DD dD2, DD object) {
        Vector3ic vector3ic;
        Object object2;
        Vector3ic vector3ic2;
        Intrinsics.checkNotNullParameter((Object)dD, (String)"");
        Intrinsics.checkNotNullParameter((Object)dD2, (String)"");
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Object object3 = this.o.remove(dD);
        Object object4 = this.o.remove(dD2);
        if (object3 != null || object4 != null) {
            Object object5;
            Vector3ic vector3ic3;
            Object object6;
            Vector3ic vector3ic4;
            Object object7;
            Object object8;
            if (object3 != null && object4 != null) {
                Intrinsics.checkNotNullParameter((Object)object4, (String)"");
                object8 = new HashMap<DoubleComponentAugmentation, Double>();
                for (DoubleComponentAugmentation doubleComponentAugmentation : ((d)object4).a.keySet()) {
                    Map map2 = (Map)object8;
                    Intrinsics.checkNotNullExpressionValue((Object)doubleComponentAugmentation, (String)"");
                    DoubleComponentAugmentation doubleComponentAugmentation2 = doubleComponentAugmentation;
                    map2.put(doubleComponentAugmentation2, doubleComponentAugmentation2.combineDouble(((d)object3).a(doubleComponentAugmentation), ((d)object4).a(doubleComponentAugmentation)));
                }
                v2 = new d((HashMap<DoubleComponentAugmentation, Double>)object8);
            } else {
                v2 = object3;
                if (v2 == null && (v2 = object4) == null) {
                    v2 = object3 = new d(new HashMap<DoubleComponentAugmentation, Double>());
                }
            }
            if ((object4 = ((DD)object).f != null ? this.a(((DD)object).f) : this.a(((DD)object).b.f)) != null && this.k.containsKey((Vector3ic)object4) && this.a(new Vector3i((Vector3ic)object4)) != ConnectionStatus.DISCONNECTED) {
                Vector3ic vector3ic5;
                Object object9;
                Vector3ic vector3ic6;
                this.p.forEach((arg_0, arg_1) -> DU.a((Function2)new Function2<ChunkClaim, HashSet<DD>, Unit>(dD, dD2){
                    private /* synthetic */ DD $a;
                    private /* synthetic */ DD $b;
                    {
                        this.$a = dD;
                        this.$b = dD2;
                        super(2);
                    }

                    public final void a(ChunkClaim chunkClaim, HashSet<DD> hashSet) {
                        Intrinsics.checkNotNullParameter((Object)chunkClaim, (String)"");
                        Intrinsics.checkNotNullParameter(hashSet, (String)"");
                        hashSet.remove(this.$a);
                        hashSet.remove(this.$b);
                    }

                    /*
                     * WARNING - void declaration
                     */
                    public final /* synthetic */ Object invoke(Object p1, Object p2) {
                        void var2_2;
                        void var1_1;
                        this.a((ChunkClaim)var1_1, (HashSet)var2_2);
                        return Unit.INSTANCE;
                    }
                }, arg_0, arg_1));
                Object object10 = dD.f;
                if (object10 == null) {
                    object10 = dD.g;
                }
                if ((vector3ic6 = this.a(object10)) == null) {
                    vector3ic6 = new Vector3i();
                }
                if ((object9 = dD2.f) == null) {
                    object9 = dD2.g;
                }
                if ((vector3ic5 = this.a(object9)) == null) {
                    vector3ic5 = new Vector3i();
                }
                object3 = new MergeEventImpl(false, vector3ic6, vector3ic5, new Vector3i(), this.f);
                this.j.add((MergeEvent)object3);
                return false;
            }
            ((Map)this.o).put(object, object3);
            object3 = new Ref.ObjectRef();
            new Ref.ObjectRef().element = new Pair((Object)ChunkClaimImpl.Companion.getClaim(-1, -1), object);
            this.p.forEach((arg_0, arg_1) -> DU.b((Function2)new Function2<ChunkClaim, HashSet<DD>, Unit>(dD, dD2, (DD)object, (Vector3ic)object4, (Ref.ObjectRef<Pair<ChunkClaim, DD>>)object3){
                private /* synthetic */ DD $a;
                private /* synthetic */ DD $b;
                private /* synthetic */ DD $c;
                private /* synthetic */ Vector3ic $d;
                private /* synthetic */ Ref.ObjectRef<Pair<ChunkClaim, DD>> $e;
                {
                    this.$a = dD;
                    this.$b = dD2;
                    this.$c = dD3;
                    this.$d = vector3ic;
                    this.$e = objectRef;
                    super(2);
                }

                public final void a(ChunkClaim chunkClaim, HashSet<DD> hashSet) {
                    Intrinsics.checkNotNullParameter((Object)chunkClaim, (String)"");
                    Intrinsics.checkNotNullParameter(hashSet, (String)"");
                    int n2 = 0;
                    if (hashSet.remove(this.$a) || hashSet.remove(this.$b)) {
                        hashSet.add(this.$c);
                        n2 = 1;
                    }
                    if (n2 == 0 && this.$d != null) {
                        n2 = this.$d.x() >> 4;
                        int n3 = this.$d.z() >> 4;
                        ChunkClaim chunkClaim2 = ChunkClaimImpl.Companion.getClaim(n2, n3);
                        this.$e.element = new Pair((Object)chunkClaim2, (Object)this.$c);
                    }
                }

                /*
                 * WARNING - void declaration
                 */
                public final /* synthetic */ Object invoke(Object p1, Object p2) {
                    void var2_2;
                    void var1_1;
                    this.a((ChunkClaim)var1_1, (HashSet)var2_2);
                    return Unit.INSTANCE;
                }
            }, arg_0, arg_1));
            if (!Intrinsics.areEqual((Object)((Pair)((Ref.ObjectRef)object3).element).getFirst(), (Object)ChunkClaimImpl.Companion.getClaim(-1, -1))) {
                Object object11;
                object = this.p;
                object8 = ((Pair)((Ref.ObjectRef)object3).element).getFirst();
                Object object12 = object.get(object8);
                if (object12 == null) {
                    object12 = new HashSet();
                    object.put(object8, object12);
                    object11 = object12;
                } else {
                    object11 = object12;
                }
                ((HashSet)object11).add(((Pair)((Ref.ObjectRef)object3).element).getSecond());
            }
            if ((object7 = dD.f) == null) {
                object7 = dD.g;
            }
            if ((vector3ic4 = this.a(object7)) == null) {
                vector3ic4 = new Vector3i();
            }
            if ((object6 = dD2.f) == null) {
                object6 = dD2.g;
            }
            if ((vector3ic3 = this.a(object6)) == null) {
                vector3ic3 = new Vector3i();
            }
            if ((object5 = object4) == null) {
                object5 = new Vector3i();
            }
            object = new MergeEventImpl(true, vector3ic4, vector3ic3, (Vector3ic)object5, this.f);
            this.j.add((MergeEvent)object);
            return true;
        }
        Object object13 = dD.f;
        if (object13 == null) {
            object13 = dD.g;
        }
        if ((vector3ic2 = this.a(object13)) == null) {
            vector3ic2 = new Vector3i();
        }
        if ((object2 = dD2.f) == null) {
            object2 = dD2.g;
        }
        if ((vector3ic = this.a(object2)) == null) {
            vector3ic = new Vector3i();
        }
        object3 = new MergeEventImpl(false, vector3ic2, vector3ic, new Vector3i(), this.f);
        this.j.add((MergeEvent)object3);
        return false;
    }

    public final boolean b(DD object, DD object2, DD dD) {
        Vector3ic vector3ic;
        Vector3ic vector3ic2;
        Vector3ic vector3ic3;
        Object object3;
        Pair pair;
        Object object4;
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        Intrinsics.checkNotNullParameter((Object)dD, (String)"");
        d d2 = this.o.remove(dD);
        Vector3ic vector3ic4 = ((DD)object).f != null ? this.a(((DD)object).f) : this.a(((DD)object).b.f);
        Vector3ic vector3ic5 = ((DD)object2).f != null ? this.a(((DD)object2).f) : this.a(((DD)object2).b.f);
        Object object5 = new b((DD)object, 1L);
        b b2 = new b((DD)object2, 0L, 2, null);
        boolean bl = true;
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        new Ref.BooleanRef().element = true;
        if (vector3ic4 != null && this.k.containsKey(vector3ic4) && this.a(new Vector3i(vector3ic4)) != ConnectionStatus.DISCONNECTED) {
            bl = false;
        }
        if (vector3ic5 != null && this.k.containsKey(vector3ic5) && this.a(new Vector3i(vector3ic5)) != ConnectionStatus.DISCONNECTED) {
            booleanRef.element = false;
        }
        bl = ((b)object5).getSize() == 0L || !bl;
        d d3 = d2;
        if (d3 != null) {
            Component component = b2;
            object4 = (Component)object5;
            d2 = d3;
            Intrinsics.checkNotNullParameter((Object)object4, (String)"");
            Intrinsics.checkNotNullParameter((Object)component, (String)"");
            HashMap<DoubleComponentAugmentation, Double> hashMap = new HashMap<DoubleComponentAugmentation, Double>();
            HashMap<DoubleComponentAugmentation, Double> hashMap2 = new HashMap<DoubleComponentAugmentation, Double>();
            for (DoubleComponentAugmentation doubleComponentAugmentation : d2.a.keySet()) {
                Double d4 = d2.a.get(doubleComponentAugmentation);
                Intrinsics.checkNotNull((Object)d4);
                double d5 = ((Number)d4).doubleValue();
                Object object6 = doubleComponentAugmentation.splitDouble(d5, (Component)object4, component);
                double d6 = ((DoublePair)object6).component1();
                double d7 = ((DoublePair)object6).component2();
                object6 = d6;
                Map map2 = hashMap;
                Intrinsics.checkNotNullExpressionValue((Object)doubleComponentAugmentation, (String)"");
                map2.put(doubleComponentAugmentation, object6);
                object6 = d7;
                ((Map)hashMap2).put(doubleComponentAugmentation, object6);
            }
            pair = new Pair((Object)new d(hashMap), (Object)new d(hashMap2));
        } else {
            pair = new Pair((Object)new d(new HashMap<DoubleComponentAugmentation, Double>()), (Object)new d(new HashMap<DoubleComponentAugmentation, Double>()));
        }
        d2 = pair;
        object4 = (d)pair.component1();
        d2 = (d)d2.component2();
        v4.a = true;
        object5 = b2;
        b2.a = true;
        if (!bl) {
            ((Map)this.o).put(object, object4);
        }
        if (booleanRef.element) {
            ((Map)this.o).put(object2, d2);
        }
        d2 = new Ref.ObjectRef();
        new Ref.ObjectRef().element = new Pair((Object)ChunkClaimImpl.Companion.getClaim(-1, -1), new HashSet());
        this.p.forEach((arg_0, arg_1) -> DU.c((Function2)new Function2<ChunkClaim, HashSet<DD>, Unit>(dD, bl, (DD)object, booleanRef, (DD)object2, vector3ic4, (Ref.ObjectRef<Pair<ChunkClaim, HashSet<DD>>>)d2, vector3ic5){
            private /* synthetic */ DD $a;
            private /* synthetic */ boolean $b;
            private /* synthetic */ DD $c;
            private /* synthetic */ Ref.BooleanRef $d;
            private /* synthetic */ DD $e;
            private /* synthetic */ Vector3ic $f;
            private /* synthetic */ Ref.ObjectRef<Pair<ChunkClaim, HashSet<DD>>> $g;
            private /* synthetic */ Vector3ic $h;
            {
                this.$a = dD;
                this.$b = bl;
                this.$c = dD2;
                this.$d = booleanRef;
                this.$e = dD3;
                this.$f = vector3ic;
                this.$g = objectRef;
                this.$h = vector3ic2;
                super(2);
            }

            public final void a(ChunkClaim chunkClaim, HashSet<DD> hashSet) {
                Intrinsics.checkNotNullParameter((Object)chunkClaim, (String)"");
                Intrinsics.checkNotNullParameter(hashSet, (String)"");
                int n2 = hashSet.remove(this.$a);
                boolean bl = false;
                boolean bl2 = false;
                if (n2 != 0) {
                    if (!this.$b) {
                        hashSet.add(this.$c);
                        bl = true;
                    }
                    if (this.$d.element) {
                        hashSet.add(this.$e);
                        bl2 = true;
                    }
                }
                if (!bl && !bl2) {
                    if (this.$f != null && !this.$b) {
                        Object[] objectArray;
                        n2 = this.$f.x() >> 4;
                        int n3 = this.$f.z() >> 4;
                        Object[] objectArray2 = objectArray = ChunkClaimImpl.Companion.getClaim(n2, n3);
                        Object[] objectArray3 = new DD[1];
                        objectArray = objectArray3;
                        objectArray3[0] = this.$c;
                        this.$g.element = new Pair((Object)objectArray2, (Object)SetsKt.hashSetOf((Object[])objectArray));
                    }
                    if (this.$h != null && this.$d.element) {
                        int n4 = this.$h.x() >> 4;
                        int n5 = this.$h.z() >> 4;
                        Object[] objectArray = ChunkClaimImpl.Companion.getClaim(n4, n5);
                        if (((HashSet)((Pair)this.$g.element).getSecond()).isEmpty()) {
                            Object[] objectArray4 = objectArray;
                            Object[] objectArray5 = new DD[1];
                            objectArray = objectArray5;
                            objectArray5[0] = this.$e;
                            this.$g.element = new Pair((Object)objectArray4, (Object)SetsKt.hashSetOf((Object[])objectArray));
                            return;
                        }
                        ((HashSet)((Pair)this.$g.element).getSecond()).add(this.$e);
                    }
                }
            }

            /*
             * WARNING - void declaration
             */
            public final /* synthetic */ Object invoke(Object p1, Object p2) {
                void var2_2;
                void var1_1;
                this.a((ChunkClaim)var1_1, (HashSet)var2_2);
                return Unit.INSTANCE;
            }
        }, arg_0, arg_1));
        if (!((Collection)((Pair)((Ref.ObjectRef)d2).element).getSecond()).isEmpty()) {
            Object object7;
            object = this.p;
            object2 = ((Pair)((Ref.ObjectRef)d2).element).getFirst();
            object5 = object.get(object2);
            if (object5 == null) {
                object5 = new HashSet();
                object.put(object2, object5);
                object7 = object5;
            } else {
                object7 = object5;
            }
            ((HashSet)object7).addAll((Collection)((Pair)((Ref.ObjectRef)d2).element).getSecond());
        }
        if ((object3 = dD.f) == null) {
            object3 = dD.g;
        }
        if ((vector3ic3 = this.a(object3)) == null) {
            vector3ic3 = new Vector3i();
        }
        if ((vector3ic2 = vector3ic4) == null) {
            vector3ic2 = new Vector3i();
        }
        if ((vector3ic = vector3ic5) == null) {
            vector3ic = new Vector3i();
        }
        object = new SplitEventImpl(true, vector3ic3, vector3ic2, vector3ic, this.f);
        this.i.add((SplitEvent)object);
        return true;
    }

    private final a h(int n2, int n3, int n4) {
        DB dB = this.k.get(n2, n3, n4);
        try {
            if (dB == null) {
                String string = "Cannot get augmentation info for node " + n2 + " " + n3 + " " + n4 + " not in graph";
                throw new IllegalArgumentException(string.toString());
            }
        }
        catch (Exception exception) {
            DW.a.a().warn(exception);
            return null;
        }
        a a2 = (a)this.h.c(dB);
        return a2;
    }

    @Override
    public final double a(DoubleAugmentation doubleAugmentation, int n2, int n3, int n4) {
        Intrinsics.checkNotNullParameter((Object)doubleAugmentation, (String)"");
        a a2 = this.h(n2, n3, n4);
        if (a2 != null) {
            return a2.a(doubleAugmentation);
        }
        return 0.0;
    }

    @Override
    public final void a(DoubleAugmentation object, int n2, int n3, int n4, double d2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        DB dB = this.k.get(n2, n3, n4);
        try {
            if (dB == null) {
                String string = "Cannot set augmentation on node " + n2 + " " + n3 + " " + n4 + " not in graph";
                throw new IllegalArgumentException(string.toString());
            }
        }
        catch (Exception exception) {
            DW.a.a().warn(exception);
            return;
        }
        a a2 = (a)this.h.c(dB);
        Object2DoubleOpenHashMap object2DoubleOpenHashMap = new Object2DoubleOpenHashMap();
        if (a2 != null) {
            a a3 = a2;
            object2DoubleOpenHashMap.putAll((Map)a3.a);
        }
        object2DoubleOpenHashMap.put(object, d2);
        a a4 = a2;
        if (a4 == null || (a4 = org.valkyrienskies.core.impl.shadow.DU$a.a$default(a4, (Object2DoubleMap)object2DoubleOpenHashMap, 0, 2)) == null) {
            a4 = new a((Object2DoubleMap)object2DoubleOpenHashMap, 0, 2, null);
        }
        object = a4;
        this.h.a(dB, object);
    }

    private final void a(DoubleAugmentation object, int n2, int n3, int n4, long l2, double d2) {
        DB dB = this.k.get(n2, n3, n4, l2);
        try {
            if (dB == null) {
                String string = "Cannot set augmentation on node " + n2 + " " + n3 + " " + n4 + " " + l2 + " not in graph";
                throw new IllegalArgumentException(string.toString());
            }
        }
        catch (Exception exception) {
            DW.a.a().warn(exception);
            return;
        }
        a a2 = (a)this.h.c(dB);
        Object2DoubleOpenHashMap object2DoubleOpenHashMap = new Object2DoubleOpenHashMap();
        if (a2 != null) {
            a a3 = a2;
            object2DoubleOpenHashMap.putAll((Map)a3.a);
        }
        object2DoubleOpenHashMap.put(object, d2);
        a a4 = a2;
        if (a4 == null || (a4 = org.valkyrienskies.core.impl.shadow.DU$a.a$default(a4, (Object2DoubleMap)object2DoubleOpenHashMap, 0, 2)) == null) {
            a4 = new a((Object2DoubleMap)object2DoubleOpenHashMap, 0, 2, null);
        }
        object = a4;
        this.h.a(dB, object);
    }

    @Override
    public final void a(DoubleAugmentation doubleAugmentation, int n2, int n3, int n4, DoubleUnaryOperator doubleUnaryOperator) {
        Intrinsics.checkNotNullParameter((Object)doubleAugmentation, (String)"");
        Intrinsics.checkNotNullParameter((Object)doubleUnaryOperator, (String)"");
        this.a(doubleAugmentation, n2, n3, n4, doubleUnaryOperator.applyAsDouble(this.a(doubleAugmentation, n2, n3, n4)));
    }

    @Override
    public final void b(DoubleAugmentation object, int n2, int n3, int n4) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        DB dB = this.k.get(n2, n3, n4);
        try {
            if (dB == null) {
                String string = "Cannot set augmentation on node " + n2 + " " + n3 + " " + n4 + " not in graph";
                throw new IllegalArgumentException(string.toString());
            }
        }
        catch (Exception exception) {
            DW.a.a().warn(exception);
            return;
        }
        a a2 = (a)this.h.c(dB);
        Object2DoubleOpenHashMap object2DoubleOpenHashMap = new Object2DoubleOpenHashMap();
        if (a2 != null) {
            a a3 = a2;
            object2DoubleOpenHashMap.putAll((Map)a3.a);
        }
        object2DoubleOpenHashMap.removeDouble(object);
        a a4 = a2;
        if (a4 == null || (a4 = org.valkyrienskies.core.impl.shadow.DU$a.a$default(a4, (Object2DoubleMap)object2DoubleOpenHashMap, 0, 2)) == null) {
            a4 = new a((Object2DoubleMap)object2DoubleOpenHashMap, 0, 2, null);
        }
        object = a4;
        this.h.a(dB, object);
    }

    @Override
    public final double c(DoubleAugmentation object, int n2, int n3, int n4) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        DB dB = this.k.get(n2, n3, n4);
        try {
            if (dB == null) {
                String string = "Cannot collect augmentation from node " + n2 + " " + n3 + " " + n4 + " not in graph";
                throw new IllegalArgumentException(string.toString());
            }
            if (!(this.a(dB) == ConnectionStatus.DISCONNECTED)) {
                object = "Cannot collect augmentation for node connected to the world";
                throw new IllegalArgumentException(object.toString());
            }
        }
        catch (Exception exception) {
            DW.a.a().warn(exception);
            return 0.0;
        }
        a a2 = (a)this.h.d(dB);
        if (a2 == null) {
            return 0.0;
        }
        a a3 = a2;
        return a2.a((DoubleAugmentation)object);
    }

    @Override
    public final boolean a(DoubleComponentAugmentation object, int n2, int n3, int n4, double d2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Object object2 = this.k.get(n2, n3, n4);
        try {
            if (object2 == null) {
                String string = "Cannot store to component on node " + n2 + " " + n3 + " " + n4 + " not in graph";
                throw new IllegalArgumentException(string.toString());
            }
            if (!(this.a((DB)object2) == ConnectionStatus.DISCONNECTED)) {
                object2 = "Cannot store to component for node connected to the world";
                throw new IllegalArgumentException(object2.toString());
            }
        }
        catch (Exception exception) {
            DW.a.a().warn(exception);
            return false;
        }
        Object object3 = this.h.a.get(object2);
        DD dD = object3 != null && (object3 = ((DG)object3).a) != null && (object3 = ((DE)object3).c) != null ? (DD)((DH)object3).e() : null;
        if (dD == null) {
            return false;
        }
        DD dD2 = dD;
        d d3 = this.o.get(dD2);
        if (d3 == null) {
            d3 = new d(new HashMap<DoubleComponentAugmentation, Double>());
        }
        object2 = d3;
        double d4 = d2;
        DoubleComponentAugmentation doubleComponentAugmentation = object;
        object = d3;
        Intrinsics.checkNotNullParameter((Object)doubleComponentAugmentation, (String)"");
        Double d5 = d4;
        ((Map)((d)object).a).put(doubleComponentAugmentation, d5);
        ((Map)this.o).put(dD2, object2);
        object = ChunkClaimImpl.Companion.getClaim(n2 << 4, n4 << 4);
        if (this.p.get(object) != null) {
            HashSet<DD> hashSet = this.p.get(object);
            Intrinsics.checkNotNull(hashSet);
            hashSet.add(dD2);
        } else {
            Map map2 = this.p;
            Object[] objectArray = new DD[1];
            Object object4 = objectArray;
            objectArray[0] = dD2;
            object4 = SetsKt.hashSetOf((Object[])object4);
            map2.put(object, object4);
        }
        return true;
    }

    @Override
    public final double a(DoubleComponentAugmentation doubleComponentAugmentation, int n2, int n3, int n4) {
        Intrinsics.checkNotNullParameter((Object)doubleComponentAugmentation, (String)"");
        DB dB = this.k.get(n2, n3, n4);
        try {
            if (dB == null) {
                String string = "Cannot retrieve from component on node " + n2 + " " + n3 + " " + n4 + " not in graph";
                throw new IllegalArgumentException(string.toString());
            }
            if (!(this.a(dB) == ConnectionStatus.DISCONNECTED)) {
                String string = "Cannot store to component for node connected to the world";
                throw new IllegalArgumentException(string.toString());
            }
        }
        catch (Exception exception) {
            DW.a.a().warn(exception);
            return 0.0;
        }
        Object object = this.h.a.get(dB);
        DD dD = object != null && (object = ((DG)object).a) != null && (object = ((DE)object).c) != null ? (DD)((DH)object).e() : null;
        if (dD == null) {
            return 0.0;
        }
        Object object2 = dD;
        d d2 = this.o.get(object2);
        if (d2 == null) {
            return 0.0;
        }
        object2 = d2;
        return d2.a(doubleComponentAugmentation);
    }

    @Override
    public final boolean b(DoubleComponentAugmentation object, int n2, int n3, int n4) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        DB dB = this.k.get(n2, n3, n4);
        try {
            if (dB == null) {
                String string = "Cannot remove from component on node " + n2 + " " + n3 + " " + n4 + " not in graph";
                throw new IllegalArgumentException(string.toString());
            }
            if (!(this.a(dB) == ConnectionStatus.DISCONNECTED)) {
                String string = "Cannot store to component for node connected to the world";
                throw new IllegalArgumentException(string.toString());
            }
        }
        catch (Exception exception) {
            DW.a.a().warn(exception);
            return false;
        }
        Object object2 = this.h.a.get(dB);
        DD dD = object2 != null && (object2 = ((DG)object2).a) != null && (object2 = ((DE)object2).c) != null ? (DD)((DH)object2).e() : null;
        if (dD == null) {
            return false;
        }
        DD dD2 = dD;
        d d2 = this.o.get(dD2);
        if (d2 == null) {
            return false;
        }
        d d3 = d2;
        DoubleComponentAugmentation doubleComponentAugmentation = object;
        object = d2;
        Intrinsics.checkNotNullParameter((Object)doubleComponentAugmentation, (String)"");
        ((d)object).a.remove(doubleComponentAugmentation);
        ((Map)this.o).put(dD2, d3);
        return true;
    }

    @Override
    public final long g(int n2, int n3, int n4) {
        Object object = this.k.get(n2, n3, n4);
        try {
            if (object == null) {
                object = "Cannot get component size for node " + n2 + " " + n3 + " " + n4 + " not in graph";
                throw new IllegalArgumentException(object.toString());
            }
            if (!(this.a((DB)object) == ConnectionStatus.DISCONNECTED)) {
                String string = "Cannot store to component for node connected to the world";
                throw new IllegalArgumentException(string.toString());
            }
        }
        catch (Exception exception) {
            DW.a.a().warn(exception);
            return -1L;
        }
        Object object2 = this.h.a.get(object);
        if (object2 == null || (object2 = ((DG)object2).a) == null || (object2 = ((DE)object2).c) == null || (object2 = (DD)((DH)object2).e()) == null) {
            return -1L;
        }
        int n5 = ((DD)object2).c;
        DU dU = this;
        double d2 = dU.c(dU.t, n2, n3, n4);
        int n6 = n5;
        return (long)(n6 - n6 / 2) + (long)d2;
    }

    @Override
    public final Map<Triple<Integer, Integer, Integer>, Double> a(DoubleAugmentation doubleAugmentation, ChunkClaim chunkClaim) {
        Object object;
        Object object2;
        Intrinsics.checkNotNullParameter((Object)doubleAugmentation, (String)"");
        HashMap hashMap = new HashMap();
        Object object3 = new HashSet(this.o.keySet());
        HashSet hashSet = new HashSet();
        if (chunkClaim != null && (object2 = this.p.get(chunkClaim)) != null) {
            DD dD;
            object3 = object2;
            Iterable iterator2 = object3;
            object = new ArrayList();
            for (a a2 : iterator2) {
                dD = (DD)((Object)a2);
                if (this.o.containsKey(dD)) continue;
                object.add(a2);
            }
            hashSet = CollectionsKt.toHashSet((Iterable)((List)object));
            object3 = object2;
            Iterable iterable = object3;
            object = new ArrayList();
            for (a a2 : iterable) {
                dD = (DD)((Object)a2);
                if (!this.o.containsKey(dD)) continue;
                object.add(a2);
            }
            object3 = CollectionsKt.toHashSet((Iterable)((List)object));
        }
        object2 = (HashSet<DD>)object3;
        for (Object e2 : object2) {
            double d2;
            double d3;
            a a2;
            object = (DD)e2;
            DD dD = object;
            if ((a)((DD)object).b.f == null) continue;
            double d4 = a2.a(this.q);
            object2 = this.d((int)d4, (int)(d3 = a2.a(this.r)), (int)(d2 = a2.a(this.s)));
            if (object2 == ConnectionStatus.DISCONNECTED) {
                ((Map)hashMap).put(new Triple((Object)((int)d4), (Object)((int)d3), (Object)((int)d2)), this.c(doubleAugmentation, (int)d4, (int)d3, (int)d2));
                continue;
            }
            if (object2 != ConnectionStatus.CONNECTED) continue;
            this.o.remove(object);
        }
        object2 = hashSet;
        for (Object t : object2) {
            object = (DD)t;
            Object v = ((Map)this.p).get(chunkClaim);
            Intrinsics.checkNotNull(v);
            ((HashSet)v).remove(object);
        }
        return hashMap;
    }

    @Override
    public final Map<Triple<Integer, Integer, Integer>, Double> a(DoubleComponentAugmentation doubleComponentAugmentation, ChunkClaim chunkClaim) {
        Object object;
        Object object2;
        Object object4;
        Intrinsics.checkNotNullParameter((Object)doubleComponentAugmentation, (String)"");
        HashMap hashMap = new HashMap();
        Object object5 = new HashSet(this.o.keySet());
        HashSet hashSet = new HashSet();
        if (chunkClaim != null && (object4 = this.p.get(chunkClaim)) != null) {
            object5 = object4;
            Iterable iterator2 = object5;
            object2 = new ArrayList();
            for (Object object3 : iterator2) {
                object = (DD)object3;
                if (this.o.containsKey(object)) continue;
                object2.add(object3);
            }
            hashSet = CollectionsKt.toHashSet((Iterable)((List)object2));
            object5 = object4;
            Iterable iterable = object5;
            object2 = new ArrayList();
            for (Object object3 : iterable) {
                object = (DD)object3;
                if (!this.o.containsKey(object)) continue;
                object2.add(object3);
            }
            object5 = CollectionsKt.toHashSet((Iterable)((List)object2));
        }
        object4 = (HashSet<DD>)object5;
        for (Object e2 : object4) {
            double d2;
            double d3;
            Object object3;
            object2 = (DD)e2;
            DD dD = object2;
            if (this.o.get(object2) == null) {
                throw new IllegalStateException("Component info not found for root, but it's in the index!");
            }
            Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"");
            Object object6 = dD.b.f;
            Intrinsics.checkNotNull((Object)object6);
            if ((a)object6 == null) continue;
            double d4 = ((a)object).a(this.q);
            object4 = this.d((int)d4, (int)(d3 = ((a)object).a(this.r)), (int)(d2 = ((a)object).a(this.s)));
            if (object4 == ConnectionStatus.DISCONNECTED) {
                ((Map)hashMap).put(new Triple((Object)((int)d4), (Object)((int)d3), (Object)((int)d2)), ((d)object3).a(doubleComponentAugmentation));
                continue;
            }
            if (object4 != ConnectionStatus.CONNECTED) continue;
            this.o.remove(object2);
        }
        object4 = hashSet;
        for (Object t : object4) {
            object2 = (DD)t;
            Object v = ((Map)this.p).get(chunkClaim);
            Intrinsics.checkNotNull(v);
            ((HashSet)v).remove(object2);
        }
        return hashMap;
    }

    @Override
    public final Set<Vector3ic> a(ChunkClaim iterator2) {
        Intrinsics.checkNotNullParameter((Object)iterator2, (String)"");
        HashSet<DD> hashSet = this.p.get(iterator2);
        if (hashSet == null) {
            return SetsKt.emptySet();
        }
        iterator2 = hashSet;
        HashSet<Vector3i> hashSet2 = new HashSet<Vector3i>();
        iterator2 = (Iterable)((Object)iterator2);
        iterator2 = iterator2.iterator();
        while (iterator2.hasNext()) {
            Object object = iterator2.next();
            object = (DD)object;
            Object object2 = ((DD)object).b.f;
            Intrinsics.checkNotNull((Object)object2);
            object = (a)object2;
            hashSet2.add(new Vector3i((int)((a)object).a(this.q), (int)((a)object).a(this.r), (int)((a)object).a(this.s)));
        }
        return hashSet2;
    }

    @Override
    public final void a(int n2, int n3, int n4, Function4<? super Integer, ? super Integer, ? super Integer, ? super Long, Unit> function4) {
        Intrinsics.checkNotNullParameter(function4, (String)"");
        Object object = this.k.get(n2, n3, n4);
        try {
            if (object == null) {
                String string = "Cannot traverse component referencing node " + n2 + " " + n3 + " " + n4 + " not in graph";
                throw new IllegalArgumentException(string.toString());
            }
        }
        catch (Exception exception) {
            DW.a.a().warn(exception);
            return;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        HashSet<DD> hashSet = new HashSet<DD>();
        Object object2 = this.h.a.get(object);
        if (object2 != null && (object2 = ((DG)object2).a) != null && (object2 = ((DE)object2).c) != null && (object2 = (DD)((DH)object2).e()) != null) {
            Object object3 = object2;
            arrayDeque.add(object3);
        }
        do {
            DD dD = (DD)arrayDeque.removeFirst();
            hashSet.add(dD);
            if (dD.h && dD.b.f instanceof a) {
                Object object4 = dD.b.f;
                Intrinsics.checkNotNull((Object)object4);
                object = (a)object4;
                function4.invoke((Object)((int)((a)object).a(this.q)), (Object)((int)((a)object).a(this.r)), (Object)((int)((a)object).a(this.s)), (Object)((long)((a)object).a(this.t)));
            }
            if (dD.j != null && !hashSet.contains(dD.j)) {
                Object n5 = dD.j;
                Intrinsics.checkNotNull(n5);
                arrayDeque.add(n5);
            }
            if (dD.k == null || hashSet.contains(dD.k)) continue;
            Object n6 = dD.k;
            Intrinsics.checkNotNull(n6);
            arrayDeque.add(n6);
        } while (!((Collection)arrayDeque).isEmpty());
    }

    @Override
    public final DenseBlockPosSet a(int n2, int n3, int n4, DenseBlockPosSet denseBlockPosSet) {
        Intrinsics.checkNotNullParameter((Object)denseBlockPosSet, (String)"");
        Object object = this.k.get(n2, n3, n4);
        try {
            if (object == null) {
                String string = "Cannot index component referencing node " + n2 + " " + n3 + " " + n4 + " not in graph";
                throw new IllegalArgumentException(string.toString());
            }
        }
        catch (Exception exception) {
            DW.a.a().warn(exception);
            return denseBlockPosSet;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        HashSet<DD> hashSet = new HashSet<DD>();
        Object object2 = this.h.a.get(object);
        if (object2 != null && (object2 = ((DG)object2).a) != null && (object2 = ((DE)object2).c) != null && (object2 = (DD)((DH)object2).e()) != null) {
            Object object3 = object2;
            arrayDeque.add(object3);
        }
        do {
            DD dD = (DD)arrayDeque.removeFirst();
            hashSet.add(dD);
            if (dD.h && dD.b.f instanceof a) {
                Object object4 = dD.b.f;
                Intrinsics.checkNotNull((Object)object4);
                object = (a)object4;
                denseBlockPosSet.add((int)((a)object).a(this.q), (int)((a)object).a(this.r), (int)((a)object).a(this.s));
            }
            if (dD.j != null && !hashSet.contains(dD.j)) {
                Object n5 = dD.j;
                Intrinsics.checkNotNull(n5);
                arrayDeque.add(n5);
            }
            if (dD.k == null || hashSet.contains(dD.k)) continue;
            Object n6 = dD.k;
            Intrinsics.checkNotNull(n6);
            arrayDeque.add(n6);
        } while (!((Collection)arrayDeque).isEmpty());
        return denseBlockPosSet;
    }

    @Override
    public final Pair<HashSet<SplitEvent>, HashSet<MergeEvent>> a() {
        Pair pair = new Pair(new HashSet(this.i), new HashSet(this.j));
        this.i.clear();
        this.j.clear();
        return pair;
    }

    private final Vector3ic a(Object object) {
        if (!(object instanceof a)) {
            return null;
        }
        return new Vector3i((int)((a)object).a(this.q), (int)((a)object).a(this.r), (int)((a)object).a(this.s));
    }

    private static final void a(Function2 function2, Object object, Object object2) {
        function2.invoke(object, object2);
    }

    private static final void b(Function2 function2, Object object, Object object2) {
        function2.invoke(object, object2);
    }

    private static final void c(Function2 function2, Object object, Object object2) {
        function2.invoke(object, object2);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u0005\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u00c6\u0003\u00a2\u0006\u0004\b\f\u0010\rJ*\u0010\u0005\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u000bH\u00c6\u0001\u00a2\u0006\u0004\b\u0005\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0005\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\b\u00a2\u0006\u0004\b\u0005\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u000bH\u00d6\u0001\u00a2\u0006\u0004\b\u0014\u0010\rJ\u0010\u0010\u0016\u001a\u00020\u0015H\u00d6\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0007\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0005\u0010\nR\u0017\u0010\u0019\u001a\u00020\u000b8\u0007\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\r"}, d2={"Lorg/valkyrienskies/core/impl/shadow/DU$a;", "Lorg/valkyrienskies/core/impl/shadow/Dy;", "", "p0", "p1", "a", "(Ljava/lang/Object;Ljava/lang/Object;)Lorg/valkyrienskies/core/impl/shadow/DU$a;", "Lit/unimi/dsi/fastutil/objects/Object2DoubleMap;", "Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;", "c", "()Lit/unimi/dsi/fastutil/objects/Object2DoubleMap;", "", "d", "()I", "(Lit/unimi/dsi/fastutil/objects/Object2DoubleMap;I)Lorg/valkyrienskies/core/impl/shadow/DU$a;", "", "equals", "(Ljava/lang/Object;)Z", "", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;)D", "hashCode", "", "toString", "()Ljava/lang/String;", "Lit/unimi/dsi/fastutil/objects/Object2DoubleMap;", "b", "I", "<init>", "(Lit/unimi/dsi/fastutil/objects/Object2DoubleMap;I)V"})
    public static final class a
    implements dy_0 {
        final Object2DoubleMap<DoubleAugmentation> a;
        final int b;

        private a(Object2DoubleMap<DoubleAugmentation> object2DoubleMap, int n2) {
            Intrinsics.checkNotNullParameter(object2DoubleMap, (String)"");
            this.a = object2DoubleMap;
            this.b = n2;
        }

        public /* synthetic */ a(Object2DoubleMap object2DoubleMap, int n2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n3 & 1) != 0) {
                Object2DoubleMap object2DoubleMap2 = Object2DoubleMaps.emptyMap();
                Intrinsics.checkNotNullExpressionValue((Object)object2DoubleMap2, (String)"");
                object2DoubleMap = object2DoubleMap2;
            }
            if ((n3 & 2) != 0) {
                n2 = 0;
            }
            this((Object2DoubleMap<DoubleAugmentation>)object2DoubleMap, n2);
        }

        @JvmName(name="a")
        public final Object2DoubleMap<DoubleAugmentation> a() {
            return this.a;
        }

        @JvmName(name="b")
        public final int b() {
            return this.b;
        }

        public final double a(DoubleAugmentation doubleAugmentation) {
            Intrinsics.checkNotNullParameter((Object)doubleAugmentation, (String)"");
            Object2DoubleMap<DoubleAugmentation> object2DoubleMap = this.a;
            Intrinsics.checkNotNull(object2DoubleMap);
            return object2DoubleMap.getOrDefault((Object)doubleAugmentation, 0.0);
        }

        @Override
        public final a a(Object object, Object object2) {
            Object2DoubleMap object2DoubleMap;
            Intrinsics.checkNotNull((Object)object);
            a cfr_ignored_0 = (a)object;
            Intrinsics.checkNotNull((Object)object2);
            a cfr_ignored_1 = (a)object2;
            if (((a)object).a.size() > 0 || ((a)object2).a.size() > 0) {
                double d2;
                double d3;
                DoubleAugmentation doubleAugmentation;
                object2DoubleMap = (Object2DoubleMap)new Object2DoubleOpenHashMap();
                for (Object2DoubleMap.Entry entry : ((a)object).a.object2DoubleEntrySet()) {
                    doubleAugmentation = (DoubleAugmentation)entry.getKey();
                    d3 = entry.getDoubleValue();
                    a a2 = (a)object2;
                    Intrinsics.checkNotNullExpressionValue((Object)doubleAugmentation, (String)"");
                    d2 = a2.a(doubleAugmentation);
                    DoubleAugmentation doubleAugmentation2 = doubleAugmentation;
                    object2DoubleMap.put((Object)doubleAugmentation2, doubleAugmentation2.combineDouble(d3, d2));
                }
                for (Object2DoubleMap.Entry entry : ((a)object2).a.object2DoubleEntrySet()) {
                    doubleAugmentation = (DoubleAugmentation)entry.getKey();
                    d3 = entry.getDoubleValue();
                    a a3 = (a)object;
                    Intrinsics.checkNotNullExpressionValue((Object)doubleAugmentation, (String)"");
                    d2 = a3.a(doubleAugmentation);
                    DoubleAugmentation doubleAugmentation3 = doubleAugmentation;
                    object2DoubleMap.put((Object)doubleAugmentation3, doubleAugmentation3.combineDouble(d3, d2));
                }
            } else {
                Object2DoubleMap object2DoubleMap2 = Object2DoubleMaps.emptyMap();
                Intrinsics.checkNotNullExpressionValue((Object)object2DoubleMap2, (String)"");
                object2DoubleMap = object2DoubleMap2;
            }
            return new a((Object2DoubleMap<DoubleAugmentation>)object2DoubleMap, ((a)object).b + ((a)object2).b);
        }

        private Object2DoubleMap<DoubleAugmentation> c() {
            return this.a;
        }

        private int d() {
            return this.b;
        }

        private static a a(Object2DoubleMap<DoubleAugmentation> object2DoubleMap, int n2) {
            Intrinsics.checkNotNullParameter(object2DoubleMap, (String)"");
            return new a(object2DoubleMap, n2);
        }

        public static /* synthetic */ a a$default(a object2DoubleMap, Object2DoubleMap object2DoubleMap2, int n2, int n3) {
            if ((n3 & 1) != 0) {
                object2DoubleMap2 = object2DoubleMap.a;
            }
            if ((n3 & 2) != 0) {
                n2 = object2DoubleMap.b;
            }
            int n4 = n2;
            object2DoubleMap = object2DoubleMap2;
            Intrinsics.checkNotNullParameter(object2DoubleMap, (String)"");
            return new a(object2DoubleMap, n4);
        }

        public final String toString() {
            return "AugData(doubleAugmentations=" + this.a + ", unloaded=" + this.b + ")";
        }

        public final int hashCode() {
            int n2 = this.a.hashCode();
            n2 = n2 * 31 + Integer.hashCode(this.b);
            return n2;
        }

        public final boolean equals(Object other) {
            a a2;
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a2 = a2;
            if (!Intrinsics.areEqual(this.a, a2.a)) {
                return false;
            }
            return this.b == a2.b;
        }

        public a() {
            this(null, 0, 3, null);
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0019\u001a\u00020\n\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0003\u001a\u00020\r8\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0003\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00128\u0007\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\"\u0010\u0016\u001a\u00020\n8\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0003\u0010\u0018"}, d2={"Lorg/valkyrienskies/core/impl/shadow/DU$b;", "Lorg/valkyrienskies/core/api/world/connectivity/Component;", "", "a", "()V", "Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;", "p0", "", "collectAugmentation", "(Lorg/valkyrienskies/core/api/world/connectivity/DoubleAugmentation;)D", "", "getSize", "()J", "", "Z", "d", "()Z", "(Z)V", "Lorg/valkyrienskies/core/impl/shadow/DD;", "b", "Lorg/valkyrienskies/core/impl/shadow/DD;", "()Lorg/valkyrienskies/core/impl/shadow/DD;", "c", "J", "(J)V", "p1", "<init>", "(Lorg/valkyrienskies/core/impl/shadow/DD;J)V"})
    public static final class b
    implements Component {
        private final DD b;
        private long c;
        boolean a;

        public b(DD dD, long l2) {
            Intrinsics.checkNotNullParameter((Object)dD, (String)"");
            this.b = dD;
            this.c = l2;
        }

        public /* synthetic */ b(DD dD, long l2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n2 & 2) != 0) {
                l2 = 0L;
            }
            this(dD, l2);
        }

        @JvmName(name="b")
        private DD b() {
            return this.b;
        }

        @JvmName(name="c")
        private long c() {
            return this.c;
        }

        @JvmName(name="a")
        private void a(long l2) {
            this.c = l2;
        }

        @JvmName(name="d")
        private boolean d() {
            return this.a;
        }

        @JvmName(name="a")
        private void a(boolean bl) {
            this.a = bl;
        }

        public final void a() {
            this.a = true;
        }

        @Override
        public final long getSize() {
            if (this.a) {
                throw new IllegalStateException("Component is closed, how did you get this");
            }
            dy_0 dy_02 = this.b.f;
            Intrinsics.checkNotNull((Object)dy_02);
            double d2 = ((a)dy_02).a(new ed_0("core:extent"));
            return (long)(this.b.c - this.b.c / 2) - this.c + (long)d2;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final double collectAugmentation(DoubleAugmentation key) {
            void var1_1;
            Intrinsics.checkNotNullParameter((Object)key, (String)"");
            if (this.a) {
                throw new IllegalStateException("Component is closed, how did you get this");
            }
            Object object = this.b.g;
            Intrinsics.checkNotNull((Object)object);
            return ((a)object).a((DoubleAugmentation)var1_1);
        }
    }

    public static final class c
    implements DF {
        private final DU a;

        public c(DU dU) {
            Intrinsics.checkNotNullParameter((Object)dU, (String)"");
            this.a = dU;
        }

        private DU a() {
            return this.a;
        }

        @Override
        public final boolean a(DB dB, DB dB2, DD dD, DD dD2) {
            Intrinsics.checkNotNullParameter((Object)dB, (String)"");
            Intrinsics.checkNotNullParameter((Object)dB2, (String)"");
            Intrinsics.checkNotNullParameter((Object)dD, (String)"");
            Intrinsics.checkNotNullParameter((Object)dD2, (String)"");
            return true;
        }

        @Override
        public final boolean a(DB dB, DB dB2, DD dD) {
            Intrinsics.checkNotNullParameter((Object)dB, (String)"");
            Intrinsics.checkNotNullParameter((Object)dB2, (String)"");
            Intrinsics.checkNotNullParameter((Object)dD, (String)"");
            return true;
        }

        @Override
        public final boolean a(DB dB, DB dB2, DD dD, DD dD2, DD dD3) {
            Intrinsics.checkNotNullParameter((Object)dB, (String)"");
            Intrinsics.checkNotNullParameter((Object)dB2, (String)"");
            Intrinsics.checkNotNullParameter((Object)dD, (String)"");
            Intrinsics.checkNotNullParameter((Object)dD2, (String)"");
            Intrinsics.checkNotNullParameter((Object)dD3, (String)"");
            return this.a.a(dD, dD2, dD3);
        }

        @Override
        public final boolean b(DB dB, DB dB2, DD dD, DD dD2, DD dD3) {
            Intrinsics.checkNotNullParameter((Object)dB, (String)"");
            Intrinsics.checkNotNullParameter((Object)dB2, (String)"");
            Intrinsics.checkNotNullParameter((Object)dD, (String)"");
            Intrinsics.checkNotNullParameter((Object)dD2, (String)"");
            Intrinsics.checkNotNullParameter((Object)dD3, (String)"");
            return this.a.b(dD, dD2, dD3);
        }
    }

    public static final class d {
        final HashMap<DoubleComponentAugmentation, Double> a;

        public d(HashMap<DoubleComponentAugmentation, Double> hashMap) {
            Intrinsics.checkNotNullParameter(hashMap, (String)"");
            this.a = hashMap;
        }

        public final double a(DoubleComponentAugmentation doubleComponentAugmentation) {
            Intrinsics.checkNotNullParameter((Object)doubleComponentAugmentation, (String)"");
            Double d2 = this.a.get(doubleComponentAugmentation);
            if (d2 == null) {
                return 0.0;
            }
            return d2;
        }

        public final void a(DoubleComponentAugmentation doubleComponentAugmentation, double d2) {
            Intrinsics.checkNotNullParameter((Object)doubleComponentAugmentation, (String)"");
            Double d3 = d2;
            ((Map)this.a).put(doubleComponentAugmentation, d3);
        }

        public final void b(DoubleComponentAugmentation doubleComponentAugmentation) {
            Intrinsics.checkNotNullParameter((Object)doubleComponentAugmentation, (String)"");
            this.a.remove(doubleComponentAugmentation);
        }

        public final d a(d d2) {
            Intrinsics.checkNotNullParameter((Object)d2, (String)"");
            HashMap<DoubleComponentAugmentation, Double> hashMap = new HashMap<DoubleComponentAugmentation, Double>();
            for (DoubleComponentAugmentation doubleComponentAugmentation : d2.a.keySet()) {
                Map map2 = hashMap;
                Intrinsics.checkNotNullExpressionValue((Object)doubleComponentAugmentation, (String)"");
                DoubleComponentAugmentation doubleComponentAugmentation2 = doubleComponentAugmentation;
                map2.put(doubleComponentAugmentation2, doubleComponentAugmentation2.combineDouble(this.a(doubleComponentAugmentation), d2.a(doubleComponentAugmentation)));
            }
            return new d(hashMap);
        }

        public final Pair<d, d> a(Component component, Component component2) {
            Intrinsics.checkNotNullParameter((Object)component, (String)"");
            Intrinsics.checkNotNullParameter((Object)component2, (String)"");
            HashMap<DoubleComponentAugmentation, Double> hashMap = new HashMap<DoubleComponentAugmentation, Double>();
            HashMap<DoubleComponentAugmentation, Double> hashMap2 = new HashMap<DoubleComponentAugmentation, Double>();
            for (DoubleComponentAugmentation doubleComponentAugmentation : this.a.keySet()) {
                Double d2 = this.a.get(doubleComponentAugmentation);
                Intrinsics.checkNotNull((Object)d2);
                double d3 = ((Number)d2).doubleValue();
                Object object = doubleComponentAugmentation.splitDouble(d3, component, component2);
                double d4 = ((DoublePair)object).component1();
                double d5 = ((DoublePair)object).component2();
                object = d4;
                Map map2 = hashMap;
                Intrinsics.checkNotNullExpressionValue((Object)doubleComponentAugmentation, (String)"");
                map2.put(doubleComponentAugmentation, object);
                object = d5;
                ((Map)hashMap2).put(doubleComponentAugmentation, object);
            }
            return new Pair((Object)new d(hashMap), (Object)new d(hashMap2));
        }

        private final HashMap<DoubleComponentAugmentation, Double> a() {
            return this.a;
        }

        private static d a(HashMap<DoubleComponentAugmentation, Double> hashMap) {
            Intrinsics.checkNotNullParameter(hashMap, (String)"");
            return new d(hashMap);
        }

        private static /* synthetic */ d a(d object, HashMap hashMap, int n2) {
            if ((n2 & 1) != 0) {
                hashMap = ((d)object).a;
            }
            object = hashMap;
            Intrinsics.checkNotNullParameter(object, (String)"");
            return new d((HashMap<DoubleComponentAugmentation, Double>)object);
        }

        public final String toString() {
            return "ComponentData(data=" + this.a + ")";
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final boolean equals(Object other) {
            d d2;
            if (this == other) {
                return true;
            }
            if (!(other instanceof d)) {
                return false;
            }
            d2 = d2;
            return Intrinsics.areEqual(this.a, d2.a);
        }
    }
}

