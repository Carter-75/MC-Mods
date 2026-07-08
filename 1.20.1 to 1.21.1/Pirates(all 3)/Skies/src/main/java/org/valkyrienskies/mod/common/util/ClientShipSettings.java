/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 */
package org.valkyrienskies.mod.common.util;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.mod.common.config.ShipRenderer;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0015J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fH\u00d6\u0001\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fH\u00d6\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0017"}, d2={"Lorg/valkyrienskies/mod/common/util/ClientShipSettings;", "", "Lorg/valkyrienskies/mod/common/config/ShipRenderer;", "component1", "()Lorg/valkyrienskies/mod/common/config/ShipRenderer;", "renderer", "copy", "(Lorg/valkyrienskies/mod/common/config/ShipRenderer;)Lorg/valkyrienskies/mod/common/util/ClientShipSettings;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/valkyrienskies/mod/common/config/ShipRenderer;", "getRenderer", "setRenderer", "(Lorg/valkyrienskies/mod/common/config/ShipRenderer;)V", "<init>", "valkyrienskies-120"})
public final class ClientShipSettings {
    @Nullable
    private ShipRenderer renderer;

    public ClientShipSettings(@Nullable ShipRenderer renderer) {
        this.renderer = renderer;
    }

    public /* synthetic */ ClientShipSettings(ShipRenderer shipRenderer, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            shipRenderer = null;
        }
        this(shipRenderer);
    }

    @Nullable
    public final ShipRenderer getRenderer() {
        return this.renderer;
    }

    public final void setRenderer(@Nullable ShipRenderer shipRenderer) {
        this.renderer = shipRenderer;
    }

    @Nullable
    public final ShipRenderer component1() {
        return this.renderer;
    }

    @NotNull
    public final ClientShipSettings copy(@Nullable ShipRenderer renderer) {
        return new ClientShipSettings(renderer);
    }

    public static /* synthetic */ ClientShipSettings copy$default(ClientShipSettings clientShipSettings, ShipRenderer shipRenderer, int n2, Object object) {
        if ((n2 & 1) != 0) {
            shipRenderer = clientShipSettings.renderer;
        }
        return clientShipSettings.copy(shipRenderer);
    }

    @NotNull
    public String toString() {
        return "ClientShipSettings(renderer=" + this.renderer + ")";
    }

    public int hashCode() {
        return this.renderer == null ? 0 : this.renderer.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClientShipSettings)) {
            return false;
        }
        ClientShipSettings clientShipSettings = (ClientShipSettings)other;
        return this.renderer == clientShipSettings.renderer;
    }

    public ClientShipSettings() {
        this(null, 1, null);
    }
}

