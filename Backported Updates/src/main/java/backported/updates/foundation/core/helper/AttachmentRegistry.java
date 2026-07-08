/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.entity.LivingEntity
 */
package backported.updates.foundation.core.helper;

import backported.updates.foundation.common.data.Attachment;
import backported.updates.foundation.core.helper.fabric.AttachmentRegistryImpl;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.entity.LivingEntity;

public class AttachmentRegistry {
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static <T> void register(Attachment<T> attachment) {
        AttachmentRegistryImpl.register(attachment);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static <T> boolean hasAttachment(LivingEntity entity, Attachment<T> attachment) {
        return AttachmentRegistryImpl.hasAttachment(entity, attachment);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static <T> T getAttachmentValue(LivingEntity entity, Attachment<T> attachment) {
        return AttachmentRegistryImpl.getAttachmentValue(entity, attachment);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static <T> void setAttachment(LivingEntity entity, Attachment<T> attachment, T value) {
        AttachmentRegistryImpl.setAttachment(entity, attachment, value);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static <T> void removeAttachment(LivingEntity entity, Attachment<T> attachment) {
        AttachmentRegistryImpl.removeAttachment(entity, attachment);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void bootstrap() {
        AttachmentRegistryImpl.bootstrap();
    }
}

