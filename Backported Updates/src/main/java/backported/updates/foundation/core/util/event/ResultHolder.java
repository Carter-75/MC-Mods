/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.foundation.core.util.event;

import backported.updates.foundation.core.util.event.CancellableResult;

public class ResultHolder<T> {
    private final CancellableResult result;
    private final T value;

    public static <T> ResultHolder<T> pass() {
        return new ResultHolder<T>(CancellableResult.PASS, null);
    }

    public static <T> ResultHolder<T> submit(T value) {
        return new ResultHolder<T>(CancellableResult.CANCEL, value);
    }

    ResultHolder(CancellableResult result, T value) {
        this.result = result;
        this.value = value;
    }

    public boolean isCancelled() {
        return this.result.isCancelled();
    }

    public T getValue() {
        return this.value;
    }
}

