/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.api.bodies.properties.BodyTransform;
import org.valkyrienskies.core.api.ships.ClientShipTransformProvider;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.impl.game.ships.ShipTransformImpl;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Eg
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ'\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0007\u0010\t"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Eg;", "Lorg/valkyrienskies/core/api/ships/ClientShipTransformProvider;", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "p0", "p1", "", "p2", "a", "(Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;D)Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "(Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;)Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "<init>", "()V"})
public final class eg_0
implements ClientShipTransformProvider {
    public static final eg_0 INSTANCE = new eg_0();

    private eg_0() {
    }

    public static ShipTransform a(ShipTransform shipTransform, ShipTransform shipTransform2, ShipTransform shipTransform3) {
        Intrinsics.checkNotNullParameter((Object)shipTransform, (String)"");
        Intrinsics.checkNotNullParameter((Object)shipTransform2, (String)"");
        Intrinsics.checkNotNullParameter((Object)shipTransform3, (String)"");
        return ShipTransformImpl.Companion.createFromSlerp(shipTransform2, shipTransform3, 0.7);
    }

    public static ShipTransform a(ShipTransform shipTransform, ShipTransform shipTransform2, double d2) {
        Intrinsics.checkNotNullParameter((Object)shipTransform, (String)"");
        Intrinsics.checkNotNullParameter((Object)shipTransform2, (String)"");
        return ShipTransformImpl.Companion.createFromSlerp(shipTransform, shipTransform2, d2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final /* synthetic */ BodyTransform provideNextTransform(ShipTransform prevShipTransform, ShipTransform shipTransform, ShipTransform latestNetworkTransform) {
        void var3_3;
        void var2_2;
        return eg_0.a(prevShipTransform, (ShipTransform)var2_2, (ShipTransform)var3_3);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final /* synthetic */ BodyTransform provideNextRenderTransform(ShipTransform prevShipTransform, ShipTransform shipTransform, double partialTick) {
        void var3_3;
        void var2_2;
        return eg_0.a(prevShipTransform, (ShipTransform)var2_2, (double)var3_3);
    }
}

