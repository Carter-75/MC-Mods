/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
 */
package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ClassValueCtorCache;
import kotlinx.coroutines.internal.CtorCache;
import kotlinx.coroutines.internal.ExceptionsConstructorKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001\t\b\u00c3\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ1\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005j\u0002`\u00062\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2={"Lkotlinx/coroutines/internal/ClassValueCtorCache;", "Lkotlinx/coroutines/internal/CtorCache;", "Ljava/lang/Class;", "", "key", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "get", "(Ljava/lang/Class;)Lkotlin/jvm/functions/Function1;", "kotlinx/coroutines/internal/ClassValueCtorCache.cache.1", "cache", "Lkotlinx/coroutines/internal/ClassValueCtorCache$cache$1;", "<init>", "()V", "kotlinx-coroutines-core"})
@IgnoreJRERequirement
final class ClassValueCtorCache
extends CtorCache {
    @NotNull
    public static final ClassValueCtorCache INSTANCE = new ClassValueCtorCache();
    @NotNull
    private static final cache.1 cache = new ClassValue<Function1<? super Throwable, ? extends Throwable>>(){

        @NotNull
        protected Function1<Throwable, Throwable> computeValue(@Nullable Class<?> type) {
            Intrinsics.checkNotNull(type, (String)"null cannot be cast to non-null type java.lang.Class<out kotlin.Throwable>");
            return ExceptionsConstructorKt.access$createConstructor(type);
        }
    };

    private ClassValueCtorCache() {
    }

    @Override
    @NotNull
    public Function1<Throwable, Throwable> get(@NotNull Class<? extends Throwable> key) {
        return (Function1)cache.get(key);
    }
}

