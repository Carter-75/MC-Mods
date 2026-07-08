/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.api.attachment;

import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.api.VsBeta;
import org.valkyrienskies.core.api.attachment.AttachmentHolder;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\"\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\u0087\b\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a.\u0010\u0007\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0087\b\u00a2\u0006\u0004\b\u0007\u0010\b\u001a\"\u0010\t\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\u0087\b\u00a2\u0006\u0004\b\t\u0010\u0004\u00a8\u0006\n"}, d2={"", "T", "Lorg/valkyrienskies/core/api/attachment/AttachmentHolder;", "getAttachment", "(Lorg/valkyrienskies/core/api/attachment/AttachmentHolder;)Ljava/lang/Object;", "Ljava/util/function/Supplier;", "supplier", "getOrPutAttachment", "(Lorg/valkyrienskies/core/api/attachment/AttachmentHolder;Ljava/util/function/Supplier;)Ljava/lang/Object;", "removeAttachment", "api"})
public final class AttachmentHolderKt {
    @VsBeta
    public static final /* synthetic */ <T> T getAttachment(AttachmentHolder $this$getAttachment) {
        Intrinsics.checkNotNullParameter((Object)$this$getAttachment, (String)"<this>");
        boolean $i$f$getAttachment = false;
        Intrinsics.reifiedOperationMarker((int)4, (String)"T");
        return (T)$this$getAttachment.getAttachment(Object.class);
    }

    @VsBeta
    public static final /* synthetic */ <T> T getOrPutAttachment(AttachmentHolder $this$getOrPutAttachment, Supplier<T> supplier) {
        Intrinsics.checkNotNullParameter((Object)$this$getOrPutAttachment, (String)"<this>");
        Intrinsics.checkNotNullParameter(supplier, (String)"supplier");
        boolean $i$f$getOrPutAttachment = false;
        Intrinsics.reifiedOperationMarker((int)4, (String)"T");
        return (T)$this$getOrPutAttachment.getOrPutAttachment(Object.class, supplier);
    }

    @VsBeta
    public static final /* synthetic */ <T> T removeAttachment(AttachmentHolder $this$removeAttachment) {
        Intrinsics.checkNotNullParameter((Object)$this$removeAttachment, (String)"<this>");
        boolean $i$f$removeAttachment = false;
        Intrinsics.reifiedOperationMarker((int)4, (String)"T");
        return (T)$this$removeAttachment.removeAttachment(Object.class);
    }
}

