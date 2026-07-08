/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.simibubi.create.content.logistics.stockTicker.StockKeeperCategoryMenu
 *  com.simibubi.create.content.logistics.stockTicker.StockTickerBlockEntity
 *  com.simibubi.create.foundation.gui.menu.MenuBase
 *  net.minecraft.class_1661
 *  net.minecraft.class_2374
 *  net.minecraft.class_243
 *  net.minecraft.class_2540
 *  net.minecraft.class_3917
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client.gui.menu;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.content.logistics.stockTicker.StockKeeperCategoryMenu;
import com.simibubi.create.content.logistics.stockTicker.StockTickerBlockEntity;
import com.simibubi.create.foundation.gui.menu.MenuBase;
import net.minecraft.class_1661;
import net.minecraft.class_2374;
import net.minecraft.class_243;
import net.minecraft.class_2540;
import net.minecraft.class_3917;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={StockKeeperCategoryMenu.class})
public abstract class MixinStockKeeperCategoryMenu
extends MenuBase<StockTickerBlockEntity> {
    private MixinStockKeeperCategoryMenu(class_3917<?> type, int id, class_1661 inv, class_2540 extraData) {
        super(type, id, inv, extraData);
    }

    @WrapOperation(method={"stillValid"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;closerThan(Lnet/minecraft/core/Position;D)Z")})
    private boolean includeShipforDistCheck(class_243 instance, class_2374 position, double d2, Operation<Boolean> original) {
        Ship ship = VSGameUtilsKt.getShipManagingPos(((StockTickerBlockEntity)this.contentHolder).method_10997(), ((StockTickerBlockEntity)this.contentHolder).method_11016());
        if (ship != null) {
            Vector3d newPos = ship.getTransform().getShipToWorld().transformPosition(position.method_10216(), position.method_10214(), position.method_10215(), new Vector3d());
            return (Boolean)original.call(new Object[]{instance, VectorConversionsMCKt.toMinecraft(newPos), d2});
        }
        return (Boolean)original.call(new Object[]{instance, position, d2});
    }
}

