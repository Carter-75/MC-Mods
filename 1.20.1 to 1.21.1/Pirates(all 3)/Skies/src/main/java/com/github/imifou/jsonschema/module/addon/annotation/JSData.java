/*
 * Decompiled with CFR 0.152.
 */
package com.github.imifou.jsonschema.module.addon.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.ANNOTATION_TYPE})
@Deprecated
public @interface JSData {
    public String key();

    public String value();
}

