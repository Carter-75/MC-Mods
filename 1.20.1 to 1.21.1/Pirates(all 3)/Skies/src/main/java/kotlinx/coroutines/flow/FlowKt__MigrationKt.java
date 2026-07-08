/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.BuilderInference
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.KotlinNothingValueException
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.functions.Function5
 *  kotlin.jvm.functions.Function6
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.flow;

import kotlin.BuilderInference;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__MigrationKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=5, xi=48, d1={"\u0000x\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000\u00a2\u0006\u0004\b\u0001\u0010\u0002\u001a%\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a\u00ba\u0001\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00050\u0004\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b\"\u0004\b\u0002\u0010\t\"\u0004\b\u0003\u0010\n\"\u0004\b\u0004\u0010\u000b\"\u0004\b\u0005\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00030\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00040\u00042:\u0010\u0014\u001a6\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00050\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001a\u00a0\u0001\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00040\u0004\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b\"\u0004\b\u0002\u0010\t\"\u0004\b\u0003\u0010\n\"\u0004\b\u0004\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00030\u000424\u0010\u0014\u001a0\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00040\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0017H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0018\u001a\u0086\u0001\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00030\u0004\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b\"\u0004\b\u0002\u0010\t\"\u0004\b\u0003\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\u00042.\u0010\u0014\u001a*\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0019H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u001a\u001al\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b\"\u0004\b\u0002\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042(\u0010\u0014\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u001bH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u001c\u001aP\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00042#\u0010\u001f\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u001d\u00a2\u0006\u0002\b\u001eH\u0007\u00a2\u0006\u0004\b \u0010!\u001aE\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u001dH\u0007\u00a2\u0006\u0004\b#\u0010!\u001a-\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010$\u001a\u00028\u0000H\u0007\u00a2\u0006\u0004\b%\u0010&\u001a3\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007\u00a2\u0006\u0004\b%\u0010'\u001a-\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010)\u001a\u00020(H\u0007\u00a2\u0006\u0004\b*\u0010+\u001a-\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010)\u001a\u00020(H\u0007\u00a2\u0006\u0004\b,\u0010+\u001aX\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00042(\u0010\"\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130-H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b.\u0010/\u001a+\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0004H\u0007\u00a2\u0006\u0004\b0\u0010\u0006\u001aU\u00105\u001a\u000203\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u000421\u00104\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b($\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130-H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b5\u00106\u001a+\u00107\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0004H\u0007\u00a2\u0006\u0004\b7\u0010\u0006\u001a-\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u00109\u001a\u000208H\u0007\u00a2\u0006\u0004\b:\u0010;\u001a3\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007\u00a2\u0006\u0004\b=\u0010'\u001a3\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007\u00a2\u0006\u0004\b>\u0010'\u001a-\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010<\u001a\u00028\u0000H\u0007\u00a2\u0006\u0004\b?\u0010&\u001aC\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010<\u001a\u00028\u00002\u0014\b\u0002\u0010B\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020A0\u001dH\u0007\u00a2\u0006\u0004\b?\u0010C\u001a%\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007\u00a2\u0006\u0004\bD\u0010\u0006\u001a-\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010F\u001a\u00020EH\u0007\u00a2\u0006\u0004\bD\u0010G\u001a-\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u00109\u001a\u000208H\u0007\u00a2\u0006\u0004\bH\u0010;\u001a%\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007\u00a2\u0006\u0004\bI\u0010\u0006\u001a-\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010F\u001a\u00020EH\u0007\u00a2\u0006\u0004\bI\u0010G\u001a\u0080\u0001\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010J\u001a\u00028\u00012H\b\u0001\u0010L\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(K\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b($\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u001bH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\bM\u0010N\u001ap\u0010O\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042F\u0010L\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(K\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b($\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u001bH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\bO\u0010P\u001a-\u0010R\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010Q\u001a\u00020EH\u0007\u00a2\u0006\u0004\bR\u0010G\u001a-\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010$\u001a\u00028\u0000H\u0007\u00a2\u0006\u0004\bS\u0010&\u001a3\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007\u00a2\u0006\u0004\bS\u0010'\u001a\u001f\u0010T\u001a\u000203\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007\u00a2\u0006\u0004\bT\u0010U\u001aF\u0010T\u001a\u000203\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\"\u0010V\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130-H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\bT\u00106\u001aj\u0010T\u001a\u000203\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\"\u0010V\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130-2\"\u0010W\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020@\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130-H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\bT\u0010X\u001a-\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u00109\u001a\u000208H\u0007\u00a2\u0006\u0004\bY\u0010;\u001ag\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u000427\u0010\u0014\u001a3\b\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b($\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130-H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\bZ\u0010/\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006["}, d2={"", "noImpl", "()Ljava/lang/Void;", "T", "Lkotlinx/coroutines/flow/Flow;", "cache", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "T1", "T2", "T3", "T4", "T5", "R", "other", "other2", "other3", "other4", "Lkotlin/Function6;", "Lkotlin/coroutines/Continuation;", "", "transform", "combineLatest", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function6;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function5;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function5;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function4;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function3;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "transformer", "compose", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "mapper", "concatMap", "value", "concatWith", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "", "timeMillis", "delayEach", "(Lkotlinx/coroutines/flow/Flow;J)Lkotlinx/coroutines/flow/Flow;", "delayFlow", "Lkotlin/Function2;", "flatMap", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "flatten", "Lkotlin/ParameterName;", "name", "", "action", "forEach", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)V", "merge", "Lkotlin/coroutines/CoroutineContext;", "context", "observeOn", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/flow/Flow;", "fallback", "onErrorResume", "onErrorResumeNext", "onErrorReturn", "", "", "predicate", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "publish", "", "bufferSize", "(Lkotlinx/coroutines/flow/Flow;I)Lkotlinx/coroutines/flow/Flow;", "publishOn", "replay", "initial", "accumulator", "operation", "scanFold", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "scanReduce", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "count", "skip", "startWith", "subscribe", "(Lkotlinx/coroutines/flow/Flow;)V", "onEach", "onError", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "subscribeOn", "switchMap", "kotlinx-coroutines-core"}, xs="kotlinx/coroutines/flow/FlowKt")
@SourceDebugExtension(value={"SMAP\nMigration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Migration.kt\nkotlinx/coroutines/flow/FlowKt__MigrationKt\n+ 2 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt\n*L\n1#1,496:1\n193#2:497\n*S KotlinDebug\n*F\n+ 1 Migration.kt\nkotlinx/coroutines/flow/FlowKt__MigrationKt\n*L\n435#1:497\n*E\n"})
final class FlowKt__MigrationKt {
    @NotNull
    public static final Void noImpl() {
        throw new UnsupportedOperationException("Not implemented, should not be called");
    }

    @Deprecated(message="Collect flow in the desired context instead", level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> observeOn(@NotNull Flow<? extends T> $this$observeOn, @NotNull CoroutineContext context) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(message="Collect flow in the desired context instead", level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> publishOn(@NotNull Flow<? extends T> $this$publishOn, @NotNull CoroutineContext context) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(message="Use 'flowOn' instead", level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> subscribeOn(@NotNull Flow<? extends T> $this$subscribeOn, @NotNull CoroutineContext context) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(message="Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith=@ReplaceWith(expression="catch { emitAll(fallback) }", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> onErrorResume(@NotNull Flow<? extends T> $this$onErrorResume, @NotNull Flow<? extends T> fallback) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(message="Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith=@ReplaceWith(expression="catch { emitAll(fallback) }", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> onErrorResumeNext(@NotNull Flow<? extends T> $this$onErrorResumeNext, @NotNull Flow<? extends T> fallback) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(message="Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead", level=DeprecationLevel.ERROR)
    public static final <T> void subscribe(@NotNull Flow<? extends T> $this$subscribe) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(message="Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead", level=DeprecationLevel.ERROR)
    public static final <T> void subscribe(@NotNull Flow<? extends T> $this$subscribe, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> onEach) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(message="Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead", level=DeprecationLevel.ERROR)
    public static final <T> void subscribe(@NotNull Flow<? extends T> $this$subscribe, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> onEach, @NotNull Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> onError) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(message="Flow analogue is 'flatMapConcat'", replaceWith=@ReplaceWith(expression="flatMapConcat(mapper)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T, R> Flow<R> flatMap(@NotNull Flow<? extends T> $this$flatMap, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> mapper) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(message="Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith=@ReplaceWith(expression="flatMapConcat(mapper)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T, R> Flow<R> concatMap(@NotNull Flow<? extends T> $this$concatMap, @NotNull Function1<? super T, ? extends Flow<? extends R>> mapper) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(message="Flow analogue of 'merge' is 'flattenConcat'", replaceWith=@ReplaceWith(expression="flattenConcat()", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> merge(@NotNull Flow<? extends Flow<? extends T>> $this$merge) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(message="Flow analogue of 'flatten' is 'flattenConcat'", replaceWith=@ReplaceWith(expression="flattenConcat()", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> flatten(@NotNull Flow<? extends Flow<? extends T>> $this$flatten) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(message="Flow analogue of 'compose' is 'let'", replaceWith=@ReplaceWith(expression="let(transformer)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T, R> Flow<R> compose(@NotNull Flow<? extends T> $this$compose, @NotNull Function1<? super Flow<? extends T>, ? extends Flow<? extends R>> transformer) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(message="Flow analogue of 'skip' is 'drop'", replaceWith=@ReplaceWith(expression="drop(count)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> skip(@NotNull Flow<? extends T> $this$skip, int count2) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(message="Flow analogue of 'forEach' is 'collect'", replaceWith=@ReplaceWith(expression="collect(action)", imports={}), level=DeprecationLevel.ERROR)
    public static final <T> void forEach(@NotNull Flow<? extends T> $this$forEach, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> action) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(message="Flow has less verbose 'scan' shortcut", replaceWith=@ReplaceWith(expression="scan(initial, operation)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T, R> Flow<R> scanFold(@NotNull Flow<? extends T> $this$scanFold, R initial, @BuilderInference @NotNull Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> operation) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(message="Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith=@ReplaceWith(expression="catch { emit(fallback) }", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> onErrorReturn(@NotNull Flow<? extends T> $this$onErrorReturn, T fallback) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(message="Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith=@ReplaceWith(expression="catch { e -> if (predicate(e)) emit(fallback) else throw e }", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> onErrorReturn(@NotNull Flow<? extends T> $this$onErrorReturn, T fallback, @NotNull Function1<? super Throwable, Boolean> predicate) {
        return FlowKt.catch($this$onErrorReturn, (Function3)new Function3<FlowCollector<? super T>, Throwable, Continuation<? super Unit>, Object>(predicate, fallback, null){
            int label;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            final /* synthetic */ Function1<Throwable, Boolean> $predicate;
            final /* synthetic */ T $fallback;
            {
                this.$predicate = $predicate;
                this.$fallback = $fallback;
                super(3, $completion);
            }

            /*
             * WARNING - void declaration
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            @Nullable
            public final Object invokeSuspend(@NotNull Object object) {
                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)object);
                        FlowCollector $this$catch = (FlowCollector)this.L$0;
                        Throwable e2 = (Throwable)this.L$1;
                        if (!((Boolean)this.$predicate.invoke((Object)e2)).booleanValue()) {
                            throw e2;
                        }
                        this.L$0 = null;
                        this.label = 1;
                        Object object3 = $this$catch.emit(this.$fallback, (Continuation<Unit>)((Continuation)this));
                        if (object3 != object2) return Unit.INSTANCE;
                        return object2;
                    }
                    case 1: {
                        void $result;
                        ResultKt.throwOnFailure((Object)$result);
                        Object object3 = $result;
                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Nullable
            public final Object invoke(@NotNull FlowCollector<? super T> p1, @NotNull Throwable p2, @Nullable Continuation<? super Unit> p3) {
                Function3<FlowCollector<? super T>, Throwable, Continuation<? super Unit>, Object> function3 = new /* invalid duplicate definition of identical inner class */;
                function3.L$0 = p1;
                function3.L$1 = p2;
                return function3.invokeSuspend((Object)Unit.INSTANCE);
            }
        });
    }

    public static /* synthetic */ Flow onErrorReturn$default(Flow flow, Object object, Function1 function1, int n2, Object object2) {
        if ((n2 & 2) != 0) {
            function1 = onErrorReturn.1.INSTANCE;
        }
        return FlowKt.onErrorReturn(flow, object, (Function1<? super Throwable, Boolean>)function1);
    }

    @Deprecated(message="Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith=@ReplaceWith(expression="onStart { emit(value) }", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> startWith(@NotNull Flow<? extends T> $this$startWith, T value) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(message="Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith=@ReplaceWith(expression="onStart { emitAll(other) }", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> startWith(@NotNull Flow<? extends T> $this$startWith, @NotNull Flow<? extends T> other) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(message="Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith=@ReplaceWith(expression="onCompletion { emit(value) }", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> concatWith(@NotNull Flow<? extends T> $this$concatWith, T value) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(message="Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { if (it == null) emitAll(other) }'", replaceWith=@ReplaceWith(expression="onCompletion { if (it == null) emitAll(other) }", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> concatWith(@NotNull Flow<? extends T> $this$concatWith, @NotNull Flow<? extends T> other) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(message="Flow analogue of 'combineLatest' is 'combine'", replaceWith=@ReplaceWith(expression="this.combine(other, transform)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T1, T2, R> Flow<R> combineLatest(@NotNull Flow<? extends T1> $this$combineLatest, @NotNull Flow<? extends T2> other, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> transform2) {
        return FlowKt.combine($this$combineLatest, other, transform2);
    }

    @Deprecated(message="Flow analogue of 'combineLatest' is 'combine'", replaceWith=@ReplaceWith(expression="combine(this, other, other2, transform)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T1, T2, T3, R> Flow<R> combineLatest(@NotNull Flow<? extends T1> $this$combineLatest, @NotNull Flow<? extends T2> other, @NotNull Flow<? extends T3> other2, @NotNull Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> transform2) {
        return FlowKt.combine($this$combineLatest, other, other2, transform2);
    }

    @Deprecated(message="Flow analogue of 'combineLatest' is 'combine'", replaceWith=@ReplaceWith(expression="combine(this, other, other2, other3, transform)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T1, T2, T3, T4, R> Flow<R> combineLatest(@NotNull Flow<? extends T1> $this$combineLatest, @NotNull Flow<? extends T2> other, @NotNull Flow<? extends T3> other2, @NotNull Flow<? extends T4> other3, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> transform2) {
        return FlowKt.combine($this$combineLatest, other, other2, other3, transform2);
    }

    @Deprecated(message="Flow analogue of 'combineLatest' is 'combine'", replaceWith=@ReplaceWith(expression="combine(this, other, other2, other3, transform)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T1, T2, T3, T4, T5, R> Flow<R> combineLatest(@NotNull Flow<? extends T1> $this$combineLatest, @NotNull Flow<? extends T2> other, @NotNull Flow<? extends T3> other2, @NotNull Flow<? extends T4> other3, @NotNull Flow<? extends T5> other4, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> transform2) {
        return FlowKt.combine($this$combineLatest, other, other2, other3, other4, transform2);
    }

    @Deprecated(message="Use 'onStart { delay(timeMillis) }'", replaceWith=@ReplaceWith(expression="onStart { delay(timeMillis) }", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> delayFlow(@NotNull Flow<? extends T> $this$delayFlow, long timeMillis) {
        return FlowKt.onStart($this$delayFlow, (Function2)new Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object>(timeMillis, null){
            int label;
            final /* synthetic */ long $timeMillis;
            {
                this.$timeMillis = $timeMillis;
                super(2, $completion);
            }

            /*
             * WARNING - void declaration
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            @Nullable
            public final Object invokeSuspend(@NotNull Object object) {
                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)object);
                        this.label = 1;
                        Object object3 = DelayKt.delay(this.$timeMillis, (Continuation<? super Unit>)((Continuation)this));
                        if (object3 != object2) return Unit.INSTANCE;
                        return object2;
                    }
                    case 1: {
                        void $result;
                        ResultKt.throwOnFailure((Object)$result);
                        Object object3 = $result;
                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            @Nullable
            public final Object invoke(@NotNull FlowCollector<? super T> p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        });
    }

    @Deprecated(message="Use 'onEach { delay(timeMillis) }'", replaceWith=@ReplaceWith(expression="onEach { delay(timeMillis) }", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> delayEach(@NotNull Flow<? extends T> $this$delayEach, long timeMillis) {
        return FlowKt.onEach($this$delayEach, (Function2)new Function2<T, Continuation<? super Unit>, Object>(timeMillis, null){
            int label;
            final /* synthetic */ long $timeMillis;
            {
                this.$timeMillis = $timeMillis;
                super(2, $completion);
            }

            /*
             * WARNING - void declaration
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            @Nullable
            public final Object invokeSuspend(@NotNull Object object) {
                Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)object);
                        this.label = 1;
                        Object object3 = DelayKt.delay(this.$timeMillis, (Continuation<? super Unit>)((Continuation)this));
                        if (object3 != object2) return Unit.INSTANCE;
                        return object2;
                    }
                    case 1: {
                        void $result;
                        ResultKt.throwOnFailure((Object)$result);
                        Object object3 = $result;
                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            @Nullable
            public final Object invoke(T p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        });
    }

    @Deprecated(message="Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith=@ReplaceWith(expression="this.flatMapLatest(transform)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T, R> Flow<R> switchMap(@NotNull Flow<? extends T> $this$switchMap, @NotNull Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> transform2) {
        Flow<? extends T> $this$flatMapLatest$iv = $this$switchMap;
        boolean $i$f$flatMapLatest = false;
        return FlowKt.transformLatest($this$flatMapLatest$iv, (Function3)new Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object>(transform2, null){
            int label;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            final /* synthetic */ Function2 $transform;
            {
                this.$transform = $transform;
                super(3, $completion);
            }

            /*
             * Unable to fully structure code
             */
            @Nullable
            public final Object invokeSuspend(@NotNull Object var1_1) {
                var2_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)var1_1);
                        $this$transformLatest = (FlowCollector)this.L$0;
                        it = this.L$1;
                        var5_5 = $this$transformLatest;
                        this.L$0 = var5_5;
                        this.label = 1;
                        v0 = this.$transform.invoke(it, (Object)this);
                        if (v0 == var2_2) {
                            return var2_2;
                        }
                        ** GOTO lbl18
                    }
                    case 1: {
                        var5_5 = (FlowCollector)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl18:
                        // 2 sources

                        this.L$0 = null;
                        this.label = 2;
                        v1 = FlowKt.emitAll(var5_5, (Flow)v0, (Continuation<? super Unit>)((Continuation)this));
                        if (v1 == var2_2) {
                            return var2_2;
                        }
                        ** GOTO lbl27
                    }
                    case 2: {
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = $result;
lbl27:
                        // 2 sources

                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Nullable
            public final Object invoke(@NotNull FlowCollector<? super R> p1, T p2, @Nullable Continuation<? super Unit> p3) {
                Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> function3 = new /* invalid duplicate definition of identical inner class */;
                function3.L$0 = p1;
                function3.L$1 = p2;
                return function3.invokeSuspend((Object)Unit.INSTANCE);
            }
        });
    }

    @Deprecated(message="'scanReduce' was renamed to 'runningReduce' to be consistent with Kotlin standard library", replaceWith=@ReplaceWith(expression="runningReduce(operation)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> scanReduce(@NotNull Flow<? extends T> $this$scanReduce, @NotNull Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> operation) {
        return FlowKt.runningReduce($this$scanReduce, operation);
    }

    @Deprecated(message="Flow analogue of 'publish()' is 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith=@ReplaceWith(expression="this.shareIn(scope, 0)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> publish(@NotNull Flow<? extends T> $this$publish) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(message="Flow analogue of 'publish(bufferSize)' is 'buffer' followed by 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith=@ReplaceWith(expression="this.buffer(bufferSize).shareIn(scope, 0)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> publish(@NotNull Flow<? extends T> $this$publish, int bufferSize) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(message="Flow analogue of 'replay()' is 'shareIn' with unlimited replay. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith=@ReplaceWith(expression="this.shareIn(scope, Int.MAX_VALUE)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> replay(@NotNull Flow<? extends T> $this$replay) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(message="Flow analogue of 'replay(bufferSize)' is 'shareIn' with the specified replay parameter. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith=@ReplaceWith(expression="this.shareIn(scope, bufferSize)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> replay(@NotNull Flow<? extends T> $this$replay, int bufferSize) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(message="Flow analogue of 'cache()' is 'shareIn' with unlimited replay and 'started = SharingStared.Lazily' argument'", replaceWith=@ReplaceWith(expression="this.shareIn(scope, Int.MAX_VALUE, started = SharingStared.Lazily)", imports={}), level=DeprecationLevel.ERROR)
    @NotNull
    public static final <T> Flow<T> cache(@NotNull Flow<? extends T> $this$cache) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }
}

