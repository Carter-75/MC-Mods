/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.collection.DefaultedList
 *  net.minecraft.network.PacketByteBuf
 *  net.minecraft.network.packet.CustomPayload
 *  net.minecraft.network.packet.CustomPayload$Id
 *  net.minecraft.network.RegistryByteBuf
 *  net.minecraft.network.codec.PacketCodec
 */
package backported.updates.content.core.network;

import backported.updates.content.common.api.bundle.BundleFeatures;
import backported.updates.content.core.VanillaBackport;
import backported.updates.foundation.core.networking.PayloadContext;
import net.minecraft.screen.slot.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;

public record ServerboundSelectBundleItemPacket(int slotId, int selectedItemIndex) implements CustomPayload
{
    public static final CustomPayload.Id<ServerboundSelectBundleItemPacket> TYPE = new CustomPayload.Id(VanillaBackport.resource("serverbound_select_bundle_item"));
    public static final PacketCodec<RegistryByteBuf, ServerboundSelectBundleItemPacket> STREAM_CODEC = PacketCodec.of(ServerboundSelectBundleItemPacket::write, ServerboundSelectBundleItemPacket::new);

    public ServerboundSelectBundleItemPacket(RegistryByteBuf buf) {
        this(buf.readVarInt(), buf.readVarInt());
        if (this.selectedItemIndex < 0 && this.selectedItemIndex != -1) {
            throw new IllegalArgumentException("Invalid selectedItemIndex: " + this.selectedItemIndex);
        }
    }

    private void write(PacketByteBuf buf) {
        buf.writeVarInt(this.slotId);
        buf.writeVarInt(this.selectedItemIndex);
    }

    public CustomPayload.Id<? extends CustomPayload> getId() {
        return TYPE;
    }

    public static void handler(ServerboundSelectBundleItemPacket payload, PayloadContext context) {
        context.enqueueWork(() -> {
            DefaultedList slots = context.player().currentScreenHandler.slots;
            int slot = payload.slotId;
            if (slot >= 0 && slot < slots.size()) {
                ItemStack stack = ((Slot)slots.get(slot)).getStack();
                BundleFeatures.toggleSelectedItem(stack, payload.selectedItemIndex);
            }
        });
    }
}

