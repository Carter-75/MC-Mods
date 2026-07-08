/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2338
 *  net.minecraft.class_2487
 *  net.minecraft.class_2586
 *  net.minecraft.class_2591
 *  net.minecraft.class_2596
 *  net.minecraft.class_2602
 *  net.minecraft.class_2622
 *  net.minecraft.class_2680
 *  org.jetbrains.annotations.Nullable
 */
package ace.actually.pirates.blocks.entity;

import ace.actually.pirates.Pirates;
import net.minecraft.class_2338;
import net.minecraft.class_2487;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_2596;
import net.minecraft.class_2602;
import net.minecraft.class_2622;
import net.minecraft.class_2680;
import org.jetbrains.annotations.Nullable;

public class ShipIdBlockEntity
extends class_2586 {
    private String shipName = "";

    public ShipIdBlockEntity(class_2338 pos, class_2680 state) {
        super((class_2591)Pirates.SHIP_ID_BLOCK_ENTITY.get(), pos, state);
    }

    protected void method_11007(class_2487 nbt) {
        nbt.method_10582("shipName", this.shipName);
        super.method_11007(nbt);
    }

    public void method_11014(class_2487 nbt) {
        super.method_11014(nbt);
        this.shipName = nbt.method_10558("shipName");
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
        this.method_5431();
    }

    public String getShipName() {
        return this.shipName;
    }

    public class_2487 method_16887() {
        return this.method_38244();
    }

    @Nullable
    public class_2596<class_2602> method_38235() {
        return class_2622.method_38585((class_2586)this);
    }
}

