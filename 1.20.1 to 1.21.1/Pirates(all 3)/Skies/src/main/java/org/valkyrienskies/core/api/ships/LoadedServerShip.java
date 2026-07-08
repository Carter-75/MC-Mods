/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.api.ships;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.api.VsBeta;
import org.valkyrienskies.core.api.attachment.AttachmentHolder;
import org.valkyrienskies.core.api.ships.DragController;
import org.valkyrienskies.core.api.ships.LoadedShip;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.api.ships.WingManager;
import org.valkyrienskies.core.api.util.GameTickOnly;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J)\u0010\b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0005*\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0017\u00a2\u0006\u0004\b\b\u0010\tJ/\u0010\u000b\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\b\u0010\n\u001a\u0004\u0018\u00018\u0000H\u0017\u00a2\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\r8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00118&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0017\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/ships/LoadedServerShip;", "Lorg/valkyrienskies/core/api/attachment/AttachmentHolder;", "Lorg/valkyrienskies/core/api/ships/LoadedShip;", "Lorg/valkyrienskies/core/api/ships/ServerShip;", "", "T", "Ljava/lang/Class;", "clazz", "getAttachment", "(Ljava/lang/Class;)Ljava/lang/Object;", "value", "setAttachment", "(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;", "Lorg/valkyrienskies/core/api/ships/DragController;", "getDragController", "()Lorg/valkyrienskies/core/api/ships/DragController;", "dragController", "Lorg/valkyrienskies/core/api/ships/WingManager;", "getWingManager", "()Lorg/valkyrienskies/core/api/ships/WingManager;", "getWingManager$annotations", "()V", "wingManager", "api"})
@GameTickOnly
public interface LoadedServerShip
extends AttachmentHolder,
LoadedShip,
ServerShip {
    @Nullable
    public WingManager getWingManager();

    @VsBeta
    public static /* synthetic */ void getWingManager$annotations() {
    }

    @Nullable
    public DragController getDragController();

    @Deprecated(message="Use the AttachmentHolder methods setAttachment/removeAttachment", replaceWith=@ReplaceWith(expression="setAttachment(value)", imports={}))
    @Nullable
    default public <T> Object setAttachment(@NotNull Class<T> clazz, @Nullable T value) {
        T t;
        Intrinsics.checkNotNullParameter(clazz, (String)"clazz");
        if (value == null) {
            t = this.removeAttachment(clazz);
        } else {
            Intrinsics.checkNotNull((Object)this, (String)"null cannot be cast to non-null type org.valkyrienskies.core.api.attachment.AttachmentHolder");
            t = ((AttachmentHolder)this).setAttachment(value);
        }
        return t;
    }

    @Override
    @VsBeta
    @Nullable
    default public <T> T getAttachment(@NotNull Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, (String)"clazz");
        Intrinsics.checkNotNull((Object)this, (String)"null cannot be cast to non-null type org.valkyrienskies.core.api.attachment.AttachmentHolder");
        return ((AttachmentHolder)this).getAttachment(clazz);
    }
}

