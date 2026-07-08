/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.item.ItemStack
 *  net.minecraft.component.type.BundleContentsComponent
 *  net.minecraft.component.type.BundleContentsComponent$Builder
 *  org.apache.commons.lang3.math.Fraction
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.common.item;

import backported.updates.content.common.api.bundle.BundleFeatures;
import backported.updates.content.common.api.bundle.IBundle;
import backported_updates.mixin.access.BundleContentsAccessor;
import java.util.List;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.slot.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.component.type.BundleContentsComponent;
import org.apache.commons.lang3.math.Fraction;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={BundleContentsComponent.Builder.class})
public abstract class MutableBundleContentsMixin
implements IBundle.Mutable {
    @Shadow
    @Final
    private List<ItemStack> stacks;
    @Shadow
    private Fraction occupancy;
    @Unique
    private int selectedItem = -1;

    @Shadow
    protected abstract int getMaxAllowed(ItemStack var1);

    @Shadow
    public abstract int add(ItemStack var1);

    @Inject(method={"<init>"}, at={@At(value="RETURN")})
    private void vb$onInit(BundleContentsComponent contents, CallbackInfo ci) {
        if (BundleFeatures.onBundleUpdate()) {
            this.selectedItem = ((IBundle)(Object)contents).getSelectedItem();
        }
    }

    @Inject(method={"add"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$onTryTransfer(Slot slot, PlayerEntity player, CallbackInfoReturnable<Integer> cir) {
        if (!BundleFeatures.onBundleUpdate()) {
            return;
        }
        ItemStack stack = slot.getStack();
        int amount = this.getMaxAllowed(stack);
        int result = BundleFeatures.canItemBeInBundle(stack) ? this.add(slot.takeStackRange(stack.getCount(), amount, player)) : 0;
        cir.setReturnValue(result);
    }

    @Override
    public void toggleSelectedItem(int index) {
        this.selectedItem = this.selectedItem != index && !this.indexIsOutsideAllowedBounds(index) ? index : -1;
    }

    @Override
    public boolean indexIsOutsideAllowedBounds(int index) {
        return index < 0 || index >= this.stacks.size();
    }

    @Inject(method={"removeFirst"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$onRemoveOne(CallbackInfoReturnable<ItemStack> cir) {
        if (!BundleFeatures.onBundleUpdate()) {
            return;
        }
        if (!this.stacks.isEmpty()) {
            int index = this.indexIsOutsideAllowedBounds(this.selectedItem) ? 0 : this.selectedItem;
            ItemStack stack = this.stacks.remove(index).copy();
            this.occupancy = this.occupancy.subtract(BundleContentsAccessor.callGetOccupancy(stack).multiplyBy(Fraction.getFraction((int)stack.getCount(), (int)1)));
            this.toggleSelectedItem(-1);
            cir.setReturnValue(stack);
        }
    }

    @Inject(method={"build"}, at={@At(value="RETURN")}, cancellable=true)
    private void vb$onToImmutable(CallbackInfoReturnable<BundleContentsComponent> cir) {
        if (!BundleFeatures.onBundleUpdate()) {
            return;
        }
        BundleContentsComponent original = (BundleContentsComponent)cir.getReturnValue();
        ((IBundle)(Object)original).setSelectedItem(this.selectedItem);
        cir.setReturnValue(original);
    }
}

