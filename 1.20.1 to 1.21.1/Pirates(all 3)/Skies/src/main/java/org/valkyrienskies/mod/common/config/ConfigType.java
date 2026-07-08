/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 */
package org.valkyrienskies.mod.common.config;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2={"Lorg/valkyrienskies/mod/common/config/ConfigType;", "", "<init>", "(Ljava/lang/String;I)V", "CORE_SERVER", "SERVER", "COMMON", "CLIENT", "valkyrienskies-120"})
public final class ConfigType
extends Enum<ConfigType> {
    public static final /* enum */ ConfigType CORE_SERVER = new ConfigType();
    public static final /* enum */ ConfigType SERVER = new ConfigType();
    public static final /* enum */ ConfigType COMMON = new ConfigType();
    public static final /* enum */ ConfigType CLIENT = new ConfigType();
    private static final /* synthetic */ ConfigType[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static ConfigType[] values() {
        return (ConfigType[])$VALUES.clone();
    }

    public static ConfigType valueOf(String value) {
        return Enum.valueOf(ConfigType.class, value);
    }

    @NotNull
    public static EnumEntries<ConfigType> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = configTypeArray = new ConfigType[]{ConfigType.CORE_SERVER, ConfigType.SERVER, ConfigType.COMMON, ConfigType.CLIENT};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

