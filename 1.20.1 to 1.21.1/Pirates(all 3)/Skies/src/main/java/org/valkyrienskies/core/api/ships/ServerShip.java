/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.NotImplementedError
 *  kotlin.ReplaceWith
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.api.ships;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.api.bodies.properties.BodyTransform;
import org.valkyrienskies.core.api.ships.ServerShipTransformProvider;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.api.ships.properties.ShipInertiaData;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0017\u00a2\u0006\u0004\b\u0006\u0010\u0007J-\u0010\n\u001a\u00020\t\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0010\b\u001a\u0004\u0018\u00018\u0000H\u0017\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0016\u001a\u00020\u00158&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u001a8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010%\u001a\u0004\u0018\u00010 8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006&\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/ships/ServerShip;", "Lorg/valkyrienskies/core/api/ships/Ship;", "", "T", "Ljava/lang/Class;", "clazz", "getAttachment", "(Ljava/lang/Class;)Ljava/lang/Object;", "value", "", "saveAttachment", "(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Void;", "Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;", "transform", "", "unsafeSetTransform", "(Lorg/valkyrienskies/core/api/bodies/properties/BodyTransform;)V", "Lorg/valkyrienskies/core/api/ships/properties/ShipInertiaData;", "getInertiaData", "()Lorg/valkyrienskies/core/api/ships/properties/ShipInertiaData;", "inertiaData", "", "isStatic", "()Z", "setStatic", "(Z)V", "", "getSlug", "()Ljava/lang/String;", "setSlug", "(Ljava/lang/String;)V", "slug", "Lorg/valkyrienskies/core/api/ships/ServerShipTransformProvider;", "getTransformProvider", "()Lorg/valkyrienskies/core/api/ships/ServerShipTransformProvider;", "setTransformProvider", "(Lorg/valkyrienskies/core/api/ships/ServerShipTransformProvider;)V", "transformProvider", "api"})
public interface ServerShip
extends Ship {
    @Override
    @Nullable
    public String getSlug();

    public void setSlug(@Nullable String var1);

    public boolean isStatic();

    public void setStatic(boolean var1);

    @NotNull
    public ShipInertiaData getInertiaData();

    @Nullable
    public ServerShipTransformProvider getTransformProvider();

    public void setTransformProvider(@Nullable ServerShipTransformProvider var1);

    @ApiStatus.Experimental
    public void unsafeSetTransform(@NotNull BodyTransform var1);

    @Deprecated(message="Since VS 2.5, attachments can only be saved to a LoadedServerShip", replaceWith=@ReplaceWith(expression="this.setAttachment(clazz, value)", imports={}), level=DeprecationLevel.ERROR)
    default public /* synthetic */ Void saveAttachment(Class clazz, Object value) {
        Intrinsics.checkNotNullParameter((Object)clazz, (String)"clazz");
        String string = "Tried to save an attachment on an unloaded ship. Since VS 2.5, attachments can only be saved using LoadedServerShip";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }

    @Deprecated(message="Since VS 2.5, attachments can only be retrieved from a LoadedServerShip", replaceWith=@ReplaceWith(expression="this.getAttachment(clazz)", imports={}), level=DeprecationLevel.ERROR)
    default public /* synthetic */ Object getAttachment(Class clazz) {
        Intrinsics.checkNotNullParameter((Object)clazz, (String)"clazz");
        String string = "Tried to retrieve an attachment on an unloaded ship. Since VS 2.5, attachments can only be saved using LoadedServerShip";
        throw new NotImplementedError("An operation is not implemented: " + string);
    }
}

