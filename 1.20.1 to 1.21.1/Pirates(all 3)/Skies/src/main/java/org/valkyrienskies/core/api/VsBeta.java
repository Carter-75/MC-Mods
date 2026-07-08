/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.RequiresOptIn
 *  kotlin.RequiresOptIn$Level
 */
package org.valkyrienskies.core.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.RequiresOptIn;
import org.jetbrains.annotations.ApiStatus;

@Retention(value=RetentionPolicy.RUNTIME)
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lorg/valkyrienskies/core/api/VsBeta;", "", "<init>", "()V", "api"})
@ApiStatus.Experimental
@RequiresOptIn(message="This is an experimental API, it may be changed or removed without warning in future versions of Valkyrien Skies. Addons that use this in production code are recommended to catch a potential LinkageError or NotImplementedError and recover gracefully if this API throws or is not available.", level=RequiresOptIn.Level.WARNING)
public @interface VsBeta {
}

