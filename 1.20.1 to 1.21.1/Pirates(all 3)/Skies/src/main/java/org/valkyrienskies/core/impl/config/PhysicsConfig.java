/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.config;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.impl.api_impl.config.ConfigPhysicsBackendType;
import org.valkyrienskies.core.internal.config.ConfigEntry;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b)\u0010*R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\b\u00a8\u0006+"}, d2={"Lorg/valkyrienskies/core/impl/config/PhysicsConfig;", "", "", "krunchIterations", "I", "getKrunchIterations", "()I", "setKrunchIterations", "(I)V", "lodDetail", "getLodDetail", "setLodDetail", "", "maxDePenetrationSpeed", "D", "getMaxDePenetrationSpeed", "()D", "setMaxDePenetrationSpeed", "(D)V", "Lorg/valkyrienskies/core/impl/api_impl/config/ConfigPhysicsBackendType;", "physicsBackend", "Lorg/valkyrienskies/core/impl/api_impl/config/ConfigPhysicsBackendType;", "getPhysicsBackend", "()Lorg/valkyrienskies/core/impl/api_impl/config/ConfigPhysicsBackendType;", "setPhysicsBackend", "(Lorg/valkyrienskies/core/impl/api_impl/config/ConfigPhysicsBackendType;)V", "physicsSpeed", "getPhysicsSpeed", "setPhysicsSpeed", "physicsSubSteps", "getPhysicsSubSteps", "setPhysicsSubSteps", "physicsThreads", "getPhysicsThreads", "setPhysicsThreads", "positionIterations", "getPositionIterations", "setPositionIterations", "velocityIterations", "getVelocityIterations", "setVelocityIterations", "<init>", "()V", "internal"})
public final class PhysicsConfig {
    @ConfigEntry(description="The detail of the collision LOD of ships, higher values are more detailed but heavier to compute. Setting this to 0 disables Lod.")
    private int lodDetail = 8192;
    @ConfigEntry(description="Sets number of sub-steps used by Krunch")
    private int physicsSubSteps = 20;
    @ConfigEntry(description="Sets number of iterations per sub-steps used by Krunch Classic. Typically 1 is enough, increasing substeps is more substantial.")
    private int krunchIterations = 1;
    @ConfigEntry(description="The maximum number of iterations used by the PhysX to resolve positions. Higher values are more accurate but heavier to compute", min=1.0, max=30.0)
    private int positionIterations = 8;
    @ConfigEntry(description="The maximum number of iterations used by PhysX to resolve velocity. Higher values are more accurate but heavier to compute", min=1.0, max=30.0)
    private int velocityIterations = 2;
    @ConfigEntry(description="Limit the max collision de-penetration speed so that rigid bodies don't go flying apart when they overlap")
    private double maxDePenetrationSpeed = 10.0;
    @ConfigEntry(description="How fast the physics is running. 1.0 is full speed, 0.5 is 50% speed, etc.")
    private double physicsSpeed = 1.0;
    @ConfigEntry(description="Which backend to use.")
    @NotNull
    private ConfigPhysicsBackendType physicsBackend = ConfigPhysicsBackendType.KRUNCH_CLASSIC;
    @ConfigEntry(description="How many threads are used by Krunch physics. When set to 0 Krunch will run everything on 1 thread, the same thread that executed krunch")
    private int physicsThreads = Math.max(Runtime.getRuntime().availableProcessors() - 4, 0);

    public final int getLodDetail() {
        return this.lodDetail;
    }

    public final void setLodDetail(int n2) {
        this.lodDetail = n2;
    }

    public final int getPhysicsSubSteps() {
        return this.physicsSubSteps;
    }

    public final void setPhysicsSubSteps(int n2) {
        this.physicsSubSteps = n2;
    }

    public final int getKrunchIterations() {
        return this.krunchIterations;
    }

    public final void setKrunchIterations(int n2) {
        this.krunchIterations = n2;
    }

    public final int getPositionIterations() {
        return this.positionIterations;
    }

    public final void setPositionIterations(int n2) {
        this.positionIterations = n2;
    }

    public final int getVelocityIterations() {
        return this.velocityIterations;
    }

    public final void setVelocityIterations(int n2) {
        this.velocityIterations = n2;
    }

    public final double getMaxDePenetrationSpeed() {
        return this.maxDePenetrationSpeed;
    }

    public final void setMaxDePenetrationSpeed(double d2) {
        this.maxDePenetrationSpeed = d2;
    }

    public final double getPhysicsSpeed() {
        return this.physicsSpeed;
    }

    public final void setPhysicsSpeed(double d2) {
        this.physicsSpeed = d2;
    }

    @NotNull
    public final ConfigPhysicsBackendType getPhysicsBackend() {
        return this.physicsBackend;
    }

    public final void setPhysicsBackend(@NotNull ConfigPhysicsBackendType configPhysicsBackendType) {
        Intrinsics.checkNotNullParameter((Object)((Object)configPhysicsBackendType), (String)"<set-?>");
        this.physicsBackend = configPhysicsBackendType;
    }

    public final int getPhysicsThreads() {
        return this.physicsThreads;
    }

    public final void setPhysicsThreads(int n2) {
        this.physicsThreads = n2;
    }
}

