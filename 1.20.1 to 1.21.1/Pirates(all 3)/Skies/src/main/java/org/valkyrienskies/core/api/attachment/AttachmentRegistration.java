/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.api.attachment;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.api.VsBeta;
import org.valkyrienskies.core.api.attachment.AttachmentSerializer;

@VsBeta
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u000fR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0010\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/attachment/AttachmentRegistration;", "T", "", "Ljava/lang/Class;", "getAttachmentClass", "()Ljava/lang/Class;", "attachmentClass", "", "getKey", "()Ljava/lang/String;", "key", "Lorg/valkyrienskies/core/api/attachment/AttachmentSerializer;", "getSerializer", "()Lorg/valkyrienskies/core/api/attachment/AttachmentSerializer;", "serializer", "Builder", "api"})
public interface AttachmentRegistration<T> {
    @NotNull
    public Class<T> getAttachmentClass();

    @NotNull
    public String getKey();

    @NotNull
    public AttachmentSerializer getSerializer();

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003H&\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\n\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000H&\u00a2\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000H&\u00a2\u0006\u0004\b\u000e\u0010\rJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000H&\u00a2\u0006\u0004\b\u000f\u0010\rJ?\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0002\u0010\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00020\u00112\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u0013H&\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u00118&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0007\u001a\u00020\u00068&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\n\u001a\u00020\t8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\"\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/attachment/AttachmentRegistration$Builder;", "T", "", "Lorg/valkyrienskies/core/api/attachment/AttachmentRegistration;", "build", "()Lorg/valkyrienskies/core/api/attachment/AttachmentRegistration;", "", "key", "(Ljava/lang/String;)Lorg/valkyrienskies/core/api/attachment/AttachmentRegistration$Builder;", "Lorg/valkyrienskies/core/api/attachment/AttachmentSerializer;", "serializer", "(Lorg/valkyrienskies/core/api/attachment/AttachmentSerializer;)Lorg/valkyrienskies/core/api/attachment/AttachmentRegistration$Builder;", "useJacksonSerializer", "()Lorg/valkyrienskies/core/api/attachment/AttachmentRegistration$Builder;", "useLegacySerializer", "useTransientSerializer", "NEW", "Ljava/lang/Class;", "newAttachmentClass", "Lkotlin/Function1;", "updater", "useUpdater", "(Ljava/lang/Class;Lkotlin/jvm/functions/Function1;)Lorg/valkyrienskies/core/api/attachment/AttachmentRegistration$Builder;", "getAttachmentClass", "()Ljava/lang/Class;", "attachmentClass", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getSerializer", "()Lorg/valkyrienskies/core/api/attachment/AttachmentSerializer;", "setSerializer", "(Lorg/valkyrienskies/core/api/attachment/AttachmentSerializer;)V", "api"})
    public static interface Builder<T> {
        @NotNull
        public Class<T> getAttachmentClass();

        @NotNull
        public String getKey();

        public void setKey(@NotNull String var1);

        @NotNull
        public AttachmentSerializer getSerializer();

        public void setSerializer(@NotNull AttachmentSerializer var1);

        @NotNull
        public Builder<T> useJacksonSerializer();

        @NotNull
        public Builder<T> useLegacySerializer();

        @NotNull
        public Builder<T> useTransientSerializer();

        @NotNull
        default public Builder<T> serializer(@NotNull AttachmentSerializer serializer) {
            Builder builder;
            Intrinsics.checkNotNullParameter((Object)serializer, (String)"serializer");
            Builder it = builder = this;
            boolean bl = false;
            this.setSerializer(serializer);
            return builder;
        }

        @NotNull
        default public Builder<T> key(@NotNull String key) {
            Builder builder;
            Intrinsics.checkNotNullParameter((Object)key, (String)"key");
            Builder it = builder = this;
            boolean bl = false;
            this.setKey(key);
            return builder;
        }

        @NotNull
        public <NEW> Builder<T> useUpdater(@NotNull Class<NEW> var1, @NotNull Function1<? super T, ? extends NEW> var2);

        @NotNull
        public AttachmentRegistration<T> build();
    }
}

