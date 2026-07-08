/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Hand
 *  net.minecraft.util.TypedActionResult
 *  net.minecraft.entity.Entity
 *  net.minecraft.predicate.entity.EntityPredicates
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.vehicle.BoatEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Settings
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.World
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Position
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.stat.Stats
 *  net.minecraft.world.RaycastContext$FluidHandling
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.world.event.GameEvent
 *  net.minecraft.registry.entry.RegistryEntry
 */
package backported.updates.content.common.level.items;

import backported.updates.content.common.level.boat.PaleOakBoat;
import backported.updates.content.common.level.boat.PaleOakChestBoat;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.entity.Entity;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Box;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.stat.Stats;
import net.minecraft.world.RaycastContext;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.event.GameEvent;
import net.minecraft.registry.entry.RegistryEntry;

public class PaleOakBoatItem
extends Item {
    private static final Predicate<Entity> ENTITY_PREDICATE = EntityPredicates.EXCEPT_SPECTATOR.and(Entity::canHit);
    private final boolean hasChest;

    public PaleOakBoatItem(boolean hasChest, Item.Settings properties) {
        super(properties);
        this.hasChest = hasChest;
    }

    public TypedActionResult<ItemStack> use(World level, PlayerEntity player, Hand hand) {
        ItemStack heldStack = player.getStackInHand(hand);
        BlockHitResult hitResult = PaleOakBoatItem.raycast((World)level, (PlayerEntity)player, (RaycastContext.FluidHandling)RaycastContext.FluidHandling.ANY);
        if (hitResult.getType() == HitResult.Type.MISS) {
            return TypedActionResult.pass(heldStack);
        }
        Vec3d viewVector = player.getRotationVec(1.0f);
        List<Entity> list = level.getOtherEntities((Entity)player, player.getBoundingBox().stretch(viewVector.multiply(5.0)).expand(1.0), ENTITY_PREDICATE);
        if (!list.isEmpty()) {
            Vec3d eyePosition = player.getEyePos();
            for (Entity entity : list) {
                Box aabb = entity.getBoundingBox().expand((double)entity.getTargetingMargin());
                if (!aabb.contains(eyePosition)) continue;
                return TypedActionResult.pass(heldStack);
            }
        }
        if (hitResult.getType() == HitResult.Type.BLOCK) {
            BoatEntity boat = this.getBoat(level, (HitResult)hitResult);
            boat.setYaw(player.getYaw());
            if (!level.isSpaceEmpty((Entity)boat, boat.getBoundingBox())) {
                return TypedActionResult.fail(heldStack);
            }
            if (!level.isClient()) {
                level.spawnEntity((Entity)boat);
                level.emitGameEvent((Entity)player, (RegistryEntry)GameEvent.ENTITY_PLACE, BlockPos.ofFloored((Position)hitResult.getPos()));
                if (!player.getAbilities().creativeMode) {
                    heldStack.decrement(1);
                }
            }
            player.incrementStat(Stats.USED.getOrCreateStat(this));
            return TypedActionResult.success(heldStack, (boolean)level.isClient());
        }
        return TypedActionResult.pass(heldStack);
    }

    private BoatEntity getBoat(World level, HitResult hitResult) {
        return this.hasChest ? new PaleOakChestBoat(level, hitResult.getPos().x, hitResult.getPos().y, hitResult.getPos().z) : new PaleOakBoat(level, hitResult.getPos().x, hitResult.getPos().y, hitResult.getPos().z);
    }
}

