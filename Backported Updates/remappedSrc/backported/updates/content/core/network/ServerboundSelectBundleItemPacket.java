/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1735
 *  net.minecraft.class_1799
 *  net.minecraft.class_2371
 *  net.minecraft.class_2540
 *  net.minecraft.class_8710
 *  net.minecraft.class_8710$class_9154
 *  net.minecraft.class_9129
 *  net.minecraft.class_9139
 */
package backported.updates.content.core.network;

import backported.updates.content.common.api.bundle.BundleFeatures;
import backported.updates.content.core.VanillaBackport;
import backported.updates.foundation.core.networking.PayloadContext;
import net.minecraft.class_1735;
import net.minecraft.class_1799;
import net.minecraft.class_2371;
import net.minecraft.class_2540;
import net.minecraft.class_8710;
import net.minecraft.class_9129;
import net.minecraft.class_9139;

public record ServerboundSelectBundleItemPacket(int slotId, int selectedItemIndex) implements class_8710
{
    public static final class_8710.class_9154<ServerboundSelectBundleItemPacket> TYPE = new class_8710.class_9154(VanillaBackport.resource("serverbound_select_bundle_item"));
    public static final class_9139<class_9129, ServerboundSelectBundleItemPacket> STREAM_CODEC = class_9139.method_56438(ServerboundSelectBundleItemPacket::write, ServerboundSelectBundleItemPacket::new);

    public ServerboundSelectBundleItemPacket(class_9129 buf) {
        this(buf.method_10816(), buf.method_10816());
        if (this.selectedItemIndex < 0 && this.selectedItemIndex != -1) {
            throw new IllegalArgumentException("Invalid selectedItemIndex: " + this.selectedItemIndex);
        }
    }

    private void write(class_2540 buf) {
        buf.method_10804(this.slotId);
        buf.method_10804(this.selectedItemIndex);
    }

    public class_8710.class_9154<? extends class_8710> method_56479() {
        return TYPE;
    }

    public static void handler(ServerboundSelectBundleItemPacket payload, PayloadContext context) {
        context.enqueueWork(() -> {
            class_2371 slots = context.player().field_7512.field_7761;
            int slot = payload.slotId;
            if (slot >= 0 && slot < slots.size()) {
                class_1799 stack = ((class_1735)slots.get(slot)).method_7677();
                BundleFeatures.toggleSelectedItem(stack, payload.selectedItemIndex);
            }
        });
    }
}

