/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.foundation.nightconfig.core.conversion;

public final class InvalidValueException
extends RuntimeException {
    public InvalidValueException(String message) {
        super(message);
    }

    public InvalidValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidValueException(String messageFormat, Object ... args) {
        super(String.format(messageFormat, args));
    }
}

