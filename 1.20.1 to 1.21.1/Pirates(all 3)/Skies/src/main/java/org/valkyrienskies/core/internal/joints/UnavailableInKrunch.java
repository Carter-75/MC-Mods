/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.RequiresOptIn
 *  kotlin.RequiresOptIn$Level
 *  kotlin.annotation.AnnotationRetention
 *  kotlin.annotation.Retention
 */
package org.valkyrienskies.core.internal.joints;

import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.RequiresOptIn;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;

@Retention(value=AnnotationRetention.BINARY)
@java.lang.annotation.Retention(value=RetentionPolicy.CLASS)
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lorg/valkyrienskies/core/internal/joints/UnavailableInKrunch;", "", "<init>", "()V", "internal"})
@RequiresOptIn(message="This joint does not function when the Physics Backend is set to OG Krunch, requiring PhysX instead.", level=RequiresOptIn.Level.WARNING)
public @interface UnavailableInKrunch {
}

