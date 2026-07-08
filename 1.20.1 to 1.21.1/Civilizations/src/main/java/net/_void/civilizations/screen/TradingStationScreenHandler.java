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
 *  net.minecraft.class_3913
 *  net.minecraft.class_3919
 */
package net._void.civilizations.screen;

import net._void.civilizations.block.entity.TradingStationBlockEntity;
import net._void.civilizations.screen.ModScreenHandlers;
import net.minecraft.class_1263;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1735;
import net.minecraft.class_1799;
import net.minecraft.class_2540;
import net.minecraft.class_2586;
import net.minecraft.class_3913;
import net.minecraft.class_3919;

public class TradingStationScreenHandler
extends class_1703 {
    private final class_1263 inventory;
    private final class_3913 propertyDelegate;
    public final TradingStationBlockEntity blockEntity;

    public TradingStationScreenHandler(int syncId, class_1661 inventory, class_2540 buf) {
        this(syncId, inventory, inventory.field_7546.method_37908().method_8321(buf.method_10811()), (class_3913)new class_3919(1));
    }

    public TradingStationScreenHandler(int syncId, class_1661 playerInventory, class_2586 blockEntity, class_3913 arrayPropertyDelegate) {
        super(ModScreenHandlers.TRADING_STATION_SCREEN_HANDLER, syncId);
        TradingStationScreenHandler.method_17359((class_1263)((class_1263)blockEntity), (int)4);
        this.inventory = (class_1263)blockEntity;
        this.inventory.method_5435(playerInventory.field_7546);
        this.propertyDelegate = arrayPropertyDelegate;
        this.blockEntity = (TradingStationBlockEntity)blockEntity;
        this.method_7621(new class_1735(this.inventory, 0, 10, 64));
        this.method_7621(new class_1735(this.inventory, 1, 64, 64){

            public boolean method_7680(class_1799 stack) {
                return false;
            }

            public void method_7667(class_1657 player, class_1799 stack) {
                super.method_7667(player, stack);
                TradingStationScreenHandler.this.transaction(0, "trade");
            }
        });
        this.method_7621(new class_1735(this.inventory, 2, 97, 64));
        this.method_7621(new class_1735(this.inventory, 3, 151, 64){

            public boolean method_7680(class_1799 stack) {
                return false;
            }

            public void method_7667(class_1657 player, class_1799 stack) {
                super.method_7667(player, stack);
                TradingStationScreenHandler.this.transaction(2, "quest");
            }
        });
        this.addPlayerInventory(playerInventory);
        this.addPlayerHotbar(playerInventory);
        this.method_17360(arrayPropertyDelegate);
    }

    public int getReputation() {
        return this.propertyDelegate.method_17390(0);
    }

    public void setReputation(int value) {
        this.propertyDelegate.method_17391(0, value);
    }

    public void transaction(int paymentIndex, String type) {
        if (type == "trade") {
            this.method_7611(paymentIndex).method_7677().method_7939(this.method_7611(paymentIndex).method_7677().method_7947() - 1);
        }
        if (type == "quest") {
            int paymentAmount = 0;
            switch (this.getReputation()) {
                case 0: {
                    paymentAmount = 10;
                    break;
                }
                case 10: {
                    paymentAmount = 64;
                    break;
                }
                case 20: {
                    paymentAmount = 32;
                    break;
                }
                case 30: {
                    paymentAmount = 1;
                    break;
                }
                case 40: {
                    paymentAmount = 32;
                    break;
                }
                case 50: {
                    paymentAmount = 32;
                    break;
                }
                case 60: {
                    paymentAmount = 40;
                    break;
                }
                case 70: {
                    paymentAmount = 16;
                    break;
                }
                case 80: {
                    paymentAmount = 4;
                }
            }
            if (this.getReputation() >= 90) {
                paymentAmount = 40;
            }
            this.method_7611(paymentIndex).method_7677().method_7939(this.method_7611(paymentIndex).method_7677().method_7947() - paymentAmount);
            this.setReputation(this.getReputation() + 10);
        }
    }

    public class_1799 method_7601(class_1657 player, int invSlot) {
        class_1799 newStack = class_1799.field_8037;
        class_1735 slot = (class_1735)this.field_7761.get(invSlot);
        if (invSlot == 1 && this.method_7611(1).method_7681()) {
            this.transaction(0, "trade");
        }
        if (invSlot == 3 && this.method_7611(3).method_7681()) {
            this.transaction(2, "quest");
        }
        if (slot != null && slot.method_7681()) {
            class_1799 originalStack = slot.method_7677();
            newStack = originalStack.method_7972();
            if (invSlot < this.inventory.method_5439() ? !this.method_7616(originalStack, this.inventory.method_5439(), this.field_7761.size(), true) : !this.method_7616(originalStack, 0, this.inventory.method_5439(), false)) {
                return class_1799.field_8037;
            }
            if (originalStack.method_7960()) {
                slot.method_48931(class_1799.field_8037);
            } else {
                slot.method_7668();
            }
        }
        return newStack;
    }

    public boolean method_7597(class_1657 player) {
        return this.inventory.method_5443(player);
    }

    private void addPlayerInventory(class_1661 playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.method_7621(new class_1735((class_1263)playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(class_1661 playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.method_7621(new class_1735((class_1263)playerInventory, i, 8 + i * 18, 142));
        }
    }
}

