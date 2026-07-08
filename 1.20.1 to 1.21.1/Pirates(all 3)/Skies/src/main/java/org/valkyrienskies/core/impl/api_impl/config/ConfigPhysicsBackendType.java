/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.impl.api_impl.config;

import kotlin.Metadata;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Lorg/valkyrienskies/core/impl/api_impl/config/ConfigPhysicsBackendType;", "", "<init>", "(Ljava/lang/String;I)V", "KRUNCH_CLASSIC", "KRUNCH_PHYSX", "internal"})
public final class ConfigPhysicsBackendType
extends Enum<ConfigPhysicsBackendType> {
    public static final /* enum */ ConfigPhysicsBackendType KRUNCH_CLASSIC = new ConfigPhysicsBackendType();
    public static final /* enum */ ConfigPhysicsBackendType KRUNCH_PHYSX = new ConfigPhysicsBackendType();
    private static final /* synthetic */ ConfigPhysicsBackendType[] $VALUES;

    public static ConfigPhysicsBackendType[] values() {
        return (ConfigPhysicsBackendType[])$VALUES.clone();
    }

    public static ConfigPhysicsBackendType valueOf(String value) {
        return Enum.valueOf(ConfigPhysicsBackendType.class, value);
    }

    static {
        $VALUES = configPhysicsBackendTypeArray = new ConfigPhysicsBackendType[]{ConfigPhysicsBackendType.KRUNCH_CLASSIC, ConfigPhysicsBackendType.KRUNCH_PHYSX};
    }
}

