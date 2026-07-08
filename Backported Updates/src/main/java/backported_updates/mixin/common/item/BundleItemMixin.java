/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.item.Item$TooltipContext
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.tooltip.TooltipType
 *  net.minecraft.text.Text
 *  net.minecraft.util.math.ColorHelper$Argb
 *  net.minecraft.util.ClickType
 *  net.minecraft.item.BundleItem
 *  net.minecraft.inventory.StackReference
 *  net.minecraft.component.type.BundleContentsComponent
 *  net.minecraft.component.type.BundleContentsComponent$Builder
 *  net.minecraft.component.DataComponentTypes
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
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.slot.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.ClickType;
import net.minecraft.item.BundleItem;
import net.minecraft.inventory.StackReference;
import net.minecraft.component.type.BundleContentsComponent;
import net.minecraft.component.DataComponentTypes;
import org.apache.commons.lang3.math.Fraction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={BundleItem.class})
public abstract class BundleItemMixin {
    @Unique
    private static final int FULL_BAR_COLOR = ColorHelper.Argb.fromFloats((float)1.0f, (float)1.0f, (float)0.33f, (float)0.33f);
    @Unique
    private static final int BAR_COLOR = ColorHelper.Argb.fromFloats((float)1.0f, (float)0.44f, (float)0.53f, (float)1.0f);

    @Shadow
    protected abstract void playInsertSound(Entity var1);

    @Shadow
    protected abstract void playRemoveOneSound(Entity var1);

    @Inject(method={"onStackClicked"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$overrideStackedOnOther(ItemStack stack, Slot slot, ClickType action, PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        if (!BundleFeatures.onBundleUpdate()) {
            return;
        }
        BundleContentsComponent contents = (BundleContentsComponent)stack.get(DataComponentTypes.BUNDLE_CONTENTS);
        if (contents == null) {
            cir.setReturnValue(false);
        } else {
            ItemStack itemInSlot = slot.getStack();
            BundleContentsComponent.Builder mutable = new BundleContentsComponent.Builder(contents);
            if (action == ClickType.LEFT && !itemInSlot.isEmpty()) {
                if (mutable.add(slot, player) > 0) {
                    this.playInsertSound((Entity)player);
                } else {
                    BundleFeatures.playInsertFailSound((Entity)player);
                }
                stack.set(DataComponentTypes.BUNDLE_CONTENTS, mutable.build());
                BundleFeatures.broadcastChangesOnContainerMenu(player);
                cir.setReturnValue(true);
            } else if (action == ClickType.RIGHT && itemInSlot.isEmpty()) {
                ItemStack removed = mutable.removeFirst();
                if (removed != null) {
                    ItemStack insert = slot.insertStack(removed);
                    if (insert.getCount() > 0) {
                        mutable.add(insert);
                    } else {
                        this.playRemoveOneSound((Entity)player);
                    }
                }
                stack.set(DataComponentTypes.BUNDLE_CONTENTS, mutable.build());
                BundleFeatures.broadcastChangesOnContainerMenu(player);
                cir.setReturnValue(true);
            } else {
                cir.setReturnValue(false);
            }
        }
    }

    @Inject(method={"onClicked"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$overrideOtherStackedOnMe(ItemStack stack, ItemStack other, Slot slot, ClickType action, PlayerEntity player, StackReference access, CallbackInfoReturnable<Boolean> cir) {
        if (!BundleFeatures.onBundleUpdate()) {
            return;
        }
        if (action == ClickType.LEFT && other.isEmpty()) {
            BundleFeatures.toggleSelectedItem(stack, -1);
            cir.setReturnValue(false);
        } else {
            BundleContentsComponent contents = (BundleContentsComponent)stack.get(DataComponentTypes.BUNDLE_CONTENTS);
            if (contents == null) {
                cir.setReturnValue(false);
            } else {
                BundleContentsComponent.Builder mutable = new BundleContentsComponent.Builder(contents);
                if (action == ClickType.LEFT && !other.isEmpty()) {
                    if (slot.canTakePartial(player) && mutable.add(other) > 0) {
                        this.playInsertSound((Entity)player);
                    } else {
                        BundleFeatures.playInsertFailSound((Entity)player);
                    }
                    stack.set(DataComponentTypes.BUNDLE_CONTENTS, mutable.build());
                    BundleFeatures.broadcastChangesOnContainerMenu(player);
                    cir.setReturnValue(true);
                } else if (action == ClickType.RIGHT && other.isEmpty()) {
                    ItemStack removed;
                    if (slot.canTakePartial(player) && (removed = mutable.removeFirst()) != null) {
                        this.playRemoveOneSound((Entity)player);
                        access.set(removed);
                    }
                    stack.set(DataComponentTypes.BUNDLE_CONTENTS, mutable.build());
                    BundleFeatures.broadcastChangesOnContainerMenu(player);
                    cir.setReturnValue(true);
                } else {
                    BundleFeatures.toggleSelectedItem(stack, -1);
                    cir.setReturnValue(false);
                }
            }
        }
    }

    @Inject(method={"getItemBarColor"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$getBarColor(ItemStack stack, CallbackInfoReturnable<Integer> cir) {
        if (!BundleFeatures.onBundleUpdate()) {
            return;
        }
        BundleContentsComponent contents = (BundleContentsComponent)stack.getOrDefault(DataComponentTypes.BUNDLE_CONTENTS, BundleContentsComponent.DEFAULT);
        cir.setReturnValue((contents.getOccupancy().compareTo(Fraction.ONE) >= 0 ? FULL_BAR_COLOR : BAR_COLOR));
    }

    @Inject(method = "onItemEntityDestroyed", at = @At("HEAD"), cancellable = true)
    private static void vb$dropContents(ItemEntity entity, CallbackInfo ci) {
        if (!BundleFeatures.onBundleUpdate()) {
            return;
        }
        ItemStack stack = entity.getStack();
        BundleContentsComponent contents = (BundleContentsComponent)stack.get(DataComponentTypes.BUNDLE_CONTENTS);
        if (contents != null && !contents.isEmpty()) {
            BundleContentsComponent.Builder mutable = new BundleContentsComponent.Builder(contents);
            ItemStack removed = mutable.removeFirst();
            if (removed != null) {
                stack.set(DataComponentTypes.BUNDLE_CONTENTS, mutable.build());
                entity.getWorld().spawnEntity(new ItemEntity(entity.getWorld(), entity.getX(), entity.getY(), entity.getZ(), removed));
                BundleFeatures.playRemoveOneSound(entity);
            }
        }
    }

    @Inject(method={"appendTooltip"}, at={@At(value="HEAD")}, cancellable=true)
    private void vb$appendHoverText(ItemStack stack, Item.TooltipContext context, List<Text> tooltipComponents, TooltipType tooltipFlag, CallbackInfo ci) {
        if (BundleFeatures.onBundleUpdate()) {
            ci.cancel();
        }
    }
}

