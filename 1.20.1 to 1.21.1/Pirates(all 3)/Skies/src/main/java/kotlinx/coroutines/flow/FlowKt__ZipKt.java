/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.BuilderInference
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.functions.Function5
 *  kotlin.jvm.functions.Function6
 *  kotlin.jvm.functions.Function7
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.flow;

import java.util.Collection;
import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ZipKt;
import kotlinx.coroutines.flow.FlowKt__ZipKt$combine$;
import kotlinx.coroutines.flow.FlowKt__ZipKt$combineUnsafe$;
import kotlinx.coroutines.flow.internal.CombineKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=5, xi=48, d1={"\u0000d\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u001as\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u00012\u001e\u0010\u0004\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002\"\b\u0012\u0004\u0012\u00028\u00000\u00032*\b\u0004\u0010\b\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u001ag\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u00012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u000b2*\b\u0004\u0010\b\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\f\u001a\u00bc\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00050\u0003\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0010\"\u0004\b\u0004\u0010\u0011\"\u0004\b\u0005\u0010\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00030\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00040\u00032:\u0010\b\u001a6\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00050\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0017\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\u0018\u001a\u00a2\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00040\u0003\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0010\"\u0004\b\u0004\u0010\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00030\u000324\u0010\b\u001a0\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00040\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0019\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\u001a\u001a\u008a\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00030\u0003\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00020\u000320\b\u0001\u0010\b\u001a*\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\u001c\u001a\u008c\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032F\u0010\b\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001d\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\"\u001a\u0084\u0001\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u00012\u001e\u0010\u0004\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002\"\b\u0012\u0004\u0012\u00028\u00000\u00032;\b\u0005\u0010\b\u001a5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010#\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001d\u00a2\u0006\u0002\b%H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010'\u001ax\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u00012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u000b2;\b\u0005\u0010\b\u001a5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010#\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001d\u00a2\u0006\u0002\b%H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010(\u001a\u00cf\u0001\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00050\u0003\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0010\"\u0004\b\u0004\u0010\u0011\"\u0004\b\u0005\u0010\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00030\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00040\u00032M\b\u0001\u0010\b\u001aG\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00050#\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070)\u00a2\u0006\u0002\b%\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010*\u001a\u00b5\u0001\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00040\u0003\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u0010\"\u0004\b\u0004\u0010\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00030\u00032G\b\u0001\u0010\b\u001aA\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00040#\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0017\u00a2\u0006\u0002\b%\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010+\u001a\u009b\u0001\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00030\u0003\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u000f\"\u0004\b\u0003\u0010\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032A\b\u0001\u0010\b\u001a;\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030#\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0019\u00a2\u0006\u0002\b%\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010,\u001a\u009f\u0001\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032Y\b\u0001\u0010\b\u001aS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020#\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001b\u00a2\u0006\u0002\b%\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010-\u001a\u0084\u0001\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u00012\u001e\u0010\u0004\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002\"\b\u0012\u0004\u0012\u00028\u00000\u00032;\b\u0005\u0010\b\u001a5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010#\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001d\u00a2\u0006\u0002\b%H\u0082\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b.\u0010'\u001as\u00101\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u00012\u001e\u0010\u0004\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002\"\b\u0012\u0004\u0012\u00028\u00000\u00032*\b\u0004\u0010\b\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0082\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b0\u0010\n\u001a#\u00105\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000202\"\u0004\b\u0000\u0010\u0000H\u0002\u00a2\u0006\u0004\b3\u00104\u001a\u008a\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032F\u0010\b\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001dH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b6\u0010\"\u001a\u009d\u0001\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032Y\b\u0001\u0010\b\u001aS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020#\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001b\u00a2\u0006\u0002\b%H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b7\u0010-\u001aj\u00109\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u00108\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032(\u0010\b\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001d\u00f8\u0001\u0000\u00a2\u0006\u0004\b9\u0010\"\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006:"}, d2={"T", "R", "", "Lkotlinx/coroutines/flow/Flow;", "flows", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "transform", "combine", "([Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "T1", "T2", "T3", "T4", "T5", "flow", "flow2", "flow3", "flow4", "flow5", "Lkotlin/Function6;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function6;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function5;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function5;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function4;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "a", "b", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/ExtensionFunctionType;", "combineTransform", "([Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function7;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function7;)Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function6;)Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function5;)Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "combineTransformUnsafe$FlowKt__ZipKt", "combineTransformUnsafe", "combineUnsafe$FlowKt__ZipKt", "combineUnsafe", "Lkotlin/Function0;", "nullArrayFactory$FlowKt__ZipKt", "()Lkotlin/jvm/functions/Function0;", "nullArrayFactory", "flowCombine", "flowCombineTransform", "other", "zip", "kotlinx-coroutines-core"}, xs="kotlinx/coroutines/flow/FlowKt")
@SourceDebugExtension(value={"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,332:1\n272#1,3:334\n272#1,3:337\n261#1:340\n263#1:342\n272#1,3:343\n261#1:346\n263#1:348\n272#1,3:349\n261#1:352\n263#1:354\n272#1,3:355\n107#2:333\n107#2:341\n107#2:347\n107#2:353\n107#2:358\n107#2:359\n107#2:362\n37#3,2:360\n37#3,2:363\n*S KotlinDebug\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n75#1:334,3\n103#1:337,3\n119#1:340\n119#1:342\n138#1:343,3\n156#1:346\n156#1:348\n177#1:349,3\n197#1:352\n197#1:354\n220#1:355,3\n32#1:333\n119#1:341\n156#1:347\n197#1:353\n237#1:358\n261#1:359\n288#1:362\n287#1:360,2\n306#1:363,2\n*E\n"})
final class FlowKt__ZipKt {
    @JvmName(name="flowCombine")
    @NotNull
    public static final <T1, T2, R> Flow<R> flowCombine(@NotNull Flow<? extends T1> $this$combine, @NotNull Flow<? extends T2> flow, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> transform2) {
        boolean $i$f$unsafeFlow = false;
        return new Flow<R>($this$combine, flow, transform2){
            final /* synthetic */ Flow $this_combine$inlined;
            final /* synthetic */ Flow $flow$inlined;
            final /* synthetic */ Function3 $transform$inlined;
            {
                this.$this_combine$inlined = flow;
                this.$flow$inlined = flow2;
                this.$transform$inlined = function3;
            }

            @Nullable
            public Object collect(@NotNull FlowCollector<? super R> collector2, @NotNull Continuation<? super Unit> $completion) {
                Continuation<? super Unit> continuation = $completion;
                FlowCollector<? super R> $this$combine_u24lambda_u240 = collector2;
                boolean bl = false;
                Flow[] flowArray = new Flow[]{this.$this_combine$inlined, this.$flow$inlined};
                Object object = CombineKt.combineInternal($this$combine_u24lambda_u240, flowArray, (Function0<T[]>)FlowKt__ZipKt.access$nullArrayFactory(), (Function3)new Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object>(this.$transform$inlined, null){
                    int label;
                    private /* synthetic */ Object L$0;
                    /* synthetic */ Object L$1;
                    final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;
                    {
                        this.$transform = $transform;
                        super(3, $completion);
                    }

                    /*
                     * Unable to fully structure code
                     */
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object var1_1) {
                        var5_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0: {
                                ResultKt.throwOnFailure((Object)var1_1);
                                $this$combineInternal = (FlowCollector)this.L$0;
                                it = (Object[])this.L$1;
                                var4_5 = $this$combineInternal;
                                this.L$0 = var4_5;
                                this.label = 1;
                                v0 = this.$transform.invoke(it[0], it[1], (Object)this);
                                if (v0 == var5_2) {
                                    return var5_2;
                                }
                                ** GOTO lbl18
                            }
                            case 1: {
                                var4_5 = (FlowCollector)this.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v0 = $result;
lbl18:
                                // 2 sources

                                this.L$0 = null;
                                this.label = 2;
                                v1 = var4_5.emit(v0, (Continuation<Unit>)((Continuation)this));
                                if (v1 == var5_2) {
                                    return var5_2;
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
                    public final Object invoke(@NotNull FlowCollector<? super R> p1, @NotNull Object[] p2, @Nullable Continuation<? super Unit> p3) {
                        Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object> function3 = new /* invalid duplicate definition of identical inner class */;
                        function3.L$0 = p1;
                        function3.L$1 = p2;
                        return function3.invokeSuspend((Object)Unit.INSTANCE);
                    }
                }, $completion);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @NotNull
    public static final <T1, T2, R> Flow<R> combine(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> transform2) {
        return FlowKt.flowCombine(flow, flow2, transform2);
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="flowCombineTransform")
    @NotNull
    public static final <T1, T2, R> Flow<R> flowCombineTransform(@NotNull Flow<? extends T1> $this$combineTransform, @NotNull Flow<? extends T2> flow, @BuilderInference @NotNull Function4<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super Unit>, ? extends Object> transform2) {
        void flows$iv;
        Flow[] flowArray = new Flow[]{$this$combineTransform, flow};
        boolean $i$f$combineTransformUnsafe = false;
        return FlowKt.flow((Function2)new Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object>((Flow[])flows$iv, null, transform2){
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ Flow[] $flows;
            final /* synthetic */ Function4 $transform$inlined;
            {
                this.$flows = $flows;
                this.$transform$inlined = function4;
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
                        FlowCollector $this$flow = (FlowCollector)this.L$0;
                        this.label = 1;
                        Object object3 = CombineKt.combineInternal($this$flow, this.$flows, (Function0<T[]>)FlowKt__ZipKt.access$nullArrayFactory(), (Function3)new Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object>(null, this.$transform$inlined){
                            int label;
                            private /* synthetic */ Object L$0;
                            /* synthetic */ Object L$1;
                            final /* synthetic */ Function4 $transform$inlined;
                            {
                                this.$transform$inlined = function4;
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
                                        void args;
                                        ResultKt.throwOnFailure((Object)object);
                                        FlowCollector $this$combineInternal = (FlowCollector)this.L$0;
                                        Object[] it = (Object[])this.L$1;
                                        Continuation continuation = (Continuation)this;
                                        Object[] objectArray = it;
                                        FlowCollector $this$combineTransform_u24lambda_u241 = $this$combineInternal;
                                        boolean bl = false;
                                        void v0 = args[0];
                                        void v1 = args[1];
                                        this.label = 1;
                                        InlineMarker.mark((int)6);
                                        Object object3 = this.$transform$inlined.invoke((Object)$this$combineTransform_u24lambda_u241, (Object)v0, (Object)v1, (Object)((Object)this));
                                        InlineMarker.mark((int)7);
                                        Object object4 = object3;
                                        if (object3 != object2) return Unit.INSTANCE;
                                        return object2;
                                    }
                                    case 1: {
                                        void $result;
                                        boolean bl = false;
                                        ResultKt.throwOnFailure((Object)$result);
                                        Object object4 = $result;
                                        return Unit.INSTANCE;
                                    }
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }

                            @Nullable
                            public final Object invoke(@NotNull FlowCollector<? super R> p1, @NotNull Object[] p2, @Nullable Continuation<? super Unit> p3) {
                                Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object> function3 = new /* invalid duplicate definition of identical inner class */;
                                function3.L$0 = p1;
                                function3.L$1 = p2;
                                return function3.invokeSuspend((Object)Unit.INSTANCE);
                            }
                        }, (Continuation<? super Unit>)((Continuation)this));
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
                Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull FlowCollector<? super R> p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        });
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T1, T2, R> Flow<R> combineTransform(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @BuilderInference @NotNull Function4<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super Unit>, ? extends Object> transform2) {
        void flows$iv;
        Flow[] flowArray = new Flow[]{flow, flow2};
        boolean $i$f$combineTransformUnsafe = false;
        return FlowKt.flow((Function2)new Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object>((Flow[])flows$iv, null, transform2){
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ Flow[] $flows;
            final /* synthetic */ Function4 $transform$inlined;
            {
                this.$flows = $flows;
                this.$transform$inlined = function4;
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
                        FlowCollector $this$flow = (FlowCollector)this.L$0;
                        this.label = 1;
                        Object object3 = CombineKt.combineInternal($this$flow, this.$flows, (Function0<T[]>)FlowKt__ZipKt.access$nullArrayFactory(), (Function3)new Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object>(null, this.$transform$inlined){
                            int label;
                            private /* synthetic */ Object L$0;
                            /* synthetic */ Object L$1;
                            final /* synthetic */ Function4 $transform$inlined;
                            {
                                this.$transform$inlined = function4;
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
                                        void args;
                                        ResultKt.throwOnFailure((Object)object);
                                        FlowCollector $this$combineInternal = (FlowCollector)this.L$0;
                                        Object[] it = (Object[])this.L$1;
                                        Continuation continuation = (Continuation)this;
                                        Object[] objectArray = it;
                                        FlowCollector $this$combineTransform_u24lambda_u242 = $this$combineInternal;
                                        boolean bl = false;
                                        void v0 = args[0];
                                        void v1 = args[1];
                                        this.label = 1;
                                        InlineMarker.mark((int)6);
                                        Object object3 = this.$transform$inlined.invoke((Object)$this$combineTransform_u24lambda_u242, (Object)v0, (Object)v1, (Object)((Object)this));
                                        InlineMarker.mark((int)7);
                                        Object object4 = object3;
                                        if (object3 != object2) return Unit.INSTANCE;
                                        return object2;
                                    }
                                    case 1: {
                                        void $result;
                                        boolean bl = false;
                                        ResultKt.throwOnFailure((Object)$result);
                                        Object object4 = $result;
                                        return Unit.INSTANCE;
                                    }
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }

                            @Nullable
                            public final Object invoke(@NotNull FlowCollector<? super R> p1, @NotNull Object[] p2, @Nullable Continuation<? super Unit> p3) {
                                Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object> function3 = new /* invalid duplicate definition of identical inner class */;
                                function3.L$0 = p1;
                                function3.L$1 = p2;
                                return function3.invokeSuspend((Object)Unit.INSTANCE);
                            }
                        }, (Continuation<? super Unit>)((Continuation)this));
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
                Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull FlowCollector<? super R> p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        });
    }

    @NotNull
    public static final <T1, T2, T3, R> Flow<R> combine(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @BuilderInference @NotNull Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> transform2) {
        Flow[] flowArray = new Flow[]{flow, flow2, flow3};
        Flow[] flows$iv = flowArray;
        boolean $i$f$combineUnsafe = false;
        boolean $i$f$unsafeFlow = false;
        return new Flow<R>(flows$iv, transform2){
            final /* synthetic */ Flow[] $flows$inlined;
            final /* synthetic */ Function4 $transform$inlined$1;
            {
                this.$flows$inlined = flowArray;
                this.$transform$inlined$1 = function4;
            }

            @Nullable
            public Object collect(@NotNull FlowCollector collector2, @NotNull Continuation $completion) {
                Continuation continuation = $completion;
                FlowCollector $this$combineUnsafe_u24lambda_u2410 = collector2;
                boolean bl = false;
                Object object = CombineKt.combineInternal($this$combineUnsafe_u24lambda_u2410, this.$flows$inlined, (Function0<T[]>)FlowKt__ZipKt.access$nullArrayFactory(), (Function3)new Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object>(null, this.$transform$inlined$1){
                    int label;
                    private /* synthetic */ Object L$0;
                    /* synthetic */ Object L$1;
                    final /* synthetic */ Function4 $transform$inlined;
                    {
                        this.$transform$inlined = function4;
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
                                $this$combineInternal = (FlowCollector)this.L$0;
                                it = (Object[])this.L$1;
                                var5_5 = $this$combineInternal;
                                var6_6 = (Continuation)this;
                                args = it;
                                $i$a$-combineUnsafe-FlowKt__ZipKt$combine$2 = false;
                                v0 = args[0];
                                v1 = args[1];
                                v2 = args[2];
                                this.L$0 = var5_5;
                                this.label = 1;
                                InlineMarker.mark((int)6);
                                v3 = this.$transform$inlined.invoke(v0, v1, v2, (Object)this);
                                InlineMarker.mark((int)7);
                                v4 = v3;
                                if (v3 == var2_2) {
                                    return var2_2;
                                }
                                ** GOTO lbl29
                            }
                            case 1: {
                                $i$a$-combineUnsafe-FlowKt__ZipKt$combine$2 = false;
                                var5_5 = (FlowCollector)this.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v4 = $result;
lbl29:
                                // 2 sources

                                var7_7 = v4;
                                this.L$0 = null;
                                this.label = 2;
                                v5 = var5_5.emit(var7_7, (Continuation<Unit>)((Continuation)this));
                                if (v5 == var2_2) {
                                    return var2_2;
                                }
                                ** GOTO lbl39
                            }
                            case 2: {
                                ResultKt.throwOnFailure((Object)$result);
                                v5 = $result;
lbl39:
                                // 2 sources

                                return Unit.INSTANCE;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }

                    @Nullable
                    public final Object invoke(@NotNull FlowCollector<? super R> p1, @NotNull Object[] p2, @Nullable Continuation<? super Unit> p3) {
                        Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object> function3 = new /* invalid duplicate definition of identical inner class */;
                        function3.L$0 = p1;
                        function3.L$1 = p2;
                        return function3.invokeSuspend((Object)Unit.INSTANCE);
                    }
                }, (Continuation<? super Unit>)$completion);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @NotNull
    public static final <T1, T2, T3, R> Flow<R> combineTransform(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @BuilderInference @NotNull Function5<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super Continuation<? super Unit>, ? extends Object> transform2) {
        Flow[] flowArray = new Flow[]{flow, flow2, flow3};
        Flow[] flows$iv = flowArray;
        boolean $i$f$combineTransformUnsafe = false;
        return FlowKt.flow((Function2)new Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object>(flows$iv, null, transform2){
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ Flow[] $flows;
            final /* synthetic */ Function5 $transform$inlined;
            {
                this.$flows = $flows;
                this.$transform$inlined = function5;
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
                        FlowCollector $this$flow = (FlowCollector)this.L$0;
                        this.label = 1;
                        Object object3 = CombineKt.combineInternal($this$flow, this.$flows, (Function0<T[]>)FlowKt__ZipKt.access$nullArrayFactory(), (Function3)new Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object>(null, this.$transform$inlined){
                            int label;
                            private /* synthetic */ Object L$0;
                            /* synthetic */ Object L$1;
                            final /* synthetic */ Function5 $transform$inlined;
                            {
                                this.$transform$inlined = function5;
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
                                        void args;
                                        ResultKt.throwOnFailure((Object)object);
                                        FlowCollector $this$combineInternal = (FlowCollector)this.L$0;
                                        Object[] it = (Object[])this.L$1;
                                        Continuation continuation = (Continuation)this;
                                        Object[] objectArray = it;
                                        FlowCollector $this$combineTransform_u24lambda_u244 = $this$combineInternal;
                                        boolean bl = false;
                                        void v0 = args[0];
                                        void v1 = args[1];
                                        void v2 = args[2];
                                        this.label = 1;
                                        InlineMarker.mark((int)6);
                                        Object object3 = this.$transform$inlined.invoke((Object)$this$combineTransform_u24lambda_u244, (Object)v0, (Object)v1, (Object)v2, (Object)((Object)this));
                                        InlineMarker.mark((int)7);
                                        Object object4 = object3;
                                        if (object3 != object2) return Unit.INSTANCE;
                                        return object2;
                                    }
                                    case 1: {
                                        void $result;
                                        boolean bl = false;
                                        ResultKt.throwOnFailure((Object)$result);
                                        Object object4 = $result;
                                        return Unit.INSTANCE;
                                    }
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }

                            @Nullable
                            public final Object invoke(@NotNull FlowCollector<? super R> p1, @NotNull Object[] p2, @Nullable Continuation<? super Unit> p3) {
                                Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object> function3 = new /* invalid duplicate definition of identical inner class */;
                                function3.L$0 = p1;
                                function3.L$1 = p2;
                                return function3.invokeSuspend((Object)Unit.INSTANCE);
                            }
                        }, (Continuation<? super Unit>)((Continuation)this));
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
                Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull FlowCollector<? super R> p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        });
    }

    @NotNull
    public static final <T1, T2, T3, T4, R> Flow<R> combine(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> transform2) {
        Flow[] flowArray = new Flow[]{flow, flow2, flow3, flow4};
        Flow[] flows$iv = flowArray;
        boolean $i$f$combineUnsafe = false;
        boolean $i$f$unsafeFlow = false;
        return new Flow<R>(flows$iv, transform2){
            final /* synthetic */ Flow[] $flows$inlined;
            final /* synthetic */ Function5 $transform$inlined$1;
            {
                this.$flows$inlined = flowArray;
                this.$transform$inlined$1 = function5;
            }

            @Nullable
            public Object collect(@NotNull FlowCollector collector2, @NotNull Continuation $completion) {
                Continuation continuation = $completion;
                FlowCollector $this$combineUnsafe_u24lambda_u2410 = collector2;
                boolean bl = false;
                Object object = CombineKt.combineInternal($this$combineUnsafe_u24lambda_u2410, this.$flows$inlined, (Function0<T[]>)FlowKt__ZipKt.access$nullArrayFactory(), (Function3)new Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object>(null, this.$transform$inlined$1){
                    int label;
                    private /* synthetic */ Object L$0;
                    /* synthetic */ Object L$1;
                    final /* synthetic */ Function5 $transform$inlined;
                    {
                        this.$transform$inlined = function5;
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
                                $this$combineInternal = (FlowCollector)this.L$0;
                                it = (Object[])this.L$1;
                                var5_5 = $this$combineInternal;
                                var6_6 = (Continuation)this;
                                args = it;
                                $i$a$-combineUnsafe-FlowKt__ZipKt$combine$3 = false;
                                v0 = args[0];
                                v1 = args[1];
                                v2 = args[2];
                                v3 = args[3];
                                this.L$0 = var5_5;
                                this.label = 1;
                                InlineMarker.mark((int)6);
                                v4 = this.$transform$inlined.invoke(v0, v1, v2, v3, (Object)this);
                                InlineMarker.mark((int)7);
                                v5 = v4;
                                if (v4 == var2_2) {
                                    return var2_2;
                                }
                                ** GOTO lbl30
                            }
                            case 1: {
                                $i$a$-combineUnsafe-FlowKt__ZipKt$combine$3 = false;
                                var5_5 = (FlowCollector)this.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v5 = $result;
lbl30:
                                // 2 sources

                                var7_7 = v5;
                                this.L$0 = null;
                                this.label = 2;
                                v6 = var5_5.emit(var7_7, (Continuation<Unit>)((Continuation)this));
                                if (v6 == var2_2) {
                                    return var2_2;
                                }
                                ** GOTO lbl40
                            }
                            case 2: {
                                ResultKt.throwOnFailure((Object)$result);
                                v6 = $result;
lbl40:
                                // 2 sources

                                return Unit.INSTANCE;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }

                    @Nullable
                    public final Object invoke(@NotNull FlowCollector<? super R> p1, @NotNull Object[] p2, @Nullable Continuation<? super Unit> p3) {
                        Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object> function3 = new /* invalid duplicate definition of identical inner class */;
                        function3.L$0 = p1;
                        function3.L$1 = p2;
                        return function3.invokeSuspend((Object)Unit.INSTANCE);
                    }
                }, (Continuation<? super Unit>)$completion);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @NotNull
    public static final <T1, T2, T3, T4, R> Flow<R> combineTransform(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @BuilderInference @NotNull Function6<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super Unit>, ? extends Object> transform2) {
        Flow[] flowArray = new Flow[]{flow, flow2, flow3, flow4};
        Flow[] flows$iv = flowArray;
        boolean $i$f$combineTransformUnsafe = false;
        return FlowKt.flow((Function2)new Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object>(flows$iv, null, transform2){
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ Flow[] $flows;
            final /* synthetic */ Function6 $transform$inlined;
            {
                this.$flows = $flows;
                this.$transform$inlined = function6;
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
                        FlowCollector $this$flow = (FlowCollector)this.L$0;
                        this.label = 1;
                        Object object3 = CombineKt.combineInternal($this$flow, this.$flows, (Function0<T[]>)FlowKt__ZipKt.access$nullArrayFactory(), (Function3)new Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object>(null, this.$transform$inlined){
                            int label;
                            private /* synthetic */ Object L$0;
                            /* synthetic */ Object L$1;
                            final /* synthetic */ Function6 $transform$inlined;
                            {
                                this.$transform$inlined = function6;
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
                                        void args;
                                        ResultKt.throwOnFailure((Object)object);
                                        FlowCollector $this$combineInternal = (FlowCollector)this.L$0;
                                        Object[] it = (Object[])this.L$1;
                                        Continuation continuation = (Continuation)this;
                                        Object[] objectArray = it;
                                        FlowCollector $this$combineTransform_u24lambda_u246 = $this$combineInternal;
                                        boolean bl = false;
                                        void v0 = args[0];
                                        void v1 = args[1];
                                        void v2 = args[2];
                                        void v3 = args[3];
                                        this.label = 1;
                                        InlineMarker.mark((int)6);
                                        Object object3 = this.$transform$inlined.invoke((Object)$this$combineTransform_u24lambda_u246, (Object)v0, (Object)v1, (Object)v2, (Object)v3, (Object)((Object)this));
                                        InlineMarker.mark((int)7);
                                        Object object4 = object3;
                                        if (object3 != object2) return Unit.INSTANCE;
                                        return object2;
                                    }
                                    case 1: {
                                        void $result;
                                        boolean bl = false;
                                        ResultKt.throwOnFailure((Object)$result);
                                        Object object4 = $result;
                                        return Unit.INSTANCE;
                                    }
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }

                            @Nullable
                            public final Object invoke(@NotNull FlowCollector<? super R> p1, @NotNull Object[] p2, @Nullable Continuation<? super Unit> p3) {
                                Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object> function3 = new /* invalid duplicate definition of identical inner class */;
                                function3.L$0 = p1;
                                function3.L$1 = p2;
                                return function3.invokeSuspend((Object)Unit.INSTANCE);
                            }
                        }, (Continuation<? super Unit>)((Continuation)this));
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
                Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull FlowCollector<? super R> p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        });
    }

    @NotNull
    public static final <T1, T2, T3, T4, T5, R> Flow<R> combine(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @NotNull Flow<? extends T5> flow5, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> transform2) {
        Flow[] flowArray = new Flow[]{flow, flow2, flow3, flow4, flow5};
        Flow[] flows$iv = flowArray;
        boolean $i$f$combineUnsafe = false;
        boolean $i$f$unsafeFlow = false;
        return new Flow<R>(flows$iv, transform2){
            final /* synthetic */ Flow[] $flows$inlined;
            final /* synthetic */ Function6 $transform$inlined$1;
            {
                this.$flows$inlined = flowArray;
                this.$transform$inlined$1 = function6;
            }

            @Nullable
            public Object collect(@NotNull FlowCollector collector2, @NotNull Continuation $completion) {
                Continuation continuation = $completion;
                FlowCollector $this$combineUnsafe_u24lambda_u2410 = collector2;
                boolean bl = false;
                Object object = CombineKt.combineInternal($this$combineUnsafe_u24lambda_u2410, this.$flows$inlined, (Function0<T[]>)FlowKt__ZipKt.access$nullArrayFactory(), (Function3)new Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object>(null, this.$transform$inlined$1){
                    int label;
                    private /* synthetic */ Object L$0;
                    /* synthetic */ Object L$1;
                    final /* synthetic */ Function6 $transform$inlined;
                    {
                        this.$transform$inlined = function6;
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
                                $this$combineInternal = (FlowCollector)this.L$0;
                                it = (Object[])this.L$1;
                                var5_5 = $this$combineInternal;
                                var6_6 = (Continuation)this;
                                args = it;
                                $i$a$-combineUnsafe-FlowKt__ZipKt$combine$4 = false;
                                v0 = args[0];
                                v1 = args[1];
                                v2 = args[2];
                                v3 = args[3];
                                v4 = args[4];
                                this.L$0 = var5_5;
                                this.label = 1;
                                InlineMarker.mark((int)6);
                                v5 = this.$transform$inlined.invoke(v0, v1, v2, v3, v4, (Object)this);
                                InlineMarker.mark((int)7);
                                v6 = v5;
                                if (v5 == var2_2) {
                                    return var2_2;
                                }
                                ** GOTO lbl31
                            }
                            case 1: {
                                $i$a$-combineUnsafe-FlowKt__ZipKt$combine$4 = false;
                                var5_5 = (FlowCollector)this.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v6 = $result;
lbl31:
                                // 2 sources

                                var7_7 = v6;
                                this.L$0 = null;
                                this.label = 2;
                                v7 = var5_5.emit(var7_7, (Continuation<Unit>)((Continuation)this));
                                if (v7 == var2_2) {
                                    return var2_2;
                                }
                                ** GOTO lbl41
                            }
                            case 2: {
                                ResultKt.throwOnFailure((Object)$result);
                                v7 = $result;
lbl41:
                                // 2 sources

                                return Unit.INSTANCE;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }

                    @Nullable
                    public final Object invoke(@NotNull FlowCollector<? super R> p1, @NotNull Object[] p2, @Nullable Continuation<? super Unit> p3) {
                        Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object> function3 = new /* invalid duplicate definition of identical inner class */;
                        function3.L$0 = p1;
                        function3.L$1 = p2;
                        return function3.invokeSuspend((Object)Unit.INSTANCE);
                    }
                }, (Continuation<? super Unit>)$completion);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @NotNull
    public static final <T1, T2, T3, T4, T5, R> Flow<R> combineTransform(@NotNull Flow<? extends T1> flow, @NotNull Flow<? extends T2> flow2, @NotNull Flow<? extends T3> flow3, @NotNull Flow<? extends T4> flow4, @NotNull Flow<? extends T5> flow5, @BuilderInference @NotNull Function7<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super Unit>, ? extends Object> transform2) {
        Flow[] flowArray = new Flow[]{flow, flow2, flow3, flow4, flow5};
        Flow[] flows$iv = flowArray;
        boolean $i$f$combineTransformUnsafe = false;
        return FlowKt.flow((Function2)new Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object>(flows$iv, null, transform2){
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ Flow[] $flows;
            final /* synthetic */ Function7 $transform$inlined;
            {
                this.$flows = $flows;
                this.$transform$inlined = function7;
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
                        FlowCollector $this$flow = (FlowCollector)this.L$0;
                        this.label = 1;
                        Object object3 = CombineKt.combineInternal($this$flow, this.$flows, (Function0<T[]>)FlowKt__ZipKt.access$nullArrayFactory(), (Function3)new Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object>(null, this.$transform$inlined){
                            int label;
                            private /* synthetic */ Object L$0;
                            /* synthetic */ Object L$1;
                            final /* synthetic */ Function7 $transform$inlined;
                            {
                                this.$transform$inlined = function7;
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
                                        void args;
                                        ResultKt.throwOnFailure((Object)object);
                                        FlowCollector $this$combineInternal = (FlowCollector)this.L$0;
                                        Object[] it = (Object[])this.L$1;
                                        Continuation continuation = (Continuation)this;
                                        Object[] objectArray = it;
                                        FlowCollector $this$combineTransform_u24lambda_u248 = $this$combineInternal;
                                        boolean bl = false;
                                        void v0 = args[0];
                                        void v1 = args[1];
                                        void v2 = args[2];
                                        void v3 = args[3];
                                        void v4 = args[4];
                                        this.label = 1;
                                        InlineMarker.mark((int)6);
                                        Object object3 = this.$transform$inlined.invoke((Object)$this$combineTransform_u24lambda_u248, (Object)v0, (Object)v1, (Object)v2, (Object)v3, (Object)v4, (Object)((Object)this));
                                        InlineMarker.mark((int)7);
                                        Object object4 = object3;
                                        if (object3 != object2) return Unit.INSTANCE;
                                        return object2;
                                    }
                                    case 1: {
                                        void $result;
                                        boolean bl = false;
                                        ResultKt.throwOnFailure((Object)$result);
                                        Object object4 = $result;
                                        return Unit.INSTANCE;
                                    }
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }

                            @Nullable
                            public final Object invoke(@NotNull FlowCollector<? super R> p1, @NotNull Object[] p2, @Nullable Continuation<? super Unit> p3) {
                                Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object> function3 = new /* invalid duplicate definition of identical inner class */;
                                function3.L$0 = p1;
                                function3.L$1 = p2;
                                return function3.invokeSuspend((Object)Unit.INSTANCE);
                            }
                        }, (Continuation<? super Unit>)((Continuation)this));
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
                Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull FlowCollector<? super R> p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        });
    }

    public static final /* synthetic */ <T, R> Flow<R> combine(Flow<? extends T>[] flows, Function2<? super T[], ? super Continuation<? super R>, ? extends Object> transform2) {
        boolean $i$f$combine = false;
        boolean $i$f$unsafeFlow = false;
        Intrinsics.needClassReification();
        return new Flow<R>(flows, transform2){
            final /* synthetic */ Flow[] $flows$inlined;
            final /* synthetic */ Function2 $transform$inlined;
            {
                this.$flows$inlined = flowArray;
                this.$transform$inlined = function2;
            }

            @Nullable
            public Object collect(@NotNull FlowCollector<? super R> collector2, @NotNull Continuation<? super Unit> $completion) {
                Continuation<? super Unit> continuation = $completion;
                FlowCollector<? super R> $this$combine_u24lambda_u249 = collector2;
                boolean bl = false;
                Intrinsics.needClassReification();
                Function0 function0 = (Function0)new Function0<T[]>(this.$flows$inlined){
                    final /* synthetic */ Flow<T>[] $flows;
                    {
                        this.$flows = $flows;
                        super(0);
                    }

                    @Nullable
                    public final T[] invoke() {
                        int n2 = this.$flows.length;
                        Intrinsics.reifiedOperationMarker((int)0, (String)"T?");
                        return new Object[n2];
                    }
                };
                Intrinsics.needClassReification();
                Object object = CombineKt.combineInternal($this$combine_u24lambda_u249, this.$flows$inlined, (Function0<T[]>)function0, (Function3)new Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object>(this.$transform$inlined, null){
                    int label;
                    private /* synthetic */ Object L$0;
                    /* synthetic */ Object L$1;
                    final /* synthetic */ Function2<T[], Continuation<? super R>, Object> $transform;
                    {
                        this.$transform = $transform;
                        super(3, $completion);
                    }

                    /*
                     * Unable to fully structure code
                     */
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object var1_1) {
                        var5_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0: {
                                ResultKt.throwOnFailure((Object)var1_1);
                                $this$combineInternal = (FlowCollector)this.L$0;
                                it = (Object[])this.L$1;
                                var4_5 = $this$combineInternal;
                                this.L$0 = var4_5;
                                this.label = 1;
                                v0 = this.$transform.invoke((Object)it, (Object)this);
                                if (v0 == var5_2) {
                                    return var5_2;
                                }
                                ** GOTO lbl18
                            }
                            case 1: {
                                var4_5 = (FlowCollector)this.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v0 = $result;
lbl18:
                                // 2 sources

                                this.L$0 = null;
                                this.label = 2;
                                v1 = var4_5.emit(v0, (Continuation<Unit>)((Continuation)this));
                                if (v1 == var5_2) {
                                    return var5_2;
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
                    public final Object invokeSuspend$$forInline(@NotNull Object $result) {
                        FlowCollector $this$combineInternal = (FlowCollector)this.L$0;
                        Object[] it = (Object[])this.L$1;
                        FlowCollector flowCollector = $this$combineInternal;
                        Object object = this.$transform.invoke((Object)it, (Object)((Object)this));
                        Continuation continuation = (Continuation)this;
                        InlineMarker.mark((int)0);
                        flowCollector.emit(object, (Continuation<Unit>)continuation);
                        InlineMarker.mark((int)1);
                        return Unit.INSTANCE;
                    }

                    @Nullable
                    public final Object invoke(@NotNull FlowCollector<? super R> p1, @NotNull T[] p2, @Nullable Continuation<? super Unit> p3) {
                        Intrinsics.needClassReification();
                        Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> function3 = new /* invalid duplicate definition of identical inner class */;
                        function3.L$0 = p1;
                        function3.L$1 = p2;
                        return function3.invokeSuspend((Object)Unit.INSTANCE);
                    }
                }, $completion);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }

            @Nullable
            public Object collect$$forInline(@NotNull FlowCollector collector2, @NotNull Continuation $completion) {
                InlineMarker.mark((int)4);
                new ContinuationImpl(this, $completion){
                    /* synthetic */ Object result;
                    int label;
                    final /* synthetic */ combine$$inlined$unsafeFlow$2 this$0;
                    {
                        this.this$0 = this$0;
                        super($completion);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        this.result = $result;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.collect(null, (Continuation<? super Unit>)((Continuation)this));
                    }
                };
                InlineMarker.mark((int)5);
                Continuation continuation = $completion;
                FlowCollector $this$combine_u24lambda_u249 = collector2;
                boolean bl = false;
                Intrinsics.needClassReification();
                Function0 function0 = (Function0)new /* invalid duplicate definition of identical inner class */;
                Intrinsics.needClassReification();
                Function3 function3 = (Function3)new /* invalid duplicate definition of identical inner class */;
                InlineMarker.mark((int)0);
                CombineKt.combineInternal($this$combine_u24lambda_u249, this.$flows$inlined, (Function0<T[]>)function0, function3, (Continuation<? super Unit>)$completion);
                InlineMarker.mark((int)1);
                return Unit.INSTANCE;
            }
        };
    }

    public static final /* synthetic */ <T, R> Flow<R> combineTransform(Flow<? extends T>[] flows, @BuilderInference Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> transform2) {
        boolean $i$f$combineTransform = false;
        Intrinsics.needClassReification();
        return FlowKt.flow((Function2)new Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object>(flows, transform2, null){
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ Flow<T>[] $flows;
            final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> $transform;
            {
                this.$flows = $flows;
                this.$transform = $transform;
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
                        FlowCollector $this$flow = (FlowCollector)this.L$0;
                        Intrinsics.needClassReification();
                        Function0 function0 = (Function0)new Function0<T[]>(this.$flows){
                            final /* synthetic */ Flow<T>[] $flows;
                            {
                                this.$flows = $flows;
                                super(0);
                            }

                            @Nullable
                            public final T[] invoke() {
                                int n2 = this.$flows.length;
                                Intrinsics.reifiedOperationMarker((int)0, (String)"T?");
                                return new Object[n2];
                            }
                        };
                        Intrinsics.needClassReification();
                        this.label = 1;
                        Object object3 = CombineKt.combineInternal($this$flow, this.$flows, (Function0<T[]>)function0, (Function3)new Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object>(this.$transform, null){
                            int label;
                            private /* synthetic */ Object L$0;
                            /* synthetic */ Object L$1;
                            final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> $transform;
                            {
                                this.$transform = $transform;
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
                                        FlowCollector $this$combineInternal = (FlowCollector)this.L$0;
                                        Object[] it = (Object[])this.L$1;
                                        this.L$0 = null;
                                        this.label = 1;
                                        Object object3 = this.$transform.invoke((Object)$this$combineInternal, (Object)it, (Object)((Object)this));
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
                            public final Object invokeSuspend$$forInline(@NotNull Object $result) {
                                FlowCollector $this$combineInternal = (FlowCollector)this.L$0;
                                Object[] it = (Object[])this.L$1;
                                this.$transform.invoke((Object)$this$combineInternal, (Object)it, (Object)((Object)this));
                                return Unit.INSTANCE;
                            }

                            @Nullable
                            public final Object invoke(@NotNull FlowCollector<? super R> p1, @NotNull T[] p2, @Nullable Continuation<? super Unit> p3) {
                                Intrinsics.needClassReification();
                                Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> function3 = new /* invalid duplicate definition of identical inner class */;
                                function3.L$0 = p1;
                                function3.L$1 = p2;
                                return function3.invokeSuspend((Object)Unit.INSTANCE);
                            }
                        }, (Continuation<? super Unit>)((Continuation)this));
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
            public final Object invokeSuspend$$forInline(@NotNull Object $result) {
                FlowCollector $this$flow = (FlowCollector)this.L$0;
                Intrinsics.needClassReification();
                Function0 function0 = (Function0)new /* invalid duplicate definition of identical inner class */;
                Intrinsics.needClassReification();
                Function3 function3 = (Function3)new /* invalid duplicate definition of identical inner class */;
                Continuation continuation = (Continuation)this;
                InlineMarker.mark((int)0);
                CombineKt.combineInternal($this$flow, this.$flows, (Function0<T[]>)function0, function3, (Continuation<? super Unit>)continuation);
                InlineMarker.mark((int)1);
                return Unit.INSTANCE;
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull FlowCollector<? super R> p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        });
    }

    private static final /* synthetic */ <T, R> Flow<R> combineUnsafe$FlowKt__ZipKt(Flow<? extends T>[] flows, Function2<? super T[], ? super Continuation<? super R>, ? extends Object> transform2) {
        boolean $i$f$combineUnsafe = false;
        boolean $i$f$unsafeFlow = false;
        Intrinsics.needClassReification();
        return new Flow<R>(flows, transform2){
            final /* synthetic */ Flow[] $flows$inlined;
            final /* synthetic */ Function2 $transform$inlined;
            {
                this.$flows$inlined = flowArray;
                this.$transform$inlined = function2;
            }

            @Nullable
            public Object collect(@NotNull FlowCollector<? super R> collector2, @NotNull Continuation<? super Unit> $completion) {
                Continuation<? super Unit> continuation = $completion;
                FlowCollector<? super R> $this$combineUnsafe_u24lambda_u2410 = collector2;
                boolean bl = false;
                Function0 function0 = FlowKt__ZipKt.access$nullArrayFactory();
                Intrinsics.needClassReification();
                Object object = CombineKt.combineInternal($this$combineUnsafe_u24lambda_u2410, this.$flows$inlined, (Function0<T[]>)function0, (Function3)new Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object>(this.$transform$inlined, null){
                    int label;
                    private /* synthetic */ Object L$0;
                    /* synthetic */ Object L$1;
                    final /* synthetic */ Function2<T[], Continuation<? super R>, Object> $transform;
                    {
                        this.$transform = $transform;
                        super(3, $completion);
                    }

                    /*
                     * Unable to fully structure code
                     */
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object var1_1) {
                        var5_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0: {
                                ResultKt.throwOnFailure((Object)var1_1);
                                $this$combineInternal = (FlowCollector)this.L$0;
                                it = (Object[])this.L$1;
                                var4_5 = $this$combineInternal;
                                this.L$0 = var4_5;
                                this.label = 1;
                                v0 = this.$transform.invoke((Object)it, (Object)this);
                                if (v0 == var5_2) {
                                    return var5_2;
                                }
                                ** GOTO lbl18
                            }
                            case 1: {
                                var4_5 = (FlowCollector)this.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v0 = $result;
lbl18:
                                // 2 sources

                                this.L$0 = null;
                                this.label = 2;
                                v1 = var4_5.emit(v0, (Continuation<Unit>)((Continuation)this));
                                if (v1 == var5_2) {
                                    return var5_2;
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
                    public final Object invokeSuspend$$forInline(@NotNull Object $result) {
                        FlowCollector $this$combineInternal = (FlowCollector)this.L$0;
                        Object[] it = (Object[])this.L$1;
                        FlowCollector flowCollector = $this$combineInternal;
                        Object object = this.$transform.invoke((Object)it, (Object)((Object)this));
                        Continuation continuation = (Continuation)this;
                        InlineMarker.mark((int)0);
                        flowCollector.emit(object, (Continuation<Unit>)continuation);
                        InlineMarker.mark((int)1);
                        return Unit.INSTANCE;
                    }

                    @Nullable
                    public final Object invoke(@NotNull FlowCollector<? super R> p1, @NotNull T[] p2, @Nullable Continuation<? super Unit> p3) {
                        Intrinsics.needClassReification();
                        Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> function3 = new /* invalid duplicate definition of identical inner class */;
                        function3.L$0 = p1;
                        function3.L$1 = p2;
                        return function3.invokeSuspend((Object)Unit.INSTANCE);
                    }
                }, $completion);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }

            @Nullable
            public Object collect$$forInline(@NotNull FlowCollector collector2, @NotNull Continuation $completion) {
                InlineMarker.mark((int)4);
                new ContinuationImpl(this, $completion){
                    /* synthetic */ Object result;
                    int label;
                    final /* synthetic */ combineUnsafe$$inlined$unsafeFlow$1 this$0;
                    {
                        this.this$0 = this$0;
                        super($completion);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        this.result = $result;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.collect(null, (Continuation<? super Unit>)((Continuation)this));
                    }
                };
                InlineMarker.mark((int)5);
                Continuation continuation = $completion;
                FlowCollector $this$combineUnsafe_u24lambda_u2410 = collector2;
                boolean bl = false;
                Function0 function0 = FlowKt__ZipKt.access$nullArrayFactory();
                Intrinsics.needClassReification();
                Function3 function3 = (Function3)new /* invalid duplicate definition of identical inner class */;
                InlineMarker.mark((int)0);
                CombineKt.combineInternal($this$combineUnsafe_u24lambda_u2410, this.$flows$inlined, (Function0<T[]>)function0, function3, (Continuation<? super Unit>)$completion);
                InlineMarker.mark((int)1);
                return Unit.INSTANCE;
            }
        };
    }

    private static final /* synthetic */ <T, R> Flow<R> combineTransformUnsafe$FlowKt__ZipKt(Flow<? extends T>[] flows, @BuilderInference Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> transform2) {
        boolean $i$f$combineTransformUnsafe = false;
        Intrinsics.needClassReification();
        return FlowKt.flow((Function2)new Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object>(flows, transform2, null){
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ Flow<T>[] $flows;
            final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> $transform;
            {
                this.$flows = $flows;
                this.$transform = $transform;
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
                        FlowCollector $this$flow = (FlowCollector)this.L$0;
                        Function0 function0 = FlowKt__ZipKt.access$nullArrayFactory();
                        Intrinsics.needClassReification();
                        this.label = 1;
                        Object object3 = CombineKt.combineInternal($this$flow, this.$flows, (Function0<T[]>)function0, (Function3)new Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object>(this.$transform, null){
                            int label;
                            private /* synthetic */ Object L$0;
                            /* synthetic */ Object L$1;
                            final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> $transform;
                            {
                                this.$transform = $transform;
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
                                        FlowCollector $this$combineInternal = (FlowCollector)this.L$0;
                                        Object[] it = (Object[])this.L$1;
                                        this.L$0 = null;
                                        this.label = 1;
                                        Object object3 = this.$transform.invoke((Object)$this$combineInternal, (Object)it, (Object)((Object)this));
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
                            public final Object invokeSuspend$$forInline(@NotNull Object $result) {
                                FlowCollector $this$combineInternal = (FlowCollector)this.L$0;
                                Object[] it = (Object[])this.L$1;
                                this.$transform.invoke((Object)$this$combineInternal, (Object)it, (Object)((Object)this));
                                return Unit.INSTANCE;
                            }

                            @Nullable
                            public final Object invoke(@NotNull FlowCollector<? super R> p1, @NotNull T[] p2, @Nullable Continuation<? super Unit> p3) {
                                Intrinsics.needClassReification();
                                Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> function3 = new /* invalid duplicate definition of identical inner class */;
                                function3.L$0 = p1;
                                function3.L$1 = p2;
                                return function3.invokeSuspend((Object)Unit.INSTANCE);
                            }
                        }, (Continuation<? super Unit>)((Continuation)this));
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
            public final Object invokeSuspend$$forInline(@NotNull Object $result) {
                FlowCollector $this$flow = (FlowCollector)this.L$0;
                Function0 function0 = FlowKt__ZipKt.access$nullArrayFactory();
                Intrinsics.needClassReification();
                Function3 function3 = (Function3)new /* invalid duplicate definition of identical inner class */;
                Continuation continuation = (Continuation)this;
                InlineMarker.mark((int)0);
                CombineKt.combineInternal($this$flow, this.$flows, (Function0<T[]>)function0, function3, (Continuation<? super Unit>)continuation);
                InlineMarker.mark((int)1);
                return Unit.INSTANCE;
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull FlowCollector<? super R> p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        });
    }

    private static final <T> Function0<T[]> nullArrayFactory$FlowKt__ZipKt() {
        return nullArrayFactory.1.INSTANCE;
    }

    public static final /* synthetic */ <T, R> Flow<R> combine(Iterable<? extends Flow<? extends T>> flows, Function2<? super T[], ? super Continuation<? super R>, ? extends Object> transform2) {
        boolean $i$f$combine = false;
        Collection $this$toTypedArray$iv = CollectionsKt.toList(flows);
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        Flow[] flowArray = thisCollection$iv.toArray(new Flow[0]);
        boolean $i$f$unsafeFlow = false;
        Intrinsics.needClassReification();
        return new Flow<R>(flowArray, transform2){
            final /* synthetic */ Flow[] $flowArray$inlined;
            final /* synthetic */ Function2 $transform$inlined;
            {
                this.$flowArray$inlined = flowArray;
                this.$transform$inlined = function2;
            }

            @Nullable
            public Object collect(@NotNull FlowCollector<? super R> collector2, @NotNull Continuation<? super Unit> $completion) {
                Continuation<? super Unit> continuation = $completion;
                FlowCollector<? super R> $this$combine_u24lambda_u2411 = collector2;
                boolean bl = false;
                Intrinsics.needClassReification();
                Function0 function0 = (Function0)new Function0<T[]>(this.$flowArray$inlined){
                    final /* synthetic */ Flow<T>[] $flowArray;
                    {
                        this.$flowArray = $flowArray;
                        super(0);
                    }

                    @Nullable
                    public final T[] invoke() {
                        int n2 = this.$flowArray.length;
                        Intrinsics.reifiedOperationMarker((int)0, (String)"T?");
                        return new Object[n2];
                    }
                };
                Intrinsics.needClassReification();
                Object object = CombineKt.combineInternal($this$combine_u24lambda_u2411, this.$flowArray$inlined, (Function0<T[]>)function0, (Function3)new Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object>(this.$transform$inlined, null){
                    int label;
                    private /* synthetic */ Object L$0;
                    /* synthetic */ Object L$1;
                    final /* synthetic */ Function2<T[], Continuation<? super R>, Object> $transform;
                    {
                        this.$transform = $transform;
                        super(3, $completion);
                    }

                    /*
                     * Unable to fully structure code
                     */
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object var1_1) {
                        var5_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0: {
                                ResultKt.throwOnFailure((Object)var1_1);
                                $this$combineInternal = (FlowCollector)this.L$0;
                                it = (Object[])this.L$1;
                                var4_5 = $this$combineInternal;
                                this.L$0 = var4_5;
                                this.label = 1;
                                v0 = this.$transform.invoke((Object)it, (Object)this);
                                if (v0 == var5_2) {
                                    return var5_2;
                                }
                                ** GOTO lbl18
                            }
                            case 1: {
                                var4_5 = (FlowCollector)this.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v0 = $result;
lbl18:
                                // 2 sources

                                this.L$0 = null;
                                this.label = 2;
                                v1 = var4_5.emit(v0, (Continuation<Unit>)((Continuation)this));
                                if (v1 == var5_2) {
                                    return var5_2;
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
                    public final Object invokeSuspend$$forInline(@NotNull Object $result) {
                        FlowCollector $this$combineInternal = (FlowCollector)this.L$0;
                        Object[] it = (Object[])this.L$1;
                        FlowCollector flowCollector = $this$combineInternal;
                        Object object = this.$transform.invoke((Object)it, (Object)((Object)this));
                        Continuation continuation = (Continuation)this;
                        InlineMarker.mark((int)0);
                        flowCollector.emit(object, (Continuation<Unit>)continuation);
                        InlineMarker.mark((int)1);
                        return Unit.INSTANCE;
                    }

                    @Nullable
                    public final Object invoke(@NotNull FlowCollector<? super R> p1, @NotNull T[] p2, @Nullable Continuation<? super Unit> p3) {
                        Intrinsics.needClassReification();
                        Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> function3 = new /* invalid duplicate definition of identical inner class */;
                        function3.L$0 = p1;
                        function3.L$1 = p2;
                        return function3.invokeSuspend((Object)Unit.INSTANCE);
                    }
                }, $completion);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }

            @Nullable
            public Object collect$$forInline(@NotNull FlowCollector collector2, @NotNull Continuation $completion) {
                InlineMarker.mark((int)4);
                new ContinuationImpl(this, $completion){
                    /* synthetic */ Object result;
                    int label;
                    final /* synthetic */ combine$$inlined$unsafeFlow$3 this$0;
                    {
                        this.this$0 = this$0;
                        super($completion);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        this.result = $result;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.collect(null, (Continuation<? super Unit>)((Continuation)this));
                    }
                };
                InlineMarker.mark((int)5);
                Continuation continuation = $completion;
                FlowCollector $this$combine_u24lambda_u2411 = collector2;
                boolean bl = false;
                Intrinsics.needClassReification();
                Function0 function0 = (Function0)new /* invalid duplicate definition of identical inner class */;
                Intrinsics.needClassReification();
                Function3 function3 = (Function3)new /* invalid duplicate definition of identical inner class */;
                InlineMarker.mark((int)0);
                CombineKt.combineInternal($this$combine_u24lambda_u2411, this.$flowArray$inlined, (Function0<T[]>)function0, function3, (Continuation<? super Unit>)$completion);
                InlineMarker.mark((int)1);
                return Unit.INSTANCE;
            }
        };
    }

    public static final /* synthetic */ <T, R> Flow<R> combineTransform(Iterable<? extends Flow<? extends T>> flows, @BuilderInference Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> transform2) {
        boolean $i$f$combineTransform = false;
        Collection $this$toTypedArray$iv = CollectionsKt.toList(flows);
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        Flow[] flowArray = thisCollection$iv.toArray(new Flow[0]);
        Intrinsics.needClassReification();
        return FlowKt.flow((Function2)new Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object>(flowArray, transform2, null){
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ Flow<T>[] $flowArray;
            final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> $transform;
            {
                this.$flowArray = $flowArray;
                this.$transform = $transform;
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
                        FlowCollector $this$flow = (FlowCollector)this.L$0;
                        Intrinsics.needClassReification();
                        Function0 function0 = (Function0)new Function0<T[]>(this.$flowArray){
                            final /* synthetic */ Flow<T>[] $flowArray;
                            {
                                this.$flowArray = $flowArray;
                                super(0);
                            }

                            @Nullable
                            public final T[] invoke() {
                                int n2 = this.$flowArray.length;
                                Intrinsics.reifiedOperationMarker((int)0, (String)"T?");
                                return new Object[n2];
                            }
                        };
                        Intrinsics.needClassReification();
                        this.label = 1;
                        Object object3 = CombineKt.combineInternal($this$flow, this.$flowArray, (Function0<T[]>)function0, (Function3)new Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object>(this.$transform, null){
                            int label;
                            private /* synthetic */ Object L$0;
                            /* synthetic */ Object L$1;
                            final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> $transform;
                            {
                                this.$transform = $transform;
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
                                        FlowCollector $this$combineInternal = (FlowCollector)this.L$0;
                                        Object[] it = (Object[])this.L$1;
                                        this.L$0 = null;
                                        this.label = 1;
                                        Object object3 = this.$transform.invoke((Object)$this$combineInternal, (Object)it, (Object)((Object)this));
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
                            public final Object invokeSuspend$$forInline(@NotNull Object $result) {
                                FlowCollector $this$combineInternal = (FlowCollector)this.L$0;
                                Object[] it = (Object[])this.L$1;
                                this.$transform.invoke((Object)$this$combineInternal, (Object)it, (Object)((Object)this));
                                return Unit.INSTANCE;
                            }

                            @Nullable
                            public final Object invoke(@NotNull FlowCollector<? super R> p1, @NotNull T[] p2, @Nullable Continuation<? super Unit> p3) {
                                Intrinsics.needClassReification();
                                Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> function3 = new /* invalid duplicate definition of identical inner class */;
                                function3.L$0 = p1;
                                function3.L$1 = p2;
                                return function3.invokeSuspend((Object)Unit.INSTANCE);
                            }
                        }, (Continuation<? super Unit>)((Continuation)this));
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
            public final Object invokeSuspend$$forInline(@NotNull Object $result) {
                FlowCollector $this$flow = (FlowCollector)this.L$0;
                Intrinsics.needClassReification();
                Function0 function0 = (Function0)new /* invalid duplicate definition of identical inner class */;
                Intrinsics.needClassReification();
                Function3 function3 = (Function3)new /* invalid duplicate definition of identical inner class */;
                Continuation continuation = (Continuation)this;
                InlineMarker.mark((int)0);
                CombineKt.combineInternal($this$flow, this.$flowArray, (Function0<T[]>)function0, function3, (Continuation<? super Unit>)continuation);
                InlineMarker.mark((int)1);
                return Unit.INSTANCE;
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> $completion) {
                Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object> function2 = new /* invalid duplicate definition of identical inner class */;
                function2.L$0 = value;
                return (Continuation)function2;
            }

            @Nullable
            public final Object invoke(@NotNull FlowCollector<? super R> p1, @Nullable Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        });
    }

    @NotNull
    public static final <T1, T2, R> Flow<R> zip(@NotNull Flow<? extends T1> $this$zip, @NotNull Flow<? extends T2> other, @NotNull Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> transform2) {
        return CombineKt.zipImpl($this$zip, other, transform2);
    }

    public static final /* synthetic */ Function0 access$nullArrayFactory() {
        return FlowKt__ZipKt.nullArrayFactory$FlowKt__ZipKt();
    }
}

