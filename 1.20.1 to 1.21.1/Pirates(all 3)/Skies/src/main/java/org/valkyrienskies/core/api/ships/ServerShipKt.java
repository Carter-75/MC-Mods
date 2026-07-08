/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.KotlinNothingValueException
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.api.ships;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.api.ships.ServerShip;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0003\u001a\"\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\u0087\b\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a&\u0010\u0007\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000H\u0087\b\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"", "T", "Lorg/valkyrienskies/core/api/ships/ServerShip;", "getAttachment", "(Lorg/valkyrienskies/core/api/ships/ServerShip;)Ljava/lang/Object;", "value", "", "saveAttachment", "(Lorg/valkyrienskies/core/api/ships/ServerShip;Ljava/lang/Object;)Ljava/lang/Void;", "api"})
public final class ServerShipKt {
    @Deprecated(message="Since VS 2.5, attachments can only be set on a LoadedServerShip; make sure to import org.valkyrienskies.core.api.attachment.setAttachment and remove old imports on org.valkyrienskies.core.api.ships.saveAttachment", replaceWith=@ReplaceWith(expression="this.setAttachment(value)", imports={"org.valkyrienskies.core.api.attachment.setAttachment"}), level=DeprecationLevel.ERROR)
    public static final /* synthetic */ <T> Void saveAttachment(ServerShip $this$saveAttachment, T value) {
        Intrinsics.checkNotNullParameter((Object)$this$saveAttachment, (String)"<this>");
        boolean $i$f$saveAttachment = false;
        Intrinsics.reifiedOperationMarker((int)4, (String)"T");
        $this$saveAttachment.saveAttachment(Object.class, value);
        throw new KotlinNothingValueException();
    }

    @Deprecated(message="Since VS 2.5, attachments can only be retrieved from a LoadedServerShip; make sure to import org.valkyrienskies.core.api.attachment.getAttachment and remove old imports on org.valkyrienskies.core.api.ships.getAttachment", replaceWith=@ReplaceWith(expression="this.getAttachment<T>()", imports={"org.valkyrienskies.core.api.attachment.getAttachment"}), level=DeprecationLevel.ERROR)
    public static final /* synthetic */ <T> T getAttachment(ServerShip $this$getAttachment) {
        Intrinsics.checkNotNullParameter((Object)$this$getAttachment, (String)"<this>");
        boolean $i$f$getAttachment = false;
        Intrinsics.reifiedOperationMarker((int)4, (String)"T");
        return (T)$this$getAttachment.getAttachment(Object.class);
    }
}

