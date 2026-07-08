/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0005\"\u001a\u0010\u0001\u001a\u00020\u00008\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2={"", "ANDROID_DETECTED", "Z", "getANDROID_DETECTED", "()Z", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nFastServiceLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastServiceLoader.kt\nkotlinx/coroutines/internal/FastServiceLoaderKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,161:1\n1#2:162\n*E\n"})
public final class FastServiceLoaderKt {
    private static final boolean ANDROID_DETECTED;

    public static final boolean getANDROID_DETECTED() {
        return ANDROID_DETECTED;
    }

    static {
        Object object;
        try {
            boolean bl = false;
            object = Result.constructor-impl(Class.forName("android.os.Build"));
        }
        catch (Throwable throwable) {
            object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
        ANDROID_DETECTED = Result.isSuccess-impl((Object)object);
    }
}

