/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.KotlinNothingValueException
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.internal;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.internal.MainDispatchersKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\b*\u0010+J#\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ+\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001d\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016\u00a2\u0006\u0004\b \u0010!R\u0016\u0010#\u001a\u0004\u0018\u00010\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u0004\u0018\u00010\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u00018VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010(\u00a8\u0006,"}, d2={"Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)Ljava/lang/Void;", "", "timeMillis", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnTimeout", "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/DisposableHandle;", "", "isDispatchNeeded", "(Lkotlin/coroutines/CoroutineContext;)Z", "", "parallelism", "Lkotlinx/coroutines/CoroutineDispatcher;", "limitedParallelism", "(I)Lkotlinx/coroutines/CoroutineDispatcher;", "missing", "()Ljava/lang/Void;", "Lkotlinx/coroutines/CancellableContinuation;", "", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Void;", "", "toString", "()Ljava/lang/String;", "", "cause", "Ljava/lang/Throwable;", "errorHint", "Ljava/lang/String;", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "immediate", "<init>", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nMainDispatchers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainDispatchers.kt\nkotlinx/coroutines/internal/MissingMainCoroutineDispatcher\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
final class MissingMainCoroutineDispatcher
extends MainCoroutineDispatcher
implements Delay {
    @Nullable
    private final Throwable cause;
    @Nullable
    private final String errorHint;

    public MissingMainCoroutineDispatcher(@Nullable Throwable cause, @Nullable String errorHint) {
        this.cause = cause;
        this.errorHint = errorHint;
    }

    public /* synthetic */ MissingMainCoroutineDispatcher(Throwable throwable, String string, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            string = null;
        }
        this(throwable, string);
    }

    @Override
    @NotNull
    public MainCoroutineDispatcher getImmediate() {
        return this;
    }

    @Override
    public boolean isDispatchNeeded(@NotNull CoroutineContext context) {
        this.missing();
        throw new KotlinNothingValueException();
    }

    @Override
    @NotNull
    public CoroutineDispatcher limitedParallelism(int parallelism) {
        this.missing();
        throw new KotlinNothingValueException();
    }

    @Override
    @NotNull
    public DisposableHandle invokeOnTimeout(long timeMillis, @NotNull Runnable block, @NotNull CoroutineContext context) {
        this.missing();
        throw new KotlinNothingValueException();
    }

    @NotNull
    public Void dispatch(@NotNull CoroutineContext context, @NotNull Runnable block) {
        this.missing();
        throw new KotlinNothingValueException();
    }

    @NotNull
    public Void scheduleResumeAfterDelay(long timeMillis, @NotNull CancellableContinuation<? super Unit> continuation) {
        this.missing();
        throw new KotlinNothingValueException();
    }

    /*
     * WARNING - void declaration
     */
    private final Void missing() {
        String string;
        StringBuilder stringBuilder;
        block5: {
            block4: {
                void it;
                if (this.cause == null) {
                    MainDispatchersKt.throwMissingMainDispatcherException();
                    throw new KotlinNothingValueException();
                }
                stringBuilder = new StringBuilder().append("Module with the Main dispatcher had failed to initialize");
                string = this.errorHint;
                if (string == null) break block4;
                String string2 = string;
                StringBuilder stringBuilder2 = stringBuilder;
                boolean bl = false;
                String string3 = ". " + (String)it;
                stringBuilder = stringBuilder2;
                string = string3;
                if (string3 != null) break block5;
            }
            string = "";
        }
        String message = stringBuilder.append(string).toString();
        throw new IllegalStateException(message, this.cause);
    }

    @Override
    @NotNull
    public String toString() {
        return "Dispatchers.Main[missing" + (this.cause != null ? ", cause=" + this.cause : "") + ']';
    }

    @Override
    @Deprecated(message="Deprecated without replacement as an internal method never intended for public use", level=DeprecationLevel.ERROR)
    @Nullable
    public Object delay(long time, @NotNull Continuation<? super Unit> $completion) {
        return Delay.DefaultImpls.delay(this, time, $completion);
    }
}

