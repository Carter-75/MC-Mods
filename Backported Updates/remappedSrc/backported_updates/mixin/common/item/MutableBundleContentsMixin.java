/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_1735
 *  net.minecraft.class_1799
 *  net.minecraft.class_9276
 *  net.minecraft.class_9276$class_9277
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
import net.minecraft.class_1657;
import net.minecraft.class_1735;
import net.minecraft.class_1799;
import net.minecraft.class_9276;
import org.apache.commons.lang3.math.Fraction;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_9276.class_9277.class})
public abstract class MutableBundleContentsMixin
implements IBundle.Mutable {
    @Shadow
    @Final
    private List<class_1799> field_49296;
    @Shadow
    private Fraction field_49297;
    @Unique
    private int selectedItem = -1;

    @Shadow
    protected abstract int method_57436(class_1799 var1);

    @Shadow
    public abstract int method_57432(class_1799 var1);

    @Inject(method={"<init>"}, at={@At(value="RETURN")})
    private void vb$onInit(class_9276 contents, CallbackInfo ci) {
        if (BundleFeatures.onBundleUpdate()) {
            this.selectedItem = ((IBundle)contents).getSelectedItem();
        }
    }

    @Inject(method={"tryTransfer"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$onTryTransfer(class_1735 slot, class_1657 player, CallbackInfoReturnable<Integer> cir) {
        if (!BundleFeatures.onBundleUpdate()) {
            return;
        }
        class_1799 stack = slot.method_7677();
        int amount = this.method_57436(stack);
        int result = BundleFeatures.canItemBeInBundle(stack) ? this.method_57432(slot.method_32753(stack.method_7947(), amount, player)) : 0;
        cir.setReturnValue((Object)result);
    }

    @Override
    public void toggleSelectedItem(int index) {
        this.selectedItem = this.selectedItem != index && !this.indexIsOutsideAllowedBounds(index) ? index : -1;
    }

    @Override
    public boolean indexIsOutsideAllowedBounds(int index) {
        return index < 0 || index >= this.field_49296.size();
    }

    @Inject(method={"removeOne"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$onRemoveOne(CallbackInfoReturnable<class_1799> cir) {
        if (!BundleFeatures.onBundleUpdate()) {
            return;
        }
        if (!this.field_49296.isEmpty()) {
            int index = this.indexIsOutsideAllowedBounds(this.selectedItem) ? 0 : this.selectedItem;
            class_1799 stack = this.field_49296.remove(index).method_7972();
            this.field_49297 = this.field_49297.subtract(BundleContentsAccessor.callGetWeight(stack).multiplyBy(Fraction.getFraction((int)stack.method_7947(), (int)1)));
            this.toggleSelectedItem(-1);
            cir.setReturnValue((Object)stack);
        }
    }

    @Inject(method={"toImmutable"}, at={@At(value="RETURN")}, cancellable=true)
    private void vb$onToImmutable(CallbackInfoReturnable<class_9276> cir) {
        if (!BundleFeatures.onBundleUpdate()) {
            return;
        }
        class_9276 original = (class_9276)cir.getReturnValue();
        ((IBundle)original).setSelectedItem(this.selectedItem);
        cir.setReturnValue((Object)original);
    }
}

