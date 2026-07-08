/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.inventory.Inventories
 *  net.minecraft.inventory.Inventory
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.collection.DefaultedList
 */
package backported.updates.copper.block.shelf;

import java.util.function.Predicate;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

public interface ListBackedContainer
extends Inventory {
    public DefaultedList<ItemStack> getItems();

    default public int count() {
        return (int)this.getItems().stream().filter(Predicate.not(ItemStack::isEmpty)).count();
    }

    default public int size() {
        return this.getItems().size();
    }

    default public void clear() {
        this.getItems().clear();
    }

    default public boolean isEmpty() {
        return this.getItems().stream().allMatch(ItemStack::isEmpty);
    }

    default public ItemStack getStack(int slot) {
        return (ItemStack)this.getItems().get(slot);
    }

    default public ItemStack removeStack(int slot, int amount) {
        ItemStack itemstack = Inventories.splitStack(this.getItems(), (int)slot, (int)amount);
        if (!itemstack.isEmpty()) {
            this.markDirty();
        }
        return itemstack;
    }

    default public ItemStack removeStack(int slot) {
        return Inventories.removeStack(this.getItems(), (int)slot);
    }

    default public boolean isValid(int slot, ItemStack stack) {
        if (!this.acceptsItemType(stack)) {
            return false;
        }
        ItemStack existing = this.getStack(slot);
        if (existing.isEmpty()) {
            return true;
        }
        return ItemStack.areItemsAndComponentsEqual((ItemStack)existing, (ItemStack)stack) && existing.getCount() < existing.getMaxCount();
    }

    default public boolean acceptsItemType(ItemStack stack) {
        return true;
    }

    default public void setStack(int slot, ItemStack stack) {
        this.setItemNoUpdate(slot, stack);
        this.markDirty();
    }

    default public void setItemNoUpdate(int slot, ItemStack stack) {
        this.getItems().set(slot, stack);
        if (stack.getCount() > this.getMaxCountPerStack()) {
            stack.setCount(this.getMaxCountPerStack());
        }
    }
}

