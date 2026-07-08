/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2338
 *  net.minecraft.class_2586
 *  net.minecraft.class_2680
 */
package org.valkyrienskies.mod.common.blockentity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2338;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;
import org.valkyrienskies.core.api.ships.PhysShip;
import org.valkyrienskies.core.api.world.PhysLevel;
import org.valkyrienskies.mod.api.BlockEntityPhysicsListener;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J!\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\b\u0010\tR&\u0010\f\u001a\u00060\nj\u0002`\u000b8\u0016@\u0016X\u0096.\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0018"}, d2={"Lorg/valkyrienskies/mod/common/blockentity/TestAntigravBlockEntity;", "Lnet/minecraft/class_2586;", "Lorg/valkyrienskies/mod/api/BlockEntityPhysicsListener;", "Lorg/valkyrienskies/core/api/ships/PhysShip;", "physShip", "Lorg/valkyrienskies/core/api/world/PhysLevel;", "physLevel", "", "physTick", "(Lorg/valkyrienskies/core/api/ships/PhysShip;Lorg/valkyrienskies/core/api/world/PhysLevel;)V", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "dimension", "Ljava/lang/String;", "getDimension", "()Ljava/lang/String;", "setDimension", "(Ljava/lang/String;)V", "Lnet/minecraft/class_2338;", "blockPos", "Lnet/minecraft/class_2680;", "blockState", "<init>", "(Lnet/minecraft/class_2338;Lnet/minecraft/class_2680;)V", "valkyrienskies-120"})
public final class TestAntigravBlockEntity
extends class_2586
implements BlockEntityPhysicsListener {
    public volatile String dimension;

    public TestAntigravBlockEntity(@NotNull class_2338 blockPos, @NotNull class_2680 blockState) {
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        Intrinsics.checkNotNullParameter((Object)blockState, (String)"blockState");
        super(ValkyrienSkiesMod.INSTANCE.getTEST_ANTIGRAV_BLOCK_ENTITY_TYPE(), blockPos, blockState);
    }

    @Override
    @NotNull
    public String getDimension() {
        String string = this.dimension;
        if (string != null) {
            return string;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"dimension");
        return null;
    }

    @Override
    public void setDimension(@NotNull String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<set-?>");
        this.dimension = string;
    }

    @Override
    public void physTick(@Nullable PhysShip physShip, @NotNull PhysLevel physLevel) {
        Intrinsics.checkNotNullParameter((Object)physLevel, (String)"physLevel");
        if (physShip == null) {
            return;
        }
        double atmoGravity = ((Number)physLevel.getAerodynamicUtils().getAtmosphereForDimension(physLevel.getDimension()).getThird()).doubleValue();
        double forceToCancel = physShip.getMass() * atmoGravity;
        Vector3d forceVec = new Vector3d(0.0, forceToCancel, 0.0);
        PhysShip.applyWorldForceToBodyPos$default(physShip, forceVec, null, 2, null);
    }
}

