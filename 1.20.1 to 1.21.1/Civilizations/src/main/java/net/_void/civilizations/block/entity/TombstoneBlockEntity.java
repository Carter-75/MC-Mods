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
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2371
 *  net.minecraft.class_2487
 *  net.minecraft.class_2540
 *  net.minecraft.class_2561
 *  net.minecraft.class_2586
 *  net.minecraft.class_2680
 *  net.minecraft.class_3222
 *  org.jetbrains.annotations.Nullable
 */
package net._void.civilizations.block.entity;

import net._void.civilizations.block.entity.ImplementedInventory;
import net._void.civilizations.block.entity.ModBlockEntities;
import net._void.civilizations.screen.TombstoneScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.class_1262;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2371;
import net.minecraft.class_2487;
import net.minecraft.class_2540;
import net.minecraft.class_2561;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_3222;
import org.jetbrains.annotations.Nullable;

public class TombstoneBlockEntity
extends class_2586
implements ExtendedScreenHandlerFactory,
ImplementedInventory {
    private final class_2371<class_1799> inventory = class_2371.method_10213((int)54, (Object)class_1799.field_8037);

    public TombstoneBlockEntity(class_2338 pos, class_2680 state) {
        super(ModBlockEntities.TOMBSTONE_BLOCK_ENTITY, pos, state);
    }

    public void writeScreenOpeningData(class_3222 player, class_2540 buf) {
        buf.method_10807(this.field_11867);
    }

    public class_2561 method_5476() {
        return class_2561.method_43470((String)"Tombstone");
    }

    @Override
    public class_2371<class_1799> getItems() {
        return this.inventory;
    }

    protected void method_11007(class_2487 nbt) {
        super.method_11007(nbt);
        class_1262.method_5426((class_2487)nbt, this.inventory);
    }

    public void method_11014(class_2487 nbt) {
        super.method_11014(nbt);
        class_1262.method_5429((class_2487)nbt, this.inventory);
    }

    @Nullable
    public class_1703 createMenu(int syncId, class_1661 playerInventory, class_1657 player) {
        return new TombstoneScreenHandler(syncId, playerInventory, this);
    }

    public void tick(class_1937 world, class_2338 pos, class_2680 state) {
        if (world.method_8608()) {
            return;
        }
    }
}

