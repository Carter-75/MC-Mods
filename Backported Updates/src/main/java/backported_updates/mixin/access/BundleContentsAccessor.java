/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 *  net.minecraft.component.type.BundleContentsComponent
 *  org.apache.commons.lang3.math.Fraction
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package backported_updates.mixin.access;

import net.minecraft.item.ItemStack;
import net.minecraft.component.type.BundleContentsComponent;
import org.apache.commons.lang3.math.Fraction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={BundleContentsComponent.class})
public interface BundleContentsAccessor {
    @Invoker
    public static Fraction callGetOccupancy(ItemStack stack) {
        throw new UnsupportedOperationException();
    }
}

