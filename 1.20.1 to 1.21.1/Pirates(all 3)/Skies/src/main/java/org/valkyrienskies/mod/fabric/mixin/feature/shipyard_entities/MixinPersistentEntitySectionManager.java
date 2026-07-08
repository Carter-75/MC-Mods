/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_5573
 *  net.minecraft.class_5579
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.ModifyArg
 */
package org.valkyrienskies.mod.fabric.mixin.feature.shipyard_entities;

import java.util.function.LongPredicate;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_5573;
import net.minecraft.class_5579;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.valkyrienskies.mod.mixinducks.world.OfLevel;

@Mixin(value={class_5579.class})
public abstract class MixinPersistentEntitySectionManager
implements OfLevel {
    @Shadow
    @Final
    class_5573<class_1297> field_27265;
    @Unique
    private class_1937 valkyrienskies$level;

    @Override
    public class_1937 getLevel() {
        return this.valkyrienskies$level;
    }

    @Override
    public void setLevel(class_1937 level) {
        this.valkyrienskies$level = level;
        ((OfLevel)this.field_27265).setLevel(level);
    }

    @ModifyArg(method={"processUnloads"}, at=@At(target="Lit/unimi/dsi/fastutil/longs/LongSet;removeIf(Ljava/uti l/function/LongPredicate;)Z", value="INVOKE"))
    private LongPredicate processUnloads_catchException(LongPredicate par1) {
        return l2 -> {
            try {
                return par1.test(l2);
            }
            catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        };
    }
}

