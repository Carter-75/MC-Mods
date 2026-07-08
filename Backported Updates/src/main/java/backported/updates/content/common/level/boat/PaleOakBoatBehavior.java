/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.vehicle.BoatEntity
 *  net.minecraft.entity.vehicle.BoatEntity$Location
 *  net.minecraft.item.Items
 *  net.minecraft.world.GameRules
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.registry.tag.FluidTags
 */
package backported.updates.content.common.level.boat;

import backported.updates.content.common.registries.ModBlocks;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Items;
import net.minecraft.world.GameRules;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.tag.FluidTags;

public interface PaleOakBoatBehavior {
    default public void fall(BoatEntity boat, double y, boolean onGround) {
        boat.fallVelocity = boat.getVelocity().y;
        if (!boat.hasVehicle()) {
            if (onGround) {
                if (boat.fallDistance > 3.0f) {
                    if (boat.location != BoatEntity.Location.ON_LAND) {
                        boat.onLanding();
                        return;
                    }
                    boat.handleFallDamage(boat.fallDistance, 1.0f, boat.getDamageSources().fall());
                    if (!boat.getWorld().isClient() && !boat.isRemoved()) {
                        boat.kill();
                        if (boat.getWorld().getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
                            int i;
                            for (i = 0; i < 3; ++i) {
                                boat.dropItem((ItemConvertible)ModBlocks.PALE_OAK_PLANKS.get());
                            }
                            for (i = 0; i < 3; ++i) {
                                boat.dropItem((ItemConvertible)Items.STICK);
                            }
                        }
                    }
                }
                boat.onLanding();
            } else if (!boat.getWorld().getFluidState(boat.getBlockPos().down()).isIn(FluidTags.WATER) && y < 0.0) {
                boat.fallDistance -= (float)y;
            }
        }
    }
}

