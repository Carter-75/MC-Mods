/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  com.fasterxml.jackson.databind.exc.MismatchedInputException
 *  com.fasterxml.jackson.module.kotlin.ExtensionsKt
 *  kotlin.Metadata
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package g_mungus.vlib.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.module.kotlin.ExtensionsKt;
import java.io.Closeable;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB!\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u00c6\u0001\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014H\u00d6\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0019\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\b\u00a8\u0006\u001f"}, d2={"Lg_mungus/vlib/data/DimensionSettings;", "", "", "component1", "()D", "component2", "", "component3", "()Z", "shipScale", "gravity", "shouldApplyGravity", "copy", "(DDZ)Lg_mungus/vlib/data/DimensionSettings;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "D", "getShipScale", "getGravity", "Z", "getShouldApplyGravity", "<init>", "(DDZ)V", "Companion", "vlib"})
public final class DimensionSettings {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final double shipScale;
    private final double gravity;
    private final boolean shouldApplyGravity;
    @NotNull
    private static final ObjectMapper objectMapper = ExtensionsKt.jacksonObjectMapper();

    public DimensionSettings(double shipScale, double gravity, boolean shouldApplyGravity) {
        this.shipScale = shipScale;
        this.gravity = gravity;
        this.shouldApplyGravity = shouldApplyGravity;
    }

    public /* synthetic */ DimensionSettings(double d, double d2, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            bl = true;
        }
        this(d, d2, bl);
    }

    public final double getShipScale() {
        return this.shipScale;
    }

    public final double getGravity() {
        return this.gravity;
    }

    public final boolean getShouldApplyGravity() {
        return this.shouldApplyGravity;
    }

    public final double component1() {
        return this.shipScale;
    }

    public final double component2() {
        return this.gravity;
    }

    public final boolean component3() {
        return this.shouldApplyGravity;
    }

    @NotNull
    public final DimensionSettings copy(double shipScale, double gravity, boolean shouldApplyGravity) {
        return new DimensionSettings(shipScale, gravity, shouldApplyGravity);
    }

    public static /* synthetic */ DimensionSettings copy$default(DimensionSettings dimensionSettings, double d, double d2, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            d = dimensionSettings.shipScale;
        }
        if ((n & 2) != 0) {
            d2 = dimensionSettings.gravity;
        }
        if ((n & 4) != 0) {
            bl = dimensionSettings.shouldApplyGravity;
        }
        return dimensionSettings.copy(d, d2, bl);
    }

    @NotNull
    public String toString() {
        return "DimensionSettings(shipScale=" + this.shipScale + ", gravity=" + this.gravity + ", shouldApplyGravity=" + this.shouldApplyGravity + ")";
    }

    public int hashCode() {
        int result = Double.hashCode(this.shipScale);
        result = result * 31 + Double.hashCode(this.gravity);
        result = result * 31 + Boolean.hashCode(this.shouldApplyGravity);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DimensionSettings)) {
            return false;
        }
        DimensionSettings dimensionSettings = (DimensionSettings)other;
        if (Double.compare(this.shipScale, dimensionSettings.shipScale) != 0) {
            return false;
        }
        if (Double.compare(this.gravity, dimensionSettings.gravity) != 0) {
            return false;
        }
        return this.shouldApplyGravity == dimensionSettings.shouldApplyGravity;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2={"Lg_mungus/vlib/data/DimensionSettings$Companion;", "", "Ljava/io/InputStream;", "inputStream", "Lg_mungus/vlib/data/DimensionSettings;", "readJson", "(Ljava/io/InputStream;)Lg_mungus/vlib/data/DimensionSettings;", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "objectMapper", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "<init>", "()V", "vlib"})
    public static final class Companion {
        private Companion() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Nullable
        public final DimensionSettings readJson(@NotNull InputStream inputStream) {
            DimensionSettings dimensionSettings;
            Intrinsics.checkNotNullParameter((Object)inputStream, (String)"inputStream");
            Closeable closeable = inputStream;
            Throwable throwable = null;
            try {
                DimensionSettings dimensionSettings2;
                InputStream it = (InputStream)closeable;
                boolean bl = false;
                try {
                    dimensionSettings2 = (DimensionSettings)objectMapper.readValue(it, DimensionSettings.class);
                }
                catch (MismatchedInputException e) {
                    dimensionSettings2 = null;
                }
                dimensionSettings = dimensionSettings2;
            }
            catch (Throwable throwable2) {
                throwable = throwable2;
                throw throwable2;
            }
            finally {
                CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
            }
            return dimensionSettings;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

