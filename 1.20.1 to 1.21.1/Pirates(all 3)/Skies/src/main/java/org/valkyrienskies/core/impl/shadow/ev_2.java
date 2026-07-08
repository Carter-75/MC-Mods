/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.cx_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ev
 */
public final class ev_2 {
    public static <T> T a(@cx_0 T reference) {
        if (reference == null) {
            throw new NullPointerException();
        }
        return reference;
    }

    public static <T> T a(T reference, String errorMessage) {
        if (reference == null) {
            throw new NullPointerException(errorMessage);
        }
        return reference;
    }

    public static <T> T b(T reference) {
        if (reference == null) {
            throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
        }
        return reference;
    }

    private static <T> T c(T reference) {
        if (reference == null) {
            throw new NullPointerException("Cannot return null from a non-@Nullable component method");
        }
        return reference;
    }

    private static <T> T a(T reference, String errorMessageTemplate, Object errorMessageArg) {
        if (reference == null) {
            if (!errorMessageTemplate.contains("%s")) {
                throw new IllegalArgumentException("errorMessageTemplate has no format specifiers");
            }
            if (errorMessageTemplate.indexOf("%s") != errorMessageTemplate.lastIndexOf("%s")) {
                throw new IllegalArgumentException("errorMessageTemplate has more than one format specifier");
            }
            reference = String.valueOf(errorMessageArg instanceof Class ? ((Class)errorMessageArg).getCanonicalName() : errorMessageArg);
            throw new NullPointerException(errorMessageTemplate.replace("%s", (CharSequence)reference));
        }
        return reference;
    }

    public static <T> void a(T requirement, Class<T> clazz) {
        if (requirement == null) {
            throw new IllegalStateException(clazz.getCanonicalName() + " must be set");
        }
    }

    private ev_2() {
    }
}

