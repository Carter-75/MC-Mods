/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  net.minecraft.class_1297
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_897
 */
package org.valkyrienskies.mod.common.entity.handling;

import kotlin.Metadata;
import net.minecraft.class_1297;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_897;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.Ship;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\t\u0010\bJw\u0010\u001b\u001a\u00020\u0006\"\b\b\u0000\u0010\n*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00028\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H&\u00a2\u0006\u0004\b\u001b\u0010\u001cJ7\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH&\u00a2\u0006\u0004\b\u001f\u0010 J\u001f\u0010#\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!H&\u00a2\u0006\u0004\b#\u0010$J7\u0010&\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H&\u00a2\u0006\u0004\b&\u0010'\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006(\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/mod/common/entity/handling/VSEntityHandler;", "", "Lnet/minecraft/class_1297;", "entity", "Lorg/valkyrienskies/core/api/ships/Ship;", "ship", "", "freshEntityInShipyard", "(Lnet/minecraft/class_1297;Lorg/valkyrienskies/core/api/ships/Ship;)V", "entityRemovedFromShipyard", "T", "Lorg/valkyrienskies/core/api/ships/ClientShip;", "Lnet/minecraft/class_897;", "entityRenderer", "", "x", "y", "z", "", "rotationYaw", "partialTicks", "Lnet/minecraft/class_4587;", "matrixStack", "Lnet/minecraft/class_4597;", "buffer", "", "packedLight", "applyRenderTransform", "(Lorg/valkyrienskies/core/api/ships/ClientShip;Lnet/minecraft/class_1297;Lnet/minecraft/class_897;DDDFFLnet/minecraft/class_4587;Lnet/minecraft/class_4597;I)V", "self", "vehicle", "positionSetFromVehicle", "(Lnet/minecraft/class_1297;Lnet/minecraft/class_1297;DDD)V", "Lorg/joml/Vector3d;", "pos", "getTeleportPos", "(Lnet/minecraft/class_1297;Lorg/joml/Vector3d;)Lorg/joml/Vector3d;", "passenger", "applyRenderOnMountedEntity", "(Lorg/valkyrienskies/core/api/ships/ClientShip;Lnet/minecraft/class_1297;Lnet/minecraft/class_1297;FLnet/minecraft/class_4587;)V", "valkyrienskies-120"})
public interface VSEntityHandler {
    public void freshEntityInShipyard(@NotNull class_1297 var1, @NotNull Ship var2);

    public void entityRemovedFromShipyard(@NotNull class_1297 var1, @NotNull Ship var2);

    public <T extends class_1297> void applyRenderTransform(@NotNull ClientShip var1, @NotNull T var2, @NotNull class_897<T> var3, double var4, double var6, double var8, float var10, float var11, @NotNull class_4587 var12, @NotNull class_4597 var13, int var14);

    public void positionSetFromVehicle(@NotNull class_1297 var1, @NotNull class_1297 var2, double var3, double var5, double var7);

    @NotNull
    public Vector3d getTeleportPos(@NotNull class_1297 var1, @NotNull Vector3d var2);

    public void applyRenderOnMountedEntity(@NotNull ClientShip var1, @NotNull class_1297 var2, @NotNull class_1297 var3, float var4, @NotNull class_4587 var5);
}

