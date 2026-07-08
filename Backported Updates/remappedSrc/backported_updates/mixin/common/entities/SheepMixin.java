/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1299
 *  net.minecraft.class_1309
 *  net.minecraft.class_1472
 *  net.minecraft.class_1767
 *  net.minecraft.class_1937
 *  net.minecraft.class_5819
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package backported_updates.mixin.common.entities;

import backported.updates.content.common.level.entities.animal.SheepColorSpawnRules;
import backported_updates.mixin.common.entities.MobMixin;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1472;
import net.minecraft.class_1767;
import net.minecraft.class_1937;
import net.minecraft.class_5819;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={class_1472.class})
public abstract class SheepMixin
extends MobMixin {
    protected SheepMixin(class_1299<? extends class_1309> entityType, class_1937 level) {
        super(entityType, level);
    }

    @Redirect(method={"finalizeSpawn"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/animal/Sheep;getRandomSheepColor(Lnet/minecraft/util/RandomSource;)Lnet/minecraft/world/item/DyeColor;"))
    private class_1767 vb$updateColors(class_5819 random) {
        class_1767 originalColor = class_1472.method_6632((class_5819)random);
        return SheepColorSpawnRules.getRandomSheepColor(originalColor, this.method_37908(), this.method_24515(), random);
    }
}

