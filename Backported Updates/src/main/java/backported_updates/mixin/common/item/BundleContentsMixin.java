/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.component.type.BundleContentsComponent
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 */
package backported_updates.mixin.common.item;

import backported.updates.content.common.api.bundle.IBundle;
import net.minecraft.component.type.BundleContentsComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={BundleContentsComponent.class})
public abstract class BundleContentsMixin
implements IBundle {
    @Unique
    private int selectedItem = -1;

    @Shadow
    public abstract int size();

    @Override
    public void setSelectedItem(int index) {
        this.selectedItem = index;
    }

    @Override
    public int getSelectedItem() {
        return this.selectedItem;
    }

    @Override
    public int getNumberOfItemsToShow() {
        int contents = this.size();
        int maxDisplay = contents > 12 ? 11 : 12;
        int remainder = contents % 4;
        int padding = remainder == 0 ? 0 : 4 - remainder;
        return Math.min(contents, maxDisplay - padding);
    }
}

