/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.inventory.Inventory
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.ChunkPos
 *  net.minecraft.world.World
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.block.BlockState
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.sound.SoundEvents
 *  net.minecraft.sound.SoundCategory
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.copper.compat.modules;

import backported.updates.copper.compat.IContainerCompat;
import backported.updates.copper.compat.IModCompatModule;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.minecraft.inventory.Inventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import org.jetbrains.annotations.Nullable;

public class SophisticatedStorageCompat
implements IModCompatModule,
IContainerCompat {
    public static final String MOD_ID = "sophisticatedstorage";
    private Class<?> chestBlockClass;
    private Class<?> barrelBlockClass;
    private Class<?> limitedBarrelBlockClass;
    private Class<?> storageBlockEntityClass;
    private Method setShouldBeOpenMethod;
    private Class<?> storageOpennessPayloadClass;
    private Constructor<?> storageOpennessPayloadConstructor;
    private Class<?> packetDistributorClass;
    private Method sendToPlayersTrackingChunkMethod;
    private Class<?> capabilitiesClass;
    private Object itemHandlerCapability;
    private Class<?> iItemHandlerClass;
    private boolean chestInitialized = false;
    private boolean barrelInitialized = false;

    @Override
    public String getModId() {
        return MOD_ID;
    }

    @Override
    public void init() {
        try {
            this.chestBlockClass = Class.forName("net.p3pp3rf1y.sophisticatedstorage.block.ChestBlock");
            this.chestInitialized = true;
        }
        catch (ClassNotFoundException classNotFoundException) {
            // empty catch block
        }
        try {
            this.barrelBlockClass = Class.forName("net.p3pp3rf1y.sophisticatedstorage.block.BarrelBlock");
            this.barrelInitialized = true;
        }
        catch (ClassNotFoundException classNotFoundException) {
            // empty catch block
        }
        try {
            this.limitedBarrelBlockClass = Class.forName("net.p3pp3rf1y.sophisticatedstorage.block.LimitedBarrelBlock");
        }
        catch (ClassNotFoundException classNotFoundException) {
            // empty catch block
        }
        try {
            this.storageBlockEntityClass = Class.forName("net.p3pp3rf1y.sophisticatedstorage.block.StorageBlockEntity");
            this.setShouldBeOpenMethod = this.storageBlockEntityClass.getMethod("setShouldBeOpen", Boolean.TYPE);
        }
        catch (ClassNotFoundException | NoSuchMethodException reflectiveOperationException) {
            // empty catch block
        }
        try {
            this.storageOpennessPayloadClass = Class.forName("net.p3pp3rf1y.sophisticatedstorage.network.StorageOpennessPayload");
            this.storageOpennessPayloadConstructor = this.storageOpennessPayloadClass.getConstructor(BlockPos.class, Boolean.TYPE);
            this.packetDistributorClass = Class.forName("net.neoforged.neoforge.network.PacketDistributor");
            Class<?> customPacketPayloadClass = Class.forName("net.minecraft.network.protocol.common.custom.CustomPacketPayload");
            Class<?> payloadArrayClass = Array.newInstance(customPacketPayloadClass, 0).getClass();
            this.sendToPlayersTrackingChunkMethod = this.packetDistributorClass.getMethod("sendToPlayersTrackingChunk", ServerWorld.class, ChunkPos.class, customPacketPayloadClass, payloadArrayClass);
        }
        catch (ClassNotFoundException | NoSuchMethodException customPacketPayloadClass) {
            // empty catch block
        }
        try {
            this.capabilitiesClass = Class.forName("net.neoforged.neoforge.capabilities.Capabilities");
            Class<?> itemHandlerClass = Class.forName("net.neoforged.neoforge.capabilities.Capabilities$ItemHandler");
            Field blockField = itemHandlerClass.getField("BLOCK");
            this.itemHandlerCapability = blockField.get(null);
            this.iItemHandlerClass = Class.forName("net.neoforged.neoforge.items.IItemHandler");
        }
        catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException reflectiveOperationException) {
            // empty catch block
        }
    }

    @Override
    public boolean isValidContainer(BlockState state) {
        Block block = state.getBlock();
        if (this.chestBlockClass != null && this.chestBlockClass.isInstance(block)) {
            return true;
        }
        if (this.barrelBlockClass != null && this.barrelBlockClass.isInstance(block)) {
            return true;
        }
        return this.limitedBarrelBlockClass != null && this.limitedBarrelBlockClass.isInstance(block);
    }

    @Override
    public boolean canHandle(BlockState state) {
        return this.isValidContainer(state);
    }

    @Override
    public void setOpen(World level, BlockPos pos, BlockState state, boolean open) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity == null) {
            return;
        }
        Block block = state.getBlock();
        try {
            if (this.setShouldBeOpenMethod != null && this.storageBlockEntityClass != null && this.storageBlockEntityClass.isInstance(blockEntity)) {
                this.setShouldBeOpenMethod.invoke(blockEntity, open);
            }
            if (level instanceof ServerWorld) {
                ServerWorld serverLevel = (ServerWorld)level;
                this.sendOpennessPacket(serverLevel, pos, open);
            }
            if (this.chestBlockClass != null && this.chestBlockClass.isInstance(block)) {
                level.playSound(null, pos, open ? SoundEvents.BLOCK_CHEST_OPEN : SoundEvents.BLOCK_CHEST_CLOSE, SoundCategory.BLOCKS, 0.5f, level.random.nextFloat() * 0.1f + 0.9f);
            } else if (this.barrelBlockClass != null && this.barrelBlockClass.isInstance(block)) {
                level.playSound(null, pos, open ? SoundEvents.BLOCK_BARREL_OPEN : SoundEvents.BLOCK_BARREL_CLOSE, SoundCategory.BLOCKS, 0.5f, level.random.nextFloat() * 0.1f + 0.9f);
            } else if (this.limitedBarrelBlockClass != null && this.limitedBarrelBlockClass.isInstance(block)) {
                level.playSound(null, pos, open ? SoundEvents.BLOCK_BARREL_OPEN : SoundEvents.BLOCK_BARREL_CLOSE, SoundCategory.BLOCKS, 0.5f, level.random.nextFloat() * 0.1f + 0.9f);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private void sendOpennessPacket(ServerWorld serverLevel, BlockPos pos, boolean open) {
        if (this.storageOpennessPayloadConstructor == null || this.sendToPlayersTrackingChunkMethod == null) {
            return;
        }
        try {
            Object payload = this.storageOpennessPayloadConstructor.newInstance(pos, open);
            ChunkPos chunkPos = serverLevel.getWorldChunk(pos).getPos();
            Class<?> customPacketPayloadClass = Class.forName("net.minecraft.network.protocol.common.custom.CustomPacketPayload");
            Object emptyPayloadsArray = Array.newInstance(customPacketPayloadClass, 0);
            this.sendToPlayersTrackingChunkMethod.invoke(null, serverLevel, chunkPos, payload, emptyPayloadsArray);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    @Nullable
    public Inventory getContainer(BlockEntity blockEntity, World level, BlockPos pos) {
        if (!this.isValidContainer(level.getBlockState(pos))) {
            return null;
        }
        if (this.itemHandlerCapability == null || this.iItemHandlerClass == null) {
            return null;
        }
        try {
            Class<?> blockCapabilityClass = Class.forName("net.neoforged.neoforge.capabilities.BlockCapability");
            Method getCapabilityMethod = blockCapabilityClass.getMethod("getCapability", World.class, BlockPos.class, BlockState.class, BlockEntity.class, Object.class);
            BlockState state = level.getBlockState(pos);
            Object itemHandler = getCapabilityMethod.invoke(this.itemHandlerCapability, level, pos, state, blockEntity, null);
            if (itemHandler == null) {
                return null;
            }
            return new ItemHandlerContainerWrapper(itemHandler, this.iItemHandlerClass);
        }
        catch (Exception e) {
            return null;
        }
    }

    private static class ItemHandlerContainerWrapper
    implements Inventory {
        private final Object itemHandler;
        private final Method getSlotsMethod;
        private final Method getStackInSlotMethod;
        private final Method insertItemMethod;
        private final Method extractItemMethod;
        private final Method getSlotLimitMethod;

        public ItemHandlerContainerWrapper(Object itemHandler, Class<?> iItemHandlerClass) throws Exception {
            this.itemHandler = itemHandler;
            this.getSlotsMethod = iItemHandlerClass.getMethod("getSlots", new Class[0]);
            this.getStackInSlotMethod = iItemHandlerClass.getMethod("getStackInSlot", Integer.TYPE);
            this.insertItemMethod = iItemHandlerClass.getMethod("insertItem", Integer.TYPE, ItemStack.class, Boolean.TYPE);
            this.extractItemMethod = iItemHandlerClass.getMethod("extractItem", Integer.TYPE, Integer.TYPE, Boolean.TYPE);
            this.getSlotLimitMethod = iItemHandlerClass.getMethod("getSlotLimit", Integer.TYPE);
        }

        public int size() {
            try {
                return (Integer)this.getSlotsMethod.invoke(this.itemHandler, new Object[0]);
            }
            catch (Exception e) {
                return 0;
            }
        }

        public boolean isEmpty() {
            for (int i = 0; i < this.size(); ++i) {
                if (this.getStack(i).isEmpty()) continue;
                return false;
            }
            return true;
        }

        public ItemStack getStack(int slot) {
            try {
                return (ItemStack)this.getStackInSlotMethod.invoke(this.itemHandler, slot);
            }
            catch (Exception e) {
                return ItemStack.EMPTY;
            }
        }

        public ItemStack removeStack(int slot, int amount) {
            try {
                return (ItemStack)this.extractItemMethod.invoke(this.itemHandler, slot, amount, false);
            }
            catch (Exception e) {
                return ItemStack.EMPTY;
            }
        }

        public ItemStack removeStack(int slot) {
            try {
                ItemStack current = this.getStack(slot);
                if (current.isEmpty()) {
                    return ItemStack.EMPTY;
                }
                return (ItemStack)this.extractItemMethod.invoke(this.itemHandler, slot, current.getCount(), false);
            }
            catch (Exception e) {
                return ItemStack.EMPTY;
            }
        }

        public void setStack(int slot, ItemStack stack) {
            try {
                this.extractItemMethod.invoke(this.itemHandler, slot, 64, false);
                if (!stack.isEmpty()) {
                    this.insertItemMethod.invoke(this.itemHandler, slot, stack, false);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }

        public int getMaxCountPerStack() {
            try {
                if (this.size() > 0) {
                    return (Integer)this.getSlotLimitMethod.invoke(this.itemHandler, 0);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
            return 64;
        }

        public void markDirty() {
        }

        public boolean canPlayerUse(PlayerEntity player) {
            return true;
        }

        public void clear() {
            for (int i = 0; i < this.size(); ++i) {
                this.removeStack(i);
            }
        }
    }
}

