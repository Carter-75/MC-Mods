/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.PublishedApi
 *  kotlin.internal.InlineOnly
 *  kotlin.jvm.functions.Function0
 */
package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineId;
import kotlinx.coroutines.internal.SystemPropsKt;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u001a\u001e\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0081\b\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\u000f\u0010\u0006\u001a\u00020\u0003H\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\"\u001a\u0010\b\u001a\u00020\u00018\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u001a\u0010\r\u001a\u00020\f8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u001a\u0010\u0011\u001a\u00020\u00018\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000b\"\u0014\u0010\u0014\u001a\u00020\u00138\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\"\u0014\u0010\u0016\u001a\u00020\u00138\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0015\"\u0014\u0010\u0017\u001a\u00020\u00138\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015\"\u0014\u0010\u0018\u001a\u00020\u00138\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0015\" \u0010\u0019\u001a\u00020\u00018\u0000X\u0081\u0004\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\t\u0012\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u001a\u0010\u000b\"\u0014\u0010\u001c\u001a\u00020\u00138\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0015\u00a8\u0006\u001d"}, d2={"Lkotlin/Function0;", "", "value", "", "assert", "(Lkotlin/jvm/functions/Function0;)V", "resetCoroutineId", "()V", "ASSERTIONS_ENABLED", "Z", "getASSERTIONS_ENABLED", "()Z", "Ljava/util/concurrent/atomic/AtomicLong;", "COROUTINE_ID", "Ljava/util/concurrent/atomic/AtomicLong;", "getCOROUTINE_ID", "()Ljava/util/concurrent/atomic/AtomicLong;", "DEBUG", "getDEBUG", "", "DEBUG_PROPERTY_NAME", "Ljava/lang/String;", "DEBUG_PROPERTY_VALUE_AUTO", "DEBUG_PROPERTY_VALUE_OFF", "DEBUG_PROPERTY_VALUE_ON", "RECOVER_STACK_TRACES", "getRECOVER_STACK_TRACES", "getRECOVER_STACK_TRACES$annotations", "STACKTRACE_RECOVERY_PROPERTY_NAME", "kotlinx-coroutines-core"})
public final class DebugKt {
    @NotNull
    public static final String DEBUG_PROPERTY_NAME = "kotlinx.coroutines.debug";
    @NotNull
    public static final String STACKTRACE_RECOVERY_PROPERTY_NAME = "kotlinx.coroutines.stacktrace.recovery";
    @NotNull
    public static final String DEBUG_PROPERTY_VALUE_AUTO = "auto";
    @NotNull
    public static final String DEBUG_PROPERTY_VALUE_ON = "on";
    @NotNull
    public static final String DEBUG_PROPERTY_VALUE_OFF = "off";
    private static final boolean ASSERTIONS_ENABLED = CoroutineId.class.desiredAssertionStatus();
    private static final boolean DEBUG;
    private static final boolean RECOVER_STACK_TRACES;
    @NotNull
    private static final AtomicLong COROUTINE_ID;

    public static final boolean getASSERTIONS_ENABLED() {
        return ASSERTIONS_ENABLED;
    }

    public static final boolean getDEBUG() {
        return DEBUG;
    }

    public static final boolean getRECOVER_STACK_TRACES() {
        return RECOVER_STACK_TRACES;
    }

    @PublishedApi
    public static /* synthetic */ void getRECOVER_STACK_TRACES$annotations() {
    }

    @NotNull
    public static final AtomicLong getCOROUTINE_ID() {
        return COROUTINE_ID;
    }

    public static final void resetCoroutineId() {
        COROUTINE_ID.set(0L);
    }

    @InlineOnly
    private static final void assert(Function0<Boolean> value) {
        if (DebugKt.getASSERTIONS_ENABLED() && !((Boolean)value.invoke()).booleanValue()) {
            throw new AssertionError();
        }
    }

    /*
     * Unable to fully structure code
     */
    static {
        value = SystemPropsKt.systemProp("kotlinx.coroutines.debug");
        $i$a$-let-DebugKt$DEBUG$1 = false;
        var2_2 = value;
        if (var2_2 == null) ** GOTO lbl-1000
        tmp = -1;
        switch (var2_2.hashCode()) {
            case 0: {
                if (var2_2.equals("")) {
                    tmp = 1;
                }
                break;
            }
            case 3005871: {
                if (var2_2.equals("auto")) {
                    tmp = 2;
                }
                break;
            }
            case 109935: {
                if (var2_2.equals("off")) {
                    tmp = 3;
                }
                break;
            }
            case 3551: {
                if (var2_2.equals("on")) {
                    tmp = 1;
                }
                break;
            }
        }
        switch (tmp) {
            case 2: lbl-1000:
            // 2 sources

            {
                v0 = DebugKt.ASSERTIONS_ENABLED;
                break;
            }
            case 1: {
                v0 = true;
                break;
            }
            case 3: {
                v0 = false;
                break;
            }
            default: {
                throw new IllegalStateException(("System property 'kotlinx.coroutines.debug' has unrecognized value '" + value + '\'').toString());
            }
        }
        DebugKt.DEBUG = v0;
        DebugKt.RECOVER_STACK_TRACES = DebugKt.DEBUG != false && SystemPropsKt.systemProp("kotlinx.coroutines.stacktrace.recovery", true) != false;
        DebugKt.COROUTINE_ID = new AtomicLong(0L);
    }
}

