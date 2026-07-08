/*
 * Decompiled with CFR 0.152.
 */
package com.fasterxml.jackson.module.paramnames;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.module.paramnames.PackageVersion;
import com.fasterxml.jackson.module.paramnames.ParameterExtractor;
import com.fasterxml.jackson.module.paramnames.ParameterNamesAnnotationIntrospector;

public class ParameterNamesModule
extends SimpleModule {
    private static final long serialVersionUID = 1L;
    private final JsonCreator.Mode creatorBinding;

    public ParameterNamesModule(JsonCreator.Mode creatorBinding) {
        super(PackageVersion.VERSION);
        this.creatorBinding = creatorBinding;
    }

    public ParameterNamesModule() {
        super(PackageVersion.VERSION);
        this.creatorBinding = null;
    }

    @Override
    public void setupModule(Module.SetupContext context) {
        super.setupModule(context);
        context.insertAnnotationIntrospector(new ParameterNamesAnnotationIntrospector(this.creatorBinding, new ParameterExtractor()));
    }

    public int hashCode() {
        return this.getClass().hashCode();
    }

    public boolean equals(Object o) {
        return this == o;
    }
}

