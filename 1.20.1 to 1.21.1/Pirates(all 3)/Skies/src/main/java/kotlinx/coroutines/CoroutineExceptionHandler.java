/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Element
 *  kotlin.coroutines.CoroutineContext$Element$DefaultImpls
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.jvm.functions.Function2
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2={"Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Throwable;)V", "Key", "kotlinx-coroutines-core"})
public interface CoroutineExceptionHandler
extends CoroutineContext.Element {
    @NotNull
    public static final Key Key = kotlinx.coroutines.CoroutineExceptionHandler$Key.$$INSTANCE;

    public void handleException(@NotNull CoroutineContext var1, @NotNull Throwable var2);

    @Metadata(mv={1, 8, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        public static <R> R fold(@NotNull CoroutineExceptionHandler $this, R initial, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
            return (R)CoroutineContext.Element.DefaultImpls.fold((CoroutineContext.Element)$this, initial, operation);
        }

        @Nullable
        public static <E extends CoroutineContext.Element> E get(@NotNull CoroutineExceptionHandler $this, @NotNull CoroutineContext.Key<E> key) {
            return (E)CoroutineContext.Element.DefaultImpls.get((CoroutineContext.Element)$this, key);
        }

        @NotNull
        public static CoroutineContext minusKey(@NotNull CoroutineExceptionHandler $this, @NotNull CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.DefaultImpls.minusKey((CoroutineContext.Element)$this, key);
        }

        @NotNull
        public static CoroutineContext plus(@NotNull CoroutineExceptionHandler $this, @NotNull CoroutineContext context) {
            return CoroutineContext.Element.DefaultImpls.plus((CoroutineContext.Element)$this, (CoroutineContext)context);
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2={"Lkotlinx/coroutines/CoroutineExceptionHandler$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "<init>", "()V", "kotlinx-coroutines-core"})
    public static final class Key
    implements CoroutineContext.Key<CoroutineExceptionHandler> {
        static final /* synthetic */ Key $$INSTANCE;

        private Key() {
        }

        static {
            $$INSTANCE = new Key();
        }
    }
}

