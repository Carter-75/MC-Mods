/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Comparator;
import org.valkyrienskies.core.impl.shadow.ab_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.aZ
 */
public final class az_1 {
    public static final Comparator<ab_1<?, ?>> a = (ab_12, ab_13) -> Boolean.compare(ab_12.s().endsWith(")"), ab_13.s().endsWith(")"));
    public static final Comparator<ab_1<?, ?>> b = (ab_12, ab_13) -> ab_12.s().compareTo(ab_13.s());
    public static final Comparator<ab_1<?, ?>> c = a.thenComparing(b);
}

