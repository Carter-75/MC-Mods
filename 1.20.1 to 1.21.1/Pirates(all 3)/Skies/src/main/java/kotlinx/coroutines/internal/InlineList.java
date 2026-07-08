/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmInline
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package kotlinx.coroutines.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DebugKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@JvmInline
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\b\u0081@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0016\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J$\u0010\r\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\bH\u0086\b\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0011\u001a\u00020\u000eH\u00d6\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0012\u001a\u00028\u0000H\u0086\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0019\u001a\u00020\u0016H\u00d6\u0001\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u0088\u0001\u001a\u0092\u0001\u0004\u0018\u00010\u0002\u00f8\u0001\u0002\u0082\u0002\u000f\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2={"Lkotlinx/coroutines/internal/InlineList;", "E", "", "other", "", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "equals", "Lkotlin/Function1;", "", "action", "forEachReversed-impl", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "forEachReversed", "", "hashCode-impl", "(Ljava/lang/Object;)I", "hashCode", "element", "plus-FjFbRPM", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "plus", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "toString", "holder", "Ljava/lang/Object;", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
@SourceDebugExtension(value={"SMAP\nInlineList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InlineList.kt\nkotlinx/coroutines/internal/InlineList\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,49:1\n1#2:50\n*E\n"})
public final class InlineList<E> {
    @Nullable
    private final Object holder;

    @NotNull
    public static final Object plus-FjFbRPM(Object arg0, E element) {
        Object object;
        Object object2;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            boolean bl = false;
            if (!(!(element instanceof List))) {
                throw new AssertionError();
            }
        }
        if ((object2 = arg0) == null) {
            object = InlineList.constructor-impl(element);
        } else if (object2 instanceof ArrayList) {
            Object object3 = arg0;
            Intrinsics.checkNotNull((Object)object3, (String)"null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ((ArrayList)object3).add(element);
            object = InlineList.constructor-impl(arg0);
        } else {
            ArrayList<Object> list = new ArrayList<Object>(4);
            list.add(arg0);
            list.add(element);
            object = InlineList.constructor-impl(list);
        }
        return object;
    }

    public static final void forEachReversed-impl(Object arg0, @NotNull Function1<? super E, Unit> action) {
        boolean bl = false;
        Object object = arg0;
        if (object == null) {
            return;
        }
        if (!(object instanceof ArrayList)) {
            action.invoke(arg0);
        } else {
            Object object2 = arg0;
            Intrinsics.checkNotNull((Object)object2, (String)"null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ArrayList list = (ArrayList)object2;
            for (int i2 = list.size() - 1; -1 < i2; --i2) {
                action.invoke(list.get(i2));
            }
        }
    }

    public static String toString-impl(Object arg0) {
        return "InlineList(holder=" + arg0 + ')';
    }

    public String toString() {
        return InlineList.toString-impl(this.holder);
    }

    public static int hashCode-impl(Object arg0) {
        Object object = arg0;
        return object == null ? 0 : object.hashCode();
    }

    public int hashCode() {
        return InlineList.hashCode-impl(this.holder);
    }

    public static boolean equals-impl(Object arg0, Object other) {
        if (!(other instanceof InlineList)) {
            return false;
        }
        return Intrinsics.areEqual((Object)arg0, (Object)((InlineList)other).unbox-impl());
    }

    public boolean equals(Object other) {
        return InlineList.equals-impl(this.holder, other);
    }

    private /* synthetic */ InlineList(Object holder) {
        this.holder = holder;
    }

    @NotNull
    public static <E> Object constructor-impl(@Nullable Object holder) {
        return holder;
    }

    public static /* synthetic */ Object constructor-impl$default(Object object, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            object = null;
        }
        return InlineList.constructor-impl(object);
    }

    public static final /* synthetic */ InlineList box-impl(Object v) {
        return new InlineList(v);
    }

    public final /* synthetic */ Object unbox-impl() {
        return this.holder;
    }

    public static final boolean equals-impl0(Object p1, Object p2) {
        return Intrinsics.areEqual((Object)p1, (Object)p2);
    }
}

