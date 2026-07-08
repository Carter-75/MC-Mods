/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 */
package org.valkyrienskies.core.api.ships;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix3dc;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.api.util.PhysTickOnly;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001a\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0002H'\u00a2\u0006\u0004\b\f\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H'\u00a2\u0006\u0004\b\u000e\u0010\u0007J\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0002H'\u00a2\u0006\u0004\b\u0010\u0010\nJ!\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0013\u0010\u0007J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0015\u0010\nJ\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0002H'\u00a2\u0006\u0004\b\u0016\u0010\nJ\u001f\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H'\u00a2\u0006\u0004\b\u0017\u0010\u0007J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0002H'\u00a2\u0006\u0004\b\u0018\u0010\nJ!\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u001b\u0010\u0007J!\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u001c\u0010\u0007J!\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u001d\u0010\u0007J\u0017\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u001f\u0010\nR$\u0010&\u001a\u00020 2\u0006\u0010!\u001a\u00020 8g@gX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020\u00028gX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010(R$\u0010/\u001a\u00020*2\u0006\u0010!\u001a\u00020*8g@gX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0014\u00100\u001a\u00020*8gX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b0\u0010,R\u001c\u00101\u001a\u00020*8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.R\u0014\u00104\u001a\u00020 8gX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b3\u0010#R\u0014\u00106\u001a\u00020 8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b5\u0010#R\u0014\u0010:\u001a\u0002078&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b8\u00109\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006;\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/ships/PhysShip;", "Lorg/valkyrienskies/core/api/ships/Ship;", "Lorg/joml/Vector3dc;", "forceInBody", "posInBody", "", "applyBodyForce", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)V", "torqueInBody", "applyBodyTorque", "(Lorg/joml/Vector3dc;)V", "force", "applyInvariantForce", "pos", "applyInvariantForceToPos", "torque", "applyInvariantTorque", "forceInShip", "posInShip", "applyModelForce", "torqueInShip", "applyModelTorque", "applyRotDependentForce", "applyRotDependentForceToPos", "applyRotDependentTorque", "forceInWorld", "posInWorld", "applyWorldForce", "applyWorldForceToBodyPos", "applyWorldForceToModelPos", "torqueInWorld", "applyWorldTorque", "", "<set-?>", "getBuoyantFactor", "()D", "setBuoyantFactor", "(D)V", "buoyantFactor", "getCenterOfMass", "()Lorg/joml/Vector3dc;", "centerOfMass", "", "getDoFluidDrag", "()Z", "setDoFluidDrag", "(Z)V", "doFluidDrag", "isSleeping", "isStatic", "setStatic", "getLiquidOverlap", "liquidOverlap", "getMass", "mass", "Lorg/joml/Matrix3dc;", "getMomentOfInertia", "()Lorg/joml/Matrix3dc;", "momentOfInertia", "api"})
@PhysTickOnly
public interface PhysShip
extends Ship {
    public boolean isStatic();

    public void setStatic(boolean var1);

    @ApiStatus.Experimental
    public double getBuoyantFactor();

    @ApiStatus.Experimental
    public void setBuoyantFactor(double var1);

    @ApiStatus.Experimental
    public boolean getDoFluidDrag();

    @ApiStatus.Experimental
    public void setDoFluidDrag(boolean var1);

    public double getMass();

    @ApiStatus.Experimental
    @NotNull
    public Vector3dc getCenterOfMass();

    @NotNull
    public Matrix3dc getMomentOfInertia();

    @ApiStatus.Experimental
    public double getLiquidOverlap();

    @ApiStatus.Experimental
    public boolean isSleeping();

    public void applyWorldForce(@NotNull Vector3dc var1, @NotNull Vector3dc var2);

    public static /* synthetic */ void applyWorldForce$default(PhysShip physShip, Vector3dc vector3dc, Vector3dc vector3dc2, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyWorldForce");
        }
        if ((n2 & 2) != 0) {
            vector3dc2 = physShip.getKinematics().getPosition();
        }
        physShip.applyWorldForce(vector3dc, vector3dc2);
    }

    public void applyWorldTorque(@NotNull Vector3dc var1);

    public void applyModelForce(@NotNull Vector3dc var1, @NotNull Vector3dc var2);

    public static /* synthetic */ void applyModelForce$default(PhysShip physShip, Vector3dc vector3dc, Vector3dc vector3dc2, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyModelForce");
        }
        if ((n2 & 2) != 0) {
            vector3dc2 = physShip.getKinematics().getPositionInModel();
        }
        physShip.applyModelForce(vector3dc, vector3dc2);
    }

    public void applyModelTorque(@NotNull Vector3dc var1);

    public void applyWorldForceToModelPos(@NotNull Vector3dc var1, @NotNull Vector3dc var2);

    public static /* synthetic */ void applyWorldForceToModelPos$default(PhysShip physShip, Vector3dc vector3dc, Vector3dc vector3dc2, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyWorldForceToModelPos");
        }
        if ((n2 & 2) != 0) {
            vector3dc2 = physShip.getKinematics().getPositionInModel();
        }
        physShip.applyWorldForceToModelPos(vector3dc, vector3dc2);
    }

    public void applyBodyForce(@NotNull Vector3dc var1, @NotNull Vector3dc var2);

    public static /* synthetic */ void applyBodyForce$default(PhysShip physShip, Vector3dc vector3dc, Vector3dc vector3dc2, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyBodyForce");
        }
        if ((n2 & 2) != 0) {
            vector3dc2 = new Vector3d();
        }
        physShip.applyBodyForce(vector3dc, vector3dc2);
    }

    public void applyBodyTorque(@NotNull Vector3dc var1);

    public void applyWorldForceToBodyPos(@NotNull Vector3dc var1, @NotNull Vector3dc var2);

    public static /* synthetic */ void applyWorldForceToBodyPos$default(PhysShip physShip, Vector3dc vector3dc, Vector3dc vector3dc2, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyWorldForceToBodyPos");
        }
        if ((n2 & 2) != 0) {
            vector3dc2 = new Vector3d();
        }
        physShip.applyWorldForceToBodyPos(vector3dc, vector3dc2);
    }

    @Deprecated(message="Use applyModelForce or applyBodyForce instead", replaceWith=@ReplaceWith(expression="applyBodyForce(force, posInBody)", imports={}))
    public void applyRotDependentForce(@NotNull Vector3dc var1);

    @Deprecated(message="Use applyWorldForce instead", replaceWith=@ReplaceWith(expression="applyWorldForce(force, posInWorld)", imports={}))
    public void applyInvariantForce(@NotNull Vector3dc var1);

    @Deprecated(message="Use applyModelForce or applyBodyForce instead", replaceWith=@ReplaceWith(expression="applyBodyForce(force, pos)", imports={}))
    public void applyRotDependentForceToPos(@NotNull Vector3dc var1, @NotNull Vector3dc var2);

    @Deprecated(message="Use applyWorldForce instead", replaceWith=@ReplaceWith(expression="applyWorldForce(force, pos)", imports={}))
    public void applyInvariantForceToPos(@NotNull Vector3dc var1, @NotNull Vector3dc var2);

    @Deprecated(message="Use applyModelTorque or applyBodyTorque instead", replaceWith=@ReplaceWith(expression="applyBodyTorque(torque)", imports={}))
    public void applyRotDependentTorque(@NotNull Vector3dc var1);

    @Deprecated(message="Use applyWorldTorque instead", replaceWith=@ReplaceWith(expression="applyWorldTorque(torque)", imports={}))
    public void applyInvariantTorque(@NotNull Vector3dc var1);
}

