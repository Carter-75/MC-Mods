/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry
 *  net.fabricmc.fabric.api.attachment.v1.AttachmentType
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.Identifier
 */
package backported.updates.foundation.core.helper.fabric;

import backported.updates.foundation.Platform;
import backported.updates.foundation.common.data.Attachment;
import java.util.HashMap;
import java.util.Map;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;

public class AttachmentRegistryImpl {
    private static final Map<Identifier, AttachmentType<?>> ATTACHMENTS = new HashMap<>();

    public static <T> void register(Attachment<T> attachment) {
        AttachmentType<T> result = AttachmentRegistry.<T>builder().copyOnDeath().initializer(attachment.defaultSyncedValue()).persistent(attachment.codec()).buildAndRegister(attachment.valueId());
        ATTACHMENTS.put(attachment.valueId(), result);
    }

    public static <T> boolean hasAttachment(LivingEntity entity, Attachment<T> attachment) {
        AttachmentType<?> type = ATTACHMENTS.get(attachment.valueId());
        if (type == null) {
            Platform.LOGGER.warn("Querying attachment that has not been registered: {}", attachment.valueId());
            return false;
        }
        return entity.hasAttached(type);
    }

    public static <T> T getAttachmentValue(LivingEntity entity, Attachment<T> attachment) {
        AttachmentType<T> type = (AttachmentType<T>)ATTACHMENTS.get(attachment.valueId());
        if (type == null) {
            Platform.LOGGER.warn("Getting attachment that has not been registered: {}", attachment.valueId());
            return null;
        }
        return entity.getAttachedOrCreate(type);
    }

    public static <T> void setAttachment(LivingEntity entity, Attachment<T> attachment, T value) {
        AttachmentType<T> type = (AttachmentType<T>)ATTACHMENTS.get(attachment.valueId());
        if (type == null) {
            Platform.LOGGER.warn("Setting attachment that has not been registered: {}", attachment.valueId());
            return;
        }
        entity.setAttached(type, value);
    }

    public static <T> void removeAttachment(LivingEntity entity, Attachment<T> attachment) {
        AttachmentType<?> type = ATTACHMENTS.get(attachment.valueId());
        if (type == null) {
            Platform.LOGGER.warn("Removing attachment that has not been registered: {}", attachment.valueId());
            return;
        }
        entity.removeAttached(type);
    }

    public static void bootstrap() {
    }
}

