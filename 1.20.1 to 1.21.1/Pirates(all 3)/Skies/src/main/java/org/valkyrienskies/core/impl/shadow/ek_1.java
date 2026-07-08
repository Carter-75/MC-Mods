/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.valkyrienskies.core.impl.shadow.du_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.eK
 */
@Target(value={ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
@Retention(value=RetentionPolicy.RUNTIME)
@Documented
@du_1
public @interface ek_1 {
    public Class<?> a();
}

