/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.RequiresOptIn
 *  kotlin.RequiresOptIn$Level
 *  kotlin.annotation.AnnotationRetention
 *  kotlin.annotation.MustBeDocumented
 *  kotlin.annotation.Retention
 */
package kotlinx.coroutines;

import java.lang.annotation.Documented;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.RequiresOptIn;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.MustBeDocumented;
import kotlin.annotation.Retention;

@MustBeDocumented
@Retention(value=AnnotationRetention.BINARY)
@Documented
@java.lang.annotation.Retention(value=RetentionPolicy.CLASS)
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lkotlinx/coroutines/DelicateCoroutinesApi;", "", "<init>", "()V", "kotlinx-coroutines-core"})
@RequiresOptIn(message="This is a delicate API and its use requires care. Make sure you fully read and understand documentation of the declaration that is marked as a delicate API.", level=RequiresOptIn.Level.WARNING)
public @interface DelicateCoroutinesApi {
}

