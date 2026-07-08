/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.contraptions.actors.seat.SeatEntity
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1309
 *  net.minecraft.class_1937
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Overwrite
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.entity;

import com.simibubi.create.content.contraptions.actors.seat.SeatEntity;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1937;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={SeatEntity.class})
public abstract class MixinSeatEntity
extends class_1297 {
    public MixinSeatEntity(class_1299<?> entityType, class_1937 level) {
        super(entityType, level);
    }

    @Overwrite
    @NotNull
    public class_243 method_24829(@NotNull class_1309 livingEntity) {
        if (VSGameUtilsKt.isBlockInShipyard(this.method_37908(), this.method_19538()) && VSGameUtilsKt.getShipManagingPos(this.method_37908(), (class_2374)this.method_19538()) == null) {
            return livingEntity.method_19538();
        }
        return super.method_24829(livingEntity).method_1031(0.0, 0.5, 0.0);
    }
}

