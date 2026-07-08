/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.World
 *  net.minecraft.block.DispenserBlock
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPointer
 *  net.minecraft.block.dispenser.ItemDispenserBehavior
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.Property
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.registry.tag.FluidTags
 */
package backported.updates.content.common.level.dispenser;

import backported.updates.content.common.level.boat.PaleOakBoat;
import backported.updates.content.common.level.boat.PaleOakBoatBehavior;
import backported.updates.content.common.level.boat.PaleOakChestBoat;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.block.DispenserBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.state.property.Property;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.registry.tag.FluidTags;

public class PaleOakBoatDispenseBehavior
extends ItemDispenserBehavior {
    private final ItemDispenserBehavior defaultDispenseItemBehavior = new ItemDispenserBehavior();
    private final boolean isChestBoat;

    public PaleOakBoatDispenseBehavior() {
        this(false);
    }

    public PaleOakBoatDispenseBehavior(boolean isChestBoat) {
        this.isChestBoat = isChestBoat;
    }

    public ItemStack dispenseSilently(BlockPointer source, ItemStack stack) {
        Direction direction = (Direction)source.state().get(DispenserBlock.FACING);
        ServerWorld level = source.world();
        Vec3d center = source.centerPos();
        double width = 0.5625 + (double)EntityType.BOAT.getWidth() / 2.0;
        double x = center.getX() + (double)direction.getOffsetX() * width;
        double y = center.getY() + (double)((float)direction.getOffsetY() * 1.125f);
        double z = center.getZ() + (double)direction.getOffsetZ() * width;
        BlockPos blockpos = source.pos().offset(direction);
        double offset = 0.0;
        if (level.getFluidState(blockpos).isIn(FluidTags.WATER)) {
            offset = 1.0;
        } else if (!level.getBlockState(blockpos).isAir() || !level.getFluidState(blockpos.down()).isIn(FluidTags.WATER)) {
            return this.defaultDispenseItemBehavior.dispense(source, stack);
        }
        Entity boat = this.isChestBoat ? new PaleOakChestBoat((World)level, x, y, z) : new PaleOakBoat((World)level, x, y, z);
        boat.setYaw(direction.asRotation());
        boat.setPosition(x, y + offset, z);
        level.spawnEntity(boat);
        stack.decrement(1);
        return stack;
    }

    protected void playSound(BlockPointer source) {
        source.world().syncWorldEvent(1000, source.pos(), 0);
    }
}

