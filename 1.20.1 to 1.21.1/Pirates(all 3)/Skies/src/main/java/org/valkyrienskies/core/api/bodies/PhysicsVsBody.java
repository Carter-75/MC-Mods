/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.api.bodies;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.bodies.ServerBaseVsBody;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\bf\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u0007\u0010\bJ'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u0007\u0010\nJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\u000bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\fJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\r\u0010\bJ'\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\r\u0010\nJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\r\u0010\u000bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\r\u0010\fJ\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u000e\u0010\bJ'\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u000e\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u000e\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u0010\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0010\u0010\u000bJ\u001f\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u0011\u0010\bJ'\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u0011\u0010\nJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0011\u0010\u000bJ\u001f\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0011\u0010\fJ\u001f\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u0012\u0010\bJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u000bJ\u001f\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u0013\u0010\bJ\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u000bJ\u001f\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u0014\u0010\bJ\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u000b\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0016\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/bodies/PhysicsVsBody;", "Lorg/valkyrienskies/core/api/bodies/ServerBaseVsBody;", "", "reason", "Lorg/joml/Vector3dc;", "force", "", "applyForceInLocal", "(Ljava/lang/String;Lorg/joml/Vector3dc;)V", "pos", "(Ljava/lang/String;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)V", "(Lorg/joml/Vector3dc;)V", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)V", "applyForceInWorld", "applyInvariantForceInLocal", "torque", "applyInvariantTorqueInLocal", "applyRotatingForceInWorld", "applyRotatingTorqueInWorld", "applyTorqueInLocal", "applyTorqueInWorld", "Companion", "api"})
public interface PhysicsVsBody
extends ServerBaseVsBody {
    @NotNull
    public static final Companion Companion = org.valkyrienskies.core.api.bodies.PhysicsVsBody$Companion.$$INSTANCE;
    @NotNull
    public static final String REASON_UNKNOWN = "unspecified";

    default public void applyForceInWorld(@NotNull Vector3dc force) {
        Intrinsics.checkNotNullParameter((Object)force, (String)"force");
        this.applyForceInWorld(REASON_UNKNOWN, force);
    }

    default public void applyForceInLocal(@NotNull Vector3dc force) {
        Intrinsics.checkNotNullParameter((Object)force, (String)"force");
        this.applyForceInLocal(REASON_UNKNOWN, force);
    }

    default public void applyForceInWorld(@NotNull Vector3dc force, @NotNull Vector3dc pos) {
        Intrinsics.checkNotNullParameter((Object)force, (String)"force");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        this.applyForceInWorld(REASON_UNKNOWN, force);
    }

    default public void applyForceInLocal(@NotNull Vector3dc force, @NotNull Vector3dc pos) {
        Intrinsics.checkNotNullParameter((Object)force, (String)"force");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        this.applyForceInLocal(REASON_UNKNOWN, force);
    }

    default public void applyRotatingForceInWorld(@NotNull Vector3dc force) {
        Intrinsics.checkNotNullParameter((Object)force, (String)"force");
        this.applyRotatingForceInWorld(REASON_UNKNOWN, force);
    }

    default public void applyInvariantForceInLocal(@NotNull Vector3dc force) {
        Intrinsics.checkNotNullParameter((Object)force, (String)"force");
        this.applyInvariantForceInLocal(REASON_UNKNOWN, force);
    }

    default public void applyRotatingForceInWorld(@NotNull Vector3dc force, @NotNull Vector3dc pos) {
        Intrinsics.checkNotNullParameter((Object)force, (String)"force");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        this.applyRotatingForceInWorld(REASON_UNKNOWN, force);
    }

    default public void applyInvariantForceInLocal(@NotNull Vector3dc force, @NotNull Vector3dc pos) {
        Intrinsics.checkNotNullParameter((Object)force, (String)"force");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        this.applyInvariantForceInLocal(REASON_UNKNOWN, force);
    }

    default public void applyTorqueInWorld(@NotNull Vector3dc torque) {
        Intrinsics.checkNotNullParameter((Object)torque, (String)"torque");
        this.applyTorqueInWorld(REASON_UNKNOWN, torque);
    }

    default public void applyTorqueInLocal(@NotNull Vector3dc torque) {
        Intrinsics.checkNotNullParameter((Object)torque, (String)"torque");
        this.applyTorqueInLocal(REASON_UNKNOWN, torque);
    }

    default public void applyRotatingTorqueInWorld(@NotNull Vector3dc torque) {
        Intrinsics.checkNotNullParameter((Object)torque, (String)"torque");
        this.applyRotatingTorqueInWorld(REASON_UNKNOWN, torque);
    }

    default public void applyInvariantTorqueInLocal(@NotNull Vector3dc torque) {
        Intrinsics.checkNotNullParameter((Object)torque, (String)"torque");
        this.applyInvariantTorqueInLocal(REASON_UNKNOWN, torque);
    }

    public void applyForceInWorld(@NotNull String var1, @NotNull Vector3dc var2);

    public void applyForceInLocal(@NotNull String var1, @NotNull Vector3dc var2);

    public void applyForceInWorld(@NotNull String var1, @NotNull Vector3dc var2, @NotNull Vector3dc var3);

    public void applyForceInLocal(@NotNull String var1, @NotNull Vector3dc var2, @NotNull Vector3dc var3);

    public void applyRotatingForceInWorld(@NotNull String var1, @NotNull Vector3dc var2);

    public void applyInvariantForceInLocal(@NotNull String var1, @NotNull Vector3dc var2);

    public void applyRotatingForceInWorld(@NotNull String var1, @NotNull Vector3dc var2, @NotNull Vector3dc var3);

    public void applyInvariantForceInLocal(@NotNull String var1, @NotNull Vector3dc var2, @NotNull Vector3dc var3);

    public void applyTorqueInWorld(@NotNull String var1, @NotNull Vector3dc var2);

    public void applyTorqueInLocal(@NotNull String var1, @NotNull Vector3dc var2);

    public void applyRotatingTorqueInWorld(@NotNull String var1, @NotNull Vector3dc var2);

    public void applyInvariantTorqueInLocal(@NotNull String var1, @NotNull Vector3dc var2);

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2={"Lorg/valkyrienskies/core/api/bodies/PhysicsVsBody$Companion;", "", "", "REASON_UNKNOWN", "Ljava/lang/String;", "<init>", "()V", "api"})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;
        @NotNull
        public static final String REASON_UNKNOWN = "unspecified";

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }
}

