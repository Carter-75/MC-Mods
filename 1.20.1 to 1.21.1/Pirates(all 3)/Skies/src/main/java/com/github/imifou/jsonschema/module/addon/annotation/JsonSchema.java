/*
 * Decompiled with CFR 0.152.
 */
package com.github.imifou.jsonschema.module.addon.annotation;

import com.github.imifou.jsonschema.module.addon.TypeFormat;
import com.github.imifou.jsonschema.module.addon.annotation.JSData;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.FIELD, ElementType.METHOD})
@Deprecated
public @interface JsonSchema {
    public String title() default "";

    public String description() default "";

    public TypeFormat format() default TypeFormat.NONE;

    public String defaultValue() default "";

    public double multipleOf() default 0.0;

    public double min() default 4.9E-324;

    public boolean exclusiveMin() default false;

    public double max() default 1.7976931348623157E308;

    public boolean exclusiveMax() default false;

    public int minLength() default 0;

    public int maxLength() default 0x7FFFFFFF;

    public String pattern() default "";

    public boolean required() default false;

    public boolean ignore() default false;

    public JSData[] metadata() default {};
}

