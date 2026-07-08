/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.api.attachment;

import java.io.DataInput;
import java.io.DataOutput;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.api.VsBeta;
import org.valkyrienskies.core.api.attachment.AttachmentSerializer;

@VsBeta
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0019\u0010\u0005\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\u0003H&\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\bH&\u00a2\u0006\u0004\b\u000b\u0010\f\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\r\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/attachment/BinaryAttachmentSerializer;", "T", "Lorg/valkyrienskies/core/api/attachment/AttachmentSerializer;", "Ljava/io/DataInput;", "input", "deserialize", "(Ljava/io/DataInput;)Ljava/lang/Object;", "attachment", "Ljava/io/DataOutput;", "output", "", "serialize", "(Ljava/lang/Object;Ljava/io/DataOutput;)V", "api"})
public interface BinaryAttachmentSerializer<T>
extends AttachmentSerializer {
    public void serialize(T var1, @NotNull DataOutput var2);

    @Nullable
    public T deserialize(@NotNull DataInput var1);
}

