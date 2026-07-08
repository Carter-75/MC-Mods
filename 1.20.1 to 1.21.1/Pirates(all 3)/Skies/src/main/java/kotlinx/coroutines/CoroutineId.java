/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.PublishedApi
 *  kotlin.coroutines.AbstractCoroutineContextElement
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Key
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
 */
package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.ThreadContextElement;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0081\b\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001 B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u00c6\u0001\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u00d6\u0003\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fH\u00d6\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u0006\u00a8\u0006!"}, d2={"Lkotlinx/coroutines/CoroutineId;", "Lkotlinx/coroutines/ThreadContextElement;", "", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "", "component1", "()J", "id", "copy", "(J)Lkotlinx/coroutines/CoroutineId;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lkotlin/coroutines/CoroutineContext;", "context", "oldState", "", "restoreThreadContext", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "updateThreadContext", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "J", "getId", "<init>", "(J)V", "Key", "kotlinx-coroutines-core"})
@IgnoreJRERequirement
@PublishedApi
public final class CoroutineId
extends AbstractCoroutineContextElement
implements ThreadContextElement<String> {
    @NotNull
    public static final Key Key = new Key(null);
    private final long id;

    public CoroutineId(long id) {
        super((CoroutineContext.Key)Key);
        this.id = id;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public String toString() {
        return "CoroutineId(" + this.id + ')';
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public String updateThreadContext(@NotNull CoroutineContext context) {
        void $this$updateThreadContext_u24lambda_u240;
        StringBuilder stringBuilder;
        Object object = (CoroutineName)context.get((CoroutineContext.Key)CoroutineName.Key);
        if (object == null || (object = object.getName()) == null) {
            object = "coroutine";
        }
        CoroutineName coroutineName = object;
        Thread currentThread = Thread.currentThread();
        String oldName = currentThread.getName();
        int lastIndex = 0;
        lastIndex = StringsKt.lastIndexOf$default((CharSequence)oldName, (String)" @", (int)0, (boolean)false, (int)6, null);
        if (lastIndex < 0) {
            lastIndex = oldName.length();
        }
        int n2 = lastIndex + ((String)((Object)coroutineName)).length() + 10;
        StringBuilder stringBuilder2 = stringBuilder = new StringBuilder(n2);
        Thread thread = currentThread;
        boolean bl = false;
        String string = oldName.substring(0, lastIndex);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"this as java.lang.String\u2026ing(startIndex, endIndex)");
        $this$updateThreadContext_u24lambda_u240.append(string);
        $this$updateThreadContext_u24lambda_u240.append(" @");
        $this$updateThreadContext_u24lambda_u240.append((String)((Object)coroutineName));
        $this$updateThreadContext_u24lambda_u240.append('#');
        $this$updateThreadContext_u24lambda_u240.append(this.id);
        String string2 = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"StringBuilder(capacity).\u2026builderAction).toString()");
        thread.setName(string2);
        return oldName;
    }

    @Override
    public void restoreThreadContext(@NotNull CoroutineContext context, @NotNull String oldState) {
        Thread.currentThread().setName(oldState);
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final CoroutineId copy(long id) {
        return new CoroutineId(id);
    }

    public static /* synthetic */ CoroutineId copy$default(CoroutineId coroutineId, long l2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            l2 = coroutineId.id;
        }
        return coroutineId.copy(l2);
    }

    public int hashCode() {
        return Long.hashCode(this.id);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CoroutineId)) {
            return false;
        }
        CoroutineId coroutineId = (CoroutineId)other;
        return this.id == coroutineId.id;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2={"Lkotlinx/coroutines/CoroutineId$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineId;", "<init>", "()V", "kotlinx-coroutines-core"})
    public static final class Key
    implements CoroutineContext.Key<CoroutineId> {
        private Key() {
        }

        public /* synthetic */ Key(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

