/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 */
package org.valkyrienskies.core.impl.program;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.valkyrienskies.core.api.event.SingleEvent;
import org.valkyrienskies.core.api.events.CollisionEvent;
import org.valkyrienskies.core.api.events.MergeEvent;
import org.valkyrienskies.core.api.events.PhysTickEvent;
import org.valkyrienskies.core.api.events.SplitEvent;
import org.valkyrienskies.core.impl.shadow.EU;
import org.valkyrienskies.core.impl.shadow.FL;
import org.valkyrienskies.core.impl.shadow.fi_0;
import org.valkyrienskies.core.impl.shadow.fj_0;
import org.valkyrienskies.core.internal.VsiCore;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028'X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028'X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028'X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\u000e\u001a\u00020\u000b8'X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8'X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u00028'X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0005R\u0014\u0010\u0019\u001a\u00020\u00168'X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00028'X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0005R\u0014\u0010 \u001a\u00020\u001d8'X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\u00028'X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\u0005\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/impl/program/VSCoreInternal;", "Lorg/valkyrienskies/core/internal/VsiCore;", "Lorg/valkyrienskies/core/api/event/SingleEvent;", "Lorg/valkyrienskies/core/api/events/CollisionEvent;", "getCollisionEndEvent", "()Lorg/valkyrienskies/core/api/event/SingleEvent;", "collisionEndEvent", "getCollisionPersistEvent", "collisionPersistEvent", "getCollisionStartEvent", "collisionStartEvent", "Lorg/valkyrienskies/core/impl/shadow/Fj;", "getConfigurator", "()Lorg/valkyrienskies/core/impl/shadow/Fj;", "configurator", "Lorg/valkyrienskies/core/impl/shadow/EU;", "getHooks", "()Lorg/valkyrienskies/core/impl/shadow/EU;", "hooks", "Lorg/valkyrienskies/core/api/events/MergeEvent;", "getMergeEvent", "mergeEvent", "Lorg/valkyrienskies/core/impl/shadow/Fi;", "getNetworking", "()Lorg/valkyrienskies/core/impl/shadow/Fi;", "networking", "Lorg/valkyrienskies/core/api/events/PhysTickEvent;", "getPhysTickEvent", "physTickEvent", "Lorg/valkyrienskies/core/impl/shadow/FL$a;", "getPipelineComponentFactory", "()Lorg/valkyrienskies/core/impl/shadow/FL$a;", "pipelineComponentFactory", "Lorg/valkyrienskies/core/api/events/SplitEvent;", "getSplitEvent", "splitEvent"})
public interface VSCoreInternal
extends VsiCore {
    @JvmName(name="getNetworking")
    public fi_0 getNetworking();

    @Override
    @JvmName(name="getHooks")
    public EU getHooks();

    @JvmName(name="getConfigurator")
    public fj_0 getConfigurator();

    @JvmName(name="getPipelineComponentFactory")
    public FL.a getPipelineComponentFactory();

    @JvmName(name="getCollisionStartEvent")
    public SingleEvent<CollisionEvent> getCollisionStartEvent();

    @JvmName(name="getCollisionEndEvent")
    public SingleEvent<CollisionEvent> getCollisionEndEvent();

    @JvmName(name="getCollisionPersistEvent")
    public SingleEvent<CollisionEvent> getCollisionPersistEvent();

    @JvmName(name="getPhysTickEvent")
    public SingleEvent<PhysTickEvent> getPhysTickEvent();

    @JvmName(name="getMergeEvent")
    public SingleEvent<MergeEvent> getMergeEvent();

    @JvmName(name="getSplitEvent")
    public SingleEvent<SplitEvent> getSplitEvent();
}

