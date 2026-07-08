/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.screen.slot.SlotActionType
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.item.ItemStack
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 *  org.joml.Vector2i
 */
package backported.updates.content.client.api.bundle;

import backported.updates.content.client.api.bundle.ItemSlotMouseAction;
import backported.updates.content.client.api.bundle.ScrollWheelHandler;
import backported.updates.content.common.api.bundle.BundleFeatures;
import backported.updates.content.core.data.tags.ModItemTags;
import backported.updates.content.core.network.ServerboundSelectBundleItemPacket;
import backported.updates.foundation.client.event.screen.HudInteractions;
import backported.updates.foundation.core.networking.PayloadDistributor;
import backported.updates.foundation.core.util.event.CancellableResult;
import backported_updates.mixin.access.HandledScreenAccessor;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import org.joml.Vector2i;

@Environment(value=EnvType.CLIENT)
public class BundleMouseActions
implements ItemSlotMouseAction {
    public static final BundleMouseActions INSTANCE = new BundleMouseActions();
    private final ScrollWheelHandler scrollWheelHandler = new ScrollWheelHandler();

    public static void bootstrap() {
        HudInteractions.SCROLLING_PRE.register((minecraft, screen, mouseX, mouseY, deltaX, deltaY) -> {
            if (!BundleFeatures.onBundleUpdate()) {
                return CancellableResult.PASS;
            }
            if (screen instanceof HandledScreen) {
                BundleMouseActions action;
                HandledScreen container = (HandledScreen)screen;
                Slot slot = ((HandledScreenAccessor)container).getFocusedSlot();
                if (slot != null && slot.hasStack() && (action = INSTANCE).matches(slot) && action.onMouseScrolled(deltaY, slot.id, slot.getStack())) {
                    return CancellableResult.CANCEL;
                }
            }
            return CancellableResult.PASS;
        });
        HudInteractions.STOP_HOVERING.register((minecraft, screen, slot) -> {
            BundleMouseActions action;
            if (slot != null && slot.hasStack() && (action = INSTANCE).matches(slot)) {
                if (!BundleFeatures.onBundleUpdate()) {
                    return;
                }
                action.onStopHovering(slot);
            }
        });
        HudInteractions.SLOT_CLICK.register((minecraft, screen, slot, clickType) -> {
            BundleMouseActions action;
            if (slot != null && slot.hasStack() && (action = INSTANCE).matches(slot)) {
                if (!BundleFeatures.onBundleUpdate()) {
                    return;
                }
                action.onSlotClicked(slot, clickType);
            }
        });
    }

    @Override
    public boolean matches(Slot slot) {
        return slot.getStack().isIn(ModItemTags.BUNDLES);
    }

    @Override
    public boolean onMouseScrolled(double scrollDelta, int slotId, ItemStack stack) {
        int selectedItemIndex;
        int selectedItem;
        int delta;
        int itemsToShow = BundleFeatures.getNumberOfItemsToShow(stack);
        if (itemsToShow == 0) {
            return false;
        }
        Vector2i scroll = this.scrollWheelHandler.onMouseScroll(scrollDelta);
        int n = delta = scroll.y == 0 ? -scroll.x : scroll.y;
        if (delta != 0 && (selectedItem = BundleFeatures.getSelectedItem(stack)) != (selectedItemIndex = ScrollWheelHandler.getNextScrollWheelSelection(delta, selectedItem, itemsToShow))) {
            this.toggleSelectedBundleItem(stack, slotId, selectedItemIndex);
        }
        return true;
    }

    @Override
    public void onStopHovering(Slot slot) {
        this.unselectedBundleItem(slot.getStack(), slot.id);
    }

    @Override
    public void onSlotClicked(Slot slot, SlotActionType clickType) {
        if (clickType == SlotActionType.QUICK_MOVE || clickType == SlotActionType.SWAP) {
            this.unselectedBundleItem(slot.getStack(), slot.id);
        }
    }

    private void toggleSelectedBundleItem(ItemStack stack, int slotId, int selectedItemIndex) {
        if (selectedItemIndex < BundleFeatures.getNumberOfItemsToShow(stack)) {
            BundleFeatures.toggleSelectedItem(stack, selectedItemIndex);
            PayloadDistributor.sendToServer(new ServerboundSelectBundleItemPacket(slotId, selectedItemIndex));
        }
    }

    public void unselectedBundleItem(ItemStack stack, int slotId) {
        this.toggleSelectedBundleItem(stack, slotId, -1);
    }
}

