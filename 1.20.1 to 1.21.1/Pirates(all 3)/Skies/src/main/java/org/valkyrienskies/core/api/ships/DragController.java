/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.api.ships;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.VsBeta;
import org.valkyrienskies.core.api.util.GameTickOnly;

@VsBeta
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&\u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H&\u00a2\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0006H&\u00a2\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\u0006H&\u00a2\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000e\u001a\u00020\u0006H&\u00a2\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\u0006H&\u00a2\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0013\u0010\u0011J1\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u0017H&\u00a2\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001bJ!\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u0017H&\u00a2\u0006\u0004\b\u001c\u0010\u001d\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u001e\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/ships/DragController;", "", "Lorg/joml/Vector3dc;", "direction", "", "speed", "", "applyWindImpulse", "(Lorg/joml/Vector3dc;D)V", "disableDrag", "()V", "disableLift", "disableRotDrag", "enableDrag", "enableLift", "enableRotDrag", "getDragForce", "()Lorg/joml/Vector3dc;", "getLiftForce", "getWindVector", "x", "y", "z", "", "identifier", "setWindDirection", "(DDDLjava/lang/String;)V", "(Lorg/joml/Vector3dc;Ljava/lang/String;)V", "setWindSpeed", "(DLjava/lang/String;)V", "api"})
@GameTickOnly
public interface DragController {
    public void enableDrag();

    public void disableDrag();

    public void enableLift();

    public void disableLift();

    public void enableRotDrag();

    public void disableRotDrag();

    @NotNull
    public Vector3dc getDragForce();

    @NotNull
    public Vector3dc getLiftForce();

    public void setWindDirection(double var1, double var3, double var5, @NotNull String var7);

    public static /* synthetic */ void setWindDirection$default(DragController dragController, double d2, double d3, double d4, String string, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setWindDirection");
        }
        if ((n2 & 8) != 0) {
            string = "default";
        }
        dragController.setWindDirection(d2, d3, d4, string);
    }

    default public void setWindDirection(@NotNull Vector3dc direction, @NotNull String identifier) {
        Intrinsics.checkNotNullParameter((Object)direction, (String)"direction");
        Intrinsics.checkNotNullParameter((Object)identifier, (String)"identifier");
        this.setWindDirection(direction.x(), direction.y(), direction.z(), identifier);
    }

    public static /* synthetic */ void setWindDirection$default(DragController dragController, Vector3dc vector3dc, String string, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setWindDirection");
        }
        if ((n2 & 2) != 0) {
            string = "default";
        }
        dragController.setWindDirection(vector3dc, string);
    }

    public void setWindSpeed(double var1, @NotNull String var3);

    public static /* synthetic */ void setWindSpeed$default(DragController dragController, double d2, String string, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setWindSpeed");
        }
        if ((n2 & 2) != 0) {
            string = "default";
        }
        dragController.setWindSpeed(d2, string);
    }

    public void applyWindImpulse(@NotNull Vector3dc var1, double var2);

    @NotNull
    public Vector3dc getWindVector();
}

