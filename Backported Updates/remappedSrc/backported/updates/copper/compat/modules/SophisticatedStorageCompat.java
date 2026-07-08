/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1263
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1923
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2586
 *  net.minecraft.class_2680
 *  net.minecraft.class_3218
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.copper.compat.modules;

import backported.updates.copper.compat.IContainerCompat;
import backported.updates.copper.compat.IModCompatModule;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.minecraft.class_1263;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1923;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_3218;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
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
            this.storageOpennessPayloadConstructor = this.storageOpennessPayloadClass.getConstructor(class_2338.class, Boolean.TYPE);
            this.packetDistributorClass = Class.forName("net.neoforged.neoforge.network.PacketDistributor");
            Class<?> customPacketPayloadClass = Class.forName("net.minecraft.network.protocol.common.custom.CustomPacketPayload");
            Class<?> payloadArrayClass = Array.newInstance(customPacketPayloadClass, 0).getClass();
            this.sendToPlayersTrackingChunkMethod = this.packetDistributorClass.getMethod("sendToPlayersTrackingChunk", class_3218.class, class_1923.class, customPacketPayloadClass, payloadArrayClass);
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
    public boolean isValidContainer(class_2680 state) {
        class_2248 block = state.method_26204();
        if (this.chestBlockClass != null && this.chestBlockClass.isInstance(block)) {
            return true;
        }
        if (this.barrelBlockClass != null && this.barrelBlockClass.isInstance(block)) {
            return true;
        }
        return this.limitedBarrelBlockClass != null && this.limitedBarrelBlockClass.isInstance(block);
    }

    @Override
    public boolean canHandle(class_2680 state) {
        return this.isValidContainer(state);
    }

    @Override
    public void setOpen(class_1937 level, class_2338 pos, class_2680 state, boolean open) {
        class_2586 blockEntity = level.method_8321(pos);
        if (blockEntity == null) {
            return;
        }
        class_2248 block = state.method_26204();
        try {
            if (this.setShouldBeOpenMethod != null && this.storageBlockEntityClass != null && this.storageBlockEntityClass.isInstance(blockEntity)) {
                this.setShouldBeOpenMethod.invoke((Object)blockEntity, open);
            }
            if (level instanceof class_3218) {
                class_3218 serverLevel = (class_3218)level;
                this.sendOpennessPacket(serverLevel, pos, open);
            }
            if (this.chestBlockClass != null && this.chestBlockClass.isInstance(block)) {
                level.method_8396(null, pos, open ? class_3417.field_14982 : class_3417.field_14823, class_3419.field_15245, 0.5f, level.field_9229.method_43057() * 0.1f + 0.9f);
            } else if (this.barrelBlockClass != null && this.barrelBlockClass.isInstance(block)) {
                level.method_8396(null, pos, open ? class_3417.field_17604 : class_3417.field_17603, class_3419.field_15245, 0.5f, level.field_9229.method_43057() * 0.1f + 0.9f);
            } else if (this.limitedBarrelBlockClass != null && this.limitedBarrelBlockClass.isInstance(block)) {
                level.method_8396(null, pos, open ? class_3417.field_17604 : class_3417.field_17603, class_3419.field_15245, 0.5f, level.field_9229.method_43057() * 0.1f + 0.9f);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private void sendOpennessPacket(class_3218 serverLevel, class_2338 pos, boolean open) {
        if (this.storageOpennessPayloadConstructor == null || this.sendToPlayersTrackingChunkMethod == null) {
            return;
        }
        try {
            Object payload = this.storageOpennessPayloadConstructor.newInstance(pos, open);
            class_1923 chunkPos = serverLevel.method_8500(pos).method_12004();
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
    public class_1263 getContainer(class_2586 blockEntity, class_1937 level, class_2338 pos) {
        if (!this.isValidContainer(level.method_8320(pos))) {
            return null;
        }
        if (this.itemHandlerCapability == null || this.iItemHandlerClass == null) {
            return null;
        }
        try {
            Class<?> blockCapabilityClass = Class.forName("net.neoforged.neoforge.capabilities.BlockCapability");
            Method getCapabilityMethod = blockCapabilityClass.getMethod("getCapability", class_1937.class, class_2338.class, class_2680.class, class_2586.class, Object.class);
            class_2680 state = level.method_8320(pos);
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
    implements class_1263 {
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
            this.insertItemMethod = iItemHandlerClass.getMethod("insertItem", Integer.TYPE, class_1799.class, Boolean.TYPE);
            this.extractItemMethod = iItemHandlerClass.getMethod("extractItem", Integer.TYPE, Integer.TYPE, Boolean.TYPE);
            this.getSlotLimitMethod = iItemHandlerClass.getMethod("getSlotLimit", Integer.TYPE);
        }

        public int method_5439() {
            try {
                return (Integer)this.getSlotsMethod.invoke(this.itemHandler, new Object[0]);
            }
            catch (Exception e) {
                return 0;
            }
        }

        public boolean method_5442() {
            for (int i = 0; i < this.method_5439(); ++i) {
                if (this.method_5438(i).method_7960()) continue;
                return false;
            }
            return true;
        }

        public class_1799 method_5438(int slot) {
            try {
                return (class_1799)this.getStackInSlotMethod.invoke(this.itemHandler, slot);
            }
            catch (Exception e) {
                return class_1799.field_8037;
            }
        }

        public class_1799 method_5434(int slot, int amount) {
            try {
                return (class_1799)this.extractItemMethod.invoke(this.itemHandler, slot, amount, false);
            }
            catch (Exception e) {
                return class_1799.field_8037;
            }
        }

        public class_1799 method_5441(int slot) {
            try {
                class_1799 current = this.method_5438(slot);
                if (current.method_7960()) {
                    return class_1799.field_8037;
                }
                return (class_1799)this.extractItemMethod.invoke(this.itemHandler, slot, current.method_7947(), false);
            }
            catch (Exception e) {
                return class_1799.field_8037;
            }
        }

        public void method_5447(int slot, class_1799 stack) {
            try {
                this.extractItemMethod.invoke(this.itemHandler, slot, 64, false);
                if (!stack.method_7960()) {
                    this.insertItemMethod.invoke(this.itemHandler, slot, stack, false);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }

        public int method_5444() {
            try {
                if (this.method_5439() > 0) {
                    return (Integer)this.getSlotLimitMethod.invoke(this.itemHandler, 0);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
            return 64;
        }

        public void method_5431() {
        }

        public boolean method_5443(class_1657 player) {
            return true;
        }

        public void method_5448() {
            for (int i = 0; i < this.method_5439(); ++i) {
                this.method_5441(i);
            }
        }
    }
}

