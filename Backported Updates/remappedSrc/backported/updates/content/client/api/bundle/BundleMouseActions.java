/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1713
 *  net.minecraft.class_1735
 *  net.minecraft.class_1799
 *  net.minecraft.class_465
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
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1799;
import net.minecraft.class_465;
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
            if (screen instanceof class_465) {
                BundleMouseActions action;
                class_465 container = (class_465)screen;
                class_1735 slot = container.field_2787;
                if (slot != null && slot.method_7681() && (action = INSTANCE).matches(slot) && action.onMouseScrolled(deltaY, slot.field_7874, slot.method_7677())) {
                    return CancellableResult.CANCEL;
                }
            }
            return CancellableResult.PASS;
        });
        HudInteractions.STOP_HOVERING.register((minecraft, screen, slot) -> {
            BundleMouseActions action;
            if (slot != null && slot.method_7681() && (action = INSTANCE).matches(slot)) {
                if (!BundleFeatures.onBundleUpdate()) {
                    return;
                }
                action.onStopHovering(slot);
            }
        });
        HudInteractions.SLOT_CLICK.register((minecraft, screen, slot, clickType) -> {
            BundleMouseActions action;
            if (slot != null && slot.method_7681() && (action = INSTANCE).matches(slot)) {
                if (!BundleFeatures.onBundleUpdate()) {
                    return;
                }
                action.onSlotClicked(slot, clickType);
            }
        });
    }

    @Override
    public boolean matches(class_1735 slot) {
        return slot.method_7677().method_31573(ModItemTags.BUNDLES);
    }

    @Override
    public boolean onMouseScrolled(double scrollDelta, int slotId, class_1799 stack) {
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
    public void onStopHovering(class_1735 slot) {
        this.unselectedBundleItem(slot.method_7677(), slot.field_7874);
    }

    @Override
    public void onSlotClicked(class_1735 slot, class_1713 clickType) {
        if (clickType == class_1713.field_7794 || clickType == class_1713.field_7791) {
            this.unselectedBundleItem(slot.method_7677(), slot.field_7874);
        }
    }

    private void toggleSelectedBundleItem(class_1799 stack, int slotId, int selectedItemIndex) {
        if (selectedItemIndex < BundleFeatures.getNumberOfItemsToShow(stack)) {
            BundleFeatures.toggleSelectedItem(stack, selectedItemIndex);
            PayloadDistributor.sendToServer(new ServerboundSelectBundleItemPacket(slotId, selectedItemIndex));
        }
    }

    public void unselectedBundleItem(class_1799 stack, int slotId) {
        this.toggleSelectedBundleItem(stack, slotId, -1);
    }
}

