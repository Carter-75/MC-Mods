/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 */
package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0086\b\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2={"Lkotlinx/coroutines/internal/Symbol;", "", "", "toString", "()Ljava/lang/String;", "T", "value", "unbox", "(Ljava/lang/Object;)Ljava/lang/Object;", "symbol", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "kotlinx-coroutines-core"})
public final class Symbol {
    @JvmField
    @NotNull
    public final String symbol;

    public Symbol(@NotNull String symbol) {
        this.symbol = symbol;
    }

    @NotNull
    public String toString() {
        return '<' + this.symbol + '>';
    }

    public final <T> T unbox(@Nullable Object value) {
        boolean $i$f$unbox = false;
        return (T)(value == this ? null : value);
    }
}

