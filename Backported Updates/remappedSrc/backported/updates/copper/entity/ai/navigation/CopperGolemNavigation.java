/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_11
 *  net.minecraft.class_1308
 *  net.minecraft.class_1409
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2818
 *  net.minecraft.class_4076
 */
package backported.updates.copper.entity.ai.navigation;

import java.util.Set;
import net.minecraft.class_11;
import net.minecraft.class_1308;
import net.minecraft.class_1409;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2818;
import net.minecraft.class_4076;

public class CopperGolemNavigation
extends class_1409 {
    private float requiredPathLength = 16.0f;
    private boolean canPathToTargetsBelowSurface = false;

    public CopperGolemNavigation(class_1308 mob, class_1937 level) {
        super(mob, level);
    }

    public void setRequiredPathLength(float requiredPathLength) {
        this.requiredPathLength = requiredPathLength;
    }

    public float getRequiredPathLength() {
        return this.requiredPathLength;
    }

    public void setCanPathToTargetsBelowSurface(boolean canPathToTargetsBelowSurface) {
        this.canPathToTargetsBelowSurface = canPathToTargetsBelowSurface;
    }

    public boolean canPathToTargetsBelowSurface() {
        return this.canPathToTargetsBelowSurface;
    }

    public class_11 method_6348(class_2338 pos, int accuracy) {
        if (!this.canPathToTargetsBelowSurface) {
            return super.method_6348(pos, accuracy);
        }
        class_2818 chunk = this.field_6677.method_8398().method_21730(class_4076.method_18675((int)pos.method_10263()), class_4076.method_18675((int)pos.method_10260()));
        if (chunk == null) {
            return null;
        }
        return this.createPathDirect(pos, accuracy);
    }

    private class_11 createPathDirect(class_2338 pos, int accuracy) {
        return super.method_35142(Set.of(pos), 8, false, accuracy);
    }
}

