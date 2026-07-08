/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.foundation.core.util.event;

public enum CancellableResult {
    PASS(false),
    CANCEL(true);

    private final boolean cancelled;

    public static CancellableResult pass() {
        return PASS;
    }

    public static CancellableResult cancel() {
        return CANCEL;
    }

    private CancellableResult(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }
}

