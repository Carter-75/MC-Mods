/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1335$class_1336
 *  net.minecraft.class_1352
 *  net.minecraft.class_1352$class_4134
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_243
 *  net.minecraft.class_4051
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.content.common.level.entities.happyghast;

import backported.updates.content.common.level.entities.happyghast.HappyGhast;
import java.util.EnumSet;
import java.util.function.Predicate;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1335;
import net.minecraft.class_1352;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_243;
import net.minecraft.class_4051;
import org.jetbrains.annotations.Nullable;

public class HappyGhastTemptGoal
extends class_1352 {
    private static final class_4051 TEMP_TARGETING = class_4051.method_36626().method_18418(10.0).method_36627();
    private final class_4051 targetingConditions;
    protected final HappyGhast ghast;
    private final double speedModifier;
    private double px;
    private double py;
    private double pz;
    private double pRotX;
    private double pRotY;
    @Nullable
    protected class_1657 player;
    private int calmDown;
    private final Predicate<class_1799> items;
    private final boolean canScare;
    private final double stopDistance;

    public HappyGhastTemptGoal(HappyGhast ghast, double speedModifier, Predicate<class_1799> items, boolean canScare, double stopDistance) {
        this.ghast = ghast;
        this.speedModifier = speedModifier;
        this.items = items;
        this.canScare = canScare;
        this.stopDistance = stopDistance;
        this.method_6265(EnumSet.of(class_1352.class_4134.field_18405, class_1352.class_4134.field_18406));
        this.targetingConditions = TEMP_TARGETING.method_33335().method_18420(this::shouldFollow);
    }

    public boolean method_6264() {
        if (this.calmDown > 0) {
            --this.calmDown;
            return false;
        }
        this.player = this.ghast.method_37908().method_18462(this.targetingConditions.method_18418(16.0), (class_1309)this.ghast);
        return this.player != null;
    }

    private boolean shouldFollow(class_1309 entity) {
        return this.items.test(entity.method_6047()) || this.items.test(entity.method_6079());
    }

    public boolean method_6266() {
        if (this.canScare() && this.player != null) {
            if (this.ghast.method_5858((class_1297)this.player) < 36.0) {
                if (this.player.method_5649(this.px, this.py, this.pz) > 0.01) {
                    return false;
                }
                if (Math.abs((double)this.player.method_36455() - this.pRotX) > 5.0 || Math.abs((double)this.player.method_36454() - this.pRotY) > 5.0) {
                    return false;
                }
            } else {
                this.px = this.player.method_23317();
                this.py = this.player.method_23318();
                this.pz = this.player.method_23321();
            }
            this.pRotX = this.player.method_36455();
            this.pRotY = this.player.method_36454();
        }
        return this.method_6264();
    }

    protected boolean canScare() {
        return this.canScare;
    }

    public void method_6269() {
        if (this.player == null) {
            return;
        }
        this.px = this.player.method_23317();
        this.py = this.player.method_23318();
        this.pz = this.player.method_23321();
    }

    public void method_6270() {
        this.player = null;
        this.ghast.method_5942().method_6340();
        this.calmDown = HappyGhastTemptGoal.method_38848((int)100);
    }

    public void method_6268() {
        if (this.player == null) {
            return;
        }
        this.ghast.method_5988().method_6226((class_1297)this.player, (float)(this.ghast.method_5986() + 20), (float)this.ghast.method_5978());
        if (this.ghast.method_5858((class_1297)this.player) < this.stopDistance * this.stopDistance) {
            this.ghast.method_5962().field_6374 = class_1335.class_1336.field_6377;
        } else {
            class_243 vec3 = this.player.method_33571().method_1020(this.ghast.method_19538()).method_1021(this.ghast.method_59922().method_43058()).method_1019(this.ghast.method_19538());
            this.ghast.method_5962().method_6239(vec3.field_1352, vec3.field_1351, vec3.field_1350, this.speedModifier);
        }
    }
}

