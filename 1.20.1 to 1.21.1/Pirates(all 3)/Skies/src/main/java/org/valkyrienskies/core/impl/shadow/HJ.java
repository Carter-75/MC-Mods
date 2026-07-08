/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.valkyrienskies.core.impl.shadow.HK;
import org.valkyrienskies.core.impl.shadow.HL;
import org.valkyrienskies.core.impl.shadow.hb_0;

@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0018\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u00158&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001a\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u00158&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017\u00a8\u0006\u001c"}, d2={"Lorg/valkyrienskies/physics_api/joints/JointData;", "", "Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;", "getBreakForceTorque", "()Lorg/valkyrienskies/physics_api/joints/MaxForceTorque;", "breakForceTorque", "", "getCompliance", "()D", "compliance", "Lorg/valkyrienskies/physics_api/joints/JointType;", "getConstraintType", "()Lorg/valkyrienskies/physics_api/joints/JointType;", "constraintType", "Lorg/valkyrienskies/physics_api/Pose;", "getLocalFrame0", "()Lorg/valkyrienskies/physics_api/Pose;", "localFrame0", "getLocalFrame1", "localFrame1", "", "Lorg/valkyrienskies/physics_api/PhysicsBodyId;", "getPhysicsBodyId0", "()Ljava/lang/Integer;", "physicsBodyId0", "getPhysicsBodyId1", "physicsBodyId1", "Companion", "physics_api"})
public interface HJ {
    public static final a a = org.valkyrienskies.core.impl.shadow.HJ$a.a;
    public static final double k = 1.0E-10;

    @JvmName(name="a")
    public Integer a();

    @JvmName(name="b")
    public hb_0 b();

    @JvmName(name="c")
    public Integer c();

    @JvmName(name="d")
    public hb_0 d();

    @JvmName(name="e")
    public HL e();

    @JvmName(name="p")
    public HK p();

    @JvmName(name="o")
    public double o();

    public static final class a {
        static final /* synthetic */ a a;
        private static double b = 1.0E-10;

        private a() {
        }

        static {
            a = new a();
        }
    }
}

