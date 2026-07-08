/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.internal.joints;

import kotlin.Metadata;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2={"Lorg/valkyrienskies/core/internal/joints/VSJointType;", "", "<init>", "(Ljava/lang/String;I)V", "FIXED", "DISTANCE", "PRISMATIC", "SPHERICAL", "REVOLUTE", "GEAR", "RACK_AND_PINION", "D6", "internal"})
public final class VSJointType
extends Enum<VSJointType> {
    public static final /* enum */ VSJointType FIXED = new VSJointType();
    public static final /* enum */ VSJointType DISTANCE = new VSJointType();
    public static final /* enum */ VSJointType PRISMATIC = new VSJointType();
    public static final /* enum */ VSJointType SPHERICAL = new VSJointType();
    public static final /* enum */ VSJointType REVOLUTE = new VSJointType();
    public static final /* enum */ VSJointType GEAR = new VSJointType();
    public static final /* enum */ VSJointType RACK_AND_PINION = new VSJointType();
    public static final /* enum */ VSJointType D6 = new VSJointType();
    private static final /* synthetic */ VSJointType[] $VALUES;

    public static VSJointType[] values() {
        return (VSJointType[])$VALUES.clone();
    }

    public static VSJointType valueOf(String value) {
        return Enum.valueOf(VSJointType.class, value);
    }

    static {
        $VALUES = vSJointTypeArray = new VSJointType[]{VSJointType.FIXED, VSJointType.DISTANCE, VSJointType.PRISMATIC, VSJointType.SPHERICAL, VSJointType.REVOLUTE, VSJointType.GEAR, VSJointType.RACK_AND_PINION, VSJointType.D6};
    }
}

