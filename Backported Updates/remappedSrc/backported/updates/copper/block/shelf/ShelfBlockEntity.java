/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1262
 *  net.minecraft.class_1263
 *  net.minecraft.class_1278
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2371
 *  net.minecraft.class_2487
 *  net.minecraft.class_2586
 *  net.minecraft.class_2596
 *  net.minecraft.class_2602
 *  net.minecraft.class_2622
 *  net.minecraft.class_2680
 *  net.minecraft.class_7225$class_7874
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.copper.block.shelf;

import backported.updates.copper.block.shelf.ListBackedContainer;
import backported.updates.copper.block.shelf.ShelfBlock;
import backported.updates.copper.registry.ModBlockEntities;
import net.minecraft.class_1262;
import net.minecraft.class_1263;
import net.minecraft.class_1278;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2371;
import net.minecraft.class_2487;
import net.minecraft.class_2586;
import net.minecraft.class_2596;
import net.minecraft.class_2602;
import net.minecraft.class_2622;
import net.minecraft.class_2680;
import net.minecraft.class_7225;
import org.jetbrains.annotations.Nullable;

public class ShelfBlockEntity
extends class_2586
implements ListBackedContainer,
class_1278 {
    public static final int MAX_ITEMS = 3;
    private static final String ITEMS_TAG = "Items";
    private static final String ALIGN_ITEMS_TO_BOTTOM_TAG = "align_items_to_bottom";
    private static final int[] SLOTS = new int[]{0, 1, 2};
    private final class_2371<class_1799> items = class_2371.method_10213((int)3, (Object)class_1799.field_8037);
    private boolean alignItemsToBottom = false;

    public ShelfBlockEntity(class_2338 pos, class_2680 state) {
        super(ModBlockEntities.SHELF_BLOCK_ENTITY.get(), pos, state);
    }

    @Override
    public class_2371<class_1799> getItems() {
        return this.items;
    }

    public boolean method_5443(class_1657 player) {
        return class_1263.method_49105((class_2586)this, (class_1657)player);
    }

    public class_1799 swapItemNoUpdate(int slot, class_1799 stack) {
        class_1799 oldItem = this.method_5441(slot);
        this.setItemNoUpdate(slot, stack.method_7972());
        return oldItem;
    }

    public void method_5431() {
        super.method_5431();
        if (this.field_11863 != null && !this.field_11863.method_8608()) {
            this.field_11863.method_8413(this.method_11016(), this.method_11010(), this.method_11010(), 3);
        }
    }

    protected void method_11007(class_2487 tag, class_7225.class_7874 registries) {
        super.method_11007(tag, registries);
        class_1262.method_5427((class_2487)tag, this.items, (boolean)true, (class_7225.class_7874)registries);
        tag.method_10556(ALIGN_ITEMS_TO_BOTTOM_TAG, this.alignItemsToBottom);
    }

    protected void method_11014(class_2487 tag, class_7225.class_7874 registries) {
        super.method_11014(tag, registries);
        this.items.clear();
        class_1262.method_5429((class_2487)tag, this.items, (class_7225.class_7874)registries);
        this.alignItemsToBottom = tag.method_10577(ALIGN_ITEMS_TO_BOTTOM_TAG);
    }

    @Nullable
    public class_2596<class_2602> method_38235() {
        return class_2622.method_38585((class_2586)this);
    }

    public class_2487 method_16887(class_7225.class_7874 registries) {
        class_2487 tag = new class_2487();
        class_1262.method_5427((class_2487)tag, this.items, (boolean)true, (class_7225.class_7874)registries);
        tag.method_10556(ALIGN_ITEMS_TO_BOTTOM_TAG, this.alignItemsToBottom);
        return tag;
    }

    public boolean getAlignItemsToBottom() {
        return this.alignItemsToBottom;
    }

    public void setAlignItemsToBottom(boolean alignItemsToBottom) {
        this.alignItemsToBottom = alignItemsToBottom;
        this.method_5431();
    }

    public float getVisualRotationYInDegrees() {
        return ((class_2350)this.method_11010().method_11654(ShelfBlock.FACING)).method_10153().method_10144();
    }

    public int[] method_5494(class_2350 side) {
        return SLOTS;
    }

    public boolean method_5492(int slot, class_1799 stack, @Nullable class_2350 side) {
        class_1799 existing = this.method_5438(slot);
        if (existing.method_7960()) {
            for (int i = 0; i < slot; ++i) {
                class_1799 prev = this.method_5438(i);
                if (prev.method_7960()) {
                    return false;
                }
                if (!class_1799.method_31577((class_1799)prev, (class_1799)stack) || prev.method_7947() >= prev.method_7914()) continue;
                return false;
            }
            return true;
        }
        return class_1799.method_31577((class_1799)existing, (class_1799)stack) && existing.method_7947() < existing.method_7914();
    }

    public boolean method_5493(int slot, class_1799 stack, class_2350 side) {
        for (int i = 2; i > slot; --i) {
            if (this.method_5438(i).method_7960()) continue;
            return false;
        }
        return true;
    }

    public int method_5444() {
        return 64;
    }
}

