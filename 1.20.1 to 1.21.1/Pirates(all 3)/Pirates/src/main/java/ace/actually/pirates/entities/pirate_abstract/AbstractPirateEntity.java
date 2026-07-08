/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1266
 *  net.minecraft.class_1297
 *  net.minecraft.class_1297$class_5529
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1315
 *  net.minecraft.class_1352
 *  net.minecraft.class_1361
 *  net.minecraft.class_1376
 *  net.minecraft.class_1588
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2487
 *  net.minecraft.class_3730
 *  net.minecraft.class_5425
 *  org.valkyrienskies.mod.common.VSGameUtilsKt
 */
package ace.actually.pirates.entities.pirate_abstract;

import ace.actually.pirates.util.DisarmUtils;
import net.minecraft.class_1266;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1315;
import net.minecraft.class_1352;
import net.minecraft.class_1361;
import net.minecraft.class_1376;
import net.minecraft.class_1588;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2487;
import net.minecraft.class_3730;
import net.minecraft.class_5425;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

public abstract class AbstractPirateEntity
extends class_1588 {
    protected class_2338 blockToDisable;

    protected AbstractPirateEntity(class_1299<? extends class_1588> entityType, class_1937 world, class_2338 blockToDisable) {
        super(entityType, world);
        this.blockToDisable = blockToDisable;
    }

    public boolean method_5947() {
        return true;
    }

    public class_1315 method_5943(class_5425 world, class_1266 difficulty, class_3730 spawnReason, class_1315 entityData, class_2487 entityTag) {
        entityData = super.method_5943(world, difficulty, spawnReason, entityData, entityTag);
        this.method_5964(this.field_5974, difficulty);
        DisarmUtils.rearm(this.method_37908(), this.blockToDisable);
        this.method_5971();
        return entityData;
    }

    protected void method_5959() {
        super.method_5959();
        this.field_6201.method_6277(6, (class_1352)new class_1361((class_1308)this, class_1657.class, 200.0f));
        this.field_6201.method_6277(6, (class_1352)new class_1376((class_1308)this));
    }

    public void method_5650(class_1297.class_5529 reason) {
        DisarmUtils.disarm(this.method_37908(), this.blockToDisable);
        super.method_5650(reason);
    }

    public boolean isOnShip() {
        return VSGameUtilsKt.getShipManaging((class_1297)this) != null;
    }

    public void method_5652(class_2487 nbt) {
        super.method_5652(nbt);
        nbt.method_10569("BlockToDisableX", this.blockToDisable.method_10263());
        nbt.method_10569("BlockToDisableY", this.blockToDisable.method_10264());
        nbt.method_10569("BlockToDisableZ", this.blockToDisable.method_10260());
    }

    public void method_5749(class_2487 nbt) {
        super.method_5749(nbt);
        if (nbt.method_10545("BlockToDisableX") && nbt.method_10545("BlockToDisableY") && nbt.method_10545("BlockToDisableZ")) {
            int x = nbt.method_10550("BlockToDisableX");
            int y = nbt.method_10550("BlockToDisableY");
            int z = nbt.method_10550("BlockToDisableZ");
            this.blockToDisable = new class_2338(x, y, z);
        }
    }
}

