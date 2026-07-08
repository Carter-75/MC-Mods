/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 */
package org.valkyrienskies.core.api.ships;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.valkyrienskies.core.api.attachment.AttachmentHolder;
import org.valkyrienskies.core.api.ships.LoadedServerShip;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a(\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00018\u0000H\u0087\b\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2={"T", "Lorg/valkyrienskies/core/api/ships/LoadedServerShip;", "value", "setAttachment", "(Lorg/valkyrienskies/core/api/ships/LoadedServerShip;Ljava/lang/Object;)Ljava/lang/Object;", "api"})
@SourceDebugExtension(value={"SMAP\nLoadedServerShip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LoadedServerShip.kt\norg/valkyrienskies/core/api/ships/LoadedServerShipKt\n+ 2 AttachmentHolder.kt\norg/valkyrienskies/core/api/attachment/AttachmentHolderKt\n*L\n1#1,47:1\n80#2:48\n*S KotlinDebug\n*F\n+ 1 LoadedServerShip.kt\norg/valkyrienskies/core/api/ships/LoadedServerShipKt\n*L\n46#1:48\n*E\n"})
public final class LoadedServerShipKt {
    @Deprecated(message="Use the version from the attachments package", replaceWith=@ReplaceWith(expression="setAttachment(value)", imports={"org.valkyrienskies.core.api.attachment.setAttachment"}))
    public static final /* synthetic */ <T> T setAttachment(LoadedServerShip $this$setAttachment, T value) {
        Object object;
        Intrinsics.checkNotNullParameter((Object)$this$setAttachment, (String)"<this>");
        boolean $i$f$setAttachment = false;
        if (value == null) {
            AttachmentHolder $this$removeAttachment$iv = $this$setAttachment;
            boolean $i$f$removeAttachment = false;
            Intrinsics.reifiedOperationMarker((int)4, (String)"T");
            object = $this$removeAttachment$iv.removeAttachment(Object.class);
        } else {
            object = ((AttachmentHolder)$this$setAttachment).setAttachment(value);
        }
        return object;
    }
}

