/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Hand
 *  net.minecraft.util.ActionResult
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Settings
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.world.event.GameEvent
 *  net.minecraft.registry.entry.RegistryEntry
 */
package backported.updates.content.common.level.items;

import backported.updates.content.common.level.entities.happyghast.HappyGhast;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemConvertible;
import net.minecraft.world.event.GameEvent;
import net.minecraft.registry.entry.RegistryEntry;

public class HarnessItem
extends Item {
    public HarnessItem(Item.Settings properties) {
        super(properties);
    }

    public ActionResult useOnEntity(ItemStack stack, PlayerEntity player, LivingEntity target, Hand usedHand) {
        if (target instanceof HappyGhast) {
            HappyGhast ghast = (HappyGhast)target;
            if (target.isAlive() && !ghast.isHarnessed() && ghast.canBeHarnessed()) {
                if (!player.getWorld().isClient) {
                    ghast.equipHarness();
                    ghast.equipStack(EquipmentSlot.CHEST, new ItemStack((ItemConvertible)this));
                    target.getWorld().emitGameEvent((Entity)target, (RegistryEntry)GameEvent.EQUIP, target.getPos());
                    stack.decrement(1);
                }
                return ActionResult.success((boolean)player.getWorld().isClient);
            }
        }
        return ActionResult.PASS;
    }
}

