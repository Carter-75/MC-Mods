/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1352
 *  net.minecraft.class_4466
 *  org.jetbrains.annotations.Nullable
 */
package tech.alexnijjar.golemoverhaul.common.entities.goals;

import net.minecraft.class_1297;
import net.minecraft.class_1352;
import net.minecraft.class_4466;
import org.jetbrains.annotations.Nullable;
import tech.alexnijjar.golemoverhaul.common.entities.AdditionalBeeData;
import tech.alexnijjar.golemoverhaul.common.entities.golems.HoneyGolem;
import tech.alexnijjar.golemoverhaul.mixins.common.BeeAccessor;

public class LocateHoneyGolemHiveGoal
extends class_1352 {
    private final class_4466 bee;
    private final BeeAccessor beeAccessor;

    public LocateHoneyGolemHiveGoal(class_4466 bee) {
        this.bee = bee;
        this.beeAccessor = (BeeAccessor)bee;
    }

    public boolean method_6264() {
        return this.beeAccessor.getRemainingCooldownBeforeLocatingNewHive() < 20 && !((AdditionalBeeData)this.bee).golemoverhaul$hasGolemHive() && this.beeAccessor.invokeWantsToEnterHive();
    }

    public boolean method_6266() {
        return false;
    }

    public void method_6269() {
        this.beeAccessor.setRemainingCooldownBeforeLocatingNewHive(200);
        HoneyGolem golem = this.findHive();
        if (golem != null) {
            ((AdditionalBeeData)this.bee).golemoverhaul$setOwner(golem.method_5667());
        }
    }

    @Nullable
    private HoneyGolem findHive() {
        return this.bee.method_37908().method_18467(HoneyGolem.class, this.bee.method_5829().method_1014(128.0)).stream().min((g1, g2) -> Double.compare(this.bee.method_5739((class_1297)g1), this.bee.method_5739((class_1297)g2))).orElse(null);
    }
}

