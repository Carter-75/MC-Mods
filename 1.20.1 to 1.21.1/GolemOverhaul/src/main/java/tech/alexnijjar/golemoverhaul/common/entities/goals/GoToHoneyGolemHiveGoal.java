/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1352
 *  net.minecraft.class_1937
 *  net.minecraft.class_3218
 *  net.minecraft.class_4466
 *  org.jetbrains.annotations.Nullable
 */
package tech.alexnijjar.golemoverhaul.common.entities.goals;

import java.util.UUID;
import net.minecraft.class_1297;
import net.minecraft.class_1352;
import net.minecraft.class_1937;
import net.minecraft.class_3218;
import net.minecraft.class_4466;
import org.jetbrains.annotations.Nullable;
import tech.alexnijjar.golemoverhaul.common.entities.AdditionalBeeData;
import tech.alexnijjar.golemoverhaul.common.entities.golems.HoneyGolem;
import tech.alexnijjar.golemoverhaul.mixins.common.BeeAccessor;

public class GoToHoneyGolemHiveGoal
extends class_1352 {
    private final class_4466 bee;
    private final BeeAccessor beeAccessor;
    private int travellingTicks;
    @Nullable
    private HoneyGolem hive;

    public GoToHoneyGolemHiveGoal(class_4466 bee) {
        this.bee = bee;
        this.beeAccessor = (BeeAccessor)bee;
    }

    public boolean method_6264() {
        if (!this.bee.method_29511() && !this.bee.method_18410() && this.beeAccessor.invokeWantsToEnterHive()) {
            HoneyGolem golem = this.hive == null ? this.findHive() : this.hive;
            return golem != null && !golem.method_29504() && golem.canPutBee();
        }
        return false;
    }

    public void method_6269() {
        this.travellingTicks = 0;
        this.hive = this.findHive();
    }

    public void method_6270() {
        this.travellingTicks = 0;
        this.bee.method_5942().method_6340();
        this.bee.method_5942().method_23965();
        this.hive = null;
    }

    public void method_6268() {
        if (this.hive == null) {
            return;
        }
        if (this.bee.method_5739((class_1297)this.hive) < 2.0f) {
            this.hive.putBee(this.bee);
            this.method_6270();
        } else {
            ++this.travellingTicks;
            if (this.travellingTicks > this.method_38847(600)) {
                this.method_6270();
            } else {
                this.bee.method_5942().method_6335((class_1297)this.hive, 1.0);
            }
        }
    }

    @Nullable
    private HoneyGolem findHive() {
        class_3218 level;
        class_1297 class_12972;
        class_1937 class_19372;
        UUID owner = ((AdditionalBeeData)this.bee).golemoverhaul$getOwner();
        if (owner != null && (class_19372 = this.bee.method_37908()) instanceof class_3218 && (class_12972 = (level = (class_3218)class_19372).method_14190(owner)) instanceof HoneyGolem) {
            HoneyGolem golem = (HoneyGolem)class_12972;
            return golem;
        }
        return null;
    }
}

