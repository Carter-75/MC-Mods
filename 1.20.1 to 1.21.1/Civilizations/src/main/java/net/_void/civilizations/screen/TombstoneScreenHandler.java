/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1263
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1703
 *  net.minecraft.class_1735
 *  net.minecraft.class_1799
 *  net.minecraft.class_2540
 *  net.minecraft.class_2586
 */
package net._void.civilizations.screen;

import net._void.civilizations.screen.ModScreenHandlers;
import net.minecraft.class_1263;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1735;
import net.minecraft.class_1799;
import net.minecraft.class_2540;
import net.minecraft.class_2586;

public class TombstoneScreenHandler
extends class_1703 {
    private static final int NUM_COLUMNS = 9;
    private final class_1263 inventory;
    private final int rows = 6;

    public TombstoneScreenHandler(int syncId, class_1661 playerInventory, class_2540 packetByteBuf) {
        this(syncId, playerInventory, playerInventory.field_7546.method_37908().method_8321(packetByteBuf.method_10811()));
    }

    public TombstoneScreenHandler(int syncId, class_1661 playerInventory, class_2586 blockEntity) {
        super(ModScreenHandlers.TOMBSTONE_SCREEN_HANDLER, syncId);
        int k;
        int j;
        TombstoneScreenHandler.method_17359((class_1263)((class_1263)blockEntity), (int)54);
        this.inventory = (class_1263)blockEntity;
        this.inventory.method_5435(playerInventory.field_7546);
        int i = (this.rows - 4) * 18;
        for (j = 0; j < this.rows; ++j) {
            for (k = 0; k < 9; ++k) {
                this.method_7621(new class_1735(this.inventory, k + j * 9, 8 + k * 18, 18 + j * 18));
            }
        }
        for (j = 0; j < 3; ++j) {
            for (k = 0; k < 9; ++k) {
                this.method_7621(new class_1735((class_1263)playerInventory, k + j * 9 + 9, 8 + k * 18, 103 + j * 18 + i));
            }
        }
        for (j = 0; j < 9; ++j) {
            this.method_7621(new class_1735((class_1263)playerInventory, j, 8 + j * 18, 161 + i));
        }
    }

    public boolean method_7597(class_1657 player) {
        return this.inventory.method_5443(player);
    }

    public class_1799 method_7601(class_1657 player, int slot) {
        class_1799 itemStack = class_1799.field_8037;
        class_1735 slot2 = (class_1735)this.field_7761.get(slot);
        if (slot2 != null && slot2.method_7681()) {
            class_1799 itemStack2 = slot2.method_7677();
            itemStack = itemStack2.method_7972();
            if (slot < this.rows * 9 ? !this.method_7616(itemStack2, this.rows * 9, this.field_7761.size(), true) : !this.method_7616(itemStack2, 0, this.rows * 9, false)) {
                return class_1799.field_8037;
            }
            if (itemStack2.method_7960()) {
                slot2.method_48931(class_1799.field_8037);
            } else {
                slot2.method_7668();
            }
        }
        return itemStack;
    }

    public void method_7595(class_1657 player) {
        super.method_7595(player);
        this.inventory.method_5432(player);
    }

    public class_1263 getInventory() {
        return this.inventory;
    }

    public int getRows() {
        return this.rows;
    }
}

