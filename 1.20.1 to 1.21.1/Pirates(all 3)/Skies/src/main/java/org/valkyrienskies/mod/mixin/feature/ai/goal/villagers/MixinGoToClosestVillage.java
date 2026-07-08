/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  net.minecraft.class_1646
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_4076
 *  net.minecraft.class_4153
 *  net.minecraft.class_4458
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.feature.ai.goal.villagers;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.class_1646;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_4076;
import net.minecraft.class_4153;
import net.minecraft.class_4458;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={class_4458.class})
public class MixinGoToClosestVillage {
    @WrapOperation(method={"method_46937"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/ai/village/poi/PoiManager;sectionsToVillage(Lnet/minecraft/core/SectionPos;)I", ordinal=0)})
    private static int onSectionsToVillageInitial(class_4153 poiManager, class_4076 sectionPos, Operation<Integer> original, @Local class_1646 villager) {
        int[] currentLevels = new int[]{(Integer)original.call(new Object[]{poiManager, sectionPos})};
        VSGameUtilsKt.transformToNearbyShipsAndWorld(villager.method_37908(), villager.method_23317(), villager.method_23318(), villager.method_23321(), 100.0, (x, y, z) -> {
            currentLevels[0] = Math.min(currentLevels[0], (Integer)original.call(new Object[]{poiManager, class_4076.method_18682((class_2338)class_2338.method_49637((double)x, (double)y, (double)z))}));
        });
        return currentLevels[0];
    }

    @WrapOperation(method={"method_46937"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/ai/village/poi/PoiManager;sectionsToVillage(Lnet/minecraft/core/SectionPos;)I", ordinal=1)})
    private static int onSectionsToVillageVec3(class_4153 poiManager, class_4076 sectionPos, Operation<Integer> original, @Local class_1646 villager, @Local(ordinal=1) class_243 vec32) {
        int[] currentLevels = new int[]{(Integer)original.call(new Object[]{poiManager, sectionPos})};
        VSGameUtilsKt.transformToNearbyShipsAndWorld(villager.method_37908(), vec32.field_1352, vec32.field_1351, vec32.field_1350, 100.0, (x, y, z) -> {
            currentLevels[0] = Math.min(currentLevels[0], (Integer)original.call(new Object[]{poiManager, class_4076.method_18682((class_2338)class_2338.method_49637((double)x, (double)y, (double)z))}));
        });
        return currentLevels[0];
    }
}

