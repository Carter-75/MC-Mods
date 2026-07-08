/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  net.minecraft.class_2586
 *  net.minecraft.class_2680
 *  net.minecraft.class_2741
 *  net.minecraft.class_2769
 */
package org.valkyrienskies.mod.common.blockentity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_2769;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.PhysShip;
import org.valkyrienskies.core.api.world.PhysLevel;
import org.valkyrienskies.mod.api.BlockEntityPhysicsListener;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010 \u001a\u00020\u001c\u0012\u0006\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b#\u0010$J!\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\b\u0010\tR&\u0010\f\u001a\u00060\nj\u0002`\u000b8\u0016@\u0016X\u0096.\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u001b\u001a\u00020\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001f\u001a\u00020\u001c8F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006%"}, d2={"Lorg/valkyrienskies/mod/common/blockentity/TestThrusterBlockEntity;", "Lorg/valkyrienskies/mod/api/BlockEntityPhysicsListener;", "Lnet/minecraft/class_2586;", "Lorg/valkyrienskies/core/api/ships/PhysShip;", "physShip", "Lorg/valkyrienskies/core/api/world/PhysLevel;", "physLevel", "", "physTick", "(Lorg/valkyrienskies/core/api/ships/PhysShip;Lorg/valkyrienskies/core/api/world/PhysLevel;)V", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "dimension", "Ljava/lang/String;", "getDimension", "()Ljava/lang/String;", "setDimension", "(Ljava/lang/String;)V", "", "isActive", "Z", "()Z", "setActive", "(Z)V", "Lnet/minecraft/class_2350;", "getFacing", "()Lnet/minecraft/class_2350;", "facing", "Lnet/minecraft/class_2338;", "getPos", "()Lnet/minecraft/class_2338;", "pos", "blockPos", "Lnet/minecraft/class_2680;", "blockState", "<init>", "(Lnet/minecraft/class_2338;Lnet/minecraft/class_2680;)V", "valkyrienskies-120"})
public final class TestThrusterBlockEntity
extends class_2586
implements BlockEntityPhysicsListener {
    public volatile String dimension;
    private volatile boolean isActive;

    public TestThrusterBlockEntity(@NotNull class_2338 blockPos, @NotNull class_2680 blockState) {
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        Intrinsics.checkNotNullParameter((Object)blockState, (String)"blockState");
        super(ValkyrienSkiesMod.INSTANCE.getTEST_THRUSTER_BLOCK_ENTITY_TYPE(), blockPos, blockState);
        Comparable comparable = blockState.method_11654((class_2769)class_2741.field_12484);
        Intrinsics.checkNotNullExpressionValue((Object)comparable, (String)"getValue(...)");
        this.isActive = (Boolean)comparable;
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

    public final boolean isActive() {
        return this.isActive;
    }

    public final void setActive(boolean bl) {
        this.isActive = bl;
    }

    @NotNull
    public final class_2350 getFacing() {
        Comparable comparable = this.method_11010().method_11654((class_2769)class_2741.field_12525);
        Intrinsics.checkNotNullExpressionValue((Object)comparable, (String)"getValue(...)");
        return (class_2350)comparable;
    }

    @NotNull
    public final class_2338 getPos() {
        class_2338 class_23382 = this.field_11867;
        Intrinsics.checkNotNullExpressionValue((Object)class_23382, (String)"worldPosition");
        return class_23382;
    }

    @Override
    public void physTick(@Nullable PhysShip physShip, @NotNull PhysLevel physLevel) {
        Intrinsics.checkNotNullParameter((Object)physLevel, (String)"physLevel");
        if (!this.isActive || physShip == null) {
            return;
        }
        class_2382 class_23822 = this.getFacing().method_10163();
        Intrinsics.checkNotNullExpressionValue((Object)class_23822, (String)"getNormal(...)");
        Vector3d vector3d = VectorConversionsMCKt.toJOMLD(class_23822).mul(10000.0);
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"mul(...)");
        Vector3dc vector3dc = vector3d;
        Vector3d vector3d2 = VectorConversionsMCKt.toJOMLD((class_2382)this.getPos()).add(0.5, 0.5, 0.5);
        Intrinsics.checkNotNullExpressionValue((Object)vector3d2, (String)"add(...)");
        physShip.applyModelForce(vector3dc, vector3d2);
    }
}

