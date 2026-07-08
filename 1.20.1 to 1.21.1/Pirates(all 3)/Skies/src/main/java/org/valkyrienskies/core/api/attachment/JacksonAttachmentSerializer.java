/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.api.attachment;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.api.VsBeta;
import org.valkyrienskies.core.api.attachment.AttachmentSerializer;

@VsBeta
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lorg/valkyrienskies/core/api/attachment/JacksonAttachmentSerializer;", "Lorg/valkyrienskies/core/api/attachment/AttachmentSerializer;", "<init>", "()V", "api"})
public final class JacksonAttachmentSerializer
implements AttachmentSerializer {
    @NotNull
    public static final JacksonAttachmentSerializer INSTANCE = new JacksonAttachmentSerializer();

    private JacksonAttachmentSerializer() {
    }
}

