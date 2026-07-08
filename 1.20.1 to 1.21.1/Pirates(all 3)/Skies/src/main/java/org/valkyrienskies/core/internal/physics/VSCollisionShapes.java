/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.internal.physics;

import kotlin.Metadata;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2={"Lorg/valkyrienskies/core/internal/physics/VSCollisionShapes;", "", "<init>", "(Ljava/lang/String;I)V", "VOXEL", "SPHERE", "WHEEL", "BOX", "CAPSULE", "internal"})
public final class VSCollisionShapes
extends Enum<VSCollisionShapes> {
    public static final /* enum */ VSCollisionShapes VOXEL = new VSCollisionShapes();
    public static final /* enum */ VSCollisionShapes SPHERE = new VSCollisionShapes();
    public static final /* enum */ VSCollisionShapes WHEEL = new VSCollisionShapes();
    public static final /* enum */ VSCollisionShapes BOX = new VSCollisionShapes();
    public static final /* enum */ VSCollisionShapes CAPSULE = new VSCollisionShapes();
    private static final /* synthetic */ VSCollisionShapes[] $VALUES;

    public static VSCollisionShapes[] values() {
        return (VSCollisionShapes[])$VALUES.clone();
    }

    public static VSCollisionShapes valueOf(String value) {
        return Enum.valueOf(VSCollisionShapes.class, value);
    }

    static {
        $VALUES = vSCollisionShapesArray = new VSCollisionShapes[]{VSCollisionShapes.VOXEL, VSCollisionShapes.SPHERE, VSCollisionShapes.WHEEL, VSCollisionShapes.BOX, VSCollisionShapes.CAPSULE};
    }
}

