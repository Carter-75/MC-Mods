package com.drone_army.client.gui;

import com.drone_army.registry.ModScreenHandlers;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.Hand;

public class ControllerScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final ItemStack controllerStack;

    public static final ExtendedScreenHandlerType<ControllerScreenHandler, ControllerScreenData> TYPE = new ExtendedScreenHandlerType<>(
            ControllerScreenHandler::new,
            ControllerScreenData.PACKET_CODEC);

    // Define the record and codec
    public record ControllerScreenData(ItemStack stack) {
        public static final net.minecraft.network.codec.PacketCodec<RegistryByteBuf, ControllerScreenData> PACKET_CODEC = net.minecraft.network.codec.PacketCodec
                .tuple(
                        ItemStack.PACKET_CODEC, ControllerScreenData::stack,
                        ControllerScreenData::new);
    }

    // Client constructor
    public ControllerScreenHandler(int syncId, PlayerInventory playerInventory, ControllerScreenData data) {
        this(syncId, playerInventory, new SimpleInventory(18), data.stack());
    }

    // Server constructor
    public ControllerScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory,
            ItemStack controllerStack) {
        super(ModScreenHandlers.CONTROLLER_SCREEN_HANDLER, syncId);
        this.inventory = inventory;
        this.controllerStack = controllerStack;

        inventory.onOpen(playerInventory.player);

        // Controller Inventory (Dynamic size)
        int invSize = inventory.size();
        for (int i = 0; i < invSize; ++i) {
            int x = 8 + (i % 9) * 18;
            int y = 18 + (i / 9) * 18;
            this.addSlot(new Slot(inventory, i, x, y));
        }

        // Player Inventory
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 85 + i * 18));
            }
        }

        // Action Bar
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 143));
        }
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slotObj = this.slots.get(slot);
        if (slotObj != null && slotObj.hasStack()) {
            ItemStack originalStack = slotObj.getStack();
            newStack = originalStack.copy();
            int invSize = this.inventory.size();

            if (slot < invSize) {
                // From Controller to Player
                if (!this.insertItem(originalStack, invSize, invSize + 36, true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                // From Player to Controller
                if (!this.insertItem(originalStack, 0, invSize, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (originalStack.isEmpty()) {
                slotObj.setStack(ItemStack.EMPTY);
            } else {
                slotObj.markDirty();
            }
        }
        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        this.inventory.onClose(player);
        // Note: The logic to write NBT back to the stack should be handled by the
        // Inventory implementation
        // or explicitly here if using SimpleInventory and manually syncing.
        // For a portable item inventory, we usually need to listen to slot changes or
        // write on close.
    }
}
