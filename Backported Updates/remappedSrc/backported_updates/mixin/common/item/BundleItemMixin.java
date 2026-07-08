/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1735
 *  net.minecraft.class_1792$class_9635
 *  net.minecraft.class_1799
 *  net.minecraft.class_1836
 *  net.minecraft.class_2561
 *  net.minecraft.class_5253$class_5254
 *  net.minecraft.class_5536
 *  net.minecraft.class_5537
 *  net.minecraft.class_5630
 *  net.minecraft.class_9276
 *  net.minecraft.class_9276$class_9277
 *  net.minecraft.class_9334
 *  org.apache.commons.lang3.math.Fraction
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
import java.util.List;
import java.util.Optional;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1735;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1836;
import net.minecraft.class_2561;
import net.minecraft.class_5253;
import net.minecraft.class_5536;
import net.minecraft.class_5537;
import net.minecraft.class_5630;
import net.minecraft.class_9276;
import net.minecraft.class_9334;
import org.apache.commons.lang3.math.Fraction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_5537.class})
public abstract class BundleItemMixin {
    @Unique
    private static final int FULL_BAR_COLOR = class_5253.class_5254.method_59554((float)1.0f, (float)1.0f, (float)0.33f, (float)0.33f);
    @Unique
    private static final int BAR_COLOR = class_5253.class_5254.method_59554((float)1.0f, (float)0.44f, (float)0.53f, (float)1.0f);

    @Shadow
    protected abstract void method_38076(class_1297 var1);

    @Shadow
    protected abstract void method_38074(class_1297 var1);

    @Inject(method={"overrideStackedOnOther"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$overrideStackedOnOther(class_1799 stack, class_1735 slot, class_5536 action, class_1657 player, CallbackInfoReturnable<Boolean> cir) {
        if (!BundleFeatures.onBundleUpdate()) {
            return;
        }
        class_9276 contents = (class_9276)stack.method_57824(class_9334.field_49650);
        if (contents == null) {
            cir.setReturnValue((Object)false);
        } else {
            class_1799 itemInSlot = slot.method_7677();
            class_9276.class_9277 mutable = new class_9276.class_9277(contents);
            if (action == class_5536.field_27013 && !itemInSlot.method_7960()) {
                if (mutable.method_57431(slot, player) > 0) {
                    this.method_38076((class_1297)player);
                } else {
                    BundleFeatures.playInsertFailSound((class_1297)player);
                }
                stack.method_57379(class_9334.field_49650, (Object)mutable.method_57435());
                BundleFeatures.broadcastChangesOnContainerMenu(player);
                cir.setReturnValue((Object)true);
            } else if (action == class_5536.field_27014 && itemInSlot.method_7960()) {
                class_1799 removed = mutable.method_57430();
                if (removed != null) {
                    class_1799 insert = slot.method_32756(removed);
                    if (insert.method_7947() > 0) {
                        mutable.method_57432(insert);
                    } else {
                        this.method_38074((class_1297)player);
                    }
                }
                stack.method_57379(class_9334.field_49650, (Object)mutable.method_57435());
                BundleFeatures.broadcastChangesOnContainerMenu(player);
                cir.setReturnValue((Object)true);
            } else {
                cir.setReturnValue((Object)false);
            }
        }
    }

    @Inject(method={"overrideOtherStackedOnMe"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$overrideOtherStackedOnMe(class_1799 stack, class_1799 other, class_1735 slot, class_5536 action, class_1657 player, class_5630 access, CallbackInfoReturnable<Boolean> cir) {
        if (!BundleFeatures.onBundleUpdate()) {
            return;
        }
        if (action == class_5536.field_27013 && other.method_7960()) {
            BundleFeatures.toggleSelectedItem(stack, -1);
            cir.setReturnValue((Object)false);
        } else {
            class_9276 contents = (class_9276)stack.method_57824(class_9334.field_49650);
            if (contents == null) {
                cir.setReturnValue((Object)false);
            } else {
                class_9276.class_9277 mutable = new class_9276.class_9277(contents);
                if (action == class_5536.field_27013 && !other.method_7960()) {
                    if (slot.method_32754(player) && mutable.method_57432(other) > 0) {
                        this.method_38076((class_1297)player);
                    } else {
                        BundleFeatures.playInsertFailSound((class_1297)player);
                    }
                    stack.method_57379(class_9334.field_49650, (Object)mutable.method_57435());
                    BundleFeatures.broadcastChangesOnContainerMenu(player);
                    cir.setReturnValue((Object)true);
                } else if (action == class_5536.field_27014 && other.method_7960()) {
                    class_1799 removed;
                    if (slot.method_32754(player) && (removed = mutable.method_57430()) != null) {
                        this.method_38074((class_1297)player);
                        access.method_32332(removed);
                    }
                    stack.method_57379(class_9334.field_49650, (Object)mutable.method_57435());
                    BundleFeatures.broadcastChangesOnContainerMenu(player);
                    cir.setReturnValue((Object)true);
                } else {
                    BundleFeatures.toggleSelectedItem(stack, -1);
                    cir.setReturnValue((Object)false);
                }
            }
        }
    }

    @Inject(method={"getBarColor"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$getBarColor(class_1799 stack, CallbackInfoReturnable<Integer> cir) {
        if (!BundleFeatures.onBundleUpdate()) {
            return;
        }
        class_9276 contents = (class_9276)stack.method_57825(class_9334.field_49650, (Object)class_9276.field_49289);
        cir.setReturnValue((Object)(contents.method_57428().compareTo(Fraction.ONE) >= 0 ? FULL_BAR_COLOR : BAR_COLOR));
    }

    @Inject(method={"dropContents"}, at={@At(value="HEAD")}, cancellable=true)
    private static void vb$dropContents(class_1799 stack, class_1657 player, CallbackInfoReturnable<Boolean> cir) {
        if (!BundleFeatures.onBundleUpdate()) {
            return;
        }
        class_9276 contents = (class_9276)stack.method_57824(class_9334.field_49650);
        if (contents != null && !contents.method_57429()) {
            Optional<class_1799> optional = BundleFeatures.removeOneItemFromBundle(stack, player, contents);
            if (optional.isPresent()) {
                player.method_7328(optional.get(), true);
                cir.setReturnValue((Object)true);
            } else {
                cir.setReturnValue((Object)false);
            }
        } else {
            cir.setReturnValue((Object)false);
        }
    }

    @Inject(method={"appendHoverText"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$appendHoverText(class_1799 stack, class_1792.class_9635 context, List<class_2561> tooltipComponents, class_1836 tooltipFlag, CallbackInfo ci) {
        if (BundleFeatures.onBundleUpdate()) {
            ci.cancel();
        }
    }
}

