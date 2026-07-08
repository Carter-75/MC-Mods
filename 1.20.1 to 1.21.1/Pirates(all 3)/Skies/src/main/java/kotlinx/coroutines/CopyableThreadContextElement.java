/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Element
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.jvm.functions.Function2
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelicateCoroutinesApi;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0015\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H&\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2={"Lkotlinx/coroutines/CopyableThreadContextElement;", "S", "Lkotlinx/coroutines/ThreadContextElement;", "copyForChild", "()Lkotlinx/coroutines/CopyableThreadContextElement;", "Lkotlin/coroutines/CoroutineContext$Element;", "overwritingElement", "Lkotlin/coroutines/CoroutineContext;", "mergeForChild", "(Lkotlin/coroutines/CoroutineContext$Element;)Lkotlin/coroutines/CoroutineContext;", "kotlinx-coroutines-core"})
@DelicateCoroutinesApi
@ExperimentalCoroutinesApi
public interface CopyableThreadContextElement<S>
extends ThreadContextElement<S> {
    @NotNull
    public CopyableThreadContextElement<S> copyForChild();

    @NotNull
    public CoroutineContext mergeForChild(@NotNull CoroutineContext.Element var1);

    @Metadata(mv={1, 8, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        public static <S, R> R fold(@NotNull CopyableThreadContextElement<S> $this, R initial, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
            return ThreadContextElement.DefaultImpls.fold($this, initial, operation);
        }

        @Nullable
        public static <S, E extends CoroutineContext.Element> E get(@NotNull CopyableThreadContextElement<S> $this, @NotNull CoroutineContext.Key<E> key) {
            return ThreadContextElement.DefaultImpls.get($this, key);
        }

        @NotNull
        public static <S> CoroutineContext minusKey(@NotNull CopyableThreadContextElement<S> $this, @NotNull CoroutineContext.Key<?> key) {
            return ThreadContextElement.DefaultImpls.minusKey($this, key);
        }

        @NotNull
        public static <S> CoroutineContext plus(@NotNull CopyableThreadContextElement<S> $this, @NotNull CoroutineContext context) {
            return ThreadContextElement.DefaultImpls.plus($this, context);
        }
    }
}

