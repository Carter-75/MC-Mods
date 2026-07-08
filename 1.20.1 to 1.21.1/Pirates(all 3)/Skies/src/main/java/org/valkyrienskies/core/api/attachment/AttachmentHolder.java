/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.api.attachment;

import java.util.function.Supplier;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.api.VsBeta;

@VsBeta
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0015\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002H&\u00a2\u0006\u0004\b\u0003\u0010\u0004J)\u0010\b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0005*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H&\u00a2\u0006\u0004\b\b\u0010\tJ5\u0010\f\u001a\u00028\u0000\"\b\b\u0000\u0010\u0005*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH&\u00a2\u0006\u0004\b\f\u0010\rJ)\u0010\u000e\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0005*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H&\u00a2\u0006\u0004\b\u000e\u0010\tJ#\u0010\u0010\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0005*\u00020\u00012\u0006\u0010\u000f\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0010\u0010\u0011\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0012\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/attachment/AttachmentHolder;", "", "", "getAllAttachments", "()Ljava/lang/Iterable;", "T", "Ljava/lang/Class;", "clazz", "getAttachment", "(Ljava/lang/Class;)Ljava/lang/Object;", "Ljava/util/function/Supplier;", "supplier", "getOrPutAttachment", "(Ljava/lang/Class;Ljava/util/function/Supplier;)Ljava/lang/Object;", "removeAttachment", "value", "setAttachment", "(Ljava/lang/Object;)Ljava/lang/Object;", "api"})
public interface AttachmentHolder {
    @Nullable
    public <T> T getAttachment(@NotNull Class<T> var1);

    @NotNull
    public <T> T getOrPutAttachment(@NotNull Class<T> var1, @NotNull Supplier<T> var2);

    @Nullable
    public <T> T setAttachment(@NotNull T var1);

    @Nullable
    public <T> T removeAttachment(@NotNull Class<T> var1);

    @NotNull
    public Iterable<Object> getAllAttachments();
}

