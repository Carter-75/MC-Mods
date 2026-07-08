/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.io.ByteStreamsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
 */
package kotlinx.coroutines.debug;

import android.annotation.SuppressLint;
import java.io.InputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.debug.internal.AgentInstallationType;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sun.misc.Signal;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c1\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2={"Lkotlinx/coroutines/debug/AgentPremain;", "", "", "installSignalHandler", "()V", "", "args", "Ljava/lang/instrument/Instrumentation;", "instrumentation", "premain", "(Ljava/lang/String;Ljava/lang/instrument/Instrumentation;)V", "", "enableCreationStackTraces", "Z", "<init>", "DebugProbesTransformer", "kotlinx-coroutines-core"})
@SuppressLint(value={"all"})
@IgnoreJRERequirement
public final class AgentPremain {
    @NotNull
    public static final AgentPremain INSTANCE;
    private static final boolean enableCreationStackTraces;

    private AgentPremain() {
    }

    @JvmStatic
    public static final void premain(@Nullable String args, @NotNull Instrumentation instrumentation) {
        AgentInstallationType.INSTANCE.setInstalledStatically$kotlinx_coroutines_core(true);
        instrumentation.addTransformer(DebugProbesTransformer.INSTANCE);
        DebugProbesImpl.INSTANCE.setEnableCreationStackTraces$kotlinx_coroutines_core(enableCreationStackTraces);
        DebugProbesImpl.INSTANCE.install$kotlinx_coroutines_core();
        INSTANCE.installSignalHandler();
    }

    private final void installSignalHandler() {
        try {
            Signal.handle(new Signal("TRAP"), AgentPremain::installSignalHandler$lambda$1);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private static final void installSignalHandler$lambda$1(Signal it) {
        if (DebugProbesImpl.INSTANCE.isInstalled$kotlinx_coroutines_debug()) {
            DebugProbesImpl.INSTANCE.dumpCoroutines(System.out);
        } else {
            System.out.println((Object)"Cannot perform coroutines dump, debug probes are disabled");
        }
    }

    static {
        Object object;
        INSTANCE = new AgentPremain();
        Object object2 = INSTANCE;
        try {
            AgentPremain $this$enableCreationStackTraces_u24lambda_u240 = object2;
            boolean bl = false;
            String string = System.getProperty("kotlinx.coroutines.debug.enable.creation.stack.trace");
            object = Result.constructor-impl((Object)(string != null ? Boolean.valueOf(Boolean.parseBoolean(string)) : null));
        }
        catch (Throwable throwable) {
            object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
        object2 = object;
        Boolean bl = (Boolean)(Result.isFailure-impl((Object)object2) ? null : object2);
        enableCreationStackTraces = bl != null ? bl.booleanValue() : DebugProbesImpl.INSTANCE.getEnableCreationStackTraces$kotlinx_coroutines_core();
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJC\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2={"Lkotlinx/coroutines/debug/AgentPremain$DebugProbesTransformer;", "Ljava/lang/instrument/ClassFileTransformer;", "Ljava/lang/ClassLoader;", "loader", "", "className", "Ljava/lang/Class;", "classBeingRedefined", "Ljava/security/ProtectionDomain;", "protectionDomain", "", "classfileBuffer", "transform", "(Ljava/lang/ClassLoader;Ljava/lang/String;Ljava/lang/Class;Ljava/security/ProtectionDomain;[B)[B", "<init>", "()V", "kotlinx-coroutines-core"})
    public static final class DebugProbesTransformer
    implements ClassFileTransformer {
        @NotNull
        public static final DebugProbesTransformer INSTANCE = new DebugProbesTransformer();

        private DebugProbesTransformer() {
        }

        @Override
        @Nullable
        public byte[] transform(@Nullable ClassLoader loader, @NotNull String className, @Nullable Class<?> classBeingRedefined, @NotNull ProtectionDomain protectionDomain, @Nullable byte[] classfileBuffer) {
            if (loader == null || !Intrinsics.areEqual((Object)className, (Object)"kotlin/coroutines/jvm/internal/DebugProbesKt")) {
                return null;
            }
            AgentInstallationType.INSTANCE.setInstalledStatically$kotlinx_coroutines_core(true);
            return ByteStreamsKt.readBytes((InputStream)loader.getResourceAsStream("DebugProbesKt.bin"));
        }
    }
}

