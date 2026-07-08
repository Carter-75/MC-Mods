/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory
 *  net.minecraft.class_1262
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1703
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2371
 *  net.minecraft.class_2487
 *  net.minecraft.class_2540
 *  net.minecraft.class_2561
 *  net.minecraft.class_2586
 *  net.minecraft.class_2680
 *  net.minecraft.class_3222
 *  net.minecraft.class_3913
 *  org.jetbrains.annotations.Nullable
 */
package net._void.civilizations.block.entity;

import net._void.civilizations.block.entity.ImplementedInventory;
import net._void.civilizations.block.entity.ModBlockEntities;
import net._void.civilizations.item.ModItems;
import net._void.civilizations.screen.TradingStationScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.class_1262;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2371;
import net.minecraft.class_2487;
import net.minecraft.class_2540;
import net.minecraft.class_2561;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_3222;
import net.minecraft.class_3913;
import org.jetbrains.annotations.Nullable;

public class TradingStationBlockEntity
extends class_2586
implements ExtendedScreenHandlerFactory,
ImplementedInventory {
    private final class_2371<class_1799> inventory = class_2371.method_10213((int)4, (Object)class_1799.field_8037);
    public static int TRADE = 1;
    private static final int TRADE_INPUT = 0;
    private static final int TRADE_OUTPUT = 1;
    private static final int QUEST_INPUT = 2;
    private static final int QUEST_OUTPUT = 3;
    protected final class_3913 propertyDelegate = new class_3913(){

        public int method_17390(int index) {
            return switch (index) {
                case 0 -> TradingStationBlockEntity.this.reputation;
                default -> 0;
            };
        }

        public void method_17391(int index, int value) {
            switch (index) {
                case 0: {
                    TradingStationBlockEntity.this.reputation = value;
                }
            }
        }

        public int method_17389() {
            return 1;
        }
    };
    private int reputation = 0;

    public TradingStationBlockEntity(class_2338 pos, class_2680 state) {
        super(ModBlockEntities.TRADING_STATION_BLOCK_ENTITY, pos, state);
    }

    public void writeScreenOpeningData(class_3222 player, class_2540 buf) {
        buf.method_10807(this.field_11867);
    }

    public class_2561 method_5476() {
        return class_2561.method_43470((String)"Trading Station");
    }

    @Override
    public class_2371<class_1799> getItems() {
        return this.inventory;
    }

    protected void method_11007(class_2487 nbt) {
        super.method_11007(nbt);
        class_1262.method_5426((class_2487)nbt, this.inventory);
        nbt.method_10569("trading_station.reputation", this.reputation);
    }

    public void method_11014(class_2487 nbt) {
        super.method_11014(nbt);
        class_1262.method_5429((class_2487)nbt, this.inventory);
        this.reputation = nbt.method_10550("trading_station.reputation");
    }

    @Nullable
    public class_1703 createMenu(int syncId, class_1661 playerInventory, class_1657 player) {
        return new TradingStationScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    public void tick(class_1937 world, class_2338 pos, class_2680 state) {
        if (world.method_8608()) {
            return;
        }
        if (TRADE == 1 && this.isRightItemForTrade(TRADE)) {
            this.tradeResult(TRADE, world, pos, state);
        } else if (TRADE == 2 && this.isRightItemForTrade(TRADE)) {
            this.tradeResult(TRADE, world, pos, state);
        } else if (TRADE == 3 && this.isRightItemForTrade(TRADE)) {
            this.tradeResult(TRADE, world, pos, state);
        } else if (TRADE == 4 && this.isRightItemForTrade(TRADE)) {
            this.tradeResult(TRADE, world, pos, state);
        } else {
            this.tradeResult(-1, world, pos, state);
        }
        if (this.reputation == 0 && this.isRightItemForQuest(0)) {
            this.questResult(0, world, pos, state);
        } else if (this.reputation == 10 && this.isRightItemForQuest(10)) {
            this.questResult(10, world, pos, state);
        } else if (this.reputation == 20 && this.isRightItemForQuest(20)) {
            this.questResult(20, world, pos, state);
        } else if (this.reputation == 30 && this.isRightItemForQuest(30)) {
            this.questResult(30, world, pos, state);
        } else if (this.reputation == 40 && this.isRightItemForQuest(40)) {
            this.questResult(40, world, pos, state);
        } else if (this.reputation == 50 && this.isRightItemForQuest(50)) {
            this.questResult(50, world, pos, state);
        } else if (this.reputation == 60 && this.isRightItemForQuest(60)) {
            this.questResult(60, world, pos, state);
        } else if (this.reputation == 70 && this.isRightItemForQuest(70)) {
            this.questResult(70, world, pos, state);
        } else if (this.reputation == 80 && this.isRightItemForQuest(80)) {
            this.questResult(80, world, pos, state);
        } else if (this.reputation >= 90 && this.isRightItemForQuest(90)) {
            this.questResult(90, world, pos, state);
        } else {
            this.questResult(-1, world, pos, state);
        }
    }

    private boolean isRightItemForTrade(int trade) {
        boolean bl = false;
        switch (trade) {
            case 1: {
                bl = this.method_5438(0).method_7909() == class_1802.field_17528;
                break;
            }
            case 2: {
                bl = this.method_5438(0).method_7909() == class_1802.field_19060;
                break;
            }
            case 3: {
                bl = this.method_5438(0).method_7909() == ModItems.EGYPT_COIN;
                break;
            }
            case 4: {
                bl = this.method_5438(0).method_7909() == ModItems.EGYPT_COIN;
            }
        }
        return bl;
    }

    private void tradeResult(int trade, class_1937 world, class_2338 pos, class_2680 state) {
        switch (trade) {
            case 1: {
                this.method_5447(1, new class_1799((class_1935)ModItems.EGYPT_COIN, 1));
                break;
            }
            case 2: {
                this.method_5447(1, new class_1799((class_1935)ModItems.EGYPT_COIN, 1));
                break;
            }
            case 3: {
                this.method_5447(1, new class_1799((class_1935)ModItems.PAPYRUS, 1));
                break;
            }
            case 4: {
                this.method_5447(1, new class_1799((class_1935)class_1802.field_8397, 3));
                break;
            }
            case -1: {
                this.method_5447(1, class_1799.field_8037);
            }
        }
        TradingStationBlockEntity.method_31663((class_1937)world, (class_2338)pos, (class_2680)state);
    }

    private boolean isRightItemForQuest(int reputation) {
        boolean bl = false;
        switch (reputation) {
            case 0: {
                bl = this.method_5438(2).method_7909() == class_1802.field_17528 && this.method_5438(2).method_7947() >= 10;
                break;
            }
            case 10: {
                bl = this.method_5438(2).method_7909() == class_1802.field_20384 && this.method_5438(2).method_7947() >= 64;
                break;
            }
            case 20: {
                bl = this.method_5438(2).method_7909() == class_1802.field_8696 && this.method_5438(2).method_7947() >= 32;
                break;
            }
            case 30: {
                bl = this.method_5438(2).method_7909() == class_1802.field_42716 && this.method_5438(2).method_7947() >= 1;
                break;
            }
            case 40: {
                bl = this.method_5438(2).method_7909() == class_1802.field_8229 && this.method_5438(2).method_7947() >= 32;
                break;
            }
            case 50: {
                bl = this.method_5438(2).method_7909() == class_1802.field_27022 && this.method_5438(2).method_7947() >= 32;
                break;
            }
            case 60: {
                bl = this.method_5438(2).method_7909() == class_1802.field_8745 && this.method_5438(2).method_7947() >= 40;
                break;
            }
            case 70: {
                bl = this.method_5438(2).method_7909() == class_1802.field_20417 && this.method_5438(2).method_7947() >= 16;
                break;
            }
            case 80: {
                bl = this.method_5438(2).method_7909() == class_1802.field_8477 && this.method_5438(2).method_7947() >= 4;
                break;
            }
            case 90: {
                bl = this.method_5438(2).method_7909() == ModItems.EGYPT_COIN && this.method_5438(2).method_7947() >= 40;
            }
        }
        return bl;
    }

    private void questResult(int reputation, class_1937 world, class_2338 pos, class_2680 state) {
        switch (reputation) {
            case 0: {
                this.method_5447(3, new class_1799((class_1935)ModItems.EGYPT_COIN, 16));
                break;
            }
            case 10: {
                this.method_5447(3, new class_1799((class_1935)class_1802.field_8287, 32));
                break;
            }
            case 20: {
                this.method_5447(3, new class_1799((class_1935)class_1802.field_42689, 64));
                break;
            }
            case 30: {
                this.method_5447(3, new class_1799((class_1935)ModItems.EGYPT_COIN, 32));
                break;
            }
            case 40: {
                this.method_5447(3, new class_1799((class_1935)class_1802.field_8175, 1));
                break;
            }
            case 50: {
                this.method_5447(3, new class_1799((class_1935)class_1802.field_8463, 4));
                break;
            }
            case 60: {
                this.method_5447(3, new class_1799((class_1935)ModItems.EGYPT_COIN, 64));
                break;
            }
            case 70: {
                this.method_5447(3, new class_1799((class_1935)class_1802.field_41948, 4));
                break;
            }
            case 80: {
                this.method_5447(3, new class_1799((class_1935)class_1802.field_8288, 1));
                break;
            }
            case 90: {
                this.method_5447(3, new class_1799((class_1935)ModItems.EGYPT_KEY, 1));
                break;
            }
            case -1: {
                this.method_5447(3, class_1799.field_8037);
            }
        }
        TradingStationBlockEntity.method_31663((class_1937)world, (class_2338)pos, (class_2680)state);
    }
}

