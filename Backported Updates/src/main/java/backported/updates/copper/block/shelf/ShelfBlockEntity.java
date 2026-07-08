/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.inventory.Inventories
 *  net.minecraft.inventory.Inventory
 *  net.minecraft.inventory.SidedInventory
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.collection.DefaultedList
 *  net.minecraft.nbt.NbtCompound
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.listener.ClientPlayPacketListener
 *  net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket
 *  net.minecraft.block.BlockState
 *  net.minecraft.registry.RegistryWrapper$WrapperLookup
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.copper.block.shelf;

import backported.updates.copper.block.shelf.ListBackedContainer;
import backported.updates.copper.block.shelf.ShelfBlock;
import backported.updates.copper.registry.ModBlockEntities;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.block.BlockState;
import net.minecraft.registry.RegistryWrapper;
import org.jetbrains.annotations.Nullable;

public class ShelfBlockEntity
extends BlockEntity
implements ListBackedContainer,
SidedInventory {
    public static final int MAX_ITEMS = 3;
    private static final String ITEMS_TAG = "Items";
    private static final String ALIGN_ITEMS_TO_BOTTOM_TAG = "align_items_to_bottom";
    private static final int[] SLOTS = new int[]{0, 1, 2};
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize((int)3, ItemStack.EMPTY);
    private boolean alignItemsToBottom = false;

    public ShelfBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SHELF_BLOCK_ENTITY.get(), pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.items;
    }

    public boolean canPlayerUse(PlayerEntity player) {
        return Inventory.canPlayerUse((BlockEntity)this, (PlayerEntity)player);
    }

    public ItemStack swapItemNoUpdate(int slot, ItemStack stack) {
        ItemStack oldItem = this.removeStack(slot);
        this.setItemNoUpdate(slot, stack.copy());
        return oldItem;
    }

    public void markDirty() {
        super.markDirty();
        if (this.world != null && !this.world.isClient()) {
            this.world.updateListeners(this.getPos(), this.getCachedState(), this.getCachedState(), 3);
        }
    }

    protected void writeNbt(NbtCompound tag, RegistryWrapper.WrapperLookup registries) {
        super.writeNbt(tag, registries);
        Inventories.writeNbt((NbtCompound)tag, this.items, (boolean)true, (RegistryWrapper.WrapperLookup)registries);
        tag.putBoolean(ALIGN_ITEMS_TO_BOTTOM_TAG, this.alignItemsToBottom);
    }

    protected void readNbt(NbtCompound tag, RegistryWrapper.WrapperLookup registries) {
        super.readNbt(tag, registries);
        this.items.clear();
        Inventories.readNbt((NbtCompound)tag, this.items, (RegistryWrapper.WrapperLookup)registries);
        this.alignItemsToBottom = tag.getBoolean(ALIGN_ITEMS_TO_BOTTOM_TAG);
    }

    @Nullable
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create((BlockEntity)this);
    }

    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registries) {
        NbtCompound tag = new NbtCompound();
        Inventories.writeNbt((NbtCompound)tag, this.items, (boolean)true, (RegistryWrapper.WrapperLookup)registries);
        tag.putBoolean(ALIGN_ITEMS_TO_BOTTOM_TAG, this.alignItemsToBottom);
        return tag;
    }

    public boolean getAlignItemsToBottom() {
        return this.alignItemsToBottom;
    }

    public void setAlignItemsToBottom(boolean alignItemsToBottom) {
        this.alignItemsToBottom = alignItemsToBottom;
        this.markDirty();
    }

    public float getVisualRotationYInDegrees() {
        return ((Direction)this.getCachedState().get(ShelfBlock.FACING)).getOpposite().asRotation();
    }

    public int[] getAvailableSlots(Direction side) {
        return SLOTS;
    }

    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        ItemStack existing = this.getStack(slot);
        if (existing.isEmpty()) {
            for (int i = 0; i < slot; ++i) {
                ItemStack prev = this.getStack(i);
                if (prev.isEmpty()) {
                    return false;
                }
                if (!ItemStack.areItemsAndComponentsEqual((ItemStack)prev, (ItemStack)stack) || prev.getCount() >= prev.getMaxCount()) continue;
                return false;
            }
            return true;
        }
        return ItemStack.areItemsAndComponentsEqual((ItemStack)existing, (ItemStack)stack) && existing.getCount() < existing.getMaxCount();
    }

    public boolean canExtract(int slot, ItemStack stack, Direction side) {
        for (int i = 2; i > slot; --i) {
            if (this.getStack(i).isEmpty()) continue;
            return false;
        }
        return true;
    }

    public int getMaxCountPerStack() {
        return 64;
    }
}

