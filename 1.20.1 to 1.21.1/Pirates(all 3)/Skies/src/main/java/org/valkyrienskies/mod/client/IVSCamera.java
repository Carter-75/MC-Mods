/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  net.minecraft.class_1297
 *  net.minecraft.class_1922
 */
package org.valkyrienskies.mod.client;

import kotlin.Metadata;
import net.minecraft.class_1297;
import net.minecraft.class_1922;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.ClientShip;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JG\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH&\u00a2\u0006\u0004\b\u0010\u0010\u0011\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0012\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/mod/client/IVSCamera;", "", "Lnet/minecraft/class_1922;", "level", "Lnet/minecraft/class_1297;", "renderViewEntity", "", "thirdPerson", "thirdPersonReverse", "", "partialTicks", "Lorg/valkyrienskies/core/api/ships/ClientShip;", "shipMountedTo", "Lorg/joml/Vector3dc;", "inShipPlayerPosition", "", "setupWithShipMounted", "(Lnet/minecraft/class_1922;Lnet/minecraft/class_1297;ZZFLorg/valkyrienskies/core/api/ships/ClientShip;Lorg/joml/Vector3dc;)V", "valkyrienskies-120"})
public interface IVSCamera {
    public void setupWithShipMounted(@NotNull class_1922 var1, @NotNull class_1297 var2, boolean var3, boolean var4, float var5, @NotNull ClientShip var6, @NotNull Vector3dc var7);
}

