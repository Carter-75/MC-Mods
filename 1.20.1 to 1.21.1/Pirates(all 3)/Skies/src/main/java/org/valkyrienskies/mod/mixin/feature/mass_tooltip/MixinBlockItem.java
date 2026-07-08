/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_124
 *  net.minecraft.class_1747
 *  net.minecraft.class_1799
 *  net.minecraft.class_1836
 *  net.minecraft.class_1937
 *  net.minecraft.class_2561
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  oshi.util.tuples.Pair
 */
package org.valkyrienskies.mod.mixin.feature.mass_tooltip;

import java.util.List;
import java.util.Objects;
import net.minecraft.class_124;
import net.minecraft.class_1747;
import net.minecraft.class_1799;
import net.minecraft.class_1836;
import net.minecraft.class_1937;
import net.minecraft.class_2561;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.mod.common.BlockStateInfo;
import org.valkyrienskies.mod.common.config.VSGameConfig;
import org.valkyrienskies.mod.mixinducks.feature.mass_tooltip.MassTooltipVisibility;
import oshi.util.tuples.Pair;

@Mixin(value={class_1747.class})
public class MixinBlockItem {
    @Inject(method={"appendHoverText"}, at={@At(value="HEAD")})
    private void ValkyrienSkies$addMassToTooltip(class_1799 itemStack, class_1937 level, List<class_2561> list, class_1836 tooltipFlag, CallbackInfo ci) {
        MassTooltipVisibility visibility = VSGameConfig.CLIENT.getTooltip().getMassTooltipVisibility();
        if (visibility.isVisible(tooltipFlag)) {
            try {
                class_1747 item = (class_1747)itemStack.method_7909();
                Double mass = (Double)Objects.requireNonNull(BlockStateInfo.INSTANCE.get(item.method_7711().method_9564())).getFirst();
                list.add((class_2561)class_2561.method_43471((String)"tooltip.valkyrienskies.mass").method_27693((String)(VSGameConfig.CLIENT.getTooltip().getUseImperialUnits() ? this.getImperialText(mass) : ": " + mass + "kg")).method_27692(class_124.field_1063));
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    @Unique
    private Pair<Integer, Integer> convertToImperial(double mass) {
        double ounces = mass * 35.274;
        double pounds = Math.floor(ounces / 16.0);
        return new Pair((Object)((int)pounds), (Object)((int)Math.floor((ounces / 16.0 - pounds) * 16.0)));
    }

    @Unique
    private String getImperialText(double mass) {
        Object impText = ": ";
        Pair<Integer, Integer> imperial = this.convertToImperial(mass);
        if ((Integer)imperial.getA() > 0) {
            impText = (String)impText + String.valueOf(imperial.getA());
            impText = (Integer)imperial.getA() == 1 ? (String)impText + "lb. " : (String)impText + "lbs. ";
        }
        if ((Integer)imperial.getB() > 0) {
            impText = (String)impText + String.valueOf(imperial.getB()) + "oz.";
        }
        return impText;
    }
}

