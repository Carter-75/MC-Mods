/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.class_1309
 */
package backported.updates.foundation.core.helper;

import backported.updates.foundation.common.data.Attachment;
import backported.updates.foundation.core.helper.fabric.AttachmentRegistryImpl;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.class_1309;

public class AttachmentRegistry {
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static <T> void register(Attachment<T> attachment) {
        AttachmentRegistryImpl.register(attachment);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static <T> boolean hasAttachment(class_1309 entity, Attachment<T> attachment) {
        return AttachmentRegistryImpl.hasAttachment(entity, attachment);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static <T> T getAttachmentValue(class_1309 entity, Attachment<T> attachment) {
        return AttachmentRegistryImpl.getAttachmentValue(entity, attachment);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static <T> void setAttachment(class_1309 entity, Attachment<T> attachment, T value) {
        AttachmentRegistryImpl.setAttachment(entity, attachment, value);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static <T> void removeAttachment(class_1309 entity, Attachment<T> attachment) {
        AttachmentRegistryImpl.removeAttachment(entity, attachment);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void bootstrap() {
        AttachmentRegistryImpl.bootstrap();
    }
}

