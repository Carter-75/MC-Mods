/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.internal;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aK\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0000*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00032\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b\b\u0010\t\u001a?\u0010\n\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00032\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b\n\u0010\u000b\u001aE\u0010\u000e\u001a\u0004\u0018\u00010\f\"\u0004\b\u0000\u0010\u0000*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00032\u0006\u0010\u0004\u001a\u00028\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f**\b\u0000\u0010\u0010\u001a\u0004\b\u0000\u0010\u0000\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0001\u00a8\u0006\u0011"}, d2={"E", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "element", "Lkotlin/coroutines/CoroutineContext;", "context", "", "bindCancellationFun", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)Lkotlin/jvm/functions/Function1;", "callUndeliveredElement", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", "Lkotlinx/coroutines/internal/UndeliveredElementException;", "undeliveredElementException", "callUndeliveredElementCatchingException", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlinx/coroutines/internal/UndeliveredElementException;)Lkotlinx/coroutines/internal/UndeliveredElementException;", "OnUndeliveredElement", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nOnUndeliveredElement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnUndeliveredElement.kt\nkotlinx/coroutines/internal/OnUndeliveredElementKt\n+ 2 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n*L\n1#1,44:1\n75#2:45\n*S KotlinDebug\n*F\n+ 1 OnUndeliveredElement.kt\nkotlinx/coroutines/internal/OnUndeliveredElementKt\n*L\n22#1:45\n*E\n"})
public final class OnUndeliveredElementKt {
    @Nullable
    public static final <E> UndeliveredElementException callUndeliveredElementCatchingException(@NotNull Function1<? super E, Unit> $this$callUndeliveredElementCatchingException, E element, @Nullable UndeliveredElementException undeliveredElementException) {
        try {
            $this$callUndeliveredElementCatchingException.invoke(element);
        }
        catch (Throwable ex) {
            if (undeliveredElementException != null && undeliveredElementException.getCause() != ex) {
                Throwable $this$addSuppressedThrowable$iv = undeliveredElementException;
                boolean $i$f$addSuppressedThrowable = false;
                ExceptionsKt.addSuppressed((Throwable)$this$addSuppressedThrowable$iv, (Throwable)ex);
            }
            return new UndeliveredElementException("Exception in undelivered element handler for " + element, ex);
        }
        return undeliveredElementException;
    }

    public static /* synthetic */ UndeliveredElementException callUndeliveredElementCatchingException$default(Function1 function1, Object object, UndeliveredElementException undeliveredElementException, int n2, Object object2) {
        if ((n2 & 2) != 0) {
            undeliveredElementException = null;
        }
        return OnUndeliveredElementKt.callUndeliveredElementCatchingException(function1, object, undeliveredElementException);
    }

    public static final <E> void callUndeliveredElement(@NotNull Function1<? super E, Unit> $this$callUndeliveredElement, E element, @NotNull CoroutineContext context) {
        block0: {
            UndeliveredElementException undeliveredElementException = OnUndeliveredElementKt.callUndeliveredElementCatchingException($this$callUndeliveredElement, element, null);
            if (undeliveredElementException == null) break block0;
            UndeliveredElementException ex = undeliveredElementException;
            boolean bl = false;
            CoroutineExceptionHandlerKt.handleCoroutineException(context, ex);
        }
    }

    @NotNull
    public static final <E> Function1<Throwable, Unit> bindCancellationFun(@NotNull Function1<? super E, Unit> $this$bindCancellationFun, E element, @NotNull CoroutineContext context) {
        return (Function1)new Function1<Throwable, Unit>($this$bindCancellationFun, element, context){
            final /* synthetic */ Function1<E, Unit> $this_bindCancellationFun;
            final /* synthetic */ E $element;
            final /* synthetic */ CoroutineContext $context;
            {
                this.$this_bindCancellationFun = $receiver;
                this.$element = $element;
                this.$context = $context;
                super(1);
            }

            public final void invoke(@NotNull Throwable throwable) {
                OnUndeliveredElementKt.callUndeliveredElement(this.$this_bindCancellationFun, this.$element, this.$context);
            }
        };
    }
}

