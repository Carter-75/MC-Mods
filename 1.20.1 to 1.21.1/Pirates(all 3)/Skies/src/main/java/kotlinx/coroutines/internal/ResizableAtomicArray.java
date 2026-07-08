/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ranges.RangesKt
 */
package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0007\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0006\u001a\u00020\u0003H\u0086\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2={"Lkotlinx/coroutines/internal/ResizableAtomicArray;", "T", "", "", "currentLength", "()I", "index", "get", "(I)Ljava/lang/Object;", "value", "", "setSynchronized", "(ILjava/lang/Object;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "array", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "initialLength", "<init>", "(I)V", "kotlinx-coroutines-core"})
public final class ResizableAtomicArray<T> {
    @NotNull
    private volatile AtomicReferenceArray<T> array;

    public ResizableAtomicArray(int initialLength) {
        this.array = new AtomicReferenceArray(initialLength);
    }

    public final int currentLength() {
        return this.array.length();
    }

    @Nullable
    public final T get(int index) {
        AtomicReferenceArray<T> array = this.array;
        return index < array.length() ? (T)array.get(index) : null;
    }

    public final void setSynchronized(int index, @Nullable T value) {
        AtomicReferenceArray<T> curArray = this.array;
        int curLen = curArray.length();
        if (index < curLen) {
            curArray.set(index, value);
            return;
        }
        AtomicReferenceArray<T> newArray = new AtomicReferenceArray<T>(RangesKt.coerceAtLeast((int)(index + 1), (int)(2 * curLen)));
        for (int i2 = 0; i2 < curLen; ++i2) {
            newArray.set(i2, curArray.get(i2));
        }
        newArray.set(index, value);
        this.array = newArray;
    }
}

