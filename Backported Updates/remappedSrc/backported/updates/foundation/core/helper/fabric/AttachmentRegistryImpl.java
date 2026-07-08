/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry
 *  net.fabricmc.fabric.api.attachment.v1.AttachmentType
 *  net.minecraft.class_1309
 *  net.minecraft.class_2960
 */
package backported.updates.foundation.core.helper.fabric;

import backported.updates.foundation.Platform;
import backported.updates.foundation.common.data.Attachment;
import java.util.HashMap;
import java.util.Map;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.minecraft.class_1309;
import net.minecraft.class_2960;

public class AttachmentRegistryImpl {
    private static final Map<class_2960, AttachmentType<?>> ATTACHMENTS = new HashMap();

    public static <T> void register(Attachment<T> attachment) {
        AttachmentType result = AttachmentRegistry.builder().copyOnDeath().initializer(attachment.defaultSyncedValue()).persistent(attachment.codec()).buildAndRegister(attachment.valueId());
        ATTACHMENTS.put(attachment.valueId(), result);
    }

    public static <T> boolean hasAttachment(class_1309 entity, Attachment<T> attachment) {
        AttachmentType<?> type = ATTACHMENTS.get(attachment.valueId());
        if (type == null) {
            Platform.LOGGER.warn("Querying attachment that has not been registered: {}", (Object)attachment.valueId());
            return false;
        }
        return entity.hasAttached(type);
    }

    public static <T> T getAttachmentValue(class_1309 entity, Attachment<T> attachment) {
        AttachmentType<?> type = ATTACHMENTS.get(attachment.valueId());
        if (type == null) {
            Platform.LOGGER.warn("Getting attachment that has not been registered: {}", (Object)attachment.valueId());
            return null;
        }
        return (T)entity.getAttachedOrCreate(type);
    }

    public static <T> void setAttachment(class_1309 entity, Attachment<T> attachment, T value) {
        AttachmentType<?> type = ATTACHMENTS.get(attachment.valueId());
        if (type == null) {
            Platform.LOGGER.warn("Setting attachment that has not been registered: {}", (Object)attachment.valueId());
            return;
        }
        entity.setAttached(type, value);
    }

    public static <T> void removeAttachment(class_1309 entity, Attachment<T> attachment) {
        AttachmentType<?> type = ATTACHMENTS.get(attachment.valueId());
        if (type == null) {
            Platform.LOGGER.warn("Removing attachment that has not been registered: {}", (Object)attachment.valueId());
            return;
        }
        entity.removeAttached(type);
    }

    public static void bootstrap() {
    }
}

