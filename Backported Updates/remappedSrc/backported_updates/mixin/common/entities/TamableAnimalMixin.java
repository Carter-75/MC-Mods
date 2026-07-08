/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1299
 *  net.minecraft.class_1309
 *  net.minecraft.class_1321
 *  net.minecraft.class_1937
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 */
package backported_updates.mixin.common.entities;

import backported_updates.mixin.common.entities.MobMixin;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1321;
import net.minecraft.class_1937;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value={class_1321.class})
public abstract class TamableAnimalMixin
extends MobMixin {
    @Shadow
    public abstract boolean method_6181();

    protected TamableAnimalMixin(class_1299<? extends class_1309> entityType, class_1937 level) {
        super(entityType, level);
    }
}

